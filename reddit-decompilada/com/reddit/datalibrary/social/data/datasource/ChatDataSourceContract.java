package com.reddit.datalibrary.social.data.datasource;

import com.google.gson.JsonElement;
import com.reddit.datalibrary.social.model.ChannelMuteStatus;
import com.reddit.datalibrary.social.model.ChatEnabled;
import com.reddit.datalibrary.social.model.Contact;
import com.reddit.datalibrary.social.model.User;
import com.reddit.datalibrary.social.model.UserBriefData;
import com.reddit.social.domain.functions.RawMessagesBatch;
import com.reddit.social.presentation.presentationobjects.SentStatus;
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

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J$\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00032\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0004H&J\u001c\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00032\u0006\u0010\n\u001a\u00020\u0006H&J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0006H&J3\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\b0\u00032\u0006\u0010\n\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0002\u0010\u0013J&\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006H&J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH&J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J$\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\b0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0004H&J\u001e\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0004H&J\b\u0010#\u001a\u00020\u0004H&J\b\u0010$\u001a\u00020\u0004H&J\b\u0010%\u001a\u00020\u0004H&J\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J$\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\bH&J\u0016\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u000e\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u0003H&J\b\u0010-\u001a\u00020\u0004H&J\u0016\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010/\u001a\b\u0012\u0004\u0012\u00020\"0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u00100\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\"\u00101\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u000204020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0001\u00105\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u000204020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u00122\b\u0010<\u001a\u0004\u0018\u00010\u00062\b\u0010=\u001a\u0004\u0018\u00010\u00062\u000e\u0010>\u001a\n\u0012\u0006\b\u0001\u0012\u00020@0?2\u001c\u0010A\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020602j\u0002`D0BH&J8\u0010E\u001a\b\u0012\u0004\u0012\u00020F0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010G\u001a\u0004\u0018\u00010\u00062\b\u0010<\u001a\u0004\u0018\u00010\u00062\f\u0010H\u001a\b\u0012\u0004\u0012\u00020F0IH&J\u001e\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u0006H&J\u000e\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H&J\u001e\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010M\u001a\u00020\u0004H&J\u0010\u0010N\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u0006H&J\u000e\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00120\u0003H&J\u001c\u0010P\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\b0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J$\u0010Q\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00032\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0004H&J\u0016\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0006H&J\u0016\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u001c\u0010T\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00032\u0006\u0010\n\u001a\u00020\u0006H&J4\u0010U\u001a\u001c\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0006j\u0002`W\u0012\u0004\u0012\u00020X0Vj\u0002`Y0\u00032\u0010\u0010Z\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`W0[H&¨\u0006\\"}, d2 = {"Lcom/reddit/datalibrary/social/data/datasource/ChatDataSourceContract;", "", "acceptInvite", "Lio/reactivex/Observable;", "", "channelUrl", "", "acceptedGroupChannels", "", "Lcom/sendbird/android/GroupChannel;", "userId", "refresh", "acceptedGroupChannelsWithMore", "areNotificationsEnabledSendbird", "blockUser", "contacts", "Lcom/reddit/datalibrary/social/model/Contact;", "limit", "", "(Ljava/lang/String;Ljava/lang/Integer;Z)Lio/reactivex/Observable;", "createChannel", "users", "Lcom/reddit/datalibrary/social/model/User;", "channelName", "declineInvite", "deleteMessage", "", "messageId", "endTyping", "", "getGroupChannel", "getMembers", "Lcom/sendbird/android/Member;", "groupMessages", "Lcom/reddit/social/domain/functions/RawMessagesBatch;", "hasMoreAcceptedChannels", "hasMoreMessages", "hasMoreUnacceptedChannels", "hideChannel", "inviteToChannel", "Lcom/google/gson/JsonElement;", "isChannelMuted", "Lcom/reddit/datalibrary/social/model/ChannelMuteStatus;", "isChatEnabled", "Lcom/reddit/datalibrary/social/model/ChatEnabled;", "isLoadingUnacceptedChannels", "leaveChannel", "moreGroupMessages", "muteChannel", "newMessageObservable", "Lkotlin/Pair;", "Lcom/sendbird/android/BaseChannel;", "Lcom/sendbird/android/BaseMessage;", "sendFileMessage", "Lcom/reddit/social/presentation/presentationobjects/SentStatus;", "file", "Ljava/io/File;", "name", "type", "size", "data", "customType", "thumbnailSizes", "", "Lcom/sendbird/android/FileMessage$ThumbnailSize;", "messagesStatus", "Lio/reactivex/subjects/PublishSubject;", "Lcom/sendbird/android/FileMessage;", "Lcom/reddit/social/presentation/groupchat/presentation/FileMessageStatus;", "sendMessage", "Lcom/sendbird/android/UserMessage;", "message", "tempMessage", "Lio/reactivex/subjects/BehaviorSubject;", "setChannelName", "setChatEnabled", "setNotificationsEnabledSendbird", "enable", "startTyping", "totalUnreadMessageCount", "typingStatusObservable", "unacceptedGroupChannels", "unblockUser", "unmuteChannel", "unnacceptedGroupChannelsWithMore", "userDataByAccountIds", "", "Lcom/reddit/datalibrary/social/network/UserId;", "Lcom/reddit/datalibrary/social/model/UserBriefData;", "Lcom/reddit/datalibrary/social/network/UserBriefDataMap;", "usersId", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ChatDataSourceContract.kt */
public interface ChatDataSourceContract {
    Observable<GroupChannel> mo6381a(String str);

