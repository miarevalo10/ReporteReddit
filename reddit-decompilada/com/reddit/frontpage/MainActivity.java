package com.reddit.frontpage;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Toast;
import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.ControllerChangeHandler;
import com.bluelinelabs.conductor.ControllerChangeHandler.ControllerChangeListener;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.evernote.android.state.State;
import com.evernote.android.state.StateSaver;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration.Onboarding;
import com.reddit.datalibrary.frontpage.service.api.SubmitService;
import com.reddit.frontpage.commons.analytics.AnalyticsTrackable;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.events.v2.OnboardingEventBuilder.PageType;
import com.reddit.frontpage.commons.analytics.events.v2.ScreenviewEventBuilder;
import com.reddit.frontpage.commons.analytics.listener.NotificationSettingsListener;
import com.reddit.frontpage.nav.FloatingActionsManager;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Routing.NavigationAware;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.presentation.onboarding.OnboardingUtil;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.BottomNavScreen;
import com.reddit.frontpage.ui.search.Searchable;
import com.reddit.frontpage.ui.submit.MediaSubmitScreen;
import com.reddit.frontpage.util.DeepLinkUtil;
import com.reddit.frontpage.util.DeepLinkUtil.ScreenDeepLinker;
import com.reddit.frontpage.util.InstabugEventUtil;
import com.reddit.frontpage.util.IntentUtil;
import com.reddit.frontpage.util.ShareType;
import com.reddit.frontpage.widgets.bottomnav.BottomNavView.Item;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.parceler.Parcels;
import timber.log.Timber;

public class MainActivity extends BaseActivity implements NavigationAware {
    private static final Subject<Boolean> f40814l = PublishSubject.create();
    @State
    String bottomNavInstanceId;
    public boolean f40815d;
    private final Handler f40816h = new Handler();
    private Router f40817i;
    private ControllerChangeListener f40818j;
    private FloatingActionsManager f40819k;
    private boolean f40820m = false;

    private class MainActivityChangeListener implements ControllerChangeListener {
        final /* synthetic */ MainActivity f27422a;

        private MainActivityChangeListener(MainActivity mainActivity) {
            this.f27422a = mainActivity;
        }

        public final void m28888a(Controller controller, ViewGroup viewGroup, ControllerChangeHandler controllerChangeHandler) {
            this.f27422a.f40819k.m29345a((BaseScreen) controller);
        }

        public final void m28889b(Controller controller, ViewGroup viewGroup, ControllerChangeHandler controllerChangeHandler) {
            if (controller != null) {
                controllerChangeHandler = null;
                if ((controller instanceof AnalyticsTrackable) != null) {
                    AnalyticsTrackable analyticsTrackable = (AnalyticsTrackable) controller;
                    ScreenviewEventBuilder analyticsScreenviewEvent = analyticsTrackable.getAnalyticsScreenviewEvent();
                    viewGroup = analyticsTrackable.getAnalyticsScreenName();
                    if (analyticsScreenviewEvent != null) {
                        controllerChangeHandler = InstabugEventUtil.m23730a(analyticsScreenviewEvent);
                    }
                } else {
                    viewGroup = null;
                }
                if (viewGroup == null) {
                    viewGroup = controller.getClass().getSimpleName();
                }
                InstabugEventUtil.m23731a(viewGroup, controllerChangeHandler);
            }
        }
    }

    public final int mo7724d() {
        return C1761R.layout.activity_screen_container;
    }

