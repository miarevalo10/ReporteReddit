package com.reddit.frontpage.ui.listing;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import com.evernote.android.state.State;
import com.google.common.collect.ImmutableList;
import com.reddit.datalibrary.frontpage.data.feature.account.datasource.local.AccountStorage;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.data.provider.BaseOtherProvider;
import com.reddit.datalibrary.frontpage.data.provider.LinkListingProvider;
import com.reddit.datalibrary.frontpage.data.provider.ProviderManager;
import com.reddit.datalibrary.frontpage.data.provider.UserSubmittedListingProvider;
import com.reddit.datalibrary.frontpage.data.provider.UserSubmittedListingProvider.Filter;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v1.Account;
import com.reddit.datalibrary.frontpage.requests.models.v2.ClientLink;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.datalibrary.frontpage.requests.models.v2.ListParcelerBundler;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listing;
import com.reddit.datalibrary.frontpage.requests.models.v2.ListingModel;
import com.reddit.datalibrary.frontpage.requests.models.v2.SubmittedVideoLink;
import com.reddit.datalibrary.frontpage.service.api.VideoUploadService;
import com.reddit.datalibrary.frontpage.service.api.VideoUploadService.SubmitVideoResultEvent;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.events.v1.BaseEvent;
import com.reddit.frontpage.commons.analytics.events.v1.ScreenViewEvent;
import com.reddit.frontpage.commons.analytics.events.v1.ScreenViewEvent.ScreenViewPayload;
import com.reddit.frontpage.commons.analytics.events.v1.ScrollEvent.ScrollPayload;
import com.reddit.frontpage.commons.analytics.events.v1.TopSubredditClickEvent;
import com.reddit.frontpage.commons.analytics.events.v1.TopSubredditClickEvent.TopSubredditPayload;
import com.reddit.frontpage.commons.analytics.listener.AnalyticsOnScrollListener;
import com.reddit.frontpage.domain.model.Karma;
import com.reddit.frontpage.domain.repository.KarmaRepository;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.presentation.carousel.CarouselColorGenerator;
import com.reddit.frontpage.presentation.carousel.model.GeneralCarouselCollectionPresentationModel;
import com.reddit.frontpage.presentation.carousel.model.ICarouselItemPresentationModel;
import com.reddit.frontpage.ui.carousel.CarouselItemLayout;
import com.reddit.frontpage.ui.carousel.CarouselViewHolder;
import com.reddit.frontpage.ui.carousel.KarmaCarouselItemPresentationModel;
import com.reddit.frontpage.ui.listing.adapter.CardLinkAdapter;
import com.reddit.frontpage.ui.listing.newcard.LinkViewHolder;
import com.reddit.frontpage.util.AccountPrefsUtil;
import com.reddit.frontpage.util.ListUtil;
import com.reddit.frontpage.util.SchedulerProvider;
import com.reddit.frontpage.util.ScreenUtil;
import com.reddit.frontpage.util.Util;
import de.greenrobot.event.EventBus;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

public class UserSubmittedListingScreen extends BaseLinkListingScreen {
    private String f40162M;
    private CarouselViewHolder f40163N;
    private KarmaRepository f40164O;
    private AnalyticsOnScrollListener f40165P;
    private Disposable f40166Q;
    @State
    public boolean isContributor;
    @State(ListParcelerBundler.class)
    List<KarmaCarouselItemPresentationModel> karmaList;
    @State
    boolean karmaListLoaded;
    @State
    int karmaListPosition;
    @State
    int karmaListPositionOffset;
    public boolean f40167v;

    class C23452 implements Observer<List<KarmaCarouselItemPresentationModel>> {
        final /* synthetic */ UserSubmittedListingScreen f29085a;

        public void onComplete() {
        }

        public void onError(Throwable th) {
        }

        C23452(UserSubmittedListingScreen userSubmittedListingScreen) {
            this.f29085a = userSubmittedListingScreen;
        }

        public /* synthetic */ void onNext(Object obj) {
            this.f29085a.karmaList = (List) obj;
            this.f29085a.karmaListLoaded = true;
            if (this.f29085a.e != null) {
                this.f29085a.m41036x();
            }
        }

