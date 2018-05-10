package com.reddit.datalibrary.social.data.datasource.remote;

import com.sendbird.android.GroupChannel;
import com.sendbird.android.GroupChannelListQuery;
import io.reactivex.ObservableEmitter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "emitter", "Lio/reactivex/ObservableEmitter;", "", "Lcom/sendbird/android/GroupChannel;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatRemoteDataSource.kt */
final class ChatRemoteDataSource$unnacceptedGroupChannelsWithMore$1 extends Lambda implements Function1<ObservableEmitter<List<? extends GroupChannel>>, Unit> {
    final /* synthetic */ ChatRemoteDataSource f36311a;
    final /* synthetic */ GroupChannelListQuery f36312b;

    ChatRemoteDataSource$unnacceptedGroupChannelsWithMore$1(ChatRemoteDataSource chatRemoteDataSource, GroupChannelListQuery groupChannelListQuery) {
        this.f36311a = chatRemoteDataSource;
        this.f36312b = groupChannelListQuery;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        ObservableEmitter observableEmitter = (ObservableEmitter) obj;
        Intrinsics.m26847b(observableEmitter, "emitter");
        ChatRemoteDataSource.m34292a(this.f36311a, observableEmitter, this.f36312b, this.f36311a.f33474n);
        return Unit.f25273a;
    }
}
