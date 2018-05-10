package com.reddit.social;

import com.reddit.datalibrary.social.data.repo.ChatCredentialsRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class SocialModule_ProvideChatCredentialsRepositoryFactory implements Factory<ChatCredentialsRepository> {
    private final SocialModule f34577a;

    private SocialModule_ProvideChatCredentialsRepositoryFactory(SocialModule socialModule) {
        this.f34577a = socialModule;
    }

    public static SocialModule_ProvideChatCredentialsRepositoryFactory m35412a(SocialModule socialModule) {
        return new SocialModule_ProvideChatCredentialsRepositoryFactory(socialModule);
    }

    public final /* synthetic */ Object get() {
        return (ChatCredentialsRepository) Preconditions.m26013a(SocialModule.m24454o(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
