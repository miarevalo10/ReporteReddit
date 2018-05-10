package com.reddit.frontpage.di.module;

import com.reddit.frontpage.presentation.modtools.modqueue.modcommunities.ModCommunitiesContract.View;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ModCommunitiesViewModule_ViewFactory implements Factory<View> {
    private final ModCommunitiesViewModule f33600a;

    private ModCommunitiesViewModule_ViewFactory(ModCommunitiesViewModule modCommunitiesViewModule) {
        this.f33600a = modCommunitiesViewModule;
    }

    public static ModCommunitiesViewModule_ViewFactory m34498a(ModCommunitiesViewModule modCommunitiesViewModule) {
        return new ModCommunitiesViewModule_ViewFactory(modCommunitiesViewModule);
    }

    public final /* synthetic */ Object get() {
        return (View) Preconditions.m26013a(this.f33600a.f20242a, "Cannot return null from a non-@Nullable @Provides method");
    }
}
