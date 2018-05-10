package com.google.android.gms.internal;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.stetho.server.http.HttpStatus;
import com.google.android.gms.common.api.internal.zzbz;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.common.util.zzh;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.instabug.library.model.State;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

public class zzcim {
    private static volatile zzcim f6958m;
    private final zzcgk f6959A;
    private final zzcgd f6960B;
    private boolean f6961C = false;
    private boolean f6962D;
    private Boolean f6963E;
    private long f6964F;
    private FileLock f6965G;
    private FileChannel f6966H;
    private List<Long> f6967I;
    private int f6968J;
    private long f6969K;
    private long f6970L;
    private boolean f6971M;
    private boolean f6972N;
    private boolean f6973O;
    final Context f6974a;
    final zzcgn f6975b;
    final zzchm f6976c;
    final zzcih f6977d;
    final zzclf f6978e;
    public final AppMeasurement f6979f;
    public final FirebaseAnalytics f6980g;
    final zzchi f6981h;
    final zzd f6982i;
    List<Runnable> f6983j;
    int f6984k;
    final long f6985l;
    private final zzchx f6986n;
    private final zzcig f6987o;
    private final zzclq f6988p;
    private final zzchk f6989q;
    private final zzcgo f6990r;
    private final zzchq f6991s;
    private final zzckc f6992t;
    private final zzckg f6993u;
    private final zzcgu f6994v;
    private final zzcjn f6995w;
    private final zzchh f6996x;
    private final zzchv f6997y;
    private final zzcll f6998z;

    class zza implements zzcgq {
        zzcme f14233a;
        List<Long> f14234b;
        List<zzcmb> f14235c;
        private long f14236d;
        private /* synthetic */ zzcim f14237e;

        private zza(zzcim com_google_android_gms_internal_zzcim) {
            this.f14237e = com_google_android_gms_internal_zzcim;
        }

        private static long m13538a(zzcmb com_google_android_gms_internal_zzcmb) {
            return ((com_google_android_gms_internal_zzcmb.f17962c.longValue() / 1000) / 60) / 60;
        }

        public final void mo1847a(zzcme com_google_android_gms_internal_zzcme) {
            zzbq.m4808a((Object) com_google_android_gms_internal_zzcme);
            this.f14233a = com_google_android_gms_internal_zzcme;
        }

        public final boolean mo1848a(long j, zzcmb com_google_android_gms_internal_zzcmb) {
            zzbq.m4808a((Object) com_google_android_gms_internal_zzcmb);
            if (this.f14235c == null) {
                this.f14235c = new ArrayList();
            }
            if (this.f14234b == null) {
                this.f14234b = new ArrayList();
            }
            if (this.f14235c.size() > 0 && m13538a((zzcmb) this.f14235c.get(0)) != m13538a(com_google_android_gms_internal_zzcmb)) {
                return false;
            }
            long e = this.f14236d + ((long) com_google_android_gms_internal_zzcmb.m6211e());
            if (e >= ((long) Math.max(0, ((Integer) zzchc.f6877k.f6893a).intValue()))) {
                return false;
            }
            this.f14236d = e;
            this.f14235c.add(com_google_android_gms_internal_zzcmb);
            this.f14234b.add(Long.valueOf(j));
            if (this.f14235c.size() >= Math.max(1, ((Integer) zzchc.f6878l.f6893a).intValue())) {
                return false;
            }
            return true;
        }
    }

    private final long m5714B() {
        long a = this.f6982i.mo1632a();
        zzcjk d = m5753d();
        d.m13545L();
        d.mo1811c();
        long a2 = d.f17834g.m5702a();
        if (a2 == 0) {
            a2 = 1 + ((long) d.mo1824p().m18584z().nextInt(86400000));
            d.f17834g.m5703a(a2);
        }
        return ((((a + a2) / 1000) / 60) / 60) / 24;
    }

    private final boolean m5716D() {
        m5755f().mo1811c();
        m5736a();
        return this.f6962D;
    }

    public static zzcim m5720a(Context context) {
        zzbq.m4808a((Object) context);
        zzbq.m4808a(context.getApplicationContext());
        if (f6958m == null) {
            synchronized (zzcim.class) {
                if (f6958m == null) {
                    f6958m = new zzcim(new zzcjm(context));
                }
            }
        }
        return f6958m;
    }

