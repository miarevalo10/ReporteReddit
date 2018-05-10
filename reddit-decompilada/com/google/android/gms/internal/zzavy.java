package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzr;

public final class zzavy extends zzab<zzawd> {
    final AuthCredentialsOptions f19210a;

    public zzavy(Context context, Looper looper, zzr com_google_android_gms_common_internal_zzr, AuthCredentialsOptions authCredentialsOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 68, com_google_android_gms_common_internal_zzr, connectionCallbacks, onConnectionFailedListener);
        this.f19210a = authCredentialsOptions;
    }

    protected final /* synthetic */ IInterface mo1646a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
        return queryLocalInterface instanceof zzawd ? (zzawd) queryLocalInterface : new zzawe(iBinder);
    }

    protected final String mo1647a() {
        return "com.google.android.gms.auth.api.credentials.service.START";
    }

    protected final String mo1648b() {
        return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
    }

    protected final Bundle mo4022p() {
        if (this.f19210a == null) {
            return new Bundle();
        }
        AuthCredentialsOptions authCredentialsOptions = this.f19210a;
        Bundle bundle = new Bundle();
        bundle.putString("consumer_package", null);
        bundle.putParcelable("password_specification", authCredentialsOptions.f19080a);
        bundle.putBoolean("force_save_dialog", authCredentialsOptions.f19081b);
        return bundle;
    }
}
