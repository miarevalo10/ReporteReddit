package com.google.android.gms.internal;

@zzzv
public final class zzuk extends zzve {
    final Object f18309a = new Object();
    zzup f18310b;
    private zzuj f18311c;

    public final void mo2196a() {
        synchronized (this.f18309a) {
            if (this.f18311c != null) {
                this.f18311c.mo3942M();
            }
        }
    }

    public final void mo2197a(int i) {
        synchronized (this.f18309a) {
            if (this.f18310b != null) {
                this.f18310b.mo2163a(i == 3 ? 1 : 2);
                this.f18310b = null;
            }
        }
    }

    public final void mo2198a(zzqm com_google_android_gms_internal_zzqm, String str) {
        synchronized (this.f18309a) {
            if (this.f18311c != null) {
                this.f18311c.mo3949a(com_google_android_gms_internal_zzqm, str);
            }
        }
    }

    public final void m19041a(zzuj com_google_android_gms_internal_zzuj) {
        synchronized (this.f18309a) {
            this.f18311c = com_google_android_gms_internal_zzuj;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo2199a(com.google.android.gms.internal.zzvg r3) {
        /*
        r2 = this;
        r0 = r2.f18309a;
        monitor-enter(r0);
        r1 = r2.f18310b;	 Catch:{ all -> 0x001c }
        if (r1 == 0) goto L_0x0011;
    L_0x0007:
        r1 = r2.f18310b;	 Catch:{ all -> 0x001c }
        r1.mo2164a(r3);	 Catch:{ all -> 0x001c }
        r3 = 0;
        r2.f18310b = r3;	 Catch:{ all -> 0x001c }
        monitor-exit(r0);	 Catch:{ all -> 0x001c }
        return;
    L_0x0011:
        r3 = r2.f18311c;	 Catch:{ all -> 0x001c }
        if (r3 == 0) goto L_0x001a;
    L_0x0015:
        r3 = r2.f18311c;	 Catch:{ all -> 0x001c }
        r3.mo3948T();	 Catch:{ all -> 0x001c }
    L_0x001a:
        monitor-exit(r0);	 Catch:{ all -> 0x001c }
        return;
    L_0x001c:
        r3 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x001c }
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzuk.a(com.google.android.gms.internal.zzvg):void");
    }

    public final void mo2200a(String str, String str2) {
        synchronized (this.f18309a) {
            if (this.f18311c != null) {
                this.f18311c.mo3953b(str, str2);
            }
        }
    }

    public final void mo2201b() {
        synchronized (this.f18309a) {
            if (this.f18311c != null) {
                this.f18311c.mo3945Q();
            }
        }
    }

    public final void mo2202c() {
        synchronized (this.f18309a) {
            if (this.f18311c != null) {
                this.f18311c.mo3946R();
            }
        }
    }

    public final void mo2203d() {
        synchronized (this.f18309a) {
            if (this.f18311c != null) {
                this.f18311c.mo3947S();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo2204e() {
        /*
        r3 = this;
        r0 = r3.f18309a;
        monitor-enter(r0);
        r1 = r3.f18310b;	 Catch:{ all -> 0x001d }
        if (r1 == 0) goto L_0x0012;
    L_0x0007:
        r1 = r3.f18310b;	 Catch:{ all -> 0x001d }
        r2 = 0;
        r1.mo2163a(r2);	 Catch:{ all -> 0x001d }
        r1 = 0;
        r3.f18310b = r1;	 Catch:{ all -> 0x001d }
        monitor-exit(r0);	 Catch:{ all -> 0x001d }
        return;
    L_0x0012:
        r1 = r3.f18311c;	 Catch:{ all -> 0x001d }
        if (r1 == 0) goto L_0x001b;
    L_0x0016:
        r1 = r3.f18311c;	 Catch:{ all -> 0x001d }
        r1.mo3948T();	 Catch:{ all -> 0x001d }
    L_0x001b:
        monitor-exit(r0);	 Catch:{ all -> 0x001d }
        return;
    L_0x001d:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x001d }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzuk.e():void");
    }

    public final void mo2205f() {
        synchronized (this.f18309a) {
            if (this.f18311c != null) {
                this.f18311c.mo3943N();
            }
        }
    }

    public final void mo2206g() {
        synchronized (this.f18309a) {
            if (this.f18311c != null) {
                this.f18311c.mo3944O();
            }
        }
    }
}
