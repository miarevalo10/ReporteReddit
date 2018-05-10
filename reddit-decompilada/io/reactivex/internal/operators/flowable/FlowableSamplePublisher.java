package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSamplePublisher<T> extends Flowable<T> {
    final Publisher<T> f35283a;
    final Publisher<?> f35284b;
    final boolean f35285c;

    static abstract class SamplePublisherSubscriber<T> extends AtomicReference<T> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> f35277c;
        final Publisher<?> f35278d;
        final AtomicLong f35279e = new AtomicLong();
        final AtomicReference<Subscription> f35280f = new AtomicReference();
        Subscription f35281g;

        abstract void mo7048a();

        abstract void mo7049b();

        abstract void mo7050c();

        SamplePublisherSubscriber(Subscriber<? super T> subscriber, Publisher<?> publisher) {
            this.f35277c = subscriber;
            this.f35278d = publisher;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f35281g, subscription)) {
                this.f35281g = subscription;
                this.f35277c.mo5623a(this);
                if (this.f35280f.get() == null) {
                    this.f35278d.subscribe(new SamplerSubscriber(this));
                    subscription.request(Long.MAX_VALUE);
                }
            }
        }

        public void onNext(T t) {
            lazySet(t);
        }

        public void onError(Throwable th) {
            SubscriptionHelper.m32777a(this.f35280f);
            this.f35277c.onError(th);
        }

        public void onComplete() {
            SubscriptionHelper.m32777a(this.f35280f);
            mo7048a();
        }

        public void request(long j) {
            if (SubscriptionHelper.m32776a(j)) {
                BackpressureHelper.m26670a(this.f35279e, j);
            }
        }

        public void cancel() {
            SubscriptionHelper.m32777a(this.f35280f);
            this.f35281g.cancel();
        }

        final void m35819d() {
            Object andSet = getAndSet(null);
            if (andSet != null) {
                if (this.f35279e.get() != 0) {
                    this.f35277c.onNext(andSet);
                    BackpressureHelper.m26673c(this.f35279e, 1);
                    return;
                }
                cancel();
                this.f35277c.onError(new MissingBackpressureException("Couldn't emit value due to lack of requests!"));
            }
        }
    }

    static final class SamplerSubscriber<T> implements FlowableSubscriber<Object> {
        final SamplePublisherSubscriber<T> f35282a;

        SamplerSubscriber(SamplePublisherSubscriber<T> samplePublisherSubscriber) {
            this.f35282a = samplePublisherSubscriber;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32779a(this.f35282a.f35280f, subscription)) {
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(Object obj) {
            this.f35282a.mo7050c();
        }

        public final void onError(Throwable th) {
            SamplePublisherSubscriber samplePublisherSubscriber = this.f35282a;
            samplePublisherSubscriber.f35281g.cancel();
            samplePublisherSubscriber.f35277c.onError(th);
        }

        public final void onComplete() {
            SamplePublisherSubscriber samplePublisherSubscriber = this.f35282a;
            samplePublisherSubscriber.f35281g.cancel();
            samplePublisherSubscriber.mo7049b();
        }
    }

    static final class SampleMainEmitLast<T> extends SamplePublisherSubscriber<T> {
        final AtomicInteger f37805a = new AtomicInteger();
        volatile boolean f37806b;

        SampleMainEmitLast(Subscriber<? super T> subscriber, Publisher<?> publisher) {
            super(subscriber, publisher);
        }

        final void mo7048a() {
            this.f37806b = true;
            if (this.f37805a.getAndIncrement() == 0) {
                m35819d();
                this.c.onComplete();
            }
        }

        final void mo7049b() {
            this.f37806b = true;
            if (this.f37805a.getAndIncrement() == 0) {
                m35819d();
                this.c.onComplete();
            }
        }

        final void mo7050c() {
            if (this.f37805a.getAndIncrement() == 0) {
                do {
                    boolean z = this.f37806b;
                    m35819d();
                    if (z) {
                        this.c.onComplete();
                        return;
                    }
                } while (this.f37805a.decrementAndGet() != 0);
            }
        }
    }

    static final class SampleMainNoLast<T> extends SamplePublisherSubscriber<T> {
        SampleMainNoLast(Subscriber<? super T> subscriber, Publisher<?> publisher) {
            super(subscriber, publisher);
        }

        final void mo7048a() {
            this.c.onComplete();
        }

        final void mo7049b() {
            this.c.onComplete();
        }

        final void mo7050c() {
            m35819d();
        }
    }

    public FlowableSamplePublisher(Publisher<T> publisher, Publisher<?> publisher2, boolean z) {
        this.f35283a = publisher;
        this.f35284b = publisher2;
        this.f35285c = z;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        Subscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        if (this.f35285c != null) {
            this.f35283a.subscribe(new SampleMainEmitLast(serializedSubscriber, this.f35284b));
        } else {
            this.f35283a.subscribe(new SampleMainNoLast(serializedSubscriber, this.f35284b));
        }
    }
}
