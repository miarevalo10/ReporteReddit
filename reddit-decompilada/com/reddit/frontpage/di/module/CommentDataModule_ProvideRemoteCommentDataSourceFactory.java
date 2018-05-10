package com.reddit.frontpage.di.module;

import com.reddit.datalibrary.frontpage.data.feature.comments.RemoteCommentDataSource;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

public final class CommentDataModule_ProvideRemoteCommentDataSourceFactory implements Factory<RemoteCommentDataSource> {
    private final CommentDataModule f33543a;
    private final Provider<Retrofit> f33544b;

    private CommentDataModule_ProvideRemoteCommentDataSourceFactory(CommentDataModule commentDataModule, Provider<Retrofit> provider) {
        this.f33543a = commentDataModule;
        this.f33544b = provider;
    }

    public static CommentDataModule_ProvideRemoteCommentDataSourceFactory m34474a(CommentDataModule commentDataModule, Provider<Retrofit> provider) {
        return new CommentDataModule_ProvideRemoteCommentDataSourceFactory(commentDataModule, provider);
    }

    public final /* synthetic */ Object get() {
        return (RemoteCommentDataSource) Preconditions.m26013a(CommentDataModule.m22331a((Retrofit) this.f33544b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
