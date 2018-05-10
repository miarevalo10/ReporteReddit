package com.reddit.frontpage.presentation.modtools.modlist.all;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/modlist/all/AllModeratorsContract;", "", "Presenter", "View", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AllModeratorsContract.kt */
public interface AllModeratorsContract {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/modlist/all/AllModeratorsContract$View;", "Lcom/reddit/frontpage/presentation/modtools/base/BaseModeratorsContract$View;", "onDecline", "", "onInviteSuccess", "showModInviteDialog", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: AllModeratorsContract.kt */
    public interface View extends com.reddit.frontpage.presentation.modtools.base.BaseModeratorsContract.View {
        void R_();

        void mo7674d();
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/modlist/all/AllModeratorsContract$Presenter;", "Lcom/reddit/frontpage/presentation/modtools/base/BaseModeratorsContract$Presenter;", "acceptModInvite", "", "declineModInvite", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    public interface Presenter extends com.reddit.frontpage.presentation.modtools.base.BaseModeratorsContract.Presenter {
    }
}
