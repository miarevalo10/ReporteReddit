package com.reddit.social.domain.usecases;

import com.reddit.datalibrary.social.data.repo.ChatDataRepositoryContract;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.util.SchedulerProvider;
import com.reddit.frontpage.util.SessionUtil;
import com.reddit.social.domain.functions.ChannelConversationTransformer;
import com.reddit.social.domain.functions.ChatInboxChannelsTransformer;
import com.reddit.social.presentation.chatinbox.ChatInboxItem;
import com.reddit.social.util.ChatUtilKt;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0007J0\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00130\u000b\"\u0004\b\u0000\u0010\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00130\u000b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00130\u000bH\u0002J:\u0010\u0016\u001a&\u0012\"\u0012 \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u000b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001a0\u00190\u00170\n2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u000bH\u0003R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/reddit/social/domain/usecases/ChatInboxListUseCase;", "", "()V", "chatDataRepository", "Lcom/reddit/datalibrary/social/data/repo/ChatDataRepositoryContract;", "getChatDataRepository", "()Lcom/reddit/datalibrary/social/data/repo/ChatDataRepositoryContract;", "setChatDataRepository", "(Lcom/reddit/datalibrary/social/data/repo/ChatDataRepositoryContract;)V", "chatInboxListObservable", "Lio/reactivex/Observable;", "", "Lcom/reddit/social/presentation/chatinbox/ChatInboxItem;", "userId", "", "refreshUnacceptedChannels", "", "refreshAcceptedChannels", "combineLists", "T", "listOne", "listTwo", "fetchUserData", "Lkotlin/Pair;", "Lcom/sendbird/android/GroupChannel;", "", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "groupChannels", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ChatInboxListUseCase.kt */
public final class ChatInboxListUseCase {
    @Inject
    public ChatDataRepositoryContract f22306a;

    public ChatInboxListUseCase() {
        FrontpageApplication.m28878n().mo5082a(this);
    }

    public final Observable<List<ChatInboxItem>> m24490a(String str, boolean z, boolean z2) {
        Intrinsics.m26847b(str, "userId");
        BiFunction chatInboxListUseCase$chatInboxListObservable$combine$1 = new ChatInboxListUseCase$chatInboxListObservable$combine$1(this);
        ChatDataRepositoryContract chatDataRepositoryContract = this.f22306a;
        if (chatDataRepositoryContract == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        ObservableSource b = chatDataRepositoryContract.mo4520b(str, z);
        chatDataRepositoryContract = this.f22306a;
        if (chatDataRepositoryContract == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        Object map = Observable.zip(b, chatDataRepositoryContract.mo4513a(str, z2), chatInboxListUseCase$chatInboxListObservable$combine$1).observeOn(SchedulerProvider.m23886b()).flatMap((Function) new ChatInboxListUseCase$chatInboxListObservable$1(this)).map((Function) new ChannelConversationTransformer(SessionUtil.m23898d(), SessionUtil.m23899e())).map((Function) ChatInboxListUseCase$chatInboxListObservable$2.f29587a).map((Function) new ChatInboxChannelsTransformer());
        Intrinsics.m26843a(map, "Observable.zip<List<Grou…boxChannelsTransformer())");
        return map;
    }

    public static final /* synthetic */ Observable m24488a(ChatInboxListUseCase chatInboxListUseCase, List list) {
        chatInboxListUseCase = chatInboxListUseCase.f22306a;
        if (chatInboxListUseCase == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        Object map = chatInboxListUseCase.mo4515a(ChatUtilKt.m24761b(list)).map(new ChatInboxListUseCase$fetchUserData$1(list));
        Intrinsics.m26843a(map, "chatDataRepository.users…p { groupChannels to it }");
        return map;
    }
}
