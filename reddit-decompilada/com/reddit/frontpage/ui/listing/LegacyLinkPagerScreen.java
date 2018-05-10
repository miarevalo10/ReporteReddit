package com.reddit.frontpage.ui.listing;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.bluelinelabs.conductor.Controller;
import com.crashlytics.android.Crashlytics;
import com.evernote.android.state.State;
import com.evernote.android.state.StateSaver;
import com.reddit.datalibrary.frontpage.data.feature.link.repo.LegacyLinkRepository;
import com.reddit.datalibrary.frontpage.data.feature.settings.InternalSettings;
import com.reddit.datalibrary.frontpage.data.provider.LinkListingProvider;
import com.reddit.datalibrary.frontpage.data.provider.LinkListingProvider.LoadCompleteListingEvent;
import com.reddit.datalibrary.frontpage.data.provider.ProviderManager;
import com.reddit.datalibrary.frontpage.data.provider.ProviderSpec;
import com.reddit.datalibrary.frontpage.requests.models.v2.ClientLink;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listing;
import com.reddit.frontpage.BaseActivity;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.commons.analytics.AnalyticsTrackable;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.events.v2.AnalyticsHeartbeatParams;
import com.reddit.frontpage.commons.analytics.performance.ListingPerformanceTracker;
import com.reddit.frontpage.debug.RedditLogger;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.HasToolbar;
import com.reddit.frontpage.ui.color.ColorSource;
import com.reddit.frontpage.ui.color.ColorSource.OnColorChangedCallback;
import com.reddit.frontpage.ui.detail.BaseDetailScreen;
import com.reddit.frontpage.ui.detail.OnLinkActionListener;
import com.reddit.frontpage.ui.detail.image.ImageDetailScreen;
import com.reddit.frontpage.ui.detail.self.SelfDetailScreen;
import com.reddit.frontpage.ui.detail.video.VideoDetailScreen;
import com.reddit.frontpage.ui.detail.video.VideoDetailScreenLegacy;
import com.reddit.frontpage.ui.detail.web.WebDetailScreen;
import com.reddit.frontpage.ui.detail.xpost.XPostImageDetailScreen;
import com.reddit.frontpage.ui.detail.xpost.XPostSmallDetailScreen;
import com.reddit.frontpage.ui.detail.xpost.XPostVideoDetailScreen;
import com.reddit.frontpage.ui.detail.xpost.XPostVideoLegacyDetailScreen;
import com.reddit.frontpage.ui.listing.adapter.ScreenPagerAdapter;
import com.reddit.frontpage.ui.listing.adapter.ads.AdVisibilityTracker;
import com.reddit.frontpage.util.LinkUtil;
import com.reddit.frontpage.util.ModUtil;
import com.reddit.frontpage.util.Nimbledroid.Scenario;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.ScreenPager;
import com.reddit.frontpage.widgets.modtools.modqueue.ModModeable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
import org.parceler.Parcels;

public class LegacyLinkPagerScreen extends BaseScreen implements ColorSource, OnColorChangedCallback, OnLinkActionListener, ModModeable {
    private PagerProvider f39215A;
    private AdVisibilityTracker f39216B;
    private List<OnColorChangedCallback> f39217C = new ArrayList();
    private int f39218D;
    @State
    int feedPosition = -1;
    @State
    String listingInstanceId;
    @State
    int pagerPosition = -1;
    @State
    String sourcePage;
    PagerAdapter f39219v;
    protected Listing<Listable> f39220w;
    @Inject
    LegacyLinkRepository f39221x;
    private ScreenPager f39222y;
    private LinkListingProvider f39223z;

    private interface PagerProvider {
        List<Integer> mo4982a();

        void mo4983a(int i);

        boolean mo4984b();

        int mo4985c();
    }

    class C23401 implements OnPageChangeListener {
        final /* synthetic */ LegacyLinkPagerScreen f29043a;

        public final void m30096a(int i) {
        }

        public final void m30097a(int i, float f) {
        }

        C23401(LegacyLinkPagerScreen legacyLinkPagerScreen) {
            this.f29043a = legacyLinkPagerScreen;
        }

