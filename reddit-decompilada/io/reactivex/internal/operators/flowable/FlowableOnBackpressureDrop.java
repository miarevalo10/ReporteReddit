package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableOnBackpressureDrop<T> extends AbstractFlowableWithUpstream<T, T> implements Consumer<T> {
    final Consumer<? super T> f37774a;

    static final class BackpressureDropSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> f35161a;
        final Consumer<? super T> f35162b;
        Subscription f35163c;
        boolean f35164d;

        BackpressureDropSubscriber(Subscriber<? super T> subscriber, Consumer<? super T> consumer) {
            this.f35161a = subscriber;
            this.f35162b = consumer;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f35163c, subscription)) {
                this.f35163c = subscription;
                this.f35161a.mo5623a(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(T t) {
            if (!this.f35164d) {
                if (get() != 0) {
                    this.f35161a.onNext(t);
                    BackpressureHelper.m26673c(this, 1);
                    return;
                }
                try {
                    this.f35162b.accept(t);
                } catch (T t2) {
                    Exceptions.m26521b(t2);
                    cancel();
                    onError(t2);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f35164d) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f35164d = true;
            this.f35161a.onError(th);
        }

        public final void onComplete() {
            if (!this.f35164d) {
                this.f35164d = true;
                this.f35161a.onComplete();
            }
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j)) {
                BackpressureHelper.m26670a((AtomicLong) this, j);
            }
        }

        public final void cancel() {
            this.f35163c.cancel();
        }
    }

    public final void accept(T t) {
    }

    public FlowableOnBackpressureDrop(Flowable<T> flowable) {
        super(flowable);
        this.f37774a = this;
    }

    public FlowableOnBackpressureDrop(Flowable<T> flowable, Consumer<? super T> consumer) {
        super(flowable);
        this.f37774a = consumer;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new BackpressureDropSubscriber(subscriber, this.f37774a));
    }
}
