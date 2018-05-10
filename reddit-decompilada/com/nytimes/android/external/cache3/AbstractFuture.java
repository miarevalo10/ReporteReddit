package com.nytimes.android.external.cache3;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractFuture<V> implements ListenableFuture<V> {
    private static final boolean f15633b = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    private static final Logger f15634c = Logger.getLogger(AbstractFuture.class.getName());
    private static final AtomicHelper f15635d;
    private static final Object f15636e = new Object();
    volatile Object f15637a;
    private volatile Listener f15638f;
    private volatile Waiter f15639g;

    private static abstract class AtomicHelper {
        abstract void mo2656a(Waiter waiter, Waiter waiter2);

        abstract void mo2657a(Waiter waiter, Thread thread);

        abstract boolean mo2658a(AbstractFuture<?> abstractFuture, Listener listener, Listener listener2);

        abstract boolean mo2659a(AbstractFuture<?> abstractFuture, Waiter waiter, Waiter waiter2);

        abstract boolean mo2660a(AbstractFuture<?> abstractFuture, Object obj, Object obj2);

        private AtomicHelper() {
        }
    }

    private static final class Cancellation {
        final boolean f10097a;
        final Throwable f10098b;

        Cancellation(boolean z, Throwable th) {
            this.f10097a = z;
            this.f10098b = th;
        }
    }

    private static final class Failure {
        static final Failure f10099a = new Failure(new C08271("Failure occurred while trying to finish a future."));
        final Throwable f10100b;

        class C08271 extends Throwable {
            C08271(String str) {
                super(str);
            }

            public final synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        Failure(Throwable th) {
            this.f10100b = (Throwable) Preconditions.m8670a((Object) th);
        }
    }

    private static final class Listener {
        static final Listener f10101a = new Listener(null, null);
        final Runnable f10102b;
        final Executor f10103c;
        Listener f10104d;

        Listener(Runnable runnable, Executor executor) {
            this.f10102b = runnable;
            this.f10103c = executor;
        }
    }

    private final class SetFuture implements Runnable {
        final ListenableFuture<? extends V> f10105a;
        final /* synthetic */ AbstractFuture f10106b;

        public final void run() {
            if (this.f10106b.f15637a == this) {
                this.f10106b.m15551a(this.f10105a, (Object) this);
            }
        }
    }

    private static final class Waiter {
        static final Waiter f10107a = new Waiter();
        volatile Thread f10108b;
        volatile Waiter f10109c;

        Waiter() {
        }

        Waiter(byte b) {
            AbstractFuture.f15635d.mo2657a(this, Thread.currentThread());
        }

        final void m8531a(Waiter waiter) {
            AbstractFuture.f15635d.mo2656a(this, waiter);
        }
    }

    private static final class SafeAtomicHelper extends AtomicHelper {
        final AtomicReferenceFieldUpdater<Waiter, Thread> f15628a;
        final AtomicReferenceFieldUpdater<Waiter, Waiter> f15629b;
        final AtomicReferenceFieldUpdater<AbstractFuture, Waiter> f15630c;
        final AtomicReferenceFieldUpdater<AbstractFuture, Listener> f15631d;
        final AtomicReferenceFieldUpdater<AbstractFuture, Object> f15632e;

        SafeAtomicHelper(AtomicReferenceFieldUpdater<Waiter, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<Waiter, Waiter> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractFuture, Waiter> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractFuture, Listener> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractFuture, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f15628a = atomicReferenceFieldUpdater;
            this.f15629b = atomicReferenceFieldUpdater2;
            this.f15630c = atomicReferenceFieldUpdater3;
            this.f15631d = atomicReferenceFieldUpdater4;
            this.f15632e = atomicReferenceFieldUpdater5;
        }

        final void mo2657a(Waiter waiter, Thread thread) {
            this.f15628a.lazySet(waiter, thread);
        }

        final void mo2656a(Waiter waiter, Waiter waiter2) {
            this.f15629b.lazySet(waiter, waiter2);
        }

        final boolean mo2659a(AbstractFuture<?> abstractFuture, Waiter waiter, Waiter waiter2) {
            return this.f15630c.compareAndSet(abstractFuture, waiter, waiter2);
        }

        final boolean mo2658a(AbstractFuture<?> abstractFuture, Listener listener, Listener listener2) {
            return this.f15631d.compareAndSet(abstractFuture, listener, listener2);
        }

        final boolean mo2660a(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            return this.f15632e.compareAndSet(abstractFuture, obj, obj2);
        }
    }

    private static final class SynchronizedHelper extends AtomicHelper {
        private SynchronizedHelper() {
            super();
        }

        final void mo2657a(Waiter waiter, Thread thread) {
            waiter.f10108b = thread;
        }

        final void mo2656a(Waiter waiter, Waiter waiter2) {
            waiter.f10109c = waiter2;
        }

        final boolean mo2659a(AbstractFuture<?> abstractFuture, Waiter waiter, Waiter waiter2) {
            synchronized (abstractFuture) {
                if (abstractFuture.f15639g == waiter) {
                    abstractFuture.f15639g = waiter2;
                    return true;
                }
                return null;
            }
        }

        final boolean mo2658a(AbstractFuture<?> abstractFuture, Listener listener, Listener listener2) {
            synchronized (abstractFuture) {
                if (abstractFuture.f15638f == listener) {
                    abstractFuture.f15638f = listener2;
                    return true;
                }
                return null;
            }
        }

        final boolean mo2660a(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            synchronized (abstractFuture) {
                if (abstractFuture.f15637a == obj) {
                    abstractFuture.f15637a = obj2;
                    return true;
                }
                return null;
            }
        }
    }

    public static abstract class TrustedFuture<V> extends AbstractFuture<V> {
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

        public final void mo2661a(Runnable runnable, Executor executor) {
            super.mo2661a(runnable, executor);
        }
    }

    void mo4088a() {
    }

    static {
        AtomicHelper synchronizedHelper;
        try {
            AtomicHelper safeAtomicHelper = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Thread.class, "b"), AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Waiter.class, "c"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Waiter.class, "g"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Listener.class, "f"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, "a"));
        } catch (Throwable th) {
            f15634c.log(Level.SEVERE, "UnsafeAtomicHelper is broken!");
            f15634c.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
            synchronizedHelper = new SynchronizedHelper();
        }
        f15635d = synchronizedHelper;
    }

    private void m15549a(Waiter waiter) {
        waiter.f10108b = null;
        while (true) {
            waiter = this.f15639g;
            if (waiter != Waiter.f10107a) {
                Waiter waiter2 = null;
                while (waiter != null) {
                    Waiter waiter3 = waiter.f10109c;
                    if (waiter.f10108b != null) {
                        waiter2 = waiter;
                    } else if (waiter2 != null) {
                        waiter2.f10109c = waiter3;
                        if (waiter2.f10108b == null) {
                        }
                    } else if (f15635d.mo2659a(this, waiter, waiter3) != null) {
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
        j = timeUnit.toNanos(j);
        if (Thread.interrupted() != null) {
            throw new InterruptedException();
        }
        Object obj = this.f15637a;
        if (((obj != null ? 1 : 0) & (!(obj instanceof SetFuture) ? 1 : 0)) != 0) {
            return m15554b(obj);
        }
        Object obj2;
        long nanoTime = j > 0 ? System.nanoTime() + j : 0;
        if (j >= 1000) {
            Waiter waiter = this.f15639g;
            if (waiter != Waiter.f10107a) {
                Waiter waiter2 = new Waiter((byte) 0);
                do {
                    waiter2.m8531a(waiter);
                    if (f15635d.mo2659a(this, waiter, waiter2) != null) {
                        do {
                            LockSupport.parkNanos(this, j);
                            if (Thread.interrupted() != null) {
                                m15549a(waiter2);
                                throw new InterruptedException();
                            }
                            obj2 = this.f15637a;
                            if (((obj2 != null ? 1 : 0) & ((obj2 instanceof SetFuture) == null ? 1 : null)) != 0) {
                                return m15554b(obj2);
                            }
                            j = nanoTime - System.nanoTime();
                        } while (j >= 1000);
                        m15549a(waiter2);
                    } else {
                        waiter = this.f15639g;
                    }
                } while (waiter != Waiter.f10107a);
            }
            return m15554b(this.f15637a);
        }
        while (j > 0) {
            obj2 = this.f15637a;
            if (((obj2 != null ? 1 : 0) & ((obj2 instanceof SetFuture) == null ? 1 : null)) != 0) {
                return m15554b(obj2);
            }
            if (Thread.interrupted() != null) {
                throw new InterruptedException();
            }
            j = nanoTime - System.nanoTime();
        }
        throw new TimeoutException();
    }

    public V get() throws InterruptedException, ExecutionException {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f15637a;
        if (((obj != null ? 1 : 0) & (!(obj instanceof SetFuture) ? 1 : 0)) != 0) {
            return m15554b(obj);
        }
        Waiter waiter = this.f15639g;
        if (waiter != Waiter.f10107a) {
            Waiter waiter2 = new Waiter((byte) 0);
            do {
                waiter2.m8531a(waiter);
                if (f15635d.mo2659a(this, waiter, waiter2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            m15549a(waiter2);
                            throw new InterruptedException();
                        }
                        obj = this.f15637a;
                    } while (((obj != null ? 1 : 0) & (!(obj instanceof SetFuture) ? 1 : 0)) == 0);
                    return m15554b(obj);
                }
                waiter = this.f15639g;
            } while (waiter != Waiter.f10107a);
        }
        return m15554b(this.f15637a);
    }

    private static V m15554b(Object obj) throws ExecutionException {
        if (obj instanceof Cancellation) {
            obj = ((Cancellation) obj).f10098b;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(obj);
            throw cancellationException;
        } else if (!(obj instanceof Failure)) {
            return obj == f15636e ? null : obj;
        } else {
            throw new ExecutionException(((Failure) obj).f10100b);
        }
    }

    public boolean isDone() {
        Object obj = this.f15637a;
        int i = 0;
        int i2 = obj != null ? 1 : 0;
        if (!(obj instanceof SetFuture)) {
            i = 1;
        }
        return i2 & i;
    }

    public boolean isCancelled() {
        return this.f15637a instanceof Cancellation;
    }

    public boolean cancel(boolean z) {
        Object obj = this.f15637a;
        if (((obj == null ? 1 : 0) | (obj instanceof SetFuture)) == 0) {
            return false;
        }
        Object cancellation = new Cancellation(z, f15633b ? new CancellationException("Future.cancel() was called.") : null);
        while (!f15635d.mo2660a(this, obj, cancellation)) {
            obj = this.f15637a;
            if (!(obj instanceof SetFuture)) {
            }
        }
        m15557c();
        if (obj instanceof SetFuture) {
            ((SetFuture) obj).f10105a.cancel(z);
        }
        return true;
        return false;
    }

    public void mo2661a(Runnable runnable, Executor executor) {
        Preconditions.m8671a((Object) runnable, "Runnable was null.");
        Preconditions.m8671a((Object) executor, "Executor was null.");
        Listener listener = this.f15638f;
        if (listener != Listener.f10101a) {
            Listener listener2 = new Listener(runnable, executor);
            do {
                listener2.f10104d = listener;
                if (!f15635d.mo2658a(this, listener, listener2)) {
                    listener = this.f15638f;
                } else {
                    return;
                }
            } while (listener != Listener.f10101a);
        }
        m15555b(runnable, executor);
    }

    protected boolean mo4089a(V v) {
        if (v == null) {
            Object obj = f15636e;
        }
        if (f15635d.mo2660a(this, null, obj) == null) {
            return null;
        }
        m15557c();
        return true;
    }

    protected boolean mo4090a(Throwable th) {
        if (f15635d.mo2660a(this, null, new Failure((Throwable) Preconditions.m8670a((Object) th))) == null) {
            return null;
        }
        m15557c();
        return true;
    }

    private boolean m15551a(ListenableFuture<? extends V> listenableFuture, Object obj) {
        Object failure;
        if (listenableFuture instanceof TrustedFuture) {
            listenableFuture = ((AbstractFuture) listenableFuture).f15637a;
        } else {
            try {
                listenableFuture = Uninterruptibles.m8683a(listenableFuture);
                if (listenableFuture == null) {
                    listenableFuture = f15636e;
                }
            } catch (ListenableFuture<? extends V> listenableFuture2) {
                failure = new Failure(listenableFuture2.getCause());
            } catch (ListenableFuture<? extends V> listenableFuture22) {
                failure = new Cancellation(false, listenableFuture22);
            } catch (ListenableFuture<? extends V> listenableFuture222) {
                failure = new Failure(listenableFuture222);
            }
        }
        failure = listenableFuture222;
        if (f15635d.mo2660a(this, obj, failure) == null) {
            return false;
        }
        m15557c();
        return true;
    }

    private static void m15555b(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (Throwable e) {
            Logger logger = f15634c;
            Level level = Level.SEVERE;
            StringBuilder stringBuilder = new StringBuilder("RuntimeException while executing runnable ");
            stringBuilder.append(runnable);
            stringBuilder.append(" with executor ");
            stringBuilder.append(executor);
            logger.log(level, stringBuilder.toString(), e);
        }
    }

    private void m15557c() {
        Waiter waiter;
        Listener listener;
        do {
            waiter = this.f15639g;
        } while (!f15635d.mo2659a(this, waiter, Waiter.f10107a));
        while (waiter != null) {
            Thread thread = waiter.f10108b;
            if (thread != null) {
                waiter.f10108b = null;
                LockSupport.unpark(thread);
            }
            waiter = waiter.f10109c;
        }
        do {
            listener = this.f15638f;
        } while (!f15635d.mo2658a(this, listener, Listener.f10101a));
        Listener listener2 = listener;
        listener = null;
        while (listener2 != null) {
            Listener listener3 = listener2.f10104d;
            listener2.f10104d = listener;
            listener = listener2;
            listener2 = listener3;
        }
        while (listener != null) {
            m15555b(listener.f10102b, listener.f10103c);
            listener = listener.f10104d;
        }
        mo4088a();
    }
}
