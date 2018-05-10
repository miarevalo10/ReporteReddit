package com.google.android.gms.ads.internal;

import android.os.Debug;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zznh;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

final class zzb extends TimerTask {
    private /* synthetic */ CountDownLatch f5510a;
    private /* synthetic */ Timer f5511b;
    private /* synthetic */ zza f5512c;

    zzb(zza com_google_android_gms_ads_internal_zza, CountDownLatch countDownLatch, Timer timer) {
        this.f5512c = com_google_android_gms_ads_internal_zza;
        this.f5510a = countDownLatch;
        this.f5511b = timer;
    }

    public final void run() {
        if (((long) ((Integer) zzkb.m6350f().m6488a(zznh.bZ)).intValue()) != this.f5510a.getCount()) {
            zzakb.m5366b("Stopping method tracing");
            Debug.stopMethodTracing();
            if (this.f5510a.getCount() == 0) {
                this.f5511b.cancel();
                return;
            }
        }
        String concat = String.valueOf(this.f5512c.f17129e.f5600c.getPackageName()).concat("_adsTrace_");
        try {
            zzakb.m5366b("Starting method tracing");
            this.f5510a.countDown();
            long a = zzbs.m4492k().mo1632a();
            StringBuilder stringBuilder = new StringBuilder(20 + String.valueOf(concat).length());
            stringBuilder.append(concat);
            stringBuilder.append(a);
            Debug.startMethodTracing(stringBuilder.toString(), ((Integer) zzkb.m6350f().m6488a(zznh.ca)).intValue());
        } catch (Throwable e) {
            zzakb.m5369c("Exception occurred while starting method tracing.", e);
        }
    }
}
