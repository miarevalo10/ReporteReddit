package com.reddit.social;

import com.reddit.datalibrary.social.data.datasource.local.ChatDiscDataSource;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class SocialModule_ProvideLocalChatDataSourceFactory implements Factory<ChatDiscDataSource> {
    public static ChatDiscDataSource m35427a() {
        return (ChatDiscDataSource) Preconditions.m26013a(SocialModule.m24449j(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return (ChatDiscDataSource) Preconditions.m26013a(SocialModule.m24449j(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
