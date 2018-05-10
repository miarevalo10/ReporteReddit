package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzbs;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@zzzv
public final class zzakl {
    public static <T> zzaku<T> m5377a(T t) {
        return new zzaku(t);
    }

    public static <V> zzakv<V> m5378a(zzakv<V> com_google_android_gms_internal_zzakv_V, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        zzalf com_google_android_gms_internal_zzalf = new zzalf();
        m5386a((zzakv) com_google_android_gms_internal_zzalf, (Future) com_google_android_gms_internal_zzakv_V);
        Future schedule = scheduledExecutorService.schedule(new zzakp(com_google_android_gms_internal_zzalf), j, timeUnit);
        m5385a((zzakv) com_google_android_gms_internal_zzakv_V, com_google_android_gms_internal_zzalf);
        com_google_android_gms_internal_zzalf.mo1732a(new zzakq(schedule), zzala.f6512b);
        return com_google_android_gms_internal_zzalf;
    }

    public static <A, B> zzakv<B> m5379a(zzakv<A> com_google_android_gms_internal_zzakv_A, zzakg<? super A, ? extends B> com_google_android_gms_internal_zzakg__super_A___extends_B, Executor executor) {
        zzakv com_google_android_gms_internal_zzalf = new zzalf();
        com_google_android_gms_internal_zzakv_A.mo1732a(new zzako(com_google_android_gms_internal_zzalf, com_google_android_gms_internal_zzakg__super_A___extends_B, com_google_android_gms_internal_zzakv_A), executor);
        m5386a(com_google_android_gms_internal_zzalf, (Future) com_google_android_gms_internal_zzakv_A);
        return com_google_android_gms_internal_zzalf;
    }

    public static <A, B> zzakv<B> m5380a(zzakv<A> com_google_android_gms_internal_zzakv_A, zzakh<A, B> com_google_android_gms_internal_zzakh_A__B, Executor executor) {
        zzakv com_google_android_gms_internal_zzalf = new zzalf();
        com_google_android_gms_internal_zzakv_A.mo1732a(new zzakn(com_google_android_gms_internal_zzalf, com_google_android_gms_internal_zzakh_A__B, com_google_android_gms_internal_zzakv_A), executor);
        m5386a(com_google_android_gms_internal_zzalf, (Future) com_google_android_gms_internal_zzakv_A);
        return com_google_android_gms_internal_zzalf;
    }

    public static <V, X extends Throwable> zzakv<V> m5381a(zzakv<? extends V> com_google_android_gms_internal_zzakv__extends_V, Class<X> cls, zzakg<? super X, ? extends V> com_google_android_gms_internal_zzakg__super_X___extends_V, Executor executor) {
        zzakv com_google_android_gms_internal_zzalf = new zzalf();
        m5386a(com_google_android_gms_internal_zzalf, (Future) com_google_android_gms_internal_zzakv__extends_V);
        com_google_android_gms_internal_zzakv__extends_V.mo1732a(new zzakr(com_google_android_gms_internal_zzalf, com_google_android_gms_internal_zzakv__extends_V, cls, com_google_android_gms_internal_zzakg__super_X___extends_V, executor), zzala.f6512b);
        return com_google_android_gms_internal_zzalf;
    }

