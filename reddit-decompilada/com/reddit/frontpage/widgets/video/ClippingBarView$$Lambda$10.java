package com.reddit.frontpage.widgets.video;

import io.reactivex.functions.Consumer;

final /* synthetic */ class ClippingBarView$$Lambda$10 implements Consumer {
    private final ClippingBarView f29538a;

    ClippingBarView$$Lambda$10(ClippingBarView clippingBarView) {
        this.f29538a = clippingBarView;
    }

    public final void accept(Object obj) {
        ClippingBarView clippingBarView = this.f29538a;
        Long l = (Long) obj;
        if (clippingBarView.f22080b != null) {
            clippingBarView.f22080b.m24358a(l.longValue());
        }
    }
}
