package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.gmsg.zzt;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzanh;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

final class zzau implements zzt<zzanh> {
    private /* synthetic */ CountDownLatch f13776a;

    zzau(CountDownLatch countDownLatch) {
        this.f13776a = countDownLatch;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzanh com_google_android_gms_internal_zzanh = (zzanh) obj;
        zzakb.m5371e("Adapter returned an ad, but assets substitution failed");
        this.f13776a.countDown();
        com_google_android_gms_internal_zzanh.destroy();
    }
}
