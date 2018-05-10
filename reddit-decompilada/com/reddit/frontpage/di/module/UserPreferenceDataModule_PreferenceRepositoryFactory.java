package com.reddit.frontpage.di.module;

import android.content.Context;
import android.content.SharedPreferences;
import com.reddit.common.rx.BackgroundThread;
import com.reddit.datalibrary.frontpage.data.feature.settings.UserSettingsStorage.UserSettings;
import com.reddit.frontpage.domain.repository.PreferenceRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class UserPreferenceDataModule_PreferenceRepositoryFactory implements Factory<PreferenceRepository> {
    private final UserPreferenceDataModule f33686a;
    private final Provider<Context> f33687b;
    private final Provider<SharedPreferences> f33688c;
    private final Provider<UserSettings> f33689d;
    private final Provider<BackgroundThread> f33690e;

    private UserPreferenceDataModule_PreferenceRepositoryFactory(UserPreferenceDataModule userPreferenceDataModule, Provider<Context> provider, Provider<SharedPreferences> provider2, Provider<UserSettings> provider3, Provider<BackgroundThread> provider4) {
        this.f33686a = userPreferenceDataModule;
        this.f33687b = provider;
        this.f33688c = provider2;
        this.f33689d = provider3;
        this.f33690e = provider4;
    }

    public static UserPreferenceDataModule_PreferenceRepositoryFactory m34543a(UserPreferenceDataModule userPreferenceDataModule, Provider<Context> provider, Provider<SharedPreferences> provider2, Provider<UserSettings> provider3, Provider<BackgroundThread> provider4) {
        return new UserPreferenceDataModule_PreferenceRepositoryFactory(userPreferenceDataModule, provider, provider2, provider3, provider4);
    }

    public final /* synthetic */ Object get() {
        return (PreferenceRepository) Preconditions.m26013a(UserPreferenceDataModule.m22381a((Context) this.f33687b.get(), (SharedPreferences) this.f33688c.get(), (UserSettings) this.f33689d.get(), (BackgroundThread) this.f33690e.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
