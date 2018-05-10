package com.reddit.frontpage.presentation.geopopular.select;

import android.support.annotation.RequiresApi;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.OnQueryTextListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.di.component.DaggerGeopopularRegionSelectComponent;
import com.reddit.frontpage.di.module.GeopopularRegionSelectViewModule;
import com.reddit.frontpage.domain.model.Region;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.presentation.MvpBaseScreen;
import com.reddit.frontpage.presentation.geopopular.ActionBarProvider;
import com.reddit.frontpage.presentation.geopopular.GeopopularRegionSelectFilter;
import com.reddit.frontpage.presentation.geopopular.GeopopularSelectFilterTarget;
import com.reddit.frontpage.presentation.geopopular.model.GeopopularRegionPresentationModel;
import com.reddit.frontpage.presentation.geopopular.select.GeopopularRegionSelectContract.Navigator;
import com.reddit.frontpage.presentation.geopopular.select.GeopopularRegionSelectContract.View;
import com.reddit.frontpage.presentation.geopopular.subregion.GeopopularRegionAdapter;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import de.greenrobot.event.EventBus;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020(H\u0016J&\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\b00H\u0016J\u0010\u00101\u001a\u00020(2\u0006\u00102\u001a\u00020 H\u0016J\u0010\u00103\u001a\u00020(2\u0006\u00104\u001a\u000205H\u0014J\u0018\u00106\u001a\u00020(2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0016J\u0018\u0010;\u001a\u0002052\u0006\u00109\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0016J\u0010\u0010?\u001a\u00020(2\u0006\u00104\u001a\u000205H\u0014J-\u0010@\u001a\u00020(2\u0006\u0010A\u001a\u00020&2\u000e\u0010B\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0C2\u0006\u0010D\u001a\u00020EH\u0016¢\u0006\u0002\u0010FJ\u0010\u0010G\u001a\u00020(2\u0006\u00102\u001a\u00020 H\u0016J\u0016\u0010H\u001a\u00020(2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020J00H\u0016J\u0010\u0010K\u001a\u00020(2\u0006\u0010L\u001a\u00020\bH\u0016J\b\u0010M\u001a\u00020(H\u0017J\b\u0010N\u001a\u00020(H\u0016J\b\u0010O\u001a\u00020(H\u0016R2\u0010\u0006\u001a&\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b \t*\u0012\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u001c8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006P"}, d2 = {"Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectScreen;", "Lcom/reddit/frontpage/presentation/MvpBaseScreen;", "Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectContract$View;", "Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectContract$Navigator;", "Lcom/reddit/frontpage/presentation/geopopular/GeopopularSelectFilterTarget;", "()V", "_searchQuery", "Lio/reactivex/subjects/PublishSubject;", "", "kotlin.jvm.PlatformType", "actionBarProvider", "Lcom/reddit/frontpage/presentation/geopopular/ActionBarProvider;", "getActionBarProvider", "()Lcom/reddit/frontpage/presentation/geopopular/ActionBarProvider;", "actionBarProvider$delegate", "Lkotlin/Lazy;", "adapter", "Lcom/reddit/frontpage/presentation/geopopular/subregion/GeopopularRegionAdapter;", "getAdapter", "()Lcom/reddit/frontpage/presentation/geopopular/subregion/GeopopularRegionAdapter;", "adapter$delegate", "presenter", "Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectPresenter;", "getPresenter", "()Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectPresenter;", "setPresenter", "(Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectPresenter;)V", "searchQuery", "Lio/reactivex/Observable;", "getSearchQuery", "()Lio/reactivex/Observable;", "subregionSelectFilter", "Lcom/reddit/frontpage/presentation/geopopular/GeopopularRegionSelectFilter;", "getSubregionSelectFilter", "()Lcom/reddit/frontpage/presentation/geopopular/GeopopularRegionSelectFilter;", "setSubregionSelectFilter", "(Lcom/reddit/frontpage/presentation/geopopular/GeopopularRegionSelectFilter;)V", "getLayoutId", "", "hideRegionList", "", "hideUseLocation", "navigateToSubregionSelect", "parent", "Lcom/reddit/frontpage/domain/model/Region;", "parentPreviouslySelected", "", "selectedChildIds", "", "notifyRegionSelect", "select", "onAttach", "view", "Landroid/view/View;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateView", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDetach", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "setFilter", "setRegions", "regions", "Lcom/reddit/frontpage/presentation/geopopular/model/GeopopularRegionPresentationModel;", "showError", "string", "showLocationPermissionRequest", "showRegionList", "showUseLocation", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: GeopopularRegionSelectScreen.kt */
public final class GeopopularRegionSelectScreen extends MvpBaseScreen implements GeopopularSelectFilterTarget, Navigator, View {
    static final /* synthetic */ KProperty[] f40017v = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(GeopopularRegionSelectScreen.class), "actionBarProvider", "getActionBarProvider()Lcom/reddit/frontpage/presentation/geopopular/ActionBarProvider;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(GeopopularRegionSelectScreen.class), "adapter", "getAdapter()Lcom/reddit/frontpage/presentation/geopopular/subregion/GeopopularRegionAdapter;"))};
    private final PublishSubject<String> f40018A = PublishSubject.create();
    @Inject
    public GeopopularRegionSelectPresenter f40019w;
    private GeopopularRegionSelectFilter f40020x;
    private final Lazy f40021y = LazyKt.m26777a(new GeopopularRegionSelectScreen$actionBarProvider$2(this));
    private final Lazy f40022z = LazyKt.m26777a(new GeopopularRegionSelectScreen$adapter$2(this));

    private final GeopopularRegionAdapter m40589x() {
        return (GeopopularRegionAdapter) this.f40022z.mo5678b();
    }

    public final int mo7141s() {
        return C1761R.layout.screen_geopopular_region_select;
    }

    public GeopopularRegionSelectScreen() {
        super();
        DaggerGeopopularRegionSelectComponent.m29134a().m22107a(FrontpageApplication.m28875k()).m22108a(new GeopopularRegionSelectViewModule(this, this)).m22109a().mo4662a(this);
    }

    public final GeopopularRegionSelectFilter y_() {
        return this.f40020x;
    }

    public final GeopopularRegionSelectPresenter m40604w() {
        GeopopularRegionSelectPresenter geopopularRegionSelectPresenter = this.f40019w;
        if (geopopularRegionSelectPresenter == null) {
            Intrinsics.m26844a("presenter");
        }
        return geopopularRegionSelectPresenter;
    }

    public final Observable<String> mo7348b() {
        Object obj = this.f40018A;
        Intrinsics.m26843a(obj, "_searchQuery");
        return (Observable) obj;
    }

    public final android.view.View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.m26847b(layoutInflater, "inflater");
        Intrinsics.m26847b(viewGroup, "container");
        Object a = super.mo7139a(layoutInflater, viewGroup);
        n();
        Intrinsics.m26843a(a, "view");
        RecyclerView recyclerView = (RecyclerView) a.findViewById(C1761R.id.geopopular_region_items);
        recyclerView.setAdapter(m40589x());
        recyclerView.setLayoutManager(new LinearLayoutManager(a.getContext()));
        Object obj = (TextView) a.findViewById(C1761R.id.geopopular_use_location);
        Intrinsics.m26843a(obj, "view.geopopular_use_location");
        ((android.view.View) obj).setOnClickListener(new C1818x8864b2db(new GeopopularRegionSelectScreen$onCreateView$$inlined$also$lambda$1(this)));
        Intrinsics.m26843a(a, "super.onCreateView(infla…)\n            }\n        }");
        return a;
    }

    public final void m40592a(Menu menu, MenuInflater menuInflater) {
        Intrinsics.m26847b(menu, "menu");
        Intrinsics.m26847b(menuInflater, "inflater");
        super.a(menu, menuInflater);
        menuInflater.inflate(C1761R.menu.menu_region_select, menu);
        menu = MenuItemCompat.a(menu.findItem(C1761R.id.region_select_search));
        if (menu == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.support.v7.widget.SearchView");
        }
        ((SearchView) menu).setOnQueryTextListener((OnQueryTextListener) new C2303xb9991918(this));
    }

    protected final void mo6992b(android.view.View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6992b(view);
        view = this.f40019w;
        if (view == null) {
            Intrinsics.m26844a("presenter");
        }
        view.attach();
        ((ActionBarProvider) this.f40021y.mo5678b()).mo7784a().a(Util.m24027f((int) C1761R.string.region_select_title));
    }

    protected final void mo6993c(android.view.View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6993c(view);
        view = this.f40019w;
        if (view == null) {
            Intrinsics.m26844a("presenter");
        }
        view.detach();
    }

    public final void mo7347a(List<GeopopularRegionPresentationModel> list) {
        Intrinsics.m26847b(list, "regions");
        m40589x().m29544a((List) list);
        m40589x().e();
    }

    public final void mo7349b(GeopopularRegionSelectFilter geopopularRegionSelectFilter) {
        Intrinsics.m26847b(geopopularRegionSelectFilter, "select");
        EventBus.getDefault().postSticky(geopopularRegionSelectFilter);
        geopopularRegionSelectFilter = am_();
        if (geopopularRegionSelectFilter == null) {
            Intrinsics.m26842a();
        }
        geopopularRegionSelectFilter.finish();
    }

    public final void z_() {
        Object obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        obj = (RecyclerView) obj.findViewById(C1761R.id.geopopular_region_items);
        Intrinsics.m26843a(obj, "rootView.geopopular_region_items");
        ViewsKt.m24107c((android.view.View) obj);
    }

    public final void A_() {
        Object obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        obj = (RecyclerView) obj.findViewById(C1761R.id.geopopular_region_items);
        Intrinsics.m26843a(obj, "rootView.geopopular_region_items");
        ViewsKt.m24109d((android.view.View) obj);
    }

    public final void mo7350c() {
        Object obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        obj = (LinearLayout) obj.findViewById(C1761R.id.use_location_layout);
        Intrinsics.m26843a(obj, "rootView.use_location_layout");
        ViewsKt.m24107c((android.view.View) obj);
        obj = am_();
        if (obj == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26843a(obj, "activity!!");
        Util.m23972a(obj.getCurrentFocus());
    }

    public final void mo7351d() {
        Object obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        obj = (LinearLayout) obj.findViewById(C1761R.id.use_location_layout);
        Intrinsics.m26843a(obj, "rootView.use_location_layout");
        ViewsKt.m24109d((android.view.View) obj);
    }

    @RequiresApi(23)
    public final void B_() {
        a(new String[]{"android.permission.ACCESS_COARSE_LOCATION"}, 19);
    }

    public final void m40591a(int i, String[] strArr, int[] iArr) {
        Intrinsics.m26847b(strArr, "permissions");
        Intrinsics.m26847b(iArr, "grantResults");
        super.a(i, strArr, iArr);
        if (i == 19) {
            if ((1 ^ (iArr.length == null ? 1 : null)) == 0 || ArraysKt___ArraysKt.m36080a(iArr) != 0) {
                i = this.f40019w;
                if (i == 0) {
                    Intrinsics.m26844a("presenter");
                }
                i = i.f33864a;
                String f = Util.m24027f((int) 2131886335);
                Intrinsics.m26843a((Object) f, "Util.getString(R.string.error_current_location)");
                i.mo7346a(f);
            } else {
                i = this.f40019w;
                if (i == 0) {
                    Intrinsics.m26844a("presenter");
                }
                i.m34690b();
            }
        }
    }

    public final void mo7344a(Region region, boolean z, List<String> list) {
        Intrinsics.m26847b(region, "parent");
        Intrinsics.m26847b(list, "selectedChildIds");
        Screen a = Nav.m22543a(region, z, (List) list);
        Screen screen = this;
        a.m29363b(screen);
        Routing.m22623a(screen, a);
    }

    public final void mo7346a(String str) {
        Intrinsics.m26847b(str, "string");
        mo7204a((CharSequence) str);
    }

    public final void mo7345a(GeopopularRegionSelectFilter geopopularRegionSelectFilter) {
        Intrinsics.m26847b(geopopularRegionSelectFilter, "select");
        this.f40020x = geopopularRegionSelectFilter;
    }
}
