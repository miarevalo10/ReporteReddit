package com.reddit.frontpage.util;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.frontpage.commons.analytics.AppAnalytics.ShareEventBuilder;

final /* synthetic */ class ShareRequestUtil$$Lambda$0 implements OnClickListener {
    private final Context f21790a;
    private final String f21791b;
    private final ShareEventBuilder f21792c;

    ShareRequestUtil$$Lambda$0(Context context, String str, ShareEventBuilder shareEventBuilder) {
        this.f21790a = context;
        this.f21791b = str;
        this.f21792c = shareEventBuilder;
    }

    public final void onClick(View view) {
        ShareRequestUtil.m23900a(this.f21790a, this.f21791b, this.f21792c);
    }
}
