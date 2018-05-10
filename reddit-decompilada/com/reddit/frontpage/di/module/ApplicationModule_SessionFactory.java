package com.reddit.frontpage.di.module;

import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class ApplicationModule_SessionFactory implements Factory<Session> {
    private final ApplicationModule f33525a;
    private final Provider<SessionManager> f33526b;

    private ApplicationModule_SessionFactory(ApplicationModule applicationModule, Provider<SessionManager> provider) {
        this.f33525a = applicationModule;
        this.f33526b = provider;
    }

    public static ApplicationModule_SessionFactory m34465a(ApplicationModule applicationModule, Provider<SessionManager> provider) {
        return new ApplicationModule_SessionFactory(applicationModule, provider);
    }

    public final /* synthetic */ Object get() {
        return (Session) Preconditions.m26013a(ApplicationModule.m22323a((SessionManager) this.f33526b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
