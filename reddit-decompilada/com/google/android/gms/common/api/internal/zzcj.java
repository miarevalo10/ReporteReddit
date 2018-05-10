package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.internal.zzbq;

final class zzcj extends Handler {
    private /* synthetic */ zzci f5813a;

    public zzcj(zzci com_google_android_gms_common_api_internal_zzci, Looper looper) {
        this.f5813a = com_google_android_gms_common_api_internal_zzci;
        super(looper);
    }

    public final void handleMessage(Message message) {
        boolean z = true;
        if (message.what != 1) {
            z = false;
        }
        zzbq.m4817b(z);
        zzci com_google_android_gms_common_api_internal_zzci = this.f5813a;
        message = message.obj;
        if (com_google_android_gms_common_api_internal_zzci.f5810a == null) {
        }
    }
}
