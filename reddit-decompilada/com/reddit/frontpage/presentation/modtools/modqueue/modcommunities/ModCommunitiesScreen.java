package com.reddit.frontpage.presentation.modtools.modqueue.modcommunities;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.util.DiffUtil;
import android.support.v7.util.DiffUtil.DiffResult;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.evernote.android.state.State;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.di.component.DaggerModCommunitiesComponent;
import com.reddit.frontpage.di.module.ModCommunitiesViewModule;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.nav.Screens;
import com.reddit.frontpage.presentation.MvpBaseScreen;
import com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel;
import com.reddit.frontpage.presentation.modtools.modqueue.modcommunities.ModCommunitiesContract.View;
import com.reddit.frontpage.util.NetworkUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.ViewGroupsKt;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import com.reddit.frontpage.widgets.ShapedIconView;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0003+,-B\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0014J\u0016\u0010\u0019\u001a\u00020\u00162\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u0010H\u0016J\u0010\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020#H\u0014J\u0018\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020#H\u0014J\u0016\u0010*\u001a\u00020\u00162\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0016R\u0012\u0010\u0007\u001a\u00060\bR\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006."}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/modqueue/modcommunities/ModCommunitiesScreen;", "Lcom/reddit/frontpage/presentation/MvpBaseScreen;", "Lcom/reddit/frontpage/presentation/modtools/modqueue/modcommunities/ModCommunitiesContract$View;", "()V", "bundle", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "adapter", "Lcom/reddit/frontpage/presentation/modtools/modqueue/modcommunities/ModCommunitiesScreen$ModCommunitiesAdapter;", "presenter", "Lcom/reddit/frontpage/presentation/modtools/modqueue/modcommunities/ModCommunitiesPresenter;", "getPresenter", "()Lcom/reddit/frontpage/presentation/modtools/modqueue/modcommunities/ModCommunitiesPresenter;", "setPresenter", "(Lcom/reddit/frontpage/presentation/modtools/modqueue/modcommunities/ModCommunitiesPresenter;)V", "username", "", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "configureActionBar", "", "actionBar", "Landroid/support/v7/app/ActionBar;", "diffAndSetCommunities", "communities", "", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "getLayoutId", "", "navigateToScreen", "name", "onAttach", "view", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDetach", "setCommunities", "Companion", "ModCommunitiesAdapter", "ModCommunityViewHolder", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ModCommunitiesScreen.kt */
public final class ModCommunitiesScreen extends MvpBaseScreen implements View {
    public static final Companion f40104w = new Companion();
    @State
    String username;
    @Inject
    public ModCommunitiesPresenter f40105v;
    private final ModCommunitiesAdapter f40106x = new ModCommunitiesAdapter(this);

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/modqueue/modcommunities/ModCommunitiesScreen$Companion;", "", "()V", "instance", "Lcom/reddit/frontpage/presentation/modtools/modqueue/modcommunities/ModCommunitiesScreen;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ModCommunitiesScreen.kt */
    public static final class Companion {
        private Companion() {
        }

