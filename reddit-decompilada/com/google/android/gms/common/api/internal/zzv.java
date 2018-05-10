package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.common.zzf;
import com.google.android.gms.internal.zzcxd;
import com.google.android.gms.internal.zzcxe;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;
import org.jcodec.codecs.common.biari.MQEncoder;

final class zzv implements zzcc {
    private final Context f13973a;
    private final zzba f13974b;
    private final Looper f13975c;
    private final zzbi f13976d;
    private final zzbi f13977e;
    private final Map<zzc<?>, zzbi> f13978f;
    private final Set<zzcu> f13979g = Collections.newSetFromMap(new WeakHashMap());
    private final zze f13980h;
    private Bundle f13981i;
    private ConnectionResult f13982j = null;
    private ConnectionResult f13983k = null;
    private boolean f13984l = false;
    private final Lock f13985m;
    private int f13986n = 0;

    private zzv(Context context, zzba com_google_android_gms_common_api_internal_zzba, Lock lock, Looper looper, zzf com_google_android_gms_common_zzf, Map<zzc<?>, zze> map, Map<zzc<?>, zze> map2, zzr com_google_android_gms_common_internal_zzr, zza<? extends zzcxd, zzcxe> com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzcxd__com_google_android_gms_internal_zzcxe, zze com_google_android_gms_common_api_Api_zze, ArrayList<zzt> arrayList, ArrayList<zzt> arrayList2, Map<Api<?>, Boolean> map3, Map<Api<?>, Boolean> map4) {
        Context context2 = context;
        this.f13973a = context2;
        this.f13974b = com_google_android_gms_common_api_internal_zzba;
        Lock lock2 = lock;
        this.f13985m = lock2;
        Looper looper2 = looper;
        this.f13975c = looper2;
        this.f13980h = com_google_android_gms_common_api_Api_zze;
        Context context3 = context2;
        Lock lock3 = lock2;
        zzf com_google_android_gms_common_zzf2 = com_google_android_gms_common_zzf;
        zzbi com_google_android_gms_common_api_internal_zzbi = r2;
        zzbi com_google_android_gms_common_api_internal_zzbi2 = new zzbi(context3, this.f13974b, lock3, looper2, com_google_android_gms_common_zzf2, map2, null, map4, null, arrayList2, new zzx());
        this.f13976d = com_google_android_gms_common_api_internal_zzbi;
        this.f13977e = new zzbi(context3, this.f13974b, lock3, looper, com_google_android_gms_common_zzf2, map, com_google_android_gms_common_internal_zzr, map3, com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzcxd__com_google_android_gms_internal_zzcxe, arrayList, new zzy());
        Map arrayMap = new ArrayMap();
        for (zzc put : map2.keySet()) {
            arrayMap.put(put, r0.f13976d);
        }
        for (zzc put2 : map.keySet()) {
            arrayMap.put(put2, r0.f13977e);
        }
        r0.f13978f = Collections.unmodifiableMap(arrayMap);
    }

