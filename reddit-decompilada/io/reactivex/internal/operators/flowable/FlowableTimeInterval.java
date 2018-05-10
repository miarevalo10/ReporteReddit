package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.schedulers.Timed;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTimeInterval<T> extends AbstractFlowableWithUpstream<T, Timed<T>> {
    final Scheduler f37851a;
    final TimeUnit f37852b;

    static final class TimeIntervalSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super Timed<T>> f35437a;
        final TimeUnit f35438b;
        final Scheduler f35439c;
        Subscription f35440d;
        long f35441e;

        TimeIntervalSubscriber(Subscriber<? super Timed<T>> subscriber, TimeUnit timeUnit, Scheduler scheduler) {
            this.f35437a = subscriber;
            this.f35439c = scheduler;
            this.f35438b = timeUnit;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f35440d, subscription)) {
                this.f35441e = Scheduler.m26494a(this.f35438b);
                this.f35440d = subscription;
                this.f35437a.mo5623a(this);
            }
        }

        public final void onNext(T t) {
            long a = Scheduler.m26494a(this.f35438b);
            long j = this.f35441e;
            this.f35441e = a;
            this.f35437a.onNext(new Timed(t, a - j, this.f35438b));
        }

        public final void onError(Throwable th) {
            this.f35437a.onError(th);
        }

        public final void onComplete() {
            this.f35437a.onComplete();
        }

        public final void request(long j) {
            this.f35440d.request(j);
        }

        public final void cancel() {
            this.f35440d.cancel();
        }
    }

    public FlowableTimeInterval(Flowable<T> flowable, TimeUnit timeUnit, Scheduler scheduler) {
        super(flowable);
        this.f37851a = scheduler;
        this.f37852b = timeUnit;
    }

    protected final void subscribeActual(Subscriber<? super Timed<T>> subscriber) {
        this.source.subscribe(new TimeIntervalSubscriber(subscriber, this.f37852b, this.f37851a));
    }
}
