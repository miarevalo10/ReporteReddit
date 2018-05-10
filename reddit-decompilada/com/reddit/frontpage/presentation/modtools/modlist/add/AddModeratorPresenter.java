package com.reddit.frontpage.presentation.modtools.modlist.add;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.frontpage.domain.repository.ModToolsRepository;
import com.reddit.frontpage.presentation.common.DisposablePresenter;
import com.reddit.frontpage.presentation.modtools.modlist.add.AddModeratorContract.View;
import com.reddit.frontpage.util.kotlin.SinglesKt;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/modlist/add/AddModeratorPresenter;", "Lcom/reddit/frontpage/presentation/common/DisposablePresenter;", "Lcom/reddit/frontpage/presentation/modtools/modlist/add/AddModeratorContract$Presenter;", "view", "Lcom/reddit/frontpage/presentation/modtools/modlist/add/AddModeratorContract$View;", "repository", "Lcom/reddit/frontpage/domain/repository/ModToolsRepository;", "scheduler", "Lcom/reddit/common/rx/PostExecutionThread;", "(Lcom/reddit/frontpage/presentation/modtools/modlist/add/AddModeratorContract$View;Lcom/reddit/frontpage/domain/repository/ModToolsRepository;Lcom/reddit/common/rx/PostExecutionThread;)V", "getRepository", "()Lcom/reddit/frontpage/domain/repository/ModToolsRepository;", "getScheduler", "()Lcom/reddit/common/rx/PostExecutionThread;", "getView", "()Lcom/reddit/frontpage/presentation/modtools/modlist/add/AddModeratorContract$View;", "attach", "", "editModerator", "username", "", "permissions", "inviteModerator", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AddModeratorPresenter.kt */
public final class AddModeratorPresenter extends DisposablePresenter {
    final View f34074a;
    private final ModToolsRepository f34075b;
    private final PostExecutionThread f34076c;

    public final void attach() {
    }

    @Inject
    public AddModeratorPresenter(View view, ModToolsRepository modToolsRepository, PostExecutionThread postExecutionThread) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(modToolsRepository, "repository");
        Intrinsics.m26847b(postExecutionThread, "scheduler");
        this.f34074a = view;
        this.f34075b = modToolsRepository;
        this.f34076c = postExecutionThread;
    }

    public final void m34800a(String str, String str2) {
        Intrinsics.m26847b(str, "username");
        Intrinsics.m26847b(str2, "permissions");
        Object subscribe = SinglesKt.m24094b(this.f34075b.m22447b(this.f34074a.mo7392a(), str, str2), this.f34076c).subscribe(new AddModeratorPresenter$inviteModerator$1(this, str), (Consumer) new AddModeratorPresenter$inviteModerator$2(this));
        Intrinsics.m26843a(subscribe, "repository.inviteModerat…edMessage)\n            })");
        handleDispose(subscribe);
    }

    public final void m34801b(String str, String str2) {
        Intrinsics.m26847b(str, "username");
        Intrinsics.m26847b(str2, "permissions");
        Object subscribe = SinglesKt.m24094b(this.f34075b.m22451c(this.f34074a.mo7392a(), str, str2), this.f34076c).subscribe(new AddModeratorPresenter$editModerator$1(this, str), (Consumer) new AddModeratorPresenter$editModerator$2(this));
        Intrinsics.m26843a(subscribe, "repository.editModerator…edMessage)\n            })");
        handleDispose(subscribe);
    }
}
