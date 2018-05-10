package com.reddit.frontpage.widgets.video;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

final /* synthetic */ class ClippingBarView$$Lambda$9 implements AnimatorUpdateListener {
    private final ClippingBarView f22047a;

    ClippingBarView$$Lambda$9(ClippingBarView clippingBarView) {
        this.f22047a = clippingBarView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        ClippingBarView clippingBarView = this.f22047a;
        clippingBarView.f22079a = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        clippingBarView.invalidate();
    }
}
