package com.reddit.frontpage.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.List;

public abstract class MultiListenerAnimationRunner {
    ViewPropertyAnimator f19903a;
    private final AnimatorListenerAdapter f19904b = new C17641(this);
    private final View f19905c;
    private final List<AnimatorListener> f19906d = new ArrayList();

    class C17641 extends AnimatorListenerAdapter {
        final /* synthetic */ MultiListenerAnimationRunner f19902a;

        C17641(MultiListenerAnimationRunner multiListenerAnimationRunner) {
            this.f19902a = multiListenerAnimationRunner;
        }

        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            for (AnimatorListener onAnimationCancel : this.f19902a.f19906d) {
                onAnimationCancel.onAnimationCancel(animator);
            }
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            for (AnimatorListener onAnimationEnd : this.f19902a.f19906d) {
                onAnimationEnd.onAnimationEnd(animator);
            }
            this.f19902a.f19903a = null;
        }

        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            for (AnimatorListener onAnimationStart : this.f19902a.f19906d) {
                onAnimationStart.onAnimationStart(animator);
            }
        }

        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            for (AnimatorListener onAnimationRepeat : this.f19902a.f19906d) {
                onAnimationRepeat.onAnimationRepeat(animator);
            }
        }
    }

    protected abstract void mo4566a(ViewPropertyAnimator viewPropertyAnimator);

    public MultiListenerAnimationRunner(View view) {
        this.f19905c = view;
    }

    public final void m21790a() {
        this.f19903a = this.f19905c.animate();
        this.f19903a.setListener(this.f19904b);
        mo4566a(this.f19903a);
    }

    public final void m21791a(AnimatorListener animatorListener) {
        this.f19906d.add(animatorListener);
    }
}
