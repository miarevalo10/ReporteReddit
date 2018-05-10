package com.reddit.datalibrary.social.data.datasource.remote;

import com.reddit.social.presentation.presentationobjects.SentStatus;
import com.sendbird.android.BaseMessage;
import com.sendbird.android.GroupChannel;
import io.reactivex.ObservableEmitter;
import io.reactivex.subjects.PublishSubject;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "emitter", "Lio/reactivex/ObservableEmitter;", "Lkotlin/Pair;", "Lcom/reddit/social/presentation/presentationobjects/SentStatus;", "Lcom/sendbird/android/BaseMessage;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatRemoteDataSource.kt */
final class ChatRemoteDataSource$sendFileMessage$2 extends Lambda implements Function1<ObservableEmitter<Pair<? extends SentStatus, ? extends BaseMessage>>, Unit> {
    final /* synthetic */ ChatRemoteDataSource f36285a;
    final /* synthetic */ GroupChannel f36286b;
    final /* synthetic */ File f36287c;
    final /* synthetic */ String f36288d;
    final /* synthetic */ String f36289e;
    final /* synthetic */ int f36290f;
    final /* synthetic */ String f36291g;
    final /* synthetic */ String f36292h;
    final /* synthetic */ List f36293i;
    final /* synthetic */ PublishSubject f36294j;

    ChatRemoteDataSource$sendFileMessage$2(ChatRemoteDataSource chatRemoteDataSource, GroupChannel groupChannel, File file, String str, String str2, int i, String str3, String str4, List list, PublishSubject publishSubject) {
        this.f36285a = chatRemoteDataSource;
        this.f36286b = groupChannel;
        this.f36287c = file;
        this.f36288d = str;
        this.f36289e = str2;
        this.f36290f = i;
        this.f36291g = str3;
        this.f36292h = str4;
        this.f36293i = list;
        this.f36294j = publishSubject;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        ObservableEmitter observableEmitter = (ObservableEmitter) obj;
        Intrinsics.m26847b(observableEmitter, "emitter");
        observableEmitter.mo5641a((Object) new Pair(SentStatus.f22461b, this.f36286b.m24863a(this.f36287c, this.f36288d, this.f36289e, this.f36290f, this.f36291g, this.f36292h, this.f36293i, new ChatRemoteDataSource$sendFileMessage$2$tempFileMessage$1(this, observableEmitter))));
        return Unit.f25273a;
    }
}
