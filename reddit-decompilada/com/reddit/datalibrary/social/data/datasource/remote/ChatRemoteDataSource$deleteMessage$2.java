package com.reddit.datalibrary.social.data.datasource.remote;

import com.sendbird.android.BaseChannel.DeleteMessageHandler;
import com.sendbird.android.BaseMessage;
import com.sendbird.android.GroupChannel;
import com.sendbird.android.SendBirdException;
import io.reactivex.ObservableEmitter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "emitter", "Lio/reactivex/ObservableEmitter;", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatRemoteDataSource.kt */
final class ChatRemoteDataSource$deleteMessage$2 extends Lambda implements Function1<ObservableEmitter<Long>, Unit> {
    final /* synthetic */ ChatRemoteDataSource f36270a;
    final /* synthetic */ GroupChannel f36271b;
    final /* synthetic */ BaseMessage f36272c;
    final /* synthetic */ long f36273d;

    ChatRemoteDataSource$deleteMessage$2(ChatRemoteDataSource chatRemoteDataSource, GroupChannel groupChannel, BaseMessage baseMessage, long j) {
        this.f36270a = chatRemoteDataSource;
        this.f36271b = groupChannel;
        this.f36272c = baseMessage;
        this.f36273d = j;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        final ObservableEmitter observableEmitter = (ObservableEmitter) obj;
        Intrinsics.m26847b(observableEmitter, "emitter");
        this.f36271b.m24866a(this.f36272c, new DeleteMessageHandler() {
            public final /* synthetic */ void mo4489a(SendBirdException sendBirdException) {
                if (ChatRemoteDataSource.m34304b(observableEmitter, sendBirdException) == null) {
                    sendBirdException = this.f36270a.m34320t(this.f36271b.m24870d());
                    if (sendBirdException != null) {
                        sendBirdException.remove(this.f36272c);
                    }
                    observableEmitter.mo5641a((Object) Long.valueOf(this.f36273d));
                    observableEmitter.aA_();
                }
            }
        });
        return Unit.f25273a;
    }
}
