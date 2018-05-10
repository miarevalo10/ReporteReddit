package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzr;

public final class zzaut extends zzab<zzauu> {
    public zzaut(Context context, Looper looper, zzr com_google_android_gms_common_internal_zzr, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 74, com_google_android_gms_common_internal_zzr, connectionCallbacks, onConnectionFailedListener);
    }

    protected final /* synthetic */ IInterface mo1646a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.accountactivationstate.internal.IAccountActivationStateService");
        return queryLocalInterface instanceof zzauu ? (zzauu) queryLocalInterface : new zzauv(iBinder);
    }

    protected final String mo1647a() {
        return "com.google.android.gms.auth.api.accountactivationstate.START";
    }

    protected final String mo1648b() {
        return "com.google.android.gms.auth.api.accountactivationstate.internal.IAccountActivationStateService";
    }
}