    public static Intent m42701a(Context context, String str) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.setAction("com.reddit.frontpage.Mainactivity.MEDIA_SUBMIT_ACTION");
        intent.putExtra(SubmitService.EXTRA_REQUEST_ID, str);
        return intent;
    }

    public static Intent m42700a(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.setAction("com.reddit.frontpage.Mainactivity.SUBMITTED_POSTS_ACTION");
        return intent;
    }

    public static Observable<Boolean> m42706f() {
        return f40814l;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onCreate(android.os.Bundle r10) {
        /*
        r9 = this;
        super.onCreate(r10);
        r0 = r9.getIntent();
        r1 = "com.reddit.frontpage.requires_init";
        r2 = 1;
        r0 = r0.getBooleanExtra(r1, r2);
        r1 = 2131427619; // 0x7f0b0123 float:1.847686E38 double:1.053065163E-314;
        r1 = r9.findViewById(r1);
        r1 = (android.view.ViewGroup) r1;
        r1 = com.bluelinelabs.conductor.Conductor.a(r9, r1, r10);
        r9.f40817i = r1;
        r1 = 4;
        r3 = 0;
        if (r10 != 0) goto L_0x00e9;
    L_0x0021:
        r10 = com.reddit.datalibrary.frontpage.data.provider.ProviderManager.b;
        com.reddit.datalibrary.frontpage.data.provider.ProviderManager.a();
        if (r0 == 0) goto L_0x007f;
    L_0x0028:
        r10 = com.reddit.datalibrary.frontpage.redditauth.account.SessionManager.b();
        r10 = r10.c;
        r0 = r10.isAnonymous();
        if (r0 != 0) goto L_0x006a;
    L_0x0034:
        r0 = "requesting sync for %s";
        r4 = new java.lang.Object[r2];
        r5 = r10.getUsername();
        r4[r3] = r5;
        timber.log.Timber.b(r0, r4);
        r10 = r10.getUsername();
        r10 = com.reddit.datalibrary.frontpage.redditauth.account.AccountUtil.a(r9, r10);
        r0 = 2131887090; // 0x7f1203f2 float:1.9408777E38 double:1.053292172E-314;
        r4 = r9.getString(r0);
        com.reddit.frontpage.sync.SyncSchedule.m23257a(r10, r4, r3);
        r4 = r9.getString(r0);
        com.reddit.frontpage.sync.SyncSchedule.m23257a(r10, r4, r2);
        r4 = r9.getString(r0);
        r5 = 3;
        com.reddit.frontpage.sync.SyncSchedule.m23257a(r10, r4, r5);
        r0 = r9.getString(r0);
        com.reddit.frontpage.sync.SyncSchedule.m23257a(r10, r0, r1);
        goto L_0x0078;
    L_0x006a:
        r10 = com.reddit.datalibrary.frontpage.redditauth.account.AccountUtil.d(r9);
        r0 = 2131887088; // 0x7f1203f0 float:1.9408773E38 double:1.053292171E-314;
        r0 = r9.getString(r0);
        com.reddit.frontpage.sync.SyncSchedule.m23257a(r10, r0, r3);
    L_0x0078:
        r10 = com.reddit.frontpage.util.IntentUtil.m23759b(r9);
        r9.startService(r10);
    L_0x007f:
        r10 = new com.reddit.frontpage.ui.BottomNavScreen;
        r10.<init>();
        r0 = r10.l;
        r9.bottomNavInstanceId = r0;
        r0 = r9.getIntent();
        r0 = m42703a(r0);
        r4 = 0;
        if (r0 == 0) goto L_0x0098;
    L_0x0093:
        r5 = r0.createScreen();
        goto L_0x0099;
    L_0x0098:
        r5 = r4;
    L_0x0099:
        r6 = r9.getIntent();
        r6 = com.reddit.frontpage.util.ShareType.m23903a(r6);
        r7 = r9.getIntent();
        r8 = "com.reddit.extra.is_sign_up";
        r7 = r7.getBooleanExtra(r8, r3);
        if (r5 == 0) goto L_0x00b5;
    L_0x00ad:
        r10 = com.reddit.frontpage.nav.Routing.m22615a();
        r9.m42704a(r5, r2, r10);
        goto L_0x00ec;
    L_0x00b5:
        if (r6 == 0) goto L_0x00bb;
    L_0x00b7:
        r9.m42705a(r6);
        goto L_0x00ec;
    L_0x00bb:
        if (r7 == 0) goto L_0x00d4;
    L_0x00bd:
        r5 = "android_onboarding_v2";
        r6 = com.reddit.frontpage.commons.analytics.events.v2.OnboardingEventBuilder.PageType.RECOMMENDATIONS;
        r6 = r6.value;
        com.reddit.frontpage.commons.analytics.AppAnalytics.m21856a(r5, r6);
        r5 = com.reddit.frontpage.presentation.onboarding.OnboardingUtil.m23163a();
        if (r5 == 0) goto L_0x00d4;
    L_0x00cc:
        r10 = com.reddit.frontpage.nav.Nav.m22601m();
        r9.m42704a(r10, r2, r4);
        goto L_0x00ec;
    L_0x00d4:
        r4 = r9.f40817i;
        r4 = r4.n();
        if (r4 != 0) goto L_0x00ec;
    L_0x00dc:
        r4 = r9.f40817i;
        r5 = com.bluelinelabs.conductor.RouterTransaction.a(r10);
        r4.d(r5);
        r10.m39005a(r0);
        goto L_0x00ec;
    L_0x00e9:
        com.livefront.bridge.Bridge.a(r9, r10);
    L_0x00ec:
        r10 = new com.reddit.frontpage.MainActivity$MainActivityChangeListener;
        r10.<init>();
        r9.f40818j = r10;
        r10 = r9.f40817i;
        r0 = r9.f40818j;
        r10.a(r0);
        r10 = r9.m41961k();
        if (r10 == 0) goto L_0x010a;
    L_0x0100:
        r10 = r9.f40817i;
        r0 = new com.reddit.frontpage.ui.color.StatusBarColorControllerChangeListener;
        r0.<init>(r9);
        r10.a(r0);
    L_0x010a:
        r10 = 2131427768; // 0x7f0b01b8 float:1.8477162E38 double:1.053065237E-314;
        r10 = r9.findViewById(r10);
        r10 = (com.reddit.frontpage.widgets.FloatingActionsView) r10;
        r0 = new com.reddit.frontpage.nav.FloatingActionsManager;
        r0.<init>(r10);
        r9.f40819k = r0;
        r10 = r9.f40819k;
        r0 = r9.f40817i;
        r0 = com.reddit.frontpage.nav.Routing.m22618a(r0);
        r0 = (com.reddit.frontpage.ui.BaseScreen) r0;
        r10.m29345a(r0);
        r10 = com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings.a();
        r10 = r10.l();
        if (r10 == 0) goto L_0x0136;
    L_0x0131:
        r10 = com.reddit.datalibrary.social.data.session.ChatConnectionManager.f19854b;
        com.reddit.datalibrary.social.data.session.ChatConnectionManager.Companion.m21750a();
    L_0x0136:
        r10 = android.os.Build.VERSION.SDK_INT;
        r0 = 17;
        if (r10 < r0) goto L_0x0160;
    L_0x013c:
        r10 = r9.getWindowManager();
        r10 = r10.getDefaultDisplay();
        r0 = new android.util.DisplayMetrics;
        r0.<init>();
        r10.getRealMetrics(r0);
        r1 = r0.heightPixels;
        r4 = r0.widthPixels;
        r10.getMetrics(r0);
        r10 = r0.heightPixels;
        r0 = r0.widthPixels;
        r4 = r4 - r0;
        if (r4 > 0) goto L_0x0170;
    L_0x015a:
        r1 = r1 - r10;
        if (r1 <= 0) goto L_0x015e;
    L_0x015d:
        goto L_0x0170;
    L_0x015e:
        r2 = r3;
        goto L_0x0170;
    L_0x0160:
        r10 = android.view.ViewConfiguration.get(r9);
        r10 = r10.hasPermanentMenuKey();
        r0 = android.view.KeyCharacterMap.deviceHasKey(r1);
        if (r10 != 0) goto L_0x015e;
    L_0x016e:
        if (r0 != 0) goto L_0x015e;
    L_0x0170:
        r10 = com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings.a();
        r10 = r10.a;
        r10 = r10.edit();
        r0 = "com.reddit.frontpage.device_has_software_keys";
        r10 = r10.putBoolean(r0, r2);
        r10.apply();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.MainActivity.onCreate(android.os.Bundle):void");
    }

    protected void onStart() {
        super.onStart();
        NotificationSettingsListener.m21948a(this);
    }

    public void onPause() {
        this.f40815d = true;
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.f40815d = false;
        if (this.f40820m) {
            Intent intent = getIntent();
            ScreenDeepLinker a = m42703a(intent);
            if (a != null) {
                BottomNavScreen a2 = m42708a(false);
                if (!(a2 == null || a2.m39005a(a))) {
                    Routing.m22620a((NavigationAware) this, a.createScreen(), DeepLinkUtil.isInternal(intent));
                }
            }
            intent = getIntent();
            if ("android.intent.action.SEARCH".equals(intent.getAction())) {
                String stringExtra = intent.getStringExtra("query");
                Timber.b("ACTION_SEARCH with query %s", new Object[]{stringExtra});
                Screen a3 = Routing.m22618a(mo7779h());
                if (a3 instanceof Searchable) {
                    ((Searchable) a3).mo7239b(stringExtra);
                } else {
                    Routing.m22619a((Context) this, Nav.m22603n(stringExtra));
                }
            }
            intent = getIntent();
            if ("com.reddit.frontpage.Mainactivity.MEDIA_SUBMIT_ACTION".equals(intent.getAction()) && !MediaSubmitScreen.class.isInstance(Routing.m22617a((Context) this))) {
                this.f40816h.post(new MainActivity$$Lambda$0(this, intent.getStringExtra(SubmitService.EXTRA_REQUEST_ID)));
            }
            if ("com.reddit.frontpage.Mainactivity.SUBMITTED_POSTS_ACTION".equals(getIntent().getAction()) && m42708a(false) == null) {
                this.f40817i.a(Collections.singletonList(RouterTransaction.a(m42708a(true))), null);
            }
            intent = getIntent();
            ShareType a4 = ShareType.m23903a(intent);
            if (a4 != null) {
                if (Routing.m22617a((Context) this) != null) {
                    switch (a4) {
                        case f21794a:
                            this.f40816h.post(new MainActivity$$Lambda$1(this, intent.getStringExtra("android.intent.extra.TEXT")));
                            break;
                        case f21795b:
                            this.f40816h.post(new MainActivity$$Lambda$2(this, intent.getStringExtra("android.intent.extra.TEXT")));
                            break;
                        case f21796c:
                            this.f40816h.post(new MainActivity$$Lambda$3(this, (Uri) IntentUtil.m23754a(intent, "android.intent.extra.STREAM", Uri.class)));
                            break;
                        case f21797d:
                            this.f40816h.post(new MainActivity$$Lambda$4(this, (Uri) IntentUtil.m23754a(intent, "android.intent.extra.STREAM", Uri.class)));
                            break;
                        default:
                            break;
                    }
                }
                m42705a(a4);
            }
            if (getIntent().getBooleanExtra("com.reddit.extra.is_sign_up", false)) {
                AppAnalytics.m21856a(Onboarding.NAME, PageType.RECOMMENDATIONS.value);
                if (OnboardingUtil.m23163a()) {
                    OnboardingUtil.m23162a(Routing.m22617a((Context) this));
                }
            }
            this.f40820m = false;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        this.f40817i.b(this.f40818j);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        StateSaver.saveInstanceState(this, bundle);
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        StateSaver.restoreInstanceState(this, bundle);
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.f40820m = true;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        FrontpageApplication.m28872h().mo4568a().post(i);
        return super.onKeyDown(i, keyEvent);
    }

    public void onBackPressed() {
        Screen a = Routing.m22618a(mo7779h());
        boolean z = a != null && a.mo6986J();
        if (!z) {
            z = (m42707l() ? m42708a(false).mo7197I() : true) && this.f40817i.i();
        }
        if (!z && m42707l()) {
            Controller a2 = m42708a(false);
            if (!(!a2.e || a2.c || a2.m39001O() == Item.f21972a)) {
                a2.m39004a(Item.f21972a);
                z = true;
            }
        }
        if (!z) {
            super.onBackPressed();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public boolean onMenuOpened(int i, Menu menu) {
        f40814l.onNext(Boolean.valueOf(true));
        return super.onMenuOpened(i, menu);
    }

    public final Router mo7778g() {
        return this.f40817i;
    }

    public final Router mo7779h() {
        if (this.f40817i != null) {
            if (this.f40817i.c.b() > 0) {
                if (this.f40817i.c.b() > 1) {
                    return this.f40817i;
                }
                BottomNavScreen a = m42708a(false);
                if (a != null) {
                    return a.f39128v;
                }
                return this.f40817i;
            }
        }
        return null;
    }

    public final boolean m42713j() {
        return this.f40815d;
    }

    private boolean m42707l() {
        return this.f40817i.c.b() == 1 && m42708a(false) != null;
    }

    public final BottomNavScreen m42708a(boolean z) {
        BottomNavScreen bottomNavScreen = this.f40817i != null ? (BottomNavScreen) this.f40817i.c(this.bottomNavInstanceId) : null;
        if (!z || bottomNavScreen != null) {
            return bottomNavScreen;
        }
        Controller bottomNavScreen2 = new BottomNavScreen();
        this.bottomNavInstanceId = bottomNavScreen2.l;
        return bottomNavScreen2;
    }

    public final void m42709a(Screen screen) {
        m42704a(screen, true, null);
    }

    private void m42704a(Screen screen, boolean z, ControllerChangeHandler controllerChangeHandler) {
        List arrayList = new ArrayList();
        if (z) {
            arrayList.add(RouterTransaction.a(m42708a(true)));
        }
        arrayList.add(RouterTransaction.a(screen));
        this.f40817i.a(arrayList, controllerChangeHandler);
    }

    private static ScreenDeepLinker m42703a(Intent intent) {
        return (ScreenDeepLinker) Parcels.m28673a(intent.getParcelableExtra("com.reddit.frontpage.deep_linker"));
    }

    private void m42705a(ShareType shareType) {
        Intent intent = getIntent();
        switch (shareType) {
            case f21794a:
                shareType = Nav.m22606q(intent.getStringExtra("android.intent.extra.TEXT"));
                break;
            case f21795b:
                shareType = Nav.m22607r(intent.getStringExtra("android.intent.extra.TEXT"));
                break;
            case f21796c:
                shareType = Nav.m22538a(0, (Uri) IntentUtil.m23754a(intent, "android.intent.extra.STREAM", Uri.class));
                break;
            case f21797d:
                shareType = Nav.m22538a(2, (Uri) IntentUtil.m23754a(intent, "android.intent.extra.STREAM", Uri.class));
                break;
            default:
                shareType = null;
                break;
        }
        if (shareType != null) {
            m42704a(shareType, false, null);
            return;
        }
        Timber.e("Received share intent but we could not map it to any screen. MimeType=%s", new Object[]{getIntent().getType()});
        Toast.makeText(this, C1761R.string.error_message_share_to_reddit, 0).show();
    }
}
