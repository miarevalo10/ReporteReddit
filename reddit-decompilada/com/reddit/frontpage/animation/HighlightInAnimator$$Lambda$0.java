package com.reddit.frontpage.animation;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.v7.widget.RecyclerView.ViewHolder;

final /* synthetic */ class HighlightInAnimator$$Lambda$0 implements AnimatorUpdateListener {
    private final ViewHolder f19901a;

    HighlightInAnimator$$Lambda$0(ViewHolder viewHolder) {
        this.f19901a = viewHolder;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f19901a.c.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
