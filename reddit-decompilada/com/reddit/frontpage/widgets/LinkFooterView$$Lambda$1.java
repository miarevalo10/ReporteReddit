package com.reddit.frontpage.widgets;

import io.reactivex.functions.Consumer;
import timber.log.Timber;

final /* synthetic */ class LinkFooterView$$Lambda$1 implements Consumer {
    private final LinkFooterView f29453a;

    LinkFooterView$$Lambda$1(LinkFooterView linkFooterView) {
        this.f29453a = linkFooterView;
    }

    public final void accept(Object obj) {
        LinkFooterView linkFooterView = this.f29453a;
        Timber.c((Throwable) obj, "Error getting post flairs", new Object[0]);
        linkFooterView.m24176a(true);
    }
}
