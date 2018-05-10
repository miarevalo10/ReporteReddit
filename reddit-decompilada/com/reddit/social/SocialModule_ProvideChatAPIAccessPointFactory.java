package com.reddit.social;

import com.reddit.datalibrary.social.network.BaseplateClient;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class SocialModule_ProvideChatAPIAccessPointFactory implements Factory<BaseplateClient> {
    private final SocialModule f34576a;

    private SocialModule_ProvideChatAPIAccessPointFactory(SocialModule socialModule) {
        this.f34576a = socialModule;
    }

    public static SocialModule_ProvideChatAPIAccessPointFactory m35410a(SocialModule socialModule) {
        return new SocialModule_ProvideChatAPIAccessPointFactory(socialModule);
    }

    public final /* synthetic */ Object get() {
        return (BaseplateClient) Preconditions.m26013a(SocialModule.m24453n(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
