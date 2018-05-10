package com.reddit.datalibrary.social.data.datasource.remote;

import com.sendbird.android.GroupChannel;
import com.sendbird.android.UserMessage;
import io.reactivex.ObservableEmitter;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "emitter", "Lio/reactivex/ObservableEmitter;", "Lcom/sendbird/android/UserMessage;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatRemoteDataSource.kt */
final class ChatRemoteDataSource$sendMessage$2 extends Lambda implements Function1<ObservableEmitter<UserMessage>, Unit> {
    final /* synthetic */ ChatRemoteDataSource f36295a;
    final /* synthetic */ GroupChannel f36296b;
    final /* synthetic */ String f36297c;
    final /* synthetic */ String f36298d;
    final /* synthetic */ BehaviorSubject f36299e;

    ChatRemoteDataSource$sendMessage$2(ChatRemoteDataSource chatRemoteDataSource, GroupChannel groupChannel, String str, String str2, BehaviorSubject behaviorSubject) {
        this.f36295a = chatRemoteDataSource;
        this.f36296b = groupChannel;
        this.f36297c = str;
        this.f36298d = str2;
        this.f36299e = behaviorSubject;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        ObservableEmitter observableEmitter = (ObservableEmitter) obj;
        Intrinsics.m26847b(observableEmitter, "emitter");
        this.f36299e.onNext(this.f36296b.m24864a(this.f36297c, this.f36298d, new ChatRemoteDataSource$sendMessage$2$tempUserMessage$1(this, observableEmitter)));
        return Unit.f25273a;
    }
}
