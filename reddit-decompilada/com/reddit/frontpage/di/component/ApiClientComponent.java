package com.reddit.frontpage.di.component;

import com.reddit.datalibrary.frontpage.data.feature.account.datasource.local.AccountStorage;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.ApiLinkDataSourceLegacy;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.LegacyApiSubredditDataSource;
import com.reddit.datalibrary.frontpage.data.provider.CombinedSearchProvider;
import com.reddit.datalibrary.frontpage.data.provider.CommentListingProvider;
import com.reddit.datalibrary.frontpage.data.provider.CommentsProvider;
import com.reddit.datalibrary.frontpage.data.provider.FlairProvider;
import com.reddit.datalibrary.frontpage.data.provider.InboxFilterableListingProvider;
import com.reddit.datalibrary.frontpage.data.provider.LinkSearchListingProvider;
import com.reddit.datalibrary.frontpage.data.provider.LiveUpdateProvider;
import com.reddit.datalibrary.frontpage.data.provider.MessageListingProvider;
import com.reddit.datalibrary.frontpage.data.provider.MessageThreadProvider;
import com.reddit.datalibrary.frontpage.data.provider.SavedListingProvider;
import com.reddit.datalibrary.frontpage.data.provider.SubredditSearchListingProvider;
import com.reddit.datalibrary.frontpage.service.api.ComposeService;
import com.reddit.datalibrary.frontpage.service.api.ReplyService;
import com.reddit.datalibrary.frontpage.service.api.SubmitService;
import com.reddit.datalibrary.frontpage.service.api.UploadService;
import com.reddit.datalibrary.frontpage.service.api.VideoUploadService;
import com.reddit.frontpage.service.sync.PreferencesSyncService;
import com.reddit.frontpage.sync.routine.AppConfigSyncRoutine;
import com.reddit.frontpage.sync.routine.UserSyncRoutine;
import com.reddit.frontpage.ui.inbox.InboxPagerScreen;
import com.reddit.frontpage.ui.live.LiveUpdatesFragment;
import com.reddit.social.presentation.messaginglist.content.RedditImageMessageContent;
import javax.inject.Singleton;
import kotlin.Metadata;

