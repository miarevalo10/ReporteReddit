package com.reddit.datalibrary.social.data.datasource.remote;

import com.reddit.datalibrary.social.data.session.ChatConnectionManager;
import com.reddit.datalibrary.social.network.BaseplateClient;
import com.reddit.social.analytics.ChatPerformanceAnalyticsContract;
import dagger.MembersInjector;

public final class ChatRemoteDataSource_MembersInjector implements MembersInjector<ChatRemoteDataSource> {
    public static void m28769a(ChatRemoteDataSource chatRemoteDataSource, ChatConnectionManager chatConnectionManager) {
        chatRemoteDataSource.f33461a = chatConnectionManager;
    }

    public static void m28770a(ChatRemoteDataSource chatRemoteDataSource, BaseplateClient baseplateClient) {
        chatRemoteDataSource.f33462b = baseplateClient;
    }

    public static void m28771a(ChatRemoteDataSource chatRemoteDataSource, ChatPerformanceAnalyticsContract chatPerformanceAnalyticsContract) {
        chatRemoteDataSource.f33463c = chatPerformanceAnalyticsContract;
    }
}
