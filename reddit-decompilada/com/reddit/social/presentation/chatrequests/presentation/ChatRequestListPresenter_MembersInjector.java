package com.reddit.social.presentation.chatrequests.presentation;

import com.reddit.datalibrary.social.data.repo.ChatDataRepositoryContract;
import com.reddit.social.analytics.ChatAnalytics;
import com.reddit.social.domain.usecases.LoadInvitesUseCase;
import dagger.MembersInjector;

public final class ChatRequestListPresenter_MembersInjector implements MembersInjector<ChatRequestListPresenter> {
    public static void m30671a(ChatRequestListPresenter chatRequestListPresenter, ChatDataRepositoryContract chatDataRepositoryContract) {
        chatRequestListPresenter.f29642a = chatDataRepositoryContract;
    }

    public static void m30672a(ChatRequestListPresenter chatRequestListPresenter, ChatAnalytics chatAnalytics) {
        chatRequestListPresenter.f29643b = chatAnalytics;
    }

    public static void m30673a(ChatRequestListPresenter chatRequestListPresenter, LoadInvitesUseCase loadInvitesUseCase) {
        chatRequestListPresenter.f29644c = loadInvitesUseCase;
    }
}
