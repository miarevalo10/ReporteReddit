package com.reddit.social.domain.usecases;

import com.reddit.datalibrary.social.data.repo.ChatDataRepositoryContract;
import dagger.MembersInjector;

public final class LoadInvitesUseCase_MembersInjector implements MembersInjector<LoadInvitesUseCase> {
    public static void m30623a(LoadInvitesUseCase loadInvitesUseCase, ChatDataRepositoryContract chatDataRepositoryContract) {
        loadInvitesUseCase.f22308a = chatDataRepositoryContract;
    }
}
