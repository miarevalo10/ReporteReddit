package android.support.transition;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.support.annotation.RequiresApi;
import java.util.ArrayList;

@RequiresApi(14)
class AnimatorUtilsApi14 implements AnimatorUtilsImpl {

    interface AnimatorPauseListenerCompat {
        void onAnimationPause(Animator animator);

        void onAnimationResume(Animator animator);
    }

    public final void mo129a(Animator animator, AnimatorListenerAdapter animatorListenerAdapter) {
    }

    AnimatorUtilsApi14() {
    }

    public final void mo128a(Animator animator) {
        ArrayList listeners = animator.getListeners();
        if (listeners != null) {
            int size = listeners.size();
            for (int i = 0; i < size; i++) {
                AnimatorListener animatorListener = (AnimatorListener) listeners.get(i);
                if (animatorListener instanceof AnimatorPauseListenerCompat) {
                    ((AnimatorPauseListenerCompat) animatorListener).onAnimationPause(animator);
                }
            }
        }
    }

    public final void mo130b(Animator animator) {
        ArrayList listeners = animator.getListeners();
        if (listeners != null) {
            int size = listeners.size();
            for (int i = 0; i < size; i++) {
                AnimatorListener animatorListener = (AnimatorListener) listeners.get(i);
                if (animatorListener instanceof AnimatorPauseListenerCompat) {
                    ((AnimatorPauseListenerCompat) animatorListener).onAnimationResume(animator);
                }
            }
        }
    }
}
