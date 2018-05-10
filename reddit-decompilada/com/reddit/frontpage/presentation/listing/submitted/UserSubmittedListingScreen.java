package com.reddit.frontpage.presentation.listing.submitted;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.evernote.android.state.State;
import com.reddit.datalibrary.frontpage.data.feature.account.datasource.local.AccountStorage;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v1.Account;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.events.v1.ScreenViewEvent;
import com.reddit.frontpage.commons.analytics.events.v1.ScreenViewEvent.ScreenViewPayload;
import com.reddit.frontpage.commons.analytics.events.v2.ScreenviewEventBuilder;
import com.reddit.frontpage.di.component.DaggerUserSubmittedListingComponent;
import com.reddit.frontpage.di.component.UserComponent;
import com.reddit.frontpage.di.component.UserSubmittedListingComponent.Builder;
import com.reddit.frontpage.presentation.MvpBaseScreen;
import com.reddit.frontpage.presentation.carousel.model.GeneralCarouselCollectionPresentationModel;
import com.reddit.frontpage.presentation.carousel.model.ICarouselItemPresentationModel;
import com.reddit.frontpage.presentation.listing.common.LoadMoreListingAdapter;
import com.reddit.frontpage.presentation.listing.common.LoadMoreOnScrollListener;
import com.reddit.frontpage.presentation.listing.common.ViewDiffResult;
import com.reddit.frontpage.presentation.listing.model.FooterState;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import com.reddit.frontpage.presentation.listing.model.LoadingFooterPresentationModel;
import com.reddit.frontpage.presentation.listing.submitted.UserSubmittedListingContract.View;
import com.reddit.frontpage.presentation.listing.ui.viewholder.LoadingFooterViewHolder;
import com.reddit.frontpage.presentation.listing.ui.viewholder.VideoPlayable;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.carousel.CarouselItemLayout;
import com.reddit.frontpage.ui.carousel.CarouselViewHolder;
import com.reddit.frontpage.ui.listener.AutoplayGifsOnScrollListener;
import com.reddit.frontpage.ui.listing.DecorationInclusionStrategy;
import com.reddit.frontpage.ui.listing.DividerItemDecoration;
import com.reddit.frontpage.ui.listing.adapter.CardLinkAdapter;
import com.reddit.frontpage.ui.listing.adapter.ListingViewHolder;
import com.reddit.frontpage.ui.listing.newcard.LinkViewHolder;
import com.reddit.frontpage.ui.listing.newcard.VideoCardLinkViewHolder;
import com.reddit.frontpage.ui.listing.newcard.VisibilityDependent;
import com.reddit.frontpage.ui.listing.newcard.VisibilityDependentDelegate;
import com.reddit.frontpage.ui.listing.newcard.VisibilityDependentDelegate.ItemChangedListener;
import com.reddit.frontpage.util.AnimUtil;
import com.reddit.frontpage.util.ListUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.InvalidatableLazy;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ¢\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0004¡\u0001¢\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020>H\u0002J\u001c\u0010`\u001a\u00020^2\u0012\u0010a\u001a\u000e\u0012\u0004\u0012\u00020c\u0012\u0004\u0012\u00020^0bH\u0002J\b\u0010d\u001a\u00020\u0019H\u0002J\b\u0010e\u001a\u00020fH\u0016J\n\u0010g\u001a\u0004\u0018\u00010SH\u0016J\n\u0010h\u001a\u0004\u0018\u00010SH\u0016J\b\u0010i\u001a\u00020jH\u0016J\b\u0010k\u001a\u000200H\u0016J\b\u0010l\u001a\u00020^H\u0016J\b\u0010m\u001a\u00020^H\u0016J\u0010\u0010n\u001a\u00020^2\u0006\u0010o\u001a\u00020pH\u0016J\u0010\u0010q\u001a\u00020^2\u0006\u0010r\u001a\u000200H\u0016J\u0018\u0010s\u001a\u00020^2\u0006\u0010t\u001a\u0002002\u0006\u0010u\u001a\u000200H\u0016J\u0018\u0010v\u001a\u00020^2\u0006\u0010t\u001a\u0002002\u0006\u0010u\u001a\u000200H\u0016J\b\u0010w\u001a\u00020^H\u0016J\b\u0010x\u001a\u00020^H\u0016J\u0010\u0010y\u001a\u00020^2\u0006\u0010z\u001a\u00020SH\u0016J\b\u0010{\u001a\u00020^H\u0016J\b\u0010|\u001a\u00020^H\u0016J\u0010\u0010}\u001a\u00020^2\u0006\u0010~\u001a\u00020H\u0014J\u0011\u0010\u0001\u001a\u00020^2\u0006\u0010~\u001a\u00020H\u0014J\u0011\u0010\u0001\u001a\u00020^2\u0006\u0010~\u001a\u00020H\u0014J\u0012\u0010\u0001\u001a\u00020^2\u0007\u0010\u0001\u001a\u00020CH\u0014J\u001d\u0010\u0001\u001a\u00020C2\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u0012\u0010\u0001\u001a\u00020^2\u0007\u0010\u0001\u001a\u00020CH\u0016J\u0012\u0010\u0001\u001a\u00020^2\u0007\u0010\u0001\u001a\u00020CH\u0014J\u0012\u0010\u0001\u001a\u00020^2\u0007\u0010\u0001\u001a\u00020CH\u0002J\u0012\u0010\u0001\u001a\u00020^2\u0007\u0010\u0001\u001a\u00020CH\u0002J\u0012\u0010\u0001\u001a\u00020^2\u0007\u0010\u0001\u001a\u00020\u0006H\u0014J\u0012\u0010\u0001\u001a\u00020^2\u0007\u0010\u0001\u001a\u00020\u0006H\u0014J\t\u0010\u0001\u001a\u00020-H\u0016J\u0012\u0010\u0001\u001a\u00020^2\u0007\u0010\u0001\u001a\u00020CH\u0002J\u0017\u0010\u0001\u001a\u00020^2\f\b\u0002\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J\t\u0010\u0001\u001a\u00020^H\u0014J\u001a\u0010\u0001\u001a\u00020^2\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u0001H\u0016J\t\u0010\u0001\u001a\u00020^H\u0016J\t\u0010\u0001\u001a\u00020^H\u0016J\t\u0010\u0001\u001a\u00020^H\u0016J\t\u0010 \u0001\u001a\u00020^H\u0016R\u001f\u0010\b\u001a\u00060\tR\u00020\u00008BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001f\u001a\u00020\u001b8BX\u0002¢\u0006\f\n\u0004\b!\u0010\u0017\u001a\u0004\b \u0010\u001dR\u000e\u0010\"\u001a\u00020#X.¢\u0006\u0002\n\u0000R\u001e\u0010$\u001a\u00020%8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020+X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\u00020-8BX\u0004¢\u0006\u0006\u001a\u0004\b,\u0010.R\u001e\u0010/\u001a\u0002008\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001e\u00105\u001a\u0002008\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00102\"\u0004\b7\u00104R\u001b\u00108\u001a\u0002098BX\u0002¢\u0006\f\n\u0004\b<\u0010\u0017\u001a\u0004\b:\u0010;R\u001b\u0010=\u001a\u00020>8BX\u0002¢\u0006\f\n\u0004\bA\u0010\u0017\u001a\u0004\b?\u0010@R\u001b\u0010B\u001a\u00020C8BX\u0002¢\u0006\f\n\u0004\bF\u0010\u0017\u001a\u0004\bD\u0010ER\u001e\u0010G\u001a\u00020H8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001b\u0010M\u001a\u00020N8BX\u0002¢\u0006\f\n\u0004\bQ\u0010\u0017\u001a\u0004\bO\u0010PR\u001e\u0010R\u001a\u00020S8\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u001b\u0010X\u001a\u00020Y8BX\u0002¢\u0006\f\n\u0004\b\\\u0010\u0017\u001a\u0004\bZ\u0010[¨\u0006£\u0001"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/submitted/UserSubmittedListingScreen;", "Lcom/reddit/frontpage/presentation/MvpBaseScreen;", "Lcom/reddit/frontpage/presentation/listing/submitted/UserSubmittedListingContract$View;", "Lcom/reddit/frontpage/ui/listing/newcard/VisibilityDependent;", "()V", "bundle", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "adapter", "Lcom/reddit/frontpage/presentation/listing/submitted/UserSubmittedListingScreen$Adapter;", "getAdapter", "()Lcom/reddit/frontpage/presentation/listing/submitted/UserSubmittedListingScreen$Adapter;", "adapter$delegate", "Lkotlin/Lazy;", "carouselViewHolder", "Lcom/reddit/frontpage/ui/carousel/CarouselViewHolder;", "changedListener", "Lcom/reddit/frontpage/ui/listing/newcard/VisibilityDependentDelegate$ItemChangedListener;", "contentContainer", "Landroid/widget/FrameLayout;", "getContentContainer", "()Landroid/widget/FrameLayout;", "contentContainer$delegate", "Lcom/reddit/frontpage/util/kotlin/InvalidatableLazy;", "divider", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "emptyContainer", "Landroid/view/ViewStub;", "getEmptyContainer", "()Landroid/view/ViewStub;", "emptyContainer$delegate", "errorContatiner", "getErrorContatiner", "errorContatiner$delegate", "errorMessageView", "Landroid/widget/TextView;", "frontpageSettings", "Lcom/reddit/datalibrary/frontpage/data/feature/settings/FrontpageSettings;", "getFrontpageSettings", "()Lcom/reddit/datalibrary/frontpage/data/feature/settings/FrontpageSettings;", "setFrontpageSettings", "(Lcom/reddit/datalibrary/frontpage/data/feature/settings/FrontpageSettings;)V", "handler", "Landroid/os/Handler;", "isCompact", "", "()Z", "lastClickedPosition", "", "getLastClickedPosition", "()I", "setLastClickedPosition", "(I)V", "lastPlayingPosition", "getLastPlayingPosition", "setLastPlayingPosition", "layoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "getLayoutManager", "()Landroid/support/v7/widget/LinearLayoutManager;", "layoutManager$delegate", "listView", "Landroid/support/v7/widget/RecyclerView;", "getListView", "()Landroid/support/v7/widget/RecyclerView;", "listView$delegate", "loadingSpinner", "Landroid/view/View;", "getLoadingSpinner", "()Landroid/view/View;", "loadingSpinner$delegate", "presenter", "Lcom/reddit/frontpage/presentation/listing/submitted/UserSubmittedListingPresenter;", "getPresenter", "()Lcom/reddit/frontpage/presentation/listing/submitted/UserSubmittedListingPresenter;", "setPresenter", "(Lcom/reddit/frontpage/presentation/listing/submitted/UserSubmittedListingPresenter;)V", "swipeRefreshLayout", "Landroid/support/v4/widget/SwipeRefreshLayout;", "getSwipeRefreshLayout", "()Landroid/support/v4/widget/SwipeRefreshLayout;", "swipeRefreshLayout$delegate", "username", "", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "visibilityDependentDelegate", "Lcom/reddit/frontpage/ui/listing/newcard/VisibilityDependentDelegate;", "getVisibilityDependentDelegate", "()Lcom/reddit/frontpage/ui/listing/newcard/VisibilityDependentDelegate;", "visibilityDependentDelegate$delegate", "applyItemDecoration", "", "recyclerView", "changeVideoPlayerState", "action", "Lkotlin/Function1;", "Lcom/reddit/frontpage/presentation/listing/ui/viewholder/VideoPlayable;", "createItemDecoration", "createV1ScreenViewEvent", "Lcom/reddit/frontpage/commons/analytics/events/v1/ScreenViewEvent;", "getAnalyticsPageType", "getAnalyticsScreenName", "getAnalyticsScreenviewEvent", "Lcom/reddit/frontpage/commons/analytics/events/v2/ScreenviewEventBuilder;", "getLayoutId", "hideLoading", "hideRefreshing", "notifyDiffResult", "diffResult", "Lcom/reddit/frontpage/presentation/listing/common/ViewDiffResult;", "notifyLinkChanged", "position", "notifyLinksInserted", "startPosition", "numItems", "notifyLinksRemoved", "notifyListingChanged", "notifyLoadError", "notifyLoadMoreError", "errorMessage", "notifyOffScreen", "notifyOnScreen", "onActivityPaused", "activity", "Landroid/app/Activity;", "onActivityResumed", "onActivityStopped", "onAttach", "view", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onDetach", "onEmptyInflate", "inflated", "onErrorInflate", "onRestoreInstanceState", "savedInstanceState", "onSaveInstanceState", "outState", "resetScreen", "resizeEmptyView", "empty", "retainPlayersInFeed", "holder", "Lcom/reddit/frontpage/presentation/listing/ui/viewholder/LinkViewHolder;", "sendScreenViewEvent", "setListing", "items", "", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "showContentListView", "showEmptyListView", "showLoading", "showRefreshing", "Adapter", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: UserSubmittedListingScreen.kt */
public final class UserSubmittedListingScreen extends MvpBaseScreen implements View, VisibilityDependent {
    static final /* synthetic */ KProperty[] f40058v = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(UserSubmittedListingScreen.class), "listView", "getListView()Landroid/support/v7/widget/RecyclerView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(UserSubmittedListingScreen.class), "layoutManager", "getLayoutManager()Landroid/support/v7/widget/LinearLayoutManager;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(UserSubmittedListingScreen.class), "swipeRefreshLayout", "getSwipeRefreshLayout()Landroid/support/v4/widget/SwipeRefreshLayout;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(UserSubmittedListingScreen.class), "contentContainer", "getContentContainer()Landroid/widget/FrameLayout;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(UserSubmittedListingScreen.class), "errorContatiner", "getErrorContatiner()Landroid/view/ViewStub;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(UserSubmittedListingScreen.class), "emptyContainer", "getEmptyContainer()Landroid/view/ViewStub;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(UserSubmittedListingScreen.class), "loadingSpinner", "getLoadingSpinner()Landroid/view/View;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(UserSubmittedListingScreen.class), "adapter", "getAdapter()Lcom/reddit/frontpage/presentation/listing/submitted/UserSubmittedListingScreen$Adapter;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(UserSubmittedListingScreen.class), "visibilityDependentDelegate", "getVisibilityDependentDelegate()Lcom/reddit/frontpage/ui/listing/newcard/VisibilityDependentDelegate;"))};
    public static final Companion f40059y = new Companion();
    private final InvalidatableLazy f40060A;
    private final InvalidatableLazy f40061B;
    private final InvalidatableLazy f40062C;
    private final InvalidatableLazy f40063D;
    private final InvalidatableLazy f40064E;
    private final InvalidatableLazy f40065F;
    private TextView f40066G;
    private CarouselViewHolder f40067H;
    private final Lazy f40068M;
    private ItemDecoration f40069N;
    private final ItemChangedListener f40070O;
    private final InvalidatableLazy f40071P;
    private final Handler f40072Q;
    @State
    int lastClickedPosition;
    @State
    int lastPlayingPosition;
    @State
    public String username;
    @Inject
    public UserSubmittedListingPresenter f40073w;
    @Inject
    public FrontpageSettings f40074x;
    private final InvalidatableLazy f40075z;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/submitted/UserSubmittedListingScreen$Companion;", "", "()V", "ANALYTICS_PAGE_TYPE", "", "ANALYTICS_SCREEN_NAME", "FOOTER_COUNT", "", "SOURCE_PAGE", "newInstance", "Lcom/reddit/frontpage/presentation/listing/submitted/UserSubmittedListingScreen;", "username", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: UserSubmittedListingScreen.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#H\u0014J\u0018\u0010%\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0014J\u0018\u0010%\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020)2\u0006\u0010\"\u001a\u00020\u0007H\u0014J\u0010\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020&H\u0014J\u0012\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020/H\u0014J\b\u00100\u001a\u000201H\u0016J\u0010\u00102\u001a\u00020\u00162\u0006\u00103\u001a\u00020\u000eH\u0016J\b\u00104\u001a\u00020\u000eH\u0016J\u0010\u00105\u001a\u0002062\u0006\u00103\u001a\u00020\u000eH\u0016J\b\u00107\u001a\u000208H\u0014J\u001c\u00109\u001a\u00020\u001f2\b\u0010:\u001a\u0004\u0018\u00010;2\b\u0010'\u001a\u0004\u0018\u00010<H\u0014R$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R0\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0010¨\u0006="}, d2 = {"Lcom/reddit/frontpage/presentation/listing/submitted/UserSubmittedListingScreen$Adapter;", "Lcom/reddit/frontpage/ui/listing/adapter/CardLinkAdapter;", "Lcom/reddit/frontpage/presentation/listing/common/LoadMoreListingAdapter;", "context", "Landroid/content/Context;", "(Lcom/reddit/frontpage/presentation/listing/submitted/UserSubmittedListingScreen;Landroid/content/Context;)V", "value", "Lcom/reddit/frontpage/presentation/listing/model/LoadingFooterPresentationModel;", "footer", "getFooter", "()Lcom/reddit/frontpage/presentation/listing/model/LoadingFooterPresentationModel;", "setFooter", "(Lcom/reddit/frontpage/presentation/listing/model/LoadingFooterPresentationModel;)V", "footerIndex", "", "getFooterIndex", "()I", "footerState", "Lcom/reddit/frontpage/presentation/listing/model/FooterState;", "getFooterState", "()Lcom/reddit/frontpage/presentation/listing/model/FooterState;", "", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "listing", "getListing", "()Ljava/util/List;", "setListing", "(Ljava/util/List;)V", "listingItemCount", "getListingItemCount", "bindSubredditCarouselViewHolder", "", "holder", "Lcom/reddit/frontpage/ui/carousel/CarouselViewHolder;", "model", "Lcom/reddit/frontpage/presentation/carousel/model/GeneralCarouselCollectionPresentationModel;", "Lcom/reddit/frontpage/presentation/carousel/model/ICarouselItemPresentationModel;", "bindViewHolder", "Lcom/reddit/frontpage/presentation/listing/ui/viewholder/LinkViewHolder;", "link", "Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;", "Lcom/reddit/frontpage/presentation/listing/ui/viewholder/LoadingFooterViewHolder;", "configure", "viewHolder", "createKarmaListingCarouselViewHolder", "Lcom/reddit/frontpage/ui/listing/adapter/ListingViewHolder;", "parent", "Landroid/view/ViewGroup;", "getCompact", "", "getItem", "position", "getItemCount", "getItemId", "", "getSourcePage", "", "navigateToPostDetail", "linkViewHolder", "Lcom/reddit/frontpage/ui/listing/newcard/LinkViewHolder;", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: UserSubmittedListingScreen.kt */
    private final class Adapter extends CardLinkAdapter implements LoadMoreListingAdapter {
        LoadingFooterPresentationModel f34030a = new LoadingFooterPresentationModel(null, 3);
        List<Listable> f34031b = CollectionsKt__CollectionsKt.m26797c(new Listable[]{(Listable) this.f34030a});
        final /* synthetic */ UserSubmittedListingScreen f34032c;

        protected final void mo6468a(LinkViewHolder linkViewHolder, Link link) {
        }

        protected final String mo6479f() {
            return "profile";
        }

        public Adapter(UserSubmittedListingScreen userSubmittedListingScreen, Context context) {
            Intrinsics.m26847b(context, "context");
            this.f34032c = userSubmittedListingScreen;
            super(context, 1);
        }

        public final /* synthetic */ Object mo4996g(int i) {
            return mo6476c(i);
        }

        public final int mo4926b() {
            return CollectionsKt__CollectionsKt.m26787a(this.f34031b);
        }

        public final FooterState F_() {
            return this.f34030a.f34003a;
        }

        public final int mo4927j() {
            return m34748a() - 1;
        }

        public final boolean mo6477c() {
            return this.f34032c.m40679X();
        }

        public final int m34748a() {
            return this.f34031b.size();
        }

        public final Listable mo6476c(int i) {
            return (Listable) this.f34031b.get(i);
        }

        public final long m34749a(int i) {
            return ((Listable) this.f34031b.get(i)).getUniqueID();
        }

        protected final ListingViewHolder mo6478e(ViewGroup viewGroup) {
            Intrinsics.m26847b(viewGroup, "parent");
            return this.f34032c.f40067H;
        }

        protected final void mo6464a(com.reddit.frontpage.presentation.listing.ui.viewholder.LinkViewHolder linkViewHolder, LinkPresentationModel linkPresentationModel) {
            Intrinsics.m26847b(linkViewHolder, "holder");
            Intrinsics.m26847b(linkPresentationModel, "link");
            super.mo6464a(linkViewHolder, linkPresentationModel);
            Object obj = linkViewHolder.c;
            Intrinsics.m26843a(obj, "holder.itemView");
            obj.setOnClickListener(new C1830x720e5c14(new UserSubmittedListingScreen$Adapter$bindViewHolder$1(this, linkViewHolder)));
            linkViewHolder.m34771M().setClickListener(new UserSubmittedListingScreen$Adapter$bindViewHolder$2(this, linkViewHolder));
            linkViewHolder.m34780a((Function0) new UserSubmittedListingScreen$Adapter$bindViewHolder$3(this, linkViewHolder));
            linkViewHolder.m34781b((Function0) new UserSubmittedListingScreen$Adapter$bindViewHolder$4(this, linkViewHolder));
        }

        protected final void mo6475a(CarouselViewHolder carouselViewHolder, GeneralCarouselCollectionPresentationModel<? extends ICarouselItemPresentationModel> generalCarouselCollectionPresentationModel) {
            Intrinsics.m26847b(carouselViewHolder, "holder");
            Intrinsics.m26847b(generalCarouselCollectionPresentationModel, "model");
            super.mo6475a(carouselViewHolder, (GeneralCarouselCollectionPresentationModel) generalCarouselCollectionPresentationModel);
            carouselViewHolder.m34914a(generalCarouselCollectionPresentationModel, null, null, new C2878x43ed6dc6(this), C2879x43ed6dc7.f36753a, null);
        }

        protected final void mo6463a(com.reddit.frontpage.presentation.listing.ui.viewholder.LinkViewHolder linkViewHolder) {
            Intrinsics.m26847b(linkViewHolder, "viewHolder");
            super.mo6463a(linkViewHolder);
            linkViewHolder.f34045r = new UserSubmittedListingScreen$Adapter$configure$1(this, linkViewHolder);
        }

        protected final void mo6474a(LoadingFooterViewHolder loadingFooterViewHolder, LoadingFooterPresentationModel loadingFooterPresentationModel) {
            Intrinsics.m26847b(loadingFooterViewHolder, "holder");
            Intrinsics.m26847b(loadingFooterPresentationModel, "model");
            super.mo6474a(loadingFooterViewHolder, loadingFooterPresentationModel);
            loadingFooterViewHolder.m34788a((OnClickListener) new UserSubmittedListingScreen$Adapter$bindViewHolder$5(this));
        }
    }

    public static final /* synthetic */ void m40670O() {
    }

    private final RecyclerView m40671P() {
        return (RecyclerView) this.f40075z.mo5678b();
    }

    private final LinearLayoutManager m40672Q() {
        return (LinearLayoutManager) this.f40060A.mo5678b();
    }

    private final SwipeRefreshLayout m40673R() {
        return (SwipeRefreshLayout) this.f40061B.mo5678b();
    }

    private final FrameLayout m40674S() {
        return (FrameLayout) this.f40062C.mo5678b();
    }

    private final ViewStub m40675T() {
        return (ViewStub) this.f40063D.mo5678b();
    }

    private final ViewStub m40676U() {
        return (ViewStub) this.f40064E.mo5678b();
    }

    private final android.view.View m40677V() {
        return (android.view.View) this.f40065F.mo5678b();
    }

    private final Adapter m40678W() {
        return (Adapter) this.f40068M.mo5678b();
    }

    private final VisibilityDependentDelegate m40680Y() {
        return (VisibilityDependentDelegate) this.f40071P.mo5678b();
    }

    protected final void E_() {
    }

    public final String getAnalyticsPageType() {
        return "profile";
    }

    public final String getAnalyticsScreenName() {
        return "profile_posts";
    }

    public final int mo7141s() {
        return C1761R.layout.screen_user_posts;
    }

    public UserSubmittedListingScreen() {
        super();
        Builder a = DaggerUserSubmittedListingComponent.m29303a();
        UserComponent k = FrontpageApplication.m28875k();
        Intrinsics.m26843a((Object) k, "FrontpageApplication.getUserComponent()");
        a.mo4748a(k).mo4749a((View) this).mo4751a(LazyKt.m26777a(new Function0<Activity>() {
            public final /* synthetic */ Object invoke() {
                Activity am_ = this.am_();
                if (am_ == null) {
                    Intrinsics.m26842a();
                }
                return am_;
            }
        })).mo4750a("profile").mo4752a().mo4753a(this);
        this.f40075z = com.reddit.frontpage.util.kotlin.LazyKt.m24085a((BaseScreen) this, (Function0) new UserSubmittedListingScreen$listView$2(this));
        this.f40060A = com.reddit.frontpage.util.kotlin.LazyKt.m24085a((BaseScreen) this, (Function0) new UserSubmittedListingScreen$layoutManager$2(this));
        this.f40061B = com.reddit.frontpage.util.kotlin.LazyKt.m24085a((BaseScreen) this, (Function0) new UserSubmittedListingScreen$swipeRefreshLayout$2(this));
        this.f40062C = com.reddit.frontpage.util.kotlin.LazyKt.m24085a((BaseScreen) this, (Function0) new UserSubmittedListingScreen$contentContainer$2(this));
        this.f40063D = com.reddit.frontpage.util.kotlin.LazyKt.m24085a((BaseScreen) this, (Function0) new UserSubmittedListingScreen$errorContatiner$2(this));
        this.f40064E = com.reddit.frontpage.util.kotlin.LazyKt.m24085a((BaseScreen) this, (Function0) new UserSubmittedListingScreen$emptyContainer$2(this));
        this.f40065F = com.reddit.frontpage.util.kotlin.LazyKt.m24085a((BaseScreen) this, (Function0) new UserSubmittedListingScreen$loadingSpinner$2(this));
        this.f40068M = LazyKt.m26777a(new UserSubmittedListingScreen$adapter$2(this));
        this.f40070O = new UserSubmittedListingScreen$changedListener$1(this);
        this.f40071P = com.reddit.frontpage.util.kotlin.LazyKt.m24085a((BaseScreen) this, (Function0) new UserSubmittedListingScreen$visibilityDependentDelegate$2(this));
        this.lastClickedPosition = -1;
        this.lastPlayingPosition = -1;
        this.f40072Q = new Handler();
    }

    public UserSubmittedListingScreen(Bundle bundle) {
        Intrinsics.m26847b(bundle, "bundle");
        super(bundle);
        bundle = DaggerUserSubmittedListingComponent.m29303a();
        UserComponent k = FrontpageApplication.m28875k();
        Intrinsics.m26843a((Object) k, "FrontpageApplication.getUserComponent()");
        bundle.mo4748a(k).mo4749a((View) this).mo4751a(LazyKt.m26777a(/* anonymous class already generated */)).mo4750a("profile").mo4752a().mo4753a(this);
        this.f40075z = com.reddit.frontpage.util.kotlin.LazyKt.m24085a((BaseScreen) this, (Function0) new UserSubmittedListingScreen$listView$2(this));
        this.f40060A = com.reddit.frontpage.util.kotlin.LazyKt.m24085a((BaseScreen) this, (Function0) new UserSubmittedListingScreen$layoutManager$2(this));
        this.f40061B = com.reddit.frontpage.util.kotlin.LazyKt.m24085a((BaseScreen) this, (Function0) new UserSubmittedListingScreen$swipeRefreshLayout$2(this));
        this.f40062C = com.reddit.frontpage.util.kotlin.LazyKt.m24085a((BaseScreen) this, (Function0) new UserSubmittedListingScreen$contentContainer$2(this));
        this.f40063D = com.reddit.frontpage.util.kotlin.LazyKt.m24085a((BaseScreen) this, (Function0) new UserSubmittedListingScreen$errorContatiner$2(this));
        this.f40064E = com.reddit.frontpage.util.kotlin.LazyKt.m24085a((BaseScreen) this, (Function0) new UserSubmittedListingScreen$emptyContainer$2(this));
        this.f40065F = com.reddit.frontpage.util.kotlin.LazyKt.m24085a((BaseScreen) this, (Function0) new UserSubmittedListingScreen$loadingSpinner$2(this));
        this.f40068M = LazyKt.m26777a((Function0) new UserSubmittedListingScreen$adapter$2(this));
        this.f40070O = (ItemChangedListener) new UserSubmittedListingScreen$changedListener$1(this);
        this.f40071P = com.reddit.frontpage.util.kotlin.LazyKt.m24085a((BaseScreen) this, (Function0) new UserSubmittedListingScreen$visibilityDependentDelegate$2(this));
        this.lastClickedPosition = -1;
        this.lastPlayingPosition = -1;
        this.f40072Q = new Handler();
    }

    public final UserSubmittedListingPresenter m40712w() {
        UserSubmittedListingPresenter userSubmittedListingPresenter = this.f40073w;
        if (userSubmittedListingPresenter == null) {
            Intrinsics.m26844a("presenter");
        }
        return userSubmittedListingPresenter;
    }

    public final String mo7368a() {
        String str = this.username;
        if (str == null) {
            Intrinsics.m26844a("username");
        }
        return str;
    }

    private final boolean m40679X() {
        FrontpageSettings frontpageSettings = this.f40074x;
        if (frontpageSettings == null) {
            Intrinsics.m26844a("frontpageSettings");
        }
        return frontpageSettings.c();
    }

    public final android.view.View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.m26847b(layoutInflater, "inflater");
        Intrinsics.m26847b(viewGroup, "container");
        super.mo7139a(layoutInflater, viewGroup);
        Activity d = Util.m24014d(viewGroup.getContext());
        int i = Util.m23955a(d).x;
        Object inflate = layoutInflater.inflate(C1761R.layout.layout_carousel, null, false);
        Intrinsics.m26843a(inflate, "inflater.inflate(R.layou…ut_carousel, null, false)");
        this.f40067H = new CarouselViewHolder(inflate, i, CarouselItemLayout.SMALL, null, 24);
        layoutInflater = m40671P();
        ItemDecoration itemDecoration = this.f40069N;
        if (itemDecoration != null) {
            layoutInflater.removeItemDecoration(itemDecoration);
        }
        if (am_() != null) {
            boolean X = m40679X();
            DecorationInclusionStrategy a = DividerItemDecoration.m30091a();
            Activity am_ = am_();
            if (am_ == null) {
                Intrinsics.m26842a();
            }
            Object a2 = DividerItemDecoration.m30093a(am_, X, a);
            Intrinsics.m26843a(a2, "DividerItemDecoration.cr…tivity!!, size, strategy)");
            this.f40069N = (ItemDecoration) a2;
            ((RecyclerView) ((android.view.View) layoutInflater).findViewById(C1761R.id.link_list)).addItemDecoration(this.f40069N);
        }
        layoutInflater.setLayoutManager(m40672Q());
        layoutInflater.setAdapter(m40678W());
        layoutInflater.addOnChildAttachStateChangeListener(new UserSubmittedListingScreen$onCreateView$1$1(layoutInflater));
        LinearLayoutManager Q = m40672Q();
        LoadMoreListingAdapter W = m40678W();
        UserSubmittedListingPresenter userSubmittedListingPresenter = this.f40073w;
        if (userSubmittedListingPresenter == null) {
            Intrinsics.m26844a("presenter");
        }
        layoutInflater.addOnScrollListener(new LoadMoreOnScrollListener(Q, W, new UserSubmittedListingScreen$onCreateView$1$2(userSubmittedListingPresenter)));
        layoutInflater.addOnScrollListener(new AutoplayGifsOnScrollListener(m40672Q(), this.f40070O));
        Util.m23970a(m40673R());
        m40673R().setOnRefreshListener(new UserSubmittedListingScreen$onCreateView$2(this));
        m40675T().setOnInflateListener(new UserSubmittedListingScreen$onCreateView$3(this));
        m40676U().setOnInflateListener(new UserSubmittedListingScreen$onCreateView$4(this));
        m40677V().setBackground(AnimUtil.m23637a(d));
        Object obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        return obj;
    }

    public final void mo6987a(android.view.View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6987a(view);
        m40671P().setAdapter(null);
        this.I.m24081a();
    }

    protected final void mo6992b(android.view.View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6992b(view);
        view = this.f40073w;
        if (view == null) {
            Intrinsics.m26844a("presenter");
        }
        view.attach();
        ap();
    }

    protected final void mo6993c(android.view.View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6993c(view);
        aq();
        if (this.f40073w == null) {
            Intrinsics.m26844a("presenter");
        }
        UserSubmittedListingPresenter.m37190c();
        m40680Y().m23493a(false);
        view = this.f40073w;
        if (view == null) {
            Intrinsics.m26844a("presenter");
        }
        view.detach();
    }

    protected final void m40706c(Activity activity) {
        Intrinsics.m26847b(activity, "activity");
        super.c(activity);
        if (T_() != null) {
            m40683a((Function1) UserSubmittedListingScreen$onActivityPaused$1$1.f36769a);
        }
    }

    protected final void mo7209b(Activity activity) {
        Intrinsics.m26847b(activity, "activity");
        super.mo7209b(activity);
        if (T_() != null) {
            activity = m40678W().m30232l();
            if (activity >= null) {
                m40678W().d(activity);
            }
            m40683a((Function1) UserSubmittedListingScreen$onActivityResumed$1$1.f36770a);
        }
        this.f40072Q.postDelayed(new UserSubmittedListingScreen$onActivityResumed$2(this), 500);
    }

    protected final void m40710d(Activity activity) {
        Intrinsics.m26847b(activity, "activity");
        super.d(activity);
        if (v_() != null) {
            aq();
        }
    }

    private final void m40683a(Function1<? super VideoPlayable, Unit> function1) {
        int k = m40678W().m30230k();
        if (k >= 0) {
            ViewHolder findViewHolderForAdapterPosition = m40671P().findViewHolderForAdapterPosition(k);
            if (findViewHolderForAdapterPosition instanceof VideoPlayable) {
                function1.mo6492a(findViewHolderForAdapterPosition);
            }
        }
    }

    protected final void mo6991b(Bundle bundle) {
        Intrinsics.m26847b(bundle, "outState");
        this.lastClickedPosition = m40678W().m30232l();
        this.lastPlayingPosition = m40678W().m30230k();
        super.mo6991b(bundle);
    }

    protected final void mo7199c(Bundle bundle) {
        Intrinsics.m26847b(bundle, "savedInstanceState");
        super.mo7199c(bundle);
        m40678W().m30228i(this.lastClickedPosition);
        m40678W().m30229j(this.lastPlayingPosition);
    }

    public final boolean mo7200K() {
        Object obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        RecyclerView recyclerView = (RecyclerView) obj.findViewById(C1761R.id.link_list);
        if (recyclerView != null) {
            LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
            } else if (!ListUtil.m23810a((LinearLayoutManager) layoutManager)) {
                recyclerView.smoothScrollToPosition(0);
            }
        }
        return false;
    }

    public final ScreenviewEventBuilder getAnalyticsScreenviewEvent() {
        UserSubmittedListingPresenter userSubmittedListingPresenter = this.f40073w;
        if (userSubmittedListingPresenter == null) {
            Intrinsics.m26844a("presenter");
        }
        ScreenviewEventBuilder a = AppAnalytics.m21877n().m21927a("profile");
        long size = (long) userSubmittedListingPresenter.f36737c.size();
        Iterable<com.reddit.frontpage.domain.model.Link> iterable = userSubmittedListingPresenter.f36737c;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (com.reddit.frontpage.domain.model.Link kindWithId : iterable) {
            arrayList.add(kindWithId.getKindWithId());
        }
        a.m21926a(size, (List) arrayList, null, null);
        if (userSubmittedListingPresenter.f36736b != null) {
            a.m21930b(userSubmittedListingPresenter.f36736b.getId(), userSubmittedListingPresenter.f36736b.getUsername());
            if (userSubmittedListingPresenter.f36736b.getSubreddit() != null) {
                a.m21929a(userSubmittedListingPresenter.f36736b.getSubreddit().getKindWithId(), userSubmittedListingPresenter.f36736b.getSubreddit().getDisplayName());
            }
        }
        return a;
    }

    public final ScreenViewEvent mo7203N() {
        Object N = super.mo7203N();
        UserSubmittedListingPresenter userSubmittedListingPresenter = this.f40073w;
        if (userSubmittedListingPresenter == null) {
            Intrinsics.m26844a("presenter");
        }
        Intrinsics.m26843a(N, "event");
        Intrinsics.m26847b(N, "event");
        ((ScreenViewPayload) N.payload).target_type = "account";
        ((ScreenViewPayload) N.payload).target_name = userSubmittedListingPresenter.f36739e.mo7368a();
        ScreenViewPayload screenViewPayload = (ScreenViewPayload) N.payload;
        Object b = SessionManager.b();
        Intrinsics.m26843a(b, "SessionManager.getInstance()");
        screenViewPayload.user_name = b.c().getUsername();
        AccountStorage accountStorage = AccountStorage.b;
        b = SessionManager.b();
        Intrinsics.m26843a(b, "SessionManager.getInstance()");
        Account account = (Account) accountStorage.a(b.c().getUsername());
        if (account != null) {
            ((ScreenViewPayload) N.payload).user_id36 = account.getId();
            ((ScreenViewPayload) N.payload).is_contributor = account.subreddit != null;
        }
        return N;
    }

    public final void mo7330b(List<? extends Listable> list) {
        Intrinsics.m26847b(list, "items");
        Adapter W = m40678W();
        list = CollectionsKt___CollectionsKt.m41428c(list);
        Intrinsics.m26847b(list, "value");
        list.add(W.f34030a);
        W.f34031b = list;
    }

    public final void mo7335x() {
        m40678W().e();
    }

    public final void mo7328b(int i) {
        m40678W().d(i);
    }

    public final void mo7323a(int i, int i2) {
        m40678W().c(i, i2);
    }

    public final void mo7322a(int i) {
        m40678W().d(i, 1);
    }

    public final void mo7336y() {
        ViewsKt.m24105b(m40674S());
        ViewsKt.m24107c(m40675T());
        ViewsKt.m24109d(m40676U());
        TextView textView = this.f40066G;
        if (textView == null) {
            Intrinsics.m26844a("errorMessageView");
        }
        Activity am_ = am_();
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        textView.setText(am_.getString(C1761R.string.error_data_load));
    }

    public final void mo7369b() {
        ViewsKt.m24109d(m40675T());
        ViewsKt.m24107c(m40674S());
        SwipeRefreshLayout R = m40673R();
        R.setRefreshing(false);
        R.setEnabled(false);
        ViewsKt.m24107c(m40677V());
        ViewsKt.m24109d(m40676U());
    }

    public final void mo7370c() {
        ViewsKt.m24109d(m40677V());
    }

    public final void mo7371d() {
        if (!m40673R().b()) {
            m40673R().setRefreshing(true);
        }
    }

    public final void O_() {
        if (m40673R().b() && v_()) {
            m40673R().setRefreshing(false);
            m40671P().stopScroll();
        }
    }

    public final void P_() {
        ViewsKt.m24107c(m40674S());
        m40673R().setEnabled(true);
        ViewsKt.m24109d(m40677V());
        ViewsKt.m24109d(m40676U());
    }

    public final void Q_() {
        ViewsKt.m24109d(m40674S());
        m40673R().setEnabled(true);
        ViewsKt.m24109d(m40677V());
        m40676U().setLayoutResource(C1761R.layout.listing_empty);
        ViewsKt.m24107c(m40676U());
    }

    public final void ap() {
        if (v_()) {
            m40680Y().m23493a(true);
        }
    }

    public final void aq() {
        if (this.f40073w == null) {
            Intrinsics.m26844a("presenter");
        }
        UserSubmittedListingPresenter.m37190c();
        if (T_() != null) {
            Object obj = this.K;
            Intrinsics.m26843a(obj, "rootView");
            ((RecyclerView) obj.findViewById(C1761R.id.link_list)).stopScroll();
            m40680Y().m23493a(false);
        }
    }

    public final void mo7324a(ViewDiffResult viewDiffResult) {
        Intrinsics.m26847b(viewDiffResult, "diffResult");
        viewDiffResult.f20594a.a(m40678W());
    }

    static /* synthetic */ void m40681a(UserSubmittedListingScreen userSubmittedListingScreen) {
        Iterator it = new IntRange(userSubmittedListingScreen.m40672Q().k(), userSubmittedListingScreen.m40672Q().m()).iterator();
        while (it.hasNext()) {
            Object findViewHolderForAdapterPosition = userSubmittedListingScreen.m40671P().findViewHolderForAdapterPosition(((IntIterator) it).mo6663a());
            if ((findViewHolderForAdapterPosition instanceof VideoCardLinkViewHolder) && (Intrinsics.m26845a(findViewHolderForAdapterPosition, null) ^ 1) != 0) {
                ((VideoCardLinkViewHolder) findViewHolderForAdapterPosition).m37655I();
            }
        }
    }

    public static final /* synthetic */ void m40682a(UserSubmittedListingScreen userSubmittedListingScreen, android.view.View view) {
        Object obj = (TextView) view.findViewById(C1761R.id.error_message);
        Intrinsics.m26843a(obj, "inflated.error_message");
        userSubmittedListingScreen.f40066G = obj;
        view.setOnClickListener((OnClickListener) new C1831x3310bcff(new UserSubmittedListingScreen$onErrorInflate$1(userSubmittedListingScreen)));
    }

    public static final /* synthetic */ void m40684b(UserSubmittedListingScreen userSubmittedListingScreen, android.view.View view) {
        Object obj = userSubmittedListingScreen.K;
        Intrinsics.m26843a(obj, "rootView");
        if (obj.getHeight() == 0) {
            obj = userSubmittedListingScreen.K;
            Intrinsics.m26843a(obj, "rootView");
            obj.getViewTreeObserver().addOnGlobalLayoutListener(new UserSubmittedListingScreen$onEmptyInflate$1(userSubmittedListingScreen, view));
        }
    }
}
