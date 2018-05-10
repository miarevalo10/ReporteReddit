package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzd;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public final class zzcih extends zzcjl {
    private static final AtomicLong f17858k = new AtomicLong(Long.MIN_VALUE);
    private ExecutorService f17859a;
    private zzcil f17860b;
    private zzcil f17861c;
    private final PriorityBlockingQueue<zzcik<?>> f17862d = new PriorityBlockingQueue();
    private final BlockingQueue<zzcik<?>> f17863e = new LinkedBlockingQueue();
    private final UncaughtExceptionHandler f17864f = new zzcij(this, "Thread death: Uncaught exception on worker thread");
    private final UncaughtExceptionHandler f17865g = new zzcij(this, "Thread death: Uncaught exception on network thread");
    private final Object f17866h = new Object();
    private final Semaphore f17867i = new Semaphore(2);
    private volatile boolean f17868j;

    zzcih(zzcim com_google_android_gms_internal_zzcim) {
        super(com_google_android_gms_internal_zzcim);
    }

    private final void m18260a(zzcik<?> com_google_android_gms_internal_zzcik_) {
        synchronized (this.f17866h) {
            this.f17862d.add(com_google_android_gms_internal_zzcik_);
            if (this.f17860b == null) {
                this.f17860b = new zzcil(this, "Measurement Worker", this.f17862d);
                this.f17860b.setUncaughtExceptionHandler(this.f17864f);
                this.f17860b.start();
            } else {
                this.f17860b.m5712a();
            }
        }
    }

    public static boolean m18267y() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    final ExecutorService m18268A() {
        ExecutorService executorService;
        synchronized (this.f17866h) {
            if (this.f17859a == null) {
                this.f17859a = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new ArrayBlockingQueue(100));
            }
            executorService = this.f17859a;
        }
        return executorService;
    }

    public final /* bridge */ /* synthetic */ void mo1809a() {
        super.mo1809a();
    }

    public final void m18271a(Runnable runnable) throws IllegalStateException {
        m13545L();
        zzbq.m4808a((Object) runnable);
        m18260a(new zzcik(this, runnable, "Task exception on worker thread"));
    }

    public final <V> Future<V> m18272b(Callable<V> callable) throws IllegalStateException {
        m13545L();
        zzbq.m4808a((Object) callable);
        zzcik com_google_android_gms_internal_zzcik = new zzcik(this, callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.f17860b) {
            com_google_android_gms_internal_zzcik.run();
            return com_google_android_gms_internal_zzcik;
        }
        m18260a(com_google_android_gms_internal_zzcik);
        return com_google_android_gms_internal_zzcik;
    }

    public final void mo1810b() {
        if (Thread.currentThread() != this.f17861c) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    public final void m18274b(Runnable runnable) throws IllegalStateException {
        m13545L();
        zzbq.m4808a((Object) runnable);
        zzcik com_google_android_gms_internal_zzcik = new zzcik(this, runnable, "Task exception on network thread");
        synchronized (this.f17866h) {
            this.f17863e.add(com_google_android_gms_internal_zzcik);
            if (this.f17861c == null) {
                this.f17861c = new zzcil(this, "Measurement Network", this.f17863e);
                this.f17861c.setUncaughtExceptionHandler(this.f17865g);
                this.f17861c.start();
            } else {
                this.f17861c.m5712a();
            }
        }
    }

    public final void mo1811c() {
        if (Thread.currentThread() != this.f17860b) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public final /* bridge */ /* synthetic */ zzcgd mo1812d() {
        return super.mo1812d();
    }

    public final /* bridge */ /* synthetic */ zzcgk mo1813e() {
        return super.mo1813e();
    }

    public final /* bridge */ /* synthetic */ zzcjn mo1814f() {
        return super.mo1814f();
    }

    public final /* bridge */ /* synthetic */ zzchh mo1815g() {
        return super.mo1815g();
    }

    public final /* bridge */ /* synthetic */ zzcgu mo1816h() {
        return super.mo1816h();
    }

    public final /* bridge */ /* synthetic */ zzckg mo1817i() {
        return super.mo1817i();
    }

    public final /* bridge */ /* synthetic */ zzckc mo1818j() {
        return super.mo1818j();
    }

    public final /* bridge */ /* synthetic */ zzd mo1819k() {
        return super.mo1819k();
    }

    public final /* bridge */ /* synthetic */ Context mo1820l() {
        return super.mo1820l();
    }

    public final /* bridge */ /* synthetic */ zzchi mo1821m() {
        return super.mo1821m();
    }

    public final /* bridge */ /* synthetic */ zzcgo mo1822n() {
        return super.mo1822n();
    }

    public final /* bridge */ /* synthetic */ zzchk mo1823o() {
        return super.mo1823o();
    }

    public final /* bridge */ /* synthetic */ zzclq mo1824p() {
        return super.mo1824p();
    }

    public final /* bridge */ /* synthetic */ zzcig mo1825q() {
        return super.mo1825q();
    }

    public final /* bridge */ /* synthetic */ zzclf mo1826r() {
        return super.mo1826r();
    }

    public final /* bridge */ /* synthetic */ zzcih mo1827s() {
        return super.mo1827s();
    }

    public final /* bridge */ /* synthetic */ zzchm mo1828t() {
        return super.mo1828t();
    }

    public final /* bridge */ /* synthetic */ zzchx mo1829u() {
        return super.mo1829u();
    }

    public final /* bridge */ /* synthetic */ zzcgn mo1830v() {
        return super.mo1830v();
    }

    protected final boolean mo3490w() {
        return false;
    }

    public final boolean m18296z() {
        return Thread.currentThread() == this.f17860b;
    }

    public final <V> Future<V> m18269a(Callable<V> callable) throws IllegalStateException {
        m13545L();
        zzbq.m4808a((Object) callable);
        zzcik com_google_android_gms_internal_zzcik = new zzcik(this, callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.f17860b) {
            if (this.f17862d.isEmpty() == null) {
                mo1828t().f17818c.m5693a("Callable skipped the worker queue.");
            }
            com_google_android_gms_internal_zzcik.run();
        } else {
            m18260a(com_google_android_gms_internal_zzcik);
        }
        return com_google_android_gms_internal_zzcik;
    }
}
