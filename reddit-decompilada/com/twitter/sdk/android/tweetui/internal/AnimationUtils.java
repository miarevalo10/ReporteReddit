package com.twitter.sdk.android.tweetui.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

class AnimationUtils {
    public static ViewPropertyAnimator m25950a(final View view) {
        if (view.getVisibility() != 0) {
            return null;
        }
        view.clearAnimation();
        ViewPropertyAnimator animate = view.animate();
        animate.alpha(0.0f).setDuration(150).setListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                view.setVisibility(4);
                view.setAlpha(1.0f);
            }
        });
        return animate;
    }

    public static ViewPropertyAnimator m25951b(View view) {
        if (view.getVisibility() != 0) {
            view.setAlpha(0.0f);
            view.setVisibility(0);
        }
        view.clearAnimation();
        view = view.animate();
        view.alpha(1.0f).setDuration(150).setListener(null);
        return view;
    }
}
