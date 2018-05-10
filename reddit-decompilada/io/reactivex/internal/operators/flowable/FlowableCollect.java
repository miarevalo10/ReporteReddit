package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableCollect<T, U> extends AbstractFlowableWithUpstream<T, U> {
    final Callable<? extends U> f37662a;
    final BiConsumer<? super U, ? super T> f37663b;

    static final class CollectSubscriber<T, U> extends DeferredScalarSubscription<U> implements FlowableSubscriber<T> {
        final BiConsumer<? super U, ? super T> f40232a;
        final U f40233b;
        Subscription f40234c;
        boolean f40235d;

        CollectSubscriber(Subscriber<? super U> subscriber, U u, BiConsumer<? super U, ? super T> biConsumer) {
            super(subscriber);
            this.f40232a = biConsumer;
            this.f40233b = u;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f40234c, subscription)) {
                this.f40234c = subscription;
                this.h.mo5623a(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(T t) {
            if (!this.f40235d) {
                try {
                    this.f40232a.mo4825a(this.f40233b, t);
                } catch (T t2) {
                    Exceptions.m26521b(t2);
                    this.f40234c.cancel();
                    onError(t2);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f40235d) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f40235d = true;
            this.h.onError(th);
        }

        public final void onComplete() {
            if (!this.f40235d) {
                this.f40235d = true;
                m39789a(this.f40233b);
            }
        }

        public final void cancel() {
            super.cancel();
            this.f40234c.cancel();
        }
    }

    public FlowableCollect(Flowable<T> flowable, Callable<? extends U> callable, BiConsumer<? super U, ? super T> biConsumer) {
        super(flowable);
        this.f37662a = callable;
        this.f37663b = biConsumer;
    }

    protected final void subscribeActual(Subscriber<? super U> subscriber) {
        try {
            this.source.subscribe(new CollectSubscriber(subscriber, ObjectHelper.m26573a(this.f37662a.call(), "The initial value supplied is null"), this.f37663b));
        } catch (Throwable th) {
            EmptySubscription.m38160a(th, subscriber);
        }
    }
}
