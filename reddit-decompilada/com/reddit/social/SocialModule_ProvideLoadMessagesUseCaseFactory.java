package com.reddit.social;

import com.reddit.social.domain.usecases.LoadMessagesUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class SocialModule_ProvideLoadMessagesUseCaseFactory implements Factory<LoadMessagesUseCase> {
    public static LoadMessagesUseCase m35426a() {
        return (LoadMessagesUseCase) Preconditions.m26013a(SocialModule.m24459t(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return (LoadMessagesUseCase) Preconditions.m26013a(SocialModule.m24459t(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
