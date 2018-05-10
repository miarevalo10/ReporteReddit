package com.google.android.gms.common.api.internal;

import android.app.Dialog;

final class zzr extends zzby {
    private /* synthetic */ Dialog f13968a;
    private /* synthetic */ zzq f13969b;

    zzr(zzq com_google_android_gms_common_api_internal_zzq, Dialog dialog) {
        this.f13969b = com_google_android_gms_common_api_internal_zzq;
        this.f13968a = dialog;
    }

    public final void mo1603a() {
        this.f13969b.f5855a.m13045f();
        if (this.f13968a.isShowing()) {
            this.f13968a.dismiss();
        }
    }
}
