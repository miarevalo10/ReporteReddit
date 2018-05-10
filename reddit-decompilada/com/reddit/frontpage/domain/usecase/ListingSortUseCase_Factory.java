package com.reddit.frontpage.domain.usecase;

import com.reddit.frontpage.domain.repository.PreferenceRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class ListingSortUseCase_Factory implements Factory<ListingSortUseCase> {
    private final Provider<PreferenceRepository> f33751a;

    private ListingSortUseCase_Factory(Provider<PreferenceRepository> provider) {
        this.f33751a = provider;
    }

    public static ListingSortUseCase_Factory m34566a(Provider<PreferenceRepository> provider) {
        return new ListingSortUseCase_Factory(provider);
    }

    public final /* synthetic */ Object get() {
        return new ListingSortUseCase((PreferenceRepository) this.f33751a.get());
    }
}
