package com.reddit.frontpage.ui.profile;

import android.animation.LayoutTransition;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.Tab;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import com.crashlytics.android.Crashlytics;
import com.evernote.android.state.State;
import com.evernote.android.state.StateSaver;
import com.reddit.common.rx.PostExecutionThread;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.RedditThemedActivity;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.events.v2.AnalyticsHeartbeatParams;
import com.reddit.frontpage.commons.analytics.events.v2.ScreenviewEventBuilder;
import com.reddit.frontpage.di.component.DaggerProfilePagerComponent;
import com.reddit.frontpage.domain.repository.AccountRepository;
import com.reddit.frontpage.domain.repository.TrophiesRepository;
import com.reddit.frontpage.domain.usecase.AccountUseCase;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.presentation.common.ui.view.listoptions.ListOptionAction;
import com.reddit.frontpage.presentation.common.ui.view.listoptions.ListOptionsDialog;
import com.reddit.frontpage.presentation.onboarding.OnboardingUtil;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.color.ColorSource;
import com.reddit.frontpage.ui.color.ColorSource.OnColorChangedCallback;
import com.reddit.frontpage.ui.color.ColorSourceHelper;
import com.reddit.frontpage.ui.listener.ProfileToolbarOffsetChangedListener;
import com.reddit.frontpage.ui.listing.adapter.ScreenPagerAdapter;
import com.reddit.frontpage.util.AccountUtil;
import com.reddit.frontpage.util.AnimUtil;
import com.reddit.frontpage.util.DeepLinkUtil.ScreenDeepLinker;
import com.reddit.frontpage.util.SchedulerProvider;
import com.reddit.frontpage.util.SimpleOnTabSelectedListener;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import com.reddit.frontpage.widgets.ScreenPager;
import com.reddit.frontpage.widgets.ShapedIconView;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import org.parceler.Parcel;
import timber.log.Timber;

public class ProfilePagerScreen extends BaseScreen implements ColorSource {
    private static final int[] f39253C = new int[]{C1761R.string.title_posts, C1761R.string.title_comments, C1761R.string.title_about};
    ProfilePagerAdapter f39254A;
    CompositeDisposable f39255B;
    @BindView
    View bannerShadow;
    @BindView
    ImageView bannerView;
    @BindView
    CollapsingToolbarLayout collapsingToolbar;
    @BindView
    Button editButton;
    @BindView
    Button followButton;
    @State
    boolean following;
    @BindView
    ViewGroup headerView;
    @BindView
    TextView profileDescription;
    @BindView
    TextView profileDetail1;
    @BindView
    TextView profileDetail2;
    @BindView
    TextView profileDetailSpacer;
    @BindView
    ScreenPager screenPager;
    @State
    int screenPosition;
    @State
    boolean self;
    @State
    String subredditId;
    @State
    String subredditName;
    @BindView
    TabLayout tabLayout;
    @BindView
    TextView toolbarTitle;
    @BindView
    ShapedIconView userIconView;
    @State
    String userId;
    @BindView
    TextView userTitleView;
    @State
    String username;
    @BindView
    TextView usernameView;
    @Inject
    TrophiesRepository f39256v;
    @Inject
    AccountRepository f39257w;
    @Inject
    AccountUseCase f39258x;
    @Inject
    PostExecutionThread f39259y;
    final ColorSource f39260z = new ColorSourceHelper();

    class C23581 implements OnPageChangeListener {
        final /* synthetic */ ProfilePagerScreen f29230a;

        public final void m30327a(int i) {
        }

        public final void m30328a(int i, float f) {
        }

        C23581(ProfilePagerScreen profilePagerScreen) {
            this.f29230a = profilePagerScreen;
        }

        public final void m30329b(int i) {
            BaseScreen baseScreen = (BaseScreen) this.f29230a.f39254A.m35102d(i);
            if (baseScreen != null) {
                AppAnalytics.m21852a(baseScreen.mo7203N());
            }
        }
    }

    @Parcel
    static class DeepLinker implements ScreenDeepLinker {
        int screenPosition;
        String username;

