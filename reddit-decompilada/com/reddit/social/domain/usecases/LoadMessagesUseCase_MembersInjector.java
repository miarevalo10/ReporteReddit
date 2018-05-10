package com.reddit.social.domain.usecases;

import com.reddit.datalibrary.social.data.repo.ChatDataRepositoryContract;
import dagger.MembersInjector;

public final class LoadMessagesUseCase_MembersInjector implements MembersInjector<LoadMessagesUseCase> {
    public static void m30624a(LoadMessagesUseCase loadMessagesUseCase, ChatDataRepositoryContract chatDataRepositoryContract) {
        loadMessagesUseCase.f22309a = chatDataRepositoryContract;
    }
}
