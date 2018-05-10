package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.ListCompositeDisposable;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ComputationScheduler extends Scheduler {
    static final FixedSchedulerPool f32412b;
    static final RxThreadFactory f32413c = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
    static final int f32414d;
    static final PoolWorker f32415e;
    final ThreadFactory f32416f;
    final AtomicReference<FixedSchedulerPool> f32417g;

    static final class FixedSchedulerPool {
        final int f25154a;
        final PoolWorker[] f25155b;
        long f25156c;

        FixedSchedulerPool(int i, ThreadFactory threadFactory) {
            this.f25154a = i;
            this.f25155b = new PoolWorker[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.f25155b[i2] = new PoolWorker(threadFactory);
            }
        }

        public final PoolWorker m26655a() {
            int i = this.f25154a;
            if (i == 0) {
                return ComputationScheduler.f32415e;
            }
            PoolWorker[] poolWorkerArr = this.f25155b;
            long j = this.f25156c;
            this.f25156c = 1 + j;
            return poolWorkerArr[(int) (j % ((long) i))];
        }

        public final void m26656b() {
            for (PoolWorker a : this.f25155b) {
                a.mo5626a();
            }
        }
    }

    static final class EventLoopWorker extends Worker {
        volatile boolean f35883a;
        private final ListCompositeDisposable f35884b = new ListCompositeDisposable();
        private final CompositeDisposable f35885c = new CompositeDisposable();
        private final ListCompositeDisposable f35886d = new ListCompositeDisposable();
        private final PoolWorker f35887e;

        EventLoopWorker(PoolWorker poolWorker) {
            this.f35887e = poolWorker;
            this.f35886d.mo5631a(this.f35884b);
            this.f35886d.mo5631a(this.f35885c);
        }

        public final void mo5626a() {
            if (!this.f35883a) {
                this.f35883a = true;
                this.f35886d.mo5626a();
            }
        }

        public final boolean mo5627b() {
            return this.f35883a;
        }

        public final Disposable mo6651a(Runnable runnable) {
            if (this.f35883a) {
                return EmptyDisposable.INSTANCE;
            }
            return this.f35887e.m35980a(runnable, 0, TimeUnit.MILLISECONDS, this.f35884b);
        }

        public final Disposable mo6607a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.f35883a) {
                return EmptyDisposable.INSTANCE;
            }
            return this.f35887e.m35980a(runnable, j, timeUnit, this.f35885c);
        }
    }

    static final class PoolWorker extends NewThreadWorker {
        PoolWorker(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        int intValue = Integer.getInteger("rx2.computation-threads", 0).intValue();
        if (intValue > 0) {
            if (intValue <= availableProcessors) {
                availableProcessors = intValue;
            }
        }
        f32414d = availableProcessors;
        PoolWorker poolWorker = new PoolWorker(new RxThreadFactory("RxComputationShutdown"));
        f32415e = poolWorker;
        poolWorker.mo5626a();
        FixedSchedulerPool fixedSchedulerPool = new FixedSchedulerPool(0, f32413c);
        f32412b = fixedSchedulerPool;
        fixedSchedulerPool.m26656b();
    }

    public ComputationScheduler() {
        this(f32413c);
    }

    private ComputationScheduler(ThreadFactory threadFactory) {
        this.f32416f = threadFactory;
        this.f32417g = new AtomicReference(f32412b);
        mo5676b();
    }

    public final Worker mo5629a() {
        return new EventLoopWorker(((FixedSchedulerPool) this.f32417g.get()).m26655a());
    }

    public final Disposable mo5630a(Runnable runnable, long j, TimeUnit timeUnit) {
        return ((FixedSchedulerPool) this.f32417g.get()).m26655a().m35983b(runnable, j, timeUnit);
    }

    public final Disposable mo5675a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return ((FixedSchedulerPool) this.f32417g.get()).m26655a().m35982b(runnable, j, j2, timeUnit);
    }

    public final void mo5676b() {
        FixedSchedulerPool fixedSchedulerPool = new FixedSchedulerPool(f32414d, this.f32416f);
        if (!this.f32417g.compareAndSet(f32412b, fixedSchedulerPool)) {
            fixedSchedulerPool.m26656b();
        }
    }
}
