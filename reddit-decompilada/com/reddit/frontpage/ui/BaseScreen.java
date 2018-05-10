package com.reddit.frontpage.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import bolts.AggregateException;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.android.volley.VolleyError;
import com.evernote.android.state.State;
import com.livefront.bridge.Bridge;
import com.reddit.datalibrary.frontpage.data.common.busevents.ErrorEvent;
import com.reddit.datalibrary.frontpage.data.common.busevents.MessageEvent;
import com.reddit.datalibrary.frontpage.data.provider.BaseOtherProvider;
import com.reddit.datalibrary.frontpage.data.provider.ProviderManager;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.RedditThemedActivity;
import com.reddit.frontpage.commons.analytics.AnalyticsTrackable;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.events.v1.ScreenViewEvent;
import com.reddit.frontpage.commons.analytics.events.v2.AnalyticsHeartbeatParams;
import com.reddit.frontpage.commons.analytics.events.v2.ScreenviewEventBuilder;
import com.reddit.frontpage.di.component.DaggerNavUserAccountComponent;
import com.reddit.frontpage.domain.usecase.AccountInfoUseCase;
import com.reddit.frontpage.domain.usecase.AccountInfoUseCase.AccountInfoUseCaseParams;
import com.reddit.frontpage.domain.usecase.AccountInfoUseCase.Avatar;
import com.reddit.frontpage.domain.usecase.AccountInfoUseCase.Avatar.AnonymousAvatar;
import com.reddit.frontpage.domain.usecase.AccountInfoUseCase.Avatar.RealAvatar;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.nav.Screens;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.presentation.navdrawer.RedditNavHeaderContract;
import com.reddit.frontpage.presentation.navdrawer.RedditNavHeaderPresenter;
import com.reddit.frontpage.presentation.navdrawer.RedditNavHeaderView;
import com.reddit.frontpage.presentation.onboarding.OnboardingUtil;
import com.reddit.frontpage.presentation.postoption.PostOptionsScreen;
import com.reddit.frontpage.util.AvatarUtilKt;
import com.reddit.frontpage.util.SessionUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.InvalidatableManager;
import com.reddit.frontpage.widgets.video.VideoPlayerOld;
import de.greenrobot.event.EventBus;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

public abstract class BaseScreen extends GlideLifecycleScreen implements AnalyticsTrackable {
    private Unbinder f37152A;
    private Toolbar f37153B;
    public final InvalidatableManager f37154I;
    DrawerLayout f37155J;
    protected View f37156K;
    public FloatingActionsCallback f37157L;
    @State
    protected String eventRequestId;
    @State
    public boolean suppressScreenViewEvent;
    private RedditNavHeaderPresenter f37158v;
    private Disposable f37159w;
    private AccountInfoUseCase f37160x;
    private final Map<String, BaseOtherProvider> f37161y;
    private boolean f37162z;

    public interface FloatingActionsCallback {
    }

    public void mo7185a(ActionBar actionBar) {
    }

    public boolean af_() {
        return false;
    }

    public String getAnalyticsPageType() {
        return null;
    }

    public String getAnalyticsScreenName() {
        return null;
    }

    public abstract int mo7141s();

    public void mo7142t() {
    }

    public void mo7144v() {
    }

    protected BaseScreen() {
        this(null);
    }

    protected BaseScreen(Bundle bundle) {
        super(bundle);
        this.f37154I = new InvalidatableManager();
        this.f37161y = new HashMap();
    }

    protected final void mo6985A() {
        if (!this.f37162z) {
            mo7142t();
            mo7144v();
            this.f37162z = true;
        }
    }

