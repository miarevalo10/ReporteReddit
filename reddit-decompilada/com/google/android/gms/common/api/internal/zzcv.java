package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.internal.zzcxa;
import com.google.android.gms.internal.zzcxd;
import com.google.android.gms.internal.zzcxe;
import com.google.android.gms.internal.zzcxi;
import com.google.android.gms.internal.zzcxq;
import java.util.Set;

public final class zzcv extends zzcxi implements ConnectionCallbacks, OnConnectionFailedListener {
    private static zza<? extends zzcxd, zzcxe> f19108h = zzcxa.f7196a;
    final Context f19109a;
    final Handler f19110b;
    final zza<? extends zzcxd, zzcxe> f19111c;
    Set<Scope> f19112d;
    zzr f19113e;
    zzcxd f19114f;
    zzcy f19115g;

    public zzcv(Context context, Handler handler, zzr com_google_android_gms_common_internal_zzr) {
        this(context, handler, com_google_android_gms_common_internal_zzr, f19108h);
    }

    public final void mo1581a(int i) {
        this.f19114f.mo4292e();
    }

    public final void mo1582a(Bundle bundle) {
        this.f19114f.mo4026a(this);
    }

    public final void mo1583a(ConnectionResult connectionResult) {
        this.f19115g.mo1607b(connectionResult);
    }

    public final void mo3496a(zzcxq com_google_android_gms_internal_zzcxq) {
        this.f19110b.post(new zzcx(this, com_google_android_gms_internal_zzcxq));
    }

    public zzcv(Context context, Handler handler, zzr com_google_android_gms_common_internal_zzr, zza<? extends zzcxd, zzcxe> com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzcxd__com_google_android_gms_internal_zzcxe) {
        this.f19109a = context;
        this.f19110b = handler;
        this.f19113e = (zzr) zzbq.m4809a((Object) com_google_android_gms_common_internal_zzr, (Object) "ClientSettings must not be null");
        this.f19112d = com_google_android_gms_common_internal_zzr.f5942b;
        this.f19111c = com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzcxd__com_google_android_gms_internal_zzcxe;
    }

    static /* synthetic */ void m20198a(zzcv com_google_android_gms_common_api_internal_zzcv, zzcxq com_google_android_gms_internal_zzcxq) {
        ConnectionResult connectionResult = com_google_android_gms_internal_zzcxq.f18032a;
        if (connectionResult.m17584b()) {
            com_google_android_gms_internal_zzcxq = com_google_android_gms_internal_zzcxq.f18033b;
            connectionResult = com_google_android_gms_internal_zzcxq.f17333a;
            if (connectionResult.m17584b()) {
                com_google_android_gms_common_api_internal_zzcv.f19115g.mo1606a(com_google_android_gms_internal_zzcxq.m17680a(), com_google_android_gms_common_api_internal_zzcv.f19112d);
                com_google_android_gms_common_api_internal_zzcv.f19114f.mo4292e();
            }
            String valueOf = String.valueOf(connectionResult);
            StringBuilder stringBuilder = new StringBuilder(48 + String.valueOf(valueOf).length());
            stringBuilder.append("Sign-in succeeded with resolve account failure: ");
            stringBuilder.append(valueOf);
            Log.wtf("SignInCoordinator", stringBuilder.toString(), new Exception());
        }
        com_google_android_gms_common_api_internal_zzcv.f19115g.mo1607b(connectionResult);
        com_google_android_gms_common_api_internal_zzcv.f19114f.mo4292e();
    }
}
