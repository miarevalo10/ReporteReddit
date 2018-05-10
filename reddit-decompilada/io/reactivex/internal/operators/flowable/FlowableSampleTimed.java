package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSampleTimed<T> extends AbstractFlowableWithUpstream<T, T> {
    final long f37808a;
    final TimeUnit f37809b;
    final Scheduler f37810c;
    final boolean f37811d;

    static abstract class SampleTimedSubscriber<T> extends AtomicReference<T> implements FlowableSubscriber<T>, Runnable, Subscription {
        final Subscriber<? super T> f35286b;
        final long f35287c;
        final TimeUnit f35288d;
        final Scheduler f35289e;
        final AtomicLong f35290f = new AtomicLong();
        final SequentialDisposable f35291g = new SequentialDisposable();
        Subscription f35292h;

        abstract void mo7051a();

        SampleTimedSubscriber(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.f35286b = subscriber;
            this.f35287c = j;
            this.f35288d = timeUnit;
            this.f35289e = scheduler;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f35292h, subscription)) {
                this.f35292h = subscription;
                this.f35286b.mo5623a(this);
                DisposableHelper.m32094c(this.f35291g, this.f35289e.mo5675a(this, this.f35287c, this.f35287c, this.f35288d));
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void onNext(T t) {
            lazySet(t);
        }

        public void onError(Throwable th) {
            m35821c();
            this.f35286b.onError(th);
        }

        public void onComplete() {
            m35821c();
            mo7051a();
        }

        private void m35821c() {
            DisposableHelper.m32090a(this.f35291g);
        }

        public void request(long j) {
            if (SubscriptionHelper.m32776a(j)) {
                BackpressureHelper.m26670a(this.f35290f, j);
            }
        }

        public void cancel() {
            m35821c();
            this.f35292h.cancel();
        }

        final void m35824b() {
            Object andSet = getAndSet(null);
            if (andSet != null) {
                if (this.f35290f.get() != 0) {
                    this.f35286b.onNext(andSet);
                    BackpressureHelper.m26673c(this.f35290f, 1);
                    return;
                }
                cancel();
                this.f35286b.onError(new MissingBackpressureException("Couldn't emit value due to lack of requests!"));
            }
        }
    }

    static final class SampleTimedEmitLast<T> extends SampleTimedSubscriber<T> {
        final AtomicInteger f37807a = new AtomicInteger(1);

        SampleTimedEmitLast(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, Scheduler scheduler) {
            super(subscriber, j, timeUnit, scheduler);
        }

        final void mo7051a() {
            m35824b();
            if (this.f37807a.decrementAndGet() == 0) {
                this.b.onComplete();
            }
        }

        public final void run() {
            if (this.f37807a.incrementAndGet() == 2) {
                m35824b();
                if (this.f37807a.decrementAndGet() == 0) {
                    this.b.onComplete();
                }
            }
        }
    }

    static final class SampleTimedNoLast<T> extends SampleTimedSubscriber<T> {
        SampleTimedNoLast(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, Scheduler scheduler) {
            super(subscriber, j, timeUnit, scheduler);
        }

        final void mo7051a() {
            this.b.onComplete();
        }

        public final void run() {
            m35824b();
        }
    }

    public FlowableSampleTimed(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        super(flowable);
        this.f37808a = j;
        this.f37809b = timeUnit;
        this.f37810c = scheduler;
        this.f37811d = z;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        Subscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        if (this.f37811d != null) {
            this.source.subscribe(new SampleTimedEmitLast(serializedSubscriber, this.f37808a, this.f37809b, this.f37810c));
        } else {
            this.source.subscribe(new SampleTimedNoLast(serializedSubscriber, this.f37808a, this.f37809b, this.f37810c));
        }
    }
}
