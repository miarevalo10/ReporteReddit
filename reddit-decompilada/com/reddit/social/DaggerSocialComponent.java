package com.reddit.social;

import com.reddit.datalibrary.social.data.datasource.ChatDataSourceContract;
import com.reddit.datalibrary.social.data.datasource.cache.ChatUserDataCacheContract;
import com.reddit.datalibrary.social.data.datasource.cache.FailedMessagesCacheContract;
import com.reddit.datalibrary.social.data.datasource.remote.ChatRemoteDataSource;
import com.reddit.datalibrary.social.data.datasource.remote.ChatRemoteDataSource_MembersInjector;
import com.reddit.datalibrary.social.data.repo.ChatCredentialsRepository;
import com.reddit.datalibrary.social.data.repo.ChatDataRepository;
import com.reddit.datalibrary.social.data.repo.ChatDataRepository_MembersInjector;
import com.reddit.datalibrary.social.data.session.ChatConnectionManager;
import com.reddit.datalibrary.social.data.session.ChatConnectionManager_MembersInjector;
import com.reddit.datalibrary.social.network.BaseplateClient;
import com.reddit.social.analytics.ChatAnalytics;
import com.reddit.social.analytics.ChatAnalytics_MembersInjector;
import com.reddit.social.domain.functions.ChannelConversationTransformer;
import com.reddit.social.domain.functions.ChannelConversationTransformer_MembersInjector;
import com.reddit.social.domain.usecases.ChatInboxListUseCase;
import com.reddit.social.domain.usecases.ChatInboxListUseCase_MembersInjector;
import com.reddit.social.domain.usecases.LoadInviteUseCase;
import com.reddit.social.domain.usecases.LoadInviteUseCase_MembersInjector;
import com.reddit.social.domain.usecases.LoadInvitesUseCase;
import com.reddit.social.domain.usecases.LoadInvitesUseCase_MembersInjector;
import com.reddit.social.domain.usecases.LoadMessagesUseCase;
import com.reddit.social.domain.usecases.LoadMessagesUseCase_MembersInjector;
import com.reddit.social.presentation.chatinbox.presentation.ChatInboxPresenter;
import com.reddit.social.presentation.chatinbox.presentation.ChatInboxPresenter_MembersInjector;
import com.reddit.social.presentation.chatinbox.view.ChatInboxScreen;
import com.reddit.social.presentation.chatinbox.view.ChatInboxScreen_MembersInjector;
import com.reddit.social.presentation.chatrequests.presentation.ChatRequestListPresenter;
import com.reddit.social.presentation.chatrequests.presentation.ChatRequestListPresenter_MembersInjector;
import com.reddit.social.presentation.chatrequests.presentation.ChatRequestPresenter;
import com.reddit.social.presentation.chatrequests.presentation.ChatRequestPresenter_MembersInjector;
import com.reddit.social.presentation.chatrequests.view.ChatRequestListScreen;
import com.reddit.social.presentation.chatrequests.view.ChatRequestListScreen_MembersInjector;
import com.reddit.social.presentation.chatrequests.view.ChatRequestScreen;
import com.reddit.social.presentation.chatrequests.view.ChatRequestScreen_MembersInjector;
import com.reddit.social.presentation.contacts.presentation.ContactsPresenter;
import com.reddit.social.presentation.contacts.presentation.ContactsPresenter_MembersInjector;
import com.reddit.social.presentation.contacts.view.ContactsScreen;
import com.reddit.social.presentation.contacts.view.ContactsScreen_MembersInjector;
import com.reddit.social.presentation.groupchat.presentation.GroupMembersPresenter;
import com.reddit.social.presentation.groupchat.presentation.GroupMembersPresenter_MembersInjector;
import com.reddit.social.presentation.groupchat.presentation.GroupMessagingPresenter;
import com.reddit.social.presentation.groupchat.presentation.GroupMessagingPresenter_MembersInjector;
import com.reddit.social.presentation.groupchat.presentation.MessagingSettingsPresenter;
import com.reddit.social.presentation.groupchat.presentation.MessagingSettingsPresenter_MembersInjector;
import com.reddit.social.presentation.groupchat.view.GroupMembersScreen;
import com.reddit.social.presentation.groupchat.view.GroupMembersScreen_MembersInjector;
import com.reddit.social.presentation.groupchat.view.GroupMessagingScreen;
import com.reddit.social.presentation.groupchat.view.GroupMessagingScreen_MembersInjector;
import com.reddit.social.presentation.groupchat.view.MessagingSettingsScreen;
import com.reddit.social.presentation.groupchat.view.MessagingSettingsScreen_MembersInjector;
import dagger.internal.DoubleCheck;
import javax.inject.Provider;

