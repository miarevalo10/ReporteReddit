package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzae;
import com.google.android.gms.common.internal.zzaf;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.common.zzf;
import com.google.android.gms.internal.zzbft;
import com.google.android.gms.internal.zzcxd;
import com.google.android.gms.internal.zzcxe;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

public final class zzba extends GoogleApiClient implements zzcd {
    final Queue<zzm<?, ?>> f13895a = new LinkedList();
    final Map<zzc<?>, zze> f13896b;
    Set<Scope> f13897c = new HashSet();
    Set<zzdg> f13898d = null;
    final zzdj f13899e;
    private final Lock f13900f;
    private boolean f13901g;
    private final zzae f13902h;
    private zzcc f13903i = null;
    private final int f13904j;
    private final Context f13905k;
    private final Looper f13906l;
    private volatile boolean f13907m;
    private long f13908n = 120000;
    private long f13909o = 5000;
    private final zzbf f13910p;
    private final GoogleApiAvailability f13911q;
    private zzbx f13912r;
    private zzr f13913s;
    private Map<Api<?>, Boolean> f13914t;
    private zza<? extends zzcxd, zzcxe> f13915u;
    private final zzcm f13916v = new zzcm();
    private final ArrayList<zzt> f13917w;
    private Integer f13918x = null;
    private final zzaf f13919y = new zzbb(this);

    public static int m12951a(Iterable<zze> iterable, boolean z) {
        int i = 0;
        int i2 = 0;
        for (zze com_google_android_gms_common_api_Api_zze : iterable) {
            if (com_google_android_gms_common_api_Api_zze.mo4023h()) {
                i = 1;
            }
            if (com_google_android_gms_common_api_Api_zze.mo3957c()) {
                i2 = 1;
            }
        }
        return i != 0 ? (i2 == 0 || !z) ? 1 : 2 : 3;
    }

    private final void m12952a(GoogleApiClient googleApiClient, zzda com_google_android_gms_common_api_internal_zzda, boolean z) {
        zzbft.f6696c.mo1768a(googleApiClient).mo1543a(new zzbe(this, com_google_android_gms_common_api_internal_zzda, z, googleApiClient));
    }

    private final void m12955b(int i) {
        if (this.f13918x == null) {
            this.f13918x = Integer.valueOf(i);
        } else if (this.f13918x.intValue() != i) {
            String c = m12958c(i);
            String c2 = m12958c(this.f13918x.intValue());
            StringBuilder stringBuilder = new StringBuilder((51 + String.valueOf(c).length()) + String.valueOf(c2).length());
            stringBuilder.append("Cannot use sign-in mode: ");
            stringBuilder.append(c);
            stringBuilder.append(". Mode was already set to ");
            stringBuilder.append(c2);
            throw new IllegalStateException(stringBuilder.toString());
        }
        if (this.f13903i == null) {
            Object obj = null;
            Object obj2 = null;
            for (zze com_google_android_gms_common_api_Api_zze : this.f13896b.values()) {
                if (com_google_android_gms_common_api_Api_zze.mo4023h()) {
                    obj = 1;
                }
                if (com_google_android_gms_common_api_Api_zze.mo3957c()) {
                    obj2 = 1;
                }
            }
            switch (this.f13918x.intValue()) {
                case 1:
                    if (obj == null) {
                        throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
                    } else if (obj2 != null) {
                        throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
                    }
                    break;
                case 2:
                    if (obj != null) {
                        if (this.f13901g) {
                            this.f13903i = new zzaa(this.f13905k, this.f13900f, this.f13906l, this.f13911q, this.f13896b, this.f13913s, this.f13914t, this.f13915u, this.f13917w, this, true);
                            return;
                        } else {
                            this.f13903i = zzv.m13053a(this.f13905k, this, this.f13900f, this.f13906l, this.f13911q, this.f13896b, this.f13913s, this.f13914t, this.f13915u, this.f13917w);
                            return;
                        }
                    }
                    break;
                case 3:
                    break;
                default:
                    break;
            }
            if (this.f13901g && obj2 == null) {
                this.f13903i = new zzaa(this.f13905k, this.f13900f, this.f13906l, this.f13911q, this.f13896b, this.f13913s, this.f13914t, this.f13915u, this.f13917w, this, false);
            } else {
                this.f13903i = new zzbi(this.f13905k, this, this.f13900f, this.f13906l, this.f13911q, this.f13896b, this.f13913s, this.f13914t, this.f13915u, this.f13917w, this);
            }
        }
    }

