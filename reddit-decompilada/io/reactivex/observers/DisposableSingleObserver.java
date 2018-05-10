package io.reactivex.observers;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.EndConsumerHelper;
import java.util.concurrent.atomic.AtomicReference;

public abstract class DisposableSingleObserver<T> implements SingleObserver<T>, Disposable {
    final AtomicReference<Disposable> f32470d = new AtomicReference();

    public final void onSubscribe(Disposable disposable) {
        EndConsumerHelper.m26679a(this.f32470d, disposable, getClass());
    }

    public final boolean mo5627b() {
        return this.f32470d.get() == DisposableHelper.f31095a;
    }

    public final void mo5626a() {
        DisposableHelper.m32090a(this.f32470d);
    }
}
