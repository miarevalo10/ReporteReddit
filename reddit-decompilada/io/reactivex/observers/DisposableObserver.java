package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.EndConsumerHelper;
import java.util.concurrent.atomic.AtomicReference;

public abstract class DisposableObserver<T> implements Observer<T>, Disposable {
    final AtomicReference<Disposable> f32469f = new AtomicReference();

    public final void onSubscribe(Disposable disposable) {
        EndConsumerHelper.m26679a(this.f32469f, disposable, getClass());
    }

    public final boolean mo5627b() {
        return this.f32469f.get() == DisposableHelper.f31095a;
    }

    public final void mo5626a() {
        DisposableHelper.m32090a(this.f32469f);
    }
}
