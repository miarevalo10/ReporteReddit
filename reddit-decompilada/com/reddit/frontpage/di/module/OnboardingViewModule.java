package com.reddit.frontpage.di.module;

import com.reddit.frontpage.presentation.onboarding.OnboardingContract.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0002\u001a\u00020\u0003H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/di/module/OnboardingViewModule;", "", "view", "Lcom/reddit/frontpage/presentation/onboarding/OnboardingContract$View;", "(Lcom/reddit/frontpage/presentation/onboarding/OnboardingContract$View;)V", "getView", "()Lcom/reddit/frontpage/presentation/onboarding/OnboardingContract$View;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: OnboardingViewModule.kt */
public final class OnboardingViewModule {
    final View f20253a;

    public OnboardingViewModule(View view) {
        Intrinsics.m26847b(view, "view");
        this.f20253a = view;
    }
}