        public final void m30098b(int i) {
            this.f29043a.f39215A.mo4983a(i);
            this.f29043a.pagerPosition = i;
            LegacyLinkPagerScreen.m39273a(this.f29043a, i - 1);
            this.f29043a.m39284a(i, true);
            LegacyLinkPagerScreen.m39273a(this.f29043a, i + 1);
        }
    }

    private static class LinksPagerProvider implements PagerProvider {
        private final List<ClientLink> f29044a;

        public final void mo4983a(int i) {
        }

        public final boolean mo4984b() {
            return true;
        }

        private LinksPagerProvider(List<ClientLink> list) {
            this.f29044a = list;
        }

        public final List<Integer> mo4982a() {
            List<Integer> arrayList = new ArrayList(this.f29044a.size());
            for (int i = 0; i < this.f29044a.size(); i++) {
                arrayList.add(Integer.valueOf(i));
            }
            return arrayList;
        }

        public final int mo4985c() {
            return this.f29044a.size();
        }
    }

    private class MixedPagerProvider implements PagerProvider {
        final /* synthetic */ LegacyLinkPagerScreen f29045a;

        private MixedPagerProvider(LegacyLinkPagerScreen legacyLinkPagerScreen) {
            this.f29045a = legacyLinkPagerScreen;
        }

        public final void mo4983a(int i) {
            if (i >= this.f29045a.f39220w.size() - (5 + this.f29045a.f39223z.ignoreLinkForPagingCount) && this.f29045a.f39220w.getAfter() != 0) {
                this.f29045a.f39223z.b(ListingPerformanceTracker.m21961a(this.f29045a.m39266O()));
            }
        }

        public final List<Integer> mo4982a() {
            if (this.f29045a.f39220w != null) {
                return this.f29045a.f39223z.linkPositions;
            }
            return Collections.emptyList();
        }

        public final boolean mo4984b() {
            List list = this.f29045a.f39223z.linkPositions;
            if (list.isEmpty()) {
                return true;
            }
            int size = list.size() - 1;
            if (((Integer) list.get(size)).intValue() == size) {
                return true;
            }
            return false;
        }

        public final int mo4985c() {
            return this.f29045a.f39220w != null ? this.f29045a.f39220w.size() : 0;
        }
    }

    private class PagerAdapter extends ScreenPagerAdapter {
        int f37264d;
        int f37265e = 0;
        final /* synthetic */ LegacyLinkPagerScreen f37266f;
        private final String f37267h;

        PagerAdapter(LegacyLinkPagerScreen legacyLinkPagerScreen, String str) {
            this.f37266f = legacyLinkPagerScreen;
            super(legacyLinkPagerScreen, false);
            this.f37267h = str;
        }

        protected final void mo6954a(Screen screen, int i) {
            screen.a_(1);
        }

