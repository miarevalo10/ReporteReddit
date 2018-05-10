package com.reddit.datalibrary.social.data.datasource.remote;

import com.sendbird.android.GroupChannel;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lio/reactivex/Observable;", "Lcom/sendbird/android/UserMessage;", "channel", "Lcom/sendbird/android/GroupChannel;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatRemoteDataSource.kt */
final class ChatRemoteDataSource$sendMessage$1<T, R> implements Function<T, ObservableSource<? extends R>> {
    final /* synthetic */ ChatRemoteDataSource f27319a;
    final /* synthetic */ String f27320b;
    final /* synthetic */ String f27321c;
    final /* synthetic */ BehaviorSubject f27322d;

    ChatRemoteDataSource$sendMessage$1(ChatRemoteDataSource chatRemoteDataSource, String str, String str2, BehaviorSubject behaviorSubject) {
        this.f27319a = chatRemoteDataSource;
        this.f27320b = str;
        this.f27321c = str2;
        this.f27322d = behaviorSubject;
    }

    public final /* synthetic */ Object apply(Object obj) {
        GroupChannel groupChannel = (GroupChannel) obj;
        Intrinsics.m26847b(groupChannel, "channel");
        return ChatRemoteDataSource.m34300b((Function1) new ChatRemoteDataSource$sendMessage$2(this.f27319a, groupChannel, this.f27320b, this.f27321c, this.f27322d));
    }
}
