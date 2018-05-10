package com.reddit.frontpage.presentation.listing;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import com.evernote.android.state.State;
import com.reddit.datalibrary.frontpage.data.feature.common.SortSelection;
import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.data.feature.common.SortType;
import com.reddit.datalibrary.frontpage.data.provider.LocationPermissionRequestListener;
import com.reddit.datalibrary.frontpage.data.provider.LocationPermissionRequestProvider;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.di.component.DaggerPopularComponent;
import com.reddit.frontpage.di.component.PopularComponent.Builder;
import com.reddit.frontpage.di.component.UserComponent;
import com.reddit.frontpage.domain.model.Region;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.presentation.common.ui.view.listoptions.sort.PostSortOptionsDialog;
import com.reddit.frontpage.presentation.geopopular.GeopopularRegionSelectFilter;
import com.reddit.frontpage.presentation.geopopular.option.GeopopularOptionsScreen;
import com.reddit.frontpage.presentation.listing.common.LinkListingScreen;
import com.reddit.frontpage.presentation.listing.common.ListingViewActions;
import com.reddit.frontpage.presentation.listing.common.LoadMoreListingAdapter;
import com.reddit.frontpage.presentation.listing.common.LoadMoreOnScrollListener;
import com.reddit.frontpage.presentation.listing.common.SortableLoadMoreListingAdapter.DefaultImpls;
import com.reddit.frontpage.presentation.listing.common.SubscribeListingAdapter;
import com.reddit.frontpage.presentation.listing.common.ViewDiffResult;
import com.reddit.frontpage.presentation.listing.model.FooterState;
import com.reddit.frontpage.presentation.listing.model.ListingViewMode;
import com.reddit.frontpage.presentation.listing.model.LoadingFooterPresentationModel;
import com.reddit.frontpage.presentation.listing.model.SortHeaderPresentationModel;
import com.reddit.frontpage.presentation.listing.popular.PopularListingContract.Parameters;
import com.reddit.frontpage.presentation.listing.popular.PopularListingContract.View;
import com.reddit.frontpage.presentation.listing.popular.PopularListingPresenter;
import com.reddit.frontpage.presentation.viewmode.ViewModeOptionSelection;
import com.reddit.frontpage.presentation.viewmode.ViewModeOptionsScreen;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.home.HomeTab;
import com.reddit.frontpage.ui.listing.DecorationInclusionStrategy;
import com.reddit.frontpage.ui.listing.adapter.CardLinkAdapter;
import com.reddit.frontpage.ui.listing.newcard.VisibilityDependent;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import de.greenrobot.event.EventBus;
import io.reactivex.Observer;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u0001B\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0014J\b\u0010,\u001a\u00020\u000fH\u0016J\b\u0010-\u001a\u00020\u000fH\u0016J\b\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u000201H\u0016J\n\u00102\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u00103\u001a\u00020/H\u0014J\b\u00104\u001a\u000205H\u0014J\b\u00106\u001a\u00020)H\u0016J\b\u00107\u001a\u00020)H\u0016J\b\u00108\u001a\u00020)H\u0016J\u0010\u00109\u001a\u00020)2\u0006\u0010:\u001a\u00020;H\u0016J\u0010\u0010<\u001a\u00020)2\u0006\u0010=\u001a\u000201H\u0016J\u0018\u0010>\u001a\u00020)2\u0006\u0010?\u001a\u0002012\u0006\u0010@\u001a\u000201H\u0016J\u0018\u0010A\u001a\u00020)2\u0006\u0010?\u001a\u0002012\u0006\u0010@\u001a\u000201H\u0016J\b\u0010B\u001a\u00020)H\u0016J\b\u0010C\u001a\u00020)H\u0016J\b\u0010D\u001a\u00020)H\u0016J\u0010\u0010E\u001a\u00020)2\u0006\u0010F\u001a\u00020GH\u0014J\u001a\u0010H\u001a\u00020)2\b\u0010I\u001a\u0004\u0018\u00010J2\u0006\u0010K\u001a\u000201H\u0016J\u0010\u0010L\u001a\u00020)2\u0006\u0010M\u001a\u00020NH\u0014J\u0018\u0010O\u001a\u00020)2\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020SH\u0016J\u0018\u0010T\u001a\u00020N2\u0006\u0010R\u001a\u00020U2\u0006\u0010V\u001a\u00020WH\u0016J\b\u0010X\u001a\u00020)H\u0016J\u0010\u0010Y\u001a\u00020)2\u0006\u0010M\u001a\u00020NH\u0014J\u0010\u0010Z\u001a\u00020)2\u0006\u0010[\u001a\u00020NH\u0014J\u000e\u0010\\\u001a\u00020)2\u0006\u0010]\u001a\u00020^J\u000e\u0010\\\u001a\u00020)2\u0006\u0010_\u001a\u00020`J\u0010\u0010a\u001a\u0002052\u0006\u0010b\u001a\u00020cH\u0016J-\u0010d\u001a\u00020)2\u0006\u0010e\u001a\u0002012\u000e\u0010f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0g2\u0006\u0010h\u001a\u00020iH\u0016¢\u0006\u0002\u0010jJ\u0010\u0010k\u001a\u00020)2\u0006\u0010l\u001a\u00020\u001fH\u0016J\b\u0010m\u001a\u000205H\u0016J\u0016\u0010n\u001a\u00020)2\f\u0010o\u001a\b\u0012\u0004\u0012\u00020q0pH\u0016J\u0010\u0010r\u001a\u00020)2\u0006\u0010s\u001a\u00020/H\u0016J\u001a\u0010t\u001a\u00020)2\u0006\u0010u\u001a\u00020\t2\b\u0010v\u001a\u0004\u0018\u00010wH\u0016J\b\u0010x\u001a\u00020)H\u0016J\b\u0010y\u001a\u00020)H\u0016J\b\u0010z\u001a\u00020)H\u0002J\b\u0010{\u001a\u00020)H\u0016J\b\u0010|\u001a\u00020)H\u0016J\b\u0010}\u001a\u00020)H\u0016J\b\u0010~\u001a\u00020)H\u0016J\b\u0010\u001a\u00020)H\u0016J1\u0010\u0001\u001a\u00020)2&\u0010\u0001\u001a!\u0012\u0016\u0012\u001405¢\u0006\u000f\b\u0001\u0012\n\b\u0001\u0012\u0005\b\b(\u0001\u0012\u0004\u0012\u00020)0\u0001H\u0016J\u001d\u0010\u0001\u001a\u00020)2\u0007\u0010\u0001\u001a\u00020\t2\t\u0010\u0001\u001a\u0004\u0018\u00010wH\u0002J\u0012\u0010\u0001\u001a\u00020)2\u0007\u0010\u0001\u001a\u00020\u000fH\u0016J\t\u0010\u0001\u001a\u00020)H\u0016J\t\u0010\u0001\u001a\u00020)H\u0002R'\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00078TX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u000fXD¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u00020\b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0'0&X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/PopularListingScreen;", "Lcom/reddit/frontpage/presentation/listing/common/LinkListingScreen;", "Lcom/reddit/frontpage/presentation/listing/popular/PopularListingContract$View;", "Lcom/reddit/frontpage/ui/home/HomeTab;", "Lcom/reddit/datalibrary/frontpage/data/provider/LocationPermissionRequestProvider;", "()V", "adapter", "Lcom/reddit/frontpage/presentation/listing/common/SubscribeListingAdapter;", "Lcom/reddit/frontpage/presentation/listing/popular/PopularListingPresenter;", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "getAdapter", "()Lcom/reddit/frontpage/presentation/listing/common/SubscribeListingAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "geopopularRegionName", "", "getGeopopularRegionName", "()Ljava/lang/String;", "setGeopopularRegionName", "(Ljava/lang/String;)V", "handler", "Landroid/os/Handler;", "listingName", "getListingName", "listingViewActions", "Lcom/reddit/frontpage/presentation/listing/common/ListingViewActions;", "getListingViewActions", "()Lcom/reddit/frontpage/presentation/listing/common/ListingViewActions;", "setListingViewActions", "(Lcom/reddit/frontpage/presentation/listing/common/ListingViewActions;)V", "locationPermissionListener", "Lcom/reddit/datalibrary/frontpage/data/provider/LocationPermissionRequestListener;", "presenter", "getPresenter", "()Lcom/reddit/frontpage/presentation/listing/popular/PopularListingPresenter;", "setPresenter", "(Lcom/reddit/frontpage/presentation/listing/popular/PopularListingPresenter;)V", "sortObservable", "Lio/reactivex/subjects/PublishSubject;", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortSelection;", "customizeDecorationStrategy", "", "strategy", "Lcom/reddit/frontpage/ui/listing/DecorationInclusionStrategy;", "getAnalyticsPageType", "getAnalyticsScreenName", "getCurrentViewMode", "Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;", "getLayoutId", "", "getScreenListingName", "getViewModePreference", "hasNavigationDrawer", "", "hideLoadMoreView", "hideRefreshPill", "hideRefreshing", "notifyDiffResult", "diffResult", "Lcom/reddit/frontpage/presentation/listing/common/ViewDiffResult;", "notifyLinkChanged", "position", "notifyLinksInserted", "startPosition", "numItems", "notifyLinksRemoved", "notifyListingChanged", "notifyLoadError", "notifyLoadMoreNetworkError", "onActivityResumed", "activity", "Landroid/app/Activity;", "onAppBarOffsetChanged", "appBarLayout", "Landroid/support/design/widget/AppBarLayout;", "verticalOffset", "onAttach", "view", "Landroid/view/View;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateView", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onErrorInflated", "inflated", "onEventMainThread", "select", "Lcom/reddit/frontpage/presentation/geopopular/GeopopularRegionSelectFilter;", "viewModeSelection", "Lcom/reddit/frontpage/presentation/viewmode/ViewModeOptionSelection;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "requestLocationPermission", "listenerPermission", "resetScreen", "setListing", "posts", "", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "setListingViewMode", "mode", "setSorting", "sort", "sortTimeFrame", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "showContentListView", "showEmptyListView", "showGeopopularDialog", "showLoadMoreView", "showLoading", "showNetworkErrorMessage", "showRefreshPill", "showRefreshing", "showReportView", "wasReported", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "showSortDialog", "initialSort", "timeFrame", "showSubscribedMessage", "subredditName", "showSuspendedReportView", "showViewModeOptions", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: PopularListingScreen.kt */
public final class PopularListingScreen extends LinkListingScreen implements LocationPermissionRequestProvider, View, HomeTab {
    static final /* synthetic */ KProperty[] f40564v = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(PopularListingScreen.class), "adapter", "getAdapter()Lcom/reddit/frontpage/presentation/listing/common/SubscribeListingAdapter;"))};
    public static final Companion f40565y = new Companion();
    private final Handler f40566M = new Handler();
    private final PublishSubject<SortSelection<SortType>> f40567N;
    private final String f40568O;
    private final Lazy f40569P;
    @State
    String geopopularRegionName = Region.DEFAULT.getName();
    @Inject
    public PopularListingPresenter f40570w;
    @Inject
    public ListingViewActions f40571x;
    private LocationPermissionRequestListener f40572z;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/PopularListingScreen$Companion;", "", "()V", "ANALYTICS_PAGE_TYPE", "", "ANALYTICS_SCREEN_NAME", "LISTING_NAME", "PREF_POPULAR_LISTING_VIEW_MODE", "SOURCE_PAGE", "newInstance", "Lcom/reddit/frontpage/presentation/listing/PopularListingScreen;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: PopularListingScreen.kt */
    public static final class Companion {
        private Companion() {
        }

        public static PopularListingScreen m22868a() {
            return new PopularListingScreen();
        }
    }

    public static final PopularListingScreen m42012Y() {
        return Companion.m22868a();
    }

    private SubscribeListingAdapter<PopularListingPresenter, SortType> m42013Z() {
        return (SubscribeListingAdapter) this.f40569P.mo5678b();
    }

    public final void mo7215a(AppBarLayout appBarLayout, int i) {
    }

    protected final boolean af_() {
        return true;
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

    public PopularListingScreen() {
        Object create = PublishSubject.create();
        Intrinsics.m26843a(create, "PublishSubject.create()");
        this.f40567N = create;
        this.f40568O = "popular";
        this.f40569P = LazyKt.m26777a(new PopularListingScreen$adapter$2(this));
        Builder a = DaggerPopularComponent.m29239a();
        UserComponent k = FrontpageApplication.m28875k();
        Intrinsics.m26843a((Object) k, "FrontpageApplication.getUserComponent()");
        a.mo4711a(k).mo4713a((View) this).mo4717b(LazyKt.m26777a(new Function0<Activity>() {
            public final /* synthetic */ Object invoke() {
                Activity am_ = this.am_();
                if (am_ == null) {
                    Intrinsics.m26842a();
                }
                return am_;
            }
        })).mo4715a(LazyKt.m26777a(new Function0<Activity>() {
            public final /* synthetic */ Object invoke() {
                Activity am_ = this.am_();
                if (am_ == null) {
                    Intrinsics.m26842a();
                }
                return am_;
            }
        })).mo4714a("popular").mo4712a(new Parameters(this.f40567N)).mo4716a().mo4718a(this);
    }

    public final /* synthetic */ CardLinkAdapter mo7617M() {
        return m42013Z();
    }

    public final PopularListingPresenter mo7641w() {
        PopularListingPresenter popularListingPresenter = this.f40570w;
        if (popularListingPresenter == null) {
            Intrinsics.m26844a("presenter");
        }
        return popularListingPresenter;
    }

    public final android.view.View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.m26847b(layoutInflater, "inflater");
        Intrinsics.m26847b(viewGroup, "container");
        super.mo7139a(layoutInflater, viewGroup);
        layoutInflater = af();
        LinearLayoutManager ag = ag();
        LoadMoreListingAdapter Z = m42013Z();
        PopularListingPresenter popularListingPresenter = this.f40570w;
        if (popularListingPresenter == null) {
            Intrinsics.m26844a("presenter");
        }
        layoutInflater.addOnScrollListener((OnScrollListener) new LoadMoreOnScrollListener(ag, Z, new PopularListingScreen$onCreateView$1(popularListingPresenter)));
        ViewsKt.m24109d(ah());
        ai().setOnRefreshListener((OnRefreshListener) new PopularListingScreen$onCreateView$3(this));
        Object obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        return obj;
    }

    protected final void mo6992b(android.view.View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6992b(view);
        ae().mo4854a(this);
        view = this.f40570w;
        if (view == null) {
            Intrinsics.m26844a("presenter");
        }
        view.attach();
    }

    protected final void mo6993c(android.view.View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6993c(view);
        view = this.f40570w;
        if (view == null) {
            Intrinsics.m26844a("presenter");
        }
        view.detach();
    }

    public final void mo7191l() {
        super.mo7191l();
        PopularListingPresenter popularListingPresenter = this.f40570w;
        if (popularListingPresenter == null) {
            Intrinsics.m26844a("presenter");
        }
        popularListingPresenter.destroy();
    }

    protected final void mo7209b(Activity activity) {
        Intrinsics.m26847b(activity, "activity");
        super.mo7209b(activity);
        activity = T_();
        if (!(activity instanceof VisibilityDependent)) {
            activity = null;
        }
        VisibilityDependent visibilityDependent = (VisibilityDependent) activity;
        if (visibilityDependent != null) {
            this.f40566M.postDelayed(new PopularListingScreen$onActivityResumed$1$1(visibilityDependent), 500);
        }
    }

    public final void m42037a(Menu menu, MenuInflater menuInflater) {
        Intrinsics.m26847b(menu, "menu");
        Intrinsics.m26847b(menuInflater, "inflater");
        super.a(menu, menuInflater);
        menuInflater.inflate(C1761R.menu.menu_link_listing, menu);
    }

    public final boolean mo7201a(MenuItem menuItem) {
        Intrinsics.m26847b(menuItem, "item");
        if (menuItem.getItemId() != C1761R.id.action_search) {
            return super.mo7201a(menuItem);
        }
        m29359a((Screen) Nav.m22603n(null));
        return true;
    }

    protected final ListingViewMode ab() {
        Object blockingGet = ad().m22477b("listingViewMode.popular", ao()).blockingGet();
        Intrinsics.m26843a(blockingGet, "preferenceRepository\n   …ode)\n      .blockingGet()");
        return (ListingViewMode) blockingGet;
    }

    protected final void mo7634a(DecorationInclusionStrategy decorationInclusionStrategy) {
        Intrinsics.m26847b(decorationInclusionStrategy, "strategy");
        decorationInclusionStrategy.m23389a(PopularListingScreen$customizeDecorationStrategy$1.f36525a);
    }

    protected final void mo7639f(android.view.View view) {
        Intrinsics.m26847b(view, "inflated");
        view.setOnClickListener(new PopularListingScreen$inlined$sam$OnClickListener$i$7f478c20(new PopularListingScreen$onErrorInflated$1(this)));
    }

    public final boolean mo7200K() {
        if (T_() == null) {
            return false;
        }
        af().smoothScrollToPosition(0);
        return true;
    }

    public final void mo7330b(List<? extends Listable> list) {
        Intrinsics.m26847b(list, "posts");
        ListingViewActions listingViewActions = this.f40571x;
        if (listingViewActions == null) {
            Intrinsics.m26844a("listingViewActions");
        }
        listingViewActions.mo4866a((List) list, (CardLinkAdapter) m42013Z());
    }

    public final void mo7335x() {
        ListingViewActions listingViewActions = this.f40571x;
        if (listingViewActions == null) {
            Intrinsics.m26844a("listingViewActions");
        }
        listingViewActions.mo4864a((CardLinkAdapter) m42013Z());
    }

    public final void mo7328b(int i) {
        ListingViewActions listingViewActions = this.f40571x;
        if (listingViewActions == null) {
            Intrinsics.m26844a("listingViewActions");
        }
        listingViewActions.mo4860a(i, (CardLinkAdapter) m42013Z());
    }

    public final void mo7323a(int i, int i2) {
        ListingViewActions listingViewActions = this.f40571x;
        if (listingViewActions == null) {
            Intrinsics.m26844a("listingViewActions");
        }
        listingViewActions.mo4859a(i, i2, m42013Z());
    }

    public final void mo7322a(int i) {
        ListingViewActions listingViewActions = this.f40571x;
        if (listingViewActions == null) {
            Intrinsics.m26844a("listingViewActions");
        }
        listingViewActions.mo4867b(i, m42013Z());
    }

    public final void mo7336y() {
        ListingViewActions listingViewActions = this.f40571x;
        if (listingViewActions == null) {
            Intrinsics.m26844a("listingViewActions");
        }
        LinkListingScreen linkListingScreen = this;
        Activity am_ = am_();
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        String string = am_.getString(C1761R.string.error_network_error);
        Intrinsics.m26843a((Object) string, "activity!!.getString(R.string.error_network_error)");
        listingViewActions.mo4863a(linkListingScreen, string);
    }

    public final void mo7324a(ViewDiffResult viewDiffResult) {
        Intrinsics.m26847b(viewDiffResult, "diffResult");
        ListingViewActions listingViewActions = this.f40571x;
        if (listingViewActions == null) {
            Intrinsics.m26844a("listingViewActions");
        }
        listingViewActions.mo4865a((CardLinkAdapter) m42013Z(), viewDiffResult);
    }

    public final void mo7643P() {
        SubscribeListingAdapter Z = m42013Z();
        FooterState footerState = FooterState.ERROR;
        Activity am_ = am_();
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        Z.m37030a(new LoadingFooterPresentationModel(footerState, am_.getString(C1761R.string.error_network_error)));
        m42013Z().d(DefaultImpls.m22942a(m42013Z()));
    }

    public final void mo7644Q() {
        ListingViewActions listingViewActions = this.f40571x;
        if (listingViewActions == null) {
            Intrinsics.m26844a("listingViewActions");
        }
        listingViewActions.mo4861a((LinkListingScreen) this);
    }

    public final void mo7645R() {
        ListingViewActions listingViewActions = this.f40571x;
        if (listingViewActions == null) {
            Intrinsics.m26844a("listingViewActions");
        }
        listingViewActions.mo4862a((LinkListingScreen) this, Integer.valueOf(C1761R.layout.frontpage_empty));
    }

    public final void mo7646S() {
        ListingViewActions listingViewActions = this.f40571x;
        if (listingViewActions == null) {
            Intrinsics.m26844a("listingViewActions");
        }
        listingViewActions.mo4868b(this);
    }

    public final void mo7647T() {
        Activity am_ = am_();
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        mo7204a((CharSequence) am_.getString(C1761R.string.error_network_error));
    }

    public final void mo7654a(String str) {
        Intrinsics.m26847b(str, "subredditName");
        Activity am_ = am_();
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        mo7204a((CharSequence) am_.getString(C1761R.string.fmt_now_subscribed, new Object[]{str}));
    }

    public final void mo7652a(SortType sortType, SortTimeFrame sortTimeFrame) {
        Intrinsics.m26847b(sortType, "sort");
        as();
        SubscribeListingAdapter Z = m42013Z();
        ListingViewMode listingViewMode = this.f40038G;
        if (listingViewMode == null) {
            Intrinsics.m26842a();
        }
        Z.m37031a(new SortHeaderPresentationModel(sortType, sortTimeFrame, listingViewMode, this.geopopularRegionName));
        m42013Z().d(null);
    }

    public final void mo7648U() {
        ListingViewActions listingViewActions = this.f40571x;
        if (listingViewActions == null) {
            Intrinsics.m26844a("listingViewActions");
        }
        listingViewActions.mo4869c(this);
    }

    public final void mo7649V() {
        ListingViewActions listingViewActions = this.f40571x;
        if (listingViewActions == null) {
            Intrinsics.m26844a("listingViewActions");
        }
        listingViewActions.mo4870d(this);
    }

    public final void mo7650W() {
        m42013Z().m37030a(new LoadingFooterPresentationModel(FooterState.LOADING, 2));
        m42013Z().d(DefaultImpls.m22942a(m42013Z()));
    }

    public final void mo7651X() {
        m42013Z().m37030a(new LoadingFooterPresentationModel(FooterState.NONE, 2));
        m42013Z().d(DefaultImpls.m22942a(m42013Z()));
    }

    public final void m42035a(int i, String[] strArr, int[] iArr) {
        Intrinsics.m26847b(strArr, "permissions");
        Intrinsics.m26847b(iArr, "grantResults");
        if (i == 19) {
            i = ArraysKt___ArraysKt.m36092b(iArr);
            if (i != 0) {
                if (i.intValue() == 0) {
                    i = this.f40572z;
                    if (i != 0) {
                        i.a();
                    }
                    return;
                }
            }
            i = this.f40572z;
            if (i != 0) {
                i.b();
            }
            return;
        }
        super.a(i, strArr, iArr);
    }

    public final void m42039a(LocationPermissionRequestListener locationPermissionRequestListener) {
        Intrinsics.m26847b(locationPermissionRequestListener, "listenerPermission");
        this.f40572z = locationPermissionRequestListener;
        a(new String[]{"android.permission.ACCESS_COARSE_LOCATION"}, 19);
    }

    public final void onEventMainThread(GeopopularRegionSelectFilter geopopularRegionSelectFilter) {
        Intrinsics.m26847b(geopopularRegionSelectFilter, "select");
        EventBus.getDefault().removeStickyEvent((Object) geopopularRegionSelectFilter);
    }

    protected final String mo7618O() {
        return this.f40568O;
    }

    public final ListingViewMode H_() {
        ListingViewMode listingViewMode = this.f40038G;
        return listingViewMode == null ? ao() : listingViewMode;
    }

    public final void mo7653a(ListingViewMode listingViewMode) {
        Intrinsics.m26847b(listingViewMode, "mode");
        this.f40038G = listingViewMode;
        listingViewMode = m42013Z();
        SortHeaderPresentationModel sortHeaderPresentationModel = m42013Z().f36617c.f33896a;
        ListingViewMode listingViewMode2 = this.f40038G;
        if (listingViewMode2 == null) {
            Intrinsics.m26842a();
        }
        listingViewMode.m37031a(SortHeaderPresentationModel.m34745a(sortHeaderPresentationModel, listingViewMode2));
        ar();
        m42013Z().e();
    }

    public final void onEventMainThread(ViewModeOptionSelection viewModeOptionSelection) {
        Intrinsics.m26847b(viewModeOptionSelection, "viewModeSelection");
        if ((Intrinsics.m26845a(viewModeOptionSelection.f20997a, (Object) this) ^ 1) == 0) {
            EventBus.getDefault().removeStickyEvent((Object) viewModeOptionSelection);
            PopularListingPresenter popularListingPresenter = this.f40570w;
            if (popularListingPresenter == null) {
                Intrinsics.m26844a("presenter");
            }
            popularListingPresenter.m37169a(viewModeOptionSelection.f20998b);
        }
    }

    public static final /* synthetic */ void m42015a(PopularListingScreen popularListingScreen, SortType sortType, SortTimeFrame sortTimeFrame) {
        Observer observer = popularListingScreen.f40567N;
        Object am_ = popularListingScreen.am_();
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26843a(am_, "activity!!");
        new PostSortOptionsDialog(observer, (Context) am_, false, sortType, sortTimeFrame).m22764a();
    }

    public static final /* synthetic */ void m42018d(PopularListingScreen popularListingScreen) {
        Activity am_ = popularListingScreen.am_();
        if (am_ == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.content.Context");
        }
        Context context = am_;
        ListingViewMode listingViewMode = popularListingScreen.f40038G;
        if (listingViewMode == null) {
            Intrinsics.m26842a();
        }
        ViewModeOptionsScreen viewModeOptionsScreen = new ViewModeOptionsScreen(context, listingViewMode);
        viewModeOptionsScreen.m38982a((BaseScreen) popularListingScreen);
        viewModeOptionsScreen.show();
    }

    public static final /* synthetic */ void m42019e(PopularListingScreen popularListingScreen) {
        Activity am_ = popularListingScreen.am_();
        if (am_ == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.content.Context");
        }
        GeopopularOptionsScreen geopopularOptionsScreen = new GeopopularOptionsScreen(am_);
        geopopularOptionsScreen.m38951a((BaseScreen) popularListingScreen);
        geopopularOptionsScreen.m38949a((LocationPermissionRequestProvider) popularListingScreen);
        geopopularOptionsScreen.show();
    }
}
