package com.reddit.social.presentation.groupchat.presentation;

import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u0004H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/Observable;", "Lcom/sendbird/android/BaseMessage;", "it", "Lkotlin/Pair;", "Lcom/sendbird/android/BaseChannel;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: GroupMessagingPresenter.kt */
final class GroupMessagingPresenter$createNewMessageObservable$1<T, R> implements Function<T, ObservableSource<? extends R>> {
    final /* synthetic */ GroupMessagingPresenter f29750a;

    GroupMessagingPresenter$createNewMessageObservable$1(GroupMessagingPresenter groupMessagingPresenter) {
        this.f29750a = groupMessagingPresenter;
    }

    public final /* synthetic */ Object apply(Object obj) {
        Pair pair = (Pair) obj;
        Intrinsics.m26847b(pair, "it");
        return GroupMessagingPresenter.m30778a(pair);
    }
}
