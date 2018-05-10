package com.google.android.gms.internal;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@zzzv
public class zzall<T> implements zzalh<T> {
    public int f14142a = 0;
    private final Object f14143b = new Object();
    private BlockingQueue<zzalm> f14144c = new LinkedBlockingQueue();
    private T f14145d;

    public final void mo1736a(zzalk<T> com_google_android_gms_internal_zzalk_T, zzali com_google_android_gms_internal_zzali) {
        synchronized (this.f14143b) {
            if (this.f14142a == 1) {
                com_google_android_gms_internal_zzalk_T.mo1509a(this.f14145d);
            } else if (this.f14142a == -1) {
                com_google_android_gms_internal_zzali.mo1510a();
            } else if (this.f14142a == 0) {
                this.f14144c.add(new zzalm(com_google_android_gms_internal_zzalk_T, com_google_android_gms_internal_zzali));
            }
        }
    }

    public final void mo1737a(T t) {
        synchronized (this.f14143b) {
            if (this.f14142a != 0) {
                throw new UnsupportedOperationException();
            }
            this.f14145d = t;
            this.f14142a = 1;
            for (zzalm com_google_android_gms_internal_zzalm : this.f14144c) {
                com_google_android_gms_internal_zzalm.f6516a.mo1509a(t);
            }
            this.f14144c.clear();
        }
    }

    public final void m13334d() {
        synchronized (this.f14143b) {
            if (this.f14142a != 0) {
                throw new UnsupportedOperationException();
            }
            this.f14142a = -1;
            for (zzalm com_google_android_gms_internal_zzalm : this.f14144c) {
                com_google_android_gms_internal_zzalm.f6517b.mo1510a();
            }
            this.f14144c.clear();
        }
    }
}
