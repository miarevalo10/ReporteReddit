package com.reddit.frontpage;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.multidex.MultiDexApplication;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.airbnb.deeplinkdispatch.DeepLinkHandler;
import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.core.CrashlyticsCore;
import com.crashlytics.android.core.CrashlyticsCore.Builder;
import com.evernote.android.state.StateSaver;
import com.livefront.bridge.Bridge;
import com.livefront.bridge.SavedStateHandler;
import com.reddit.config.GlideApp;
import com.reddit.datalibrary.frontpage.data.common.db2.RedditFlowDatabase;
import com.reddit.datalibrary.frontpage.data.feature.ads.di.AdRepositoryComponent;
import com.reddit.datalibrary.frontpage.data.feature.ads.di.AdRepositoryModule;
import com.reddit.datalibrary.frontpage.data.feature.ads.di.DaggerAdRepositoryComponent;
import com.reddit.datalibrary.frontpage.data.feature.legacy.LegacySubredditDataSourceModule;
import com.reddit.datalibrary.frontpage.data.feature.link.di.DaggerLinkRepositoryComponent;
import com.reddit.datalibrary.frontpage.data.feature.link.di.LegacyLinkDataSourceModule;
import com.reddit.datalibrary.frontpage.data.feature.link.di.LegacyLinkRepositoryModule;
import com.reddit.datalibrary.frontpage.data.feature.link.di.LinkRepositoryComponent;
import com.reddit.datalibrary.frontpage.data.feature.settings.InternalSettings;
import com.reddit.datalibrary.frontpage.data.feature.subreddit.di.DaggerSubredditRepositoryComponent;
import com.reddit.datalibrary.frontpage.data.feature.subreddit.di.SubredditRepositoryComponent;
import com.reddit.datalibrary.frontpage.data.feature.subreddit.di.SubredditRepositoryModule;
import com.reddit.datalibrary.frontpage.data.provider.ProviderManager;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import com.reddit.datalibrary.frontpage.redditauth.Config;
import com.reddit.datalibrary.frontpage.redditauth.account.AccountUtil;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.bus.BusComponent;
import com.reddit.frontpage.bus.DaggerBusComponent;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.di.component.ApiClientComponent;
import com.reddit.frontpage.di.component.BaseComponent;
import com.reddit.frontpage.di.component.DaggerApiClientComponent;
import com.reddit.frontpage.di.component.DaggerBaseComponent;
import com.reddit.frontpage.di.component.DaggerNetworkComponent;
import com.reddit.frontpage.di.component.DaggerThriftComponent;
import com.reddit.frontpage.di.component.NetworkComponent;
import com.reddit.frontpage.di.component.ThriftComponent;
import com.reddit.frontpage.di.component.UserComponent;
import com.reddit.frontpage.di.module.AccountDataModule;
import com.reddit.frontpage.di.module.AnalyticsModule;
import com.reddit.frontpage.di.module.ApiClientModule;
import com.reddit.frontpage.di.module.ApplicationModule;
import com.reddit.frontpage.di.module.CategoryDataModule;
import com.reddit.frontpage.di.module.CommentDataModule;
import com.reddit.frontpage.di.module.FormatterModule;
import com.reddit.frontpage.di.module.GeneratorModule;
import com.reddit.frontpage.di.module.LinkDataModule;
import com.reddit.frontpage.di.module.LinkModule;
import com.reddit.frontpage.di.module.ModToolsDataModule;
import com.reddit.frontpage.di.module.NetworkModule;
import com.reddit.frontpage.di.module.OkHttpModule;
import com.reddit.frontpage.di.module.RegionDataModule;
import com.reddit.frontpage.di.module.RxModule;
import com.reddit.frontpage.di.module.SearchDataModule;
import com.reddit.frontpage.di.module.SubredditDataModule;
import com.reddit.frontpage.di.module.ThriftModule;
import com.reddit.frontpage.di.module.TopKarmaDataModule;
import com.reddit.frontpage.di.module.TrophiesDataModule;
import com.reddit.frontpage.di.module.UserPreferenceDataModule;
import com.reddit.frontpage.di.module.VideoCacheModule;
import com.reddit.frontpage.di.module.VolleyModule;
import com.reddit.frontpage.service.video.RemoveStaleUploadsService;
import com.reddit.frontpage.sync.SyncSchedule;
import com.reddit.frontpage.sync.SyncScheduleConfig;
import com.reddit.frontpage.sync.routine.AppConfigSyncRoutine;
import com.reddit.frontpage.sync.routine.DefaultsSyncRoutine;
import com.reddit.frontpage.sync.routine.ModeratedSyncRoutine;
import com.reddit.frontpage.sync.routine.MultiredditSyncRoutine;
import com.reddit.frontpage.sync.routine.SubscriptionsSyncRoutine;
import com.reddit.frontpage.sync.routine.UserSyncRoutine;
import com.reddit.frontpage.util.AdUtil;
import com.reddit.frontpage.util.AudioUtilComponent;
import com.reddit.frontpage.util.BranchUtil;
import com.reddit.frontpage.util.CrashlyticsTree;
import com.reddit.frontpage.util.DaggerAudioUtilComponent;
import com.reddit.frontpage.util.DaggerVideoUtilComponent;
import com.reddit.frontpage.util.InstabugUtil;
import com.reddit.frontpage.util.NetworkUtil;
import com.reddit.frontpage.util.NotificationUtil;
import com.reddit.frontpage.util.PushUtil;
import com.reddit.frontpage.util.SubredditUtil;
import com.reddit.frontpage.util.UpgradeUtil;
import com.reddit.frontpage.util.VideoUtilComponent;
import com.reddit.frontpage.util.kotlin.ActivityLifecycleCallbacksSimple;
import com.reddit.social.DaggerSocialComponent;
import com.reddit.social.SocialComponent;
import com.reddit.social.SocialModule;
import com.reddit.social.util.ChatUtilKt;
import dagger.internal.Preconditions;
import io.fabric.sdk.android.Fabric;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.plugins.RxJavaPlugins;
import java.io.IOException;
import java.net.SocketException;
import java.util.HashSet;
import java.util.Set;
import timber.log.Timber;

