package com.reddit.frontpage.ui.detail.web;

import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;
import timber.log.Timber;

final /* synthetic */ class WebBrowserFragment$$Lambda$2 implements DownloadListener {
    private final WebBrowserFragment f21204a;

    WebBrowserFragment$$Lambda$2(WebBrowserFragment webBrowserFragment) {
        this.f21204a = webBrowserFragment;
    }

    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        str2 = this.f21204a;
        Timber.b("This is a download! %s", new Object[]{str});
        str2.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }
}
