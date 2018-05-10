package com.reddit.social.presentation.groupchat.presentation;

import com.reddit.social.domain.functions.RawMessagesBatch;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0003\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u0004j\u0002`\b0\u00020\u00012\u0006\u0010\t\u001a\u00020\u0003H\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "Lio/reactivex/Observable;", "Lkotlin/Pair;", "Lcom/reddit/social/domain/functions/RawMessagesBatch;", "", "", "Lcom/reddit/datalibrary/social/network/UserId;", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "Lcom/reddit/datalibrary/social/data/datasource/cache/UserDataMap;", "it", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: GroupMessagingPresenter.kt */
final class GroupMessagingPresenter$loadMoreMessages$messagesObservable$1<T, R> implements Function<T, ObservableSource<? extends R>> {
    final /* synthetic */ GroupMessagingPresenter f29774a;

    GroupMessagingPresenter$loadMoreMessages$messagesObservable$1(GroupMessagingPresenter groupMessagingPresenter) {
        this.f29774a = groupMessagingPresenter;
    }

    public final /* synthetic */ Object apply(Object obj) {
        RawMessagesBatch rawMessagesBatch = (RawMessagesBatch) obj;
        Intrinsics.m26847b(rawMessagesBatch, "it");
        return GroupMessagingPresenter.m30775a(this.f29774a, rawMessagesBatch);
    }
}
