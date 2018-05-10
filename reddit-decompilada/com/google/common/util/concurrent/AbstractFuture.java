package com.google.common.util.concurrent;

import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.lang.reflect.Field;
import java.security.PrivilegedExceptionAction;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

public abstract class AbstractFuture<V> extends FluentFuture<V> {
    private static final boolean f19267b = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    private static final Logger f19268c = Logger.getLogger(AbstractFuture.class.getName());
    private static final AtomicHelper f19269d;
    private static final Object f19270e = new Object();
    volatile Object f19271a;
    private volatile Listener f19272f;
    private volatile Waiter f19273g;

    private static abstract class AtomicHelper {
        abstract void mo2445a(Waiter waiter, Waiter waiter2);

        abstract void mo2446a(Waiter waiter, Thread thread);

        abstract boolean mo2447a(AbstractFuture<?> abstractFuture, Listener listener, Listener listener2);

        abstract boolean mo2448a(AbstractFuture<?> abstractFuture, Waiter waiter, Waiter waiter2);

        abstract boolean mo2449a(AbstractFuture<?> abstractFuture, Object obj, Object obj2);

        private AtomicHelper() {
        }
    }

    private static final class Cancellation {
        static final Cancellation f8558a;
        static final Cancellation f8559b;
        final boolean f8560c;
        final Throwable f8561d;

        static {
            if (AbstractFuture.f19267b) {
                f8559b = null;
                f8558a = null;
                return;
            }
            f8559b = new Cancellation(false, null);
            f8558a = new Cancellation(true, null);
        }

        Cancellation(boolean z, Throwable th) {
            this.f8560c = z;
            this.f8561d = th;
        }
    }

    private static final class Failure {
        static final Failure f8562a = new Failure(new Throwable("Failure occurred while trying to finish a future.") {
            public final synchronized Throwable fillInStackTrace() {
                return this;
            }
        });
        final Throwable f8563b;

        Failure(Throwable th) {
            this.f8563b = (Throwable) Preconditions.m6908a((Object) th);
        }
    }

    private static final class Listener {
        static final Listener f8564a = new Listener(null, null);
        final Runnable f8565b;
        final Executor f8566c;
        Listener f8567d;

        Listener(Runnable runnable, Executor executor) {
            this.f8565b = runnable;
            this.f8566c = executor;
        }
    }

    private static final class SetFuture<V> implements Runnable {
        final AbstractFuture<V> f8568a;
        final ListenableFuture<? extends V> f8569b;

        public final void run() {
            if (this.f8568a.f19271a == this) {
                if (AbstractFuture.f19269d.mo2449a(this.f8568a, (Object) this, AbstractFuture.m20509b(this.f8569b))) {
                    AbstractFuture.m20517e(this.f8568a);
                }
            }
        }
    }

    private static final class Waiter {
        static final Waiter f8570a = new Waiter();
        volatile Thread f8571b;
        volatile Waiter f8572c;

        Waiter() {
        }

        Waiter(byte b) {
            AbstractFuture.f19269d.mo2446a(this, Thread.currentThread());
        }

        final void m7336a(Waiter waiter) {
            AbstractFuture.f19269d.mo2445a(this, waiter);
        }
    }

    private static final class SafeAtomicHelper extends AtomicHelper {
        final AtomicReferenceFieldUpdater<Waiter, Thread> f14959a;
        final AtomicReferenceFieldUpdater<Waiter, Waiter> f14960b;
        final AtomicReferenceFieldUpdater<AbstractFuture, Waiter> f14961c;
        final AtomicReferenceFieldUpdater<AbstractFuture, Listener> f14962d;
        final AtomicReferenceFieldUpdater<AbstractFuture, Object> f14963e;

        SafeAtomicHelper(AtomicReferenceFieldUpdater<Waiter, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<Waiter, Waiter> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractFuture, Waiter> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractFuture, Listener> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractFuture, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f14959a = atomicReferenceFieldUpdater;
            this.f14960b = atomicReferenceFieldUpdater2;
            this.f14961c = atomicReferenceFieldUpdater3;
            this.f14962d = atomicReferenceFieldUpdater4;
            this.f14963e = atomicReferenceFieldUpdater5;
        }

        final void mo2446a(Waiter waiter, Thread thread) {
            this.f14959a.lazySet(waiter, thread);
        }

