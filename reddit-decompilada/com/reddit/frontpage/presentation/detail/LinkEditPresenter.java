package com.reddit.frontpage.presentation.detail;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.frontpage.domain.repository.LinkRepository;
import com.reddit.frontpage.presentation.common.DisposablePresenter;
import com.reddit.frontpage.presentation.detail.EditContract.LinkParameters;
import com.reddit.frontpage.presentation.detail.EditContract.Presenter;
import com.reddit.frontpage.presentation.detail.EditContract.View;
import com.reddit.frontpage.util.kotlin.SinglesKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/reddit/frontpage/presentation/detail/LinkEditPresenter;", "Lcom/reddit/frontpage/presentation/detail/EditContract$Presenter;", "Lcom/reddit/frontpage/presentation/common/DisposablePresenter;", "view", "Lcom/reddit/frontpage/presentation/detail/EditContract$View;", "linkRepository", "Lcom/reddit/frontpage/domain/repository/LinkRepository;", "postExecutionThread", "Lcom/reddit/common/rx/PostExecutionThread;", "params", "Lcom/reddit/frontpage/presentation/detail/EditContract$LinkParameters;", "(Lcom/reddit/frontpage/presentation/detail/EditContract$View;Lcom/reddit/frontpage/domain/repository/LinkRepository;Lcom/reddit/common/rx/PostExecutionThread;Lcom/reddit/frontpage/presentation/detail/EditContract$LinkParameters;)V", "attach", "", "onLeaveSelected", "onSubmitSelected", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LinkEditPresenter.kt */
public final class LinkEditPresenter extends DisposablePresenter implements Presenter {
    private final View f33833a;
    private final LinkRepository f33834b;
    private final PostExecutionThread f33835c;
    private final LinkParameters f33836d;

    public final void attach() {
    }

    public final void destroy() {
    }

    public LinkEditPresenter(View view, LinkRepository linkRepository, PostExecutionThread postExecutionThread, LinkParameters linkParameters) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(linkRepository, "linkRepository");
        Intrinsics.m26847b(postExecutionThread, "postExecutionThread");
        Intrinsics.m26847b(linkParameters, "params");
        this.f33833a = view;
        this.f33834b = linkRepository;
        this.f33835c = postExecutionThread;
        this.f33836d = linkParameters;
    }

    public final void mo6453a() {
        this.f33833a.mo7159e();
    }

    public final void mo6454b() {
        this.f33833a.mo7157c();
        Object subscribe = SinglesKt.m24094b(this.f33834b.m22423b(this.f33836d.f20495a.getId(), this.f33833a.mo7153a()), this.f33835c).subscribe(new LinkEditPresenter$onSubmitSelected$1(this), new LinkEditPresenter$onSubmitSelected$2(this));
        Intrinsics.m26843a(subscribe, "linkRepository.edit(\n   …orMessage()\n            }");
        handleDispose(subscribe);
    }
}
