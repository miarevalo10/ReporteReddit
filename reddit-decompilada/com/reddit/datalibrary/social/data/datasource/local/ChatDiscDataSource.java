package com.reddit.datalibrary.social.data.datasource.local;

import android.os.Handler;
import android.os.HandlerThread;
import com.google.gson.JsonElement;
import com.reddit.datalibrary.social.model.ChannelMuteStatus;
import com.reddit.datalibrary.social.model.ChatEnabled;
import com.reddit.datalibrary.social.model.Contact;
import com.reddit.datalibrary.social.model.User;
import com.reddit.datalibrary.social.model.UserBriefData;
import com.reddit.frontpage.util.SessionUtil;
import com.reddit.social.domain.functions.RawMessagesBatch;
import com.reddit.social.presentation.presentationobjects.SentStatus;
import com.reddit.social.util.ChatSerializer;
import com.reddit.social.util.ChatSharedPreferencesUtil;
import com.sendbird.android.BaseChannel;
import com.sendbird.android.BaseMessage;
import com.sendbird.android.FileMessage;
import com.sendbird.android.FileMessage.ThumbnailSize;
import com.sendbird.android.GroupChannel;
import com.sendbird.android.Member;
import com.sendbird.android.UserMessage;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J$\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u000e2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000fH\u0016J\u001c\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u000e2\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J3\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00120\u000e2\u0006\u0010\u0014\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0015\u001a\u00020\u000fH\u0016¢\u0006\u0002\u0010\u001dJ&\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00122\b\u0010!\u001a\u0004\u0018\u00010\u0004H\u0016J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\u001e\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u000e2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$H\u0016J\u0010\u0010&\u001a\u00020'2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J$\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0\u00120\u000e2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000fH\u0016J\u001e\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u000e2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000fH\u0016J\b\u0010-\u001a\u00020\u000fH\u0016J\b\u0010.\u001a\u00020\u000fH\u0016J\b\u0010/\u001a\u00020\u000fH\u0016J\u0016\u00100\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J$\u00101\u001a\b\u0012\u0004\u0012\u0002020\u000e2\u0006\u0010\u0010\u001a\u00020\u00042\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0012H\u0016J\u0016\u00103\u001a\b\u0012\u0004\u0012\u0002040\u000e2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\u000e\u00105\u001a\b\u0012\u0004\u0012\u0002060\u000eH\u0016J\b\u00107\u001a\u00020\u000fH\u0016J\u0016\u00108\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\u0016\u00109\u001a\b\u0012\u0004\u0012\u00020,0\u000e2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J4\u0010:\u001a&\u0012\f\u0012\n <*\u0004\u0018\u00010;0; <*\u0012\u0012\f\u0012\n <*\u0004\u0018\u00010;0;\u0018\u00010\u000e0\u000e2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\"\u0010=\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020@0>0\u000e2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\u001e\u0010A\u001a\u00020'2\u0006\u0010\u0014\u001a\u00020\u00042\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016J&\u0010C\u001a\u00020'2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\f\u0010D\u001a\b\u0012\u0004\u0012\u00020@0\u0012H\u0016J\u001e\u0010E\u001a\u00020'2\u0006\u0010\u0014\u001a\u00020\u00042\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016J\u0001\u0010F\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020@0>0\u000e2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\u00042\u0006\u0010K\u001a\u00020\u00042\u0006\u0010L\u001a\u00020\u001c2\b\u0010M\u001a\u0004\u0018\u00010\u00042\b\u0010N\u001a\u0004\u0018\u00010\u00042\u000e\u0010O\u001a\n\u0012\u0006\b\u0001\u0012\u00020Q0P2\u001c\u0010R\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020G0>j\u0002`U0SH\u0016J8\u0010V\u001a\b\u0012\u0004\u0012\u00020W0\u000e2\u0006\u0010\u0010\u001a\u00020\u00042\b\u0010X\u001a\u0004\u0018\u00010\u00042\b\u0010M\u001a\u0004\u0018\u00010\u00042\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020W0ZH\u0016J\u001e\u0010[\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010J\u001a\u00020\u0004H\u0016J\u000e\u0010\\\u001a\b\u0012\u0004\u0012\u00020;0\u000eH\u0016J\u001e\u0010]\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010^\u001a\u00020\u000fH\u0016J\u0010\u0010_\u001a\u00020'2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\u000e\u0010`\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000eH\u0016J\u001c\u0010a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0\u00120\u000e2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J$\u0010b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u000e2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000fH\u0016J\u0016\u0010c\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J4\u0010d\u001a&\u0012\f\u0012\n <*\u0004\u0018\u00010;0; <*\u0012\u0012\f\u0012\n <*\u0004\u0018\u00010;0;\u0018\u00010\u000e0\u000e2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\u001c\u0010e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u000e2\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J,\u0010f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0004j\u0002`h\u0012\u0004\u0012\u00020i0g0\u000e2\f\u0010j\u001a\b\u0012\u0004\u0012\u00020\u00040kH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006¨\u0006l"}, d2 = {"Lcom/reddit/datalibrary/social/data/datasource/local/ChatDiscDataSource;", "Lcom/reddit/datalibrary/social/data/datasource/local/ChatDiscDataSourceContract;", "()V", "acceptedChannelType", "", "getAcceptedChannelType", "()Ljava/lang/String;", "currentUserId", "getCurrentUserId", "setCurrentUserId", "(Ljava/lang/String;)V", "unacceptedChannelType", "getUnacceptedChannelType", "acceptInvite", "Lio/reactivex/Observable;", "", "channelUrl", "acceptedGroupChannels", "", "Lcom/sendbird/android/GroupChannel;", "userId", "refresh", "acceptedGroupChannelsWithMore", "areNotificationsEnabledSendbird", "blockUser", "contacts", "Lcom/reddit/datalibrary/social/model/Contact;", "limit", "", "(Ljava/lang/String;Ljava/lang/Integer;Z)Lio/reactivex/Observable;", "createChannel", "users", "Lcom/reddit/datalibrary/social/model/User;", "channelName", "declineInvite", "deleteMessage", "", "messageId", "endTyping", "", "getGroupChannel", "getMembers", "Lcom/sendbird/android/Member;", "groupMessages", "Lcom/reddit/social/domain/functions/RawMessagesBatch;", "hasMoreAcceptedChannels", "hasMoreMessages", "hasMoreUnacceptedChannels", "hideChannel", "inviteToChannel", "Lcom/google/gson/JsonElement;", "isChannelMuted", "Lcom/reddit/datalibrary/social/model/ChannelMuteStatus;", "isChatEnabled", "Lcom/reddit/datalibrary/social/model/ChatEnabled;", "isLoadingUnacceptedChannels", "leaveChannel", "moreGroupMessages", "muteChannel", "", "kotlin.jvm.PlatformType", "newMessageObservable", "Lkotlin/Pair;", "Lcom/sendbird/android/BaseChannel;", "Lcom/sendbird/android/BaseMessage;", "saveAcceptedGroupChannels", "groupChannels", "saveMessages", "messages", "saveUnacceptedGroupChannels", "sendFileMessage", "Lcom/reddit/social/presentation/presentationobjects/SentStatus;", "file", "Ljava/io/File;", "name", "type", "size", "data", "customType", "thumbnailSizes", "", "Lcom/sendbird/android/FileMessage$ThumbnailSize;", "messagesStatus", "Lio/reactivex/subjects/PublishSubject;", "Lcom/sendbird/android/FileMessage;", "Lcom/reddit/social/presentation/groupchat/presentation/FileMessageStatus;", "sendMessage", "Lcom/sendbird/android/UserMessage;", "message", "tempMessage", "Lio/reactivex/subjects/BehaviorSubject;", "setChannelName", "setChatEnabled", "setNotificationsEnabledSendbird", "enable", "startTyping", "totalUnreadMessageCount", "typingStatusObservable", "unacceptedGroupChannels", "unblockUser", "unmuteChannel", "unnacceptedGroupChannelsWithMore", "userDataByAccountIds", "", "Lcom/reddit/datalibrary/social/network/UserId;", "Lcom/reddit/datalibrary/social/model/UserBriefData;", "usersId", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ChatDiscDataSource.kt */
public final class ChatDiscDataSource implements ChatDiscDataSourceContract {
    final String f33458a = "accepted";
    final String f33459b = "unaccepted";
    private String f33460c;

    public final boolean mo6390a() {
        return false;
    }

    public final boolean mo6393b() {
        return false;
    }

    public final boolean mo6396c() {
        return false;
    }

    public final boolean mo6402e() {
        return false;
    }

    public static void m34245a(String str, String str2, List<? extends BaseMessage> list) {
        Intrinsics.m26847b(str, "userId");
        Intrinsics.m26847b(str2, "channelUrl");
        Intrinsics.m26847b(list, "messages");
        HandlerThread handlerThread = new HandlerThread("SaveMessagesHandler");
        handlerThread.start();
        new Handler(handlerThread.getLooper()).post(new ChatDiscDataSource$saveMessages$1(str, str2, list));
    }

    public final Observable<GroupChannel> mo6381a(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        String d = SessionUtil.m23898d();
        if (d == null) {
            Object empty = Observable.empty();
            Intrinsics.m26843a(empty, "Observable.empty<GroupChannel>()");
            return empty;
        }
        empty = Observable.zip(mo6387a(d, false), mo6392b(d, false), ChatDiscDataSource$getGroupChannel$combine$1.f27258a).flatMap(ChatDiscDataSource$getGroupChannel$1.f27256a).filter(new ChatDiscDataSource$getGroupChannel$2(str));
        Intrinsics.m26843a(empty, "Observable.zip(acceptedG… { it.url == channelUrl }");
        return empty;
    }

    public final Observable<Boolean> mo6407h(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        Object error = Observable.error((Throwable) new IllegalStateException("Cannot accept invite without a network connection"));
        Intrinsics.m26843a(error, "Observable.error(Illegal…t a network connection\"))");
        return error;
    }

    public final Observable<Boolean> mo6408i(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        Object error = Observable.error((Throwable) new IllegalStateException("Cannot decline invite without a network connection"));
        Intrinsics.m26843a(error, "Observable.error(Illegal…t a network connection\"))");
        return error;
    }

    public final Observable<List<GroupChannel>> mo6387a(String str, boolean z) {
        Intrinsics.m26847b(str, "userId");
        str = SessionUtil.m23898d();
        if (str == null) {
            Object empty = Observable.empty();
            Intrinsics.m26843a(empty, "Observable.empty<List<GroupChannel>>()");
            return empty;
        }
        if (this.f33460c) {
            if (!StringsKt__StringsJVMKt.m41946a((String) this.f33460c, str, true)) {
                empty = Observable.empty();
                Intrinsics.m26843a(empty, "Observable.empty<List<GroupChannel>>()");
                return empty;
            }
        }
        this.f33460c = str;
        empty = Observable.just(ChatSerializer.m24741b(this.f33460c, this.f33458a));
        Intrinsics.m26843a(empty, "Observable.just(ChatSeri…Id, acceptedChannelType))");
        return empty;
    }

    public final Observable<List<GroupChannel>> mo6391b(String str) {
        Intrinsics.m26847b(str, "userId");
        Object error = Observable.error((Throwable) new IllegalStateException("Cannot load more accepted group channels without a network connection"));
        Intrinsics.m26843a(error, "Observable.error(Illegal…t a network connection\"))");
        return error;
    }

    public final Observable<List<GroupChannel>> mo6392b(String str, boolean z) {
        Intrinsics.m26847b(str, "userId");
        str = SessionUtil.m23898d();
        if (str == null) {
            Object empty = Observable.empty();
            Intrinsics.m26843a(empty, "Observable.empty<List<GroupChannel>>()");
            return empty;
        }
        if (this.f33460c) {
            if (!StringsKt__StringsJVMKt.m41946a((String) this.f33460c, str, true)) {
                empty = Observable.empty();
                Intrinsics.m26843a(empty, "Observable.empty<List<GroupChannel>>()");
                return empty;
            }
        }
        this.f33460c = str;
        empty = Observable.just(ChatSerializer.m24741b(this.f33460c, this.f33459b));
        Intrinsics.m26843a(empty, "Observable.just(ChatSeri…, unacceptedChannelType))");
        return empty;
    }

    public final Observable<List<GroupChannel>> mo6394c(String str) {
        Intrinsics.m26847b(str, "userId");
        Object error = Observable.error((Throwable) new IllegalStateException("Cannot set channel name without a network connection"));
        Intrinsics.m26843a(error, "Observable.error<List<Gr…t a network connection\"))");
        return error;
    }

    public final Observable<Boolean> mo6384a(String str, String str2) {
        Intrinsics.m26847b(str, "channelUrl");
        Intrinsics.m26847b(str2, "name");
        Object error = Observable.error((Throwable) new IllegalStateException("Cannot set channel name without a network connection"));
        Intrinsics.m26843a(error, "Observable.error(Illegal…t a network connection\"))");
        return error;
    }

    public final Observable<List<Contact>> mo6398d(String str) {
        Intrinsics.m26847b(str, "userId");
        Object error = Observable.error((Throwable) new IllegalStateException("Cannot get contacts without a network connection"));
        Intrinsics.m26843a(error, "Observable.error(Illegal…t a network connection\"))");
        return error;
    }

    public final Observable<String> mo6388a(List<User> list, String str) {
        Intrinsics.m26847b(list, "users");
        Object error = Observable.error((Throwable) new IllegalStateException("Cannot create channel without a network connection"));
        Intrinsics.m26843a(error, "Observable.error<String>…t a network connection\"))");
        return error;
    }

    public final Observable<JsonElement> mo6386a(String str, List<User> list) {
        Intrinsics.m26847b(str, "channelUrl");
        Intrinsics.m26847b(list, "users");
        Object error = Observable.error((Throwable) new IllegalStateException("Cannot invite users to channel without a network connection"));
        Intrinsics.m26843a(error, "Observable.error(Illegal…t a network connection\"))");
        return error;
    }

    public final Observable<RawMessagesBatch> mo6395c(String str, boolean z) {
        Intrinsics.m26847b(str, "channelUrl");
        z = SessionUtil.m23898d();
        if (z) {
            Object a = ChatSerializer.m24738a(z, str);
            Intrinsics.m26843a(a, "messages");
            a = Observable.just(new RawMessagesBatch(a, false));
            Intrinsics.m26843a(a, "Observable.just(RawMessa…ages, hasMoreMessages()))");
            return a;
        }
        a = Observable.empty();
        Intrinsics.m26843a(a, "Observable.empty()");
        return a;
    }

    public final Observable<Integer> mo6397d() {
        Object just = Observable.just(Integer.valueOf(ChatSharedPreferencesUtil.m24742a()));
        Intrinsics.m26843a(just, "Observable.just(ChatShar…getUnreadMessagesCount())");
        return just;
    }

    public final Observable<RawMessagesBatch> mo6400e(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        Object empty = Observable.empty();
        Intrinsics.m26843a(empty, "Observable.empty()");
        return empty;
    }

    public final Observable<Pair<BaseChannel, BaseMessage>> mo6404f(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        Object empty = Observable.empty();
        Intrinsics.m26843a(empty, "Observable.empty<Pair<BaseChannel, BaseMessage>>()");
        return empty;
    }

    public final Observable<List<Member>> mo6406g(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        Object empty = Observable.empty();
        Intrinsics.m26843a(empty, "Observable.empty()");
        return empty;
    }

    public final Observable<UserMessage> mo6385a(String str, String str2, String str3, BehaviorSubject<UserMessage> behaviorSubject) {
        Intrinsics.m26847b(str, "channelUrl");
        Intrinsics.m26847b(behaviorSubject, "tempMessage");
        Object error = Observable.error((Throwable) new IllegalStateException("Cannot send messages without a network connection"));
        Intrinsics.m26843a(error, "Observable.error(Illegal…t a network connection\"))");
        return error;
    }

    public final Observable<Pair<SentStatus, BaseMessage>> mo6383a(String str, File file, String str2, String str3, int i, List<? extends ThumbnailSize> list, PublishSubject<Pair<FileMessage, SentStatus>> publishSubject) {
        Intrinsics.m26847b(str, "channelUrl");
        Intrinsics.m26847b(file, "file");
        Intrinsics.m26847b(str2, "name");
        Intrinsics.m26847b(str3, "type");
        Intrinsics.m26847b(list, "thumbnailSizes");
        Intrinsics.m26847b(publishSubject, "messagesStatus");
        Object error = Observable.error((Throwable) new IllegalStateException("Cannot send messages without a network connection"));
        Intrinsics.m26843a(error, "Observable.error(Illegal…t a network connection\"))");
        return error;
    }

    public final Observable<Long> mo6382a(String str, long j) {
        Intrinsics.m26847b(str, "channelUrl");
        Object error = Observable.error((Throwable) new IllegalStateException("Cannot delete messages without a network connection"));
        Intrinsics.m26843a(error, "Observable.error<Long>(I…t a network connection\"))");
        return error;
    }

    public final Observable<Boolean> mo6409j(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        Object error = Observable.error((Throwable) new IllegalStateException("Cannot access notification settings without a network connection"));
        Intrinsics.m26843a(error, "Observable.error<Boolean…t a network connection\"))");
        return error;
    }

    public final Observable<Boolean> mo6399d(String str, boolean z) {
        Intrinsics.m26847b(str, "channelUrl");
        Object error = Observable.error((Throwable) new IllegalStateException("Cannot configure notification settings without a network connection"));
        Intrinsics.m26843a(error, "Observable.error<Boolean…t a network connection\"))");
        return error;
    }

    public final Observable<List<Member>> mo6401e(String str, boolean z) {
        Intrinsics.m26847b(str, "channelUrl");
        Object error = Observable.error((Throwable) new IllegalStateException("Cannot get members without a network connection"));
        Intrinsics.m26843a(error, "Observable.error<List<Me…t a network connection\"))");
        return error;
    }

    public final Observable<Boolean> mo6410k(String str) {
        Intrinsics.m26847b(str, "userId");
        Object error = Observable.error((Throwable) new IllegalStateException("Cannot block users without a network connection"));
        Intrinsics.m26843a(error, "Observable.error<Boolean…t a network connection\"))");
        return error;
    }

    public final Observable<Boolean> mo6411l(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        Object error = Observable.error((Throwable) new IllegalStateException("Cannot leave group without a network connection"));
        Intrinsics.m26843a(error, "Observable.error<Boolean…t a network connection\"))");
        return error;
    }

    public final Observable<Boolean> mo6412m(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        Object error = Observable.error((Throwable) new IllegalStateException("Cannot hide chat without a network connection"));
        Intrinsics.m26843a(error, "Observable.error<Boolean…t a network connection\"))");
        return error;
    }

    public final Observable<Map<String, UserBriefData>> mo6389a(Set<String> set) {
        Intrinsics.m26847b(set, "usersId");
        Object error = Observable.error((Throwable) new IllegalStateException("Cannot get users data without a network connection"));
        Intrinsics.m26843a(error, "Observable.error<Map<Use…t a network connection\"))");
        return error;
    }

    public final Observable<ChannelMuteStatus> mo6413n(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        Object error = Observable.error((Throwable) new IllegalStateException("Cannot see if channel is muted without a network connection"));
        Intrinsics.m26843a(error, "Observable.error<Channel…t a network connection\"))");
        return error;
    }

    public final Observable<Object> mo6414o(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        return Observable.error((Throwable) new IllegalStateException("Cannot mute a channel without a network connection"));
    }

    public final Observable<Object> mo6415p(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        return Observable.error((Throwable) new IllegalStateException("Cannot unmute a channel without a network connection"));
    }

    public final Observable<ChatEnabled> mo6403f() {
        Object error = Observable.error((Throwable) new IllegalStateException("Cannot check if chat enabled for user without a network connection"));
        Intrinsics.m26843a(error, "Observable.error<ChatEna…t a network connection\"))");
        return error;
    }

    public final Observable<Object> mo6405g() {
        Object error = Observable.error((Throwable) new IllegalStateException("Cannot enable chat for user without a network connection"));
        Intrinsics.m26843a(error, "Observable.error<Any>(Il…t a network connection\"))");
        return error;
    }

    public final void mo6416q(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        Timber.e("Cannot call startTyping() without a network connection", new Object[0]);
    }

    public final void mo6417r(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        Timber.e("Cannot call endTyping() without a network connection", new Object[0]);
    }
}