        public final Screen mo6953a(int i) {
            Controller a;
            i = this.f37266f.m39269a(i);
            while (!(this.f37266f.f39220w.get(this.f37265e + i) instanceof Link)) {
                String a2 = LegacyLinkPagerScreen.m39272a(this.f37266f.f39215A.mo4982a());
                Throwable illegalStateException = new IllegalStateException();
                StringBuilder stringBuilder = new StringBuilder("Skipping position ");
                stringBuilder.append(this.f37265e + i);
                stringBuilder.append(" link positions = ");
                stringBuilder.append(a2);
                RedditLogger.m21983a(illegalStateException, stringBuilder.toString());
                this.f37265e++;
            }
            Link link = (Link) this.f37266f.f39220w.get(this.f37265e + i);
            Bundle bundle = new Bundle();
            bundle.putInt("com.reddit.arg.position", i);
            bundle.putBoolean("com.reddit.arg.enableScreenViewEvents", false);
            bundle.putString("com.reddit.arg.sourcePage", this.f37267h);
            bundle.putBoolean("com.reddit.arg.fromFeed", true);
            if (link.getLinkType() == 10) {
                Link link2 = (ClientLink) link.getCrosspostParentList().get(0);
                if (Util.m24043l(link2)) {
                    a = XPostImageDetailScreen.m42481a(link, bundle);
                } else if (link2.isVideo()) {
                    a = XPostVideoDetailScreen.m42487a(link, bundle);
                } else if (Util.m24010c(link2)) {
                    a = XPostVideoLegacyDetailScreen.m42501a(link, bundle);
                } else {
                    a = XPostSmallDetailScreen.m42484a(link, bundle);
                }
            } else if (link.isSelf()) {
                a = SelfDetailScreen.m42157a(link, bundle);
            } else if (Util.m24010c(link)) {
                if (link.isVideo()) {
                    if (!InternalSettings.a().q()) {
                        a = VideoDetailScreen.m42165a(link, bundle);
                    }
                }
                a = VideoDetailScreenLegacy.m42203a(link, bundle);
            } else if (Util.m24043l(link)) {
                a = ImageDetailScreen.m42154a(link, bundle);
            } else {
                a = WebDetailScreen.m42213a(link, bundle);
            }
            a.m29363b(this.f37266f);
            a.a.putBoolean("com.reddit.arg.mark_read", false);
            if (this.f37266f.pagerPosition != i) {
                a.a.putBoolean("com.reddit.arg.immediate_view", false);
            }
            if (link.isPromoted() != 0) {
                a.f39161S = this.f37266f.f39216B;
            }
            return a;
        }

        public final int mo6955f() {
            return this.f37264d;
        }

        public final void m37596d() {
            int i;
            if (this.f37266f.f39215A == null) {
                i = 0;
            } else if (this.f37266f.f39215A.mo4982a() != null) {
                i = this.f37266f.f39215A.mo4982a().size();
            } else {
                i = this.f37266f.f39215A.mo4985c();
            }
            this.f37264d = i;
            super.d();
        }
    }

    public final int mo7141s() {
        return C1761R.layout.fragment_pager;
    }

    public final int mo7143u() {
        return 2;
    }

    public LegacyLinkPagerScreen(Bundle bundle) {
        super(bundle);
        FrontpageApplication.m28868d().a(this);
        n();
        ModUtil.m23838e();
    }

