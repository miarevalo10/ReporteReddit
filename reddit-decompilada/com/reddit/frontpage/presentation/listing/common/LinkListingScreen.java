package com.reddit.frontpage.presentation.listing.common;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.evernote.android.state.State;
import com.livefront.bridge.Bridge;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.commons.analytics.events.v1.ScrollEvent.ScrollPayload;
import com.reddit.frontpage.commons.analytics.listener.AnalyticsOnScrollListener;
import com.reddit.frontpage.domain.repository.PreferenceRepository;
import com.reddit.frontpage.presentation.MvpBaseScreen;
import com.reddit.frontpage.presentation.analytics.ListItemViewAttachListener;
import com.reddit.frontpage.presentation.listing.model.ListingViewMode;
import com.reddit.frontpage.presentation.listing.ui.viewholder.LinkViewHolder;
import com.reddit.frontpage.presentation.listing.ui.viewholder.VideoCardLinkViewHolder;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.listener.AutoplayGifsOnScrollListener;
import com.reddit.frontpage.ui.listing.DecorationInclusionStrategy;
import com.reddit.frontpage.ui.listing.DividerItemDecoration;
import com.reddit.frontpage.ui.listing.adapter.CardLinkAdapter;
import com.reddit.frontpage.ui.listing.adapter.ads.AdVisibilityTracker;
import com.reddit.frontpage.ui.listing.newcard.VisibilityDependent;
import com.reddit.frontpage.ui.listing.newcard.VisibilityDependentDelegate;
import com.reddit.frontpage.ui.listing.newcard.VisibilityDependentDelegate.ItemChangedListener;
import com.reddit.frontpage.util.AnimUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.InvalidatableLazy;
import com.reddit.frontpage.util.kotlin.LazyKt;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import com.reddit.frontpage.widgets.RefreshPill;
import java.util.ArrayList;
import java.util.Iterator;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u00012\u00020\u00012\u00020\u0002:\u0006\u0001\u0001\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010p\u001a\u00020qH\u0004J\b\u0010r\u001a\u00020\u001bH\u0002J\u0010\u0010s\u001a\u00020q2\u0006\u0010t\u001a\u00020uH\u0014J\n\u0010v\u001a\u0004\u0018\u00010wH\u0014J\b\u0010x\u001a\u00020\u0017H$J\u0018\u0010y\u001a\u00020q2\u0006\u0010z\u001a\u00020F2\u0006\u0010{\u001a\u00020SH\u0002J\b\u0010|\u001a\u00020qH\u0016J\b\u0010}\u001a\u00020qH\u0016J\u0011\u0010~\u001a\u00020q2\u0007\u0010\u001a\u00030\u0001H\u0014J\u0012\u0010\u0001\u001a\u00020q2\u0007\u0010\u001a\u00030\u0001H\u0014J\u0012\u0010\u0001\u001a\u00020q2\u0007\u0010\u001a\u00030\u0001H\u0014J\u0011\u0010\u0001\u001a\u00020q2\u0006\u0010{\u001a\u00020SH\u0014J\u001d\u0010\u0001\u001a\u00020S2\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u0011\u0010\u0001\u001a\u00020q2\u0006\u0010{\u001a\u00020SH\u0016J\u0011\u0010\u0001\u001a\u00020q2\u0006\u0010{\u001a\u00020SH\u0014J\u0012\u0010\u0001\u001a\u00020q2\u0007\u0010\u0001\u001a\u00020SH\u0014J\u0012\u0010\u0001\u001a\u00020q2\u0007\u0010\u0001\u001a\u00020SH\u0014J\u001b\u0010\u0001\u001a\u00020q2\u0006\u0010{\u001a\u00020S2\b\u0010\u0001\u001a\u00030\u0001H\u0014J\u001b\u0010\u0001\u001a\u00020q2\u0006\u0010{\u001a\u00020S2\b\u0010\u0001\u001a\u00030\u0001H\u0014J\u0015\u0010\u0001\u001a\u00020q2\f\b\u0002\u0010\u0001\u001a\u0005\u0018\u00010\u0001J\t\u0010\u0001\u001a\u00020qH\u0004R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¤\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118FX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00178DX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001b\u0010 \u001a\u00020!8FX\u0002¢\u0006\f\n\u0004\b$\u0010\u0015\u001a\u0004\b\"\u0010#R\u001b\u0010%\u001a\u00020!8FX\u0002¢\u0006\f\n\u0004\b'\u0010\u0015\u001a\u0004\b&\u0010#R\u001a\u0010(\u001a\u00020)X.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010.\u001a\u00020/8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0014\u00104\u001a\u0002058DX\u0004¢\u0006\u0006\u001a\u0004\b4\u00106R\u001e\u00107\u001a\u0002088\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001e\u0010=\u001a\u0002088\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010:\"\u0004\b?\u0010<R\u001b\u0010@\u001a\u00020A8DX\u0002¢\u0006\f\n\u0004\bD\u0010\u0015\u001a\u0004\bB\u0010CR\u001b\u0010E\u001a\u00020F8FX\u0002¢\u0006\f\n\u0004\bI\u0010\u0015\u001a\u0004\bG\u0010HR\u0012\u0010J\u001a\u00060KR\u00020\u0000X.¢\u0006\u0002\n\u0000R\u001e\u0010L\u001a\u00020M8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001b\u0010R\u001a\u00020S8FX\u0002¢\u0006\f\n\u0004\bV\u0010\u0015\u001a\u0004\bT\u0010UR\u001e\u0010W\u001a\u00020X8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u001b\u0010]\u001a\u00020^8DX\u0002¢\u0006\f\n\u0004\ba\u0010\u0015\u001a\u0004\b_\u0010`R\u001b\u0010b\u001a\u00020c8FX\u0002¢\u0006\f\n\u0004\bf\u0010\u0015\u001a\u0004\bd\u0010eR\u001c\u0010g\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010\u0019\"\u0004\bi\u0010jR\u001b\u0010k\u001a\u00020l8BX\u0002¢\u0006\f\n\u0004\bo\u0010\u0015\u001a\u0004\bm\u0010n¨\u0006\u0001"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/common/LinkListingScreen;", "Lcom/reddit/frontpage/presentation/MvpBaseScreen;", "Lcom/reddit/frontpage/ui/listing/newcard/VisibilityDependent;", "()V", "adVisibilityTracker", "Lcom/reddit/frontpage/ui/listing/adapter/ads/AdVisibilityTracker;", "getAdVisibilityTracker", "()Lcom/reddit/frontpage/ui/listing/adapter/ads/AdVisibilityTracker;", "setAdVisibilityTracker", "(Lcom/reddit/frontpage/ui/listing/adapter/ads/AdVisibilityTracker;)V", "adapter", "Lcom/reddit/frontpage/ui/listing/adapter/CardLinkAdapter;", "getAdapter", "()Lcom/reddit/frontpage/ui/listing/adapter/CardLinkAdapter;", "changedListener", "Lcom/reddit/frontpage/ui/listing/newcard/VisibilityDependentDelegate$ItemChangedListener;", "contentContainer", "Landroid/widget/FrameLayout;", "getContentContainer", "()Landroid/widget/FrameLayout;", "contentContainer$delegate", "Lcom/reddit/frontpage/util/kotlin/InvalidatableLazy;", "defaultViewMode", "Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;", "getDefaultViewMode", "()Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;", "divider", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getDivider", "()Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "setDivider", "(Landroid/support/v7/widget/RecyclerView$ItemDecoration;)V", "emptyContainer", "Landroid/view/ViewStub;", "getEmptyContainer", "()Landroid/view/ViewStub;", "emptyContainer$delegate", "errorContainer", "getErrorContainer", "errorContainer$delegate", "errorMessageView", "Landroid/widget/TextView;", "getErrorMessageView", "()Landroid/widget/TextView;", "setErrorMessageView", "(Landroid/widget/TextView;)V", "frontpageSettings", "Lcom/reddit/datalibrary/frontpage/data/feature/settings/FrontpageSettings;", "getFrontpageSettings", "()Lcom/reddit/datalibrary/frontpage/data/feature/settings/FrontpageSettings;", "setFrontpageSettings", "(Lcom/reddit/datalibrary/frontpage/data/feature/settings/FrontpageSettings;)V", "isCompact", "", "()Z", "lastClickedPosition", "", "getLastClickedPosition", "()I", "setLastClickedPosition", "(I)V", "lastPlayingPosition", "getLastPlayingPosition", "setLastPlayingPosition", "layoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "getLayoutManager", "()Landroid/support/v7/widget/LinearLayoutManager;", "layoutManager$delegate", "listView", "Landroid/support/v7/widget/RecyclerView;", "getListView", "()Landroid/support/v7/widget/RecyclerView;", "listView$delegate", "listingInfoOnScrollListener", "Lcom/reddit/frontpage/presentation/listing/common/LinkListingScreen$ListingInfoOnScrollListener;", "listingScreenActions", "Lcom/reddit/frontpage/presentation/listing/common/ListingScreenActions;", "getListingScreenActions", "()Lcom/reddit/frontpage/presentation/listing/common/ListingScreenActions;", "setListingScreenActions", "(Lcom/reddit/frontpage/presentation/listing/common/ListingScreenActions;)V", "loadingSpinner", "Landroid/view/View;", "getLoadingSpinner", "()Landroid/view/View;", "loadingSpinner$delegate", "preferenceRepository", "Lcom/reddit/frontpage/domain/repository/PreferenceRepository;", "getPreferenceRepository", "()Lcom/reddit/frontpage/domain/repository/PreferenceRepository;", "setPreferenceRepository", "(Lcom/reddit/frontpage/domain/repository/PreferenceRepository;)V", "refreshPill", "Lcom/reddit/frontpage/widgets/RefreshPill;", "getRefreshPill", "()Lcom/reddit/frontpage/widgets/RefreshPill;", "refreshPill$delegate", "swipeRefreshLayout", "Landroid/support/v4/widget/SwipeRefreshLayout;", "getSwipeRefreshLayout", "()Landroid/support/v4/widget/SwipeRefreshLayout;", "swipeRefreshLayout$delegate", "viewMode", "getViewMode", "setViewMode", "(Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;)V", "visibilityDependentDelegate", "Lcom/reddit/frontpage/ui/listing/newcard/VisibilityDependentDelegate;", "getVisibilityDependentDelegate", "()Lcom/reddit/frontpage/ui/listing/newcard/VisibilityDependentDelegate;", "visibilityDependentDelegate$delegate", "applyItemDecoration", "", "createItemDecoration", "customizeDecorationStrategy", "strategy", "Lcom/reddit/frontpage/ui/listing/DecorationInclusionStrategy;", "getScreenListingName", "", "getViewModePreference", "notifyListItemViewAttachListener", "recyclerView", "view", "notifyOffScreen", "notifyOnScreen", "onActivityPaused", "activity", "Landroid/app/Activity;", "onActivityResumed", "onActivityStopped", "onAttach", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onDetach", "onEmptyInflated", "inflated", "onErrorInflated", "onRestoreViewState", "savedViewState", "Landroid/os/Bundle;", "onSaveViewState", "outState", "retainPlayersInFeed", "holder", "Lcom/reddit/frontpage/presentation/listing/ui/viewholder/LinkViewHolder;", "sendScrollAnalytics", "Companion", "ListingInfoOnScrollListener", "ViewedInfo", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LinkListingScreen.kt */
public abstract class LinkListingScreen extends MvpBaseScreen implements VisibilityDependent {
    static final /* synthetic */ KProperty[] f40031A = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(LinkListingScreen.class), "listView", "getListView()Landroid/support/v7/widget/RecyclerView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(LinkListingScreen.class), "layoutManager", "getLayoutManager()Landroid/support/v7/widget/LinearLayoutManager;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(LinkListingScreen.class), "refreshPill", "getRefreshPill()Lcom/reddit/frontpage/widgets/RefreshPill;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(LinkListingScreen.class), "swipeRefreshLayout", "getSwipeRefreshLayout()Landroid/support/v4/widget/SwipeRefreshLayout;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(LinkListingScreen.class), "contentContainer", "getContentContainer()Landroid/widget/FrameLayout;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(LinkListingScreen.class), "errorContainer", "getErrorContainer()Landroid/view/ViewStub;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(LinkListingScreen.class), "emptyContainer", "getEmptyContainer()Landroid/view/ViewStub;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(LinkListingScreen.class), "loadingSpinner", "getLoadingSpinner()Landroid/view/View;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(LinkListingScreen.class), "visibilityDependentDelegate", "getVisibilityDependentDelegate()Lcom/reddit/frontpage/ui/listing/newcard/VisibilityDependentDelegate;"))};
    public static final Companion f40032H = new Companion();
    @Inject
    public FrontpageSettings f40033B;
    @Inject
    public PreferenceRepository f40034C;
    @Inject
    public ListingScreenActions f40035D;
    @Inject
    public AdVisibilityTracker f40036E;
    public TextView f40037F;
    protected ListingViewMode f40038G;
    private final InvalidatableLazy f40039M = LazyKt.m24085a((BaseScreen) this, (Function0) new LinkListingScreen$errorContainer$2(this));
    private final InvalidatableLazy f40040N = LazyKt.m24085a((BaseScreen) this, (Function0) new LinkListingScreen$emptyContainer$2(this));
    private final InvalidatableLazy f40041O = LazyKt.m24085a((BaseScreen) this, (Function0) new LinkListingScreen$loadingSpinner$2(this));
    private ItemDecoration f40042P;
    private final ItemChangedListener f40043Q = new LinkListingScreen$changedListener$1(this);
    private final InvalidatableLazy f40044R = LazyKt.m24085a((BaseScreen) this, (Function0) new LinkListingScreen$visibilityDependentDelegate$2(this));
    private ListingInfoOnScrollListener f40045S;
    @State
    int lastClickedPosition = -1;
    @State
    int lastPlayingPosition = -1;
    private final InvalidatableLazy f40046v = LazyKt.m24085a((BaseScreen) this, (Function0) new LinkListingScreen$listView$2(this));
    private final InvalidatableLazy f40047w = LazyKt.m24085a((BaseScreen) this, (Function0) new LinkListingScreen$layoutManager$2(this));
    private final InvalidatableLazy f40048x = LazyKt.m24085a((BaseScreen) this, (Function0) new LinkListingScreen$refreshPill$2(this));
    private final InvalidatableLazy f40049y = LazyKt.m24085a((BaseScreen) this, (Function0) new LinkListingScreen$swipeRefreshLayout$2(this));
    private final InvalidatableLazy f40050z = LazyKt.m24085a((BaseScreen) this, (Function0) new LinkListingScreen$contentContainer$2(this));

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/common/LinkListingScreen$Companion;", "", "()V", "CONTROL_NAME_REFRESH_PILL", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: LinkListingScreen.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J)\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/common/LinkListingScreen$ViewedInfo;", "", "id", "", "start", "", "end", "(Ljava/lang/String;JJ)V", "getEnd", "()J", "setEnd", "(J)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getStart", "setStart", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: LinkListingScreen.kt */
    private static final class ViewedInfo {
        String f20568a;
        long f20569b;
        long f20570c;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ViewedInfo) {
                ViewedInfo viewedInfo = (ViewedInfo) obj;
                if (Intrinsics.m26845a(this.f20568a, viewedInfo.f20568a)) {
                    if (this.f20569b == viewedInfo.f20569b) {
                        if (this.f20570c == viewedInfo.f20570c) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public final int hashCode() {
            String str = this.f20568a;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            long j = this.f20569b;
            hashCode = (hashCode + ((int) (j ^ (j >>> 32)))) * 31;
            j = this.f20570c;
            return hashCode + ((int) (j ^ (j >>> 32)));
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("ViewedInfo(id=");
            stringBuilder.append(this.f20568a);
            stringBuilder.append(", start=");
            stringBuilder.append(this.f20569b);
            stringBuilder.append(", end=");
            stringBuilder.append(this.f20570c);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        private ViewedInfo() {
            this.f20568a = null;
            this.f20569b = 0;
            this.f20570c = 0;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/common/LinkListingScreen$ListingInfoOnScrollListener;", "Lcom/reddit/frontpage/commons/analytics/listener/AnalyticsOnScrollListener;", "Landroid/support/v7/widget/RecyclerView$OnChildAttachStateChangeListener;", "screenName", "", "(Lcom/reddit/frontpage/presentation/listing/common/LinkListingScreen;Ljava/lang/String;)V", "seenLinks", "Ljava/util/ArrayList;", "Lcom/reddit/frontpage/presentation/listing/common/LinkListingScreen$ViewedInfo;", "modifyPayload", "", "payload", "Lcom/reddit/frontpage/commons/analytics/events/v1/ScrollEvent$ScrollPayload;", "onChildViewAttachedToWindow", "view", "Landroid/view/View;", "onChildViewDetachedFromWindow", "sendAnalytics", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: LinkListingScreen.kt */
    private final class ListingInfoOnScrollListener extends AnalyticsOnScrollListener implements OnChildAttachStateChangeListener {
        final /* synthetic */ LinkListingScreen f33879b;
        private final ArrayList<ViewedInfo> f33880c = new ArrayList();

        public ListingInfoOnScrollListener(LinkListingScreen linkListingScreen, String str) {
            Intrinsics.m26847b(str, "screenName");
            this.f33879b = linkListingScreen;
            super(str);
        }

        public final void mo6460a(RecyclerView recyclerView) {
            Intrinsics.m26847b(recyclerView, "recyclerView");
            super.mo6460a(recyclerView);
            this.f33880c.clear();
        }

        protected final void mo6461a(ScrollPayload scrollPayload) {
            Intrinsics.m26847b(scrollPayload, "payload");
            scrollPayload.sr_name = this.f33879b.mo7618O();
            scrollPayload.posts_seen = new ArrayList(this.f33880c.size());
            scrollPayload.posts_seen_start_time = new ArrayList(this.f33880c.size());
            scrollPayload.posts_seen_end_time = new ArrayList(this.f33880c.size());
            long currentTimeMillis = System.currentTimeMillis();
            int size = this.f33880c.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                ViewedInfo viewedInfo = (ViewedInfo) this.f33880c.get(size);
                if (viewedInfo.f20570c != 0) {
                    break;
                }
                viewedInfo.f20570c = currentTimeMillis;
            }
            Iterator it = this.f33880c.iterator();
            while (it.hasNext()) {
                ViewedInfo viewedInfo2 = (ViewedInfo) it.next();
                scrollPayload.posts_seen.add(viewedInfo2.f20568a);
                scrollPayload.posts_seen_start_time.add(Long.valueOf(viewedInfo2.f20569b));
                scrollPayload.posts_seen_end_time.add(Long.valueOf(viewedInfo2.f20570c));
            }
        }

        public final void m34695a(View view) {
            Intrinsics.m26847b(view, "view");
            view = view.getTag(538378531);
            if (!(view instanceof String)) {
                view = null;
            }
            String str = (String) view;
            if (!TextUtils.isEmpty(str)) {
                ViewedInfo viewedInfo = new ViewedInfo();
                viewedInfo.f20568a = str;
                viewedInfo.f20569b = System.currentTimeMillis();
                this.f33880c.add(viewedInfo);
            }
        }

        public final void m34697b(View view) {
            Intrinsics.m26847b(view, "view");
            if (this.f33879b.v_()) {
                ViewedInfo viewedInfo;
                view = view.getTag(538378531);
                if (!(view instanceof String)) {
                    view = null;
                }
                String str = (String) view;
                int size = this.f33880c.size();
                do {
                    size--;
                    if (size >= 0) {
                        viewedInfo = (ViewedInfo) this.f33880c.get(size);
                    }
                } while (!TextUtils.equals(viewedInfo.f20568a, str));
                viewedInfo.f20570c = System.currentTimeMillis();
            }
        }
    }

    private final VisibilityDependentDelegate mo7641w() {
        return (VisibilityDependentDelegate) this.f40044R.mo5678b();
    }

    public abstract CardLinkAdapter mo7617M();

    public String mo7618O() {
        return null;
    }

    public void mo7634a(DecorationInclusionStrategy decorationInclusionStrategy) {
        Intrinsics.m26847b(decorationInclusionStrategy, "strategy");
    }

    public abstract ListingViewMode ab();

    public final RecyclerView af() {
        return (RecyclerView) this.f40046v.mo5678b();
    }

    protected final LinearLayoutManager ag() {
        return (LinearLayoutManager) this.f40047w.mo5678b();
    }

    protected final RefreshPill ah() {
        return (RefreshPill) this.f40048x.mo5678b();
    }

    public final SwipeRefreshLayout ai() {
        return (SwipeRefreshLayout) this.f40049y.mo5678b();
    }

    public final FrameLayout aj() {
        return (FrameLayout) this.f40050z.mo5678b();
    }

    public final ViewStub ak() {
        return (ViewStub) this.f40039M.mo5678b();
    }

    public final ViewStub al() {
        return (ViewStub) this.f40040N.mo5678b();
    }

    public final View am() {
        return (View) this.f40041O.mo5678b();
    }

    public void mo7640g(View view) {
        Intrinsics.m26847b(view, "inflated");
    }

    public LinkListingScreen() {
        super();
    }

    public final PreferenceRepository ad() {
        PreferenceRepository preferenceRepository = this.f40034C;
        if (preferenceRepository == null) {
            Intrinsics.m26844a("preferenceRepository");
        }
        return preferenceRepository;
    }

    public final ListingScreenActions ae() {
        ListingScreenActions listingScreenActions = this.f40035D;
        if (listingScreenActions == null) {
            Intrinsics.m26844a("listingScreenActions");
        }
        return listingScreenActions;
    }

    protected final boolean an() {
        if (this.f40038G != null) {
            return Intrinsics.m26845a(this.f40038G, ListingViewMode.f20613b);
        }
        return Intrinsics.m26845a(ao(), ListingViewMode.f20613b);
    }

    protected final ListingViewMode ao() {
        PreferenceRepository preferenceRepository = this.f40034C;
        if (preferenceRepository == null) {
            Intrinsics.m26844a("preferenceRepository");
        }
        Object blockingGet = preferenceRepository.m22477b("listingViewMode.globalDefault", ListingViewMode.f20612a).blockingGet();
        Intrinsics.m26843a(blockingGet, "preferenceRepository\n   …D)\n        .blockingGet()");
        return (ListingViewMode) blockingGet;
    }

    public View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.m26847b(layoutInflater, "inflater");
        Intrinsics.m26847b(viewGroup, "container");
        super.mo7139a(layoutInflater, viewGroup);
        this.f40038G = ab();
        ar();
        layoutInflater = mo7618O();
        if (layoutInflater != null) {
            this.f40045S = new ListingInfoOnScrollListener(this, layoutInflater);
        }
        layoutInflater = af();
        layoutInflater.setLayoutManager(ag());
        layoutInflater.setAdapter(mo7617M());
        if (this.f40045S != null) {
            viewGroup = this.f40045S;
            if (viewGroup == null) {
                Intrinsics.m26844a("listingInfoOnScrollListener");
            }
            layoutInflater.addOnChildAttachStateChangeListener((OnChildAttachStateChangeListener) viewGroup);
            viewGroup = this.f40045S;
            if (viewGroup == null) {
                Intrinsics.m26844a("listingInfoOnScrollListener");
            }
            layoutInflater.addOnScrollListener((OnScrollListener) viewGroup);
        }
        layoutInflater.setItemAnimator(null);
        layoutInflater.addOnChildAttachStateChangeListener((OnChildAttachStateChangeListener) new LinkListingScreen$onCreateView$$inlined$apply$lambda$1(layoutInflater, this));
        layoutInflater.addOnScrollListener((OnScrollListener) new AutoplayGifsOnScrollListener(ag(), this.f40043Q));
        Util.m23970a(ai());
        ak().setOnInflateListener((OnInflateListener) new LinkListingScreen$onCreateView$3(this));
        al().setOnInflateListener((OnInflateListener) new LinkListingScreen$onCreateView$4(this));
        am().setBackground(AnimUtil.m23637a(am_()));
        layoutInflater = mo7617M();
        AdVisibilityTracker adVisibilityTracker = this.f40036E;
        if (adVisibilityTracker == null) {
            Intrinsics.m26844a("adVisibilityTracker");
        }
        layoutInflater.m30204a(adVisibilityTracker);
        Object obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        return obj;
    }

    public void mo6987a(View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6987a(view);
        ah().setRecyclerView(null);
        af().setAdapter(null);
        this.I.m24081a();
    }

    public void mo6992b(View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6992b(view);
        view = this.f40036E;
        if (view == null) {
            Intrinsics.m26844a("adVisibilityTracker");
        }
        view.m23449a();
    }

    public void mo6993c(View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6993c(view);
        as();
        view = this.f40035D;
        if (view == null) {
            Intrinsics.m26844a("listingScreenActions");
        }
        view.mo4856a(this, mo7641w());
        view = this.f40036E;
        if (view == null) {
            Intrinsics.m26844a("adVisibilityTracker");
        }
        view.m23452b();
    }

    protected final void m40632c(Activity activity) {
        Intrinsics.m26847b(activity, "activity");
        super.c(activity);
        if (T_() != null) {
            activity = this.f40035D;
            if (activity == null) {
                Intrinsics.m26844a("listingScreenActions");
            }
            activity.mo4855a(this, mo7617M(), af());
        }
    }

    public void mo7209b(Activity activity) {
        Intrinsics.m26847b(activity, "activity");
        super.mo7209b(activity);
        if (T_() != null) {
            activity = this.f40035D;
            if (activity == null) {
                Intrinsics.m26844a("listingScreenActions");
            }
            activity.mo4858b(this, mo7617M(), af());
        }
    }

    protected final void m40634d(Activity activity) {
        Intrinsics.m26847b(activity, "activity");
        super.d(activity);
        activity = this.f40035D;
        if (activity == null) {
            Intrinsics.m26844a("listingScreenActions");
        }
        activity.mo4857b(this);
    }

    public void mo7631a(View view, Bundle bundle) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(bundle, "outState");
        this.lastClickedPosition = mo7617M().m30232l();
        this.lastPlayingPosition = mo7617M().m30230k();
        Bridge.b(this, bundle);
        super.a(view, bundle);
    }

    public void mo7638b(View view, Bundle bundle) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(bundle, "savedViewState");
        Bridge.a(this, bundle);
        super.b(view, bundle);
        view = mo7617M();
        view.m30228i(this.lastClickedPosition);
        view.m30229j(this.lastPlayingPosition);
    }

    public void ap() {
        if (v_()) {
            mo7641w().m23493a(true);
        }
    }

    public void aq() {
        as();
        if (T_() != null) {
            af().stopScroll();
            mo7641w().m23493a(false);
            ViewsKt.m24105b(ah());
        }
    }

    public final void m40627a(LinkViewHolder linkViewHolder) {
        Iterator it = new IntRange(ag().k(), ag().m()).iterator();
        while (it.hasNext()) {
            Object findViewHolderForAdapterPosition = af().findViewHolderForAdapterPosition(((IntIterator) it).mo6663a());
            if ((findViewHolderForAdapterPosition instanceof VideoCardLinkViewHolder) && (Intrinsics.m26845a(findViewHolderForAdapterPosition, (Object) linkViewHolder) ^ 1) != 0) {
                ((VideoCardLinkViewHolder) findViewHolderForAdapterPosition).mo6968v().m23525c();
            }
        }
    }

    protected final void ar() {
        ItemDecoration itemDecoration = this.f40042P;
        if (itemDecoration != null) {
            af().removeItemDecoration(itemDecoration);
        }
        if (am_() != null) {
            boolean an = an();
            DecorationInclusionStrategy a = DividerItemDecoration.m30091a();
            Intrinsics.m26843a((Object) a, "strategy");
            mo7634a(a);
            a.m23389a(new LinkListingScreen$createItemDecoration$1(this));
            Activity am_ = am_();
            if (am_ == null) {
                Intrinsics.m26842a();
            }
            Object a2 = DividerItemDecoration.m30093a(am_, an, a);
            Intrinsics.m26843a(a2, "DividerItemDecoration.cr…e,\n        strategy\n    )");
            this.f40042P = (ItemDecoration) a2;
            af().addItemDecoration(this.f40042P);
        }
    }

    public void mo7639f(View view) {
        Intrinsics.m26847b(view, "inflated");
        Object obj = (TextView) view.findViewById(C1761R.id.error_message);
        Intrinsics.m26843a(obj, "inflated.error_message");
        this.f40037F = obj;
    }

    protected final void as() {
        if (this.f40045S != null) {
            ListingInfoOnScrollListener listingInfoOnScrollListener = this.f40045S;
            if (listingInfoOnScrollListener == null) {
                Intrinsics.m26844a("listingInfoOnScrollListener");
            }
            listingInfoOnScrollListener.mo6460a(af());
        }
    }

    public static final /* synthetic */ void m40618a(RecyclerView recyclerView, View view) {
        LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            layoutManager = null;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        if (linearLayoutManager != null) {
            recyclerView = recyclerView.getChildViewHolder(view);
            if (!(recyclerView instanceof ListItemViewAttachListener)) {
                recyclerView = null;
            }
            ListItemViewAttachListener listItemViewAttachListener = (ListItemViewAttachListener) recyclerView;
            if (listItemViewAttachListener != null) {
                linearLayoutManager.i(view);
                listItemViewAttachListener.ab_();
            }
        }
    }
}