public class FrontpageApplication extends MultiDexApplication {
    public static FrontpageApplication f27402a;
    private static LinkRepositoryComponent f27403b;
    private static SubredditRepositoryComponent f27404c;
    private static NetworkComponent f27405d;
    private static AdRepositoryComponent f27406e;
    private static VideoUtilComponent f27407f;
    private static BusComponent f27408g;
    private static AudioUtilComponent f27409h;
    private static final Set<String> f27410i = new HashSet();
    private static final Set<String> f27411j = new HashSet();
    private static BaseComponent f27412l;
    private static UserComponent f27413m;
    private static ThriftComponent f27414n;
    private static ApiClientComponent f27415o;
    private static SocialComponent f27416p;
    private Activity f27417k = null;

    public class DeepLinkReceiver extends BroadcastReceiver {
        final /* synthetic */ FrontpageApplication f19870a;

        public DeepLinkReceiver(FrontpageApplication frontpageApplication) {
            this.f19870a = frontpageApplication;
        }

        public void onReceive(Context context, Intent intent) {
            context = intent.getStringExtra(DeepLinkHandler.EXTRA_URI);
            if (intent.getBooleanExtra(DeepLinkHandler.EXTRA_SUCCESSFUL, false)) {
                Timber.b("Success deep linking: %s", new Object[]{context});
                return;
            }
            intent = intent.getStringExtra(DeepLinkHandler.EXTRA_ERROR_MESSAGE);
            Timber.b("Error deep linking: %s with error message %s", new Object[]{context, intent});
            intent = new Intent(this.f19870a, DeepLinkFallbackActivity.class);
            intent.putExtra("com.reddit.extra.uri", Uri.parse(context));
            intent.setFlags(268435456);
            this.f19870a.startActivity(intent);
        }
    }

    class C22481 extends ActivityLifecycleCallbacksSimple {
        final /* synthetic */ FrontpageApplication f27400a;

        C22481(FrontpageApplication frontpageApplication) {
            this.f27400a = frontpageApplication;
        }

        public void onActivityStarted(Activity activity) {
            StringBuilder stringBuilder = new StringBuilder("Adding started activity: ");
            stringBuilder.append(activity.getClass().getSimpleName());
            Timber.b(stringBuilder.toString(), new Object[0]);
            FrontpageApplication.f27410i.add(activity.getClass().getSimpleName());
            this.f27400a.f27417k = activity;
        }

        public void onActivityResumed(Activity activity) {
            StringBuilder stringBuilder = new StringBuilder("Adding resumed activity: ");
            stringBuilder.append(activity.getClass().getSimpleName());
            Timber.b(stringBuilder.toString(), new Object[0]);
            FrontpageApplication.f27411j.add(activity.getClass().getSimpleName());
            this.f27400a.f27417k = activity;
        }

