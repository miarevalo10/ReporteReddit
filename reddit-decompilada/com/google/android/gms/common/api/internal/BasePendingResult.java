package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzaq;
import com.google.android.gms.common.internal.zzbq;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@KeepName
public abstract class BasePendingResult<R extends Result> extends PendingResult<R> {
    static final ThreadLocal<Boolean> f13813c = new zzs();
    private final Object f13814a;
    private zza<R> f13815b;
    private WeakReference<GoogleApiClient> f13816d;
    private final CountDownLatch f13817e;
    private final ArrayList<com.google.android.gms.common.api.PendingResult.zza> f13818f;
    private ResultCallback<? super R> f13819g;
    private final AtomicReference<zzdm> f13820h;
    private R f13821i;
    private Status f13822j;
    private volatile boolean f13823k;
    private boolean f13824l;
    private boolean f13825m;
    @KeepName
    private zzb mResultGuardian;
    private zzaq f13826n;
    private volatile zzdg<R> f13827o;
    private boolean f13828p;

    public static class zza<R extends Result> extends Handler {
        public zza() {
            this(Looper.getMainLooper());
        }

        public zza(Looper looper) {
            super(looper);
        }

        public final void m4678a(ResultCallback<? super R> resultCallback, R r) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Pair pair = (Pair) message.obj;
                    ResultCallback resultCallback = (ResultCallback) pair.first;
                    Result result = (Result) pair.second;
                    try {
                        resultCallback.mo1602a(result);
                        return;
                    } catch (RuntimeException e) {
                        BasePendingResult.m12820b(result);
                        throw e;
                    }
                case 2:
                    ((BasePendingResult) message.obj).m12830b(Status.f17266d);
                    return;
                default:
                    int i = message.what;
                    StringBuilder stringBuilder = new StringBuilder(45);
                    stringBuilder.append("Don't know how to handle message: ");
                    stringBuilder.append(i);
                    Log.wtf("BasePendingResult", stringBuilder.toString(), new Exception());
                    return;
            }
        }
    }

    final class zzb {
        private /* synthetic */ BasePendingResult f5763a;

        private zzb(BasePendingResult basePendingResult) {
            this.f5763a = basePendingResult;
        }

        protected final void finalize() throws Throwable {
            BasePendingResult.m12820b(this.f5763a.f13821i);
            super.finalize();
        }
    }

    @Deprecated
    BasePendingResult() {
        this.f13814a = new Object();
        this.f13817e = new CountDownLatch(1);
        this.f13818f = new ArrayList();
        this.f13820h = new AtomicReference();
        this.f13828p = false;
        this.f13815b = new zza(Looper.getMainLooper());
        this.f13816d = new WeakReference(null);
    }

    protected BasePendingResult(GoogleApiClient googleApiClient) {
        this.f13814a = new Object();
        this.f13817e = new CountDownLatch(1);
        this.f13818f = new ArrayList();
        this.f13820h = new AtomicReference();
        this.f13828p = false;
        this.f13815b = new zza(googleApiClient != null ? googleApiClient.mo1599c() : Looper.getMainLooper());
        this.f13816d = new WeakReference(googleApiClient);
    }

    public static void m12820b(Result result) {
        if (!(result instanceof Releasable)) {
        }
    }

    private final void m12821c(R r) {
        this.f13821i = r;
        this.f13826n = null;
        this.f13817e.countDown();
        this.f13822j = this.f13821i.k_();
        int i = 0;
        if (this.f13824l) {
            this.f13819g = null;
        } else if (this.f13819g != null) {
            this.f13815b.removeMessages(2);
            this.f13815b.m4678a(this.f13819g, m12822g());
        } else if (this.f13821i instanceof Releasable) {
            this.mResultGuardian = new zzb();
        }
        ArrayList arrayList = this.f13818f;
        int size = arrayList.size();
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((com.google.android.gms.common.api.PendingResult.zza) obj).mo1559a();
        }
        this.f13818f.clear();
    }

    private final R m12822g() {
        R r;
        synchronized (this.f13814a) {
            zzbq.m4814a(this.f13823k ^ true, (Object) "Result has already been consumed.");
            zzbq.m4814a(m12829a(), (Object) "Result is not ready.");
            r = this.f13821i;
            this.f13821i = null;
            this.f13819g = null;
            this.f13823k = true;
        }
        zzdm com_google_android_gms_common_api_internal_zzdm = (zzdm) this.f13820h.getAndSet(null);
        if (com_google_android_gms_common_api_internal_zzdm != null) {
            com_google_android_gms_common_api_internal_zzdm.mo1611a(this);
        }
        return r;
    }

    public final R mo1541a(long r4, java.util.concurrent.TimeUnit r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r3 = this;
        r0 = 0;
        r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x000b;
    L_0x0006:
        r0 = "await must not be called on the UI thread when time is greater than zero.";
        com.google.android.gms.common.internal.zzbq.m4820c(r0);
    L_0x000b:
        r0 = r3.f13823k;
        r1 = 1;
        r0 = r0 ^ r1;
        r2 = "Result has already been consumed.";
        com.google.android.gms.common.internal.zzbq.m4814a(r0, r2);
        r0 = r3.f13827o;
        if (r0 != 0) goto L_0x0019;
    L_0x0018:
        goto L_0x001a;
    L_0x0019:
        r1 = 0;
    L_0x001a:
        r0 = "Cannot await if then() has been called.";
        com.google.android.gms.common.internal.zzbq.m4814a(r1, r0);
        r0 = r3.f13817e;	 Catch:{ InterruptedException -> 0x002d }
        r4 = r0.await(r4, r6);	 Catch:{ InterruptedException -> 0x002d }
        if (r4 != 0) goto L_0x0032;	 Catch:{ InterruptedException -> 0x002d }
    L_0x0027:
        r4 = com.google.android.gms.common.api.Status.f17266d;	 Catch:{ InterruptedException -> 0x002d }
        r3.m12830b(r4);	 Catch:{ InterruptedException -> 0x002d }
        goto L_0x0032;
    L_0x002d:
        r4 = com.google.android.gms.common.api.Status.f17264b;
        r3.m12830b(r4);
    L_0x0032:
        r4 = r3.m12829a();
        r5 = "Result is not ready.";
        com.google.android.gms.common.internal.zzbq.m4814a(r4, r5);
        r4 = r3.m12822g();
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.BasePendingResult.a(long, java.util.concurrent.TimeUnit):R");
    }

    public abstract R mo3409a(Status status);

    public final void mo1542a(com.google.android.gms.common.api.PendingResult.zza com_google_android_gms_common_api_PendingResult_zza) {
        zzbq.m4818b(com_google_android_gms_common_api_PendingResult_zza != null, "Callback cannot be null.");
        synchronized (this.f13814a) {
            if (m12829a()) {
                com_google_android_gms_common_api_PendingResult_zza.mo1559a();
            } else {
                this.f13818f.add(com_google_android_gms_common_api_PendingResult_zza);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m12826a(R r4) {
        /*
        r3 = this;
        r0 = r3.f13814a;
        monitor-enter(r0);
        r1 = r3.f13825m;	 Catch:{ all -> 0x0029 }
        if (r1 != 0) goto L_0x0027;
    L_0x0007:
        r1 = r3.f13824l;	 Catch:{ all -> 0x0029 }
        if (r1 != 0) goto L_0x0027;
    L_0x000b:
        r3.m12829a();	 Catch:{ all -> 0x0029 }
        r1 = r3.m12829a();	 Catch:{ all -> 0x0029 }
        r1 = r1 ^ 1;
        r2 = "Results have already been set";
        com.google.android.gms.common.internal.zzbq.m4814a(r1, r2);	 Catch:{ all -> 0x0029 }
        r1 = r3.f13823k;	 Catch:{ all -> 0x0029 }
        r1 = r1 ^ 1;
        r2 = "Result has already been consumed";
        com.google.android.gms.common.internal.zzbq.m4814a(r1, r2);	 Catch:{ all -> 0x0029 }
        r3.m12821c(r4);	 Catch:{ all -> 0x0029 }
        monitor-exit(r0);	 Catch:{ all -> 0x0029 }
        return;
    L_0x0027:
        monitor-exit(r0);	 Catch:{ all -> 0x0029 }
        return;
    L_0x0029:
        r4 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0029 }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.BasePendingResult.a(com.google.android.gms.common.api.Result):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo1543a(com.google.android.gms.common.api.ResultCallback<? super R> r5) {
        /*
        r4 = this;
        r0 = r4.f13814a;
        monitor-enter(r0);
        if (r5 != 0) goto L_0x000c;
    L_0x0005:
        r5 = 0;
        r4.f13819g = r5;	 Catch:{ all -> 0x000a }
        monitor-exit(r0);	 Catch:{ all -> 0x000a }
        return;
    L_0x000a:
        r5 = move-exception;
        goto L_0x003c;
    L_0x000c:
        r1 = r4.f13823k;	 Catch:{ all -> 0x000a }
        r2 = 1;
        r1 = r1 ^ r2;
        r3 = "Result has already been consumed.";
        com.google.android.gms.common.internal.zzbq.m4814a(r1, r3);	 Catch:{ all -> 0x000a }
        r1 = r4.f13827o;	 Catch:{ all -> 0x000a }
        if (r1 != 0) goto L_0x001a;
    L_0x0019:
        goto L_0x001b;
    L_0x001a:
        r2 = 0;
    L_0x001b:
        r1 = "Cannot set callbacks if then() has been called.";
        com.google.android.gms.common.internal.zzbq.m4814a(r2, r1);	 Catch:{ all -> 0x000a }
        r1 = r4.mo1545d();	 Catch:{ all -> 0x000a }
        if (r1 == 0) goto L_0x0028;
    L_0x0026:
        monitor-exit(r0);	 Catch:{ all -> 0x000a }
        return;
    L_0x0028:
        r1 = r4.m12829a();	 Catch:{ all -> 0x000a }
        if (r1 == 0) goto L_0x0038;
    L_0x002e:
        r1 = r4.f13815b;	 Catch:{ all -> 0x000a }
        r2 = r4.m12822g();	 Catch:{ all -> 0x000a }
        r1.m4678a(r5, r2);	 Catch:{ all -> 0x000a }
        goto L_0x003a;
    L_0x0038:
        r4.f13819g = r5;	 Catch:{ all -> 0x000a }
    L_0x003a:
        monitor-exit(r0);	 Catch:{ all -> 0x000a }
        return;
    L_0x003c:
        monitor-exit(r0);	 Catch:{ all -> 0x000a }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.BasePendingResult.a(com.google.android.gms.common.api.ResultCallback):void");
    }

    public final void m12828a(zzdm com_google_android_gms_common_api_internal_zzdm) {
        this.f13820h.set(com_google_android_gms_common_api_internal_zzdm);
    }

    public final boolean m12829a() {
        return this.f13817e.getCount() == 0;
    }

    public final void m12830b(Status status) {
        synchronized (this.f13814a) {
            if (!m12829a()) {
                m12826a(mo3409a(status));
                this.f13825m = true;
            }
        }
    }

    public final boolean m12831b() {
        boolean d;
        synchronized (this.f13814a) {
            if (((GoogleApiClient) this.f13816d.get()) == null || !this.f13828p) {
                mo1544c();
            }
            d = mo1545d();
        }
        return d;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo1544c() {
        /*
        r2 = this;
        r0 = r2.f13814a;
        monitor-enter(r0);
        r1 = r2.f13824l;	 Catch:{ all -> 0x001c }
        if (r1 != 0) goto L_0x001a;
    L_0x0007:
        r1 = r2.f13823k;	 Catch:{ all -> 0x001c }
        if (r1 == 0) goto L_0x000c;
    L_0x000b:
        goto L_0x001a;
    L_0x000c:
        r1 = 1;
        r2.f13824l = r1;	 Catch:{ all -> 0x001c }
        r1 = com.google.android.gms.common.api.Status.f17267e;	 Catch:{ all -> 0x001c }
        r1 = r2.mo3409a(r1);	 Catch:{ all -> 0x001c }
        r2.m12821c(r1);	 Catch:{ all -> 0x001c }
        monitor-exit(r0);	 Catch:{ all -> 0x001c }
        return;
    L_0x001a:
        monitor-exit(r0);	 Catch:{ all -> 0x001c }
        return;
    L_0x001c:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x001c }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.BasePendingResult.c():void");
    }

    public final boolean mo1545d() {
        boolean z;
        synchronized (this.f13814a) {
            z = this.f13824l;
        }
        return z;
    }

    public final Integer mo1546e() {
        return null;
    }

    public final void m12835f() {
        boolean z;
        if (!this.f13828p) {
            if (!((Boolean) f13813c.get()).booleanValue()) {
                z = false;
                this.f13828p = z;
            }
        }
        z = true;
        this.f13828p = z;
    }
}
