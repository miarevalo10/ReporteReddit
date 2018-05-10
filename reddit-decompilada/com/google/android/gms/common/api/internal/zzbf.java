package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

final class zzbf extends Handler {
    private /* synthetic */ zzba f5770a;

    zzbf(zzba com_google_android_gms_common_api_internal_zzba, Looper looper) {
        this.f5770a = com_google_android_gms_common_api_internal_zzba;
        super(looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                zzba.m12956b(this.f5770a);
                return;
            case 2:
                zzba.m12953a(this.f5770a);
                return;
            default:
                int i = message.what;
                StringBuilder stringBuilder = new StringBuilder(31);
                stringBuilder.append("Unknown message id: ");
                stringBuilder.append(i);
                Log.w("GoogleApiClientImpl", stringBuilder.toString());
                return;
        }
    }
}
