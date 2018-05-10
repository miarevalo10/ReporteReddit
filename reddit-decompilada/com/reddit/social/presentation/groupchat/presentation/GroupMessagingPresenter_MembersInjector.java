package com.reddit.social.presentation.groupchat.presentation;

import com.reddit.datalibrary.social.data.datasource.cache.FailedMessagesCacheContract;
import com.reddit.datalibrary.social.data.repo.ChatDataRepositoryContract;
import com.reddit.social.analytics.ChatAnalytics;
import com.reddit.social.analytics.ChatPerformanceAnalyticsContract;
import com.reddit.social.domain.usecases.LoadMessagesUseCase;
import dagger.MembersInjector;

public final class GroupMessagingPresenter_MembersInjector implements MembersInjector<GroupMessagingPresenter> {
    public static void m30822a(GroupMessagingPresenter groupMessagingPresenter, ChatDataRepositoryContract chatDataRepositoryContract) {
        groupMessagingPresenter.f29796b = chatDataRepositoryContract;
    }

    public static void m30823a(GroupMessagingPresenter groupMessagingPresenter, ChatAnalytics chatAnalytics) {
        groupMessagingPresenter.f29797c = chatAnalytics;
    }

    public static void m30825a(GroupMessagingPresenter groupMessagingPresenter, LoadMessagesUseCase loadMessagesUseCase) {
        groupMessagingPresenter.f29798d = loadMessagesUseCase;
    }

    public static void m30821a(GroupMessagingPresenter groupMessagingPresenter, FailedMessagesCacheContract failedMessagesCacheContract) {
        groupMessagingPresenter.f29799e = failedMessagesCacheContract;
    }

    public static void m30824a(GroupMessagingPresenter groupMessagingPresenter, ChatPerformanceAnalyticsContract chatPerformanceAnalyticsContract) {
        groupMessagingPresenter.f29800f = chatPerformanceAnalyticsContract;
    }
}
