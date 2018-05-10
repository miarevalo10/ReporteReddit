package com.reddit.datalibrary.frontpage.redditauth.account;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.crashlytics.android.Crashlytics;
import com.google.common.base.Strings;
import com.reddit.datalibrary.frontpage.data.feature.account.datasource.local.AccountStorage;
import com.reddit.datalibrary.frontpage.data.feature.settings.InternalSettings;
import com.reddit.datalibrary.frontpage.redditauth.account.Session.SessionId;
import com.reddit.datalibrary.frontpage.redditauth.account.TokenUtil.TokenRotationError;
import com.reddit.datalibrary.frontpage.redditauth.models.Scope;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.presentation.accounts.AccountPickerFragment;
import com.reddit.frontpage.redditauth_private.ui.AuthActivity;
import com.reddit.frontpage.util.SchedulerProvider;
import com.reddit.frontpage.util.SessionUtil;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import timber.log.Timber;

public class SessionManager {
    public static final Object f10837a = new Object();
    private static SessionManager f10838e;
    public final Session f10839b = m9184a(null, "com.reddit.account", null, -1);
    public Session f10840c;
    public boolean f10841d;
    private final PublishSubject<Session> f10842f = PublishSubject.create();
    private final ConcurrentMap<SessionId, Session> f10843g = new ConcurrentHashMap();

    public static void m9185a() {
        m9191b();
    }

    private SessionManager() {
        if (this.f10840c == null) {
            SharedPreferences sharedPreferences = FrontpageApplication.a.getSharedPreferences("com.reddit.auth", 0);
            String string = sharedPreferences.getString("username", null);
            String string2 = sharedPreferences.getString("account_type", "com.reddit.account");
            String string3 = sharedPreferences.getString("token", null);
            long j = sharedPreferences.getLong("token_expiration", -1);
            if (string != null) {
                m9193d(m9184a(string, string2, string3, j));
                if (!m9190a(string)) {
                    m9195i();
                    return;
                }
            }
            m9193d(this.f10839b);
        }
    }

    private void m9193d(Session session) {
        this.f10840c = session;
        session = this.f10840c.getUsername();
        if (Strings.m6933a(session)) {
            Crashlytics.setUserName("anonymous");
        } else {
            Crashlytics.setUserName(session);
        }
        m9194e(this.f10840c);
    }

    private Session m9184a(String str, String str2, String str3, long j) {
        SessionId a = SessionId.m9180a(str, str2);
        Session session = (Session) this.f10843g.get(a);
        if (session == null) {
            session = new Session(str, str2, str3);
            Session session2 = (Session) this.f10843g.putIfAbsent(a, session);
            if (session2 != null) {
                session = session2;
            }
        }
        if (j != -1) {
            session.m16310a(str3, j);
        }
        return session;
    }

    private static void m9194e(Session session) {
        FrontpageApplication.a.getSharedPreferences("com.reddit.auth", 0).edit().putString("username", session.getUsername()).putString("account_type", session.f16288a.f10835b).putString("token", session.f16289b).putLong("token_expiration", session.f16290c).apply();
    }

    private static boolean m9190a(String str) {
        for (Account account : AccountManager.get(FrontpageApplication.a).getAccountsByType("com.reddit.account")) {
            if (account.name.contains(str)) {
                return true;
            }
        }
        return false;
    }

    public static SessionManager m9191b() {
        if (f10838e == null) {
            f10838e = new SessionManager();
        }
        return f10838e;
    }

    public final void m9198a(FragmentActivity fragmentActivity, boolean z) {
        ArrayList b = AccountUtil.m9172b(fragmentActivity.getApplicationContext());
        Timber.b("current user = %s type = %s", new Object[]{this.f10840c.getUsername(), this.f10840c.f16288a.f10835b});
        if (b.isEmpty()) {
            fragmentActivity.startActivityForResult(m9183a((Context) fragmentActivity, z), 42);
        } else {
            new AccountPickerFragment().a(fragmentActivity.getSupportFragmentManager(), null);
        }
    }

    public static void m9186a(Fragment fragment) {
        fragment.startActivityForResult(m9183a(fragment.getContext(), false), 42);
    }

    private static Intent m9183a(Context context, boolean z) {
        return new Intent(context, AuthActivity.class).putExtra("com.reddit.is_signup", z);
    }

    private void m9189a(boolean z, boolean z2) {
        if (!z) {
            Intent intent = new Intent("com.reddit.SESSION_CHANGED");
            intent.putExtra("com.reddit.extra.is_sign_up", this.f10841d);
            intent.putExtra("com.reddit.extra.clear_backstack", z2);
            LocalBroadcastManager.m744a(FrontpageApplication.a).m748a(intent);
        }
        this.f10841d = false;
        SessionUtil.c();
        if (!z) {
            this.f10842f.onNext(this.f10840c);
        }
    }

