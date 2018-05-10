package com.reddit.frontpage.widgets;

import com.reddit.frontpage.commons.analytics.builders.CustomReasonsNoun;
import com.reddit.frontpage.commons.analytics.builders.CustomReportEventBuilder;

final /* synthetic */ class LinkHeaderView$$Lambda$0 implements Runnable {
    private final LinkHeaderView f21907a;

    LinkHeaderView$$Lambda$0(LinkHeaderView linkHeaderView) {
        this.f21907a = linkHeaderView;
    }

    public final void run() {
        CustomReportEventBuilder.m28937a(this.f21907a.f29461a, "post_overflow", "click", CustomReasonsNoun.f20016a.f20028l);
    }
}
