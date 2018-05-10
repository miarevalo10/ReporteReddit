package com.reddit.frontpage.di.module;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.datalibrary.frontpage.data.feature.comments.CommentRepository;
import com.reddit.frontpage.presentation.detail.ReplyContract.Parameters;
import com.reddit.frontpage.presentation.detail.ReplyContract.Presenter;
import com.reddit.frontpage.presentation.detail.ReplyContract.View;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class ReplyModule_ProvideReplyPresenterFactory implements Factory<Presenter> {
    private final ReplyModule f33650a;
    private final Provider<View> f33651b;
    private final Provider<CommentRepository> f33652c;
    private final Provider<PostExecutionThread> f33653d;
    private final Provider<Parameters> f33654e;

    private ReplyModule_ProvideReplyPresenterFactory(ReplyModule replyModule, Provider<View> provider, Provider<CommentRepository> provider2, Provider<PostExecutionThread> provider3, Provider<Parameters> provider4) {
        this.f33650a = replyModule;
        this.f33651b = provider;
        this.f33652c = provider2;
        this.f33653d = provider3;
        this.f33654e = provider4;
    }

    public static ReplyModule_ProvideReplyPresenterFactory m34526a(ReplyModule replyModule, Provider<View> provider, Provider<CommentRepository> provider2, Provider<PostExecutionThread> provider3, Provider<Parameters> provider4) {
        return new ReplyModule_ProvideReplyPresenterFactory(replyModule, provider, provider2, provider3, provider4);
    }

    public final /* synthetic */ Object get() {
        return (Presenter) Preconditions.m26013a(ReplyModule.m22365a((View) this.f33651b.get(), (CommentRepository) this.f33652c.get(), (PostExecutionThread) this.f33653d.get(), (Parameters) this.f33654e.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
