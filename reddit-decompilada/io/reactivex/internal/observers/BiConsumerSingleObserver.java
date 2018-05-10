package io.reactivex.internal.observers;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class BiConsumerSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
    final BiConsumer<? super T, ? super Throwable> f31127a;

    public BiConsumerSingleObserver(BiConsumer<? super T, ? super Throwable> biConsumer) {
        this.f31127a = biConsumer;
    }

    public final void onError(Throwable th) {
        try {
            lazySet(DisposableHelper.f31095a);
            this.f31127a.mo4825a(null, th);
        } catch (Throwable th2) {
            Exceptions.m26521b(th2);
            RxJavaPlugins.m26757a(new CompositeException(th, th2));
        }
    }

    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.m32092b(this, disposable);
    }

    public final void onSuccess(T t) {
        try {
            lazySet(DisposableHelper.f31095a);
            this.f31127a.mo4825a(t, null);
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            RxJavaPlugins.m26757a(th);
        }
    }

    public final void mo5626a() {
        DisposableHelper.m32090a((AtomicReference) this);
    }

    public final boolean mo5627b() {
        return get() == DisposableHelper.f31095a;
    }
}
