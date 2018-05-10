package com.reddit.social.presentation.chatrequests.presentation;

import com.sendbird.android.GroupChannel;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/Observable;", "", "Lcom/reddit/social/presentation/chatinbox/ChatInboxItem;", "it", "Lcom/sendbird/android/GroupChannel;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatRequestListPresenter.kt */
final class ChatRequestListPresenter$attachView$3<T, R> implements Function<T, ObservableSource<? extends R>> {
    final /* synthetic */ ChatRequestListPresenter f29636a;

    ChatRequestListPresenter$attachView$3(ChatRequestListPresenter chatRequestListPresenter) {
        this.f29636a = chatRequestListPresenter;
    }

    public final /* synthetic */ Object apply(Object obj) {
        Intrinsics.m26847b((GroupChannel) obj, "it");
        return this.f29636a.m30670d().m24492a(true);
    }
}
