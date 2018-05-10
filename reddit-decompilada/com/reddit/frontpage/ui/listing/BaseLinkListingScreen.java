package com.reddit.frontpage.ui.listing;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.BindView;
import com.android.volley.NetworkError;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.evernote.android.state.State;
import com.livefront.bridge.Bridge;
import com.reddit.datalibrary.frontpage.data.common.busevents.ErrorEvent;
import com.reddit.datalibrary.frontpage.data.feature.common.SortSelection;
import com.reddit.datalibrary.frontpage.data.feature.common.SortType;
import com.reddit.datalibrary.frontpage.data.feature.common.SortingsLegacyMapper;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.data.provider.LinkListingProvider;
import com.reddit.datalibrary.frontpage.data.provider.LinkListingProvider.LinkListingError;
import com.reddit.datalibrary.frontpage.data.provider.LinkListingProvider.LoadCompleteListingEvent;
import com.reddit.datalibrary.frontpage.job.DeletePostJob.ResultEvent;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration.FreshContentPill;
import com.reddit.datalibrary.frontpage.requests.models.v2.Banner;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listing;
import com.reddit.datalibrary.frontpage.requests.models.v2.LiveThread;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.commons.Sorting;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.AppAnalytics.ClickEventBuilder;
import com.reddit.frontpage.commons.analytics.events.v1.ScreenViewEvent;
import com.reddit.frontpage.commons.analytics.events.v1.ScreenViewEvent.ScreenViewPayload;
import com.reddit.frontpage.commons.analytics.events.v1.ScrollEvent.ScrollPayload;
import com.reddit.frontpage.commons.analytics.events.v2.ScreenviewEventBuilder;
import com.reddit.frontpage.commons.analytics.listener.AnalyticsOnScrollListener;
import com.reddit.frontpage.commons.analytics.performance.ListingPerformanceTracker;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.presentation.carousel.model.CarouselCollectionPresentationModel;
import com.reddit.frontpage.presentation.common.ui.view.listoptions.sort.PostSortOptionsDialog;
import com.reddit.frontpage.presentation.listing.model.ListingViewMode;
import com.reddit.frontpage.presentation.listing.ui.viewholder.VideoPlayable;
import com.reddit.frontpage.presentation.viewmode.ViewModeOptionsScreen;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.detail.OnLinkActionListener.HideLinkActionEvent;
import com.reddit.frontpage.ui.detail.OnLinkActionListener.UnhideLinkActionEvent;
import com.reddit.frontpage.ui.layout.SmoothScrollingLinearLayoutManager;
import com.reddit.frontpage.ui.listener.AutoplayGifsOnScrollListener;
import com.reddit.frontpage.ui.listener.OnPercentScrollListener;
import com.reddit.frontpage.ui.listing.DecorationInclusionStrategy.Defaults;
import com.reddit.frontpage.ui.listing.adapter.CardLinkAdapter;
import com.reddit.frontpage.ui.listing.adapter.RecyclerHeaderFooterAdapter;
import com.reddit.frontpage.ui.listing.adapter.RecyclerHeaderFooterAdapter.Footer;
import com.reddit.frontpage.ui.listing.adapter.ads.AdVisibilityTracker;
import com.reddit.frontpage.ui.listing.newcard.BannerViewHolder;
import com.reddit.frontpage.ui.listing.newcard.LinkViewHolder;
import com.reddit.frontpage.ui.listing.newcard.LiveThreadViewHolder;
import com.reddit.frontpage.ui.listing.newcard.VideoCardLinkViewHolder;
import com.reddit.frontpage.ui.listing.newcard.VisibilityDependent;
import com.reddit.frontpage.ui.listing.newcard.VisibilityDependentDelegate;
import com.reddit.frontpage.ui.listing.newcard.VisibilityDependentDelegate.ItemChangedListener;
import com.reddit.frontpage.util.AnimUtil;
import com.reddit.frontpage.util.IntentUtil;
import com.reddit.frontpage.util.Nimbledroid.Scenario;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import com.reddit.frontpage.widgets.ListingFooterState;
import com.reddit.frontpage.widgets.ListingFooterState.Error;
import com.reddit.frontpage.widgets.ListingFooterState.Hidden;
import com.reddit.frontpage.widgets.ListingFooterState.Loading;
import com.reddit.frontpage.widgets.ListingFooterView;
import com.reddit.frontpage.widgets.RefreshPill;
import de.greenrobot.event.EventBus;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.List;
import timber.log.Timber;

