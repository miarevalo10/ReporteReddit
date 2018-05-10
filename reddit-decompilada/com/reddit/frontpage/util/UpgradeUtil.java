package com.reddit.frontpage.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.data.feature.settings.InternalSettings;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import timber.log.Timber;

public class UpgradeUtil {
    public static void m23943a() {
        int i = InternalSettings.a().a.getInt("com.reddit.pref.old_version", RedditJobManager.f10810d);
        Object obj = null;
        Object obj2 = i < 209200 ? 1 : null;
        if (i == RedditJobManager.f10810d && InternalSettings.a().g()) {
            obj = 1;
        }
        if (obj2 != null) {
            m23944a(i);
        } else if (obj != null) {
            m23944a(46);
        }
        InternalSettings.a().a(209200);
    }

    public static boolean m23945b() {
        Context context = FrontpageApplication.f27402a;
        return TextUtils.equals("com.android.vending", context.getPackageManager().getInstallerPackageName(context.getPackageName()));
    }

    public static boolean m23946c() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = com.reddit.frontpage.FrontpageApplication.f27402a;
        r1 = 0;
        r0 = r0.getPackageManager();	 Catch:{ NameNotFoundException -> 0x000e }
        r2 = "com.android.vending";	 Catch:{ NameNotFoundException -> 0x000e }
        r0.getPackageInfo(r2, r1);	 Catch:{ NameNotFoundException -> 0x000e }
        r0 = 1;
        return r0;
    L_0x000e:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.util.UpgradeUtil.c():boolean");
    }

    public static boolean m23947d() {
        AppConfiguration t = FrontpageSettings.a().t();
        return (t == null || t.global == null || t.global.app_version_check == null || !m23946c() || 209200 >= t.global.app_version_check.min_version) ? false : true;
    }

    private static void m23944a(int i) {
        if (i <= 52) {
            Timber.b("Upgrade 52: Reloading the app config since the structure has changed entirely", new Object[0]);
            FrontpageSettings.a().a(FrontpageSettings.u());
        }
        if (i <= 160) {
            InternalSettings a = InternalSettings.a();
            if (TextUtils.isEmpty(a.c())) {
                a.a.edit().putLong("com.reddit.frontpage.install_settings.install_timestamp", a.d()).apply();
            }
        }
        if (i <= 20500) {
            i = FrontpageApplication.f27402a.getSharedPreferences("com.reddit.frontpage.settings", 0);
            FrontpageSettings a2 = FrontpageSettings.a();
            a2.a(i.getBoolean("com.reddit.mobile.disable_preview_images", false));
            a2.a(i.getBoolean("com.reddit.pref.compact_listing_view", false), false);
            a2.b(i.getBoolean("com.reddit.pref.night_mode", false));
            a2.e(i.getBoolean("com.reddit.pref.blur_nsfw", true));
            a2.a(i.getString("com.reddit.pref.autoplay", Util.m24027f((int) C1761R.string.option_value_always)));
            a2.b(i.getString("com.reddit.pref.last_push_token", null));
            a2.c(i.getString("com.reddit.pref.last_push_token_user", null));
            a2.d(i.getString("com.reddit.pref.base_uri", Util.m24027f((int) C1761R.string.base_uri_default)));
            a2.e(i.getString("com.reddit.pref.gateway_uri", Util.m24027f((int) C1761R.string.gateway_uri_default)));
            a2.g(i.getBoolean("com.reddit.pref.dummy_upcoming_event", false));
            InternalSettings.a().a(i.getInt("com.reddit.pref.old_version", RedditJobManager.f10810d));
            i.edit().clear().apply();
            if (SessionManager.b().c.isAnonymous() == 0) {
                i = FrontpageApplication.f27402a.getSharedPreferences("com.reddit.frontpage.internal_settings", 0);
                SharedPreferences sharedPreferences = FrontpageApplication.f27402a.getSharedPreferences("com.reddit.frontpage.internal_settings", 0);
                sharedPreferences.edit().putLong("com.reddit.frontpage.last_upvote_timestamp", i.getLong("com.reddit.frontpage.last_upvote_timestamp", 0)).apply();
                sharedPreferences.edit().putBoolean("com.reddit.frontpage.rage_shake_unlocked", i.getBoolean("com.reddit.frontpage.rake_shake_unlocked", false)).apply();
            }
        }
        Timber.b("Upgrades complete", new Object[0]);
    }
}
