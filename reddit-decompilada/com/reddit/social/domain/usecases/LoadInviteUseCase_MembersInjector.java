package com.reddit.social.domain.usecases;

import com.reddit.datalibrary.social.data.repo.ChatDataRepositoryContract;
import dagger.MembersInjector;

public final class LoadInviteUseCase_MembersInjector implements MembersInjector<LoadInviteUseCase> {
    public static void m30622a(LoadInviteUseCase loadInviteUseCase, ChatDataRepositoryContract chatDataRepositoryContract) {
        loadInviteUseCase.f22307a = chatDataRepositoryContract;
    }
}
