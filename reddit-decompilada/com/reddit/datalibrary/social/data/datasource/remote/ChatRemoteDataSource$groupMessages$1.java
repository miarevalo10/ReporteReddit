package com.reddit.datalibrary.social.data.datasource.remote;

import com.sendbird.android.GroupChannel;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lio/reactivex/Observable;", "Lcom/reddit/social/domain/functions/RawMessagesBatch;", "it", "Lcom/sendbird/android/GroupChannel;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatRemoteDataSource.kt */
final class ChatRemoteDataSource$groupMessages$1<T, R> implements Function<T, ObservableSource<? extends R>> {
    final /* synthetic */ ChatRemoteDataSource f27291a;
    final /* synthetic */ boolean f27292b;

    ChatRemoteDataSource$groupMessages$1(ChatRemoteDataSource chatRemoteDataSource, boolean z) {
        this.f27291a = chatRemoteDataSource;
        this.f27292b = z;
    }

    public final /* synthetic */ Object apply(Object obj) {
        GroupChannel groupChannel = (GroupChannel) obj;
        Intrinsics.m26847b(groupChannel, "it");
        return ChatRemoteDataSource.m34288a(this.f27291a, groupChannel, this.f27292b);
    }
}
