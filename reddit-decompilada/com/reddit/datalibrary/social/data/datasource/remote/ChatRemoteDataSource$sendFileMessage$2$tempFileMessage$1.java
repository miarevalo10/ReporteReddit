package com.reddit.datalibrary.social.data.datasource.remote;

import com.reddit.social.presentation.presentationobjects.SentStatus;
import com.sendbird.android.BaseChannel.SendFileMessageHandler;
import com.sendbird.android.FileMessage;
import com.sendbird.android.SendBirdException;
import io.reactivex.ObservableEmitter;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "fileMessage", "Lcom/sendbird/android/FileMessage;", "kotlin.jvm.PlatformType", "e", "Lcom/sendbird/android/SendBirdException;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatRemoteDataSource.kt */
final class ChatRemoteDataSource$sendFileMessage$2$tempFileMessage$1 implements SendFileMessageHandler {
    final /* synthetic */ ChatRemoteDataSource$sendFileMessage$2 f27317a;
    final /* synthetic */ ObservableEmitter f27318b;

    ChatRemoteDataSource$sendFileMessage$2$tempFileMessage$1(ChatRemoteDataSource$sendFileMessage$2 chatRemoteDataSource$sendFileMessage$2, ObservableEmitter observableEmitter) {
        this.f27317a = chatRemoteDataSource$sendFileMessage$2;
        this.f27318b = observableEmitter;
    }

    public final /* synthetic */ void mo4499a(FileMessage fileMessage, SendBirdException sendBirdException) {
        if (ChatRemoteDataSource.m34304b(this.f27318b, sendBirdException) != null) {
            this.f27317a.f36294j.onNext(TuplesKt.m26780a(fileMessage, SentStatus.f22462c));
            return;
        }
        sendBirdException = this.f27317a.f36285a.m34320t(this.f27317a.f36286b.m24870d());
        if (sendBirdException != null) {
            Intrinsics.m26843a((Object) fileMessage, "fileMessage");
            sendBirdException.add(0, fileMessage);
        }
        this.f27317a.f36294j.onNext(TuplesKt.m26780a(fileMessage, SentStatus.f22460a));
        this.f27318b.aA_();
    }
}
