package com.reddit.datalibrary.social.data.datasource.remote;

import com.reddit.social.domain.functions.RawMessagesBatch;
import com.sendbird.android.BaseMessage;
import com.sendbird.android.GroupChannel;
import com.sendbird.android.PreviousMessageListQuery;
import com.sendbird.android.PreviousMessageListQuery.MessageListQueryResult;
import com.sendbird.android.SendBirdException;
import io.reactivex.ObservableEmitter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "emitter", "Lio/reactivex/ObservableEmitter;", "Lcom/reddit/social/domain/functions/RawMessagesBatch;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatRemoteDataSource.kt */
final class ChatRemoteDataSource$messagesObservable$1 extends Lambda implements Function1<ObservableEmitter<RawMessagesBatch>, Unit> {
    final /* synthetic */ ChatRemoteDataSource f36281a;
    final /* synthetic */ GroupChannel f36282b;

    ChatRemoteDataSource$messagesObservable$1(ChatRemoteDataSource chatRemoteDataSource, GroupChannel groupChannel) {
        this.f36281a = chatRemoteDataSource;
        this.f36282b = groupChannel;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        final ObservableEmitter observableEmitter = (ObservableEmitter) obj;
        Intrinsics.m26847b(observableEmitter, "emitter");
        PreviousMessageListQuery j = this.f36281a.f33477q;
        if (j == null) {
            Intrinsics.m26842a();
        }
        if (j.m24944a()) {
            j = this.f36281a.f33477q;
            if (j == null) {
                Intrinsics.m26842a();
            }
            if (!j.m24945b()) {
                j = this.f36281a.f33477q;
                if (j == null) {
                    Intrinsics.m26842a();
                }
                j.m24942a(this.f36281a.f33466f, (MessageListQueryResult) new MessageListQueryResult() {
                    public final void mo4497a(List<BaseMessage> list, SendBirdException sendBirdException) {
                        if (ChatRemoteDataSource.m34304b(observableEmitter, sendBirdException) == null) {
                            sendBirdException = this.f36281a.m34320t(this.f36282b.m24870d());
                            if (sendBirdException != null) {
                                Intrinsics.m26843a((Object) list, "list");
                                sendBirdException.addAll(list);
                            }
                            sendBirdException = observableEmitter;
                            Intrinsics.m26843a((Object) list, "list");
                            PreviousMessageListQuery j = this.f36281a.f33477q;
                            if (j == null) {
                                Intrinsics.m26842a();
                            }
                            sendBirdException.mo5641a((Object) new RawMessagesBatch(list, j.m24944a()));
                            observableEmitter.aA_();
                        }
                    }
                });
            }
        } else {
            observableEmitter.mo5641a((Object) new RawMessagesBatch(CollectionsKt__CollectionsKt.m26790a(), false));
            observableEmitter.aA_();
        }
        return Unit.f25273a;
    }
}
