package com.reddit.datalibrary.frontpage.data.feature.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration.FreshContentPill;
import com.reddit.datalibrary.frontpage.requests.models.config.discoveryunit.DiscoveryUnit;
import com.reddit.datalibrary.frontpage.requests.models.config.discoveryunit.DiscoveryUnitExperimentManager;
import com.reddit.datalibrary.frontpage.requests.models.v1.Account;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.debug.RedditLogger;
import com.reddit.frontpage.presentation.listing.model.ListingViewMode;
import com.reddit.frontpage.presentation.theme.ThemeOption;
import com.reddit.frontpage.util.IOUtil;
import com.reddit.frontpage.util.JsonUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.social.util.ChatUtilKt;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import timber.log.Timber;

public class FrontpageSettings {
    private static final String f10755c = "FrontpageSettings";
    private static FrontpageSettings f10756d;
    private static String f10757e;
    public final SharedPreferences f10758a;
    public final SharedPreferences f10759b;
    private AppConfiguration f10760f;
    private final ReentrantLock f10761g = new ReentrantLock();

    private FrontpageSettings(Context context) {
        this.f10759b = context.getSharedPreferences("com.reddit.frontpage.app_wide_prefs_key.", 0);
        this.f10758a = m9013b(context, f10757e);
    }

    public static FrontpageSettings m9011a() {
        Object obj;
        Session session = SessionManager.m9191b().f10840c;
        if (session.isAnonymous()) {
            obj = "a.non.ymous";
        } else {
            obj = session.getUsername();
        }
        if (f10756d == null || !TextUtils.equals(f10757e, obj)) {
            f10757e = obj;
            f10756d = new FrontpageSettings(FrontpageApplication.a);
        }
        return f10756d;
    }

    public static void m9012a(Context context, String str) {
        m9013b(context, str).edit().clear().apply();
    }

    public final boolean m9027b() {
        return this.f10758a.getBoolean("com.reddit.mobile.disable_preview_images", false);
    }

    public final void m9021a(boolean z) {
        this.f10758a.edit().putBoolean("com.reddit.mobile.disable_preview_images", z).apply();
    }

    public final boolean m9030c() {
        boolean z = this.f10758a.getBoolean("com.reddit.pref.compact_listing_view_migrated", false);
        boolean z2 = this.f10758a.getBoolean("com.reddit.pref.compact_listing_view", false);
        if (!z) {
            FrontpageApplication.k().a().a("listingViewMode.globalDefault", z2 ? ListingViewMode.b : ListingViewMode.a).blockingGet();
            this.f10758a.edit().putBoolean("com.reddit.pref.compact_listing_view_migrated", true).apply();
        }
        return z2;
    }

    public final void m9022a(boolean z, boolean z2) {
        this.f10758a.edit().putBoolean("com.reddit.pref.compact_listing_view", z).apply();
        if (z2) {
            FrontpageApplication.k().a().a(z).subscribeOn(Schedulers.b()).subscribe();
        }
    }

    public final boolean m9033d() {
        boolean z = this.f10758a.getBoolean("com.reddit.pref.night_mode.migrated", false);
        boolean z2 = this.f10758a.getBoolean("com.reddit.pref.night_mode", false);
        FrontpageApplication.k().a();
        if (!z) {
            Timber.b("App Theme: migrating legacy night mode pref (nightMode = %s)", new Object[]{Boolean.valueOf(z2)});
            if (z2) {
                m9019a(ThemeOption.c);
            }
            this.f10758a.edit().putBoolean("com.reddit.pref.night_mode.migrated", true).apply();
        }
        return z2;
    }