public final class DaggerSocialComponent implements SocialComponent {
    private SocialModule f29561a;
    private Provider<ChatDataSourceContract> f29562b;
    private Provider<ChatUserDataCacheContract> f29563c;
    private Provider<FailedMessagesCacheContract> f29564d;
    private Provider<ChatConnectionManager> f29565e;
    private Provider<BaseplateClient> f29566f;
    private Provider<ChatCredentialsRepository> f29567g;

    public static final class Builder {
        public SocialModule f22280a;

        private Builder() {
        }
    }

    private DaggerSocialComponent(Builder builder) {
        this.f29561a = builder.f22280a;
        this.f29562b = DoubleCheck.m31842a(SocialModule_ProvideRemoteChatDataSourceFactory.m35429a(builder.f22280a));
        this.f29563c = DoubleCheck.m31842a(SocialModule_ProvideChatUserDataCacheFactory.m35418a(builder.f22280a));
        this.f29564d = DoubleCheck.m31842a(SocialModule_ProvideFailedMessagesCacheFactory.m35421a(builder.f22280a));
        this.f29565e = DoubleCheck.m31842a(SocialModule_ProvideSendBirdSessionFactory.m35430a(builder.f22280a));
        this.f29566f = DoubleCheck.m31842a(SocialModule_ProvideChatAPIAccessPointFactory.m35410a(builder.f22280a));
        this.f29567g = DoubleCheck.m31842a(SocialModule_ProvideChatCredentialsRepositoryFactory.m35412a(builder.f22280a));
    }

    public static Builder m30577a() {
        return new Builder();
    }

    public final void mo5087a(ChatInboxScreen chatInboxScreen) {
        ChatInboxScreen_MembersInjector.m30658a(chatInboxScreen, SocialModule_ProvideConversationsPresenterFactory.m35420a());
        ChatInboxScreen_MembersInjector.m30656a(chatInboxScreen, SocialModule_ProvideChatAnalyticsFactory.m35411a());
        ChatInboxScreen_MembersInjector.m30657a(chatInboxScreen, SocialModule_ProvideChatPerformanceAnalyticsFactory.m35415a());
    }

    public final void mo5093a(ContactsScreen contactsScreen) {
        ContactsScreen_MembersInjector.m30758a(contactsScreen, SocialModule_ProvideContactsPresenterFactory.m35419a());
    }

    public final void mo5098a(GroupMessagingScreen groupMessagingScreen) {
        GroupMessagingScreen_MembersInjector.m30861a(groupMessagingScreen, SocialModule_ProvideGroupMessagingPresenterFactory.m35423a());
    }

    public final void mo5097a(GroupMembersScreen groupMembersScreen) {
        GroupMembersScreen_MembersInjector.m30852a(groupMembersScreen, SocialModule_ProvideGroupMembersPresenterFactory.m35422a());
    }

    public final void mo5099a(MessagingSettingsScreen messagingSettingsScreen) {
        MessagingSettingsScreen_MembersInjector.m30863a(messagingSettingsScreen, SocialModule_ProvideMessagingSettingsPresenterFactory.m35428a());
    }

    public final void mo5090a(ChatRequestListScreen chatRequestListScreen) {
        ChatRequestListScreen_MembersInjector.m30702a(chatRequestListScreen, SocialModule_ProvideChatRequestListPresenterFactory.m35416a());
    }

