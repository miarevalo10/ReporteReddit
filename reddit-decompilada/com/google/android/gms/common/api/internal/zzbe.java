package com.google.android.gms.common.api.internal;

import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.zzz;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

final class zzbe implements ResultCallback<Status> {
    private /* synthetic */ zzda f13925a;
    private /* synthetic */ boolean f13926b;
    private /* synthetic */ GoogleApiClient f13927c;
    private /* synthetic */ zzba f13928d;

    zzbe(zzba com_google_android_gms_common_api_internal_zzba, zzda com_google_android_gms_common_api_internal_zzda, boolean z, GoogleApiClient googleApiClient) {
        this.f13928d = com_google_android_gms_common_api_internal_zzba;
        this.f13925a = com_google_android_gms_common_api_internal_zzda;
        this.f13926b = z;
        this.f13927c = googleApiClient;
    }

    public final /* synthetic */ void mo1602a(Result result) {
        result = (Status) result;
        zzz a = zzz.m4620a(this.f13928d.f13905k);
        String a2 = a.m4625a("defaultGoogleSignInAccount");
        a.m4629b("defaultGoogleSignInAccount");
        if (!TextUtils.isEmpty(a2)) {
            a.m4629b(zzz.m4621b("googleSignInAccount", a2));
            a.m4629b(zzz.m4621b("googleSignInOptions", a2));
        }
        if (result.m17588b() && this.f13928d.mo1568j()) {
            this.f13928d.mo1566h();
        }
        this.f13925a.m12826a(result);
        if (this.f13926b != null) {
            this.f13927c.mo1565g();
        }
    }
}
