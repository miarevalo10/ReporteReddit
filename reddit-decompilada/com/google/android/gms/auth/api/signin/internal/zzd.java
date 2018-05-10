package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzr;

public final class zzd extends zzab<zzu> {
    final GoogleSignInOptions f19101a;

    protected final /* synthetic */ IInterface mo1646a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
        return queryLocalInterface instanceof zzu ? (zzu) queryLocalInterface : new zzv(iBinder);
    }

    protected final String mo1647a() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }

    protected final String mo1648b() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }

    public final boolean mo3957c() {
        return true;
    }

    public zzd(Context context, Looper looper, zzr com_google_android_gms_common_internal_zzr, GoogleSignInOptions googleSignInOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 91, com_google_android_gms_common_internal_zzr, connectionCallbacks, onConnectionFailedListener);
        if (googleSignInOptions == null) {
            googleSignInOptions = new Builder().m4597b();
        }
        if (com_google_android_gms_common_internal_zzr.f5943c.isEmpty() == null) {
            context = new Builder(googleSignInOptions);
            for (Scope a : com_google_android_gms_common_internal_zzr.f5943c) {
                context.m4596a(a, new Scope[null]);
            }
            googleSignInOptions = context.m4597b();
        }
        this.f19101a = googleSignInOptions;
    }

    public final Intent mo3958d() {
        return zze.m4598a(this.f5913e, this.f19101a);
    }
}
