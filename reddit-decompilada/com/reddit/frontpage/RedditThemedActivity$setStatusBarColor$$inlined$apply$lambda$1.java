package com.reddit.frontpage;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditThemedActivity.kt */
final class RedditThemedActivity$setStatusBarColor$$inlined$apply$lambda$1 implements AnimatorUpdateListener {
    final /* synthetic */ RedditThemedActivity f19889a;
    final /* synthetic */ Function1 f19890b;

    RedditThemedActivity$setStatusBarColor$$inlined$apply$lambda$1(RedditThemedActivity redditThemedActivity, Function1 function1) {
        this.f19889a = redditThemedActivity;
        this.f19890b = function1;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Object window = this.f19889a.getWindow();
        Intrinsics.m26843a(window, "window");
        Intrinsics.m26843a((Object) valueAnimator, "it");
        valueAnimator = valueAnimator.getAnimatedValue();
        if (valueAnimator == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
        }
        window.setStatusBarColor(((Integer) valueAnimator).intValue());
    }
}
