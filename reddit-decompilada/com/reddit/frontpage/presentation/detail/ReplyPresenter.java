package com.reddit.frontpage.presentation.detail;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.datalibrary.frontpage.data.feature.comments.CommentRepository;
import com.reddit.frontpage.presentation.common.DisposablePresenter;
import com.reddit.frontpage.presentation.detail.ReplyContract.Parameters;
import com.reddit.frontpage.presentation.detail.ReplyContract.Presenter;
import com.reddit.frontpage.presentation.detail.ReplyContract.View;
import com.reddit.frontpage.util.kotlin.SinglesKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/reddit/frontpage/presentation/detail/ReplyPresenter;", "Lcom/reddit/frontpage/presentation/detail/ReplyContract$Presenter;", "Lcom/reddit/frontpage/presentation/common/DisposablePresenter;", "view", "Lcom/reddit/frontpage/presentation/detail/ReplyContract$View;", "commentRepository", "Lcom/reddit/datalibrary/frontpage/data/feature/comments/CommentRepository;", "postExecutionThread", "Lcom/reddit/common/rx/PostExecutionThread;", "params", "Lcom/reddit/frontpage/presentation/detail/ReplyContract$Parameters;", "(Lcom/reddit/frontpage/presentation/detail/ReplyContract$View;Lcom/reddit/datalibrary/frontpage/data/feature/comments/CommentRepository;Lcom/reddit/common/rx/PostExecutionThread;Lcom/reddit/frontpage/presentation/detail/ReplyContract$Parameters;)V", "attach", "", "onLeaveSelected", "onSubmitSelected", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ReplyPresenter.kt */
public final class ReplyPresenter extends DisposablePresenter implements Presenter {
    private final View f33837a;
    private final CommentRepository f33838b;
    private final PostExecutionThread f33839c;
    private final Parameters f33840d;

    public final void attach() {
    }

    public final void destroy() {
    }

    public ReplyPresenter(View view, CommentRepository commentRepository, PostExecutionThread postExecutionThread, Parameters parameters) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(commentRepository, "commentRepository");
        Intrinsics.m26847b(postExecutionThread, "postExecutionThread");
        Intrinsics.m26847b(parameters, "params");
        this.f33837a = view;
        this.f33838b = commentRepository;
        this.f33839c = postExecutionThread;
        this.f33840d = parameters;
    }

    public final void mo6455a() {
        if ((StringsKt__StringsJVMKt.m41943a((CharSequence) this.f33837a.mo7166c()) ^ 1) != 0) {
            this.f33837a.mo7167d();
        } else {
            this.f33837a.mo7171i();
        }
    }

    public final void mo6456b() {
        this.f33837a.mo7169f();
        Object subscribe = SinglesKt.m24094b(this.f33838b.a(this.f33840d.f20498a, this.f33837a.mo7166c(), this.f33840d.f20499b), this.f33839c).subscribe(new ReplyPresenter$onSubmitSelected$1(this), new ReplyPresenter$onSubmitSelected$2(this));
        Intrinsics.m26843a(subscribe, "commentRepository.commen…orMessage()\n            }");
        handleDispose(subscribe);
    }
}
