package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSubscribeOn<T> extends AbstractFlowableWithUpstream<T, T> {
    final Scheduler f37831a;
    final boolean f37832b;

    static final class SubscribeOnSubscriber<T> extends AtomicReference<Thread> implements FlowableSubscriber<T>, Runnable, Subscription {
        final Subscriber<? super T> f35361a;
        final Worker f35362b;
        final AtomicReference<Subscription> f35363c = new AtomicReference();
        final AtomicLong f35364d = new AtomicLong();
        final boolean f35365e;
        Publisher<T> f35366f;

        static final class Request implements Runnable {
            private final Subscription f25078a;
            private final long f25079b;

            Request(Subscription subscription, long j) {
                this.f25078a = subscription;
                this.f25079b = j;
            }

            public final void run() {
                this.f25078a.request(this.f25079b);
            }
        }

        SubscribeOnSubscriber(Subscriber<? super T> subscriber, Worker worker, Publisher<T> publisher, boolean z) {
            this.f35361a = subscriber;
            this.f35362b = worker;
            this.f35366f = publisher;
            this.f35365e = z ^ 1;
        }

        public final void run() {
            lazySet(Thread.currentThread());
            Publisher publisher = this.f35366f;
            this.f35366f = null;
            publisher.subscribe(this);
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32779a(this.f35363c, subscription)) {
                long andSet = this.f35364d.getAndSet(0);
                if (andSet != 0) {
                    m35846a(andSet, subscription);
                }
            }
        }

        public final void onNext(T t) {
            this.f35361a.onNext(t);
        }

        public final void onError(Throwable th) {
            this.f35361a.onError(th);
            this.f35362b.mo5626a();
        }

        public final void onComplete() {
            this.f35361a.onComplete();
            this.f35362b.mo5626a();
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j)) {
                Subscription subscription = (Subscription) this.f35363c.get();
                if (subscription != null) {
                    m35846a(j, subscription);
                    return;
                }
                BackpressureHelper.m26670a(this.f35364d, j);
                Subscription subscription2 = (Subscription) this.f35363c.get();
                if (subscription2 != null) {
                    long andSet = this.f35364d.getAndSet(0);
                    if (andSet != 0) {
                        m35846a(andSet, subscription2);
                    }
                }
            }
        }

        private void m35846a(long j, Subscription subscription) {
            if (!this.f35365e) {
                if (Thread.currentThread() != get()) {
                    this.f35362b.mo6651a(new Request(subscription, j));
                    return;
                }
            }
            subscription.request(j);
        }

        public final void cancel() {
            SubscriptionHelper.m32777a(this.f35363c);
            this.f35362b.mo5626a();
        }
    }

    public FlowableSubscribeOn(Flowable<T> flowable, Scheduler scheduler, boolean z) {
        super(flowable);
        this.f37831a = scheduler;
        this.f37832b = z;
    }

    public final void subscribeActual(Subscriber<? super T> subscriber) {
        Worker a = this.f37831a.mo5629a();
        Runnable subscribeOnSubscriber = new SubscribeOnSubscriber(subscriber, a, this.source, this.f37832b);
        subscriber.mo5623a(subscribeOnSubscriber);
        a.mo6651a(subscribeOnSubscriber);
    }
}
