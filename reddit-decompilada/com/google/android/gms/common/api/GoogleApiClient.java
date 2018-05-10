package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.ApiOptions.NotRequiredOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.internal.zzba;
import com.google.android.gms.common.api.internal.zzce;
import com.google.android.gms.common.api.internal.zzcu;
import com.google.android.gms.common.api.internal.zzdg;
import com.google.android.gms.common.api.internal.zzi;
import com.google.android.gms.common.api.internal.zzm;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.internal.zzcxa;
import com.google.android.gms.internal.zzcxd;
import com.google.android.gms.internal.zzcxe;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;

public abstract class GoogleApiClient {
    private static final Set<GoogleApiClient> f5762a = Collections.newSetFromMap(new WeakHashMap());

    public static final class Builder {
        public zzce f5743a;
        public int f5744b = -1;
        public OnConnectionFailedListener f5745c;
        public Looper f5746d;
        private Account f5747e;
        private final Set<Scope> f5748f = new HashSet();
        private final Set<Scope> f5749g = new HashSet();
        private int f5750h;
        private View f5751i;
        private String f5752j;
        private String f5753k;
        private final Map<Api<?>, zzt> f5754l = new ArrayMap();
        private final Context f5755m;
        private final Map<Api<?>, ApiOptions> f5756n = new ArrayMap();
        private GoogleApiAvailability f5757o = GoogleApiAvailability.m12790a();
        private zza<? extends zzcxd, zzcxe> f5758p = zzcxa.f7196a;
        private final ArrayList<ConnectionCallbacks> f5759q = new ArrayList();
        private final ArrayList<OnConnectionFailedListener> f5760r = new ArrayList();
        private boolean f5761s = false;

        public Builder(Context context) {
            this.f5755m = context;
            this.f5746d = context.getMainLooper();
            this.f5752j = context.getPackageName();
            this.f5753k = context.getClass().getName();
        }

        public final Builder m4636a(Api<? extends NotRequiredOptions> api) {
            zzbq.m4809a((Object) api, (Object) "Api must not be null");
            this.f5756n.put(api, null);
            Collection a = api.zzagd().mo3408a(null);
            this.f5749g.addAll(a);
            this.f5748f.addAll(a);
            return this;
        }

        public final <O extends HasOptions> Builder m4637a(Api<O> api, O o) {
            zzbq.m4809a((Object) api, (Object) "Api must not be null");
            zzbq.m4809a((Object) o, (Object) "Null options are not permitted for this Api");
            this.f5756n.put(api, o);
            Collection a = api.zzagd().mo3408a(o);
            this.f5749g.addAll(a);
            this.f5748f.addAll(a);
            return this;
        }

        public final Builder m4638a(ConnectionCallbacks connectionCallbacks) {
            zzbq.m4809a((Object) connectionCallbacks, (Object) "Listener must not be null");
            this.f5759q.add(connectionCallbacks);
            return this;
        }

        public final Builder m4639a(OnConnectionFailedListener onConnectionFailedListener) {
            zzbq.m4809a((Object) onConnectionFailedListener, (Object) "Listener must not be null");
            this.f5760r.add(onConnectionFailedListener);
            return this;
        }

