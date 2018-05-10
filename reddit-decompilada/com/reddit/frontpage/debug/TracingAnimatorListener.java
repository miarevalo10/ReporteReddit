package com.reddit.frontpage.debug;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.text.TextUtils;
import timber.log.Timber;

public class TracingAnimatorListener implements AnimatorListener {
    private String f20145a;

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public TracingAnimatorListener(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f20145a = getClass().getName();
        } else {
            this.f20145a = str;
        }
    }

    public void onAnimationStart(Animator animator) {
        AnimationTracer.m21976a(this.f20145a);
    }

    public void onAnimationEnd(Animator animator) {
        Timber.b(AnimationTracer.m21977b(this.f20145a).toString(), new Object[0]);
    }
}
