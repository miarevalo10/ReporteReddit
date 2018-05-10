package com.reddit.frontpage.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import timber.log.Timber;

public class ScaleOutAnimationRunner extends MultiListenerAnimationRunner {
    public ScaleOutAnimationRunner(final View view) {
        super(view);
        m21791a(new AnimatorListenerAdapter(this) {
            final /* synthetic */ ScaleOutAnimationRunner f19910b;

            public void onAnimationStart(Animator animator) {
                Timber.a("[hideanim.start] called", new Object[0]);
                super.onAnimationStart(animator);
                view.setVisibility(0);
            }

            public void onAnimationEnd(Animator animator) {
                Timber.a("[hideanim.end] called", new Object[0]);
                super.onAnimationEnd(animator);
                view.setVisibility(8);
            }
        });
    }

    protected final void mo4566a(ViewPropertyAnimator viewPropertyAnimator) {
        viewPropertyAnimator.scaleX(0.0f).scaleY(0.0f).alpha(0.0f).setDuration(200).setInterpolator(new FastOutSlowInInterpolator());
    }
}
