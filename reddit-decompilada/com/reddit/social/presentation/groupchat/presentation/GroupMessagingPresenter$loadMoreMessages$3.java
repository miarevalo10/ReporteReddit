package com.reddit.social.presentation.groupchat.presentation;

import com.reddit.social.domain.functions.MessagesBatch;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lio/reactivex/Observable;", "Lcom/sendbird/android/GroupChannel;", "it", "Lcom/reddit/social/domain/functions/MessagesBatch;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: GroupMessagingPresenter.kt */
final class GroupMessagingPresenter$loadMoreMessages$3<T, R> implements Function<T, ObservableSource<? extends R>> {
    final /* synthetic */ GroupMessagingPresenter f29772a;
    final /* synthetic */ String f29773b;

    GroupMessagingPresenter$loadMoreMessages$3(GroupMessagingPresenter groupMessagingPresenter, String str) {
        this.f29772a = groupMessagingPresenter;
        this.f29773b = str;
    }

    public final /* synthetic */ Object apply(Object obj) {
        Intrinsics.m26847b((MessagesBatch) obj, "it");
        return this.f29772a.m30818g().mo4506a(this.f29773b);
    }
}
