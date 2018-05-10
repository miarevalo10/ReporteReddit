package com.reddit.social;

import com.reddit.datalibrary.social.data.datasource.ChatDataSourceContract;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class SocialModule_ProvideRemoteChatDataSourceFactory implements Factory<ChatDataSourceContract> {
    private final SocialModule f34580a;

    private SocialModule_ProvideRemoteChatDataSourceFactory(SocialModule socialModule) {
        this.f34580a = socialModule;
    }

    public static SocialModule_ProvideRemoteChatDataSourceFactory m35429a(SocialModule socialModule) {
        return new SocialModule_ProvideRemoteChatDataSourceFactory(socialModule);
    }

    public final /* synthetic */ Object get() {
        return (ChatDataSourceContract) Preconditions.m26013a(SocialModule.m24448i(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
