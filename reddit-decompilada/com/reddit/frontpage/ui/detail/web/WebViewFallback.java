package com.reddit.frontpage.ui.detail.web;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.commons.vendor.CustomTabsActivityHelper.CustomTabFallback;
import com.reddit.frontpage.util.IntentUtil;
import com.reddit.frontpage.util.Util;

public class WebViewFallback implements CustomTabFallback {
    Uri f28987a;
    String f28988b;
    Integer f28989c;

    public WebViewFallback(Link link) {
        this.f28987a = Uri.parse(link.getUrl());
        if (link.getSubredditDetail() != null) {
            link = link.getSubredditDetail().key_color;
        } else {
            link = null;
        }
        this.f28988b = link;
    }

    public WebViewFallback(Uri uri, Integer num) {
        this.f28987a = uri;
        this.f28989c = num;
    }

    public final void mo4976a(Activity activity, Uri uri) {
        int intValue;
        if (this.f28989c != null) {
            intValue = this.f28989c.intValue();
        } else {
            intValue = Util.m23951a((Context) activity, this.f28988b);
        }
        activity.startActivity(IntentUtil.m23747a((Context) activity, uri.toString(), intValue));
        activity.overridePendingTransition(0, 0);
    }
}
