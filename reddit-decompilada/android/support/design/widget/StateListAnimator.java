package android.support.design.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import java.util.ArrayList;

final class StateListAnimator {
    final ArrayList<Tuple> f616a = new ArrayList();
    Tuple f617b = null;
    ValueAnimator f618c = null;
    private final AnimatorListener f619d = new C00381(this);

    class C00381 extends AnimatorListenerAdapter {
        final /* synthetic */ StateListAnimator f613a;

        C00381(StateListAnimator stateListAnimator) {
            this.f613a = stateListAnimator;
        }

        public void onAnimationEnd(Animator animator) {
            if (this.f613a.f618c == animator) {
                this.f613a.f618c = null;
            }
        }
    }

    static class Tuple {
        final int[] f614a;
        final ValueAnimator f615b;

        Tuple(int[] iArr, ValueAnimator valueAnimator) {
            this.f614a = iArr;
            this.f615b = valueAnimator;
        }
    }

    StateListAnimator() {
    }

    public final void m295a(int[] iArr, ValueAnimator valueAnimator) {
        Tuple tuple = new Tuple(iArr, valueAnimator);
        valueAnimator.addListener(this.f619d);
        this.f616a.add(tuple);
    }
}
