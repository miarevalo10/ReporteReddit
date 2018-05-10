package com.reddit.datalibrary.social.data.datasource.remote;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatRemoteDataSource.kt */
final class ChatRemoteDataSourceKt$sam$ObservableOnSubscribe$57128d7d implements ObservableOnSubscribe {
    private final /* synthetic */ Function1 f27340a;

    ChatRemoteDataSourceKt$sam$ObservableOnSubscribe$57128d7d(Function1 function1) {
        this.f27340a = function1;
    }

    public final /* synthetic */ void mo4493a(ObservableEmitter<T> observableEmitter) {
        Intrinsics.m26847b(observableEmitter, "p0");
        Intrinsics.m26843a(this.f27340a.mo6492a(observableEmitter), "invoke(...)");
    }
}
