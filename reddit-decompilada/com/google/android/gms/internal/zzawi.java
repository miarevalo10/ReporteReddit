package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.auth.api.zzd;
import com.google.android.gms.auth.api.zzf;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.common.internal.zzt;
import java.util.HashSet;
import java.util.Set;

public final class zzawi extends zzab<zzawl> {
    private final Bundle f19211a;

    public zzawi(Context context, Looper looper, zzr com_google_android_gms_common_internal_zzr, zzf com_google_android_gms_auth_api_zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 16, com_google_android_gms_common_internal_zzr, connectionCallbacks, onConnectionFailedListener);
        if (com_google_android_gms_auth_api_zzf == null) {
            this.f19211a = new Bundle();
            return;
        }
        throw new NoSuchMethodError();
    }

    protected final /* synthetic */ IInterface mo1646a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.internal.IAuthService");
        return queryLocalInterface instanceof zzawl ? (zzawl) queryLocalInterface : new zzawm(iBinder);
    }

    protected final String mo1647a() {
        return "com.google.android.gms.auth.service.START";
    }

    protected final String mo1648b() {
        return "com.google.android.gms.auth.api.internal.IAuthService";
    }

    protected final Bundle mo4022p() {
        return this.f19211a;
    }

    public final boolean mo4023h() {
        zzr com_google_android_gms_common_internal_zzr = this.f17327b;
        if (!TextUtils.isEmpty(com_google_android_gms_common_internal_zzr.f5941a != null ? com_google_android_gms_common_internal_zzr.f5941a.name : null)) {
            Set hashSet;
            zzt com_google_android_gms_common_internal_zzt = (zzt) com_google_android_gms_common_internal_zzr.f5944d.get(zzd.f5728a);
            if (com_google_android_gms_common_internal_zzt != null) {
                if (!com_google_android_gms_common_internal_zzt.f5957a.isEmpty()) {
                    hashSet = new HashSet(com_google_android_gms_common_internal_zzr.f5942b);
                    hashSet.addAll(com_google_android_gms_common_internal_zzt.f5957a);
                    if (!hashSet.isEmpty()) {
                        return true;
                    }
                }
            }
            hashSet = com_google_android_gms_common_internal_zzr.f5942b;
            if (hashSet.isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
