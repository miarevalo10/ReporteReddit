package com.reddit.frontpage.presentation.modtools.base;

import com.reddit.datalibrary.frontpage.data.model.ModToolsUserModel;
import com.reddit.frontpage.presentation.common.BasePresenter;
import com.reddit.frontpage.presentation.modtools.ModToolsListItemModel;
import com.reddit.frontpage.presentation.modtools.util.ModUsersOptionsAction;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/base/BaseModeratorsContract;", "", "Presenter", "View", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: BaseModeratorsContract.kt */
public interface BaseModeratorsContract {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0016\u0010\u0016\u001a\u00020\u00122\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H&J\u0016\u0010\u001a\u001a\u00020\u00122\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H&J\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\tH&J\u0018\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020!H&J\b\u0010\"\u001a\u00020\u0012H&J\u0010\u0010#\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\tH&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\r¨\u0006$"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/base/BaseModeratorsContract$View;", "", "listItemModel", "Lcom/reddit/frontpage/presentation/modtools/ModToolsListItemModel;", "getListItemModel", "()Lcom/reddit/frontpage/presentation/modtools/ModToolsListItemModel;", "setListItemModel", "(Lcom/reddit/frontpage/presentation/modtools/ModToolsListItemModel;)V", "subredditId", "", "getSubredditId", "()Ljava/lang/String;", "setSubredditId", "(Ljava/lang/String;)V", "subredditName", "getSubredditName", "setSubredditName", "notifyUserRemoved", "", "onEventMainThread", "event", "Lcom/reddit/frontpage/presentation/modtools/util/ModUsersOptionsAction;", "setNewSearchResults", "results", "", "Lcom/reddit/datalibrary/frontpage/data/model/ModToolsUserModel;", "setUsers", "users", "showError", "errorMessage", "showNegativeActionSuccess", "username", "stringRes", "", "showOptions", "viewProfile", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: BaseModeratorsContract.kt */
    public interface View {
        String mo7383a();

        void mo7385a(List<? extends ModToolsUserModel> list);

        ModToolsListItemModel mo7386b();

        void mo7387b(String str, int i);

        void mo7388b(List<? extends ModToolsUserModel> list);

        void b_(String str);

        void mo7390c();

        void onEventMainThread(ModUsersOptionsAction modUsersOptionsAction);

        void mo7669x();
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0014\u001a\u00020\u0015H&J\b\u0010\u0016\u001a\u00020\u0015H&J\b\u0010\u0017\u001a\u00020\u0015H&J\b\u0010\u0018\u001a\u00020\u0015H&J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0003H&R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u0018\u0010\u0011\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/base/BaseModeratorsContract$Presenter;", "Lcom/reddit/frontpage/presentation/common/BasePresenter;", "after", "", "getAfter", "()Ljava/lang/String;", "setAfter", "(Ljava/lang/String;)V", "allUsersLoaded", "", "getAllUsersLoaded", "()Z", "setAllUsersLoaded", "(Z)V", "loadingUsers", "getLoadingUsers", "setLoadingUsers", "previouslyAttached", "getPreviouslyAttached", "setPreviouslyAttached", "loadUsers", "", "onItemClicked", "performNegativeAction", "reload", "searchUser", "username", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: BaseModeratorsContract.kt */
    public interface Presenter extends BasePresenter {
        void mo6481a();

        void mo6974a(String str);

        void mo6975c();

        void mo6482d();
    }
}