        DeepLinker() {
        }

        public Screen createScreen() {
            return ProfilePagerScreen.m39370a(this.username, this.screenPosition);
        }
    }

    class C26932 extends SimpleOnTabSelectedListener {
        final /* synthetic */ ProfilePagerScreen f34409a;

        C26932(ProfilePagerScreen profilePagerScreen) {
            this.f34409a = profilePagerScreen;
        }

        public final void mo6520a(Tab tab) {
            ProfilePagerScreen.m39371a(this.f34409a, tab.e);
        }
    }

    private class ProfilePagerAdapter extends ScreenPagerAdapter {
        final /* synthetic */ ProfilePagerScreen f37328d;
        private final boolean f37329e;

        ProfilePagerAdapter(ProfilePagerScreen profilePagerScreen) {
            this.f37328d = profilePagerScreen;
            super(profilePagerScreen, true);
            this.f37329e = TextUtils.equals(SessionManager.b().c.getUsername(), profilePagerScreen.username);
        }

        public final Screen mo6953a(int i) {
            if (this.f37328d.username == null) {
                StringBuilder stringBuilder = new StringBuilder("NON-NULL-LOGGING_ProfilePagerScreen.ProfilePagerAdapter.createScreen:username-null=");
                stringBuilder.append(this.f37328d.username == null);
                Timber.e(stringBuilder.toString(), new Object[0]);
            }
            switch (i) {
                case 0:
                    return Nav.m22600l(this.f37328d.username);
                case 1:
                    return Nav.m22602m(this.f37328d.username);
                case 2:
                    return this.f37329e != 0 ? Nav.m22573d() : Nav.m22551a(this.f37328d.username, this.f37328d.userId);
                default:
                    return 0;
            }
        }

        public final int mo6955f() {
            return ProfilePagerScreen.f39253C.length;
        }

        public final CharSequence m37748b(int i) {
            return Util.m24027f(ProfilePagerScreen.f39253C[i]);
        }
    }

    public String getAnalyticsPageType() {
        return "profile";
    }

    public String getAnalyticsScreenName() {
        return "profile";
    }

    public final int mo7141s() {
        return C1761R.layout.screen_profile_pager;
    }

    public ProfilePagerScreen() {
        DaggerProfilePagerComponent.m29251a().mo4725a(this);
    }

    public static ProfilePagerScreen m39369a(String str) {
        ProfilePagerScreen profilePagerScreen = new ProfilePagerScreen();
        Session session = SessionManager.b().c;
        profilePagerScreen.username = str;
        profilePagerScreen.self = TextUtils.equals(str, session.getUsername());
        boolean z = true;
        if (!session.isAnonymous() && TextUtils.equals(str, "me")) {
            profilePagerScreen.username = session.getUsername();
            profilePagerScreen.self = true;
        }
        if (str == null) {
            StringBuilder stringBuilder = new StringBuilder("NON-NULL-LOGGING_ProfilePagerScreen.newInstance1:username-null=");
            if (str != null) {
                z = false;
            }
            stringBuilder.append(z);
            Timber.e(stringBuilder.toString(), new Object[0]);
        }
        return profilePagerScreen;
    }

    public static ProfilePagerScreen m39370a(String str, int i) {
        ProfilePagerScreen profilePagerScreen = new ProfilePagerScreen();
        profilePagerScreen.username = str;
        profilePagerScreen.screenPosition = i;
        return profilePagerScreen;
    }

    public static ScreenDeepLinker m39372b(String str, int i) {
        ScreenDeepLinker deepLinker = new DeepLinker();
        deepLinker.username = str;
        deepLinker.screenPosition = i;
        if (str == null) {
            i = new StringBuilder("NON-NULL-LOGGING_ProfilePagerScreen.deeplink:username-null=");
            i.append(str == null ? true : null);
            Timber.e(i.toString(), new Object[0]);
        }
        return deepLinker;
    }

    protected final void mo7142t() {
        super.mo7142t();
        n();
    }

