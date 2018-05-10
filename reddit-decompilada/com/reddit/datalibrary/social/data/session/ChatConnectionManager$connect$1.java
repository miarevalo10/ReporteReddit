package com.reddit.datalibrary.social.data.session;

import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lio/reactivex/subjects/PublishSubject;", "", "it", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatConnectionManager.kt */
final class ChatConnectionManager$connect$1<T, R> implements Function<T, ObservableSource<? extends R>> {
    final /* synthetic */ ChatConnectionManager f27378a;

    ChatConnectionManager$connect$1(ChatConnectionManager chatConnectionManager) {
        this.f27378a = chatConnectionManager;
    }

    public final /* synthetic */ Object apply(Object obj) {
        Intrinsics.m26847b((String) obj, "it");
        return ChatConnectionManager.m21765e(this.f27378a);
    }
}
