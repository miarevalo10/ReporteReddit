package com.google.android.gms.internal;

import android.content.ContentProviderClient;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.zzci;
import com.google.android.gms.common.api.internal.zzck;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import java.util.HashMap;
import java.util.Map;

public final class zzcfd {
    final zzcfu<zzcez> f6781a;
    final Context f6782b;
    boolean f6783c = false;
    final Map<zzck<LocationListener>, zzcfi> f6784d = new HashMap();
    final Map<zzck<Object>, zzcfh> f6785e = new HashMap();
    final Map<zzck<LocationCallback>, zzcfe> f6786f = new HashMap();
    private ContentProviderClient f6787g = null;

    public zzcfd(Context context, zzcfu<zzcez> com_google_android_gms_internal_zzcfu_com_google_android_gms_internal_zzcez) {
        this.f6782b = context;
        this.f6781a = com_google_android_gms_internal_zzcfu_com_google_android_gms_internal_zzcez;
    }

    public final void m5613a(boolean z) throws RemoteException {
        this.f6781a.mo1779a();
        ((zzcez) this.f6781a.mo1780b()).mo1806a(z);
        this.f6783c = z;
    }

    final zzcfi m5612a(zzci<LocationListener> com_google_android_gms_common_api_internal_zzci_com_google_android_gms_location_LocationListener) {
        zzcfi com_google_android_gms_internal_zzcfi;
        synchronized (this.f6784d) {
            com_google_android_gms_internal_zzcfi = (zzcfi) this.f6784d.get(com_google_android_gms_common_api_internal_zzci_com_google_android_gms_location_LocationListener.f5811b);
            if (com_google_android_gms_internal_zzcfi == null) {
                com_google_android_gms_internal_zzcfi = new zzcfi(com_google_android_gms_common_api_internal_zzci_com_google_android_gms_location_LocationListener);
            }
            this.f6784d.put(com_google_android_gms_common_api_internal_zzci_com_google_android_gms_location_LocationListener.f5811b, com_google_android_gms_internal_zzcfi);
        }
        return com_google_android_gms_internal_zzcfi;
    }

    final zzcfe m5614b(zzci<LocationCallback> com_google_android_gms_common_api_internal_zzci_com_google_android_gms_location_LocationCallback) {
        zzcfe com_google_android_gms_internal_zzcfe;
        synchronized (this.f6786f) {
            com_google_android_gms_internal_zzcfe = (zzcfe) this.f6786f.get(com_google_android_gms_common_api_internal_zzci_com_google_android_gms_location_LocationCallback.f5811b);
            if (com_google_android_gms_internal_zzcfe == null) {
                com_google_android_gms_internal_zzcfe = new zzcfe(com_google_android_gms_common_api_internal_zzci_com_google_android_gms_location_LocationCallback);
            }
            this.f6786f.put(com_google_android_gms_common_api_internal_zzci_com_google_android_gms_location_LocationCallback.f5811b, com_google_android_gms_internal_zzcfe);
        }
        return com_google_android_gms_internal_zzcfe;
    }
}
