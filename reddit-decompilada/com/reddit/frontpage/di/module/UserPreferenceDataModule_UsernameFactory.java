package com.reddit.frontpage.di.module;

import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class UserPreferenceDataModule_UsernameFactory implements Factory<String> {
    private final UserPreferenceDataModule f33696a;
    private final Provider<Session> f33697b;

    private UserPreferenceDataModule_UsernameFactory(UserPreferenceDataModule userPreferenceDataModule, Provider<Session> provider) {
        this.f33696a = userPreferenceDataModule;
        this.f33697b = provider;
    }

    public static UserPreferenceDataModule_UsernameFactory m34546a(UserPreferenceDataModule userPreferenceDataModule, Provider<Session> provider) {
        return new UserPreferenceDataModule_UsernameFactory(userPreferenceDataModule, provider);
    }

    public final /* synthetic */ Object get() {
        return (String) Preconditions.m26013a(UserPreferenceDataModule.m22382a((Session) this.f33697b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