    public final void mo5091a(ChatRequestScreen chatRequestScreen) {
        ChatRequestScreen_MembersInjector.m30705a(chatRequestScreen, SocialModule_ProvideChatRequestPresenterFactory.m35417a());
        ChatRequestScreen_MembersInjector.m30704a(chatRequestScreen, SocialModule_ProvideChatAnalyticsFactory.m35411a());
    }

    public final void mo5078a(ChatDataRepository chatDataRepository) {
        ChatDataRepository_MembersInjector.m28836a(chatDataRepository, SocialModule_ProvideLocalChatDataSourceFactory.m35427a());
        ChatDataRepository_MembersInjector.m28833a(chatDataRepository, (ChatDataSourceContract) this.f29562b.get());
        ChatDataRepository_MembersInjector.m28834a(chatDataRepository, (ChatUserDataCacheContract) this.f29563c.get());
        ChatDataRepository_MembersInjector.m28835a(chatDataRepository, (FailedMessagesCacheContract) this.f29564d.get());
    }

    public final void mo5077a(ChatRemoteDataSource chatRemoteDataSource) {
        ChatRemoteDataSource_MembersInjector.m28769a(chatRemoteDataSource, (ChatConnectionManager) this.f29565e.get());
        ChatRemoteDataSource_MembersInjector.m28770a(chatRemoteDataSource, (BaseplateClient) this.f29566f.get());
        ChatRemoteDataSource_MembersInjector.m28771a(chatRemoteDataSource, SocialModule_ProvideChatPerformanceAnalyticsFactory.m35415a());
    }

    public final void mo5092a(ContactsPresenter contactsPresenter) {
        ContactsPresenter_MembersInjector.m30751a(contactsPresenter, SocialModule_ProvideChatDataRepositoryContractFactory.m35413a());
        ContactsPresenter_MembersInjector.m30752a(contactsPresenter, SocialModule_ProvideChatAnalyticsFactory.m35411a());
    }

    public final void mo5086a(ChatInboxPresenter chatInboxPresenter) {
        ChatInboxPresenter_MembersInjector.m30643a(chatInboxPresenter, SocialModule_ProvideChatDataRepositoryContractFactory.m35413a());
        ChatInboxPresenter_MembersInjector.m30644a(chatInboxPresenter, SocialModule_ProvideChatAnalyticsFactory.m35411a());
        ChatInboxPresenter_MembersInjector.m30646a(chatInboxPresenter, SocialModule_ProvideChatInboxListUseCaseFactory.m35414a());
        ChatInboxPresenter_MembersInjector.m30645a(chatInboxPresenter, SocialModule_ProvideChatPerformanceAnalyticsFactory.m35415a());
    }

    public final void mo5095a(GroupMessagingPresenter groupMessagingPresenter) {
        GroupMessagingPresenter_MembersInjector.m30822a(groupMessagingPresenter, SocialModule_ProvideChatDataRepositoryContractFactory.m35413a());
        GroupMessagingPresenter_MembersInjector.m30823a(groupMessagingPresenter, SocialModule_ProvideChatAnalyticsFactory.m35411a());
        GroupMessagingPresenter_MembersInjector.m30825a(groupMessagingPresenter, SocialModule_ProvideLoadMessagesUseCaseFactory.m35426a());
        GroupMessagingPresenter_MembersInjector.m30821a(groupMessagingPresenter, (FailedMessagesCacheContract) this.f29564d.get());
        GroupMessagingPresenter_MembersInjector.m30824a(groupMessagingPresenter, SocialModule_ProvideChatPerformanceAnalyticsFactory.m35415a());
    }

    public final void mo5094a(GroupMembersPresenter groupMembersPresenter) {
        GroupMembersPresenter_MembersInjector.m30770a(groupMembersPresenter, SocialModule_ProvideChatDataRepositoryContractFactory.m35413a());
        GroupMembersPresenter_MembersInjector.m30771a(groupMembersPresenter, SocialModule_ProvideChatAnalyticsFactory.m35411a());
    }

