package com.reddit.datalibrary.social.data.datasource.remote;

import com.sendbird.android.BaseChannel;
import com.sendbird.android.BaseMessage;
import io.reactivex.functions.Predicate;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "Lcom/sendbird/android/BaseChannel;", "Lcom/sendbird/android/BaseMessage;", "test"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatRemoteDataSource.kt */
final class ChatRemoteDataSource$newMessageObservable$1<T> implements Predicate<Pair<? extends BaseChannel, ? extends BaseMessage>> {
    final /* synthetic */ String f27304a;

    ChatRemoteDataSource$newMessageObservable$1(String str) {
        this.f27304a = str;
    }

    public final /* synthetic */ boolean test(Object obj) {
        Pair pair = (Pair) obj;
        Intrinsics.m26847b(pair, "<name for destructuring parameter 0>");
        return Intrinsics.m26845a(((BaseChannel) pair.f25267a).m24870d(), this.f27304a);
    }
}
