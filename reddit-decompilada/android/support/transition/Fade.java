package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.support.transition.Transition.TransitionListener;
import android.support.v4.view.ViewCompat;
import android.view.View;

public class Fade extends Visibility {

    private static class FadeAnimatorListener extends AnimatorListenerAdapter {
        private final View f840a;
        private boolean f841b = false;

        FadeAnimatorListener(View view) {
            this.f840a = view;
        }

        public void onAnimationStart(Animator animator) {
            if (ViewCompat.m1200A(this.f840a) != null && this.f840a.getLayerType() == null) {
                this.f841b = true;
                this.f840a.setLayerType(2, null);
            }
        }

        public void onAnimationEnd(Animator animator) {
            ViewUtils.m499a(this.f840a, 1.0f);
            if (this.f841b != null) {
                this.f840a.setLayerType(0, null);
            }
        }
    }

    public Fade(int i) {
        if ((i & -4) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.f11245k = i;
    }

    public final void mo132a(TransitionValues transitionValues) {
        super.mo132a(transitionValues);
        transitionValues.f902a.put("android:fade:transitionAlpha", Float.valueOf(ViewUtils.m505c(transitionValues.f903b)));
    }

    private Animator m16589a(final View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        ViewUtils.m499a(view, f);
        f = ObjectAnimator.ofFloat(view, ViewUtils.f916a, new float[]{f2});
        f.addListener(new FadeAnimatorListener(view));
        mo159a((TransitionListener) new TransitionListenerAdapter(this) {
            final /* synthetic */ Fade f16478b;

            public final void mo136a(Transition transition) {
                ViewUtils.m499a(view, 1.0f);
                ViewUtils.m507e(view);
                transition.mo165b((TransitionListener) this);
            }
        });
        return f;
    }

    public final Animator mo3107a(View view, TransitionValues transitionValues) {
        transitionValues = m16588a(transitionValues, 0.0f);
        if (transitionValues == 1065353216) {
            transitionValues = null;
        }
        return m16589a(view, transitionValues, 1.0f);
    }

    public final Animator mo3108b(View view, TransitionValues transitionValues) {
        ViewUtils.m506d(view);
        return m16589a(view, m16588a(transitionValues, 1.0f), 0.0f);
    }

    private static float m16588a(TransitionValues transitionValues, float f) {
        if (transitionValues == null) {
            return f;
        }
        Float f2 = (Float) transitionValues.f902a.get("android:fade:transitionAlpha");
        return f2 != null ? f2.floatValue() : f;
    }
}
