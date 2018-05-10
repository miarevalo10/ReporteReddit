package com.reddit.frontpage.di.module;

import com.reddit.frontpage.presentation.modtools.base.BaseModeratorsContract.View;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class MutedUsersViewModule_ViewFactory implements Factory<View> {
    private final MutedUsersViewModule f33610a;

    private MutedUsersViewModule_ViewFactory(MutedUsersViewModule mutedUsersViewModule) {
        this.f33610a = mutedUsersViewModule;
    }

    public static MutedUsersViewModule_ViewFactory m34505a(MutedUsersViewModule mutedUsersViewModule) {
        return new MutedUsersViewModule_ViewFactory(mutedUsersViewModule);
    }

    public final /* synthetic */ Object get() {
        return (View) Preconditions.m26013a(this.f33610a.f20247a, "Cannot return null from a non-@Nullable @Provides method");
    }
}
