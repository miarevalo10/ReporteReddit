package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;

final class zzq implements Runnable {
    final /* synthetic */ zzo f5855a;
    private final zzp f5856b;

    zzq(zzo com_google_android_gms_common_api_internal_zzo, zzp com_google_android_gms_common_api_internal_zzp) {
        this.f5855a = com_google_android_gms_common_api_internal_zzo;
        this.f5856b = com_google_android_gms_common_api_internal_zzp;
    }

    public final void run() {
        if (this.f5855a.f13965c) {
            ConnectionResult connectionResult = this.f5856b.f5854b;
            if (connectionResult.m17583a()) {
                this.f5855a.a.startActivityForResult(GoogleApiActivity.m4635a(this.f5855a.m4681a(), connectionResult.f17258c, this.f5856b.f5853a, false), 1);
            } else if (this.f5855a.f13967e.mo1539a(connectionResult.f17257b)) {
                GoogleApiAvailability.m12794a(this.f5855a.m4681a(), this.f5855a.a, connectionResult.f17257b, this.f5855a);
            } else if (connectionResult.f17257b == 18) {
                GoogleApiAvailability.m12791a(this.f5855a.m4681a().getApplicationContext(), new zzr(this, GoogleApiAvailability.m12788a(this.f5855a.m4681a(), this.f5855a)));
            } else {
                this.f5855a.mo3410a(connectionResult, this.f5856b.f5853a);
            }
        }
    }
}
