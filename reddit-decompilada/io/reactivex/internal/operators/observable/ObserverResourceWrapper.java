package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObserverResourceWrapper<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
    final Observer<? super T> f32305a;
    final AtomicReference<Disposable> f32306b = new AtomicReference();

    public ObserverResourceWrapper(Observer<? super T> observer) {
        this.f32305a = observer;
    }

    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.m32092b(this.f32306b, disposable) != null) {
            this.f32305a.onSubscribe(this);
        }
    }

    public final void onNext(T t) {
        this.f32305a.onNext(t);
    }

    public final void onError(Throwable th) {
        mo5626a();
        this.f32305a.onError(th);
    }

    public final void onComplete() {
        mo5626a();
        this.f32305a.onComplete();
    }

    public final void mo5626a() {
        DisposableHelper.m32090a(this.f32306b);
        DisposableHelper.m32090a((AtomicReference) this);
    }

    public final boolean mo5627b() {
        return this.f32306b.get() == DisposableHelper.f31095a;
    }
}
