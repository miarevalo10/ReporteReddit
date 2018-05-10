package com.reddit.social.presentation.chatrequests.presentation;

import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lio/reactivex/Observable;", "", "Lcom/reddit/social/presentation/chatinbox/ChatInboxItem;", "it", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatRequestListPresenter.kt */
final class ChatRequestListPresenter$loadChatRequestListItems$2<T, R> implements Function<T, ObservableSource<? extends R>> {
    final /* synthetic */ ChatRequestListPresenter f29637a;

    ChatRequestListPresenter$loadChatRequestListItems$2(ChatRequestListPresenter chatRequestListPresenter) {
        this.f29637a = chatRequestListPresenter;
    }

    public final /* synthetic */ Object apply(Object obj) {
        Intrinsics.m26847b((List) obj, "it");
        return this.f29637a.m30670d().m24492a(true);
    }
}