        final void mo2445a(Waiter waiter, Waiter waiter2) {
            this.f14960b.lazySet(waiter, waiter2);
        }

        final boolean mo2448a(AbstractFuture<?> abstractFuture, Waiter waiter, Waiter waiter2) {
            return this.f14961c.compareAndSet(abstractFuture, waiter, waiter2);
        }

        final boolean mo2447a(AbstractFuture<?> abstractFuture, Listener listener, Listener listener2) {
            return this.f14962d.compareAndSet(abstractFuture, listener, listener2);
        }

        final boolean mo2449a(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            return this.f14963e.compareAndSet(abstractFuture, obj, obj2);
        }
    }

    private static final class SynchronizedHelper extends AtomicHelper {
        private SynchronizedHelper() {
            super();
        }

        final void mo2446a(Waiter waiter, Thread thread) {
            waiter.f8571b = thread;
        }

        final void mo2445a(Waiter waiter, Waiter waiter2) {
            waiter.f8572c = waiter2;
        }

        final boolean mo2448a(AbstractFuture<?> abstractFuture, Waiter waiter, Waiter waiter2) {
            synchronized (abstractFuture) {
                if (abstractFuture.f19273g == waiter) {
                    abstractFuture.f19273g = waiter2;
                    return true;
                }
                return null;
            }
        }

        final boolean mo2447a(AbstractFuture<?> abstractFuture, Listener listener, Listener listener2) {
            synchronized (abstractFuture) {
                if (abstractFuture.f19272f == listener) {
                    abstractFuture.f19272f = listener2;
                    return true;
                }
                return null;
            }
        }

        final boolean mo2449a(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            synchronized (abstractFuture) {
                if (abstractFuture.f19271a == obj) {
                    abstractFuture.f19271a = obj2;
                    return true;
                }
                return null;
            }
        }
    }

    private static final class UnsafeAtomicHelper extends AtomicHelper {
        static final Unsafe f14964a;
        static final long f14965b;
        static final long f14966c;
        static final long f14967d;
        static final long f14968e;
        static final long f14969f;

        static class C04511 implements PrivilegedExceptionAction<Unsafe> {
            C04511() {
            }

            public final /* synthetic */ Object run() throws Exception {
                Class cls = Unsafe.class;
                for (Field field : cls.getDeclaredFields()) {
                    field.setAccessible(true);
                    Object obj = field.get(null);
                    if (cls.isInstance(obj)) {
                        return (Unsafe) cls.cast(obj);
                    }
                }
                throw new NoSuchFieldError("the Unsafe");
            }
        }

        private UnsafeAtomicHelper() {
            super();
        }

        static {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = sun.misc.Unsafe.getUnsafe();	 Catch:{ SecurityException -> 0x0005 }
            goto L_0x0010;
        L_0x0005:
            r0 = new com.google.common.util.concurrent.AbstractFuture$UnsafeAtomicHelper$1;	 Catch:{ PrivilegedActionException -> 0x005f }
            r0.<init>();	 Catch:{ PrivilegedActionException -> 0x005f }
            r0 = java.security.AccessController.doPrivileged(r0);	 Catch:{ PrivilegedActionException -> 0x005f }
            r0 = (sun.misc.Unsafe) r0;	 Catch:{ PrivilegedActionException -> 0x005f }
        L_0x0010:
            r1 = com.google.common.util.concurrent.AbstractFuture.class;	 Catch:{ Exception -> 0x0055 }
            r2 = "waiters";	 Catch:{ Exception -> 0x0055 }
            r2 = r1.getDeclaredField(r2);	 Catch:{ Exception -> 0x0055 }
            r2 = r0.objectFieldOffset(r2);	 Catch:{ Exception -> 0x0055 }
            f14966c = r2;	 Catch:{ Exception -> 0x0055 }
            r2 = "listeners";	 Catch:{ Exception -> 0x0055 }
            r2 = r1.getDeclaredField(r2);	 Catch:{ Exception -> 0x0055 }
            r2 = r0.objectFieldOffset(r2);	 Catch:{ Exception -> 0x0055 }
            f14965b = r2;	 Catch:{ Exception -> 0x0055 }
            r2 = "value";	 Catch:{ Exception -> 0x0055 }
            r1 = r1.getDeclaredField(r2);	 Catch:{ Exception -> 0x0055 }
            r1 = r0.objectFieldOffset(r1);	 Catch:{ Exception -> 0x0055 }
            f14967d = r1;	 Catch:{ Exception -> 0x0055 }
            r1 = com.google.common.util.concurrent.AbstractFuture.Waiter.class;	 Catch:{ Exception -> 0x0055 }
            r2 = "b";	 Catch:{ Exception -> 0x0055 }
            r1 = r1.getDeclaredField(r2);	 Catch:{ Exception -> 0x0055 }
            r1 = r0.objectFieldOffset(r1);	 Catch:{ Exception -> 0x0055 }
            f14968e = r1;	 Catch:{ Exception -> 0x0055 }
            r1 = com.google.common.util.concurrent.AbstractFuture.Waiter.class;	 Catch:{ Exception -> 0x0055 }
            r2 = "c";	 Catch:{ Exception -> 0x0055 }
            r1 = r1.getDeclaredField(r2);	 Catch:{ Exception -> 0x0055 }
            r1 = r0.objectFieldOffset(r1);	 Catch:{ Exception -> 0x0055 }
            f14969f = r1;	 Catch:{ Exception -> 0x0055 }
            f14964a = r0;	 Catch:{ Exception -> 0x0055 }
            return;
        L_0x0055:
            r0 = move-exception;
            com.google.common.base.Throwables.m6938a(r0);
            r1 = new java.lang.RuntimeException;
            r1.<init>(r0);
            throw r1;
        L_0x005f:
            r0 = move-exception;
            r1 = new java.lang.RuntimeException;
            r2 = "Could not initialize intrinsics";
            r0 = r0.getCause();
            r1.<init>(r2, r0);
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.AbstractFuture.UnsafeAtomicHelper.<clinit>():void");
        }

