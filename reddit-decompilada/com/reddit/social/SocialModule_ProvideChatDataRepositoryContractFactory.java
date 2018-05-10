package com.reddit.social;

import com.reddit.datalibrary.social.data.repo.ChatDataRepositoryContract;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class SocialModule_ProvideChatDataRepositoryContractFactory implements Factory<ChatDataRepositoryContract> {
    public static ChatDataRepositoryContract m35413a() {
        return (ChatDataRepositoryContract) Preconditions.m26013a(SocialModule.m24452m(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return (ChatDataRepositoryContract) Preconditions.m26013a(SocialModule.m24452m(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
