package com.reddit.frontpage.ui;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import com.crashlytics.android.Crashlytics;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.data.feature.settings.InternalSettings;
import com.reddit.datalibrary.frontpage.redditauth.account.AccountUtil;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.redditauth.account.SuspensionUtil;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.commons.analytics.AnalyticsTrackable;
import com.reddit.frontpage.commons.analytics.events.v2.AnalyticsHeartbeatParams;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.presentation.common.ui.Features;
import com.reddit.frontpage.presentation.common.ui.view.RedditSearchView;
import com.reddit.frontpage.presentation.listing.FrontpageListingScreen;
import com.reddit.frontpage.presentation.listing.PopularListingScreen;
import com.reddit.frontpage.ui.home.HomeLoggedOutScreen;
import com.reddit.frontpage.ui.home.HomeTab;
import com.reddit.frontpage.ui.listing.LegacyFrontpageScreen;
import com.reddit.frontpage.ui.listing.LegacyPopularListingScreen;
import com.reddit.frontpage.ui.listing.adapter.ScreenPagerAdapter;
import com.reddit.frontpage.ui.listing.newcard.VisibilityDependent;
import com.reddit.frontpage.util.AppRater;
import com.reddit.frontpage.util.SessionUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.ScreenPager;
import kotlin.jvm.internal.Intrinsics;

public class HomeScreen extends BaseScreen {
    static final int[] f39133v = new int[]{C1761R.string.title_tab_front, C1761R.string.title_tab_popular};
    @BindView
    AppBarLayout appBarLayout;
    @BindView
    ScreenPager screenPager;
    @BindView
    TabLayout tabLayout;
    public int f39134w = -1;
    HomePagerAdapter f39135x;
    private int f39136y = -1;

    class C26811 extends SimpleOnPageChangeListener {
        final /* synthetic */ HomeScreen f34212a;

        C26811(HomeScreen homeScreen) {
            this.f34212a = homeScreen;
        }

        public final void m34903b(int i) {
            if (this.f34212a.e) {
                this.f34212a.f39134w = i;
            }
        }

        public final void m34902a(int i) {
            if (i == 0 && this.f34212a.f39134w >= 0) {
                this.f34212a.m39017b(this.f34212a.f39134w);
                this.f34212a.f39134w = -1;
            }
        }
    }

    private class HomePagerAdapter extends ScreenPagerAdapter {
        final /* synthetic */ HomeScreen f37163d;

        HomePagerAdapter(HomeScreen homeScreen) {
            this.f37163d = homeScreen;
            super(homeScreen, true);
        }

        protected final void mo6954a(Screen screen, int i) {
            HomeTab homeTab = (HomeTab) screen;
            if (i == 0 && !SessionUtil.m23894a()) {
                if (screen instanceof LegacyFrontpageScreen) {
                    HomeScreen.m39016a(this.f37163d, (LegacyFrontpageScreen) screen);
                } else if (screen instanceof FrontpageListingScreen) {
                    ((FrontpageListingScreen) screen).f40563y = new HomeScreen$$Lambda$4(this.f37163d, (FrontpageListingScreen) screen);
                }
            }
            if (this.f37163d.screenPager.getCurrentItem() == i) {
                homeTab.ap();
            }
        }

        public final Screen mo6953a(int i) {
            switch (i) {
                case 0:
                    if (SessionUtil.m23894a() == 0) {
                        if (Features.m22742a() == 0) {
                            i = LegacyFrontpageScreen.m42225w();
                            break;
                        }
                        i = FrontpageListingScreen.ac();
                        break;
                    }
                    i = HomeLoggedOutScreen.m39147w();
                    break;
                case 1:
                    if (Features.m22743b() == 0) {
                        i = LegacyPopularListingScreen.m42520w();
                        break;
                    }
                    i = PopularListingScreen.m42012Y();
                    break;
                default:
                    i = 0;
                    break;
            }
            return (Screen) i;
        }

        public final int mo6955f() {
            return HomeScreen.f39133v.length;
        }

        public final CharSequence m37544b(int i) {
            return Util.m24027f(HomeScreen.f39133v[i]);
        }
    }

    protected final boolean af_() {
        return true;
    }

    public final int mo7141s() {
        return C1761R.layout.screen_home;
    }

    public static HomeScreen m39019w() {
        return new HomeScreen();
    }

    public final int m39030x() {
        return this.f39134w;
    }

    protected final void mo7142t() {
        super.mo7142t();
    }

