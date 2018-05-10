package com.reddit.frontpage.presentation.modtools.modlist.all;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.frontpage.domain.repository.ModToolsRepository;
import com.reddit.frontpage.presentation.modtools.base.BaseModeratorsPresenter;
import com.reddit.frontpage.presentation.modtools.modlist.all.AllModeratorsContract.Presenter;
import com.reddit.frontpage.presentation.modtools.modlist.all.AllModeratorsContract.View;
import com.reddit.frontpage.util.kotlin.SinglesKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/modlist/all/AllModeratorsPresenter;", "Lcom/reddit/frontpage/presentation/modtools/base/BaseModeratorsPresenter;", "Lcom/reddit/frontpage/presentation/modtools/modlist/all/AllModeratorsContract$Presenter;", "view", "Lcom/reddit/frontpage/presentation/modtools/modlist/all/AllModeratorsContract$View;", "repository", "Lcom/reddit/frontpage/domain/repository/ModToolsRepository;", "scheduler", "Lcom/reddit/common/rx/PostExecutionThread;", "(Lcom/reddit/frontpage/presentation/modtools/modlist/all/AllModeratorsContract$View;Lcom/reddit/frontpage/domain/repository/ModToolsRepository;Lcom/reddit/common/rx/PostExecutionThread;)V", "getRepository", "()Lcom/reddit/frontpage/domain/repository/ModToolsRepository;", "getScheduler", "()Lcom/reddit/common/rx/PostExecutionThread;", "getView", "()Lcom/reddit/frontpage/presentation/modtools/modlist/all/AllModeratorsContract$View;", "acceptModInvite", "", "declineModInvite", "loadUsers", "onItemClicked", "performNegativeAction", "searchUser", "username", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AllModeratorsPresenter.kt */
public final class AllModeratorsPresenter extends BaseModeratorsPresenter implements Presenter {
    final View f36982a;
    private final ModToolsRepository f36983e;
    private final PostExecutionThread f36984f;

    public final void mo6975c() {
    }

    @Inject
    public AllModeratorsPresenter(View view, ModToolsRepository modToolsRepository, PostExecutionThread postExecutionThread) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(modToolsRepository, "repository");
        Intrinsics.m26847b(postExecutionThread, "scheduler");
        this.f36982a = view;
        this.f36983e = modToolsRepository;
        this.f36984f = postExecutionThread;
    }

    public final void mo6974a(String str) {
        Intrinsics.m26847b(str, "username");
        Object subscribe = SinglesKt.m24094b(this.f36983e.m22462k(this.f36982a.mo7383a(), str), this.f36984f).subscribe(new AllModeratorsPresenter$searchUser$1(this), new AllModeratorsPresenter$searchUser$2(this));
        Intrinsics.m26843a(subscribe, "repository.searchAllMode…er_error))\n            })");
        handleDispose(subscribe);
    }

    public final void m37359b() {
        Object subscribe = SinglesKt.m24094b(this.f36983e.m22448c(this.f36982a.mo7383a()), this.f36984f).subscribe(new AllModeratorsPresenter$acceptModInvite$1(this), new AllModeratorsPresenter$acceptModInvite$2(this));
        Intrinsics.m26843a(subscribe, "repository.acceptModInvi…er_error))\n            })");
        handleDispose(subscribe);
    }

    public final void m37361e() {
        Object subscribe = SinglesKt.m24094b(this.f36983e.m22452d(this.f36982a.mo7383a()), this.f36984f).subscribe(new AllModeratorsPresenter$declineModInvite$1(this), new AllModeratorsPresenter$declineModInvite$2(this));
        Intrinsics.m26843a(subscribe, "repository.declineModInv…nDecline()\n            })");
        handleDispose(subscribe);
    }

    public final void mo6481a() {
        if (!this.f34071c && !this.f34072d) {
            this.f34072d = true;
            Object subscribe = SinglesKt.m24094b(this.f36983e.m22460i(this.f36982a.mo7383a(), this.f34070b), this.f36984f).subscribe(new AllModeratorsPresenter$loadUsers$1(this), new AllModeratorsPresenter$loadUsers$2(this));
            Intrinsics.m26843a(subscribe, "repository.getAllModerat…_error))\n              })");
            handleDispose(subscribe);
        }
    }
}
