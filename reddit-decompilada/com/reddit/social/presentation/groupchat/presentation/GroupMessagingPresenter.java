package com.reddit.social.presentation.groupchat.presentation;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Patterns;
import com.reddit.datalibrary.frontpage.requests.models.v1.Kind;
import com.reddit.datalibrary.frontpage.requests.models.v1.LinkPreview;
import com.reddit.datalibrary.frontpage.requests.models.v2.ClientLink;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.datalibrary.social.data.common.StateStorageContract;
import com.reddit.datalibrary.social.data.datasource.cache.FailedMessagesCacheContract;
import com.reddit.datalibrary.social.data.repo.ChatDataRepositoryContract;
import com.reddit.datalibrary.social.model.ReportMessage;
import com.reddit.datalibrary.social.model.SendBirdDataV1;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.util.SchedulerProvider;
import com.reddit.frontpage.util.SessionUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.ObservablesKt;
import com.reddit.social.analytics.ChatAnalytics;
import com.reddit.social.analytics.ChatPerformanceAnalyticsContract;
import com.reddit.social.domain.functions.MessageListTransformer;
import com.reddit.social.domain.functions.MessageTransformer;
import com.reddit.social.domain.functions.RawMessagesBatch;
import com.reddit.social.domain.functions.SentMessageTransformer;
import com.reddit.social.domain.usecases.LoadMessagesUseCase;
import com.reddit.social.presentation.groupchat.ChatContract.Presenter;
import com.reddit.social.presentation.groupchat.ChatContract.View;
import com.reddit.social.presentation.presentationobjects.HasMessageData;
import com.reddit.social.presentation.presentationobjects.MessageData;
import com.reddit.social.presentation.presentationobjects.SentStatus;
import com.reddit.social.presentation.presentationobjects.TextMessageData;
import com.reddit.social.util.ChatSharedPreferencesUtil;
import com.reddit.social.util.ChatUtilKt;
import com.sendbird.android.BaseChannel;
import com.sendbird.android.BaseMessage;
import com.sendbird.android.FileMessage;
import com.sendbird.android.GroupChannel;
import com.sendbird.android.User;
import com.sendbird.android.UserMessage;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.Regex;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0002!G\u0018\u00002\u00020\u0001:\u0002\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010Q\u001a\u00020RH\u0002J \u0010S\u001a\u00020R2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\u0004H\u0016J\b\u0010W\u001a\u00020RH\u0016J\b\u0010X\u001a\u00020RH\u0016JF\u0010Y\u001a,\u0012(\u0012&\u0012\u0004\u0012\u00020M\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020[\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020]0\\0K0K0Z2\u0012\u0010^\u001a\u000e\u0012\u0004\u0012\u00020M\u0012\u0004\u0012\u00020[0KH\u0003J6\u0010_\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020`\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0004j\u0002`a\u0012\u0004\u0012\u00020]0\\j\u0002`b0K0Z2\u0006\u0010c\u001a\u00020`H\u0003J$\u0010_\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020[\u0012\u0006\u0012\u0004\u0018\u00010]0K0Z2\u0006\u0010d\u001a\u00020[H\u0003J\u0018\u0010e\u001a\u00020R2\u0006\u0010@\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u0004H\u0016J8\u0010e\u001a\u00020R2\u0006\u0010\r\u001a\u00020\u00042\b\u0010f\u001a\u0004\u0018\u00010\u00042\b\u0010D\u001a\u0004\u0018\u00010\u00042\b\u0010E\u001a\u0004\u0018\u00010\u00042\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J\u001a\u0010e\u001a\u00020R2\b\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010g\u001a\u00020\fH\u0016J\b\u0010h\u001a\u00020RH\u0002J\b\u0010i\u001a\u00020RH\u0002J\b\u0010j\u001a\u00020RH\u0002J\b\u0010k\u001a\u00020RH\u0016J\"\u0010l\u001a\b\u0012\u0004\u0012\u00020[0Z2\u0012\u0010^\u001a\u000e\u0012\u0004\u0012\u00020m\u0012\u0004\u0012\u00020[0KH\u0003J\u0012\u0010n\u001a\u00020R2\b\u0010d\u001a\u0004\u0018\u00010oH\u0002J\b\u0010p\u001a\u00020RH\u0002J\u0010\u0010q\u001a\u00020R2\u0006\u0010r\u001a\u00020\fH\u0002J\b\u0010s\u001a\u00020RH\u0002J&\u0010t\u001a\b\u0012\u0004\u0012\u00020u0Z2\u0006\u0010d\u001a\u00020v2\u0006\u0010w\u001a\u00020\u00042\u0006\u0010t\u001a\u00020xH\u0017J\u0010\u0010y\u001a\u00020R2\u0006\u0010d\u001a\u00020vH\u0016J\u0010\u0010z\u001a\u00020R2\u0006\u0010{\u001a\u00020|H\u0016J\b\u0010}\u001a\u00020RH\u0016J\b\u0010~\u001a\u00020RH\u0016J\u0010\u0010\u001a\u00020R2\u0006\u0010{\u001a\u00020|H\u0016J\u0011\u0010\u0001\u001a\u00020R2\u0006\u0010d\u001a\u00020\u0004H\u0016J\u0012\u0010\u0001\u001a\u00020R2\u0007\u0010\u0001\u001a\u00020\u0004H\u0016J\t\u0010\u0001\u001a\u00020RH\u0016J\t\u0010\u0001\u001a\u00020RH\u0016J\u0013\u0010\u0001\u001a\u00020R2\b\u0010\u0001\u001a\u00030\u0001H\u0016J\t\u0010\u0001\u001a\u00020RH\u0016J\u0011\u0010\u0001\u001a\u00020R2\u0006\u0010O\u001a\u00020PH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u00020\u001b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0010\u0010 \u001a\u00020!X\u0004¢\u0006\u0004\n\u0002\u0010\"R\u000e\u0010#\u001a\u00020$X.¢\u0006\u0002\n\u0000R\u001e\u0010%\u001a\u00020&8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020,X.¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\u00020\f8BX\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u001e\u00100\u001a\u0002018\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R+\u00108\u001a\u0002072\u0006\u00106\u001a\u0002078B@BX\u0002¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0010\u0010?\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u00020GX\u0004¢\u0006\u0004\n\u0002\u0010HR$\u0010I\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020M0Kj\u0002`N0JX.¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020PX.¢\u0006\u0002\n\u0000¨\u0006\u0001"}, d2 = {"Lcom/reddit/social/presentation/groupchat/presentation/GroupMessagingPresenter;", "Lcom/reddit/social/presentation/groupchat/ChatContract$Presenter;", "()V", "CHANNEL_NAME_DEFAULT_VALUE", "", "CHANNEL_URL_KEY", "ONE_ON_ONE_RECIPIENT_KEY", "RECIPIENT_ID_KEY", "RECIPIENT_USERNAME_KEY", "SHARE_TITLE_KEY", "SHARE_URL_KEY", "areMessagesLoading", "", "channelUrl", "chatAnalytics", "Lcom/reddit/social/analytics/ChatAnalytics;", "getChatAnalytics", "()Lcom/reddit/social/analytics/ChatAnalytics;", "setChatAnalytics", "(Lcom/reddit/social/analytics/ChatAnalytics;)V", "chatDataRepository", "Lcom/reddit/datalibrary/social/data/repo/ChatDataRepositoryContract;", "getChatDataRepository", "()Lcom/reddit/datalibrary/social/data/repo/ChatDataRepositoryContract;", "setChatDataRepository", "(Lcom/reddit/datalibrary/social/data/repo/ChatDataRepositoryContract;)V", "chatPerfAnalytics", "Lcom/reddit/social/analytics/ChatPerformanceAnalyticsContract;", "getChatPerfAnalytics", "()Lcom/reddit/social/analytics/ChatPerformanceAnalyticsContract;", "setChatPerfAnalytics", "(Lcom/reddit/social/analytics/ChatPerformanceAnalyticsContract;)V", "createChannelPathInitializer", "com/reddit/social/presentation/groupchat/presentation/GroupMessagingPresenter$createChannelPathInitializer$1", "Lcom/reddit/social/presentation/groupchat/presentation/GroupMessagingPresenter$createChannelPathInitializer$1;", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "failedMessagesCache", "Lcom/reddit/datalibrary/social/data/datasource/cache/FailedMessagesCacheContract;", "getFailedMessagesCache", "()Lcom/reddit/datalibrary/social/data/datasource/cache/FailedMessagesCacheContract;", "setFailedMessagesCache", "(Lcom/reddit/datalibrary/social/data/datasource/cache/FailedMessagesCacheContract;)V", "initializer", "Lcom/reddit/social/presentation/groupchat/presentation/GroupMessagingPresenter$Initializer;", "isChannelInfoLoading", "isShare", "()Z", "loadMessagesUseCase", "Lcom/reddit/social/domain/usecases/LoadMessagesUseCase;", "getLoadMessagesUseCase", "()Lcom/reddit/social/domain/usecases/LoadMessagesUseCase;", "setLoadMessagesUseCase", "(Lcom/reddit/social/domain/usecases/LoadMessagesUseCase;)V", "<set-?>", "", "maxMessageLength", "getMaxMessageLength", "()I", "setMaxMessageLength", "(I)V", "maxMessageLength$delegate", "Lkotlin/properties/ReadWriteProperty;", "oneOnOneRecipient", "recipientId", "recipientUsername", "shareLink", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "shareTitle", "shareUrl", "standardPathInitializer", "com/reddit/social/presentation/groupchat/presentation/GroupMessagingPresenter$standardPathInitializer$1", "Lcom/reddit/social/presentation/groupchat/presentation/GroupMessagingPresenter$standardPathInitializer$1;", "uploadedFilesStatus", "Lio/reactivex/subjects/PublishSubject;", "Lkotlin/Pair;", "Lcom/sendbird/android/FileMessage;", "Lcom/reddit/social/presentation/presentationobjects/SentStatus;", "Lcom/reddit/social/presentation/groupchat/presentation/FileMessageStatus;", "view", "Lcom/reddit/social/presentation/groupchat/ChatContract$View;", "createNewMessageObservable", "", "deleteMessage", "messageId", "", "requestId", "detach", "endTyping", "fetchUserData", "Lio/reactivex/Observable;", "Lcom/sendbird/android/BaseMessage;", "", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "pair", "fetchUsersData", "Lcom/reddit/social/domain/functions/RawMessagesBatch;", "Lcom/reddit/datalibrary/social/network/UserId;", "Lcom/reddit/datalibrary/social/data/datasource/cache/UserDataMap;", "batch", "message", "init", "channelName", "deepLink", "initView", "loadChatInfo", "loadMessages", "loadMoreMessages", "markChannelAsRead", "Lcom/sendbird/android/BaseChannel;", "markMessageFailed", "Lcom/sendbird/android/UserMessage;", "markMessagesAsRead", "networkConnectionChange", "isConnected", "reconnect", "reportMessage", "", "Lcom/reddit/social/presentation/presentationobjects/HasMessageData;", "reason", "Lcom/reddit/datalibrary/social/model/ReportMessage;", "resendMessage", "restore", "stateStorage", "Lcom/reddit/datalibrary/social/data/common/StateStorageContract;", "revealUsername", "revealUsernameRequested", "save", "sendClicked", "sendSnoomoji", "snoomoji", "settings", "startTyping", "uploadFileConfirmed", "uri", "Landroid/net/Uri;", "viewAttached", "viewCreated", "Initializer", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: GroupMessagingPresenter.kt */
public final class GroupMessagingPresenter implements Presenter {
    static final /* synthetic */ KProperty[] f29792a = new KProperty[]{Reflection.m26854a(new MutablePropertyReference1Impl(Reflection.m26850a(GroupMessagingPresenter.class), "maxMessageLength", "getMaxMessageLength()I"))};
    private final ReadWriteProperty f29793A;
    private final GroupMessagingPresenter$standardPathInitializer$1 f29794B;
    private final GroupMessagingPresenter$createChannelPathInitializer$1 f29795C;
    @Inject
    public ChatDataRepositoryContract f29796b;
    @Inject
    public ChatAnalytics f29797c;
    @Inject
    public LoadMessagesUseCase f29798d;
    @Inject
    public FailedMessagesCacheContract f29799e;
    @Inject
    public ChatPerformanceAnalyticsContract f29800f;
    private final String f29801g = "Group Channel";
    private final String f29802h = "CHANNEL_URL_KEY";
    private final String f29803i = "SHARE_TITLE_KEY";
    private final String f29804j = "SHARE_URL_KEY";
    private final String f29805k = "RECIPIENT_USERNAME_KEY";
    private final String f29806l = "RECIPIENT_ID_KEY";
    private final String f29807m = "ONE_ON_ONE_RECIPIENT_KEY";
    private CompositeDisposable f29808n;
    private PublishSubject<Pair<FileMessage, SentStatus>> f29809o;
    private View f29810p;
    private String f29811q;
    private String f29812r;
    private String f29813s;
    private Link f29814t;
    private String f29815u;
    private String f29816v;
    private String f29817w;
    private boolean f29818x;
    private boolean f29819y;
    private Initializer f29820z;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bb\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/reddit/social/presentation/groupchat/presentation/GroupMessagingPresenter$Initializer;", "", "init", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: GroupMessagingPresenter.kt */
    private interface Initializer {
        void mo5159a();
    }

    private final int m30790j() {
        return ((Number) this.f29793A.getValue(this, f29792a[0])).intValue();
    }

    public GroupMessagingPresenter() {
        Delegates delegates = Delegates.f25296a;
        this.f29793A = Delegates.m26877a();
        this.f29794B = new GroupMessagingPresenter$standardPathInitializer$1(this);
        this.f29795C = new GroupMessagingPresenter$createChannelPathInitializer$1(this);
        FrontpageApplication.m28878n().mo5095a(this);
    }

    public static final /* synthetic */ View m30774a(GroupMessagingPresenter groupMessagingPresenter) {
        groupMessagingPresenter = groupMessagingPresenter.f29810p;
        if (groupMessagingPresenter == null) {
            Intrinsics.m26844a("view");
        }
        return groupMessagingPresenter;
    }

    public static final /* synthetic */ CompositeDisposable m30798n(GroupMessagingPresenter groupMessagingPresenter) {
        groupMessagingPresenter = groupMessagingPresenter.f29808n;
        if (groupMessagingPresenter == null) {
            Intrinsics.m26844a("disposables");
        }
        return groupMessagingPresenter;
    }

    public final ChatDataRepositoryContract m30818g() {
        ChatDataRepositoryContract chatDataRepositoryContract = this.f29796b;
        if (chatDataRepositoryContract == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        return chatDataRepositoryContract;
    }

    public final ChatAnalytics m30819h() {
        ChatAnalytics chatAnalytics = this.f29797c;
        if (chatAnalytics == null) {
            Intrinsics.m26844a("chatAnalytics");
        }
        return chatAnalytics;
    }

    public final ChatPerformanceAnalyticsContract m30820i() {
        ChatPerformanceAnalyticsContract chatPerformanceAnalyticsContract = this.f29800f;
        if (chatPerformanceAnalyticsContract == null) {
            Intrinsics.m26844a("chatPerfAnalytics");
        }
        return chatPerformanceAnalyticsContract;
    }

    private final boolean m30793k() {
        return (TextUtils.isEmpty((CharSequence) this.f29812r) || TextUtils.isEmpty(this.f29813s)) ? false : true;
    }

    public final void mo5168a(String str, String str2) {
        Intrinsics.m26847b(str, "recipientId");
        Intrinsics.m26847b(str2, "recipientUsername");
        this.f29816v = str;
        this.f29815u = str2;
        this.f29820z = (Initializer) this.f29795C;
    }

    public final void mo5169a(String str, String str2, String str3, Link link) {
        Intrinsics.m26847b(str, "channelUrl");
        this.f29811q = str;
        this.f29812r = str2;
        this.f29813s = str3;
        this.f29814t = link;
        this.f29820z = (Initializer) this.f29794B;
    }

    public final void mo5166a(String str) {
        this.f29811q = str;
        this.f29820z = (Initializer) this.f29794B;
    }

    public final void mo5164a(View view) {
        Intrinsics.m26847b(view, "view");
        this.f29810p = view;
        this.f29793A.setValue(this, f29792a[0], Integer.valueOf(ChatSharedPreferencesUtil.m24747b()));
        this.f29808n = new CompositeDisposable();
        CompositeDisposable compositeDisposable = this.f29808n;
        if (compositeDisposable == null) {
            Intrinsics.m26844a("disposables");
        }
        ChatDataRepositoryContract chatDataRepositoryContract = this.f29796b;
        if (chatDataRepositoryContract == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        DisposableKt.m26766a(compositeDisposable, chatDataRepositoryContract.mo4516a((Function1) new GroupMessagingPresenter$viewCreated$1(view), (Function1) new GroupMessagingPresenter$viewCreated$2(this)));
        view = this.f29820z;
        if (view == null) {
            Intrinsics.m26844a("initializer");
        }
        view.mo5159a();
        Object create = PublishSubject.create();
        Intrinsics.m26843a(create, "PublishSubject.create<FileMessageStatus>()");
        this.f29809o = create;
        view = this.f29808n;
        if (view == null) {
            Intrinsics.m26844a("disposables");
        }
        PublishSubject publishSubject = this.f29809o;
        if (publishSubject == null) {
            Intrinsics.m26844a("uploadedFilesStatus");
        }
        Object subscribe = publishSubject.observeOn(SchedulerProvider.m23887c()).subscribe((Consumer) GroupMessagingPresenter$viewCreated$3.f29791a);
        Intrinsics.m26843a(subscribe, "uploadedFilesStatus\n    …us of sent file\n        }");
        DisposableKt.m26766a(view, subscribe);
        if (TextUtils.isEmpty((CharSequence) this.f29815u) == null) {
            String l = Util.m24042l(this.f29815u);
            View view2 = this.f29810p;
            if (view2 == null) {
                Intrinsics.m26844a("view");
            }
            Intrinsics.m26843a((Object) l, "username");
            view2.mo7555a(l, null);
            view2 = this.f29810p;
            if (view2 == null) {
                Intrinsics.m26844a("view");
            }
            view2.mo7560b(l);
        }
    }

    public final void mo5161a() {
        m30795l();
    }

    private final void m30795l() {
        String str = this.f29811q;
        if (str != null && !this.f29818x) {
            this.f29818x = true;
            CompositeDisposable compositeDisposable = this.f29808n;
            if (compositeDisposable == null) {
                Intrinsics.m26844a("disposables");
            }
            LoadMessagesUseCase loadMessagesUseCase = this.f29798d;
            if (loadMessagesUseCase == null) {
                Intrinsics.m26844a("loadMessagesUseCase");
            }
            Object subscribe = loadMessagesUseCase.m24494a(str, false).observeOn(SchedulerProvider.m23887c()).flatMap(new GroupMessagingPresenter$loadMessages$1(this, str)).observeOn(SchedulerProvider.m23887c()).doOnNext(new GroupMessagingPresenter$loadMessages$2(this)).doFinally(new GroupMessagingPresenter$loadMessages$3(this)).subscribe(new GroupMessagingPresenter$loadMessages$4(this, str), new GroupMessagingPresenter$loadMessages$5(this));
            Intrinsics.m26843a(subscribe, "loadMessagesUseCase.load…more messages\")\n        }");
            DisposableKt.m26766a(compositeDisposable, subscribe);
        }
    }

    private final void m30797m() {
        String str = this.f29811q;
        if (str != null && !this.f29819y) {
            this.f29819y = true;
            CompositeDisposable compositeDisposable = this.f29808n;
            if (compositeDisposable == null) {
                Intrinsics.m26844a("disposables");
            }
            ChatDataRepositoryContract chatDataRepositoryContract = this.f29796b;
            if (chatDataRepositoryContract == null) {
                Intrinsics.m26844a("chatDataRepository");
            }
            ObservableSource a = chatDataRepositoryContract.mo4506a(str);
            ChatDataRepositoryContract chatDataRepositoryContract2 = this.f29796b;
            if (chatDataRepositoryContract2 == null) {
                Intrinsics.m26844a("chatDataRepository");
            }
            Object subscribe = Observable.combineLatest(a, (ObservableSource) chatDataRepositoryContract2.mo4529e(str, false), (BiFunction) GroupMessagingPresenter$loadChatInfo$1.f29759a).subscribeOn(SchedulerProvider.m23886b()).observeOn(SchedulerProvider.m23887c()).doFinally(new GroupMessagingPresenter$loadChatInfo$2(this)).subscribe(new GroupMessagingPresenter$loadChatInfo$3(this), new GroupMessagingPresenter$loadChatInfo$4(this));
            Intrinsics.m26843a(subscribe, "Observable.combineLatest… channel info\")\n        }");
            DisposableKt.m26766a(compositeDisposable, subscribe);
        }
    }

    public final void mo5172b(String str) {
        String str2 = str;
        Intrinsics.m26847b(str2, "message");
        mo5177f();
        String str3 = this.f29811q;
        if (str3 != null) {
            String d = SessionUtil.m23898d();
            if (d != null) {
                CharSequence charSequence = str2;
                if (TextUtils.isEmpty(charSequence) && !m30793k()) {
                    return;
                }
                Object a;
                View view;
                if (str.length() > m30790j()) {
                    a = Util.m23960a((int) C1761R.string.fmt_chat_error_max_message_length, Integer.valueOf(m30790j()), Integer.valueOf(str.length()));
                    view = r0.f29810p;
                    if (view == null) {
                        Intrinsics.m26844a("view");
                    }
                    Intrinsics.m26843a(a, "errorMessage");
                    view.mo7566e(a);
                    return;
                }
                String sourceUrl;
                String str4 = null;
                ChatAnalytics chatAnalytics;
                if (m30793k()) {
                    String str5;
                    String str6 = "Reddit";
                    if (r0.f29814t == null || !(r0.f29814t instanceof ClientLink)) {
                        str5 = null;
                    } else {
                        ClientLink clientLink = (ClientLink) r0.f29814t;
                        if (clientLink != null) {
                            LinkPreview preview = clientLink.getPreview();
                            if (preview != null) {
                                sourceUrl = preview.getSourceUrl();
                                str5 = sourceUrl;
                            }
                        }
                        sourceUrl = null;
                        str5 = sourceUrl;
                    }
                    sourceUrl = new SendBirdDataV1(str2, r0.f29813s, false, null, str5, str6, r0.f29812r, null, null).toString();
                    r0.f29812r = null;
                    r0.f29813s = null;
                    str5 = r0.f29814t != null ? String.valueOf(Util.m23952a(r0.f29814t)) : null;
                    chatAnalytics = r0.f29797c;
                    if (chatAnalytics == null) {
                        Intrinsics.m26844a("chatAnalytics");
                    }
                    chatAnalytics.m24473a(str3, Kind.POST, r0.f29813s, str5, r0.f29812r);
                } else {
                    chatAnalytics = r0.f29797c;
                    if (chatAnalytics == null) {
                        Intrinsics.m26844a("chatAnalytics");
                    }
                    chatAnalytics.m24473a(str3, "text", null, null, null);
                    sourceUrl = (new Regex("\\s+").m28149b(charSequence).size() == 1 && Patterns.WEB_URL.matcher(charSequence).matches()) ? new SendBirdDataV1(str2, str2, false, null, null, null, null, null, null).toString() : null;
                }
                view = r0.f29810p;
                if (view == null) {
                    Intrinsics.m26844a("view");
                }
                view.mo7569h();
                Object a2 = BehaviorSubject.m38175a();
                CompositeDisposable compositeDisposable = r0.f29808n;
                if (compositeDisposable == null) {
                    Intrinsics.m26844a("disposables");
                }
                Observable map = a2.map(GroupMessagingPresenter$sendClicked$1.f29779a).flatMap(new GroupMessagingPresenterKt$sam$Function$a90a4364(new GroupMessagingPresenter$sendClicked$2(r0))).map(new SentMessageTransformer(d));
                Intrinsics.m26843a((Object) map, "tempMessage\n        .map…ansformer(currentUserId))");
                DisposableKt.m26766a(compositeDisposable, ObservablesKt.m24091a(map, (Function1) new GroupMessagingPresenter$sendClicked$3(r0)));
                if (sourceUrl == null) {
                    str4 = str2;
                }
                compositeDisposable = r0.f29808n;
                if (compositeDisposable == null) {
                    Intrinsics.m26844a("disposables");
                }
                ChatDataRepositoryContract chatDataRepositoryContract = r0.f29796b;
                if (chatDataRepositoryContract == null) {
                    Intrinsics.m26844a("chatDataRepository");
                }
                Intrinsics.m26843a(a2, "tempMessage");
                a = chatDataRepositoryContract.mo4511a(str3, str4, sourceUrl, a2).observeOn(SchedulerProvider.m23887c()).subscribe(new GroupMessagingPresenter$sendClicked$4(r0), new GroupMessagingPresenter$sendClicked$5(r0, a2, str3));
                Intrinsics.m26843a(a, "chatDataRepository.sendM…ll)\n          }\n        }");
                DisposableKt.m26766a(compositeDisposable, a);
            }
        }
    }

    public final void mo5174c(String str) {
        Intrinsics.m26847b(str, "snoomoji");
        String str2 = this.f29811q;
        if (str2 != null) {
            String d = SessionUtil.m23898d();
            if (d != null) {
                if (!TextUtils.isEmpty(str) || m30793k()) {
                    ChatAnalytics chatAnalytics = this.f29797c;
                    if (chatAnalytics == null) {
                        Intrinsics.m26844a("chatAnalytics");
                    }
                    Intrinsics.m26847b(str2, "channelUrl");
                    ChatDataRepositoryContract chatDataRepositoryContract = chatAnalytics.f22291a;
                    if (chatDataRepositoryContract == null) {
                        Intrinsics.m26844a("chatDataRepository");
                    }
                    ObservablesKt.m24091a(chatDataRepositoryContract.mo4506a(str2), (Function1) new ChatAnalytics$snoomoji$1(str2));
                    String sendBirdDataV1 = new SendBirdDataV1(null, this.f29813s, false, null, null, "Reddit", this.f29812r, null, str).toString();
                    ChatAnalytics chatAnalytics2 = this.f29797c;
                    if (chatAnalytics2 == null) {
                        Intrinsics.m26844a("chatAnalytics");
                    }
                    chatAnalytics2.m24473a(str2, "snoomoji", null, null, null);
                    Object a = BehaviorSubject.m38175a();
                    CompositeDisposable compositeDisposable = this.f29808n;
                    if (compositeDisposable == null) {
                        Intrinsics.m26844a("disposables");
                    }
                    Observable map = a.map(GroupMessagingPresenter$sendSnoomoji$1.f29784a).flatMap(new GroupMessagingPresenterKt$sam$Function$a90a4364(new GroupMessagingPresenter$sendSnoomoji$2(this))).map(new SentMessageTransformer(d));
                    Intrinsics.m26843a((Object) map, "tempMessage\n        .map…ansformer(currentUserId))");
                    DisposableKt.m26766a(compositeDisposable, ObservablesKt.m24091a(map, (Function1) new GroupMessagingPresenter$sendSnoomoji$3(this)));
                    compositeDisposable = this.f29808n;
                    if (compositeDisposable == null) {
                        Intrinsics.m26844a("disposables");
                    }
                    ChatDataRepositoryContract chatDataRepositoryContract2 = this.f29796b;
                    if (chatDataRepositoryContract2 == null) {
                        Intrinsics.m26844a("chatDataRepository");
                    }
                    Intrinsics.m26843a(a, "tempMessage");
                    Object subscribe = chatDataRepositoryContract2.mo4511a(str2, null, sendBirdDataV1, a).observeOn(SchedulerProvider.m23887c()).subscribe(new GroupMessagingPresenter$sendSnoomoji$4(this), new GroupMessagingPresenter$sendSnoomoji$5(this, a, str2));
                    Intrinsics.m26843a(subscribe, "chatDataRepository.sendM…ll, null, null)\n        }");
                    DisposableKt.m26766a(compositeDisposable, subscribe);
                }
            }
        }
    }

    public final void mo5165a(HasMessageData hasMessageData) {
        Intrinsics.m26847b(hasMessageData, "message");
        String d = SessionUtil.m23898d();
        if (d != null) {
            MessageData a = hasMessageData.mo5204a();
            FailedMessagesCacheContract failedMessagesCacheContract = this.f29799e;
            if (failedMessagesCacheContract == null) {
                Intrinsics.m26844a("failedMessagesCache");
            }
            failedMessagesCacheContract.remove(a.f22438k, a.f22428a);
            View view = this.f29810p;
            if (view == null) {
                Intrinsics.m26844a("view");
            }
            view.mo7552a(a.f22428a);
            String str = null;
            if (!(hasMessageData instanceof TextMessageData)) {
                hasMessageData = null;
            }
            TextMessageData textMessageData = (TextMessageData) hasMessageData;
            if (textMessageData != null) {
                str = textMessageData.f29964a;
            }
            Object a2 = BehaviorSubject.m38175a();
            CompositeDisposable compositeDisposable = this.f29808n;
            if (compositeDisposable == null) {
                Intrinsics.m26844a("disposables");
            }
            Observable map = a2.map(GroupMessagingPresenter$resendMessage$1.f29775a).flatMap(new GroupMessagingPresenterKt$sam$Function$a90a4364(new GroupMessagingPresenter$resendMessage$2(this))).map(new SentMessageTransformer(d));
            Intrinsics.m26843a((Object) map, "tempMessage\n        .map…ansformer(currentUserId))");
            DisposableKt.m26766a(compositeDisposable, ObservablesKt.m24091a(map, (Function1) new GroupMessagingPresenter$resendMessage$3(this)));
            CompositeDisposable compositeDisposable2 = this.f29808n;
            if (compositeDisposable2 == null) {
                Intrinsics.m26844a("disposables");
            }
            ChatDataRepositoryContract chatDataRepositoryContract = this.f29796b;
            if (chatDataRepositoryContract == null) {
                Intrinsics.m26844a("chatDataRepository");
            }
            String str2 = a.f22438k;
            String str3 = a.f22440m;
            Intrinsics.m26843a(a2, "tempMessage");
            a2 = chatDataRepositoryContract.mo4511a(str2, str, str3, a2).observeOn(SchedulerProvider.m23887c()).subscribe(new GroupMessagingPresenter$resendMessage$4(this), new GroupMessagingPresenter$resendMessage$5(this, a2));
            Intrinsics.m26843a(a2, "chatDataRepository.sendM…pMessage.value)\n        }");
            DisposableKt.m26766a(compositeDisposable2, a2);
        }
    }

    public final void mo5162a(Uri uri) {
        Intrinsics.m26847b(uri, "uri");
        String str = this.f29811q;
        if (str != null) {
            String d = SessionUtil.m23898d();
            if (d != null) {
                ChatDataRepositoryContract chatDataRepositoryContract = this.f29796b;
                if (chatDataRepositoryContract == null) {
                    Intrinsics.m26844a("chatDataRepository");
                }
                PublishSubject publishSubject = this.f29809o;
                if (publishSubject == null) {
                    Intrinsics.m26844a("uploadedFilesStatus");
                }
                Observable observeOn = chatDataRepositoryContract.mo4508a(str, uri, publishSubject).flatMap(new GroupMessagingPresenter$uploadFileConfirmed$1(this)).map(new SentMessageTransformer(d)).observeOn(SchedulerProvider.m23887c());
                Intrinsics.m26843a((Object) observeOn, "chatDataRepository.sendF…n(SchedulerProvider.ui())");
                ObservablesKt.m24091a(observeOn, (Function1) new GroupMessagingPresenter$uploadFileConfirmed$2(this));
            }
        }
    }

    public final void mo5170b() {
        String str = this.f29811q;
        if (str != null) {
            String d = SessionUtil.m23898d();
            if (d != null) {
                ChatDataRepositoryContract chatDataRepositoryContract = this.f29796b;
                if (chatDataRepositoryContract == null) {
                    Intrinsics.m26844a("chatDataRepository");
                }
                if (chatDataRepositoryContract.mo4532f()) {
                    View view = this.f29810p;
                    if (view == null) {
                        Intrinsics.m26844a("view");
                    }
                    view.mo7563d();
                    chatDataRepositoryContract = this.f29796b;
                    if (chatDataRepositoryContract == null) {
                        Intrinsics.m26844a("chatDataRepository");
                    }
                    Observable share = chatDataRepositoryContract.mo4536h(str).flatMap(new GroupMessagingPresenter$loadMoreMessages$messagesObservable$1(this)).map(new MessageListTransformer(d)).share();
                    CompositeDisposable compositeDisposable = this.f29808n;
                    if (compositeDisposable == null) {
                        Intrinsics.m26844a("disposables");
                    }
                    Object subscribe = share.observeOn(SchedulerProvider.m23887c()).subscribe(new GroupMessagingPresenter$loadMoreMessages$1(this), new GroupMessagingPresenter$loadMoreMessages$2(this));
                    Intrinsics.m26843a(subscribe, "messagesObservable\n     …_more_messages)\n        }");
                    DisposableKt.m26766a(compositeDisposable, subscribe);
                    compositeDisposable = this.f29808n;
                    if (compositeDisposable == null) {
                        Intrinsics.m26844a("disposables");
                    }
                    Observable flatMap = share.flatMap(new GroupMessagingPresenter$loadMoreMessages$3(this, str));
                    Intrinsics.m26843a((Object) flatMap, "messagesObservable.flatM…itory.groupChannel(url) }");
                    DisposableKt.m26766a(compositeDisposable, ObservablesKt.m24091a(flatMap, (Function1) new GroupMessagingPresenter$loadMoreMessages$4(this)));
                    return;
                }
                View view2 = this.f29810p;
                if (view2 == null) {
                    Intrinsics.m26844a("view");
                }
                view2.mo7565e();
            }
        }
    }

    public final void mo5167a(String str, long j, String str2) {
        Object subscribe;
        Intrinsics.m26847b(str, "channelUrl");
        Intrinsics.m26847b(str2, "requestId");
        CompositeDisposable compositeDisposable = this.f29808n;
        if (compositeDisposable == null) {
            Intrinsics.m26844a("disposables");
        }
        View view;
        if (j != 0) {
            str2 = this.f29796b;
            if (str2 == null) {
                Intrinsics.m26844a("chatDataRepository");
            }
            str = str2.mo4507a(str, j);
            view = this.f29810p;
            if (view == null) {
                Intrinsics.m26844a("view");
            }
            subscribe = str.subscribe(new GroupMessagingPresenterKt$sam$Consumer$34e35382((Function1) new GroupMessagingPresenter$deleteMessage$1(view)), (Consumer) new GroupMessagingPresenter$deleteMessage$2(this));
        } else {
            j = this.f29796b;
            if (j == null) {
                Intrinsics.m26844a("chatDataRepository");
            }
            str = j.mo4519b(str, str2);
            view = this.f29810p;
            if (view == null) {
                Intrinsics.m26844a("view");
            }
            subscribe = str.subscribe(new GroupMessagingPresenterKt$sam$Consumer$34e35382((Function1) new GroupMessagingPresenter$deleteMessage$3(view)), (Consumer) new GroupMessagingPresenter$deleteMessage$4(this));
        }
        Intrinsics.m26843a(subscribe, "if (messageId != 0L) {\n …delete)\n          }\n    }");
        DisposableKt.m26766a(compositeDisposable, subscribe);
    }

    public final Observable<Object> mo5160a(HasMessageData hasMessageData, String str, ReportMessage reportMessage) {
        Intrinsics.m26847b(hasMessageData, "message");
        Intrinsics.m26847b(str, "reason");
        Intrinsics.m26847b(reportMessage, "reportMessage");
        String str2 = this.f29811q;
        if (str2 == null) {
            throw ((Throwable) new Exception("channel url is null"));
        }
        MessageData a = hasMessageData.mo5204a();
        ChatAnalytics chatAnalytics;
        if (m30793k()) {
            String str3 = null;
            if (this.f29814t != null) {
                str3 = String.valueOf(Util.m23952a(this.f29814t));
            }
            String str4 = str3;
            chatAnalytics = this.f29797c;
            if (chatAnalytics == null) {
                Intrinsics.m26844a("chatAnalytics");
            }
            chatAnalytics.m24470a(str2, hasMessageData, this.f29813s, str4, this.f29812r);
        } else {
            chatAnalytics = this.f29797c;
            if (chatAnalytics == null) {
                Intrinsics.m26844a("chatAnalytics");
            }
            chatAnalytics.m24470a(str2, hasMessageData, null, null, null);
        }
        hasMessageData = this.f29796b;
        if (hasMessageData == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        return hasMessageData.mo4510a(a.f22432e, str, reportMessage);
    }

    public final void mo5173c() {
        String str = this.f29811q;
        if (str != null) {
            View view = this.f29810p;
            if (view == null) {
                Intrinsics.m26844a("view");
            }
            view.mo7241c(str);
        }
    }

    public final void mo5176e() {
        String str = this.f29811q;
        if (str != null) {
            ChatDataRepositoryContract chatDataRepositoryContract = this.f29796b;
            if (chatDataRepositoryContract == null) {
                Intrinsics.m26844a("chatDataRepository");
            }
            chatDataRepositoryContract.mo4554y(str);
        }
    }

    public final void mo5177f() {
        String str = this.f29811q;
        if (str != null) {
            ChatDataRepositoryContract chatDataRepositoryContract = this.f29796b;
            if (chatDataRepositoryContract == null) {
                Intrinsics.m26844a("chatDataRepository");
            }
            chatDataRepositoryContract.mo4555z(str);
        }
    }

    public final void mo5175d() {
        String str = this.f29811q;
        if (str != null) {
            mo5177f();
            ChatDataRepositoryContract chatDataRepositoryContract = this.f29796b;
            if (chatDataRepositoryContract == null) {
                Intrinsics.m26844a("chatDataRepository");
            }
            chatDataRepositoryContract.mo4549t(str);
            CompositeDisposable compositeDisposable = this.f29808n;
            if (compositeDisposable == null) {
                Intrinsics.m26844a("disposables");
            }
            compositeDisposable.mo5626a();
        }
    }

    public final void mo5163a(StateStorageContract stateStorageContract) {
        Intrinsics.m26847b(stateStorageContract, "stateStorage");
        String str = this.f29811q;
        if (str != null) {
            ChatDataRepositoryContract chatDataRepositoryContract = this.f29796b;
            if (chatDataRepositoryContract == null) {
                Intrinsics.m26844a("chatDataRepository");
            }
            chatDataRepositoryContract.mo4549t(str);
            stateStorageContract.mo4475a(this.f29802h, (CharSequence) str);
            str = this.f29812r;
            if (str != null) {
                stateStorageContract.mo4475a(this.f29803i, (CharSequence) str);
            }
            str = this.f29813s;
            if (str != null) {
                stateStorageContract.mo4475a(this.f29804j, (CharSequence) str);
            }
            str = this.f29815u;
            if (str != null) {
                stateStorageContract.mo4475a(this.f29805k, (CharSequence) str);
            }
            str = this.f29817w;
            if (str != null) {
                stateStorageContract.mo4475a(this.f29807m, (CharSequence) str);
            }
            str = this.f29816v;
            if (str != null) {
                stateStorageContract.mo4475a(this.f29806l, (CharSequence) str);
            }
        }
    }

    public final void mo5171b(StateStorageContract stateStorageContract) {
        Intrinsics.m26847b(stateStorageContract, "stateStorage");
        this.f29811q = (String) stateStorageContract.mo4474a(this.f29802h);
        this.f29812r = stateStorageContract.mo4477b(this.f29803i);
        this.f29813s = stateStorageContract.mo4477b(this.f29804j);
        this.f29815u = stateStorageContract.mo4477b(this.f29805k);
        this.f29817w = stateStorageContract.mo4477b(this.f29807m);
        this.f29816v = stateStorageContract.mo4477b(this.f29806l);
        if (this.f29811q != null) {
            this.f29820z = (Initializer) this.f29794B;
        } else {
            this.f29820z = (Initializer) this.f29795C;
        }
    }

    public static final /* synthetic */ void m30781a(GroupMessagingPresenter groupMessagingPresenter, boolean z) {
        View view = groupMessagingPresenter.f29810p;
        if (view == null) {
            Intrinsics.m26844a("view");
        }
        view.mo7557a(z);
        if (z) {
            z = groupMessagingPresenter.f29810p;
            if (!z) {
                Intrinsics.m26844a("view");
            }
            z.mo7547a();
            groupMessagingPresenter.m30795l();
            groupMessagingPresenter.m30797m();
            return;
        }
        z = SessionUtil.m23898d();
        if (z) {
            groupMessagingPresenter = groupMessagingPresenter.f29796b;
            if (groupMessagingPresenter == null) {
                Intrinsics.m26844a("chatDataRepository");
            }
            groupMessagingPresenter.mo4548s(z);
        }
    }

    public static final /* synthetic */ Observable m30778a(Pair pair) {
        BaseChannel baseChannel = (BaseChannel) pair.f25267a;
        if (!(baseChannel instanceof GroupChannel)) {
            baseChannel = null;
        }
        GroupChannel groupChannel = (GroupChannel) baseChannel;
        if (groupChannel != null) {
            groupChannel.m30987q();
        }
        Object just = Observable.just(pair.f25268b);
        Intrinsics.m26843a(just, "Observable.just(pair.second)");
        return just;
    }

    public static final /* synthetic */ Observable m30776a(GroupMessagingPresenter groupMessagingPresenter, BaseMessage baseMessage) {
        User b = ChatUtilKt.m24757b(baseMessage);
        String d = b != null ? b.m25021d() : null;
        groupMessagingPresenter = groupMessagingPresenter.f29796b;
        if (groupMessagingPresenter == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        Object map = groupMessagingPresenter.mo4515a(SetsKt__SetsKt.m26800a((Object) d)).map(new GroupMessagingPresenter$fetchUsersData$1(baseMessage, d));
        Intrinsics.m26843a(map, "chatDataRepository.users…message to it[senderId] }");
        return map;
    }

    public static final /* synthetic */ void m30782b(GroupMessagingPresenter groupMessagingPresenter) {
        String str = groupMessagingPresenter.f29811q;
        if (str != null) {
            CompositeDisposable compositeDisposable = groupMessagingPresenter.f29808n;
            if (compositeDisposable == null) {
                Intrinsics.m26844a("disposables");
            }
            ChatDataRepositoryContract chatDataRepositoryContract = groupMessagingPresenter.f29796b;
            if (chatDataRepositoryContract == null) {
                Intrinsics.m26844a("chatDataRepository");
            }
            DisposableKt.m26766a(compositeDisposable, ObservablesKt.m24091a(chatDataRepositoryContract.mo4506a(str), (Function1) new GroupMessagingPresenter$markMessagesAsRead$1(groupMessagingPresenter)));
        }
    }

    public static final /* synthetic */ Observable m30777a(GroupMessagingPresenter groupMessagingPresenter, Pair pair) {
        SentStatus sentStatus = (SentStatus) pair.f25267a;
        BaseMessage baseMessage = (BaseMessage) pair.f25268b;
        User b = ChatUtilKt.m24757b(baseMessage);
        Object d = b != null ? b.m25021d() : null;
        groupMessagingPresenter = groupMessagingPresenter.f29796b;
        if (groupMessagingPresenter == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        Object map = groupMessagingPresenter.mo4515a(SetsKt__SetsKt.m26800a(d)).map(new GroupMessagingPresenter$fetchUserData$1(sentStatus, baseMessage));
        Intrinsics.m26843a(map, "chatDataRepository.users… to (baseMessage to it) }");
        return map;
    }

    public static final /* synthetic */ void m30779a(GroupMessagingPresenter groupMessagingPresenter, UserMessage userMessage) {
        if (userMessage != null) {
            FailedMessagesCacheContract failedMessagesCacheContract = groupMessagingPresenter.f29799e;
            if (failedMessagesCacheContract == null) {
                Intrinsics.m26844a("failedMessagesCache");
            }
            Object h = userMessage.m24880h();
            Intrinsics.m26843a(h, "it.channelUrl");
            failedMessagesCacheContract.add(h, userMessage);
            groupMessagingPresenter = groupMessagingPresenter.f29810p;
            if (groupMessagingPresenter == null) {
                Intrinsics.m26844a("view");
            }
            String j = userMessage.m31084j();
            Intrinsics.m26843a((Object) j, "it.requestId");
            groupMessagingPresenter.mo7554a(j, SentStatus.f22462c);
        }
    }

    public static final /* synthetic */ Observable m30775a(GroupMessagingPresenter groupMessagingPresenter, RawMessagesBatch rawMessagesBatch) {
        groupMessagingPresenter = groupMessagingPresenter.f29796b;
        if (groupMessagingPresenter == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        Object map = groupMessagingPresenter.mo4515a(ChatUtilKt.m24753a(rawMessagesBatch.f22304a)).map(new GroupMessagingPresenter$fetchUsersData$2(rawMessagesBatch));
        Intrinsics.m26843a(map, "chatDataRepository.users…     .map { batch to it }");
        return map;
    }

    public static final /* synthetic */ void m30791j(GroupMessagingPresenter groupMessagingPresenter) {
        String str = groupMessagingPresenter.f29811q;
        if (str != null) {
            String d = SessionUtil.m23898d();
            if (d != null) {
                CompositeDisposable compositeDisposable = groupMessagingPresenter.f29808n;
                if (compositeDisposable == null) {
                    Intrinsics.m26844a("disposables");
                }
                ChatDataRepositoryContract chatDataRepositoryContract = groupMessagingPresenter.f29796b;
                if (chatDataRepositoryContract == null) {
                    Intrinsics.m26844a("chatDataRepository");
                }
                Observable observeOn = chatDataRepositoryContract.mo4538i(str).flatMap(new GroupMessagingPresenter$createNewMessageObservable$1(groupMessagingPresenter)).flatMap(new GroupMessagingPresenter$createNewMessageObservable$2(groupMessagingPresenter)).map(new MessageTransformer(d)).observeOn(SchedulerProvider.m23887c());
                Intrinsics.m26843a((Object) observeOn, "chatDataRepository.newMe…n(SchedulerProvider.ui())");
                DisposableKt.m26766a(compositeDisposable, ObservablesKt.m24091a(observeOn, (Function1) new GroupMessagingPresenter$createNewMessageObservable$3(groupMessagingPresenter)));
                CompositeDisposable compositeDisposable2 = groupMessagingPresenter.f29808n;
                if (compositeDisposable2 == null) {
                    Intrinsics.m26844a("disposables");
                }
                ChatDataRepositoryContract chatDataRepositoryContract2 = groupMessagingPresenter.f29796b;
                if (chatDataRepositoryContract2 == null) {
                    Intrinsics.m26844a("chatDataRepository");
                }
                Observable observeOn2 = chatDataRepositoryContract2.mo4539j(str).observeOn(SchedulerProvider.m23887c());
                Intrinsics.m26843a((Object) observeOn2, "chatDataRepository.typin…n(SchedulerProvider.ui())");
                DisposableKt.m26766a(compositeDisposable2, ObservablesKt.m24091a(observeOn2, (Function1) new GroupMessagingPresenter$createNewMessageObservable$4(groupMessagingPresenter)));
            }
        }
    }
}