        final void mo2446a(Waiter waiter, Thread thread) {
            f14964a.putObject(waiter, f14968e, thread);
        }

        final void mo2445a(Waiter waiter, Waiter waiter2) {
            f14964a.putObject(waiter, f14969f, waiter2);
        }

        final boolean mo2448a(AbstractFuture<?> abstractFuture, Waiter waiter, Waiter waiter2) {
            return f14964a.compareAndSwapObject(abstractFuture, f14966c, waiter, waiter2);
        }

        final boolean mo2447a(AbstractFuture<?> abstractFuture, Listener listener, Listener listener2) {
            return f14964a.compareAndSwapObject(abstractFuture, f14965b, listener, listener2);
        }

        final boolean mo2449a(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            return f14964a.compareAndSwapObject(abstractFuture, f14967d, obj, obj2);
        }
    }

    static abstract class TrustedFuture<V> extends AbstractFuture<V> {
        TrustedFuture() {
        }

        public final V get() throws InterruptedException, ExecutionException {
            return super.get();
        }

        public final V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return super.get(j, timeUnit);
        }

        public final boolean isDone() {
            return super.isDone();
        }

        public final boolean isCancelled() {
            return super.isCancelled();
        }

        public final void mo4057a(Runnable runnable, Executor executor) {
            super.mo4057a(runnable, executor);
        }

