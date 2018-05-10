package com.google.firebase.iid;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.io.IOException;
import java.security.KeyPair;
import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FirebaseInstanceId {
    static zzy f8610a;
    private static final long f8611d = TimeUnit.HOURS.toSeconds(8);
    private static Map<String, FirebaseInstanceId> f8612e = new ArrayMap();
    private static ScheduledThreadPoolExecutor f8613f;
    final FirebaseApp f8614b;
    final zzu f8615c;
    private final zzv f8616g;
    private KeyPair f8617h;
    private boolean f8618i = false;

    private FirebaseInstanceId(FirebaseApp firebaseApp) {
        this.f8614b = firebaseApp;
        if (zzu.m7401a(firebaseApp) == null) {
            throw new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
        }
        this.f8615c = new zzu(firebaseApp.m7353a());
        this.f8616g = new zzv(firebaseApp.m7353a(), this.f8615c);
        zzz e = m7366e();
        if (e == null || e.m7433b(this.f8615c.m7405b()) || f8610a.m7423a() != null) {
            m7363b();
        }
    }

    public static FirebaseInstanceId m7356a() {
        return getInstance(FirebaseApp.m7346c());
    }

    static void m7357a(Runnable runnable, long j) {
        synchronized (FirebaseInstanceId.class) {
            if (f8613f == null) {
                f8613f = new ScheduledThreadPoolExecutor(1);
            }
            f8613f.schedule(runnable, j, TimeUnit.SECONDS);
        }
    }

    static zzy m7358f() {
        return f8610a;
    }

    static boolean m7359g() {
        if (!Log.isLoggable("FirebaseInstanceId", 3)) {
            if (VERSION.SDK_INT != 23 || !Log.isLoggable("FirebaseInstanceId", 3)) {
                return false;
            }
        }
        return true;
    }

    final synchronized void m7361a(long j) {
        m7357a(new zzaa(this, this.f8615c, Math.min(Math.max(30, j << 1), f8611d)), j);
        this.f8618i = true;
    }

    final synchronized void m7362a(boolean z) {
        this.f8618i = z;
    }

    final synchronized void m7363b() {
        if (!this.f8618i) {
            m7361a(0);
        }
    }

    public final String m7364c() {
        if (this.f8617h == null) {
            this.f8617h = f8610a.m7430e("");
        }
        if (this.f8617h == null) {
            this.f8617h = f8610a.m7426b("");
        }
        return zzu.m7402a(this.f8617h);
    }

    public final String m7365d() {
        zzz e = m7366e();
        if (e == null || e.m7433b(this.f8615c.m7405b())) {
            m7363b();
        }
        return e != null ? e.f8692a : null;
    }

    final zzz m7366e() {
        return f8610a.m7422a("", zzu.m7401a(this.f8614b), Operation.MULTIPLY);
    }

    @Keep
    public static synchronized FirebaseInstanceId getInstance(FirebaseApp firebaseApp) {
        FirebaseInstanceId firebaseInstanceId;
        synchronized (FirebaseInstanceId.class) {
            firebaseInstanceId = (FirebaseInstanceId) f8612e.get(firebaseApp.m7354b().f8603a);
            if (firebaseInstanceId == null) {
                if (f8610a == null) {
                    f8610a = new zzy(firebaseApp.m7353a());
                }
                firebaseInstanceId = new FirebaseInstanceId(firebaseApp);
                f8612e.put(firebaseApp.m7354b().f8603a, firebaseInstanceId);
            }
        }
        return firebaseInstanceId;
    }

    final String m7360a(String str, String str2, Bundle bundle) throws IOException {
        bundle.putString("scope", str2);
        bundle.putString("sender", str);
        bundle.putString("subtype", str);
        bundle.putString("appid", m7364c());
        bundle.putString("gmp_app_id", this.f8614b.m7354b().f8603a);
        bundle.putString("gmsv", Integer.toString(this.f8615c.m7407d()));
        bundle.putString("osv", Integer.toString(VERSION.SDK_INT));
        bundle.putString("app_ver", this.f8615c.m7405b());
        bundle.putString("app_ver_name", this.f8615c.m7406c());
        bundle.putString("cliv", "fiid-11910000");
        str = this.f8616g.m7414a(bundle);
        if (str == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        str2 = str.getString("registration_id");
        if (str2 == null) {
            str2 = str.getString("unregistered");
            if (str2 == null) {
                str2 = str.getString("error");
                if (str2 != null) {
                    throw new IOException(str2);
                }
                str = String.valueOf(str);
                StringBuilder stringBuilder = new StringBuilder(20 + String.valueOf(str).length());
                stringBuilder.append("Unexpected response ");
                stringBuilder.append(str);
                Log.w("FirebaseInstanceId", stringBuilder.toString(), new Throwable());
                throw new IOException("SERVICE_NOT_AVAILABLE");
            }
        }
        if ("RST".equals(str2) == null) {
            if (str2.startsWith("RST|") == null) {
                return str2;
            }
        }
        m7367h();
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    final void m7367h() {
        f8610a.m7427b();
        f8610a.m7428c("");
        this.f8617h = null;
        m7363b();
    }
}
