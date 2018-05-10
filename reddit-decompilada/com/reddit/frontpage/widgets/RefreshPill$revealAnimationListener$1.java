package com.reddit.frontpage.widgets;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\n"}, d2 = {"com/reddit/frontpage/widgets/RefreshPill$revealAnimationListener$1", "Landroid/animation/Animator$AnimatorListener;", "(Lcom/reddit/frontpage/widgets/RefreshPill;)V", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RefreshPill.kt */
public final class RefreshPill$revealAnimationListener$1 implements AnimatorListener {
    final /* synthetic */ RefreshPill f21941a;

    RefreshPill$revealAnimationListener$1(RefreshPill refreshPill) {
        this.f21941a = refreshPill;
    }

    public final void onAnimationRepeat(Animator animator) {
        this.f21941a.f21943b = false;
    }

    public final void onAnimationEnd(Animator animator) {
        this.f21941a.f21943b = true;
    }

    public final void onAnimationCancel(Animator animator) {
        this.f21941a.f21943b = true;
    }

    public final void onAnimationStart(Animator animator) {
        this.f21941a.f21943b = false;
    }
}
