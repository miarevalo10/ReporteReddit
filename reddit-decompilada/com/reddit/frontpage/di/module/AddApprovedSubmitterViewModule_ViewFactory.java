package com.reddit.frontpage.di.module;

import com.reddit.frontpage.presentation.modtools.approvedsubmitters.add.AddApprovedSubmitterContract.View;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class AddApprovedSubmitterViewModule_ViewFactory implements Factory<View> {
    private final AddApprovedSubmitterViewModule f33500a;

    private AddApprovedSubmitterViewModule_ViewFactory(AddApprovedSubmitterViewModule addApprovedSubmitterViewModule) {
        this.f33500a = addApprovedSubmitterViewModule;
    }

    public static AddApprovedSubmitterViewModule_ViewFactory m34447a(AddApprovedSubmitterViewModule addApprovedSubmitterViewModule) {
        return new AddApprovedSubmitterViewModule_ViewFactory(addApprovedSubmitterViewModule);
    }

    public final /* synthetic */ Object get() {
        return (View) Preconditions.m26013a(this.f33500a.f20225a, "Cannot return null from a non-@Nullable @Provides method");
    }
}
