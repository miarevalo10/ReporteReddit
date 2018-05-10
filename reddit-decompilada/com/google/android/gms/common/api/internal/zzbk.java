package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

final class zzbk extends Handler {
    private /* synthetic */ zzbi f5772a;

    zzbk(zzbi com_google_android_gms_common_api_internal_zzbi, Looper looper) {
        this.f5772a = com_google_android_gms_common_api_internal_zzbi;
        super(looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                ((zzbj) message.obj).m4706a(this.f5772a);
                return;
            case 2:
                throw ((RuntimeException) message.obj);
            default:
                int i = message.what;
                StringBuilder stringBuilder = new StringBuilder(31);
                stringBuilder.append("Unknown message id: ");
                stringBuilder.append(i);
                Log.w("GACStateManager", stringBuilder.toString());
                return;
        }
    }
}