    public final View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        boolean z;
        TextView textView;
        super.mo7139a(layoutInflater, viewGroup);
        layoutInflater = InternalSettings.a();
        AppConfiguration t = FrontpageSettings.a().t();
        if (t.experiments != null) {
            if (t.experiments.new_user_alert != null) {
                z = t.experiments.new_user_alert.active;
                if (z && !layoutInflater.a.getBoolean("com.reddit.frontpage.seen_new_user_experiment", false)) {
                    viewGroup.postDelayed(new HomeScreen$$Lambda$2(this, layoutInflater), 1000);
                }
                this.appBarLayout.a(new HomeScreen$$Lambda$0(this));
                this.f39135x = new HomePagerAdapter(this);
                this.screenPager.setAdapter(this.f39135x);
                this.tabLayout.setupWithViewPager(this.screenPager);
                this.screenPager.addOnPageChangeListener(new C26811(this));
                layoutInflater = SessionManager.b();
                if (!(AccountUtil.a(layoutInflater) == null || ao_() == null)) {
                    if (SuspensionUtil.a(layoutInflater) == null) {
                        layoutInflater = SuspensionUtil.b(layoutInflater);
                        layoutInflater = ao_().getQuantityString(C1761R.plurals.account_suspended_temporary, layoutInflater, new Object[]{Integer.valueOf(layoutInflater)});
                    } else {
                        layoutInflater = Util.m24027f((int) C1761R.string.account_suspended_permanent);
                    }
                    layoutInflater = Snackbar.a(this.K, layoutInflater, 0);
                    textView = (TextView) layoutInflater.d.findViewById(C1761R.id.snackbar_text);
                    textView.setCompoundDrawablesRelativeWithIntrinsicBounds(C1761R.drawable.ic_user_banned_small, 0, 0, 0);
                    textView.setCompoundDrawablePadding(ao_().getDimensionPixelOffset(C1761R.dimen.snackbar_icon_padding));
                    layoutInflater.a();
                }
                ((RedditSearchView) this.K.findViewById(C1761R.id.search_view)).m34598a(new HomeScreen$$Lambda$1(this));
                return this.K;
            }
        }
        z = false;
        viewGroup.postDelayed(new HomeScreen$$Lambda$2(this, layoutInflater), 1000);
        this.appBarLayout.a(new HomeScreen$$Lambda$0(this));
        this.f39135x = new HomePagerAdapter(this);
        this.screenPager.setAdapter(this.f39135x);
        this.tabLayout.setupWithViewPager(this.screenPager);
        this.screenPager.addOnPageChangeListener(new C26811(this));
        layoutInflater = SessionManager.b();
        if (SuspensionUtil.a(layoutInflater) == null) {
            layoutInflater = Util.m24027f((int) C1761R.string.account_suspended_permanent);
        } else {
            layoutInflater = SuspensionUtil.b(layoutInflater);
            layoutInflater = ao_().getQuantityString(C1761R.plurals.account_suspended_temporary, layoutInflater, new Object[]{Integer.valueOf(layoutInflater)});
        }
        layoutInflater = Snackbar.a(this.K, layoutInflater, 0);
        textView = (TextView) layoutInflater.d.findViewById(C1761R.id.snackbar_text);
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(C1761R.drawable.ic_user_banned_small, 0, 0, 0);
        textView.setCompoundDrawablePadding(ao_().getDimensionPixelOffset(C1761R.dimen.snackbar_icon_padding));
        layoutInflater.a();
        ((RedditSearchView) this.K.findViewById(C1761R.id.search_view)).m34598a(new HomeScreen$$Lambda$1(this));
        return this.K;
    }

    protected final void mo6992b(View view) {
        Crashlytics.log("HomeScreen: uses ScreenPager");
        super.mo6992b(view);
        AppRater.m23644a((Screen) this);
        if (this.f39136y >= null && this.f39136y != this.screenPager.getCurrentItem()) {
            this.screenPager.setCurrentItem(this.f39136y);
            this.f39136y = -1;
        }
        m39017b(this.screenPager.getCurrentItem());
    }

    public final void mo6987a(View view) {
        super.mo6987a(view);
        this.f39135x.f34367g = false;
        this.f39135x = null;
    }

    public final boolean mo7201a(MenuItem menuItem) {
        if (menuItem.getItemId() != C1761R.id.action_search) {
            return super.mo7201a(menuItem);
        }
        Routing.m22623a((Screen) this, Nav.m22603n(null));
        return true;
    }

    protected final void mo7185a(ActionBar actionBar) {
        actionBar.c(false);
        actionBar.b(false);
    }

    private <T extends Screen & VisibilityDependent> void m39017b(int i) {
        if (this.f39135x != null) {
            for (int i2 = 0; i2 < f39133v.length; i2++) {
                Screen d = this.f39135x.m35102d(i2);
                if (d != null) {
                    if (i == i2) {
                        ((VisibilityDependent) d).ap();
                    } else {
                        ((VisibilityDependent) d).aq();
                    }
                }
            }
        }
    }

    public final boolean mo7200K() {
        if (this.screenPager == null) {
            return false;
        }
        Screen d = this.f39135x.m35102d(this.screenPager.getCurrentItem());
        if (!(d == null || d.mo7200K())) {
            this.screenPager.setCurrentItem(0, true);
        }
        return true;
    }

    public String getAnalyticsPageType() {
        if (this.screenPager != null) {
            Screen d = this.f39135x.m35102d(this.screenPager.getCurrentItem());
            if (d instanceof AnalyticsTrackable) {
                return ((AnalyticsTrackable) d).getAnalyticsPageType();
            }
        }
        return super.getAnalyticsPageType();
    }

    public AnalyticsHeartbeatParams getAnalyticsHeartbeatParams() {
        if (this.screenPager != null) {
            Screen d = this.f39135x.m35102d(this.screenPager.getCurrentItem());
            if (d instanceof AnalyticsTrackable) {
                return ((AnalyticsTrackable) d).getAnalyticsHeartbeatParams();
            }
        }
        return super.getAnalyticsHeartbeatParams();
    }

    public final void m39023a(int i) {
        if (this.e) {
            this.screenPager.setCurrentItem(i);
        } else {
            this.f39136y = i;
        }
    }

    static /* synthetic */ void m39016a(HomeScreen homeScreen, LegacyFrontpageScreen legacyFrontpageScreen) {
        OnClickListener homeScreen$$Lambda$3 = new HomeScreen$$Lambda$3(homeScreen, legacyFrontpageScreen);
        Intrinsics.m26847b(homeScreen$$Lambda$3, "listener");
        legacyFrontpageScreen.f40605N = homeScreen$$Lambda$3;
    }
}
