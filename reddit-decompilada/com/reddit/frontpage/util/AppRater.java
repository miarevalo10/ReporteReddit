package com.reddit.frontpage.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.design.widget.Snackbar.SnackbarLayout;
import android.support.design.widget.TwoActionSnackbar;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.data.feature.settings.InternalSettings;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration.RateOrShare;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.nav.Screens;
import timber.log.Timber;

public class AppRater {

    private static class Version {
        final int f21696a;
        final int f21697b;

        private Version(int i, int i2) {
            this.f21696a = i;
            this.f21697b = i2;
        }

        public static com.reddit.frontpage.util.AppRater.Version m23640a(java.lang.String r6) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = android.text.TextUtils.isEmpty(r6);
            r1 = 0;
            if (r0 == 0) goto L_0x0008;
        L_0x0007:
            return r1;
        L_0x0008:
            r0 = "\\.";
            r0 = r6.split(r0);
            r2 = 0;
            r3 = 1;
            r4 = r0.length;
            if (r4 <= r3) goto L_0x0030;
        L_0x0013:
            r4 = r0[r2];	 Catch:{ NumberFormatException -> 0x0026 }
            r4 = java.lang.Integer.parseInt(r4);	 Catch:{ NumberFormatException -> 0x0026 }
            r0 = r0[r3];	 Catch:{ NumberFormatException -> 0x0026 }
            r0 = java.lang.Integer.parseInt(r0);	 Catch:{ NumberFormatException -> 0x0026 }
            r5 = new com.reddit.frontpage.util.AppRater$Version;	 Catch:{ NumberFormatException -> 0x0026 }
            r5.<init>(r4, r0);	 Catch:{ NumberFormatException -> 0x0026 }
            r1 = r5;
            goto L_0x0039;
        L_0x0026:
            r0 = "Unable to parse version: %s";
            r3 = new java.lang.Object[r3];
            r3[r2] = r6;
            timber.log.Timber.e(r0, r3);
            goto L_0x0039;
        L_0x0030:
            r0 = "Version did not match x.y.z pattern: %s";
            r3 = new java.lang.Object[r3];
            r3[r2] = r6;
            timber.log.Timber.e(r0, r3);
        L_0x0039:
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.util.AppRater.Version.a(java.lang.String):com.reddit.frontpage.util.AppRater$Version");
        }
    }

    public static void m23641a() {
        if (m23646b()) {
            InternalSettings a = InternalSettings.a();
            a.a.edit().putInt("com.reddit.frontpage.app_open_count", a.l() + 1).apply();
            Timber.b("Incremented app open count to [%d]", new Object[]{Integer.valueOf(a.l())});
        }
    }

    public static void m23644a(Screen screen) {
        if (screen != null) {
            View b = Screens.m22633b(screen);
            if (b != null) {
                InternalSettings a = InternalSettings.a();
                CharSequence m = a.m();
                String c = m23647c();
                if (a.l() >= (TextUtils.isEmpty(m) ? 5 : 2) && m23646b()) {
                    m23643a(b);
                    a.a.edit().putString("com.reddit.frontpage.version_user_prompted_to_rate", c).apply();
                    a.a.edit().putInt("com.reddit.frontpage.app_open_count", 0).apply();
                }
            }
        }
    }

    public static void m23643a(View view) {
        Timber.b("Prompting user to rate", new Object[0]);
        TwoActionSnackbar a = ViewUtils.m24061a(view, C1761R.string.prompt_enjoy_app);
        a.a(C1761R.string.label_not_really, new AppRater$$Lambda$0(view));
        a.b(C1761R.string.label_love_it, new AppRater$$Lambda$1(view));
        a.a();
        view = AppAnalytics.m21864c();
        view.f20004a = "enjoying_reddit";
        view.m21846a();
    }

    static final /* synthetic */ void m23650e(View view) {
        Snackbar a;
        if (FrontpageSettings.a().t().e()) {
            a = ViewUtils.m24059a(view, (int) C1761R.string.prompt_share_app, 5000);
            a.a(C1761R.string.action_share, AppRater$$Lambda$4.f21694a);
            m23642a(a);
            a.a();
        } else {
            a = ViewUtils.m24059a(view, (int) C1761R.string.prompt_rate_app, 5000);
            a.a(C1761R.string.label_rate, AppRater$$Lambda$5.f21695a);
            m23642a(a);
            a.a();
        }
        view = AppAnalytics.m21858b();
        view.f19954a = "home";
        view.f19955b = "enjoying_reddit_yes";
        view.m21825a();
    }

    static final /* synthetic */ void m23649d(View view) {
        Context context = view.getContext();
        context.startActivity(IntentUtil.m23747a(context, context.getResources().getString(C1761R.string.feedback_uri), ContextCompat.c(context, C1761R.color.rdt_alien_blue)));
    }

    static final /* synthetic */ void m23648c(View view) {
        Context context = view.getContext();
        InternalSettings.a().k();
        RateOrShare rateOrShare = FrontpageSettings.a().t().experiments.enjoy_reddit_toast;
        context.startActivity(IntentUtil.m23746a(context, context.getResources().getString(C1761R.string.share_post_link, new Object[]{rateOrShare.copy, rateOrShare.link})));
        view = AppAnalytics.m21858b();
        view.f19954a = "home";
        view.f19955b = "enjoying_reddit_share";
        view.m21825a();
    }

    static final /* synthetic */ void m23645b(View view) {
        view = view.getContext();
        InternalSettings.a().k();
        view.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(FrontpageSettings.a().t().global.app_version_check.update_url)));
    }

    private static boolean m23646b() {
        int max;
        InternalSettings a = InternalSettings.a();
        CharSequence m = a.m();
        String c = m23647c();
        if (!TextUtils.isEmpty(m)) {
            Version a2 = Version.m23640a(c);
            Version a3 = Version.m23640a(m);
            if (a2.f21696a > a3.f21696a) {
                max = Math.max(a2.f21697b, a2.f21697b - a3.f21697b) + (a2.f21696a - a3.f21696a);
            } else if (a2.f21696a == a3.f21696a) {
                max = a2.f21697b - a3.f21697b;
            }
            if (!a.a.getBoolean("com.reddit.frontpage.user_rated_app", false) && max < 8) {
                Timber.b("User rated app; version difference [%d] does not meet or exceed [%d]", new Object[]{Integer.valueOf(max), Integer.valueOf(8)});
                return false;
            } else if ((TextUtils.isEmpty(m) ^ 1) == 0 && max < 2) {
                Timber.b("User saw prompt; version difference [%d] does not meet or exceed [%d]", new Object[]{Integer.valueOf(max), Integer.valueOf(2)});
                return false;
            } else if (!UpgradeUtil.m23945b()) {
                Timber.b("App not installed from Google Play store", new Object[0]);
                return false;
            } else if (!UpgradeUtil.m23946c()) {
                return true;
            } else {
                Timber.b("Google Play store not installed", new Object[0]);
                return false;
            }
        }
        max = 0;
        if (!a.a.getBoolean("com.reddit.frontpage.user_rated_app", false)) {
        }
        if ((TextUtils.isEmpty(m) ^ 1) == 0) {
        }
        if (!UpgradeUtil.m23945b()) {
            Timber.b("App not installed from Google Play store", new Object[0]);
            return false;
        } else if (!UpgradeUtil.m23946c()) {
            return true;
        } else {
            Timber.b("Google Play store not installed", new Object[0]);
            return false;
        }
    }

    private static java.lang.String m23647c() {
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
        r2 = r0.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0012 }
        r0 = r0.getPackageName();	 Catch:{ NameNotFoundException -> 0x0012 }
        r0 = r2.getPackageInfo(r0, r1);	 Catch:{ NameNotFoundException -> 0x0012 }
        r0 = r0.versionName;	 Catch:{ NameNotFoundException -> 0x0012 }
        goto L_0x001a;
    L_0x0012:
        r0 = "Impossible happened! Our package wasn't found...";
        r1 = new java.lang.Object[r1];
        timber.log.Timber.e(r0, r1);
        r0 = 0;
    L_0x001a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.util.AppRater.c():java.lang.String");
    }

    @SuppressLint({"PrivateResource"})
    private static void m23642a(Snackbar snackbar) {
        SnackbarLayout snackbarLayout = (SnackbarLayout) snackbar.d;
        TextView textView = (TextView) snackbarLayout.findViewById(C1761R.id.snackbar_text);
        Resources resources = textView.getResources();
        textView.setCompoundDrawablesWithIntrinsicBounds(FrontpageSettings.a().d() ? C1761R.drawable.toast_snoo : C1761R.drawable.toast_snoo_dark, 0, 0, 0);
        textView.setCompoundDrawablePadding(resources.getDimensionPixelSize(C1761R.dimen.design_snackbar_padding_horizontal));
        textView.setPadding(0, snackbarLayout.getPaddingTop(), snackbarLayout.getPaddingRight(), snackbarLayout.getPaddingBottom());
    }

    static final /* synthetic */ void m23651f(View view) {
        view = ViewUtils.m24061a(view, C1761R.string.prompt_feedback);
        view.a(C1761R.string.label_not_now, AppRater$$Lambda$2.f21692a);
        view.b(C1761R.string.label_sure, AppRater$$Lambda$3.f21693a);
        view.a();
        view = AppAnalytics.m21858b();
        view.f19954a = "home";
        view.f19955b = "enjoying_reddit_no";
        view.m21825a();
    }
}
