package com.reddit.frontpage.presentation.geopopular.subregion;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.bluelinelabs.conductor.Controller;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.di.component.DaggerGeopopularSubregionSelectComponent;
import com.reddit.frontpage.di.module.GeopopularSubregionSelectViewModule;
import com.reddit.frontpage.domain.model.Region;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.presentation.MvpBaseScreen;
import com.reddit.frontpage.presentation.geopopular.ActionBarProvider;
import com.reddit.frontpage.presentation.geopopular.GeopopularRegionSelectFilter;
import com.reddit.frontpage.presentation.geopopular.GeopopularSelectFilterTarget;
import com.reddit.frontpage.presentation.geopopular.model.GeopopularRegionPresentationModel;
import com.reddit.frontpage.presentation.geopopular.subregion.GeopopularSubregionSelectContract.Navigator;
import com.reddit.frontpage.presentation.geopopular.subregion.GeopopularSubregionSelectContract.View;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 =2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001=B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00100\u001a\u00020,2\u0006\u00101\u001a\u000202H\u0014J\b\u00103\u001a\u00020\u0017H\u0016J\u0018\u00104\u001a\u0002022\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0016J\u0010\u00109\u001a\u00020,2\u0006\u00101\u001a\u000202H\u0014J\u0016\u0010:\u001a\u00020,2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020<0#H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R \u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#X.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006>"}, d2 = {"Lcom/reddit/frontpage/presentation/geopopular/subregion/GeopopularSubregionSelectScreen;", "Lcom/reddit/frontpage/presentation/MvpBaseScreen;", "Lcom/reddit/frontpage/presentation/geopopular/subregion/GeopopularSubregionSelectContract$View;", "Lcom/reddit/frontpage/presentation/geopopular/subregion/GeopopularSubregionSelectContract$Navigator;", "()V", "actionBarProvider", "Lcom/reddit/frontpage/presentation/geopopular/ActionBarProvider;", "getActionBarProvider", "()Lcom/reddit/frontpage/presentation/geopopular/ActionBarProvider;", "actionBarProvider$delegate", "Lkotlin/Lazy;", "adapter", "Lcom/reddit/frontpage/presentation/geopopular/subregion/GeopopularRegionAdapter;", "getAdapter", "()Lcom/reddit/frontpage/presentation/geopopular/subregion/GeopopularRegionAdapter;", "adapter$delegate", "parent", "Lcom/reddit/frontpage/domain/model/Region;", "getParent", "()Lcom/reddit/frontpage/domain/model/Region;", "setParent", "(Lcom/reddit/frontpage/domain/model/Region;)V", "parentIsPreviouslySelected", "", "getParentIsPreviouslySelected", "()Z", "setParentIsPreviouslySelected", "(Z)V", "presenter", "Lcom/reddit/frontpage/presentation/geopopular/subregion/GeopopularSubregionSelectPresenter;", "getPresenter", "()Lcom/reddit/frontpage/presentation/geopopular/subregion/GeopopularSubregionSelectPresenter;", "setPresenter", "(Lcom/reddit/frontpage/presentation/geopopular/subregion/GeopopularSubregionSelectPresenter;)V", "selectedChildIds", "", "", "getSelectedChildIds", "()Ljava/util/List;", "setSelectedChildIds", "(Ljava/util/List;)V", "getLayoutId", "", "navigateAway", "", "notifyRegionSelect", "select", "Lcom/reddit/frontpage/presentation/geopopular/GeopopularRegionSelectFilter;", "onAttach", "view", "Landroid/view/View;", "onBackPressed", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDetach", "setRegions", "models", "Lcom/reddit/frontpage/presentation/geopopular/model/GeopopularRegionPresentationModel;", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: GeopopularSubregionSelectScreen.kt */
public final class GeopopularSubregionSelectScreen extends MvpBaseScreen implements Navigator, View {
    public static final Companion f40023A = new Companion();
    static final /* synthetic */ KProperty[] f40024v = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(GeopopularSubregionSelectScreen.class), "actionBarProvider", "getActionBarProvider()Lcom/reddit/frontpage/presentation/geopopular/ActionBarProvider;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(GeopopularSubregionSelectScreen.class), "adapter", "getAdapter()Lcom/reddit/frontpage/presentation/geopopular/subregion/GeopopularRegionAdapter;"))};
    private final Lazy f40025B = LazyKt.m26777a(new GeopopularSubregionSelectScreen$actionBarProvider$2(this));
    private final Lazy f40026C = LazyKt.m26777a(new GeopopularSubregionSelectScreen$adapter$2(this));
    @Inject
    public GeopopularSubregionSelectPresenter f40027w;
    public Region f40028x;
    public List<String> f40029y;
    boolean f40030z;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\f"}, d2 = {"Lcom/reddit/frontpage/presentation/geopopular/subregion/GeopopularSubregionSelectScreen$Companion;", "", "()V", "newInstance", "Lcom/reddit/frontpage/presentation/geopopular/subregion/GeopopularSubregionSelectScreen;", "parent", "Lcom/reddit/frontpage/domain/model/Region;", "selectedChildIds", "", "", "previouslySelected", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: GeopopularSubregionSelectScreen.kt */
    public static final class Companion {
        private Companion() {
        }

