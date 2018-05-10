package com.reddit.frontpage.di.component;

import com.reddit.datalibrary.frontpage.data.feature.account.datasource.local.AccountStorage;
import com.reddit.datalibrary.frontpage.data.feature.account.datasource.local.AccountStorage_MembersInjector;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.ApiLinkDataSourceLegacy;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.ApiLinkDataSourceLegacy_MembersInjector;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.LegacyApiSubredditDataSource;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.LegacyApiSubredditDataSource_MembersInjector;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteGatewayDataSource;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteWebSocketDataSource;
import com.reddit.datalibrary.frontpage.data.provider.CombinedSearchProvider;
import com.reddit.datalibrary.frontpage.data.provider.CombinedSearchProvider_MembersInjector;
import com.reddit.datalibrary.frontpage.data.provider.CommentListingProvider;
import com.reddit.datalibrary.frontpage.data.provider.CommentListingProvider_MembersInjector;
import com.reddit.datalibrary.frontpage.data.provider.CommentsProvider;
import com.reddit.datalibrary.frontpage.data.provider.CommentsProvider_MembersInjector;
import com.reddit.datalibrary.frontpage.data.provider.FlairProvider;
import com.reddit.datalibrary.frontpage.data.provider.FlairProvider_MembersInjector;
import com.reddit.datalibrary.frontpage.data.provider.InboxFilterableListingProvider;
import com.reddit.datalibrary.frontpage.data.provider.InboxFilterableListingProvider_MembersInjector;
import com.reddit.datalibrary.frontpage.data.provider.LinkSearchListingProvider;
import com.reddit.datalibrary.frontpage.data.provider.LinkSearchListingProvider_MembersInjector;
import com.reddit.datalibrary.frontpage.data.provider.LiveUpdateProvider;
import com.reddit.datalibrary.frontpage.data.provider.LiveUpdateProvider_MembersInjector;
import com.reddit.datalibrary.frontpage.data.provider.MessageListingProvider;
import com.reddit.datalibrary.frontpage.data.provider.MessageListingProvider_MembersInjector;
import com.reddit.datalibrary.frontpage.data.provider.MessageThreadProvider;
import com.reddit.datalibrary.frontpage.data.provider.MessageThreadProvider_MembersInjector;
import com.reddit.datalibrary.frontpage.data.provider.SavedListingProvider;
import com.reddit.datalibrary.frontpage.data.provider.SavedListingProvider_MembersInjector;
import com.reddit.datalibrary.frontpage.data.provider.SubredditSearchListingProvider;
import com.reddit.datalibrary.frontpage.data.provider.SubredditSearchListingProvider_MembersInjector;
import com.reddit.datalibrary.frontpage.service.api.ComposeService;
import com.reddit.datalibrary.frontpage.service.api.ComposeService_MembersInjector;
import com.reddit.datalibrary.frontpage.service.api.ReplyService;
import com.reddit.datalibrary.frontpage.service.api.ReplyService_MembersInjector;
import com.reddit.datalibrary.frontpage.service.api.SubmitService;
import com.reddit.datalibrary.frontpage.service.api.SubmitService_MembersInjector;
import com.reddit.datalibrary.frontpage.service.api.UploadService;
import com.reddit.datalibrary.frontpage.service.api.UploadService_MembersInjector;
import com.reddit.datalibrary.frontpage.service.api.VideoUploadService;
import com.reddit.datalibrary.frontpage.service.api.VideoUploadService_MembersInjector;
import com.reddit.frontpage.di.module.ApiClientModule;
import com.reddit.frontpage.di.module.ApiClientModule_ProvideRemoteGatewayDataSourceFactory;
import com.reddit.frontpage.di.module.ApiClientModule_ProvideRemoteRedditApiDataSourceFactory;
import com.reddit.frontpage.di.module.ApiClientModule_ProvideRemoteWebsocketDataSourceFactory;
import com.reddit.frontpage.di.module.NetworkModule;
import com.reddit.frontpage.di.module.NetworkModule_GatewayRetrofitClientFactory;
import com.reddit.frontpage.di.module.NetworkModule_OauthHttpClientFactory;
import com.reddit.frontpage.service.sync.PreferencesSyncService;
import com.reddit.frontpage.service.sync.PreferencesSyncService_MembersInjector;
import com.reddit.frontpage.sync.routine.AppConfigSyncRoutine;
import com.reddit.frontpage.sync.routine.AppConfigSyncRoutine_MembersInjector;
import com.reddit.frontpage.sync.routine.UserSyncRoutine;
import com.reddit.frontpage.sync.routine.UserSyncRoutine_MembersInjector;
import com.reddit.frontpage.ui.inbox.InboxPagerScreen;
import com.reddit.frontpage.ui.inbox.InboxPagerScreen_MembersInjector;
import com.reddit.frontpage.ui.live.LiveUpdatesFragment;
import com.reddit.frontpage.ui.live.LiveUpdatesFragment_MembersInjector;
import com.reddit.social.presentation.messaginglist.content.RedditImageMessageContent;
import com.reddit.social.presentation.messaginglist.content.RedditImageMessageContent_MembersInjector;
import dagger.internal.DoubleCheck;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public final class DaggerApiClientComponent implements ApiClientComponent {
    private Provider<OkHttpClient> f27507a;
    private Provider<Retrofit> f27508b;
    private Provider<RemoteGatewayDataSource> f27509c;
    private Provider<RemoteRedditApiDataSource> f27510d;
    private Provider<RemoteWebSocketDataSource> f27511e;

    public static final class Builder {
        public NetworkModule f20156a;
        public ApiClientModule f20157b;

        private Builder() {
        }
    }

    private DaggerApiClientComponent(Builder builder) {
        this.f27507a = DoubleCheck.m31842a(NetworkModule_OauthHttpClientFactory.m34508a(builder.f20156a));
        this.f27508b = DoubleCheck.m31842a(NetworkModule_GatewayRetrofitClientFactory.m34507a(builder.f20156a, this.f27507a));
        this.f27509c = DoubleCheck.m31842a(ApiClientModule_ProvideRemoteGatewayDataSourceFactory.m34457a(builder.f20157b, this.f27508b));
        this.f27510d = DoubleCheck.m31842a(ApiClientModule_ProvideRemoteRedditApiDataSourceFactory.m34458a(builder.f20157b));
        this.f27511e = DoubleCheck.m31842a(ApiClientModule_ProvideRemoteWebsocketDataSourceFactory.m34459a(builder.f20157b));
    }

    public static Builder m29002a() {
        return new Builder();
    }

    public final void mo4605a(AppConfigSyncRoutine appConfigSyncRoutine) {
        AppConfigSyncRoutine_MembersInjector.m29923a(appConfigSyncRoutine, (RemoteGatewayDataSource) this.f27509c.get());
    }

    public final void mo4609a(RedditImageMessageContent redditImageMessageContent) {
        RedditImageMessageContent_MembersInjector.m30883a(redditImageMessageContent, (RemoteRedditApiDataSource) this.f27510d.get());
    }

    public final void mo4586a(ApiLinkDataSourceLegacy apiLinkDataSourceLegacy) {
        ApiLinkDataSourceLegacy_MembersInjector.a(apiLinkDataSourceLegacy, (RemoteRedditApiDataSource) this.f27510d.get());
    }

    public final void mo4587a(LegacyApiSubredditDataSource legacyApiSubredditDataSource) {
        LegacyApiSubredditDataSource_MembersInjector.a(legacyApiSubredditDataSource, (RemoteRedditApiDataSource) this.f27510d.get());
    }

    public final void mo4594a(LiveUpdateProvider liveUpdateProvider) {
        LiveUpdateProvider_MembersInjector.a(liveUpdateProvider, (RemoteRedditApiDataSource) this.f27510d.get());
    }

    public final void mo4590a(CommentsProvider commentsProvider) {
        CommentsProvider_MembersInjector.a(commentsProvider, (RemoteRedditApiDataSource) this.f27510d.get());
        CommentsProvider_MembersInjector.a(commentsProvider, (RemoteWebSocketDataSource) this.f27511e.get());
    }

    public final void mo4592a(InboxFilterableListingProvider inboxFilterableListingProvider) {
        MessageListingProvider_MembersInjector.a(inboxFilterableListingProvider, (RemoteRedditApiDataSource) this.f27510d.get());
        InboxFilterableListingProvider_MembersInjector.a(inboxFilterableListingProvider, (RemoteRedditApiDataSource) this.f27510d.get());
    }

    public final void mo4595a(MessageListingProvider messageListingProvider) {
        MessageListingProvider_MembersInjector.a(messageListingProvider, (RemoteRedditApiDataSource) this.f27510d.get());
    }

    public final void mo4596a(MessageThreadProvider messageThreadProvider) {
        MessageThreadProvider_MembersInjector.a(messageThreadProvider, (RemoteRedditApiDataSource) this.f27510d.get());
    }

    public final void mo4597a(SavedListingProvider savedListingProvider) {
        SavedListingProvider_MembersInjector.a(savedListingProvider, (RemoteRedditApiDataSource) this.f27510d.get());
    }

    public final void mo4585a(AccountStorage accountStorage) {
        AccountStorage_MembersInjector.a(accountStorage, (RemoteRedditApiDataSource) this.f27510d.get());
    }

    public final void mo4604a(PreferencesSyncService preferencesSyncService) {
        PreferencesSyncService_MembersInjector.m29917a(preferencesSyncService, (RemoteRedditApiDataSource) this.f27510d.get());
    }

    public final void mo4603a(VideoUploadService videoUploadService) {
        VideoUploadService_MembersInjector.injectRemoteRedditApiDataSource(videoUploadService, (RemoteRedditApiDataSource) this.f27510d.get());
    }

    public final void mo4589a(CommentListingProvider commentListingProvider) {
        CommentListingProvider_MembersInjector.a(commentListingProvider, (RemoteRedditApiDataSource) this.f27510d.get());
    }

    public final void mo4588a(CombinedSearchProvider combinedSearchProvider) {
        CombinedSearchProvider_MembersInjector.a(combinedSearchProvider, (RemoteRedditApiDataSource) this.f27510d.get());
    }

    public final void mo4598a(SubredditSearchListingProvider subredditSearchListingProvider) {
        SubredditSearchListingProvider_MembersInjector.a(subredditSearchListingProvider, (RemoteRedditApiDataSource) this.f27510d.get());
    }

    public final void mo4593a(LinkSearchListingProvider linkSearchListingProvider) {
        LinkSearchListingProvider_MembersInjector.a(linkSearchListingProvider, (RemoteRedditApiDataSource) this.f27510d.get());
    }

    public final void mo4601a(SubmitService submitService) {
        SubmitService_MembersInjector.injectRemoteRedditApiDataSource(submitService, (RemoteRedditApiDataSource) this.f27510d.get());
        SubmitService_MembersInjector.injectRemoteWebSocketDataSource(submitService, (RemoteWebSocketDataSource) this.f27511e.get());
    }

    public final void mo4602a(UploadService uploadService) {
        UploadService_MembersInjector.injectRemoteRedditApiDataSource(uploadService, (RemoteRedditApiDataSource) this.f27510d.get());
    }

    public final void mo4600a(ReplyService replyService) {
        ReplyService_MembersInjector.injectRemoteRedditApiDataSource(replyService, (RemoteRedditApiDataSource) this.f27510d.get());
    }

    public final void mo4591a(FlairProvider flairProvider) {
        FlairProvider_MembersInjector.a(flairProvider, (RemoteRedditApiDataSource) this.f27510d.get());
    }

    public final void mo4608a(LiveUpdatesFragment liveUpdatesFragment) {
        LiveUpdatesFragment_MembersInjector.m30284a(liveUpdatesFragment, (RemoteWebSocketDataSource) this.f27511e.get());
    }

    public final void mo4606a(UserSyncRoutine userSyncRoutine) {
        UserSyncRoutine_MembersInjector.m29930a(userSyncRoutine, (RemoteRedditApiDataSource) this.f27510d.get());
    }

    public final void mo4599a(ComposeService composeService) {
        ComposeService_MembersInjector.injectRemoteRedditApiDataSource(composeService, (RemoteRedditApiDataSource) this.f27510d.get());
    }

    public final void mo4607a(InboxPagerScreen inboxPagerScreen) {
        InboxPagerScreen_MembersInjector.m30064a(inboxPagerScreen, (RemoteRedditApiDataSource) this.f27510d.get());
        InboxPagerScreen_MembersInjector.m30063a(inboxPagerScreen, (RemoteGatewayDataSource) this.f27509c.get());
    }
}