    private static String m12958c(int i) {
        switch (i) {
            case 1:
                return "SIGN_IN_MODE_REQUIRED";
            case 2:
                return "SIGN_IN_MODE_OPTIONAL";
            case 3:
                return "SIGN_IN_MODE_NONE";
            default:
                return "UNKNOWN";
        }
    }

    public final <C extends zze> C mo1587a(zzc<C> com_google_android_gms_common_api_Api_zzc_C) {
        Object obj = (zze) this.f13896b.get(com_google_android_gms_common_api_Api_zzc_C);
        zzbq.m4809a(obj, (Object) "Appropriate Api was not requested.");
        return obj;
    }

    public final void mo1589a(int i) {
        this.f13900f.lock();
        boolean z = true;
        if (!(i == 3 || i == 1)) {
            if (i != 2) {
                z = false;
            }
        }
        try {
            StringBuilder stringBuilder = new StringBuilder(33);
            stringBuilder.append("Illegal sign-in mode: ");
            stringBuilder.append(i);
            zzbq.m4818b(z, stringBuilder.toString());
            m12955b(i);
            m12959p();
        } finally {
            this.f13900f.unlock();
        }
    }

    public final void mo1560a(OnConnectionFailedListener onConnectionFailedListener) {
        this.f13902h.m4780a(onConnectionFailedListener);
    }

    public final void mo1593a(zzdg com_google_android_gms_common_api_internal_zzdg) {
        this.f13900f.lock();
        try {
            if (this.f13898d == null) {
                this.f13898d = new HashSet();
            }
            this.f13898d.add(com_google_android_gms_common_api_internal_zzdg);
        } finally {
            this.f13900f.unlock();
        }
    }

