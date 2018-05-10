package com.reddit.frontpage.util;

import android.text.TextUtils;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import com.reddit.datalibrary.frontpage.job.ReportLogoutJob;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.FrontpageApplication;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import timber.log.Timber;

public class PushUtil {
    private static final AtomicBoolean f21784a = new AtomicBoolean(false);

    public static void m23872a() {
        if (m23878e()) {
            Timber.b("Firebase SDK initializing.", new Object[0]);
            FirebaseApp.a(FrontpageApplication.f27402a);
            return;
        }
        Timber.b("Google Play Services not detected, bypassing Firebase SDK initialization.", new Object[0]);
    }

    public static void m23875b() {
        if (m23878e()) {
            boolean z = true;
            if (f21784a.getAndSet(true)) {
                Timber.b("Another push token is in progress of being registered.", new Object[0]);
                return;
            }
            CharSequence d = FirebaseInstanceId.a().d();
            CharSequence string = FrontpageSettings.a().a.getString("com.reddit.pref.last_push_token", null);
            if (!TextUtils.isEmpty(string)) {
                if (TextUtils.equals(d, string)) {
                    boolean equals = TextUtils.equals(SessionManager.b().c.getUsername(), FrontpageSettings.a().a.getString("com.reddit.pref.last_push_token_user", null));
                    if (!equals) {
                        Timber.b("Current user for push token: %s", new Object[]{d});
                        Timber.b("Previous user for push token: %s", new Object[]{string});
                    }
                    if (equals) {
                        z = false;
                    }
                    if (z) {
                        Timber.b("Push token state not being updated, releasing lock.", new Object[0]);
                        f21784a.set(false);
                        return;
                    }
                    m23876c();
                    return;
                }
            }
            Timber.b("Current push token: %s", new Object[]{d});
            Timber.b("Previous push token: %s", new Object[]{string});
            if (z) {
                m23876c();
                return;
            }
            Timber.b("Push token state not being updated, releasing lock.", new Object[0]);
            f21784a.set(false);
            return;
        }
        Timber.b("Google Play Services not detected, bypassing push token reset.", new Object[0]);
    }

    public static void m23876c() {
        if (m23878e()) {
            final String d = FirebaseInstanceId.a().d();
            if (TextUtils.isEmpty(d)) {
                f21784a.set(false);
                Timber.b("Push token is null or empty, releasing lock.", new Object[0]);
                return;
            }
            Timber.b("Refreshed push token: %s", new Object[]{d});
            RemoteRedditApiDataSource remoteRedditApiDataSource = new RemoteRedditApiDataSource();
            RemoteRedditApiDataSource.w(d).subscribeOn(SchedulerProvider.m23886b()).observeOn(SchedulerProvider.m23887c()).subscribe(new CompletableObserver() {
                public final void onSubscribe(Disposable disposable) {
                }

                public final void onComplete() {
                    PushUtil.m23874a(d);
                    Timber.b("Push token registered successfully, releasing lock.", new Object[0]);
                    PushUtil.f21784a.set(false);
                }

                public final void onError(Throwable th) {
                    PushUtil.m23874a((String) null);
                    Timber.b("Push token registration unsuccessful, releasing lock.", new Object[0]);
                    PushUtil.f21784a.set(false);
                }
            });
            return;
        }
        Timber.b("Google Play Services not detected, bypassing push token force reset.", new Object[0]);
    }

    public static void m23873a(Session session) {
        if (!session.isAnonymous()) {
            RedditJobManager.a().a(new ReportLogoutJob(session));
        }
    }

    private static boolean m23878e() {
        return GoogleApiAvailability.a().a(FrontpageApplication.f27402a) == 0;
    }

    static /* synthetic */ void m23874a(String str) {
        FrontpageSettings.a().b(str);
        FrontpageSettings.a().c(SessionManager.b().c.getUsername());
    }
}
