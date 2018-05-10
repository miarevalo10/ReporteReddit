package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTakeUntil<T, U> extends AbstractFlowableWithUpstream<T, T> {
    final Publisher<? extends U> f37845a;

    static final class TakeUntilMainSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> f35416a;
        final AtomicLong f35417b = new AtomicLong();
        final AtomicReference<Subscription> f35418c = new AtomicReference();
        final AtomicThrowable f35419d = new AtomicThrowable();
        final OtherSubscriber f35420e = new OtherSubscriber(this);

        final class OtherSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
            final /* synthetic */ TakeUntilMainSubscriber f35415a;

            OtherSubscriber(TakeUntilMainSubscriber takeUntilMainSubscriber) {
                this.f35415a = takeUntilMainSubscriber;
            }

            public final void mo5623a(Subscription subscription) {
                if (SubscriptionHelper.m32779a((AtomicReference) this, subscription)) {
                    subscription.request(Long.MAX_VALUE);
                }
            }

            public final void onNext(Object obj) {
                SubscriptionHelper.m32777a((AtomicReference) this);
                onComplete();
            }

            public final void onError(Throwable th) {
                SubscriptionHelper.m32777a(this.f35415a.f35418c);
                HalfSerializer.m26690a(this.f35415a.f35416a, th, this.f35415a, this.f35415a.f35419d);
            }

            public final void onComplete() {
                SubscriptionHelper.m32777a(this.f35415a.f35418c);
                HalfSerializer.m26691a(this.f35415a.f35416a, this.f35415a, this.f35415a.f35419d);
            }
        }

        TakeUntilMainSubscriber(Subscriber<? super T> subscriber) {
            this.f35416a = subscriber;
        }

        public final void mo5623a(Subscription subscription) {
            SubscriptionHelper.m32778a(this.f35418c, this.f35417b, subscription);
        }

        public final void onNext(T t) {
            HalfSerializer.m26689a(this.f35416a, (Object) t, (AtomicInteger) this, this.f35419d);
        }

        public final void onError(Throwable th) {
            SubscriptionHelper.m32777a(this.f35420e);
            HalfSerializer.m26690a(this.f35416a, th, (AtomicInteger) this, this.f35419d);
        }

        public final void onComplete() {
            SubscriptionHelper.m32777a(this.f35420e);
            HalfSerializer.m26691a(this.f35416a, (AtomicInteger) this, this.f35419d);
        }

        public final void request(long j) {
            SubscriptionHelper.m32775a(this.f35418c, this.f35417b, j);
        }

        public final void cancel() {
            SubscriptionHelper.m32777a(this.f35418c);
            SubscriptionHelper.m32777a(this.f35420e);
        }
    }

    public FlowableTakeUntil(Flowable<T> flowable, Publisher<? extends U> publisher) {
        super(flowable);
        this.f37845a = publisher;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        FlowableSubscriber takeUntilMainSubscriber = new TakeUntilMainSubscriber(subscriber);
        subscriber.mo5623a(takeUntilMainSubscriber);
        this.f37845a.subscribe(takeUntilMainSubscriber.f35420e);
        this.source.subscribe(takeUntilMainSubscriber);
    }
}
