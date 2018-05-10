package com.reddit.frontpage.di.module;

import com.reddit.frontpage.presentation.usermodal.UserModalContract.View;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class UserModalModule_ViewFactory implements Factory<View> {
    private final UserModalModule f33685a;

    private UserModalModule_ViewFactory(UserModalModule userModalModule) {
        this.f33685a = userModalModule;
    }

    public static UserModalModule_ViewFactory m34542a(UserModalModule userModalModule) {
        return new UserModalModule_ViewFactory(userModalModule);
    }

    public final /* synthetic */ Object get() {
        return (View) Preconditions.m26013a(this.f33685a.f20256a, "Cannot return null from a non-@Nullable @Provides method");
    }
}
