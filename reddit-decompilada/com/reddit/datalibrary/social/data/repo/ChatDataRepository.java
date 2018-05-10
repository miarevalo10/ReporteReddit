package com.reddit.datalibrary.social.data.repo;

import android.net.Uri;
import com.google.gson.JsonElement;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.social.data.datasource.ChatDataSourceContract;
import com.reddit.datalibrary.social.data.datasource.cache.ChatUserDataCacheContract;
import com.reddit.datalibrary.social.data.datasource.cache.FailedMessagesCacheContract;
import com.reddit.datalibrary.social.data.datasource.local.ChatDiscDataSource;
import com.reddit.datalibrary.social.data.session.ChatConnectionManager;
import com.reddit.datalibrary.social.data.session.ChatConnectionManager.Companion;
import com.reddit.datalibrary.social.model.ChannelMuteStatus;
import com.reddit.datalibrary.social.model.ChatEnabled;
import com.reddit.datalibrary.social.model.ReportMessage;
import com.reddit.datalibrary.social.model.User;
import com.reddit.datalibrary.social.network.RedditAPIClient;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.util.Connectivity;
import com.reddit.frontpage.util.FileUtil;
import com.reddit.frontpage.util.NetworkUtil;
import com.reddit.frontpage.util.SchedulerProvider;
import com.reddit.frontpage.util.SessionUtil;
import com.reddit.frontpage.util.kotlin.ObservablesKt;
import com.reddit.social.domain.functions.ContactListTransformer;
import com.reddit.social.domain.functions.RawMessagesBatch;
import com.reddit.social.domain.functions.UserDataMapTransformer;
import com.reddit.social.presentation.presentationobjects.ContactData;
import com.reddit.social.presentation.presentationobjects.SentStatus;
import com.reddit.social.presentation.presentationobjects.UserData;
import com.reddit.social.util.ChatSharedPreferencesUtil;
import com.sendbird.android.BaseChannel;
import com.sendbird.android.BaseMessage;
import com.sendbird.android.FileMessage;
import com.sendbird.android.FileMessage.ThumbnailSize;
import com.sendbird.android.GroupChannel;
import com.sendbird.android.Member;
import com.sendbird.android.SendBird;
import com.sendbird.android.UserMessage;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010)\u001a\b\u0012\u0004\u0012\u00020\"0*2\u0006\u0010+\u001a\u00020\u0004H\u0017J$\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0-0*2\u0006\u0010/\u001a\u00020\u00042\u0006\u00100\u001a\u00020\"H\u0017J\u001c\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0-0*2\u0006\u0010/\u001a\u00020\u0004H\u0017J\u0016\u00102\u001a\b\u0012\u0004\u0012\u00020\"0*2\u0006\u0010+\u001a\u00020\u0004H\u0017J\u0016\u00103\u001a\b\u0012\u0004\u0012\u00020\"0*2\u0006\u0010/\u001a\u00020\u0004H\u0017J\u0016\u00104\u001a\b\u0012\u0004\u0012\u0002050*2\u0006\u0010/\u001a\u00020\u0004H\u0017J\u0010\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0004H\u0017J3\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020:0-0*2\u0006\u0010/\u001a\u00020\u00042\b\u0010;\u001a\u0004\u0018\u00010\b2\u0006\u00100\u001a\u00020\"H\u0017¢\u0006\u0002\u0010<J&\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00040*2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020?0-2\b\u0010@\u001a\u0004\u0018\u00010\u0004H\u0017J\u0016\u0010A\u001a\b\u0012\u0004\u0012\u00020\"0*2\u0006\u0010+\u001a\u00020\u0004H\u0017J\u001e\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00040*2\u0006\u0010+\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u0004H\u0017J\u001e\u0010D\u001a\b\u0012\u0004\u0012\u00020E0*2\u0006\u0010+\u001a\u00020\u00042\u0006\u0010F\u001a\u00020EH\u0017J\u0010\u0010G\u001a\u0002072\u0006\u0010+\u001a\u00020\u0004H\u0017J$\u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020I0-0*2\u0006\u0010+\u001a\u00020\u00042\u0006\u00100\u001a\u00020\"H\u0017J\u0016\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00040K2\u0006\u0010L\u001a\u00020\u0004H\u0017J\u0016\u0010M\u001a\b\u0012\u0004\u0012\u00020.0*2\u0006\u0010+\u001a\u00020\u0004H\u0017J\u001e\u0010N\u001a\b\u0012\u0004\u0012\u00020O0*2\u0006\u0010+\u001a\u00020\u00042\u0006\u00100\u001a\u00020\"H\u0017J0\u0010P\u001a\u00020Q2\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u0002070S2\u0012\u0010T\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u0002070SH\u0016J\b\u0010U\u001a\u00020\"H\u0017J\b\u0010V\u001a\u00020\"H\u0017J\b\u0010W\u001a\u00020\"H\u0017J\u0016\u0010X\u001a\b\u0012\u0004\u0012\u00020\"0*2\u0006\u0010+\u001a\u00020\u0004H\u0017J$\u0010Y\u001a\b\u0012\u0004\u0012\u00020Z0*2\u0006\u0010+\u001a\u00020\u00042\f\u0010>\u001a\b\u0012\u0004\u0012\u00020?0-H\u0017J\u0016\u0010[\u001a\b\u0012\u0004\u0012\u00020\\0*2\u0006\u0010+\u001a\u00020\u0004H\u0017J\u000e\u0010]\u001a\b\u0012\u0004\u0012\u00020^0*H\u0017J\b\u0010_\u001a\u00020\"H\u0017J\u0016\u0010`\u001a\b\u0012\u0004\u0012\u00020\"0*2\u0006\u0010+\u001a\u00020\u0004H\u0017J\u0016\u0010a\u001a\b\u0012\u0004\u0012\u00020b0*2\u0006\u00108\u001a\u00020\u0004H\u0017J\u0016\u0010c\u001a\b\u0012\u0004\u0012\u00020.0*2\u0006\u00108\u001a\u00020\u0004H\u0017J\u0010\u0010d\u001a\u0002072\u0006\u0010M\u001a\u00020.H\u0017J\u0016\u0010e\u001a\b\u0012\u0004\u0012\u00020O0*2\u0006\u0010+\u001a\u00020\u0004H\u0017J\u0016\u0010f\u001a\b\u0012\u0004\u0012\u0002050*2\u0006\u0010+\u001a\u00020\u0004H\u0017J\u000e\u0010g\u001a\b\u0012\u0004\u0012\u00020\"0*H\u0016J\"\u0010h\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020b\u0012\u0004\u0012\u00020j0i0*2\u0006\u0010+\u001a\u00020\u0004H\u0017J&\u0010k\u001a\b\u0012\u0004\u0012\u0002050*2\u0006\u0010l\u001a\u00020\u00042\u0006\u0010m\u001a\u00020\u00042\u0006\u0010k\u001a\u00020nH\u0017J\u001e\u0010o\u001a\b\u0012\u0004\u0012\u0002050*2\u0006\u0010l\u001a\u00020\u00042\u0006\u0010m\u001a\u00020\u0004H\u0017J\u000e\u0010p\u001a\b\u0012\u0004\u0012\u00020\b0*H\u0017J\u0010\u0010q\u001a\u0002072\u0006\u0010/\u001a\u00020\u0004H\u0016J\u0010\u0010r\u001a\u0002072\u0006\u0010/\u001a\u00020\u0004H\u0017J\u0010\u0010s\u001a\u0002072\u0006\u0010+\u001a\u00020\u0004H\u0017J\b\u0010t\u001a\u000207H\u0002J\\\u0010u\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020v\u0012\u0004\u0012\u00020j0i0*2\u0006\u0010+\u001a\u00020\u00042\b\u0010w\u001a\u0004\u0018\u00010\u00042\b\u0010x\u001a\u0004\u0018\u00010\u00042\u0006\u0010y\u001a\u00020z2\u001c\u0010{\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020}\u0012\u0004\u0012\u00020v0ij\u0002`~0|H\u0017J;\u0010\u001a\t\u0012\u0005\u0012\u00030\u00010*2\u0006\u0010+\u001a\u00020\u00042\b\u0010w\u001a\u0004\u0018\u00010\u00042\b\u0010x\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010!H\u0017J \u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\"0*2\u0006\u0010+\u001a\u00020\u00042\u0007\u0010\u0001\u001a\u00020\u0004H\u0017J\u000f\u0010\u0001\u001a\b\u0012\u0004\u0012\u0002050*H\u0017J \u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\"0*2\u0006\u0010+\u001a\u00020\u00042\u0007\u0010\u0001\u001a\u00020\"H\u0017J\u0012\u0010\u0001\u001a\u0002072\u0007\u0010\u0001\u001a\u00020\bH\u0017J\u0011\u0010\u0001\u001a\u0002072\u0006\u0010+\u001a\u00020\u0004H\u0017J\u000f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\b0*H\u0017J\u001e\u0010\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u00010-0*2\u0006\u0010+\u001a\u00020\u0004H\u0017J%\u0010\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0-0*2\u0006\u0010/\u001a\u00020\u00042\u0006\u00100\u001a\u00020\"H\u0017J\u001d\u0010\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0-0*2\u0006\u0010/\u001a\u00020\u0004H\u0017J\u0017\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\"0*2\u0006\u0010/\u001a\u00020\u0004H\u0017J\u0017\u0010\u0001\u001a\b\u0012\u0004\u0012\u0002050*2\u0006\u0010+\u001a\u00020\u0004H\u0017J8\u0010\u0001\u001a\u001f\u0012\u001b\u0012\u0019\u0012\t\u0012\u00070\u0004j\u0003`\u0001\u0012\u0004\u0012\u00020I0\u0001j\u0003`\u00010*2\u0010\u0010\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001H\u0017R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118BX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u00020\u001b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010%\u001a\u00020\u00118\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0013\"\u0004\b'\u0010(¨\u0006\u0001"}, d2 = {"Lcom/reddit/datalibrary/social/data/repo/ChatDataRepository;", "Lcom/reddit/datalibrary/social/data/repo/ChatDataRepositoryContract;", "()V", "INFO_KEY_MIME", "", "INFO_KEY_PATH", "INFO_KEY_SIZE", "THUMB_SIZE_LARGE", "", "THUMB_SIZE_SMALL", "cacheDataSource", "Lcom/reddit/datalibrary/social/data/datasource/cache/ChatUserDataCacheContract;", "getCacheDataSource", "()Lcom/reddit/datalibrary/social/data/datasource/cache/ChatUserDataCacheContract;", "setCacheDataSource", "(Lcom/reddit/datalibrary/social/data/datasource/cache/ChatUserDataCacheContract;)V", "chatDataSource", "Lcom/reddit/datalibrary/social/data/datasource/ChatDataSourceContract;", "getChatDataSource", "()Lcom/reddit/datalibrary/social/data/datasource/ChatDataSourceContract;", "failedMessagesCache", "Lcom/reddit/datalibrary/social/data/datasource/cache/FailedMessagesCacheContract;", "getFailedMessagesCache", "()Lcom/reddit/datalibrary/social/data/datasource/cache/FailedMessagesCacheContract;", "setFailedMessagesCache", "(Lcom/reddit/datalibrary/social/data/datasource/cache/FailedMessagesCacheContract;)V", "localDataSource", "Lcom/reddit/datalibrary/social/data/datasource/local/ChatDiscDataSource;", "getLocalDataSource", "()Lcom/reddit/datalibrary/social/data/datasource/local/ChatDiscDataSource;", "setLocalDataSource", "(Lcom/reddit/datalibrary/social/data/datasource/local/ChatDiscDataSource;)V", "networkConnectivityChangeSubject", "Lio/reactivex/subjects/BehaviorSubject;", "", "redditAPIClient", "Lcom/reddit/datalibrary/social/network/RedditAPIClient;", "remoteDataSource", "getRemoteDataSource", "setRemoteDataSource", "(Lcom/reddit/datalibrary/social/data/datasource/ChatDataSourceContract;)V", "acceptInvite", "Lio/reactivex/Observable;", "channelUrl", "acceptedGroupChannels", "", "Lcom/sendbird/android/GroupChannel;", "userId", "refresh", "acceptedGroupChannelsWithMore", "areNotificationsEnabledSendbird", "blockUser", "blockUserOnReddit", "", "cancelListenGroupChannels", "", "channelHandlerId", "contacts", "Lcom/reddit/social/presentation/presentationobjects/ContactData;", "limit", "(Ljava/lang/String;Ljava/lang/Integer;Z)Lio/reactivex/Observable;", "createChannel", "users", "Lcom/reddit/datalibrary/social/model/User;", "channelName", "declineInvite", "deleteFailedMessage", "requestId", "deleteMessage", "", "messageId", "endTyping", "getMembers", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "getUserId", "Lio/reactivex/Single;", "username", "groupChannel", "groupMessages", "Lcom/reddit/social/domain/functions/RawMessagesBatch;", "handleNetworkConnection", "Lio/reactivex/disposables/CompositeDisposable;", "onInit", "Lkotlin/Function1;", "onChange", "hasMoreAcceptedChannels", "hasMoreMessages", "hasMoreUnacceptedChannels", "hideChannel", "inviteToChannel", "Lcom/google/gson/JsonElement;", "isChannelMuted", "Lcom/reddit/datalibrary/social/model/ChannelMuteStatus;", "isChatEnabled", "Lcom/reddit/datalibrary/social/model/ChatEnabled;", "isLoadingUnacceptedChannels", "leaveChannel", "listenChats", "Lcom/sendbird/android/BaseChannel;", "listenNewInvite", "markGroupChannelAsRead", "moreMessages", "muteChannel", "networkConnectionChangedObservable", "newMessageObservable", "Lkotlin/Pair;", "Lcom/sendbird/android/BaseMessage;", "reportMessage", "userName", "reason", "Lcom/reddit/datalibrary/social/model/ReportMessage;", "reportUser", "requestsCount", "saveContacts", "saveConversations", "saveMessages", "saveState", "sendFileMessage", "Lcom/reddit/social/presentation/presentationobjects/SentStatus;", "message", "data", "uri", "Landroid/net/Uri;", "messagesStatus", "Lio/reactivex/subjects/PublishSubject;", "Lcom/sendbird/android/FileMessage;", "Lcom/reddit/social/presentation/groupchat/presentation/FileMessageStatus;", "sendMessage", "Lcom/sendbird/android/UserMessage;", "tempMessage", "setChannelName", "name", "setChatEnabled", "setNotificationsEnabledSendbird", "enable", "setTotalUnreadMessageCount", "count", "startTyping", "totalUnreadMessageCount", "typingStatusObservable", "Lcom/sendbird/android/Member;", "unacceptedGroupChannels", "unacceptedGroupChannelsWithMore", "unblockUser", "unmuteChannel", "usersData", "", "Lcom/reddit/datalibrary/social/network/UserId;", "Lcom/reddit/datalibrary/social/data/datasource/cache/UserDataMap;", "usersId", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ChatDataRepository.kt */
public final class ChatDataRepository implements ChatDataRepositoryContract {
    @Inject
    public ChatDiscDataSource f27362a;
    @Inject
    public ChatDataSourceContract f27363b;
    @Inject
    public ChatUserDataCacheContract f27364c;
    @Inject
    public FailedMessagesCacheContract f27365d;
    private final RedditAPIClient f27366e = new RedditAPIClient();
    private final int f27367f = 240;
    private final int f27368g = 320;
    private final String f27369h = "path";
    private final String f27370i = "mime";
    private final String f27371j = "size";
    private final BehaviorSubject<Boolean> f27372k;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lio/reactivex/Observable;", "", "it", "Lcom/reddit/datalibrary/frontpage/redditauth/account/Session;", "apply"}, k = 3, mv = {1, 1, 9})
    /* compiled from: ChatDataRepository.kt */
    static final class C22421<T, R> implements Function<T, ObservableSource<? extends R>> {
        public static final C22421 f27344a = new C22421();

        C22421() {
        }

        public final /* synthetic */ Object apply(Object obj) {
            Intrinsics.m26847b((Session) obj, "it");
            obj = ChatConnectionManager.f19854b;
            return Companion.m21750a().m21772b();
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 9})
    /* compiled from: ChatDataRepository.kt */
    static final class C28072 extends Lambda implements Function1<String, Unit> {
        public static final C28072 f36313a = new C28072();

        C28072() {
            super(1);
        }

        public final /* bridge */ /* synthetic */ Object mo6492a(Object obj) {
            return Unit.f25273a;
        }
    }

    public ChatDataRepository() {
        Object a = BehaviorSubject.m38175a();
        Intrinsics.m26843a(a, "BehaviorSubject.create()");
        this.f27372k = a;
        FrontpageApplication.m28878n().mo5078a(this);
        this.f27372k.onNext(Boolean.valueOf(NetworkUtil.m23842b()));
        Observable flatMap = SessionManager.b().g().flatMap(C22421.f27344a);
        Intrinsics.m26843a((Object) flatMap, "SessionManager.getInstan…ager.instance.connect() }");
        ObservablesKt.m24091a(flatMap, (Function1) C28072.f36313a);
        ObservablesKt.m24091a(NetworkUtil.m23840a(), (Function1) new Function1<Connectivity, Unit>() {
            public final /* synthetic */ Object mo6492a(Object obj) {
                Connectivity connectivity = (Connectivity) obj;
                Intrinsics.m26847b(connectivity, "<name for destructuring parameter 0>");
                this.f27372k.onNext(Boolean.valueOf(connectivity.f21708a));
                return Unit.f25273a;
            }
        });
    }

    public final ChatDiscDataSource m28781a() {
        ChatDiscDataSource chatDiscDataSource = this.f27362a;
        if (chatDiscDataSource == null) {
            Intrinsics.m26844a("localDataSource");
        }
        return chatDiscDataSource;
    }

    public final ChatUserDataCacheContract m28794b() {
        ChatUserDataCacheContract chatUserDataCacheContract = this.f27364c;
        if (chatUserDataCacheContract == null) {
            Intrinsics.m26844a("cacheDataSource");
        }
        return chatUserDataCacheContract;
    }

    private final ChatDataSourceContract m28780j() {
        if (NetworkUtil.m23842b()) {
            ChatDataSourceContract chatDataSourceContract = this.f27363b;
            if (chatDataSourceContract == null) {
                Intrinsics.m26844a("remoteDataSource");
            }
            return chatDataSourceContract;
        }
        ChatDiscDataSource chatDiscDataSource = this.f27362a;
        if (chatDiscDataSource == null) {
            Intrinsics.m26844a("localDataSource");
        }
        return chatDiscDataSource;
    }

    public final CompositeDisposable mo4516a(Function1<? super Boolean, Unit> function1, Function1<? super Boolean, Unit> function12) {
        Intrinsics.m26847b(function1, "onInit");
        Intrinsics.m26847b(function12, "onChange");
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        Observable a = NetworkUtil.m23840a();
        Observable take = a.take(1);
        Intrinsics.m26843a((Object) take, "connection\n            .take(1)");
        DisposableKt.m26766a(compositeDisposable, ObservablesKt.m24091a(take, (Function1) new C2809xa6b61eec(function1, function12)));
        a = a.skip(1);
        Intrinsics.m26843a((Object) a, "connection\n            .skip(1)");
        DisposableKt.m26766a(compositeDisposable, ObservablesKt.m24091a(a, (Function1) new C2810xa6b61eed(function1, function12)));
        return compositeDisposable;
    }

    public final Observable<String> mo4514a(List<User> list, String str) {
        Intrinsics.m26847b(list, "users");
        return m28780j().mo6388a((List) list, str);
    }

    public final Observable<JsonElement> mo4512a(String str, List<User> list) {
        Intrinsics.m26847b(str, "channelUrl");
        Intrinsics.m26847b(list, "users");
        return m28780j().mo6386a(str, (List) list);
    }

    public final Observable<GroupChannel> mo4506a(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        return m28780j().mo6381a(str);
    }

    public final void mo4517a(GroupChannel groupChannel) {
        Intrinsics.m26847b(groupChannel, "groupChannel");
        int l = groupChannel.m30982l();
        groupChannel.m30987q();
        groupChannel = this.f27362a;
        if (groupChannel == null) {
            Intrinsics.m26844a("localDataSource");
        }
        groupChannel.mo6397d().subscribe((Consumer) new ChatDataRepository$markGroupChannelAsRead$1(this, l));
    }

    public final Observable<BaseChannel> mo4518b(String str) {
        Intrinsics.m26847b(str, "channelHandlerId");
        Object create = Observable.create(new ChatDataRepository$listenChats$1(str));
        Intrinsics.m26843a(create, "Observable.create { emit…essage) {}\n      })\n    }");
        return create;
    }

    public final Observable<GroupChannel> mo4521c(String str) {
        Intrinsics.m26847b(str, "channelHandlerId");
        Object create = Observable.create(new ChatDataRepository$listenNewInvite$1(str));
        Intrinsics.m26843a(create, "Observable.create { emit…essage) {}\n      })\n    }");
        return create;
    }

    public final void mo4526d(String str) {
        Intrinsics.m26847b(str, "channelHandlerId");
        SendBird.m24961a(str);
    }

    public final Observable<List<GroupChannel>> mo4513a(String str, boolean z) {
        Intrinsics.m26847b(str, "userId");
        return m28780j().mo6387a(str, z);
    }

    public final Observable<List<GroupChannel>> mo4528e(String str) {
        Intrinsics.m26847b(str, "userId");
        return m28780j().mo6391b(str);
    }

    public final boolean mo4524c() {
        return m28780j().mo6390a();
    }

    public final Observable<List<GroupChannel>> mo4520b(String str, boolean z) {
        Intrinsics.m26847b(str, "userId");
        return m28780j().mo6392b(str, z);
    }

    public final Observable<List<GroupChannel>> mo4531f(String str) {
        Intrinsics.m26847b(str, "userId");
        return m28780j().mo6394c(str);
    }

    public final boolean mo4527d() {
        return m28780j().mo6393b();
    }

    public final boolean mo4530e() {
        return m28780j().mo6396c();
    }

    public final Observable<List<ContactData>> mo4534g(String str) {
        Intrinsics.m26847b(str, "userId");
        Object map = m28780j().mo6398d(str).flatMap(new ChatDataRepository$contacts$1(this)).map(new ContactListTransformer());
        Intrinsics.m26843a(map, "chatDataSource.contacts(…ContactListTransformer())");
        return map;
    }

    public final Observable<Boolean> mo4509a(String str, String str2) {
        Intrinsics.m26847b(str, "channelUrl");
        Intrinsics.m26847b(str2, "name");
        return m28780j().mo6384a(str, str2);
    }

    public final Observable<RawMessagesBatch> mo4523c(String str, boolean z) {
        Intrinsics.m26847b(str, "channelUrl");
        Object map = m28780j().mo6395c(str, z).map(new ChatDataRepository$groupMessages$1(this, str));
        Intrinsics.m26843a(map, "chatDataSource.groupMess…, it.hasMore)\n          }");
        return map;
    }

    public final boolean mo4532f() {
        return m28780j().mo6402e();
    }

    public final Observable<RawMessagesBatch> mo4536h(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        return m28780j().mo6400e(str);
    }

    public final Observable<Pair<BaseChannel, BaseMessage>> mo4538i(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        return m28780j().mo6404f(str);
    }

    public final Observable<List<Member>> mo4539j(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        return m28780j().mo6406g(str);
    }

    public final Observable<Integer> mo4533g() {
        if (NetworkUtil.m23842b()) {
            ChatDataSourceContract chatDataSourceContract = this.f27363b;
            if (chatDataSourceContract == null) {
                Intrinsics.m26844a("remoteDataSource");
            }
            Object doOnNext = chatDataSourceContract.mo6397d().doOnNext(new ChatDataRepository$totalUnreadMessageCount$1(this));
            Intrinsics.m26843a(doOnNext, "remoteDataSource.totalUn…lUnreadMessageCount(it) }");
            return doOnNext;
        }
        ChatDiscDataSource chatDiscDataSource = this.f27362a;
        if (chatDiscDataSource == null) {
            Intrinsics.m26844a("localDataSource");
        }
        return chatDiscDataSource.mo6397d();
    }

    public static void m28779a(int i) {
        ChatSharedPreferencesUtil.m24744a(i);
    }

    public final Observable<UserMessage> mo4511a(String str, String str2, String str3, BehaviorSubject<UserMessage> behaviorSubject) {
        Intrinsics.m26847b(str, "channelUrl");
        Intrinsics.m26847b(behaviorSubject, "tempMessage");
        ChatDataSourceContract chatDataSourceContract = this.f27363b;
        if (chatDataSourceContract == null) {
            Intrinsics.m26844a("remoteDataSource");
        }
        return chatDataSourceContract.mo6385a(str, str2, str3, behaviorSubject);
    }

    public final Observable<Pair<SentStatus, BaseMessage>> mo4508a(String str, Uri uri, PublishSubject<Pair<FileMessage, SentStatus>> publishSubject) {
        Intrinsics.m26847b(str, "channelUrl");
        Intrinsics.m26847b(uri, "uri");
        Intrinsics.m26847b(publishSubject, "messagesStatus");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ThumbnailSize(this.f27367f, this.f27367f));
        arrayList.add(new ThumbnailSize(this.f27368g, this.f27368g));
        Object obj = FrontpageApplication.f27402a;
        Intrinsics.m26843a(obj, "FrontpageApplication.instance");
        uri = FileUtil.m23701c(obj.getApplicationContext(), uri);
        if (uri == null) {
            Intrinsics.m26842a();
        }
        obj = uri.get(this.f27369h);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
        }
        File file = new File((String) obj);
        Object name = file.getName();
        obj = uri.get(this.f27370i);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
        }
        String str2 = (String) obj;
        uri = uri.get(this.f27371j);
        if (uri == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
        }
        int intValue = ((Integer) uri).intValue();
        ChatDataSourceContract chatDataSourceContract = this.f27363b;
        if (chatDataSourceContract == null) {
            Intrinsics.m26844a("remoteDataSource");
        }
        Intrinsics.m26843a(name, "name");
        return chatDataSourceContract.mo6383a(str, file, name, str2, intValue, arrayList, publishSubject);
    }

    public final Observable<Long> mo4507a(String str, long j) {
        Intrinsics.m26847b(str, "channelUrl");
        return m28780j().mo6382a(str, j);
    }

    public final Observable<String> mo4519b(String str, String str2) {
        Intrinsics.m26847b(str, "channelUrl");
        Intrinsics.m26847b(str2, "requestId");
        FailedMessagesCacheContract failedMessagesCacheContract = this.f27365d;
        if (failedMessagesCacheContract == null) {
            Intrinsics.m26844a("failedMessagesCache");
        }
        failedMessagesCacheContract.remove(str, str2);
        Object just = Observable.just(str2);
        Intrinsics.m26843a(just, "Observable.just(requestId)");
        return just;
    }

    public final Observable<Boolean> mo4540k(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        return m28780j().mo6407h(str);
    }

    public final Observable<Boolean> mo4541l(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        return m28780j().mo6408i(str);
    }

    public final Observable<Boolean> mo4542m(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        return m28780j().mo6409j(str);
    }

    public final Observable<Boolean> mo4525d(String str, boolean z) {
        Intrinsics.m26847b(str, "channelUrl");
        return m28780j().mo6399d(str, z);
    }

    public final Observable<List<UserData>> mo4529e(String str, boolean z) {
        Intrinsics.m26847b(str, "channelUrl");
        Object flatMap = m28780j().mo6401e(str, z).flatMap((Function) new ChatDataRepository$getMembers$1(this));
        Intrinsics.m26843a(flatMap, "chatDataSource.getMember…              }\n        }");
        return flatMap;
    }

    public final Observable<Boolean> mo4543n(String str) {
        Intrinsics.m26847b(str, "userId");
        return m28780j().mo6410k(str);
    }

    public final Observable<Object> mo4544o(String str) {
        Intrinsics.m26847b(str, "userId");
        if (NetworkUtil.m23842b()) {
            Object subscribeOn = this.f27366e.m28853a(str).subscribeOn(SchedulerProvider.m23886b());
            Intrinsics.m26843a(subscribeOn, "redditAPIClient.blockUse…n(SchedulerProvider.io())");
            return subscribeOn;
        }
        subscribeOn = Observable.error((Throwable) new IllegalStateException("Cannot block user without a network connection"));
        Intrinsics.m26843a(subscribeOn, "Observable.error(Illegal…t a network connection\"))");
        return subscribeOn;
    }

    public final Observable<Object> mo4522c(String str, String str2) {
        Intrinsics.m26847b(str, "userName");
        Intrinsics.m26847b(str2, "reason");
        if (NetworkUtil.m23842b()) {
            return this.f27366e.m28854a(str, str2);
        }
        Object error = Observable.error((Throwable) new IllegalStateException("Cannot report user without a network connection"));
        Intrinsics.m26843a(error, "Observable.error(Illegal…t a network connection\"))");
        return error;
    }

    public final Observable<Object> mo4510a(String str, String str2, ReportMessage reportMessage) {
        Intrinsics.m26847b(str, "userName");
        Intrinsics.m26847b(str2, "reason");
        Intrinsics.m26847b(reportMessage, "reportMessage");
        if (NetworkUtil.m23842b()) {
            return this.f27366e.m28855a(str, str2, reportMessage);
        }
        Object error = Observable.error((Throwable) new IllegalStateException("Cannot report message without a network connection"));
        Intrinsics.m26843a(error, "Observable.error(Illegal…t a network connection\"))");
        return error;
    }

    public final Observable<Boolean> mo4545p(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        return m28780j().mo6411l(str);
    }

    public final Observable<Boolean> mo4546q(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        return m28780j().mo6412m(str);
    }

    public final Single<String> mo4547r(String str) {
        Intrinsics.m26847b(str, "username");
        RemoteRedditApiDataSource remoteRedditApiDataSource = new RemoteRedditApiDataSource();
        Object map = RemoteRedditApiDataSource.i(str).map(ChatDataRepository$getUserId$1.f27349a);
        Intrinsics.m26843a(map, "RemoteRedditApiDataSourc…issing(account.data.id) }");
        return map;
    }

    public final void mo4548s(String str) {
        Intrinsics.m26847b(str, "userId");
        if (NetworkUtil.m23842b()) {
            ChatDataSourceContract chatDataSourceContract = this.f27363b;
            if (chatDataSourceContract == null) {
                Intrinsics.m26844a("remoteDataSource");
            }
            ObservablesKt.m24091a(chatDataSourceContract.mo6387a(str, false), (Function1) new ChatDataRepository$saveConversations$1(this, str));
            chatDataSourceContract = this.f27363b;
            if (chatDataSourceContract == null) {
                Intrinsics.m26844a("remoteDataSource");
            }
            ObservablesKt.m24091a(chatDataSourceContract.mo6392b(str, false), (Function1) new ChatDataRepository$saveConversations$2(this, str));
            return;
        }
        Timber.b("Cannot save conversation data in offline mode", new Object[0]);
    }

    public final void mo4549t(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        String d = SessionUtil.m23898d();
        if (d != null) {
            ChatDataSourceContract chatDataSourceContract = this.f27363b;
            if (chatDataSourceContract == null) {
                Intrinsics.m26844a("remoteDataSource");
            }
            ObservablesKt.m24091a(chatDataSourceContract.mo6395c(str, false), (Function1) new ChatDataRepository$saveMessages$1(this, d, str));
        }
    }

    public final void mo4550u(String str) {
        Intrinsics.m26847b(str, "userId");
        NetworkUtil.m23842b();
    }

    public final Observable<Map<String, UserData>> mo4515a(Set<String> set) {
        Intrinsics.m26847b(set, "usersId");
        Collection arrayList = new ArrayList();
        for (Object next : CollectionsKt___CollectionsKt.m41446k(set)) {
            if ((((CharSequence) ((String) next)).length() > 0 ? 1 : null) != null) {
                arrayList.add(next);
            }
        }
        set = CollectionsKt___CollectionsKt.m41451p((List) arrayList);
        ChatUserDataCacheContract chatUserDataCacheContract = this.f27364c;
        if (chatUserDataCacheContract == null) {
            Intrinsics.m26844a("cacheDataSource");
        }
        Set notCachedUsersId = chatUserDataCacheContract.getNotCachedUsersId(set);
        if (notCachedUsersId.isEmpty()) {
            chatUserDataCacheContract = this.f27364c;
            if (chatUserDataCacheContract == null) {
                Intrinsics.m26844a("cacheDataSource");
            }
            return chatUserDataCacheContract.getUsersData(set);
        }
        Object flatMap = m28780j().mo6389a(notCachedUsersId).subscribeOn(SchedulerProvider.m23886b()).map(new UserDataMapTransformer()).doOnNext(new ChatDataRepository$usersData$1(this)).flatMap(new ChatDataRepository$usersData$2(this, set));
        Intrinsics.m26843a(flatMap, "chatDataSource.userDataB…rsData(filteredUsersId) }");
        return flatMap;
    }

    public final Observable<ChannelMuteStatus> mo4551v(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        return m28780j().mo6413n(str);
    }

    public final Observable<Object> mo4552w(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        return m28780j().mo6414o(str);
    }

    public final Observable<Object> mo4553x(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        return m28780j().mo6415p(str);
    }

    public final Observable<ChatEnabled> mo4535h() {
        return m28780j().mo6403f();
    }

    public final Observable<Object> mo4537i() {
        return m28780j().mo6405g();
    }

    public final void mo4554y(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        m28780j().mo6416q(str);
    }

    public final void mo4555z(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        m28780j().mo6417r(str);
    }
}