        public static ModCommunitiesScreen m23131a() {
            return new ModCommunitiesScreen();
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0016J\u001c\u0010\u0012\u001a\u00020\u00132\n\u0010\u0014\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0010\u001a\u00020\rH\u0016J\u001c\u0010\u0015\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rH\u0016R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/modqueue/modcommunities/ModCommunitiesScreen$ModCommunitiesAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/reddit/frontpage/presentation/modtools/modqueue/modcommunities/ModCommunitiesScreen$ModCommunityViewHolder;", "Lcom/reddit/frontpage/presentation/modtools/modqueue/modcommunities/ModCommunitiesScreen;", "(Lcom/reddit/frontpage/presentation/modtools/modqueue/modcommunities/ModCommunitiesScreen;)V", "items", "", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "getItemCount", "", "getItemId", "", "position", "getItemViewType", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ModCommunitiesScreen.kt */
    private final class ModCommunitiesAdapter extends Adapter<ModCommunityViewHolder> {
        List<CommunityPresentationModel> f28672a = CollectionsKt__CollectionsKt.m26790a();
        final /* synthetic */ ModCommunitiesScreen f28673b;

        public ModCommunitiesAdapter(ModCommunitiesScreen modCommunitiesScreen) {
            this.f28673b = modCommunitiesScreen;
        }

        public final /* synthetic */ ViewHolder m29789a(ViewGroup viewGroup, int i) {
            Intrinsics.m26847b(viewGroup, "parent");
            return (ViewHolder) new ModCommunityViewHolder(this.f28673b, ViewGroupsKt.m24100a(viewGroup, C1761R.layout.listitem_community, false));
        }

        public final /* synthetic */ void m29790a(ViewHolder viewHolder, int i) {
            ModCommunityViewHolder modCommunityViewHolder = (ModCommunityViewHolder) viewHolder;
            Intrinsics.m26847b(modCommunityViewHolder, "holder");
            CommunityPresentationModel communityPresentationModel = (CommunityPresentationModel) this.f28672a.get(i);
            Intrinsics.m26847b(communityPresentationModel, "model");
            modCommunityViewHolder.f28674a = communityPresentationModel;
            Util.m23984a(modCommunityViewHolder.f28675b, communityPresentationModel.f20474f, communityPresentationModel.f20475g, communityPresentationModel.f20478j, communityPresentationModel.f20479k, communityPresentationModel.f20477i, communityPresentationModel.f20480l);
            modCommunityViewHolder.f28676p.setText((CharSequence) communityPresentationModel.f20472d);
        }

        public final int m29791b(int i) {
            return ((CommunityPresentationModel) this.f28672a.get(i)).f20470b.ordinal();
        }

        public final int m29787a() {
            return this.f28672a.size();
        }

        public final long m29788a(int i) {
            return ((CommunityPresentationModel) this.f28672a.get(i)).f20481m;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/modqueue/modcommunities/ModCommunitiesScreen$ModCommunityViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/reddit/frontpage/presentation/modtools/modqueue/modcommunities/ModCommunitiesScreen;Landroid/view/View;)V", "icon", "Lcom/reddit/frontpage/widgets/ShapedIconView;", "model", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "name", "Landroid/widget/TextView;", "bind", "", "bindIcon", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ModCommunitiesScreen.kt */
    private final class ModCommunityViewHolder extends ViewHolder {
        CommunityPresentationModel f28674a;
        final ShapedIconView f28675b;
        final TextView f28676p;
        final /* synthetic */ ModCommunitiesScreen f28677q;

        public ModCommunityViewHolder(ModCommunitiesScreen modCommunitiesScreen, android.view.View view) {
            Intrinsics.m26847b(view, "view");
            this.f28677q = modCommunitiesScreen;
            super(view);
            Object obj = (ShapedIconView) view.findViewById(C1761R.id.community_icon);
            Intrinsics.m26843a(obj, "view.community_icon");
            this.f28675b = obj;
            obj = (TextView) view.findViewById(C1761R.id.community_name);
            Intrinsics.m26843a(obj, "view.community_name");
            this.f28676p = obj;
            obj = this.c;
            Intrinsics.m26843a(obj, "itemView");
            obj.setOnClickListener(new C1864x93188cd4(new Function1<android.view.View, Unit>() {
                public final /* synthetic */ Object mo6492a(Object obj) {
                    obj = this.f28677q.m40823w();
                    CommunityPresentationModel a = ModCommunityViewHolder.m29792a(this);
                    Intrinsics.m26847b(a, "item");
                    String str = a.f20472d;
                    if (str != null) {
                        if (Intrinsics.m26845a((Object) str, Util.m24027f((int) C1761R.string.title_moderating))) {
                            str = Util.m24027f((int) C1761R.string.mod);
                        }
                        obj.f34079a.mo7396a(StringsKt__StringsKt.m42447a(str, (CharSequence) "r/"));
                    }
                    return Unit.f25273a;
                }
            }));
            obj = (ImageView) view.findViewById(C1761R.id.community_favorite);
            Intrinsics.m26843a(obj, "view.community_favorite");
            ViewsKt.m24109d((android.view.View) obj);
        }

        public static final /* synthetic */ CommunityPresentationModel m29792a(ModCommunityViewHolder modCommunityViewHolder) {
            modCommunityViewHolder = modCommunityViewHolder.f28674a;
            if (modCommunityViewHolder == null) {
                Intrinsics.m26844a("model");
            }
            return modCommunityViewHolder;
        }
    }

    public static final ModCommunitiesScreen m40814x() {
        return Companion.m23131a();
    }

    public final int mo7141s() {
        return C1761R.layout.screen_communities;
    }

    public ModCommunitiesScreen() {
        super();
        DaggerModCommunitiesComponent.m29177a().m22121a(FrontpageApplication.m28875k()).m22122a(new ModCommunitiesViewModule(this)).m22123a().mo4684a(this);
    }

    public ModCommunitiesScreen(Bundle bundle) {
        Intrinsics.m26847b(bundle, "bundle");
        super(bundle);
        DaggerModCommunitiesComponent.m29177a().m22121a(FrontpageApplication.m28875k()).m22122a(new ModCommunitiesViewModule(this)).m22123a().mo4684a(this);
    }

    public final ModCommunitiesPresenter m40823w() {
        ModCommunitiesPresenter modCommunitiesPresenter = this.f40105v;
        if (modCommunitiesPresenter == null) {
            Intrinsics.m26844a("presenter");
        }
        return modCommunitiesPresenter;
    }

    public final String mo7395a() {
        return this.username;
    }

    public final android.view.View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.m26847b(layoutInflater, "inflater");
        Intrinsics.m26847b(viewGroup, "container");
        Object a = super.mo7139a(layoutInflater, viewGroup);
        Intrinsics.m26843a(a, "view");
        RecyclerView recyclerView = (RecyclerView) a.findViewById(C1761R.id.communities_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(aq_()));
        recyclerView.setAdapter(this.f40106x);
        return a;
    }

    protected final void mo7185a(ActionBar actionBar) {
        Intrinsics.m26847b(actionBar, "actionBar");
        super.mo7185a(actionBar);
        actionBar.a(C1761R.string.title_moderating_communities);
    }

    protected final void mo6992b(android.view.View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6992b(view);
        view = this.f40105v;
        if (view == null) {
            Intrinsics.m26844a("presenter");
        }
        view.attach();
    }

    protected final void mo6993c(android.view.View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6993c(view);
        view = this.f40105v;
        if (view == null) {
            Intrinsics.m26844a("presenter");
        }
        view.detach();
    }

    public final void mo7396a(String str) {
        Intrinsics.m26847b(str, "name");
        if (NetworkUtil.m23842b()) {
            m29359a((Screen) Nav.m22571c(str));
        } else {
            Screens.m22628a((Screen) this, (int) C1761R.string.error_no_internet).a();
        }
    }

    public final void mo7397a(List<CommunityPresentationModel> list) {
        Intrinsics.m26847b(list, "communities");
        DiffResult a = DiffUtil.a(new ModCommunitiesScreen$diffAndSetCommunities$result$1(this, this.f40106x.f28672a, list));
        Intrinsics.m26847b(list, "communities");
        ModCommunitiesAdapter modCommunitiesAdapter = this.f40106x;
        Intrinsics.m26847b(list, "<set-?>");
        modCommunitiesAdapter.f28672a = list;
        a.a((Adapter) this.f40106x);
    }
}