public abstract class BaseLinkListingScreen extends BaseScreen implements VisibilityDependent {
    TextView f39196A;
    protected VisibilityDependentDelegate f39197B;
    CardLinkAdapter f39198C;
    ItemDecoration f39199D;
    LinkListingProvider f39200E;
    boolean f39201F;
    protected CompositeDisposable f39202G = new CompositeDisposable();
    protected ListingViewMode f39203H;
    private AdVisibilityTracker f39204M;
    private final Handler f39205N = new Handler();
    private PublishSubject<SortSelection<SortType>> f39206O = PublishSubject.create();
    private Context f39207P;
    private ListingFooterState f39208Q;
    private final ItemChangedListener f39209R = new C23383(this);
    @BindView
    FrameLayout contentContainer;
    @BindView
    ViewStub emptyContainer;
    @BindView
    ViewStub errorContainer;
    @State
    int lastClickedPosition = -1;
    @State
    int lastPlayingPosition = -1;
    @BindView
    protected RecyclerView listView;
    @BindView
    View loadingSpinner;
    @BindView
    protected RefreshPill refreshPill;
    @BindView
    SwipeRefreshLayout swipeRefreshLayout;
    private ListingInfoOnScrollListener f39210v;
    protected RecyclerHeaderFooterAdapter f39211w;
    protected LinearLayoutManager f39212x;
    protected Listing<Listable> f39213y;
    protected ListingFooterView f39214z;

    class C18905 implements OnGlobalLayoutListener {
        final /* synthetic */ BaseLinkListingScreen f21264a;

        C18905(BaseLinkListingScreen baseLinkListingScreen) {
            this.f21264a = baseLinkListingScreen;
        }

        public void onGlobalLayout() {
            this.f21264a.f39197B.m23493a(true);
            if (this.f21264a.listView != null) {
                this.f21264a.listView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        }
    }

    private static class ViewedInfo {
        String f21269a;
        long f21270b;
        long f21271c;

        private ViewedInfo() {
        }
    }

    class C23361 implements OnChildAttachStateChangeListener {
        final /* synthetic */ BaseLinkListingScreen f29017a;

        public final void m30081a(View view) {
        }

        C23361(BaseLinkListingScreen baseLinkListingScreen) {
            this.f29017a = baseLinkListingScreen;
        }

        public final void m30082b(View view) {
            view = this.f29017a.listView.getChildViewHolder(view);
            if (view instanceof VisibilityDependent) {
                ((VisibilityDependent) view).aq();
            }
        }
    }

    class C23372 implements Footer {
        final /* synthetic */ BaseLinkListingScreen f29018a;

        C23372(BaseLinkListingScreen baseLinkListingScreen) {
            this.f29018a = baseLinkListingScreen;
        }

        public final View mo4979a() {
            this.f29018a.f39214z = new ListingFooterView(this.f29018a.f39207P);
            this.f29018a.f39214z.setErrorOnClickListener(new BaseLinkListingScreen$2$$Lambda$0(this));
            return this.f29018a.f39214z;
        }

        final /* synthetic */ void m30085b() {
            this.f29018a.mo7444O();
        }

        public final void mo4980a(ViewHolder viewHolder) {
            ListingFooterView listingFooterView = (ListingFooterView) viewHolder.c;
            if (this.f29018a.f39208Q instanceof Loading) {
                listingFooterView.m24184b();
            } else if (this.f29018a.f39208Q instanceof Hidden) {
                listingFooterView.m24182a();
            } else {
                if (this.f29018a.f39208Q instanceof Error) {
                    listingFooterView.m24183a(Util.m24027f(((Error) this.f29018a.f39208Q).f29473a));
                }
            }
        }
    }

    class C23383 implements ItemChangedListener {
        final /* synthetic */ BaseLinkListingScreen f29019a;

        C23383(BaseLinkListingScreen baseLinkListingScreen) {
            this.f29019a = baseLinkListingScreen;
        }

        public final void mo4827a(int i, int i2) {
            this.f29019a.f39197B.m23491a(i, i2, true);
        }

        public final void mo4826a(int i) {
            this.f29019a.f39197B.m23492a(i, true);
        }
    }

    class C23394 implements Observer<SortSelection<SortType>> {
        final /* synthetic */ BaseLinkListingScreen f29020a;

        public void onComplete() {
        }

        public void onError(Throwable th) {
        }

        C23394(BaseLinkListingScreen baseLinkListingScreen) {
            this.f29020a = baseLinkListingScreen;
        }

