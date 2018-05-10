package rx.internal.schedulers;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscription;
import rx.functions.Action0;
import rx.subscriptions.BooleanSubscription;
import rx.subscriptions.Subscriptions;

public final class TrampolineScheduler extends Scheduler {
    public static final TrampolineScheduler f41766b = new TrampolineScheduler();

    static final class TimedAction implements Comparable<TimedAction> {
        final Action0 f41346a;
        final Long f41347b;
        final int f41348c;

        public final /* synthetic */ int compareTo(Object obj) {
            TimedAction timedAction = (TimedAction) obj;
            int compareTo = this.f41347b.compareTo(timedAction.f41347b);
            return compareTo == 0 ? TrampolineScheduler.m43874a(this.f41348c, timedAction.f41348c) : compareTo;
        }

        TimedAction(Action0 action0, Long l, int i) {
            this.f41346a = action0;
            this.f41347b = l;
            this.f41348c = i;
        }
    }

    static final class InnerCurrentThreadScheduler extends Worker implements Subscription {
        final AtomicInteger f42016a = new AtomicInteger();
        final PriorityBlockingQueue<TimedAction> f42017b = new PriorityBlockingQueue();
        private final BooleanSubscription f42018c = new BooleanSubscription();
        private final AtomicInteger f42019d = new AtomicInteger();

        InnerCurrentThreadScheduler() {
        }

        private Subscription m44116a(Action0 action0, long j) {
            if (this.f42018c.mo7894d()) {
                return Subscriptions.m43536a();
            }
            final TimedAction timedAction = new TimedAction(action0, Long.valueOf(j), this.f42016a.incrementAndGet());
            this.f42017b.add(timedAction);
            if (this.f42019d.getAndIncrement() != null) {
                return Subscriptions.m43537a(new Action0(this) {
                    final /* synthetic */ InnerCurrentThreadScheduler f41765b;

                    public final void mo7898a() {
                        this.f41765b.f42017b.remove(timedAction);
                    }
                });
            }
            do {
                TimedAction timedAction2 = (TimedAction) this.f42017b.poll();
                if (timedAction2 != null) {
                    timedAction2.f41346a.mo7898a();
                }
            } while (this.f42019d.decrementAndGet() > null);
            return Subscriptions.m43536a();
        }

        public final void mo7893c() {
            this.f42018c.mo7893c();
        }

        public final boolean mo7894d() {
            return this.f42018c.mo7894d();
        }

        public final Subscription mo7927a(Action0 action0) {
            return m44116a(action0, System.currentTimeMillis());
        }

        public final Subscription mo7928a(Action0 action0, long j, TimeUnit timeUnit) {
            long currentTimeMillis = System.currentTimeMillis() + timeUnit.toMillis(j);
            return m44116a(new SleepingAction(action0, this, currentTimeMillis), currentTimeMillis);
        }
    }

    static int m43874a(int i, int i2) {
        return i < i2 ? -1 : i == i2 ? 0 : 1;
    }

    public final Worker mo7895a() {
        return new InnerCurrentThreadScheduler();
    }

    private TrampolineScheduler() {
    }
}
