package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;

public final class MaybeToObservable<T> extends Observable<T> {
    final MaybeSource<T> f35610a;

    static final class MaybeToFlowableSubscriber<T> extends DeferredScalarDisposable<T> implements MaybeObserver<T> {
        Disposable f40270c;

        MaybeToFlowableSubscriber(Observer<? super T> observer) {
            super(observer);
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f40270c, disposable)) {
                this.f40270c = disposable;
                this.a.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            m39624a((Object) t);
        }

        public final void onError(Throwable th) {
            m39625a(th);
        }

        public final void onComplete() {
            m39627c();
        }

        public final void mo5626a() {
            super.mo5626a();
            this.f40270c.mo5626a();
        }
    }

    public MaybeToObservable(MaybeSource<T> maybeSource) {
        this.f35610a = maybeSource;
    }

    protected final void subscribeActual(Observer<? super T> observer) {
        this.f35610a.subscribe(new MaybeToFlowableSubscriber(observer));
    }
}
