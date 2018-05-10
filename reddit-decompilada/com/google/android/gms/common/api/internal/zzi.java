package com.google.android.gms.common.api.internal;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzbq;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class zzi extends zzo {
    private final SparseArray<zza> f17312b = new SparseArray();

    class zza implements OnConnectionFailedListener {
        public final int f13960a;
        public final GoogleApiClient f13961b;
        public final OnConnectionFailedListener f13962c;
        private /* synthetic */ zzi f13963d;

        public zza(zzi com_google_android_gms_common_api_internal_zzi, int i, GoogleApiClient googleApiClient, OnConnectionFailedListener onConnectionFailedListener) {
            this.f13963d = com_google_android_gms_common_api_internal_zzi;
            this.f13960a = i;
            this.f13961b = googleApiClient;
            this.f13962c = onConnectionFailedListener;
            googleApiClient.mo1560a((OnConnectionFailedListener) this);
        }

        public final void mo1583a(ConnectionResult connectionResult) {
            String valueOf = String.valueOf(connectionResult);
            StringBuilder stringBuilder = new StringBuilder(27 + String.valueOf(valueOf).length());
            stringBuilder.append("beginFailureResolution for ");
            stringBuilder.append(valueOf);
            Log.d("AutoManageHelper", stringBuilder.toString());
            this.f13963d.m13042b(connectionResult, this.f13960a);
        }
    }

    private zzi(zzcf com_google_android_gms_common_api_internal_zzcf) {
        super(com_google_android_gms_common_api_internal_zzcf);
        this.a.mo1610a("AutoManageHelper", (LifecycleCallback) this);
    }

    private final zza m17662a(int i) {
        return this.f17312b.size() <= i ? null : (zza) this.f17312b.get(this.f17312b.keyAt(i));
    }

    public static zzi m17663b(zzce com_google_android_gms_common_api_internal_zzce) {
        zzcf a = LifecycleCallback.m4680a(com_google_android_gms_common_api_internal_zzce);
        zzi com_google_android_gms_common_api_internal_zzi = (zzi) a.mo1609a("AutoManageHelper", zzi.class);
        return com_google_android_gms_common_api_internal_zzi != null ? com_google_android_gms_common_api_internal_zzi : new zzi(a);
    }

    public final void m17664a(int i, GoogleApiClient googleApiClient, OnConnectionFailedListener onConnectionFailedListener) {
        zzbq.m4809a((Object) googleApiClient, (Object) "GoogleApiClient instance cannot be null");
        boolean z = this.f17312b.indexOfKey(i) < 0;
        StringBuilder stringBuilder = new StringBuilder(54);
        stringBuilder.append("Already managing a GoogleApiClient with id ");
        stringBuilder.append(i);
        zzbq.m4814a(z, stringBuilder.toString());
        zzp com_google_android_gms_common_api_internal_zzp = (zzp) this.d.get();
        boolean z2 = this.c;
        String valueOf = String.valueOf(com_google_android_gms_common_api_internal_zzp);
        StringBuilder stringBuilder2 = new StringBuilder(49 + String.valueOf(valueOf).length());
        stringBuilder2.append("starting AutoManage for client ");
        stringBuilder2.append(i);
        stringBuilder2.append(" ");
        stringBuilder2.append(z2);
        stringBuilder2.append(" ");
        stringBuilder2.append(valueOf);
        Log.d("AutoManageHelper", stringBuilder2.toString());
        this.f17312b.put(i, new zza(this, i, googleApiClient, onConnectionFailedListener));
        if (this.c && com_google_android_gms_common_api_internal_zzp == null) {
            String valueOf2 = String.valueOf(googleApiClient);
            StringBuilder stringBuilder3 = new StringBuilder(11 + String.valueOf(valueOf2).length());
            stringBuilder3.append("connecting ");
            stringBuilder3.append(valueOf2);
            Log.d("AutoManageHelper", stringBuilder3.toString());
            googleApiClient.mo1563e();
        }
    }

    public final void mo3420a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i = 0; i < this.f17312b.size(); i++) {
            zza a = m17662a(i);
            if (a != null) {
                printWriter.append(str).append("GoogleApiClient #").print(a.f13960a);
                printWriter.println(":");
                a.f13961b.mo1561a(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
            }
        }
    }

    public final void mo1615b() {
        super.mo1615b();
        boolean z = this.c;
        String valueOf = String.valueOf(this.f17312b);
        StringBuilder stringBuilder = new StringBuilder(14 + String.valueOf(valueOf).length());
        stringBuilder.append("onStart ");
        stringBuilder.append(z);
        stringBuilder.append(" ");
        stringBuilder.append(valueOf);
        Log.d("AutoManageHelper", stringBuilder.toString());
        if (this.d.get() == null) {
            for (int i = 0; i < this.f17312b.size(); i++) {
                zza a = m17662a(i);
                if (a != null) {
                    a.f13961b.mo1563e();
                }
            }
        }
    }

    public final void mo1617d() {
        super.mo1617d();
        for (int i = 0; i < this.f17312b.size(); i++) {
            zza a = m17662a(i);
            if (a != null) {
                a.f13961b.mo1565g();
            }
        }
    }

    protected final void mo3412e() {
        for (int i = 0; i < this.f17312b.size(); i++) {
            zza a = m17662a(i);
            if (a != null) {
                a.f13961b.mo1563e();
            }
        }
    }

    protected final void mo3410a(ConnectionResult connectionResult, int i) {
        Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
        if (i < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        zza com_google_android_gms_common_api_internal_zzi_zza = (zza) this.f17312b.get(i);
        if (com_google_android_gms_common_api_internal_zzi_zza != null) {
            OnConnectionFailedListener onConnectionFailedListener = (zza) this.f17312b.get(i);
            this.f17312b.remove(i);
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.f13961b.mo1562b(onConnectionFailedListener);
                onConnectionFailedListener.f13961b.mo1565g();
            }
            i = com_google_android_gms_common_api_internal_zzi_zza.f13962c;
            if (i != 0) {
                i.mo1583a(connectionResult);
            }
        }
    }
}