    private static void m5723a(zzcjk com_google_android_gms_internal_zzcjk) {
        if (com_google_android_gms_internal_zzcjk == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    static void m5724a(zzcjl com_google_android_gms_internal_zzcjl) {
        if (com_google_android_gms_internal_zzcjl == null) {
            throw new IllegalStateException("Component not created");
        } else if (!com_google_android_gms_internal_zzcjl.m13544K()) {
            throw new IllegalStateException("Component not initialized");
        }
    }

    private static boolean m5727a(zzcmb com_google_android_gms_internal_zzcmb, String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return false;
        }
        zzcmc[] com_google_android_gms_internal_zzcmcArr = com_google_android_gms_internal_zzcmb.f17960a;
        int length = com_google_android_gms_internal_zzcmcArr.length;
        int i = 0;
        while (i < length) {
            zzcmc com_google_android_gms_internal_zzcmc = com_google_android_gms_internal_zzcmcArr[i];
            if (str.equals(com_google_android_gms_internal_zzcmc.f17966a)) {
                return ((obj instanceof Long) && obj.equals(com_google_android_gms_internal_zzcmc.f17968c)) || (((obj instanceof String) && obj.equals(com_google_android_gms_internal_zzcmc.f17967b)) || ((obj instanceof Double) && obj.equals(com_google_android_gms_internal_zzcmc.f17969d)));
            } else {
                i++;
            }
        }
        return false;
    }

    private final zzcma[] m5729a(String str, zzcmg[] com_google_android_gms_internal_zzcmgArr, zzcmb[] com_google_android_gms_internal_zzcmbArr) {
        zzbq.m4810a(str);
        return m5766q().m17967a(str, com_google_android_gms_internal_zzcmbArr, com_google_android_gms_internal_zzcmgArr);
    }

    static void m5732t() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    private final zzchv m5733y() {
        if (this.f6997y != null) {
            return this.f6997y;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private final zzcll m5734z() {
        m5724a(this.f6998z);
        return this.f6998z;
    }

    final void m5736a() {
        if (!this.f6961C) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
    }

    final void m5739a(zzcgl com_google_android_gms_internal_zzcgl) {
        zzcgi b = m5730b(com_google_android_gms_internal_zzcgl.f17774a);
        if (b != null) {
            m5740a(com_google_android_gms_internal_zzcgl, b);
        }
    }

    final void m5746b(zzcgl com_google_android_gms_internal_zzcgl) {
        zzcgi b = m5730b(com_google_android_gms_internal_zzcgl.f17774a);
        if (b != null) {
            m5747b(com_google_android_gms_internal_zzcgl, b);
        }
    }

    protected final boolean m5749b() {
        m5736a();
        m5755f().mo1811c();
        if (this.f6963E == null || this.f6964F == 0 || !(this.f6963E == null || this.f6963E.booleanValue() || Math.abs(this.f6982i.mo1633b() - this.f6964F) <= 1000)) {
            this.f6964F = this.f6982i.mo1633b();
            boolean z = m5758i().m18563g("android.permission.INTERNET") && m5758i().m18563g("android.permission.ACCESS_NETWORK_STATE") && (zzbhf.m5574a(this.f6974a).m5570a() || (zzcid.m5707a(this.f6974a) && zzcla.m5795a(this.f6974a)));
            this.f6963E = Boolean.valueOf(z);
            if (this.f6963E.booleanValue()) {
                this.f6963E = Boolean.valueOf(m5758i().m18560e(m5765p().m18056A()));
            }
        }
        return this.f6963E.booleanValue();
    }

    final void m5752c(zzcgi com_google_android_gms_internal_zzcgi) {
        Object obj;
        m5755f().mo1811c();
        m5736a();
        zzbq.m4808a((Object) com_google_android_gms_internal_zzcgi);
        zzbq.m4810a(com_google_android_gms_internal_zzcgi.f17759a);
        zzcgh b = m5760k().m18008b(com_google_android_gms_internal_zzcgi.f17759a);
        String b2 = m5753d().m18218b(com_google_android_gms_internal_zzcgi.f17759a);
        if (b == null) {
            b = new zzcgh(this, com_google_android_gms_internal_zzcgi.f17759a);
            b.m5621a(m5765p().m18083y());
            b.m5629c(b2);
        } else if (b2.equals(b.m5630d())) {
            obj = null;
            if (!(TextUtils.isEmpty(com_google_android_gms_internal_zzcgi.f17760b) || com_google_android_gms_internal_zzcgi.f17760b.equals(b.m5627c()))) {
                b.m5625b(com_google_android_gms_internal_zzcgi.f17760b);
                obj = 1;
            }
            if (!(TextUtils.isEmpty(com_google_android_gms_internal_zzcgi.f17769k) || com_google_android_gms_internal_zzcgi.f17769k.equals(b.m5633e()))) {
                b.m5632d(com_google_android_gms_internal_zzcgi.f17769k);
                obj = 1;
            }
            if (!(com_google_android_gms_internal_zzcgi.f17763e == 0 || com_google_android_gms_internal_zzcgi.f17763e == b.m5647k())) {
                b.m5631d(com_google_android_gms_internal_zzcgi.f17763e);
                obj = 1;
            }
            if (!(TextUtils.isEmpty(com_google_android_gms_internal_zzcgi.f17761c) || com_google_android_gms_internal_zzcgi.f17761c.equals(b.m5642h()))) {
                b.m5635e(com_google_android_gms_internal_zzcgi.f17761c);
                obj = 1;
            }
            if (com_google_android_gms_internal_zzcgi.f17768j != b.m5644i()) {
                b.m5628c(com_google_android_gms_internal_zzcgi.f17768j);
                obj = 1;
            }
            if (!(com_google_android_gms_internal_zzcgi.f17762d == null || com_google_android_gms_internal_zzcgi.f17762d.equals(b.m5646j()))) {
                b.m5638f(com_google_android_gms_internal_zzcgi.f17762d);
                obj = 1;
            }
            if (com_google_android_gms_internal_zzcgi.f17764f != b.m5648l()) {
                b.m5634e(com_google_android_gms_internal_zzcgi.f17764f);
                obj = 1;
            }
            if (com_google_android_gms_internal_zzcgi.f17766h != b.m5649m()) {
                b.m5622a(com_google_android_gms_internal_zzcgi.f17766h);
                obj = 1;
            }
            if (!(TextUtils.isEmpty(com_google_android_gms_internal_zzcgi.f17765g) || com_google_android_gms_internal_zzcgi.f17765g.equals(b.m5654r()))) {
                b.m5641g(com_google_android_gms_internal_zzcgi.f17765g);
                obj = 1;
            }
            if (com_google_android_gms_internal_zzcgi.f17770l != b.m5655s()) {
                b.m5645i(com_google_android_gms_internal_zzcgi.f17770l);
                obj = 1;
            }
            if (com_google_android_gms_internal_zzcgi.f17773o != b.m5656t()) {
                b.m5626b(com_google_android_gms_internal_zzcgi.f17773o);
                obj = 1;
            }
            if (obj != null) {
                m5760k().m18000a(b);
            }
        } else {
            b.m5629c(b2);
            b.m5621a(m5765p().m18083y());
        }
        obj = 1;
        b.m5625b(com_google_android_gms_internal_zzcgi.f17760b);
        obj = 1;
        b.m5632d(com_google_android_gms_internal_zzcgi.f17769k);
        obj = 1;
        b.m5631d(com_google_android_gms_internal_zzcgi.f17763e);
        obj = 1;
        b.m5635e(com_google_android_gms_internal_zzcgi.f17761c);
        obj = 1;
        if (com_google_android_gms_internal_zzcgi.f17768j != b.m5644i()) {
            b.m5628c(com_google_android_gms_internal_zzcgi.f17768j);
            obj = 1;
        }
        b.m5638f(com_google_android_gms_internal_zzcgi.f17762d);
        obj = 1;
        if (com_google_android_gms_internal_zzcgi.f17764f != b.m5648l()) {
            b.m5634e(com_google_android_gms_internal_zzcgi.f17764f);
            obj = 1;
        }
        if (com_google_android_gms_internal_zzcgi.f17766h != b.m5649m()) {
            b.m5622a(com_google_android_gms_internal_zzcgi.f17766h);
            obj = 1;
        }
        b.m5641g(com_google_android_gms_internal_zzcgi.f17765g);
        obj = 1;
        if (com_google_android_gms_internal_zzcgi.f17770l != b.m5655s()) {
            b.m5645i(com_google_android_gms_internal_zzcgi.f17770l);
            obj = 1;
        }
        if (com_google_android_gms_internal_zzcgi.f17773o != b.m5656t()) {
            b.m5626b(com_google_android_gms_internal_zzcgi.f17773o);
            obj = 1;
        }
        if (obj != null) {
            m5760k().m18000a(b);
        }
    }

    public final zzchx m5753d() {
        m5723a(this.f6986n);
        return this.f6986n;
    }

    public final zzchm m5754e() {
        m5724a(this.f6976c);
        return this.f6976c;
    }

    public final zzcih m5755f() {
        m5724a(this.f6977d);
        return this.f6977d;
    }

    public final zzcig m5756g() {
        m5724a(this.f6987o);
        return this.f6987o;
    }

    public final zzcjn m5757h() {
        m5724a(this.f6995w);
        return this.f6995w;
    }

    public final zzclq m5758i() {
        m5723a(this.f6988p);
        return this.f6988p;
    }

    public final zzchk m5759j() {
        m5723a(this.f6989q);
        return this.f6989q;
    }

    public final zzcgo m5760k() {
        m5724a(this.f6990r);
        return this.f6990r;
    }

    public final zzchq m5761l() {
        m5724a(this.f6991s);
        return this.f6991s;
    }

    public final zzckc m5762m() {
        m5724a(this.f6992t);
        return this.f6992t;
    }

    public final zzckg m5763n() {
        m5724a(this.f6993u);
        return this.f6993u;
    }

    public final zzcgu m5764o() {
        m5724a(this.f6994v);
        return this.f6994v;
    }

    public final zzchh m5765p() {
        m5724a(this.f6996x);
        return this.f6996x;
    }

    public final zzcgk m5766q() {
        m5724a(this.f6959A);
        return this.f6959A;
    }

    public final zzcgd m5767r() {
        m5723a(this.f6960B);
        return this.f6960B;
    }

    public final boolean m5768s() {
        m5755f().mo1811c();
        m5736a();
        boolean z = false;
        if (this.f6975b.m13516x()) {
            return false;
        }
        Boolean b = this.f6975b.m13492b("firebase_analytics_collection_enabled");
        if (b != null) {
            z = b.booleanValue();
        } else if (!zzbz.m4737b()) {
            z = true;
        }
        return m5753d().m18221c(z);
    }

    final void m5771w() {
        this.f6968J++;
    }

    private zzcim(zzcjm com_google_android_gms_internal_zzcjm) {
        zzbq.m4808a((Object) com_google_android_gms_internal_zzcjm);
        this.f6974a = com_google_android_gms_internal_zzcjm.f7057a;
        this.f6969K = -1;
        this.f6982i = zzh.m13111d();
        this.f6985l = this.f6982i.mo1632a();
        this.f6975b = new zzcgn(this);
        com_google_android_gms_internal_zzcjm = new zzchx(this);
        com_google_android_gms_internal_zzcjm.m13546M();
        this.f6986n = com_google_android_gms_internal_zzcjm;
        com_google_android_gms_internal_zzcjm = new zzchm(this);
        com_google_android_gms_internal_zzcjm.m13546M();
        this.f6976c = com_google_android_gms_internal_zzcjm;
        com_google_android_gms_internal_zzcjm = new zzclq(this);
        com_google_android_gms_internal_zzcjm.m13546M();
        this.f6988p = com_google_android_gms_internal_zzcjm;
        com_google_android_gms_internal_zzcjm = new zzchk(this);
        com_google_android_gms_internal_zzcjm.m13546M();
        this.f6989q = com_google_android_gms_internal_zzcjm;
        com_google_android_gms_internal_zzcjm = new zzcgu(this);
        com_google_android_gms_internal_zzcjm.m13546M();
        this.f6994v = com_google_android_gms_internal_zzcjm;
        com_google_android_gms_internal_zzcjm = new zzchh(this);
        com_google_android_gms_internal_zzcjm.m13546M();
        this.f6996x = com_google_android_gms_internal_zzcjm;
        com_google_android_gms_internal_zzcjm = new zzcgo(this);
        com_google_android_gms_internal_zzcjm.m13546M();
        this.f6990r = com_google_android_gms_internal_zzcjm;
        com_google_android_gms_internal_zzcjm = new zzchi(this);
        com_google_android_gms_internal_zzcjm.m13546M();
        this.f6981h = com_google_android_gms_internal_zzcjm;
        com_google_android_gms_internal_zzcjm = new zzcgk(this);
        com_google_android_gms_internal_zzcjm.m13546M();
        this.f6959A = com_google_android_gms_internal_zzcjm;
        this.f6960B = new zzcgd(this);
        com_google_android_gms_internal_zzcjm = new zzchq(this);
        com_google_android_gms_internal_zzcjm.m13546M();
        this.f6991s = com_google_android_gms_internal_zzcjm;
        com_google_android_gms_internal_zzcjm = new zzckc(this);
        com_google_android_gms_internal_zzcjm.m13546M();
        this.f6992t = com_google_android_gms_internal_zzcjm;
        com_google_android_gms_internal_zzcjm = new zzckg(this);
        com_google_android_gms_internal_zzcjm.m13546M();
        this.f6993u = com_google_android_gms_internal_zzcjm;
        com_google_android_gms_internal_zzcjm = new zzcjn(this);
        com_google_android_gms_internal_zzcjm.m13546M();
        this.f6995w = com_google_android_gms_internal_zzcjm;
        com_google_android_gms_internal_zzcjm = new zzcll(this);
        com_google_android_gms_internal_zzcjm.m13546M();
        this.f6998z = com_google_android_gms_internal_zzcjm;
        this.f6997y = new zzchv(this);
        this.f6979f = new AppMeasurement(this);
        this.f6980g = new FirebaseAnalytics(this);
        com_google_android_gms_internal_zzcjm = new zzclf(this);
        com_google_android_gms_internal_zzcjm.m13546M();
        this.f6978e = com_google_android_gms_internal_zzcjm;
        com_google_android_gms_internal_zzcjm = new zzcig(this);
        com_google_android_gms_internal_zzcjm.m13546M();
        this.f6987o = com_google_android_gms_internal_zzcjm;
        com_google_android_gms_internal_zzcjm = new zzcih(this);
        com_google_android_gms_internal_zzcjm.m13546M();
        this.f6977d = com_google_android_gms_internal_zzcjm;
        if ((this.f6974a.getApplicationContext() instanceof Application) != null) {
            com_google_android_gms_internal_zzcjm = m5757h();
            if (com_google_android_gms_internal_zzcjm.mo1820l().getApplicationContext() instanceof Application) {
                Application application = (Application) com_google_android_gms_internal_zzcjm.mo1820l().getApplicationContext();
                if (com_google_android_gms_internal_zzcjm.f17872a == null) {
                    com_google_android_gms_internal_zzcjm.f17872a = new zzckb(com_google_android_gms_internal_zzcjm);
                }
                application.unregisterActivityLifecycleCallbacks(com_google_android_gms_internal_zzcjm.f17872a);
                application.registerActivityLifecycleCallbacks(com_google_android_gms_internal_zzcjm.f17872a);
                com_google_android_gms_internal_zzcjm.mo1828t().f17822g.m5693a("Registered activity lifecycle callback");
            }
        } else {
            m5754e().f17818c.m5693a("Application context is not an Application");
        }
        this.f6977d.m18271a(new zzcin(this));
    }

    protected final void m5751c() {
        m5755f().mo1811c();
        m5760k().m17989C();
        if (m5753d().f17830c.m5702a() == 0) {
            m5753d().f17830c.m5703a(this.f6982i.mo1632a());
        }
        if (Long.valueOf(m5753d().f17835h.m5702a()).longValue() == 0) {
            m5754e().f17822g.m5694a("Persisting first open", Long.valueOf(this.f6985l));
            m5753d().f17835h.m5703a(this.f6985l);
        }
        if (m5749b()) {
            if (!TextUtils.isEmpty(m5765p().m18056A())) {
                String y = m5753d().m18223y();
                if (y == null) {
                    m5753d().m18220c(m5765p().m18056A());
                } else if (!y.equals(m5765p().m18056A())) {
                    m5754e().f17820e.m5693a("Rechecking which service to use due to a GMP App Id change");
                    m5753d().m18214B();
                    this.f6993u.m18409D();
                    this.f6993u.m18408C();
                    m5753d().m18220c(m5765p().m18056A());
                    m5753d().f17835h.m5703a(this.f6985l);
                    m5753d().f17836i.m5706a(null);
                }
            }
            zzcjn h = m5757h();
            zzcic com_google_android_gms_internal_zzcic = m5753d().f17836i;
            if (!com_google_android_gms_internal_zzcic.f6938b) {
                com_google_android_gms_internal_zzcic.f6938b = true;
                com_google_android_gms_internal_zzcic.f6939c = com_google_android_gms_internal_zzcic.f6940d.m18211D().getString(com_google_android_gms_internal_zzcic.f6937a, null);
            }
            h.m18331a(com_google_android_gms_internal_zzcic.f6939c);
            if (!TextUtils.isEmpty(m5765p().m18056A())) {
                zzcjk h2 = m5757h();
                h2.mo1811c();
                h2.m13545L();
                if (h2.s.m5749b()) {
                    h2.mo1817i().m18407B();
                    String C = h2.mo1829u().m18215C();
                    if (!TextUtils.isEmpty(C)) {
                        h2.mo1816h().m13545L();
                        if (!C.equals(VERSION.RELEASE)) {
                            Bundle bundle = new Bundle();
                            bundle.putString("_po", C);
                            h2.m18332a("auto", "_ou", bundle);
                        }
                    }
                }
                m5763n().m18417a(new AtomicReference());
            }
        } else if (m5768s()) {
            if (!m5758i().m18563g("android.permission.INTERNET")) {
                m5754e().f17816a.m5693a("App is missing INTERNET permission");
            }
            if (!m5758i().m18563g("android.permission.ACCESS_NETWORK_STATE")) {
                m5754e().f17816a.m5693a("App is missing ACCESS_NETWORK_STATE permission");
            }
            if (!zzbhf.m5574a(this.f6974a).m5570a()) {
                if (!zzcid.m5707a(this.f6974a)) {
                    m5754e().f17816a.m5693a("AppMeasurementReceiver not registered/enabled");
                }
                if (!zzcla.m5795a(this.f6974a)) {
                    m5754e().f17816a.m5693a("AppMeasurementService not registered/enabled");
                }
            }
            m5754e().f17816a.m5693a("Uploading is not possible. App measurement disabled");
        }
        m5770v();
    }

    final void m5738a(zzcgi com_google_android_gms_internal_zzcgi) {
        m5760k().m18008b(com_google_android_gms_internal_zzcgi.f17759a);
        zzcjk k = m5760k();
        String str = com_google_android_gms_internal_zzcgi.f17759a;
        zzbq.m4810a(str);
        k.mo1811c();
        k.m13545L();
        try {
            SQLiteDatabase A = k.m17987A();
            String[] strArr = new String[]{str};
            int delete = (((((((0 + A.delete("apps", "app_id=?", strArr)) + A.delete("events", "app_id=?", strArr)) + A.delete(State.KEY_USER_ATTRIBUTES, "app_id=?", strArr)) + A.delete("conditional_properties", "app_id=?", strArr)) + A.delete("raw_events", "app_id=?", strArr)) + A.delete("raw_events_metadata", "app_id=?", strArr)) + A.delete("queue", "app_id=?", strArr)) + A.delete("audience_filter_values", "app_id=?", strArr);
            if (delete > 0) {
                k.mo1828t().f17822g.m5695a("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            k.mo1828t().f17816a.m5695a("Error resetting analytics data. appId, error", zzchm.m18154a(str), e);
        }
        m5745b(m5719a(this.f6974a, com_google_android_gms_internal_zzcgi.f17759a, com_google_android_gms_internal_zzcgi.f17760b, com_google_android_gms_internal_zzcgi.f17766h, com_google_android_gms_internal_zzcgi.f17773o));
    }

    private final com.google.android.gms.internal.zzcgi m5719a(android.content.Context r23, java.lang.String r24, java.lang.String r25, boolean r26, boolean r27) {
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
        r22 = this;
        r1 = r24;
        r0 = "Unknown";
        r2 = "Unknown";
        r3 = "Unknown";
        r4 = r23.getPackageManager();
        r5 = 0;
        if (r4 != 0) goto L_0x001b;
    L_0x000f:
        r0 = r22.m5754e();
        r0 = r0.f17816a;
        r1 = "PackageManager is null, can not log app install information";
        r0.m5693a(r1);
        return r5;
    L_0x001b:
        r4 = r4.getInstallerPackageName(r1);	 Catch:{ IllegalArgumentException -> 0x0021 }
        r0 = r4;
        goto L_0x0030;
    L_0x0021:
        r4 = r22.m5754e();
        r4 = r4.f17816a;
        r6 = "Error retrieving installer package name. appId";
        r7 = com.google.android.gms.internal.zzchm.m18154a(r24);
        r4.m5694a(r6, r7);
    L_0x0030:
        if (r0 != 0) goto L_0x0036;
    L_0x0032:
        r0 = "manual_install";
    L_0x0034:
        r6 = r0;
        goto L_0x0041;
    L_0x0036:
        r4 = "com.android.vending";
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x0034;
    L_0x003e:
        r0 = "";
        goto L_0x0034;
    L_0x0041:
        r0 = com.google.android.gms.internal.zzbhf.m5574a(r23);	 Catch:{ NameNotFoundException -> 0x008c }
        r4 = 0;	 Catch:{ NameNotFoundException -> 0x008c }
        r0 = r0.m5572b(r1, r4);	 Catch:{ NameNotFoundException -> 0x008c }
        if (r0 == 0) goto L_0x0064;	 Catch:{ NameNotFoundException -> 0x008c }
    L_0x004c:
        r2 = com.google.android.gms.internal.zzbhf.m5574a(r23);	 Catch:{ NameNotFoundException -> 0x008c }
        r2 = r2.m5573b(r1);	 Catch:{ NameNotFoundException -> 0x008c }
        r4 = android.text.TextUtils.isEmpty(r2);	 Catch:{ NameNotFoundException -> 0x008c }
        if (r4 != 0) goto L_0x005f;	 Catch:{ NameNotFoundException -> 0x008c }
    L_0x005a:
        r2 = r2.toString();	 Catch:{ NameNotFoundException -> 0x008c }
        r3 = r2;	 Catch:{ NameNotFoundException -> 0x008c }
    L_0x005f:
        r2 = r0.versionName;	 Catch:{ NameNotFoundException -> 0x008c }
        r0 = r0.versionCode;	 Catch:{ NameNotFoundException -> 0x008c }
        goto L_0x0066;
    L_0x0064:
        r0 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
    L_0x0066:
        r3 = r2;
        r21 = new com.google.android.gms.internal.zzcgi;
        r4 = (long) r0;
        r7 = 11910; // 0x2e86 float:1.669E-41 double:5.8843E-320;
        r0 = r22.m5758i();
        r2 = r23;
        r9 = r0.m18551b(r2, r1);
        r11 = 0;
        r13 = 0;
        r14 = "";
        r15 = 0;
        r17 = 0;
        r19 = 0;
        r0 = r21;
        r2 = r25;
        r12 = r26;
        r20 = r27;
        r0.<init>(r1, r2, r3, r4, r6, r7, r9, r11, r12, r13, r14, r15, r17, r19, r20);
        return r21;
    L_0x008c:
        r0 = r22.m5754e();
        r0 = r0.f17816a;
        r2 = "Error retrieving newly installed package info. appId, appName";
        r1 = com.google.android.gms.internal.zzchm.m18154a(r24);
        r0.m5695a(r2, r1, r3);
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcim.a(android.content.Context, java.lang.String, java.lang.String, boolean, boolean):com.google.android.gms.internal.zzcgi");
    }

    private final boolean m5713A() {
        m5755f().mo1811c();
        try {
            this.f6966H = new RandomAccessFile(new File(this.f6974a.getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
            this.f6965G = this.f6966H.tryLock();
            if (this.f6965G != null) {
                m5754e().f17822g.m5693a("Storage concurrent access okay");
                return true;
            }
            m5754e().f17816a.m5693a("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e) {
            m5754e().f17816a.m5694a("Failed to acquire storage lock", e);
        } catch (IOException e2) {
            m5754e().f17816a.m5694a("Failed to access storage lock file", e2);
        }
    }

    private final int m5718a(FileChannel fileChannel) {
        m5755f().mo1811c();
        if (fileChannel != null) {
            if (fileChannel.isOpen()) {
                ByteBuffer allocate = ByteBuffer.allocate(4);
                try {
                    fileChannel.position(0);
                    fileChannel = fileChannel.read(allocate);
                    if (fileChannel != 4) {
                        if (fileChannel != -1) {
                            m5754e().f17818c.m5694a("Unexpected data length. Bytes read", Integer.valueOf(fileChannel));
                        }
                        return 0;
                    }
                    allocate.flip();
                    fileChannel = allocate.getInt();
                    return fileChannel;
                } catch (FileChannel fileChannel2) {
                    m5754e().f17816a.m5694a("Failed to read from channel", fileChannel2);
                    fileChannel2 = null;
                }
            }
        }
        m5754e().f17816a.m5693a("Bad chanel to read from");
        return 0;
    }

    private final boolean m5725a(int i, FileChannel fileChannel) {
        m5755f().mo1811c();
        if (fileChannel != null) {
            if (fileChannel.isOpen()) {
                ByteBuffer allocate = ByteBuffer.allocate(4);
                allocate.putInt(i);
                allocate.flip();
                try {
                    fileChannel.truncate(0);
                    fileChannel.write(allocate);
                    fileChannel.force(true);
                    if (fileChannel.size() != 4) {
                        m5754e().f17816a.m5694a("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
                    }
                    return true;
                } catch (int i2) {
                    m5754e().f17816a.m5694a("Failed to write to channel", i2);
                    return false;
                }
            }
        }
        m5754e().f17816a.m5693a("Bad chanel to read from");
        return false;
    }

    private final com.google.android.gms.internal.zzcgi m5730b(java.lang.String r24) {
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
        r23 = this;
        r1 = r24;
        r0 = r23.m5760k();
        r0 = r0.m18008b(r1);
        r2 = 0;
        if (r0 == 0) goto L_0x0085;
    L_0x000d:
        r3 = r0.m5642h();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 == 0) goto L_0x0018;
    L_0x0017:
        goto L_0x0085;
    L_0x0018:
        r15 = r23;
        r3 = r15.f6974a;	 Catch:{ NameNotFoundException -> 0x0047 }
        r3 = com.google.android.gms.internal.zzbhf.m5574a(r3);	 Catch:{ NameNotFoundException -> 0x0047 }
        r4 = 0;	 Catch:{ NameNotFoundException -> 0x0047 }
        r3 = r3.m5572b(r1, r4);	 Catch:{ NameNotFoundException -> 0x0047 }
        r3 = r3.versionName;	 Catch:{ NameNotFoundException -> 0x0047 }
        r4 = r0.m5642h();	 Catch:{ NameNotFoundException -> 0x0047 }
        if (r4 == 0) goto L_0x0047;	 Catch:{ NameNotFoundException -> 0x0047 }
    L_0x002d:
        r4 = r0.m5642h();	 Catch:{ NameNotFoundException -> 0x0047 }
        r3 = r4.equals(r3);	 Catch:{ NameNotFoundException -> 0x0047 }
        if (r3 != 0) goto L_0x0047;	 Catch:{ NameNotFoundException -> 0x0047 }
    L_0x0037:
        r3 = r23.m5754e();	 Catch:{ NameNotFoundException -> 0x0047 }
        r3 = r3.f17818c;	 Catch:{ NameNotFoundException -> 0x0047 }
        r4 = "App version does not match; dropping. appId";	 Catch:{ NameNotFoundException -> 0x0047 }
        r5 = com.google.android.gms.internal.zzchm.m18154a(r24);	 Catch:{ NameNotFoundException -> 0x0047 }
        r3.m5694a(r4, r5);	 Catch:{ NameNotFoundException -> 0x0047 }
        return r2;
    L_0x0047:
        r21 = new com.google.android.gms.internal.zzcgi;
        r2 = r0.m5627c();
        r3 = r0.m5642h();
        r4 = r0.m5644i();
        r6 = r0.m5646j();
        r7 = r0.m5647k();
        r9 = r0.m5648l();
        r11 = 0;
        r12 = r0.m5649m();
        r13 = 0;
        r14 = r0.m5633e();
        r16 = r0.m5655s();
        r18 = 0;
        r20 = 0;
        r22 = r0.m5656t();
        r0 = r21;
        r15 = r16;
        r17 = r18;
        r19 = r20;
        r20 = r22;
        r0.<init>(r1, r2, r3, r4, r6, r7, r9, r11, r12, r13, r14, r15, r17, r19, r20);
        return r21;
    L_0x0085:
        r0 = r23.m5754e();
        r0 = r0.f17821f;
        r3 = "No app data available; dropping";
        r0.m5694a(r3, r1);
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcim.b(java.lang.String):com.google.android.gms.internal.zzcgi");
    }

    final void m5742a(com.google.android.gms.internal.zzcha r26, java.lang.String r27) {
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
        r25 = this;
        r0 = r25;
        r1 = r26;
        r3 = r27;
        r2 = r25.m5760k();
        r2 = r2.m18008b(r3);
        if (r2 == 0) goto L_0x00ab;
    L_0x0010:
        r4 = r2.m5642h();
        r4 = android.text.TextUtils.isEmpty(r4);
        if (r4 == 0) goto L_0x001c;
    L_0x001a:
        goto L_0x00ab;
    L_0x001c:
        r4 = r0.f6974a;	 Catch:{ NameNotFoundException -> 0x0049 }
        r4 = com.google.android.gms.internal.zzbhf.m5574a(r4);	 Catch:{ NameNotFoundException -> 0x0049 }
        r5 = 0;	 Catch:{ NameNotFoundException -> 0x0049 }
        r4 = r4.m5572b(r3, r5);	 Catch:{ NameNotFoundException -> 0x0049 }
        r4 = r4.versionName;	 Catch:{ NameNotFoundException -> 0x0049 }
        r5 = r2.m5642h();	 Catch:{ NameNotFoundException -> 0x0049 }
        if (r5 == 0) goto L_0x0062;	 Catch:{ NameNotFoundException -> 0x0049 }
    L_0x002f:
        r5 = r2.m5642h();	 Catch:{ NameNotFoundException -> 0x0049 }
        r4 = r5.equals(r4);	 Catch:{ NameNotFoundException -> 0x0049 }
        if (r4 != 0) goto L_0x0062;	 Catch:{ NameNotFoundException -> 0x0049 }
    L_0x0039:
        r4 = r25.m5754e();	 Catch:{ NameNotFoundException -> 0x0049 }
        r4 = r4.f17818c;	 Catch:{ NameNotFoundException -> 0x0049 }
        r5 = "App version does not match; dropping event. appId";	 Catch:{ NameNotFoundException -> 0x0049 }
        r6 = com.google.android.gms.internal.zzchm.m18154a(r27);	 Catch:{ NameNotFoundException -> 0x0049 }
        r4.m5694a(r5, r6);	 Catch:{ NameNotFoundException -> 0x0049 }
        return;
    L_0x0049:
        r4 = "_ui";
        r5 = r1.f17798a;
        r4 = r4.equals(r5);
        if (r4 != 0) goto L_0x0062;
    L_0x0053:
        r4 = r25.m5754e();
        r4 = r4.f17818c;
        r5 = "Could not find package. appId";
        r6 = com.google.android.gms.internal.zzchm.m18154a(r27);
        r4.m5694a(r5, r6);
    L_0x0062:
        r15 = new com.google.android.gms.internal.zzcgi;
        r4 = r2.m5627c();
        r5 = r2.m5642h();
        r6 = r2.m5644i();
        r8 = r2.m5646j();
        r9 = r2.m5647k();
        r11 = r2.m5648l();
        r13 = 0;
        r14 = r2.m5649m();
        r16 = 0;
        r17 = r2.m5633e();
        r18 = r2.m5655s();
        r20 = 0;
        r22 = 0;
        r23 = r2.m5656t();
        r2 = r15;
        r24 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r19 = r20;
        r21 = r22;
        r22 = r23;
        r2.<init>(r3, r4, r5, r6, r8, r9, r11, r13, r14, r15, r16, r17, r19, r21, r22);
        r2 = r24;
        r0.m5741a(r1, r2);
        return;
    L_0x00ab:
        r1 = r25.m5754e();
        r1 = r1.f17821f;
        r2 = "No app data available; dropping event";
        r1.m5694a(r2, r3);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcim.a(com.google.android.gms.internal.zzcha, java.lang.String):void");
    }

    final void m5741a(zzcha com_google_android_gms_internal_zzcha, zzcgi com_google_android_gms_internal_zzcgi) {
        zzcim com_google_android_gms_internal_zzcim = this;
        zzcha com_google_android_gms_internal_zzcha2 = com_google_android_gms_internal_zzcha;
        zzcgi com_google_android_gms_internal_zzcgi2 = com_google_android_gms_internal_zzcgi;
        zzbq.m4808a((Object) com_google_android_gms_internal_zzcgi);
        zzbq.m4810a(com_google_android_gms_internal_zzcgi2.f17759a);
        m5755f().mo1811c();
        m5736a();
        String str = com_google_android_gms_internal_zzcgi2.f17759a;
        long j = com_google_android_gms_internal_zzcha2.f17801d;
        m5758i();
        if (!zzclq.m18512a(com_google_android_gms_internal_zzcha, com_google_android_gms_internal_zzcgi)) {
            return;
        }
        if (com_google_android_gms_internal_zzcgi2.f17766h) {
            m5760k().m18022x();
            try {
                List emptyList;
                List emptyList2;
                zzcjk k = m5760k();
                zzbq.m4810a(str);
                k.mo1811c();
                k.m13545L();
                int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                if (i < 0) {
                    k.mo1828t().f17818c.m5695a("Invalid time querying timed out conditional properties", zzchm.m18154a(str), Long.valueOf(j));
                    emptyList = Collections.emptyList();
                } else {
                    emptyList = k.m18010b("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j)});
                }
                for (zzcgl com_google_android_gms_internal_zzcgl : r5) {
                    if (com_google_android_gms_internal_zzcgl != null) {
                        m5754e().f17821f.m5696a("User property timed out", com_google_android_gms_internal_zzcgl.f17774a, m5759j().m18132c(com_google_android_gms_internal_zzcgl.f17776c.f17900a), com_google_android_gms_internal_zzcgl.f17776c.m18501a());
                        if (com_google_android_gms_internal_zzcgl.f17780g != null) {
                            m5731b(new zzcha(com_google_android_gms_internal_zzcgl.f17780g, j), com_google_android_gms_internal_zzcgi2);
                        }
                        m5760k().m18016e(str, com_google_android_gms_internal_zzcgl.f17776c.f17900a);
                    }
                }
                k = m5760k();
                zzbq.m4810a(str);
                k.mo1811c();
                k.m13545L();
                if (i < 0) {
                    k.mo1828t().f17818c.m5695a("Invalid time querying expired conditional properties", zzchm.m18154a(str), Long.valueOf(j));
                    emptyList = Collections.emptyList();
                } else {
                    emptyList = k.m18010b("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j)});
                }
                List arrayList = new ArrayList(r5.size());
                for (zzcgl com_google_android_gms_internal_zzcgl2 : r5) {
                    if (com_google_android_gms_internal_zzcgl2 != null) {
                        m5754e().f17821f.m5696a("User property expired", com_google_android_gms_internal_zzcgl2.f17774a, m5759j().m18132c(com_google_android_gms_internal_zzcgl2.f17776c.f17900a), com_google_android_gms_internal_zzcgl2.f17776c.m18501a());
                        m5760k().m18011b(str, com_google_android_gms_internal_zzcgl2.f17776c.f17900a);
                        if (com_google_android_gms_internal_zzcgl2.f17784k != null) {
                            arrayList.add(com_google_android_gms_internal_zzcgl2.f17784k);
                        }
                        m5760k().m18016e(str, com_google_android_gms_internal_zzcgl2.f17776c.f17900a);
                    }
                }
                ArrayList arrayList2 = (ArrayList) arrayList;
                int size = arrayList2.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList2.get(i2);
                    i2++;
                    m5731b(new zzcha((zzcha) obj, j), com_google_android_gms_internal_zzcgi2);
                }
                k = m5760k();
                String str2 = com_google_android_gms_internal_zzcha2.f17798a;
                zzbq.m4810a(str);
                zzbq.m4810a(str2);
                k.mo1811c();
                k.m13545L();
                if (i < 0) {
                    k.mo1828t().f17818c.m5696a("Invalid time querying triggered conditional properties", zzchm.m18154a(str), k.mo1823o().m18128a(str2), Long.valueOf(j));
                    emptyList2 = Collections.emptyList();
                } else {
                    emptyList2 = k.m18010b("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j)});
                }
                List arrayList3 = new ArrayList(emptyList2.size());
                Iterator it = emptyList2.iterator();
                while (it.hasNext()) {
                    zzcgl com_google_android_gms_internal_zzcgl3 = (zzcgl) it.next();
                    if (com_google_android_gms_internal_zzcgl3 != null) {
                        zzcln com_google_android_gms_internal_zzcln = com_google_android_gms_internal_zzcgl3.f17776c;
                        zzclp com_google_android_gms_internal_zzclp = r5;
                        Iterator it2 = it;
                        zzcgl com_google_android_gms_internal_zzcgl4 = com_google_android_gms_internal_zzcgl3;
                        zzclp com_google_android_gms_internal_zzclp2 = new zzclp(com_google_android_gms_internal_zzcgl3.f17774a, com_google_android_gms_internal_zzcgl3.f17775b, com_google_android_gms_internal_zzcln.f17900a, j, com_google_android_gms_internal_zzcln.m18501a());
                        if (m5760k().m18006a(com_google_android_gms_internal_zzclp)) {
                            m5754e().f17821f.m5696a("User property triggered", com_google_android_gms_internal_zzcgl4.f17774a, m5759j().m18132c(com_google_android_gms_internal_zzclp.f7177c), com_google_android_gms_internal_zzclp.f7179e);
                        } else {
                            m5754e().f17816a.m5696a("Too many active user properties, ignoring", zzchm.m18154a(com_google_android_gms_internal_zzcgl4.f17774a), m5759j().m18132c(com_google_android_gms_internal_zzclp.f7177c), com_google_android_gms_internal_zzclp.f7179e);
                        }
                        if (com_google_android_gms_internal_zzcgl4.f17782i != null) {
                            arrayList3.add(com_google_android_gms_internal_zzcgl4.f17782i);
                        }
                        com_google_android_gms_internal_zzcgl4.f17776c = new zzcln(com_google_android_gms_internal_zzclp);
                        com_google_android_gms_internal_zzcgl4.f17778e = true;
                        m5760k().m18004a(com_google_android_gms_internal_zzcgl4);
                        it = it2;
                    }
                }
                m5731b(com_google_android_gms_internal_zzcha, com_google_android_gms_internal_zzcgi);
                ArrayList arrayList4 = (ArrayList) arrayList3;
                int size2 = arrayList4.size();
                int i3 = 0;
                while (i3 < size2) {
                    Object obj2 = arrayList4.get(i3);
                    i3++;
                    m5731b(new zzcha((zzcha) obj2, j), com_google_android_gms_internal_zzcgi2);
                }
                m5760k().m18023y();
                m5760k().m18024z();
            } catch (Throwable th) {
                Throwable th2 = th;
                m5760k().m18024z();
            }
        } else {
            m5752c(com_google_android_gms_internal_zzcgi2);
        }
    }

    private final void m5731b(zzcha com_google_android_gms_internal_zzcha, zzcgi com_google_android_gms_internal_zzcgi) {
        zzcim com_google_android_gms_internal_zzcim = this;
        zzcha com_google_android_gms_internal_zzcha2 = com_google_android_gms_internal_zzcha;
        zzcgi com_google_android_gms_internal_zzcgi2 = com_google_android_gms_internal_zzcgi;
        zzbq.m4808a((Object) com_google_android_gms_internal_zzcgi);
        zzbq.m4810a(com_google_android_gms_internal_zzcgi2.f17759a);
        long nanoTime = System.nanoTime();
        m5755f().mo1811c();
        m5736a();
        String str = com_google_android_gms_internal_zzcgi2.f17759a;
        m5758i();
        if (!zzclq.m18512a(com_google_android_gms_internal_zzcha, com_google_android_gms_internal_zzcgi)) {
            return;
        }
        if (!com_google_android_gms_internal_zzcgi2.f17766h) {
            m5752c(com_google_android_gms_internal_zzcgi2);
        } else if (m5756g().m18234b(str, com_google_android_gms_internal_zzcha2.f17798a)) {
            int i;
            zzcgh b;
            m5754e().f17818c.m5695a("Dropping blacklisted event. appId", zzchm.m18154a(str), m5759j().m18128a(com_google_android_gms_internal_zzcha2.f17798a));
            if (!m5758i().m18569k(str)) {
                if (!m5758i().m18571l(str)) {
                    i = 0;
                    if (i == 0 && !"_err".equals(com_google_android_gms_internal_zzcha2.f17798a)) {
                        m5758i().m18553b(11, "_ev", com_google_android_gms_internal_zzcha2.f17798a, 0);
                    }
                    if (i != 0) {
                        b = m5760k().m18008b(str);
                        if (b != null) {
                            if (Math.abs(com_google_android_gms_internal_zzcim.f6982i.mo1632a() - Math.max(b.m5652p(), b.m5651o())) > ((Long) zzchc.f6853B.f6893a).longValue()) {
                                m5754e().f17821f.m5693a("Fetching config for blacklisted app");
                                m5721a(b);
                            }
                        }
                    }
                }
            }
            i = 1;
            m5758i().m18553b(11, "_ev", com_google_android_gms_internal_zzcha2.f17798a, 0);
            if (i != 0) {
                b = m5760k().m18008b(str);
                if (b != null) {
                    if (Math.abs(com_google_android_gms_internal_zzcim.f6982i.mo1632a() - Math.max(b.m5652p(), b.m5651o())) > ((Long) zzchc.f6853B.f6893a).longValue()) {
                        m5754e().f17821f.m5693a("Fetching config for blacklisted app");
                        m5721a(b);
                    }
                }
            }
        } else {
            if (m5754e().m18161a(2)) {
                m5754e().f17822g.m5694a("Logging event", m5759j().m18124a(com_google_android_gms_internal_zzcha2));
            }
            m5760k().m18022x();
            m5752c(com_google_android_gms_internal_zzcgi2);
            if (("_iap".equals(com_google_android_gms_internal_zzcha2.f17798a) || "ecommerce_purchase".equals(com_google_android_gms_internal_zzcha2.f17798a)) && !m5728a(str, com_google_android_gms_internal_zzcha2)) {
                m5760k().m18023y();
                m5760k().m18024z();
                return;
            }
            zzcme com_google_android_gms_internal_zzcme;
            try {
                boolean a = zzclq.m18513a(com_google_android_gms_internal_zzcha2.f17798a);
                boolean equals = "_err".equals(com_google_android_gms_internal_zzcha2.f17798a);
                zzcgp a2 = m5760k().m17994a(m5714B(), str, true, a, false, equals, false);
                long intValue = a2.f6824b - ((long) ((Integer) zzchc.f6879m.f6893a).intValue());
                if (intValue > 0) {
                    if (intValue % 1000 == 1) {
                        m5754e().f17816a.m5695a("Data loss. Too many events logged. appId, count", zzchm.m18154a(str), Long.valueOf(a2.f6824b));
                    }
                    m5760k().m18023y();
                    m5760k().m18024z();
                    return;
                }
                zzcgo k;
                boolean z;
                zzcgw a3;
                if (a) {
                    intValue = a2.f6823a - ((long) ((Integer) zzchc.f6881o.f6893a).intValue());
                    if (intValue > 0) {
                        if (intValue % 1000 == 1) {
                            m5754e().f17816a.m5695a("Data loss. Too many public events logged. appId, count", zzchm.m18154a(str), Long.valueOf(a2.f6823a));
                        }
                        m5758i().m18553b(16, "_ev", com_google_android_gms_internal_zzcha2.f17798a, 0);
                        m5760k().m18023y();
                        m5760k().m18024z();
                        return;
                    }
                }
                if (equals) {
                    intValue = a2.f6826d - ((long) Math.max(0, Math.min(1000000, com_google_android_gms_internal_zzcim.f6975b.m13491b(com_google_android_gms_internal_zzcgi2.f17759a, zzchc.f6880n))));
                    if (intValue > 0) {
                        if (intValue == 1) {
                            m5754e().f17816a.m5695a("Too many error events logged. appId, count", zzchm.m18154a(str), Long.valueOf(a2.f6826d));
                        }
                        m5760k().m18023y();
                        m5760k().m18024z();
                        return;
                    }
                }
                Bundle a4 = com_google_android_gms_internal_zzcha2.f17799b.m18052a();
                m5758i().m18540a(a4, "_o", com_google_android_gms_internal_zzcha2.f17800c);
                if (m5758i().m18566i(str)) {
                    m5758i().m18540a(a4, "_dbg", Long.valueOf(1));
                    m5758i().m18540a(a4, "_r", Long.valueOf(1));
                }
                long c = m5760k().m18012c(str);
                if (c > 0) {
                    m5754e().f17818c.m5695a("Data lost. Too many events stored on disk, deleted. appId", zzchm.m18154a(str), Long.valueOf(c));
                }
                long j = nanoTime;
                nanoTime = 0;
                zzcgv com_google_android_gms_internal_zzcgv = r1;
                String str2 = str;
                zzcgv com_google_android_gms_internal_zzcgv2 = new zzcgv(com_google_android_gms_internal_zzcim, com_google_android_gms_internal_zzcha2.f17800c, str, com_google_android_gms_internal_zzcha2.f17798a, com_google_android_gms_internal_zzcha2.f17801d, 0, a4);
                zzcgw a5 = m5760k().m17995a(str2, com_google_android_gms_internal_zzcgv.f6836b);
                if (a5 == null) {
                    k = m5760k();
                    zzbq.m4810a(str2);
                    if (k.m17993a("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str2}, 0) < 500 || !a) {
                        a5 = new zzcgw(str2, com_google_android_gms_internal_zzcgv.f6836b, 0, 0, com_google_android_gms_internal_zzcgv.f6838d, 0, null, null, null);
                        z = false;
                    } else {
                        m5754e().f17816a.m5696a("Too many event names used, ignoring event. appId, name, supported count", zzchm.m18154a(str2), m5759j().m18128a(com_google_android_gms_internal_zzcgv.f6836b), Integer.valueOf(500));
                        m5758i().m18553b(8, null, null, 0);
                        m5760k().m18024z();
                        return;
                    }
                }
                z = false;
                com_google_android_gms_internal_zzcgv2 = new zzcgv(com_google_android_gms_internal_zzcim, com_google_android_gms_internal_zzcgv.f6837c, com_google_android_gms_internal_zzcgv.f6835a, com_google_android_gms_internal_zzcgv.f6836b, com_google_android_gms_internal_zzcgv.f6838d, a5.f6845e, com_google_android_gms_internal_zzcgv.f6840f);
                a3 = a5.m5669a(com_google_android_gms_internal_zzcgv2.f6838d);
                com_google_android_gms_internal_zzcgv = com_google_android_gms_internal_zzcgv2;
                m5760k().m18001a(a3);
                m5755f().mo1811c();
                m5736a();
                zzbq.m4808a((Object) com_google_android_gms_internal_zzcgv);
                zzbq.m4808a((Object) com_google_android_gms_internal_zzcgi);
                zzbq.m4810a(com_google_android_gms_internal_zzcgv.f6835a);
                zzbq.m4817b(com_google_android_gms_internal_zzcgv.f6835a.equals(com_google_android_gms_internal_zzcgi2.f17759a));
                com_google_android_gms_internal_zzcme = new zzcme();
                boolean z2 = true;
                com_google_android_gms_internal_zzcme.f17982a = Integer.valueOf(1);
                com_google_android_gms_internal_zzcme.f17990i = "android";
                com_google_android_gms_internal_zzcme.f17996o = com_google_android_gms_internal_zzcgi2.f17759a;
                com_google_android_gms_internal_zzcme.f17995n = com_google_android_gms_internal_zzcgi2.f17762d;
                com_google_android_gms_internal_zzcme.f17997p = com_google_android_gms_internal_zzcgi2.f17761c;
                com_google_android_gms_internal_zzcme.f17975C = com_google_android_gms_internal_zzcgi2.f17768j == -2147483648L ? null : Integer.valueOf((int) com_google_android_gms_internal_zzcgi2.f17768j);
                com_google_android_gms_internal_zzcme.f17998q = Long.valueOf(com_google_android_gms_internal_zzcgi2.f17763e);
                com_google_android_gms_internal_zzcme.f18006y = com_google_android_gms_internal_zzcgi2.f17760b;
                com_google_android_gms_internal_zzcme.f18003v = com_google_android_gms_internal_zzcgi2.f17764f == 0 ? null : Long.valueOf(com_google_android_gms_internal_zzcgi2.f17764f);
                Pair a6 = m5753d().m18216a(com_google_android_gms_internal_zzcgi2.f17759a);
                if (TextUtils.isEmpty((CharSequence) a6.first)) {
                    if (!m5764o().m18026a(com_google_android_gms_internal_zzcim.f6974a)) {
                        String string = Secure.getString(com_google_android_gms_internal_zzcim.f6974a.getContentResolver(), "android_id");
                        if (string == null) {
                            m5754e().f17818c.m5694a("null secure ID. appId", zzchm.m18154a(com_google_android_gms_internal_zzcme.f17996o));
                            string = "null";
                        } else if (string.isEmpty()) {
                            m5754e().f17818c.m5694a("empty secure ID. appId", zzchm.m18154a(com_google_android_gms_internal_zzcme.f17996o));
                        }
                        com_google_android_gms_internal_zzcme.f17976D = string;
                    }
                } else if (com_google_android_gms_internal_zzcgi2.f17773o) {
                    com_google_android_gms_internal_zzcme.f18000s = (String) a6.first;
                    com_google_android_gms_internal_zzcme.f18001t = (Boolean) a6.second;
                }
                m5764o().m13545L();
                com_google_android_gms_internal_zzcme.f17992k = Build.MODEL;
                m5764o().m13545L();
                com_google_android_gms_internal_zzcme.f17991j = VERSION.RELEASE;
                com_google_android_gms_internal_zzcme.f17994m = Integer.valueOf((int) m5764o().m18049x());
                com_google_android_gms_internal_zzcme.f17993l = m5764o().m18050y();
                com_google_android_gms_internal_zzcme.f17999r = null;
                com_google_android_gms_internal_zzcme.f17985d = null;
                com_google_android_gms_internal_zzcme.f17986e = null;
                com_google_android_gms_internal_zzcme.f17987f = null;
                com_google_android_gms_internal_zzcme.f17978F = Long.valueOf(com_google_android_gms_internal_zzcgi2.f17770l);
                if (m5768s() && zzcgn.m13484B()) {
                    m5765p();
                    com_google_android_gms_internal_zzcme.f17979G = null;
                }
                zzcgh b2 = m5760k().m18008b(com_google_android_gms_internal_zzcgi2.f17759a);
                if (b2 == null) {
                    b2 = new zzcgh(com_google_android_gms_internal_zzcim, com_google_android_gms_internal_zzcgi2.f17759a);
                    b2.m5621a(m5765p().m18083y());
                    b2.m5632d(com_google_android_gms_internal_zzcgi2.f17769k);
                    b2.m5625b(com_google_android_gms_internal_zzcgi2.f17760b);
                    b2.m5629c(m5753d().m18218b(com_google_android_gms_internal_zzcgi2.f17759a));
                    b2.m5637f(0);
                    b2.m5620a(0);
                    b2.m5624b(0);
                    b2.m5635e(com_google_android_gms_internal_zzcgi2.f17761c);
                    b2.m5628c(com_google_android_gms_internal_zzcgi2.f17768j);
                    b2.m5638f(com_google_android_gms_internal_zzcgi2.f17762d);
                    b2.m5631d(com_google_android_gms_internal_zzcgi2.f17763e);
                    b2.m5634e(com_google_android_gms_internal_zzcgi2.f17764f);
                    b2.m5622a(com_google_android_gms_internal_zzcgi2.f17766h);
                    b2.m5645i(com_google_android_gms_internal_zzcgi2.f17770l);
                    m5760k().m18000a(b2);
                }
                com_google_android_gms_internal_zzcme.f18002u = b2.m5623b();
                com_google_android_gms_internal_zzcme.f17974B = b2.m5633e();
                List a7 = m5760k().m17997a(com_google_android_gms_internal_zzcgi2.f17759a);
                com_google_android_gms_internal_zzcme.f17984c = new zzcmg[a7.size()];
                for (int i2 = z; i2 < a7.size(); i2++) {
                    zzcmg com_google_android_gms_internal_zzcmg = new zzcmg();
                    com_google_android_gms_internal_zzcme.f17984c[i2] = com_google_android_gms_internal_zzcmg;
                    com_google_android_gms_internal_zzcmg.f18012b = ((zzclp) a7.get(i2)).f7177c;
                    com_google_android_gms_internal_zzcmg.f18011a = Long.valueOf(((zzclp) a7.get(i2)).f7178d);
                    m5758i().m18542a(com_google_android_gms_internal_zzcmg, ((zzclp) a7.get(i2)).f7179e);
                }
                intValue = m5760k().m17991a(com_google_android_gms_internal_zzcme);
                k = m5760k();
                if (com_google_android_gms_internal_zzcgv.f6840f != null) {
                    Iterator it = com_google_android_gms_internal_zzcgv.f6840f.iterator();
                    while (it.hasNext()) {
                        if ("_r".equals((String) it.next())) {
                            break;
                        }
                    }
                    equals = m5756g().m18236c(com_google_android_gms_internal_zzcgv.f6835a, com_google_android_gms_internal_zzcgv.f6836b);
                    zzcgp a8 = m5760k().m17994a(m5714B(), com_google_android_gms_internal_zzcgv.f6835a, false, false, false, false, false);
                    if (equals && a8.f6827e < ((long) com_google_android_gms_internal_zzcim.f6975b.m13488a(com_google_android_gms_internal_zzcgv.f6835a))) {
                        if (k.m18005a(com_google_android_gms_internal_zzcgv, intValue, z2)) {
                            com_google_android_gms_internal_zzcim.f6970L = 0;
                        }
                        m5760k().m18023y();
                        if (m5754e().m18161a(2)) {
                            m5754e().f17822g.m5694a("Event recorded", m5759j().m18123a(com_google_android_gms_internal_zzcgv));
                        }
                        m5760k().m18024z();
                        m5770v();
                        m5754e().f17822g.m5694a("Background event processing time, ms", Long.valueOf(((System.nanoTime() - j) + 500000) / 1000000));
                    }
                }
                z2 = z;
                if (k.m18005a(com_google_android_gms_internal_zzcgv, intValue, z2)) {
                    com_google_android_gms_internal_zzcim.f6970L = 0;
                }
                m5760k().m18023y();
                if (m5754e().m18161a(2)) {
                    m5754e().f17822g.m5694a("Event recorded", m5759j().m18123a(com_google_android_gms_internal_zzcgv));
                }
                m5760k().m18024z();
                m5770v();
                m5754e().f17822g.m5694a("Background event processing time, ms", Long.valueOf(((System.nanoTime() - j) + 500000) / 1000000));
            } catch (IOException e) {
                m5754e().f17816a.m5695a("Data loss. Failed to insert raw event metadata. appId", zzchm.m18154a(com_google_android_gms_internal_zzcme.f17996o), e);
            } catch (Throwable th) {
                Throwable th2 = th;
                m5760k().m18024z();
            }
        }
    }

    private final boolean m5728a(String str, zzcha com_google_android_gms_internal_zzcha) {
        long round;
        zzcim com_google_android_gms_internal_zzcim = this;
        String str2 = str;
        zzcha com_google_android_gms_internal_zzcha2 = com_google_android_gms_internal_zzcha;
        Object string = com_google_android_gms_internal_zzcha2.f17799b.f17797a.getString("currency");
        if ("ecommerce_purchase".equals(com_google_android_gms_internal_zzcha2.f17798a)) {
            double doubleValue = Double.valueOf(com_google_android_gms_internal_zzcha2.f17799b.f17797a.getDouble("value")).doubleValue() * 1000000.0d;
            if (doubleValue == 0.0d) {
                doubleValue = ((double) com_google_android_gms_internal_zzcha2.f17799b.m18054b("value").longValue()) * 1000000.0d;
            }
            if (doubleValue > 9.223372036854776E18d || doubleValue < -9.223372036854776E18d) {
                m5754e().f17818c.m5695a("Data lost. Currency value is too big. appId", zzchm.m18154a(str), Double.valueOf(doubleValue));
                return false;
            }
            round = Math.round(doubleValue);
        } else {
            round = com_google_android_gms_internal_zzcha2.f17799b.m18054b("value").longValue();
        }
        if (!TextUtils.isEmpty(string)) {
            String toUpperCase = string.toUpperCase(Locale.US);
            if (toUpperCase.matches("[A-Z]{3}")) {
                zzclp com_google_android_gms_internal_zzclp;
                String valueOf = String.valueOf("_ltv_");
                toUpperCase = String.valueOf(toUpperCase);
                valueOf = toUpperCase.length() != 0 ? valueOf.concat(toUpperCase) : new String(valueOf);
                zzclp c = m5760k().m18013c(str2, valueOf);
                if (c != null) {
                    if (c.f7179e instanceof Long) {
                        long longValue = ((Long) c.f7179e).longValue();
                        com_google_android_gms_internal_zzclp = new zzclp(str2, com_google_android_gms_internal_zzcha2.f17800c, valueOf, com_google_android_gms_internal_zzcim.f6982i.mo1632a(), Long.valueOf(longValue + round));
                        if (!m5760k().m18006a(r12)) {
                            m5754e().f17816a.m5696a("Too many unique user properties are set. Ignoring user property. appId", zzchm.m18154a(str), m5759j().m18132c(r12.f7177c), r12.f7179e);
                            m5758i().m18553b(9, null, null, 0);
                        }
                    }
                }
                zzcjk k = m5760k();
                int b = com_google_android_gms_internal_zzcim.f6975b.m13491b(str2, zzchc.f6858G) - 1;
                zzbq.m4810a(str);
                k.mo1811c();
                k.m13545L();
                try {
                    k.m17987A().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[]{str2, str2, String.valueOf(b)});
                } catch (SQLiteException e) {
                    k.mo1828t().f17816a.m5695a("Error pruning currencies. appId", zzchm.m18154a(str), e);
                }
                com_google_android_gms_internal_zzclp = new zzclp(str2, com_google_android_gms_internal_zzcha2.f17800c, valueOf, com_google_android_gms_internal_zzcim.f6982i.mo1632a(), Long.valueOf(round));
                if (m5760k().m18006a(r12)) {
                    m5754e().f17816a.m5696a("Too many unique user properties are set. Ignoring user property. appId", zzchm.m18154a(str), m5759j().m18132c(r12.f7177c), r12.f7179e);
                    m5758i().m18553b(9, null, null, 0);
                }
            }
        }
        return true;
    }

    final void m5740a(zzcgl com_google_android_gms_internal_zzcgl, zzcgi com_google_android_gms_internal_zzcgi) {
        zzbq.m4808a((Object) com_google_android_gms_internal_zzcgl);
        zzbq.m4810a(com_google_android_gms_internal_zzcgl.f17774a);
        zzbq.m4808a(com_google_android_gms_internal_zzcgl.f17775b);
        zzbq.m4808a(com_google_android_gms_internal_zzcgl.f17776c);
        zzbq.m4810a(com_google_android_gms_internal_zzcgl.f17776c.f17900a);
        m5755f().mo1811c();
        m5736a();
        if (!TextUtils.isEmpty(com_google_android_gms_internal_zzcgi.f17760b)) {
            if (com_google_android_gms_internal_zzcgi.f17766h) {
                zzcgl com_google_android_gms_internal_zzcgl2 = new zzcgl(com_google_android_gms_internal_zzcgl);
                com_google_android_gms_internal_zzcgl = null;
                com_google_android_gms_internal_zzcgl2.f17778e = false;
                m5760k().m18022x();
                try {
                    zzcgl d = m5760k().m18014d(com_google_android_gms_internal_zzcgl2.f17774a, com_google_android_gms_internal_zzcgl2.f17776c.f17900a);
                    if (!(d == null || d.f17775b.equals(com_google_android_gms_internal_zzcgl2.f17775b))) {
                        m5754e().f17818c.m5696a("Updating a conditional user property with different origin. name, origin, origin (from DB)", m5759j().m18132c(com_google_android_gms_internal_zzcgl2.f17776c.f17900a), com_google_android_gms_internal_zzcgl2.f17775b, d.f17775b);
                    }
                    if (d != null && d.f17778e) {
                        com_google_android_gms_internal_zzcgl2.f17775b = d.f17775b;
                        com_google_android_gms_internal_zzcgl2.f17777d = d.f17777d;
                        com_google_android_gms_internal_zzcgl2.f17781h = d.f17781h;
                        com_google_android_gms_internal_zzcgl2.f17779f = d.f17779f;
                        com_google_android_gms_internal_zzcgl2.f17782i = d.f17782i;
                        com_google_android_gms_internal_zzcgl2.f17778e = d.f17778e;
                        com_google_android_gms_internal_zzcgl2.f17776c = new zzcln(com_google_android_gms_internal_zzcgl2.f17776c.f17900a, d.f17776c.f17901b, com_google_android_gms_internal_zzcgl2.f17776c.m18501a(), d.f17776c.f17902c);
                    } else if (TextUtils.isEmpty(com_google_android_gms_internal_zzcgl2.f17779f)) {
                        com_google_android_gms_internal_zzcgl2.f17776c = new zzcln(com_google_android_gms_internal_zzcgl2.f17776c.f17900a, com_google_android_gms_internal_zzcgl2.f17777d, com_google_android_gms_internal_zzcgl2.f17776c.m18501a(), com_google_android_gms_internal_zzcgl2.f17776c.f17902c);
                        com_google_android_gms_internal_zzcgl2.f17778e = true;
                        com_google_android_gms_internal_zzcgl = 1;
                    }
                    if (com_google_android_gms_internal_zzcgl2.f17778e) {
                        zzcln com_google_android_gms_internal_zzcln = com_google_android_gms_internal_zzcgl2.f17776c;
                        zzclp com_google_android_gms_internal_zzclp = new zzclp(com_google_android_gms_internal_zzcgl2.f17774a, com_google_android_gms_internal_zzcgl2.f17775b, com_google_android_gms_internal_zzcln.f17900a, com_google_android_gms_internal_zzcln.f17901b, com_google_android_gms_internal_zzcln.m18501a());
                        if (m5760k().m18006a(com_google_android_gms_internal_zzclp)) {
                            m5754e().f17821f.m5696a("User property updated immediately", com_google_android_gms_internal_zzcgl2.f17774a, m5759j().m18132c(com_google_android_gms_internal_zzclp.f7177c), com_google_android_gms_internal_zzclp.f7179e);
                        } else {
                            m5754e().f17816a.m5696a("(2)Too many active user properties, ignoring", zzchm.m18154a(com_google_android_gms_internal_zzcgl2.f17774a), m5759j().m18132c(com_google_android_gms_internal_zzclp.f7177c), com_google_android_gms_internal_zzclp.f7179e);
                        }
                        if (!(com_google_android_gms_internal_zzcgl == null || com_google_android_gms_internal_zzcgl2.f17782i == null)) {
                            m5731b(new zzcha(com_google_android_gms_internal_zzcgl2.f17782i, com_google_android_gms_internal_zzcgl2.f17777d), com_google_android_gms_internal_zzcgi);
                        }
                    }
                    if (m5760k().m18004a(com_google_android_gms_internal_zzcgl2) != null) {
                        m5754e().f17821f.m5696a("Conditional property added", com_google_android_gms_internal_zzcgl2.f17774a, m5759j().m18132c(com_google_android_gms_internal_zzcgl2.f17776c.f17900a), com_google_android_gms_internal_zzcgl2.f17776c.m18501a());
                    } else {
                        m5754e().f17816a.m5696a("Too many conditional properties, ignoring", zzchm.m18154a(com_google_android_gms_internal_zzcgl2.f17774a), m5759j().m18132c(com_google_android_gms_internal_zzcgl2.f17776c.f17900a), com_google_android_gms_internal_zzcgl2.f17776c.m18501a());
                    }
                    m5760k().m18023y();
                } finally {
                    m5760k().m18024z();
                }
            } else {
                m5752c(com_google_android_gms_internal_zzcgi);
            }
        }
    }

    final void m5747b(zzcgl com_google_android_gms_internal_zzcgl, zzcgi com_google_android_gms_internal_zzcgi) {
        zzbq.m4808a((Object) com_google_android_gms_internal_zzcgl);
        zzbq.m4810a(com_google_android_gms_internal_zzcgl.f17774a);
        zzbq.m4808a(com_google_android_gms_internal_zzcgl.f17776c);
        zzbq.m4810a(com_google_android_gms_internal_zzcgl.f17776c.f17900a);
        m5755f().mo1811c();
        m5736a();
        if (!TextUtils.isEmpty(com_google_android_gms_internal_zzcgi.f17760b)) {
            if (com_google_android_gms_internal_zzcgi.f17766h) {
                m5760k().m18022x();
                try {
                    m5752c(com_google_android_gms_internal_zzcgi);
                    zzcgl d = m5760k().m18014d(com_google_android_gms_internal_zzcgl.f17774a, com_google_android_gms_internal_zzcgl.f17776c.f17900a);
                    if (d != null) {
                        m5754e().f17821f.m5695a("Removing conditional user property", com_google_android_gms_internal_zzcgl.f17774a, m5759j().m18132c(com_google_android_gms_internal_zzcgl.f17776c.f17900a));
                        m5760k().m18016e(com_google_android_gms_internal_zzcgl.f17774a, com_google_android_gms_internal_zzcgl.f17776c.f17900a);
                        if (d.f17778e) {
                            m5760k().m18011b(com_google_android_gms_internal_zzcgl.f17774a, com_google_android_gms_internal_zzcgl.f17776c.f17900a);
                        }
                        if (com_google_android_gms_internal_zzcgl.f17784k != null) {
                            Bundle bundle = null;
                            if (com_google_android_gms_internal_zzcgl.f17784k.f17799b != null) {
                                bundle = com_google_android_gms_internal_zzcgl.f17784k.f17799b.m18052a();
                            }
                            Bundle bundle2 = bundle;
                            m5731b(m5758i().m18537a(com_google_android_gms_internal_zzcgl.f17784k.f17798a, bundle2, d.f17775b, com_google_android_gms_internal_zzcgl.f17784k.f17801d), com_google_android_gms_internal_zzcgi);
                        }
                    } else {
                        m5754e().f17818c.m5695a("Conditional user property doesn't exist", zzchm.m18154a(com_google_android_gms_internal_zzcgl.f17774a), m5759j().m18132c(com_google_android_gms_internal_zzcgl.f17776c.f17900a));
                    }
                    m5760k().m18023y();
                } finally {
                    m5760k().m18024z();
                }
            } else {
                m5752c(com_google_android_gms_internal_zzcgi);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] m5750b(com.google.android.gms.internal.zzcha r34, java.lang.String r35) {
        /*
        r33 = this;
        r11 = r33;
        r1 = r34;
        r10 = r35;
        r33.m5736a();
        r2 = r33.m5755f();
        r2.mo1811c();
        m5732t();
        com.google.android.gms.common.internal.zzbq.m4808a(r34);
        com.google.android.gms.common.internal.zzbq.m4810a(r35);
        r8 = new com.google.android.gms.internal.zzcmd;
        r8.<init>();
        r2 = r33.m5760k();
        r2.m18022x();
        r2 = r33.m5760k();	 Catch:{ all -> 0x0392 }
        r9 = r2.m18008b(r10);	 Catch:{ all -> 0x0392 }
        r6 = 0;
        if (r9 != 0) goto L_0x004a;
    L_0x0030:
        r1 = r33.m5754e();	 Catch:{ all -> 0x0045 }
        r1 = r1.f17821f;	 Catch:{ all -> 0x0045 }
        r2 = "Log and bundle not available. package_name";
        r1.m5694a(r2, r10);	 Catch:{ all -> 0x0045 }
        r1 = new byte[r6];	 Catch:{ all -> 0x0045 }
        r2 = r33.m5760k();
        r2.m18024z();
        return r1;
    L_0x0045:
        r0 = move-exception;
        r1 = r0;
        r5 = r11;
        goto L_0x0395;
    L_0x004a:
        r2 = r9.m5649m();	 Catch:{ all -> 0x0392 }
        if (r2 != 0) goto L_0x0065;
    L_0x0050:
        r1 = r33.m5754e();	 Catch:{ all -> 0x0045 }
        r1 = r1.f17821f;	 Catch:{ all -> 0x0045 }
        r2 = "Log and bundle disabled. package_name";
        r1.m5694a(r2, r10);	 Catch:{ all -> 0x0045 }
        r1 = new byte[r6];	 Catch:{ all -> 0x0045 }
        r2 = r33.m5760k();
        r2.m18024z();
        return r1;
    L_0x0065:
        r2 = "_iap";
        r3 = r1.f17798a;	 Catch:{ all -> 0x0392 }
        r2 = r2.equals(r3);	 Catch:{ all -> 0x0392 }
        if (r2 != 0) goto L_0x0079;
    L_0x006f:
        r2 = "ecommerce_purchase";
        r3 = r1.f17798a;	 Catch:{ all -> 0x0045 }
        r2 = r2.equals(r3);	 Catch:{ all -> 0x0045 }
        if (r2 == 0) goto L_0x008e;
    L_0x0079:
        r2 = r11.m5728a(r10, r1);	 Catch:{ all -> 0x0392 }
        if (r2 != 0) goto L_0x008e;
    L_0x007f:
        r2 = r33.m5754e();	 Catch:{ all -> 0x0045 }
        r2 = r2.f17818c;	 Catch:{ all -> 0x0045 }
        r3 = "Failed to handle purchase event at single event bundle creation. appId";
        r4 = com.google.android.gms.internal.zzchm.m18154a(r35);	 Catch:{ all -> 0x0045 }
        r2.m5694a(r3, r4);	 Catch:{ all -> 0x0045 }
    L_0x008e:
        r7 = new com.google.android.gms.internal.zzcme;	 Catch:{ all -> 0x0392 }
        r7.<init>();	 Catch:{ all -> 0x0392 }
        r5 = 1;
        r2 = new com.google.android.gms.internal.zzcme[r5];	 Catch:{ all -> 0x0392 }
        r2[r6] = r7;	 Catch:{ all -> 0x0392 }
        r8.f17971a = r2;	 Catch:{ all -> 0x0392 }
        r2 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x0392 }
        r7.f17982a = r2;	 Catch:{ all -> 0x0392 }
        r2 = "android";
        r7.f17990i = r2;	 Catch:{ all -> 0x0392 }
        r2 = r9.m5619a();	 Catch:{ all -> 0x0392 }
        r7.f17996o = r2;	 Catch:{ all -> 0x0392 }
        r2 = r9.m5646j();	 Catch:{ all -> 0x0392 }
        r7.f17995n = r2;	 Catch:{ all -> 0x0392 }
        r2 = r9.m5642h();	 Catch:{ all -> 0x0392 }
        r7.f17997p = r2;	 Catch:{ all -> 0x0392 }
        r2 = r9.m5644i();	 Catch:{ all -> 0x0392 }
        r12 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r4 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1));
        r15 = 0;
        if (r4 != 0) goto L_0x00c4;
    L_0x00c2:
        r2 = r15;
        goto L_0x00c9;
    L_0x00c4:
        r2 = (int) r2;	 Catch:{ all -> 0x0392 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x0392 }
    L_0x00c9:
        r7.f17975C = r2;	 Catch:{ all -> 0x0392 }
        r2 = r9.m5647k();	 Catch:{ all -> 0x0392 }
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x0392 }
        r7.f17998q = r2;	 Catch:{ all -> 0x0392 }
        r2 = r9.m5627c();	 Catch:{ all -> 0x0392 }
        r7.f18006y = r2;	 Catch:{ all -> 0x0392 }
        r2 = r9.m5648l();	 Catch:{ all -> 0x0392 }
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x0392 }
        r7.f18003v = r2;	 Catch:{ all -> 0x0392 }
        r2 = r33.m5768s();	 Catch:{ all -> 0x0392 }
        if (r2 == 0) goto L_0x0100;
    L_0x00eb:
        r2 = com.google.android.gms.internal.zzcgn.m13484B();	 Catch:{ all -> 0x0045 }
        if (r2 == 0) goto L_0x0100;
    L_0x00f1:
        r2 = r11.f6975b;	 Catch:{ all -> 0x0045 }
        r3 = r7.f17996o;	 Catch:{ all -> 0x0045 }
        r2 = r2.m13495c(r3);	 Catch:{ all -> 0x0045 }
        if (r2 == 0) goto L_0x0100;
    L_0x00fb:
        r33.m5765p();	 Catch:{ all -> 0x0045 }
        r7.f17979G = r15;	 Catch:{ all -> 0x0045 }
    L_0x0100:
        r2 = r33.m5753d();	 Catch:{ all -> 0x0392 }
        r3 = r9.m5619a();	 Catch:{ all -> 0x0392 }
        r2 = r2.m18216a(r3);	 Catch:{ all -> 0x0392 }
        r3 = r9.m5656t();	 Catch:{ all -> 0x0392 }
        if (r3 == 0) goto L_0x0128;
    L_0x0112:
        r3 = r2.first;	 Catch:{ all -> 0x0045 }
        r3 = (java.lang.CharSequence) r3;	 Catch:{ all -> 0x0045 }
        r3 = android.text.TextUtils.isEmpty(r3);	 Catch:{ all -> 0x0045 }
        if (r3 != 0) goto L_0x0128;
    L_0x011c:
        r3 = r2.first;	 Catch:{ all -> 0x0045 }
        r3 = (java.lang.String) r3;	 Catch:{ all -> 0x0045 }
        r7.f18000s = r3;	 Catch:{ all -> 0x0045 }
        r2 = r2.second;	 Catch:{ all -> 0x0045 }
        r2 = (java.lang.Boolean) r2;	 Catch:{ all -> 0x0045 }
        r7.f18001t = r2;	 Catch:{ all -> 0x0045 }
    L_0x0128:
        r2 = r33.m5764o();	 Catch:{ all -> 0x0392 }
        r2.m13545L();	 Catch:{ all -> 0x0392 }
        r2 = android.os.Build.MODEL;	 Catch:{ all -> 0x0392 }
        r7.f17992k = r2;	 Catch:{ all -> 0x0392 }
        r2 = r33.m5764o();	 Catch:{ all -> 0x0392 }
        r2.m13545L();	 Catch:{ all -> 0x0392 }
        r2 = android.os.Build.VERSION.RELEASE;	 Catch:{ all -> 0x0392 }
        r7.f17991j = r2;	 Catch:{ all -> 0x0392 }
        r2 = r33.m5764o();	 Catch:{ all -> 0x0392 }
        r2 = r2.m18049x();	 Catch:{ all -> 0x0392 }
        r2 = (int) r2;	 Catch:{ all -> 0x0392 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x0392 }
        r7.f17994m = r2;	 Catch:{ all -> 0x0392 }
        r2 = r33.m5764o();	 Catch:{ all -> 0x0392 }
        r2 = r2.m18050y();	 Catch:{ all -> 0x0392 }
        r7.f17993l = r2;	 Catch:{ all -> 0x0392 }
        r2 = r9.m5623b();	 Catch:{ all -> 0x0392 }
        r7.f18002u = r2;	 Catch:{ all -> 0x0392 }
        r2 = r9.m5633e();	 Catch:{ all -> 0x0392 }
        r7.f17974B = r2;	 Catch:{ all -> 0x0392 }
        r2 = r33.m5760k();	 Catch:{ all -> 0x0392 }
        r3 = r9.m5619a();	 Catch:{ all -> 0x0392 }
        r2 = r2.m17997a(r3);	 Catch:{ all -> 0x0392 }
        r3 = r2.size();	 Catch:{ all -> 0x0392 }
        r3 = new com.google.android.gms.internal.zzcmg[r3];	 Catch:{ all -> 0x0392 }
        r7.f17984c = r3;	 Catch:{ all -> 0x0392 }
        r3 = r6;
    L_0x0178:
        r4 = r2.size();	 Catch:{ all -> 0x0392 }
        if (r3 >= r4) goto L_0x01b1;
    L_0x017e:
        r4 = new com.google.android.gms.internal.zzcmg;	 Catch:{ all -> 0x0045 }
        r4.<init>();	 Catch:{ all -> 0x0045 }
        r12 = r7.f17984c;	 Catch:{ all -> 0x0045 }
        r12[r3] = r4;	 Catch:{ all -> 0x0045 }
        r12 = r2.get(r3);	 Catch:{ all -> 0x0045 }
        r12 = (com.google.android.gms.internal.zzclp) r12;	 Catch:{ all -> 0x0045 }
        r12 = r12.f7177c;	 Catch:{ all -> 0x0045 }
        r4.f18012b = r12;	 Catch:{ all -> 0x0045 }
        r12 = r2.get(r3);	 Catch:{ all -> 0x0045 }
        r12 = (com.google.android.gms.internal.zzclp) r12;	 Catch:{ all -> 0x0045 }
        r12 = r12.f7178d;	 Catch:{ all -> 0x0045 }
        r12 = java.lang.Long.valueOf(r12);	 Catch:{ all -> 0x0045 }
        r4.f18011a = r12;	 Catch:{ all -> 0x0045 }
        r12 = r33.m5758i();	 Catch:{ all -> 0x0045 }
        r13 = r2.get(r3);	 Catch:{ all -> 0x0045 }
        r13 = (com.google.android.gms.internal.zzclp) r13;	 Catch:{ all -> 0x0045 }
        r13 = r13.f7179e;	 Catch:{ all -> 0x0045 }
        r12.m18542a(r4, r13);	 Catch:{ all -> 0x0045 }
        r3 = r3 + 1;
        goto L_0x0178;
    L_0x01b1:
        r2 = r1.f17799b;	 Catch:{ all -> 0x0392 }
        r4 = r2.m18052a();	 Catch:{ all -> 0x0392 }
        r2 = "_iap";
        r3 = r1.f17798a;	 Catch:{ all -> 0x0392 }
        r2 = r2.equals(r3);	 Catch:{ all -> 0x0392 }
        r12 = 1;
        if (r2 == 0) goto L_0x01d8;
    L_0x01c3:
        r2 = "_c";
        r4.putLong(r2, r12);	 Catch:{ all -> 0x0045 }
        r2 = r33.m5754e();	 Catch:{ all -> 0x0045 }
        r2 = r2.f17821f;	 Catch:{ all -> 0x0045 }
        r3 = "Marking in-app purchase as real-time";
        r2.m5693a(r3);	 Catch:{ all -> 0x0045 }
        r2 = "_r";
        r4.putLong(r2, r12);	 Catch:{ all -> 0x0045 }
    L_0x01d8:
        r2 = "_o";
        r3 = r1.f17800c;	 Catch:{ all -> 0x0392 }
        r4.putString(r2, r3);	 Catch:{ all -> 0x0392 }
        r2 = r33.m5758i();	 Catch:{ all -> 0x0392 }
        r3 = r7.f17996o;	 Catch:{ all -> 0x0392 }
        r2 = r2.m18566i(r3);	 Catch:{ all -> 0x0392 }
        if (r2 == 0) goto L_0x0205;
    L_0x01eb:
        r2 = r33.m5758i();	 Catch:{ all -> 0x0045 }
        r3 = "_dbg";
        r14 = java.lang.Long.valueOf(r12);	 Catch:{ all -> 0x0045 }
        r2.m18540a(r4, r3, r14);	 Catch:{ all -> 0x0045 }
        r2 = r33.m5758i();	 Catch:{ all -> 0x0045 }
        r3 = "_r";
        r12 = java.lang.Long.valueOf(r12);	 Catch:{ all -> 0x0045 }
        r2.m18540a(r4, r3, r12);	 Catch:{ all -> 0x0045 }
    L_0x0205:
        r2 = r33.m5760k();	 Catch:{ all -> 0x0392 }
        r3 = r1.f17798a;	 Catch:{ all -> 0x0392 }
        r2 = r2.m17995a(r10, r3);	 Catch:{ all -> 0x0392 }
        r26 = 0;
        if (r2 != 0) goto L_0x023e;
    L_0x0213:
        r2 = new com.google.android.gms.internal.zzcgw;	 Catch:{ all -> 0x0045 }
        r14 = r1.f17798a;	 Catch:{ all -> 0x0045 }
        r16 = 1;
        r18 = 0;
        r12 = r1.f17801d;	 Catch:{ all -> 0x0045 }
        r21 = 0;
        r23 = 0;
        r24 = 0;
        r25 = 0;
        r28 = r12;
        r12 = r2;
        r13 = r10;
        r30 = r15;
        r15 = r16;
        r17 = r18;
        r19 = r28;
        r12.<init>(r13, r14, r15, r17, r19, r21, r23, r24, r25);	 Catch:{ all -> 0x0045 }
        r3 = r33.m5760k();	 Catch:{ all -> 0x0045 }
        r3.m18001a(r2);	 Catch:{ all -> 0x0045 }
        r12 = r26;
        goto L_0x0253;
    L_0x023e:
        r30 = r15;
        r12 = r2.f6845e;	 Catch:{ all -> 0x0392 }
        r14 = r1.f17801d;	 Catch:{ all -> 0x0392 }
        r2 = r2.m5669a(r14);	 Catch:{ all -> 0x0392 }
        r2 = r2.m5668a();	 Catch:{ all -> 0x0392 }
        r3 = r33.m5760k();	 Catch:{ all -> 0x0392 }
        r3.m18001a(r2);	 Catch:{ all -> 0x0392 }
    L_0x0253:
        r14 = new com.google.android.gms.internal.zzcgv;	 Catch:{ all -> 0x0392 }
        r3 = r1.f17800c;	 Catch:{ all -> 0x0392 }
        r15 = r1.f17798a;	 Catch:{ all -> 0x0392 }
        r1 = r1.f17801d;	 Catch:{ all -> 0x0392 }
        r16 = r1;
        r1 = r14;
        r2 = r11;
        r18 = r4;
        r4 = r10;
        r11 = r5;
        r5 = r15;
        r19 = r6;
        r15 = r7;
        r6 = r16;
        r31 = r8;
        r32 = r9;
        r8 = r12;
        r10 = r18;
        r1.<init>(r2, r3, r4, r5, r6, r8, r10);	 Catch:{ all -> 0x038e }
        r1 = new com.google.android.gms.internal.zzcmb;	 Catch:{ all -> 0x038e }
        r1.<init>();	 Catch:{ all -> 0x038e }
        r2 = new com.google.android.gms.internal.zzcmb[r11];	 Catch:{ all -> 0x038e }
        r2[r19] = r1;	 Catch:{ all -> 0x038e }
        r15.f17983b = r2;	 Catch:{ all -> 0x038e }
        r2 = r14.f6838d;	 Catch:{ all -> 0x038e }
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x038e }
        r1.f17962c = r2;	 Catch:{ all -> 0x038e }
        r2 = r14.f6836b;	 Catch:{ all -> 0x038e }
        r1.f17961b = r2;	 Catch:{ all -> 0x038e }
        r2 = r14.f6839e;	 Catch:{ all -> 0x038e }
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x038e }
        r1.f17963d = r2;	 Catch:{ all -> 0x038e }
        r2 = r14.f6840f;	 Catch:{ all -> 0x038e }
        r2 = r2.f17797a;	 Catch:{ all -> 0x038e }
        r2 = r2.size();	 Catch:{ all -> 0x038e }
        r2 = new com.google.android.gms.internal.zzcmc[r2];	 Catch:{ all -> 0x038e }
        r1.f17960a = r2;	 Catch:{ all -> 0x038e }
        r2 = r14.f6840f;	 Catch:{ all -> 0x038e }
        r2 = r2.iterator();	 Catch:{ all -> 0x038e }
    L_0x02a4:
        r3 = r2.hasNext();	 Catch:{ all -> 0x038e }
        if (r3 == 0) goto L_0x02cf;
    L_0x02aa:
        r3 = r2.next();	 Catch:{ all -> 0x038e }
        r3 = (java.lang.String) r3;	 Catch:{ all -> 0x038e }
        r4 = new com.google.android.gms.internal.zzcmc;	 Catch:{ all -> 0x038e }
        r4.<init>();	 Catch:{ all -> 0x038e }
        r5 = r1.f17960a;	 Catch:{ all -> 0x038e }
        r6 = r19 + 1;
        r5[r19] = r4;	 Catch:{ all -> 0x038e }
        r4.f17966a = r3;	 Catch:{ all -> 0x038e }
        r5 = r14.f6840f;	 Catch:{ all -> 0x038e }
        r3 = r5.m18053a(r3);	 Catch:{ all -> 0x038e }
        r5 = r33;
        r7 = r33.m5758i();	 Catch:{ all -> 0x038c }
        r7.m18541a(r4, r3);	 Catch:{ all -> 0x038c }
        r19 = r6;
        goto L_0x02a4;
    L_0x02cf:
        r2 = r32;
        r5 = r33;
        r3 = r2.m5619a();	 Catch:{ all -> 0x038c }
        r4 = r15.f17984c;	 Catch:{ all -> 0x038c }
        r6 = r15.f17983b;	 Catch:{ all -> 0x038c }
        r3 = r5.m5729a(r3, r4, r6);	 Catch:{ all -> 0x038c }
        r15.f17973A = r3;	 Catch:{ all -> 0x038c }
        r3 = r1.f17962c;	 Catch:{ all -> 0x038c }
        r15.f17986e = r3;	 Catch:{ all -> 0x038c }
        r1 = r1.f17962c;	 Catch:{ all -> 0x038c }
        r15.f17987f = r1;	 Catch:{ all -> 0x038c }
        r3 = r2.m5639g();	 Catch:{ all -> 0x038c }
        r1 = (r3 > r26 ? 1 : (r3 == r26 ? 0 : -1));
        if (r1 == 0) goto L_0x02f6;
    L_0x02f1:
        r1 = java.lang.Long.valueOf(r3);	 Catch:{ all -> 0x038c }
        goto L_0x02f8;
    L_0x02f6:
        r1 = r30;
    L_0x02f8:
        r15.f17989h = r1;	 Catch:{ all -> 0x038c }
        r6 = r2.m5636f();	 Catch:{ all -> 0x038c }
        r1 = (r6 > r26 ? 1 : (r6 == r26 ? 0 : -1));
        if (r1 != 0) goto L_0x0303;
    L_0x0302:
        goto L_0x0304;
    L_0x0303:
        r3 = r6;
    L_0x0304:
        r1 = (r3 > r26 ? 1 : (r3 == r26 ? 0 : -1));
        if (r1 == 0) goto L_0x030d;
    L_0x0308:
        r1 = java.lang.Long.valueOf(r3);	 Catch:{ all -> 0x038c }
        goto L_0x030f;
    L_0x030d:
        r1 = r30;
    L_0x030f:
        r15.f17988g = r1;	 Catch:{ all -> 0x038c }
        r2.m5653q();	 Catch:{ all -> 0x038c }
        r3 = r2.m5650n();	 Catch:{ all -> 0x038c }
        r1 = (int) r3;	 Catch:{ all -> 0x038c }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ all -> 0x038c }
        r15.f18004w = r1;	 Catch:{ all -> 0x038c }
        r3 = 11910; // 0x2e86 float:1.669E-41 double:5.8843E-320;
        r1 = java.lang.Long.valueOf(r3);	 Catch:{ all -> 0x038c }
        r15.f17999r = r1;	 Catch:{ all -> 0x038c }
        r1 = r5.f6982i;	 Catch:{ all -> 0x038c }
        r3 = r1.mo1632a();	 Catch:{ all -> 0x038c }
        r1 = java.lang.Long.valueOf(r3);	 Catch:{ all -> 0x038c }
        r15.f17985d = r1;	 Catch:{ all -> 0x038c }
        r1 = java.lang.Boolean.TRUE;	 Catch:{ all -> 0x038c }
        r15.f18007z = r1;	 Catch:{ all -> 0x038c }
        r1 = r15.f17986e;	 Catch:{ all -> 0x038c }
        r3 = r1.longValue();	 Catch:{ all -> 0x038c }
        r2.m5620a(r3);	 Catch:{ all -> 0x038c }
        r1 = r15.f17987f;	 Catch:{ all -> 0x038c }
        r3 = r1.longValue();	 Catch:{ all -> 0x038c }
        r2.m5624b(r3);	 Catch:{ all -> 0x038c }
        r1 = r33.m5760k();	 Catch:{ all -> 0x038c }
        r1.m18000a(r2);	 Catch:{ all -> 0x038c }
        r1 = r33.m5760k();	 Catch:{ all -> 0x038c }
        r1.m18023y();	 Catch:{ all -> 0x038c }
        r1 = r33.m5760k();
        r1.m18024z();
        r1 = r31;
        r2 = r1.m6211e();	 Catch:{ IOException -> 0x037a }
        r2 = new byte[r2];	 Catch:{ IOException -> 0x037a }
        r3 = r2.length;	 Catch:{ IOException -> 0x037a }
        r3 = com.google.android.gms.internal.zzfjk.m6158a(r2, r3);	 Catch:{ IOException -> 0x037a }
        r1.mo1928a(r3);	 Catch:{ IOException -> 0x037a }
        r3.m6171a();	 Catch:{ IOException -> 0x037a }
        r1 = r33.m5758i();	 Catch:{ IOException -> 0x037a }
        r1 = r1.m18548a(r2);	 Catch:{ IOException -> 0x037a }
        return r1;
    L_0x037a:
        r0 = move-exception;
        r1 = r0;
        r2 = r33.m5754e();
        r2 = r2.f17816a;
        r3 = "Data loss. Failed to bundle and serialize. appId";
        r4 = com.google.android.gms.internal.zzchm.m18154a(r35);
        r2.m5695a(r3, r4, r1);
        return r30;
    L_0x038c:
        r0 = move-exception;
        goto L_0x0394;
    L_0x038e:
        r0 = move-exception;
        r5 = r33;
        goto L_0x0394;
    L_0x0392:
        r0 = move-exception;
        r5 = r11;
    L_0x0394:
        r1 = r0;
    L_0x0395:
        r2 = r33.m5760k();
        r2.m18024z();
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcim.b(com.google.android.gms.internal.zzcha, java.lang.String):byte[]");
    }

    public final String m5735a(String str) {
        try {
            return (String) m5755f().m18269a(new zzcio(this, str)).get(30000, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            m5754e().f17816a.m5695a("Failed to get app instance id. appId", zzchm.m18154a(str), e);
            return null;
        }
    }

    final void m5743a(zzcln com_google_android_gms_internal_zzcln, zzcgi com_google_android_gms_internal_zzcgi) {
        m5755f().mo1811c();
        m5736a();
        if (!TextUtils.isEmpty(com_google_android_gms_internal_zzcgi.f17760b)) {
            if (com_google_android_gms_internal_zzcgi.f17766h) {
                String a;
                int d = m5758i().m18557d(com_google_android_gms_internal_zzcln.f17900a);
                int i = 0;
                if (d != 0) {
                    m5758i();
                    a = zzclq.m18506a(com_google_android_gms_internal_zzcln.f17900a, 24, true);
                    if (com_google_android_gms_internal_zzcln.f17900a != null) {
                        com_google_android_gms_internal_zzcln = com_google_android_gms_internal_zzcln.f17900a;
                    }
                    com_google_android_gms_internal_zzcln = m5758i();
                    com_google_android_gms_internal_zzcgi = com_google_android_gms_internal_zzcgi.f17759a;
                    com_google_android_gms_internal_zzcln.m18553b(d, "_ev", a, i);
                    return;
                }
                d = m5758i().m18550b(com_google_android_gms_internal_zzcln.f17900a, com_google_android_gms_internal_zzcln.m18501a());
                if (d != 0) {
                    m5758i();
                    a = zzclq.m18506a(com_google_android_gms_internal_zzcln.f17900a, 24, true);
                    com_google_android_gms_internal_zzcln = com_google_android_gms_internal_zzcln.m18501a();
                    if (com_google_android_gms_internal_zzcln != null && ((com_google_android_gms_internal_zzcln instanceof String) || (com_google_android_gms_internal_zzcln instanceof CharSequence))) {
                        com_google_android_gms_internal_zzcln = String.valueOf(com_google_android_gms_internal_zzcln);
                    }
                    com_google_android_gms_internal_zzcln = m5758i();
                    com_google_android_gms_internal_zzcgi = com_google_android_gms_internal_zzcgi.f17759a;
                    com_google_android_gms_internal_zzcln.m18553b(d, "_ev", a, i);
                    return;
                }
                m5758i();
                Object c = zzclq.m18523c(com_google_android_gms_internal_zzcln.f17900a, com_google_android_gms_internal_zzcln.m18501a());
                if (c != null) {
                    zzclp com_google_android_gms_internal_zzclp = new zzclp(com_google_android_gms_internal_zzcgi.f17759a, com_google_android_gms_internal_zzcln.f17902c, com_google_android_gms_internal_zzcln.f17900a, com_google_android_gms_internal_zzcln.f17901b, c);
                    m5754e().f17821f.m5695a("Setting user property", m5759j().m18132c(com_google_android_gms_internal_zzclp.f7177c), c);
                    m5760k().m18022x();
                    try {
                        m5752c(com_google_android_gms_internal_zzcgi);
                        com_google_android_gms_internal_zzcln = m5760k().m18006a(com_google_android_gms_internal_zzclp);
                        m5760k().m18023y();
                        if (com_google_android_gms_internal_zzcln != null) {
                            m5754e().f17821f.m5695a("User property set", m5759j().m18132c(com_google_android_gms_internal_zzclp.f7177c), com_google_android_gms_internal_zzclp.f7179e);
                        } else {
                            m5754e().f17816a.m5695a("Too many unique user properties are set. Ignoring user property", m5759j().m18132c(com_google_android_gms_internal_zzclp.f7177c), com_google_android_gms_internal_zzclp.f7179e);
                            com_google_android_gms_internal_zzcln = m5758i();
                            com_google_android_gms_internal_zzcgi = com_google_android_gms_internal_zzcgi.f17759a;
                            com_google_android_gms_internal_zzcln.m18553b(9, null, null, 0);
                        }
                        m5760k().m18024z();
                        return;
                    } catch (Throwable th) {
                        m5760k().m18024z();
                    }
                } else {
                    return;
                }
                i = com_google_android_gms_internal_zzcln.length();
                com_google_android_gms_internal_zzcln = m5758i();
                com_google_android_gms_internal_zzcgi = com_google_android_gms_internal_zzcgi.f17759a;
                com_google_android_gms_internal_zzcln.m18553b(d, "_ev", a, i);
                return;
            }
            m5752c(com_google_android_gms_internal_zzcgi);
        }
    }

    final void m5748b(zzcln com_google_android_gms_internal_zzcln, zzcgi com_google_android_gms_internal_zzcgi) {
        m5755f().mo1811c();
        m5736a();
        if (!TextUtils.isEmpty(com_google_android_gms_internal_zzcgi.f17760b)) {
            if (com_google_android_gms_internal_zzcgi.f17766h) {
                m5754e().f17821f.m5694a("Removing user property", m5759j().m18132c(com_google_android_gms_internal_zzcln.f17900a));
                m5760k().m18022x();
                try {
                    m5752c(com_google_android_gms_internal_zzcgi);
                    m5760k().m18011b(com_google_android_gms_internal_zzcgi.f17759a, com_google_android_gms_internal_zzcln.f17900a);
                    m5760k().m18023y();
                    m5754e().f17821f.m5694a("User property removed", m5759j().m18132c(com_google_android_gms_internal_zzcln.f17900a));
                } finally {
                    m5760k().m18024z();
                }
            } else {
                m5752c(com_google_android_gms_internal_zzcgi);
            }
        }
    }

    public final void m5769u() {
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
        r14 = this;
        r0 = r14.m5755f();
        r0.mo1811c();
        r14.m5736a();
        r0 = 1;
        r14.f6973O = r0;
        r1 = 0;
        r2 = r14.m5763n();	 Catch:{ all -> 0x028c }
        r2 = r2.f17886a;	 Catch:{ all -> 0x028c }
        if (r2 != 0) goto L_0x0027;	 Catch:{ all -> 0x028c }
    L_0x0016:
        r0 = r14.m5754e();	 Catch:{ all -> 0x028c }
        r0 = r0.f17818c;	 Catch:{ all -> 0x028c }
        r2 = "Upload data called on the client side before use of service was decided";	 Catch:{ all -> 0x028c }
        r0.m5693a(r2);	 Catch:{ all -> 0x028c }
        r14.f6973O = r1;
        r14.m5717E();
        return;
    L_0x0027:
        r2 = r2.booleanValue();	 Catch:{ all -> 0x028c }
        if (r2 == 0) goto L_0x003e;	 Catch:{ all -> 0x028c }
    L_0x002d:
        r0 = r14.m5754e();	 Catch:{ all -> 0x028c }
        r0 = r0.f17816a;	 Catch:{ all -> 0x028c }
        r2 = "Upload called in the client side when service should be used";	 Catch:{ all -> 0x028c }
        r0.m5693a(r2);	 Catch:{ all -> 0x028c }
    L_0x0038:
        r14.f6973O = r1;
        r14.m5717E();
        return;
    L_0x003e:
        r2 = r14.f6970L;	 Catch:{ all -> 0x028c }
        r4 = 0;	 Catch:{ all -> 0x028c }
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));	 Catch:{ all -> 0x028c }
        if (r2 <= 0) goto L_0x004a;	 Catch:{ all -> 0x028c }
    L_0x0046:
        r14.m5770v();	 Catch:{ all -> 0x028c }
        goto L_0x0038;	 Catch:{ all -> 0x028c }
    L_0x004a:
        r2 = r14.m5755f();	 Catch:{ all -> 0x028c }
        r2.mo1811c();	 Catch:{ all -> 0x028c }
        r2 = r14.f6967I;	 Catch:{ all -> 0x028c }
        if (r2 == 0) goto L_0x0057;	 Catch:{ all -> 0x028c }
    L_0x0055:
        r2 = r0;	 Catch:{ all -> 0x028c }
        goto L_0x0058;	 Catch:{ all -> 0x028c }
    L_0x0057:
        r2 = r1;	 Catch:{ all -> 0x028c }
    L_0x0058:
        if (r2 == 0) goto L_0x006b;	 Catch:{ all -> 0x028c }
    L_0x005a:
        r0 = r14.m5754e();	 Catch:{ all -> 0x028c }
        r0 = r0.f17822g;	 Catch:{ all -> 0x028c }
        r2 = "Uploading requested multiple times";	 Catch:{ all -> 0x028c }
        r0.m5693a(r2);	 Catch:{ all -> 0x028c }
        r14.f6973O = r1;
        r14.m5717E();
        return;
    L_0x006b:
        r2 = r14.m5761l();	 Catch:{ all -> 0x028c }
        r2 = r2.m18210y();	 Catch:{ all -> 0x028c }
        if (r2 != 0) goto L_0x0089;	 Catch:{ all -> 0x028c }
    L_0x0075:
        r0 = r14.m5754e();	 Catch:{ all -> 0x028c }
        r0 = r0.f17822g;	 Catch:{ all -> 0x028c }
        r2 = "Network not connected, ignoring upload request";	 Catch:{ all -> 0x028c }
        r0.m5693a(r2);	 Catch:{ all -> 0x028c }
        r14.m5770v();	 Catch:{ all -> 0x028c }
        r14.f6973O = r1;
        r14.m5717E();
        return;
    L_0x0089:
        r2 = r14.f6982i;	 Catch:{ all -> 0x028c }
        r2 = r2.mo1632a();	 Catch:{ all -> 0x028c }
        r6 = com.google.android.gms.internal.zzcgn.m13486z();	 Catch:{ all -> 0x028c }
        r6 = r2 - r6;	 Catch:{ all -> 0x028c }
        r14.m5726a(r6);	 Catch:{ all -> 0x028c }
        r6 = r14.m5753d();	 Catch:{ all -> 0x028c }
        r6 = r6.f17830c;	 Catch:{ all -> 0x028c }
        r6 = r6.m5702a();	 Catch:{ all -> 0x028c }
        r4 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1));	 Catch:{ all -> 0x028c }
        if (r4 == 0) goto L_0x00bb;	 Catch:{ all -> 0x028c }
    L_0x00a6:
        r4 = r14.m5754e();	 Catch:{ all -> 0x028c }
        r4 = r4.f17821f;	 Catch:{ all -> 0x028c }
        r5 = "Uploading events. Elapsed time since last upload attempt (ms)";	 Catch:{ all -> 0x028c }
        r6 = r2 - r6;	 Catch:{ all -> 0x028c }
        r6 = java.lang.Math.abs(r6);	 Catch:{ all -> 0x028c }
        r6 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x028c }
        r4.m5694a(r5, r6);	 Catch:{ all -> 0x028c }
    L_0x00bb:
        r4 = r14.m5760k();	 Catch:{ all -> 0x028c }
        r4 = r4.m17988B();	 Catch:{ all -> 0x028c }
        r5 = android.text.TextUtils.isEmpty(r4);	 Catch:{ all -> 0x028c }
        r6 = -1;	 Catch:{ all -> 0x028c }
        if (r5 != 0) goto L_0x0264;	 Catch:{ all -> 0x028c }
    L_0x00cb:
        r8 = r14.f6969K;	 Catch:{ all -> 0x028c }
        r5 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1));	 Catch:{ all -> 0x028c }
        if (r5 != 0) goto L_0x00db;	 Catch:{ all -> 0x028c }
    L_0x00d1:
        r5 = r14.m5760k();	 Catch:{ all -> 0x028c }
        r5 = r5.m17990D();	 Catch:{ all -> 0x028c }
        r14.f6969K = r5;	 Catch:{ all -> 0x028c }
    L_0x00db:
        r5 = r14.f6975b;	 Catch:{ all -> 0x028c }
        r6 = com.google.android.gms.internal.zzchc.f6875i;	 Catch:{ all -> 0x028c }
        r5 = r5.m13491b(r4, r6);	 Catch:{ all -> 0x028c }
        r6 = r14.f6975b;	 Catch:{ all -> 0x028c }
        r7 = com.google.android.gms.internal.zzchc.f6876j;	 Catch:{ all -> 0x028c }
        r6 = r6.m13491b(r4, r7);	 Catch:{ all -> 0x028c }
        r6 = java.lang.Math.max(r1, r6);	 Catch:{ all -> 0x028c }
        r7 = r14.m5760k();	 Catch:{ all -> 0x028c }
        r5 = r7.m17998a(r4, r5, r6);	 Catch:{ all -> 0x028c }
        r6 = r5.isEmpty();	 Catch:{ all -> 0x028c }
        if (r6 != 0) goto L_0x0286;	 Catch:{ all -> 0x028c }
    L_0x00fd:
        r6 = r5.iterator();	 Catch:{ all -> 0x028c }
    L_0x0101:
        r7 = r6.hasNext();	 Catch:{ all -> 0x028c }
        r8 = 0;	 Catch:{ all -> 0x028c }
        if (r7 == 0) goto L_0x011d;	 Catch:{ all -> 0x028c }
    L_0x0108:
        r7 = r6.next();	 Catch:{ all -> 0x028c }
        r7 = (android.util.Pair) r7;	 Catch:{ all -> 0x028c }
        r7 = r7.first;	 Catch:{ all -> 0x028c }
        r7 = (com.google.android.gms.internal.zzcme) r7;	 Catch:{ all -> 0x028c }
        r9 = r7.f18000s;	 Catch:{ all -> 0x028c }
        r9 = android.text.TextUtils.isEmpty(r9);	 Catch:{ all -> 0x028c }
        if (r9 != 0) goto L_0x0101;	 Catch:{ all -> 0x028c }
    L_0x011a:
        r6 = r7.f18000s;	 Catch:{ all -> 0x028c }
        goto L_0x011e;	 Catch:{ all -> 0x028c }
    L_0x011d:
        r6 = r8;	 Catch:{ all -> 0x028c }
    L_0x011e:
        if (r6 == 0) goto L_0x0149;	 Catch:{ all -> 0x028c }
    L_0x0120:
        r7 = r1;	 Catch:{ all -> 0x028c }
    L_0x0121:
        r9 = r5.size();	 Catch:{ all -> 0x028c }
        if (r7 >= r9) goto L_0x0149;	 Catch:{ all -> 0x028c }
    L_0x0127:
        r9 = r5.get(r7);	 Catch:{ all -> 0x028c }
        r9 = (android.util.Pair) r9;	 Catch:{ all -> 0x028c }
        r9 = r9.first;	 Catch:{ all -> 0x028c }
        r9 = (com.google.android.gms.internal.zzcme) r9;	 Catch:{ all -> 0x028c }
        r10 = r9.f18000s;	 Catch:{ all -> 0x028c }
        r10 = android.text.TextUtils.isEmpty(r10);	 Catch:{ all -> 0x028c }
        if (r10 != 0) goto L_0x0146;	 Catch:{ all -> 0x028c }
    L_0x0139:
        r9 = r9.f18000s;	 Catch:{ all -> 0x028c }
        r9 = r9.equals(r6);	 Catch:{ all -> 0x028c }
        if (r9 != 0) goto L_0x0146;	 Catch:{ all -> 0x028c }
    L_0x0141:
        r5 = r5.subList(r1, r7);	 Catch:{ all -> 0x028c }
        goto L_0x0149;	 Catch:{ all -> 0x028c }
    L_0x0146:
        r7 = r7 + 1;	 Catch:{ all -> 0x028c }
        goto L_0x0121;	 Catch:{ all -> 0x028c }
    L_0x0149:
        r6 = new com.google.android.gms.internal.zzcmd;	 Catch:{ all -> 0x028c }
        r6.<init>();	 Catch:{ all -> 0x028c }
        r7 = r5.size();	 Catch:{ all -> 0x028c }
        r7 = new com.google.android.gms.internal.zzcme[r7];	 Catch:{ all -> 0x028c }
        r6.f17971a = r7;	 Catch:{ all -> 0x028c }
        r7 = new java.util.ArrayList;	 Catch:{ all -> 0x028c }
        r9 = r5.size();	 Catch:{ all -> 0x028c }
        r7.<init>(r9);	 Catch:{ all -> 0x028c }
        r9 = com.google.android.gms.internal.zzcgn.m13484B();	 Catch:{ all -> 0x028c }
        if (r9 == 0) goto L_0x016f;	 Catch:{ all -> 0x028c }
    L_0x0165:
        r9 = r14.f6975b;	 Catch:{ all -> 0x028c }
        r9 = r9.m13495c(r4);	 Catch:{ all -> 0x028c }
        if (r9 == 0) goto L_0x016f;	 Catch:{ all -> 0x028c }
    L_0x016d:
        r9 = r0;	 Catch:{ all -> 0x028c }
        goto L_0x0170;	 Catch:{ all -> 0x028c }
    L_0x016f:
        r9 = r1;	 Catch:{ all -> 0x028c }
    L_0x0170:
        r10 = r1;	 Catch:{ all -> 0x028c }
    L_0x0171:
        r11 = r6.f17971a;	 Catch:{ all -> 0x028c }
        r11 = r11.length;	 Catch:{ all -> 0x028c }
        if (r10 >= r11) goto L_0x01bc;	 Catch:{ all -> 0x028c }
    L_0x0176:
        r11 = r6.f17971a;	 Catch:{ all -> 0x028c }
        r12 = r5.get(r10);	 Catch:{ all -> 0x028c }
        r12 = (android.util.Pair) r12;	 Catch:{ all -> 0x028c }
        r12 = r12.first;	 Catch:{ all -> 0x028c }
        r12 = (com.google.android.gms.internal.zzcme) r12;	 Catch:{ all -> 0x028c }
        r11[r10] = r12;	 Catch:{ all -> 0x028c }
        r11 = r5.get(r10);	 Catch:{ all -> 0x028c }
        r11 = (android.util.Pair) r11;	 Catch:{ all -> 0x028c }
        r11 = r11.second;	 Catch:{ all -> 0x028c }
        r11 = (java.lang.Long) r11;	 Catch:{ all -> 0x028c }
        r7.add(r11);	 Catch:{ all -> 0x028c }
        r11 = r6.f17971a;	 Catch:{ all -> 0x028c }
        r11 = r11[r10];	 Catch:{ all -> 0x028c }
        r12 = 11910; // 0x2e86 float:1.669E-41 double:5.8843E-320;	 Catch:{ all -> 0x028c }
        r12 = java.lang.Long.valueOf(r12);	 Catch:{ all -> 0x028c }
        r11.f17999r = r12;	 Catch:{ all -> 0x028c }
        r11 = r6.f17971a;	 Catch:{ all -> 0x028c }
        r11 = r11[r10];	 Catch:{ all -> 0x028c }
        r12 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x028c }
        r11.f17985d = r12;	 Catch:{ all -> 0x028c }
        r11 = r6.f17971a;	 Catch:{ all -> 0x028c }
        r11 = r11[r10];	 Catch:{ all -> 0x028c }
        r12 = java.lang.Boolean.valueOf(r1);	 Catch:{ all -> 0x028c }
        r11.f18007z = r12;	 Catch:{ all -> 0x028c }
        if (r9 != 0) goto L_0x01b9;	 Catch:{ all -> 0x028c }
    L_0x01b3:
        r11 = r6.f17971a;	 Catch:{ all -> 0x028c }
        r11 = r11[r10];	 Catch:{ all -> 0x028c }
        r11.f17979G = r8;	 Catch:{ all -> 0x028c }
    L_0x01b9:
        r10 = r10 + 1;	 Catch:{ all -> 0x028c }
        goto L_0x0171;	 Catch:{ all -> 0x028c }
    L_0x01bc:
        r5 = r14.m5754e();	 Catch:{ all -> 0x028c }
        r9 = 2;	 Catch:{ all -> 0x028c }
        r5 = r5.m18161a(r9);	 Catch:{ all -> 0x028c }
        if (r5 == 0) goto L_0x01cf;	 Catch:{ all -> 0x028c }
    L_0x01c7:
        r5 = r14.m5759j();	 Catch:{ all -> 0x028c }
        r8 = r5.m18127a(r6);	 Catch:{ all -> 0x028c }
    L_0x01cf:
        r5 = r14.m5758i();	 Catch:{ all -> 0x028c }
        r9 = r5.m18547a(r6);	 Catch:{ all -> 0x028c }
        r5 = com.google.android.gms.internal.zzchc.f6885s;	 Catch:{ all -> 0x028c }
        r5 = r5.f6893a;	 Catch:{ all -> 0x028c }
        r12 = r5;	 Catch:{ all -> 0x028c }
        r12 = (java.lang.String) r12;	 Catch:{ all -> 0x028c }
        r10 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x0254 }
        r10.<init>(r12);	 Catch:{ MalformedURLException -> 0x0254 }
        r5 = r7.isEmpty();	 Catch:{ MalformedURLException -> 0x0254 }
        r5 = r5 ^ r0;	 Catch:{ MalformedURLException -> 0x0254 }
        com.google.android.gms.common.internal.zzbq.m4817b(r5);	 Catch:{ MalformedURLException -> 0x0254 }
        r5 = r14.f6967I;	 Catch:{ MalformedURLException -> 0x0254 }
        if (r5 == 0) goto L_0x01fb;	 Catch:{ MalformedURLException -> 0x0254 }
    L_0x01ef:
        r5 = r14.m5754e();	 Catch:{ MalformedURLException -> 0x0254 }
        r5 = r5.f17816a;	 Catch:{ MalformedURLException -> 0x0254 }
        r7 = "Set uploading progress before finishing the previous upload";	 Catch:{ MalformedURLException -> 0x0254 }
        r5.m5693a(r7);	 Catch:{ MalformedURLException -> 0x0254 }
        goto L_0x0202;	 Catch:{ MalformedURLException -> 0x0254 }
    L_0x01fb:
        r5 = new java.util.ArrayList;	 Catch:{ MalformedURLException -> 0x0254 }
        r5.<init>(r7);	 Catch:{ MalformedURLException -> 0x0254 }
        r14.f6967I = r5;	 Catch:{ MalformedURLException -> 0x0254 }
    L_0x0202:
        r5 = r14.m5753d();	 Catch:{ MalformedURLException -> 0x0254 }
        r5 = r5.f17831d;	 Catch:{ MalformedURLException -> 0x0254 }
        r5.m5703a(r2);	 Catch:{ MalformedURLException -> 0x0254 }
        r2 = "?";	 Catch:{ MalformedURLException -> 0x0254 }
        r3 = r6.f17971a;	 Catch:{ MalformedURLException -> 0x0254 }
        r3 = r3.length;	 Catch:{ MalformedURLException -> 0x0254 }
        if (r3 <= 0) goto L_0x0218;	 Catch:{ MalformedURLException -> 0x0254 }
    L_0x0212:
        r2 = r6.f17971a;	 Catch:{ MalformedURLException -> 0x0254 }
        r2 = r2[r1];	 Catch:{ MalformedURLException -> 0x0254 }
        r2 = r2.f17996o;	 Catch:{ MalformedURLException -> 0x0254 }
    L_0x0218:
        r3 = r14.m5754e();	 Catch:{ MalformedURLException -> 0x0254 }
        r3 = r3.f17822g;	 Catch:{ MalformedURLException -> 0x0254 }
        r5 = "Uploading data. app, uncompressed size, data";	 Catch:{ MalformedURLException -> 0x0254 }
        r6 = r9.length;	 Catch:{ MalformedURLException -> 0x0254 }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ MalformedURLException -> 0x0254 }
        r3.m5696a(r5, r2, r6, r8);	 Catch:{ MalformedURLException -> 0x0254 }
        r14.f6972N = r0;	 Catch:{ MalformedURLException -> 0x0254 }
        r6 = r14.m5761l();	 Catch:{ MalformedURLException -> 0x0254 }
        r11 = new com.google.android.gms.internal.zzcip;	 Catch:{ MalformedURLException -> 0x0254 }
        r11.<init>(r14);	 Catch:{ MalformedURLException -> 0x0254 }
        r6.mo1811c();	 Catch:{ MalformedURLException -> 0x0254 }
        r6.m13545L();	 Catch:{ MalformedURLException -> 0x0254 }
        com.google.android.gms.common.internal.zzbq.m4808a(r10);	 Catch:{ MalformedURLException -> 0x0254 }
        com.google.android.gms.common.internal.zzbq.m4808a(r9);	 Catch:{ MalformedURLException -> 0x0254 }
        com.google.android.gms.common.internal.zzbq.m4808a(r11);	 Catch:{ MalformedURLException -> 0x0254 }
        r0 = r6.mo1827s();	 Catch:{ MalformedURLException -> 0x0254 }
        r2 = new com.google.android.gms.internal.zzchu;	 Catch:{ MalformedURLException -> 0x0254 }
        r3 = 0;	 Catch:{ MalformedURLException -> 0x0254 }
        r5 = r2;	 Catch:{ MalformedURLException -> 0x0254 }
        r7 = r4;	 Catch:{ MalformedURLException -> 0x0254 }
        r8 = r10;	 Catch:{ MalformedURLException -> 0x0254 }
        r10 = r3;	 Catch:{ MalformedURLException -> 0x0254 }
        r5.<init>(r6, r7, r8, r9, r10, r11);	 Catch:{ MalformedURLException -> 0x0254 }
        r0.m18274b(r2);	 Catch:{ MalformedURLException -> 0x0254 }
        goto L_0x0286;
    L_0x0254:
        r0 = r14.m5754e();	 Catch:{ all -> 0x028c }
        r0 = r0.f17816a;	 Catch:{ all -> 0x028c }
        r2 = "Failed to parse upload URL. Not uploading. appId";	 Catch:{ all -> 0x028c }
        r3 = com.google.android.gms.internal.zzchm.m18154a(r4);	 Catch:{ all -> 0x028c }
        r0.m5695a(r2, r3, r12);	 Catch:{ all -> 0x028c }
        goto L_0x0286;	 Catch:{ all -> 0x028c }
    L_0x0264:
        r14.f6969K = r6;	 Catch:{ all -> 0x028c }
        r0 = r14.m5760k();	 Catch:{ all -> 0x028c }
        r4 = com.google.android.gms.internal.zzcgn.m13486z();	 Catch:{ all -> 0x028c }
        r2 = r2 - r4;	 Catch:{ all -> 0x028c }
        r0 = r0.m17996a(r2);	 Catch:{ all -> 0x028c }
        r2 = android.text.TextUtils.isEmpty(r0);	 Catch:{ all -> 0x028c }
        if (r2 != 0) goto L_0x0286;	 Catch:{ all -> 0x028c }
    L_0x0279:
        r2 = r14.m5760k();	 Catch:{ all -> 0x028c }
        r0 = r2.m18008b(r0);	 Catch:{ all -> 0x028c }
        if (r0 == 0) goto L_0x0286;	 Catch:{ all -> 0x028c }
    L_0x0283:
        r14.m5721a(r0);	 Catch:{ all -> 0x028c }
    L_0x0286:
        r14.f6973O = r1;
        r14.m5717E();
        return;
    L_0x028c:
        r0 = move-exception;
        r14.f6973O = r1;
        r14.m5717E();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcim.u():void");
    }

    private final void m5721a(com.google.android.gms.internal.zzcgh r11) {
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
        r10 = this;
        r0 = r10.m5755f();
        r0.mo1811c();
        r0 = r11.m5627c();
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x001f;
    L_0x0011:
        r2 = r11.m5619a();
        r3 = 204; // 0xcc float:2.86E-43 double:1.01E-321;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r1 = r10;
        r1.m5744a(r2, r3, r4, r5, r6);
        return;
    L_0x001f:
        r0 = r11.m5627c();
        r1 = r11.m5623b();
        r2 = new android.net.Uri$Builder;
        r2.<init>();
        r3 = com.google.android.gms.internal.zzchc.f6873g;
        r3 = r3.f6893a;
        r3 = (java.lang.String) r3;
        r3 = r2.scheme(r3);
        r4 = com.google.android.gms.internal.zzchc.f6874h;
        r4 = r4.f6893a;
        r4 = (java.lang.String) r4;
        r3 = r3.encodedAuthority(r4);
        r4 = "config/app/";
        r0 = java.lang.String.valueOf(r0);
        r5 = r0.length();
        if (r5 == 0) goto L_0x0051;
    L_0x004c:
        r0 = r4.concat(r0);
        goto L_0x0056;
    L_0x0051:
        r0 = new java.lang.String;
        r0.<init>(r4);
    L_0x0056:
        r0 = r3.path(r0);
        r3 = "app_instance_id";
        r0 = r0.appendQueryParameter(r3, r1);
        r1 = "platform";
        r3 = "android";
        r0 = r0.appendQueryParameter(r1, r3);
        r1 = "gmp_version";
        r3 = "11910";
        r0.appendQueryParameter(r1, r3);
        r0 = r2.build();
        r0 = r0.toString();
        r4 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x00eb }
        r4.<init>(r0);	 Catch:{ MalformedURLException -> 0x00eb }
        r1 = r10.m5754e();	 Catch:{ MalformedURLException -> 0x00eb }
        r1 = r1.f17822g;	 Catch:{ MalformedURLException -> 0x00eb }
        r2 = "Fetching remote configuration";	 Catch:{ MalformedURLException -> 0x00eb }
        r3 = r11.m5619a();	 Catch:{ MalformedURLException -> 0x00eb }
        r1.m5694a(r2, r3);	 Catch:{ MalformedURLException -> 0x00eb }
        r1 = r10.m5756g();	 Catch:{ MalformedURLException -> 0x00eb }
        r2 = r11.m5619a();	 Catch:{ MalformedURLException -> 0x00eb }
        r1 = r1.m18229a(r2);	 Catch:{ MalformedURLException -> 0x00eb }
        r2 = 0;	 Catch:{ MalformedURLException -> 0x00eb }
        r3 = r10.m5756g();	 Catch:{ MalformedURLException -> 0x00eb }
        r5 = r11.m5619a();	 Catch:{ MalformedURLException -> 0x00eb }
        r3.mo1811c();	 Catch:{ MalformedURLException -> 0x00eb }
        r3 = r3.f17853b;	 Catch:{ MalformedURLException -> 0x00eb }
        r3 = r3.get(r5);	 Catch:{ MalformedURLException -> 0x00eb }
        r3 = (java.lang.String) r3;	 Catch:{ MalformedURLException -> 0x00eb }
        if (r1 == 0) goto L_0x00bf;	 Catch:{ MalformedURLException -> 0x00eb }
    L_0x00ad:
        r1 = android.text.TextUtils.isEmpty(r3);	 Catch:{ MalformedURLException -> 0x00eb }
        if (r1 != 0) goto L_0x00bf;	 Catch:{ MalformedURLException -> 0x00eb }
    L_0x00b3:
        r1 = new android.support.v4.util.ArrayMap;	 Catch:{ MalformedURLException -> 0x00eb }
        r1.<init>();	 Catch:{ MalformedURLException -> 0x00eb }
        r2 = "If-Modified-Since";	 Catch:{ MalformedURLException -> 0x00eb }
        r1.put(r2, r3);	 Catch:{ MalformedURLException -> 0x00eb }
        r6 = r1;	 Catch:{ MalformedURLException -> 0x00eb }
        goto L_0x00c0;	 Catch:{ MalformedURLException -> 0x00eb }
    L_0x00bf:
        r6 = r2;	 Catch:{ MalformedURLException -> 0x00eb }
    L_0x00c0:
        r1 = 1;	 Catch:{ MalformedURLException -> 0x00eb }
        r10.f6971M = r1;	 Catch:{ MalformedURLException -> 0x00eb }
        r2 = r10.m5761l();	 Catch:{ MalformedURLException -> 0x00eb }
        r3 = r11.m5619a();	 Catch:{ MalformedURLException -> 0x00eb }
        r7 = new com.google.android.gms.internal.zzciq;	 Catch:{ MalformedURLException -> 0x00eb }
        r7.<init>(r10);	 Catch:{ MalformedURLException -> 0x00eb }
        r2.mo1811c();	 Catch:{ MalformedURLException -> 0x00eb }
        r2.m13545L();	 Catch:{ MalformedURLException -> 0x00eb }
        com.google.android.gms.common.internal.zzbq.m4808a(r4);	 Catch:{ MalformedURLException -> 0x00eb }
        com.google.android.gms.common.internal.zzbq.m4808a(r7);	 Catch:{ MalformedURLException -> 0x00eb }
        r8 = r2.mo1827s();	 Catch:{ MalformedURLException -> 0x00eb }
        r9 = new com.google.android.gms.internal.zzchu;	 Catch:{ MalformedURLException -> 0x00eb }
        r5 = 0;	 Catch:{ MalformedURLException -> 0x00eb }
        r1 = r9;	 Catch:{ MalformedURLException -> 0x00eb }
        r1.<init>(r2, r3, r4, r5, r6, r7);	 Catch:{ MalformedURLException -> 0x00eb }
        r8.m18274b(r9);	 Catch:{ MalformedURLException -> 0x00eb }
        return;
    L_0x00eb:
        r1 = r10.m5754e();
        r1 = r1.f17816a;
        r2 = "Failed to parse config URL. Not fetching. appId";
        r11 = r11.m5619a();
        r11 = com.google.android.gms.internal.zzchm.m18154a(r11);
        r1.m5695a(r2, r11, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcim.a(com.google.android.gms.internal.zzcgh):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean m5726a(long r47) {
        /*
        r46 = this;
        r1 = r46;
        r2 = r46.m5760k();
        r2.m18022x();
        r2 = new com.google.android.gms.internal.zzcim$zza;	 Catch:{ all -> 0x09be }
        r3 = 0;
        r2.<init>();	 Catch:{ all -> 0x09be }
        r4 = r46.m5760k();	 Catch:{ all -> 0x09be }
        r5 = r1.f6969K;	 Catch:{ all -> 0x09be }
        com.google.android.gms.common.internal.zzbq.m4808a(r2);	 Catch:{ all -> 0x09be }
        r4.mo1811c();	 Catch:{ all -> 0x09be }
        r4.m13545L();	 Catch:{ all -> 0x09be }
        r7 = -1;
        r9 = 2;
        r10 = 0;
        r11 = 1;
        r15 = r4.m17987A();	 Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
        r12 = android.text.TextUtils.isEmpty(r10);	 Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
        if (r12 == 0) goto L_0x00a2;
    L_0x002d:
        r12 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
        if (r12 == 0) goto L_0x004a;
    L_0x0031:
        r13 = new java.lang.String[r9];	 Catch:{ SQLiteException -> 0x0045, all -> 0x0040 }
        r14 = java.lang.String.valueOf(r5);	 Catch:{ SQLiteException -> 0x0045, all -> 0x0040 }
        r13[r3] = r14;	 Catch:{ SQLiteException -> 0x0045, all -> 0x0040 }
        r14 = java.lang.String.valueOf(r47);	 Catch:{ SQLiteException -> 0x0045, all -> 0x0040 }
        r13[r11] = r14;	 Catch:{ SQLiteException -> 0x0045, all -> 0x0040 }
        goto L_0x0052;
    L_0x0040:
        r0 = move-exception;
        r2 = r0;
        r9 = r10;
        goto L_0x09b8;
    L_0x0045:
        r0 = move-exception;
        r5 = r0;
        r9 = r10;
        goto L_0x025f;
    L_0x004a:
        r13 = new java.lang.String[r11];	 Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
        r14 = java.lang.String.valueOf(r47);	 Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
        r13[r3] = r14;	 Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
    L_0x0052:
        if (r12 == 0) goto L_0x0057;
    L_0x0054:
        r12 = "rowid <= ? and ";
        goto L_0x0059;
    L_0x0057:
        r12 = "";
    L_0x0059:
        r14 = 148; // 0x94 float:2.07E-43 double:7.3E-322;
        r10 = java.lang.String.valueOf(r12);	 Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
        r10 = r10.length();	 Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
        r14 = r14 + r10;
        r10 = new java.lang.StringBuilder;	 Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
        r10.<init>(r14);	 Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
        r14 = "select app_id, metadata_fingerprint from raw_events where ";
        r10.append(r14);	 Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
        r10.append(r12);	 Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
        r12 = "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;";
        r10.append(r12);	 Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
        r10 = r10.toString();	 Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
        r10 = r15.rawQuery(r10, r13);	 Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
        r12 = r10.moveToFirst();	 Catch:{ SQLiteException -> 0x0252, all -> 0x0040 }
        if (r12 != 0) goto L_0x008b;
    L_0x0084:
        if (r10 == 0) goto L_0x0273;
    L_0x0086:
        r10.close();	 Catch:{ all -> 0x09be }
        goto L_0x0273;
    L_0x008b:
        r12 = r10.getString(r3);	 Catch:{ SQLiteException -> 0x0252, all -> 0x0040 }
        r13 = r10.getString(r11);	 Catch:{ SQLiteException -> 0x009c, all -> 0x0040 }
        r10.close();	 Catch:{ SQLiteException -> 0x009c, all -> 0x0040 }
        r22 = r10;
        r10 = r12;
        r21 = r13;
        goto L_0x00f9;
    L_0x009c:
        r0 = move-exception;
        r5 = r0;
        r9 = r10;
        r10 = r12;
        goto L_0x025f;
    L_0x00a2:
        r10 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
        if (r10 == 0) goto L_0x00b2;
    L_0x00a6:
        r12 = new java.lang.String[r9];	 Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
        r13 = 0;
        r12[r3] = r13;	 Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
        r13 = java.lang.String.valueOf(r5);	 Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
        r12[r11] = r13;	 Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
        goto L_0x00b8;
    L_0x00b2:
        r12 = 0;
        r13 = new java.lang.String[]{r12};	 Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
        r12 = r13;
    L_0x00b8:
        if (r10 == 0) goto L_0x00bd;
    L_0x00ba:
        r10 = " and rowid <= ?";
        goto L_0x00bf;
    L_0x00bd:
        r10 = "";
    L_0x00bf:
        r13 = 84;
        r14 = java.lang.String.valueOf(r10);	 Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
        r14 = r14.length();	 Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
        r13 = r13 + r14;
        r14 = new java.lang.StringBuilder;	 Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
        r14.<init>(r13);	 Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
        r13 = "select metadata_fingerprint from raw_events where app_id = ?";
        r14.append(r13);	 Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
        r14.append(r10);	 Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
        r10 = " order by rowid limit 1;";
        r14.append(r10);	 Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
        r10 = r14.toString();	 Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
        r10 = r15.rawQuery(r10, r12);	 Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
        r12 = r10.moveToFirst();	 Catch:{ SQLiteException -> 0x0252, all -> 0x0040 }
        if (r12 != 0) goto L_0x00ed;
    L_0x00ea:
        if (r10 == 0) goto L_0x0273;
    L_0x00ec:
        goto L_0x0086;
    L_0x00ed:
        r13 = r10.getString(r3);	 Catch:{ SQLiteException -> 0x0252, all -> 0x0040 }
        r10.close();	 Catch:{ SQLiteException -> 0x0252, all -> 0x0040 }
        r22 = r10;
        r21 = r13;
        r10 = 0;
    L_0x00f9:
        r13 = "raw_events_metadata";
        r12 = "metadata";
        r14 = new java.lang.String[]{r12};	 Catch:{ SQLiteException -> 0x024d, all -> 0x0247 }
        r16 = "app_id = ? and metadata_fingerprint = ?";
        r12 = new java.lang.String[r9];	 Catch:{ SQLiteException -> 0x024d, all -> 0x0247 }
        r12[r3] = r10;	 Catch:{ SQLiteException -> 0x024d, all -> 0x0247 }
        r12[r11] = r21;	 Catch:{ SQLiteException -> 0x024d, all -> 0x0247 }
        r17 = 0;
        r18 = 0;
        r19 = "rowid";
        r20 = "2";
        r23 = r12;
        r12 = r15;
        r24 = r15;
        r15 = r16;
        r16 = r23;
        r15 = r12.query(r13, r14, r15, r16, r17, r18, r19, r20);	 Catch:{ SQLiteException -> 0x024d, all -> 0x0247 }
        r12 = r15.moveToFirst();	 Catch:{ SQLiteException -> 0x0243, all -> 0x023f }
        if (r12 != 0) goto L_0x0144;
    L_0x0124:
        r5 = r4.mo1828t();	 Catch:{ SQLiteException -> 0x013f, all -> 0x013a }
        r5 = r5.f17816a;	 Catch:{ SQLiteException -> 0x013f, all -> 0x013a }
        r6 = "Raw event metadata record is missing. appId";
        r12 = com.google.android.gms.internal.zzchm.m18154a(r10);	 Catch:{ SQLiteException -> 0x013f, all -> 0x013a }
        r5.m5694a(r6, r12);	 Catch:{ SQLiteException -> 0x013f, all -> 0x013a }
        if (r15 == 0) goto L_0x0273;
    L_0x0135:
        r15.close();	 Catch:{ all -> 0x09be }
        goto L_0x0273;
    L_0x013a:
        r0 = move-exception;
        r2 = r0;
        r9 = r15;
        goto L_0x09b8;
    L_0x013f:
        r0 = move-exception;
        r5 = r0;
        r9 = r15;
        goto L_0x025f;
    L_0x0144:
        r12 = r15.getBlob(r3);	 Catch:{ SQLiteException -> 0x0243, all -> 0x023f }
        r13 = r12.length;	 Catch:{ SQLiteException -> 0x0243, all -> 0x023f }
        r12 = com.google.android.gms.internal.zzfjj.m6130a(r12, r13);	 Catch:{ SQLiteException -> 0x0243, all -> 0x023f }
        r13 = new com.google.android.gms.internal.zzcme;	 Catch:{ SQLiteException -> 0x0243, all -> 0x023f }
        r13.<init>();	 Catch:{ SQLiteException -> 0x0243, all -> 0x023f }
        r13.mo3478a(r12);	 Catch:{ IOException -> 0x0226 }
        r12 = r15.moveToNext();	 Catch:{ SQLiteException -> 0x0243, all -> 0x023f }
        if (r12 == 0) goto L_0x016a;
    L_0x015b:
        r12 = r4.mo1828t();	 Catch:{ SQLiteException -> 0x013f, all -> 0x013a }
        r12 = r12.f17818c;	 Catch:{ SQLiteException -> 0x013f, all -> 0x013a }
        r14 = "Get multiple raw event metadata records, expected one. appId";
        r9 = com.google.android.gms.internal.zzchm.m18154a(r10);	 Catch:{ SQLiteException -> 0x013f, all -> 0x013a }
        r12.m5694a(r14, r9);	 Catch:{ SQLiteException -> 0x013f, all -> 0x013a }
    L_0x016a:
        r15.close();	 Catch:{ SQLiteException -> 0x0243, all -> 0x023f }
        r2.mo1847a(r13);	 Catch:{ SQLiteException -> 0x0243, all -> 0x023f }
        r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
        r14 = 3;
        if (r9 == 0) goto L_0x0188;
    L_0x0175:
        r9 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?";
        r12 = new java.lang.String[r14];	 Catch:{ SQLiteException -> 0x013f, all -> 0x013a }
        r12[r3] = r10;	 Catch:{ SQLiteException -> 0x013f, all -> 0x013a }
        r12[r11] = r21;	 Catch:{ SQLiteException -> 0x013f, all -> 0x013a }
        r5 = java.lang.String.valueOf(r5);	 Catch:{ SQLiteException -> 0x013f, all -> 0x013a }
        r6 = 2;
        r12[r6] = r5;	 Catch:{ SQLiteException -> 0x013f, all -> 0x013a }
        r5 = r9;
        r16 = r12;
        goto L_0x0193;
    L_0x0188:
        r5 = "app_id = ? and metadata_fingerprint = ?";
        r6 = 2;
        r9 = new java.lang.String[r6];	 Catch:{ SQLiteException -> 0x0243, all -> 0x023f }
        r9[r3] = r10;	 Catch:{ SQLiteException -> 0x0243, all -> 0x023f }
        r9[r11] = r21;	 Catch:{ SQLiteException -> 0x0243, all -> 0x023f }
        r16 = r9;
    L_0x0193:
        r13 = "raw_events";
        r6 = "rowid";
        r9 = "name";
        r12 = "timestamp";
        r14 = "data";
        r14 = new java.lang.String[]{r6, r9, r12, r14};	 Catch:{ SQLiteException -> 0x0243, all -> 0x023f }
        r17 = 0;
        r18 = 0;
        r19 = "rowid";
        r20 = 0;
        r12 = r24;
        r6 = 3;
        r9 = r15;
        r15 = r5;
        r5 = r12.query(r13, r14, r15, r16, r17, r18, r19, r20);	 Catch:{ SQLiteException -> 0x023d }
        r9 = r5.moveToFirst();	 Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
        if (r9 != 0) goto L_0x01ce;
    L_0x01b8:
        r6 = r4.mo1828t();	 Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
        r6 = r6.f17818c;	 Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
        r9 = "Raw event data disappeared while in transaction. appId";
        r12 = com.google.android.gms.internal.zzchm.m18154a(r10);	 Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
        r6.m5694a(r9, r12);	 Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
        if (r5 == 0) goto L_0x0273;
    L_0x01c9:
        r5.close();	 Catch:{ all -> 0x09be }
        goto L_0x0273;
    L_0x01ce:
        r12 = r5.getLong(r3);	 Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
        r9 = r5.getBlob(r6);	 Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
        r14 = r9.length;	 Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
        r9 = com.google.android.gms.internal.zzfjj.m6130a(r9, r14);	 Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
        r14 = new com.google.android.gms.internal.zzcmb;	 Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
        r14.<init>();	 Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
        r14.mo3478a(r9);	 Catch:{ IOException -> 0x0201 }
        r9 = r5.getString(r11);	 Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
        r14.f17961b = r9;	 Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
        r9 = 2;
        r6 = r5.getLong(r9);	 Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
        r6 = java.lang.Long.valueOf(r6);	 Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
        r14.f17962c = r6;	 Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
        r6 = r2.mo1848a(r12, r14);	 Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
        if (r6 != 0) goto L_0x0211;
    L_0x01fa:
        if (r5 == 0) goto L_0x0273;
    L_0x01fc:
        r5.close();	 Catch:{ all -> 0x09be }
        goto L_0x0273;
    L_0x0201:
        r0 = move-exception;
        r6 = r4.mo1828t();	 Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
        r6 = r6.f17816a;	 Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
        r7 = "Data loss. Failed to merge raw event. appId";
        r8 = com.google.android.gms.internal.zzchm.m18154a(r10);	 Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
        r6.m5695a(r7, r8, r0);	 Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
    L_0x0211:
        r6 = r5.moveToNext();	 Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
        if (r6 != 0) goto L_0x021a;
    L_0x0217:
        if (r5 == 0) goto L_0x0273;
    L_0x0219:
        goto L_0x01fc;
    L_0x021a:
        r6 = 3;
        r7 = -1;
        goto L_0x01ce;
    L_0x021e:
        r0 = move-exception;
        r2 = r0;
        r9 = r5;
        goto L_0x09b8;
    L_0x0223:
        r0 = move-exception;
        r9 = r5;
        goto L_0x0245;
    L_0x0226:
        r0 = move-exception;
        r9 = r15;
        r5 = r4.mo1828t();	 Catch:{ SQLiteException -> 0x023d }
        r5 = r5.f17816a;	 Catch:{ SQLiteException -> 0x023d }
        r6 = "Data loss. Failed to merge raw event metadata. appId";
        r7 = com.google.android.gms.internal.zzchm.m18154a(r10);	 Catch:{ SQLiteException -> 0x023d }
        r5.m5695a(r6, r7, r0);	 Catch:{ SQLiteException -> 0x023d }
        if (r9 == 0) goto L_0x0273;
    L_0x0239:
        r9.close();	 Catch:{ all -> 0x09be }
        goto L_0x0273;
    L_0x023d:
        r0 = move-exception;
        goto L_0x0245;
    L_0x023f:
        r0 = move-exception;
        r9 = r15;
        goto L_0x09b7;
    L_0x0243:
        r0 = move-exception;
        r9 = r15;
    L_0x0245:
        r5 = r0;
        goto L_0x025f;
    L_0x0247:
        r0 = move-exception;
        r2 = r0;
        r9 = r22;
        goto L_0x09b8;
    L_0x024d:
        r0 = move-exception;
        r5 = r0;
        r9 = r22;
        goto L_0x025f;
    L_0x0252:
        r0 = move-exception;
        r5 = r0;
        r9 = r10;
        goto L_0x025e;
    L_0x0256:
        r0 = move-exception;
        r2 = r0;
        r9 = 0;
        goto L_0x09b8;
    L_0x025b:
        r0 = move-exception;
        r5 = r0;
        r9 = 0;
    L_0x025e:
        r10 = 0;
    L_0x025f:
        r4 = r4.mo1828t();	 Catch:{ all -> 0x09b6 }
        r4 = r4.f17816a;	 Catch:{ all -> 0x09b6 }
        r6 = "Data loss. Error selecting raw event. appId";
        r7 = com.google.android.gms.internal.zzchm.m18154a(r10);	 Catch:{ all -> 0x09b6 }
        r4.m5695a(r6, r7, r5);	 Catch:{ all -> 0x09b6 }
        if (r9 == 0) goto L_0x0273;
    L_0x0270:
        r9.close();	 Catch:{ all -> 0x09be }
    L_0x0273:
        r4 = r2.f14235c;	 Catch:{ all -> 0x09be }
        if (r4 == 0) goto L_0x0282;
    L_0x0277:
        r4 = r2.f14235c;	 Catch:{ all -> 0x09be }
        r4 = r4.isEmpty();	 Catch:{ all -> 0x09be }
        if (r4 == 0) goto L_0x0280;
    L_0x027f:
        goto L_0x0282;
    L_0x0280:
        r4 = r3;
        goto L_0x0283;
    L_0x0282:
        r4 = r11;
    L_0x0283:
        if (r4 != 0) goto L_0x09a6;
    L_0x0285:
        r4 = r2.f14233a;	 Catch:{ all -> 0x09be }
        r5 = r2.f14235c;	 Catch:{ all -> 0x09be }
        r5 = r5.size();	 Catch:{ all -> 0x09be }
        r5 = new com.google.android.gms.internal.zzcmb[r5];	 Catch:{ all -> 0x09be }
        r4.f17983b = r5;	 Catch:{ all -> 0x09be }
        r5 = r3;
        r6 = r5;
        r7 = r6;
    L_0x0294:
        r8 = r2.f14235c;	 Catch:{ all -> 0x09be }
        r8 = r8.size();	 Catch:{ all -> 0x09be }
        if (r5 >= r8) goto L_0x058f;
    L_0x029c:
        r8 = r46.m5756g();	 Catch:{ all -> 0x09be }
        r12 = r2.f14233a;	 Catch:{ all -> 0x09be }
        r12 = r12.f17996o;	 Catch:{ all -> 0x09be }
        r13 = r2.f14235c;	 Catch:{ all -> 0x09be }
        r13 = r13.get(r5);	 Catch:{ all -> 0x09be }
        r13 = (com.google.android.gms.internal.zzcmb) r13;	 Catch:{ all -> 0x09be }
        r13 = r13.f17961b;	 Catch:{ all -> 0x09be }
        r8 = r8.m18234b(r12, r13);	 Catch:{ all -> 0x09be }
        if (r8 == 0) goto L_0x0324;
    L_0x02b4:
        r8 = r46.m5754e();	 Catch:{ all -> 0x09be }
        r8 = r8.f17818c;	 Catch:{ all -> 0x09be }
        r9 = "Dropping blacklisted raw event. appId";
        r10 = r2.f14233a;	 Catch:{ all -> 0x09be }
        r10 = r10.f17996o;	 Catch:{ all -> 0x09be }
        r10 = com.google.android.gms.internal.zzchm.m18154a(r10);	 Catch:{ all -> 0x09be }
        r12 = r46.m5759j();	 Catch:{ all -> 0x09be }
        r13 = r2.f14235c;	 Catch:{ all -> 0x09be }
        r13 = r13.get(r5);	 Catch:{ all -> 0x09be }
        r13 = (com.google.android.gms.internal.zzcmb) r13;	 Catch:{ all -> 0x09be }
        r13 = r13.f17961b;	 Catch:{ all -> 0x09be }
        r12 = r12.m18128a(r13);	 Catch:{ all -> 0x09be }
        r8.m5695a(r9, r10, r12);	 Catch:{ all -> 0x09be }
        r8 = r46.m5758i();	 Catch:{ all -> 0x09be }
        r9 = r2.f14233a;	 Catch:{ all -> 0x09be }
        r9 = r9.f17996o;	 Catch:{ all -> 0x09be }
        r8 = r8.m18569k(r9);	 Catch:{ all -> 0x09be }
        if (r8 != 0) goto L_0x02f8;
    L_0x02e7:
        r8 = r46.m5758i();	 Catch:{ all -> 0x09be }
        r9 = r2.f14233a;	 Catch:{ all -> 0x09be }
        r9 = r9.f17996o;	 Catch:{ all -> 0x09be }
        r8 = r8.m18571l(r9);	 Catch:{ all -> 0x09be }
        if (r8 == 0) goto L_0x02f6;
    L_0x02f5:
        goto L_0x02f8;
    L_0x02f6:
        r8 = r3;
        goto L_0x02f9;
    L_0x02f8:
        r8 = r11;
    L_0x02f9:
        if (r8 != 0) goto L_0x0589;
    L_0x02fb:
        r8 = "_err";
        r9 = r2.f14235c;	 Catch:{ all -> 0x09be }
        r9 = r9.get(r5);	 Catch:{ all -> 0x09be }
        r9 = (com.google.android.gms.internal.zzcmb) r9;	 Catch:{ all -> 0x09be }
        r9 = r9.f17961b;	 Catch:{ all -> 0x09be }
        r8 = r8.equals(r9);	 Catch:{ all -> 0x09be }
        if (r8 != 0) goto L_0x0589;
    L_0x030d:
        r8 = r46.m5758i();	 Catch:{ all -> 0x09be }
        r9 = 11;
        r10 = "_ev";
        r12 = r2.f14235c;	 Catch:{ all -> 0x09be }
        r12 = r12.get(r5);	 Catch:{ all -> 0x09be }
        r12 = (com.google.android.gms.internal.zzcmb) r12;	 Catch:{ all -> 0x09be }
        r12 = r12.f17961b;	 Catch:{ all -> 0x09be }
        r8.m18553b(r9, r10, r12, r3);	 Catch:{ all -> 0x09be }
        goto L_0x0589;
    L_0x0324:
        r8 = r46.m5756g();	 Catch:{ all -> 0x09be }
        r12 = r2.f14233a;	 Catch:{ all -> 0x09be }
        r12 = r12.f17996o;	 Catch:{ all -> 0x09be }
        r13 = r2.f14235c;	 Catch:{ all -> 0x09be }
        r13 = r13.get(r5);	 Catch:{ all -> 0x09be }
        r13 = (com.google.android.gms.internal.zzcmb) r13;	 Catch:{ all -> 0x09be }
        r13 = r13.f17961b;	 Catch:{ all -> 0x09be }
        r8 = r8.m18236c(r12, r13);	 Catch:{ all -> 0x09be }
        if (r8 != 0) goto L_0x034f;
    L_0x033c:
        r46.m5758i();	 Catch:{ all -> 0x09be }
        r12 = r2.f14235c;	 Catch:{ all -> 0x09be }
        r12 = r12.get(r5);	 Catch:{ all -> 0x09be }
        r12 = (com.google.android.gms.internal.zzcmb) r12;	 Catch:{ all -> 0x09be }
        r12 = r12.f17961b;	 Catch:{ all -> 0x09be }
        r12 = com.google.android.gms.internal.zzclq.m18529m(r12);	 Catch:{ all -> 0x09be }
        if (r12 == 0) goto L_0x057a;
    L_0x034f:
        r12 = r2.f14235c;	 Catch:{ all -> 0x09be }
        r12 = r12.get(r5);	 Catch:{ all -> 0x09be }
        r12 = (com.google.android.gms.internal.zzcmb) r12;	 Catch:{ all -> 0x09be }
        r12 = r12.f17960a;	 Catch:{ all -> 0x09be }
        if (r12 != 0) goto L_0x0367;
    L_0x035b:
        r12 = r2.f14235c;	 Catch:{ all -> 0x09be }
        r12 = r12.get(r5);	 Catch:{ all -> 0x09be }
        r12 = (com.google.android.gms.internal.zzcmb) r12;	 Catch:{ all -> 0x09be }
        r13 = new com.google.android.gms.internal.zzcmc[r3];	 Catch:{ all -> 0x09be }
        r12.f17960a = r13;	 Catch:{ all -> 0x09be }
    L_0x0367:
        r12 = r2.f14235c;	 Catch:{ all -> 0x09be }
        r12 = r12.get(r5);	 Catch:{ all -> 0x09be }
        r12 = (com.google.android.gms.internal.zzcmb) r12;	 Catch:{ all -> 0x09be }
        r12 = r12.f17960a;	 Catch:{ all -> 0x09be }
        r13 = r12.length;	 Catch:{ all -> 0x09be }
        r14 = r3;
        r15 = r14;
        r16 = r15;
    L_0x0376:
        if (r14 >= r13) goto L_0x03a7;
    L_0x0378:
        r3 = r12[r14];	 Catch:{ all -> 0x09be }
        r11 = "_c";
        r9 = r3.f17966a;	 Catch:{ all -> 0x09be }
        r9 = r11.equals(r9);	 Catch:{ all -> 0x09be }
        if (r9 == 0) goto L_0x038e;
    L_0x0384:
        r9 = 1;
        r11 = java.lang.Long.valueOf(r9);	 Catch:{ all -> 0x09be }
        r3.f17968c = r11;	 Catch:{ all -> 0x09be }
        r15 = 1;
        goto L_0x03a2;
    L_0x038e:
        r9 = "_r";
        r10 = r3.f17966a;	 Catch:{ all -> 0x09be }
        r9 = r9.equals(r10);	 Catch:{ all -> 0x09be }
        if (r9 == 0) goto L_0x03a2;
    L_0x0398:
        r9 = 1;
        r11 = java.lang.Long.valueOf(r9);	 Catch:{ all -> 0x09be }
        r3.f17968c = r11;	 Catch:{ all -> 0x09be }
        r16 = 1;
    L_0x03a2:
        r14 = r14 + 1;
        r3 = 0;
        r11 = 1;
        goto L_0x0376;
    L_0x03a7:
        if (r15 != 0) goto L_0x0405;
    L_0x03a9:
        if (r8 == 0) goto L_0x0405;
    L_0x03ab:
        r3 = r46.m5754e();	 Catch:{ all -> 0x09be }
        r3 = r3.f17822g;	 Catch:{ all -> 0x09be }
        r9 = "Marking event as conversion";
        r10 = r46.m5759j();	 Catch:{ all -> 0x09be }
        r11 = r2.f14235c;	 Catch:{ all -> 0x09be }
        r11 = r11.get(r5);	 Catch:{ all -> 0x09be }
        r11 = (com.google.android.gms.internal.zzcmb) r11;	 Catch:{ all -> 0x09be }
        r11 = r11.f17961b;	 Catch:{ all -> 0x09be }
        r10 = r10.m18128a(r11);	 Catch:{ all -> 0x09be }
        r3.m5694a(r9, r10);	 Catch:{ all -> 0x09be }
        r3 = r2.f14235c;	 Catch:{ all -> 0x09be }
        r3 = r3.get(r5);	 Catch:{ all -> 0x09be }
        r3 = (com.google.android.gms.internal.zzcmb) r3;	 Catch:{ all -> 0x09be }
        r3 = r3.f17960a;	 Catch:{ all -> 0x09be }
        r9 = r2.f14235c;	 Catch:{ all -> 0x09be }
        r9 = r9.get(r5);	 Catch:{ all -> 0x09be }
        r9 = (com.google.android.gms.internal.zzcmb) r9;	 Catch:{ all -> 0x09be }
        r9 = r9.f17960a;	 Catch:{ all -> 0x09be }
        r9 = r9.length;	 Catch:{ all -> 0x09be }
        r10 = 1;
        r9 = r9 + r10;
        r3 = java.util.Arrays.copyOf(r3, r9);	 Catch:{ all -> 0x09be }
        r3 = (com.google.android.gms.internal.zzcmc[]) r3;	 Catch:{ all -> 0x09be }
        r9 = new com.google.android.gms.internal.zzcmc;	 Catch:{ all -> 0x09be }
        r9.<init>();	 Catch:{ all -> 0x09be }
        r10 = "_c";
        r9.f17966a = r10;	 Catch:{ all -> 0x09be }
        r10 = 1;
        r12 = java.lang.Long.valueOf(r10);	 Catch:{ all -> 0x09be }
        r9.f17968c = r12;	 Catch:{ all -> 0x09be }
        r10 = r3.length;	 Catch:{ all -> 0x09be }
        r11 = 1;
        r10 = r10 - r11;
        r3[r10] = r9;	 Catch:{ all -> 0x09be }
        r9 = r2.f14235c;	 Catch:{ all -> 0x09be }
        r9 = r9.get(r5);	 Catch:{ all -> 0x09be }
        r9 = (com.google.android.gms.internal.zzcmb) r9;	 Catch:{ all -> 0x09be }
        r9.f17960a = r3;	 Catch:{ all -> 0x09be }
    L_0x0405:
        if (r16 != 0) goto L_0x0461;
    L_0x0407:
        r3 = r46.m5754e();	 Catch:{ all -> 0x09be }
        r3 = r3.f17822g;	 Catch:{ all -> 0x09be }
        r9 = "Marking event as real-time";
        r10 = r46.m5759j();	 Catch:{ all -> 0x09be }
        r11 = r2.f14235c;	 Catch:{ all -> 0x09be }
        r11 = r11.get(r5);	 Catch:{ all -> 0x09be }
        r11 = (com.google.android.gms.internal.zzcmb) r11;	 Catch:{ all -> 0x09be }
        r11 = r11.f17961b;	 Catch:{ all -> 0x09be }
        r10 = r10.m18128a(r11);	 Catch:{ all -> 0x09be }
        r3.m5694a(r9, r10);	 Catch:{ all -> 0x09be }
        r3 = r2.f14235c;	 Catch:{ all -> 0x09be }
        r3 = r3.get(r5);	 Catch:{ all -> 0x09be }
        r3 = (com.google.android.gms.internal.zzcmb) r3;	 Catch:{ all -> 0x09be }
        r3 = r3.f17960a;	 Catch:{ all -> 0x09be }
        r9 = r2.f14235c;	 Catch:{ all -> 0x09be }
        r9 = r9.get(r5);	 Catch:{ all -> 0x09be }
        r9 = (com.google.android.gms.internal.zzcmb) r9;	 Catch:{ all -> 0x09be }
        r9 = r9.f17960a;	 Catch:{ all -> 0x09be }
        r9 = r9.length;	 Catch:{ all -> 0x09be }
        r10 = 1;
        r9 = r9 + r10;
        r3 = java.util.Arrays.copyOf(r3, r9);	 Catch:{ all -> 0x09be }
        r3 = (com.google.android.gms.internal.zzcmc[]) r3;	 Catch:{ all -> 0x09be }
        r9 = new com.google.android.gms.internal.zzcmc;	 Catch:{ all -> 0x09be }
        r9.<init>();	 Catch:{ all -> 0x09be }
        r10 = "_r";
        r9.f17966a = r10;	 Catch:{ all -> 0x09be }
        r10 = 1;
        r10 = java.lang.Long.valueOf(r10);	 Catch:{ all -> 0x09be }
        r9.f17968c = r10;	 Catch:{ all -> 0x09be }
        r10 = r3.length;	 Catch:{ all -> 0x09be }
        r11 = 1;
        r10 = r10 - r11;
        r3[r10] = r9;	 Catch:{ all -> 0x09be }
        r9 = r2.f14235c;	 Catch:{ all -> 0x09be }
        r9 = r9.get(r5);	 Catch:{ all -> 0x09be }
        r9 = (com.google.android.gms.internal.zzcmb) r9;	 Catch:{ all -> 0x09be }
        r9.f17960a = r3;	 Catch:{ all -> 0x09be }
    L_0x0461:
        r10 = r46.m5760k();	 Catch:{ all -> 0x09be }
        r11 = r46.m5714B();	 Catch:{ all -> 0x09be }
        r3 = r2.f14233a;	 Catch:{ all -> 0x09be }
        r13 = r3.f17996o;	 Catch:{ all -> 0x09be }
        r14 = 0;
        r15 = 0;
        r16 = 0;
        r17 = 0;
        r18 = 1;
        r3 = r10.m17994a(r11, r13, r14, r15, r16, r17, r18);	 Catch:{ all -> 0x09be }
        r9 = r3.f6827e;	 Catch:{ all -> 0x09be }
        r3 = r1.f6975b;	 Catch:{ all -> 0x09be }
        r11 = r2.f14233a;	 Catch:{ all -> 0x09be }
        r11 = r11.f17996o;	 Catch:{ all -> 0x09be }
        r3 = r3.m13488a(r11);	 Catch:{ all -> 0x09be }
        r11 = (long) r3;	 Catch:{ all -> 0x09be }
        r3 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1));
        if (r3 <= 0) goto L_0x04c7;
    L_0x048a:
        r3 = r2.f14235c;	 Catch:{ all -> 0x09be }
        r3 = r3.get(r5);	 Catch:{ all -> 0x09be }
        r3 = (com.google.android.gms.internal.zzcmb) r3;	 Catch:{ all -> 0x09be }
        r9 = 0;
    L_0x0493:
        r10 = r3.f17960a;	 Catch:{ all -> 0x09be }
        r10 = r10.length;	 Catch:{ all -> 0x09be }
        if (r9 >= r10) goto L_0x04c8;
    L_0x0498:
        r10 = "_r";
        r11 = r3.f17960a;	 Catch:{ all -> 0x09be }
        r11 = r11[r9];	 Catch:{ all -> 0x09be }
        r11 = r11.f17966a;	 Catch:{ all -> 0x09be }
        r10 = r10.equals(r11);	 Catch:{ all -> 0x09be }
        if (r10 == 0) goto L_0x04c4;
    L_0x04a6:
        r10 = r3.f17960a;	 Catch:{ all -> 0x09be }
        r10 = r10.length;	 Catch:{ all -> 0x09be }
        r11 = 1;
        r10 = r10 - r11;
        r10 = new com.google.android.gms.internal.zzcmc[r10];	 Catch:{ all -> 0x09be }
        if (r9 <= 0) goto L_0x04b5;
    L_0x04af:
        r11 = r3.f17960a;	 Catch:{ all -> 0x09be }
        r12 = 0;
        java.lang.System.arraycopy(r11, r12, r10, r12, r9);	 Catch:{ all -> 0x09be }
    L_0x04b5:
        r11 = r10.length;	 Catch:{ all -> 0x09be }
        if (r9 >= r11) goto L_0x04c1;
    L_0x04b8:
        r11 = r3.f17960a;	 Catch:{ all -> 0x09be }
        r12 = r9 + 1;
        r13 = r10.length;	 Catch:{ all -> 0x09be }
        r13 = r13 - r9;
        java.lang.System.arraycopy(r11, r12, r10, r9, r13);	 Catch:{ all -> 0x09be }
    L_0x04c1:
        r3.f17960a = r10;	 Catch:{ all -> 0x09be }
        goto L_0x04c8;
    L_0x04c4:
        r9 = r9 + 1;
        goto L_0x0493;
    L_0x04c7:
        r6 = 1;
    L_0x04c8:
        r3 = r2.f14235c;	 Catch:{ all -> 0x09be }
        r3 = r3.get(r5);	 Catch:{ all -> 0x09be }
        r3 = (com.google.android.gms.internal.zzcmb) r3;	 Catch:{ all -> 0x09be }
        r3 = r3.f17961b;	 Catch:{ all -> 0x09be }
        r3 = com.google.android.gms.internal.zzclq.m18513a(r3);	 Catch:{ all -> 0x09be }
        if (r3 == 0) goto L_0x057a;
    L_0x04d8:
        if (r8 == 0) goto L_0x057a;
    L_0x04da:
        r9 = r46.m5760k();	 Catch:{ all -> 0x09be }
        r10 = r46.m5714B();	 Catch:{ all -> 0x09be }
        r3 = r2.f14233a;	 Catch:{ all -> 0x09be }
        r12 = r3.f17996o;	 Catch:{ all -> 0x09be }
        r13 = 0;
        r14 = 0;
        r15 = 1;
        r16 = 0;
        r17 = 0;
        r3 = r9.m17994a(r10, r12, r13, r14, r15, r16, r17);	 Catch:{ all -> 0x09be }
        r8 = r3.f6825c;	 Catch:{ all -> 0x09be }
        r3 = r1.f6975b;	 Catch:{ all -> 0x09be }
        r10 = r2.f14233a;	 Catch:{ all -> 0x09be }
        r10 = r10.f17996o;	 Catch:{ all -> 0x09be }
        r11 = com.google.android.gms.internal.zzchc.f6882p;	 Catch:{ all -> 0x09be }
        r3 = r3.m13491b(r10, r11);	 Catch:{ all -> 0x09be }
        r10 = (long) r3;	 Catch:{ all -> 0x09be }
        r3 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r3 <= 0) goto L_0x057a;
    L_0x0504:
        r3 = r46.m5754e();	 Catch:{ all -> 0x09be }
        r3 = r3.f17818c;	 Catch:{ all -> 0x09be }
        r8 = "Too many conversions. Not logging as conversion. appId";
        r9 = r2.f14233a;	 Catch:{ all -> 0x09be }
        r9 = r9.f17996o;	 Catch:{ all -> 0x09be }
        r9 = com.google.android.gms.internal.zzchm.m18154a(r9);	 Catch:{ all -> 0x09be }
        r3.m5694a(r8, r9);	 Catch:{ all -> 0x09be }
        r3 = r2.f14235c;	 Catch:{ all -> 0x09be }
        r3 = r3.get(r5);	 Catch:{ all -> 0x09be }
        r3 = (com.google.android.gms.internal.zzcmb) r3;	 Catch:{ all -> 0x09be }
        r8 = r3.f17960a;	 Catch:{ all -> 0x09be }
        r9 = r8.length;	 Catch:{ all -> 0x09be }
        r10 = 0;
        r11 = 0;
        r12 = 0;
    L_0x0525:
        if (r10 >= r9) goto L_0x0543;
    L_0x0527:
        r13 = r8[r10];	 Catch:{ all -> 0x09be }
        r14 = "_c";
        r15 = r13.f17966a;	 Catch:{ all -> 0x09be }
        r14 = r14.equals(r15);	 Catch:{ all -> 0x09be }
        if (r14 == 0) goto L_0x0535;
    L_0x0533:
        r12 = r13;
        goto L_0x0540;
    L_0x0535:
        r14 = "_err";
        r13 = r13.f17966a;	 Catch:{ all -> 0x09be }
        r13 = r14.equals(r13);	 Catch:{ all -> 0x09be }
        if (r13 == 0) goto L_0x0540;
    L_0x053f:
        r11 = 1;
    L_0x0540:
        r10 = r10 + 1;
        goto L_0x0525;
    L_0x0543:
        if (r11 == 0) goto L_0x0558;
    L_0x0545:
        if (r12 == 0) goto L_0x0558;
    L_0x0547:
        r8 = r3.f17960a;	 Catch:{ all -> 0x09be }
        r9 = 1;
        r10 = new com.google.android.gms.internal.zzcmc[r9];	 Catch:{ all -> 0x09be }
        r9 = 0;
        r10[r9] = r12;	 Catch:{ all -> 0x09be }
        r8 = com.google.android.gms.common.util.zza.m4892a(r8, r10);	 Catch:{ all -> 0x09be }
        r8 = (com.google.android.gms.internal.zzcmc[]) r8;	 Catch:{ all -> 0x09be }
        r3.f17960a = r8;	 Catch:{ all -> 0x09be }
        goto L_0x057a;
    L_0x0558:
        if (r12 == 0) goto L_0x0567;
    L_0x055a:
        r3 = "_err";
        r12.f17966a = r3;	 Catch:{ all -> 0x09be }
        r8 = 10;
        r3 = java.lang.Long.valueOf(r8);	 Catch:{ all -> 0x09be }
        r12.f17968c = r3;	 Catch:{ all -> 0x09be }
        goto L_0x057a;
    L_0x0567:
        r3 = r46.m5754e();	 Catch:{ all -> 0x09be }
        r3 = r3.f17816a;	 Catch:{ all -> 0x09be }
        r8 = "Did not find conversion parameter. appId";
        r9 = r2.f14233a;	 Catch:{ all -> 0x09be }
        r9 = r9.f17996o;	 Catch:{ all -> 0x09be }
        r9 = com.google.android.gms.internal.zzchm.m18154a(r9);	 Catch:{ all -> 0x09be }
        r3.m5694a(r8, r9);	 Catch:{ all -> 0x09be }
    L_0x057a:
        r3 = r4.f17983b;	 Catch:{ all -> 0x09be }
        r8 = r7 + 1;
        r9 = r2.f14235c;	 Catch:{ all -> 0x09be }
        r9 = r9.get(r5);	 Catch:{ all -> 0x09be }
        r9 = (com.google.android.gms.internal.zzcmb) r9;	 Catch:{ all -> 0x09be }
        r3[r7] = r9;	 Catch:{ all -> 0x09be }
        r7 = r8;
    L_0x0589:
        r5 = r5 + 1;
        r3 = 0;
        r11 = 1;
        goto L_0x0294;
    L_0x058f:
        r3 = r2.f14235c;	 Catch:{ all -> 0x09be }
        r3 = r3.size();	 Catch:{ all -> 0x09be }
        if (r7 >= r3) goto L_0x05a1;
    L_0x0597:
        r3 = r4.f17983b;	 Catch:{ all -> 0x09be }
        r3 = java.util.Arrays.copyOf(r3, r7);	 Catch:{ all -> 0x09be }
        r3 = (com.google.android.gms.internal.zzcmb[]) r3;	 Catch:{ all -> 0x09be }
        r4.f17983b = r3;	 Catch:{ all -> 0x09be }
    L_0x05a1:
        r3 = r2.f14233a;	 Catch:{ all -> 0x09be }
        r3 = r3.f17996o;	 Catch:{ all -> 0x09be }
        r5 = r2.f14233a;	 Catch:{ all -> 0x09be }
        r5 = r5.f17984c;	 Catch:{ all -> 0x09be }
        r7 = r4.f17983b;	 Catch:{ all -> 0x09be }
        r3 = r1.m5729a(r3, r5, r7);	 Catch:{ all -> 0x09be }
        r4.f17973A = r3;	 Catch:{ all -> 0x09be }
        r3 = com.google.android.gms.internal.zzchc.f6868b;	 Catch:{ all -> 0x09be }
        r3 = r3.f6893a;	 Catch:{ all -> 0x09be }
        r3 = (java.lang.Boolean) r3;	 Catch:{ all -> 0x09be }
        r3 = r3.booleanValue();	 Catch:{ all -> 0x09be }
        if (r3 == 0) goto L_0x0844;
    L_0x05bd:
        r3 = r1.f6975b;	 Catch:{ all -> 0x09be }
        r5 = r2.f14233a;	 Catch:{ all -> 0x09be }
        r5 = r5.f17996o;	 Catch:{ all -> 0x09be }
        r7 = "1";
        r3 = r3.mo1825q();	 Catch:{ all -> 0x09be }
        r8 = "measurement.event_sampling_enabled";
        r3 = r3.m18230a(r5, r8);	 Catch:{ all -> 0x09be }
        r3 = r7.equals(r3);	 Catch:{ all -> 0x09be }
        if (r3 == 0) goto L_0x0844;
    L_0x05d5:
        r3 = new java.util.HashMap;	 Catch:{ all -> 0x09be }
        r3.<init>();	 Catch:{ all -> 0x09be }
        r5 = r4.f17983b;	 Catch:{ all -> 0x09be }
        r5 = r5.length;	 Catch:{ all -> 0x09be }
        r5 = new com.google.android.gms.internal.zzcmb[r5];	 Catch:{ all -> 0x09be }
        r7 = r46.m5758i();	 Catch:{ all -> 0x09be }
        r7 = r7.m18584z();	 Catch:{ all -> 0x09be }
        r8 = r4.f17983b;	 Catch:{ all -> 0x09be }
        r9 = r8.length;	 Catch:{ all -> 0x09be }
        r10 = 0;
        r11 = 0;
    L_0x05ec:
        if (r10 >= r9) goto L_0x0810;
    L_0x05ee:
        r12 = r8[r10];	 Catch:{ all -> 0x09be }
        r13 = r12.f17961b;	 Catch:{ all -> 0x09be }
        r14 = "_ep";
        r13 = r13.equals(r14);	 Catch:{ all -> 0x09be }
        if (r13 == 0) goto L_0x0674;
    L_0x05fa:
        r46.m5758i();	 Catch:{ all -> 0x09be }
        r13 = "_en";
        r13 = com.google.android.gms.internal.zzclq.m18504a(r12, r13);	 Catch:{ all -> 0x09be }
        r13 = (java.lang.String) r13;	 Catch:{ all -> 0x09be }
        r14 = r3.get(r13);	 Catch:{ all -> 0x09be }
        r14 = (com.google.android.gms.internal.zzcgw) r14;	 Catch:{ all -> 0x09be }
        if (r14 != 0) goto L_0x061c;
    L_0x060d:
        r14 = r46.m5760k();	 Catch:{ all -> 0x09be }
        r15 = r2.f14233a;	 Catch:{ all -> 0x09be }
        r15 = r15.f17996o;	 Catch:{ all -> 0x09be }
        r14 = r14.m17995a(r15, r13);	 Catch:{ all -> 0x09be }
        r3.put(r13, r14);	 Catch:{ all -> 0x09be }
    L_0x061c:
        r13 = r14.f6847g;	 Catch:{ all -> 0x09be }
        if (r13 != 0) goto L_0x0669;
    L_0x0620:
        r13 = r14.f6848h;	 Catch:{ all -> 0x09be }
        r15 = r13.longValue();	 Catch:{ all -> 0x09be }
        r17 = 1;
        r13 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1));
        if (r13 <= 0) goto L_0x063e;
    L_0x062c:
        r46.m5758i();	 Catch:{ all -> 0x09be }
        r13 = r12.f17960a;	 Catch:{ all -> 0x09be }
        r15 = "_sr";
        r25 = r8;
        r8 = r14.f6848h;	 Catch:{ all -> 0x09be }
        r8 = com.google.android.gms.internal.zzclq.m18519a(r13, r15, r8);	 Catch:{ all -> 0x09be }
        r12.f17960a = r8;	 Catch:{ all -> 0x09be }
        goto L_0x0640;
    L_0x063e:
        r25 = r8;
    L_0x0640:
        r8 = r14.f6849i;	 Catch:{ all -> 0x09be }
        if (r8 == 0) goto L_0x0662;
    L_0x0644:
        r8 = r14.f6849i;	 Catch:{ all -> 0x09be }
        r8 = r8.booleanValue();	 Catch:{ all -> 0x09be }
        if (r8 == 0) goto L_0x0662;
    L_0x064c:
        r46.m5758i();	 Catch:{ all -> 0x09be }
        r8 = r12.f17960a;	 Catch:{ all -> 0x09be }
        r13 = "_efs";
        r26 = r9;
        r14 = 1;
        r9 = java.lang.Long.valueOf(r14);	 Catch:{ all -> 0x09be }
        r8 = com.google.android.gms.internal.zzclq.m18519a(r8, r13, r9);	 Catch:{ all -> 0x09be }
        r12.f17960a = r8;	 Catch:{ all -> 0x09be }
        goto L_0x0664;
    L_0x0662:
        r26 = r9;
    L_0x0664:
        r8 = r11 + 1;
        r5[r11] = r12;	 Catch:{ all -> 0x09be }
        goto L_0x06ad;
    L_0x0669:
        r25 = r8;
        r26 = r9;
        r43 = r2;
        r42 = r6;
        r41 = r7;
        goto L_0x06b4;
    L_0x0674:
        r25 = r8;
        r26 = r9;
        r8 = "_dbg";
        r13 = 1;
        r9 = java.lang.Long.valueOf(r13);	 Catch:{ all -> 0x09be }
        r8 = m5727a(r12, r8, r9);	 Catch:{ all -> 0x09be }
        if (r8 != 0) goto L_0x0695;
    L_0x0686:
        r8 = r46.m5756g();	 Catch:{ all -> 0x09be }
        r9 = r2.f14233a;	 Catch:{ all -> 0x09be }
        r9 = r9.f17996o;	 Catch:{ all -> 0x09be }
        r13 = r12.f17961b;	 Catch:{ all -> 0x09be }
        r8 = r8.m18237d(r9, r13);	 Catch:{ all -> 0x09be }
        goto L_0x0696;
    L_0x0695:
        r8 = 1;
    L_0x0696:
        if (r8 > 0) goto L_0x06b7;
    L_0x0698:
        r9 = r46.m5754e();	 Catch:{ all -> 0x09be }
        r9 = r9.f17818c;	 Catch:{ all -> 0x09be }
        r13 = "Sample rate must be positive. event, rate";
        r14 = r12.f17961b;	 Catch:{ all -> 0x09be }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ all -> 0x09be }
        r9.m5695a(r13, r14, r8);	 Catch:{ all -> 0x09be }
        r8 = r11 + 1;
        r5[r11] = r12;	 Catch:{ all -> 0x09be }
    L_0x06ad:
        r43 = r2;
        r42 = r6;
        r41 = r7;
        r11 = r8;
    L_0x06b4:
        r7 = r3;
        goto L_0x0801;
    L_0x06b7:
        r9 = r12.f17961b;	 Catch:{ all -> 0x09be }
        r9 = r3.get(r9);	 Catch:{ all -> 0x09be }
        r9 = (com.google.android.gms.internal.zzcgw) r9;	 Catch:{ all -> 0x09be }
        if (r9 != 0) goto L_0x0705;
    L_0x06c1:
        r9 = r46.m5760k();	 Catch:{ all -> 0x09be }
        r13 = r2.f14233a;	 Catch:{ all -> 0x09be }
        r13 = r13.f17996o;	 Catch:{ all -> 0x09be }
        r14 = r12.f17961b;	 Catch:{ all -> 0x09be }
        r9 = r9.m17995a(r13, r14);	 Catch:{ all -> 0x09be }
        if (r9 != 0) goto L_0x0705;
    L_0x06d1:
        r9 = r46.m5754e();	 Catch:{ all -> 0x09be }
        r9 = r9.f17818c;	 Catch:{ all -> 0x09be }
        r13 = "Event being bundled has no eventAggregate. appId, eventName";
        r14 = r2.f14233a;	 Catch:{ all -> 0x09be }
        r14 = r14.f17996o;	 Catch:{ all -> 0x09be }
        r15 = r12.f17961b;	 Catch:{ all -> 0x09be }
        r9.m5695a(r13, r14, r15);	 Catch:{ all -> 0x09be }
        r9 = new com.google.android.gms.internal.zzcgw;	 Catch:{ all -> 0x09be }
        r13 = r2.f14233a;	 Catch:{ all -> 0x09be }
        r13 = r13.f17996o;	 Catch:{ all -> 0x09be }
        r14 = r12.f17961b;	 Catch:{ all -> 0x09be }
        r30 = 1;
        r32 = 1;
        r15 = r12.f17962c;	 Catch:{ all -> 0x09be }
        r34 = r15.longValue();	 Catch:{ all -> 0x09be }
        r36 = 0;
        r38 = 0;
        r39 = 0;
        r40 = 0;
        r27 = r9;
        r28 = r13;
        r29 = r14;
        r27.<init>(r28, r29, r30, r32, r34, r36, r38, r39, r40);	 Catch:{ all -> 0x09be }
    L_0x0705:
        r46.m5758i();	 Catch:{ all -> 0x09be }
        r13 = "_eid";
        r13 = com.google.android.gms.internal.zzclq.m18504a(r12, r13);	 Catch:{ all -> 0x09be }
        r13 = (java.lang.Long) r13;	 Catch:{ all -> 0x09be }
        if (r13 == 0) goto L_0x0714;
    L_0x0712:
        r14 = 1;
        goto L_0x0715;
    L_0x0714:
        r14 = 0;
    L_0x0715:
        r14 = java.lang.Boolean.valueOf(r14);	 Catch:{ all -> 0x09be }
        r15 = 1;
        if (r8 != r15) goto L_0x073e;
    L_0x071c:
        r8 = r11 + 1;
        r5[r11] = r12;	 Catch:{ all -> 0x09be }
        r11 = r14.booleanValue();	 Catch:{ all -> 0x09be }
        if (r11 == 0) goto L_0x06ad;
    L_0x0726:
        r11 = r9.f6847g;	 Catch:{ all -> 0x09be }
        if (r11 != 0) goto L_0x0732;
    L_0x072a:
        r11 = r9.f6848h;	 Catch:{ all -> 0x09be }
        if (r11 != 0) goto L_0x0732;
    L_0x072e:
        r11 = r9.f6849i;	 Catch:{ all -> 0x09be }
        if (r11 == 0) goto L_0x06ad;
    L_0x0732:
        r11 = 0;
        r9 = r9.m5670a(r11, r11, r11);	 Catch:{ all -> 0x09be }
        r11 = r12.f17961b;	 Catch:{ all -> 0x09be }
        r3.put(r11, r9);	 Catch:{ all -> 0x09be }
        goto L_0x06ad;
    L_0x073e:
        r15 = r7.nextInt(r8);	 Catch:{ all -> 0x09be }
        if (r15 != 0) goto L_0x0782;
    L_0x0744:
        r46.m5758i();	 Catch:{ all -> 0x09be }
        r13 = r12.f17960a;	 Catch:{ all -> 0x09be }
        r15 = "_sr";
        r41 = r7;
        r7 = (long) r8;	 Catch:{ all -> 0x09be }
        r42 = r6;
        r6 = java.lang.Long.valueOf(r7);	 Catch:{ all -> 0x09be }
        r6 = com.google.android.gms.internal.zzclq.m18519a(r13, r15, r6);	 Catch:{ all -> 0x09be }
        r12.f17960a = r6;	 Catch:{ all -> 0x09be }
        r6 = r11 + 1;
        r5[r11] = r12;	 Catch:{ all -> 0x09be }
        r11 = r14.booleanValue();	 Catch:{ all -> 0x09be }
        if (r11 == 0) goto L_0x076d;
    L_0x0764:
        r7 = java.lang.Long.valueOf(r7);	 Catch:{ all -> 0x09be }
        r8 = 0;
        r9 = r9.m5670a(r8, r7, r8);	 Catch:{ all -> 0x09be }
    L_0x076d:
        r7 = r12.f17961b;	 Catch:{ all -> 0x09be }
        r8 = r12.f17962c;	 Catch:{ all -> 0x09be }
        r11 = r8.longValue();	 Catch:{ all -> 0x09be }
        r8 = r9.m5671b(r11);	 Catch:{ all -> 0x09be }
        r3.put(r7, r8);	 Catch:{ all -> 0x09be }
        r43 = r2;
        r7 = r3;
    L_0x077f:
        r11 = r6;
        goto L_0x0801;
    L_0x0782:
        r42 = r6;
        r41 = r7;
        r6 = r9.f6846f;	 Catch:{ all -> 0x09be }
        r15 = r12.f17962c;	 Catch:{ all -> 0x09be }
        r15 = r15.longValue();	 Catch:{ all -> 0x09be }
        r6 = r15 - r6;
        r6 = java.lang.Math.abs(r6);	 Catch:{ all -> 0x09be }
        r15 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
        r6 = (r6 > r15 ? 1 : (r6 == r15 ? 0 : -1));
        if (r6 < 0) goto L_0x07ee;
    L_0x079b:
        r46.m5758i();	 Catch:{ all -> 0x09be }
        r6 = r12.f17960a;	 Catch:{ all -> 0x09be }
        r7 = "_efs";
        r43 = r2;
        r44 = r3;
        r2 = 1;
        r13 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x09be }
        r6 = com.google.android.gms.internal.zzclq.m18519a(r6, r7, r13);	 Catch:{ all -> 0x09be }
        r12.f17960a = r6;	 Catch:{ all -> 0x09be }
        r46.m5758i();	 Catch:{ all -> 0x09be }
        r6 = r12.f17960a;	 Catch:{ all -> 0x09be }
        r7 = "_sr";
        r2 = (long) r8;	 Catch:{ all -> 0x09be }
        r8 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x09be }
        r6 = com.google.android.gms.internal.zzclq.m18519a(r6, r7, r8);	 Catch:{ all -> 0x09be }
        r12.f17960a = r6;	 Catch:{ all -> 0x09be }
        r6 = r11 + 1;
        r5[r11] = r12;	 Catch:{ all -> 0x09be }
        r7 = r14.booleanValue();	 Catch:{ all -> 0x09be }
        if (r7 == 0) goto L_0x07dc;
    L_0x07ce:
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x09be }
        r3 = 1;
        r7 = java.lang.Boolean.valueOf(r3);	 Catch:{ all -> 0x09be }
        r3 = 0;
        r9 = r9.m5670a(r3, r2, r7);	 Catch:{ all -> 0x09be }
    L_0x07dc:
        r2 = r12.f17961b;	 Catch:{ all -> 0x09be }
        r3 = r12.f17962c;	 Catch:{ all -> 0x09be }
        r7 = r3.longValue();	 Catch:{ all -> 0x09be }
        r3 = r9.m5671b(r7);	 Catch:{ all -> 0x09be }
        r7 = r44;
        r7.put(r2, r3);	 Catch:{ all -> 0x09be }
        goto L_0x077f;
    L_0x07ee:
        r43 = r2;
        r7 = r3;
        r2 = r14.booleanValue();	 Catch:{ all -> 0x09be }
        if (r2 == 0) goto L_0x0801;
    L_0x07f7:
        r2 = r12.f17961b;	 Catch:{ all -> 0x09be }
        r3 = 0;
        r6 = r9.m5670a(r13, r3, r3);	 Catch:{ all -> 0x09be }
        r7.put(r2, r6);	 Catch:{ all -> 0x09be }
    L_0x0801:
        r10 = r10 + 1;
        r3 = r7;
        r8 = r25;
        r9 = r26;
        r7 = r41;
        r6 = r42;
        r2 = r43;
        goto L_0x05ec;
    L_0x0810:
        r43 = r2;
        r7 = r3;
        r42 = r6;
        r2 = r4.f17983b;	 Catch:{ all -> 0x09be }
        r2 = r2.length;	 Catch:{ all -> 0x09be }
        if (r11 >= r2) goto L_0x0822;
    L_0x081a:
        r2 = java.util.Arrays.copyOf(r5, r11);	 Catch:{ all -> 0x09be }
        r2 = (com.google.android.gms.internal.zzcmb[]) r2;	 Catch:{ all -> 0x09be }
        r4.f17983b = r2;	 Catch:{ all -> 0x09be }
    L_0x0822:
        r2 = r7.entrySet();	 Catch:{ all -> 0x09be }
        r2 = r2.iterator();	 Catch:{ all -> 0x09be }
    L_0x082a:
        r3 = r2.hasNext();	 Catch:{ all -> 0x09be }
        if (r3 == 0) goto L_0x0848;
    L_0x0830:
        r3 = r2.next();	 Catch:{ all -> 0x09be }
        r3 = (java.util.Map.Entry) r3;	 Catch:{ all -> 0x09be }
        r5 = r46.m5760k();	 Catch:{ all -> 0x09be }
        r3 = r3.getValue();	 Catch:{ all -> 0x09be }
        r3 = (com.google.android.gms.internal.zzcgw) r3;	 Catch:{ all -> 0x09be }
        r5.m18001a(r3);	 Catch:{ all -> 0x09be }
        goto L_0x082a;
    L_0x0844:
        r43 = r2;
        r42 = r6;
    L_0x0848:
        r2 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x09be }
        r4.f17986e = r2;	 Catch:{ all -> 0x09be }
        r2 = -9223372036854775808;
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x09be }
        r4.f17987f = r2;	 Catch:{ all -> 0x09be }
        r2 = 0;
    L_0x085c:
        r3 = r4.f17983b;	 Catch:{ all -> 0x09be }
        r3 = r3.length;	 Catch:{ all -> 0x09be }
        if (r2 >= r3) goto L_0x0890;
    L_0x0861:
        r3 = r4.f17983b;	 Catch:{ all -> 0x09be }
        r3 = r3[r2];	 Catch:{ all -> 0x09be }
        r5 = r3.f17962c;	 Catch:{ all -> 0x09be }
        r5 = r5.longValue();	 Catch:{ all -> 0x09be }
        r7 = r4.f17986e;	 Catch:{ all -> 0x09be }
        r7 = r7.longValue();	 Catch:{ all -> 0x09be }
        r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
        if (r5 >= 0) goto L_0x0879;
    L_0x0875:
        r5 = r3.f17962c;	 Catch:{ all -> 0x09be }
        r4.f17986e = r5;	 Catch:{ all -> 0x09be }
    L_0x0879:
        r5 = r3.f17962c;	 Catch:{ all -> 0x09be }
        r5 = r5.longValue();	 Catch:{ all -> 0x09be }
        r7 = r4.f17987f;	 Catch:{ all -> 0x09be }
        r7 = r7.longValue();	 Catch:{ all -> 0x09be }
        r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
        if (r5 <= 0) goto L_0x088d;
    L_0x0889:
        r3 = r3.f17962c;	 Catch:{ all -> 0x09be }
        r4.f17987f = r3;	 Catch:{ all -> 0x09be }
    L_0x088d:
        r2 = r2 + 1;
        goto L_0x085c;
    L_0x0890:
        r2 = r43;
        r3 = r2.f14233a;	 Catch:{ all -> 0x09be }
        r3 = r3.f17996o;	 Catch:{ all -> 0x09be }
        r5 = r46.m5760k();	 Catch:{ all -> 0x09be }
        r5 = r5.m18008b(r3);	 Catch:{ all -> 0x09be }
        if (r5 != 0) goto L_0x08b4;
    L_0x08a0:
        r5 = r46.m5754e();	 Catch:{ all -> 0x09be }
        r5 = r5.f17816a;	 Catch:{ all -> 0x09be }
        r6 = "Bundling raw events w/o app info. appId";
        r7 = r2.f14233a;	 Catch:{ all -> 0x09be }
        r7 = r7.f17996o;	 Catch:{ all -> 0x09be }
        r7 = com.google.android.gms.internal.zzchm.m18154a(r7);	 Catch:{ all -> 0x09be }
        r5.m5694a(r6, r7);	 Catch:{ all -> 0x09be }
        goto L_0x0919;
    L_0x08b4:
        r6 = r4.f17983b;	 Catch:{ all -> 0x09be }
        r6 = r6.length;	 Catch:{ all -> 0x09be }
        if (r6 <= 0) goto L_0x0919;
    L_0x08b9:
        r6 = r5.m5639g();	 Catch:{ all -> 0x09be }
        r8 = 0;
        r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r10 == 0) goto L_0x08c8;
    L_0x08c3:
        r10 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x09be }
        goto L_0x08c9;
    L_0x08c8:
        r10 = 0;
    L_0x08c9:
        r4.f17989h = r10;	 Catch:{ all -> 0x09be }
        r10 = r5.m5636f();	 Catch:{ all -> 0x09be }
        r12 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1));
        if (r12 != 0) goto L_0x08d4;
    L_0x08d3:
        goto L_0x08d5;
    L_0x08d4:
        r6 = r10;
    L_0x08d5:
        r8 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r8 == 0) goto L_0x08de;
    L_0x08d9:
        r10 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x09be }
        goto L_0x08df;
    L_0x08de:
        r10 = 0;
    L_0x08df:
        r4.f17988g = r10;	 Catch:{ all -> 0x09be }
        r5.m5653q();	 Catch:{ all -> 0x09be }
        r6 = r5.m5650n();	 Catch:{ all -> 0x09be }
        r6 = (int) r6;	 Catch:{ all -> 0x09be }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x09be }
        r4.f18004w = r6;	 Catch:{ all -> 0x09be }
        r6 = r4.f17986e;	 Catch:{ all -> 0x09be }
        r6 = r6.longValue();	 Catch:{ all -> 0x09be }
        r5.m5620a(r6);	 Catch:{ all -> 0x09be }
        r6 = r4.f17987f;	 Catch:{ all -> 0x09be }
        r6 = r6.longValue();	 Catch:{ all -> 0x09be }
        r5.m5624b(r6);	 Catch:{ all -> 0x09be }
        r6 = r5.f6797a;	 Catch:{ all -> 0x09be }
        r6 = r6.m5755f();	 Catch:{ all -> 0x09be }
        r6.mo1811c();	 Catch:{ all -> 0x09be }
        r6 = r5.f6804h;	 Catch:{ all -> 0x09be }
        r7 = 0;
        r5.m5641g(r7);	 Catch:{ all -> 0x09be }
        r4.f18005x = r6;	 Catch:{ all -> 0x09be }
        r6 = r46.m5760k();	 Catch:{ all -> 0x09be }
        r6.m18000a(r5);	 Catch:{ all -> 0x09be }
    L_0x0919:
        r5 = r4.f17983b;	 Catch:{ all -> 0x09be }
        r5 = r5.length;	 Catch:{ all -> 0x09be }
        if (r5 <= 0) goto L_0x0965;
    L_0x091e:
        r5 = r46.m5756g();	 Catch:{ all -> 0x09be }
        r6 = r2.f14233a;	 Catch:{ all -> 0x09be }
        r6 = r6.f17996o;	 Catch:{ all -> 0x09be }
        r5 = r5.m18229a(r6);	 Catch:{ all -> 0x09be }
        if (r5 == 0) goto L_0x0936;
    L_0x092c:
        r6 = r5.f17945a;	 Catch:{ all -> 0x09be }
        if (r6 != 0) goto L_0x0931;
    L_0x0930:
        goto L_0x0936;
    L_0x0931:
        r5 = r5.f17945a;	 Catch:{ all -> 0x09be }
        r4.f17977E = r5;	 Catch:{ all -> 0x09be }
        goto L_0x095c;
    L_0x0936:
        r5 = r2.f14233a;	 Catch:{ all -> 0x09be }
        r5 = r5.f18006y;	 Catch:{ all -> 0x09be }
        r5 = android.text.TextUtils.isEmpty(r5);	 Catch:{ all -> 0x09be }
        if (r5 == 0) goto L_0x0949;
    L_0x0940:
        r5 = -1;
        r5 = java.lang.Long.valueOf(r5);	 Catch:{ all -> 0x09be }
        r4.f17977E = r5;	 Catch:{ all -> 0x09be }
        goto L_0x095c;
    L_0x0949:
        r5 = r46.m5754e();	 Catch:{ all -> 0x09be }
        r5 = r5.f17818c;	 Catch:{ all -> 0x09be }
        r6 = "Did not find measurement config or missing version info. appId";
        r7 = r2.f14233a;	 Catch:{ all -> 0x09be }
        r7 = r7.f17996o;	 Catch:{ all -> 0x09be }
        r7 = com.google.android.gms.internal.zzchm.m18154a(r7);	 Catch:{ all -> 0x09be }
        r5.m5694a(r6, r7);	 Catch:{ all -> 0x09be }
    L_0x095c:
        r5 = r46.m5760k();	 Catch:{ all -> 0x09be }
        r6 = r42;
        r5.m18007a(r4, r6);	 Catch:{ all -> 0x09be }
    L_0x0965:
        r4 = r46.m5760k();	 Catch:{ all -> 0x09be }
        r2 = r2.f14234b;	 Catch:{ all -> 0x09be }
        r4.m18003a(r2);	 Catch:{ all -> 0x09be }
        r2 = r46.m5760k();	 Catch:{ all -> 0x09be }
        r4 = r2.m17987A();	 Catch:{ all -> 0x09be }
        r5 = "delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)";
        r6 = 2;
        r6 = new java.lang.String[r6];	 Catch:{ SQLiteException -> 0x0985 }
        r7 = 0;
        r6[r7] = r3;	 Catch:{ SQLiteException -> 0x0985 }
        r7 = 1;
        r6[r7] = r3;	 Catch:{ SQLiteException -> 0x0985 }
        r4.execSQL(r5, r6);	 Catch:{ SQLiteException -> 0x0985 }
        goto L_0x0996;
    L_0x0985:
        r0 = move-exception;
        r4 = r0;
        r2 = r2.mo1828t();	 Catch:{ all -> 0x09be }
        r2 = r2.f17816a;	 Catch:{ all -> 0x09be }
        r5 = "Failed to remove unused event metadata. appId";
        r3 = com.google.android.gms.internal.zzchm.m18154a(r3);	 Catch:{ all -> 0x09be }
        r2.m5695a(r5, r3, r4);	 Catch:{ all -> 0x09be }
    L_0x0996:
        r2 = r46.m5760k();	 Catch:{ all -> 0x09be }
        r2.m18023y();	 Catch:{ all -> 0x09be }
        r2 = r46.m5760k();
        r2.m18024z();
        r2 = 1;
        return r2;
    L_0x09a6:
        r2 = r46.m5760k();	 Catch:{ all -> 0x09be }
        r2.m18023y();	 Catch:{ all -> 0x09be }
        r2 = r46.m5760k();
        r2.m18024z();
        r2 = 0;
        return r2;
    L_0x09b6:
        r0 = move-exception;
    L_0x09b7:
        r2 = r0;
    L_0x09b8:
        if (r9 == 0) goto L_0x09bd;
    L_0x09ba:
        r9.close();	 Catch:{ all -> 0x09be }
    L_0x09bd:
        throw r2;	 Catch:{ all -> 0x09be }
    L_0x09be:
        r0 = move-exception;
        r2 = r0;
        r3 = r46.m5760k();
        r3.m18024z();
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcim.a(long):boolean");
    }

    final void m5744a(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        m5755f().mo1811c();
        m5736a();
        zzbq.m4810a(str);
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.f6971M = false;
                m5717E();
            }
        }
        m5754e().f17822g.m5694a("onConfigFetched. Response size", Integer.valueOf(bArr.length));
        m5760k().m18022x();
        zzcgh b = m5760k().m18008b(str);
        boolean z = true;
        boolean z2 = (i == HttpStatus.HTTP_OK || i == 204 || i == 304) && th == null;
        if (b == null) {
            m5754e().f17818c.m5694a("App does not exist in onConfigFetched. appId", zzchm.m18154a(str));
        } else {
            if (!z2) {
                if (i != HttpStatus.HTTP_NOT_FOUND) {
                    b.m5643h(this.f6982i.mo1632a());
                    m5760k().m18000a(b);
                    m5754e().f17822g.m5695a("Fetching config failed. code, error", Integer.valueOf(i), th);
                    th = m5756g();
                    th.mo1811c();
                    th.f17853b.put(str, null);
                    m5753d().f17831d.m5703a(this.f6982i.mo1632a());
                    if (i != 503) {
                        if (i != 429) {
                            z = false;
                        }
                    }
                    if (z) {
                        m5753d().f17832e.m5703a(this.f6982i.mo1632a());
                    }
                    m5770v();
                }
            }
            th = map != null ? (List) map.get(HttpRequest.HEADER_LAST_MODIFIED) : null;
            th = (th == null || th.size() <= null) ? null : (String) th.get(0);
            if (i != HttpStatus.HTTP_NOT_FOUND) {
                if (i != 304) {
                    m5756g().m18232a(str, bArr, th);
                    b.m5640g(this.f6982i.mo1632a());
                    m5760k().m18000a(b);
                    if (i != HttpStatus.HTTP_NOT_FOUND) {
                        m5754e().f17819d.m5694a("Config not found. Using empty config. appId", str);
                    } else {
                        m5754e().f17822g.m5695a("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                    }
                    if (m5761l().m18210y() != null || m5715C() == null) {
                        m5770v();
                    } else {
                        m5769u();
                    }
                }
            }
            if (m5756g().m18229a(str) == null) {
                m5756g().m18232a(str, null, null);
            }
            b.m5640g(this.f6982i.mo1632a());
            m5760k().m18000a(b);
            if (i != HttpStatus.HTTP_NOT_FOUND) {
                m5754e().f17822g.m5695a("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
            } else {
                m5754e().f17819d.m5694a("Config not found. Using empty config. appId", str);
            }
            if (m5761l().m18210y() != null) {
            }
            m5770v();
        }
        m5760k().m18023y();
        m5760k().m18024z();
        this.f6971M = false;
        m5717E();
    }

    protected final void m5737a(int i, Throwable th, byte[] bArr) {
        m5755f().mo1811c();
        m5736a();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.f6972N = false;
                m5717E();
            }
        }
        List<Long> list = this.f6967I;
        this.f6967I = null;
        int i2 = 1;
        if ((i == HttpStatus.HTTP_OK || i == 204) && th == null) {
            try {
                m5753d().f17830c.m5703a(this.f6982i.mo1632a());
                m5753d().f17831d.m5703a(0);
                m5770v();
                m5754e().f17822g.m5695a("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                m5760k().m18022x();
                try {
                    for (Long l : list) {
                        bArr = m5760k();
                        long longValue = l.longValue();
                        bArr.mo1811c();
                        bArr.m13545L();
                        if (bArr.m17987A().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                            throw new SQLiteException("Deleted fewer rows from queue than expected");
                        }
                    }
                    m5760k().m18023y();
                    m5760k().m18024z();
                    if (m5761l().m18210y() == 0 || m5715C() == 0) {
                        this.f6969K = -1;
                        m5770v();
                    } else {
                        m5769u();
                    }
                    this.f6970L = 0;
                } catch (int i3) {
                    bArr.mo1828t().f17816a.m5694a("Failed to delete a bundle in a queue table", i3);
                    throw i3;
                } catch (Throwable th3) {
                    m5760k().m18024z();
                }
            } catch (int i32) {
                m5754e().f17816a.m5694a("Database error while trying to delete uploaded bundles", i32);
                this.f6970L = this.f6982i.mo1633b();
                m5754e().f17822g.m5694a("Disable upload, time", Long.valueOf(this.f6970L));
            }
        } else {
            m5754e().f17822g.m5695a("Network upload failed. Will retry later. code, error", Integer.valueOf(i32), th);
            m5753d().f17831d.m5703a(this.f6982i.mo1632a());
            if (i32 != 503) {
                if (i32 != 429) {
                    i2 = 0;
                }
            }
            if (i2 != 0) {
                m5753d().f17832e.m5703a(this.f6982i.mo1632a());
            }
            m5770v();
        }
        this.f6972N = false;
        m5717E();
    }

    private final boolean m5715C() {
        m5755f().mo1811c();
        m5736a();
        if (!(m5760k().m17992a("select count(1) > 0 from raw_events", null) != 0)) {
            if (TextUtils.isEmpty(m5760k().m17988B())) {
                return false;
            }
        }
        return true;
    }

    final void m5770v() {
        zzcim com_google_android_gms_internal_zzcim = this;
        m5755f().mo1811c();
        m5736a();
        if (m5716D()) {
            long abs;
            if (com_google_android_gms_internal_zzcim.f6970L > 0) {
                abs = 3600000 - Math.abs(com_google_android_gms_internal_zzcim.f6982i.mo1633b() - com_google_android_gms_internal_zzcim.f6970L);
                if (abs > 0) {
                    m5754e().f17822g.m5694a("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(abs));
                    m5733y().m5700a();
                    m5734z().m18500y();
                    return;
                }
                com_google_android_gms_internal_zzcim.f6970L = 0;
            }
            if (m5749b()) {
                if (m5715C()) {
                    Object obj;
                    CharSequence A;
                    long max;
                    long a;
                    long a2;
                    long j;
                    long max2;
                    long abs2;
                    long j2;
                    long j3;
                    int i;
                    long max3;
                    BroadcastReceiver y;
                    long a3 = com_google_android_gms_internal_zzcim.f6982i.mo1632a();
                    abs = Math.max(0, ((Long) zzchc.f6854C.f6893a).longValue());
                    if ((m5760k().m17992a("select count(1) > 0 from raw_events where realtime = 1", null) != 0 ? 1 : null) == null) {
                        if ((m5760k().m17992a("select count(1) > 0 from queue where has_realtime = 1", null) != 0 ? 1 : null) == null) {
                            obj = null;
                            if (obj == null) {
                                A = com_google_android_gms_internal_zzcim.f6975b.m13487A();
                                if (!TextUtils.isEmpty(A) || ".none.".equals(A)) {
                                    max = Math.max(0, ((Long) zzchc.f6889w.f6893a).longValue());
                                } else {
                                    max = Math.max(0, ((Long) zzchc.f6890x.f6893a).longValue());
                                }
                            } else {
                                max = Math.max(0, ((Long) zzchc.f6888v.f6893a).longValue());
                            }
                            a = m5753d().f17830c.m5702a();
                            a2 = m5753d().f17831d.m5702a();
                            j = max;
                            max2 = Math.max(m5760k().m17993a("select max(bundle_end_timestamp) from queue", null, 0), m5760k().m17993a("select max(timestamp) from raw_events", null, 0));
                            if (max2 != 0) {
                                max2 = a3 - Math.abs(max2 - a3);
                                abs2 = a3 - Math.abs(a - a3);
                                a3 -= Math.abs(a2 - a3);
                                abs2 = Math.max(abs2, a3);
                                abs += max2;
                                if (obj != null && abs2 > 0) {
                                    abs = Math.min(max2, abs2) + j;
                                }
                                j2 = j;
                                if (!m5758i().m18543a(abs2, j2)) {
                                    abs = abs2 + j2;
                                }
                                if (a3 != 0 && a3 >= max2) {
                                    j3 = abs;
                                    for (i = 0; i < Math.min(20, Math.max(0, ((Integer) zzchc.f6856E.f6893a).intValue())); i++) {
                                        j3 += Math.max(0, ((Long) zzchc.f6855D.f6893a).longValue()) * (1 << i);
                                        if (j3 > a3) {
                                            abs = j3;
                                            break;
                                        }
                                    }
                                }
                                if (abs != 0) {
                                    m5754e().f17822g.m5693a("Next upload time is 0");
                                    m5733y().m5700a();
                                    m5734z().m18500y();
                                    return;
                                } else if (m5761l().m18210y()) {
                                    a3 = m5753d().f17832e.m5702a();
                                    max3 = Math.max(0, ((Long) zzchc.f6886t.f6893a).longValue());
                                    if (!m5758i().m18543a(a3, max3)) {
                                        abs = Math.max(abs, a3 + max3);
                                    }
                                    m5733y().m5700a();
                                    abs -= com_google_android_gms_internal_zzcim.f6982i.mo1632a();
                                    if (abs <= 0) {
                                        abs = Math.max(0, ((Long) zzchc.f6891y.f6893a).longValue());
                                        m5753d().f17830c.m5703a(com_google_android_gms_internal_zzcim.f6982i.mo1632a());
                                    }
                                    m5754e().f17822g.m5694a("Upload scheduled in approximately ms", Long.valueOf(abs));
                                    m5734z().m18477a(abs);
                                    return;
                                } else {
                                    m5754e().f17822g.m5693a("No network");
                                    y = m5733y();
                                    y.f6917a.m5736a();
                                    y.f6917a.m5755f().mo1811c();
                                    if (!y.f6918b) {
                                        y.f6917a.f6974a.registerReceiver(y, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                                        y.f6919c = y.f6917a.m5761l().m18210y();
                                        y.f6917a.m5754e().f17822g.m5694a("Registering connectivity change receiver. Network connected", Boolean.valueOf(y.f6919c));
                                        y.f6918b = true;
                                    }
                                    m5734z().m18500y();
                                    return;
                                }
                            }
                            abs = 0;
                            if (abs != 0) {
                                m5754e().f17822g.m5693a("Next upload time is 0");
                                m5733y().m5700a();
                                m5734z().m18500y();
                                return;
                            } else if (m5761l().m18210y()) {
                                a3 = m5753d().f17832e.m5702a();
                                max3 = Math.max(0, ((Long) zzchc.f6886t.f6893a).longValue());
                                if (m5758i().m18543a(a3, max3)) {
                                    abs = Math.max(abs, a3 + max3);
                                }
                                m5733y().m5700a();
                                abs -= com_google_android_gms_internal_zzcim.f6982i.mo1632a();
                                if (abs <= 0) {
                                    abs = Math.max(0, ((Long) zzchc.f6891y.f6893a).longValue());
                                    m5753d().f17830c.m5703a(com_google_android_gms_internal_zzcim.f6982i.mo1632a());
                                }
                                m5754e().f17822g.m5694a("Upload scheduled in approximately ms", Long.valueOf(abs));
                                m5734z().m18477a(abs);
                                return;
                            } else {
                                m5754e().f17822g.m5693a("No network");
                                y = m5733y();
                                y.f6917a.m5736a();
                                y.f6917a.m5755f().mo1811c();
                                if (y.f6918b) {
                                    y.f6917a.f6974a.registerReceiver(y, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                                    y.f6919c = y.f6917a.m5761l().m18210y();
                                    y.f6917a.m5754e().f17822g.m5694a("Registering connectivity change receiver. Network connected", Boolean.valueOf(y.f6919c));
                                    y.f6918b = true;
                                }
                                m5734z().m18500y();
                                return;
                            }
                        }
                    }
                    obj = 1;
                    if (obj == null) {
                        max = Math.max(0, ((Long) zzchc.f6888v.f6893a).longValue());
                    } else {
                        A = com_google_android_gms_internal_zzcim.f6975b.m13487A();
                        if (TextUtils.isEmpty(A)) {
                        }
                        max = Math.max(0, ((Long) zzchc.f6889w.f6893a).longValue());
                    }
                    a = m5753d().f17830c.m5702a();
                    a2 = m5753d().f17831d.m5702a();
                    j = max;
                    max2 = Math.max(m5760k().m17993a("select max(bundle_end_timestamp) from queue", null, 0), m5760k().m17993a("select max(timestamp) from raw_events", null, 0));
                    if (max2 != 0) {
                        max2 = a3 - Math.abs(max2 - a3);
                        abs2 = a3 - Math.abs(a - a3);
                        a3 -= Math.abs(a2 - a3);
                        abs2 = Math.max(abs2, a3);
                        abs += max2;
                        abs = Math.min(max2, abs2) + j;
                        j2 = j;
                        if (m5758i().m18543a(abs2, j2)) {
                            abs = abs2 + j2;
                        }
                        j3 = abs;
                        for (i = 0; i < Math.min(20, Math.max(0, ((Integer) zzchc.f6856E.f6893a).intValue())); i++) {
                            j3 += Math.max(0, ((Long) zzchc.f6855D.f6893a).longValue()) * (1 << i);
                            if (j3 > a3) {
                                abs = j3;
                                break;
                            }
                        }
                    }
                    abs = 0;
                    if (abs != 0) {
                        m5754e().f17822g.m5693a("Next upload time is 0");
                        m5733y().m5700a();
                        m5734z().m18500y();
                        return;
                    } else if (m5761l().m18210y()) {
                        m5754e().f17822g.m5693a("No network");
                        y = m5733y();
                        y.f6917a.m5736a();
                        y.f6917a.m5755f().mo1811c();
                        if (y.f6918b) {
                            y.f6917a.f6974a.registerReceiver(y, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                            y.f6919c = y.f6917a.m5761l().m18210y();
                            y.f6917a.m5754e().f17822g.m5694a("Registering connectivity change receiver. Network connected", Boolean.valueOf(y.f6919c));
                            y.f6918b = true;
                        }
                        m5734z().m18500y();
                        return;
                    } else {
                        a3 = m5753d().f17832e.m5702a();
                        max3 = Math.max(0, ((Long) zzchc.f6886t.f6893a).longValue());
                        if (m5758i().m18543a(a3, max3)) {
                            abs = Math.max(abs, a3 + max3);
                        }
                        m5733y().m5700a();
                        abs -= com_google_android_gms_internal_zzcim.f6982i.mo1632a();
                        if (abs <= 0) {
                            abs = Math.max(0, ((Long) zzchc.f6891y.f6893a).longValue());
                            m5753d().f17830c.m5703a(com_google_android_gms_internal_zzcim.f6982i.mo1632a());
                        }
                        m5754e().f17822g.m5694a("Upload scheduled in approximately ms", Long.valueOf(abs));
                        m5734z().m18477a(abs);
                        return;
                    }
                }
            }
            m5754e().f17822g.m5693a("Nothing to upload or uploading impossible");
            m5733y().m5700a();
            m5734z().m18500y();
        }
    }

    public final void m5745b(zzcgi com_google_android_gms_internal_zzcgi) {
        zzcim com_google_android_gms_internal_zzcim = this;
        zzcgi com_google_android_gms_internal_zzcgi2 = com_google_android_gms_internal_zzcgi;
        m5755f().mo1811c();
        m5736a();
        zzbq.m4808a((Object) com_google_android_gms_internal_zzcgi);
        zzbq.m4810a(com_google_android_gms_internal_zzcgi2.f17759a);
        if (!TextUtils.isEmpty(com_google_android_gms_internal_zzcgi2.f17760b)) {
            zzcgh b = m5760k().m18008b(com_google_android_gms_internal_zzcgi2.f17759a);
            if (!(b == null || !TextUtils.isEmpty(b.m5627c()) || TextUtils.isEmpty(com_google_android_gms_internal_zzcgi2.f17760b))) {
                b.m5640g(0);
                m5760k().m18000a(b);
                zzcjk g = m5756g();
                String str = com_google_android_gms_internal_zzcgi2.f17759a;
                g.mo1811c();
                g.f17852a.remove(str);
            }
            if (com_google_android_gms_internal_zzcgi2.f17766h) {
                zzcgh b2;
                zzcgo k;
                String str2;
                String str3;
                zzcgw com_google_android_gms_internal_zzcgw;
                long j;
                long j2;
                Bundle bundle;
                PackageInfo b3;
                int i;
                ApplicationInfo a;
                zzcjk k2;
                long h;
                zzcha com_google_android_gms_internal_zzcha;
                long j3 = com_google_android_gms_internal_zzcgi2.f17771m;
                if (j3 == 0) {
                    j3 = com_google_android_gms_internal_zzcim.f6982i.mo1632a();
                }
                int i2 = com_google_android_gms_internal_zzcgi2.f17772n;
                if (!(i2 == 0 || i2 == 1)) {
                    m5754e().f17818c.m5695a("Incorrect app type, assuming installed app. appId, appType", zzchm.m18154a(com_google_android_gms_internal_zzcgi2.f17759a), Integer.valueOf(i2));
                    i2 = 0;
                }
                m5760k().m18022x();
                zzcjk k3;
                String a2;
                try {
                    b2 = m5760k().m18008b(com_google_android_gms_internal_zzcgi2.f17759a);
                    if (!(b2 == null || b2.m5627c() == null || b2.m5627c().equals(com_google_android_gms_internal_zzcgi2.f17760b))) {
                        m5754e().f17818c.m5694a("New GMP App Id passed in. Removing cached database data. appId", zzchm.m18154a(b2.m5619a()));
                        k3 = m5760k();
                        a2 = b2.m5619a();
                        k3.m13545L();
                        k3.mo1811c();
                        zzbq.m4810a(a2);
                        SQLiteDatabase A = k3.m17987A();
                        String[] strArr = new String[]{a2};
                        int delete = ((((((((A.delete("events", "app_id=?", strArr) + 0) + A.delete(State.KEY_USER_ATTRIBUTES, "app_id=?", strArr)) + A.delete("conditional_properties", "app_id=?", strArr)) + A.delete("apps", "app_id=?", strArr)) + A.delete("raw_events", "app_id=?", strArr)) + A.delete("raw_events_metadata", "app_id=?", strArr)) + A.delete("event_filters", "app_id=?", strArr)) + A.delete("property_filters", "app_id=?", strArr)) + A.delete("audience_filter_values", "app_id=?", strArr);
                        if (delete > 0) {
                            k3.mo1828t().f17822g.m5695a("Deleted application data. app, records", a2, Integer.valueOf(delete));
                        }
                        b2 = null;
                    }
                } catch (SQLiteException e) {
                    k3.mo1828t().f17816a.m5695a("Error deleting application data. appId, error", zzchm.m18154a(a2), e);
                } catch (Throwable th) {
                    Throwable th2 = th;
                    m5760k().m18024z();
                }
                if (!(b2 == null || b2.m5642h() == null || b2.m5642h().equals(com_google_android_gms_internal_zzcgi2.f17761c))) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("_pv", b2.m5642h());
                    m5741a(new zzcha("_au", new zzcgx(bundle2), "auto", j3), com_google_android_gms_internal_zzcgi2);
                }
                m5752c(com_google_android_gms_internal_zzcgi);
                if (i2 == 0) {
                    k = m5760k();
                    str2 = com_google_android_gms_internal_zzcgi2.f17759a;
                    str3 = "_f";
                } else if (i2 == 1) {
                    k = m5760k();
                    str2 = com_google_android_gms_internal_zzcgi2.f17759a;
                    str3 = "_v";
                } else {
                    com_google_android_gms_internal_zzcgw = null;
                    if (com_google_android_gms_internal_zzcgw != null) {
                        j = ((j3 / 3600000) + 1) * 3600000;
                        if (i2 != 0) {
                            j2 = 1;
                            m5743a(new zzcln("_fot", j3, Long.valueOf(j), "auto"), com_google_android_gms_internal_zzcgi2);
                            m5755f().mo1811c();
                            m5736a();
                            bundle = new Bundle();
                            bundle.putLong("_c", j2);
                            bundle.putLong("_r", j2);
                            bundle.putLong("_uwa", 0);
                            bundle.putLong("_pfo", 0);
                            bundle.putLong("_sys", 0);
                            bundle.putLong("_sysu", 0);
                            if (com_google_android_gms_internal_zzcim.f6974a.getPackageManager() != null) {
                                m5754e().f17816a.m5694a("PackageManager is null, first open report might be inaccurate. appId", zzchm.m18154a(com_google_android_gms_internal_zzcgi2.f17759a));
                            } else {
                                try {
                                    b3 = zzbhf.m5574a(com_google_android_gms_internal_zzcim.f6974a).m5572b(com_google_android_gms_internal_zzcgi2.f17759a, 0);
                                } catch (NameNotFoundException e2) {
                                    m5754e().f17816a.m5695a("Package info is null, first open report might be inaccurate. appId", zzchm.m18154a(com_google_android_gms_internal_zzcgi2.f17759a), e2);
                                    b3 = null;
                                }
                                if (!(b3 == null || b3.firstInstallTime == 0)) {
                                    if (b3.firstInstallTime == b3.lastUpdateTime) {
                                        bundle.putLong("_uwa", j2);
                                        i = 0;
                                    } else {
                                        i = 1;
                                    }
                                    m5743a(new zzcln("_fi", j3, Long.valueOf(i == 0 ? j2 : 0), "auto"), com_google_android_gms_internal_zzcgi2);
                                }
                                try {
                                    a = zzbhf.m5574a(com_google_android_gms_internal_zzcim.f6974a).m5569a(com_google_android_gms_internal_zzcgi2.f17759a, 0);
                                } catch (NameNotFoundException e22) {
                                    m5754e().f17816a.m5695a("Application info is null, first open report might be inaccurate. appId", zzchm.m18154a(com_google_android_gms_internal_zzcgi2.f17759a), e22);
                                    a = null;
                                }
                                if (a != null) {
                                    if ((a.flags & 1) != 0) {
                                        bundle.putLong("_sys", j2);
                                    }
                                    if ((a.flags & 128) != 0) {
                                        bundle.putLong("_sysu", j2);
                                    }
                                }
                            }
                            k2 = m5760k();
                            str2 = com_google_android_gms_internal_zzcgi2.f17759a;
                            zzbq.m4810a(str2);
                            k2.mo1811c();
                            k2.m13545L();
                            h = k2.m18020h(str2, "first_open_count");
                            if (h >= 0) {
                                bundle.putLong("_pfo", h);
                            }
                            com_google_android_gms_internal_zzcha = new zzcha("_f", new zzcgx(bundle), "auto", j3);
                        } else {
                            j2 = 1;
                            if (i2 == 1) {
                                m5743a(new zzcln("_fvt", j3, Long.valueOf(j), "auto"), com_google_android_gms_internal_zzcgi2);
                                m5755f().mo1811c();
                                m5736a();
                                bundle = new Bundle();
                                bundle.putLong("_c", j2);
                                bundle.putLong("_r", j2);
                                com_google_android_gms_internal_zzcha = new zzcha("_v", new zzcgx(bundle), "auto", j3);
                            }
                            bundle = new Bundle();
                            bundle.putLong("_et", j2);
                            com_google_android_gms_internal_zzcha = new zzcha("_e", new zzcgx(bundle), "auto", j3);
                        }
                        m5741a(r14, com_google_android_gms_internal_zzcgi2);
                        bundle = new Bundle();
                        bundle.putLong("_et", j2);
                        com_google_android_gms_internal_zzcha = new zzcha("_e", new zzcgx(bundle), "auto", j3);
                    } else {
                        if (com_google_android_gms_internal_zzcgi2.f17767i) {
                            com_google_android_gms_internal_zzcha = new zzcha("_cd", new zzcgx(new Bundle()), "auto", j3);
                        }
                        m5760k().m18023y();
                        m5760k().m18024z();
                        return;
                    }
                    m5741a(r4, com_google_android_gms_internal_zzcgi2);
                    m5760k().m18023y();
                    m5760k().m18024z();
                    return;
                }
                com_google_android_gms_internal_zzcgw = k.m17995a(str2, str3);
                if (com_google_android_gms_internal_zzcgw != null) {
                    if (com_google_android_gms_internal_zzcgi2.f17767i) {
                        com_google_android_gms_internal_zzcha = new zzcha("_cd", new zzcgx(new Bundle()), "auto", j3);
                    }
                    m5760k().m18023y();
                    m5760k().m18024z();
                    return;
                }
                j = ((j3 / 3600000) + 1) * 3600000;
                if (i2 != 0) {
                    j2 = 1;
                    if (i2 == 1) {
                        m5743a(new zzcln("_fvt", j3, Long.valueOf(j), "auto"), com_google_android_gms_internal_zzcgi2);
                        m5755f().mo1811c();
                        m5736a();
                        bundle = new Bundle();
                        bundle.putLong("_c", j2);
                        bundle.putLong("_r", j2);
                        com_google_android_gms_internal_zzcha = new zzcha("_v", new zzcgx(bundle), "auto", j3);
                    }
                    bundle = new Bundle();
                    bundle.putLong("_et", j2);
                    com_google_android_gms_internal_zzcha = new zzcha("_e", new zzcgx(bundle), "auto", j3);
                } else {
                    j2 = 1;
                    m5743a(new zzcln("_fot", j3, Long.valueOf(j), "auto"), com_google_android_gms_internal_zzcgi2);
                    m5755f().mo1811c();
                    m5736a();
                    bundle = new Bundle();
                    bundle.putLong("_c", j2);
                    bundle.putLong("_r", j2);
                    bundle.putLong("_uwa", 0);
                    bundle.putLong("_pfo", 0);
                    bundle.putLong("_sys", 0);
                    bundle.putLong("_sysu", 0);
                    if (com_google_android_gms_internal_zzcim.f6974a.getPackageManager() != null) {
                        b3 = zzbhf.m5574a(com_google_android_gms_internal_zzcim.f6974a).m5572b(com_google_android_gms_internal_zzcgi2.f17759a, 0);
                        if (b3.firstInstallTime == b3.lastUpdateTime) {
                            i = 1;
                        } else {
                            bundle.putLong("_uwa", j2);
                            i = 0;
                        }
                        if (i == 0) {
                        }
                        m5743a(new zzcln("_fi", j3, Long.valueOf(i == 0 ? j2 : 0), "auto"), com_google_android_gms_internal_zzcgi2);
                        a = zzbhf.m5574a(com_google_android_gms_internal_zzcim.f6974a).m5569a(com_google_android_gms_internal_zzcgi2.f17759a, 0);
                        if (a != null) {
                            if ((a.flags & 1) != 0) {
                                bundle.putLong("_sys", j2);
                            }
                            if ((a.flags & 128) != 0) {
                                bundle.putLong("_sysu", j2);
                            }
                        }
                    } else {
                        m5754e().f17816a.m5694a("PackageManager is null, first open report might be inaccurate. appId", zzchm.m18154a(com_google_android_gms_internal_zzcgi2.f17759a));
                    }
                    k2 = m5760k();
                    str2 = com_google_android_gms_internal_zzcgi2.f17759a;
                    zzbq.m4810a(str2);
                    k2.mo1811c();
                    k2.m13545L();
                    h = k2.m18020h(str2, "first_open_count");
                    if (h >= 0) {
                        bundle.putLong("_pfo", h);
                    }
                    com_google_android_gms_internal_zzcha = new zzcha("_f", new zzcgx(bundle), "auto", j3);
                }
                m5741a(r14, com_google_android_gms_internal_zzcgi2);
                bundle = new Bundle();
                bundle.putLong("_et", j2);
                com_google_android_gms_internal_zzcha = new zzcha("_e", new zzcgx(bundle), "auto", j3);
                m5741a(r4, com_google_android_gms_internal_zzcgi2);
                m5760k().m18023y();
                m5760k().m18024z();
                return;
            }
            m5752c(com_google_android_gms_internal_zzcgi);
        }
    }

    final void m5772x() {
        m5755f().mo1811c();
        m5736a();
        if (!this.f6962D) {
            m5754e().f17820e.m5693a("This instance being marked as an uploader");
            m5755f().mo1811c();
            m5736a();
            if (m5716D() && m5713A()) {
                int a = m5718a(this.f6966H);
                int B = m5765p().m18057B();
                m5755f().mo1811c();
                if (a > B) {
                    m5754e().f17816a.m5695a("Panic: can't downgrade version. Previous, current version", Integer.valueOf(a), Integer.valueOf(B));
                } else if (a < B) {
                    if (m5725a(B, this.f6966H)) {
                        m5754e().f17822g.m5695a("Storage version upgraded. Previous, current version", Integer.valueOf(a), Integer.valueOf(B));
                    } else {
                        m5754e().f17816a.m5695a("Storage version upgrade failed. Previous, current version", Integer.valueOf(a), Integer.valueOf(B));
                    }
                }
            }
            this.f6962D = true;
            m5770v();
        }
    }

    private final void m5717E() {
        m5755f().mo1811c();
        if (!(this.f6971M || this.f6972N)) {
            if (!this.f6973O) {
                m5754e().f17822g.m5693a("Stopping uploading service(s)");
                if (this.f6983j != null) {
                    for (Runnable run : this.f6983j) {
                        run.run();
                    }
                    this.f6983j.clear();
                    return;
                }
                return;
            }
        }
        m5754e().f17822g.m5696a("Not stopping services. fetch, network, upload", Boolean.valueOf(this.f6971M), Boolean.valueOf(this.f6972N), Boolean.valueOf(this.f6973O));
    }

    static /* synthetic */ void m5722a(zzcim com_google_android_gms_internal_zzcim) {
        zzcho com_google_android_gms_internal_zzcho;
        com_google_android_gms_internal_zzcim.m5755f().mo1811c();
        com_google_android_gms_internal_zzcim.f6988p.m13547N();
        com_google_android_gms_internal_zzcim.f6986n.m13547N();
        com_google_android_gms_internal_zzcim.f6996x.m13547N();
        com_google_android_gms_internal_zzcim.m5754e().f17820e.m5694a("App measurement is starting up, version", Long.valueOf(11910));
        com_google_android_gms_internal_zzcim.m5754e().f17820e.m5693a("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String z = com_google_android_gms_internal_zzcim.f6996x.m18084z();
        if (com_google_android_gms_internal_zzcim.m5758i().m18566i(z)) {
            com_google_android_gms_internal_zzcho = com_google_android_gms_internal_zzcim.m5754e().f17820e;
            z = "Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.";
        } else {
            com_google_android_gms_internal_zzcho = com_google_android_gms_internal_zzcim.m5754e().f17820e;
            String str = "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ";
            z = String.valueOf(z);
            z = z.length() != 0 ? str.concat(z) : new String(str);
        }
        com_google_android_gms_internal_zzcho.m5693a(z);
        com_google_android_gms_internal_zzcim.m5754e().f17821f.m5693a("Debug-level message logging enabled");
        if (com_google_android_gms_internal_zzcim.f6984k != com_google_android_gms_internal_zzcim.f6968J) {
            com_google_android_gms_internal_zzcim.m5754e().f17816a.m5695a("Not all components initialized", Integer.valueOf(com_google_android_gms_internal_zzcim.f6984k), Integer.valueOf(com_google_android_gms_internal_zzcim.f6968J));
        }
        com_google_android_gms_internal_zzcim.f6961C = true;
    }
}
