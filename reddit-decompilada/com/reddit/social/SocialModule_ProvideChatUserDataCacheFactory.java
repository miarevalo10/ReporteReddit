package com.reddit.social;

import com.reddit.datalibrary.social.data.datasource.cache.ChatUserDataCacheContract;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class SocialModule_ProvideChatUserDataCacheFactory implements Factory<ChatUserDataCacheContract> {
    private final SocialModule f34578a;

    private SocialModule_ProvideChatUserDataCacheFactory(SocialModule socialModule) {
        this.f34578a = socialModule;
    }

    public static SocialModule_ProvideChatUserDataCacheFactory m35418a(SocialModule socialModule) {
        return new SocialModule_ProvideChatUserDataCacheFactory(socialModule);
    }

    public final /* synthetic */ Object get() {
        return (ChatUserDataCacheContract) Preconditions.m26013a(SocialModule.m24450k(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
