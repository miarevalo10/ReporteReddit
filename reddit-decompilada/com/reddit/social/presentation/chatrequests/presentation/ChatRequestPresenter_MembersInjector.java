package com.reddit.social.presentation.chatrequests.presentation;

import com.reddit.datalibrary.social.data.repo.ChatDataRepositoryContract;
import com.reddit.social.analytics.ChatAnalytics;
import com.reddit.social.domain.usecases.LoadInviteUseCase;
import com.reddit.social.domain.usecases.LoadMessagesUseCase;
import dagger.MembersInjector;

public final class ChatRequestPresenter_MembersInjector implements MembersInjector<ChatRequestPresenter> {
    public static void m30693a(ChatRequestPresenter chatRequestPresenter, ChatDataRepositoryContract chatDataRepositoryContract) {
        chatRequestPresenter.f29659a = chatDataRepositoryContract;
    }

    public static void m30694a(ChatRequestPresenter chatRequestPresenter, ChatAnalytics chatAnalytics) {
        chatRequestPresenter.f29660b = chatAnalytics;
    }

    public static void m30695a(ChatRequestPresenter chatRequestPresenter, LoadInviteUseCase loadInviteUseCase) {
        chatRequestPresenter.f29661c = loadInviteUseCase;
    }

    public static void m30696a(ChatRequestPresenter chatRequestPresenter, LoadMessagesUseCase loadMessagesUseCase) {
        chatRequestPresenter.f29662d = loadMessagesUseCase;
    }
}
