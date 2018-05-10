package com.reddit.social.analytics;

import com.reddit.datalibrary.social.data.repo.ChatDataRepositoryContract;
import com.reddit.social.domain.usecases.ChatInboxListUseCase;
import com.reddit.social.domain.usecases.LoadInviteUseCase;
import com.reddit.social.domain.usecases.LoadMessagesUseCase;
import dagger.MembersInjector;

public final class ChatAnalytics_MembersInjector implements MembersInjector<ChatAnalytics> {
    public static void m30601a(ChatAnalytics chatAnalytics, ChatDataRepositoryContract chatDataRepositoryContract) {
        chatAnalytics.f22291a = chatDataRepositoryContract;
    }

    public static void m30602a(ChatAnalytics chatAnalytics, ChatInboxListUseCase chatInboxListUseCase) {
        chatAnalytics.f22292b = chatInboxListUseCase;
    }

    public static void m30603a(ChatAnalytics chatAnalytics, LoadInviteUseCase loadInviteUseCase) {
        chatAnalytics.f22293c = loadInviteUseCase;
    }

    public static void m30604a(ChatAnalytics chatAnalytics, LoadMessagesUseCase loadMessagesUseCase) {
        chatAnalytics.f22294d = loadMessagesUseCase;
    }
}