    public final void m9026b(boolean z) {
        this.f10758a.edit().putBoolean("com.reddit.pref.night_mode", z).apply();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.reddit.frontpage.presentation.theme.ThemeOption m9028c(boolean r25) {
        /*
        r24 = this;
        r0 = r24;
        r1 = r0.f10758a;
        r2 = "com.reddit.pref.theme";
        r3 = com.reddit.frontpage.presentation.theme.ThemeOption.a;
        r3 = r3.name();
        r1 = r1.getString(r2, r3);
        r1 = com.reddit.frontpage.presentation.theme.ThemeOption.valueOf(r1);
        if (r25 == 0) goto L_0x0124;
    L_0x0016:
        r2 = r24.m9036e();
        if (r2 == 0) goto L_0x0124;
    L_0x001c:
        r2 = com.reddit.frontpage.FrontpageApplication.a;
        r2 = android.support.v7.app.RedditTwilightManager.m1555a(r2);
        r3 = r2.f1830b;
        r4 = r2.f1830b;
        r4 = r4.nextUpdate;
        r6 = java.lang.System.currentTimeMillis();
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        r6 = 1;
        if (r4 <= 0) goto L_0x0033;
    L_0x0031:
        r4 = r6;
        goto L_0x0034;
    L_0x0033:
        r4 = 0;
    L_0x0034:
        if (r4 == 0) goto L_0x003c;
    L_0x0036:
        r5 = r3.isNight;
        r20 = r1;
        goto L_0x011f;
    L_0x003c:
        r4 = r2.f1829a;
        r7 = "android.permission.ACCESS_COARSE_LOCATION";
        r4 = android.support.v4.content.PermissionChecker.m759a(r4, r7);
        r7 = 0;
        if (r4 != 0) goto L_0x004e;
    L_0x0047:
        r4 = "network";
        r4 = r2.m1556a(r4);
        goto L_0x004f;
    L_0x004e:
        r4 = r7;
    L_0x004f:
        r8 = r2.f1829a;
        r9 = "android.permission.ACCESS_FINE_LOCATION";
        r8 = android.support.v4.content.PermissionChecker.m759a(r8, r9);
        if (r8 != 0) goto L_0x005f;
    L_0x0059:
        r7 = "gps";
        r7 = r2.m1556a(r7);
    L_0x005f:
        if (r7 == 0) goto L_0x0070;
    L_0x0061:
        if (r4 == 0) goto L_0x0070;
    L_0x0063:
        r8 = r7.getTime();
        r10 = r4.getTime();
        r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r8 <= 0) goto L_0x0073;
    L_0x006f:
        goto L_0x0072;
    L_0x0070:
        if (r7 == 0) goto L_0x0073;
    L_0x0072:
        r4 = r7;
    L_0x0073:
        if (r4 == 0) goto L_0x0101;
    L_0x0075:
        r2 = r2.f1830b;
        r14 = java.lang.System.currentTimeMillis();
        r12 = android.support.v7.app.TwilightCalculator.m1562a();
        r16 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
        r8 = r14 - r16;
        r10 = r4.getLatitude();
        r18 = r4.getLongitude();
        r7 = r12;
        r5 = r12;
        r12 = r18;
        r7.m1563a(r8, r10, r12);
        r12 = r5.f1842a;
        r10 = r4.getLatitude();
        r18 = r4.getLongitude();
        r7 = r5;
        r8 = r14;
        r20 = r1;
        r0 = r12;
        r12 = r18;
        r7.m1563a(r8, r10, r12);
        r7 = r5.f1844c;
        if (r7 != r6) goto L_0x00ac;
    L_0x00ab:
        goto L_0x00ad;
    L_0x00ac:
        r6 = 0;
    L_0x00ad:
        r12 = r5.f1843b;
        r10 = r5.f1842a;
        r8 = r14 + r16;
        r16 = r4.getLatitude();
        r18 = r4.getLongitude();
        r7 = r5;
        r21 = r3;
        r3 = r10;
        r10 = r16;
        r22 = r0;
        r0 = r12;
        r12 = r18;
        r7.m1563a(r8, r10, r12);
        r7 = r5.f1843b;
        r9 = -1;
        r5 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1));
        if (r5 == 0) goto L_0x00ea;
    L_0x00d1:
        r5 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1));
        if (r5 != 0) goto L_0x00d6;
    L_0x00d5:
        goto L_0x00ea;
    L_0x00d6:
        r5 = (r14 > r3 ? 1 : (r14 == r3 ? 0 : -1));
        r9 = 0;
        if (r5 <= 0) goto L_0x00de;
    L_0x00dc:
        r9 = r9 + r7;
        goto L_0x00e5;
    L_0x00de:
        r5 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1));
        if (r5 <= 0) goto L_0x00e4;
    L_0x00e2:
        r9 = r9 + r3;
        goto L_0x00e5;
    L_0x00e4:
        r9 = r9 + r0;
    L_0x00e5:
        r11 = 60000; // 0xea60 float:8.4078E-41 double:2.9644E-319;
        r9 = r9 + r11;
        goto L_0x00ee;
    L_0x00ea:
        r9 = 43200000; // 0x2932e00 float:2.1626111E-37 double:2.1343636E-316;
        r9 = r9 + r14;
    L_0x00ee:
        r2.isNight = r6;
        r5 = r22;
        r2.yesterdaySunset = r5;
        r2.todaySunrise = r0;
        r2.todaySunset = r3;
        r2.tomorrowSunrise = r7;
        r2.nextUpdate = r9;
        r0 = r21;
        r5 = r0.isNight;
        goto L_0x011f;
    L_0x0101:
        r20 = r1;
        r0 = "RedditTwilightManager";
        r1 = "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.";
        android.util.Log.i(r0, r1);
        r0 = java.util.Calendar.getInstance();
        r1 = 11;
        r0 = r0.get(r1);
        r1 = 6;
        if (r0 < r1) goto L_0x011e;
    L_0x0117:
        r1 = 22;
        if (r0 < r1) goto L_0x011c;
    L_0x011b:
        goto L_0x011e;
    L_0x011c:
        r5 = 0;
        goto L_0x011f;
    L_0x011e:
        r5 = r6;
    L_0x011f:
        if (r5 == 0) goto L_0x0126;
    L_0x0121:
        r1 = com.reddit.frontpage.presentation.theme.ThemeOption.c;
        goto L_0x0128;
    L_0x0124:
        r20 = r1;
    L_0x0126:
        r1 = r20;
    L_0x0128:
        r0 = com.reddit.frontpage.presentation.theme.ThemeOption.c;
        if (r1 != r0) goto L_0x0135;
    L_0x012c:
        r0 = r24.m9039f();
        if (r0 == 0) goto L_0x0135;
    L_0x0132:
        r0 = com.reddit.frontpage.presentation.theme.ThemeOption.f;
        return r0;
    L_0x0135:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings.c(boolean):com.reddit.frontpage.presentation.theme.ThemeOption");
    }

    public final void m9019a(ThemeOption themeOption) {
        if (themeOption == ThemeOption.f) {
            throw new IllegalArgumentException("AMOLED shouldn't be set as the current theme. Set night theme and call setAmoledNight(true) instead.");
        }
        this.f10758a.edit().putString("com.reddit.pref.theme", themeOption.name()).apply();
        if (themeOption == ThemeOption.c) {
            m9032d((boolean) null);
        }
    }

    public final void m9024b(ThemeOption themeOption) {
        if (themeOption != ThemeOption.c) {
            if (themeOption != ThemeOption.f) {
                this.f10758a.edit().putString("com.reddit.pref.prev_theme", themeOption.name()).apply();
                return;
            }
        }
        throw new IllegalArgumentException("Only non-night themes should be set as the previous non-night theme");
    }

    public final boolean m9036e() {
        return this.f10758a.getBoolean("com.reddit.pref.auto_night", false);
    }

    public final void m9032d(boolean z) {
        ThemeOption c = m9028c(false);
        if (z && (c == ThemeOption.c || c == ThemeOption.f)) {
            throw new IllegalArgumentException("Can't use auto night mode with a night theme set");
        }
        this.f10758a.edit().putBoolean("com.reddit.pref.auto_night", z).apply();
    }

    public final boolean m9039f() {
        return this.f10758a.getBoolean("com.reddit.pref.amoled_night", false);
    }

    public final boolean m9041g() {
        return this.f10758a.getBoolean("com.reddit.pref.blur_nsfw", true);
    }

    public final void m9035e(boolean z) {
        this.f10758a.edit().putBoolean("com.reddit.pref.blur_nsfw", z).apply();
    }

    public final void m9020a(String str) {
        this.f10758a.edit().putString("com.reddit.pref.autoplay", str).apply();
    }

    public final int m9042h() {
        CharSequence string = FrontpageApplication.a.getString(C1761R.string.option_value_never);
        CharSequence string2 = FrontpageApplication.a.getString(C1761R.string.option_value_unmetered);
        CharSequence string3 = FrontpageApplication.a.getString(C1761R.string.option_value_always);
        CharSequence string4 = this.f10758a.getString("com.reddit.pref.autoplay", Util.f(C1761R.string.option_value_always));
        if (TextUtils.equals(string4, string)) {
            return 3;
        }
        if (TextUtils.equals(string4, string2)) {
            return 2;
        }
        if (TextUtils.equals(string4, string3)) {
            return 1;
        }
        Timber.e("Unrecognized autoplay setting: %s", new Object[]{string4});
        return -1;
    }

    public final void m9025b(String str) {
        this.f10758a.edit().putString("com.reddit.pref.last_push_token", str).apply();
    }

    public final void m9029c(String str) {
        this.f10758a.edit().putString("com.reddit.pref.last_push_token_user", str).apply();
    }

    public final String m9044i() {
        return this.f10758a.getString("com.reddit.pref.base_uri", Util.f(C1761R.string.base_uri_default));
    }

    public final void m9031d(String str) {
        this.f10758a.edit().putString("com.reddit.pref.base_uri", str).apply();
    }

    public final String m9046j() {
        return this.f10758a.getString("com.reddit.pref.gateway_uri", FrontpageApplication.a.getString(C1761R.string.gateway_uri_default));
    }

    public final void m9034e(String str) {
        this.f10758a.edit().putString("com.reddit.pref.gateway_uri", str).apply();
    }

    public final boolean m9049k() {
        return this.f10758a.getBoolean("com.reddit.pref.use_staging", false);
    }

    public final boolean m9050l() {
        if (!this.f10758a.contains("com.reddit.social.chat_opt_in")) {
            ChatUtilKt.a();
        }
        return this.f10758a.getBoolean("com.reddit.social.chat_opt_in", false);
    }

    public final void m9038f(boolean z) {
        Account d = SessionManager.m9191b().m9205d();
        boolean z2 = false;
        boolean z3 = d != null && d.in_chat;
        Editor edit = this.f10758a.edit();
        String str = "com.reddit.social.chat_opt_in";
        if (z || z3) {
            z2 = true;
        }
        edit.putBoolean(str, z2).apply();
    }

    public final void m9040g(boolean z) {
        this.f10758a.edit().putBoolean("com.reddit.pref.dummy_upcoming_event", z).apply();
    }

    public final void m9037f(String str) {
        RedditLogger.a(String.format("hideCarousel(%1$s), key = %2$s", new Object[]{str, m9014g(str)}));
        m9048k(r0);
    }

    static String m9014g(String str) {
        StringBuilder stringBuilder = new StringBuilder("com.reddit.frontpage.hide_carousel_timestamp.");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public final void m9052m() {
        m9048k("com.reddit.frontpage.last_upvote_timestamp");
    }

    public final boolean m9053n() {
        if (!m9059t().m9373f()) {
            return false;
        }
        return m9023a("com.reddit.frontpage.last_upvote_timestamp", ((long) m9059t().experiments.upvote_toast.frequency) * 3600000);
    }

    public final List<DiscoveryUnit> m9043h(String str) {
        AppConfiguration t = m9059t();
        if (t.discoveryUnitExperimentManager == null && t.m9380m() != null) {
            List list;
            List m = t.m9380m();
            List arrayList = new ArrayList();
            if (t.experiments != null) {
                if (!(t.experiments.subreddit_recommendation_android == null || t.experiments.subreddit_recommendation_android.discovery_units == null)) {
                    arrayList.addAll(t.experiments.subreddit_recommendation_android.discovery_units);
                }
                if (!(t.experiments.favorite_subreddits_carousel_android == null || t.experiments.favorite_subreddits_carousel_android.discovery_units == null)) {
                    arrayList.addAll(t.experiments.favorite_subreddits_carousel_android.discovery_units);
                }
                if (!(t.experiments.trending_users_carousel_android == null || t.experiments.trending_users_carousel_android.discovery_units == null)) {
                    arrayList.addAll(t.experiments.trending_users_carousel_android.discovery_units);
                }
                if (!(t.experiments.new_in_your_subscriptions_carousel_android == null || t.experiments.new_in_your_subscriptions_carousel_android.discovery_units == null)) {
                    arrayList.addAll(t.experiments.new_in_your_subscriptions_carousel_android.discovery_units);
                }
                if (!(t.experiments.recommended_posts_carousel_android == null || t.experiments.recommended_posts_carousel_android.discovery_units == null)) {
                    arrayList.addAll(t.experiments.recommended_posts_carousel_android.discovery_units);
                }
            }
            if (t.global.discovery_config_v1 != null) {
                if (t.global.discovery_config_v1.discovery_surfaces != null) {
                    list = t.global.discovery_config_v1.discovery_surfaces;
                    t.discoveryUnitExperimentManager = new DiscoveryUnitExperimentManager(m, arrayList, list, m9011a().m9057r());
                }
            }
            list = new ArrayList();
            t.discoveryUnitExperimentManager = new DiscoveryUnitExperimentManager(m, arrayList, list, m9011a().m9057r());
        }
        if (t.discoveryUnitExperimentManager != null) {
            str = t.discoveryUnitExperimentManager.m9381a(str);
        } else {
            str = null;
        }
        return (List) Observable.fromIterable(str).filter(new FrontpageSettings$$Lambda$0(this)).toList().blockingGet();
    }

    public final boolean m9045i(String str) {
        boolean a = m9023a(m9016n(str), 1800000);
        if (a) {
            AppAnalytics.a(FreshContentPill.NAME, str);
        }
        str = m9059t();
        if (str.experiments != null) {
            if (str.experiments.fresh_content_pill != null) {
                str = str.experiments.fresh_content_pill.active;
                if (str == null && a) {
                    return true;
                }
                return false;
            }
        }
        str = null;
        if (str == null) {
        }
        return false;
    }

    private static String m9016n(String str) {
        StringBuilder stringBuilder = new StringBuilder("com.reddit.frontpage.last_screen_refresh_timestamp.");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public final void m9047j(String str) {
        m9048k(m9016n(str));
    }

    final boolean m9023a(String str, long j) {
        return System.currentTimeMillis() - this.f10758a.getLong(str, 0) > j ? true : null;
    }

    public final void m9048k(String str) {
        this.f10758a.edit().putLong(str, System.currentTimeMillis()).apply();
    }

    public final boolean m9054o() {
        return this.f10758a.getBoolean("com.reddit.pref.mvp_frontpage_listing", false);
    }

    public final boolean m9055p() {
        return this.f10758a.getBoolean("com.reddit.pref.mvp_popular_listing", false);
    }

    public final boolean m9056q() {
        return this.f10758a.getBoolean("com.reddit.pref.mvp_usp_listing", false);
    }

    public final boolean m9057r() {
        return this.f10758a.getBoolean("com.reddit.pref.carousel_debug", false);
    }

    public final boolean m9058s() {
        return this.f10758a.getBoolean("com.reddit.pref.onboarding_enabled_override", false);
    }

    public final AppConfiguration m9059t() {
        this.f10761g.lock();
        try {
            if (this.f10760f == null) {
                String string = this.f10759b.getString("com.reddit.frontpage.app_config", null);
                if (string == null) {
                    this.f10760f = m9017u();
                } else {
                    this.f10760f = (AppConfiguration) JsonUtil.a(string, AppConfiguration.class);
                }
            }
            this.f10761g.unlock();
            return this.f10760f;
        } catch (Throwable th) {
            this.f10761g.unlock();
        }
    }

    public static AppConfiguration m9017u() {
        Closeable openRawResource = FrontpageApplication.a.getResources().openRawResource(C1761R.raw.handshake);
        AppConfiguration appConfiguration;
        try {
            appConfiguration = (AppConfiguration) new Gson().m7481a(new BufferedReader(new InputStreamReader(openRawResource, "UTF-8")), AppConfiguration.class);
            return appConfiguration;
        } catch (IOException e) {
            appConfiguration = e;
            Timber.c(appConfiguration, f10755c, new Object[0]);
            return null;
        } finally {
            IOUtil.a(openRawResource);
        }
    }

    public final void m9018a(AppConfiguration appConfiguration) {
        this.f10761g.lock();
        if (appConfiguration == null) {
            this.f10761g.unlock();
            return;
        }
        try {
            this.f10760f = appConfiguration;
            this.f10758a.edit().putString("com.reddit.frontpage.app_config", JsonUtil.a(appConfiguration)).apply();
            this.f10758a.edit().putLong("com.reddit.frontpage.app_config_timestamp", System.currentTimeMillis()).apply();
            this.f10759b.edit().putLong("com.reddit.frontpage.app_config_timestamp", System.currentTimeMillis()).apply();
            this.f10759b.edit().putString("com.reddit.frontpage.app_config", JsonUtil.a(appConfiguration)).apply();
        } finally {
            this.f10761g.unlock();
        }
    }

    public final boolean m9051l(String str) {
        SharedPreferences sharedPreferences = this.f10758a;
        StringBuilder stringBuilder = new StringBuilder("com.reddit.frontpage.rage_shake_enabled");
        stringBuilder.append(str);
        return sharedPreferences.getBoolean(stringBuilder.toString(), false);
    }

    public static void m9015m(String str) {
        FrontpageSettings a = m9011a();
        String username = SessionManager.m9191b().f10840c.getUsername();
        if (!a.m9051l(username) && TextUtils.equals(str, "redditandroidbeta") != null) {
            str = a.f10758a.edit();
            StringBuilder stringBuilder = new StringBuilder("com.reddit.frontpage.rage_shake_enabled");
            stringBuilder.append(username);
            str = str.putBoolean(stringBuilder.toString(), true);
            str.putBoolean("com.reddit.frontpage.rage_shake_enabled", true);
            str.apply();
        }
    }

    public final void m9060v() {
        this.f10758a.edit().putInt("com.reddit.frontpage.ads_seen", this.f10758a.getInt("com.reddit.frontpage.ads_seen", 0) + 1).apply();
    }

    private static SharedPreferences m9013b(Context context, String str) {
        return context.getSharedPreferences(String.format("com.reddit.frontpage.settings.%s", new Object[]{str}), 0);
    }
}
