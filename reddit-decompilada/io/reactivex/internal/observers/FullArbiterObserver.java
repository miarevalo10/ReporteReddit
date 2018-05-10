package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.ObserverFullArbiter;

public final class FullArbiterObserver<T> implements Observer<T> {
    final ObserverFullArbiter<T> f31150a;
    Disposable f31151b;

    public FullArbiterObserver(ObserverFullArbiter<T> observerFullArbiter) {
        this.f31150a = observerFullArbiter;
    }

    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.m32089a(this.f31151b, disposable)) {
            this.f31151b = disposable;
            this.f31150a.m38060a(disposable);
        }
    }

    public final void onNext(T t) {
        this.f31150a.m38061a((Object) t, this.f31151b);
    }

    public final void onError(Throwable th) {
        this.f31150a.m38059a(th, this.f31151b);
    }

    public final void onComplete() {
        this.f31150a.m38062b(this.f31151b);
    }
}
