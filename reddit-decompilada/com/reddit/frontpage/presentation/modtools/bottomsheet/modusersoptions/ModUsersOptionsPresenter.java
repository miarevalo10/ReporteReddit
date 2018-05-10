package com.reddit.frontpage.presentation.modtools.bottomsheet.modusersoptions;

import com.reddit.frontpage.presentation.common.DisposablePresenter;
import com.reddit.frontpage.presentation.modtools.bottomsheet.modusersoptions.ModUsersOptionsContract.View;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/bottomsheet/modusersoptions/ModUsersOptionsPresenter;", "Lcom/reddit/frontpage/presentation/common/DisposablePresenter;", "Lcom/reddit/frontpage/presentation/modtools/bottomsheet/modusersoptions/ModUsersOptionsContract$Presenter;", "view", "Lcom/reddit/frontpage/presentation/modtools/bottomsheet/modusersoptions/ModUsersOptionsContract$View;", "(Lcom/reddit/frontpage/presentation/modtools/bottomsheet/modusersoptions/ModUsersOptionsContract$View;)V", "attach", "", "onDetailsClicked", "onNegativeActionClicked", "onProfileClicked", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ModUsersOptionsPresenter.kt */
public final class ModUsersOptionsPresenter extends DisposablePresenter {
    final View f34073a;

    public final void attach() {
    }

    @Inject
    public ModUsersOptionsPresenter(View view) {
        Intrinsics.m26847b(view, "view");
        this.f34073a = view;
    }
}
