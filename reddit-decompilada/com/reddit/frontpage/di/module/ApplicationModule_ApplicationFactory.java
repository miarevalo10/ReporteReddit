package com.reddit.frontpage.di.module;

import android.app.Application;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ApplicationModule_ApplicationFactory implements Factory<Application> {
    private final ApplicationModule f33519a;

    private ApplicationModule_ApplicationFactory(ApplicationModule applicationModule) {
        this.f33519a = applicationModule;
    }

    public static ApplicationModule_ApplicationFactory m34460a(ApplicationModule applicationModule) {
        return new ApplicationModule_ApplicationFactory(applicationModule);
    }

    public final /* synthetic */ Object get() {
        return (Application) Preconditions.m26013a(this.f33519a.f20230a, "Cannot return null from a non-@Nullable @Provides method");
    }
}