        public /* synthetic */ void onNext(Object obj) {
            SortSelection sortSelection = (SortSelection) obj;
            if (this.f29020a.e) {
                this.f29020a.mo7694a(SortingsLegacyMapper.a((SortType) sortSelection.a.f20414c), SortingsLegacyMapper.a(sortSelection.b));
            }
        }

        public void onSubscribe(Disposable disposable) {
            this.f29020a.f39202G.mo5631a(disposable);
        }
    }

    protected class FrontpageLinkAdapter extends CardLinkAdapter {
        final /* synthetic */ BaseLinkListingScreen f34314a;
        private final String f34315b;

        public final /* synthetic */ Object mo4996g(int i) {
            return mo6476c(i);
        }

        FrontpageLinkAdapter(BaseLinkListingScreen baseLinkListingScreen, Context context, String str) {
            this(baseLinkListingScreen, context, str, 11);
        }

        public FrontpageLinkAdapter(BaseLinkListingScreen baseLinkListingScreen, Context context, String str, int i) {
            this.f34314a = baseLinkListingScreen;
            super(context, 11 | i);
            this.f34315b = str;
        }

        public final Listable mo6476c(int i) {
            return (Listable) this.f34314a.f39213y.get(i);
        }

        public final int m35021a() {
            return this.f34314a.f39213y != null ? this.f34314a.f39213y.size() : 0;
        }

        protected void mo6506b(LinkViewHolder linkViewHolder, Link link) {
            linkViewHolder.f34378a = this.f34314a.l;
            super.mo6506b(linkViewHolder, link);
        }

        protected final void mo6468a(LinkViewHolder linkViewHolder, Link link) {
            EventBus.getDefault().unregister(this.f34314a);
            linkViewHolder.mo7006w();
            this.f34314a.m39238a((ViewHolder) linkViewHolder);
            if ((linkViewHolder instanceof VisibilityDependent) != null) {
                ((VisibilityDependent) linkViewHolder).aq();
            }
            this.f34314a.mo7708a(linkViewHolder);
        }

        protected final void mo6503a(LiveThreadViewHolder liveThreadViewHolder, LiveThread liveThread) {
            super.mo6503a(liveThreadViewHolder, liveThread);
            liveThreadViewHolder.c.setOnClickListener(new BaseLinkListingScreen$FrontpageLinkAdapter$$Lambda$0(liveThreadViewHolder, liveThread));
        }

        static final /* synthetic */ void m35020b(LiveThreadViewHolder liveThreadViewHolder, LiveThread liveThread) {
            Context context = liveThreadViewHolder.c.getContext();
            context.startActivity(IntentUtil.m23744a(context, liveThread));
            liveThreadViewHolder = AppAnalytics.m21858b().m21823a(liveThreadViewHolder.c);
            liveThreadViewHolder.f19955b = "banner_live";
            liveThreadViewHolder.m21825a();
        }

        protected final void mo6467a(BannerViewHolder bannerViewHolder, Banner banner) {
            super.mo6467a(bannerViewHolder, banner);
            bannerViewHolder.c.setOnClickListener(new BaseLinkListingScreen$FrontpageLinkAdapter$$Lambda$1(banner, bannerViewHolder));
        }

        static final /* synthetic */ void m35019a(Banner banner, BannerViewHolder bannerViewHolder) {
            IntentUtil.m23752a(banner.getDeeplinkUrl());
            banner = AppAnalytics.m21858b().m21823a(bannerViewHolder.c);
            banner.f19955b = "fp_banner";
            banner.m21825a();
        }

        public final boolean mo6477c() {
            return this.f34314a.ag();
        }

        protected final String mo6479f() {
            return this.f34315b;
        }

        protected final Listing<Listable> G_() {
            return this.f34314a.f39213y;
        }

        protected final void b_(int i) {
            super.b_(i);
            this.f34314a.f39200E.c(i);
        }

        protected final Integer a_(ViewHolder viewHolder) {
            return Integer.valueOf(this.f34314a.f39211w.m30148d(viewHolder));
        }

        protected final RecyclerView mo6490h() {
            return this.f34314a.listView;
        }

        protected final String mo6508g() {
            return this.f34314a.getAnalyticsScreenName();
        }

        protected final void mo6504a(String str) {
            super.mo6504a(str);
            this.f34314a.m37531b((CharSequence) str);
        }
    }

    private class ListingInfoOnScrollListener extends AnalyticsOnScrollListener implements OnChildAttachStateChangeListener {
        final /* synthetic */ BaseLinkListingScreen f34316b;
        private List<ViewedInfo> f34317c = new ArrayList();