    Observable<Long> mo6382a(String str, long j);

    Observable<Pair<SentStatus, BaseMessage>> mo6383a(String str, File file, String str2, String str3, int i, List<? extends ThumbnailSize> list, PublishSubject<Pair<FileMessage, SentStatus>> publishSubject);

    Observable<Boolean> mo6384a(String str, String str2);

    Observable<UserMessage> mo6385a(String str, String str2, String str3, BehaviorSubject<UserMessage> behaviorSubject);

    Observable<JsonElement> mo6386a(String str, List<User> list);

    Observable<List<GroupChannel>> mo6387a(String str, boolean z);

    Observable<String> mo6388a(List<User> list, String str);

    Observable<Map<String, UserBriefData>> mo6389a(Set<String> set);

    boolean mo6390a();

    Observable<List<GroupChannel>> mo6391b(String str);

    Observable<List<GroupChannel>> mo6392b(String str, boolean z);

    boolean mo6393b();

    Observable<List<GroupChannel>> mo6394c(String str);

    Observable<RawMessagesBatch> mo6395c(String str, boolean z);

    boolean mo6396c();

    Observable<Integer> mo6397d();

    Observable<List<Contact>> mo6398d(String str);

    Observable<Boolean> mo6399d(String str, boolean z);

    Observable<RawMessagesBatch> mo6400e(String str);

    Observable<List<Member>> mo6401e(String str, boolean z);

    boolean mo6402e();

    Observable<ChatEnabled> mo6403f();

    Observable<Pair<BaseChannel, BaseMessage>> mo6404f(String str);

    Observable<Object> mo6405g();

    Observable<List<Member>> mo6406g(String str);

    Observable<Boolean> mo6407h(String str);

    Observable<Boolean> mo6408i(String str);

    Observable<Boolean> mo6409j(String str);

    Observable<Boolean> mo6410k(String str);

    Observable<Boolean> mo6411l(String str);

    Observable<Boolean> mo6412m(String str);

    Observable<ChannelMuteStatus> mo6413n(String str);

    Observable<Object> mo6414o(String str);

    Observable<Object> mo6415p(String str);

    void mo6416q(String str);

    void mo6417r(String str);
}
