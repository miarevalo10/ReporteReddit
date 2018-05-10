package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableScan<T> extends AbstractFlowableWithUpstream<T, T> {
    final BiFunction<T, T, T> f37812a;

    static final class ScanSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> f35295a;
        final BiFunction<T, T, T> f35296b;
        Subscription f35297c;
        T f35298d;
        boolean f35299e;

        ScanSubscriber(Subscriber<? super T> subscriber, BiFunction<T, T, T> biFunction) {
            this.f35295a = subscriber;
            this.f35296b = biFunction;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f35297c, subscription)) {
                this.f35297c = subscription;
                this.f35295a.mo5623a(this);
            }
        }

        public final void onNext(T t) {
            if (!this.f35299e) {
                Subscriber subscriber = this.f35295a;
                Object obj = this.f35298d;
                if (obj == null) {
                    this.f35298d = t;
                    subscriber.onNext(t);
                    return;
                }
                try {
                    t = ObjectHelper.m26573a(this.f35296b.apply(obj, t), "The value returned by the accumulator is null");
                    this.f35298d = t;
                    subscriber.onNext(t);
                } catch (T t2) {
                    Exceptions.m26521b(t2);
                    this.f35297c.cancel();
                    onError(t2);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f35299e) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f35299e = true;
            this.f35295a.onError(th);
        }

        public final void onComplete() {
            if (!this.f35299e) {
                this.f35299e = true;
                this.f35295a.onComplete();
            }
        }

        public final void request(long j) {
            this.f35297c.request(j);
        }

        public final void cancel() {
            this.f35297c.cancel();
        }
    }

    public FlowableScan(Flowable<T> flowable, BiFunction<T, T, T> biFunction) {
        super(flowable);
        this.f37812a = biFunction;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new ScanSubscriber(subscriber, this.f37812a));
    }
}
