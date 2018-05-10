package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableUnsubscribeOn<T> extends AbstractFlowableWithUpstream<T, T> {
    final Scheduler f37861a;

    static final class UnsubscribeSubscriber<T> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> f35482a;
        final Scheduler f35483b;
        Subscription f35484c;

        final class Cancellation implements Runnable {
            final /* synthetic */ UnsubscribeSubscriber f25082a;

            Cancellation(UnsubscribeSubscriber unsubscribeSubscriber) {
                this.f25082a = unsubscribeSubscriber;
            }

            public final void run() {
                this.f25082a.f35484c.cancel();
            }
        }

        UnsubscribeSubscriber(Subscriber<? super T> subscriber, Scheduler scheduler) {
            this.f35482a = subscriber;
            this.f35483b = scheduler;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f35484c, subscription)) {
                this.f35484c = subscription;
                this.f35482a.mo5623a(this);
            }
        }

        public final void onNext(T t) {
            if (!get()) {
                this.f35482a.onNext(t);
            }
        }

        public final void onError(Throwable th) {
            if (get()) {
                RxJavaPlugins.m26757a(th);
            } else {
                this.f35482a.onError(th);
            }
        }

        public final void onComplete() {
            if (!get()) {
                this.f35482a.onComplete();
            }
        }

        public final void request(long j) {
            this.f35484c.request(j);
        }

        public final void cancel() {
            if (compareAndSet(false, true)) {
                this.f35483b.mo5677a(new Cancellation(this));
            }
        }
    }

    public FlowableUnsubscribeOn(Flowable<T> flowable, Scheduler scheduler) {
        super(flowable);
        this.f37861a = scheduler;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new UnsubscribeSubscriber(subscriber, this.f37861a));
    }
}
