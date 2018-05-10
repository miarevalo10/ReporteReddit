package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable.OnSubscribe;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Action0;

public final class OnSubscribeTimerOnce implements OnSubscribe<Long> {
    final long f41919a;
    final TimeUnit f41920b;
    final Scheduler f41921c;

    public final /* synthetic */ void mo7899a(Object obj) {
        final Subscriber subscriber = (Subscriber) obj;
        Subscription a = this.f41921c.mo7895a();
        subscriber.m43809a(a);
        a.mo7928a(new Action0(this) {
            final /* synthetic */ OnSubscribeTimerOnce f41704b;

            public final void mo7898a() {
                try {
                    subscriber.a_(Long.valueOf(0));
                    subscriber.mo7906b();
                } catch (Throwable th) {
                    Exceptions.m43432a(th, subscriber);
                }
            }
        }, this.f41919a, this.f41920b);
    }

    public OnSubscribeTimerOnce(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.f41919a = j;
        this.f41920b = timeUnit;
        this.f41921c = scheduler;
    }
}
