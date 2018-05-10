package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzv {
    final Set<zzr<?>> f8098a;
    final List<Object> f8099b;
    private final AtomicInteger f8100c;
    private final PriorityBlockingQueue<zzr<?>> f8101d;
    private final PriorityBlockingQueue<zzr<?>> f8102e;
    private final zzb f8103f;
    private final zzm f8104g;
    private final zzz f8105h;
    private final zzn[] f8106i;
    private zzd f8107j;

    private zzv(zzb com_google_android_gms_internal_zzb, zzm com_google_android_gms_internal_zzm) {
        this(com_google_android_gms_internal_zzb, com_google_android_gms_internal_zzm, new zzi(new Handler(Looper.getMainLooper())));
    }

    public zzv(zzb com_google_android_gms_internal_zzb, zzm com_google_android_gms_internal_zzm, byte b) {
        this(com_google_android_gms_internal_zzb, com_google_android_gms_internal_zzm);
    }

    private zzv(zzb com_google_android_gms_internal_zzb, zzm com_google_android_gms_internal_zzm, zzz com_google_android_gms_internal_zzz) {
        this.f8100c = new AtomicInteger();
        this.f8098a = new HashSet();
        this.f8101d = new PriorityBlockingQueue();
        this.f8102e = new PriorityBlockingQueue();
        this.f8099b = new ArrayList();
        this.f8103f = com_google_android_gms_internal_zzb;
        this.f8104g = com_google_android_gms_internal_zzm;
        this.f8106i = new zzn[4];
        this.f8105h = com_google_android_gms_internal_zzz;
    }

    public final void m6693a() {
        if (this.f8107j != null) {
            this.f8107j.m5832a();
        }
        int i = 0;
        for (zzn com_google_android_gms_internal_zzn : this.f8106i) {
            if (com_google_android_gms_internal_zzn != null) {
                com_google_android_gms_internal_zzn.f7850a = true;
                com_google_android_gms_internal_zzn.interrupt();
            }
        }
        this.f8107j = new zzd(this.f8101d, this.f8102e, this.f8103f, this.f8105h);
        this.f8107j.start();
        while (i < this.f8106i.length) {
            zzn com_google_android_gms_internal_zzn2 = new zzn(this.f8102e, this.f8104g, this.f8103f, this.f8105h);
            this.f8106i[i] = com_google_android_gms_internal_zzn2;
            com_google_android_gms_internal_zzn2.start();
            i++;
        }
    }

    public final <T> zzr<T> m6692a(zzr<T> com_google_android_gms_internal_zzr_T) {
        com_google_android_gms_internal_zzr_T.f7971f = this;
        synchronized (this.f8098a) {
            this.f8098a.add(com_google_android_gms_internal_zzr_T);
        }
        com_google_android_gms_internal_zzr_T.f7970e = Integer.valueOf(this.f8100c.incrementAndGet());
        com_google_android_gms_internal_zzr_T.m6628b("add-to-queue");
        (!com_google_android_gms_internal_zzr_T.f7972g ? this.f8102e : this.f8101d).add(com_google_android_gms_internal_zzr_T);
        return com_google_android_gms_internal_zzr_T;
    }
}
