package com.reddit.datalibrary.social.data.datasource.remote;

import com.sendbird.android.GroupChannel;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.reactivex.subjects.PublishSubject;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lio/reactivex/Observable;", "Lkotlin/Pair;", "Lcom/reddit/social/presentation/presentationobjects/SentStatus;", "Lcom/sendbird/android/BaseMessage;", "channel", "Lcom/sendbird/android/GroupChannel;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatRemoteDataSource.kt */
final class ChatRemoteDataSource$sendFileMessage$1<T, R> implements Function<T, ObservableSource<? extends R>> {
    final /* synthetic */ ChatRemoteDataSource f27308a;
    final /* synthetic */ File f27309b;
    final /* synthetic */ String f27310c;
    final /* synthetic */ String f27311d;
    final /* synthetic */ int f27312e;
    final /* synthetic */ String f27313f = null;
    final /* synthetic */ String f27314g = null;
    final /* synthetic */ List f27315h;
    final /* synthetic */ PublishSubject f27316i;

    ChatRemoteDataSource$sendFileMessage$1(ChatRemoteDataSource chatRemoteDataSource, File file, String str, String str2, int i, List list, PublishSubject publishSubject) {
        this.f27308a = chatRemoteDataSource;
        this.f27309b = file;
        this.f27310c = str;
        this.f27311d = str2;
        this.f27312e = i;
        this.f27315h = list;
        this.f27316i = publishSubject;
    }

    public final /* synthetic */ Object apply(Object obj) {
        GroupChannel groupChannel = (GroupChannel) obj;
        Intrinsics.m26847b(groupChannel, "channel");
        return ChatRemoteDataSource.m34300b((Function1) new ChatRemoteDataSource$sendFileMessage$2(this.f27308a, groupChannel, this.f27309b, this.f27310c, this.f27311d, this.f27312e, this.f27313f, this.f27314g, this.f27315h, this.f27316i));
    }
}
