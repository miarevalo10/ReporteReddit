package com.reddit.frontpage.di.module;

import com.reddit.datalibrary.frontpage.data.feature.comments.LocalCommentDataSource;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class CommentDataModule_ProvideDatabaseCommentDataSourceFactory implements Factory<LocalCommentDataSource> {
    private final CommentDataModule f33542a;

    private CommentDataModule_ProvideDatabaseCommentDataSourceFactory(CommentDataModule commentDataModule) {
        this.f33542a = commentDataModule;
    }

    public static CommentDataModule_ProvideDatabaseCommentDataSourceFactory m34473a(CommentDataModule commentDataModule) {
        return new CommentDataModule_ProvideDatabaseCommentDataSourceFactory(commentDataModule);
    }

    public final /* synthetic */ Object get() {
        return (LocalCommentDataSource) Preconditions.m26013a(CommentDataModule.m22330a(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