        public static GeopopularSubregionSelectScreen m22865a(Region region, List<String> list, boolean z) {
            Intrinsics.m26847b(region, "parent");
            Intrinsics.m26847b(list, "selectedChildIds");
            GeopopularSubregionSelectScreen geopopularSubregionSelectScreen = new GeopopularSubregionSelectScreen();
            Intrinsics.m26847b(region, "<set-?>");
            geopopularSubregionSelectScreen.f40028x = region;
            Intrinsics.m26847b(list, "<set-?>");
            geopopularSubregionSelectScreen.f40029y = list;
            geopopularSubregionSelectScreen.f40030z = z;
            return geopopularSubregionSelectScreen;
        }
    }

    public static final GeopopularSubregionSelectScreen m40605a(Region region, List<String> list, boolean z) {
        return Companion.m22865a(region, list, z);
    }

    private final GeopopularRegionAdapter m40606x() {
        return (GeopopularRegionAdapter) this.f40026C.mo5678b();
    }

    public final int mo7141s() {
        return C1761R.layout.screen_geopopular_subregion_select;
    }

    public GeopopularSubregionSelectScreen() {
        super();
        DaggerGeopopularSubregionSelectComponent.m29136a().m22112a(FrontpageApplication.m28875k()).m22113a(new GeopopularSubregionSelectViewModule(this, this)).m22114a().mo4663a(this);
    }

    public final GeopopularSubregionSelectPresenter m40616w() {
        GeopopularSubregionSelectPresenter geopopularSubregionSelectPresenter = this.f40027w;
        if (geopopularSubregionSelectPresenter == null) {
            Intrinsics.m26844a("presenter");
        }
        return geopopularSubregionSelectPresenter;
    }

    public final Region mo7354a() {
        Region region = this.f40028x;
        if (region == null) {
            Intrinsics.m26844a("parent");
        }
        return region;
    }

    public final List<String> mo7358b() {
        List<String> list = this.f40029y;
        if (list == null) {
            Intrinsics.m26844a("selectedChildIds");
        }
        return list;
    }

    public final android.view.View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.m26847b(layoutInflater, "inflater");
        Intrinsics.m26847b(viewGroup, "container");
        Object a = super.mo7139a(layoutInflater, viewGroup);
        Intrinsics.m26843a(a, "view");
        RecyclerView recyclerView = (RecyclerView) a.findViewById(C1761R.id.geopopular_subregion_items);
        recyclerView.setAdapter(m40606x());
        recyclerView.setLayoutManager(new LinearLayoutManager(a.getContext()));
        Intrinsics.m26843a(a, "super.onCreateView(infla…)\n            }\n        }");
        return a;
    }

    protected final void mo6992b(android.view.View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6992b(view);
        view = this.f40027w;
        if (view == null) {
            Intrinsics.m26844a("presenter");
        }
        view.attach();
        ((ActionBarProvider) this.f40025B.mo5678b()).mo7784a().a(mo7354a().getName());
    }

    protected final void mo6993c(android.view.View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6993c(view);
        view = this.f40027w;
        if (view == null) {
            Intrinsics.m26844a("presenter");
        }
        view.detach();
    }

    public final void mo7356a(List<GeopopularRegionPresentationModel> list) {
        Intrinsics.m26847b(list, "models");
        m40606x().m29544a((List) list);
        m40606x().e();
    }

    public final void mo7355a(GeopopularRegionSelectFilter geopopularRegionSelectFilter) {
        Intrinsics.m26847b(geopopularRegionSelectFilter, "select");
        Controller k = k();
        if (k == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.geopopular.GeopopularSelectFilterTarget");
        }
        ((GeopopularSelectFilterTarget) k).mo7345a(geopopularRegionSelectFilter);
        Routing.m22621a((Screen) this);
    }

    public final boolean mo6986J() {
        GeopopularSubregionSelectPresenter geopopularSubregionSelectPresenter = this.f40027w;
        if (geopopularSubregionSelectPresenter == null) {
            Intrinsics.m26844a("presenter");
        }
        geopopularSubregionSelectPresenter.f33874a.remove(CollectionsKt__CollectionsKt.m26787a(geopopularSubregionSelectPresenter.f33874a));
        if (geopopularSubregionSelectPresenter.f33874a.isEmpty()) {
            geopopularSubregionSelectPresenter.f33876c.ai_();
        } else {
            geopopularSubregionSelectPresenter.f33875b.mo7356a((List) CollectionsKt___CollectionsKt.m41437f(geopopularSubregionSelectPresenter.f33874a));
        }
        return false;
    }

    public final void ai_() {
        Routing.m22621a((Screen) this);
    }
}
