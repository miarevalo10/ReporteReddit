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

public final class FlowableIntervalRange extends Flowable<Long> {
    final Scheduler f35093a;
    final long f35094b;
    final long f35095c;
    final long f35096d;
    final long f35097e;
    final TimeUnit f35098f;

    static final class IntervalRangeSubscriber extends AtomicLong implements Runnable, Subscription {
        final Subscriber<? super Long> f31312a;
        final long f31313b;
        long f31314c;
        final AtomicReference<Disposable> f31315d = new AtomicReference();

        IntervalRangeSubscriber(Subscriber<? super Long> subscriber, long j, long j2) {
            this.f31312a = subscriber;
            this.f31314c = j;
            this.f31313b = j2;
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j)) {
                BackpressureHelper.m26670a((AtomicLong) this, j);
            }
        }

        public final void cancel() {
            DisposableHelper.m32090a(this.f31315d);
        }

        public final void run() {
            if (this.f31315d.get() != DisposableHelper.f31095a) {
                long j = get();
                if (j != 0) {
                    long j2 = this.f31314c;
                    this.f31312a.onNext(Long.valueOf(j2));
                    if (j2 == this.f31313b) {
                        if (this.f31315d.get() != DisposableHelper.f31095a) {
                            this.f31312a.onComplete();
                        }
                        DisposableHelper.m32090a(this.f31315d);
                        return;
                    }
                    this.f31314c = j2 + 1;
                    if (j != Long.MAX_VALUE) {
                        decrementAndGet();
                    }
                    return;
                }
                Subscriber subscriber = this.f31312a;
                StringBuilder stringBuilder = new StringBuilder("Can't deliver value ");
                stringBuilder.append(this.f31314c);
                stringBuilder.append(" due to lack of requests");
                subscriber.onError(new MissingBackpressureException(stringBuilder.toString()));
                DisposableHelper.m32090a(this.f31315d);
            }
        }

        public final void m32197a(Disposable disposable) {
            DisposableHelper.m32092b(this.f31315d, disposable);
        }
    }

    public FlowableIntervalRange(long j, long j2, long j3, long j4, TimeUnit timeUnit, Scheduler scheduler) {
        this.f35096d = j3;
        this.f35097e = j4;
        this.f35098f = timeUnit;
        this.f35093a = scheduler;
        this.f35094b = j;
        this.f35095c = j2;
    }

    public final void subscribeActual(Subscriber<? super Long> subscriber) {
        IntervalRangeSubscriber intervalRangeSubscriber = new IntervalRangeSubscriber(subscriber, this.f35094b, this.f35095c);
        subscriber.mo5623a(intervalRangeSubscriber);
        Scheduler scheduler = this.f35093a;
        if ((scheduler instanceof TrampolineScheduler) != null) {
            Object a = scheduler.mo5629a();
            intervalRangeSubscriber.m32197a(a);
            a.mo6652a(intervalRangeSubscriber, this.f35096d, this.f35097e, this.f35098f);
            return;
        }
        intervalRangeSubscriber.m32197a(scheduler.mo5675a(intervalRangeSubscriber, this.f35096d, this.f35097e, this.f35098f));
    }
}
