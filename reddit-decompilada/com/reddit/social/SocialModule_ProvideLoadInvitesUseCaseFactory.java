package com.reddit.social;

import com.reddit.social.domain.usecases.LoadInvitesUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class SocialModule_ProvideLoadInvitesUseCaseFactory implements Factory<LoadInvitesUseCase> {
    public static LoadInvitesUseCase m35425a() {
        return (LoadInvitesUseCase) Preconditions.m26013a(SocialModule.m24458s(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return (LoadInvitesUseCase) Preconditions.m26013a(SocialModule.m24458s(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
