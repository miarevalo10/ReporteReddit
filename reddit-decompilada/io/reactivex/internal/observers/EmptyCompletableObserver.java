package io.reactivex.internal.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class EmptyCompletableObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
    public final void mo5626a() {
        DisposableHelper.m32090a((AtomicReference) this);
    }

    public final boolean mo5627b() {
        return get() == DisposableHelper.f31095a;
    }

    public final void onComplete() {
        lazySet(DisposableHelper.f31095a);
    }

    public final void onError(Throwable th) {
        lazySet(DisposableHelper.f31095a);
        RxJavaPlugins.m26757a(new OnErrorNotImplementedException(th));
    }

    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.m32092b(this, disposable);
    }
}
