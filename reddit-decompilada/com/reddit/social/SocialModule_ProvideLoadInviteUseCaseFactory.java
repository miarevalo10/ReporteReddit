package com.reddit.social;

import com.reddit.social.domain.usecases.LoadInviteUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class SocialModule_ProvideLoadInviteUseCaseFactory implements Factory<LoadInviteUseCase> {
    public static LoadInviteUseCase m35424a() {
        return (LoadInviteUseCase) Preconditions.m26013a(SocialModule.m24457r(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return (LoadInviteUseCase) Preconditions.m26013a(SocialModule.m24457r(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
