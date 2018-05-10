package com.reddit.frontpage.presentation.modtools.approvedsubmitters.add;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.frontpage.domain.repository.ModToolsRepository;
import com.reddit.frontpage.presentation.common.DisposablePresenter;
import com.reddit.frontpage.presentation.modtools.approvedsubmitters.add.AddApprovedSubmitterContract.View;
import com.reddit.frontpage.util.kotlin.SinglesKt;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/approvedsubmitters/add/AddApprovedSubmitterPresenter;", "Lcom/reddit/frontpage/presentation/common/DisposablePresenter;", "Lcom/reddit/frontpage/presentation/modtools/approvedsubmitters/add/AddApprovedSubmitterContract$Presenter;", "view", "Lcom/reddit/frontpage/presentation/modtools/approvedsubmitters/add/AddApprovedSubmitterContract$View;", "repository", "Lcom/reddit/frontpage/domain/repository/ModToolsRepository;", "scheduler", "Lcom/reddit/common/rx/PostExecutionThread;", "(Lcom/reddit/frontpage/presentation/modtools/approvedsubmitters/add/AddApprovedSubmitterContract$View;Lcom/reddit/frontpage/domain/repository/ModToolsRepository;Lcom/reddit/common/rx/PostExecutionThread;)V", "getRepository", "()Lcom/reddit/frontpage/domain/repository/ModToolsRepository;", "getScheduler", "()Lcom/reddit/common/rx/PostExecutionThread;", "getView", "()Lcom/reddit/frontpage/presentation/modtools/approvedsubmitters/add/AddApprovedSubmitterContract$View;", "approveSubmitter", "", "username", "", "attach", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AddApprovedSubmitterPresenter.kt */
public final class AddApprovedSubmitterPresenter extends DisposablePresenter {
    final View f34061a;
    private final ModToolsRepository f34062b;
    private final PostExecutionThread f34063c;

    public final void attach() {
    }

    @Inject
    public AddApprovedSubmitterPresenter(View view, ModToolsRepository modToolsRepository, PostExecutionThread postExecutionThread) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(modToolsRepository, "repository");
        Intrinsics.m26847b(postExecutionThread, "scheduler");
        this.f34061a = view;
        this.f34062b = modToolsRepository;
        this.f34063c = postExecutionThread;
    }

    public final void m34795a(String str) {
        Intrinsics.m26847b(str, "username");
        Object subscribe = SinglesKt.m24094b(this.f34062b.m22454d(this.f34061a.mo7373a(), str), this.f34063c).subscribe(new AddApprovedSubmitterPresenter$approveSubmitter$1(this, str), (Consumer) new AddApprovedSubmitterPresenter$approveSubmitter$2(this));
        Intrinsics.m26843a(subscribe, "repository.addApprovedSu…edMessage)\n            })");
        handleDispose(subscribe);
    }
}
