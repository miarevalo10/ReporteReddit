package com.reddit.frontpage.ui.detail.web;

import android.os.Bundle;
import android.webkit.WebViewClient;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/reddit/frontpage/ui/detail/web/ModMailFragment;", "Lcom/reddit/frontpage/ui/detail/web/WebBrowserFragment;", "()V", "reloaded", "", "createWebViewClient", "Landroid/webkit/WebViewClient;", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ModMailFragment.kt */
public final class ModMailFragment extends WebBrowserFragment {
    public static final Companion f37247a = new Companion();
    private boolean f37248g;
    private HashMap f37249h;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/reddit/frontpage/ui/detail/web/ModMailFragment$Companion;", "", "()V", "newInstance", "Lcom/reddit/frontpage/ui/detail/web/WebBrowserFragment;", "initialUrl", "", "titleOverride", "color", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ModMailFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public static WebBrowserFragment m23370a(String str, String str2, int i) {
            Intrinsics.m26847b(str, "initialUrl");
            Bundle bundle = new Bundle();
            bundle.putString("com.reddit.args.initial_url", str);
            bundle.putString("com.reddit.arg.title_override", str2);
            bundle.putInt("com.reddit.arg.color", i);
            str = new ModMailFragment();
            str.setArguments(bundle);
            return (WebBrowserFragment) str;
        }
    }

    protected final WebViewClient mo7000b() {
        return new ModMailFragment$createWebViewClient$1(this);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        if (this.f37249h != null) {
            this.f37249h.clear();
        }
    }
}
