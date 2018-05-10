package com.reddit.social.domain.usecases;

import com.reddit.datalibrary.social.data.repo.ChatDataRepositoryContract;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.util.SessionUtil;
import com.reddit.social.domain.functions.MessageListTransformer;
import com.reddit.social.domain.functions.MessagesBatch;
import com.reddit.social.domain.functions.RawMessagesBatch;
import com.reddit.social.util.ChatUtilKt;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J6\u0010\t\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\f\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u000ej\u0002`\u000f\u0012\u0004\u0012\u00020\u00100\rj\u0002`\u00110\u000b0\n2\u0006\u0010\u0012\u001a\u00020\fH\u0003J\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\n2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0007R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/reddit/social/domain/usecases/LoadMessagesUseCase;", "", "()V", "chatDataRepository", "Lcom/reddit/datalibrary/social/data/repo/ChatDataRepositoryContract;", "getChatDataRepository", "()Lcom/reddit/datalibrary/social/data/repo/ChatDataRepositoryContract;", "setChatDataRepository", "(Lcom/reddit/datalibrary/social/data/repo/ChatDataRepositoryContract;)V", "fetchUsersData", "Lio/reactivex/Observable;", "Lkotlin/Pair;", "Lcom/reddit/social/domain/functions/RawMessagesBatch;", "", "", "Lcom/reddit/datalibrary/social/network/UserId;", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "Lcom/reddit/datalibrary/social/data/datasource/cache/UserDataMap;", "batch", "load", "Lcom/reddit/social/domain/functions/MessagesBatch;", "channelUrl", "refresh", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LoadMessagesUseCase.kt */
public final class LoadMessagesUseCase {
    @Inject
    public ChatDataRepositoryContract f22309a;

    public LoadMessagesUseCase() {
        FrontpageApplication.m28878n().mo5085a(this);
    }

    public final Observable<MessagesBatch> m24494a(String str, boolean z) {
        Intrinsics.m26847b(str, "channelUrl");
        String d = SessionUtil.m23898d();
        if (d == null) {
            throw ((Throwable) new IllegalStateException("You must have a userId to use load()"));
        }
        ChatDataRepositoryContract chatDataRepositoryContract = this.f22309a;
        if (chatDataRepositoryContract == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        Object map = chatDataRepositoryContract.mo4523c(str, z).flatMap(new LoadMessagesUseCaseKt$sam$Function$805f0ce6((Function1) new LoadMessagesUseCase$load$1(this))).map((Function) new MessageListTransformer(d));
        Intrinsics.m26843a(map, "chatDataRepository.group…ansformer(currentUserId))");
        return map;
    }

    public static final /* synthetic */ Observable m24493a(LoadMessagesUseCase loadMessagesUseCase, RawMessagesBatch rawMessagesBatch) {
        loadMessagesUseCase = loadMessagesUseCase.f22309a;
        if (loadMessagesUseCase == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        Object map = loadMessagesUseCase.mo4515a(ChatUtilKt.m24753a(rawMessagesBatch.f22304a)).map(new LoadMessagesUseCase$fetchUsersData$1(rawMessagesBatch));
        Intrinsics.m26843a(map, "chatDataRepository.users…     .map { batch to it }");
        return map;
    }
}
