package com.reddit.frontpage.di.module;

import com.reddit.frontpage.presentation.profile.user.UserAccountContract.View;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class UserAccountViewModule_ViewFactory implements Factory<View> {
    private final UserAccountViewModule f33684a;

    private UserAccountViewModule_ViewFactory(UserAccountViewModule userAccountViewModule) {
        this.f33684a = userAccountViewModule;
    }

    public static UserAccountViewModule_ViewFactory m34541a(UserAccountViewModule userAccountViewModule) {
        return new UserAccountViewModule_ViewFactory(userAccountViewModule);
    }

    public final /* synthetic */ Object get() {
        return (View) Preconditions.m26013a(this.f33684a.f20255a, "Cannot return null from a non-@Nullable @Provides method");
    }
}
