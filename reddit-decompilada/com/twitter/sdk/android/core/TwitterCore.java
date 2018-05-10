package com.twitter.sdk.android.core;

import android.content.Context;
import com.twitter.sdk.android.core.GuestSession.Serializer;
import com.twitter.sdk.android.core.internal.MigrationHelper;
import com.twitter.sdk.android.core.internal.SessionMonitor;
import com.twitter.sdk.android.core.internal.SessionMonitor.C25251;
import com.twitter.sdk.android.core.internal.TwitterApi;
import com.twitter.sdk.android.core.internal.TwitterSessionVerifier;
import com.twitter.sdk.android.core.internal.oauth.OAuth2Service;
import com.twitter.sdk.android.core.internal.scribe.TwitterCoreScribeClientHolder;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.network.NetworkUtils;
import io.fabric.sdk.android.services.persistence.PreferenceStoreImpl;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.SSLSocketFactory;

public class TwitterCore extends Kit<Boolean> {
    public SessionManager<TwitterSession> f30693a;
    SessionManager<GuestSession> f30694b;
    SessionMonitor<TwitterSession> f30695c;
    public final TwitterAuthConfig f30696d;
    private final ConcurrentHashMap<Session, TwitterApiClient> f30697e;
    private volatile TwitterApiClient f30698f;
    private volatile GuestSessionProvider f30699g;
    private volatile SSLSocketFactory f30700h;

    public String getIdentifier() {
        return "com.twitter.sdk.android:twitter-core";
    }

    public String getVersion() {
        return "2.1.0.155";
    }

    public TwitterCore(TwitterAuthConfig twitterAuthConfig) {
        this(twitterAuthConfig, new ConcurrentHashMap());
    }

    private TwitterCore(TwitterAuthConfig twitterAuthConfig, ConcurrentHashMap<Session, TwitterApiClient> concurrentHashMap) {
        this.f30696d = twitterAuthConfig;
        this.f30697e = concurrentHashMap;
        this.f30698f = null;
    }

    public static TwitterCore m31719a() {
        m31720c();
        return (TwitterCore) Fabric.m26237a(TwitterCore.class);
    }

    public final SSLSocketFactory m31725b() {
        m31720c();
        if (this.f30700h == null) {
            m31721f();
        }
        return this.f30700h;
    }

    private synchronized void m31721f() {
        if (this.f30700h == null) {
            try {
                this.f30700h = NetworkUtils.m26413a(new TwitterPinningInfoProvider(getContext()));
                Fabric.m26243b().mo5562a("Twitter", "Custom SSL pinning enabled");
            } catch (Throwable e) {
                Fabric.m26243b().mo5568c("Twitter", "Exception setting up custom SSL pinning", e);
            }
        }
    }

    protected boolean onPreExecute() {
        MigrationHelper migrationHelper = new MigrationHelper();
        Context context = getContext();
        String identifier = getIdentifier();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getIdentifier());
        stringBuilder.append(":session_store.xml");
        String stringBuilder2 = stringBuilder.toString();
        File a = MigrationHelper.m25856a(context);
        if (a.exists()) {
            if (a.isDirectory()) {
                File file = new File(a, stringBuilder2);
                if (!file.exists()) {
                    a = MigrationHelper.m25857a(a, identifier);
                    if (a != null) {
                        a.renameTo(file);
                    }
                }
            }
        }
        this.f30693a = new PersistedSessionManager(new PreferenceStoreImpl(getContext(), "session_store"), new Serializer(), "active_twittersession", "twittersession");
        this.f30694b = new PersistedSessionManager(new PreferenceStoreImpl(getContext(), "session_store"), new Serializer(), "active_guestsession", "guestsession");
        this.f30695c = new SessionMonitor(this.f30693a, getFabric().f24695c, new TwitterSessionVerifier());
        return true;
    }

    public static void m31720c() {
        if (Fabric.m26237a(TwitterCore.class) == null) {
            throw new IllegalStateException("Must start Twitter Kit with Fabric.with() first");
        }
    }

    public final GuestSessionProvider m31726d() {
        m31720c();
        if (this.f30699g == null) {
            m31722g();
        }
        return this.f30699g;
    }

    private synchronized void m31722g() {
        if (this.f30699g == null) {
            this.f30699g = new GuestSessionProvider(new OAuth2Service(this, m31725b(), new TwitterApi()), this.f30694b);
        }
    }

    public final TwitterApiClient m31727e() {
        m31720c();
        TwitterSession twitterSession = (TwitterSession) this.f30693a.mo5463a();
        if (twitterSession != null) {
            return m31724a(twitterSession);
        }
        m31720c();
        if (this.f30698f == null) {
            m31723h();
        }
        return this.f30698f;
    }

    public final TwitterApiClient m31724a(TwitterSession twitterSession) {
        m31720c();
        if (!this.f30697e.containsKey(twitterSession)) {
            this.f30697e.putIfAbsent(twitterSession, new TwitterApiClient(twitterSession));
        }
        return (TwitterApiClient) this.f30697e.get(twitterSession);
    }

    private synchronized void m31723h() {
        if (this.f30698f == null) {
            this.f30698f = new TwitterApiClient();
        }
    }

    protected /* synthetic */ Object doInBackground() {
        this.f30693a.mo5463a();
        this.f30694b.mo5463a();
        m31725b();
        m31726d();
        m31720c();
        TwitterCoreScribeClientHolder.m25888a(this, this.f30693a, m31726d(), getIdManager());
        getFabric().f24697e.m26232a(new C25251(this.f30695c));
        return Boolean.valueOf(true);
    }
}
