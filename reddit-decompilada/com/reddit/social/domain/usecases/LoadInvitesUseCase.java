package com.reddit.social.domain.usecases;

import com.reddit.datalibrary.social.data.repo.ChatDataRepositoryContract;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.util.SessionUtil;
import com.reddit.social.domain.functions.ChannelConversationTransformer;
import com.reddit.social.presentation.chatinbox.ChatInboxItem;
import com.reddit.social.util.ChatUtilKt;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JB\u0010\t\u001a.\u0012*\u0012(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u000fj\u0002`\u0010\u0012\u0004\u0012\u00020\u00110\u000ej\u0002`\u00120\u000b0\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0003J\u001c\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\f0\n2\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0014\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\f0\nH\u0007R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/reddit/social/domain/usecases/LoadInvitesUseCase;", "", "()V", "chatDataRepository", "Lcom/reddit/datalibrary/social/data/repo/ChatDataRepositoryContract;", "getChatDataRepository", "()Lcom/reddit/datalibrary/social/data/repo/ChatDataRepositoryContract;", "setChatDataRepository", "(Lcom/reddit/datalibrary/social/data/repo/ChatDataRepositoryContract;)V", "fetchUserData", "Lio/reactivex/Observable;", "Lkotlin/Pair;", "", "Lcom/sendbird/android/GroupChannel;", "", "", "Lcom/reddit/datalibrary/social/network/UserId;", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "Lcom/reddit/datalibrary/social/data/datasource/cache/UserDataMap;", "channels", "load", "Lcom/reddit/social/presentation/chatinbox/ChatInboxItem;", "refresh", "", "loadMore", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LoadInvitesUseCase.kt */
public final class LoadInvitesUseCase {
    @Inject
    public ChatDataRepositoryContract f22308a;

    public LoadInvitesUseCase() {
        FrontpageApplication.m28878n().mo5084a(this);
    }

    public final Observable<List<ChatInboxItem>> m24492a(boolean z) {
        ChatDataRepositoryContract chatDataRepositoryContract = this.f22308a;
        if (chatDataRepositoryContract == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        String d = SessionUtil.m23898d();
        Intrinsics.m26843a((Object) d, "getTypedCurrentSessionAccountID()");
        Object map = chatDataRepositoryContract.mo4520b(d, z).map(LoadInvitesUseCase$load$1.f29592a).flatMap(new LoadInvitesUseCaseKt$sam$Function$af391548(new LoadInvitesUseCase$load$2(this))).map(new ChannelConversationTransformer(SessionUtil.m23898d(), SessionUtil.m23899e()));
        Intrinsics.m26843a(map, "chatDataRepository.unacc…), getCurrentUsername()))");
        return map;
    }

    public static final /* synthetic */ Observable m24491a(LoadInvitesUseCase loadInvitesUseCase, List list) {
        loadInvitesUseCase = loadInvitesUseCase.f22308a;
        if (loadInvitesUseCase == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        Object map = loadInvitesUseCase.mo4515a(ChatUtilKt.m24761b(list)).map(new LoadInvitesUseCase$fetchUserData$1(list));
        Intrinsics.m26843a(map, "chatDataRepository.users…  .map { channels to it }");
        return map;
    }
}
