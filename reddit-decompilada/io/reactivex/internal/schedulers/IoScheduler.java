package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class IoScheduler extends Scheduler {
    static final RxThreadFactory f32427b;
    static final RxThreadFactory f32428c;
    static final ThreadWorker f32429d;
    static final CachedWorkerPool f32430g;
    private static final TimeUnit f32431h = TimeUnit.SECONDS;
    final ThreadFactory f32432e;
    final AtomicReference<CachedWorkerPool> f32433f;

    static final class CachedWorkerPool implements Runnable {
        final long f25157a;
        final ConcurrentLinkedQueue<ThreadWorker> f25158b;
        final CompositeDisposable f25159c;
        private final ScheduledExecutorService f25160d;
        private final Future<?> f25161e;
        private final ThreadFactory f25162f;

        CachedWorkerPool(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            Future scheduleWithFixedDelay;
            this.f25157a = timeUnit != null ? timeUnit.toNanos(j) : 0;
            this.f25158b = new ConcurrentLinkedQueue();
            this.f25159c = new CompositeDisposable();
            this.f25162f = threadFactory;
            j = null;
            if (timeUnit != null) {
                j = Executors.newScheduledThreadPool(1, IoScheduler.f32428c);
                scheduleWithFixedDelay = j.scheduleWithFixedDelay(this, this.f25157a, this.f25157a, TimeUnit.NANOSECONDS);
            } else {
                scheduleWithFixedDelay = null;
            }
            this.f25160d = j;
            this.f25161e = scheduleWithFixedDelay;
        }

        final ThreadWorker m26658a() {
            if (this.f25159c.mo5627b()) {
                return IoScheduler.f32429d;
            }
            while (!this.f25158b.isEmpty()) {
                ThreadWorker threadWorker = (ThreadWorker) this.f25158b.poll();
                if (threadWorker != null) {
                    return threadWorker;
                }
            }
            Disposable threadWorker2 = new ThreadWorker(this.f25162f);
            this.f25159c.mo5631a(threadWorker2);
            return threadWorker2;
        }

        static long m26657b() {
            return System.nanoTime();
        }

        final void m26659c() {
            this.f25159c.mo5626a();
            if (this.f25161e != null) {
                this.f25161e.cancel(true);
            }
            if (this.f25160d != null) {
                this.f25160d.shutdownNow();
            }
        }

        public final void run() {
            if (!this.f25158b.isEmpty()) {
                long nanoTime = System.nanoTime();
                Iterator it = this.f25158b.iterator();
                while (it.hasNext()) {
                    ThreadWorker threadWorker = (ThreadWorker) it.next();
                    if (threadWorker.f38133a > nanoTime) {
                        return;
                    }
                    if (this.f25158b.remove(threadWorker)) {
                        this.f25159c.mo5632b(threadWorker);
                    }
                }
            }
        }
    }

    static final class EventLoopWorker extends Worker {
        final AtomicBoolean f35888a = new AtomicBoolean();
        private final CompositeDisposable f35889b;
        private final CachedWorkerPool f35890c;
        private final ThreadWorker f35891d;

        EventLoopWorker(CachedWorkerPool cachedWorkerPool) {
            this.f35890c = cachedWorkerPool;
            this.f35889b = new CompositeDisposable();
            this.f35891d = cachedWorkerPool.m26658a();
        }

        public final void mo5626a() {
            if (this.f35888a.compareAndSet(false, true)) {
                this.f35889b.mo5626a();
                CachedWorkerPool cachedWorkerPool = this.f35890c;
                ThreadWorker threadWorker = this.f35891d;
                threadWorker.f38133a = CachedWorkerPool.m26657b() + cachedWorkerPool.f25157a;
                cachedWorkerPool.f25158b.offer(threadWorker);
            }
        }

        public final boolean mo5627b() {
            return this.f35888a.get();
        }

        public final Disposable mo6607a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.f35889b.mo5627b()) {
                return EmptyDisposable.INSTANCE;
            }
            return this.f35891d.m35980a(runnable, j, timeUnit, this.f35889b);
        }
    }

    static final class ThreadWorker extends NewThreadWorker {
        long f38133a = 0;

        ThreadWorker(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        ThreadWorker threadWorker = new ThreadWorker(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
        f32429d = threadWorker;
        threadWorker.mo5626a();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        f32427b = new RxThreadFactory("RxCachedThreadScheduler", max);
        f32428c = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        CachedWorkerPool cachedWorkerPool = new CachedWorkerPool(0, null, f32427b);
        f32430g = cachedWorkerPool;
        cachedWorkerPool.m26659c();
    }

    public IoScheduler() {
        this(f32427b);
    }

    private IoScheduler(ThreadFactory threadFactory) {
        this.f32432e = threadFactory;
        this.f32433f = new AtomicReference(f32430g);
        mo5676b();
    }

    public final void mo5676b() {
        CachedWorkerPool cachedWorkerPool = new CachedWorkerPool(60, f32431h, this.f32432e);
        if (!this.f32433f.compareAndSet(f32430g, cachedWorkerPool)) {
            cachedWorkerPool.m26659c();
        }
    }

    public final Worker mo5629a() {
        return new EventLoopWorker((CachedWorkerPool) this.f32433f.get());
    }
}
