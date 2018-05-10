package com.reddit.frontpage.di.module;

import com.reddit.frontpage.presentation.modtools.mute.add.AddMutedUserContract.View;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class AddMutedUserViewModule_ViewFactory implements Factory<View> {
    private final AddMutedUserViewModule f33503a;

    private AddMutedUserViewModule_ViewFactory(AddMutedUserViewModule addMutedUserViewModule) {
        this.f33503a = addMutedUserViewModule;
    }

    public static AddMutedUserViewModule_ViewFactory m34450a(AddMutedUserViewModule addMutedUserViewModule) {
        return new AddMutedUserViewModule_ViewFactory(addMutedUserViewModule);
    }

    public final /* synthetic */ Object get() {
        return (View) Preconditions.m26013a(this.f33503a.f20228a, "Cannot return null from a non-@Nullable @Provides method");
    }
}
