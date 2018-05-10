package com.reddit.frontpage.presentation.modtools.modlist.editable;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.frontpage.domain.repository.ModToolsRepository;
import com.reddit.frontpage.presentation.modtools.base.BaseModeratorsContract.Presenter;
import com.reddit.frontpage.presentation.modtools.base.BaseModeratorsContract.View;
import com.reddit.frontpage.presentation.modtools.base.BaseModeratorsPresenter;
import com.reddit.frontpage.util.kotlin.SinglesKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/modlist/editable/EditableModeratorsPresenter;", "Lcom/reddit/frontpage/presentation/modtools/base/BaseModeratorsPresenter;", "Lcom/reddit/frontpage/presentation/modtools/base/BaseModeratorsContract$Presenter;", "view", "Lcom/reddit/frontpage/presentation/modtools/base/BaseModeratorsContract$View;", "repository", "Lcom/reddit/frontpage/domain/repository/ModToolsRepository;", "scheduler", "Lcom/reddit/common/rx/PostExecutionThread;", "(Lcom/reddit/frontpage/presentation/modtools/base/BaseModeratorsContract$View;Lcom/reddit/frontpage/domain/repository/ModToolsRepository;Lcom/reddit/common/rx/PostExecutionThread;)V", "getRepository", "()Lcom/reddit/frontpage/domain/repository/ModToolsRepository;", "getScheduler", "()Lcom/reddit/common/rx/PostExecutionThread;", "getView", "()Lcom/reddit/frontpage/presentation/modtools/base/BaseModeratorsContract$View;", "loadUsers", "", "onItemClicked", "performNegativeAction", "searchUser", "username", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: EditableModeratorsPresenter.kt */
public final class EditableModeratorsPresenter extends BaseModeratorsPresenter implements Presenter {
    final View f36987a;
    private final ModToolsRepository f36988e;
    private final PostExecutionThread f36989f;

    @Inject
    public EditableModeratorsPresenter(View view, ModToolsRepository modToolsRepository, PostExecutionThread postExecutionThread) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(modToolsRepository, "repository");
        Intrinsics.m26847b(postExecutionThread, "scheduler");
        this.f36987a = view;
        this.f36988e = modToolsRepository;
        this.f36989f = postExecutionThread;
    }

    public final void m37366b() {
        Object subscribe = SinglesKt.m24094b(this.f36988e.m22453d(this.f36987a.mo7383a(), this.f36987a.mo7386b().f20859b), this.f36989f).subscribe(new EditableModeratorsPresenter$performNegativeAction$1(this), new EditableModeratorsPresenter$performNegativeAction$2(this));
        Intrinsics.m26843a(subscribe, "repository.removeModerat…er_error))\n            })");
        handleDispose(subscribe);
    }

    public final void mo6974a(String str) {
        Intrinsics.m26847b(str, "username");
        Object subscribe = SinglesKt.m24094b(this.f36988e.m22463l(this.f36987a.mo7383a(), str), this.f36989f).subscribe(new EditableModeratorsPresenter$searchUser$1(this), new EditableModeratorsPresenter$searchUser$2(this));
        Intrinsics.m26843a(subscribe, "repository.searchEditabl…er_error))\n            })");
        handleDispose(subscribe);
    }

    public final void mo6975c() {
        this.f36987a.mo7669x();
    }

    public final void mo6481a() {
        if (!this.f34071c && !this.f34072d) {
            this.f34072d = true;
            Object subscribe = SinglesKt.m24094b(this.f36988e.m22461j(this.f36987a.mo7383a(), this.f34070b), this.f36989f).subscribe(new EditableModeratorsPresenter$loadUsers$1(this), new EditableModeratorsPresenter$loadUsers$2(this));
            Intrinsics.m26843a(subscribe, "repository.getEditableMo… = false\n              })");
            handleDispose(subscribe);
        }
    }
}
