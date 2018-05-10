package com.reddit.frontpage.presentation.listing;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import com.reddit.datalibrary.frontpage.data.feature.common.SortSelection;
import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.data.feature.common.SortType;
import com.reddit.datalibrary.frontpage.requests.models.config.discoveryunit.DiscoveryUnit;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.di.component.DaggerFrontpageComponent;
import com.reddit.frontpage.di.component.FrontpageComponent.Builder;
import com.reddit.frontpage.di.component.UserComponent;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.presentation.carousel.model.CarouselCollectionPresentationModel;
import com.reddit.frontpage.presentation.carousel.model.CarouselItemPresentationModel;
import com.reddit.frontpage.presentation.carousel.model.GeneralCarouselCollectionPresentationModel;
import com.reddit.frontpage.presentation.carousel.model.ICarouselItemPresentationModel;
import com.reddit.frontpage.presentation.carousel.model.LinkCarouselCollectionPresentationModel;
import com.reddit.frontpage.presentation.carousel.options.CarouselOptionsScreen;
import com.reddit.frontpage.presentation.common.ui.view.listoptions.sort.PostSortOptionsDialog;
import com.reddit.frontpage.presentation.listing.common.LinkListingScreen;
import com.reddit.frontpage.presentation.listing.common.ListingViewActions;
import com.reddit.frontpage.presentation.listing.common.LoadMoreListingAdapter;
import com.reddit.frontpage.presentation.listing.common.LoadMoreOnScrollListener;
import com.reddit.frontpage.presentation.listing.common.PresentationListingAdapter;
import com.reddit.frontpage.presentation.listing.common.RedditSortableLoadMoreListingAdapter;
import com.reddit.frontpage.presentation.listing.common.SortableLoadMoreListingAdapter;
import com.reddit.frontpage.presentation.listing.common.SortableLoadMoreListingAdapter.DefaultImpls;
import com.reddit.frontpage.presentation.listing.common.ViewDiffResult;
import com.reddit.frontpage.presentation.listing.frontpage.FrontpageListingContract.Parameters;
import com.reddit.frontpage.presentation.listing.frontpage.FrontpageListingContract.View;
import com.reddit.frontpage.presentation.listing.frontpage.FrontpageListingPresenter;
import com.reddit.frontpage.presentation.listing.model.FooterState;
import com.reddit.frontpage.presentation.listing.model.ListingViewMode;
import com.reddit.frontpage.presentation.listing.model.LoadingFooterPresentationModel;
import com.reddit.frontpage.presentation.listing.model.SortHeaderPresentationModel;
import com.reddit.frontpage.presentation.listing.ui.viewholder.LinkViewHolder;
import com.reddit.frontpage.presentation.listing.ui.viewholder.LoadingFooterViewHolder;
import com.reddit.frontpage.presentation.viewmode.ViewModeOptionSelection;
import com.reddit.frontpage.presentation.viewmode.ViewModeOptionsScreen;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.carousel.CarouselViewHolder;
import com.reddit.frontpage.ui.carousel.LargeCarouselViewHolder;
import com.reddit.frontpage.ui.carousel.LinkCarouselViewHolder;
import com.reddit.frontpage.ui.carousel.SmallCarouselViewHolder;
import com.reddit.frontpage.ui.home.HomeTab;
import com.reddit.frontpage.ui.listing.DecorationInclusionStrategy;
import com.reddit.frontpage.ui.listing.adapter.CardLinkAdapter;
import com.reddit.frontpage.ui.listing.adapter.ListingViewHolder;
import com.reddit.frontpage.ui.listing.newcard.VisibilityDependent;
import com.reddit.frontpage.util.ListUtil;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import de.greenrobot.event.EventBus;
import io.reactivex.Observer;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0004\u0001\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0014J\u0010\u00100\u001a\u00020-2\u0006\u00101\u001a\u000202H\u0014J\b\u00103\u001a\u00020-H\u0016J\n\u00104\u001a\u0004\u0018\u00010\u0012H\u0016J\n\u00105\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u000209H\u0016J\n\u0010:\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010;\u001a\u000207H\u0014J\b\u0010<\u001a\u00020=H\u0014J\b\u0010>\u001a\u00020-H\u0016J\b\u0010?\u001a\u00020-H\u0016J\b\u0010@\u001a\u00020-H\u0016J\b\u0010A\u001a\u00020-H\u0016J\u0010\u0010B\u001a\u00020-2\u0006\u0010C\u001a\u00020DH\u0016J\u0010\u0010E\u001a\u00020-2\u0006\u0010F\u001a\u000209H\u0016J\u0018\u0010G\u001a\u00020-2\u0006\u0010H\u001a\u0002092\u0006\u0010I\u001a\u000209H\u0016J\u0018\u0010J\u001a\u00020-2\u0006\u0010H\u001a\u0002092\u0006\u0010I\u001a\u000209H\u0016J\b\u0010K\u001a\u00020-H\u0016J\b\u0010L\u001a\u00020-H\u0016J\b\u0010M\u001a\u00020-H\u0016J\u0010\u0010N\u001a\u00020-2\u0006\u0010O\u001a\u00020PH\u0014J\u0018\u0010Q\u001a\u00020-2\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u000209H\u0016J\u0010\u0010U\u001a\u00020-2\u0006\u0010V\u001a\u00020WH\u0014J.\u0010X\u001a\u00020-2\u0006\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\\2\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00120^2\u0006\u0010_\u001a\u000209H\u0002J\u0018\u0010`\u001a\u00020-2\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020dH\u0016J\u0018\u0010e\u001a\u00020W2\u0006\u0010c\u001a\u00020f2\u0006\u0010g\u001a\u00020\u0006H\u0016J\b\u0010h\u001a\u00020-H\u0016J\u0010\u0010i\u001a\u00020-2\u0006\u0010V\u001a\u00020WH\u0016J\u0010\u0010j\u001a\u00020-2\u0006\u0010V\u001a\u00020WH\u0014J\u0010\u0010k\u001a\u00020-2\u0006\u0010l\u001a\u00020WH\u0014J\u0010\u0010m\u001a\u00020-2\u0006\u0010l\u001a\u00020WH\u0014J\u000e\u0010n\u001a\u00020-2\u0006\u0010o\u001a\u00020pJ\u0010\u0010q\u001a\u00020=2\u0006\u0010[\u001a\u00020rH\u0016J\u0018\u0010s\u001a\u00020-2\u0006\u0010V\u001a\u00020W2\u0006\u0010t\u001a\u00020uH\u0014J\u0018\u0010v\u001a\u00020-2\u0006\u0010V\u001a\u00020W2\u0006\u0010w\u001a\u00020uH\u0014J\b\u0010x\u001a\u00020=H\u0016J\u0010\u0010y\u001a\u00020-2\u0006\u0010z\u001a\u00020WH\u0002J\u0016\u0010{\u001a\u00020-2\f\u0010|\u001a\b\u0012\u0004\u0012\u00020~0}H\u0016J\u0011\u0010\u001a\u00020-2\u0007\u0010\u0001\u001a\u000207H\u0016J\u001e\u0010\u0001\u001a\u00020-2\u0007\u0010\u0001\u001a\u00020+2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\t\u0010\u0001\u001a\u00020-H\u0016J\t\u0010\u0001\u001a\u00020-H\u0016J\t\u0010\u0001\u001a\u00020-H\u0016J\t\u0010\u0001\u001a\u00020-H\u0016J\u0012\u0010\u0001\u001a\u00020-2\u0007\u0010\u0001\u001a\u00020\u0012H\u0016J\t\u0010\u0001\u001a\u00020-H\u0016J\t\u0010\u0001\u001a\u00020-H\u0016J\t\u0010\u0001\u001a\u00020-H\u0016J1\u0010\u0001\u001a\u00020-2&\u0010\u0001\u001a!\u0012\u0016\u0012\u00140=¢\u0006\u000f\b\u0001\u0012\n\b\u0001\u0012\u0005\b\b(\u0001\u0012\u0004\u0012\u00020-0\u0001H\u0016J\u0012\u0010\u0001\u001a\u00020-2\u0007\u0010\u0001\u001a\u00020\u0012H\u0016J\u001e\u0010\u0001\u001a\u00020-2\u0007\u0010\u0001\u001a\u00020+2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J\t\u0010\u0001\u001a\u00020-H\u0016J\t\u0010\u0001\u001a\u00020-H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u0007\u001a\u00060\bR\u00020\u00008TX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u00020#8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0*0)X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/FrontpageListingScreen;", "Lcom/reddit/frontpage/presentation/listing/common/LinkListingScreen;", "Lcom/reddit/frontpage/presentation/listing/frontpage/FrontpageListingContract$View;", "Lcom/reddit/frontpage/ui/home/HomeTab;", "()V", "actionContainer", "Landroid/view/ViewGroup;", "adapter", "Lcom/reddit/frontpage/presentation/listing/FrontpageListingScreen$FrontpageLinkAdapter;", "getAdapter", "()Lcom/reddit/frontpage/presentation/listing/FrontpageListingScreen$FrontpageLinkAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "carouselOptionsBottomsheet", "Lcom/reddit/frontpage/presentation/carousel/options/CarouselOptionsScreen;", "handler", "Landroid/os/Handler;", "listingName", "", "getListingName", "()Ljava/lang/String;", "listingViewActions", "Lcom/reddit/frontpage/presentation/listing/common/ListingViewActions;", "getListingViewActions", "()Lcom/reddit/frontpage/presentation/listing/common/ListingViewActions;", "setListingViewActions", "(Lcom/reddit/frontpage/presentation/listing/common/ListingViewActions;)V", "newUserContainer", "onExploreClickListener", "Landroid/view/View$OnClickListener;", "getOnExploreClickListener", "()Landroid/view/View$OnClickListener;", "setOnExploreClickListener", "(Landroid/view/View$OnClickListener;)V", "presenter", "Lcom/reddit/frontpage/presentation/listing/frontpage/FrontpageListingPresenter;", "getPresenter", "()Lcom/reddit/frontpage/presentation/listing/frontpage/FrontpageListingPresenter;", "setPresenter", "(Lcom/reddit/frontpage/presentation/listing/frontpage/FrontpageListingPresenter;)V", "sortObservable", "Lio/reactivex/subjects/PublishSubject;", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortSelection;", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "configureActionBar", "", "actionBar", "Landroid/support/v7/app/ActionBar;", "customizeDecorationStrategy", "strategy", "Lcom/reddit/frontpage/ui/listing/DecorationInclusionStrategy;", "dismissCarouselBottomsheet", "getAnalyticsPageType", "getAnalyticsScreenName", "getCurrentViewMode", "Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;", "getLayoutId", "", "getScreenListingName", "getViewModePreference", "hasNavigationDrawer", "", "hideLoadMoreView", "hideLoading", "hideRefreshPill", "hideRefreshing", "notifyDiffResult", "diffResult", "Lcom/reddit/frontpage/presentation/listing/common/ViewDiffResult;", "notifyLinkChanged", "position", "notifyLinksInserted", "startPosition", "numItems", "notifyLinksRemoved", "notifyListingChanged", "notifyLoadError", "notifyLoadMoreNetworkError", "onActivityResumed", "activity", "Landroid/app/Activity;", "onAppBarOffsetChanged", "appBarLayout", "Landroid/support/design/widget/AppBarLayout;", "verticalOffset", "onAttach", "view", "Landroid/view/View;", "onCarouselOverflowClicked", "context", "Landroid/content/Context;", "item", "Lcom/reddit/frontpage/presentation/carousel/model/CarouselCollectionPresentationModel;", "idsSeen", "", "listablePosition", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateView", "Landroid/view/LayoutInflater;", "container", "onDestroy", "onDestroyView", "onDetach", "onEmptyInflated", "inflated", "onErrorInflated", "onEventMainThread", "viewModeSelection", "Lcom/reddit/frontpage/presentation/viewmode/ViewModeOptionSelection;", "onOptionsItemSelected", "Landroid/view/MenuItem;", "onRestoreViewState", "savedViewState", "Landroid/os/Bundle;", "onSaveViewState", "outState", "resetScreen", "resizeEmptyView", "empty", "setListing", "posts", "", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "setListingViewMode", "mode", "setSorting", "sort", "sortTimeFrame", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "showContentListView", "showEmptyListView", "showLoadMoreView", "showLoading", "showMessage", "message", "showNetworkErrorMessage", "showRefreshPill", "showRefreshing", "showReportView", "wasReported", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "showShortDurationMessage", "showSortDialog", "initialSort", "timeFrame", "showSuspendedReportView", "showViewModeOptions", "Companion", "FrontpageLinkAdapter", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: FrontpageListingScreen.kt */
public final class FrontpageListingScreen extends LinkListingScreen implements View, HomeTab {
    static final /* synthetic */ KProperty[] f40553v = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(FrontpageListingScreen.class), "adapter", "getAdapter()Lcom/reddit/frontpage/presentation/listing/FrontpageListingScreen$FrontpageLinkAdapter;"))};
    public static final Companion f40554z = new Companion();
    private ViewGroup f40555M;
    private ViewGroup f40556N;
    private CarouselOptionsScreen f40557O;
    private final Handler f40558P = new Handler();
    private final PublishSubject<SortSelection<SortType>> f40559Q;
    private final Lazy f40560R;
    @Inject
    public FrontpageListingPresenter f40561w;
    @Inject
    public ListingViewActions f40562x;
    public OnClickListener f40563y;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/FrontpageListingScreen$Companion;", "", "()V", "ANALYTICS_PAGE_TYPE", "", "ANALYTICS_SCREEN_NAME", "DEFAULT_ADAPTER_OPTIONS", "", "LISTING_NAME", "SOURCE_PAGE", "newInstance", "Lcom/reddit/frontpage/presentation/listing/FrontpageListingScreen;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: FrontpageListingScreen.kt */
    public static final class Companion {
        private Companion() {
        }

        public static FrontpageListingScreen m22867a() {
            return new FrontpageListingScreen();
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004j\u0002`\b2\u00020\tBÂ\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012j\u0010\f\u001af\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0014\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\rj\u0002`\u0019\u0012j\u0010\u001a\u001af\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0014\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\rj\u0002`\u0019\u0012j\u0010\u001b\u001af\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0014\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\rj\u0002`\u0019\u0012j\u0010\u001c\u001af\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0014\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\rj\u0002`\u0019\u0012U\u0010\u001d\u001aQ\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0014\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\u001ej\u0002` \u0012U\u0010!\u001aQ\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0014\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\u001ej\u0002` \u0012U\u0010\"\u001aQ\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0014\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\u001ej\u0002` ¢\u0006\u0002\u0010#J\u0018\u0010?\u001a\u00020\u00182\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0014J\u001e\u0010D\u001a\u00020\u00182\u0006\u0010@\u001a\u00020E2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020G0FH\u0014J\u0018\u0010H\u001a\u00020\u00182\u0006\u0010@\u001a\u00020I2\u0006\u0010B\u001a\u00020\u0006H\u0014J\u0010\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020MH\u0014J\u0012\u0010N\u001a\u0004\u0018\u00010O2\u0006\u0010L\u001a\u00020MH\u0014J\u0012\u0010P\u001a\u0004\u0018\u00010Q2\u0006\u0010L\u001a\u00020MH\u0014J\u0010\u0010R\u001a\u00020Q2\u0006\u0010L\u001a\u00020MH\u0014J\b\u0010S\u001a\u00020TH\u0016J\u0010\u0010U\u001a\u00020\u00072\u0006\u0010V\u001a\u00020\u000eH\u0016J\b\u0010W\u001a\u00020\u000eH\u0016J\u0010\u0010X\u001a\u00020Y2\u0006\u0010V\u001a\u00020\u000eH\u0016J\u0011\u0010Z\u001a\u00020\u000e2\u0006\u0010V\u001a\u00020\u000eH\u0001J\n\u0010[\u001a\u0004\u0018\u00010\\H\u0014J\b\u0010]\u001a\u00020\u0016H\u0014J\u0011\u0010^\u001a\u00020\u000e2\u0006\u0010@\u001a\u00020_H\u0001J4\u0010`\u001a\u00020\u00182\u0006\u0010@\u001a\u00020_2!\u0010a\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(V\u0012\u0004\u0012\u00020\u00180bH\u0001R\u0018\u0010$\u001a\u00020\u0006X\u000f¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020-8VX\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0018\u00100\u001a\u00020\u0005X\u000f¢\u0006\f\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001e\u00105\u001a\b\u0012\u0004\u0012\u00020\u000706X\u000f¢\u0006\f\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0014\u0010;\u001a\u00020\u000e8VX\u0005¢\u0006\u0006\u001a\u0004\b<\u0010+R]\u0010!\u001aQ\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0014\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\u001ej\u0002` X\u0004¢\u0006\u0002\n\u0000R]\u0010\"\u001aQ\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0014\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\u001ej\u0002` X\u0004¢\u0006\u0002\n\u0000Rr\u0010\f\u001af\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0014\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\rj\u0002`\u0019X\u0004¢\u0006\u0002\n\u0000Rr\u0010\u001b\u001af\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0014\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\rj\u0002`\u0019X\u0004¢\u0006\u0002\n\u0000Rr\u0010\u001c\u001af\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0014\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\rj\u0002`\u0019X\u0004¢\u0006\u0002\n\u0000R]\u0010\u001d\u001aQ\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0014\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\u001ej\u0002` X\u0004¢\u0006\u0002\n\u0000Rr\u0010\u001a\u001af\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0014\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\rj\u0002`\u0019X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010=\u001a\u00020\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b>\u0010+¨\u0006c"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/FrontpageListingScreen$FrontpageLinkAdapter;", "Lcom/reddit/frontpage/presentation/listing/common/PresentationListingAdapter;", "Lcom/reddit/frontpage/presentation/listing/frontpage/FrontpageListingPresenter;", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "Lcom/reddit/frontpage/presentation/listing/common/SortableLoadMoreListingAdapter;", "Lcom/reddit/frontpage/presentation/listing/model/SortHeaderPresentationModel;", "Lcom/reddit/frontpage/presentation/listing/model/LoadingFooterPresentationModel;", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "Lcom/reddit/frontpage/presentation/listing/common/ListableListingHeaderFooterAdapter;", "Lcom/reddit/frontpage/presentation/listing/common/LoadMoreListingAdapter;", "context", "Landroid/content/Context;", "onDismissListener", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "listablePosition", "carouselItemPosition", "Lcom/reddit/frontpage/presentation/carousel/model/CarouselItemPresentationModel;", "item", "", "", "idsSeen", "", "Lcom/reddit/frontpage/presentation/listing/ListableCarouselItemClickListener;", "onSubscribeListener", "onItemClickListener", "onItemHeaderClickListener", "onOverflowClickListener", "Lkotlin/Function3;", "Lcom/reddit/frontpage/presentation/carousel/model/CarouselCollectionPresentationModel;", "Lcom/reddit/frontpage/presentation/listing/ListableCarouselClickListener;", "onCarouselClickListener", "onCarouselSubscribeListener", "(Lcom/reddit/frontpage/presentation/listing/FrontpageListingScreen;Landroid/content/Context;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;)V", "footer", "getFooter", "()Lcom/reddit/frontpage/presentation/listing/model/LoadingFooterPresentationModel;", "setFooter", "(Lcom/reddit/frontpage/presentation/listing/model/LoadingFooterPresentationModel;)V", "footerIndex", "getFooterIndex", "()I", "footerState", "Lcom/reddit/frontpage/presentation/listing/model/FooterState;", "getFooterState", "()Lcom/reddit/frontpage/presentation/listing/model/FooterState;", "header", "getHeader", "()Lcom/reddit/frontpage/presentation/listing/model/SortHeaderPresentationModel;", "setHeader", "(Lcom/reddit/frontpage/presentation/listing/model/SortHeaderPresentationModel;)V", "listing", "", "getListing", "()Ljava/util/List;", "setListing", "(Ljava/util/List;)V", "listingItemCount", "getListingItemCount", "screenWidth", "getScreenWidth", "bindLinkCarouselViewHolder", "holder", "Lcom/reddit/frontpage/ui/carousel/LinkCarouselViewHolder;", "model", "Lcom/reddit/frontpage/presentation/carousel/model/LinkCarouselCollectionPresentationModel;", "bindSubredditCarouselViewHolder", "Lcom/reddit/frontpage/ui/carousel/CarouselViewHolder;", "Lcom/reddit/frontpage/presentation/carousel/model/GeneralCarouselCollectionPresentationModel;", "Lcom/reddit/frontpage/presentation/carousel/model/ICarouselItemPresentationModel;", "bindViewHolder", "Lcom/reddit/frontpage/presentation/listing/ui/viewholder/LoadingFooterViewHolder;", "createLargeSubredditListingCarouselViewHolder", "Lcom/reddit/frontpage/ui/carousel/LargeCarouselViewHolder;", "parent", "Landroid/view/ViewGroup;", "createLinkCarouselViewHolder", "Lcom/reddit/frontpage/ui/listing/adapter/ListingViewHolder;", "createMediumSubredditListingCarouselViewHolder", "Lcom/reddit/frontpage/ui/carousel/SmallCarouselViewHolder;", "createSmallSubredditListingCarouselViewHolder", "getCompact", "", "getItem", "position", "getItemCount", "getItemId", "", "getModelPosition", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getSourcePage", "getUnadjustedLinkPosition", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "withUnadjustedLinkPosition", "action", "Lkotlin/Function1;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: FrontpageListingScreen.kt */
    protected final class FrontpageLinkAdapter extends PresentationListingAdapter<FrontpageListingPresenter, SortType> implements LoadMoreListingAdapter, SortableLoadMoreListingAdapter<SortHeaderPresentationModel, LoadingFooterPresentationModel, Listable> {
        final /* synthetic */ RedditSortableLoadMoreListingAdapter f36501a;
        final /* synthetic */ FrontpageListingScreen f36502b;
        private final Function4<Integer, Integer, CarouselItemPresentationModel, Set<String>, Unit> f36503c;
        private final Function4<Integer, Integer, CarouselItemPresentationModel, Set<String>, Unit> f36504p;
        private final Function4<Integer, Integer, CarouselItemPresentationModel, Set<String>, Unit> f36505q;
        private final Function4<Integer, Integer, CarouselItemPresentationModel, Set<String>, Unit> f36506r;
        private final Function3<Integer, CarouselCollectionPresentationModel, Set<String>, Unit> f36507s;
        private final Function3<Integer, CarouselCollectionPresentationModel, Set<String>, Unit> f36508t;
        private final Function3<Integer, CarouselCollectionPresentationModel, Set<String>, Unit> f36509u;

        public final void mo6937a(ViewHolder viewHolder, Function1<? super Integer, Unit> function1) {
            Intrinsics.m26847b(viewHolder, "holder");
            Intrinsics.m26847b(function1, "action");
            this.f36501a.m34715a(viewHolder, function1);
        }

        public final void m36891a(LoadingFooterPresentationModel loadingFooterPresentationModel) {
            Intrinsics.m26847b(loadingFooterPresentationModel, "<set-?>");
            this.f36501a.m34716a(loadingFooterPresentationModel);
        }

        public final void m36892a(SortHeaderPresentationModel sortHeaderPresentationModel) {
            Intrinsics.m26847b(sortHeaderPresentationModel, "<set-?>");
            this.f36501a.m34717a(sortHeaderPresentationModel);
        }

        public final void mo6470a(List<Listable> list) {
            Intrinsics.m26847b(list, "<set-?>");
            this.f36501a.mo6470a((List) list);
        }

        public final int mo6471d(ViewHolder viewHolder) {
            Intrinsics.m26847b(viewHolder, "holder");
            return this.f36501a.mo6471d(viewHolder);
        }

        protected final String mo6479f() {
            return "front_page";
        }

        public FrontpageLinkAdapter(FrontpageListingScreen frontpageListingScreen, Context context, Function4<? super Integer, ? super Integer, ? super CarouselItemPresentationModel, ? super Set<String>, Unit> function4, Function4<? super Integer, ? super Integer, ? super CarouselItemPresentationModel, ? super Set<String>, Unit> function42, Function4<? super Integer, ? super Integer, ? super CarouselItemPresentationModel, ? super Set<String>, Unit> function43, Function4<? super Integer, ? super Integer, ? super CarouselItemPresentationModel, ? super Set<String>, Unit> function44, Function3<? super Integer, ? super CarouselCollectionPresentationModel, ? super Set<String>, Unit> function3, Function3<? super Integer, ? super CarouselCollectionPresentationModel, ? super Set<String>, Unit> function32, Function3<? super Integer, ? super CarouselCollectionPresentationModel, ? super Set<String>, Unit> function33) {
            FrontpageListingScreen frontpageListingScreen2 = frontpageListingScreen;
            Function4<? super Integer, ? super Integer, ? super CarouselItemPresentationModel, ? super Set<String>, Unit> function45 = function4;
            Function4<? super Integer, ? super Integer, ? super CarouselItemPresentationModel, ? super Set<String>, Unit> function46 = function42;
            Function4<? super Integer, ? super Integer, ? super CarouselItemPresentationModel, ? super Set<String>, Unit> function47 = function43;
            Function4<? super Integer, ? super Integer, ? super CarouselItemPresentationModel, ? super Set<String>, Unit> function48 = function44;
            Function3<? super Integer, ? super CarouselCollectionPresentationModel, ? super Set<String>, Unit> function34 = function3;
            Function3<? super Integer, ? super CarouselCollectionPresentationModel, ? super Set<String>, Unit> function35 = function32;
            Function3<? super Integer, ? super CarouselCollectionPresentationModel, ? super Set<String>, Unit> function36 = function33;
            Context context2 = context;
            Intrinsics.m26847b(context2, "context");
            Intrinsics.m26847b(function45, "onDismissListener");
            Intrinsics.m26847b(function46, "onSubscribeListener");
            Intrinsics.m26847b(function47, "onItemClickListener");
            Intrinsics.m26847b(function48, "onItemHeaderClickListener");
            Intrinsics.m26847b(function34, "onOverflowClickListener");
            Intrinsics.m26847b(function35, "onCarouselClickListener");
            Intrinsics.m26847b(function36, "onCarouselSubscribeListener");
            this.f36502b = frontpageListingScreen2;
            super(context2, frontpageListingScreen.mo7641w(), new Function1<LinkViewHolder, Unit>(frontpageListingScreen2) {
                public final KDeclarationContainer mo6931a() {
                    return Reflection.m26850a(FrontpageListingScreen.class);
                }

                public final String mo5687b() {
                    return "retainPlayersInFeed";
                }

                public final String mo6932c() {
                    return "retainPlayersInFeed(Lcom/reddit/frontpage/presentation/listing/ui/viewholder/LinkViewHolder;)V";
                }

                public final /* bridge */ /* synthetic */ Object mo6492a(Object obj) {
                    ((FrontpageListingScreen) this.b).m40627a((LinkViewHolder) obj);
                    return Unit.f25273a;
                }
            }, new Function2<SortType, SortTimeFrame, Unit>(frontpageListingScreen2) {
                public final KDeclarationContainer mo6931a() {
                    return Reflection.m26850a(FrontpageListingScreen.class);
                }

                public final String mo5687b() {
                    return "showSortDialog";
                }

                public final String mo6932c() {
                    return "showSortDialog(Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;)V";
                }

                public final /* synthetic */ Object mo6497a(Object obj, Object obj2) {
                    SortType sortType = (SortType) obj;
                    SortTimeFrame sortTimeFrame = (SortTimeFrame) obj2;
                    Intrinsics.m26847b(sortType, "p1");
                    FrontpageListingScreen.m41965a((FrontpageListingScreen) this.b, sortType, sortTimeFrame);
                    return Unit.f25273a;
                }
            }, new Function0<Unit>(frontpageListingScreen2) {
                public final KDeclarationContainer mo6931a() {
                    return Reflection.m26850a(FrontpageListingScreen.class);
                }

                public final String mo5687b() {
                    return "showViewModeOptions";
                }

                public final String mo6932c() {
                    return "showViewModeOptions()V";
                }

                public final /* synthetic */ Object invoke() {
                    FrontpageListingScreen.m41967c((FrontpageListingScreen) this.b);
                    return Unit.f25273a;
                }
            });
            ListingViewMode a = frontpageListingScreen.f40038G;
            if (a == null) {
                Intrinsics.m26842a();
            }
            r6.f36501a = new RedditSortableLoadMoreListingAdapter(a);
            r6.f36503c = function45;
            r6.f36504p = function46;
            r6.f36505q = function47;
            r6.f36506r = function48;
            r6.f36507s = function34;
            r6.f36508t = function35;
            r6.f36509u = function36;
        }

        public final /* synthetic */ Object mo4996g(int i) {
            return mo6476c(i);
        }

        public final int mo4926b() {
            return DefaultImpls.m22942a((SortableLoadMoreListingAdapter) this);
        }

        private static int m36886o() {
            Object system = Resources.getSystem();
            Intrinsics.m26843a(system, "Resources.getSystem()");
            return system.getDisplayMetrics().widthPixels;
        }

        protected final void mo6474a(LoadingFooterViewHolder loadingFooterViewHolder, LoadingFooterPresentationModel loadingFooterPresentationModel) {
            Intrinsics.m26847b(loadingFooterViewHolder, "holder");
            Intrinsics.m26847b(loadingFooterPresentationModel, "model");
            super.mo6474a(loadingFooterViewHolder, loadingFooterPresentationModel);
            loadingFooterViewHolder.m34788a((OnClickListener) new FrontpageListingScreen$FrontpageLinkAdapter$bindViewHolder$1(this));
        }

        public final boolean mo6477c() {
            return Intrinsics.m26845a(this.f36502b.f40038G, ListingViewMode.f20613b);
        }

        protected final void mo6938a(LinkCarouselViewHolder linkCarouselViewHolder, LinkCarouselCollectionPresentationModel linkCarouselCollectionPresentationModel) {
            Intrinsics.m26847b(linkCarouselViewHolder, "holder");
            Intrinsics.m26847b(linkCarouselCollectionPresentationModel, "model");
            int d = mo6471d((ViewHolder) linkCarouselViewHolder);
            Function3 function3 = null;
            Function1 c2839xb29a6c6 = linkCarouselCollectionPresentationModel.f36377n.e() ? new C2839xb29a6c6(this, d, linkCarouselCollectionPresentationModel) : null;
            if (linkCarouselCollectionPresentationModel.f36377n.c()) {
                function3 = new C2838xbb9a4fcb(this, d);
            }
            linkCarouselViewHolder.m34944a(linkCarouselCollectionPresentationModel, function3, new C2833x3f429cb0(this, d), new C2834x3f429cb1(this, d), new C2835x3f429cb2(this), new C2836x3f429cb3(this, d), new C2837x3f429cb4(this, d), c2839xb29a6c6);
        }

        protected final void mo6475a(CarouselViewHolder carouselViewHolder, GeneralCarouselCollectionPresentationModel<? extends ICarouselItemPresentationModel> generalCarouselCollectionPresentationModel) {
            Intrinsics.m26847b(carouselViewHolder, "holder");
            Intrinsics.m26847b(generalCarouselCollectionPresentationModel, "model");
            int d = mo6471d((ViewHolder) carouselViewHolder);
            DiscoveryUnit discoveryUnit = generalCarouselCollectionPresentationModel.f36361i;
            Function3 function3 = null;
            Function1 c2844xd7b33b3a = (discoveryUnit == null || !discoveryUnit.e()) ? null : new C2844xd7b33b3a(this, d, generalCarouselCollectionPresentationModel);
            discoveryUnit = generalCarouselCollectionPresentationModel.f36361i;
            Function3 c2842x5d61ab7f = (discoveryUnit == null || !discoveryUnit.d()) ? null : new C2842x5d61ab7f(this, d);
            discoveryUnit = generalCarouselCollectionPresentationModel.f36361i;
            if (discoveryUnit != null && discoveryUnit.c()) {
                function3 = new C2843x1aa6713f(this, d);
            }
            carouselViewHolder.m34914a(generalCarouselCollectionPresentationModel, c2842x5d61ab7f, function3, new C2840x200f0024(this, d), new C2841x200f0025(this), c2844xd7b33b3a);
        }

        protected final ListingViewHolder mo6936a(ViewGroup viewGroup) {
            Intrinsics.m26847b(viewGroup, "parent");
            com.reddit.frontpage.ui.carousel.LinkCarouselViewHolder.Companion companion = LinkCarouselViewHolder.f34225a;
            return com.reddit.frontpage.ui.carousel.LinkCarouselViewHolder.Companion.m23326a(viewGroup, new C2846xb89a09af(this.f36502b.mo7641w()));
        }

        protected final SmallCarouselViewHolder mo6939b(ViewGroup viewGroup) {
            Intrinsics.m26847b(viewGroup, "parent");
            com.reddit.frontpage.ui.carousel.SmallCarouselViewHolder.Companion companion = SmallCarouselViewHolder.f37244b;
            return com.reddit.frontpage.ui.carousel.SmallCarouselViewHolder.Companion.m23328a(viewGroup, m36886o(), false, new C2847xb3f1110(this.f36502b.mo7641w()));
        }

        protected final LargeCarouselViewHolder mo6940c(ViewGroup viewGroup) {
            Intrinsics.m26847b(viewGroup, "parent");
            return new LargeCarouselViewHolder(viewGroup, m36886o(), new C2845xc47cda48(this.f36502b.mo7641w()));
        }

        protected final SmallCarouselViewHolder mo6941d(ViewGroup viewGroup) {
            Intrinsics.m26847b(viewGroup, "parent");
            com.reddit.frontpage.ui.carousel.SmallCarouselViewHolder.Companion companion = SmallCarouselViewHolder.f37244b;
            return com.reddit.frontpage.ui.carousel.SmallCarouselViewHolder.Companion.m23328a(viewGroup, m36886o(), false, new C2848xc968be14(this.f36502b.mo7641w()));
        }

        protected final RecyclerView mo6490h() {
            return this.f36502b.K == null ? null : this.f36502b.af();
        }

        public final Listable mo6476c(int i) {
            return (Listable) this.f36501a.f33898c.get(i);
        }

        public final int m36887a() {
            return this.f36501a.f33898c.size();
        }

        public final long m36888a(int i) {
            return ((Listable) this.f36501a.f33898c.get(i)).getUniqueID();
        }

        public final FooterState F_() {
            return this.f36501a.f33897b.f34003a;
        }

        public final List<Listable> mo6473i() {
            return this.f36501a.f33898c;
        }

        public final int mo4927j() {
            return DefaultImpls.m22944b(this.f36501a);
        }

        public final int mo6472h(int i) {
            return DefaultImpls.m22940a(i);
        }
    }

    private FrontpageLinkAdapter aB() {
        return (FrontpageLinkAdapter) this.f40560R.mo5678b();
    }

    public static final FrontpageListingScreen ac() {
        return Companion.m22867a();
    }

    public final String D_() {
        return "frontpage";
    }

    protected final String mo7618O() {
        return "frontpage";
    }

    protected final boolean af_() {
        return true;
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

    public FrontpageListingScreen() {
        Object create = PublishSubject.create();
        Intrinsics.m26843a(create, "PublishSubject.create()");
        this.f40559Q = create;
        this.f40560R = LazyKt.m26777a(new FrontpageListingScreen$adapter$2(this));
        Builder a = DaggerFrontpageComponent.m29130a();
        UserComponent k = FrontpageApplication.m28875k();
        Intrinsics.m26843a((Object) k, "FrontpageApplication.getUserComponent()");
        a.mo4653a(k).mo4655a((View) this).mo4659b(LazyKt.m26777a(new Function0<Activity>() {
            public final /* synthetic */ Object invoke() {
                Activity am_ = this.am_();
                if (am_ == null) {
                    Intrinsics.m26842a();
                }
                return am_;
            }
        })).mo4657a(LazyKt.m26777a(new Function0<Activity>() {
            public final /* synthetic */ Object invoke() {
                Activity am_ = this.am_();
                if (am_ == null) {
                    Intrinsics.m26842a();
                }
                return am_;
            }
        })).mo4656a("front_page").mo4654a(new Parameters(this.f40559Q)).mo4658a().mo4660a(this);
    }

    public final /* synthetic */ CardLinkAdapter mo7617M() {
        return aB();
    }

    public final FrontpageListingPresenter mo7641w() {
        FrontpageListingPresenter frontpageListingPresenter = this.f40561w;
        if (frontpageListingPresenter == null) {
            Intrinsics.m26844a("presenter");
        }
        return frontpageListingPresenter;
    }

    protected final void mo7631a(android.view.View view, Bundle bundle) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(bundle, "outState");
        aB().m30191a(bundle);
        super.mo7631a(view, bundle);
    }

    protected final void mo7638b(android.view.View view, Bundle bundle) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(bundle, "savedViewState");
        super.mo7638b(view, bundle);
        aB().m30215b(bundle);
    }

    public final void mo7630a() {
        CarouselOptionsScreen carouselOptionsScreen = this.f40557O;
        if (carouselOptionsScreen != null) {
            carouselOptionsScreen.dismiss();
        }
    }

    public final android.view.View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.m26847b(layoutInflater, "inflater");
        Intrinsics.m26847b(viewGroup, "container");
        super.mo7139a(layoutInflater, viewGroup);
        layoutInflater = af();
        LinearLayoutManager ag = ag();
        LoadMoreListingAdapter aB = aB();
        FrontpageListingPresenter frontpageListingPresenter = this.f40561w;
        if (frontpageListingPresenter == null) {
            Intrinsics.m26844a("presenter");
        }
        layoutInflater.addOnScrollListener((OnScrollListener) new LoadMoreOnScrollListener(ag, aB, new FrontpageListingScreen$onCreateView$1(frontpageListingPresenter)));
        layoutInflater = ah();
        layoutInflater.setRecyclerView(af());
        ((android.view.View) layoutInflater).setOnClickListener(new FrontpageListingScreen$inlined$sam$OnClickListener$i$7f478c20((Function1) new FrontpageListingScreen$onCreateView$$inlined$apply$lambda$1(this)));
        ai().setOnRefreshListener((OnRefreshListener) new FrontpageListingScreen$onCreateView$3(this));
        Object obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        return obj;
    }

    public final void mo6987a(android.view.View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6987a(view);
        this.f40556N = null;
        this.f40555M = null;
        this.f40563y = null;
    }

    protected final void mo6992b(android.view.View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6992b(view);
        ae().mo4854a(this);
        view = this.f40561w;
        if (view == null) {
            Intrinsics.m26844a("presenter");
        }
        view.attach();
    }

    protected final void mo6993c(android.view.View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6993c(view);
        view = this.f40561w;
        if (view == null) {
            Intrinsics.m26844a("presenter");
        }
        view.detach();
    }

    public final void mo7191l() {
        super.mo7191l();
        FrontpageListingPresenter frontpageListingPresenter = this.f40561w;
        if (frontpageListingPresenter == null) {
            Intrinsics.m26844a("presenter");
        }
        frontpageListingPresenter.destroy();
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
            this.f40558P.postDelayed(new FrontpageListingScreen$onActivityResumed$1$1(visibilityDependent), 500);
        }
    }

    protected final void mo7634a(DecorationInclusionStrategy decorationInclusionStrategy) {
        Intrinsics.m26847b(decorationInclusionStrategy, "strategy");
        decorationInclusionStrategy.m23389a(FrontpageListingScreen$customizeDecorationStrategy$1.f36518a);
    }

    protected final void mo7639f(android.view.View view) {
        Intrinsics.m26847b(view, "inflated");
        view.setOnClickListener(new FrontpageListingScreen$inlined$sam$OnClickListener$i$7f478c20(new FrontpageListingScreen$onErrorInflated$1(this)));
    }

    protected final void mo7640g(android.view.View view) {
        Intrinsics.m26847b(view, "inflated");
        this.f40555M = (ConstraintLayout) view.findViewById(C1761R.id.new_user_container);
        this.f40556N = (FrameLayout) view.findViewById(C1761R.id.action_container);
        Object obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        if (obj.getHeight() == 0) {
            obj = this.K;
            Intrinsics.m26843a(obj, "rootView");
            obj.getViewTreeObserver().addOnGlobalLayoutListener(new FrontpageListingScreen$onEmptyInflated$1(this, view));
            return;
        }
        m41969h(view);
    }

    public final void mo7215a(AppBarLayout appBarLayout, int i) {
        Intrinsics.m26847b(appBarLayout, "appBarLayout");
        appBarLayout = (float) ((-i) / 2);
        i = this.f40556N;
        if (i != 0) {
            i.setTranslationY(appBarLayout);
        }
        i = this.f40555M;
        if (i != 0) {
            i.setTranslationY(appBarLayout);
        }
    }

    protected final void mo7185a(ActionBar actionBar) {
        Intrinsics.m26847b(actionBar, "actionBar");
        actionBar.c(false);
    }

    public final boolean mo7200K() {
        if (T_() == null) {
            return false;
        }
        if (!ListUtil.m23810a(ag())) {
            af().smoothScrollToPosition(0);
        }
        return true;
    }

    private final void m41969h(android.view.View view) {
        ViewGroup viewGroup = this.f40555M;
        if (viewGroup != null) {
            LayoutParams layoutParams = viewGroup.getLayoutParams();
            Object T_ = T_();
            if (T_ == null) {
                Intrinsics.m26842a();
            }
            Intrinsics.m26843a(T_, "view!!");
            layoutParams.height = T_.getHeight();
            viewGroup.requestLayout();
        }
        LayoutInflater.from(view.getContext()).inflate(C1761R.layout.explore_buttons, this.f40556N);
        OnClickListener onClickListener = this.f40563y;
        if (onClickListener != null) {
            ((Button) view.findViewById(C1761R.id.popular_button)).setOnClickListener(onClickListener);
        }
    }

    public final void m41990a(Menu menu, MenuInflater menuInflater) {
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

    public final void mo7330b(List<? extends Listable> list) {
        Intrinsics.m26847b(list, "posts");
        ListingViewActions listingViewActions = this.f40562x;
        if (listingViewActions == null) {
            Intrinsics.m26844a("listingViewActions");
        }
        listingViewActions.mo4866a((List) list, (CardLinkAdapter) aB());
    }

    public final void mo7335x() {
        ListingViewActions listingViewActions = this.f40562x;
        if (listingViewActions == null) {
            Intrinsics.m26844a("listingViewActions");
        }
        listingViewActions.mo4864a((CardLinkAdapter) aB());
    }

    public final void mo7328b(int i) {
        ListingViewActions listingViewActions = this.f40562x;
        if (listingViewActions == null) {
            Intrinsics.m26844a("listingViewActions");
        }
        listingViewActions.mo4860a(i, (CardLinkAdapter) aB());
    }

    public final void mo7323a(int i, int i2) {
        ListingViewActions listingViewActions = this.f40562x;
        if (listingViewActions == null) {
            Intrinsics.m26844a("listingViewActions");
        }
        listingViewActions.mo4859a(i, i2, aB());
    }

    public final void mo7322a(int i) {
        ListingViewActions listingViewActions = this.f40562x;
        if (listingViewActions == null) {
            Intrinsics.m26844a("listingViewActions");
        }
        listingViewActions.mo4867b(i, aB());
    }

    public final void mo7336y() {
        ListingViewActions listingViewActions = this.f40562x;
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
        ListingViewActions listingViewActions = this.f40562x;
        if (listingViewActions == null) {
            Intrinsics.m26844a("listingViewActions");
        }
        listingViewActions.mo4865a((CardLinkAdapter) aB(), viewDiffResult);
    }

    public final void mo7620Q() {
        FrontpageLinkAdapter aB = aB();
        FooterState footerState = FooterState.ERROR;
        Activity am_ = am_();
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        aB.m36891a(new LoadingFooterPresentationModel(footerState, am_.getString(C1761R.string.error_network_error)));
        aB().d(DefaultImpls.m22942a(aB()));
    }

    public final void mo7621R() {
        ListingViewActions listingViewActions = this.f40562x;
        if (listingViewActions == null) {
            Intrinsics.m26844a("listingViewActions");
        }
        listingViewActions.mo4861a((LinkListingScreen) this);
    }

    public final void mo7622S() {
        ListingViewActions listingViewActions = this.f40562x;
        if (listingViewActions == null) {
            Intrinsics.m26844a("listingViewActions");
        }
        listingViewActions.mo4862a((LinkListingScreen) this, Integer.valueOf(C1761R.layout.frontpage_empty));
    }

    public final void mo7623T() {
        ListingViewActions listingViewActions = this.f40562x;
        if (listingViewActions == null) {
            Intrinsics.m26844a("listingViewActions");
        }
        listingViewActions.mo4868b(this);
    }

    public final void mo7624U() {
        ah().m24195a();
    }

    public final void mo7625V() {
        ViewsKt.m24109d(ah());
    }

    public final void mo7626W() {
        Activity am_ = am_();
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        mo7204a((CharSequence) am_.getString(C1761R.string.error_network_error));
    }

    public final void mo7635a(String str) {
        Intrinsics.m26847b(str, "message");
        mo7204a((CharSequence) str);
    }

    public final void mo7632a(SortType sortType, SortTimeFrame sortTimeFrame) {
        Intrinsics.m26847b(sortType, "sort");
        as();
        FrontpageLinkAdapter aB = aB();
        ListingViewMode listingViewMode = this.f40038G;
        if (listingViewMode == null) {
            Intrinsics.m26842a();
        }
        aB.m36892a(new SortHeaderPresentationModel(sortType, sortTimeFrame, listingViewMode));
        aB().d(null);
    }

    public final void mo7627X() {
        ListingViewActions listingViewActions = this.f40562x;
        if (listingViewActions == null) {
            Intrinsics.m26844a("listingViewActions");
        }
        listingViewActions.mo4869c(this);
    }

    public final void mo7628Y() {
        ListingViewActions listingViewActions = this.f40562x;
        if (listingViewActions == null) {
            Intrinsics.m26844a("listingViewActions");
        }
        listingViewActions.mo4870d(this);
    }

    public final void mo7629Z() {
        aB().m36891a(new LoadingFooterPresentationModel(FooterState.LOADING, 2));
        aB().d(DefaultImpls.m22942a(aB()));
    }

    public final void aa() {
        aB().m36891a(new LoadingFooterPresentationModel(FooterState.NONE, 2));
        aB().d(DefaultImpls.m22942a(aB()));
    }

    protected final ListingViewMode ab() {
        Object blockingGet = ad().m22477b("listingViewMode.frontpage", ao()).blockingGet();
        Intrinsics.m26843a(blockingGet, "preferenceRepository\n   …ode)\n      .blockingGet()");
        return (ListingViewMode) blockingGet;
    }

    public final ListingViewMode mo7619P() {
        ListingViewMode listingViewMode = this.f40038G;
        return listingViewMode == null ? ao() : listingViewMode;
    }

    public final void mo7633a(ListingViewMode listingViewMode) {
        Intrinsics.m26847b(listingViewMode, "mode");
        this.f40038G = listingViewMode;
        listingViewMode = aB();
        SortHeaderPresentationModel sortHeaderPresentationModel = aB().f36501a.f33896a;
        ListingViewMode listingViewMode2 = this.f40038G;
        if (listingViewMode2 == null) {
            Intrinsics.m26842a();
        }
        listingViewMode.m36892a(SortHeaderPresentationModel.m34745a(sortHeaderPresentationModel, listingViewMode2));
        ar();
        aB().e();
    }

    public final void onEventMainThread(ViewModeOptionSelection viewModeOptionSelection) {
        Intrinsics.m26847b(viewModeOptionSelection, "viewModeSelection");
        if ((Intrinsics.m26845a(viewModeOptionSelection.f20997a, (Object) this) ^ 1) == 0) {
            EventBus.getDefault().removeStickyEvent((Object) viewModeOptionSelection);
            FrontpageListingPresenter frontpageListingPresenter = this.f40561w;
            if (frontpageListingPresenter == null) {
                Intrinsics.m26844a("presenter");
            }
            frontpageListingPresenter.m37065a(viewModeOptionSelection.f20998b);
        }
    }

    public static final /* synthetic */ void m41965a(FrontpageListingScreen frontpageListingScreen, SortType sortType, SortTimeFrame sortTimeFrame) {
        Observer observer = frontpageListingScreen.f40559Q;
        Object am_ = frontpageListingScreen.am_();
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26843a(am_, "activity!!");
        new PostSortOptionsDialog(observer, (Context) am_, true, sortType, sortTimeFrame).m22764a();
    }

    public static final /* synthetic */ void m41967c(FrontpageListingScreen frontpageListingScreen) {
        Activity am_ = frontpageListingScreen.am_();
        if (am_ == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.content.Context");
        }
        Context context = am_;
        ListingViewMode listingViewMode = frontpageListingScreen.f40038G;
        if (listingViewMode == null) {
            Intrinsics.m26842a();
        }
        ViewModeOptionsScreen viewModeOptionsScreen = new ViewModeOptionsScreen(context, listingViewMode);
        viewModeOptionsScreen.m38982a((BaseScreen) frontpageListingScreen);
        viewModeOptionsScreen.show();
    }

    public static final /* synthetic */ void m41963a(FrontpageListingScreen frontpageListingScreen, Context context, CarouselCollectionPresentationModel carouselCollectionPresentationModel, Set set, int i) {
        FrontpageListingPresenter frontpageListingPresenter = frontpageListingScreen.f40561w;
        if (frontpageListingPresenter == null) {
            Intrinsics.m26844a("presenter");
        }
        frontpageListingScreen.f40557O = new CarouselOptionsScreen(context, frontpageListingPresenter, carouselCollectionPresentationModel, set, i);
        frontpageListingScreen = frontpageListingScreen.f40557O;
        if (frontpageListingScreen != null) {
            frontpageListingScreen.show();
        }
    }
}
