package com.reddit.datalibrary.social.data.datasource.remote;

import com.sendbird.android.GroupChannel;
import com.sendbird.android.GroupChannel.GroupChannelGetHandler;
import com.sendbird.android.SendBirdException;
import io.reactivex.ObservableEmitter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "emitter", "Lio/reactivex/ObservableEmitter;", "Lcom/sendbird/android/GroupChannel;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatRemoteDataSource.kt */
final class ChatRemoteDataSource$getGroupChannel$1 extends Lambda implements Function1<ObservableEmitter<GroupChannel>, Unit> {
    final /* synthetic */ ChatRemoteDataSource f36275a;
    final /* synthetic */ String f36276b;

    ChatRemoteDataSource$getGroupChannel$1(ChatRemoteDataSource chatRemoteDataSource, String str) {
        this.f36275a = chatRemoteDataSource;
        this.f36276b = str;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        final ObservableEmitter observableEmitter = (ObservableEmitter) obj;
        Intrinsics.m26847b(observableEmitter, "emitter");
        GroupChannel.m30962b(this.f36276b, new GroupChannelGetHandler() {
            public final void mo4490a(GroupChannel groupChannel, SendBirdException sendBirdException) {
                ChatRemoteDataSource.m34296a(observableEmitter, sendBirdException, (Object) groupChannel);
            }
        });
        return Unit.f25273a;
    }
}
