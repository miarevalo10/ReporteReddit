package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.security.NetworkSecurityPolicy;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

@zzzv
public final class zzaft implements zzahg, zzhj {
    private String f14065A = "";
    private long f14066B = 0;
    private long f14067C = 0;
    private long f14068D = 0;
    private int f14069E = -1;
    private JSONObject f14070F = new JSONObject();
    private int f14071G = 0;
    public final Object f14072a = new Object();
    public zzfs f14073b;
    public final HashSet<zzafq> f14074c = new HashSet();
    public final HashMap<String, zzafz> f14075d = new HashMap();
    Boolean f14076e = null;
    final AtomicInteger f14077f = new AtomicInteger(0);
    public final zzafv f14078g = new zzafv();
    private final zzafx f14079h = new zzafx(zzkb.m6347c());
    private BigInteger f14080i = BigInteger.ONE;
    private boolean f14081j = false;
    private boolean f14082k = true;
    private int f14083l = 0;
    private boolean f14084m = false;
    private Context f14085n;
    private zzakd f14086o;
    private zznk f14087p = null;
    private boolean f14088q = true;
    private boolean f14089r = true;
    private zzhk f14090s = null;
    private zzhf f14091t = null;
    private String f14092u;
    private String f14093v;
    private String f14094w;
    private boolean f14095x = false;
    private boolean f14096y = false;
    private boolean f14097z = false;

    private final Future m13233b(int i) {
        Future b;
        synchronized (this.f14072a) {
            this.f14069E = i;
            b = zzagh.m5130b(this.f14085n, i);
        }
        return b;
    }

    private final Future m13234b(long j) {
        Future a;
        synchronized (this.f14072a) {
            this.f14067C = j;
            a = zzagh.m5126a(this.f14085n, j);
        }
        return a;
    }

    public final Bundle m13235a(Context context, zzafy com_google_android_gms_internal_zzafy, String str) {
        Bundle bundle;
        synchronized (this.f14072a) {
            bundle = new Bundle();
            bundle.putBundle("app", this.f14079h.m5117a(context, str));
            Bundle bundle2 = new Bundle();
            for (String str2 : this.f14075d.keySet()) {
                bundle2.putBundle(str2, ((zzafz) this.f14075d.get(str2)).m5119a());
            }
            bundle.putBundle("slots", bundle2);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.f14074c.iterator();
            while (it.hasNext()) {
                arrayList.add(((zzafq) it.next()).m5111a());
            }
            bundle.putParcelableArrayList("ads", arrayList);
            com_google_android_gms_internal_zzafy.mo3388a(this.f14074c);
            this.f14074c.clear();
        }
        return bundle;
    }

