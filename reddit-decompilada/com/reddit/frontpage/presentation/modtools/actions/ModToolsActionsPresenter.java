package com.reddit.frontpage.presentation.modtools.actions;

import com.reddit.frontpage.presentation.common.DisposablePresenter;
import com.reddit.frontpage.presentation.modtools.actions.ModToolsActionsContract.Presenter;
import com.reddit.frontpage.presentation.modtools.actions.ModToolsActionsContract.View;
import com.reddit.frontpage.presentation.modtools.util.ModToolsAction;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/actions/ModToolsActionsPresenter;", "Lcom/reddit/frontpage/presentation/common/DisposablePresenter;", "Lcom/reddit/frontpage/presentation/modtools/actions/ModToolsActionsContract$Presenter;", "view", "Lcom/reddit/frontpage/presentation/modtools/actions/ModToolsActionsContract$View;", "(Lcom/reddit/frontpage/presentation/modtools/actions/ModToolsActionsContract$View;)V", "getView", "()Lcom/reddit/frontpage/presentation/modtools/actions/ModToolsActionsContract$View;", "attach", "", "onModItemClicked", "modAction", "Lcom/reddit/frontpage/presentation/modtools/util/ModToolsAction;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ModToolsActionsPresenter.kt */
public final class ModToolsActionsPresenter extends DisposablePresenter implements Presenter {
    private final View f34056a;

    public final void attach() {
    }

    @Inject
    public ModToolsActionsPresenter(View view) {
        Intrinsics.m26847b(view, "view");
        this.f34056a = view;
    }

    public final void m34793a(ModToolsAction modToolsAction) {
        Intrinsics.m26847b(modToolsAction, "modAction");
        this.f34056a.mo7372a(modToolsAction);
    }
}
