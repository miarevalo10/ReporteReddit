package com.reddit.frontpage.presentation.modtools.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.ViewGroup;
import butterknife.BindView;
import com.evernote.android.state.State;
import com.reddit.datalibrary.frontpage.data.model.ModToolsUserModel;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.nav.Screens;
import com.reddit.frontpage.presentation.MvpBaseScreen;
import com.reddit.frontpage.presentation.modtools.ModAddUserTarget;
import com.reddit.frontpage.presentation.modtools.ModToolsListItemModel;
import com.reddit.frontpage.presentation.modtools.adapter.LoadMoreModUsersOnScrollListener;
import com.reddit.frontpage.presentation.modtools.adapter.ModAdapterMode;
import com.reddit.frontpage.presentation.modtools.adapter.ModUsersAdapter;
import com.reddit.frontpage.presentation.modtools.base.BaseModeratorsContract.Presenter;
import com.reddit.frontpage.presentation.modtools.base.BaseModeratorsContract.View;
import com.reddit.frontpage.presentation.modtools.util.ModUsersOptionsAction;
import com.reddit.frontpage.ui.listing.DividerItemDecoration;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.modtools.ModSearchView;
import com.reddit.frontpage.widgets.modtools.ModSearchView.SearchViewCallback;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007\b\u0016¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u00100\u001a\u000201H\u0014J\b\u00102\u001a\u000203H&J\b\u00104\u001a\u000205H\u0016J\u0018\u00106\u001a\u0002052\u0006\u00107\u001a\u00020(2\u0006\u00108\u001a\u000203H\u0016J\u0010\u00109\u001a\u0002052\u0006\u0010:\u001a\u00020\fH\u0014J\u0018\u0010;\u001a\u0002052\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0016J\u0018\u0010@\u001a\u00020\f2\u0006\u0010>\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0016J\u0010\u0010D\u001a\u0002052\u0006\u0010E\u001a\u00020FH&J\b\u0010G\u001a\u000205H\u0002J\u0016\u0010H\u001a\u0002052\f\u0010I\u001a\b\u0012\u0004\u0012\u00020K0JH\u0016J\u0016\u0010L\u001a\u0002052\f\u0010M\u001a\b\u0012\u0004\u0012\u00020K0JH\u0016J\b\u0010N\u001a\u000205H\u0002J\u0010\u0010O\u001a\u0002052\u0006\u0010P\u001a\u00020(H\u0016J\u0018\u0010Q\u001a\u0002052\u0006\u00107\u001a\u00020(2\u0006\u00108\u001a\u000203H\u0016J\b\u0010R\u001a\u000205H&J\u0010\u0010S\u001a\u0002052\u0006\u00107\u001a\u00020(H\u0016R\u0016\u0010\b\u001a\u00020\t8\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0004R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u00020\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\"8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010'\u001a\u00020(8\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001e\u0010-\u001a\u00020(8\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,¨\u0006T"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/base/BaseModeratorsScreen;", "Lcom/reddit/frontpage/presentation/MvpBaseScreen;", "Lcom/reddit/frontpage/presentation/modtools/ModAddUserTarget;", "Lcom/reddit/frontpage/presentation/modtools/base/BaseModeratorsContract$View;", "()V", "bundle", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "adapter", "Lcom/reddit/frontpage/presentation/modtools/adapter/ModUsersAdapter;", "adapter$annotations", "emptyContainer", "Landroid/view/View;", "getEmptyContainer", "()Landroid/view/View;", "setEmptyContainer", "(Landroid/view/View;)V", "listItemModel", "Lcom/reddit/frontpage/presentation/modtools/ModToolsListItemModel;", "getListItemModel", "()Lcom/reddit/frontpage/presentation/modtools/ModToolsListItemModel;", "setListItemModel", "(Lcom/reddit/frontpage/presentation/modtools/ModToolsListItemModel;)V", "moderatorPresenter", "Lcom/reddit/frontpage/presentation/modtools/base/BaseModeratorsContract$Presenter;", "getModeratorPresenter", "()Lcom/reddit/frontpage/presentation/modtools/base/BaseModeratorsContract$Presenter;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "searchView", "Lcom/reddit/frontpage/widgets/modtools/ModSearchView;", "getSearchView", "()Lcom/reddit/frontpage/widgets/modtools/ModSearchView;", "setSearchView", "(Lcom/reddit/frontpage/widgets/modtools/ModSearchView;)V", "subredditId", "", "getSubredditId", "()Ljava/lang/String;", "setSubredditId", "(Ljava/lang/String;)V", "subredditName", "getSubredditName", "setSubredditName", "getAdapterMode", "Lcom/reddit/frontpage/presentation/modtools/adapter/ModAdapterMode;", "getLayoutId", "", "notifyUserRemoved", "", "onAddUserSuccess", "username", "stringRes", "onAttach", "view", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateView", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onEventMainThread", "event", "Lcom/reddit/frontpage/presentation/modtools/util/ModUsersOptionsAction;", "resetAndReload", "setNewSearchResults", "results", "", "Lcom/reddit/datalibrary/frontpage/data/model/ModToolsUserModel;", "setUsers", "users", "showContent", "showError", "errorMessage", "showNegativeActionSuccess", "showOptions", "viewProfile", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: BaseModeratorsScreen.kt */
public abstract class BaseModeratorsScreen extends MvpBaseScreen implements ModAddUserTarget, View {
    @BindView
    public android.view.View emptyContainer;
    @BindView
    public RecyclerView recyclerView;
    @BindView
    public ModSearchView searchView;
    @State
    public String subredditId;
    @State
    public String subredditName;
    private final ModUsersAdapter f40092v = new ModUsersAdapter(new BaseModeratorsScreen$adapter$1(this), mo7670O());
    public ModToolsListItemModel f40093x;

    public abstract void onEventMainThread(ModUsersOptionsAction modUsersOptionsAction);

    public abstract Presenter mo7668w();

    public BaseModeratorsScreen() {
        super();
    }

    public BaseModeratorsScreen(Bundle bundle) {
        Intrinsics.m26847b(bundle, "bundle");
        super(bundle);
    }

    public final void m40774b(String str) {
        Intrinsics.m26847b(str, "<set-?>");
        this.subredditId = str;
    }

    public final String m40781y() {
        String str = this.subredditId;
        if (str == null) {
            Intrinsics.m26844a("subredditId");
        }
        return str;
    }

    public final String mo7383a() {
        String str = this.subredditName;
        if (str == null) {
            Intrinsics.m26844a("subredditName");
        }
        return str;
    }

    public final void mo7241c(String str) {
        Intrinsics.m26847b(str, "<set-?>");
        this.subredditName = str;
    }

    public final ModToolsListItemModel mo7386b() {
        ModToolsListItemModel modToolsListItemModel = this.f40093x;
        if (modToolsListItemModel == null) {
            Intrinsics.m26844a("listItemModel");
        }
        return modToolsListItemModel;
    }

    public ModAdapterMode mo7670O() {
        return ModAdapterMode.f20863a;
    }

    public final android.view.View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.m26847b(layoutInflater, "inflater");
        Intrinsics.m26847b(viewGroup, "container");
        super.mo7139a(layoutInflater, viewGroup);
        n();
        layoutInflater = this.searchView;
        if (layoutInflater == null) {
            Intrinsics.m26844a("searchView");
        }
        layoutInflater.setSearchViewCallback((SearchViewCallback) new BaseModeratorsScreen$onCreateView$1(this));
        layoutInflater = new LinearLayoutManager(am_());
        viewGroup = this.recyclerView;
        if (viewGroup == null) {
            Intrinsics.m26844a("recyclerView");
        }
        viewGroup.setLayoutManager((LayoutManager) layoutInflater);
        viewGroup = this.recyclerView;
        if (viewGroup == null) {
            Intrinsics.m26844a("recyclerView");
        }
        viewGroup.setAdapter(this.f40092v);
        viewGroup = am_();
        if (viewGroup == null) {
            Intrinsics.m26842a();
        }
        viewGroup = DividerItemDecoration.m30092a((Context) viewGroup, 1);
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.m26844a("recyclerView");
        }
        recyclerView.addItemDecoration((ItemDecoration) viewGroup);
        viewGroup = this.recyclerView;
        if (viewGroup == null) {
            Intrinsics.m26844a("recyclerView");
        }
        viewGroup.addOnScrollListener(new LoadMoreModUsersOnScrollListener(layoutInflater, this.f40092v, new BaseModeratorsScreen$onCreateView$2(this)));
        Object obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        return obj;
    }

    public void mo7673a(Menu menu, MenuInflater menuInflater) {
        Intrinsics.m26847b(menu, "menu");
        Intrinsics.m26847b(menuInflater, "inflater");
        super.a(menu, menuInflater);
        menuInflater.inflate(C1761R.menu.menu_modtools_add, menu);
        Object findItem = menu.findItem(C1761R.id.action_modtools_add);
        Intrinsics.m26843a(findItem, "menu.findItem(R.id.action_modtools_add)");
        findItem.setEnabled(true);
    }

    protected final void mo6992b(android.view.View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6992b(view);
        mo7668w().attach();
    }

    public final void mo7388b(List<? extends ModToolsUserModel> list) {
        Intrinsics.m26847b(list, "results");
        this.f40092v.f28545c.clear();
        ModUsersAdapter modUsersAdapter = this.f40092v;
        Intrinsics.m26847b(list, "modUsersList");
        modUsersAdapter.f28545c.addAll(list);
        modUsersAdapter.e();
    }

    public final void mo7385a(List<? extends ModToolsUserModel> list) {
        Intrinsics.m26847b(list, "users");
        ModUsersAdapter modUsersAdapter = this.f40092v;
        Intrinsics.m26847b(list, "modUsersList");
        modUsersAdapter.f28544b.addAll(list);
        modUsersAdapter.e();
        mo7671P();
    }

    public final void mo7390c() {
        ModUsersAdapter modUsersAdapter = this.f40092v;
        ModToolsListItemModel b = mo7386b();
        Intrinsics.m26847b(b, "user");
        modUsersAdapter.f28544b.remove(b.f20859b);
        modUsersAdapter.f28545c.remove(b.f20859b);
        modUsersAdapter.f(b.f20858a);
        mo7671P();
    }

    public final void mo7387b(String str, int i) {
        Intrinsics.m26847b(str, "username");
        str = Screens.m22629a(this, Util.m23960a(i, str), -1);
        if (str != null) {
            str.a();
        }
    }

    public final void b_(String str) {
        Intrinsics.m26847b(str, "errorMessage");
        str = Screens.m22629a(this, str, -1);
        if (str != null) {
            str.a();
        }
    }

    public final void m40779d(String str) {
        Intrinsics.m26847b(str, "username");
        Routing.m22623a((Screen) this, Nav.m22594j(str));
    }

    public final void mo7384a(String str, int i) {
        Intrinsics.m26847b(str, "username");
        str = Screens.m22629a(this, Util.m23960a(i, str), 0);
        if (str != null) {
            str.a();
        }
        str = this.searchView;
        if (str == null) {
            Intrinsics.m26844a("searchView");
        }
        str.setQuery("");
        str = this.searchView;
        if (str == null) {
            Intrinsics.m26844a("searchView");
        }
        str.m24221b();
        str = this.f40092v;
        str.f28545c.clear();
        str.f28544b.clear();
        str.f28543a = str.f28544b;
        str.e();
        mo7668w().mo6482d();
    }

    private final void mo7671P() {
        if (this.f40092v.m29738a() == 0) {
            android.view.View view;
            view = this.emptyContainer;
            if (view == null) {
                Intrinsics.m26844a("emptyContainer");
            }
            view.setVisibility(0);
            return;
        }
        view = this.emptyContainer;
        if (view == null) {
            Intrinsics.m26844a("emptyContainer");
        }
        view.setVisibility(8);
    }
}
