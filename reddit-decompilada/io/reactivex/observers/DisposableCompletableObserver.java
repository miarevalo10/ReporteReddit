package io.reactivex.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.EndConsumerHelper;
import java.util.concurrent.atomic.AtomicReference;

public abstract class DisposableCompletableObserver implements CompletableObserver, Disposable {
    final AtomicReference<Disposable> f32468b = new AtomicReference();

    public final void onSubscribe(Disposable disposable) {
        EndConsumerHelper.m26679a(this.f32468b, disposable, getClass());
    }

    public final boolean mo5627b() {
        return this.f32468b.get() == DisposableHelper.f31095a;
    }

    public final void mo5626a() {
        DisposableHelper.m32090a(this.f32468b);
    }
}
