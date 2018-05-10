package com.reddit.frontpage.di.module;

import com.reddit.common.rx.BackgroundThread;
import com.reddit.datalibrary.frontpage.data.common.websocket.ObservableWebSocketClient;
import com.reddit.datalibrary.frontpage.data.feature.comments.CommentRepository;
import com.reddit.datalibrary.frontpage.data.feature.comments.DatabaseCommentDataSource;
import com.reddit.datalibrary.frontpage.data.feature.comments.LocalCommentDataSource;
import com.reddit.datalibrary.frontpage.data.feature.comments.RedditCommentRepository;
import com.reddit.datalibrary.frontpage.data.feature.comments.RemoteCommentDataSource;
import com.reddit.datalibrary.frontpage.data.feature.link.datasource.local.LocalLinkDataSource;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Retrofit;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\b\u0010\u000f\u001a\u00020\bH\u0007J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0007¨\u0006\u0013"}, d2 = {"Lcom/reddit/frontpage/di/module/CommentDataModule;", "", "()V", "provideCommentRepository", "Lcom/reddit/datalibrary/frontpage/data/feature/comments/CommentRepository;", "remote", "Lcom/reddit/datalibrary/frontpage/data/feature/comments/RemoteCommentDataSource;", "local", "Lcom/reddit/datalibrary/frontpage/data/feature/comments/LocalCommentDataSource;", "localLinkDatSource", "Lcom/reddit/datalibrary/frontpage/data/feature/link/datasource/local/LocalLinkDataSource;", "backgroundThread", "Lcom/reddit/common/rx/BackgroundThread;", "webSocketClient", "Lcom/reddit/datalibrary/frontpage/data/common/websocket/ObservableWebSocketClient;", "provideDatabaseCommentDataSource", "provideRemoteCommentDataSource", "retrofit", "Lretrofit2/Retrofit;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CommentDataModule.kt */
public final class CommentDataModule {
    @Singleton
    public static RemoteCommentDataSource m22331a(Retrofit retrofit) {
        Intrinsics.m26847b(retrofit, "retrofit");
        Object a = retrofit.a(RemoteCommentDataSource.class);
        Intrinsics.m26843a(a, "retrofit.create(RemoteCo…ntDataSource::class.java)");
        return (RemoteCommentDataSource) a;
    }

    @Singleton
    public static LocalCommentDataSource m22330a() {
        return new DatabaseCommentDataSource();
    }

    @Singleton
    public static CommentRepository m22329a(RemoteCommentDataSource remoteCommentDataSource, LocalCommentDataSource localCommentDataSource, LocalLinkDataSource localLinkDataSource, BackgroundThread backgroundThread, ObservableWebSocketClient observableWebSocketClient) {
        Intrinsics.m26847b(remoteCommentDataSource, "remote");
        Intrinsics.m26847b(localCommentDataSource, "local");
        Intrinsics.m26847b(localLinkDataSource, "localLinkDatSource");
        Intrinsics.m26847b(backgroundThread, "backgroundThread");
        Intrinsics.m26847b(observableWebSocketClient, "webSocketClient");
        return new RedditCommentRepository(remoteCommentDataSource, localCommentDataSource, localLinkDataSource, backgroundThread, observableWebSocketClient);
    }
}
