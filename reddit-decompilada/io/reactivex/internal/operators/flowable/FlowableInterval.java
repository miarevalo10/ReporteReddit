package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableInterval extends Flowable<Long> {
    final Scheduler f35089a;
    final long f35090b;
    final long f35091c;
    final TimeUnit f35092d;

    static final class IntervalSubscriber extends AtomicLong implements Runnable, Subscription {
        final Subscriber<? super Long> f31309a;
        long f31310b;
        final AtomicReference<Disposable> f31311c = new AtomicReference();

        IntervalSubscriber(Subscriber<? super Long> subscriber) {
            this.f31309a = subscriber;
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j)) {
                BackpressureHelper.m26670a((AtomicLong) this, j);
            }
        }

        public final void cancel() {
            DisposableHelper.m32090a(this.f31311c);
        }

        public final void run() {
            if (this.f31311c.get() != DisposableHelper.f31095a) {
                Subscriber subscriber;
                if (get() != 0) {
                    subscriber = this.f31309a;
                    long j = this.f31310b;
                    this.f31310b = j + 1;
                    subscriber.onNext(Long.valueOf(j));
                    BackpressureHelper.m26673c(this, 1);
                    return;
                }
                subscriber = this.f31309a;
                StringBuilder stringBuilder = new StringBuilder("Can't deliver value ");
                stringBuilder.append(this.f31310b);
                stringBuilder.append(" due to lack of requests");
                subscriber.onError(new MissingBackpressureException(stringBuilder.toString()));
                DisposableHelper.m32090a(this.f31311c);
            }
        }

        public final void m32196a(Disposable disposable) {
            DisposableHelper.m32092b(this.f31311c, disposable);
        }
    }

    public FlowableInterval(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        this.f35090b = j;
        this.f35091c = j2;
        this.f35092d = timeUnit;
        this.f35089a = scheduler;
    }

    public final void subscribeActual(Subscriber<? super Long> subscriber) {
        IntervalSubscriber intervalSubscriber = new IntervalSubscriber(subscriber);
        subscriber.mo5623a(intervalSubscriber);
        Scheduler scheduler = this.f35089a;
        if ((scheduler instanceof TrampolineScheduler) != null) {
            Object a = scheduler.mo5629a();
            intervalSubscriber.m32196a(a);
            a.mo6652a(intervalSubscriber, this.f35090b, this.f35091c, this.f35092d);
            return;
        }
        intervalSubscriber.m32196a(scheduler.mo5675a(intervalSubscriber, this.f35090b, this.f35091c, this.f35092d));
    }
}