    public final void mo5096a(MessagingSettingsPresenter messagingSettingsPresenter) {
        MessagingSettingsPresenter_MembersInjector.m30850a(messagingSettingsPresenter, SocialModule_ProvideChatDataRepositoryContractFactory.m35413a());
        MessagingSettingsPresenter_MembersInjector.m30851a(messagingSettingsPresenter, SocialModule_ProvideChatAnalyticsFactory.m35411a());
    }

    public final void mo5088a(ChatRequestListPresenter chatRequestListPresenter) {
        ChatRequestListPresenter_MembersInjector.m30671a(chatRequestListPresenter, SocialModule_ProvideChatDataRepositoryContractFactory.m35413a());
        ChatRequestListPresenter_MembersInjector.m30672a(chatRequestListPresenter, SocialModule_ProvideChatAnalyticsFactory.m35411a());
        ChatRequestListPresenter_MembersInjector.m30673a(chatRequestListPresenter, SocialModule_ProvideLoadInvitesUseCaseFactory.m35425a());
    }

    public final void mo5089a(ChatRequestPresenter chatRequestPresenter) {
        ChatRequestPresenter_MembersInjector.m30693a(chatRequestPresenter, SocialModule_ProvideChatDataRepositoryContractFactory.m35413a());
        ChatRequestPresenter_MembersInjector.m30694a(chatRequestPresenter, SocialModule_ProvideChatAnalyticsFactory.m35411a());
        ChatRequestPresenter_MembersInjector.m30695a(chatRequestPresenter, SocialModule_ProvideLoadInviteUseCaseFactory.m35424a());
        ChatRequestPresenter_MembersInjector.m30696a(chatRequestPresenter, SocialModule_ProvideLoadMessagesUseCaseFactory.m35426a());
    }

    public final void mo5079a(ChatConnectionManager chatConnectionManager) {
        ChatConnectionManager_MembersInjector.m28842a(chatConnectionManager, (ChatCredentialsRepository) this.f29567g.get());
    }

    public final void mo5080a(ChatAnalytics chatAnalytics) {
        ChatAnalytics_MembersInjector.m30601a(chatAnalytics, SocialModule_ProvideChatDataRepositoryContractFactory.m35413a());
        ChatAnalytics_MembersInjector.m30602a(chatAnalytics, SocialModule_ProvideChatInboxListUseCaseFactory.m35414a());
        ChatAnalytics_MembersInjector.m30603a(chatAnalytics, SocialModule_ProvideLoadInviteUseCaseFactory.m35424a());
        ChatAnalytics_MembersInjector.m30604a(chatAnalytics, SocialModule_ProvideLoadMessagesUseCaseFactory.m35426a());
    }

    public final void mo5082a(ChatInboxListUseCase chatInboxListUseCase) {
        ChatInboxListUseCase_MembersInjector.m30621a(chatInboxListUseCase, SocialModule_ProvideChatDataRepositoryContractFactory.m35413a());
    }

    public final void mo5083a(LoadInviteUseCase loadInviteUseCase) {
        LoadInviteUseCase_MembersInjector.m30622a(loadInviteUseCase, SocialModule_ProvideChatDataRepositoryContractFactory.m35413a());
    }

    public final void mo5084a(LoadInvitesUseCase loadInvitesUseCase) {
        LoadInvitesUseCase_MembersInjector.m30623a(loadInvitesUseCase, SocialModule_ProvideChatDataRepositoryContractFactory.m35413a());
    }

    public final void mo5085a(LoadMessagesUseCase loadMessagesUseCase) {
        LoadMessagesUseCase_MembersInjector.m30624a(loadMessagesUseCase, SocialModule_ProvideChatDataRepositoryContractFactory.m35413a());
    }

    public final void mo5081a(ChannelConversationTransformer channelConversationTransformer) {
        ChannelConversationTransformer_MembersInjector.m30615a(channelConversationTransformer, (FailedMessagesCacheContract) this.f29564d.get());
    }
}
