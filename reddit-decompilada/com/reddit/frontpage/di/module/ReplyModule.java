package com.reddit.frontpage.di.module;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.datalibrary.frontpage.data.feature.comments.CommentRepository;
import com.reddit.frontpage.presentation.detail.ReplyContract.Parameters;
import com.reddit.frontpage.presentation.detail.ReplyContract.Presenter;
import com.reddit.frontpage.presentation.detail.ReplyContract.View;
import com.reddit.frontpage.presentation.detail.ReplyPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007¨\u0006\r"}, d2 = {"Lcom/reddit/frontpage/di/module/ReplyModule;", "", "()V", "provideReplyPresenter", "Lcom/reddit/frontpage/presentation/detail/ReplyContract$Presenter;", "view", "Lcom/reddit/frontpage/presentation/detail/ReplyContract$View;", "commentRepository", "Lcom/reddit/datalibrary/frontpage/data/feature/comments/CommentRepository;", "postExecutionThread", "Lcom/reddit/common/rx/PostExecutionThread;", "params", "Lcom/reddit/frontpage/presentation/detail/ReplyContract$Parameters;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ReplyModule.kt */
public final class ReplyModule {
    public static Presenter m22365a(View view, CommentRepository commentRepository, PostExecutionThread postExecutionThread, Parameters parameters) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(commentRepository, "commentRepository");
        Intrinsics.m26847b(postExecutionThread, "postExecutionThread");
        Intrinsics.m26847b(parameters, "params");
        return new ReplyPresenter(view, commentRepository, postExecutionThread, parameters);
    }
}