    public final zzakv m13236a(Context context, String str) {
        this.f14066B = zzbs.m4492k().mo1632a();
        synchronized (this.f14072a) {
            zzakv a;
            if (str != null) {
                if (!str.equals(this.f14065A)) {
                    this.f14065A = str;
                    a = zzagh.m5123a(context, str, this.f14066B);
                    return a;
                }
            }
            a = zzakl.m5377a(null);
            return a;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.zzhk m13237a(android.content.Context r4) {
        /*
        r3 = this;
        r0 = com.google.android.gms.internal.zznh.f7875K;
        r1 = com.google.android.gms.internal.zzkb.m6350f();
        r0 = r1.m6488a(r0);
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        r1 = 0;
        if (r0 != 0) goto L_0x0014;
    L_0x0013:
        return r1;
    L_0x0014:
        r0 = com.google.android.gms.internal.zznh.f7883S;
        r2 = com.google.android.gms.internal.zzkb.m6350f();
        r0 = r2.m6488a(r0);
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        if (r0 != 0) goto L_0x0039;
    L_0x0026:
        r0 = com.google.android.gms.internal.zznh.f7881Q;
        r2 = com.google.android.gms.internal.zzkb.m6350f();
        r0 = r2.m6488a(r0);
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        if (r0 != 0) goto L_0x0039;
    L_0x0038:
        return r1;
    L_0x0039:
        r0 = r3.m13248a();
        if (r0 == 0) goto L_0x0046;
    L_0x003f:
        r0 = r3.m13252b();
        if (r0 == 0) goto L_0x0046;
    L_0x0045:
        return r1;
    L_0x0046:
        r0 = r3.f14072a;
        monitor-enter(r0);
        r2 = android.os.Looper.getMainLooper();	 Catch:{ all -> 0x007b }
        if (r2 == 0) goto L_0x0079;
    L_0x004f:
        if (r4 != 0) goto L_0x0052;
    L_0x0051:
        goto L_0x0079;
    L_0x0052:
        r4 = r3.f14091t;	 Catch:{ all -> 0x007b }
        if (r4 != 0) goto L_0x005d;
    L_0x0056:
        r4 = new com.google.android.gms.internal.zzhf;	 Catch:{ all -> 0x007b }
        r4.<init>();	 Catch:{ all -> 0x007b }
        r3.f14091t = r4;	 Catch:{ all -> 0x007b }
    L_0x005d:
        r4 = r3.f14090s;	 Catch:{ all -> 0x007b }
        if (r4 != 0) goto L_0x0070;
    L_0x0061:
        r4 = new com.google.android.gms.internal.zzhk;	 Catch:{ all -> 0x007b }
        r1 = r3.f14091t;	 Catch:{ all -> 0x007b }
        r2 = r3.f14085n;	 Catch:{ all -> 0x007b }
        r2 = com.google.android.gms.internal.zzzp.m14485a(r2);	 Catch:{ all -> 0x007b }
        r4.<init>(r1, r2);	 Catch:{ all -> 0x007b }
        r3.f14090s = r4;	 Catch:{ all -> 0x007b }
    L_0x0070:
        r4 = r3.f14090s;	 Catch:{ all -> 0x007b }
        r4.m6295a();	 Catch:{ all -> 0x007b }
        r4 = r3.f14090s;	 Catch:{ all -> 0x007b }
        monitor-exit(r0);	 Catch:{ all -> 0x007b }
        return r4;
    L_0x0079:
        monitor-exit(r0);	 Catch:{ all -> 0x007b }
        return r1;
    L_0x007b:
        r4 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x007b }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaft.a(android.content.Context):com.google.android.gms.internal.zzhk");
    }

    public final Future m13238a(int i) {
        Future a;
        synchronized (this.f14072a) {
            this.f14071G = i;
            a = zzagh.m5125a(this.f14085n, i);
        }
        return a;
    }

    public final Future m13239a(long j) {
        Future b;
        synchronized (this.f14072a) {
            this.f14068D = j;
            b = zzagh.m5131b(this.f14085n, j);
        }
        return b;
    }

    public final Future m13240a(Context context, boolean z) {
        synchronized (this.f14072a) {
            if (z != this.f14082k) {
                this.f14082k = z;
                Future a = zzagh.m5129a(context, z);
                return a;
            }
            return null;
        }
    }

    public final Future m13241a(String str) {
        synchronized (this.f14072a) {
            if (str != null) {
                if (!str.equals(this.f14092u)) {
                    this.f14092u = str;
                    Future a = zzagh.m5128a(this.f14085n, str);
                    return a;
                }
            }
            return null;
        }
    }

    public final Future m13242a(String str, String str2, boolean z) {
        synchronized (this.f14072a) {
            JSONArray optJSONArray = this.f14070F.optJSONArray(str);
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
            }
            int length = optJSONArray.length();
            int i = 0;
            while (i < optJSONArray.length()) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject == null || !str2.equals(optJSONObject.optString("template_id"))) {
                    i++;
                } else if (z && optJSONObject.optBoolean("uses_media_view", false) == z) {
                    return null;
                } else {
                    length = i;
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("template_id", str2);
                jSONObject.put("uses_media_view", z);
                jSONObject.put("timestamp_ms", zzbs.m4492k().mo1632a());
                optJSONArray.put(length, jSONObject);
                this.f14070F.put(str, optJSONArray);
            } catch (Throwable e) {
                zzakb.m5369c("Could not update native advanced settings", e);
            }
            Future c = zzagh.m5136c(this.f14085n, this.f14070F.toString());
            return c;
        }
    }

    @TargetApi(23)
    public final void m13243a(Context context, zzakd com_google_android_gms_internal_zzakd) {
        synchronized (this.f14072a) {
            if (!this.f14084m) {
                this.f14085n = context.getApplicationContext();
                this.f14086o = com_google_android_gms_internal_zzakd;
                zzbs.m4489h().m6283a(this);
                zzagh.m5127a(context, (zzahg) this);
                zzagh.m5132b(context, (zzahg) this);
                zzagh.m5142h(context, this);
                zzagh.m5140f(context, this);
                zzagh.m5135c(context, (zzahg) this);
                zzagh.m5138d(context, this);
                zzagh.m5139e(context, this);
                zzagh.m5141g(context, this);
                zzagh.m5143i(context, this);
                zzagh.m5144j(context, this);
                zzagh.m5145k(context, this);
                zzzp.m14485a(this.f14085n);
                this.f14094w = zzbs.m4486e().m5225a(context, com_google_android_gms_internal_zzakd.f17551a);
                if (VERSION.SDK_INT >= 23 && !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) {
                    this.f14096y = true;
                }
                this.f14073b = new zzfs(context.getApplicationContext(), this.f14086o);
                zznj com_google_android_gms_internal_zznj = new zznj(this.f14085n, this.f14086o.f17551a);
                try {
                    zzbs.m4494m();
                    this.f14087p = zznm.m6497a(com_google_android_gms_internal_zznj);
                } catch (Throwable e) {
                    zzakb.m5369c("Cannot initialize CSI reporter.", e);
                }
                this.f14084m = true;
            }
        }
    }

    public final void mo1715a(Bundle bundle) {
        synchronized (this.f14072a) {
            this.f14082k = bundle.getBoolean("use_https", this.f14082k);
            this.f14083l = bundle.getInt("webview_cache_version", this.f14083l);
            if (bundle.containsKey("content_url_opted_out")) {
                m13247a(bundle.getBoolean("content_url_opted_out"));
            }
            if (bundle.containsKey("content_url_hashes")) {
                this.f14092u = bundle.getString("content_url_hashes");
            }
            this.f14097z = bundle.getBoolean("auto_collect_location", this.f14097z);
            if (bundle.containsKey("content_vertical_opted_out")) {
                m13251b(bundle.getBoolean("content_vertical_opted_out"));
            }
            if (bundle.containsKey("content_vertical_hashes")) {
                this.f14093v = bundle.getString("content_vertical_hashes");
            }
            if (bundle.containsKey("native_advanced_settings")) {
                try {
                    this.f14070F = new JSONObject(bundle.getString("native_advanced_settings"));
                } catch (Throwable e) {
                    zzakb.m5369c("Could not convert native advanced settings to json object", e);
                }
            }
            if (bundle.containsKey("version_code")) {
                this.f14071G = bundle.getInt("version_code");
            }
            this.f14065A = bundle.containsKey("app_settings_json") ? bundle.getString("app_settings_json") : this.f14065A;
            this.f14066B = bundle.getLong("app_settings_last_update_ms", this.f14066B);
            this.f14067C = bundle.getLong("app_last_background_time_ms", this.f14067C);
            this.f14069E = bundle.getInt("request_in_session_count", this.f14069E);
            this.f14068D = bundle.getLong("first_ad_req_time_ms", this.f14068D);
        }
    }

    public final void m13245a(zzafq com_google_android_gms_internal_zzafq) {
        synchronized (this.f14072a) {
            this.f14074c.add(com_google_android_gms_internal_zzafq);
        }
    }

    public final void m13246a(Throwable th, String str) {
        zzzp.m14485a(this.f14085n).mo2296a(th, str);
    }

    public final void m13247a(boolean z) {
        synchronized (this.f14072a) {
            if (this.f14088q != z) {
                zzagh.m5134b(this.f14085n, z);
            }
            this.f14088q = z;
            zzhk a = m13237a(this.f14085n);
            if (!(a == null || a.isAlive())) {
                zzakb.m5370d("start fetching content...");
                a.m6295a();
            }
        }
    }

    public final boolean m13248a() {
        boolean z;
        synchronized (this.f14072a) {
            z = this.f14088q;
        }
        return z;
    }

    public final Future m13249b(Context context, boolean z) {
        synchronized (this.f14072a) {
            if (z != this.f14097z) {
                this.f14097z = z;
                Future c = zzagh.m5137c(context, z);
                return c;
            }
            return null;
        }
    }

    public final Future m13250b(String str) {
        synchronized (this.f14072a) {
            if (str != null) {
                if (!str.equals(this.f14093v)) {
                    this.f14093v = str;
                    Future b = zzagh.m5133b(this.f14085n, str);
                    return b;
                }
            }
            return null;
        }
    }

    public final void m13251b(boolean z) {
        synchronized (this.f14072a) {
            if (this.f14089r != z) {
                zzagh.m5134b(this.f14085n, z);
            }
            zzagh.m5134b(this.f14085n, z);
            this.f14089r = z;
            zzhk a = m13237a(this.f14085n);
            if (!(a == null || a.isAlive())) {
                zzakb.m5370d("start fetching content...");
                a.m6295a();
            }
        }
    }

    public final boolean m13252b() {
        boolean z;
        synchronized (this.f14072a) {
            z = this.f14089r;
        }
        return z;
    }

    public final String m13253c() {
        String bigInteger;
        synchronized (this.f14072a) {
            bigInteger = this.f14080i.toString();
            this.f14080i = this.f14080i.add(BigInteger.ONE);
        }
        return bigInteger;
    }

    public final zzafx m13255d() {
        zzafx com_google_android_gms_internal_zzafx;
        synchronized (this.f14072a) {
            com_google_android_gms_internal_zzafx = this.f14079h;
        }
        return com_google_android_gms_internal_zzafx;
    }

    public final void mo1716d(boolean z) {
        long a = zzbs.m4492k().mo1632a();
        if (z) {
            if (a - this.f14067C > ((Long) zzkb.m6350f().m6488a(zznh.aw)).longValue()) {
                this.f14079h.f6355d = -1;
                return;
            }
            this.f14079h.f6355d = this.f14069E;
            return;
        }
        m13234b(a);
        m13233b(this.f14079h.f6355d);
    }

    public final zznk m13257e() {
        zznk com_google_android_gms_internal_zznk;
        synchronized (this.f14072a) {
            com_google_android_gms_internal_zznk = this.f14087p;
        }
        return com_google_android_gms_internal_zznk;
    }

    public final boolean m13258f() {
        boolean z;
        synchronized (this.f14072a) {
            if (!this.f14082k) {
                if (!this.f14096y) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    public final String m13259g() {
        String str;
        synchronized (this.f14072a) {
            str = this.f14092u;
        }
        return str;
    }

    public final String m13260h() {
        String str;
        synchronized (this.f14072a) {
            str = this.f14093v;
        }
        return str;
    }

    public final Boolean m13261i() {
        Boolean bool;
        synchronized (this.f14072a) {
            bool = this.f14076e;
        }
        return bool;
    }

    public final boolean m13262j() {
        boolean z;
        synchronized (this.f14072a) {
            z = this.f14097z;
        }
        return z;
    }

    public final long m13263k() {
        long j;
        synchronized (this.f14072a) {
            j = this.f14067C;
        }
        return j;
    }

    public final long m13264l() {
        long j;
        synchronized (this.f14072a) {
            j = this.f14068D;
        }
        return j;
    }

    public final int m13265m() {
        int i;
        synchronized (this.f14072a) {
            i = this.f14071G;
        }
        return i;
    }

    public final int m13266n() {
        int i;
        synchronized (this.f14072a) {
            i = this.f14069E;
        }
        return i;
    }

    public final zzafs m13267o() {
        zzafs com_google_android_gms_internal_zzafs;
        synchronized (this.f14072a) {
            com_google_android_gms_internal_zzafs = new zzafs(this.f14065A, this.f14066B);
        }
        return com_google_android_gms_internal_zzafs;
    }

    public final JSONObject m13268p() {
        JSONObject jSONObject;
        synchronized (this.f14072a) {
            jSONObject = this.f14070F;
        }
        return jSONObject;
    }

    public final Future m13269q() {
        Future a;
        synchronized (this.f14072a) {
            a = zzagh.m5124a(this.f14085n);
        }
        return a;
    }

    public final void m13271s() {
        this.f14077f.incrementAndGet();
    }

    public final void m13254c(boolean z) {
        int i;
        zzafv com_google_android_gms_internal_zzafv = this.f14078g;
        if (z) {
            z = zzafw.f6348a;
            i = zzafw.f6349b;
        } else {
            z = zzafw.f6349b;
            i = zzafw.f6348a;
        }
        com_google_android_gms_internal_zzafv.m5115a(z, i);
    }

    public final Resources m13270r() {
        if (this.f14086o.f17554d) {
            return this.f14085n.getResources();
        }
        try {
            DynamiteModule a = DynamiteModule.m4956a(this.f14085n, DynamiteModule.f5985a, ModuleDescriptor.MODULE_ID);
            return a != null ? a.f5997f.getResources() : null;
        } catch (Throwable e) {
            zzakb.m5369c("Cannot load resource from dynamite apk or local jar", e);
            return null;
        }
    }
}
