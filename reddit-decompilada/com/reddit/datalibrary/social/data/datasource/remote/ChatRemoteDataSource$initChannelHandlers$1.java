package com.reddit.datalibrary.social.data.datasource.remote;

import com.sendbird.android.BaseChannel;
import com.sendbird.android.BaseMessage;
import com.sendbird.android.GroupChannel;
import com.sendbird.android.SendBird.ChannelHandler;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\r"}, d2 = {"com/reddit/datalibrary/social/data/datasource/remote/ChatRemoteDataSource$initChannelHandlers$1", "Lcom/sendbird/android/SendBird$ChannelHandler;", "(Lcom/reddit/datalibrary/social/data/datasource/remote/ChatRemoteDataSource;)V", "onMessageReceived", "", "baseChannel", "Lcom/sendbird/android/BaseChannel;", "baseMessage", "Lcom/sendbird/android/BaseMessage;", "onReadReceiptUpdated", "channel", "Lcom/sendbird/android/GroupChannel;", "onTypingStatusUpdated", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ChatRemoteDataSource.kt */
public final class ChatRemoteDataSource$initChannelHandlers$1 extends ChannelHandler {
    final /* synthetic */ ChatRemoteDataSource f27296a;

    ChatRemoteDataSource$initChannelHandlers$1(ChatRemoteDataSource chatRemoteDataSource) {
        this.f27296a = chatRemoteDataSource;
    }

    public final void mo4494a(BaseChannel baseChannel, BaseMessage baseMessage) {
        Intrinsics.m26847b(baseChannel, "baseChannel");
        Intrinsics.m26847b(baseMessage, "baseMessage");
        this.f27296a.f33472l.onNext(TuplesKt.m26780a(baseChannel, baseMessage));
    }

    public final void mo4495a(GroupChannel groupChannel) {
        if (groupChannel != null) {
            this.f27296a.f33471k.onNext(groupChannel);
        }
    }
}
