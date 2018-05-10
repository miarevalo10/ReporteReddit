package com.reddit.datalibrary.frontpage.data.common.websocket;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J%\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\t0\b\"\u0006\b\u0000\u0010\n\u0018\u00012\u0006\u0010\u000b\u001a\u00020\fH\bJ4\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\t0\b\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u0002H\n0\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/common/websocket/ObservableWebSocketClient;", "", "client", "Lokhttp3/OkHttpClient;", "(Lokhttp3/OkHttpClient;)V", "getClient", "()Lokhttp3/OkHttpClient;", "connect", "Lio/reactivex/Flowable;", "Lio/reactivex/Notification;", "T", "uri", "Ljava/net/URI;", "jsonParser", "Lkotlin/Function1;", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ObservableWebSocketClient.kt */
public final class ObservableWebSocketClient {
    private final OkHttpClient f10311a;

    public ObservableWebSocketClient(OkHttpClient okHttpClient) {
        Intrinsics.b(okHttpClient, "client");
        this.f10311a = okHttpClient;
    }
}
