package io.reactivex.internal.operators.single;

import io.reactivex.Flowable;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import org.reactivestreams.Subscriber;

public final class SingleToFlowable<T> extends Flowable<T> {
    final SingleSource<? extends T> f35853a;

    static final class SingleToFlowableObserver<T> extends DeferredScalarSubscription<T> implements SingleObserver<T> {
        Disposable f40271a;

        SingleToFlowableObserver(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f40271a, disposable)) {
                this.f40271a = disposable;
                this.h.mo5623a(this);
            }
        }

        public final void onSuccess(T t) {
            m39789a((Object) t);
        }

        public final void onError(Throwable th) {
            this.h.onError(th);
        }

        public final void cancel() {
            super.cancel();
            this.f40271a.mo5626a();
        }
    }

    public SingleToFlowable(SingleSource<? extends T> singleSource) {
        this.f35853a = singleSource;
    }

    public final void subscribeActual(Subscriber<? super T> subscriber) {
        this.f35853a.subscribe(new SingleToFlowableObserver(subscriber));
    }
}
