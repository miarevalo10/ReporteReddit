package com.reddit.social.presentation.groupchat.presentation;

import com.reddit.social.domain.functions.MessagesBatch;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lio/reactivex/Observable;", "Lcom/reddit/social/domain/functions/MessagesBatch;", "messageBatch", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: GroupMessagingPresenter.kt */
final class GroupMessagingPresenter$loadMessages$1<T, R> implements Function<T, ObservableSource<? extends R>> {
    final /* synthetic */ GroupMessagingPresenter f29763a;
    final /* synthetic */ String f29764b;

    GroupMessagingPresenter$loadMessages$1(GroupMessagingPresenter groupMessagingPresenter, String str) {
        this.f29763a = groupMessagingPresenter;
        this.f29764b = str;
    }

    public final /* synthetic */ Object apply(Object obj) {
        MessagesBatch messagesBatch = (MessagesBatch) obj;
        Intrinsics.m26847b(messagesBatch, "messageBatch");
        if ((messagesBatch.f22302a.isEmpty() ^ 1) != 0) {
            GroupMessagingPresenter.m30774a(this.f29763a).mo7550a(messagesBatch);
            this.f29763a.m30820i().mo5103a(this.f29764b, true);
        } else {
            GroupMessagingPresenter.m30774a(this.f29763a).mo7567f();
        }
        obj = this.f29763a.f29798d;
        if (obj == null) {
            Intrinsics.m26844a("loadMessagesUseCase");
        }
        return obj.m24494a(this.f29764b, true);
    }
}