        public void onSubscribe(Disposable disposable) {
            this.f29085a.G.mo5631a(disposable);
        }
    }

    private class SavedLinkAdapter extends CardLinkAdapter {
        final /* synthetic */ UserSubmittedListingScreen f34328a;

        public final boolean mo6477c() {
            return true;
        }

        protected final String mo6508g() {
            return "profile_myposts";
        }

        public final /* synthetic */ Object mo4996g(int i) {
            return mo6476c(i);
        }

        SavedLinkAdapter(UserSubmittedListingScreen userSubmittedListingScreen, Context context) {
            this.f34328a = userSubmittedListingScreen;
            super(context, 1);
        }

        public final Listable mo6476c(int i) {
            if (!this.f34328a.f40167v || !(this.f34328a.y instanceof ListingModel)) {
                return (Listable) this.f34328a.y.get(i);
            }
            List videoLinks = ((ListingModel) this.f34328a.y).getVideoLinks();
            int size = videoLinks != null ? videoLinks.size() : 0;
            if (i < size) {
                return (Listable) videoLinks.get(i);
            }
            return (Listable) this.f34328a.y.get(i - size);
        }

        public final int m35059a() {
            int i = 0;
            if (this.f34328a.f40167v && (this.f34328a.y instanceof ListingModel)) {
                ListingModel listingModel = (ListingModel) this.f34328a.y;
                List videoLinks = listingModel.getVideoLinks();
                int size = listingModel.size();
                if (videoLinks != null) {
                    i = videoLinks.size();
                }
                return size + i;
            } else if (this.f34328a.y != null) {
                return this.f34328a.y.size();
            } else {
                return 0;
            }
        }

        protected final void mo6468a(LinkViewHolder linkViewHolder, Link link) {
            if (this.f34328a.f40167v == null || (link instanceof SubmittedVideoLink) == null) {
                Routing.m22623a((Screen) this.f34328a, Nav.m22541a(link));
            }
        }
    }

    protected final void E_() {
    }

    public final void mo7454a(Menu menu, MenuInflater menuInflater) {
    }

    public final boolean ag() {
        return true;
    }

    public String getAnalyticsPageType() {
        return "profile";
    }

    public String getAnalyticsScreenName() {
        return "profile_posts";
    }

    public final int mo7141s() {
        return C1761R.layout.screen_user_posts;
    }

    public static UserSubmittedListingScreen m41025a(String str) {
        return new UserSubmittedListingScreen(str);
    }

    public UserSubmittedListingScreen(Bundle bundle) {
        super(bundle);
        this.karmaList = ImmutableList.d();
        this.karmaListLoaded = null;
    }

    protected final void mo7142t() {
        super.mo7142t();
        this.f40162M = this.a.getString("args.username");
        Session session = SessionManager.b().c;
        boolean z = !session.isAnonymous() && session.getUsername().equals(this.f40162M);
        this.f40167v = z;
    }

