package com.reddit.datalibrary.social.data.datasource.remote;

import com.sendbird.android.BaseChannel.SendUserMessageHandler;
import com.sendbird.android.SendBirdException;
import com.sendbird.android.UserMessage;
import io.reactivex.ObservableEmitter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "userMessage", "Lcom/sendbird/android/UserMessage;", "kotlin.jvm.PlatformType", "e", "Lcom/sendbird/android/SendBirdException;", "onSent"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatRemoteDataSource.kt */
final class ChatRemoteDataSource$sendMessage$2$tempUserMessage$1 implements SendUserMessageHandler {
    final /* synthetic */ ChatRemoteDataSource$sendMessage$2 f27323a;
    final /* synthetic */ ObservableEmitter f27324b;

    ChatRemoteDataSource$sendMessage$2$tempUserMessage$1(ChatRemoteDataSource$sendMessage$2 chatRemoteDataSource$sendMessage$2, ObservableEmitter observableEmitter) {
        this.f27323a = chatRemoteDataSource$sendMessage$2;
        this.f27324b = observableEmitter;
    }

    public final void mo4500a(UserMessage userMessage, SendBirdException sendBirdException) {
        if (ChatRemoteDataSource.m34304b(this.f27324b, sendBirdException) == null) {
            sendBirdException = this.f27323a.f36295a.m34320t(this.f27323a.f36296b.m24870d());
            if (sendBirdException != null) {
                Intrinsics.m26843a((Object) userMessage, "userMessage");
                sendBirdException.add(0, userMessage);
            }
            this.f27324b.mo5641a((Object) userMessage);
            this.f27324b.aA_();
        }
    }
}