    public final void m9197a(int i, int i2, Intent intent) {
        Timber.b("got result", new Object[0]);
        if (i == 42 && i2 == -1) {
            Timber.b("result: name=%s type=%s", new Object[]{intent.getStringExtra("authAccount"), intent.getStringExtra("accountType")});
            m9200a(r4, r5, false);
            Timber.b("onActivityResult called", new Object[0]);
        }
    }

    public final void m9200a(String str, String str2, boolean z) {
        m9193d(m9184a(str, str2, null, -1));
        m9189a(z, InternalSettings.m9061a().m9085p() == null ? true : null);
        FrontpageApplication.a();
    }

    public final void m9199a(Session session) {
        AccountManager accountManager = AccountManager.get(FrontpageApplication.a);
        if (TextUtils.equals(session.getUsername(), this.f10840c.getUsername())) {
            FrontpageApplication.a.getSharedPreferences("com.reddit.auth", 0).edit().remove("token").apply();
        }
        accountManager.invalidateAuthToken(session.f16288a.f10835b, session.f16289b);
        m9188a(session, "invalid-token", -1);
        Timber.b("invalidateToken: %s(%s) busted %s", new Object[]{session.getUsername(), session.f16288a.f10835b, session.f16289b});
    }

    private void m9188a(Session session, String str, long j) {
        session.m16310a(str, j);
        if (session.getUsername() != null || this.f10839b.equals(this.f10840c) == null) {
            if (TextUtils.equals(session.getUsername(), this.f10840c.getUsername()) != null) {
                m9194e(session);
            }
            return;
        }
        m9194e(session);
    }

    private void m9187a(Session session, Bundle bundle) {
        if (bundle != null) {
            String string = bundle.getString("authtoken");
            long j = bundle.getLong("com.reddit.expiration");
            Timber.b("Got new token: %s", new Object[]{session.f16289b});
            m9188a(session, string, j);
        }
    }

    public final Session m9203c() {
        return this.f10840c;
    }

    public final com.reddit.datalibrary.frontpage.requests.models.v1.Account m9205d() {
        return (com.reddit.datalibrary.frontpage.requests.models.v1.Account) AccountStorage.f15744b.m8751a(this.f10840c.getUsername());
    }

    public final Session m9196a(Account account) throws TokenRotationError {
        if (TextUtils.equals(account.name, "Reddit for Android")) {
            return this.f10839b;
        }
        Bundle c = m9192c(account);
        String string = c.getString("authtoken");
        long j = c.getLong("com.reddit.expiration", -1);
        Timber.b("Token from account manager: %s", new Object[]{string});
        return m9184a(account.name, account.type, string, j);
    }

    public final void m9206e() {
        if (this.f10840c == null) {
            Timber.d("No active session", new Object[0]);
            return;
        }
        if (this.f10840c.m16313d()) {
            try {
                m9204c(this.f10840c);
            } catch (Throwable e) {
                Timber.c(e, "Failed to get token for session: %s", new Object[]{this.f10840c.getUsername()});
            }
        }
    }

    public final Session m9201b(Session session) {
        Session session2 = (Session) this.f10843g.putIfAbsent(session.f16288a, session);
        return session2 == null ? (Session) this.f10843g.get(session.f16288a) : session2;
    }

    private void m9195i() {
        if (!this.f10840c.isAnonymous()) {
            FrontpageApplication.a.getSharedPreferences("com.reddit.auth", 0).edit().clear().apply();
            this.f10843g.remove(this.f10840c.f16288a);
            this.f10840c = this.f10839b;
            Crashlytics.setUserName("anonymous");
        }
    }

    public final void m9207f() {
        m9195i();
        m9189a(false, true);
    }

    public final boolean m9202b(Account account) {
        if (this.f10840c == null || SessionId.m9180a(account.name, account.type).equals(this.f10840c.f16288a) == null) {
            return false;
        }
        m9207f();
        return true;
    }

    public final void m9204c(Session session) throws TokenRotationError {
        Timber.b("requestTokenSynchronous", new Object[0]);
        m9199a(this.f10840c);
        Timber.b("account type: %s", new Object[]{session.f16288a.f10835b});
        if (session.isAnonymous()) {
            m9187a(this.f10839b, m9192c(new Account("Reddit for Android", "com.reddit.account")));
            return;
        }
        m9187a(session, m9192c(new Account(session.getUsername(), session.f16288a.f10835b)));
    }

    private static Bundle m9192c(Account account) throws TokenRotationError {
        try {
            Bundle bundle = (Bundle) AccountManager.get(FrontpageApplication.a).getAuthToken(account, Scope.WILD_SCOPE.toString(), null, false, null, null).getResult();
            if (bundle != null) {
                return bundle;
            }
            throw new TokenRotationError("Unable to retrieve token; bundle was null");
        } catch (Exception e) {
            throw new TokenRotationError(e);
        }
    }

    public final Observable<Session> m9208g() {
        return this.f10842f;
    }

    public final Observable<String> m9209h() {
        if (this.f10840c.m16313d()) {
            return Observable.fromCallable(new SessionManager$$Lambda$0(this)).subscribeOn(SchedulerProvider.b());
        }
        return Observable.just(this.f10840c.f16289b);
    }
}