        ListingInfoOnScrollListener(BaseLinkListingScreen baseLinkListingScreen, String str) {
            this.f34316b = baseLinkListingScreen;
            super(str);
        }

        public final void mo6460a(RecyclerView recyclerView) {
            super.mo6460a(recyclerView);
            this.f34317c.clear();
        }

        protected final void mo6461a(ScrollPayload scrollPayload) {
            scrollPayload.sr_name = this.f34316b.mo7451T();
            scrollPayload.posts_seen = new ArrayList(this.f34317c.size());
            scrollPayload.posts_seen_start_time = new ArrayList(this.f34317c.size());
            scrollPayload.posts_seen_end_time = new ArrayList(this.f34317c.size());
            long currentTimeMillis = System.currentTimeMillis();
            for (int size = this.f34317c.size() - 1; size >= 0; size--) {
                ViewedInfo viewedInfo = (ViewedInfo) this.f34317c.get(size);
                if (viewedInfo.f21271c != 0) {
                    break;
                }
                viewedInfo.f21271c = currentTimeMillis;
            }
            for (ViewedInfo viewedInfo2 : this.f34317c) {
                scrollPayload.posts_seen.add(viewedInfo2.f21269a);
                scrollPayload.posts_seen_start_time.add(Long.valueOf(viewedInfo2.f21270b));
                scrollPayload.posts_seen_end_time.add(Long.valueOf(viewedInfo2.f21271c));
            }
        }

        public final void m35034a(View view) {
            String str = (String) view.getTag(538378531);
            if (!TextUtils.isEmpty(str)) {
                ViewedInfo viewedInfo = new ViewedInfo();
                viewedInfo.f21269a = str;
                viewedInfo.f21270b = System.currentTimeMillis();
                this.f34317c.add(viewedInfo);
            }
        }

        public final void m35036b(View view) {
            if (this.f34316b.e) {
                String str = (String) view.getTag(538378531);
                for (int size = this.f34317c.size() - 1; size >= 0; size--) {
                    ViewedInfo viewedInfo = (ViewedInfo) this.f34317c.get(size);
                    if (TextUtils.equals(viewedInfo.f21269a, str)) {
                        viewedInfo.f21271c = System.currentTimeMillis();
                        return;
                    }
                }
            }
        }
    }

    private class LoadMoreOnScrollListener extends OnPercentScrollListener {
        final /* synthetic */ BaseLinkListingScreen f34318a;
        private final LinearLayoutManager f34319b;

        LoadMoreOnScrollListener(BaseLinkListingScreen baseLinkListingScreen, LinearLayoutManager linearLayoutManager) {
            this.f34318a = baseLinkListingScreen;
            this.f34319b = linearLayoutManager;
        }

        protected final void mo6462a() {
            if (this.f34319b.m() >= this.f34318a.f39213y.size() - 5 && this.f34318a.f39213y.getAfter() != null) {
                this.f34318a.mo7444O();
            }
        }
    }

    public String mo7451T() {
        return null;
    }

    public abstract LinkListingProvider mo7452U();

    protected String mo7453V() {
        return null;
    }

    protected boolean mo7692W() {
        return false;
    }

    protected Adapter mo7445a(Adapter adapter) {
        return adapter;
    }

    protected Listing<Listable> mo7456a(Listing<Listable> listing) {
        return listing;
    }

    protected void mo7695a(ViewStub viewStub) {
    }

    public void mo7728a(ScreenViewPayload screenViewPayload) {
    }

    public void mo7729a(ScreenviewEventBuilder screenviewEventBuilder) {
    }

    protected void mo7696a(DecorationInclusionStrategy decorationInclusionStrategy) {
    }

    protected void aa() {
    }

    protected boolean ae() {
        return false;
    }

    protected String ah() {
        return null;
    }

    protected void mo7701f(View view) {
    }

    protected BaseLinkListingScreen() {
    }

    protected BaseLinkListingScreen(Bundle bundle) {
        super(bundle);
    }

