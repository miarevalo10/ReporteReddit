package com.reddit.frontpage.di.module;

import com.reddit.frontpage.presentation.modtools.base.BaseModeratorsContract.View;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class BannedUsersViewModule_ViewFactory implements Factory<View> {
    private final BannedUsersViewModule f33530a;

    private BannedUsersViewModule_ViewFactory(BannedUsersViewModule bannedUsersViewModule) {
        this.f33530a = bannedUsersViewModule;
    }

    public static BannedUsersViewModule_ViewFactory m34469a(BannedUsersViewModule bannedUsersViewModule) {
        return new BannedUsersViewModule_ViewFactory(bannedUsersViewModule);
    }

    public final /* synthetic */ Object get() {
        return (View) Preconditions.m26013a(this.f33530a.f20233a, "Cannot return null from a non-@Nullable @Provides method");
    }
}
