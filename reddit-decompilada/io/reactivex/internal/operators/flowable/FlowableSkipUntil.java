package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSkipUntil<T, U> extends AbstractFlowableWithUpstream<T, T> {
    final Publisher<U> f37829a;

    static final class SkipUntilMainSubscriber<T> extends AtomicInteger implements ConditionalSubscriber<T>, Subscription {
        final Subscriber<? super T> f37823a;
        final AtomicReference<Subscription> f37824b = new AtomicReference();
        final AtomicLong f37825c = new AtomicLong();
        final OtherSubscriber f37826d = new OtherSubscriber(this);
        final AtomicThrowable f37827e = new AtomicThrowable();
        volatile boolean f37828f;

        final class OtherSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
            final /* synthetic */ SkipUntilMainSubscriber f35356a;

            OtherSubscriber(SkipUntilMainSubscriber skipUntilMainSubscriber) {
                this.f35356a = skipUntilMainSubscriber;
            }

            public final void mo5623a(Subscription subscription) {
                if (SubscriptionHelper.m32779a((AtomicReference) this, subscription)) {
                    subscription.request(Long.MAX_VALUE);
                }
            }

            public final void onNext(Object obj) {
                this.f35356a.f37828f = true;
                ((Subscription) get()).cancel();
            }

            public final void onError(Throwable th) {
                SubscriptionHelper.m32777a(this.f35356a.f37824b);
                HalfSerializer.m26690a(this.f35356a.f37823a, th, this.f35356a, this.f35356a.f37827e);
            }

            public final void onComplete() {
                this.f35356a.f37828f = true;
            }
        }

        SkipUntilMainSubscriber(Subscriber<? super T> subscriber) {
            this.f37823a = subscriber;
        }

        public final void mo5623a(Subscription subscription) {
            SubscriptionHelper.m32778a(this.f37824b, this.f37825c, subscription);
        }

        public final void onNext(T t) {
            if (mo7052a((Object) t) == null) {
                ((Subscription) this.f37824b.get()).request(1);
            }
        }

        public final boolean mo7052a(T t) {
            if (!this.f37828f) {
                return null;
            }
            HalfSerializer.m26689a(this.f37823a, (Object) t, (AtomicInteger) this, this.f37827e);
            return true;
        }

        public final void onError(Throwable th) {
            SubscriptionHelper.m32777a(this.f37826d);
            HalfSerializer.m26690a(this.f37823a, th, (AtomicInteger) this, this.f37827e);
        }

        public final void onComplete() {
            SubscriptionHelper.m32777a(this.f37826d);
            HalfSerializer.m26691a(this.f37823a, (AtomicInteger) this, this.f37827e);
        }

        public final void request(long j) {
            SubscriptionHelper.m32775a(this.f37824b, this.f37825c, j);
        }

        public final void cancel() {
            SubscriptionHelper.m32777a(this.f37824b);
            SubscriptionHelper.m32777a(this.f37826d);
        }
    }

    public FlowableSkipUntil(Flowable<T> flowable, Publisher<U> publisher) {
        super(flowable);
        this.f37829a = publisher;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        FlowableSubscriber skipUntilMainSubscriber = new SkipUntilMainSubscriber(subscriber);
        subscriber.mo5623a(skipUntilMainSubscriber);
        this.f37829a.subscribe(skipUntilMainSubscriber.f37826d);
        this.source.subscribe(skipUntilMainSubscriber);
    }
}
