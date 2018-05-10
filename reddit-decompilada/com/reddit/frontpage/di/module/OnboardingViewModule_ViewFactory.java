package com.reddit.frontpage.di.module;

import com.reddit.frontpage.presentation.onboarding.OnboardingContract.View;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class OnboardingViewModule_ViewFactory implements Factory<View> {
    private final OnboardingViewModule f33637a;

    private OnboardingViewModule_ViewFactory(OnboardingViewModule onboardingViewModule) {
        this.f33637a = onboardingViewModule;
    }

    public static OnboardingViewModule_ViewFactory m34521a(OnboardingViewModule onboardingViewModule) {
        return new OnboardingViewModule_ViewFactory(onboardingViewModule);
    }

    public final /* synthetic */ Object get() {
        return (View) Preconditions.m26013a(this.f33637a.f20253a, "Cannot return null from a non-@Nullable @Provides method");
    }
}
