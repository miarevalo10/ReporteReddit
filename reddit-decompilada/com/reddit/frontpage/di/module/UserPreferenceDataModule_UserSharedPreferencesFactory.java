package com.reddit.frontpage.di.module;

import android.app.Application;
import android.content.SharedPreferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class UserPreferenceDataModule_UserSharedPreferencesFactory implements Factory<SharedPreferences> {
    private final UserPreferenceDataModule f33693a;
    private final Provider<String> f33694b;
    private final Provider<Application> f33695c;

    private UserPreferenceDataModule_UserSharedPreferencesFactory(UserPreferenceDataModule userPreferenceDataModule, Provider<String> provider, Provider<Application> provider2) {
        this.f33693a = userPreferenceDataModule;
        this.f33694b = provider;
        this.f33695c = provider2;
    }

    public static UserPreferenceDataModule_UserSharedPreferencesFactory m34545a(UserPreferenceDataModule userPreferenceDataModule, Provider<String> provider, Provider<Application> provider2) {
        return new UserPreferenceDataModule_UserSharedPreferencesFactory(userPreferenceDataModule, provider, provider2);
    }

    public final /* synthetic */ Object get() {
        return (SharedPreferences) Preconditions.m26013a(UserPreferenceDataModule.m22379a((String) this.f33694b.get(), (Application) this.f33695c.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