    public final View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super.mo7139a(layoutInflater, viewGroup);
        ((AppBarLayout) this.K.findViewById(C1761R.id.appbar)).a(new ProfileToolbarOffsetChangedListener(this.collapsingToolbar, this.toolbarTitle));
        this.headerView.setLayoutTransition(new LayoutTransition());
        layoutInflater = Util.m23960a((int) C1761R.string.fmt_u_name, this.username);
        this.userTitleView.setText(this.username);
        this.usernameView.setVisibility(0);
        this.usernameView.setText(layoutInflater);
        this.toolbarTitle.setText(layoutInflater);
        this.profileDetail1.setText(C1761R.string.placeholder_karma_count);
        this.f39254A = new ProfilePagerAdapter(this);
        this.screenPager.setAdapter(this.f39254A);
        this.screenPager.setCurrentItem(this.screenPosition);
        this.screenPager.setOffscreenPageLimit(2);
        this.screenPager.addOnPageChangeListener(new C23581(this));
        this.tabLayout.setupWithViewPager(this.screenPager);
        this.tabLayout.a(new C26932(this));
        return this.K;
    }

    public AnalyticsHeartbeatParams getAnalyticsHeartbeatParams() {
        AnalyticsHeartbeatParams analyticsHeartbeatParams = super.getAnalyticsHeartbeatParams();
        if (!(this.userId == null || this.username == null)) {
            analyticsHeartbeatParams.m21906b(this.userId, this.username);
        }
        if (!(this.subredditId == null || this.subredditName == null)) {
            analyticsHeartbeatParams.m21905a(this.subredditId, this.subredditName);
        }
        return analyticsHeartbeatParams;
    }

    public ScreenviewEventBuilder getAnalyticsScreenviewEvent() {
        ScreenviewEventBuilder analyticsScreenviewEvent = super.getAnalyticsScreenviewEvent();
        if (!(this.userId == null || this.username == null)) {
            analyticsScreenviewEvent.m21930b(this.userId, this.username);
        }
        if (!(this.subredditId == null || this.subredditName == null)) {
            analyticsScreenviewEvent.m21929a(this.subredditId, this.subredditName);
        }
        return analyticsScreenviewEvent;
    }

    protected final void mo6992b(View view) {
        Crashlytics.log("ProfilePagerScreen: uses ScreenPager");
        super.mo6992b(view);
        this.f39255B = new CompositeDisposable();
        if (this.e != null) {
            view = this.f39258x;
            String str = this.username;
            Intrinsics.m26847b(str, "username");
            Object merge = Observable.merge((ObservableSource) view.f20266a.m22394a(str).toObservable(), (ObservableSource) view.f20266a.m22398c(str).flatMapObservable(new AccountUseCase$getAccount$1(view, str)));
            Intrinsics.m26843a(merge, "Observable\n        .merg…              }\n        )");
            this.f39255B.mo5631a(merge.observeOn(SchedulerProvider.m23887c()).subscribe(new ProfilePagerScreen$$Lambda$4(this), new ProfilePagerScreen$$Lambda$5(this)));
        }
    }

    protected final void mo6993c(View view) {
        super.mo6993c(view);
        if (this.f39255B != null) {
            this.f39255B.mo5626a();
        }
    }

    public final void mo6987a(View view) {
        super.mo6987a(view);
        this.f39254A.f34367g = false;
        this.f39254A = null;
    }

    public final void m39381a(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(C1761R.menu.menu_profile, menu);
        menuInflater = menu.findItem(C1761R.id.action_share);
        menuInflater.setIcon(ResourcesUtil.m22737g(am_(), menuInflater.getIcon()));
        menu = menu.findItem(C1761R.id.action_overflow_menu);
        menu.setIcon(ResourcesUtil.m22737g(am_(), menu.getIcon()));
    }

    public final void m39380a(Menu menu) {
        super.a(menu);
        menu = menu.findItem(C1761R.id.action_overflow_menu);
        boolean z = (this.self || SessionManager.b().c.isAnonymous()) ? false : true;
        menu.setVisible(z);
    }

    public final boolean mo7201a(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == C1761R.id.action_overflow_menu) {
            menuItem = new ArrayList();
            if (FrontpageSettings.a().l()) {
                menuItem.add(new ListOptionAction(Util.m24027f((int) C1761R.string.start_chat_label), Integer.valueOf(C1761R.drawable.ic_icon_chat_new), new ProfilePagerScreen$$Lambda$2(this)));
            }
            menuItem.add(new ListOptionAction(Util.m24027f((int) C1761R.string.send_message_label), Integer.valueOf(C1761R.drawable.ic_icon_message), new ProfilePagerScreen$$Lambda$3(this)));
            new ListOptionsDialog(am_(), menuItem).show();
            return true;
        } else if (itemId != C1761R.id.action_share) {
            return super.mo7201a(menuItem);
        } else {
            AccountUtil.m23631a(this, this.username);
            return true;
        }
    }

    public final void mo7202a(int i, int i2, Intent intent) {
        if (i == 1) {
            if (i2 == 1) {
                ((RedditThemedActivity) am_()).m41959b(true);
                return;
            } else if (i2 == 2) {
                OnboardingUtil.m23162a(this);
                return;
            }
        }
        super.mo7202a(i, i2, intent);
    }

    final void m39391d(boolean z) {
        ViewsKt.m24103a(this.followButton, z);
    }

    final void m39379a(int i, boolean z) {
        if (z) {
            AnimUtil.m23639a(this.followButton, new ProfilePagerScreen$$Lambda$8(this, i));
        } else {
            m39377a(i);
        }
    }

    final void m39377a(int i) {
        if (this.following) {
            this.followButton.setText(C1761R.string.action_following);
            this.followButton.setActivated(true);
            i = ResourcesUtil.m22740i(am_(), C1761R.attr.rdt_line_color);
        } else {
            this.followButton.setText(C1761R.string.action_follow);
            this.followButton.setActivated(false);
        }
        if (VERSION.SDK_INT == 21) {
            this.followButton.setBackgroundTintMode(Mode.SRC_IN);
        }
        ViewCompat.a(this.followButton, ColorStateList.valueOf(i));
    }

    final String m39396x() {
        switch (this.screenPager.getCurrentItem()) {
            case 0:
                return "profile_posts";
            case 1:
                return "profile_comments";
            default:
                return "profile_about";
        }
    }

    public final boolean mo7200K() {
        if (this.screenPager != null) {
            Screen d = this.f39254A.m35102d(this.screenPager.getCurrentItem());
            if (d != null) {
                return d.mo7200K();
            }
        }
        return false;
    }

    public final Integer mo4954w() {
        return this.f39260z.mo4954w();
    }

    public final Integer mo4949M() {
        return this.f39260z.mo4949M();
    }

    public final void mo4951a(Integer num) {
        this.f39260z.mo4951a(num);
    }

    public final void mo4953b(Integer num) {
        this.f39260z.mo4953b(num);
    }

    public final void mo4950a(OnColorChangedCallback onColorChangedCallback) {
        this.f39260z.mo4950a(onColorChangedCallback);
    }

    public final void mo4952b(OnColorChangedCallback onColorChangedCallback) {
        this.f39260z.mo4952b(onColorChangedCallback);
    }

    protected final void mo7148d(Bundle bundle) {
        super.mo7148d(bundle);
        StateSaver.saveInstanceState(this, bundle);
    }

    protected final void mo7149e(Bundle bundle) {
        super.mo7149e(bundle);
        StateSaver.restoreInstanceState(this, bundle);
    }

    static /* synthetic */ void m39371a(ProfilePagerScreen profilePagerScreen, int i) {
        String str = "unspecified";
        switch (i) {
            case 0:
                str = "posts";
                break;
            case 1:
                str = "comments";
                break;
            case 2:
                str = "about";
                break;
            default:
                break;
        }
        i = AppAnalytics.m21871h();
        i.f19970c = profilePagerScreen.getAnalyticsScreenName();
        i.f19968a = str;
        i.f19969b = profilePagerScreen.username;
        i.m21832a();
    }
}
