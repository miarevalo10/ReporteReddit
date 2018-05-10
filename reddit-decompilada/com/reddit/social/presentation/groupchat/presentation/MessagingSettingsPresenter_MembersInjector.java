package com.reddit.social.presentation.groupchat.presentation;

import com.reddit.datalibrary.social.data.repo.ChatDataRepositoryContract;
import com.reddit.social.analytics.ChatAnalytics;
import dagger.MembersInjector;

public final class MessagingSettingsPresenter_MembersInjector implements MembersInjector<MessagingSettingsPresenter> {
    public static void m30850a(MessagingSettingsPresenter messagingSettingsPresenter, ChatDataRepositoryContract chatDataRepositoryContract) {
        messagingSettingsPresenter.f29839a = chatDataRepositoryContract;
    }

    public static void m30851a(MessagingSettingsPresenter messagingSettingsPresenter, ChatAnalytics chatAnalytics) {
        messagingSettingsPresenter.f29840b = chatAnalytics;
    }
}
