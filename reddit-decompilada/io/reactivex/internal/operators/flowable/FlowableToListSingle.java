package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ArrayListSupplier;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscription;

public final class FlowableToListSingle<T, U extends Collection<? super T>> extends Single<U> implements FuseToFlowable<U> {
    final Flowable<T> f35480a;
    final Callable<U> f35481b;

    static final class ToListSubscriber<T, U extends Collection<? super T>> implements FlowableSubscriber<T>, Disposable {
        final SingleObserver<? super U> f35477a;
        Subscription f35478b;
        U f35479c;

        ToListSubscriber(SingleObserver<? super U> singleObserver, U u) {
            this.f35477a = singleObserver;
            this.f35479c = u;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f35478b, subscription)) {
                this.f35478b = subscription;
                this.f35477a.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(T t) {
            this.f35479c.add(t);
        }

        public final void onError(Throwable th) {
            this.f35479c = null;
            this.f35478b = SubscriptionHelper.f32454a;
            this.f35477a.onError(th);
        }

        public final void onComplete() {
            this.f35478b = SubscriptionHelper.f32454a;
            this.f35477a.onSuccess(this.f35479c);
        }

        public final void mo5626a() {
            this.f35478b.cancel();
            this.f35478b = SubscriptionHelper.f32454a;
        }

        public final boolean mo5627b() {
            return this.f35478b == SubscriptionHelper.f32454a;
        }
    }

    public FlowableToListSingle(Flowable<T> flowable) {
        this(flowable, ArrayListSupplier.m32783a());
    }

    public FlowableToListSingle(Flowable<T> flowable, Callable<U> callable) {
        this.f35480a = flowable;
        this.f35481b = callable;
    }

    protected final void subscribeActual(SingleObserver<? super U> singleObserver) {
        try {
            this.f35480a.subscribe(new ToListSubscriber(singleObserver, (Collection) ObjectHelper.m26573a(this.f35481b.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            EmptyDisposable.m38052a(th, (SingleObserver) singleObserver);
        }
    }

    public final Flowable<U> mo6616a() {
        return RxJavaPlugins.m26739a(new FlowableToList(this.f35480a, this.f35481b));
    }
}
