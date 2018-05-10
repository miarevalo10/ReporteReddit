package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzci;
import com.google.android.gms.common.api.internal.zzn;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.zzag;
import com.google.android.gms.location.zzp;
import com.google.android.gms.location.zzs;

public final class zzcfk extends zzcdt {
    final zzcfd f19568i;

    public zzcfk(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, zzr com_google_android_gms_common_internal_zzr) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, str, com_google_android_gms_common_internal_zzr);
        this.f19568i = new zzcfd(context, this.a);
    }

    public final void m20969a(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, zzn<Status> com_google_android_gms_common_api_internal_zzn_com_google_android_gms_common_api_Status) throws RemoteException {
        m4862q();
        zzbq.m4809a((Object) geofencingRequest, (Object) "geofencingRequest can't be null.");
        zzbq.m4809a((Object) pendingIntent, (Object) "PendingIntent must be specified.");
        zzbq.m4809a((Object) com_google_android_gms_common_api_internal_zzn_com_google_android_gms_common_api_Status, (Object) "ResultHolder not provided.");
        ((zzcez) m4863r()).mo1803a(geofencingRequest, pendingIntent, new zzcfl(com_google_android_gms_common_api_internal_zzn_com_google_android_gms_common_api_Status));
    }

    public final void m20971a(LocationSettingsRequest locationSettingsRequest, zzn<LocationSettingsResult> com_google_android_gms_common_api_internal_zzn_com_google_android_gms_location_LocationSettingsResult, String str) throws RemoteException {
        m4862q();
        boolean z = false;
        zzbq.m4818b(locationSettingsRequest != null, "locationSettingsRequest can't be null nor empty.");
        if (com_google_android_gms_common_api_internal_zzn_com_google_android_gms_location_LocationSettingsResult != null) {
            z = true;
        }
        zzbq.m4818b(z, "listener can't be null.");
        ((zzcez) m4863r()).mo1804a(locationSettingsRequest, new zzcfn(com_google_android_gms_common_api_internal_zzn_com_google_android_gms_location_LocationSettingsResult), str);
    }

    public final void m20972a(zzag com_google_android_gms_location_zzag, zzn<Status> com_google_android_gms_common_api_internal_zzn_com_google_android_gms_common_api_Status) throws RemoteException {
        m4862q();
        zzbq.m4809a((Object) com_google_android_gms_location_zzag, (Object) "removeGeofencingRequest can't be null.");
        zzbq.m4809a((Object) com_google_android_gms_common_api_internal_zzn_com_google_android_gms_common_api_Status, (Object) "ResultHolder not provided.");
        ((zzcez) m4863r()).mo1805a(com_google_android_gms_location_zzag, new zzcfm(com_google_android_gms_common_api_internal_zzn_com_google_android_gms_common_api_Status));
    }

    public final void mo4292e() {
        synchronized (this.f19568i) {
            if (m4853f()) {
                try {
                    zzcfd com_google_android_gms_internal_zzcfd = this.f19568i;
                    synchronized (com_google_android_gms_internal_zzcfd.f6784d) {
                        for (zzs com_google_android_gms_location_zzs : com_google_android_gms_internal_zzcfd.f6784d.values()) {
                            if (com_google_android_gms_location_zzs != null) {
                                ((zzcez) com_google_android_gms_internal_zzcfd.f6781a.mo1780b()).mo1802a(zzcfq.m17958a(com_google_android_gms_location_zzs, null));
                            }
                        }
                        com_google_android_gms_internal_zzcfd.f6784d.clear();
                    }
                    synchronized (com_google_android_gms_internal_zzcfd.f6786f) {
                        for (zzp com_google_android_gms_location_zzp : com_google_android_gms_internal_zzcfd.f6786f.values()) {
                            if (com_google_android_gms_location_zzp != null) {
                                ((zzcez) com_google_android_gms_internal_zzcfd.f6781a.mo1780b()).mo1802a(zzcfq.m17957a(com_google_android_gms_location_zzp, null));
                            }
                        }
                        com_google_android_gms_internal_zzcfd.f6786f.clear();
                    }
                    synchronized (com_google_android_gms_internal_zzcfd.f6785e) {
                        for (zzcfh com_google_android_gms_internal_zzcfh : com_google_android_gms_internal_zzcfd.f6785e.values()) {
                            if (com_google_android_gms_internal_zzcfh != null) {
                                ((zzcez) com_google_android_gms_internal_zzcfd.f6781a.mo1780b()).mo1800a(new zzcdz(2, null, com_google_android_gms_internal_zzcfh.asBinder(), null));
                            }
                        }
                        com_google_android_gms_internal_zzcfd.f6785e.clear();
                    }
                    com_google_android_gms_internal_zzcfd = this.f19568i;
                    if (com_google_android_gms_internal_zzcfd.f6783c) {
                        com_google_android_gms_internal_zzcfd.m5613a(false);
                    }
                } catch (Throwable e) {
                    Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", e);
                }
            }
            super.mo4292e();
        }
    }

    public final void m20970a(LocationRequest locationRequest, zzci<LocationListener> com_google_android_gms_common_api_internal_zzci_com_google_android_gms_location_LocationListener, zzceu com_google_android_gms_internal_zzceu) throws RemoteException {
        synchronized (this.f19568i) {
            zzcfd com_google_android_gms_internal_zzcfd = this.f19568i;
            com_google_android_gms_internal_zzcfd.f6781a.mo1779a();
            ((zzcez) com_google_android_gms_internal_zzcfd.f6781a.mo1780b()).mo1802a((zzcfq) new zzcfq(1, zzcfo.m17956a(locationRequest), com_google_android_gms_internal_zzcfd.m5612a((zzci) com_google_android_gms_common_api_internal_zzci_com_google_android_gms_location_LocationListener).asBinder(), null, null, com_google_android_gms_internal_zzceu.asBinder()));
        }
    }
}