    public View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super.mo7139a(layoutInflater, viewGroup);
        this.f39201F = FrontpageSettings.a().c();
        layoutInflater = ah();
        ListingViewMode listingViewMode = ag() ? ListingViewMode.f20613b : ListingViewMode.f20612a;
        if (layoutInflater != null) {
            listingViewMode = (ListingViewMode) FrontpageApplication.m28875k().mo4613a().m22477b(ah(), listingViewMode).blockingGet();
        } else if (this.f39203H != null) {
            listingViewMode = this.f39203H;
        }
        this.f39203H = listingViewMode;
        this.f39207P = viewGroup.getContext();
        this.f39198C = mo7455Y();
        this.f39211w = new RecyclerHeaderFooterAdapter(mo7445a(this.f39198C));
        ab();
        this.f39212x = SmoothScrollingLinearLayoutManager.m35006a(am_(), this.f39209R);
        this.listView.setLayoutManager(this.f39212x);
        this.f39197B = new VisibilityDependentDelegate(this.listView);
        this.listView.addOnChildAttachStateChangeListener(new C23361(this));
        this.f39210v = new ListingInfoOnScrollListener(this, getAnalyticsScreenName());
        this.listView.addOnChildAttachStateChangeListener(this.f39210v);
        this.listView.addOnScrollListener(this.f39210v);
        this.listView.addOnScrollListener(new LoadMoreOnScrollListener(this, this.f39212x));
        this.listView.addOnScrollListener(new AutoplayGifsOnScrollListener(this.f39212x, this.f39209R));
        Util.m23970a(this.swipeRefreshLayout);
        if (mo7692W() != null) {
            this.refreshPill.setRecyclerView(this.listView);
            this.refreshPill.setOnClickListener(new BaseLinkListingScreen$$Lambda$0(this));
        }
        this.swipeRefreshLayout.setOnRefreshListener(new BaseLinkListingScreen$$Lambda$1(this));
        this.f39208Q = Loading.f29475a;
        this.f39211w.f34366f = new C23372(this);
        this.errorContainer.setOnInflateListener(new BaseLinkListingScreen$$Lambda$2(this));
        this.emptyContainer.setOnInflateListener(new BaseLinkListingScreen$$Lambda$3(this));
        this.listView.setAdapter(this.f39211w);
        this.loadingSpinner.setBackground(AnimUtil.m23637a(am_()));
        this.f39204M = new AdVisibilityTracker(am_());
        this.f39198C.f29111h = this.f39204M;
        this.f39206O.subscribeOn(FrontpageApplication.m28875k().mo4632t().a()).observeOn(FrontpageApplication.m28875k().mo4633u().a()).subscribe(new C23394(this));
        return this.K;
    }

    final /* synthetic */ void m39262h(View view) {
        ClickEventBuilder b = AppAnalytics.m21858b();
        b.f19955b = FreshContentPill.NAME;
        b.f19954a = mo7453V();
        b.m21825a();
        ViewsKt.m24109d(view);
        m39230X();
        mo7200K();
    }

    final /* synthetic */ void m39261g(View view) {
        mo7701f(view);
    }

    protected final void m39230X() {
        mo7447x();
        mo7448y();
    }

    protected void mo7705c(Activity activity) {
        super.c(activity);
        if (this.f39198C != null) {
            activity = this.f39198C.f29110g;
            if (activity >= null) {
                activity = this.listView.findViewHolderForAdapterPosition(activity);
                if (activity instanceof VideoPlayable) {
                    ((VideoPlayable) activity).mo6960G();
                }
            }
        }
    }

    protected void mo7209b(Activity activity) {
        super.mo7209b(activity);
        if (this.f39198C != null) {
            activity = this.f39198C.f29109f;
            if (activity >= null) {
                this.f39198C.d(activity);
            }
            activity = this.f39198C.f29110g;
            if (activity >= null) {
                activity = this.listView.findViewHolderForAdapterPosition(activity);
                if (activity instanceof VideoPlayable) {
                    ((VideoPlayable) activity).mo6961H();
                }
            }
        }
    }

    protected void mo6992b(View view) {
        super.mo6992b(view);
        mo7693Z();
        this.f39205N.post(new BaseLinkListingScreen$$Lambda$4(this));
        this.f39204M.m23449a();
    }

    protected final void m39258d(Activity activity) {
        super.d(activity);
        if (this.e != null) {
            aq();
        }
    }

    protected void mo6993c(View view) {
        super.mo6993c(view);
        aq();
        mo7447x();
        this.f39197B.m23493a(false);
        this.f39204M.m23452b();
    }

    public void mo7191l() {
        super.mo7191l();
        if (this.f39198C != null) {
            this.f39198C.f29118o.m32077c();
        }
        this.f39202G.m32077c();
    }

