package com.reddit.frontpage.widgets.video;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

final /* synthetic */ class ClippingBarView$$Lambda$8 implements AnimatorUpdateListener {
    private final ClippingBarView f22046a;

    ClippingBarView$$Lambda$8(ClippingBarView clippingBarView) {
        this.f22046a = clippingBarView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f22046a.invalidate();
    }
}
