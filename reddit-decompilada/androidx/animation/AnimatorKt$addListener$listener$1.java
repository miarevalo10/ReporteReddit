package androidx.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\n"}, d2 = {"androidx/animation/AnimatorKt$addListener$listener$1", "Landroid/animation/Animator$AnimatorListener;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "onAnimationCancel", "", "animator", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "core-ktx_release"}, k = 1, mv = {1, 1, 9})
/* compiled from: Animator.kt */
public final class AnimatorKt$addListener$listener$1 implements AnimatorListener {
    final /* synthetic */ Function1 f2682a = null;
    final /* synthetic */ Function1 f2683b;
    final /* synthetic */ Function1 f2684c;
    final /* synthetic */ Function1 f2685d;

    AnimatorKt$addListener$listener$1(Function1 function1, Function1 function12) {
        this.f2683b = function1;
        this.f2684c = function12;
        this.f2685d = null;
    }

    public final void onAnimationRepeat(Animator animator) {
        Function1 function1 = this.f2682a;
        if (function1 != null) {
            function1.a(animator);
        }
    }

    public final void onAnimationEnd(Animator animator) {
        Function1 function1 = this.f2683b;
        if (function1 != null) {
            function1.a(animator);
        }
    }

    public final void onAnimationCancel(Animator animator) {
        Function1 function1 = this.f2684c;
        if (function1 != null) {
            function1.a(animator);
        }
    }

    public final void onAnimationStart(Animator animator) {
        Function1 function1 = this.f2685d;
        if (function1 != null) {
            function1.a(animator);
        }
    }
}
