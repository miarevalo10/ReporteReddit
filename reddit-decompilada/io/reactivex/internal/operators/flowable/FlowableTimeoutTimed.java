package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTimeoutTimed<T> extends AbstractFlowableWithUpstream<T, T> {
    final long f37856a;
    final TimeUnit f37857b;
    final Scheduler f37858c;
    final Publisher<? extends T> f37859d;

    interface TimeoutSupport {
        void mo6631a(long j);
    }

    static final class TimeoutTask implements Runnable {
        final TimeoutSupport f25080a;
        final long f25081b;

        TimeoutTask(long j, TimeoutSupport timeoutSupport) {
            this.f25081b = j;
            this.f25080a = timeoutSupport;
        }

        public final void run() {
            this.f25080a.mo6631a(this.f25081b);
        }
    }

    static final class FallbackSubscriber<T> implements FlowableSubscriber<T> {
        final Subscriber<? super T> f35456a;
        final SubscriptionArbiter f35457b;

        FallbackSubscriber(Subscriber<? super T> subscriber, SubscriptionArbiter subscriptionArbiter) {
            this.f35456a = subscriber;
            this.f35457b = subscriptionArbiter;
        }

        public final void mo5623a(Subscription subscription) {
            this.f35457b.m32772b(subscription);
        }

        public final void onNext(T t) {
            this.f35456a.onNext(t);
        }

        public final void onError(Throwable th) {
            this.f35456a.onError(th);
        }

        public final void onComplete() {
            this.f35456a.onComplete();
        }
    }

    static final class TimeoutFallbackSubscriber<T> extends SubscriptionArbiter implements FlowableSubscriber<T>, TimeoutSupport {
        final Subscriber<? super T> f35458a;
        final long f35459b;
        final TimeUnit f35460c;
        final Worker f35461d;
        final SequentialDisposable f35462e = new SequentialDisposable();
        final AtomicReference<Subscription> f35463f = new AtomicReference();
        final AtomicLong f35464g = new AtomicLong();
        long f35465h;
        Publisher<? extends T> f35466i;

        TimeoutFallbackSubscriber(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, Worker worker, Publisher<? extends T> publisher) {
            this.f35458a = subscriber;
            this.f35459b = j;
            this.f35460c = timeUnit;
            this.f35461d = worker;
            this.f35466i = publisher;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32779a(this.f35463f, subscription)) {
                m32772b(subscription);
            }
        }

        public final void onNext(T t) {
            long j = this.f35464g.get();
            if (j != Long.MAX_VALUE) {
                long j2 = j + 1;
                if (this.f35464g.compareAndSet(j, j2)) {
                    ((Disposable) this.f35462e.get()).mo5626a();
                    this.f35465h++;
                    this.f35458a.onNext(t);
                    m35878b(j2);
                }
            }
        }

        final void m35878b(long j) {
            DisposableHelper.m32094c(this.f35462e, this.f35461d.mo6607a(new TimeoutTask(j, this), this.f35459b, this.f35460c));
        }

        public final void onError(Throwable th) {
            if (this.f35464g.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f35462e.mo5626a();
                this.f35458a.onError(th);
                this.f35461d.mo5626a();
                return;
            }
            RxJavaPlugins.m26757a(th);
        }

        public final void onComplete() {
            if (this.f35464g.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f35462e.mo5626a();
                this.f35458a.onComplete();
                this.f35461d.mo5626a();
            }
        }

        public final void mo6631a(long j) {
            if (this.f35464g.compareAndSet(j, Long.MAX_VALUE) != null) {
                SubscriptionHelper.m32777a(this.f35463f);
                j = this.f35465h;
                if (j != 0) {
                    m32773c(j);
                }
                j = this.f35466i;
                this.f35466i = null;
                j.subscribe(new FallbackSubscriber(this.f35458a, this));
                this.f35461d.mo5626a();
            }
        }

        public final void cancel() {
            super.cancel();
            this.f35461d.mo5626a();
        }
    }

    static final class TimeoutSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, TimeoutSupport, Subscription {
        final Subscriber<? super T> f35467a;
        final long f35468b;
        final TimeUnit f35469c;
        final Worker f35470d;
        final SequentialDisposable f35471e = new SequentialDisposable();
        final AtomicReference<Subscription> f35472f = new AtomicReference();
        final AtomicLong f35473g = new AtomicLong();

        TimeoutSubscriber(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, Worker worker) {
            this.f35467a = subscriber;
            this.f35468b = j;
            this.f35469c = timeUnit;
            this.f35470d = worker;
        }

        public final void mo5623a(Subscription subscription) {
            SubscriptionHelper.m32778a(this.f35472f, this.f35473g, subscription);
        }

        public final void onNext(T t) {
            long j = get();
            if (j != Long.MAX_VALUE) {
                long j2 = 1 + j;
                if (compareAndSet(j, j2)) {
                    ((Disposable) this.f35471e.get()).mo5626a();
                    this.f35467a.onNext(t);
                    m35881b(j2);
                }
            }
        }

        final void m35881b(long j) {
            DisposableHelper.m32094c(this.f35471e, this.f35470d.mo6607a(new TimeoutTask(j, this), this.f35468b, this.f35469c));
        }

        public final void onError(Throwable th) {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f35471e.mo5626a();
                this.f35467a.onError(th);
                this.f35470d.mo5626a();
                return;
            }
            RxJavaPlugins.m26757a(th);
        }

        public final void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f35471e.mo5626a();
                this.f35467a.onComplete();
                this.f35470d.mo5626a();
            }
        }

        public final void mo6631a(long j) {
            if (compareAndSet(j, Long.MAX_VALUE) != null) {
                SubscriptionHelper.m32777a(this.f35472f);
                this.f35467a.onError(new TimeoutException());
                this.f35470d.mo5626a();
            }
        }

        public final void request(long j) {
            SubscriptionHelper.m32775a(this.f35472f, this.f35473g, j);
        }

        public final void cancel() {
            SubscriptionHelper.m32777a(this.f35472f);
            this.f35470d.mo5626a();
        }
    }

    public FlowableTimeoutTimed(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler, Publisher<? extends T> publisher) {
        super(flowable);
        this.f37856a = j;
        this.f37857b = timeUnit;
        this.f37858c = scheduler;
        this.f37859d = publisher;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        if (this.f37859d == null) {
            FlowableSubscriber timeoutSubscriber = new TimeoutSubscriber(subscriber, this.f37856a, this.f37857b, this.f37858c.mo5629a());
            subscriber.mo5623a(timeoutSubscriber);
            timeoutSubscriber.m35881b(0);
            this.source.subscribe(timeoutSubscriber);
            return;
        }
        timeoutSubscriber = new TimeoutFallbackSubscriber(subscriber, this.f37856a, this.f37857b, this.f37858c.mo5629a(), this.f37859d);
        subscriber.mo5623a(timeoutSubscriber);
        timeoutSubscriber.m35878b(0);
        this.source.subscribe(timeoutSubscriber);
    }
}
