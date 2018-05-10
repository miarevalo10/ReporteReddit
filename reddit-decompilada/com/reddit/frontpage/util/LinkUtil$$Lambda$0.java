package com.reddit.frontpage.util;

import android.content.Context;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.widgets.LinkFooterView.OnShareListener;

final /* synthetic */ class LinkUtil$$Lambda$0 implements OnShareListener {
    private final Context f29382a;

    LinkUtil$$Lambda$0(Context context) {
        this.f29382a = context;
    }

    public final void mo4945a(String str, Link link) {
        LinkUtil.m23781a(this.f29382a, str, link);
    }
}
