package com.google.android.gms.common.internal;

import android.content.Intent;
import com.google.android.gms.common.api.internal.zzcf;

final class zzy extends zzv {
    private /* synthetic */ Intent f14012a;
    private /* synthetic */ zzcf f14013b;
    private /* synthetic */ int f14014c = 2;

    zzy(Intent intent, zzcf com_google_android_gms_common_api_internal_zzcf) {
        this.f14012a = intent;
        this.f14013b = com_google_android_gms_common_api_internal_zzcf;
    }

    public final void mo1631a() {
        if (this.f14012a != null) {
            this.f14013b.startActivityForResult(this.f14012a, this.f14014c);
        }
    }
}