    public final View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.f39222y = (ScreenPager) super.mo7139a(layoutInflater, viewGroup);
        this.f39216B = new AdVisibilityTracker(am_());
        if (this.f39220w == null) {
            this.f39220w = this.f39223z.listing;
        }
        if (this.feedPosition < null) {
            RedditLogger.m21982a("Using MixedPagerProvider");
            layoutInflater = new MixedPagerProvider();
        } else {
            RedditLogger.m21982a("Using LinksPagerProvider");
            layoutInflater = new LinksPagerProvider(Collections.emptyList());
        }
        this.f39215A = layoutInflater;
        this.f39222y.addOnPageChangeListener(new C23401(this));
        this.f39219v = new PagerAdapter(this, this.sourcePage);
        this.f39222y.setAdapter(this.f39219v);
        this.f39222y.setEnabled(false);
        Scenario.f21766b.m23847b();
        return this.K;
    }

    protected final void mo6992b(View view) {
        Crashlytics.log("LegacyLinkPagerScreen: uses ScreenPager");
        super.mo6992b(view);
        view = ListingPerformanceTracker.m21961a(m39266O());
        if (this.f39220w != null) {
            m39267P();
            this.f39219v.m37596d();
        } else {
            this.f39223z.a(false, view);
        }
        this.f39222y.setCurrentItem(this.pagerPosition);
        this.f39222y.post(new LegacyLinkPagerScreen$$Lambda$0(this));
        this.f39216B.m23449a();
    }

    protected final void mo6993c(View view) {
        super.mo6993c(view);
        this.f39216B.m23452b();
    }

    public final void mo6987a(View view) {
        super.mo6987a(view);
        this.f39219v.f34367g = false;
        this.f39219v = null;
    }

    protected final void mo6991b(Bundle bundle) {
        super.mo6991b(bundle);
        StateSaver.saveInstanceState(this, bundle);
    }

    protected final void mo7199c(Bundle bundle) {
        super.mo7199c(bundle);
        StateSaver.restoreInstanceState(this, bundle);
    }

    private String m39266O() {
        BaseDetailScreen baseDetailScreen = (BaseDetailScreen) this.f39219v.m35102d(this.pagerPosition);
        return baseDetailScreen != null ? baseDetailScreen.getAnalyticsScreenName() : null;
    }

    public String getAnalyticsPageType() {
        if (this.f39219v != null) {
            Screen d = this.f39219v.m35102d(this.pagerPosition);
            if (d instanceof AnalyticsTrackable) {
                return ((AnalyticsTrackable) d).getAnalyticsPageType();
            }
        }
        return super.getAnalyticsPageType();
    }

    public AnalyticsHeartbeatParams getAnalyticsHeartbeatParams() {
        if (this.f39219v != null && this.pagerPosition >= 0) {
            Screen d = this.f39219v.m35102d(this.pagerPosition);
            if (d instanceof AnalyticsTrackable) {
                return ((AnalyticsTrackable) d).getAnalyticsHeartbeatParams();
            }
        }
        return super.getAnalyticsHeartbeatParams();
    }

    public void onEventMainThread(LoadCompleteListingEvent loadCompleteListingEvent) {
        m39267P();
    }

    final <T extends BaseDetailScreen & HasToolbar> void m39284a(int i, boolean z) {
        BaseDetailScreen baseDetailScreen = (BaseDetailScreen) this.f39219v.m35102d(i);
        if (baseDetailScreen != null) {
            if (z) {
                z = AppAnalytics.m21858b();
                z.f19954a = baseDetailScreen.getAnalyticsScreenName();
                z.f19955b = "swipe_advance";
                z.m21825a();
            }
            Context context = (BaseActivity) am_();
            Toolbar toolbar = baseDetailScreen.toolbar;
            if (toolbar != null) {
                context.a(toolbar);
                context.c().a().c(false);
                context.c().a().b(true);
                context.c().a().a(ResourcesUtil.m22736g(context, (int) C1761R.drawable.ic_icon_close));
                context.supportInvalidateOptionsMenu();
                toolbar.setNavigationOnClickListener(new LegacyLinkPagerScreen$$Lambda$1(this));
            }
            for (OnColorChangedCallback onColorChangedCallback : this.f39217C) {
                onColorChangedCallback.mo4943c(mo4954w());
                onColorChangedCallback.mo4944d(mo4949M());
            }
            baseDetailScreen.mo4950a((OnColorChangedCallback) this);
            baseDetailScreen.mo7690f(true);
            baseDetailScreen.m39096R();
            z = this.f39219v;
            LinkUtil.m23786a((Link) this.f39223z.listing.get(z.f37265e + m39269a(i)), this.f39221x);
        }
    }

    public final void m39286a(Menu menu, MenuInflater menuInflater) {
        super.a(menu, menuInflater);
        Screen d = this.f39219v.m35102d(this.f39222y.getCurrentItem());
        if (d != null) {
            d.a(menu, menuInflater);
        }
    }

    public final void m39285a(Menu menu) {
        super.a(menu);
        Screen d = this.f39219v.m35102d(this.f39222y.getCurrentItem());
        if (d != null) {
            d.a(menu);
        }
    }

    public final boolean mo7201a(MenuItem menuItem) {
        Screen d = this.f39219v.m35102d(this.f39222y.getCurrentItem());
        if (d != null) {
            return d.mo7201a(menuItem);
        }
        return super.mo7201a(menuItem);
    }

    public final boolean mo6986J() {
        if (this.f39219v != null) {
            Screen d = this.f39219v.m35102d(this.pagerPosition);
            if (d != null) {
                return d.mo6986J();
            }
        }
        return false;
    }

    private void m39267P() {
        this.f39220w = this.f39223z.listing;
        if (this.pagerPosition == -1) {
            int i = this.f39218D;
            if (!this.f39215A.mo4984b()) {
                i = this.f39215A.mo4982a().indexOf(Integer.valueOf(i));
            }
            this.pagerPosition = i;
        }
        boolean z = this.f39220w.size() > 0;
        this.f39222y.setEnabled(z);
        if (z) {
            this.f39219v.m37596d();
            this.f39222y.setCurrentItem(this.pagerPosition, false);
        }
    }

    private Screen m39268Q() {
        return this.f39219v.m35102d(this.pagerPosition);
    }

    public final void mo7146x() {
        ai_();
    }

    public final void mo7147y() {
        ai_();
    }

    public final void q_() {
        ai_();
    }

    public final Integer mo4954w() {
        Screen Q = m39268Q();
        return Q instanceof ColorSource ? ((ColorSource) Q).mo4954w() : null;
    }

    public final void mo4951a(Integer num) {
        throw new UnsupportedOperationException();
    }

    public final Integer mo4949M() {
        Screen Q = m39268Q();
        return Q instanceof ColorSource ? ((ColorSource) Q).mo4949M() : null;
    }

    public final void mo4953b(Integer num) {
        throw new UnsupportedOperationException();
    }

    public final void mo4950a(OnColorChangedCallback onColorChangedCallback) {
        this.f39217C.add(onColorChangedCallback);
    }

    public final void mo4952b(OnColorChangedCallback onColorChangedCallback) {
        this.f39217C.remove(onColorChangedCallback);
    }

    public final void mo4943c(Integer num) {
        for (OnColorChangedCallback c : this.f39217C) {
            c.mo4943c(num);
        }
    }

    public final void mo4944d(Integer num) {
        for (OnColorChangedCallback d : this.f39217C) {
            d.mo4944d(num);
        }
    }

    private int m39269a(int i) {
        List a = this.f39215A.mo4982a();
        StringBuilder stringBuilder = new StringBuilder("calcProviderPosition(%1$d), linkPositions is null = ");
        stringBuilder.append(a);
        RedditLogger.m21982a(String.format(stringBuilder.toString() == null ? "true" : "false", new Object[]{Integer.valueOf(i)}));
        return a != null ? ((Integer) a.get(i)).intValue() : i;
    }

    public static LegacyLinkPagerScreen m39271a(String str, LinkListingProvider linkListingProvider, int i, String str2) {
        Object a = linkListingProvider.a();
        Bundle bundle = new Bundle();
        bundle.putString("args.listing_id", str);
        bundle.putParcelable("args.provider_spec", Parcels.m28672a(a));
        str = new LegacyLinkPagerScreen(bundle);
        str.f39223z = linkListingProvider;
        str.f39218D = i;
        str.feedPosition = -1;
        str.sourcePage = str2;
        return str;
    }

    protected final void mo7144v() {
        Bundle bundle = this.a;
        String string = bundle.getString("args.listing_id");
        ProviderSpec providerSpec = (ProviderSpec) Parcels.m28673a(bundle.getParcelable("args.provider_spec"));
        if (this.f39223z == null) {
            ProviderManager providerManager = ProviderManager.b;
            this.f39223z = (LinkListingProvider) ProviderManager.a(string, providerSpec);
        }
        m37523a(this.f39223z);
    }

    public final /* bridge */ /* synthetic */ Screen mo7220H() {
        return (BaseLinkListingScreen) super.mo7220H();
    }

    static /* synthetic */ void m39273a(LegacyLinkPagerScreen legacyLinkPagerScreen, int i) {
        BaseDetailScreen baseDetailScreen = (BaseDetailScreen) legacyLinkPagerScreen.f39219v.m35102d(i);
        if (baseDetailScreen != null) {
            baseDetailScreen.mo4952b((OnColorChangedCallback) legacyLinkPagerScreen);
            baseDetailScreen.mo7690f((boolean) null);
        }
    }

    static /* synthetic */ String m39272a(List list) {
        StringBuilder stringBuilder = new StringBuilder();
        if (list == null) {
            stringBuilder.append("positions are null");
        } else {
            for (Integer append : list) {
                stringBuilder.append(append);
                stringBuilder.append(' ');
            }
        }
        return stringBuilder.toString();
    }
}