        public void onActivityPaused(Activity activity) {
            StringBuilder stringBuilder = new StringBuilder("Removing resumed activity: ");
            stringBuilder.append(activity.getClass().getSimpleName());
            Timber.b(stringBuilder.toString(), new Object[0]);
            FrontpageApplication.f27411j.remove(activity.getClass().getSimpleName());
        }

        public void onActivityStopped(Activity activity) {
            StringBuilder stringBuilder = new StringBuilder("Removing started activity: ");
            stringBuilder.append(activity.getClass().getSimpleName());
            Timber.b(stringBuilder.toString(), new Object[0]);
            FrontpageApplication.f27410i.remove(activity.getClass().getSimpleName());
            if (FrontpageApplication.f27410i.size() == null) {
                Timber.b("No more activities. App is going into background.", new Object[0]);
                Config.d();
                this.f27400a.f27417k = null;
            }
        }
    }

    class C22492 implements SavedStateHandler {
        final /* synthetic */ FrontpageApplication f27401a;

        C22492(FrontpageApplication frontpageApplication) {
            this.f27401a = frontpageApplication;
        }

        public final void m28860a(Object obj, Bundle bundle) {
            StateSaver.saveInstanceState(obj, bundle);
        }

        public final void m28861b(Object obj, Bundle bundle) {
            StateSaver.restoreInstanceState(obj, bundle);
        }
    }

