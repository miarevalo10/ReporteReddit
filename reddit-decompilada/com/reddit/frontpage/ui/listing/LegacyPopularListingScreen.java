package com.reddit.frontpage.ui.listing;

import android.support.annotation.RequiresApi;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.evernote.android.state.State;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.data.provider.LinkListingProvider;
import com.reddit.datalibrary.frontpage.data.provider.LocationPermissionRequestListener;
import com.reddit.datalibrary.frontpage.data.provider.LocationPermissionRequestProvider;
import com.reddit.datalibrary.frontpage.data.provider.ProviderManager;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listing;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.events.v1.BaseEvent;
import com.reddit.frontpage.commons.analytics.events.v1.ScreenViewEvent.ScreenViewPayload;
import com.reddit.frontpage.commons.analytics.events.v2.ScreenviewEventBuilder;
import com.reddit.frontpage.di.component.UserComponent;
import com.reddit.frontpage.domain.model.Region;
import com.reddit.frontpage.domain.repository.PreferenceRepository;
import com.reddit.frontpage.presentation.geopopular.GeopopularRegionSelectFilter;
import com.reddit.frontpage.presentation.listing.model.ListingViewMode;
import com.reddit.frontpage.presentation.viewmode.ViewModeOptionSelection;
import com.reddit.frontpage.ui.home.HomeTab;
import com.reddit.frontpage.ui.home.TooltipPopupWindow;
import com.reddit.frontpage.util.ListUtil;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import com.reddit.frontpage.widgets.ListingFilterBarView;
import de.greenrobot.event.EventBus;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 f2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001fB\u0005¢\u0006\u0002\u0010\u0004J\u0012\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020+H\u0014J\b\u0010,\u001a\u00020\fH\u0016J\b\u0010-\u001a\u00020\fH\u0016J\u001e\u0010.\u001a\u00020\f2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u001c2\u0006\u00101\u001a\u00020\fH\u0002J\b\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u00020\fH\u0016J\b\u00105\u001a\u00020\fH\u0014J\n\u00106\u001a\u0004\u0018\u00010\fH\u0014J\b\u00107\u001a\u00020\u0006H\u0014J\u0010\u00108\u001a\u00020!2\u0006\u00109\u001a\u00020\u0016H\u0002J\b\u0010:\u001a\u00020\u0006H\u0002J\b\u0010;\u001a\u00020\u0006H\u0014J\b\u0010<\u001a\u00020!H\u0014J\b\u0010=\u001a\u00020!H\u0016J\u0018\u0010>\u001a\u00020!2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u000203H\u0016J\u0010\u0010B\u001a\u00020!2\u0006\u0010C\u001a\u00020DH\u0014J\u0018\u0010E\u001a\u00020D2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020IH\u0016J\u0010\u0010J\u001a\u00020!2\u0006\u0010C\u001a\u00020DH\u0014J\u000e\u0010K\u001a\u00020!2\u0006\u0010L\u001a\u00020\u001fJ\u000e\u0010K\u001a\u00020!2\u0006\u0010M\u001a\u00020NJ\b\u0010O\u001a\u00020!H\u0014J-\u0010P\u001a\u00020!2\u0006\u0010Q\u001a\u0002032\u000e\u0010R\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0S2\u0006\u0010T\u001a\u00020UH\u0016¢\u0006\u0002\u0010VJ\u001c\u0010W\u001a\u00020!2\b\b\u0001\u0010X\u001a\u0002032\b\b\u0001\u0010Y\u001a\u000203H\u0014J\u001e\u0010Z\u001a\n\u0012\u0004\u0012\u00020\\\u0018\u00010[2\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\\0[H\u0014J\b\u0010^\u001a\u00020!H\u0002J\u0010\u0010_\u001a\u00020!2\u0006\u0010L\u001a\u00020\u001fH\u0002J\u0010\u0010`\u001a\u00020!2\u0006\u0010a\u001a\u00020\u0018H\u0017J\b\u0010b\u001a\u00020\u0006H\u0016J\u0010\u0010c\u001a\u00020!2\u0006\u00109\u001a\u00020\u0016H\u0002J\b\u0010d\u001a\u00020!H\u0002J\u0010\u0010e\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\fH\u0002R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u000e\u0010\u0014\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R&\u0010\u001a\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u001d0\u001c0\u001bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000¨\u0006g"}, d2 = {"Lcom/reddit/frontpage/ui/listing/LegacyPopularListingScreen;", "Lcom/reddit/frontpage/ui/listing/SubscribeListingScreen;", "Lcom/reddit/frontpage/ui/home/HomeTab;", "Lcom/reddit/datalibrary/frontpage/data/provider/LocationPermissionRequestProvider;", "()V", "checkedRemoteGeopopular", "", "getCheckedRemoteGeopopular", "()Z", "setCheckedRemoteGeopopular", "(Z)V", "geopopularRegionName", "", "getGeopopularRegionName", "()Ljava/lang/String;", "setGeopopularRegionName", "(Ljava/lang/String;)V", "geopopularRegionQueryParameterValue", "getGeopopularRegionQueryParameterValue", "setGeopopularRegionQueryParameterValue", "initialized", "listingFilterBar", "Lcom/reddit/frontpage/widgets/ListingFilterBarView;", "locationPermissionListener", "Lcom/reddit/datalibrary/frontpage/data/provider/LocationPermissionRequestListener;", "notifyOn", "queryParameters", "Lkotlin/Function0;", "", "Lkotlin/Pair;", "selectFilter", "Lcom/reddit/frontpage/presentation/geopopular/GeopopularRegionSelectFilter;", "addScreenviewEventAttributes", "", "builder", "Lcom/reddit/frontpage/commons/analytics/events/v2/ScreenviewEventBuilder;", "addV1ScreenViewEventAttributes", "payload", "Lcom/reddit/frontpage/commons/analytics/events/v1/ScreenViewEvent$ScreenViewPayload;", "createListingProvider", "Lcom/reddit/datalibrary/frontpage/data/provider/LinkListingProvider;", "customizeDecorationStrategy", "strategy", "Lcom/reddit/frontpage/ui/listing/DecorationInclusionStrategy;", "getAnalyticsPageType", "getAnalyticsScreenName", "getGeoFilterDisplayName", "regions", "Lcom/reddit/frontpage/domain/model/Region;", "geoFilter", "getLayoutId", "", "getListingName", "getSourcePage", "getViewModePreferenceKey", "hasNavigationDrawer", "initViewModeOption", "bar", "isFreshContentPillExperimentEnabled", "isRefreshPillActive", "load", "notifyOnScreen", "onAppBarOffsetChanged", "appBarLayout", "Landroid/support/design/widget/AppBarLayout;", "verticalOffset", "onAttach", "view", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDetach", "onEventMainThread", "select", "viewModeSelection", "Lcom/reddit/frontpage/presentation/viewmode/ViewModeOptionSelection;", "onListingLoad", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onSortChanged", "sortType", "sortTimeFrame", "processListing", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listing;", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "listing", "reconcileRemoteGeopopularPrefs", "reloadListingWithGeoFilterSelection", "requestLocationPermission", "listenerPermission", "resetScreen", "showGeopopularTooltipIfNeeded", "showRefreshPillIfNeeded", "storeGeopopularPreference", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LegacyPopularListingScreen.kt */
public final class LegacyPopularListingScreen extends SubscribeListingScreen implements LocationPermissionRequestProvider, HomeTab {
    public static final Companion f40740M = new Companion();
    private ListingFilterBarView f40741N;
    private GeopopularRegionSelectFilter f40742O;
    private boolean f40743P;
    private boolean f40744Q;
    private LocationPermissionRequestListener f40745R;
    private final Function0<List<Pair<String, String>>> f40746S = new LegacyPopularListingScreen$queryParameters$1(this);
    @State
    boolean checkedRemoteGeopopular;
    @State
    String geopopularRegionName = Region.DEFAULT.getName();
    @State
    String geopopularRegionQueryParameterValue = com.reddit.frontpage.presentation.geopopular.GeopopularRegionSelectFilter.Companion.m22843a().f20534a;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/reddit/frontpage/ui/listing/LegacyPopularListingScreen$Companion;", "", "()V", "ANALYTICS_PAGE_TYPE", "", "ANALYTICS_SCREEN_NAME", "GEO_FILTER_QUERY_PARAMETER", "LISTING_NAME", "SOURCE_PAGE", "newInstance", "Lcom/reddit/frontpage/ui/listing/LegacyPopularListingScreen;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: LegacyPopularListingScreen.kt */
    public static final class Companion {
        private Companion() {
        }

        public static LegacyPopularListingScreen m23428a() {
            return new LegacyPopularListingScreen();
        }
    }

    public static final LegacyPopularListingScreen m42520w() {
        return Companion.m23428a();
    }

    public final String mo7451T() {
        return "popular";
    }

    protected final String mo7453V() {
        return "popular";
    }

    protected final boolean mo7692W() {
        return false;
    }

    public final void mo7215a(AppBarLayout appBarLayout, int i) {
        Intrinsics.m26847b(appBarLayout, "appBarLayout");
    }

    protected final boolean af_() {
        return true;
    }

    protected final String ah() {
        return "listingViewMode.popular";
    }

    public final String getAnalyticsPageType() {
        return "popular";
    }

    public final String getAnalyticsScreenName() {
        return "popular";
    }

    public final int mo7141s() {
        return C1761R.layout.screen_popular;
    }

    public LegacyPopularListingScreen() {
        com.reddit.frontpage.presentation.geopopular.GeopopularRegionSelectFilter.Companion companion = GeopopularRegionSelectFilter.f20532c;
    }

    public final void m42536a(String str) {
        Intrinsics.m26847b(str, "<set-?>");
        this.geopopularRegionQueryParameterValue = str;
    }

    public final void m42538b(String str) {
        Intrinsics.m26847b(str, "<set-?>");
        this.geopopularRegionName = str;
    }

    public final View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.m26847b(layoutInflater, "inflater");
        Intrinsics.m26847b(viewGroup, "container");
        super.mo7139a(layoutInflater, viewGroup);
        Object inflate = layoutInflater.inflate(C1761R.layout.widget_sort_bar, viewGroup, false);
        ListingFilterBarView listingFilterBarView = (ListingFilterBarView) inflate.findViewById(C1761R.id.listing_filter_bar);
        Object obj = this.E;
        Intrinsics.m26843a(obj, "linkProvider");
        int b = obj.b();
        Object obj2 = this.E;
        Intrinsics.m26843a(obj2, "linkProvider");
        listingFilterBarView.m24179a(b, obj2.c());
        listingFilterBarView.setOnSortClickListener(new LegacyPopularListingScreen$onCreateView$$inlined$let$lambda$1(this));
        listingFilterBarView.setGeopopularOnClickListener(new LegacyPopularListingScreen$onCreateView$$inlined$let$lambda$2(this));
        obj = this.E;
        Intrinsics.m26843a(obj, "linkProvider");
        listingFilterBarView.m24178a(obj.b());
        listingFilterBarView.setOnViewModeClickListener(new LegacyPopularListingScreen$onCreateView$$inlined$let$lambda$3(this));
        this.w.m35092a((View) inflate);
        Intrinsics.m26843a(inflate, "view");
        inflate = (ListingFilterBarView) inflate.findViewById(C1761R.id.listing_filter_bar);
        Intrinsics.m26843a(inflate, "view.listing_filter_bar");
        this.f40741N = inflate;
        layoutInflater = this.f40741N;
        if (layoutInflater == null) {
            Intrinsics.m26844a("listingFilterBar");
        }
        Object obj3 = this.H;
        Intrinsics.m26843a(obj3, "viewMode");
        layoutInflater.setViewMode(obj3);
        GeopopularRegionSelectFilter geopopularRegionSelectFilter = (GeopopularRegionSelectFilter) FrontpageApplication.m28875k().mo4613a().m22472a().blockingGet();
        viewGroup = geopopularRegionSelectFilter.f20534a;
        layoutInflater = geopopularRegionSelectFilter.f20535b;
        this.geopopularRegionQueryParameterValue = viewGroup;
        this.geopopularRegionName = layoutInflater;
        if (this.checkedRemoteGeopopular == null) {
            this.checkedRemoteGeopopular = true;
            layoutInflater = this.G;
            viewGroup = new RemoteRedditApiDataSource();
            layoutInflater.mo5631a(RemoteRedditApiDataSource.d().map(new LegacyPopularListingScreen$reconcileRemoteGeopopularPrefs$1(this)).onErrorReturn(LegacyPopularListingScreen$reconcileRemoteGeopopularPrefs$2.f29047a).subscribeOn(Schedulers.m26771b()).observeOn(AndroidSchedulers.m26509a()).subscribe((Consumer) new LegacyPopularListingScreen$reconcileRemoteGeopopularPrefs$3(this)));
        }
        inflate = this.K;
        Intrinsics.m26843a(inflate, "rootView");
        return inflate;
    }

    protected final void mo6992b(View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6992b(view);
        if (this.f40744Q != null) {
            ap();
        }
    }

    protected final void mo6993c(View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6993c(view);
        this.f40743P = null;
    }

    public final void ap() {
        if (v_()) {
            super.ap();
            this.f40744Q = false;
            if (this.f40743P) {
                ListingFilterBarView listingFilterBarView = this.f40741N;
                if (listingFilterBarView == null) {
                    Intrinsics.m26844a("listingFilterBar");
                }
                if (listingFilterBarView.getGeopopularSelection().isShown()) {
                    PreferenceRepository a = FrontpageApplication.m28875k().mo4613a();
                    CompositeDisposable compositeDisposable = this.G;
                    com.reddit.frontpage.ui.home.TooltipPopupWindow.Companion companion = TooltipPopupWindow.f21224d;
                    compositeDisposable.mo5631a(a.m22475b(com.reddit.frontpage.ui.home.TooltipPopupWindow.Companion.m23372a()).subscribe((Consumer) new LegacyPopularListingScreen$showGeopopularTooltipIfNeeded$1(this, listingFilterBarView, a)));
                }
                Object obj = this.refreshPill;
                Intrinsics.m26843a(obj, "refreshPill");
                ViewsKt.m24109d((View) obj);
                return;
            }
            this.f40743P = true;
            mo7693Z();
            return;
        }
        this.f40744Q = true;
    }

    protected final void mo7693Z() {
        if (this.f40743P) {
            super.mo7693Z();
        }
    }

    protected final void aa() {
        FrontpageSettings.a().j("popular");
        Object obj = this.refreshPill;
        Intrinsics.m26843a(obj, "refreshPill");
        ViewsKt.m24109d((View) obj);
    }

    protected final Listing<Listable> mo7456a(Listing<Listable> listing) {
        Intrinsics.m26847b(listing, "listing");
        return this.f40743P ? super.mo7456a((Listing) listing) : null;
    }

    public final LinkListingProvider mo7452U() {
        if (this.f40742O == null) {
            GeopopularRegionSelectFilter geopopularRegionSelectFilter = (GeopopularRegionSelectFilter) FrontpageApplication.m28875k().mo4613a().m22472a().blockingGet();
            this.geopopularRegionQueryParameterValue = geopopularRegionSelectFilter.f20534a;
            this.f40742O = geopopularRegionSelectFilter;
        }
        Object Y_ = Y_();
        Intrinsics.m26843a(Y_, "instanceId");
        return ProviderManager.a(Y_, "popular", this.f40746S);
    }

    protected final void mo7696a(DecorationInclusionStrategy decorationInclusionStrategy) {
        Intrinsics.m26847b(decorationInclusionStrategy, "strategy");
        decorationInclusionStrategy.m23389a(LegacyPopularListingScreen$customizeDecorationStrategy$1.f37268a);
    }

    protected final void mo7694a(int i, int i2) {
        super.mo7694a(i, i2);
        i = this.f40741N;
        if (i == 0) {
            Intrinsics.m26844a("listingFilterBar");
        }
        Object obj = this.E;
        Intrinsics.m26843a(obj, "linkProvider");
        i2 = obj.b();
        Object obj2 = this.E;
        Intrinsics.m26843a(obj2, "linkProvider");
        i.m24179a(i2, obj2.c());
    }

    public final boolean mo7200K() {
        Object obj = this.listView;
        Intrinsics.m26843a(obj, "listView");
        LayoutManager layoutManager = obj.getLayoutManager();
        if (layoutManager == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        } else if (ListUtil.m23810a((LinearLayoutManager) layoutManager)) {
            return false;
        } else {
            this.listView.smoothScrollToPosition(0);
            return true;
        }
    }

    public final void onEventMainThread(GeopopularRegionSelectFilter geopopularRegionSelectFilter) {
        Intrinsics.m26847b(geopopularRegionSelectFilter, "select");
        EventBus.getDefault().removeStickyEvent((Object) geopopularRegionSelectFilter);
        m42518a(geopopularRegionSelectFilter);
        AppAnalytics.m21852a((BaseEvent) mo7203N());
        geopopularRegionSelectFilter = getAnalyticsScreenviewEvent();
        if (geopopularRegionSelectFilter != null) {
            geopopularRegionSelectFilter.m21931b();
        }
    }

    public final void m42530a(int i, String[] strArr, int[] iArr) {
        Intrinsics.m26847b(strArr, "permissions");
        Intrinsics.m26847b(iArr, "grantResults");
        if (i == 19) {
            i = ArraysKt___ArraysKt.m36092b(iArr);
            if (i != 0) {
                if (i.intValue() == 0) {
                    i = this.f40745R;
                    if (i != 0) {
                        i.a();
                    }
                    return;
                }
            }
            i = this.f40745R;
            if (i != 0) {
                i.b();
            }
            return;
        }
        super.a(i, strArr, iArr);
    }

    @RequiresApi(23)
    public final void m42532a(LocationPermissionRequestListener locationPermissionRequestListener) {
        Intrinsics.m26847b(locationPermissionRequestListener, "listenerPermission");
        this.f40745R = locationPermissionRequestListener;
        a(new String[]{"android.permission.ACCESS_COARSE_LOCATION"}, 19);
    }

    public final void mo7728a(ScreenViewPayload screenViewPayload) {
        Intrinsics.m26847b(screenViewPayload, "payload");
        screenViewPayload.geo_filter = this.geopopularRegionQueryParameterValue;
    }

    public final void mo7729a(ScreenviewEventBuilder screenviewEventBuilder) {
        if (screenviewEventBuilder != null) {
            String str = this.geopopularRegionQueryParameterValue;
            Intrinsics.m26847b(str, "geoFilter");
            if ((((CharSequence) str).length() == 0 ? 1 : null) != null) {
                str = "GLOBAL";
            }
            screenviewEventBuilder.listingGeoFilter = str;
        }
    }

    private final void m42518a(GeopopularRegionSelectFilter geopopularRegionSelectFilter) {
        this.geopopularRegionQueryParameterValue = geopopularRegionSelectFilter.f20534a;
        ListingFilterBarView listingFilterBarView = this.f40741N;
        if (listingFilterBarView == null) {
            Intrinsics.m26844a("listingFilterBar");
        }
        listingFilterBarView.setGeopopularText(geopopularRegionSelectFilter.f20535b);
        this.f40742O = geopopularRegionSelectFilter;
        this.y = null;
        super.ac();
        super.mo7448y();
    }

    public final void onEventMainThread(ViewModeOptionSelection viewModeOptionSelection) {
        Intrinsics.m26847b(viewModeOptionSelection, "viewModeSelection");
        if ((Intrinsics.m26845a(viewModeOptionSelection.f20997a, (Object) this) ^ 1) == 0) {
            EventBus.getDefault().removeStickyEvent((Object) viewModeOptionSelection);
            ListingFilterBarView listingFilterBarView = this.f40741N;
            if (listingFilterBarView == null) {
                Intrinsics.m26844a("listingFilterBar");
            }
            listingFilterBarView.setViewMode(viewModeOptionSelection.f20998b);
            m39246a(viewModeOptionSelection.f20998b);
            ab();
            this.w.e();
            m41008e(Intrinsics.m26845a(viewModeOptionSelection.f20998b, ListingViewMode.f20613b));
        }
    }

    public static final /* synthetic */ GeopopularRegionSelectFilter m42516a(LegacyPopularListingScreen legacyPopularListingScreen, String str) {
        UserComponent k = FrontpageApplication.m28875k();
        Object blockingGet = k.mo4631s().m22480a().map(new LegacyPopularListingScreen$storeGeopopularPreference$1(legacyPopularListingScreen, str)).flatMap((Function) new LegacyPopularListingScreen$storeGeopopularPreference$2(k)).blockingGet();
        Intrinsics.m26843a(blockingGet, "userComponent\n          …           .blockingGet()");
        return (GeopopularRegionSelectFilter) blockingGet;
    }

    public static final /* synthetic */ String m42517a(List list, String str) {
        while (true) {
            for (Region region : r3) {
                String component2 = region.component2();
                List component3 = region.component3();
                if (Intrinsics.m26845a(region.component4(), (Object) str)) {
                    return component2;
                }
                if (!component3.isEmpty()) {
                    list = component3;
                }
            }
            return Region.DEFAULT.getName();
        }
    }
}
