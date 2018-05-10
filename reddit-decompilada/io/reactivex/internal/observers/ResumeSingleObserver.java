package io.reactivex.internal.observers;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ResumeSingleObserver<T> implements SingleObserver<T> {
    final AtomicReference<Disposable> f31168a;
    final SingleObserver<? super T> f31169b;

    public ResumeSingleObserver(AtomicReference<Disposable> atomicReference, SingleObserver<? super T> singleObserver) {
        this.f31168a = atomicReference;
        this.f31169b = singleObserver;
    }

    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.m32094c(this.f31168a, disposable);
    }

    public final void onSuccess(T t) {
        this.f31169b.onSuccess(t);
    }

    public final void onError(Throwable th) {
        this.f31169b.onError(th);
    }
}
