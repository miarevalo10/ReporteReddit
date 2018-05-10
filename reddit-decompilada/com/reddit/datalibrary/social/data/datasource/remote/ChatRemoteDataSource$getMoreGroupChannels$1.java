package com.reddit.datalibrary.social.data.datasource.remote;

import com.sendbird.android.GroupChannel;
import com.sendbird.android.GroupChannelListQuery.GroupChannelListQueryResultHandler;
import com.sendbird.android.SendBirdException;
import io.reactivex.ObservableEmitter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00060\u00032\u000e\u0010\u0007\u001a\n \u0005*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "list", "", "Lcom/sendbird/android/GroupChannel;", "kotlin.jvm.PlatformType", "", "e", "Lcom/sendbird/android/SendBirdException;", "onResult"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatRemoteDataSource.kt */
final class ChatRemoteDataSource$getMoreGroupChannels$1 implements GroupChannelListQueryResultHandler {
    final /* synthetic */ ChatRemoteDataSource f27288a;
    final /* synthetic */ ObservableEmitter f27289b;
    final /* synthetic */ List f27290c;

    ChatRemoteDataSource$getMoreGroupChannels$1(ChatRemoteDataSource chatRemoteDataSource, ObservableEmitter observableEmitter, List list) {
        this.f27288a = chatRemoteDataSource;
        this.f27289b = observableEmitter;
        this.f27290c = list;
    }

    public final void mo4491a(List<GroupChannel> list, SendBirdException sendBirdException) {
        if (ChatRemoteDataSource.m34304b(this.f27289b, sendBirdException) == null) {
            sendBirdException = this.f27290c;
            Intrinsics.m26843a((Object) list, "list");
            sendBirdException.addAll(list);
            this.f27289b.mo5641a((Object) list);
            this.f27289b.aA_();
        }
    }
}
