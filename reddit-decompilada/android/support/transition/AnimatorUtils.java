package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build.VERSION;

class AnimatorUtils {
    private static final AnimatorUtilsImpl f816a;

    static {
        if (VERSION.SDK_INT >= 19) {
            f816a = new AnimatorUtilsApi19();
        } else {
            f816a = new AnimatorUtilsApi14();
        }
    }

    static void m429a(Animator animator, AnimatorListenerAdapter animatorListenerAdapter) {
        f816a.mo129a(animator, animatorListenerAdapter);
    }

    static void m428a(Animator animator) {
        f816a.mo128a(animator);
    }

    static void m430b(Animator animator) {
        f816a.mo130b(animator);
    }
}
