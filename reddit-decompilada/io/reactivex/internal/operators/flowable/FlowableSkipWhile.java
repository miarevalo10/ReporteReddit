package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSkipWhile<T> extends AbstractFlowableWithUpstream<T, T> {
    final Predicate<? super T> f37830a;

    static final class SkipWhileSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> f35357a;
        final Predicate<? super T> f35358b;
        Subscription f35359c;
        boolean f35360d;

        SkipWhileSubscriber(Subscriber<? super T> subscriber, Predicate<? super T> predicate) {
            this.f35357a = subscriber;
            this.f35358b = predicate;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f35359c, subscription)) {
                this.f35359c = subscription;
                this.f35357a.mo5623a(this);
            }
        }

        public final void onNext(T t) {
            if (this.f35360d) {
                this.f35357a.onNext(t);
                return;
            }
            try {
                if (this.f35358b.test(t)) {
                    this.f35359c.request(1);
                    return;
                }
                this.f35360d = true;
                this.f35357a.onNext(t);
            } catch (T t2) {
                Exceptions.m26521b(t2);
                this.f35359c.cancel();
                this.f35357a.onError(t2);
            }
        }

        public final void onError(Throwable th) {
            this.f35357a.onError(th);
        }

        public final void onComplete() {
            this.f35357a.onComplete();
        }

        public final void request(long j) {
            this.f35359c.request(j);
        }

        public final void cancel() {
            this.f35359c.cancel();
        }
    }

    public FlowableSkipWhile(Flowable<T> flowable, Predicate<? super T> predicate) {
        super(flowable);
        this.f37830a = predicate;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new SkipWhileSubscriber(subscriber, this.f37830a));
    }
}
