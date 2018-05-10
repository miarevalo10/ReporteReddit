package com.reddit.frontpage.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import timber.log.Timber;

public class ScaleInAnimationRunner extends MultiListenerAnimationRunner {
    public ScaleInAnimationRunner(final View view) {
        super(view);
        m21791a(new AnimatorListenerAdapter(this) {
            final /* synthetic */ ScaleInAnimationRunner f19908b;

            public void onAnimationStart(Animator animator) {
                Timber.a("[showanim.start] called", new Object[0]);
                super.onAnimationStart(animator);
                view.setVisibility(0);
            }
        });
    }

    protected final void mo4566a(ViewPropertyAnimator viewPropertyAnimator) {
        viewPropertyAnimator.scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(200).setInterpolator(new FastOutSlowInInterpolator());
    }
}
