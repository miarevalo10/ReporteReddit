package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbq;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

final class zzcik<V> extends FutureTask<V> implements Comparable<zzcik> {
    final boolean f6951a;
    private final long f6952b = zzcih.f17858k.getAndIncrement();
    private final String f6953c;
    private /* synthetic */ zzcih f6954d;

    zzcik(zzcih com_google_android_gms_internal_zzcih, Callable<V> callable, boolean z, String str) {
        this.f6954d = com_google_android_gms_internal_zzcih;
        super(callable);
        zzbq.m4808a((Object) str);
        this.f6953c = str;
        this.f6951a = z;
        if (this.f6952b == Long.MAX_VALUE) {
            com_google_android_gms_internal_zzcih.mo1828t().f17816a.m5693a("Tasks index overflow");
        }
    }

    zzcik(zzcih com_google_android_gms_internal_zzcih, Runnable runnable, String str) {
        this.f6954d = com_google_android_gms_internal_zzcih;
        super(runnable, null);
        zzbq.m4808a((Object) str);
        this.f6953c = str;
        this.f6951a = null;
        if (this.f6952b == Long.MAX_VALUE) {
            com_google_android_gms_internal_zzcih.mo1828t().f17816a.m5693a("Tasks index overflow");
        }
    }

    protected final void setException(Throwable th) {
        this.f6954d.mo1828t().f17816a.m5694a(this.f6953c, th);
        if (th instanceof zzcii) {
            Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
        }
        super.setException(th);
    }

    public final /* synthetic */ int compareTo(Object obj) {
        zzcik com_google_android_gms_internal_zzcik = (zzcik) obj;
        if (this.f6951a != com_google_android_gms_internal_zzcik.f6951a) {
            return this.f6951a != null ? -1 : 1;
        } else {
            if (this.f6952b < com_google_android_gms_internal_zzcik.f6952b) {
                return -1;
            }
            if (this.f6952b > com_google_android_gms_internal_zzcik.f6952b) {
                return 1;
            }
            this.f6954d.mo1828t().f17817b.m5694a("Two tasks share the same index. index", Long.valueOf(this.f6952b));
            return null;
        }
    }
}