    public static zzv m13053a(Context context, zzba com_google_android_gms_common_api_internal_zzba, Lock lock, Looper looper, zzf com_google_android_gms_common_zzf, Map<zzc<?>, zze> map, zzr com_google_android_gms_common_internal_zzr, Map<Api<?>, Boolean> map2, zza<? extends zzcxd, zzcxe> com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzcxd__com_google_android_gms_internal_zzcxe, ArrayList<zzt> arrayList) {
        Map<Api<?>, Boolean> map3 = map2;
        Map arrayMap = new ArrayMap();
        Map arrayMap2 = new ArrayMap();
        zze com_google_android_gms_common_api_Api_zze = null;
        for (Entry entry : map.entrySet()) {
            zze com_google_android_gms_common_api_Api_zze2 = (zze) entry.getValue();
            if (com_google_android_gms_common_api_Api_zze2.mo3957c()) {
                com_google_android_gms_common_api_Api_zze = com_google_android_gms_common_api_Api_zze2;
            }
            if (com_google_android_gms_common_api_Api_zze2.mo4023h()) {
                arrayMap.put((zzc) entry.getKey(), com_google_android_gms_common_api_Api_zze2);
            } else {
                arrayMap2.put((zzc) entry.getKey(), com_google_android_gms_common_api_Api_zze2);
            }
        }
        zzbq.m4814a(arrayMap.isEmpty() ^ 1, (Object) "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        Map arrayMap3 = new ArrayMap();
        Map arrayMap4 = new ArrayMap();
        for (Api api : map2.keySet()) {
            zzc zzagf = api.zzagf();
            if (arrayMap.containsKey(zzagf)) {
                arrayMap3.put(api, (Boolean) map3.get(api));
            } else if (arrayMap2.containsKey(zzagf)) {
                arrayMap4.put(api, (Boolean) map3.get(api));
            } else {
                throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList;
        int size = arrayList4.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList4.get(i);
            i++;
            zzt com_google_android_gms_common_api_internal_zzt = (zzt) obj;
            if (arrayMap3.containsKey(com_google_android_gms_common_api_internal_zzt.f13970a)) {
                arrayList2.add(com_google_android_gms_common_api_internal_zzt);
            } else if (arrayMap4.containsKey(com_google_android_gms_common_api_internal_zzt.f13970a)) {
                arrayList3.add(com_google_android_gms_common_api_internal_zzt);
            } else {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
            }
        }
        return new zzv(context, com_google_android_gms_common_api_internal_zzba, lock, looper, com_google_android_gms_common_zzf, arrayMap, arrayMap2, com_google_android_gms_common_internal_zzr, com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzcxd__com_google_android_gms_internal_zzcxe, com_google_android_gms_common_api_Api_zze, arrayList2, arrayList3, arrayMap3, arrayMap4);
    }

    private final void m13055a(ConnectionResult connectionResult) {
        switch (this.f13986n) {
            case 1:
                break;
            case 2:
                this.f13974b.mo1592a(connectionResult);
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                break;
        }
        m13067h();
        this.f13986n = 0;
    }

    private static boolean m13061b(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.m17584b();
    }

    private final void m13067h() {
        for (zzcu m : this.f13979g) {
            m.mo3404m();
        }
        this.f13979g.clear();
    }

    private final PendingIntent m13069j() {
        return this.f13980h == null ? null : PendingIntent.getActivity(this.f13973a, System.identityHashCode(this.f13974b), this.f13980h.mo3958d(), MQEncoder.CARRY_MASK);
    }

    public final <A extends zzb, R extends Result, T extends zzm<R, A>> T mo1547a(T t) {
        if (!m13062c((zzm) t)) {
            return this.f13976d.mo1547a((zzm) t);
        }
        if (!m13068i()) {
            return this.f13977e.mo1547a((zzm) t);
        }
        t.m17674c(new Status(4, null, m13069j()));
        return t;
    }

    public final void mo1548a() {
        this.f13986n = 2;
        this.f13984l = false;
        this.f13983k = null;
        this.f13982j = null;
        this.f13976d.mo1548a();
        this.f13977e.mo1548a();
    }

    public final void mo1549a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("authClient").println(":");
        this.f13977e.mo1549a(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append(str).append("anonClient").println(":");
        this.f13976d.mo1549a(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    public final boolean mo1550a(zzcu com_google_android_gms_common_api_internal_zzcu) {
        this.f13985m.lock();
        boolean z;
        try {
            if ((mo1555e() || mo1554d()) && !this.f13977e.mo1554d()) {
                this.f13979g.add(com_google_android_gms_common_api_internal_zzcu);
                z = true;
                if (this.f13986n == 0) {
                    this.f13986n = 1;
                }
                this.f13983k = null;
                this.f13977e.mo1548a();
                return z;
            }
            this.f13985m.unlock();
            return false;
        } finally {
            z = this.f13985m;
            z.unlock();
        }
    }

    public final ConnectionResult mo1551b() {
        throw new UnsupportedOperationException();
    }

    public final <A extends zzb, T extends zzm<? extends Result, A>> T mo1552b(T t) {
        if (!m13062c((zzm) t)) {
            return this.f13976d.mo1552b((zzm) t);
        }
        if (!m13068i()) {
            return this.f13977e.mo1552b((zzm) t);
        }
        t.m17674c(new Status(4, null, m13069j()));
        return t;
    }

    public final void mo1553c() {
        this.f13983k = null;
        this.f13982j = null;
        this.f13986n = 0;
        this.f13976d.mo1553c();
        this.f13977e.mo1553c();
        m13067h();
    }

    public final boolean mo1554d() {
        this.f13985m.lock();
        try {
            boolean z = true;
            if (this.f13976d.mo1554d()) {
                if (!(this.f13977e.mo1554d() || m13068i())) {
                    if (this.f13986n == 1) {
                    }
                }
                this.f13985m.unlock();
                return z;
            }
            z = false;
            this.f13985m.unlock();
            return z;
        } catch (Throwable th) {
            this.f13985m.unlock();
        }
    }

    public final boolean mo1555e() {
        this.f13985m.lock();
        try {
            boolean z = this.f13986n == 2;
            this.f13985m.unlock();
            return z;
        } catch (Throwable th) {
            this.f13985m.unlock();
        }
    }

    public final void mo1556f() {
        this.f13985m.lock();
        try {
            boolean e = mo1555e();
            this.f13977e.mo1553c();
            this.f13983k = new ConnectionResult(4);
            if (e) {
                new Handler(this.f13975c).post(new zzw(this));
            } else {
                m13067h();
            }
            this.f13985m.unlock();
        } catch (Throwable th) {
            this.f13985m.unlock();
        }
    }

    public final void mo1557g() {
        this.f13976d.mo1557g();
        this.f13977e.mo1557g();
    }

    private final boolean m13068i() {
        return this.f13983k != null && this.f13983k.f17257b == 4;
    }

    private final boolean m13062c(zzm<? extends Result, ? extends zzb> com_google_android_gms_common_api_internal_zzm__extends_com_google_android_gms_common_api_Result___extends_com_google_android_gms_common_api_Api_zzb) {
        com_google_android_gms_common_api_internal_zzm__extends_com_google_android_gms_common_api_Result___extends_com_google_android_gms_common_api_Api_zzb = com_google_android_gms_common_api_internal_zzm__extends_com_google_android_gms_common_api_Result___extends_com_google_android_gms_common_api_Api_zzb.f17313d;
        zzbq.m4818b(this.f13978f.containsKey(com_google_android_gms_common_api_internal_zzm__extends_com_google_android_gms_common_api_Result___extends_com_google_android_gms_common_api_Api_zzb), "GoogleApiClient is not configured to use the API required for this call.");
        return ((zzbi) this.f13978f.get(com_google_android_gms_common_api_internal_zzm__extends_com_google_android_gms_common_api_Result___extends_com_google_android_gms_common_api_Api_zzb)).equals(this.f13977e);
    }

    static /* synthetic */ void m13060b(zzv com_google_android_gms_common_api_internal_zzv) {
        if (m13061b(com_google_android_gms_common_api_internal_zzv.f13982j)) {
            if (!m13061b(com_google_android_gms_common_api_internal_zzv.f13983k)) {
                if (!com_google_android_gms_common_api_internal_zzv.m13068i()) {
                    if (com_google_android_gms_common_api_internal_zzv.f13983k != null) {
                        if (com_google_android_gms_common_api_internal_zzv.f13986n == 1) {
                            com_google_android_gms_common_api_internal_zzv.m13067h();
                            return;
                        }
                        com_google_android_gms_common_api_internal_zzv.m13055a(com_google_android_gms_common_api_internal_zzv.f13983k);
                        com_google_android_gms_common_api_internal_zzv.f13976d.mo1553c();
                        return;
                    }
                }
            }
            switch (com_google_android_gms_common_api_internal_zzv.f13986n) {
                case 1:
                    break;
                case 2:
                    com_google_android_gms_common_api_internal_zzv.f13974b.mo1591a(com_google_android_gms_common_api_internal_zzv.f13981i);
                    break;
                default:
                    Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                    break;
            }
            com_google_android_gms_common_api_internal_zzv.m13067h();
            com_google_android_gms_common_api_internal_zzv.f13986n = 0;
        } else if (com_google_android_gms_common_api_internal_zzv.f13982j != null && m13061b(com_google_android_gms_common_api_internal_zzv.f13983k)) {
            com_google_android_gms_common_api_internal_zzv.f13977e.mo1553c();
            com_google_android_gms_common_api_internal_zzv.m13055a(com_google_android_gms_common_api_internal_zzv.f13982j);
        } else if (!(com_google_android_gms_common_api_internal_zzv.f13982j == null || com_google_android_gms_common_api_internal_zzv.f13983k == null)) {
            ConnectionResult connectionResult = com_google_android_gms_common_api_internal_zzv.f13982j;
            if (com_google_android_gms_common_api_internal_zzv.f13977e.f17287l < com_google_android_gms_common_api_internal_zzv.f13976d.f17287l) {
                connectionResult = com_google_android_gms_common_api_internal_zzv.f13983k;
            }
            com_google_android_gms_common_api_internal_zzv.m13055a(connectionResult);
        }
    }

    static /* synthetic */ void m13057a(zzv com_google_android_gms_common_api_internal_zzv, Bundle bundle) {
        if (com_google_android_gms_common_api_internal_zzv.f13981i == null) {
            com_google_android_gms_common_api_internal_zzv.f13981i = bundle;
            return;
        }
        if (bundle != null) {
            com_google_android_gms_common_api_internal_zzv.f13981i.putAll(bundle);
        }
    }

    static /* synthetic */ void m13056a(zzv com_google_android_gms_common_api_internal_zzv, int i, boolean z) {
        com_google_android_gms_common_api_internal_zzv.f13974b.mo1590a(i, z);
        com_google_android_gms_common_api_internal_zzv.f13983k = null;
        com_google_android_gms_common_api_internal_zzv.f13982j = null;
    }
}
