package rx.internal.schedulers;

import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.util.RxThreadFactory;
import rx.internal.util.SubscriptionList;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.Subscriptions;

public final class EventLoopsScheduler extends Scheduler implements SchedulerLifecycle {
    static final int f41741b;
    static final PoolWorker f41742c;
    static final FixedSchedulerPool f41743d = new FixedSchedulerPool(null, 0);
    final ThreadFactory f41744e;
    public final AtomicReference<FixedSchedulerPool> f41745f = new AtomicReference(f41743d);

    static final class FixedSchedulerPool {
        final int f41341a;
        final PoolWorker[] f41342b;
        long f41343c;

        FixedSchedulerPool(ThreadFactory threadFactory, int i) {
            this.f41341a = i;
            this.f41342b = new PoolWorker[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.f41342b[i2] = new PoolWorker(threadFactory);
            }
        }

        public final PoolWorker m43461a() {
            int i = this.f41341a;
            if (i == 0) {
                return EventLoopsScheduler.f41742c;
            }
            PoolWorker[] poolWorkerArr = this.f41342b;
            long j = this.f41343c;
            this.f41343c = 1 + j;
            return poolWorkerArr[(int) (j % ((long) i))];
        }

        public final void m43462b() {
            for (PoolWorker c : this.f41342b) {
                c.mo7893c();
            }
        }
    }

    static final class EventLoopWorker extends Worker {
        private final SubscriptionList f42002a = new SubscriptionList();
        private final CompositeSubscription f42003b = new CompositeSubscription();
        private final SubscriptionList f42004c = new SubscriptionList(this.f42002a, this.f42003b);
        private final PoolWorker f42005d;

        EventLoopWorker(PoolWorker poolWorker) {
            this.f42005d = poolWorker;
        }

        public final void mo7893c() {
            this.f42004c.mo7893c();
        }

        public final boolean mo7894d() {
            return this.f42004c.f41803b;
        }

        public final Subscription mo7927a(final Action0 action0) {
            if (this.f42004c.f41803b) {
                return Subscriptions.m43536a();
            }
            NewThreadWorker newThreadWorker = this.f42005d;
            Action0 c31211 = new Action0(this) {
                final /* synthetic */ EventLoopWorker f41738b;

                public final void mo7898a() {
                    if (!this.f41738b.mo7894d()) {
                        action0.mo7898a();
                    }
                }
            };
            SubscriptionList subscriptionList = this.f42002a;
            Subscription scheduledAction = new ScheduledAction(RxJavaHooks.m43498a(c31211), subscriptionList);
            subscriptionList.m43910a(scheduledAction);
            scheduledAction.m43869a(newThreadWorker.f42014b.submit(scheduledAction));
            return scheduledAction;
        }

        public final Subscription mo7928a(final Action0 action0, long j, TimeUnit timeUnit) {
            if (this.f42004c.f41803b) {
                return Subscriptions.m43536a();
            }
            Future submit;
            NewThreadWorker newThreadWorker = this.f42005d;
            Action0 c31222 = new Action0(this) {
                final /* synthetic */ EventLoopWorker f41740b;

                public final void mo7898a() {
                    if (!this.f41740b.mo7894d()) {
                        action0.mo7898a();
                    }
                }
            };
            CompositeSubscription compositeSubscription = this.f42003b;
            Subscription scheduledAction = new ScheduledAction(RxJavaHooks.m43498a(c31222), compositeSubscription);
            compositeSubscription.m43948a(scheduledAction);
            if (j <= 0) {
                submit = newThreadWorker.f42014b.submit(scheduledAction);
            } else {
                submit = newThreadWorker.f42014b.schedule(scheduledAction, j, timeUnit);
            }
            scheduledAction.m43869a(submit);
            return scheduledAction;
        }
    }

    static final class PoolWorker extends NewThreadWorker {
        PoolWorker(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        f41741b = intValue;
        PoolWorker poolWorker = new PoolWorker(RxThreadFactory.f41363a);
        f41742c = poolWorker;
        poolWorker.mo7893c();
    }

    public EventLoopsScheduler(ThreadFactory threadFactory) {
        this.f41744e = threadFactory;
        threadFactory = new FixedSchedulerPool(this.f41744e, f41741b);
        if (!this.f41745f.compareAndSet(f41743d, threadFactory)) {
            threadFactory.m43462b();
        }
    }

    public final Worker mo7895a() {
        return new EventLoopWorker(((FixedSchedulerPool) this.f41745f.get()).m43461a());
    }

    public final void mo7903c() {
        FixedSchedulerPool fixedSchedulerPool;
        do {
            fixedSchedulerPool = (FixedSchedulerPool) this.f41745f.get();
            if (fixedSchedulerPool == f41743d) {
                return;
            }
        } while (!this.f41745f.compareAndSet(fixedSchedulerPool, f41743d));
        fixedSchedulerPool.m43462b();
    }
}
