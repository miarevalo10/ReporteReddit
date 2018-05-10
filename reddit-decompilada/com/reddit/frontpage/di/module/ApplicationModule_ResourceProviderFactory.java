package com.reddit.frontpage.di.module;

import android.content.Context;
import com.reddit.frontpage.domain.common.ResourceProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class ApplicationModule_ResourceProviderFactory implements Factory<ResourceProvider> {
    private final ApplicationModule f33523a;
    private final Provider<Context> f33524b;

    private ApplicationModule_ResourceProviderFactory(ApplicationModule applicationModule, Provider<Context> provider) {
        this.f33523a = applicationModule;
        this.f33524b = provider;
    }

    public static ApplicationModule_ResourceProviderFactory m34464a(ApplicationModule applicationModule, Provider<Context> provider) {
        return new ApplicationModule_ResourceProviderFactory(applicationModule, provider);
    }

    public final /* synthetic */ Object get() {
        return (ResourceProvider) Preconditions.m26013a(ApplicationModule.m22325a((Context) this.f33524b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
