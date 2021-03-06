package com.reddit.frontpage.presentation.modtools.mute;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.frontpage.domain.repository.ModToolsRepository;
import com.reddit.frontpage.presentation.modtools.base.BaseModeratorsContract.Presenter;
import com.reddit.frontpage.presentation.modtools.base.BaseModeratorsContract.View;
import com.reddit.frontpage.presentation.modtools.base.BaseModeratorsPresenter;
import com.reddit.frontpage.util.kotlin.SinglesKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/mute/MutedUsersPresenter;", "Lcom/reddit/frontpage/presentation/modtools/base/BaseModeratorsPresenter;", "Lcom/reddit/frontpage/presentation/modtools/base/BaseModeratorsContract$Presenter;", "view", "Lcom/reddit/frontpage/presentation/modtools/base/BaseModeratorsContract$View;", "repository", "Lcom/reddit/frontpage/domain/repository/ModToolsRepository;", "scheduler", "Lcom/reddit/common/rx/PostExecutionThread;", "(Lcom/reddit/frontpage/presentation/modtools/base/BaseModeratorsContract$View;Lcom/reddit/frontpage/domain/repository/ModToolsRepository;Lcom/reddit/common/rx/PostExecutionThread;)V", "getRepository", "()Lcom/reddit/frontpage/domain/repository/ModToolsRepository;", "getScheduler", "()Lcom/reddit/common/rx/PostExecutionThread;", "getView", "()Lcom/reddit/frontpage/presentation/modtools/base/BaseModeratorsContract$View;", "loadUsers", "", "onItemClicked", "performNegativeAction", "searchUser", "username", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: MutedUsersPresenter.kt */
public final class MutedUsersPresenter extends BaseModeratorsPresenter implements Presenter {
    final View f36992a;
    private final ModToolsRepository f36993e;
    private final PostExecutionThread f36994f;

    @Inject
    public MutedUsersPresenter(View view, ModToolsRepository modToolsRepository, PostExecutionThread postExecutionThread) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(modToolsRepository, "repository");
        Intrinsics.m26847b(postExecutionThread, "scheduler");
        this.f36992a = view;
        this.f36993e = modToolsRepository;
        this.f36994f = postExecutionThread;
    }

    public final void m37372b() {
        Object subscribe = SinglesKt.m24094b(this.f36993e.m22449c(this.f36992a.mo7383a(), this.f36992a.mo7386b().f20859b), this.f36994f).subscribe(new MutedUsersPresenter$performNegativeAction$1(this), new MutedUsersPresenter$performNegativeAction$2(this));
        Intrinsics.m26843a(subscribe, "repository.unmuteUser(vi…edMessage)\n            })");
        handleDispose(subscribe);
    }

    public final void mo6974a(String str) {
        Intrinsics.m26847b(str, "username");
        Object subscribe = SinglesKt.m24094b(this.f36993e.m22459h(this.f36992a.mo7383a(), str), this.f36994f).subscribe(new MutedUsersPresenter$searchUser$1(this), new MutedUsersPresenter$searchUser$2(this));
        Intrinsics.m26843a(subscribe, "repository.searchMutedUs…edMessage)\n            })");
        handleDispose(subscribe);
    }

    public final void mo6975c() {
        this.f36992a.mo7669x();
    }

    public final void mo6481a() {
        if (!this.f34071c && !this.f34072d) {
            this.f34072d = true;
            Object subscribe = SinglesKt.m24094b(this.f36993e.m22457f(this.f36992a.mo7383a(), this.f34070b), this.f36994f).subscribe(new MutedUsersPresenter$loadUsers$1(this), new MutedUsersPresenter$loadUsers$2(this));
            Intrinsics.m26843a(subscribe, "repository.getMutedUsers…Message)\n              })");
            handleDispose(subscribe);
        }
    }
}
