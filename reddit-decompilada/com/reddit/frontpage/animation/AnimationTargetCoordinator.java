package com.reddit.frontpage.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import timber.log.Timber;

public abstract class AnimationTargetCoordinator {
    private MultiListenerAnimationRunner f19900a;

    public final void m21786a(final MultiListenerAnimationRunner multiListenerAnimationRunner) {
        multiListenerAnimationRunner.m21791a(new AnimatorListenerAdapter(this) {
            static final /* synthetic */ boolean f19897a = true;
            final /* synthetic */ AnimationTargetCoordinator f19899c;

            static {
                Class cls = AnimationTargetCoordinator.class;
            }

            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (f19897a == null && this.f19899c.f19900a == null) {
                    throw new AssertionError();
                }
                this.f19899c.f19900a = null;
            }

            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (f19897a != null || this.f19899c.f19900a == null) {
                    this.f19899c.f19900a = multiListenerAnimationRunner;
                    return;
                }
                throw new AssertionError();
            }
        });
    }

    protected final void m21787b(MultiListenerAnimationRunner multiListenerAnimationRunner) {
        if (multiListenerAnimationRunner == this.f19900a) {
            Timber.c("[AnimationTargetCoordinator] anim running. squelch...", new Object[0]);
            return;
        }
        if (this.f19900a == null) {
            Timber.c("[AnimationTargetCoordinator] no anim running. START!", new Object[0]);
        } else {
            Timber.c("[AnimationTargetCoordinator] different anim running. CANCEL, then START!", new Object[0]);
            MultiListenerAnimationRunner multiListenerAnimationRunner2 = this.f19900a;
            if (multiListenerAnimationRunner2.f19903a != null) {
                multiListenerAnimationRunner2.f19903a.cancel();
            }
        }
        multiListenerAnimationRunner.m21790a();
    }
}