    public void mo6987a(View view) {
        super.mo6987a(view);
        this.refreshPill.setRecyclerView(null);
        this.listView.setAdapter(null);
        this.f39211w.m30143b();
        this.f39214z = null;
        this.f39196A = null;
        this.f39211w = null;
        this.f39198C = null;
        this.f39199D = null;
        this.f39212x = null;
        this.f39202G.m32077c();
    }

    public void ap() {
        this.f39197B.m23493a(true);
    }

    public void aq() {
        mo7447x();
        if (this.f39212x != null) {
            this.listView.stopScroll();
            this.f39197B.m23493a(false);
        }
    }

    protected void mo7144v() {
        this.f39200E = mo7452U();
        m37523a(this.f39200E);
    }

    protected final void mo7199c(Bundle bundle) {
        super.mo7199c(bundle);
        if (this.f39200E != null) {
            mo7459w();
        }
    }

    protected void mo7457a(View view, Bundle bundle) {
        if (this.f39198C != null) {
            if (this.f39198C.f29109f >= 0) {
                this.lastClickedPosition = this.f39198C.f29109f;
                this.lastPlayingPosition = this.f39198C.f29110g;
            }
            this.f39198C.m30191a(bundle);
        }
        Bridge.b(this, bundle);
        super.a(view, bundle);
    }

    protected void mo7700b(View view, Bundle bundle) {
        Bridge.a(this, bundle);
        super.b(view, bundle);
        if (this.f39198C != null) {
            this.f39198C.f29109f = this.lastClickedPosition;
            this.f39198C.f29110g = this.lastPlayingPosition;
            this.f39198C.m30215b(bundle);
        }
    }

    protected CardLinkAdapter mo7455Y() {
        CardLinkAdapter frontpageLinkAdapter = new FrontpageLinkAdapter(this, am_(), mo7453V());
        frontpageLinkAdapter.f29116m = new BaseLinkListingScreen$$Lambda$5(this);
        return frontpageLinkAdapter;
    }

    protected void mo7693Z() {
        if (this.f39213y != null) {
            ad();
            this.f39211w.a_.b();
            return;
        }
        ac();
        aa();
        this.f39200E.a(false, ListingPerformanceTracker.m21961a(getAnalyticsScreenName()));
    }

    protected void mo7448y() {
        aa();
        this.f39200E.a(true, ListingPerformanceTracker.m21961a(getAnalyticsScreenName()));
    }

    protected final void m39238a(ViewHolder viewHolder) {
        Scenario.f21766b.m23846a();
        EventBus.getDefault().unregister(this);
        mo7708a(null);
        Routing.m22623a((Screen) this, LegacyLinkPagerScreen.m39271a(this.l, this.f39200E, this.f39211w.m30148d(viewHolder), mo7453V()));
    }

    public void mo7454a(Menu menu, MenuInflater menuInflater) {
        super.a(menu, menuInflater);
        menuInflater.inflate(C1761R.menu.menu_link_listing, menu);
    }

