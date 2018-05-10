package com.reddit.social;

import com.reddit.datalibrary.social.data.session.ChatConnectionManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class SocialModule_ProvideSendBirdSessionFactory implements Factory<ChatConnectionManager> {
    private final SocialModule f34581a;

    private SocialModule_ProvideSendBirdSessionFactory(SocialModule socialModule) {
        this.f34581a = socialModule;
    }

    public static SocialModule_ProvideSendBirdSessionFactory m35430a(SocialModule socialModule) {
        return new SocialModule_ProvideSendBirdSessionFactory(socialModule);
    }

    public final /* synthetic */ Object get() {
        return (ChatConnectionManager) Preconditions.m26013a(SocialModule.m24447h(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
