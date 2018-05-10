package com.reddit.frontpage.util;

import com.reddit.frontpage.widgets.ShapedIconView;

final /* synthetic */ class Util$$Lambda$0 implements Runnable {
    private final ShapedIconView f21808a;

    Util$$Lambda$0(ShapedIconView shapedIconView) {
        this.f21808a = shapedIconView;
    }

    public final void run() {
        this.f21808a.setImageBitmap(AvatarUtilKt.m23656a(this.f21808a));
    }
}
