package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Collection;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableToList<T, U extends Collection<? super T>> extends AbstractFlowableWithUpstream<T, U> {
    final Callable<U> f37860a;

    static final class ToListSubscriber<T, U extends Collection<? super T>> extends DeferredScalarSubscription<U> implements FlowableSubscriber<T>, Subscription {
        Subscription f40268a;

        ToListSubscriber(Subscriber<? super U> subscriber, U u) {
            super(subscriber);
            this.i = u;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f40268a, subscription)) {
                this.f40268a = subscription;
                this.h.mo5623a(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(T t) {
            Collection collection = (Collection) this.i;
            if (collection != null) {
                collection.add(t);
            }
        }

        public final void onError(Throwable th) {
            this.i = null;
            this.h.onError(th);
        }

        public final void onComplete() {
            m39789a(this.i);
        }

        public final void cancel() {
            super.cancel();
            this.f40268a.cancel();
        }
    }

    public FlowableToList(Flowable<T> flowable, Callable<U> callable) {
        super(flowable);
        this.f37860a = callable;
    }

    protected final void subscribeActual(Subscriber<? super U> subscriber) {
        try {
            this.source.subscribe(new ToListSubscriber(subscriber, (Collection) ObjectHelper.m26573a(this.f37860a.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            EmptySubscription.m38160a(th, subscriber);
        }
    }
}
