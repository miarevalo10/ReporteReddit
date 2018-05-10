package com.reddit.datalibrary.social.data.datasource.remote;

import com.sendbird.android.BaseChannel;
import com.sendbird.android.BaseMessage;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012&\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005 \u0006*\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "Lcom/sendbird/android/BaseChannel;", "Lcom/sendbird/android/BaseMessage;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatRemoteDataSource.kt */
final class ChatRemoteDataSource$newMessageObservable$2<T> implements Consumer<Pair<? extends BaseChannel, ? extends BaseMessage>> {
    final /* synthetic */ ChatRemoteDataSource f27305a;

    ChatRemoteDataSource$newMessageObservable$2(ChatRemoteDataSource chatRemoteDataSource) {
        this.f27305a = chatRemoteDataSource;
    }

    public final /* synthetic */ void accept(Object obj) {
        Pair pair = (Pair) obj;
        BaseChannel baseChannel = (BaseChannel) pair.f25267a;
        BaseMessage baseMessage = (BaseMessage) pair.f25268b;
        List c = this.f27305a.m34320t(baseChannel.m24870d());
        if (c != null) {
            c.add(0, baseMessage);
        }
    }
}
