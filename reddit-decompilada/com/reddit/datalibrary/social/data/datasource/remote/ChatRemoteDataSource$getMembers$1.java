package com.reddit.datalibrary.social.data.datasource.remote;

import com.sendbird.android.GroupChannel;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lio/reactivex/Observable;", "Lcom/sendbird/android/GroupChannel;", "kotlin.jvm.PlatformType", "it", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatRemoteDataSource.kt */
final class ChatRemoteDataSource$getMembers$1<T, R> implements Function<T, ObservableSource<? extends R>> {
    final /* synthetic */ ChatRemoteDataSource f27285a;
    final /* synthetic */ boolean f27286b;

    ChatRemoteDataSource$getMembers$1(ChatRemoteDataSource chatRemoteDataSource, boolean z) {
        this.f27285a = chatRemoteDataSource;
        this.f27286b = z;
    }

    public final /* synthetic */ Object apply(Object obj) {
        GroupChannel groupChannel = (GroupChannel) obj;
        Intrinsics.m26847b(groupChannel, "it");
        if (this.f27286b) {
            return this.f27285a.m34289a((Function1) new ChatRemoteDataSource$refreshGroupChannel$1(this.f27285a, groupChannel));
        }
        return Observable.just(groupChannel);
    }
}
