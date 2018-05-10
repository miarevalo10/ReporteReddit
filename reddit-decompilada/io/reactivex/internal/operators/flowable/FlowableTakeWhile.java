package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTakeWhile<T> extends AbstractFlowableWithUpstream<T, T> {
    final Predicate<? super T> f37847a;

    static final class TakeWhileSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> f35425a;
        final Predicate<? super T> f35426b;
        Subscription f35427c;
        boolean f35428d;

        TakeWhileSubscriber(Subscriber<? super T> subscriber, Predicate<? super T> predicate) {
            this.f35425a = subscriber;
            this.f35426b = predicate;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f35427c, subscription)) {
                this.f35427c = subscription;
                this.f35425a.mo5623a(this);
            }
        }

        public final void onNext(T t) {
            if (!this.f35428d) {
                try {
                    if (this.f35426b.test(t)) {
                        this.f35425a.onNext(t);
                        return;
                    }
                    this.f35428d = true;
                    this.f35427c.cancel();
                    this.f35425a.onComplete();
                } catch (T t2) {
                    Exceptions.m26521b(t2);
                    this.f35427c.cancel();
                    onError(t2);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f35428d) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f35428d = true;
            this.f35425a.onError(th);
        }

        public final void onComplete() {
            if (!this.f35428d) {
                this.f35428d = true;
                this.f35425a.onComplete();
            }
        }

        public final void request(long j) {
            this.f35427c.request(j);
        }

        public final void cancel() {
            this.f35427c.cancel();
        }
    }

    public FlowableTakeWhile(Flowable<T> flowable, Predicate<? super T> predicate) {
        super(flowable);
        this.f37847a = predicate;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new TakeWhileSubscriber(subscriber, this.f37847a));
    }
}
