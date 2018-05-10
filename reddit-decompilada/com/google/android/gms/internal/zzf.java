package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class zzf implements zzt {
    private final Map<String, List<zzr<?>>> f14422a = new HashMap();
    private final zzd f14423b;

    zzf(zzd com_google_android_gms_internal_zzd) {
        this.f14423b = com_google_android_gms_internal_zzd;
    }

    public final void mo1874a(zzr<?> com_google_android_gms_internal_zzr_, zzw<?> com_google_android_gms_internal_zzw_) {
        if (com_google_android_gms_internal_zzw_.f8109b != null) {
            if (!com_google_android_gms_internal_zzw_.f8109b.m5591a()) {
                List<zzr> list;
                com_google_android_gms_internal_zzr_ = com_google_android_gms_internal_zzr_.f7967b;
                synchronized (this) {
                    list = (List) this.f14422a.remove(com_google_android_gms_internal_zzr_);
                }
                if (list != null) {
                    if (zzae.f6235a) {
                        zzae.m5041a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(list.size()), com_google_android_gms_internal_zzr_);
                    }
                    for (zzr a : list) {
                        this.f14423b.f7208e.mo1955a(a, (zzw) com_google_android_gms_internal_zzw_);
                    }
                }
                return;
            }
        }
        mo1873a(com_google_android_gms_internal_zzr_);
    }

    public final synchronized void mo1873a(zzr<?> com_google_android_gms_internal_zzr_) {
        com_google_android_gms_internal_zzr_ = com_google_android_gms_internal_zzr_.f7967b;
        List list = (List) this.f14422a.remove(com_google_android_gms_internal_zzr_);
        if (!(list == null || list.isEmpty())) {
            if (zzae.f6235a) {
                zzae.m5041a("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(list.size()), com_google_android_gms_internal_zzr_);
            }
            zzr com_google_android_gms_internal_zzr = (zzr) list.remove(0);
            this.f14422a.put(com_google_android_gms_internal_zzr_, list);
            com_google_android_gms_internal_zzr.m6624a((zzt) this);
            try {
                this.f14423b.f7206c.put(com_google_android_gms_internal_zzr);
            } catch (zzr<?> com_google_android_gms_internal_zzr_2) {
                zzae.m5044c("Couldn't add request to queue. %s", com_google_android_gms_internal_zzr_2.toString());
                Thread.currentThread().interrupt();
                this.f14423b.m5832a();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized boolean m13736b(com.google.android.gms.internal.zzr<?> r6) {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = r6.f7967b;	 Catch:{ all -> 0x0050 }
        r1 = r5.f14422a;	 Catch:{ all -> 0x0050 }
        r1 = r1.containsKey(r0);	 Catch:{ all -> 0x0050 }
        r2 = 0;
        r3 = 1;
        if (r1 == 0) goto L_0x0038;
    L_0x000d:
        r1 = r5.f14422a;	 Catch:{ all -> 0x0050 }
        r1 = r1.get(r0);	 Catch:{ all -> 0x0050 }
        r1 = (java.util.List) r1;	 Catch:{ all -> 0x0050 }
        if (r1 != 0) goto L_0x001c;
    L_0x0017:
        r1 = new java.util.ArrayList;	 Catch:{ all -> 0x0050 }
        r1.<init>();	 Catch:{ all -> 0x0050 }
    L_0x001c:
        r4 = "waiting-for-response";
        r6.m6628b(r4);	 Catch:{ all -> 0x0050 }
        r1.add(r6);	 Catch:{ all -> 0x0050 }
        r6 = r5.f14422a;	 Catch:{ all -> 0x0050 }
        r6.put(r0, r1);	 Catch:{ all -> 0x0050 }
        r6 = com.google.android.gms.internal.zzae.f6235a;	 Catch:{ all -> 0x0050 }
        if (r6 == 0) goto L_0x0036;
    L_0x002d:
        r6 = "Request for cacheKey=%s is in flight, putting on hold.";
        r1 = new java.lang.Object[r3];	 Catch:{ all -> 0x0050 }
        r1[r2] = r0;	 Catch:{ all -> 0x0050 }
        com.google.android.gms.internal.zzae.m5043b(r6, r1);	 Catch:{ all -> 0x0050 }
    L_0x0036:
        monitor-exit(r5);
        return r3;
    L_0x0038:
        r1 = r5.f14422a;	 Catch:{ all -> 0x0050 }
        r4 = 0;
        r1.put(r0, r4);	 Catch:{ all -> 0x0050 }
        r6.m6624a(r5);	 Catch:{ all -> 0x0050 }
        r6 = com.google.android.gms.internal.zzae.f6235a;	 Catch:{ all -> 0x0050 }
        if (r6 == 0) goto L_0x004e;
    L_0x0045:
        r6 = "new request, sending to network %s";
        r1 = new java.lang.Object[r3];	 Catch:{ all -> 0x0050 }
        r1[r2] = r0;	 Catch:{ all -> 0x0050 }
        com.google.android.gms.internal.zzae.m5043b(r6, r1);	 Catch:{ all -> 0x0050 }
    L_0x004e:
        monitor-exit(r5);
        return r2;
    L_0x0050:
        r6 = move-exception;
        monitor-exit(r5);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzf.b(com.google.android.gms.internal.zzr):boolean");
    }
}
