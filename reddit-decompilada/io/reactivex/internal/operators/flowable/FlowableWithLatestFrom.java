package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableWithLatestFrom<T, U, R> extends AbstractFlowableWithUpstream<T, R> {
    final BiFunction<? super T, ? super U, ? extends R> f37893a;
    final Publisher<? extends U> f37894b;

    final class FlowableWithLatestSubscriber implements FlowableSubscriber<U> {
        final /* synthetic */ FlowableWithLatestFrom f35526a;
        private final WithLatestFromSubscriber<T, U, R> f35527b;

        public final void onComplete() {
        }

        FlowableWithLatestSubscriber(FlowableWithLatestFrom flowableWithLatestFrom, WithLatestFromSubscriber<T, U, R> withLatestFromSubscriber) {
            this.f35526a = flowableWithLatestFrom;
            this.f35527b = withLatestFromSubscriber;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32779a(this.f35527b.f37892e, subscription)) {
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(U u) {
            this.f35527b.lazySet(u);
        }

        public final void onError(Throwable th) {
            WithLatestFromSubscriber withLatestFromSubscriber = this.f35527b;
            SubscriptionHelper.m32777a(withLatestFromSubscriber.f37890c);
            withLatestFromSubscriber.f37888a.onError(th);
        }
    }

    static final class WithLatestFromSubscriber<T, U, R> extends AtomicReference<U> implements ConditionalSubscriber<T>, Subscription {
        final Subscriber<? super R> f37888a;
        final BiFunction<? super T, ? super U, ? extends R> f37889b;
        final AtomicReference<Subscription> f37890c = new AtomicReference();
        final AtomicLong f37891d = new AtomicLong();
        final AtomicReference<Subscription> f37892e = new AtomicReference();

        WithLatestFromSubscriber(Subscriber<? super R> subscriber, BiFunction<? super T, ? super U, ? extends R> biFunction) {
            this.f37888a = subscriber;
            this.f37889b = biFunction;
        }

        public final void mo5623a(Subscription subscription) {
            SubscriptionHelper.m32778a(this.f37890c, this.f37891d, subscription);
        }

        public final void onNext(T t) {
            if (mo7052a((Object) t) == null) {
                ((Subscription) this.f37890c.get()).request(1);
            }
        }

        public final boolean mo7052a(T t) {
            Object obj = get();
            if (obj == null) {
                return false;
            }
            try {
                this.f37888a.onNext(ObjectHelper.m26573a(this.f37889b.apply(t, obj), "The combiner returned a null value"));
                return true;
            } catch (T t2) {
                Exceptions.m26521b(t2);
                cancel();
                this.f37888a.onError(t2);
                return false;
            }
        }

        public final void onError(Throwable th) {
            SubscriptionHelper.m32777a(this.f37892e);
            this.f37888a.onError(th);
        }

        public final void onComplete() {
            SubscriptionHelper.m32777a(this.f37892e);
            this.f37888a.onComplete();
        }

        public final void request(long j) {
            SubscriptionHelper.m32775a(this.f37890c, this.f37891d, j);
        }

        public final void cancel() {
            SubscriptionHelper.m32777a(this.f37890c);
            SubscriptionHelper.m32777a(this.f37892e);
        }
    }

    public FlowableWithLatestFrom(Flowable<T> flowable, BiFunction<? super T, ? super U, ? extends R> biFunction, Publisher<? extends U> publisher) {
        super(flowable);
        this.f37893a = biFunction;
        this.f37894b = publisher;
    }

    protected final void subscribeActual(Subscriber<? super R> subscriber) {
        Object serializedSubscriber = new SerializedSubscriber(subscriber);
        FlowableSubscriber withLatestFromSubscriber = new WithLatestFromSubscriber(serializedSubscriber, this.f37893a);
        serializedSubscriber.mo5623a(withLatestFromSubscriber);
        this.f37894b.subscribe(new FlowableWithLatestSubscriber(this, withLatestFromSubscriber));
        this.source.subscribe(withLatestFromSubscriber);
    }
}
