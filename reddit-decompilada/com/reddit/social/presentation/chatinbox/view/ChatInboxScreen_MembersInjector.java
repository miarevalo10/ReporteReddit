package com.reddit.social.presentation.chatinbox.view;

import com.reddit.social.analytics.ChatAnalytics;
import com.reddit.social.analytics.ChatPerformanceAnalyticsContract;
import com.reddit.social.presentation.chatinbox.ChatInboxContract.Presenter;
import dagger.MembersInjector;

public final class ChatInboxScreen_MembersInjector implements MembersInjector<ChatInboxScreen> {
    public static void m30658a(ChatInboxScreen chatInboxScreen, Presenter presenter) {
        chatInboxScreen.f40186v = presenter;
    }

    public static void m30656a(ChatInboxScreen chatInboxScreen, ChatAnalytics chatAnalytics) {
        chatInboxScreen.f40187w = chatAnalytics;
    }

    public static void m30657a(ChatInboxScreen chatInboxScreen, ChatPerformanceAnalyticsContract chatPerformanceAnalyticsContract) {
        chatInboxScreen.f40188x = chatPerformanceAnalyticsContract;
    }
}
