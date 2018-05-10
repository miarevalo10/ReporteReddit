package com.reddit.frontpage.presentation.modtools.base;

import com.reddit.frontpage.presentation.modtools.ModToolsListItemModel;
import com.reddit.frontpage.presentation.modtools.adapter.ModUsersAdapterAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"com/reddit/frontpage/presentation/modtools/base/BaseModeratorsScreen$adapter$1", "Lcom/reddit/frontpage/presentation/modtools/adapter/ModUsersAdapterAction;", "(Lcom/reddit/frontpage/presentation/modtools/base/BaseModeratorsScreen;)V", "onOptionsClicked", "", "listItem", "Lcom/reddit/frontpage/presentation/modtools/ModToolsListItemModel;", "onRowClicked", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: BaseModeratorsScreen.kt */
public final class BaseModeratorsScreen$adapter$1 implements ModUsersAdapterAction {
    final /* synthetic */ BaseModeratorsScreen f28594a;

    BaseModeratorsScreen$adapter$1(BaseModeratorsScreen baseModeratorsScreen) {
        this.f28594a = baseModeratorsScreen;
    }

    public final void mo4905a(ModToolsListItemModel modToolsListItemModel) {
        Intrinsics.m26847b(modToolsListItemModel, "listItem");
        this.f28594a.m40779d(modToolsListItemModel.f20859b.getUsername());
    }

    public final void mo4906b(ModToolsListItemModel modToolsListItemModel) {
        Intrinsics.m26847b(modToolsListItemModel, "listItem");
        BaseModeratorsScreen baseModeratorsScreen = this.f28594a;
        Intrinsics.m26847b(modToolsListItemModel, "<set-?>");
        baseModeratorsScreen.f40093x = modToolsListItemModel;
        this.f28594a.mo7668w().mo6975c();
    }
}
