package com.reddit.frontpage.ui.alert;

import android.content.Context;
import android.support.customtabs.CustomTabsIntent.Builder;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.commons.vendor.CustomTabsActivityHelper;
import com.reddit.frontpage.commons.vendor.CustomTabsActivityHelper.Companion;
import com.reddit.frontpage.commons.vendor.CustomTabsActivityHelper.CustomTabFallback;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.ui.detail.web.WebViewFallback;
import com.reddit.frontpage.util.kotlin.ContextsKt;
import com.reddit.frontpage.widgets.span.UrlToNativeWebViewSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.hockeyapp.android.UpdateFragment;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/reddit/frontpage/ui/alert/RedditAlertDialog$Companion$displayTable$1", "Landroid/webkit/WebViewClient;", "(Landroid/content/Context;)V", "shouldOverrideUrlLoading", "", "view", "Landroid/webkit/WebView;", "url", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditAlertDialog.kt */
public final class RedditAlertDialog$Companion$displayTable$1 extends WebViewClient {
    final /* synthetic */ Context f21098a;

    RedditAlertDialog$Companion$displayTable$1(Context context) {
        this.f21098a = context;
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Intrinsics.m26847b(webView, "view");
        Intrinsics.m26847b(str, UpdateFragment.FRAGMENT_URL);
        webView = ResourcesUtil.m22740i(this.f21098a, C1761R.attr.rdt_active_color);
        Object a = UrlToNativeWebViewSpan.m24227a(str);
        Object a2 = new Builder().a(webView).a();
        str = CustomTabsActivityHelper.f20095a;
        Object c = ContextsKt.m24079c(this.f21098a);
        Intrinsics.m26843a(c, "context.toActivity()");
        Intrinsics.m26843a(a2, "customTabsIntent");
        Intrinsics.m26843a(a, "properUri");
        Companion.m21967a(c, a2, a, null, null, (CustomTabFallback) new WebViewFallback(a, Integer.valueOf(webView)));
        return true;
    }
}
