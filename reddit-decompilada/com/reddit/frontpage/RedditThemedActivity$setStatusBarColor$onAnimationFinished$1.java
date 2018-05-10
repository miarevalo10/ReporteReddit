package com.reddit.frontpage;

import android.animation.Animator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "animator", "Landroid/animation/Animator;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditThemedActivity.kt */
final class RedditThemedActivity$setStatusBarColor$onAnimationFinished$1 extends Lambda implements Function1<Animator, Unit> {
    final /* synthetic */ RedditThemedActivity f36330a;

    RedditThemedActivity$setStatusBarColor$onAnimationFinished$1(RedditThemedActivity redditThemedActivity) {
        this.f36330a = redditThemedActivity;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Intrinsics.m26847b((Animator) obj, "animator");
        this.f36330a.f40552g = null;
        return Unit.f25273a;
    }
}
