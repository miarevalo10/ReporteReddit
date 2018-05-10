package com.reddit.frontpage.presentation.modtools.ban.add.bottomsheet;

import com.reddit.frontpage.presentation.common.DisposablePresenter;
import com.reddit.frontpage.presentation.modtools.ban.add.bottomsheet.BanReasonsContract.View;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/ban/add/bottomsheet/BanReasonsPresenter;", "Lcom/reddit/frontpage/presentation/common/DisposablePresenter;", "Lcom/reddit/frontpage/presentation/modtools/ban/add/bottomsheet/BanReasonsContract$Presenter;", "view", "Lcom/reddit/frontpage/presentation/modtools/ban/add/bottomsheet/BanReasonsContract$View;", "(Lcom/reddit/frontpage/presentation/modtools/ban/add/bottomsheet/BanReasonsContract$View;)V", "attach", "", "onClick", "banReason", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: BanReasonsPresenter.kt */
public final class BanReasonsPresenter extends DisposablePresenter {
    final View f34068a;

    public final void attach() {
    }

    @Inject
    public BanReasonsPresenter(View view) {
        Intrinsics.m26847b(view, "view");
        this.f34068a = view;
    }
}
