package rx.internal.schedulers;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.util.RxThreadFactory;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.Subscriptions;

public final class CachedThreadScheduler extends Scheduler implements SchedulerLifecycle {
    static final ThreadWorker f41732b;
    static final CachedWorkerPool f41733c;
    private static final TimeUnit f41734f = TimeUnit.SECONDS;
    final ThreadFactory f41735d;
    final AtomicReference<CachedWorkerPool> f41736e = new AtomicReference(f41733c);

    static final class CachedWorkerPool {
        final long f41335a;
        final ConcurrentLinkedQueue<ThreadWorker> f41336b;
        final CompositeSubscription f41337c;
        private final ThreadFactory f41338d;
        private final ScheduledExecutorService f41339e;
        private final Future<?> f41340f;

        class C30702 implements Runnable {
            final /* synthetic */ CachedWorkerPool f41334a;

            C30702(CachedWorkerPool cachedWorkerPool) {
                this.f41334a = cachedWorkerPool;
            }

            public void run() {
                CachedWorkerPool cachedWorkerPool = this.f41334a;
                if (!cachedWorkerPool.f41336b.isEmpty()) {
                    long b = CachedWorkerPool.m43458b();
                    Iterator it = cachedWorkerPool.f41336b.iterator();
                    while (it.hasNext()) {
                        ThreadWorker threadWorker = (ThreadWorker) it.next();
                        if (threadWorker.f42058a > b) {
                            return;
                        }
                        if (cachedWorkerPool.f41336b.remove(threadWorker)) {
                            cachedWorkerPool.f41337c.m43949b(threadWorker);
                        }
                    }
                }
            }
        }

        CachedWorkerPool(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            this.f41338d = threadFactory;
            this.f41335a = timeUnit != null ? timeUnit.toNanos(j) : 0;
            this.f41336b = new ConcurrentLinkedQueue();
            this.f41337c = new CompositeSubscription();
            j = null;
            if (timeUnit != null) {
                threadFactory = Executors.newScheduledThreadPool(1, new ThreadFactory(this) {
                    final /* synthetic */ CachedWorkerPool f41333b;

                    public Thread newThread(Runnable runnable) {
                        runnable = threadFactory.newThread(runnable);
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(runnable.getName());
                        stringBuilder.append(" (Evictor)");
                        runnable.setName(stringBuilder.toString());
                        return runnable;
                    }
                });
                NewThreadWorker.m44109b(threadFactory);
                j = threadFactory.scheduleWithFixedDelay(new C30702(this), this.f41335a, this.f41335a, TimeUnit.NANOSECONDS);
            } else {
                threadFactory = null;
            }
            this.f41339e = threadFactory;
            this.f41340f = j;
        }

        final ThreadWorker m43459a() {
            if (this.f41337c.f41838b) {
                return CachedThreadScheduler.f41732b;
            }
            while (!this.f41336b.isEmpty()) {
                ThreadWorker threadWorker = (ThreadWorker) this.f41336b.poll();
                if (threadWorker != null) {
                    return threadWorker;
                }
            }
            Subscription threadWorker2 = new ThreadWorker(this.f41338d);
            this.f41337c.m43948a(threadWorker2);
            return threadWorker2;
        }

        static long m43458b() {
            return System.nanoTime();
        }

        final void m43460c() {
            try {
                if (this.f41340f != null) {
                    this.f41340f.cancel(true);
                }
                if (this.f41339e != null) {
                    this.f41339e.shutdownNow();
                }
                this.f41337c.mo7893c();
            } catch (Throwable th) {
                this.f41337c.mo7893c();
            }
        }
    }

    static final class EventLoopWorker extends Worker implements Action0 {
        final AtomicBoolean f41998a;
        private final CompositeSubscription f41999b = new CompositeSubscription();
        private final CachedWorkerPool f42000c;
        private final ThreadWorker f42001d;

        EventLoopWorker(CachedWorkerPool cachedWorkerPool) {
            this.f42000c = cachedWorkerPool;
            this.f41998a = new AtomicBoolean();
            this.f42001d = cachedWorkerPool.m43459a();
        }

        public final void mo7893c() {
            if (this.f41998a.compareAndSet(false, true)) {
                this.f42001d.mo7928a(this, 0, null);
            }
            this.f41999b.mo7893c();
        }

        public final void mo7898a() {
            CachedWorkerPool cachedWorkerPool = this.f42000c;
            ThreadWorker threadWorker = this.f42001d;
            threadWorker.f42058a = CachedWorkerPool.m43458b() + cachedWorkerPool.f41335a;
            cachedWorkerPool.f41336b.offer(threadWorker);
        }

        public final boolean mo7894d() {
            return this.f41999b.f41838b;
        }

        public final Subscription mo7927a(Action0 action0) {
            return mo7928a(action0, 0, null);
        }

        public final Subscription mo7928a(final Action0 action0, long j, TimeUnit timeUnit) {
            if (this.f41999b.f41838b) {
                return Subscriptions.m43536a();
            }
            Subscription b = this.f42001d.m44113b(new Action0(this) {
                final /* synthetic */ EventLoopWorker f41731b;

                public final void mo7898a() {
                    if (!this.f41731b.mo7894d()) {
                        action0.mo7898a();
                    }
                }
            }, j, timeUnit);
            this.f41999b.m43948a(b);
            b.f41759a.m43910a(new Remover(b, this.f41999b));
            return b;
        }
    }

    static final class ThreadWorker extends NewThreadWorker {
        long f42058a = 0;

        ThreadWorker(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        ThreadWorker threadWorker = new ThreadWorker(RxThreadFactory.f41363a);
        f41732b = threadWorker;
        threadWorker.mo7893c();
        CachedWorkerPool cachedWorkerPool = new CachedWorkerPool(null, 0, null);
        f41733c = cachedWorkerPool;
        cachedWorkerPool.m43460c();
    }

    public CachedThreadScheduler(ThreadFactory threadFactory) {
        this.f41735d = threadFactory;
        threadFactory = new CachedWorkerPool(this.f41735d, 60, f41734f);
        if (!this.f41736e.compareAndSet(f41733c, threadFactory)) {
            threadFactory.m43460c();
        }
    }

    public final void mo7903c() {
        CachedWorkerPool cachedWorkerPool;
        do {
            cachedWorkerPool = (CachedWorkerPool) this.f41736e.get();
            if (cachedWorkerPool == f41733c) {
                return;
            }
        } while (!this.f41736e.compareAndSet(cachedWorkerPool, f41733c));
        cachedWorkerPool.m43460c();
    }

    public final Worker mo7895a() {
        return new EventLoopWorker((CachedWorkerPool) this.f41736e.get());
    }
}
