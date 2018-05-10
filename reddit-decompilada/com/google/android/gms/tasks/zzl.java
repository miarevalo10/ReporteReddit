package com.google.android.gms.tasks;

import java.util.ArrayDeque;
import java.util.Queue;

final class zzl<TResult> {
    private final Object f8221a = new Object();
    private Queue<zzk<TResult>> f8222b;
    private boolean f8223c;

    zzl() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m6869a(com.google.android.gms.tasks.Task<TResult> r3) {
        /*
        r2 = this;
        r0 = r2.f8221a;
        monitor-enter(r0);
        r1 = r2.f8222b;	 Catch:{ all -> 0x002c }
        if (r1 == 0) goto L_0x002a;
    L_0x0007:
        r1 = r2.f8223c;	 Catch:{ all -> 0x002c }
        if (r1 == 0) goto L_0x000c;
    L_0x000b:
        goto L_0x002a;
    L_0x000c:
        r1 = 1;
        r2.f8223c = r1;	 Catch:{ all -> 0x002c }
        monitor-exit(r0);	 Catch:{ all -> 0x002c }
    L_0x0010:
        r1 = r2.f8221a;
        monitor-enter(r1);
        r0 = r2.f8222b;	 Catch:{ all -> 0x0027 }
        r0 = r0.poll();	 Catch:{ all -> 0x0027 }
        r0 = (com.google.android.gms.tasks.zzk) r0;	 Catch:{ all -> 0x0027 }
        if (r0 != 0) goto L_0x0022;
    L_0x001d:
        r3 = 0;
        r2.f8223c = r3;	 Catch:{ all -> 0x0027 }
        monitor-exit(r1);	 Catch:{ all -> 0x0027 }
        return;
    L_0x0022:
        monitor-exit(r1);	 Catch:{ all -> 0x0027 }
        r0.mo2305a(r3);
        goto L_0x0010;
    L_0x0027:
        r3 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0027 }
        throw r3;
    L_0x002a:
        monitor-exit(r0);	 Catch:{ all -> 0x002c }
        return;
    L_0x002c:
        r3 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x002c }
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tasks.zzl.a(com.google.android.gms.tasks.Task):void");
    }

    public final void m6870a(zzk<TResult> com_google_android_gms_tasks_zzk_TResult) {
        synchronized (this.f8221a) {
            if (this.f8222b == null) {
                this.f8222b = new ArrayDeque();
            }
            this.f8222b.add(com_google_android_gms_tasks_zzk_TResult);
        }
    }
}