        public final boolean cancel(boolean z) {
            return super.cancel(z);
        }
    }

    protected void mo4396a() {
    }

    static {
        AtomicHelper unsafeAtomicHelper;
        Throwable th;
        Throwable th2 = null;
        try {
            unsafeAtomicHelper = new UnsafeAtomicHelper();
            th = null;
        } catch (Throwable th3) {
            th2 = th3;
            th = th;
            unsafeAtomicHelper = new SynchronizedHelper();
        }
        f19269d = unsafeAtomicHelper;
        if (th2 != null) {
            f19268c.log(Level.SEVERE, "UnsafeAtomicHelper is broken!", th);
            f19268c.log(Level.SEVERE, "SafeAtomicHelper is broken!", th2);
        }
    }

    private void m20507a(Waiter waiter) {
        waiter.f8571b = null;
        while (true) {
            waiter = this.f19273g;
            if (waiter != Waiter.f8570a) {
                Waiter waiter2 = null;
                while (waiter != null) {
                    Waiter waiter3 = waiter.f8572c;
                    if (waiter.f8571b != null) {
                        waiter2 = waiter;
                    } else if (waiter2 != null) {
                        waiter2.f8572c = waiter3;
                        if (waiter2.f8571b == null) {
                        }
                    } else if (f19269d.mo2448a(this, waiter, waiter3) != null) {
                    }
                    waiter = waiter3;
                }
                return;
            }
            return;
        }
    }

    protected AbstractFuture() {
    }

    public V get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        AbstractFuture abstractFuture = this;
        long j2 = j;
        long toNanos = timeUnit.toNanos(j2);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = abstractFuture.f19271a;
        if (((obj != null ? 1 : 0) & (!(obj instanceof SetFuture) ? 1 : 0)) != 0) {
            return mo4398b(obj);
        }
        Object obj2;
        long nanoTime = toNanos > 0 ? System.nanoTime() + toNanos : 0;
        if (toNanos >= 1000) {
            Waiter waiter = abstractFuture.f19273g;
            if (waiter != Waiter.f8570a) {
                Waiter waiter2 = new Waiter((byte) 0);
                do {
                    waiter2.m7336a(waiter);
                    if (f19269d.mo2448a(abstractFuture, waiter, waiter2)) {
                        do {
                            LockSupport.parkNanos(abstractFuture, toNanos);
                            if (Thread.interrupted()) {
                                m20507a(waiter2);
                                throw new InterruptedException();
                            }
                            obj2 = abstractFuture.f19271a;
                            if (((obj2 != null ? 1 : 0) & (!(obj2 instanceof SetFuture) ? 1 : 0)) != 0) {
                                return mo4398b(obj2);
                            }
                            toNanos = nanoTime - System.nanoTime();
                        } while (toNanos >= 1000);
                        m20507a(waiter2);
                    } else {
                        waiter = abstractFuture.f19273g;
                    }
                } while (waiter != Waiter.f8570a);
            }
            return mo4398b(abstractFuture.f19271a);
        }
        while (toNanos > 0) {
            obj2 = abstractFuture.f19271a;
            if (((obj2 != null ? 1 : 0) & (!(obj2 instanceof SetFuture) ? 1 : 0)) != 0) {
                return mo4398b(obj2);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            toNanos = nanoTime - System.nanoTime();
        }
        String abstractFuture2 = toString();
        if (isDone()) {
            StringBuilder stringBuilder = new StringBuilder("Waited ");
            stringBuilder.append(j2);
            stringBuilder.append(" ");
            stringBuilder.append(Ascii.m6871a(timeUnit.toString()));
            stringBuilder.append(" but future completed as timeout expired");
            throw new TimeoutException(stringBuilder.toString());
        }
        StringBuilder stringBuilder2 = new StringBuilder("Waited ");
        stringBuilder2.append(j2);
        stringBuilder2.append(" ");
        stringBuilder2.append(Ascii.m6871a(timeUnit.toString()));
        stringBuilder2.append(" for ");
        stringBuilder2.append(abstractFuture2);
        throw new TimeoutException(stringBuilder2.toString());
    }

    public V get() throws InterruptedException, ExecutionException {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f19271a;
        if (((obj != null ? 1 : 0) & (!(obj instanceof SetFuture) ? 1 : 0)) != 0) {
            return mo4398b(obj);
        }
        Waiter waiter = this.f19273g;
        if (waiter != Waiter.f8570a) {
            Waiter waiter2 = new Waiter((byte) 0);
            do {
                waiter2.m7336a(waiter);
                if (f19269d.mo2448a(this, waiter, waiter2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            m20507a(waiter2);
                            throw new InterruptedException();
                        }
                        obj = this.f19271a;
                    } while (((obj != null ? 1 : 0) & (!(obj instanceof SetFuture) ? 1 : 0)) == 0);
                    return mo4398b(obj);
                }
                waiter = this.f19273g;
            } while (waiter != Waiter.f8570a);
        }
        return mo4398b(this.f19271a);
    }

    private static V mo4398b(Object obj) throws ExecutionException {
        if (obj instanceof Cancellation) {
            obj = ((Cancellation) obj).f8561d;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(obj);
            throw cancellationException;
        } else if (!(obj instanceof Failure)) {
            return obj == f19270e ? null : obj;
        } else {
            throw new ExecutionException(((Failure) obj).f8563b);
        }
    }

    public boolean isDone() {
        Object obj = this.f19271a;
        int i = 0;
        int i2 = obj != null ? 1 : 0;
        if (!(obj instanceof SetFuture)) {
            i = 1;
        }
        return i2 & i;
    }

    public boolean isCancelled() {
        return this.f19271a instanceof Cancellation;
    }

    public boolean cancel(boolean z) {
        Object obj = this.f19271a;
        if (((obj == null ? 1 : 0) | (obj instanceof SetFuture)) == 0) {
            return false;
        }
        Object cancellation = f19267b ? new Cancellation(z, new CancellationException("Future.cancel() was called.")) : z ? Cancellation.f8558a : Cancellation.f8559b;
        Object obj2 = obj;
        boolean z2 = false;
        AbstractFuture abstractFuture = this;
        while (true) {
            if (f19269d.mo2449a(abstractFuture, obj2, cancellation)) {
                m20517e(abstractFuture);
                if (!(obj2 instanceof SetFuture)) {
                    return true;
                }
                ListenableFuture listenableFuture = ((SetFuture) obj2).f8569b;
                if (listenableFuture instanceof TrustedFuture) {
                    abstractFuture = (AbstractFuture) listenableFuture;
                    obj2 = abstractFuture.f19271a;
                    if (((obj2 == null ? 1 : 0) | (obj2 instanceof SetFuture)) == 0) {
                        return true;
                    }
                    z2 = true;
                } else {
                    listenableFuture.cancel(z);
                    return true;
                }
            }
            obj2 = abstractFuture.f19271a;
            if (!(obj2 instanceof SetFuture)) {
                return z2;
            }
        }
    }

    public void mo4057a(Runnable runnable, Executor executor) {
        Preconditions.m6909a((Object) runnable, (Object) "Runnable was null.");
        Preconditions.m6909a((Object) executor, (Object) "Executor was null.");
        Listener listener = this.f19272f;
        if (listener != Listener.f8564a) {
            Listener listener2 = new Listener(runnable, executor);
            do {
                listener2.f8567d = listener;
                if (!f19269d.mo2447a(this, listener, listener2)) {
                    listener = this.f19272f;
                } else {
                    return;
                }
            } while (listener != Listener.f8564a);
        }
        m20512b(runnable, executor);
    }

    protected boolean mo4399a(V v) {
        if (v == null) {
            Object obj = f19270e;
        }
        if (f19269d.mo2449a(this, null, obj) == null) {
            return null;
        }
        m20517e(this);
        return true;
    }

    protected boolean mo4400a(Throwable th) {
        if (f19269d.mo2449a(this, null, new Failure((Throwable) Preconditions.m6908a((Object) th))) == null) {
            return null;
        }
        m20517e(this);
        return true;
    }

    private static Object m20509b(ListenableFuture<?> listenableFuture) {
        if (listenableFuture instanceof TrustedFuture) {
            listenableFuture = ((AbstractFuture) listenableFuture).f19271a;
            if (listenableFuture instanceof Cancellation) {
                Cancellation cancellation = (Cancellation) listenableFuture;
                if (cancellation.f8560c) {
                    listenableFuture = cancellation.f8561d != null ? new Cancellation(false, cancellation.f8561d) : Cancellation.f8559b;
                }
            }
            return listenableFuture;
        }
        Object obj;
        try {
            listenableFuture = Futures.m14884a((Future) listenableFuture);
            if (listenableFuture == null) {
                listenableFuture = f19270e;
            }
            obj = listenableFuture;
        } catch (ListenableFuture<?> listenableFuture2) {
            obj = new Failure(listenableFuture2.getCause());
        } catch (ListenableFuture<?> listenableFuture22) {
            obj = new Cancellation(false, listenableFuture22);
        } catch (ListenableFuture<?> listenableFuture222) {
            obj = new Failure(listenableFuture222);
        }
        return obj;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append("[status=");
        if (isCancelled()) {
            stringBuilder.append("CANCELLED");
        } else if (isDone()) {
            m20508a(stringBuilder);
        } else {
            String b;
            try {
                b = mo4397b();
            } catch (RuntimeException e) {
                StringBuilder stringBuilder2 = new StringBuilder("Exception thrown from implementation: ");
                stringBuilder2.append(e.getClass());
                b = stringBuilder2.toString();
            }
            if (!Strings.m6933a(b)) {
                stringBuilder.append("PENDING, info=[");
                stringBuilder.append(b);
                stringBuilder.append("]");
            } else if (isDone()) {
                m20508a(stringBuilder);
            } else {
                stringBuilder.append("PENDING");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    protected String mo4397b() {
        Object obj = this.f19271a;
        if (obj instanceof SetFuture) {
            StringBuilder stringBuilder = new StringBuilder("setFuture=[");
            stringBuilder.append(((SetFuture) obj).f8569b);
            stringBuilder.append("]");
            return stringBuilder.toString();
        } else if (!(this instanceof ScheduledFuture)) {
            return null;
        } else {
            StringBuilder stringBuilder2 = new StringBuilder("remaining delay=[");
            stringBuilder2.append(((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS));
            stringBuilder2.append(" ms]");
            return stringBuilder2.toString();
        }
    }

    private void m20508a(java.lang.StringBuilder r3) {
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
        r2 = this;
        r0 = com.google.common.util.concurrent.Futures.m14884a(r2);	 Catch:{ ExecutionException -> 0x002b, CancellationException -> 0x0025, RuntimeException -> 0x0012 }
        r1 = "SUCCESS, result=[";	 Catch:{ ExecutionException -> 0x002b, CancellationException -> 0x0025, RuntimeException -> 0x0012 }
        r3.append(r1);	 Catch:{ ExecutionException -> 0x002b, CancellationException -> 0x0025, RuntimeException -> 0x0012 }
        r3.append(r0);	 Catch:{ ExecutionException -> 0x002b, CancellationException -> 0x0025, RuntimeException -> 0x0012 }
        r0 = "]";	 Catch:{ ExecutionException -> 0x002b, CancellationException -> 0x0025, RuntimeException -> 0x0012 }
        r3.append(r0);	 Catch:{ ExecutionException -> 0x002b, CancellationException -> 0x0025, RuntimeException -> 0x0012 }
        return;
    L_0x0012:
        r0 = move-exception;
        r1 = "UNKNOWN, cause=[";
        r3.append(r1);
        r0 = r0.getClass();
        r3.append(r0);
        r0 = " thrown from get()]";
        r3.append(r0);
        return;
    L_0x0025:
        r0 = "CANCELLED";
        r3.append(r0);
        return;
    L_0x002b:
        r0 = move-exception;
        r1 = "FAILURE, cause=[";
        r3.append(r1);
        r0 = r0.getCause();
        r3.append(r0);
        r0 = "]";
        r3.append(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.AbstractFuture.a(java.lang.StringBuilder):void");
    }

    private static void m20512b(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (Throwable e) {
            Logger logger = f19268c;
            Level level = Level.SEVERE;
            StringBuilder stringBuilder = new StringBuilder("RuntimeException while executing runnable ");
            stringBuilder.append(runnable);
            stringBuilder.append(" with executor ");
            stringBuilder.append(executor);
            logger.log(level, stringBuilder.toString(), e);
        }
    }

    private static void m20517e(AbstractFuture<?> abstractFuture) {
        Listener listener = null;
        while (true) {
            Waiter waiter = abstractFuture.f19273g;
            if (f19269d.mo2448a((AbstractFuture) abstractFuture, waiter, Waiter.f8570a)) {
                Listener listener2;
                while (waiter != null) {
                    Thread thread = waiter.f8571b;
                    if (thread != null) {
                        waiter.f8571b = null;
                        LockSupport.unpark(thread);
                    }
                    waiter = waiter.f8572c;
                }
                abstractFuture.mo4396a();
                do {
                    listener2 = abstractFuture.f19272f;
                } while (!f19269d.mo2447a((AbstractFuture) abstractFuture, listener2, Listener.f8564a));
                while (true) {
                    abstractFuture = listener;
                    listener = listener2;
                    if (listener == null) {
                        break;
                    }
                    listener2 = listener.f8567d;
                    listener.f8567d = abstractFuture;
                }
                while (abstractFuture != null) {
                    listener = abstractFuture.f8567d;
                    Runnable runnable = abstractFuture.f8565b;
                    if (runnable instanceof SetFuture) {
                        Object obj = (SetFuture) runnable;
                        abstractFuture = obj.f8568a;
                        if (abstractFuture.f19271a == obj) {
                            if (f19269d.mo2449a((AbstractFuture) abstractFuture, obj, m20509b(obj.f8569b))) {
                            }
                        } else {
                            continue;
                        }
                    } else {
                        m20512b(runnable, abstractFuture.f8566c);
                    }
                    Object obj2 = listener;
                }
                return;
            }
        }
    }
}