    public final void mo1561a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("mContext=").println(this.f13905k);
        printWriter.append(str).append("mResuming=").print(this.f13907m);
        printWriter.append(" mWorkQueue.size()=").print(this.f13895a.size());
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.f13899e.f5835c.size());
        if (this.f13903i != null) {
            this.f13903i.mo1549a(str, fileDescriptor, printWriter, strArr);
        }
    }

    public final boolean mo1594a(Api<?> api) {
        return this.f13896b.containsKey(api.zzagf());
    }

    public final boolean mo1595a(zzcu com_google_android_gms_common_api_internal_zzcu) {
        return this.f13903i != null && this.f13903i.mo1550a(com_google_android_gms_common_api_internal_zzcu);
    }

    public final Context mo1596b() {
        return this.f13905k;
    }

    public final void mo1598b(zzdg com_google_android_gms_common_api_internal_zzdg) {
        this.f13900f.lock();
        try {
            String str;
            String str2;
            Throwable exception;
            if (this.f13898d == null) {
                str = "GoogleApiClientImpl";
                str2 = "Attempted to remove pending transform when no transforms are registered.";
                exception = new Exception();
            } else if (this.f13898d.remove(com_google_android_gms_common_api_internal_zzdg)) {
                if (!m12985n()) {
                    this.f13903i.mo1557g();
                }
                this.f13900f.unlock();
            } else {
                str = "GoogleApiClientImpl";
                str2 = "Failed to remove pending transform - this may lead to memory leaks!";
                exception = new Exception();
            }
            Log.wtf(str, str2, exception);
            this.f13900f.unlock();
        } catch (Throwable th) {
            this.f13900f.unlock();
        }
    }

    public final Looper mo1599c() {
        return this.f13906l;
    }

    public final void mo1600d() {
        if (this.f13903i != null) {
            this.f13903i.mo1556f();
        }
    }

    public final void mo1563e() {
        this.f13900f.lock();
        try {
            boolean z = false;
            if (this.f13904j >= 0) {
                if (this.f13918x != null) {
                    z = true;
                }
                zzbq.m4814a(z, (Object) "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.f13918x == null) {
                this.f13918x = Integer.valueOf(m12951a(this.f13896b.values(), false));
            } else if (this.f13918x.intValue() == 2) {
                throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            mo1589a(this.f13918x.intValue());
        } finally {
            this.f13900f.unlock();
        }
    }

    public final void mo1566h() {
        mo1565g();
        mo1563e();
    }

    public final boolean mo1568j() {
        return this.f13903i != null && this.f13903i.mo1554d();
    }

    public final boolean mo1569k() {
        return this.f13903i != null && this.f13903i.mo1555e();
    }

    final boolean m12984m() {
        if (!this.f13907m) {
            return false;
        }
        this.f13907m = false;
        this.f13910p.removeMessages(2);
        this.f13910p.removeMessages(1);
        if (this.f13912r != null) {
            this.f13912r.m4732a();
            this.f13912r = null;
        }
        return true;
    }

    final boolean m12985n() {
        this.f13900f.lock();
        try {
            if (this.f13898d == null) {
                return false;
            }
            boolean isEmpty = this.f13898d.isEmpty() ^ 1;
            this.f13900f.unlock();
            return isEmpty;
        } finally {
            this.f13900f.unlock();
        }
    }

    final String m12986o() {
        Writer stringWriter = new StringWriter();
        mo1561a("", null, new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }

    public zzba(Context context, Lock lock, Looper looper, zzr com_google_android_gms_common_internal_zzr, GoogleApiAvailability googleApiAvailability, zza<? extends zzcxd, zzcxe> com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzcxd__com_google_android_gms_internal_zzcxe, Map<Api<?>, Boolean> map, List<ConnectionCallbacks> list, List<OnConnectionFailedListener> list2, Map<zzc<?>, zze> map2, int i, int i2, ArrayList<zzt> arrayList) {
        Looper looper2 = looper;
        this.f13905k = context;
        this.f13900f = lock;
        this.f13901g = false;
        this.f13902h = new zzae(looper2, this.f13919y);
        this.f13906l = looper2;
        this.f13910p = new zzbf(this, looper2);
        this.f13911q = googleApiAvailability;
        this.f13904j = i;
        if (this.f13904j >= 0) {
            r1.f13918x = Integer.valueOf(i2);
        }
        r1.f13914t = map;
        r1.f13896b = map2;
        r1.f13917w = arrayList;
        r1.f13899e = new zzdj(r1.f13896b);
        for (Object obj : list) {
            zzae com_google_android_gms_common_internal_zzae = r1.f13902h;
            zzbq.m4808a(obj);
            synchronized (com_google_android_gms_common_internal_zzae.f5876i) {
                try {
                    if (com_google_android_gms_common_internal_zzae.f5869b.contains(obj)) {
                        String valueOf = String.valueOf(obj);
                        StringBuilder stringBuilder = new StringBuilder(62 + String.valueOf(valueOf).length());
                        stringBuilder.append("registerConnectionCallbacks(): listener ");
                        stringBuilder.append(valueOf);
                        stringBuilder.append(" is already registered");
                        Log.w("GmsClientEvents", stringBuilder.toString());
                    } else {
                        com_google_android_gms_common_internal_zzae.f5869b.add(obj);
                    }
                } catch (Throwable th) {
                    while (true) {
                        Throwable th2 = th;
                    }
                }
            }
            if (com_google_android_gms_common_internal_zzae.f5868a.mo1601f()) {
                com_google_android_gms_common_internal_zzae.f5875h.sendMessage(com_google_android_gms_common_internal_zzae.f5875h.obtainMessage(1, obj));
            }
        }
        for (OnConnectionFailedListener a : list2) {
            r1.f13902h.m4780a(a);
        }
        r1.f13913s = com_google_android_gms_common_internal_zzr;
        r1.f13915u = com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzcxd__com_google_android_gms_internal_zzcxe;
    }

    public final <A extends zzb, R extends Result, T extends zzm<R, A>> T mo1588a(T t) {
        zzbq.m4818b(t.f17313d != null, "This task can not be enqueued (it's probably a Batch or malformed)");
        boolean containsKey = this.f13896b.containsKey(t.f17313d);
        String name = t.f17314e != null ? t.f17314e.getName() : "the API";
        StringBuilder stringBuilder = new StringBuilder(65 + String.valueOf(name).length());
        stringBuilder.append("GoogleApiClient is not configured to use ");
        stringBuilder.append(name);
        stringBuilder.append(" required for this call.");
        zzbq.m4818b(containsKey, stringBuilder.toString());
        this.f13900f.lock();
        try {
            if (this.f13903i == null) {
                this.f13895a.add(t);
            } else {
                t = this.f13903i.mo1547a((zzm) t);
            }
            this.f13900f.unlock();
            return t;
        } catch (Throwable th) {
            this.f13900f.unlock();
        }
    }

    public final <A extends zzb, T extends zzm<? extends Result, A>> T mo1597b(T t) {
        zzbq.m4818b(t.f17313d != null, "This task can not be executed (it's probably a Batch or malformed)");
        boolean containsKey = this.f13896b.containsKey(t.f17313d);
        String name = t.f17314e != null ? t.f17314e.getName() : "the API";
        StringBuilder stringBuilder = new StringBuilder(65 + String.valueOf(name).length());
        stringBuilder.append("GoogleApiClient is not configured to use ");
        stringBuilder.append(name);
        stringBuilder.append(" required for this call.");
        zzbq.m4818b(containsKey, stringBuilder.toString());
        this.f13900f.lock();
        try {
            if (this.f13903i == null) {
                throw new IllegalStateException("GoogleApiClient is not connected yet.");
            }
            if (this.f13907m) {
                this.f13895a.add(t);
                while (!this.f13895a.isEmpty()) {
                    zzm com_google_android_gms_common_api_internal_zzm = (zzm) this.f13895a.remove();
                    this.f13899e.m4764a(com_google_android_gms_common_api_internal_zzm);
                    com_google_android_gms_common_api_internal_zzm.m17674c(Status.f17265c);
                }
            } else {
                t = this.f13903i.mo1552b(t);
            }
            this.f13900f.unlock();
            return t;
        } catch (Throwable th) {
            this.f13900f.unlock();
        }
    }

    public final ConnectionResult mo1564f() {
        boolean z = false;
        zzbq.m4814a(Looper.myLooper() != Looper.getMainLooper(), (Object) "blockingConnect must not be called on the UI thread");
        this.f13900f.lock();
        try {
            if (this.f13904j >= 0) {
                if (this.f13918x != null) {
                    z = true;
                }
                zzbq.m4814a(z, (Object) "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.f13918x == null) {
                this.f13918x = Integer.valueOf(m12951a(this.f13896b.values(), false));
            } else if (this.f13918x.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            m12955b(this.f13918x.intValue());
            this.f13902h.f5872e = true;
            ConnectionResult b = this.f13903i.mo1551b();
            return b;
        } finally {
            this.f13900f.unlock();
        }
    }

    public final void mo1565g() {
        this.f13900f.lock();
        try {
            this.f13899e.m4763a();
            if (this.f13903i != null) {
                this.f13903i.mo1553c();
            }
            zzcm com_google_android_gms_common_api_internal_zzcm = this.f13916v;
            for (zzci com_google_android_gms_common_api_internal_zzci : com_google_android_gms_common_api_internal_zzcm.f5816a) {
                com_google_android_gms_common_api_internal_zzci.f5810a = null;
            }
            com_google_android_gms_common_api_internal_zzcm.f5816a.clear();
            for (zzm com_google_android_gms_common_api_internal_zzm : this.f13895a) {
                com_google_android_gms_common_api_internal_zzm.m12828a(null);
                com_google_android_gms_common_api_internal_zzm.mo1544c();
            }
            this.f13895a.clear();
            if (this.f13903i != null) {
                m12984m();
                this.f13902h.m4779a();
            }
            this.f13900f.unlock();
        } catch (Throwable th) {
            this.f13900f.unlock();
        }
    }

    public final PendingResult<Status> mo1567i() {
        zzbq.m4814a(mo1568j(), (Object) "GoogleApiClient is not connected yet.");
        zzbq.m4814a(this.f13918x.intValue() != 2, (Object) "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        zzda com_google_android_gms_common_api_internal_zzda = new zzda(this);
        if (this.f13896b.containsKey(zzbft.f6694a)) {
            m12952a((GoogleApiClient) this, com_google_android_gms_common_api_internal_zzda, false);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            Builder a = new Builder(this.f13905k).m4636a(zzbft.f6695b).m4638a(new zzbc(this, atomicReference, com_google_android_gms_common_api_internal_zzda)).m4639a(new zzbd(com_google_android_gms_common_api_internal_zzda));
            Object obj = this.f13910p;
            zzbq.m4809a(obj, (Object) "Handler must not be null");
            a.f5746d = obj.getLooper();
            GoogleApiClient a2 = a.m4640a();
            atomicReference.set(a2);
            a2.mo1563e();
        }
        return com_google_android_gms_common_api_internal_zzda;
    }

    private final void m12959p() {
        this.f13902h.f5872e = true;
        this.f13903i.mo1548a();
    }

    public final void mo1562b(OnConnectionFailedListener onConnectionFailedListener) {
        zzae com_google_android_gms_common_internal_zzae = this.f13902h;
        zzbq.m4808a((Object) onConnectionFailedListener);
        synchronized (com_google_android_gms_common_internal_zzae.f5876i) {
            if (!com_google_android_gms_common_internal_zzae.f5871d.remove(onConnectionFailedListener)) {
                onConnectionFailedListener = String.valueOf(onConnectionFailedListener);
                StringBuilder stringBuilder = new StringBuilder(57 + String.valueOf(onConnectionFailedListener).length());
                stringBuilder.append("unregisterConnectionFailedListener(): listener ");
                stringBuilder.append(onConnectionFailedListener);
                stringBuilder.append(" not found");
                Log.w("GmsClientEvents", stringBuilder.toString());
            }
        }
    }

    public final void mo1591a(Bundle bundle) {
        while (!this.f13895a.isEmpty()) {
            mo1597b((zzm) this.f13895a.remove());
        }
        zzae com_google_android_gms_common_internal_zzae = this.f13902h;
        boolean z = true;
        zzbq.m4814a(Looper.myLooper() == com_google_android_gms_common_internal_zzae.f5875h.getLooper(), (Object) "onConnectionSuccess must only be called on the Handler thread");
        synchronized (com_google_android_gms_common_internal_zzae.f5876i) {
            zzbq.m4813a(com_google_android_gms_common_internal_zzae.f5874g ^ true);
            com_google_android_gms_common_internal_zzae.f5875h.removeMessages(1);
            com_google_android_gms_common_internal_zzae.f5874g = true;
            if (com_google_android_gms_common_internal_zzae.f5870c.size() != 0) {
                z = false;
            }
            zzbq.m4813a(z);
            ArrayList arrayList = new ArrayList(com_google_android_gms_common_internal_zzae.f5869b);
            int i = com_google_android_gms_common_internal_zzae.f5873f.get();
            arrayList = arrayList;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                ConnectionCallbacks connectionCallbacks = (ConnectionCallbacks) obj;
                if (!com_google_android_gms_common_internal_zzae.f5872e || !com_google_android_gms_common_internal_zzae.f5868a.mo1601f() || com_google_android_gms_common_internal_zzae.f5873f.get() != i) {
                    break;
                } else if (!com_google_android_gms_common_internal_zzae.f5870c.contains(connectionCallbacks)) {
                    connectionCallbacks.mo1582a(bundle);
                }
            }
            com_google_android_gms_common_internal_zzae.f5870c.clear();
            com_google_android_gms_common_internal_zzae.f5874g = false;
        }
    }

    public final void mo1592a(ConnectionResult connectionResult) {
        if (!zzf.m4931b(this.f13905k, connectionResult.f17257b)) {
            m12984m();
        }
        if (!this.f13907m) {
            zzae com_google_android_gms_common_internal_zzae = this.f13902h;
            int i = 0;
            zzbq.m4814a(Looper.myLooper() == com_google_android_gms_common_internal_zzae.f5875h.getLooper(), (Object) "onConnectionFailure must only be called on the Handler thread");
            com_google_android_gms_common_internal_zzae.f5875h.removeMessages(1);
            synchronized (com_google_android_gms_common_internal_zzae.f5876i) {
                ArrayList arrayList = new ArrayList(com_google_android_gms_common_internal_zzae.f5871d);
                int i2 = com_google_android_gms_common_internal_zzae.f5873f.get();
                arrayList = arrayList;
                int size = arrayList.size();
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    OnConnectionFailedListener onConnectionFailedListener = (OnConnectionFailedListener) obj;
                    if (!com_google_android_gms_common_internal_zzae.f5872e) {
                        break;
                    } else if (com_google_android_gms_common_internal_zzae.f5873f.get() != i2) {
                        break;
                    } else if (com_google_android_gms_common_internal_zzae.f5871d.contains(onConnectionFailedListener)) {
                        onConnectionFailedListener.mo1583a(connectionResult);
                    }
                }
            }
            this.f13902h.m4779a();
        }
    }

    public final void mo1590a(int i, boolean z) {
        int i2;
        if (!(i != 1 || z || this.f13907m)) {
            this.f13907m = true;
            if (!this.f13912r) {
                this.f13912r = GoogleApiAvailability.m12791a(this.f13905k.getApplicationContext(), new zzbg(this));
            }
            this.f13910p.sendMessageDelayed(this.f13910p.obtainMessage(1), this.f13908n);
            this.f13910p.sendMessageDelayed(this.f13910p.obtainMessage(2), this.f13909o);
        }
        for (BasePendingResult b : (BasePendingResult[]) this.f13899e.f5835c.toArray(zzdj.f5834b)) {
            b.m12830b(zzdj.f5833a);
        }
        z = this.f13902h;
        zzbq.m4814a(Looper.myLooper() == z.f5875h.getLooper(), (Object) "onUnintentionalDisconnection must only be called on the Handler thread");
        z.f5875h.removeMessages(1);
        synchronized (z.f5876i) {
            z.f5874g = true;
            ArrayList arrayList = new ArrayList(z.f5869b);
            i2 = z.f5873f.get();
            arrayList = arrayList;
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                ConnectionCallbacks connectionCallbacks = (ConnectionCallbacks) obj;
                if (!z.f5872e || z.f5873f.get() != i2) {
                    break;
                } else if (z.f5869b.contains(connectionCallbacks)) {
                    connectionCallbacks.mo1581a(i);
                }
            }
            z.f5870c.clear();
            z.f5874g = false;
        }
        this.f13902h.m4779a();
        if (i == 2) {
            m12959p();
        }
    }

    static /* synthetic */ void m12953a(zzba com_google_android_gms_common_api_internal_zzba) {
        com_google_android_gms_common_api_internal_zzba.f13900f.lock();
        try {
            if (com_google_android_gms_common_api_internal_zzba.f13907m) {
                com_google_android_gms_common_api_internal_zzba.m12959p();
            }
            com_google_android_gms_common_api_internal_zzba.f13900f.unlock();
        } catch (Throwable th) {
            com_google_android_gms_common_api_internal_zzba.f13900f.unlock();
        }
    }

    static /* synthetic */ void m12956b(zzba com_google_android_gms_common_api_internal_zzba) {
        com_google_android_gms_common_api_internal_zzba.f13900f.lock();
        try {
            if (com_google_android_gms_common_api_internal_zzba.m12984m()) {
                com_google_android_gms_common_api_internal_zzba.m12959p();
            }
            com_google_android_gms_common_api_internal_zzba.f13900f.unlock();
        } catch (Throwable th) {
            com_google_android_gms_common_api_internal_zzba.f13900f.unlock();
        }
    }
}
