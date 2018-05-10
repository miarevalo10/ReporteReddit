package com.reddit.social;

import com.reddit.datalibrary.social.data.datasource.remote.ChatRemoteDataSource;
import com.reddit.datalibrary.social.data.repo.ChatDataRepository;
import com.reddit.datalibrary.social.data.session.ChatConnectionManager;
import com.reddit.social.analytics.ChatAnalytics;
import com.reddit.social.domain.functions.ChannelConversationTransformer;
import com.reddit.social.domain.usecases.ChatInboxListUseCase;
import com.reddit.social.domain.usecases.LoadInviteUseCase;
import com.reddit.social.domain.usecases.LoadInvitesUseCase;
import com.reddit.social.domain.usecases.LoadMessagesUseCase;
import com.reddit.social.presentation.chatinbox.presentation.ChatInboxPresenter;
import com.reddit.social.presentation.chatinbox.view.ChatInboxScreen;
import com.reddit.social.presentation.chatrequests.presentation.ChatRequestListPresenter;
import com.reddit.social.presentation.chatrequests.presentation.ChatRequestPresenter;
import com.reddit.social.presentation.chatrequests.view.ChatRequestListScreen;
import com.reddit.social.presentation.chatrequests.view.ChatRequestScreen;
import com.reddit.social.presentation.contacts.presentation.ContactsPresenter;
import com.reddit.social.presentation.contacts.view.ContactsScreen;
import com.reddit.social.presentation.groupchat.presentation.GroupMembersPresenter;
import com.reddit.social.presentation.groupchat.presentation.GroupMessagingPresenter;
import com.reddit.social.presentation.groupchat.presentation.MessagingSettingsPresenter;
import com.reddit.social.presentation.groupchat.view.GroupMembersScreen;
import com.reddit.social.presentation.groupchat.view.GroupMessagingScreen;
import com.reddit.social.presentation.groupchat.view.MessagingSettingsScreen;
import javax.inject.Singleton;
import kotlin.Metadata;

@Singleton
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001dH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001fH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010$\u001a\u00020%H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010&\u001a\u00020'H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010(\u001a\u00020)H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010*\u001a\u00020+H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010,\u001a\u00020-H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010.\u001a\u00020/H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u00100\u001a\u000201H&¨\u00062"}, d2 = {"Lcom/reddit/social/SocialComponent;", "", "inject", "", "chatRemoteDataSource", "Lcom/reddit/datalibrary/social/data/datasource/remote/ChatRemoteDataSource;", "chatDataRepository", "Lcom/reddit/datalibrary/social/data/repo/ChatDataRepository;", "chatConnectionManager", "Lcom/reddit/datalibrary/social/data/session/ChatConnectionManager;", "chatAnalytics", "Lcom/reddit/social/analytics/ChatAnalytics;", "channelConversationTransformer", "Lcom/reddit/social/domain/functions/ChannelConversationTransformer;", "chatInboxListUseCase", "Lcom/reddit/social/domain/usecases/ChatInboxListUseCase;", "loadInviteUseCase", "Lcom/reddit/social/domain/usecases/LoadInviteUseCase;", "loadInvitesUseCase", "Lcom/reddit/social/domain/usecases/LoadInvitesUseCase;", "loadMessagesUseCase", "Lcom/reddit/social/domain/usecases/LoadMessagesUseCase;", "chatInboxPresenter", "Lcom/reddit/social/presentation/chatinbox/presentation/ChatInboxPresenter;", "chatInboxScreen", "Lcom/reddit/social/presentation/chatinbox/view/ChatInboxScreen;", "chatRequestListPresenter", "Lcom/reddit/social/presentation/chatrequests/presentation/ChatRequestListPresenter;", "chatRequestPresenter", "Lcom/reddit/social/presentation/chatrequests/presentation/ChatRequestPresenter;", "chatRequestListScreen", "Lcom/reddit/social/presentation/chatrequests/view/ChatRequestListScreen;", "chatRequestScreen", "Lcom/reddit/social/presentation/chatrequests/view/ChatRequestScreen;", "contactsPresenter", "Lcom/reddit/social/presentation/contacts/presentation/ContactsPresenter;", "contactsScreen", "Lcom/reddit/social/presentation/contacts/view/ContactsScreen;", "groupMembersPresenter", "Lcom/reddit/social/presentation/groupchat/presentation/GroupMembersPresenter;", "groupMessagingPresenter", "Lcom/reddit/social/presentation/groupchat/presentation/GroupMessagingPresenter;", "messageSettingsPresenter", "Lcom/reddit/social/presentation/groupchat/presentation/MessagingSettingsPresenter;", "groupMembersScreen", "Lcom/reddit/social/presentation/groupchat/view/GroupMembersScreen;", "groupMessagingScreen", "Lcom/reddit/social/presentation/groupchat/view/GroupMessagingScreen;", "messagingSettingsScreen", "Lcom/reddit/social/presentation/groupchat/view/MessagingSettingsScreen;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SocialComponent.kt */
public interface SocialComponent {
    void mo5077a(ChatRemoteDataSource chatRemoteDataSource);

    void mo5078a(ChatDataRepository chatDataRepository);

    void mo5079a(ChatConnectionManager chatConnectionManager);

    void mo5080a(ChatAnalytics chatAnalytics);

    void mo5081a(ChannelConversationTransformer channelConversationTransformer);

    void mo5082a(ChatInboxListUseCase chatInboxListUseCase);

    void mo5083a(LoadInviteUseCase loadInviteUseCase);

    void mo5084a(LoadInvitesUseCase loadInvitesUseCase);

    void mo5085a(LoadMessagesUseCase loadMessagesUseCase);

    void mo5086a(ChatInboxPresenter chatInboxPresenter);

    void mo5087a(ChatInboxScreen chatInboxScreen);

    void mo5088a(ChatRequestListPresenter chatRequestListPresenter);

    void mo5089a(ChatRequestPresenter chatRequestPresenter);

    void mo5090a(ChatRequestListScreen chatRequestListScreen);

    void mo5091a(ChatRequestScreen chatRequestScreen);

    void mo5092a(ContactsPresenter contactsPresenter);

    void mo5093a(ContactsScreen contactsScreen);

    void mo5094a(GroupMembersPresenter groupMembersPresenter);

    void mo5095a(GroupMessagingPresenter groupMessagingPresenter);

    void mo5096a(MessagingSettingsPresenter messagingSettingsPresenter);

    void mo5097a(GroupMembersScreen groupMembersScreen);

    void mo5098a(GroupMessagingScreen groupMessagingScreen);

    void mo5099a(MessagingSettingsScreen messagingSettingsScreen);
}
