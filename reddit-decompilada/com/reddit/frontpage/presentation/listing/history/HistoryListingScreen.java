package com.reddit.frontpage.presentation.listing.history;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
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
import android.widget.TextView;
import com.evernote.android.state.State;
import com.reddit.datalibrary.frontpage.data.feature.common.SortSelection;
import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.di.component.DaggerHistoryComponent;
import com.reddit.frontpage.di.component.HistoryComponent.Builder;
import com.reddit.frontpage.di.component.UserComponent;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.presentation.common.ui.view.listoptions.sort.SimpleSortOptionsDialog;
import com.reddit.frontpage.presentation.common.ui.view.listoptions.sort.SortOption;
import com.reddit.frontpage.presentation.listing.common.LinkListingScreen;
import com.reddit.frontpage.presentation.listing.common.ListingViewActions;
import com.reddit.frontpage.presentation.listing.common.LoadMoreListingAdapter;
import com.reddit.frontpage.presentation.listing.common.LoadMoreOnScrollListener;
import com.reddit.frontpage.presentation.listing.common.PresentationListingAdapter;
import com.reddit.frontpage.presentation.listing.common.SortableLoadMoreListingAdapter;
import com.reddit.frontpage.presentation.listing.common.SortableLoadMoreListingAdapter.DefaultImpls;
import com.reddit.frontpage.presentation.listing.common.ViewDiffResult;
import com.reddit.frontpage.presentation.listing.history.HistoryListingContract.Parameters;
import com.reddit.frontpage.presentation.listing.history.HistoryListingContract.View;
import com.reddit.frontpage.presentation.listing.model.FooterState;
import com.reddit.frontpage.presentation.listing.model.ListingViewMode;
import com.reddit.frontpage.presentation.listing.model.LoadingFooterPresentationModel;
import com.reddit.frontpage.presentation.listing.ui.viewholder.LinkViewHolder;
import com.reddit.frontpage.presentation.listing.ui.viewholder.LoadingFooterViewHolder;
import com.reddit.frontpage.presentation.viewmode.ViewModeOptionSelection;
import com.reddit.frontpage.presentation.viewmode.ViewModeOptionsScreen;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.listing.DecorationInclusionStrategy;
import com.reddit.frontpage.ui.listing.adapter.CardLinkAdapter;
import com.reddit.frontpage.ui.listing.newcard.VisibilityDependent;
import com.reddit.frontpage.util.ListUtil;
import com.reddit.frontpage.util.kotlin.InvalidatableLazy;
import com.reddit.frontpage.util.kotlin.LazyKt;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import de.greenrobot.event.EventBus;
import io.reactivex.Observer;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00012\u00020\u00012\u00020\u0002:\u0004\u0001\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0014J\u0010\u00101\u001a\u00020.2\u0006\u00102\u001a\u000203H\u0014J\n\u00104\u001a\u0004\u0018\u000105H\u0016J\n\u00106\u001a\u0004\u0018\u000105H\u0016J\b\u00107\u001a\u000208H\u0016J\b\u00109\u001a\u00020:H\u0014J\b\u0010;\u001a\u00020.H\u0016J\b\u0010<\u001a\u00020.H\u0016J\u0010\u0010=\u001a\u00020.2\u0006\u0010>\u001a\u00020?H\u0016J\u0010\u0010@\u001a\u00020.2\u0006\u0010A\u001a\u000208H\u0016J\u0018\u0010B\u001a\u00020.2\u0006\u0010C\u001a\u0002082\u0006\u0010D\u001a\u000208H\u0016J\u0018\u0010E\u001a\u00020.2\u0006\u0010C\u001a\u0002082\u0006\u0010D\u001a\u000208H\u0016J\b\u0010F\u001a\u00020.H\u0016J\b\u0010G\u001a\u00020.H\u0016J\b\u0010H\u001a\u00020.H\u0016J\u0010\u0010I\u001a\u00020.2\u0006\u0010J\u001a\u00020KH\u0014J\u0010\u0010L\u001a\u00020.2\u0006\u0010M\u001a\u00020\u0013H\u0014J\u0018\u0010N\u001a\u00020.2\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020RH\u0016J\u0018\u0010S\u001a\u00020\u00132\u0006\u0010Q\u001a\u00020T2\u0006\u0010U\u001a\u00020VH\u0016J\b\u0010W\u001a\u00020.H\u0016J\u0010\u0010X\u001a\u00020.2\u0006\u0010M\u001a\u00020\u0013H\u0014J\u000e\u0010Y\u001a\u00020.2\u0006\u0010Z\u001a\u00020[J\u0010\u0010\\\u001a\u00020\u000b2\u0006\u0010]\u001a\u00020\u0011H\u0016J\u0018\u0010^\u001a\u00020.2\u0006\u0010M\u001a\u00020\u00132\u0006\u0010_\u001a\u00020`H\u0014J\u0018\u0010a\u001a\u00020.2\u0006\u0010M\u001a\u00020\u00132\u0006\u0010b\u001a\u00020`H\u0014J\b\u0010c\u001a\u00020\u000bH\u0016J\u0010\u0010d\u001a\u00020.2\u0006\u0010e\u001a\u00020\u000bH\u0016J\u0016\u0010f\u001a\u00020.2\f\u0010g\u001a\b\u0012\u0004\u0012\u00020i0hH\u0016J\u0010\u0010j\u001a\u00020.2\u0006\u0010k\u001a\u00020:H\u0016J\u0010\u0010l\u001a\u00020.2\u0006\u0010m\u001a\u00020,H\u0016J\b\u0010n\u001a\u00020.H\u0016J\b\u0010o\u001a\u00020.H\u0016J\b\u0010p\u001a\u00020.H\u0016J\b\u0010q\u001a\u00020.H\u0016J\b\u0010r\u001a\u00020.H\u0016J\b\u0010s\u001a\u00020.H\u0016J+\u0010t\u001a\u00020.2!\u0010u\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\bw\u0012\b\bx\u0012\u0004\b\b(u\u0012\u0004\u0012\u00020.0vH\u0016J\u001c\u0010y\u001a\u00020.2\u0006\u0010z\u001a\u00020,2\n\b\u0002\u0010{\u001a\u0004\u0018\u00010|H\u0002J\u0010\u0010}\u001a\u00020.2\u0006\u0010~\u001a\u000205H\u0016J\b\u0010\u001a\u00020.H\u0016J\t\u0010\u0001\u001a\u00020.H\u0002R\u001f\u0010\u0004\u001a\u00060\u0005R\u00020\u00008TX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0018\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u0019\u0010\u0015R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u00020\u001e8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010#\u001a\u00020$8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0+0*X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/history/HistoryListingScreen;", "Lcom/reddit/frontpage/presentation/listing/common/LinkListingScreen;", "Lcom/reddit/frontpage/presentation/listing/history/HistoryListingContract$View;", "()V", "adapter", "Lcom/reddit/frontpage/presentation/listing/history/HistoryListingScreen$HistoryLinkAdapter;", "getAdapter", "()Lcom/reddit/frontpage/presentation/listing/history/HistoryListingScreen$HistoryLinkAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "clearRecentsMenuEnabled", "", "getClearRecentsMenuEnabled", "()Z", "setClearRecentsMenuEnabled", "(Z)V", "clearRecentsMenuItem", "Landroid/view/MenuItem;", "emptyView", "Landroid/view/View;", "getEmptyView", "()Landroid/view/View;", "emptyView$delegate", "Lcom/reddit/frontpage/util/kotlin/InvalidatableLazy;", "errorView", "getErrorView", "errorView$delegate", "handler", "Landroid/os/Handler;", "listingViewActions", "Lcom/reddit/frontpage/presentation/listing/common/ListingViewActions;", "getListingViewActions", "()Lcom/reddit/frontpage/presentation/listing/common/ListingViewActions;", "setListingViewActions", "(Lcom/reddit/frontpage/presentation/listing/common/ListingViewActions;)V", "presenter", "Lcom/reddit/frontpage/presentation/listing/history/HistoryListingPresenter;", "getPresenter", "()Lcom/reddit/frontpage/presentation/listing/history/HistoryListingPresenter;", "setPresenter", "(Lcom/reddit/frontpage/presentation/listing/history/HistoryListingPresenter;)V", "sortObservable", "Lio/reactivex/subjects/PublishSubject;", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortSelection;", "Lcom/reddit/frontpage/presentation/listing/history/HistorySortType;", "configureActionBar", "", "actionBar", "Landroid/support/v7/app/ActionBar;", "customizeDecorationStrategy", "strategy", "Lcom/reddit/frontpage/ui/listing/DecorationInclusionStrategy;", "getAnalyticsPageType", "", "getAnalyticsScreenName", "getLayoutId", "", "getViewModePreference", "Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;", "hideLoadMoreView", "hideRefreshing", "notifyDiffResult", "diffResult", "Lcom/reddit/frontpage/presentation/listing/common/ViewDiffResult;", "notifyLinkChanged", "position", "notifyLinksInserted", "startPosition", "numItems", "notifyLinksRemoved", "notifyListingChanged", "notifyLoadError", "notifyLoadMoreNetworkError", "onActivityResumed", "activity", "Landroid/app/Activity;", "onAttach", "view", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateView", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onEventMainThread", "viewModeSelection", "Lcom/reddit/frontpage/presentation/viewmode/ViewModeOptionSelection;", "onOptionsItemSelected", "item", "onRestoreViewState", "savedViewState", "Landroid/os/Bundle;", "onSaveViewState", "outState", "resetScreen", "setClearRecentsEnabled", "enabled", "setListing", "posts", "", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "setListingViewMode", "mode", "setSorting", "sort", "showContentListView", "showEmptyListView", "showLoadMoreView", "showLoading", "showNetworkErrorMessage", "showRefreshing", "showReportView", "wasReported", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "showSortDialog", "selectedSort", "timeFrame", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "showSubscribedMessage", "subredditName", "showSuspendedReportView", "showViewModeOptions", "Companion", "HistoryLinkAdapter", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: HistoryListingScreen.kt */
public final class HistoryListingScreen extends LinkListingScreen implements View {
    static final /* synthetic */ KProperty[] f40573v = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(HistoryListingScreen.class), "emptyView", "getEmptyView()Landroid/view/View;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(HistoryListingScreen.class), "errorView", "getErrorView()Landroid/view/View;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(HistoryListingScreen.class), "adapter", "getAdapter()Lcom/reddit/frontpage/presentation/listing/history/HistoryListingScreen$HistoryLinkAdapter;"))};
    public static final Companion f40574y = new Companion();
    private final InvalidatableLazy f40575M = LazyKt.m24085a((BaseScreen) this, (Function0) new HistoryListingScreen$errorView$2(this));
    private MenuItem f40576N;
    private final Handler f40577O = new Handler();
    private final PublishSubject<SortSelection<HistorySortType>> f40578P;
    private final Lazy f40579Q;
    @State
    boolean clearRecentsMenuEnabled = true;
    @Inject
    public HistoryListingPresenter f40580w;
    @Inject
    public ListingViewActions f40581x;
    private final InvalidatableLazy f40582z = LazyKt.m24085a((BaseScreen) this, (Function0) new HistoryListingScreen$emptyView$2(this));

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/history/HistoryListingScreen$Companion;", "", "()V", "ANALYTICS_PAGE_TYPE", "", "ANALYTICS_SCREEN_NAME", "DEFAULT_ADAPTER_OPTIONS", "", "SOURCE_PAGE", "newInstance", "Lcom/reddit/frontpage/presentation/listing/history/HistoryListingScreen;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: HistoryListingScreen.kt */
    public static final class Companion {
        private Companion() {
        }

        public static HistoryListingScreen m22955a() {
            return new HistoryListingScreen();
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004j\u0002`\b2\u00020\tB\r\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0018\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0006H\u0014J\b\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0013H\u0016J\b\u00100\u001a\u00020\u0013H\u0016J\u0010\u00101\u001a\u0002022\u0006\u0010/\u001a\u00020\u0013H\u0016J\u0011\u00103\u001a\u00020\u00132\u0006\u0010/\u001a\u00020\u0013H\u0001J\n\u00104\u001a\u0004\u0018\u000105H\u0014J\b\u00106\u001a\u000207H\u0014J\u0011\u00108\u001a\u00020\u00132\u0006\u0010)\u001a\u000209H\u0001J4\u0010:\u001a\u00020(2\u0006\u0010)\u001a\u0002092!\u0010;\u001a\u001d\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020(0<H\u0001R\u0018\u0010\r\u001a\u00020\u0006X\u000f¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u00020\u0005X\u000f¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070 X\u000f¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u00138VX\u0005¢\u0006\u0006\u001a\u0004\b&\u0010\u0015¨\u0006?"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/history/HistoryListingScreen$HistoryLinkAdapter;", "Lcom/reddit/frontpage/presentation/listing/common/PresentationListingAdapter;", "Lcom/reddit/frontpage/presentation/listing/history/HistoryListingPresenter;", "Lcom/reddit/frontpage/presentation/listing/history/HistorySortType;", "Lcom/reddit/frontpage/presentation/listing/common/SortableLoadMoreListingAdapter;", "Lcom/reddit/frontpage/presentation/listing/history/HistorySortHeaderPresentationModel;", "Lcom/reddit/frontpage/presentation/listing/model/LoadingFooterPresentationModel;", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "Lcom/reddit/frontpage/presentation/listing/history/HistoryListingHeaderFooterAdapter;", "Lcom/reddit/frontpage/presentation/listing/common/LoadMoreListingAdapter;", "context", "Landroid/content/Context;", "(Lcom/reddit/frontpage/presentation/listing/history/HistoryListingScreen;Landroid/content/Context;)V", "footer", "getFooter", "()Lcom/reddit/frontpage/presentation/listing/model/LoadingFooterPresentationModel;", "setFooter", "(Lcom/reddit/frontpage/presentation/listing/model/LoadingFooterPresentationModel;)V", "footerIndex", "", "getFooterIndex", "()I", "footerState", "Lcom/reddit/frontpage/presentation/listing/model/FooterState;", "getFooterState", "()Lcom/reddit/frontpage/presentation/listing/model/FooterState;", "header", "getHeader", "()Lcom/reddit/frontpage/presentation/listing/history/HistorySortHeaderPresentationModel;", "setHeader", "(Lcom/reddit/frontpage/presentation/listing/history/HistorySortHeaderPresentationModel;)V", "listing", "", "getListing", "()Ljava/util/List;", "setListing", "(Ljava/util/List;)V", "listingItemCount", "getListingItemCount", "bindViewHolder", "", "holder", "Lcom/reddit/frontpage/presentation/listing/ui/viewholder/LoadingFooterViewHolder;", "model", "getCompact", "", "getItem", "position", "getItemCount", "getItemId", "", "getModelPosition", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getSourcePage", "", "getUnadjustedLinkPosition", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "withUnadjustedLinkPosition", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: HistoryListingScreen.kt */
    protected final class HistoryLinkAdapter extends PresentationListingAdapter<HistoryListingPresenter, HistorySortType> implements LoadMoreListingAdapter, SortableLoadMoreListingAdapter<HistorySortHeaderPresentationModel, LoadingFooterPresentationModel, Listable> {
        final /* synthetic */ HistorySortableLoadMoreListingAdapter f36681a;
        final /* synthetic */ HistoryListingScreen f36682b;

        public final void mo6470a(List<Listable> list) {
            Intrinsics.m26847b(list, "<set-?>");
            this.f36681a.mo6470a(list);
        }

        public final int mo6471d(ViewHolder viewHolder) {
            Intrinsics.m26847b(viewHolder, "holder");
            return this.f36681a.mo6471d(viewHolder);
        }

        protected final String mo6479f() {
            return "history";
        }

        public HistoryLinkAdapter(HistoryListingScreen historyListingScreen, Context context) {
            Intrinsics.m26847b(context, "context");
            this.f36682b = historyListingScreen;
            super(context, historyListingScreen.mo7641w(), new Function1<LinkViewHolder, Unit>(historyListingScreen) {
                public final KDeclarationContainer mo6931a() {
                    return Reflection.m26850a(HistoryListingScreen.class);
                }

                public final String mo5687b() {
                    return "retainPlayersInFeed";
                }

                public final String mo6932c() {
                    return "retainPlayersInFeed(Lcom/reddit/frontpage/presentation/listing/ui/viewholder/LinkViewHolder;)V";
                }

                public final /* bridge */ /* synthetic */ Object mo6492a(Object obj) {
                    ((HistoryListingScreen) this.b).m40627a((LinkViewHolder) obj);
                    return Unit.f25273a;
                }
            }, new Function2<HistorySortType, SortTimeFrame, Unit>(historyListingScreen) {
                public final KDeclarationContainer mo6931a() {
                    return Reflection.m26850a(HistoryListingScreen.class);
                }

                public final String mo5687b() {
                    return "showSortDialog";
                }

                public final String mo6932c() {
                    return "showSortDialog(Lcom/reddit/frontpage/presentation/listing/history/HistorySortType;Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;)V";
                }

                public final /* synthetic */ Object mo6497a(Object obj, Object obj2) {
                    HistorySortType historySortType = (HistorySortType) obj;
                    Intrinsics.m26847b(historySortType, "p1");
                    HistoryListingScreen.m42060a((HistoryListingScreen) this.b, historySortType);
                    return Unit.f25273a;
                }
            }, new Function0<Unit>(historyListingScreen) {
                public final KDeclarationContainer mo6931a() {
                    return Reflection.m26850a(HistoryListingScreen.class);
                }

                public final String mo5687b() {
                    return "showViewModeOptions";
                }

                public final String mo6932c() {
                    return "showViewModeOptions()V";
                }

                public final /* synthetic */ Object invoke() {
                    HistoryListingScreen.m42061b((HistoryListingScreen) this.b);
                    return Unit.f25273a;
                }
            });
            historyListingScreen = historyListingScreen.f40038G;
            if (historyListingScreen == null) {
                Intrinsics.m26842a();
            }
            this.f36681a = new HistorySortableLoadMoreListingAdapter(historyListingScreen);
        }

        public final /* synthetic */ Object mo4996g(int i) {
            return mo6476c(i);
        }

        public final int mo4926b() {
            return DefaultImpls.m22942a((SortableLoadMoreListingAdapter) this);
        }

        protected final void mo6474a(LoadingFooterViewHolder loadingFooterViewHolder, LoadingFooterPresentationModel loadingFooterPresentationModel) {
            Intrinsics.m26847b(loadingFooterViewHolder, "holder");
            Intrinsics.m26847b(loadingFooterPresentationModel, "model");
            super.mo6474a(loadingFooterViewHolder, loadingFooterPresentationModel);
            loadingFooterViewHolder.m34788a((OnClickListener) new HistoryListingScreen$HistoryLinkAdapter$bindViewHolder$1(this));
        }

        public final boolean mo6477c() {
            return Intrinsics.m26845a(this.f36682b.f40038G, ListingViewMode.f20613b);
        }

        protected final RecyclerView mo6490h() {
            return this.f36682b.af();
        }

        public final Listable mo6476c(int i) {
            return (Listable) this.f36681a.f33931c.get(i);
        }

        public final int m37124a() {
            return this.f36681a.f33931c.size();
        }

        public final long m37125a(int i) {
            return ((Listable) this.f36681a.f33931c.get(i)).getUniqueID();
        }

        public final FooterState F_() {
            return this.f36681a.f33930b.f34003a;
        }

        public final void m37128a(LoadingFooterPresentationModel loadingFooterPresentationModel) {
            Intrinsics.m26847b(loadingFooterPresentationModel, "<set-?>");
            SortableLoadMoreListingAdapter sortableLoadMoreListingAdapter = this.f36681a;
            Intrinsics.m26847b(loadingFooterPresentationModel, "value");
            sortableLoadMoreListingAdapter.f33931c.set(DefaultImpls.m22942a(sortableLoadMoreListingAdapter), loadingFooterPresentationModel);
            sortableLoadMoreListingAdapter.f33930b = loadingFooterPresentationModel;
        }

        public final void m37127a(HistorySortHeaderPresentationModel historySortHeaderPresentationModel) {
            Intrinsics.m26847b(historySortHeaderPresentationModel, "<set-?>");
            HistorySortableLoadMoreListingAdapter historySortableLoadMoreListingAdapter = this.f36681a;
            Intrinsics.m26847b(historySortHeaderPresentationModel, "value");
            historySortableLoadMoreListingAdapter.f33931c.set(0, historySortHeaderPresentationModel);
            historySortableLoadMoreListingAdapter.f33929a = historySortHeaderPresentationModel;
        }

        public final List<Listable> mo6473i() {
            return this.f36681a.f33931c;
        }

        public final int mo4927j() {
            return DefaultImpls.m22944b(this.f36681a);
        }

        public final int mo6472h(int i) {
            return DefaultImpls.m22940a(i);
        }

        public final void mo6937a(ViewHolder viewHolder, Function1<? super Integer, Unit> function1) {
            Intrinsics.m26847b(viewHolder, "holder");
            Intrinsics.m26847b(function1, "action");
            SortableLoadMoreListingAdapter sortableLoadMoreListingAdapter = this.f36681a;
            Intrinsics.m26847b(viewHolder, "holder");
            Intrinsics.m26847b(function1, "action");
            DefaultImpls.m22943a(sortableLoadMoreListingAdapter, viewHolder, function1);
        }
    }

    public static final HistoryListingScreen N_() {
        return Companion.m22955a();
    }

    private final android.view.View m42056P() {
        return (android.view.View) this.f40582z.mo5678b();
    }

    private final android.view.View m42057Q() {
        return (android.view.View) this.f40575M.mo5678b();
    }

    private HistoryLinkAdapter m42058R() {
        return (HistoryLinkAdapter) this.f40579Q.mo5678b();
    }

    public final String getAnalyticsPageType() {
        return "profile";
    }

    public final String getAnalyticsScreenName() {
        return "profile_history";
    }

    public final int mo7141s() {
        return C1761R.layout.screen_history;
    }

    public HistoryListingScreen() {
        Object create = PublishSubject.create();
        Intrinsics.m26843a(create, "PublishSubject.create()");
        this.f40578P = create;
        this.f40579Q = kotlin.LazyKt.m26777a(new HistoryListingScreen$adapter$2(this));
        Builder a = DaggerHistoryComponent.m29152a();
        UserComponent k = FrontpageApplication.m28875k();
        Intrinsics.m26843a((Object) k, "FrontpageApplication.getUserComponent()");
        a.mo4664a(k).mo4666a((View) this).mo4670b(kotlin.LazyKt.m26777a(new Function0<Activity>() {
            public final /* synthetic */ Object invoke() {
                Activity am_ = this.am_();
                if (am_ == null) {
                    Intrinsics.m26842a();
                }
                return am_;
            }
        })).mo4668a(kotlin.LazyKt.m26777a(new Function0<Activity>() {
            public final /* synthetic */ Object invoke() {
                Activity am_ = this.am_();
                if (am_ == null) {
                    Intrinsics.m26842a();
                }
                return am_;
            }
        })).mo4667a("history").mo4665a(new Parameters(this.f40578P)).mo4669a().mo4671a(this);
    }

    public final /* synthetic */ CardLinkAdapter mo7617M() {
        return m42058R();
    }

    public final HistoryListingPresenter mo7641w() {
        HistoryListingPresenter historyListingPresenter = this.f40580w;
        if (historyListingPresenter == null) {
            Intrinsics.m26844a("presenter");
        }
        return historyListingPresenter;
    }

    protected final void mo7631a(android.view.View view, Bundle bundle) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(bundle, "outState");
        m42058R().m30191a(bundle);
        super.mo7631a(view, bundle);
    }

    protected final void mo7638b(android.view.View view, Bundle bundle) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(bundle, "savedViewState");
        super.mo7638b(view, bundle);
        m42058R().m30215b(bundle);
    }

    public final android.view.View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.m26847b(layoutInflater, "inflater");
        Intrinsics.m26847b(viewGroup, "container");
        super.mo7139a(layoutInflater, viewGroup);
        n();
        layoutInflater = af();
        LinearLayoutManager ag = ag();
        LoadMoreListingAdapter R = m42058R();
        HistoryListingPresenter historyListingPresenter = this.f40580w;
        if (historyListingPresenter == null) {
            Intrinsics.m26844a("presenter");
        }
        layoutInflater.addOnScrollListener((OnScrollListener) new LoadMoreOnScrollListener(ag, R, new HistoryListingScreen$onCreateView$1(historyListingPresenter)));
        ai().setOnRefreshListener((OnRefreshListener) new HistoryListingScreen$onCreateView$2(this));
        Object obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        return obj;
    }

    protected final void mo6992b(android.view.View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6992b(view);
        ae().mo4854a(this);
        view = this.f40580w;
        if (view == null) {
            Intrinsics.m26844a("presenter");
        }
        view.attach();
    }

    protected final void mo6993c(android.view.View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6993c(view);
        view = this.f40580w;
        if (view == null) {
            Intrinsics.m26844a("presenter");
        }
        view.detach();
    }

    public final void mo7191l() {
        super.mo7191l();
        HistoryListingPresenter historyListingPresenter = this.f40580w;
        if (historyListingPresenter == null) {
            Intrinsics.m26844a("presenter");
        }
        historyListingPresenter.destroy();
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
            this.f40577O.postDelayed(new HistoryListingScreen$onActivityResumed$1$1(visibilityDependent), 500);
        }
    }

    protected final void mo7634a(DecorationInclusionStrategy decorationInclusionStrategy) {
        Intrinsics.m26847b(decorationInclusionStrategy, "strategy");
        decorationInclusionStrategy.m23389a(HistoryListingScreen$customizeDecorationStrategy$1.f36684a);
    }

    protected final void mo7185a(ActionBar actionBar) {
        Intrinsics.m26847b(actionBar, "actionBar");
        actionBar.a(C1761R.string.title_history);
        at().setOnClickListener(new HistoryListingScreen$configureActionBar$1(this));
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

    public final void m42070a(Menu menu, MenuInflater menuInflater) {
        Intrinsics.m26847b(menu, "menu");
        Intrinsics.m26847b(menuInflater, "inflater");
        super.a(menu, menuInflater);
        menuInflater.inflate(C1761R.menu.menu_history, menu);
        this.f40576N = menu.findItem(C1761R.id.action_clear_history);
        mo7664a(this.clearRecentsMenuEnabled);
    }

    public final boolean mo7201a(MenuItem menuItem) {
        Intrinsics.m26847b(menuItem, "item");
        if (menuItem.getItemId() != C1761R.id.action_clear_history) {
            return super.mo7201a(menuItem);
        }
        menuItem = this.f40580w;
        if (menuItem == null) {
            Intrinsics.m26844a("presenter");
        }
        menuItem.m37093a();
        return true;
    }

    public final void mo7330b(List<? extends Listable> list) {
        Intrinsics.m26847b(list, "posts");
        ListingViewActions listingViewActions = this.f40581x;
        if (listingViewActions == null) {
            Intrinsics.m26844a("listingViewActions");
        }
        listingViewActions.mo4866a((List) list, (CardLinkAdapter) m42058R());
    }

    public final void mo7335x() {
        ListingViewActions listingViewActions = this.f40581x;
        if (listingViewActions == null) {
            Intrinsics.m26844a("listingViewActions");
        }
        listingViewActions.mo4864a((CardLinkAdapter) m42058R());
    }

    public final void mo7328b(int i) {
        ListingViewActions listingViewActions = this.f40581x;
        if (listingViewActions == null) {
            Intrinsics.m26844a("listingViewActions");
        }
        listingViewActions.mo4860a(i, (CardLinkAdapter) m42058R());
    }

    public final void mo7323a(int i, int i2) {
        ListingViewActions listingViewActions = this.f40581x;
        if (listingViewActions == null) {
            Intrinsics.m26844a("listingViewActions");
        }
        listingViewActions.mo4859a(i, i2, m42058R());
    }

    public final void mo7322a(int i) {
        ListingViewActions listingViewActions = this.f40581x;
        if (listingViewActions == null) {
            Intrinsics.m26844a("listingViewActions");
        }
        listingViewActions.mo4867b(i, m42058R());
    }

    public final void mo7336y() {
        ListingViewActions listingViewActions = this.f40581x;
        if (listingViewActions == null) {
            Intrinsics.m26844a("listingViewActions");
        }
        listingViewActions.mo4861a((LinkListingScreen) this);
        ViewsKt.m24109d(m42056P());
        ViewsKt.m24107c(m42057Q());
        Object obj = (TextView) m42057Q().findViewById(C1761R.id.error_message);
        Intrinsics.m26843a(obj, "errorView.error_message");
        Activity am_ = am_();
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        obj.setText(am_.getString(C1761R.string.error_network_error));
        obj = (TextView) m42057Q().findViewById(C1761R.id.retry_button);
        Intrinsics.m26843a(obj, "errorView.retry_button");
        ((android.view.View) obj).setOnClickListener(new HistoryListingScreen$inlined$sam$OnClickListener$i$7f478c20(new HistoryListingScreen$notifyLoadError$1(this)));
    }

    public final void mo7324a(ViewDiffResult viewDiffResult) {
        Intrinsics.m26847b(viewDiffResult, "diffResult");
        ListingViewActions listingViewActions = this.f40581x;
        if (listingViewActions == null) {
            Intrinsics.m26844a("listingViewActions");
        }
        listingViewActions.mo4865a((CardLinkAdapter) m42058R(), viewDiffResult);
    }

    public final void I_() {
        HistoryLinkAdapter R = m42058R();
        FooterState footerState = FooterState.ERROR;
        Activity am_ = am_();
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        R.m37128a(new LoadingFooterPresentationModel(footerState, am_.getString(C1761R.string.error_network_error)));
        m42058R().d(DefaultImpls.m22942a(m42058R()));
    }

    public final void J_() {
        ListingViewActions listingViewActions = this.f40581x;
        if (listingViewActions == null) {
            Intrinsics.m26844a("listingViewActions");
        }
        listingViewActions.mo4861a((LinkListingScreen) this);
        ViewsKt.m24109d(m42056P());
        ViewsKt.m24109d(m42057Q());
    }

    public final void K_() {
        ListingViewActions listingViewActions = this.f40581x;
        if (listingViewActions == null) {
            Intrinsics.m26844a("listingViewActions");
        }
        listingViewActions.mo4861a((LinkListingScreen) this);
        ViewsKt.m24107c(m42056P());
        ViewsKt.m24109d(m42057Q());
    }

    public final void L_() {
        ListingViewActions listingViewActions = this.f40581x;
        if (listingViewActions == null) {
            Intrinsics.m26844a("listingViewActions");
        }
        listingViewActions.mo4868b(this);
        ViewsKt.m24109d(m42056P());
        ViewsKt.m24109d(m42057Q());
    }

    public final void M_() {
        Activity am_ = am_();
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        mo7204a((CharSequence) am_.getString(C1761R.string.error_network_error));
    }

    public final void mo7663a(String str) {
        Intrinsics.m26847b(str, "subredditName");
        Activity am_ = am_();
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        mo7204a((CharSequence) am_.getString(C1761R.string.fmt_now_subscribed, new Object[]{str}));
    }

    public final void mo7661a(HistorySortType historySortType) {
        Intrinsics.m26847b(historySortType, "sort");
        HistoryLinkAdapter R = m42058R();
        HistorySortOptions historySortOptions = HistorySortOptions.f20601a;
        Object a = HistorySortOptions.m22957a(historySortType);
        Intrinsics.m26843a(a, "HistorySortOptions.getOption(sort)");
        ListingViewMode listingViewMode = this.f40038G;
        if (listingViewMode == null) {
            Intrinsics.m26842a();
        }
        R.m37127a(new HistorySortHeaderPresentationModel(a, listingViewMode));
        m42058R().d(0);
        this.clearRecentsMenuEnabled = Intrinsics.m26845a((Object) historySortType, HistorySortType.f28408a);
    }

    public final void mo7664a(boolean z) {
        MenuItem menuItem = this.f40576N;
        if (menuItem != null) {
            menuItem.setEnabled(z);
            int i = z ? true : true;
            Object am_ = am_();
            if (am_ == null) {
                Intrinsics.m26842a();
            }
            Intrinsics.m26843a(am_, "activity!!");
            Context context = (Context) am_;
            MenuItem menuItem2 = this.f40576N;
            if (menuItem2 == null) {
                Intrinsics.m26842a();
            }
            Drawable icon = menuItem2.getIcon();
            Intrinsics.m26843a((Object) icon, "clearRecentsMenuItem!!.icon");
            menuItem.setIcon(ResourcesUtil.m22721a(context, icon, i));
        }
    }

    public final void mo7660a() {
        ListingViewActions listingViewActions = this.f40581x;
        if (listingViewActions == null) {
            Intrinsics.m26844a("listingViewActions");
        }
        listingViewActions.mo4869c(this);
    }

    public final void mo7665b() {
        ListingViewActions listingViewActions = this.f40581x;
        if (listingViewActions == null) {
            Intrinsics.m26844a("listingViewActions");
        }
        listingViewActions.mo4870d(this);
    }

    public final void mo7666c() {
        m42058R().m37128a(new LoadingFooterPresentationModel(FooterState.LOADING, 2));
        m42058R().d(DefaultImpls.m22942a(m42058R()));
    }

    public final void mo7667d() {
        m42058R().m37128a(new LoadingFooterPresentationModel(FooterState.NONE, 2));
        m42058R().d(DefaultImpls.m22942a(m42058R()));
    }

    protected final ListingViewMode ab() {
        return ao();
    }

    public final void mo7662a(ListingViewMode listingViewMode) {
        Intrinsics.m26847b(listingViewMode, "mode");
        this.f40038G = listingViewMode;
        listingViewMode = m42058R();
        HistorySortHeaderPresentationModel historySortHeaderPresentationModel = m42058R().f36681a.f33929a;
        ListingViewMode listingViewMode2 = this.f40038G;
        if (listingViewMode2 == null) {
            Intrinsics.m26842a();
        }
        listingViewMode.m37127a(HistorySortHeaderPresentationModel.m34725a(historySortHeaderPresentationModel, listingViewMode2));
        ar();
        m42058R().e();
    }

    public final void onEventMainThread(ViewModeOptionSelection viewModeOptionSelection) {
        Intrinsics.m26847b(viewModeOptionSelection, "viewModeSelection");
        if ((Intrinsics.m26845a(viewModeOptionSelection.f20997a, (Object) this) ^ 1) == 0) {
            EventBus.getDefault().removeStickyEvent((Object) viewModeOptionSelection);
            HistoryListingPresenter historyListingPresenter = this.f40580w;
            if (historyListingPresenter == null) {
                Intrinsics.m26844a("presenter");
            }
            ListingViewMode listingViewMode = viewModeOptionSelection.f20998b;
            Intrinsics.m26847b(listingViewMode, "mode");
            historyListingPresenter.f36663a.mo7662a(listingViewMode);
        }
    }

    public static final /* synthetic */ void m42060a(HistoryListingScreen historyListingScreen, HistorySortType historySortType) {
        Observer observer = historyListingScreen.f40578P;
        Object am_ = historyListingScreen.am_();
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26843a(am_, "activity!!");
        Context context = (Context) am_;
        historyListingScreen = historyListingScreen.am_();
        if (historyListingScreen == null) {
            Intrinsics.m26842a();
        }
        Object string = historyListingScreen.getString(C1761R.string.title_sort_history);
        Intrinsics.m26843a(string, "activity!!.getString(R.string.title_sort_history)");
        historyListingScreen = HistorySortOptions.f20601a;
        List b = HistorySortOptions.m22958b();
        historyListingScreen = HistorySortOptions.f20601a;
        SortOption a = HistorySortOptions.m22956a();
        historyListingScreen = HistorySortOptions.f20601a;
        Object a2 = HistorySortOptions.m22957a(historySortType);
        Intrinsics.m26843a(a2, "HistorySortOptions.getOption(selectedSort)");
        new SimpleSortOptionsDialog(observer, context, string, b, a, a2).f20405a.show();
    }

    public static final /* synthetic */ void m42061b(HistoryListingScreen historyListingScreen) {
        Activity am_ = historyListingScreen.am_();
        if (am_ == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.content.Context");
        }
        Context context = am_;
        ListingViewMode listingViewMode = historyListingScreen.f40038G;
        if (listingViewMode == null) {
            Intrinsics.m26842a();
        }
        ViewModeOptionsScreen viewModeOptionsScreen = new ViewModeOptionsScreen(context, listingViewMode);
        viewModeOptionsScreen.m38982a((BaseScreen) historyListingScreen);
        viewModeOptionsScreen.show();
    }
}
