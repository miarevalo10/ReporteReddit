package com.reddit.datalibrary.social.data.repo;

import android.net.Uri;
import com.google.gson.JsonElement;
import com.reddit.datalibrary.social.model.ChannelMuteStatus;
import com.reddit.datalibrary.social.model.ChatEnabled;
import com.reddit.datalibrary.social.model.ReportMessage;
import com.reddit.datalibrary.social.model.User;
import com.reddit.social.domain.functions.RawMessagesBatch;
import com.reddit.social.presentation.presentationobjects.ContactData;
import com.reddit.social.presentation.presentationobjects.SentStatus;
import com.reddit.social.presentation.presentationobjects.UserData;
import com.sendbird.android.BaseChannel;
import com.sendbird.android.BaseMessage;
import com.sendbird.android.FileMessage;
import com.sendbird.android.GroupChannel;
import com.sendbird.android.Member;
import com.sendbird.android.UserMessage;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J$\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00032\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0004H&J\u001c\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00032\u0006\u0010\n\u001a\u00020\u0006H&J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0006H&J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\n\u001a\u00020\u0006H&J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006H&J3\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\b0\u00032\u0006\u0010\n\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0002\u0010\u0017J(\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0006H&J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u001e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0006H&J\u001e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 H&J\u0010\u0010\"\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0006H&J$\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\b0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0004H&J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060&2\u0006\u0010'\u001a\u00020\u0006H&J\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u001e\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0004H&J0\u0010+\u001a\u00020,2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110.2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110.H&J\b\u00100\u001a\u00020\u0004H&J\b\u00101\u001a\u00020\u0004H&J\b\u00102\u001a\u00020\u0004H&J\u0016\u00103\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J$\u00104\u001a\b\u0012\u0004\u0012\u0002050\u00032\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\bH&J\u0016\u00106\u001a\b\u0012\u0004\u0012\u0002070\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u000e\u00108\u001a\b\u0012\u0004\u0012\u0002090\u0003H&J\b\u0010:\u001a\u00020\u0004H&J\u0016\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010<\u001a\b\u0012\u0004\u0012\u00020=0\u00032\u0006\u0010\u0012\u001a\u00020\u0006H&J\u0016\u0010>\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\u0006\u0010\u0012\u001a\u00020\u0006H&J\u0010\u0010?\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\tH&J\u0016\u0010@\u001a\b\u0012\u0004\u0012\u00020*0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u000e\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\"\u0010C\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020E0D0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J&\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010G\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\u00062\u0006\u0010F\u001a\u00020IH&J\u001e\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010G\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\u0006H&J\u000e\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00160\u0003H&J\u0010\u0010L\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u0006H&J\u0010\u0010M\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u0006H&J\u0010\u0010N\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0006H&J\\\u0010O\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020E0D0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010Q\u001a\u0004\u0018\u00010\u00062\b\u0010R\u001a\u0004\u0018\u00010\u00062\u0006\u0010S\u001a\u00020T2\u001c\u0010U\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020W\u0012\u0004\u0012\u00020P0Dj\u0002`X0VH&J8\u0010Y\u001a\b\u0012\u0004\u0012\u00020Z0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010Q\u001a\u0004\u0018\u00010\u00062\b\u0010R\u001a\u0004\u0018\u00010\u00062\f\u0010[\u001a\b\u0012\u0004\u0012\u00020Z0\\H&J\u001e\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010^\u001a\u00020\u0006H&J\u000e\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H&J\u001e\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010a\u001a\u00020\u0004H&J\u0010\u0010b\u001a\u00020\u00112\u0006\u0010c\u001a\u00020\u0016H&J\u0010\u0010d\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0006H&J\u000e\u0010e\u001a\b\u0012\u0004\u0012\u00020\u00160\u0003H&J\u001c\u0010f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020g0\b0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J$\u0010h\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00032\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0004H&J\u001c\u0010i\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00032\u0006\u0010\n\u001a\u00020\u0006H&J\u0016\u0010j\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0006H&J\u0016\u0010k\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J8\u0010l\u001a\u001c\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0006j\u0002`n\u0012\u0004\u0012\u00020$0mj\u0002`o0\u00032\u0014\u0010p\u001a\u0010\u0012\f\u0012\n\u0018\u00010\u0006j\u0004\u0018\u0001`n0qH&¨\u0006r"}, d2 = {"Lcom/reddit/datalibrary/social/data/repo/ChatDataRepositoryContract;", "", "acceptInvite", "Lio/reactivex/Observable;", "", "channelUrl", "", "acceptedGroupChannels", "", "Lcom/sendbird/android/GroupChannel;", "userId", "refresh", "acceptedGroupChannelsWithMore", "areNotificationsEnabledSendbird", "blockUser", "blockUserOnReddit", "cancelListenGroupChannels", "", "channelHandlerId", "contacts", "Lcom/reddit/social/presentation/presentationobjects/ContactData;", "limit", "", "(Ljava/lang/String;Ljava/lang/Integer;Z)Lio/reactivex/Observable;", "createChannel", "users", "Lcom/reddit/datalibrary/social/model/User;", "channelName", "declineInvite", "deleteFailedMessage", "requestId", "deleteMessage", "", "messageId", "endTyping", "getMembers", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "getUserId", "Lio/reactivex/Single;", "username", "groupChannel", "groupMessages", "Lcom/reddit/social/domain/functions/RawMessagesBatch;", "handleNetworkConnection", "Lio/reactivex/disposables/CompositeDisposable;", "onInit", "Lkotlin/Function1;", "onChange", "hasMoreAcceptedChannels", "hasMoreMessages", "hasMoreUnacceptedChannels", "hideChannel", "inviteToChannel", "Lcom/google/gson/JsonElement;", "isChannelMuted", "Lcom/reddit/datalibrary/social/model/ChannelMuteStatus;", "isChatEnabled", "Lcom/reddit/datalibrary/social/model/ChatEnabled;", "isLoadingUnacceptedChannels", "leaveChannel", "listenChats", "Lcom/sendbird/android/BaseChannel;", "listenNewInvite", "markGroupChannelAsRead", "moreMessages", "muteChannel", "networkConnectionChangedObservable", "newMessageObservable", "Lkotlin/Pair;", "Lcom/sendbird/android/BaseMessage;", "reportMessage", "userName", "reason", "Lcom/reddit/datalibrary/social/model/ReportMessage;", "reportUser", "requestsCount", "saveContacts", "saveConversations", "saveMessages", "sendFileMessage", "Lcom/reddit/social/presentation/presentationobjects/SentStatus;", "message", "data", "uri", "Landroid/net/Uri;", "messagesStatus", "Lio/reactivex/subjects/PublishSubject;", "Lcom/sendbird/android/FileMessage;", "Lcom/reddit/social/presentation/groupchat/presentation/FileMessageStatus;", "sendMessage", "Lcom/sendbird/android/UserMessage;", "tempMessage", "Lio/reactivex/subjects/BehaviorSubject;", "setChannelName", "name", "setChatEnabled", "setNotificationsEnabledSendbird", "enable", "setTotalUnreadMessageCount", "count", "startTyping", "totalUnreadMessageCount", "typingStatusObservable", "Lcom/sendbird/android/Member;", "unacceptedGroupChannels", "unacceptedGroupChannelsWithMore", "unblockUser", "unmuteChannel", "usersData", "", "Lcom/reddit/datalibrary/social/network/UserId;", "Lcom/reddit/datalibrary/social/data/datasource/cache/UserDataMap;", "usersId", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ChatDataRepositoryContract.kt */
public interface ChatDataRepositoryContract {

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    /* compiled from: ChatDataRepositoryContract.kt */
    public static final class DefaultImpls {
    }

    Observable<GroupChannel> mo4506a(String str);

    Observable<Long> mo4507a(String str, long j);

    Observable<Pair<SentStatus, BaseMessage>> mo4508a(String str, Uri uri, PublishSubject<Pair<FileMessage, SentStatus>> publishSubject);

    Observable<Boolean> mo4509a(String str, String str2);

    Observable<Object> mo4510a(String str, String str2, ReportMessage reportMessage);

    Observable<UserMessage> mo4511a(String str, String str2, String str3, BehaviorSubject<UserMessage> behaviorSubject);

    Observable<JsonElement> mo4512a(String str, List<User> list);

    Observable<List<GroupChannel>> mo4513a(String str, boolean z);

    Observable<String> mo4514a(List<User> list, String str);

    Observable<Map<String, UserData>> mo4515a(Set<String> set);

    CompositeDisposable mo4516a(Function1<? super Boolean, Unit> function1, Function1<? super Boolean, Unit> function12);

    void mo4517a(GroupChannel groupChannel);

    Observable<BaseChannel> mo4518b(String str);

    Observable<String> mo4519b(String str, String str2);

    Observable<List<GroupChannel>> mo4520b(String str, boolean z);

    Observable<GroupChannel> mo4521c(String str);

    Observable<Object> mo4522c(String str, String str2);

    Observable<RawMessagesBatch> mo4523c(String str, boolean z);

    boolean mo4524c();

    Observable<Boolean> mo4525d(String str, boolean z);

    void mo4526d(String str);

    boolean mo4527d();

    Observable<List<GroupChannel>> mo4528e(String str);

    Observable<List<UserData>> mo4529e(String str, boolean z);

    boolean mo4530e();

    Observable<List<GroupChannel>> mo4531f(String str);

    boolean mo4532f();

    Observable<Integer> mo4533g();

    Observable<List<ContactData>> mo4534g(String str);

    Observable<ChatEnabled> mo4535h();

    Observable<RawMessagesBatch> mo4536h(String str);

    Observable<Object> mo4537i();

    Observable<Pair<BaseChannel, BaseMessage>> mo4538i(String str);

    Observable<List<Member>> mo4539j(String str);

    Observable<Boolean> mo4540k(String str);

    Observable<Boolean> mo4541l(String str);

    Observable<Boolean> mo4542m(String str);

    Observable<Boolean> mo4543n(String str);

    Observable<Object> mo4544o(String str);

    Observable<Boolean> mo4545p(String str);

    Observable<Boolean> mo4546q(String str);

    Single<String> mo4547r(String str);

    void mo4548s(String str);

    void mo4549t(String str);

    void mo4550u(String str);

    Observable<ChannelMuteStatus> mo4551v(String str);

    Observable<Object> mo4552w(String str);

    Observable<Object> mo4553x(String str);

    void mo4554y(String str);

    void mo4555z(String str);
}
