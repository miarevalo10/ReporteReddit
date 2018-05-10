package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTakeUntilPredicate<T> extends AbstractFlowableWithUpstream<T, T> {
    final Predicate<? super T> f37846a;

    static final class InnerSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> f35421a;
        final Predicate<? super T> f35422b;
        Subscription f35423c;
        boolean f35424d;

        InnerSubscriber(Subscriber<? super T> subscriber, Predicate<? super T> predicate) {
            this.f35421a = subscriber;
            this.f35422b = predicate;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f35423c, subscription)) {
                this.f35423c = subscription;
                this.f35421a.mo5623a(this);
            }
        }

        public final void onNext(T t) {
            if (!this.f35424d) {
                this.f35421a.onNext(t);
                try {
                    if (this.f35422b.test(t) != null) {
                        this.f35424d = true;
                        this.f35423c.cancel();
                        this.f35421a.onComplete();
                    }
                } catch (T t2) {
                    Exceptions.m26521b(t2);
                    this.f35423c.cancel();
                    onError(t2);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f35424d) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f35424d = true;
            this.f35421a.onError(th);
        }

        public final void onComplete() {
            if (!this.f35424d) {
                this.f35424d = true;
                this.f35421a.onComplete();
            }
        }

        public final void request(long j) {
            this.f35423c.request(j);
        }

        public final void cancel() {
            this.f35423c.cancel();
        }
    }

    public FlowableTakeUntilPredicate(Flowable<T> flowable, Predicate<? super T> predicate) {
        super(flowable);
        this.f37846a = predicate;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new InnerSubscriber(subscriber, this.f37846a));
    }
}
