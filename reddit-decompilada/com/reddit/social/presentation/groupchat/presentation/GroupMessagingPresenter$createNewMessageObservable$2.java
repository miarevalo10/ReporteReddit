package com.reddit.social.presentation.groupchat.presentation;

import com.sendbird.android.BaseMessage;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/Observable;", "Lkotlin/Pair;", "Lcom/sendbird/android/BaseMessage;", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "it", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: GroupMessagingPresenter.kt */
final class GroupMessagingPresenter$createNewMessageObservable$2<T, R> implements Function<T, ObservableSource<? extends R>> {
    final /* synthetic */ GroupMessagingPresenter f29751a;

    GroupMessagingPresenter$createNewMessageObservable$2(GroupMessagingPresenter groupMessagingPresenter) {
        this.f29751a = groupMessagingPresenter;
    }

    public final /* synthetic */ Object apply(Object obj) {
        BaseMessage baseMessage = (BaseMessage) obj;
        Intrinsics.m26847b(baseMessage, "it");
        return GroupMessagingPresenter.m30776a(this.f29751a, baseMessage);
    }
}
