package com.reddit.datalibrary.social.data.repo;

import com.reddit.datalibrary.social.data.datasource.ChatDataSourceContract;
import com.reddit.datalibrary.social.data.datasource.cache.ChatUserDataCacheContract;
import com.reddit.datalibrary.social.data.datasource.cache.FailedMessagesCacheContract;
import com.reddit.datalibrary.social.data.datasource.local.ChatDiscDataSource;
import dagger.MembersInjector;

public final class ChatDataRepository_MembersInjector implements MembersInjector<ChatDataRepository> {
    public static void m28836a(ChatDataRepository chatDataRepository, ChatDiscDataSource chatDiscDataSource) {
        chatDataRepository.f27362a = chatDiscDataSource;
    }

    public static void m28833a(ChatDataRepository chatDataRepository, ChatDataSourceContract chatDataSourceContract) {
        chatDataRepository.f27363b = chatDataSourceContract;
    }

    public static void m28834a(ChatDataRepository chatDataRepository, ChatUserDataCacheContract chatUserDataCacheContract) {
        chatDataRepository.f27364c = chatUserDataCacheContract;
    }

    public static void m28835a(ChatDataRepository chatDataRepository, FailedMessagesCacheContract failedMessagesCacheContract) {
        chatDataRepository.f27365d = failedMessagesCacheContract;
    }
}
