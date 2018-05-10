package com.reddit.social.presentation.chatinbox.presentation;

import com.reddit.datalibrary.social.data.repo.ChatDataRepositoryContract;
import com.reddit.social.analytics.ChatAnalytics;
import com.reddit.social.analytics.ChatPerformanceAnalyticsContract;
import com.reddit.social.domain.usecases.ChatInboxListUseCase;
import dagger.MembersInjector;

public final class ChatInboxPresenter_MembersInjector implements MembersInjector<ChatInboxPresenter> {
    public static void m30643a(ChatInboxPresenter chatInboxPresenter, ChatDataRepositoryContract chatDataRepositoryContract) {
        chatInboxPresenter.f29614a = chatDataRepositoryContract;
    }

    public static void m30644a(ChatInboxPresenter chatInboxPresenter, ChatAnalytics chatAnalytics) {
        chatInboxPresenter.f29615b = chatAnalytics;
    }

    public static void m30646a(ChatInboxPresenter chatInboxPresenter, ChatInboxListUseCase chatInboxListUseCase) {
        chatInboxPresenter.f29616c = chatInboxListUseCase;
    }

    public static void m30645a(ChatInboxPresenter chatInboxPresenter, ChatPerformanceAnalyticsContract chatPerformanceAnalyticsContract) {
        chatInboxPresenter.f29617d = chatPerformanceAnalyticsContract;
    }
}
