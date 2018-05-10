package com.reddit.social;

import com.reddit.datalibrary.social.data.datasource.cache.FailedMessagesCacheContract;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class SocialModule_ProvideFailedMessagesCacheFactory implements Factory<FailedMessagesCacheContract> {
    private final SocialModule f34579a;

    private SocialModule_ProvideFailedMessagesCacheFactory(SocialModule socialModule) {
        this.f34579a = socialModule;
    }

    public static SocialModule_ProvideFailedMessagesCacheFactory m35421a(SocialModule socialModule) {
        return new SocialModule_ProvideFailedMessagesCacheFactory(socialModule);
    }

    public final /* synthetic */ Object get() {
        return (FailedMessagesCacheContract) Preconditions.m26013a(SocialModule.m24451l(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
