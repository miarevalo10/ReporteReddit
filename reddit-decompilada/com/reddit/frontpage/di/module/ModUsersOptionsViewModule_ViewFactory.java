package com.reddit.frontpage.di.module;

import com.reddit.frontpage.presentation.modtools.bottomsheet.modusersoptions.ModUsersOptionsContract.View;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ModUsersOptionsViewModule_ViewFactory implements Factory<View> {
    private final ModUsersOptionsViewModule f33609a;

    private ModUsersOptionsViewModule_ViewFactory(ModUsersOptionsViewModule modUsersOptionsViewModule) {
        this.f33609a = modUsersOptionsViewModule;
    }

    public static ModUsersOptionsViewModule_ViewFactory m34504a(ModUsersOptionsViewModule modUsersOptionsViewModule) {
        return new ModUsersOptionsViewModule_ViewFactory(modUsersOptionsViewModule);
    }

    public final /* synthetic */ Object get() {
        return (View) Preconditions.m26013a(this.f33609a.f20246a, "Cannot return null from a non-@Nullable @Provides method");
    }
}
