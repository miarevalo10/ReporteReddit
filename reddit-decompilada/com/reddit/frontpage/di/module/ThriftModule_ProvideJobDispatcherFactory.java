package com.reddit.frontpage.di.module;

import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class ThriftModule_ProvideJobDispatcherFactory implements Factory<FirebaseJobDispatcher> {
    private final ThriftModule f33669a;
    private final Provider<GooglePlayDriver> f33670b;

    private ThriftModule_ProvideJobDispatcherFactory(ThriftModule thriftModule, Provider<GooglePlayDriver> provider) {
        this.f33669a = thriftModule;
        this.f33670b = provider;
    }

    public static ThriftModule_ProvideJobDispatcherFactory m34535a(ThriftModule thriftModule, Provider<GooglePlayDriver> provider) {
        return new ThriftModule_ProvideJobDispatcherFactory(thriftModule, provider);
    }

    public final /* synthetic */ Object get() {
        return (FirebaseJobDispatcher) Preconditions.m26013a(ThriftModule.m22372a((GooglePlayDriver) this.f33670b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
