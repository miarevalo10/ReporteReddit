package com.reddit.frontpage.di.module;

import com.reddit.frontpage.presentation.modtools.base.BaseModeratorsContract.View;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ApprovedSubmittersViewModule_ViewFactory implements Factory<View> {
    private final ApprovedSubmittersViewModule f33528a;

    private ApprovedSubmittersViewModule_ViewFactory(ApprovedSubmittersViewModule approvedSubmittersViewModule) {
        this.f33528a = approvedSubmittersViewModule;
    }

    public static ApprovedSubmittersViewModule_ViewFactory m34467a(ApprovedSubmittersViewModule approvedSubmittersViewModule) {
        return new ApprovedSubmittersViewModule_ViewFactory(approvedSubmittersViewModule);
    }

    public final /* synthetic */ Object get() {
        return (View) Preconditions.m26013a(this.f33528a.f20231a, "Cannot return null from a non-@Nullable @Provides method");
    }
}
