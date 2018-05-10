package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

public final class FlowableReduceMaybe<T> extends Maybe<T> implements FuseToFlowable<T> {
    final Flowable<T> f35216a;
    final BiFunction<T, T, T> f35217b;

    static final class ReduceSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        final MaybeObserver<? super T> f35211a;
        final BiFunction<T, T, T> f35212b;
        T f35213c;
        Subscription f35214d;
        boolean f35215e;

        ReduceSubscriber(MaybeObserver<? super T> maybeObserver, BiFunction<T, T, T> biFunction) {
            this.f35211a = maybeObserver;
            this.f35212b = biFunction;
        }

        public final void mo5626a() {
            this.f35214d.cancel();
            this.f35215e = true;
        }

        public final boolean mo5627b() {
            return this.f35215e;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f35214d, subscription)) {
                this.f35214d = subscription;
                this.f35211a.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(T t) {
            if (!this.f35215e) {
                Object obj = this.f35213c;
                if (obj == null) {
                    this.f35213c = t;
                    return;
                }
                try {
                    this.f35213c = ObjectHelper.m26573a(this.f35212b.apply(obj, t), "The reducer returned a null value");
                } catch (T t2) {
                    Exceptions.m26521b(t2);
                    this.f35214d.cancel();
                    onError(t2);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f35215e) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f35215e = true;
            this.f35211a.onError(th);
        }

        public final void onComplete() {
            if (!this.f35215e) {
                this.f35215e = true;
                Object obj = this.f35213c;
                if (obj != null) {
                    this.f35211a.onSuccess(obj);
                } else {
                    this.f35211a.onComplete();
                }
            }
        }
    }

    public FlowableReduceMaybe(Flowable<T> flowable, BiFunction<T, T, T> biFunction) {
        this.f35216a = flowable;
        this.f35217b = biFunction;
    }

    public final Flowable<T> mo6616a() {
        return RxJavaPlugins.m26739a(new FlowableReduce(this.f35216a, this.f35217b));
    }

    protected final void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f35216a.subscribe(new ReduceSubscriber(maybeObserver, this.f35217b));
    }
}