@Singleton
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001dH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001fH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010$\u001a\u00020%H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010&\u001a\u00020'H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010(\u001a\u00020)H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010*\u001a\u00020+H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010,\u001a\u00020-H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010.\u001a\u00020/H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u00100\u001a\u000201H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u00100\u001a\u000202H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u00103\u001a\u000204H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u00105\u001a\u000206H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u00107\u001a\u000208H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u00109\u001a\u00020:H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010;\u001a\u00020<H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010=\u001a\u00020>H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010?\u001a\u00020@H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010A\u001a\u00020BH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010C\u001a\u00020DH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010E\u001a\u00020FH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010G\u001a\u00020HH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010I\u001a\u00020JH&¨\u0006K"}, d2 = {"Lcom/reddit/frontpage/di/component/ApiClientComponent;", "", "inject", "", "accountStorage", "Lcom/reddit/datalibrary/frontpage/data/feature/account/datasource/local/AccountStorage;", "apiLinkDataSourceLegacy", "Lcom/reddit/datalibrary/frontpage/data/feature/legacy/remote/ApiLinkDataSourceLegacy;", "legacyApiSubredditDataSource", "Lcom/reddit/datalibrary/frontpage/data/feature/legacy/remote/LegacyApiSubredditDataSource;", "combinedSearchProvider", "Lcom/reddit/datalibrary/frontpage/data/provider/CombinedSearchProvider;", "commentListingProvider", "Lcom/reddit/datalibrary/frontpage/data/provider/CommentListingProvider;", "commentsProvider", "Lcom/reddit/datalibrary/frontpage/data/provider/CommentsProvider;", "flairProvider", "Lcom/reddit/datalibrary/frontpage/data/provider/FlairProvider;", "inboxFilterableListingProvider", "Lcom/reddit/datalibrary/frontpage/data/provider/InboxFilterableListingProvider;", "karmaListProvider", "Lcom/reddit/datalibrary/frontpage/data/provider/KarmaListProvider;", "linkSearchListingProvider", "Lcom/reddit/datalibrary/frontpage/data/provider/LinkSearchListingProvider;", "liveThreadProvider", "Lcom/reddit/datalibrary/frontpage/data/provider/LiveThreadProvider;", "liveUpdateProvider", "Lcom/reddit/datalibrary/frontpage/data/provider/LiveUpdateProvider;", "messageListingProvider", "Lcom/reddit/datalibrary/frontpage/data/provider/MessageListingProvider;", "messageThreadProvider", "Lcom/reddit/datalibrary/frontpage/data/provider/MessageThreadProvider;", "savedListingProvider", "Lcom/reddit/datalibrary/frontpage/data/provider/SavedListingProvider;", "subredditSearchListingProvider", "Lcom/reddit/datalibrary/frontpage/data/provider/SubredditSearchListingProvider;", "userAccountProvider", "Lcom/reddit/datalibrary/frontpage/data/provider/UserAccountProvider;", "blockJob", "Lcom/reddit/datalibrary/frontpage/job/BlockJob;", "deleteJob", "Lcom/reddit/datalibrary/frontpage/job/DeleteJob;", "editCommentJob", "Lcom/reddit/datalibrary/frontpage/job/EditCommentJob;", "editLinkJob", "Lcom/reddit/datalibrary/frontpage/job/EditLinkJob;", "giveGoldJob", "Lcom/reddit/datalibrary/frontpage/job/GiveGoldJob;", "reportJob", "Lcom/reddit/datalibrary/frontpage/job/ReportJob;", "Lcom/reddit/datalibrary/frontpage/job/ReportListingJob;", "updatePostFlairJob", "Lcom/reddit/datalibrary/frontpage/job/UpdatePostFlairJob;", "composeService", "Lcom/reddit/datalibrary/frontpage/service/api/ComposeService;", "replyService", "Lcom/reddit/datalibrary/frontpage/service/api/ReplyService;", "submitService", "Lcom/reddit/datalibrary/frontpage/service/api/SubmitService;", "uploadService", "Lcom/reddit/datalibrary/frontpage/service/api/UploadService;", "videoUploadService", "Lcom/reddit/datalibrary/frontpage/service/api/VideoUploadService;", "preferencesSyncService", "Lcom/reddit/frontpage/service/sync/PreferencesSyncService;", "appConfigSyncRoutine", "Lcom/reddit/frontpage/sync/routine/AppConfigSyncRoutine;", "userSyncRoutine", "Lcom/reddit/frontpage/sync/routine/UserSyncRoutine;", "inboxPagerscreen", "Lcom/reddit/frontpage/ui/inbox/InboxPagerScreen;", "liveUpdatesFragment", "Lcom/reddit/frontpage/ui/live/LiveUpdatesFragment;", "redditImageMessageContent", "Lcom/reddit/social/presentation/messaginglist/content/RedditImageMessageContent;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ApiClientComponent.kt */
public interface ApiClientComponent {
    void mo4585a(AccountStorage accountStorage);

    void mo4586a(ApiLinkDataSourceLegacy apiLinkDataSourceLegacy);

    void mo4587a(LegacyApiSubredditDataSource legacyApiSubredditDataSource);

    void mo4588a(CombinedSearchProvider combinedSearchProvider);

    void mo4589a(CommentListingProvider commentListingProvider);

    void mo4590a(CommentsProvider commentsProvider);

    void mo4591a(FlairProvider flairProvider);

    void mo4592a(InboxFilterableListingProvider inboxFilterableListingProvider);

    void mo4593a(LinkSearchListingProvider linkSearchListingProvider);

    void mo4594a(LiveUpdateProvider liveUpdateProvider);

    void mo4595a(MessageListingProvider messageListingProvider);

    void mo4596a(MessageThreadProvider messageThreadProvider);

    void mo4597a(SavedListingProvider savedListingProvider);

    void mo4598a(SubredditSearchListingProvider subredditSearchListingProvider);

    void mo4599a(ComposeService composeService);

    void mo4600a(ReplyService replyService);

    void mo4601a(SubmitService submitService);

    void mo4602a(UploadService uploadService);

    void mo4603a(VideoUploadService videoUploadService);

    void mo4604a(PreferencesSyncService preferencesSyncService);

    void mo4605a(AppConfigSyncRoutine appConfigSyncRoutine);

    void mo4606a(UserSyncRoutine userSyncRoutine);

    void mo4607a(InboxPagerScreen inboxPagerScreen);

    void mo4608a(LiveUpdatesFragment liveUpdatesFragment);

    void mo4609a(RedditImageMessageContent redditImageMessageContent);
}
