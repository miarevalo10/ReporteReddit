package com.reddit.social.presentation.chatrequests.view;

import com.reddit.social.analytics.ChatAnalytics;
import com.reddit.social.presentation.chatrequests.ChatRequestContract.Presenter;
import dagger.MembersInjector;

public final class ChatRequestScreen_MembersInjector implements MembersInjector<ChatRequestScreen> {
    public static void m30705a(ChatRequestScreen chatRequestScreen, Presenter presenter) {
        chatRequestScreen.f40197v = presenter;
    }

    public static void m30704a(ChatRequestScreen chatRequestScreen, ChatAnalytics chatAnalytics) {
        chatRequestScreen.f40198w = chatAnalytics;
    }
}
