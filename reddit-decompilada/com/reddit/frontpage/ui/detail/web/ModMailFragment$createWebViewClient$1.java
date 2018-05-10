package com.reddit.frontpage.ui.detail.web;

import android.os.Build.VERSION;
import android.util.Base64;
import android.webkit.WebView;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import net.hockeyapp.android.UpdateFragment;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00060\u0001R\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J(\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016¨\u0006\u000f"}, d2 = {"com/reddit/frontpage/ui/detail/web/ModMailFragment$createWebViewClient$1", "Lcom/reddit/frontpage/ui/detail/web/WebBrowserFragment$DefaultWebViewClient;", "Lcom/reddit/frontpage/ui/detail/web/WebBrowserFragment;", "(Lcom/reddit/frontpage/ui/detail/web/ModMailFragment;)V", "onPageFinished", "", "view", "Landroid/webkit/WebView;", "url", "", "onReceivedError", "errorCode", "", "description", "failingUrl", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ModMailFragment.kt */
public final class ModMailFragment$createWebViewClient$1 extends DefaultWebViewClient {
    final /* synthetic */ ModMailFragment f28985a;

    ModMailFragment$createWebViewClient$1(ModMailFragment modMailFragment) {
        this.f28985a = modMailFragment;
        super(modMailFragment);
    }

    public final void onPageFinished(WebView webView, String str) {
        Intrinsics.m26847b(webView, "view");
        Intrinsics.m26847b(str, UpdateFragment.FRAGMENT_URL);
        if (!this.f28985a.f37248g) {
            super.onPageFinished(webView, str);
            Object b = SessionManager.b();
            Intrinsics.m26843a(b, "SessionManager.getInstance()");
            b = b.c();
            StringBuilder stringBuilder = new StringBuilder("{\"__type\": \"Session\", \"accessToken\": \"");
            Intrinsics.m26843a(b, Session.TYPE_SESSION);
            stringBuilder.append(b.b());
            stringBuilder.append("\", \"expires\": ");
            stringBuilder.append(b.c() * 1000);
            stringBuilder.append(", \"refreshToken\": \"55640437-iPasdgasdg--asdgjhasdg\", \"scope\": \"*\", \"tokenType\": \"bearer\"}");
            str = stringBuilder.toString();
            Charset charset = Charsets.f26455a;
            if (str == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            b = str.getBytes(charset);
            Intrinsics.m26843a(b, "(this as java.lang.String).getBytes(charset)");
            str = Base64.encodeToString(b, 0);
            stringBuilder = new StringBuilder("document.cookie = \"token=");
            stringBuilder.append(str);
            stringBuilder.append('\"');
            str = StringsKt__StringsJVMKt.m41942a(stringBuilder.toString(), "\n", "");
            if (VERSION.SDK_INT >= 19) {
                webView.evaluateJavascript(str, ModMailFragment$createWebViewClient$1$onPageFinished$1.f21201a);
            } else {
                stringBuilder = new StringBuilder("javascript:");
                stringBuilder.append(str);
                webView.loadUrl(stringBuilder.toString(), null);
            }
            webView.reload();
            this.f28985a.f37248g = true;
        }
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        Intrinsics.m26847b(webView, "view");
        Intrinsics.m26847b(str, "description");
        Intrinsics.m26847b(str2, "failingUrl");
        super.onReceivedError(webView, i, str, str2);
        Timber.e("error %d: %s", new Object[]{Integer.valueOf(i), str});
    }
}
