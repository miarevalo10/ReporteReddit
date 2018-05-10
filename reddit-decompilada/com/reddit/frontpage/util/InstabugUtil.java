package com.reddit.frontpage.util;

import android.app.Activity;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog.Builder;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.instabug.library.Instabug;
import com.instabug.library.invocation.InstabugInvocationEvent;
import com.instabug.library.okhttplogger.InstabugOkhttpInterceptor;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.data.feature.settings.InternalSettings;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.auth.RedditGoogleAuthUtil;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Response;
import timber.log.Timber;

public class InstabugUtil {
    public static final Interceptor f21744a = new C23781();
    private static boolean f21745b = false;

    static class C23781 implements Interceptor {
        InstabugOkhttpInterceptor f29381a;

        C23781() {
        }

        public final Response intercept(Chain chain) throws IOException {
            if (!InstabugUtil.m23735c()) {
                return chain.proceed(chain.request());
            }
            if (this.f29381a == null) {
                this.f29381a = new InstabugOkhttpInterceptor();
            }
            return this.f29381a.intercept(chain);
        }
    }

    public static void m23733a(Activity activity) {
        new Builder(activity).a(C1761R.string.title_beta_tester_enabled).b(C1761R.string.beta_tester_enabled_message).a(C1761R.string.action_okay, null).c();
    }

    public static void m23732a() {
        if (m23736d()) {
            m23737e();
        } else if (f21745b) {
            Instabug.disable();
        }
        String username = SessionManager.b().c.getUsername();
        InternalSettings a = InternalSettings.a();
        FrontpageSettings a2 = FrontpageSettings.a();
        if (!a2.a.getBoolean("com.reddit.frontpage.rage_shake_enabled", false)) {
            return;
        }
        if (a2.l(username) || a.o()) {
            m23734b();
        }
    }

    private static void m23737e() {
        if (m23736d()) {
            if (!f21745b) {
                new Instabug.Builder(FrontpageApplication.f27402a, "10878251e315fa5ee93c7d67be5ec5d3").setInvocationEvent(InstabugInvocationEvent.SCREENSHOT_GESTURE).build();
                Instabug.setIntroMessageEnabled(false);
                Instabug.setPromptOptionsEnabled(false, true, true);
                Instabug.setAttachmentTypesEnabled(true, true, true, false, false);
                GoogleSignInAccount a = RedditGoogleAuthUtil.m21797a(FrontpageApplication.f27402a);
                if (a != null) {
                    Instabug.identifyUser(a.c, a.b);
                }
                f21745b = true;
            }
            Instabug.enable();
            return;
        }
        Timber.d("Instabug started, but isn't supposed to be enabled", new Object[0]);
    }

    public static boolean m23735c() {
        return f21745b;
    }

    private static boolean m23736d() {
        if (PreferenceManager.getDefaultSharedPreferences(FrontpageApplication.f27402a).getBoolean("com.reddit.pref.rage_shake_unlocked", false) || InternalAccountUtil.m23766a()) {
            return true;
        }
        return false;
    }

    public static void m23734b() {
        PreferenceManager.getDefaultSharedPreferences(FrontpageApplication.f27402a).edit().putBoolean("com.reddit.pref.rage_shake_unlocked", true).apply();
        m23737e();
    }
}
