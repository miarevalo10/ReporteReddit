package com.danikula.videocache;

import java.lang.Thread.State;
import java.util.concurrent.atomic.AtomicInteger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class ProxyCache {
    static final Logger f3761d = LoggerFactory.a("ProxyCache");
    private final Object f3762a = new Object();
    private final AtomicInteger f3763b;
    private volatile int f3764c = -1;
    final Source f3765e;
    final Cache f3766f;
    final Object f3767g = new Object();
    volatile Thread f3768h;
    volatile boolean f3769i;

    private class SourceReaderRunnable implements Runnable {
        final /* synthetic */ ProxyCache f3760a;

        private SourceReaderRunnable(ProxyCache proxyCache) {
            this.f3760a = proxyCache;
        }

        public void run() {
            ProxyCache.m3337a(this.f3760a);
        }
    }

    protected void mo1097a(int i) {
    }

    public ProxyCache(Source source, Cache cache) {
        this.f3765e = (Source) Preconditions.m3330a((Object) source);
        this.f3766f = (Cache) Preconditions.m3330a((Object) cache);
        this.f3763b = new AtomicInteger();
    }

    public final int m3341a(byte[] bArr, long j) throws ProxyCacheException {
        ProxyCacheUtils.m3345a(bArr, j);
        while (!this.f3766f.isCompleted() && this.f3766f.available() < 8192 + j && !this.f3769i) {
            m3335a();
            synchronized (this.f3762a) {
                try {
                    this.f3762a.wait(1000);
                } catch (byte[] bArr2) {
                    throw new ProxyCacheException("Waiting source data is interrupted!", bArr2);
                }
            }
            int i = this.f3763b.get();
            if (i > 0) {
                this.f3763b.set(0);
                j = new StringBuilder("Error reading source ");
                j.append(i);
                j.append(" times");
                throw new ProxyCacheException(j.toString());
            }
        }
        bArr2 = this.f3766f.read(bArr2, j, 8192);
        if (!(this.f3766f.isCompleted() == null || this.f3764c == 100)) {
            this.f3764c = 100;
            mo1097a(100);
        }
        return bArr2;
    }

    private synchronized void m3335a() throws ProxyCacheException {
        byte b = (this.f3768h == null || this.f3768h.getState() == State.TERMINATED) ? (byte) 0 : (byte) 1;
        if (!(this.f3769i || this.f3766f.isCompleted() || b != (byte) 0)) {
            Runnable sourceReaderRunnable = new SourceReaderRunnable();
            StringBuilder stringBuilder = new StringBuilder("Source reader for ");
            stringBuilder.append(this.f3765e);
            this.f3768h = new Thread(sourceReaderRunnable, stringBuilder.toString());
            this.f3768h.start();
        }
    }

    private boolean m3339b() {
        if (!Thread.currentThread().isInterrupted()) {
            if (!this.f3769i) {
                return false;
            }
        }
        return true;
    }

    private void m3340c() {
        try {
            this.f3765e.mo1102b();
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder("Error closing source ");
            stringBuilder.append(this.f3765e);
            m3338a(new ProxyCacheException(stringBuilder.toString(), e));
        }
    }

    static void m3338a(Throwable th) {
        if (th instanceof InterruptedProxyCacheException) {
            f3761d.a("ProxyCache is interrupted");
        } else {
            f3761d.a("ProxyCache error", th);
        }
    }

    private void m3336a(long j, long j2) {
        int i = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        Object obj = null;
        int i2 = (i == 0 ? 1 : null) != null ? 100 : (int) ((((float) j) / ((float) j2)) * 100.0f);
        Object obj2 = i2 != this.f3764c ? 1 : null;
        if (i >= 0) {
            obj = 1;
        }
        if (!(obj == null || obj2 == null)) {
            mo1097a(i2);
        }
        this.f3764c = i2;
        synchronized (this.f3762a) {
            this.f3762a.notifyAll();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void m3337a(com.danikula.videocache.ProxyCache r12) {
        /*
        r0 = -1;
        r2 = 0;
        r4 = r12.f3766f;	 Catch:{ Throwable -> 0x0088, all -> 0x0082 }
        r4 = r4.available();	 Catch:{ Throwable -> 0x0088, all -> 0x0082 }
        r2 = r12.f3765e;	 Catch:{ Throwable -> 0x007d, all -> 0x0079 }
        r2.mo1101a(r4);	 Catch:{ Throwable -> 0x007d, all -> 0x0079 }
        r2 = r12.f3765e;	 Catch:{ Throwable -> 0x007d, all -> 0x0079 }
        r2 = r2.mo1100a();	 Catch:{ Throwable -> 0x007d, all -> 0x0079 }
        r0 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r0 = new byte[r0];	 Catch:{ Throwable -> 0x0076, all -> 0x0074 }
    L_0x0019:
        r1 = r12.f3765e;	 Catch:{ Throwable -> 0x0076, all -> 0x0074 }
        r1 = r1.mo1099a(r0);	 Catch:{ Throwable -> 0x0076, all -> 0x0074 }
        r6 = -1;
        if (r1 == r6) goto L_0x0042;
    L_0x0022:
        r6 = r12.f3767g;	 Catch:{ Throwable -> 0x0076, all -> 0x0074 }
        monitor-enter(r6);	 Catch:{ Throwable -> 0x0076, all -> 0x0074 }
        r7 = r12.m3339b();	 Catch:{ all -> 0x003f }
        if (r7 == 0) goto L_0x0033;
    L_0x002b:
        monitor-exit(r6);	 Catch:{ all -> 0x003f }
        r12.m3340c();
        r12.m3336a(r4, r2);
        return;
    L_0x0033:
        r7 = r12.f3766f;	 Catch:{ all -> 0x003f }
        r7.append(r0, r1);	 Catch:{ all -> 0x003f }
        monitor-exit(r6);	 Catch:{ all -> 0x003f }
        r6 = (long) r1;
        r4 = r4 + r6;
        r12.m3336a(r4, r2);	 Catch:{ Throwable -> 0x0076, all -> 0x0074 }
        goto L_0x0019;
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x003f }
        throw r0;	 Catch:{ Throwable -> 0x0076, all -> 0x0074 }
    L_0x0042:
        r0 = r12.f3767g;	 Catch:{ Throwable -> 0x0076, all -> 0x0074 }
        monitor-enter(r0);	 Catch:{ Throwable -> 0x0076, all -> 0x0074 }
        r1 = r12.m3339b();	 Catch:{ all -> 0x0071 }
        if (r1 != 0) goto L_0x0060;
    L_0x004b:
        r1 = r12.f3766f;	 Catch:{ all -> 0x0071 }
        r6 = r1.available();	 Catch:{ all -> 0x0071 }
        r1 = r12.f3765e;	 Catch:{ all -> 0x0071 }
        r8 = r1.mo1100a();	 Catch:{ all -> 0x0071 }
        r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r1 != 0) goto L_0x0060;
    L_0x005b:
        r1 = r12.f3766f;	 Catch:{ all -> 0x0071 }
        r1.complete();	 Catch:{ all -> 0x0071 }
    L_0x0060:
        monitor-exit(r0);	 Catch:{ all -> 0x0071 }
        r0 = 100;
        r12.f3764c = r0;	 Catch:{ Throwable -> 0x0076, all -> 0x0074 }
        r0 = r12.f3764c;	 Catch:{ Throwable -> 0x0076, all -> 0x0074 }
        r12.mo1097a(r0);	 Catch:{ Throwable -> 0x0076, all -> 0x0074 }
        r12.m3340c();
        r12.m3336a(r4, r2);
        return;
    L_0x0071:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0071 }
        throw r1;	 Catch:{ Throwable -> 0x0076, all -> 0x0074 }
    L_0x0074:
        r0 = move-exception;
        goto L_0x009f;
    L_0x0076:
        r0 = move-exception;
        r10 = r2;
        goto L_0x0080;
    L_0x0079:
        r2 = move-exception;
        r10 = r0;
        r0 = r2;
        goto L_0x0086;
    L_0x007d:
        r2 = move-exception;
        r10 = r0;
        r0 = r2;
    L_0x0080:
        r2 = r4;
        goto L_0x008b;
    L_0x0082:
        r4 = move-exception;
        r10 = r0;
        r0 = r4;
        r4 = r2;
    L_0x0086:
        r2 = r10;
        goto L_0x009f;
    L_0x0088:
        r4 = move-exception;
        r10 = r0;
        r0 = r4;
    L_0x008b:
        r4 = r10;
        r1 = r12.f3763b;	 Catch:{ all -> 0x009b }
        r1.incrementAndGet();	 Catch:{ all -> 0x009b }
        m3338a(r0);	 Catch:{ all -> 0x009b }
        r12.m3340c();
        r12.m3336a(r2, r4);
        return;
    L_0x009b:
        r0 = move-exception;
        r10 = r2;
        r2 = r4;
        r4 = r10;
    L_0x009f:
        r12.m3340c();
        r12.m3336a(r4, r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.danikula.videocache.ProxyCache.a(com.danikula.videocache.ProxyCache):void");
    }
}
