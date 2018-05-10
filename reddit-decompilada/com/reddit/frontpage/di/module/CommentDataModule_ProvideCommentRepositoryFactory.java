package com.reddit.frontpage.di.module;

import com.reddit.common.rx.BackgroundThread;
import com.reddit.datalibrary.frontpage.data.common.websocket.ObservableWebSocketClient;
import com.reddit.datalibrary.frontpage.data.feature.comments.CommentRepository;
import com.reddit.datalibrary.frontpage.data.feature.comments.LocalCommentDataSource;
import com.reddit.datalibrary.frontpage.data.feature.comments.RemoteCommentDataSource;
import com.reddit.datalibrary.frontpage.data.feature.link.datasource.local.LocalLinkDataSource;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class CommentDataModule_ProvideCommentRepositoryFactory implements Factory<CommentRepository> {
    private final CommentDataModule f33536a;
    private final Provider<RemoteCommentDataSource> f33537b;
    private final Provider<LocalCommentDataSource> f33538c;
    private final Provider<LocalLinkDataSource> f33539d;
    private final Provider<BackgroundThread> f33540e;
    private final Provider<ObservableWebSocketClient> f33541f;

    private CommentDataModule_ProvideCommentRepositoryFactory(CommentDataModule commentDataModule, Provider<RemoteCommentDataSource> provider, Provider<LocalCommentDataSource> provider2, Provider<LocalLinkDataSource> provider3, Provider<BackgroundThread> provider4, Provider<ObservableWebSocketClient> provider5) {
        this.f33536a = commentDataModule;
        this.f33537b = provider;
        this.f33538c = provider2;
        this.f33539d = provider3;
        this.f33540e = provider4;
        this.f33541f = provider5;
    }

    public static CommentDataModule_ProvideCommentRepositoryFactory m34472a(CommentDataModule commentDataModule, Provider<RemoteCommentDataSource> provider, Provider<LocalCommentDataSource> provider2, Provider<LocalLinkDataSource> provider3, Provider<BackgroundThread> provider4, Provider<ObservableWebSocketClient> provider5) {
        return new CommentDataModule_ProvideCommentRepositoryFactory(commentDataModule, provider, provider2, provider3, provider4, provider5);
    }

    public final /* synthetic */ Object get() {
        return (CommentRepository) Preconditions.m26013a(CommentDataModule.m22329a((RemoteCommentDataSource) this.f33537b.get(), (LocalCommentDataSource) this.f33538c.get(), (LocalLinkDataSource) this.f33539d.get(), (BackgroundThread) this.f33540e.get(), (ObservableWebSocketClient) this.f33541f.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
