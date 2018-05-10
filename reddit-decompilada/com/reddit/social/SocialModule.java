package com.reddit.social;

import com.reddit.datalibrary.social.data.datasource.ChatDataSourceContract;
import com.reddit.datalibrary.social.data.datasource.cache.ChatUserDataCache;
import com.reddit.datalibrary.social.data.datasource.cache.ChatUserDataCacheContract;
import com.reddit.datalibrary.social.data.datasource.cache.FailedMessagesCache;
import com.reddit.datalibrary.social.data.datasource.cache.FailedMessagesCacheContract;
import com.reddit.datalibrary.social.data.datasource.local.ChatDiscDataSource;
import com.reddit.datalibrary.social.data.datasource.remote.ChatRemoteDataSource;
import com.reddit.datalibrary.social.data.repo.ChatCredentialsRepository;
import com.reddit.datalibrary.social.data.repo.ChatDataRepository;
import com.reddit.datalibrary.social.data.repo.ChatDataRepositoryContract;
import com.reddit.datalibrary.social.data.session.ChatConnectionManager;
import com.reddit.datalibrary.social.data.session.ChatConnectionManager.Companion;
import com.reddit.datalibrary.social.network.BaseplateClient;
import com.reddit.social.analytics.ChatAnalytics;
import com.reddit.social.analytics.ChatPerformanceAnalytics;
import com.reddit.social.analytics.ChatPerformanceAnalyticsContract;
import com.reddit.social.domain.usecases.ChatInboxListUseCase;
import com.reddit.social.domain.usecases.LoadInviteUseCase;
import com.reddit.social.domain.usecases.LoadInvitesUseCase;
import com.reddit.social.domain.usecases.LoadMessagesUseCase;
import com.reddit.social.presentation.chatinbox.ChatInboxContract.Presenter;
import com.reddit.social.presentation.chatinbox.presentation.ChatInboxPresenter;
import com.reddit.social.presentation.chatrequests.ChatRequestContract;
import com.reddit.social.presentation.chatrequests.ChatRequestListContract;
import com.reddit.social.presentation.chatrequests.presentation.ChatRequestListPresenter;
import com.reddit.social.presentation.chatrequests.presentation.ChatRequestPresenter;
import com.reddit.social.presentation.contacts.ContactsContract;
import com.reddit.social.presentation.contacts.presentation.ContactsPresenter;
import com.reddit.social.presentation.groupchat.ChatContract;
import com.reddit.social.presentation.groupchat.ChatSettingsContract;
import com.reddit.social.presentation.groupchat.GroupMembersContract;
import com.reddit.social.presentation.groupchat.presentation.GroupMembersPresenter;
import com.reddit.social.presentation.groupchat.presentation.GroupMessagingPresenter;
import com.reddit.social.presentation.groupchat.presentation.MessagingSettingsPresenter;
import javax.inject.Singleton;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\r\u001a\u00020\u000eH\u0007J\b\u0010\u000f\u001a\u00020\u0010H\u0007J\b\u0010\u0011\u001a\u00020\u0012H\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0007J\b\u0010\u0015\u001a\u00020\u0016H\u0007J\b\u0010\u0017\u001a\u00020\u0018H\u0007J\b\u0010\u0019\u001a\u00020\u001aH\u0007J\b\u0010\u001b\u001a\u00020\u001cH\u0007J\b\u0010\u001d\u001a\u00020\u001eH\u0007J\b\u0010\u001f\u001a\u00020 H\u0007J\b\u0010!\u001a\u00020\"H\u0007J\b\u0010#\u001a\u00020$H\u0007J\b\u0010%\u001a\u00020&H\u0007J\b\u0010'\u001a\u00020(H\u0007J\b\u0010)\u001a\u00020*H\u0007J\b\u0010+\u001a\u00020,H\u0007¨\u0006-"}, d2 = {"Lcom/reddit/social/SocialModule;", "", "()V", "provideChatAPIAccessPoint", "Lcom/reddit/datalibrary/social/network/BaseplateClient;", "provideChatAnalytics", "Lcom/reddit/social/analytics/ChatAnalytics;", "provideChatCredentialsRepository", "Lcom/reddit/datalibrary/social/data/repo/ChatCredentialsRepository;", "provideChatDataRepositoryContract", "Lcom/reddit/datalibrary/social/data/repo/ChatDataRepositoryContract;", "provideChatInboxListUseCase", "Lcom/reddit/social/domain/usecases/ChatInboxListUseCase;", "provideChatPerformanceAnalytics", "Lcom/reddit/social/analytics/ChatPerformanceAnalyticsContract;", "provideChatRequestListPresenter", "Lcom/reddit/social/presentation/chatrequests/ChatRequestListContract$Presenter;", "provideChatRequestPresenter", "Lcom/reddit/social/presentation/chatrequests/ChatRequestContract$Presenter;", "provideChatUserDataCache", "Lcom/reddit/datalibrary/social/data/datasource/cache/ChatUserDataCacheContract;", "provideContactsPresenter", "Lcom/reddit/social/presentation/contacts/ContactsContract$Presenter;", "provideConversationsPresenter", "Lcom/reddit/social/presentation/chatinbox/ChatInboxContract$Presenter;", "provideFailedMessagesCache", "Lcom/reddit/datalibrary/social/data/datasource/cache/FailedMessagesCacheContract;", "provideGroupMembersPresenter", "Lcom/reddit/social/presentation/groupchat/GroupMembersContract$Presenter;", "provideGroupMessagingPresenter", "Lcom/reddit/social/presentation/groupchat/ChatContract$Presenter;", "provideLoadInviteUseCase", "Lcom/reddit/social/domain/usecases/LoadInviteUseCase;", "provideLoadInvitesUseCase", "Lcom/reddit/social/domain/usecases/LoadInvitesUseCase;", "provideLoadMessagesUseCase", "Lcom/reddit/social/domain/usecases/LoadMessagesUseCase;", "provideLocalChatDataSource", "Lcom/reddit/datalibrary/social/data/datasource/local/ChatDiscDataSource;", "provideMessagingSettingsPresenter", "Lcom/reddit/social/presentation/groupchat/ChatSettingsContract$Presenter;", "provideRemoteChatDataSource", "Lcom/reddit/datalibrary/social/data/datasource/ChatDataSourceContract;", "provideSendBirdSession", "Lcom/reddit/datalibrary/social/data/session/ChatConnectionManager;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SocialModule.kt */
public final class SocialModule {
    public static Presenter m24440a() {
        return new ChatInboxPresenter();
    }

    public static ContactsContract.Presenter m24441b() {
        return new ContactsPresenter();
    }

    public static ChatContract.Presenter m24442c() {
        return new GroupMessagingPresenter();
    }

    public static ChatSettingsContract.Presenter m24443d() {
        return new MessagingSettingsPresenter();
    }

    public static GroupMembersContract.Presenter m24444e() {
        return new GroupMembersPresenter();
    }

    public static ChatRequestListContract.Presenter m24445f() {
        return new ChatRequestListPresenter();
    }

    public static ChatRequestContract.Presenter m24446g() {
        return new ChatRequestPresenter();
    }

    @Singleton
    public static ChatConnectionManager m24447h() {
        Companion companion = ChatConnectionManager.f19854b;
        return Companion.m21750a();
    }

    @Singleton
    public static ChatDataSourceContract m24448i() {
        return new ChatRemoteDataSource();
    }

    public static ChatDiscDataSource m24449j() {
        return new ChatDiscDataSource();
    }

    @Singleton
    public static ChatUserDataCacheContract m24450k() {
        return new ChatUserDataCache();
    }

    @Singleton
    public static FailedMessagesCacheContract m24451l() {
        return new FailedMessagesCache();
    }

    public static ChatDataRepositoryContract m24452m() {
        return new ChatDataRepository();
    }

    @Singleton
    public static BaseplateClient m24453n() {
        return new BaseplateClient();
    }

    @Singleton
    public static ChatCredentialsRepository m24454o() {
        return new ChatCredentialsRepository();
    }

    public static ChatAnalytics m24455p() {
        return new ChatAnalytics();
    }

    public static ChatInboxListUseCase m24456q() {
        return new ChatInboxListUseCase();
    }

    public static LoadInviteUseCase m24457r() {
        return new LoadInviteUseCase();
    }

    public static LoadInvitesUseCase m24458s() {
        return new LoadInvitesUseCase();
    }

    public static LoadMessagesUseCase m24459t() {
        return new LoadMessagesUseCase();
    }

    public static ChatPerformanceAnalyticsContract m24460u() {
        return new ChatPerformanceAnalytics();
    }
}
