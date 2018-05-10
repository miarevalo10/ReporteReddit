package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTimer extends Flowable<Long> {
    final Scheduler f35474a;
    final long f35475b;
    final TimeUnit f35476c;

    static final class TimerSubscriber extends AtomicReference<Disposable> implements Runnable, Subscription {
        final Subscriber<? super Long> f31369a;
        volatile boolean f31370b;

        TimerSubscriber(Subscriber<? super Long> subscriber) {
            this.f31369a = subscriber;
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j) != null) {
                this.f31370b = 1;
            }
        }

        public final void cancel() {
            DisposableHelper.m32090a((AtomicReference) this);
        }

        public final void run() {
            if (get() != DisposableHelper.f31095a) {
                if (this.f31370b) {
                    this.f31369a.onNext(Long.valueOf(0));
                    lazySet(EmptyDisposable.INSTANCE);
                    this.f31369a.onComplete();
                    return;
                }
                lazySet(EmptyDisposable.INSTANCE);
                this.f31369a.onError(new MissingBackpressureException("Can't deliver value due to lack of requests"));
            }
        }
    }

    public FlowableTimer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.f35475b = j;
        this.f35476c = timeUnit;
        this.f35474a = scheduler;
    }

    public final void subscribeActual(Subscriber<? super Long> subscriber) {
        AtomicReference timerSubscriber = new TimerSubscriber(subscriber);
        subscriber.mo5623a(timerSubscriber);
        DisposableHelper.m32095d(timerSubscriber, this.f35474a.mo5630a(timerSubscriber, this.f35475b, this.f35476c));
    }
}