    public View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.f37156K = layoutInflater.inflate(mo7141s(), viewGroup, false);
        this.f37152A = ButterKnife.a(this, this.f37156K);
        this.f37153B = at();
        if (am_() != null) {
            this.f37155J = (DrawerLayout) am_().findViewById(C1761R.id.drawer_layout);
        }
        return this.f37156K;
    }

    public void ae_() {
        this.f37152A.a();
        this.f37156K = null;
        this.f37153B = null;
        this.f37155J = null;
        this.f37157L = null;
    }

    protected final void m37537h(String str) {
        ActionBar a = ((AppCompatActivity) am_()).c().a();
        if (a != null) {
            a.a(str);
        }
    }

    protected final Toolbar at() {
        return (Toolbar) this.f37156K.findViewById(C1761R.id.toolbar);
    }

    public void mo6987a(View view) {
        super.mo6987a(view);
        mo7241c("onDestroyView");
        VideoPlayerOld.m24377a(view);
    }

    public void mo7209b(Activity activity) {
        super.b(activity);
        if (this.e != null) {
            activity = ProviderManager.b;
            ProviderManager.a(this.l, this.f37161y);
        }
    }

    public void mo6992b(View view) {
        super.mo6992b(view);
        ProviderManager providerManager = ProviderManager.b;
        ProviderManager.a(this.l, this.f37161y);
        mo7241c("onAttach");
        AppAnalytics.m21860b(view, getAnalyticsScreenName());
        AppAnalytics.m21865c(view, getAnalyticsPageType());
        E_();
        if (this.f37153B != null) {
            au();
        } else if (this.f37155J != null && af_() == null) {
            this.f37155J.setDrawerLockMode(1);
        }
        if (EventBus.getDefault().isRegistered(this) == null) {
            EventBus.getDefault().registerSticky(this);
        }
        if (this.f37158v != null) {
            this.f37158v.attach();
        }
        Timber.b("entered screen: %s", new Object[]{getClass().getSimpleName()});
    }

    private void mo7241c(String str) {
        Util.m24009c(getClass().getSimpleName(), str);
    }

    public void au() {
        AppCompatActivity appCompatActivity = (AppCompatActivity) am_();
        appCompatActivity.a(this.f37153B);
        if (this.f37155J != null) {
            if (am_() != null) {
                if (af_()) {
                    this.f37155J.setDrawerLockMode(0);
                    boolean a = SessionUtil.m23894a();
                    NavigationView navigationView = (NavigationView) am_().findViewById(C1761R.id.nav_view);
                    navigationView.getMenu().clear();
                    if (a) {
                        navigationView.a(C1761R.menu.activity_main_drawer_logged_out);
                    } else {
                        navigationView.a(C1761R.menu.activity_main_drawer);
                    }
                    navigationView.setNavigationItemSelectedListener(new BaseScreen$$Lambda$3(this));
                    if (am_() != null) {
                        this.f37160x = FrontpageApplication.m28875k().mo4615c();
                        RedditNavHeaderContract.View view = (RedditNavHeaderView) navigationView.c.b.getChildAt(0);
                        this.f37158v = DaggerNavUserAccountComponent.m29194a().mo4690a(FrontpageApplication.m28875k()).mo4691a(view).mo4692a().mo4693b();
                        ImageView imageView = (ImageView) view.findViewById(C1761R.id.nav_drawer_avatar);
                        if (a) {
                            imageView.setOnClickListener(new BaseScreen$$Lambda$4(this));
                        } else {
                            imageView.setOnClickListener(new BaseScreen$$Lambda$5(this));
                            view.findViewById(C1761R.id.nav_user_name).setOnClickListener(new BaseScreen$$Lambda$6(this));
                        }
                    }
                    Button button = (Button) navigationView.findViewById(C1761R.id.nav_settings);
                    button.setCompoundDrawablesRelative(ResourcesUtil.m22735f(am_(), button.getCompoundDrawablesRelative()[0]), null, null, null);
                    button.setOnClickListener(new BaseScreen$$Lambda$7(this));
                    ((ImageButton) navigationView.findViewById(C1761R.id.nav_night_theme)).setOnClickListener(new BaseScreen$$Lambda$8(this));
                    if (am_() != null) {
                        ImageView imageView2 = (ImageView) this.f37153B.findViewById(C1761R.id.nav_icon);
                        if (a) {
                            m37524a(AnonymousAvatar.f27958a, imageView2);
                        } else {
                            Object e = SessionUtil.m23899e();
                            if (TextUtils.isEmpty(e)) {
                                m37524a(AnonymousAvatar.f27958a, imageView2);
                            } else {
                                if (this.f37159w != null) {
                                    this.f37159w.mo5626a();
                                }
                                this.f37159w = this.f37160x.m22528b(new AccountInfoUseCaseParams(e)).observeOn(FrontpageApplication.m28875k().mo4633u().a()).subscribe(new BaseScreen$$Lambda$0(this, imageView2), BaseScreen$$Lambda$1.f28866a);
                            }
                        }
                        imageView2.setOnClickListener(new BaseScreen$$Lambda$2(this));
                    }
                } else {
                    this.f37155J.setDrawerLockMode(1);
                }
            }
        }
        ActionBar a2 = appCompatActivity.c().a();
        Routing.m22622a((Screen) this, a2);
        mo7185a(a2);
    }

    final void m37524a(Avatar avatar, ImageView imageView) {
        if (avatar instanceof RealAvatar) {
            AvatarUtilKt.m23659a(imageView, ((RealAvatar) avatar).f27959a, null, null);
        } else if (avatar instanceof AnonymousAvatar) {
            imageView.setImageDrawable(ResourcesUtil.m22734f(am_(), (int) C1761R.drawable.ic_icon_redditor));
        } else {
            StringBuilder stringBuilder = new StringBuilder("Didn't handle avatar type ");
            stringBuilder.append(avatar.getClass().getSimpleName());
            throw new RuntimeException(stringBuilder.toString());
        }
    }

    public void mo7202a(int i, int i2, Intent intent) {
        if (i == 1 && am_() != null) {
            switch (i2) {
                case 1:
                    ((RedditThemedActivity) am_()).m41959b(true);
                    return;
                case 2:
                    OnboardingUtil.m23162a(this);
                    return;
                default:
                    break;
            }
        }
        super.a(i, i2, intent);
    }

    final void av() {
        Screen i;
        Session session = SessionManager.b().c;
        if (session.isAnonymous()) {
            i = Nav.m22590i();
        } else {
            i = Nav.m22594j(session.getUsername());
        }
        Routing.m22623a((Screen) this, i);
    }

    final void aw() {
        if (this.f37155J != null) {
            this.f37155J.a();
        }
    }

    public boolean mo6986J() {
        if (this.f37155J != null) {
            boolean g;
            View a = this.f37155J.a(8388611);
            if (a != null) {
                g = DrawerLayout.g(a);
            } else {
                g = false;
            }
            if (g) {
                this.f37155J.a();
                return true;
            }
        }
        return super.mo6986J();
    }

    public void mo6993c(View view) {
        super.mo6993c(view);
        if (this.f37159w != null) {
            this.f37159w.mo5626a();
        }
        if (this.f37158v != null) {
            this.f37158v.detach();
        }
        EventBus.getDefault().unregister(this);
        mo7241c("onDetach");
        Timber.b("left screen: %s", new Object[]{getClass().getSimpleName()});
    }

    public AnalyticsHeartbeatParams getAnalyticsHeartbeatParams() {
        FrontpageApplication frontpageApplication = FrontpageApplication.f27402a;
        return new AnalyticsHeartbeatParams(FrontpageApplication.m28866b(), getAnalyticsPageType());
    }

    public ScreenviewEventBuilder getAnalyticsScreenviewEvent() {
        return AppAnalytics.m21877n().m21927a(getAnalyticsPageType());
    }

    public void E_() {
        String analyticsScreenName = getAnalyticsScreenName();
        if (!this.suppressScreenViewEvent && analyticsScreenName != null) {
            Timber.b("Sending v1 screen view event for %s", new Object[]{analyticsScreenName});
            AppAnalytics.m21852a(mo7203N());
            ScreenviewEventBuilder analyticsScreenviewEvent = getAnalyticsScreenviewEvent();
            if (analyticsScreenviewEvent != null) {
                Timber.b("Sending v2 screen view event for %s", new Object[]{analyticsScreenName});
                analyticsScreenviewEvent.m21931b();
            }
        }
    }

    public ScreenViewEvent mo7203N() {
        return new ScreenViewEvent(getAnalyticsScreenName());
    }

    protected final void m37523a(BaseOtherProvider baseOtherProvider) {
        m37527a("__default__", baseOtherProvider);
    }

    protected final void m37527a(String str, BaseOtherProvider baseOtherProvider) {
        this.f37161y.put(str, baseOtherProvider);
    }

    public void mo6991b(Bundle bundle) {
        super.mo6991b(bundle);
        mo7148d(bundle);
    }

    public void mo7148d(Bundle bundle) {
        Bridge.b(this, bundle);
    }

    public void mo7199c(Bundle bundle) {
        super.c(bundle);
        mo7149e(bundle);
    }

    public void mo7149e(Bundle bundle) {
        Bridge.a(this, bundle);
    }

    protected final void ag_() {
        ProviderManager providerManager = ProviderManager.b;
        String str = this.l;
        Map map = this.f37161y;
        Intrinsics.m26847b(str, "ownerId");
        Intrinsics.m26847b(map, "providers");
        for (Entry entry : map.entrySet()) {
            String str2 = (String) entry.getKey();
            BaseOtherProvider baseOtherProvider = (BaseOtherProvider) entry.getValue();
            if (!ProviderManager.a.contains(ProviderManager.a(str, str2, baseOtherProvider))) {
                Bundle bundle = new Bundle();
                baseOtherProvider.saveInstanceState(bundle);
                if (!bundle.isEmpty()) {
                    ProviderManager.a.put(ProviderManager.a(str, str2, baseOtherProvider), bundle);
                }
            }
        }
    }

    protected final void ah_() {
        ProviderManager providerManager = ProviderManager.b;
        String str = this.l;
        Map map = this.f37161y;
        Intrinsics.m26847b(str, "ownerId");
        Intrinsics.m26847b(map, "providers");
        for (Entry entry : map.entrySet()) {
            String str2 = (String) entry.getKey();
            BaseOtherProvider baseOtherProvider = (BaseOtherProvider) entry.getValue();
            str2 = ProviderManager.a(str, str2, baseOtherProvider);
            Bundle bundle = (Bundle) ProviderManager.a.get(str2);
            if (bundle != null) {
                baseOtherProvider.restoreInstanceState(bundle);
            }
            ProviderManager.a.delete(str2);
        }
    }

    public void mo7191l() {
        this.f37158v = null;
        for (BaseOtherProvider finish : this.f37161y.values()) {
            finish.finish();
        }
        ProviderManager providerManager = ProviderManager.b;
        ProviderManager.a(this.l);
        this.f37161y.clear();
        super.l();
    }

    public void ax() {
        new PostOptionsScreen(am_(), null).show();
    }

    public void onEvent(MessageEvent messageEvent) {
        Timber.b("Message event (%s): %s", new Object[]{getClass().getSimpleName(), messageEvent.a});
        messageEvent = Screens.m22629a(this, messageEvent.a, messageEvent.b);
        if (messageEvent != null) {
            messageEvent.a();
        }
    }

    public void mo7219a(ErrorEvent errorEvent) {
        CharSequence string;
        if (errorEvent.exception instanceof VolleyError) {
            string = ao_().getString(C1761R.string.error_network_error);
        } else if (errorEvent.exception instanceof AggregateException) {
            string = ao_().getString(C1761R.string.error_data_load);
        } else {
            String string2 = ao_().getString(C1761R.string.error_fallback_message);
            Timber.c(errorEvent.exception, "Unexpected error. Showing fallback error message", new Object[0]);
            string = string2;
        }
        mo7204a(string);
    }

    public final void m37526a(Exception exception) {
        mo7204a(ao_().getString(C1761R.string.error_fallback_message));
        Timber.c(exception, "Unexpected error. Showing fallback error message", new Object[0]);
    }

    public void onEvent(ErrorEvent errorEvent) {
        mo7219a(errorEvent);
    }

    public void mo7204a(CharSequence charSequence) {
        charSequence = Screens.m22629a(this, charSequence, 0);
        if (charSequence != null) {
            charSequence.a();
        }
    }

    public final void m37531b(CharSequence charSequence) {
        charSequence = Screens.m22629a(this, charSequence, -1);
        if (charSequence != null) {
            charSequence.a();
        }
    }

    protected final void ay() {
        this.f37154I.m24081a();
    }

    public final boolean az() {
        return this.f37156K == null;
    }

    protected final void m37532c(int i) {
        mo7204a(this.j.getContext().getResources().getString(i));
    }
}
