package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.zzc;
import java.util.Set;

public abstract class zzab<T extends IInterface> extends zzd<T> implements zze, zzaf {
    private final Set<Scope> f17326a;
    protected final zzr f17327b;
    private final Account f17328i;

    protected zzab(Context context, Looper looper, int i, zzr com_google_android_gms_common_internal_zzr, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, zzag.m4782a(context), GoogleApiAvailability.m12790a(), i, com_google_android_gms_common_internal_zzr, (ConnectionCallbacks) zzbq.m4808a((Object) connectionCallbacks), (OnConnectionFailedListener) zzbq.m4808a((Object) onConnectionFailedListener));
    }

    public final Account mo3422k() {
        return this.f17328i;
    }

    public final zzc[] mo3423m() {
        return new zzc[0];
    }

    protected final Set<Scope> n_() {
        return this.f17326a;
    }

    private zzab(Context context, Looper looper, zzag com_google_android_gms_common_internal_zzag, GoogleApiAvailability googleApiAvailability, int i, zzr com_google_android_gms_common_internal_zzr, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        zzd com_google_android_gms_common_internal_zzd = this;
        zzr com_google_android_gms_common_internal_zzr2 = com_google_android_gms_common_internal_zzr;
        ConnectionCallbacks connectionCallbacks2 = connectionCallbacks;
        OnConnectionFailedListener onConnectionFailedListener2 = onConnectionFailedListener;
        super(context, looper, com_google_android_gms_common_internal_zzag, googleApiAvailability, i, connectionCallbacks2 == null ? null : new zzac(connectionCallbacks2), onConnectionFailedListener2 == null ? null : new zzad(onConnectionFailedListener2), com_google_android_gms_common_internal_zzr2.f5946f);
        com_google_android_gms_common_internal_zzd.f17327b = com_google_android_gms_common_internal_zzr2;
        com_google_android_gms_common_internal_zzd.f17328i = com_google_android_gms_common_internal_zzr2.f5941a;
        Set<Scope> set = com_google_android_gms_common_internal_zzr2.f5943c;
        for (Scope contains : set) {
            if (!set.contains(contains)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        com_google_android_gms_common_internal_zzd.f17326a = set;
    }
}
