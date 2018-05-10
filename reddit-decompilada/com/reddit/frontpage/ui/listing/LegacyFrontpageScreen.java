package com.reddit.frontpage.ui.listing;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import com.reddit.datalibrary.frontpage.data.feature.legacy.local.LegacyDatabaseSubredditDataSourceLegacy;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.data.provider.LinkListingProvider;
import com.reddit.datalibrary.frontpage.data.provider.ProviderManager;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listing;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.domain.usecase.ListingSortUseCase;
import com.reddit.frontpage.domain.usecase.ListingSortUseCase.LegacyListingSort;
import com.reddit.frontpage.domain.usecase.ListingSortUseCase.ListingSortParams;
import com.reddit.frontpage.presentation.listing.model.ListingViewMode;
import com.reddit.frontpage.presentation.viewmode.ViewModeOptionSelection;
import com.reddit.frontpage.ui.home.HomeTab;
import com.reddit.frontpage.ui.listing.DiscoveryUnitManager.DiscoveryUnitListingView;
import com.reddit.frontpage.util.ListUtil;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import com.reddit.frontpage.widgets.ListingFilterBarView;
import de.greenrobot.event.EventBus;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 o2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001oB\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0014J\b\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020'2\u0006\u0010-\u001a\u00020.H\u0014J\b\u0010/\u001a\u00020'H\u0002J\n\u00100\u001a\u0004\u0018\u00010#H\u0014J\n\u00101\u001a\u0004\u0018\u00010#H\u0016J\n\u00102\u001a\u0004\u0018\u00010#H\u0016J\b\u00103\u001a\u00020\u001bH\u0016J\b\u00104\u001a\u00020\u001bH\u0016J\n\u00105\u001a\u0004\u0018\u00010#H\u0016J\n\u00106\u001a\u0004\u0018\u00010#H\u0014J\n\u00107\u001a\u0004\u0018\u00010#H\u0014J\b\u00108\u001a\u00020\u0010H\u0014J\b\u00109\u001a\u00020\u0010H\u0014J\b\u0010:\u001a\u00020'H\u0014J\u0010\u0010;\u001a\u00020'2\u0006\u0010<\u001a\u00020\u001bH\u0016J\b\u0010=\u001a\u00020'H\u0016J\b\u0010>\u001a\u00020'H\u0016J\u0010\u0010?\u001a\u00020'2\u0006\u0010@\u001a\u00020AH\u0016J\u0018\u0010B\u001a\u00020'2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u001bH\u0016J\u0010\u0010F\u001a\u00020'2\u0006\u0010G\u001a\u00020HH\u0014J\u0018\u0010I\u001a\u00020H2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\u0006H\u0016J\b\u0010M\u001a\u00020'H\u0016J\u0010\u0010N\u001a\u00020'2\u0006\u0010G\u001a\u00020HH\u0016J\u0010\u0010O\u001a\u00020'2\u0006\u0010G\u001a\u00020HH\u0014J\u0010\u0010P\u001a\u00020'2\u0006\u0010Q\u001a\u00020HH\u0014J\u000e\u0010R\u001a\u00020'2\u0006\u0010S\u001a\u00020TJ\u0010\u0010U\u001a\u00020'2\u0006\u0010V\u001a\u00020HH\u0002J\b\u0010W\u001a\u00020'H\u0014J\u0010\u0010X\u001a\u00020'2\u0006\u0010Y\u001a\u00020ZH\u0014J\u0018\u0010[\u001a\u00020'2\u0006\u0010G\u001a\u00020H2\u0006\u0010\\\u001a\u00020]H\u0014J\u0018\u0010^\u001a\u00020'2\u0006\u0010G\u001a\u00020H2\u0006\u0010_\u001a\u00020]H\u0014J\u001c\u0010`\u001a\u00020'2\b\b\u0001\u0010a\u001a\u00020\u001b2\b\b\u0001\u0010b\u001a\u00020\u001bH\u0014J\u001e\u0010c\u001a\n\u0012\u0004\u0012\u00020e\u0018\u00010d2\f\u0010f\u001a\b\u0012\u0004\u0012\u00020e0dH\u0015J\b\u0010g\u001a\u00020'H\u0014J\b\u0010h\u001a\u00020\u0010H\u0016J\u0010\u0010i\u001a\u00020'2\u0006\u0010j\u001a\u00020HH\u0002J\u000e\u0010k\u001a\u00020'2\u0006\u0010l\u001a\u00020\u001fJ\b\u0010m\u001a\u00020\u0010H\u0014J\u0014\u0010n\u001a\u00020\u001b*\n\u0012\u0004\u0012\u00020e\u0018\u00010dH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00158BX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\u00020#8VX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006p"}, d2 = {"Lcom/reddit/frontpage/ui/listing/LegacyFrontpageScreen;", "Lcom/reddit/frontpage/ui/listing/AdsListingScreen;", "Lcom/reddit/frontpage/ui/home/HomeTab;", "Lcom/reddit/frontpage/ui/listing/DiscoveryUnitManager$DiscoveryUnitListingView;", "()V", "actionContainer", "Landroid/view/ViewGroup;", "discoveryUnitListingDelegate", "Lcom/reddit/frontpage/ui/listing/DiscoveryUnitManager;", "getDiscoveryUnitListingDelegate", "()Lcom/reddit/frontpage/ui/listing/DiscoveryUnitManager;", "discoveryUnitListingDelegate$delegate", "Lkotlin/Lazy;", "handler", "Landroid/os/Handler;", "initialized", "", "isFrontpageEmpty", "isViewAttached", "()Z", "listingSortUseCase", "Lcom/reddit/frontpage/domain/usecase/ListingSortUseCase;", "getListingSortUseCase", "()Lcom/reddit/frontpage/domain/usecase/ListingSortUseCase;", "newUserContainer", "notifyOn", "numListItems", "", "getNumListItems", "()I", "onExploreClickListener", "Landroid/view/View$OnClickListener;", "sortBar", "Lcom/reddit/frontpage/widgets/ListingFilterBarView;", "surfaceName", "", "getSurfaceName", "()Ljava/lang/String;", "configureActionBar", "", "actionBar", "Landroid/support/v7/app/ActionBar;", "createListingProvider", "Lcom/reddit/datalibrary/frontpage/data/provider/LinkListingProvider;", "customizeDecorationStrategy", "strategy", "Lcom/reddit/frontpage/ui/listing/DecorationInclusionStrategy;", "fetchDiscoveryUnits", "getAdUnitName", "getAnalyticsPageType", "getAnalyticsScreenName", "getIndexOfLastDiscoveryUnit", "getLayoutId", "getListingName", "getSourcePage", "getViewModePreferenceKey", "hasNavigationDrawer", "isRefreshPillActive", "load", "notifyDiscoveryUnitInsertedAtPosition", "position", "notifyOffScreen", "notifyOnScreen", "onActivityResumed", "activity", "Landroid/app/Activity;", "onAppBarOffsetChanged", "appBarLayout", "Landroid/support/design/widget/AppBarLayout;", "verticalOffset", "onAttach", "view", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "onDestroy", "onDestroyView", "onDetach", "onEmptyInflate", "inflated", "onEventMainThread", "viewModeSelection", "Lcom/reddit/frontpage/presentation/viewmode/ViewModeOptionSelection;", "onExploreClicked", "exploreButton", "onListingLoad", "onPreInflateEmpty", "emptyContainer", "Landroid/view/ViewStub;", "onRestoreViewState", "savedViewState", "Landroid/os/Bundle;", "onSaveViewState", "outState", "onSortChanged", "sortType", "sortTimeFrame", "processListing", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listing;", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "listing", "refresh", "resetScreen", "resizeEmptyView", "empty", "setOnExploreClickListener", "listener", "showBestSortOption", "indexOfLastDiscoveryUnit", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LegacyFrontpageScreen.kt */
public final class LegacyFrontpageScreen extends AdsListingScreen implements HomeTab, DiscoveryUnitListingView {
    static final /* synthetic */ KProperty[] f40603M = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(LegacyFrontpageScreen.class), "discoveryUnitListingDelegate", "getDiscoveryUnitListingDelegate()Lcom/reddit/frontpage/ui/listing/DiscoveryUnitManager;"))};
    public static final Companion f40604O = new Companion();
    public OnClickListener f40605N;
    private ListingFilterBarView f40606P;
    private ViewGroup f40607Q;
    private ViewGroup f40608R;
    private boolean f40609S;
    private boolean f40610T;
    private boolean f40611U;
    private final Handler f40612V = new Handler();
    private final Lazy f40613W = LazyKt.m26777a(new LegacyFrontpageScreen$discoveryUnitListingDelegate$2(this));

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/reddit/frontpage/ui/listing/LegacyFrontpageScreen$Companion;", "", "()V", "ANALYTICS_PAGE_TYPE", "", "ANALYTICS_SCREEN_NAME", "LISTING_NAME", "SOURCE_PAGE", "SURFACE_NAME", "newInstance", "Lcom/reddit/frontpage/ui/listing/LegacyFrontpageScreen;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: LegacyFrontpageScreen.kt */
    public static final class Companion {
        private Companion() {
        }

        public static LegacyFrontpageScreen m23423a() {
            return new LegacyFrontpageScreen();
        }
    }

    private final DiscoveryUnitManager ak() {
        return (DiscoveryUnitManager) this.f40613W.mo5678b();
    }

    public static final LegacyFrontpageScreen m42225w() {
        return Companion.m23423a();
    }

    public final String mo7451T() {
        return "frontpage";
    }

    protected final String mo7453V() {
        return "front_page";
    }

    protected final boolean mo7692W() {
        return true;
    }

    protected final boolean ae() {
        return true;
    }

    protected final boolean af_() {
        return true;
    }

    protected final String ah() {
        return "listingViewMode.frontpage";
    }

    public final String mo4800c() {
        return "front_page";
    }

    public final Boolean mo4802e() {
        return null;
    }

    public final String getAnalyticsPageType() {
        return "home";
    }

    public final String getAnalyticsScreenName() {
        return "home";
    }

    public final int mo7141s() {
        return C1761R.layout.screen_frontpage;
    }

    protected final String mo7447x() {
        return "frontpage";
    }

    private static ListingSortUseCase m42219S() {
        return new ListingSortUseCase(FrontpageApplication.m28875k().mo4613a());
    }

    protected final void mo7457a(View view, Bundle bundle) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(bundle, "outState");
        super.mo7457a(view, bundle);
        ak().m23418a(bundle);
    }

    protected final void mo7700b(View view, Bundle bundle) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(bundle, "savedViewState");
        super.mo7700b(view, bundle);
        ak().m23422b(bundle);
    }

    public final View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.m26847b(layoutInflater, "inflater");
        Intrinsics.m26847b(viewGroup, "container");
        super.mo7139a(layoutInflater, viewGroup);
        View inflate = layoutInflater.inflate(C1761R.layout.widget_sort_bar, viewGroup, false);
        Intrinsics.m26843a((Object) inflate, "view");
        viewGroup = inflate.findViewById(C1761R.id.listing_filter_bar);
        if (viewGroup == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.widgets.ListingFilterBarView");
        }
        ListingFilterBarView listingFilterBarView = (ListingFilterBarView) viewGroup;
        Object obj = this.E;
        Intrinsics.m26843a(obj, "linkProvider");
        int b = obj.b();
        Object obj2 = this.E;
        Intrinsics.m26843a(obj2, "linkProvider");
        listingFilterBarView.m24179a(b, obj2.c());
        listingFilterBarView.setOnSortClickListener(new LegacyFrontpageScreen$onCreateView$$inlined$apply$lambda$1(this));
        obj = this.H;
        Intrinsics.m26843a(obj, "viewMode");
        listingFilterBarView.setViewMode(obj);
        listingFilterBarView.setOnViewModeClickListener(new LegacyFrontpageScreen$onCreateView$$inlined$apply$lambda$2(this));
        this.f40606P = listingFilterBarView;
        this.w.m35092a(inflate);
        Object obj3 = this.K;
        Intrinsics.m26843a(obj3, "rootView");
        return obj3;
    }

    protected final void mo6992b(View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6992b(view);
        if (this.f40610T != null) {
            ap();
        }
        ak().m23421b();
        if (this.y != null && this.y.size() == null) {
            mo7448y();
        }
    }

    public final void mo7209b(Activity activity) {
        Intrinsics.m26847b(activity, "activity");
        super.mo7209b(activity);
        this.f40612V.postDelayed(new LegacyFrontpageScreen$onActivityResumed$1(this), 500);
    }

    protected final void mo6993c(View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6993c(view);
        this.f40609S = null;
    }

    public final void mo6987a(View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6987a(view);
        this.f40606P = null;
        this.f40607Q = null;
        this.f40608R = null;
        this.f40605N = null;
    }

    public final void mo7191l() {
        super.mo7191l();
        ak().f21278a.m32077c();
    }

    public final void aq() {
        super.aq();
        Object obj = this.refreshPill;
        Intrinsics.m26843a(obj, "refreshPill");
        ViewsKt.m24105b((View) obj);
    }

    public final void ap() {
        if (v_()) {
            super.ap();
            this.f40610T = false;
            if (!this.f40609S) {
                this.f40609S = true;
                mo7693Z();
            }
            if (FrontpageSettings.a().i("front_page")) {
                this.refreshPill.m24195a();
            }
            return;
        }
        this.f40610T = true;
    }

    protected final void mo7693Z() {
        if (this.f40609S) {
            super.mo7693Z();
        }
    }

    protected final void aa() {
        FrontpageSettings.a().j("front_page");
        Object obj = this.refreshPill;
        Intrinsics.m26843a(obj, "refreshPill");
        ViewsKt.m24109d((View) obj);
    }

    protected final void mo7695a(ViewStub viewStub) {
        Intrinsics.m26847b(viewStub, "emptyContainer");
        super.mo7695a(viewStub);
        LegacyDatabaseSubredditDataSourceLegacy legacyDatabaseSubredditDataSourceLegacy = new LegacyDatabaseSubredditDataSourceLegacy();
        aq_();
        this.f40611U = LegacyDatabaseSubredditDataSourceLegacy.a().isEmpty();
        if (this.f40611U) {
            Object obj = this.contentContainer;
            Intrinsics.m26843a(obj, "contentContainer");
            obj.setVisibility(8);
            viewStub.setLayoutResource(C1761R.layout.frontpage_empty);
        }
    }

    protected final void mo7701f(View view) {
        Intrinsics.m26847b(view, "inflated");
        super.mo7701f(view);
        if (this.f40611U) {
            View findViewById = view.findViewById(C1761R.id.new_user_container);
            if (findViewById == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
            }
            this.f40608R = (ViewGroup) findViewById;
            Object obj = this.K;
            Intrinsics.m26843a(obj, "rootView");
            if (obj.getHeight() == 0) {
                obj = this.K;
                Intrinsics.m26843a(obj, "rootView");
                obj.getViewTreeObserver().addOnGlobalLayoutListener(new LegacyFrontpageScreen$onEmptyInflate$1(this, view));
                return;
            }
            m42224i(view);
        }
    }

    public final void mo7215a(AppBarLayout appBarLayout, int i) {
        Intrinsics.m26847b(appBarLayout, "appBarLayout");
        if (this.f40608R != null && this.f40607Q != null) {
            appBarLayout = this.f40607Q;
            if (appBarLayout == null) {
                Intrinsics.m26842a();
            }
            i = (float) ((-i) / 2);
            appBarLayout.setTranslationY(i);
            appBarLayout = this.f40608R;
            if (appBarLayout == null) {
                Intrinsics.m26842a();
            }
            appBarLayout.setTranslationY(i);
        }
    }

    protected final void mo7185a(ActionBar actionBar) {
        Intrinsics.m26847b(actionBar, "actionBar");
        actionBar.c(false);
    }

    public final LinkListingProvider mo7452U() {
        LegacyListingSort legacyListingSort = (LegacyListingSort) m42219S().m22524b(new ListingSortParams("frontpage", new LegacyListingSort(16, -1))).blockingGet();
        int i = legacyListingSort.f20280a;
        int i2 = legacyListingSort.f20281b;
        ProviderManager providerManager = ProviderManager.b;
        Object Y_ = Y_();
        Intrinsics.m26843a(Y_, "instanceId");
        return ProviderManager.a(Y_, i, i2);
    }

    protected final void mo7696a(DecorationInclusionStrategy decorationInclusionStrategy) {
        Intrinsics.m26847b(decorationInclusionStrategy, "strategy");
        decorationInclusionStrategy.m23389a(LegacyFrontpageScreen$customizeDecorationStrategy$1.f37262a);
    }

    protected final void mo7694a(int i, int i2) {
        super.mo7694a(i, i2);
        CompositeDisposable compositeDisposable = this.G;
        Object subscribe = m42219S().m22523a(new ListingSortParams("frontpage", new LegacyListingSort(i, i2))).observeOn(AndroidSchedulers.m26509a()).subscribe();
        Intrinsics.m26843a(subscribe, "listingSortUseCase\n     …d())\n        .subscribe()");
        DisposableKt.m26766a(compositeDisposable, subscribe);
        i = this.f40606P;
        if (i == 0) {
            Intrinsics.m26842a();
        }
        Object obj = this.E;
        Intrinsics.m26843a(obj, "linkProvider");
        i2 = obj.b();
        Object obj2 = this.E;
        Intrinsics.m26843a(obj2, "linkProvider");
        i.m24179a(i2, obj2.c());
        ak().m23417a();
    }

    public final boolean mo7200K() {
        if (this.x != null) {
            if (this.listView != null) {
                Object obj = this.x;
                Intrinsics.m26843a(obj, "layoutManager");
                if (!ListUtil.m23810a(obj)) {
                    this.listView.smoothScrollToPosition(0);
                }
                return true;
            }
        }
        return false;
    }

    private final void m42224i(View view) {
        ViewGroup viewGroup = this.f40608R;
        if (viewGroup == null) {
            Intrinsics.m26842a();
        }
        LayoutParams layoutParams = viewGroup.getLayoutParams();
        Object T_ = T_();
        if (T_ == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26843a(T_, "view!!");
        layoutParams.height = T_.getHeight();
        viewGroup = this.f40608R;
        if (viewGroup == null) {
            Intrinsics.m26842a();
        }
        viewGroup.requestLayout();
        View findViewById = view.findViewById(C1761R.id.action_container);
        if (findViewById == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
        }
        this.f40607Q = (ViewGroup) findViewById;
        LayoutInflater.from(view.getContext()).inflate(C1761R.layout.explore_buttons, this.f40607Q);
        view.findViewById(C1761R.id.popular_button).setOnClickListener(new LegacyFrontpageScreen$resizeEmptyView$1(this));
    }

    public final int mo4796a() {
        Listing listing = this.y;
        if (listing != null) {
            List entities = listing.getEntities();
            if (entities != null) {
                return entities.size();
            }
        }
        return 0;
    }

    public final int mo4801d() {
        return m42222b(this.y);
    }

    private static int m42222b(Listing<Listable> listing) {
        if (listing != null) {
            listing = listing.getEntities();
            if (listing != null) {
                listing = listing.listIterator(listing.size());
                while (listing.hasPrevious()) {
                    Listable listable = (Listable) listing.previous();
                    com.reddit.datalibrary.frontpage.requests.models.v2.Listable.Companion companion = Listable.Companion;
                    if (com.reddit.datalibrary.frontpage.requests.models.v2.Listable.Companion.m21639a().contains(Integer.valueOf(listable.getListableType()))) {
                        return listing.nextIndex();
                    }
                }
                return -1;
            }
        }
        return -1;
    }

    public final boolean mo4799b() {
        return v_();
    }

    public final void mo4797a(int i) {
        this.E.b(i);
    }

    protected final void mo7448y() {
        super.mo7448y();
        ak().m23417a();
    }

    @SuppressLint({"CheckResult"})
    protected final Listing<Listable> mo7456a(Listing<Listable> listing) {
        Intrinsics.m26847b(listing, "listing");
        ak().m23421b();
        if (!this.f40609S) {
            return null;
        }
        Listing a = super.mo7456a((Listing) listing);
        DiscoveryUnitManager ak = ak();
        Intrinsics.m26843a((Object) a, "list");
        ak().m23419a(a, ak.m23415a(a.getEntities().size(), m42222b(a)));
        return a;
    }

    public final void onEventMainThread(ViewModeOptionSelection viewModeOptionSelection) {
        Intrinsics.m26847b(viewModeOptionSelection, "viewModeSelection");
        if (viewModeOptionSelection.f20997a == this) {
            EventBus.getDefault().removeStickyEvent((Object) viewModeOptionSelection);
            ListingFilterBarView listingFilterBarView = this.f40606P;
            if (listingFilterBarView == null) {
                Intrinsics.m26842a();
            }
            listingFilterBarView.setViewMode(viewModeOptionSelection.f20998b);
            m39246a(viewModeOptionSelection.f20998b);
            ab();
            this.w.e();
            m41008e(viewModeOptionSelection.f20998b == ListingViewMode.f20613b ? true : null);
        }
    }

    public static final /* synthetic */ void m42223b(LegacyFrontpageScreen legacyFrontpageScreen, View view) {
        if (legacyFrontpageScreen.f40605N != null) {
            legacyFrontpageScreen = legacyFrontpageScreen.f40605N;
            if (legacyFrontpageScreen == null) {
                Intrinsics.m26842a();
            }
            legacyFrontpageScreen.onClick(view);
        }
    }
}
