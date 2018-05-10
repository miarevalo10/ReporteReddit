package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.zzan;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.zzf;
import com.google.android.gms.internal.zzcxd;
import com.google.android.gms.internal.zzcxe;
import com.google.android.gms.internal.zzcxq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public final class zzao implements zzbh {
    private final zzbi f13859a;
    private final Lock f13860b;
    private final Context f13861c;
    private final zzf f13862d;
    private ConnectionResult f13863e;
    private int f13864f;
    private int f13865g = 0;
    private int f13866h;
    private final Bundle f13867i = new Bundle();
    private final Set<zzc> f13868j = new HashSet();
    private zzcxd f13869k;
    private boolean f13870l;
    private boolean f13871m;
    private boolean f13872n;
    private zzan f13873o;
    private boolean f13874p;
    private boolean f13875q;
    private final zzr f13876r;
    private final Map<Api<?>, Boolean> f13877s;
    private final zza<? extends zzcxd, zzcxe> f13878t;
    private ArrayList<Future<?>> f13879u = new ArrayList();

    public zzao(zzbi com_google_android_gms_common_api_internal_zzbi, zzr com_google_android_gms_common_internal_zzr, Map<Api<?>, Boolean> map, zzf com_google_android_gms_common_zzf, zza<? extends zzcxd, zzcxe> com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzcxd__com_google_android_gms_internal_zzcxe, Lock lock, Context context) {
        this.f13859a = com_google_android_gms_common_api_internal_zzbi;
        this.f13876r = com_google_android_gms_common_internal_zzr;
        this.f13877s = map;
        this.f13862d = com_google_android_gms_common_zzf;
        this.f13878t = com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzcxd__com_google_android_gms_internal_zzcxe;
        this.f13860b = lock;
        this.f13861c = context;
    }

    private final void m12898a(boolean z) {
        if (this.f13869k != null) {
            if (this.f13869k.m12812f() && z) {
                this.f13869k.m_();
            }
            this.f13869k.mo4292e();
            this.f13873o = null;
        }
    }

    private final boolean m12899a(ConnectionResult connectionResult) {
        return this.f13870l && !connectionResult.m17583a();
    }

    private final void m12901b(ConnectionResult connectionResult) {
        m12916h();
        m12898a(connectionResult.m17583a() ^ 1);
        this.f13859a.m17602a(connectionResult);
        this.f13859a.f17289n.mo1592a(connectionResult);
    }

    private final boolean m12903b(int i) {
        if (this.f13865g == i) {
            return true;
        }
        Log.w("GoogleApiClientConnecting", this.f13859a.f17288m.m12986o());
        String valueOf = String.valueOf(this);
        StringBuilder stringBuilder = new StringBuilder(23 + String.valueOf(valueOf).length());
        stringBuilder.append("Unexpected callback in ");
        stringBuilder.append(valueOf);
        Log.w("GoogleApiClientConnecting", stringBuilder.toString());
        int i2 = this.f13866h;
        stringBuilder = new StringBuilder(33);
        stringBuilder.append("mRemainingConnections=");
        stringBuilder.append(i2);
        Log.w("GoogleApiClientConnecting", stringBuilder.toString());
        valueOf = m12905c(this.f13865g);
        String c = m12905c(i);
        stringBuilder = new StringBuilder((70 + String.valueOf(valueOf).length()) + String.valueOf(c).length());
        stringBuilder.append("GoogleApiClient connecting is in step ");
        stringBuilder.append(valueOf);
        stringBuilder.append(" but received callback for step ");
        stringBuilder.append(c);
        Log.wtf("GoogleApiClientConnecting", stringBuilder.toString(), new Exception());
        m12901b(new ConnectionResult(8, null));
        return false;
    }

    private static String m12905c(int i) {
        switch (i) {
            case 0:
                return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
            case 1:
                return "STEP_GETTING_REMOTE_SERVICE";
            default:
                return "UNKNOWN";
        }
    }

    private final boolean m12908d() {
        this.f13866h--;
        if (this.f13866h > 0) {
            return false;
        }
        ConnectionResult connectionResult;
        if (this.f13866h < 0) {
            Log.w("GoogleApiClientConnecting", this.f13859a.f17288m.m12986o());
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            connectionResult = new ConnectionResult(8, null);
        } else if (this.f13863e == null) {
            return true;
        } else {
            this.f13859a.f17287l = this.f13864f;
            connectionResult = this.f13863e;
        }
        m12901b(connectionResult);
        return false;
    }

    private final void m12909e() {
        if (this.f13866h == 0) {
            if (!this.f13871m || this.f13872n) {
                ArrayList arrayList = new ArrayList();
                this.f13865g = 1;
                this.f13866h = this.f13859a.f17281f.size();
                for (zzc com_google_android_gms_common_api_Api_zzc : this.f13859a.f17281f.keySet()) {
                    if (!this.f13859a.f17282g.containsKey(com_google_android_gms_common_api_Api_zzc)) {
                        arrayList.add((zze) this.f13859a.f17281f.get(com_google_android_gms_common_api_Api_zzc));
                    } else if (m12908d()) {
                        m12912f();
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.f13879u.add(zzbl.m4707a().submit(new zzau(this, arrayList)));
                }
            }
        }
    }

    private final void m12914g() {
        this.f13871m = false;
        this.f13859a.f17288m.f13897c = Collections.emptySet();
        for (zzc com_google_android_gms_common_api_Api_zzc : this.f13868j) {
            if (!this.f13859a.f17282g.containsKey(com_google_android_gms_common_api_Api_zzc)) {
                this.f13859a.f17282g.put(com_google_android_gms_common_api_Api_zzc, new ConnectionResult(17, null));
            }
        }
    }

    private final void m12916h() {
        ArrayList arrayList = this.f13879u;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((Future) obj).cancel(true);
        }
        this.f13879u.clear();
    }

    public final <A extends zzb, R extends Result, T extends zzm<R, A>> T mo1570a(T t) {
        this.f13859a.f17288m.f13895a.add(t);
        return t;
    }

    public final void mo1572a(int i) {
        m12901b(new ConnectionResult(8, null));
    }

    public final void mo1573a(Bundle bundle) {
        if (m12903b(1)) {
            if (bundle != null) {
                this.f13867i.putAll(bundle);
            }
            if (m12908d()) {
                m12912f();
            }
        }
    }

    public final void mo1574a(ConnectionResult connectionResult, Api<?> api, boolean z) {
        if (m12903b(1)) {
            m12902b(connectionResult, api, z);
            if (m12908d()) {
                m12912f();
            }
        }
    }

    public final <A extends zzb, T extends zzm<? extends Result, A>> T mo1575b(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public final boolean mo1576b() {
        m12916h();
        m12898a(true);
        this.f13859a.m17602a(null);
        return true;
    }

    public final void mo1577c() {
    }

    public final void mo1571a() {
        this.f13859a.f17282g.clear();
        this.f13871m = false;
        this.f13863e = null;
        this.f13865g = 0;
        this.f13870l = true;
        this.f13872n = false;
        this.f13874p = false;
        Map hashMap = new HashMap();
        for (Api api : this.f13877s.keySet()) {
            zze com_google_android_gms_common_api_Api_zze = (zze) this.f13859a.f17281f.get(api.zzagf());
            api.zzagd();
            boolean booleanValue = ((Boolean) this.f13877s.get(api)).booleanValue();
            if (com_google_android_gms_common_api_Api_zze.mo4023h()) {
                this.f13871m = true;
                if (booleanValue) {
                    this.f13868j.add(api.zzagf());
                } else {
                    this.f13870l = false;
                }
            }
            hashMap.put(com_google_android_gms_common_api_Api_zze, new zzaq(this, api, booleanValue));
        }
        if (this.f13871m) {
            this.f13876r.f5948h = Integer.valueOf(System.identityHashCode(this.f13859a.f17288m));
            OnConnectionFailedListener com_google_android_gms_common_api_internal_zzax = new zzax();
            this.f13869k = (zzcxd) this.f13878t.mo3407a(this.f13861c, this.f13859a.f17288m.mo1599c(), this.f13876r, this.f13876r.f5947g, com_google_android_gms_common_api_internal_zzax, com_google_android_gms_common_api_internal_zzax);
        }
        this.f13866h = this.f13859a.f17281f.size();
        this.f13879u.add(zzbl.m4707a().submit(new zzar(this, hashMap)));
    }

    private final void m12912f() {
        zzbi com_google_android_gms_common_api_internal_zzbi = this.f13859a;
        com_google_android_gms_common_api_internal_zzbi.f17276a.lock();
        try {
            com_google_android_gms_common_api_internal_zzbi.f17288m.m12984m();
            com_google_android_gms_common_api_internal_zzbi.f17286k = new zzal(com_google_android_gms_common_api_internal_zzbi);
            com_google_android_gms_common_api_internal_zzbi.f17286k.mo1571a();
            com_google_android_gms_common_api_internal_zzbi.f17277b.signalAll();
            zzbl.m4707a().execute(new zzap(this));
            if (this.f13869k != null) {
                if (this.f13874p) {
                    this.f13869k.mo4025a(this.f13873o, this.f13875q);
                }
                m12898a(false);
            }
            for (zzc com_google_android_gms_common_api_Api_zzc : this.f13859a.f17282g.keySet()) {
                ((zze) this.f13859a.f17281f.get(com_google_android_gms_common_api_Api_zzc)).mo4292e();
            }
            this.f13859a.f17289n.mo1591a(this.f13867i.isEmpty() ? null : this.f13867i);
        } finally {
            com_google_android_gms_common_api_internal_zzbi.f17276a.unlock();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m12902b(com.google.android.gms.common.ConnectionResult r4, com.google.android.gms.common.api.Api<?> r5, boolean r6) {
        /*
        r3 = this;
        r5.zzagd();
        r0 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r1 = 0;
        r2 = 1;
        if (r6 == 0) goto L_0x001e;
    L_0x000a:
        r6 = r4.m17583a();
        if (r6 == 0) goto L_0x0012;
    L_0x0010:
        r6 = r2;
        goto L_0x001c;
    L_0x0012:
        r6 = r4.f17257b;
        r6 = com.google.android.gms.common.zzf.m4932c(r6);
        if (r6 == 0) goto L_0x001b;
    L_0x001a:
        goto L_0x0010;
    L_0x001b:
        r6 = r1;
    L_0x001c:
        if (r6 == 0) goto L_0x0027;
    L_0x001e:
        r6 = r3.f13863e;
        if (r6 == 0) goto L_0x0026;
    L_0x0022:
        r6 = r3.f13864f;
        if (r0 >= r6) goto L_0x0027;
    L_0x0026:
        r1 = r2;
    L_0x0027:
        if (r1 == 0) goto L_0x002d;
    L_0x0029:
        r3.f13863e = r4;
        r3.f13864f = r0;
    L_0x002d:
        r6 = r3.f13859a;
        r6 = r6.f17282g;
        r5 = r5.zzagf();
        r6.put(r5, r4);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzao.b(com.google.android.gms.common.ConnectionResult, com.google.android.gms.common.api.Api, boolean):void");
    }

    static /* synthetic */ Set m12913g(zzao com_google_android_gms_common_api_internal_zzao) {
        if (com_google_android_gms_common_api_internal_zzao.f13876r == null) {
            return Collections.emptySet();
        }
        Set hashSet = new HashSet(com_google_android_gms_common_api_internal_zzao.f13876r.f5942b);
        Map map = com_google_android_gms_common_api_internal_zzao.f13876r.f5944d;
        for (Api api : map.keySet()) {
            if (!com_google_android_gms_common_api_internal_zzao.f13859a.f17282g.containsKey(api.zzagf())) {
                hashSet.addAll(((zzt) map.get(api)).f5957a);
            }
        }
        return hashSet;
    }

    static /* synthetic */ void m12897a(zzao com_google_android_gms_common_api_internal_zzao, zzcxq com_google_android_gms_internal_zzcxq) {
        if (com_google_android_gms_common_api_internal_zzao.m12903b(0)) {
            ConnectionResult connectionResult = com_google_android_gms_internal_zzcxq.f18032a;
            if (connectionResult.m17584b()) {
                com_google_android_gms_internal_zzcxq = com_google_android_gms_internal_zzcxq.f18033b;
                connectionResult = com_google_android_gms_internal_zzcxq.f17333a;
                if (connectionResult.m17584b()) {
                    com_google_android_gms_common_api_internal_zzao.f13872n = true;
                    com_google_android_gms_common_api_internal_zzao.f13873o = com_google_android_gms_internal_zzcxq.m17680a();
                    com_google_android_gms_common_api_internal_zzao.f13874p = com_google_android_gms_internal_zzcxq.f17334b;
                    com_google_android_gms_common_api_internal_zzao.f13875q = com_google_android_gms_internal_zzcxq.f17335c;
                    com_google_android_gms_common_api_internal_zzao.m12909e();
                    return;
                }
                String valueOf = String.valueOf(connectionResult);
                StringBuilder stringBuilder = new StringBuilder(48 + String.valueOf(valueOf).length());
                stringBuilder.append("Sign-in succeeded with resolve account failure: ");
                stringBuilder.append(valueOf);
                Log.wtf("GoogleApiClientConnecting", stringBuilder.toString(), new Exception());
                com_google_android_gms_common_api_internal_zzao.m12901b(connectionResult);
            } else if (com_google_android_gms_common_api_internal_zzao.m12899a(connectionResult) != null) {
                com_google_android_gms_common_api_internal_zzao.m12914g();
                com_google_android_gms_common_api_internal_zzao.m12909e();
            } else {
                com_google_android_gms_common_api_internal_zzao.m12901b(connectionResult);
            }
        }
    }
}