        public final GoogleApiClient m4640a() {
            boolean z;
            boolean z2 = true;
            zzbq.m4818b(this.f5756n.isEmpty() ^ true, "must call addApi() to add at least one API");
            zzcxe com_google_android_gms_internal_zzcxe = zzcxe.f19216a;
            if (this.f5756n.containsKey(zzcxa.f7197b)) {
                com_google_android_gms_internal_zzcxe = (zzcxe) r1.f5756n.get(zzcxa.f7197b);
            }
            zzr com_google_android_gms_common_internal_zzr = new zzr(r1.f5747e, r1.f5748f, r1.f5754l, r1.f5750h, r1.f5751i, r1.f5752j, r1.f5753k, com_google_android_gms_internal_zzcxe);
            Map map = com_google_android_gms_common_internal_zzr.f5944d;
            Map arrayMap = new ArrayMap();
            Map arrayMap2 = new ArrayMap();
            ArrayList arrayList = new ArrayList();
            Iterator it = r1.f5756n.keySet().iterator();
            Api api = null;
            while (true) {
                boolean z3 = false;
                if (!it.hasNext()) {
                    break;
                }
                Api api2 = (Api) it.next();
                Object obj = r1.f5756n.get(api2);
                if (map.get(api2) != null) {
                    z3 = z2;
                }
                arrayMap.put(api2, Boolean.valueOf(z3));
                com.google.android.gms.common.api.internal.zzt com_google_android_gms_common_api_internal_zzt = new com.google.android.gms.common.api.internal.zzt(api2, z3);
                arrayList.add(com_google_android_gms_common_api_internal_zzt);
                com.google.android.gms.common.api.internal.zzt com_google_android_gms_common_api_internal_zzt2 = com_google_android_gms_common_api_internal_zzt;
                Api api3 = api2;
                Map map2 = map;
                Api api4 = api;
                zze a = api2.zzage().mo3407a(r1.f5755m, r1.f5746d, com_google_android_gms_common_internal_zzr, obj, com_google_android_gms_common_api_internal_zzt2, com_google_android_gms_common_api_internal_zzt2);
                arrayMap2.put(api3.zzagf(), a);
                if (!a.mo3957c()) {
                    api = api4;
                } else if (api4 != null) {
                    String name = api3.getName();
                    String name2 = api4.getName();
                    StringBuilder stringBuilder = new StringBuilder((21 + String.valueOf(name).length()) + String.valueOf(name2).length());
                    stringBuilder.append(name);
                    stringBuilder.append(" cannot be used with ");
                    stringBuilder.append(name2);
                    throw new IllegalStateException(stringBuilder.toString());
                } else {
                    api = api3;
                }
                map = map2;
                z2 = true;
            }
            if (api != null) {
                z = true;
                zzbq.m4815a(r1.f5747e == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", api4.getName());
                zzbq.m4815a(r1.f5748f.equals(r1.f5749g), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", api4.getName());
            } else {
                z = true;
            }
            int a2 = zzba.m12951a(arrayMap2.values(), z);
            ArrayList arrayList2 = arrayList;
            GoogleApiClient com_google_android_gms_common_api_internal_zzba = new zzba(r1.f5755m, new ReentrantLock(), r1.f5746d, com_google_android_gms_common_internal_zzr, r1.f5757o, r1.f5758p, arrayMap, r1.f5759q, r1.f5760r, arrayMap2, r1.f5744b, a2, arrayList2);
            synchronized (GoogleApiClient.f5762a) {
                try {
                    GoogleApiClient.f5762a.add(com_google_android_gms_common_api_internal_zzba);
                } catch (Throwable th) {
                    while (true) {
                        Throwable th2 = th;
                    }
                }
            }
            if (r1.f5744b >= 0) {
                zzi.m17663b(r1.f5743a).m17664a(r1.f5744b, com_google_android_gms_common_api_internal_zzba, r1.f5745c);
            }
            return com_google_android_gms_common_api_internal_zzba;
        }
    }

    public interface ConnectionCallbacks {
        void mo1581a(int i);

        void mo1582a(Bundle bundle);
    }

    public interface OnConnectionFailedListener {
        void mo1583a(ConnectionResult connectionResult);
    }

    public static Set<GoogleApiClient> m4644a() {
        Set<GoogleApiClient> set;
        synchronized (f5762a) {
            set = f5762a;
        }
        return set;
    }

    public <C extends zze> C mo1587a(zzc<C> com_google_android_gms_common_api_Api_zzc_C) {
        throw new UnsupportedOperationException();
    }

    public <A extends zzb, R extends Result, T extends zzm<R, A>> T mo1588a(T t) {
        throw new UnsupportedOperationException();
    }

    public void mo1589a(int i) {
        throw new UnsupportedOperationException();
    }

    public abstract void mo1560a(OnConnectionFailedListener onConnectionFailedListener);

    public void mo1593a(zzdg com_google_android_gms_common_api_internal_zzdg) {
        throw new UnsupportedOperationException();
    }

    public abstract void mo1561a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public boolean mo1594a(Api<?> api) {
        throw new UnsupportedOperationException();
    }

    public boolean mo1595a(zzcu com_google_android_gms_common_api_internal_zzcu) {
        throw new UnsupportedOperationException();
    }

    public Context mo1596b() {
        throw new UnsupportedOperationException();
    }

    public <A extends zzb, T extends zzm<? extends Result, A>> T mo1597b(T t) {
        throw new UnsupportedOperationException();
    }

    public abstract void mo1562b(OnConnectionFailedListener onConnectionFailedListener);

    public void mo1598b(zzdg com_google_android_gms_common_api_internal_zzdg) {
        throw new UnsupportedOperationException();
    }

    public Looper mo1599c() {
        throw new UnsupportedOperationException();
    }

    public void mo1600d() {
        throw new UnsupportedOperationException();
    }

    public abstract void mo1563e();

    public abstract ConnectionResult mo1564f();

    public abstract void mo1565g();

    public abstract void mo1566h();

    public abstract PendingResult<Status> mo1567i();

    public abstract boolean mo1568j();

    public abstract boolean mo1569k();
}