    public final View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super.mo7139a(layoutInflater, viewGroup);
        this.f40163N = new CarouselViewHolder(layoutInflater.inflate(C1761R.layout.layout_carousel, null, false), Util.m23955a(Util.m24014d(viewGroup.getContext())).x, CarouselItemLayout.SMALL, null);
        this.f40165P = new AnalyticsOnScrollListener(this, getAnalyticsScreenName()) {
            final /* synthetic */ UserSubmittedListingScreen f34327b;

            protected final void mo6461a(ScrollPayload scrollPayload) {
                scrollPayload.control_name = "comments";
                scrollPayload.base_url = this.f34327b.f40162M;
                super.mo6461a(scrollPayload);
            }
        };
        this.listView.addOnScrollListener(this.f40165P);
        return this.K;
    }

    protected final void mo7185a(ActionBar actionBar) {
        actionBar.a(C1761R.string.title_posts);
    }

    protected final void mo6992b(View view) {
        super.mo6992b(view);
        this.f40166Q = VideoUploadService.getVideoDeletedObservable().observeOn(SchedulerProvider.m23887c()).subscribe(new UserSubmittedListingScreen$$Lambda$2(this), UserSubmittedListingScreen$$Lambda$3.f29080a);
        if (this.isContributor != null && this.f40167v == null) {
            if (this.karmaListLoaded == null) {
                mo7459w();
            } else {
                m41036x();
            }
        }
        mo7448y();
    }

    protected final void mo6993c(View view) {
        if (this.f40166Q != null) {
            this.f40166Q.mo5626a();
            this.f40166Q = null;
        }
        super.mo6993c(view);
    }

    protected final void mo7457a(View view, Bundle bundle) {
        super.mo7457a(view, bundle);
        if (this.isContributor != null && this.karmaListLoaded != null) {
            this.karmaListPosition = this.f40163N.m34916v().k();
            view = this.f40163N.m34916v().a(this.karmaListPosition);
            this.karmaListPositionOffset = view != null ? view.getLeft() : null;
        }
    }

    public final void mo7459w() {
        this.f40164O.m22406a(this.f40162M).toObservable().map(new UserSubmittedListingScreen$$Lambda$0(new CarouselColorGenerator(aq_(), FrontpageSettings.a()))).observeOn(AndroidSchedulers.m26509a()).subscribe(new C23452(this));
    }

    static final /* synthetic */ List m41027a(CarouselColorGenerator carouselColorGenerator, List list) throws Exception {
        List arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            int a;
            Karma karma = (Karma) list.get(i);
            if (TextUtils.isEmpty(karma.getKeyColor())) {
                a = carouselColorGenerator.mo4784a(i);
            } else {
                a = Util.m23953a(karma.getKeyColor());
            }
            arrayList.add(new KarmaCarouselItemPresentationModel(karma, a));
        }
        return arrayList;
    }

    protected final void mo7144v() {
        super.mo7144v();
        Session session = SessionManager.b().c;
        this.f40164O = FrontpageApplication.m28875k().mo4637y();
    }

    public final LinkListingProvider mo7452U() {
        Filter filter;
        ProviderManager providerManager = ProviderManager.b;
        String str = this.l;
        String str2 = this.f40162M;
        if (AccountPrefsUtil.m23628a()) {
            filter = null;
        } else {
            filter = UserSubmittedListingScreen$$Lambda$1.f34324a;
        }
        Intrinsics.m26847b(str, "ownerId");
        Intrinsics.m26847b(str2, "username");
        BaseOtherProvider baseOtherProvider = (BaseOtherProvider) ProviderManager.b().get(str);
        if (baseOtherProvider == null) {
            baseOtherProvider = new UserSubmittedListingProvider(str, str2, filter);
            ProviderManager.b().put(str, baseOtherProvider);
        }
        return (UserSubmittedListingProvider) baseOtherProvider;
    }

    static final /* synthetic */ boolean m41031a(Listable listable) {
        if ((listable instanceof Link) && ((Link) listable).isOver18() != null) {
            return null;
        }
        return true;
    }

    public final ScreenViewEvent mo7203N() {
        ScreenViewEvent N = super.mo7203N();
        ((ScreenViewPayload) N.payload).target_type = "account";
        ((ScreenViewPayload) N.payload).target_name = this.f40162M;
        ((ScreenViewPayload) N.payload).user_name = SessionManager.b().c.getUsername();
        ((ScreenViewPayload) N.payload).is_contributor = this.isContributor;
        Account account = (Account) AccountStorage.b.a(SessionManager.b().c.getUsername());
        if (account != null) {
            ((ScreenViewPayload) N.payload).user_id36 = account.getId();
        }
        return N;
    }

    public final CardLinkAdapter mo7455Y() {
        return new SavedLinkAdapter(this, am_());
    }

    public final void mo6987a(View view) {
        this.f40165P.mo6460a(this.listView);
        super.mo6987a(view);
    }

    final /* synthetic */ void mo7241c(String str) throws Exception {
        if (this.y != null && (this.y instanceof ListingModel)) {
            List videoLinks = ((ListingModel) this.y).getVideoLinks();
            if (videoLinks != null) {
                ScreenUtil.m23891c(am_());
                int size = videoLinks.size();
                for (int i = 0; i < size; i++) {
                    if (str.equals(((SubmittedVideoLink) videoLinks.get(i)).videoUpload.getRequestId())) {
                        videoLinks.remove(i);
                        m39249b(i + this.w.m35095f());
                        Object obj = (SubmitVideoResultEvent) EventBus.getDefault().getStickyEvent(SubmitVideoResultEvent.class);
                        if (obj != null) {
                            EventBus.getDefault().removeStickyEvent(obj);
                            return;
                        }
                    }
                }
            }
        }
    }

    private void m41036x() {
        if (!this.karmaList.isEmpty()) {
            GeneralCarouselCollectionPresentationModel generalCarouselCollectionPresentationModel = new GeneralCarouselCollectionPresentationModel(Util.m24027f((int) C1761R.string.active_communities_banner), false, true, this.karmaList, "", 0, true, 16, null, null);
            Activity d = Util.m24014d(this.K.getContext());
            this.f40163N.m34914a(generalCarouselCollectionPresentationModel, null, null, new UserSubmittedListingScreen$$Lambda$4(d), UserSubmittedListingScreen$$Lambda$5.f34326a, null);
            if (this.w != null && this.w.m35095f() == 0) {
                this.w.f34364b = this.f40163N.c;
            }
            CarouselViewHolder carouselViewHolder = this.f40163N;
            carouselViewHolder.m34916v().e(this.karmaListPosition, this.karmaListPositionOffset);
        }
    }

    static final /* synthetic */ Unit m41028a(Activity activity, Integer num, ICarouselItemPresentationModel iCarouselItemPresentationModel) {
        Account account = (Account) AccountStorage.b.a(SessionManager.b().c.getUsername());
        BaseEvent topSubredditClickEvent = new TopSubredditClickEvent();
        if (!(account == null || account.subreddit == null)) {
            ((TopSubredditPayload) topSubredditClickEvent.payload).base_url = account.subreddit.getName();
            ((TopSubredditPayload) topSubredditClickEvent.payload).target_id = iCarouselItemPresentationModel.mo6433a();
        }
        ((TopSubredditPayload) topSubredditClickEvent.payload).target_name = iCarouselItemPresentationModel.mo6435b();
        ((TopSubredditPayload) topSubredditClickEvent.payload).target_type = "listing";
        ((TopSubredditPayload) topSubredditClickEvent.payload).target_url = iCarouselItemPresentationModel.mo6435b();
        ((TopSubredditPayload) topSubredditClickEvent.payload).position = num.intValue();
        AppAnalytics.m21852a(topSubredditClickEvent);
        Routing.m22619a((Context) activity, Nav.m22566b(iCarouselItemPresentationModel.mo6435b()));
        return null;
    }

    protected final Listing<Listable> mo7456a(Listing<Listable> listing) {
        super.mo7456a((Listing) listing);
        if (!listing.getEntities().isEmpty()) {
            Observable fromIterable = Observable.fromIterable(listing.getEntities());
            Class cls = ClientLink.class;
            cls.getClass();
            fromIterable.filter(UserSubmittedListingScreen$$Lambda$6.m30130a(cls)).cast(ClientLink.class).filter(UserSubmittedListingScreen$$Lambda$7.f29082a).map(UserSubmittedListingScreen$$Lambda$8.f29083a).map(new UserSubmittedListingScreen$$Lambda$9(this)).map(UserSubmittedListingScreen$$Lambda$10.f29077a).toList().map(UserSubmittedListingScreen$$Lambda$11.f29078a).subscribeOn(SchedulerProvider.m23886b()).subscribe();
        }
        return listing;
    }

    static final /* synthetic */ boolean m41034b(ClientLink clientLink) throws Exception {
        return (clientLink.getMedia() == null || clientLink.getMedia().getRedditVideo() == null || "completed".equals(clientLink.getMedia().getRedditVideo().getTranscodingStatus()) == null) ? null : true;
    }

    private UserSubmittedListingScreen(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("args.username", str);
        this(bundle);
    }

    public final boolean mo7200K() {
        if (this.j != null) {
            if (this.listView != null) {
                if (!ListUtil.m23810a((LinearLayoutManager) this.listView.getLayoutManager())) {
                    this.listView.smoothScrollToPosition(0);
                }
                return true;
            }
        }
        return false;
    }
}