    public boolean mo7201a(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == C1761R.id.action_refresh) {
            mo7447x();
            mo7448y();
            this.swipeRefreshLayout.setRefreshing(true);
            return true;
        } else if (itemId == C1761R.id.action_search) {
            Routing.m22623a((Screen) this, Nav.m22603n(null));
            return true;
        } else if (itemId != C1761R.id.action_sort) {
            return super.mo7201a(menuItem);
        } else {
            af();
            return true;
        }
    }

    public final void mo7219a(ErrorEvent errorEvent) {
        if (errorEvent instanceof LinkListingError) {
            errorEvent = errorEvent.exception;
            if (errorEvent instanceof VolleyError) {
                VolleyError volleyError = (VolleyError) errorEvent;
                if (volleyError instanceof NetworkError) {
                    mo4797a((int) C1761R.string.error_network_error);
                    return;
                } else if (volleyError instanceof ServerError) {
                    mo4797a((int) C1761R.string.error_server_error);
                    return;
                } else {
                    if ((volleyError instanceof TimeoutError) != null) {
                        mo4797a((int) C1761R.string.error_network_error);
                    }
                    return;
                }
            }
            m37526a((Exception) errorEvent);
            return;
        }
        super.mo7219a(errorEvent);
    }

    protected final void ab() {
        if (this.f39199D != null) {
            this.listView.removeItemDecoration(this.f39199D);
        }
        if (am_() != null) {
            boolean ag = ag();
            Defaults defaults = DecorationInclusionStrategy.f21272b;
            DecorationInclusionStrategy a = Defaults.m23387a();
            a.m23389a(new BaseLinkListingScreen$$Lambda$6(this));
            mo7696a(a);
            this.f39199D = DividerItemDecoration.m30093a(am_(), ag, a);
            this.listView.addItemDecoration(this.f39199D);
        }
    }

    final /* synthetic */ Boolean m39254c(Integer num) {
        return Boolean.valueOf(this.f39198C.m30231k(this.f39211w.mo6515c(num.intValue())) ^ 1);
    }

    final /* synthetic */ void aj() {
        ac();
        mo7448y();
    }

    public final void ad() {
        Timber.b("onListingSuccess", new Object[0]);
        if (this.e) {
            if (this.swipeRefreshLayout.b) {
                this.swipeRefreshLayout.postDelayed(new BaseLinkListingScreen$$Lambda$8(this), 150);
                this.listView.stopScroll();
            }
            if (this.f39213y.getAfter() == null || this.f39213y.isEmpty()) {
                m39219a(Hidden.f29474a);
                if (this.f39198C.a() == 0) {
                    if (this.j != null) {
                        this.contentContainer.setVisibility(0);
                        this.swipeRefreshLayout.setEnabled(true);
                        this.loadingSpinner.setVisibility(8);
                        mo7695a(this.emptyContainer);
                        this.emptyContainer.setVisibility(0);
                    }
                    return;
                }
            }
            if (this.j != null) {
                this.contentContainer.setVisibility(0);
                this.swipeRefreshLayout.setEnabled(true);
                this.loadingSpinner.setVisibility(8);
                this.emptyContainer.setVisibility(8);
            }
        }
    }

    private void mo7459w() {
        this.f39213y = mo7456a(this.f39200E.listing);
    }

    public void onEventMainThread(ResultEvent resultEvent) {
        EventBus.getDefault().removeStickyEvent((Object) resultEvent);
        m39249b(resultEvent.a);
    }

    public void onEventMainThread(HideLinkActionEvent hideLinkActionEvent) {
        EventBus.getDefault().removeStickyEvent((Object) hideLinkActionEvent);
        m39249b(hideLinkActionEvent.f21174a);
    }

    public void onEventMainThread(UnhideLinkActionEvent unhideLinkActionEvent) {
        EventBus.getDefault().removeStickyEvent((Object) unhideLinkActionEvent);
    }

    protected final void m39249b(int i) {
        if (i >= 0) {
            this.f39200E.a(i);
            this.f39198C.f(i);
        }
    }

    protected final void m39251b(ViewHolder viewHolder) {
        this.f39200E.a(this.f39211w.m30148d(viewHolder));
        this.f39198C.f(viewHolder.d());
    }

    public final void m39237a(int i, CarouselCollectionPresentationModel carouselCollectionPresentationModel) {
        if (i >= 0) {
            LinkListingProvider linkListingProvider = this.f39200E;
            if (i >= 0 && i <= linkListingProvider.listing.size()) {
                linkListingProvider.listing.insert(i, carouselCollectionPresentationModel);
            }
            this.f39198C.e(i);
        }
    }

    protected final void af() {
        new PostSortOptionsDialog(this.f39206O, this.f39207P, ae(), SortingsLegacyMapper.a(this.f39200E.sortId), SortingsLegacyMapper.b(this.f39200E.sortTimeFrame)).m22764a();
    }

    protected void mo7694a(int i, int i2) {
        mo7447x();
        ac();
        LinkListingProvider linkListingProvider = this.f39200E;
        String a = ListingPerformanceTracker.m21961a(getAnalyticsScreenName());
        linkListingProvider.sortId = i;
        linkListingProvider.sortTimeFrame = i2;
        linkListingProvider.listing = 0;
        linkListingProvider.a(1, a);
        this.listView.scrollToPosition(0);
    }

    public boolean ag() {
        if (this.f39203H != null) {
            return this.f39203H == ListingViewMode.f20613b;
        } else {
            return this.f39201F;
        }
    }

    protected final void m39246a(ListingViewMode listingViewMode) {
        this.f39203H = listingViewMode;
        FrontpageApplication.m28875k().mo4613a().m22470a(ah(), listingViewMode).subscribeOn(Schedulers.m26771b()).subscribe();
    }

    protected final void ai() {
        ViewModeOptionsScreen viewModeOptionsScreen = new ViewModeOptionsScreen(this.f39207P, this.f39203H);
        viewModeOptionsScreen.f39121e = this;
        viewModeOptionsScreen.show();
    }

    public ScreenviewEventBuilder getAnalyticsScreenviewEvent() {
        ScreenviewEventBuilder analyticsScreenviewEvent = super.getAnalyticsScreenviewEvent();
        if (this.f39200E != null) {
            analyticsScreenviewEvent.m21926a((long) this.f39200E.linkIds.size(), this.f39200E.linkIds, Sorting.m21806a(this.f39200E.sortId), Sorting.m21810d(this.f39200E.sortTimeFrame));
        }
        mo7729a(analyticsScreenviewEvent);
        return analyticsScreenviewEvent;
    }

    public ScreenViewEvent mo7203N() {
        ScreenViewEvent N = super.mo7203N();
        ((ScreenViewPayload) N.payload).target_type = "listing";
        ((ScreenViewPayload) N.payload).listing_name = mo7451T();
        ((ScreenViewPayload) N.payload).sr_name = mo7451T();
        if (this.f39200E != null) {
            ((ScreenViewPayload) N.payload).target_sort_order = Sorting.m21806a(this.f39200E.sortId);
            ((ScreenViewPayload) N.payload).target_filter_time = Sorting.m21810d(this.f39200E.sortTimeFrame);
        }
        mo7728a((ScreenViewPayload) N.payload);
        return N;
    }

    private void mo7447x() {
        if (this.f39210v != null) {
            this.f39210v.mo6460a(this.listView);
        }
    }

    public void onEventMainThread(LoadCompleteListingEvent loadCompleteListingEvent) {
        if (this.f39200E.isSource(loadCompleteListingEvent)) {
            mo7446d(loadCompleteListingEvent.b);
        }
    }

    public void mo7446d(boolean z) {
        Listing listing = this.f39213y;
        mo7459w();
        ad();
        if (!(z || listing == null || listing.isEmpty())) {
            if (listing.size() < this.f39213y.size()) {
                z = false;
                if (z) {
                    this.f39211w.a(listing.size(), (this.f39213y.size() - listing.size()) + this.f39211w.m35096g());
                } else {
                    this.f39211w.a_.b();
                }
                this.listView.getViewTreeObserver().addOnGlobalLayoutListener(new C18905(this));
            }
        }
        z = true;
        if (z) {
            this.f39211w.a(listing.size(), (this.f39213y.size() - listing.size()) + this.f39211w.m35096g());
        } else {
            this.f39211w.a_.b();
        }
        this.listView.getViewTreeObserver().addOnGlobalLayoutListener(new C18905(this));
    }

    private void mo7708a(LinkViewHolder linkViewHolder) {
        int m = this.f39212x.m();
        for (int k = this.f39212x.k(); k <= m; k++) {
            ViewHolder findViewHolderForLayoutPosition = this.listView.findViewHolderForLayoutPosition(k);
            if (findViewHolderForLayoutPosition instanceof VideoCardLinkViewHolder) {
                VideoCardLinkViewHolder videoCardLinkViewHolder = (VideoCardLinkViewHolder) findViewHolderForLayoutPosition;
                if (findViewHolderForLayoutPosition != linkViewHolder) {
                    videoCardLinkViewHolder.f37304v.f21424e = true;
                }
            }
        }
    }

    private void m39219a(ListingFooterState listingFooterState) {
        this.f39208Q = listingFooterState;
        if (this.f39213y != null) {
            this.f39211w.d((this.f39213y.size() + this.f39211w.m35095f()) + this.f39211w.m35096g());
        }
    }

    protected void mo7444O() {
        if (this.e) {
            m39219a(Loading.f29475a);
        }
        if (this.f39200E != null) {
            this.f39200E.b(ListingPerformanceTracker.m21961a(getAnalyticsScreenName()));
        }
    }

    protected final void ac() {
        if (this.j != null) {
            this.errorContainer.setVisibility(8);
            this.contentContainer.setVisibility(0);
            this.swipeRefreshLayout.setRefreshing(false);
            this.swipeRefreshLayout.setEnabled(false);
            this.loadingSpinner.setVisibility(0);
            this.emptyContainer.setVisibility(8);
            m39219a(Hidden.f29474a);
            if (this.f39213y != null) {
                this.f39213y = null;
                this.f39198C.a_.b();
            }
        }
    }

    private void mo4797a(int i) {
        if (this.j != null) {
            if (this.f39198C.a() == 0) {
                this.contentContainer.setVisibility(4);
                this.errorContainer.setVisibility(0);
                this.emptyContainer.setVisibility(8);
                this.f39196A.setText(i);
                return;
            }
            m39219a(new Error(i));
        }
    }
}