    public void onCreate() {
        super.onCreate();
        f27402a = this;
        CrashlyticsCore build = new Builder().build();
        Fabric.m26236a((Context) this, new Crashlytics.Builder().core(build).build());
        Crashlytics.setString("GIT_SHA", "12f1a5b");
        Crashlytics.setString("BUILD_TIME", "05-01-2018 10:45:22 PM UTC");
        Crashlytics.log("App: onCreate");
        if (!m28882r()) {
            InstabugUtil.m23732a();
        }
        RxJavaPlugins.m26756a(FrontpageApplication$$Lambda$0.f27399a);
        Bridge.a(getApplicationContext(), new C22492(this));
        Bridge.a(getApplicationContext());
        PushUtil.m23872a();
        Timber.a(new CrashlyticsTree());
        BranchUtil.m23662a();
        UpgradeUtil.m23943a();
        RedditFlowDatabase.a();
        if (VERSION.SDK_INT >= 26) {
            NotificationUtil.m23856b((Context) this);
        }
        ApplicationModule applicationModule = new ApplicationModule(this);
        DaggerLinkRepositoryComponent.Builder a = DaggerLinkRepositoryComponent.a();
        a.a = (LegacyLinkDataSourceModule) Preconditions.m26012a(new LegacyLinkDataSourceModule());
        a.b = (LegacyLinkRepositoryModule) Preconditions.m26012a(new LegacyLinkRepositoryModule());
        if (a.a == null) {
            a.a = new LegacyLinkDataSourceModule();
        }
        if (a.b == null) {
            a.b = new LegacyLinkRepositoryModule();
        }
        f27403b = new DaggerLinkRepositoryComponent(a, (byte) 0);
        DaggerSubredditRepositoryComponent.Builder a2 = DaggerSubredditRepositoryComponent.a();
        a2.f = (ApplicationModule) Preconditions.m26012a(applicationModule);
        a2.a = (LegacySubredditDataSourceModule) Preconditions.m26012a(new LegacySubredditDataSourceModule());
        a2.b = (SubredditRepositoryModule) Preconditions.m26012a(new SubredditRepositoryModule());
        if (a2.a == null) {
            a2.a = new LegacySubredditDataSourceModule();
        }
        if (a2.b == null) {
            a2.b = new SubredditRepositoryModule();
        }
        if (a2.c == null) {
            a2.c = new RxModule();
        }
        if (a2.d == null) {
            a2.d = new NetworkModule();
        }
        if (a2.e == null) {
            a2.e = new SubredditDataModule();
        }
        if (a2.f == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(ApplicationModule.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }
        f27404c = new DaggerSubredditRepositoryComponent(a2, (byte) 0);
        DaggerNetworkComponent.Builder a3 = DaggerNetworkComponent.m29196a();
        a3.f20204a = (OkHttpModule) Preconditions.m26012a(new OkHttpModule());
        a3.f20205b = (VolleyModule) Preconditions.m26012a(new VolleyModule());
        if (a3.f20204a == null) {
            a3.f20204a = new OkHttpModule();
        }
        if (a3.f20205b == null) {
            a3.f20205b = new VolleyModule();
        }
        if (a3.f20206c == null) {
            a3.f20206c = new VideoCacheModule();
        }
        f27405d = new DaggerNetworkComponent(a3);
        DaggerAdRepositoryComponent.Builder a4 = DaggerAdRepositoryComponent.a();
        a4.a = (AdRepositoryModule) Preconditions.m26012a(new AdRepositoryModule());
        if (a4.a == null) {
            a4.a = new AdRepositoryModule();
        }
        f27406e = new DaggerAdRepositoryComponent(a4, (byte) 0);
        DaggerVideoUtilComponent.m30432a();
        f27407f = new DaggerVideoUtilComponent();
        DaggerBusComponent.m28894d();
        f27408g = new DaggerBusComponent();
        DaggerAudioUtilComponent.m30430b();
        f27409h = new DaggerAudioUtilComponent();
        DaggerBaseComponent.Builder a5 = DaggerBaseComponent.m29061a();
        a5.f20164a = (ApplicationModule) Preconditions.m26012a(applicationModule);
        if (a5.f20164a == null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(ApplicationModule.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }
        if (a5.f20165b == null) {
            a5.f20165b = new RxModule();
        }
        if (a5.f20166c == null) {
            a5.f20166c = new NetworkModule();
        }
        if (a5.f20167d == null) {
            a5.f20167d = new AccountDataModule();
        }
        if (a5.f20168e == null) {
            a5.f20168e = new AnalyticsModule();
        }
        if (a5.f20169f == null) {
            a5.f20169f = new ApiClientModule();
        }
        if (a5.f20170g == null) {
            a5.f20170g = new CategoryDataModule();
        }
        if (a5.f20171h == null) {
            a5.f20171h = new CommentDataModule();
        }
        if (a5.f20172i == null) {
            a5.f20172i = new LinkDataModule();
        }
        if (a5.f20173j == null) {
            a5.f20173j = new FormatterModule();
        }
        if (a5.f20174k == null) {
            a5.f20174k = new GeneratorModule();
        }
        if (a5.f20175l == null) {
            a5.f20175l = new LinkModule();
        }
        if (a5.f20176m == null) {
            a5.f20176m = new ModToolsDataModule();
        }
        if (a5.f20177n == null) {
            a5.f20177n = new RegionDataModule();
        }
        if (a5.f20178o == null) {
            a5.f20178o = new SearchDataModule();
        }
        if (a5.f20179p == null) {
            a5.f20179p = new SubredditDataModule();
        }
        if (a5.f20180q == null) {
            a5.f20180q = new TopKarmaDataModule();
        }
        if (a5.f20181r == null) {
            a5.f20181r = new TrophiesDataModule();
        }
        f27412l = new DaggerBaseComponent(a5);
        m28881q();
        DaggerThriftComponent.Builder a6 = DaggerThriftComponent.m29286a();
        a6.f20215a = (ApplicationModule) Preconditions.m26012a(applicationModule);
        if (a6.f20215a == null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(ApplicationModule.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }
        if (a6.f20216b == null) {
            a6.f20216b = new ThriftModule();
        }
        if (a6.f20217c == null) {
            a6.f20217c = new NetworkModule();
        }
        if (a6.f20218d == null) {
            a6.f20218d = new RxModule();
        }
        f27414n = new DaggerThriftComponent(a6);
        DaggerApiClientComponent.Builder a7 = DaggerApiClientComponent.m29002a();
        if (a7.f20156a == null) {
            a7.f20156a = new NetworkModule();
        }
        if (a7.f20157b == null) {
            a7.f20157b = new ApiClientModule();
        }
        f27415o = new DaggerApiClientComponent(a7);
        DaggerSocialComponent.Builder a8 = DaggerSocialComponent.m30577a();
        a8.f22280a = (SocialModule) Preconditions.m26012a(new SocialModule());
        if (a8.f22280a == null) {
            a8.f22280a = new SocialModule();
        }
        f27416p = new DaggerSocialComponent(a8);
        if (AccountUtil.d(this) == null) {
            AccountUtil.c(this);
        }
        SessionManager.a();
        SubredditUtil.m23913a();
        SyncScheduleConfig.Builder b = new SyncScheduleConfig.Builder().m23263b(getString(C1761R.string.provider_authority_appdata), new AppConfigSyncRoutine()).m23262a(getString(C1761R.string.provider_authority_userdata), new UserSyncRoutine()).m23262a(getString(C1761R.string.provider_authority_userdata), new SubscriptionsSyncRoutine()).m23262a(getString(C1761R.string.provider_authority_userdata), new ModeratedSyncRoutine()).m23262a(getString(C1761R.string.provider_authority_userdata), new MultiredditSyncRoutine()).m23263b(getString(C1761R.string.provider_authority_appdata), new DefaultsSyncRoutine());
        SyncSchedule.m23259a(new SyncScheduleConfig(b.f21050a, b.f21051b));
        RedditJobManager.a(this);
        InternalSettings a9 = InternalSettings.a();
        String b2 = a9.b();
        String c = a9.c();
        long d = a9.d();
        a9.b();
        Long valueOf = Long.valueOf(a9.a.getLong("com.reddit.frontpage.install_settings.install_timestamp", -1));
        if (valueOf.longValue() == -1) {
            valueOf = null;
        }
        Object string = a9.a.getString("com.reddit.frontpage.install_settings.lo_id", null);
        String e = a9.e();
        Timber.b("Device ID: %s, External Install ID: %s, External Install Timestamp: %d, Install Timestamp: %d", new Object[]{b2, c, Long.valueOf(d), valueOf});
        Config.c = getString(C1761R.string.oauth_client_id);
        Config.d = getString(C1761R.string.oauth_client_secret);
        Config.e = getString(C1761R.string.oauth_client_redirect);
        Config.g = b2;
        Config.i = c;
        Config.m = d;
        Config.n = valueOf;
        Config.j = e;
        if (!TextUtils.isEmpty(string)) {
            Config.a(string);
        }
        Crashlytics.setString("DEVICE_ID", Config.g);
        ChatUtilKt.m24754a();
        AdUtil.m23635a();
        if (!m28882r()) {
            AppAnalytics.m21850a();
        }
        NetworkUtil.m23844d();
        LocalBroadcastManager.a(this).a(new DeepLinkReceiver(this), new IntentFilter(DeepLinkHandler.ACTION));
        RemoveStaleUploadsService.m29918a(this, new Intent());
        registerActivityLifecycleCallbacks(new C22481(this));
        Timber.c("Initialization complete", new Object[0]);
    }

    public static void m28863a() {
        m28881q();
    }

    private static void m28881q() {
        f27413m = f27412l.mo4639a(new UserPreferenceDataModule());
    }

    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        GlideApp.a(this).a(i);
        ProviderManager providerManager = ProviderManager.b;
        ProviderManager.a(i);
    }

    static final /* synthetic */ void m28864a(Throwable th) throws Exception {
        if (th instanceof UndeliverableException) {
            th = th.getCause();
        }
        if (!(th instanceof IOException)) {
            if (!(th instanceof SocketException)) {
                if (!(th instanceof InterruptedException)) {
                    if (!(th instanceof NullPointerException)) {
                        if (!(th instanceof IllegalArgumentException)) {
                            if (th instanceof IllegalStateException) {
                                Thread.currentThread().getUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
                                return;
                            } else {
                                Timber.b(th, "Undeliverable exception received by RxJavaPlugins, not sure what to do", new Object[0]);
                                return;
                            }
                        }
                    }
                    Thread.currentThread().getUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
                }
            }
        }
    }

    public static boolean m28865a(String str) {
        return f27410i.contains(str);
    }

    public static boolean m28867b(String str) {
        return f27411j.contains(str);
    }

    public static boolean m28866b() {
        return f27410i.size() > 0;
    }

    public final Activity m28883c() {
        return this.f27417k;
    }

    public static LinkRepositoryComponent m28868d() {
        return f27403b;
    }

    public static SubredditRepositoryComponent m28869e() {
        return f27404c;
    }

    public static NetworkComponent m28870f() {
        return f27405d;
    }

    public static VideoUtilComponent m28871g() {
        return f27407f;
    }

    public static BusComponent m28872h() {
        return f27408g;
    }

    public static AudioUtilComponent m28873i() {
        return f27409h;
    }

    public static AdRepositoryComponent m28874j() {
        return f27406e;
    }

    public static UserComponent m28875k() {
        return f27413m;
    }

    public static ThriftComponent m28876l() {
        return f27414n;
    }

    public static ApiClientComponent m28877m() {
        return f27415o;
    }

    public static SocialComponent m28878n() {
        return f27416p;
    }

    private static boolean m28882r() {
        return "robolectric".equals(Build.FINGERPRINT);
    }
}
