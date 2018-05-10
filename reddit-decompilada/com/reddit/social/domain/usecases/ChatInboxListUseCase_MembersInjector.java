package com.reddit.social.domain.usecases;

import com.reddit.datalibrary.social.data.repo.ChatDataRepositoryContract;
import dagger.MembersInjector;

public final class ChatInboxListUseCase_MembersInjector implements MembersInjector<ChatInboxListUseCase> {
    public static void m30621a(ChatInboxListUseCase chatInboxListUseCase, ChatDataRepositoryContract chatDataRepositoryContract) {
        chatInboxListUseCase.f22306a = chatDataRepositoryContract;
    }
}
