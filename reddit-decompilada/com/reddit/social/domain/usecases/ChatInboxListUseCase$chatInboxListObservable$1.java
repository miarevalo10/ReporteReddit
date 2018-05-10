package com.reddit.social.domain.usecases;

import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a&\u0012\"\u0012 \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "Lio/reactivex/Observable;", "Lkotlin/Pair;", "", "Lcom/sendbird/android/GroupChannel;", "", "", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "it", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatInboxListUseCase.kt */
final class ChatInboxListUseCase$chatInboxListObservable$1<T, R> implements Function<T, ObservableSource<? extends R>> {
    final /* synthetic */ ChatInboxListUseCase f29586a;

    ChatInboxListUseCase$chatInboxListObservable$1(ChatInboxListUseCase chatInboxListUseCase) {
        this.f29586a = chatInboxListUseCase;
    }

    public final /* synthetic */ Object apply(Object obj) {
        List list = (List) obj;
        Intrinsics.m26847b(list, "it");
        return ChatInboxListUseCase.m24488a(this.f29586a, list);
    }
}