    public static <T> T m5382a(Future<T> future, T t) {
        Throwable e;
        try {
            return future.get(((Long) zzkb.m6350f().m6488a(zznh.bl)).longValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            e = e2;
            future.cancel(true);
            zzakb.m5369c("InterruptedException caught while resolving future.", e);
            Thread.currentThread().interrupt();
            zzbs.m4490i().m13246a(e, "Futures.resolveFuture");
            return t;
        } catch (Exception e3) {
            e = e3;
            future.cancel(true);
            zzakb.m5367b("Error waiting for future.", e);
            zzbs.m4490i().m13246a(e, "Futures.resolveFuture");
            return t;
        }
    }

    public static <T> T m5383a(Future<T> future, T t, long j, TimeUnit timeUnit) {
        Throwable e;
        try {
            return future.get(j, timeUnit);
        } catch (InterruptedException e2) {
            e = e2;
            future.cancel(true);
            zzakb.m5369c("InterruptedException caught while resolving future.", e);
            Thread.currentThread().interrupt();
            zzbs.m4490i().m13246a(e, "Futures.resolveFuture");
            return t;
        } catch (Exception e3) {
            e = e3;
            future.cancel(true);
            zzakb.m5367b("Error waiting for future.", e);
            zzbs.m4490i().m13246a(e, "Futures.resolveFuture");
            return t;
        }
    }

    public static <V> void m5384a(zzakv<V> com_google_android_gms_internal_zzakv_V, zzaki<V> com_google_android_gms_internal_zzaki_V, Executor executor) {
        com_google_android_gms_internal_zzakv_V.mo1732a(new zzakm(com_google_android_gms_internal_zzaki_V, com_google_android_gms_internal_zzakv_V), executor);
    }

    private static <V> void m5385a(zzakv<? extends V> com_google_android_gms_internal_zzakv__extends_V, zzalf<V> com_google_android_gms_internal_zzalf_V) {
        m5386a((zzakv) com_google_android_gms_internal_zzalf_V, (Future) com_google_android_gms_internal_zzakv__extends_V);
        com_google_android_gms_internal_zzakv__extends_V.mo1732a(new zzaks(com_google_android_gms_internal_zzalf_V, com_google_android_gms_internal_zzakv__extends_V), zzala.f6512b);
    }

    private static <A, B> void m5386a(zzakv<A> com_google_android_gms_internal_zzakv_A, Future<B> future) {
        com_google_android_gms_internal_zzakv_A.mo1732a(new zzakt(com_google_android_gms_internal_zzakv_A, future), zzala.f6512b);
    }

    static final /* synthetic */ void m5387a(com.google.android.gms.internal.zzalf r1, com.google.android.gms.internal.zzakg r2, com.google.android.gms.internal.zzakv r3) {
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
        r0 = r1.isCancelled();
        if (r0 == 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r3 = r3.get();	 Catch:{ CancellationException -> 0x002d, ExecutionException -> 0x0024, InterruptedException -> 0x0018, Exception -> 0x0013 }
        r2 = r2.mo1516a(r3);	 Catch:{ CancellationException -> 0x002d, ExecutionException -> 0x0024, InterruptedException -> 0x0018, Exception -> 0x0013 }
        m5385a(r2, r1);	 Catch:{ CancellationException -> 0x002d, ExecutionException -> 0x0024, InterruptedException -> 0x0018, Exception -> 0x0013 }
        return;
    L_0x0013:
        r2 = move-exception;
        r1.m13329a(r2);
        return;
    L_0x0018:
        r2 = move-exception;
        r3 = java.lang.Thread.currentThread();
        r3.interrupt();
        r1.m13329a(r2);
        return;
    L_0x0024:
        r2 = move-exception;
        r2 = r2.getCause();
        r1.m13329a(r2);
        return;
    L_0x002d:
        r2 = 1;
        r1.cancel(r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzakl.a(com.google.android.gms.internal.zzalf, com.google.android.gms.internal.zzakg, com.google.android.gms.internal.zzakv):void");
    }

    static final /* synthetic */ void m5388a(zzalf com_google_android_gms_internal_zzalf, zzakv com_google_android_gms_internal_zzakv, Class cls, zzakg com_google_android_gms_internal_zzakg, Executor executor) {
        Throwable cause;
        try {
            com_google_android_gms_internal_zzalf.m13330b(com_google_android_gms_internal_zzakv.get());
        } catch (ExecutionException e) {
            cause = e.getCause();
            if (cls.isInstance(cause)) {
                m5385a(m5379a(m5377a(cause), com_google_android_gms_internal_zzakg, executor), com_google_android_gms_internal_zzalf);
            } else {
                com_google_android_gms_internal_zzalf.m13329a(cause);
            }
        } catch (InterruptedException e2) {
            cause = e2;
            Thread.currentThread().interrupt();
            if (cls.isInstance(cause)) {
                com_google_android_gms_internal_zzalf.m13329a(cause);
            } else {
                m5385a(m5379a(m5377a(cause), com_google_android_gms_internal_zzakg, executor), com_google_android_gms_internal_zzalf);
            }
        } catch (Exception e3) {
            cause = e3;
            if (cls.isInstance(cause)) {
                m5385a(m5379a(m5377a(cause), com_google_android_gms_internal_zzakg, executor), com_google_android_gms_internal_zzalf);
            } else {
                com_google_android_gms_internal_zzalf.m13329a(cause);
            }
        }
    }
}
