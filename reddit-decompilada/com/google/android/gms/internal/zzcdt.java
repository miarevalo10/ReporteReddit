package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzr;

public class zzcdt extends zzab<zzcez> {
    protected final zzcfu<zzcez> f19214a = new zzcdu(this);
    private final String f19215i;

    public zzcdt(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, zzr com_google_android_gms_common_internal_zzr) {
        super(context, looper, 23, com_google_android_gms_common_internal_zzr, connectionCallbacks, onConnectionFailedListener);
        this.f19215i = str;
    }

    protected final /* synthetic */ IInterface mo1646a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        return queryLocalInterface instanceof zzcez ? (zzcez) queryLocalInterface : new zzcfa(iBinder);
    }

    protected final String mo1647a() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    protected final String mo1648b() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    protected final Bundle mo4022p() {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.f19215i);
        return bundle;
    }
}
