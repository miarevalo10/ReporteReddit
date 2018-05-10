package com.reddit.frontpage.di.module;

import android.content.Context;
import com.firebase.jobdispatcher.GooglePlayDriver;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class ThriftModule_ProvideGooglePlayDriverFactory implements Factory<GooglePlayDriver> {
    private final ThriftModule f33667a;
    private final Provider<Context> f33668b;

    private ThriftModule_ProvideGooglePlayDriverFactory(ThriftModule thriftModule, Provider<Context> provider) {
        this.f33667a = thriftModule;
        this.f33668b = provider;
    }

    public static ThriftModule_ProvideGooglePlayDriverFactory m34534a(ThriftModule thriftModule, Provider<Context> provider) {
        return new ThriftModule_ProvideGooglePlayDriverFactory(thriftModule, provider);
    }

    public final /* synthetic */ Object get() {
        return (GooglePlayDriver) Preconditions.m26013a(ThriftModule.m22373a((Context) this.f33668b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
