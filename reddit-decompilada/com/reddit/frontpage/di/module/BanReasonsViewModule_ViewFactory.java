package com.reddit.frontpage.di.module;

import com.reddit.frontpage.presentation.modtools.ban.add.bottomsheet.BanReasonsContract.View;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class BanReasonsViewModule_ViewFactory implements Factory<View> {
    private final BanReasonsViewModule f33529a;

    private BanReasonsViewModule_ViewFactory(BanReasonsViewModule banReasonsViewModule) {
        this.f33529a = banReasonsViewModule;
    }

    public static BanReasonsViewModule_ViewFactory m34468a(BanReasonsViewModule banReasonsViewModule) {
        return new BanReasonsViewModule_ViewFactory(banReasonsViewModule);
    }

    public final /* synthetic */ Object get() {
        return (View) Preconditions.m26013a(this.f33529a.f20232a, "Cannot return null from a non-@Nullable @Provides method");
    }
}
