package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.annotation.RequiresApi;

@RequiresApi(19)
class AnimatorUtilsApi19 implements AnimatorUtilsImpl {
    AnimatorUtilsApi19() {
    }

    public final void mo129a(Animator animator, AnimatorListenerAdapter animatorListenerAdapter) {
        animator.addPauseListener(animatorListenerAdapter);
    }

    public final void mo128a(Animator animator) {
        animator.pause();
    }

    public final void mo130b(Animator animator) {
        animator.resume();
    }
}
