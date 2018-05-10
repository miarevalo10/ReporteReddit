package rx.internal.schedulers;

import java.util.concurrent.TimeUnit;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscription;
import rx.functions.Action0;
import rx.subscriptions.BooleanSubscription;
import rx.subscriptions.Subscriptions;

public final class ImmediateScheduler extends Scheduler {
    public static final ImmediateScheduler f41751b = new ImmediateScheduler();

    private class InnerImmediateScheduler extends Worker implements Subscription {
        final BooleanSubscription f42006a;
        final /* synthetic */ ImmediateScheduler f42007b;

        private InnerImmediateScheduler(ImmediateScheduler immediateScheduler) {
            this.f42007b = immediateScheduler;
            this.f42006a = new BooleanSubscription();
        }

        public final Subscription mo7928a(Action0 action0, long j, TimeUnit timeUnit) {
            return mo7927a(new SleepingAction(action0, this, Scheduler.m43414b() + timeUnit.toMillis(j)));
        }

        public final Subscription mo7927a(Action0 action0) {
            action0.mo7898a();
            return Subscriptions.m43536a();
        }

        public final void mo7893c() {
            this.f42006a.mo7893c();
        }

        public final boolean mo7894d() {
            return this.f42006a.mo7894d();
        }
    }

    private ImmediateScheduler() {
    }

    public final Worker mo7895a() {
        return new InnerImmediateScheduler();
    }
}
