package com.reddit.frontpage.di.module;

import com.reddit.datalibrary.frontpage.data.feature.settings.UserSettingsStorage.UserSettings;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class UserPreferenceDataModule_UserSettingsFactory implements Factory<UserSettings> {
    private final UserPreferenceDataModule f33691a;
    private final Provider<String> f33692b;

    private UserPreferenceDataModule_UserSettingsFactory(UserPreferenceDataModule userPreferenceDataModule, Provider<String> provider) {
        this.f33691a = userPreferenceDataModule;
        this.f33692b = provider;
    }

    public static UserPreferenceDataModule_UserSettingsFactory m34544a(UserPreferenceDataModule userPreferenceDataModule, Provider<String> provider) {
        return new UserPreferenceDataModule_UserSettingsFactory(userPreferenceDataModule, provider);
    }

    public final /* synthetic */ Object get() {
        return (UserSettings) Preconditions.m26013a(UserPreferenceDataModule.m22380a((String) this.f33692b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
