package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzj;
import java.lang.ref.WeakReference;

final class zzaq implements zzj {
    private final WeakReference<zzao> f13880a;
    private final Api<?> f13881b;
    private final boolean f13882c;

    public zzaq(zzao com_google_android_gms_common_api_internal_zzao, Api<?> api, boolean z) {
        this.f13880a = new WeakReference(com_google_android_gms_common_api_internal_zzao);
        this.f13881b = api;
        this.f13882c = z;
    }

    public final void mo1579a(ConnectionResult connectionResult) {
        zzao com_google_android_gms_common_api_internal_zzao = (zzao) this.f13880a.get();
        if (com_google_android_gms_common_api_internal_zzao != null) {
            zzbq.m4814a(Looper.myLooper() == com_google_android_gms_common_api_internal_zzao.f13859a.f17288m.mo1599c(), (Object) "onReportServiceBinding must be called on the GoogleApiClient handler thread");
            com_google_android_gms_common_api_internal_zzao.f13860b.lock();
            try {
                if (com_google_android_gms_common_api_internal_zzao.m12903b(0)) {
                    if (!connectionResult.m17584b()) {
                        com_google_android_gms_common_api_internal_zzao.m12902b(connectionResult, this.f13881b, this.f13882c);
                    }
                    if (com_google_android_gms_common_api_internal_zzao.m12908d()) {
                        com_google_android_gms_common_api_internal_zzao.m12909e();
                    }
                }
                com_google_android_gms_common_api_internal_zzao.f13860b.unlock();
            } catch (Throwable th) {
                com_google_android_gms_common_api_internal_zzao.f13860b.unlock();
            }
        }
    }
}
