package com.reddit.datalibrary.social.data.datasource.remote;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u0002H\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u0002H\u0002\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/Observable;", "T", "kotlin.jvm.PlatformType", "it", "", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatRemoteDataSource.kt */
final class ChatRemoteDataSource$createObservableWithConnection$1<T, R> implements Function<T, ObservableSource<? extends R>> {
    final /* synthetic */ Function1 f27266a;

    ChatRemoteDataSource$createObservableWithConnection$1(Function1 function1) {
        this.f27266a = function1;
    }

    public final /* synthetic */ Object apply(Object obj) {
        Intrinsics.m26847b((String) obj, "it");
        obj = this.f27266a;
        if (obj != null) {
            obj = new ChatRemoteDataSourceKt$sam$ObservableOnSubscribe$57128d7d(obj);
        }
        return Observable.create((ObservableOnSubscribe) obj);
    }
}
