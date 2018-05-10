package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableOnErrorNext<T> extends AbstractFlowableWithUpstream<T, T> {
    final Function<? super Throwable, ? extends Publisher<? extends T>> f37775a;
    final boolean f37776b;

    static final class OnErrorNextSubscriber<T> implements FlowableSubscriber<T> {
        final Subscriber<? super T> f35175a;
        final Function<? super Throwable, ? extends Publisher<? extends T>> f35176b;
        final boolean f35177c;
        final SubscriptionArbiter f35178d = new SubscriptionArbiter();
        boolean f35179e;
        boolean f35180f;

        OnErrorNextSubscriber(Subscriber<? super T> subscriber, Function<? super Throwable, ? extends Publisher<? extends T>> function, boolean z) {
            this.f35175a = subscriber;
            this.f35176b = function;
            this.f35177c = z;
        }

        public final void mo5623a(Subscription subscription) {
            this.f35178d.m32772b(subscription);
        }

        public final void onNext(T t) {
            if (!this.f35180f) {
                this.f35175a.onNext(t);
                if (this.f35179e == null) {
                    this.f35178d.m32773c(1);
                }
            }
        }

        public final void onError(Throwable th) {
            if (!this.f35179e) {
                this.f35179e = true;
                if (!this.f35177c || (th instanceof Exception)) {
                    try {
                        Publisher publisher = (Publisher) this.f35176b.apply(th);
                        if (publisher == null) {
                            Throwable nullPointerException = new NullPointerException("Publisher is null");
                            nullPointerException.initCause(th);
                            this.f35175a.onError(nullPointerException);
                            return;
                        }
                        publisher.subscribe(this);
                        return;
                    } catch (Throwable th2) {
                        Exceptions.m26521b(th2);
                        this.f35175a.onError(new CompositeException(th, th2));
                        return;
                    }
                }
                this.f35175a.onError(th);
            } else if (this.f35180f) {
                RxJavaPlugins.m26757a(th);
            } else {
                this.f35175a.onError(th);
            }
        }

        public final void onComplete() {
            if (!this.f35180f) {
                this.f35180f = true;
                this.f35179e = true;
                this.f35175a.onComplete();
            }
        }
    }

    public FlowableOnErrorNext(Flowable<T> flowable, Function<? super Throwable, ? extends Publisher<? extends T>> function, boolean z) {
        super(flowable);
        this.f37775a = function;
        this.f37776b = z;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        FlowableSubscriber onErrorNextSubscriber = new OnErrorNextSubscriber(subscriber, this.f37775a, this.f37776b);
        subscriber.mo5623a(onErrorNextSubscriber.f35178d);
        this.source.subscribe(onErrorNextSubscriber);
    }
}
