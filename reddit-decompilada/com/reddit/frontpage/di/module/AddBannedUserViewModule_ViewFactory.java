package com.reddit.frontpage.di.module;

import com.reddit.frontpage.presentation.modtools.ban.add.AddBannedUserContract.View;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class AddBannedUserViewModule_ViewFactory implements Factory<View> {
    private final AddBannedUserViewModule f33501a;

    private AddBannedUserViewModule_ViewFactory(AddBannedUserViewModule addBannedUserViewModule) {
        this.f33501a = addBannedUserViewModule;
    }

    public static AddBannedUserViewModule_ViewFactory m34448a(AddBannedUserViewModule addBannedUserViewModule) {
        return new AddBannedUserViewModule_ViewFactory(addBannedUserViewModule);
    }

    public final /* synthetic */ Object get() {
        return (View) Preconditions.m26013a(this.f33501a.f20226a, "Cannot return null from a non-@Nullable @Provides method");
    }
}
