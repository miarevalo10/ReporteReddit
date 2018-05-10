package com.reddit.social.presentation.groupchat.presentation;

import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a,\u0012(\u0012&\u0012\u0004\u0012\u00020\u0003\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00020\u00020\u00012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "Lio/reactivex/Observable;", "Lkotlin/Pair;", "Lcom/reddit/social/presentation/presentationobjects/SentStatus;", "Lcom/sendbird/android/BaseMessage;", "", "", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "it", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: GroupMessagingPresenter.kt */
final class GroupMessagingPresenter$uploadFileConfirmed$1<T, R> implements Function<T, ObservableSource<? extends R>> {
    final /* synthetic */ GroupMessagingPresenter f29790a;

    GroupMessagingPresenter$uploadFileConfirmed$1(GroupMessagingPresenter groupMessagingPresenter) {
        this.f29790a = groupMessagingPresenter;
    }

    public final /* synthetic */ Object apply(Object obj) {
        Pair pair = (Pair) obj;
        Intrinsics.m26847b(pair, "it");
        return GroupMessagingPresenter.m30777a(this.f29790a, pair);
    }
}
