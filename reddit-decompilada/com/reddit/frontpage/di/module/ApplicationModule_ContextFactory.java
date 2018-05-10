package com.reddit.frontpage.di.module;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ApplicationModule_ContextFactory implements Factory<Context> {
    private final ApplicationModule f33521a;

    private ApplicationModule_ContextFactory(ApplicationModule applicationModule) {
        this.f33521a = applicationModule;
    }

    public static ApplicationModule_ContextFactory m34462a(ApplicationModule applicationModule) {
        return new ApplicationModule_ContextFactory(applicationModule);
    }

    public final /* synthetic */ Object get() {
        return (Context) Preconditions.m26013a(this.f33521a.f20230a, "Cannot return null from a non-@Nullable @Provides method");
    }
}
