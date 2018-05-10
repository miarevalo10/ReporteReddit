package io.reactivex.internal.operators.maybe;

import io.reactivex.Flowable;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import org.reactivestreams.Subscriber;

public final class MaybeToFlowable<T> extends Flowable<T> {
    final MaybeSource<T> f35609a;

    static final class MaybeToFlowableSubscriber<T> extends DeferredScalarSubscription<T> implements MaybeObserver<T> {
        Disposable f40269a;

        MaybeToFlowableSubscriber(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f40269a, disposable)) {
                this.f40269a = disposable;
                this.h.mo5623a(this);
            }
        }

        public final void onSuccess(T t) {
            m39789a((Object) t);
        }

        public final void onError(Throwable th) {
            this.h.onError(th);
        }

        public final void onComplete() {
            this.h.onComplete();
        }

        public final void cancel() {
            super.cancel();
            this.f40269a.mo5626a();
        }
    }

    public MaybeToFlowable(MaybeSource<T> maybeSource) {
        this.f35609a = maybeSource;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        this.f35609a.subscribe(new MaybeToFlowableSubscriber(subscriber));
    }
}
