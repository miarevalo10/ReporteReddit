package com.reddit.frontpage.di.module;

import com.reddit.frontpage.presentation.modtools.modlist.all.AllModeratorsContract.View;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class AllModeratorsViewModule_ViewFactory implements Factory<View> {
    private final AllModeratorsViewModule f33512a;

    private AllModeratorsViewModule_ViewFactory(AllModeratorsViewModule allModeratorsViewModule) {
        this.f33512a = allModeratorsViewModule;
    }

    public static AllModeratorsViewModule_ViewFactory m34454a(AllModeratorsViewModule allModeratorsViewModule) {
        return new AllModeratorsViewModule_ViewFactory(allModeratorsViewModule);
    }

    public final /* synthetic */ Object get() {
        return (View) Preconditions.m26013a(this.f33512a.f20229a, "Cannot return null from a non-@Nullable @Provides method");
    }
}
