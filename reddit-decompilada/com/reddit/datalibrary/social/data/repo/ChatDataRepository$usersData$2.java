package com.reddit.datalibrary.social.data.repo;

import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u001c\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u0002j\u0002`\u00060\u00012\u001a\u0010\u0007\u001a\u0016\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u0002j\u0002`\u0006H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "Lio/reactivex/Observable;", "", "", "Lcom/reddit/datalibrary/social/network/UserId;", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "Lcom/reddit/datalibrary/social/data/datasource/cache/UserDataMap;", "it", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatDataRepository.kt */
final class ChatDataRepository$usersData$2<T, R> implements Function<T, ObservableSource<? extends R>> {
    final /* synthetic */ ChatDataRepository f27360a;
    final /* synthetic */ Set f27361b;

    ChatDataRepository$usersData$2(ChatDataRepository chatDataRepository, Set set) {
        this.f27360a = chatDataRepository;
        this.f27361b = set;
    }

    public final /* synthetic */ Object apply(Object obj) {
        Intrinsics.m26847b((Map) obj, "it");
        return this.f27360a.m28794b().getUsersData(this.f27361b);
    }
}
