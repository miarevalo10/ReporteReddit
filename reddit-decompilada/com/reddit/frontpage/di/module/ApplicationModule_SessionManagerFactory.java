package com.reddit.frontpage.di.module;

import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ApplicationModule_SessionManagerFactory implements Factory<SessionManager> {
    private final ApplicationModule f33527a;

    private ApplicationModule_SessionManagerFactory(ApplicationModule applicationModule) {
        this.f33527a = applicationModule;
    }

    public static ApplicationModule_SessionManagerFactory m34466a(ApplicationModule applicationModule) {
        return new ApplicationModule_SessionManagerFactory(applicationModule);
    }

    public final /* synthetic */ Object get() {
        return (SessionManager) Preconditions.m26013a(ApplicationModule.m22324a(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
