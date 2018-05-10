package com.reddit.social;

import com.reddit.social.domain.usecases.ChatInboxListUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class SocialModule_ProvideChatInboxListUseCaseFactory implements Factory<ChatInboxListUseCase> {
    public static ChatInboxListUseCase m35414a() {
        return (ChatInboxListUseCase) Preconditions.m26013a(SocialModule.m24456q(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return (ChatInboxListUseCase) Preconditions.m26013a(SocialModule.m24456q(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
