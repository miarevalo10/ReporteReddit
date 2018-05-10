package io.reactivex.internal.observers;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class ConsumerSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
    final Consumer<? super T> f31140a;
    final Consumer<? super Throwable> f31141b;

    public ConsumerSingleObserver(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        this.f31140a = consumer;
        this.f31141b = consumer2;
    }

    public final void onError(Throwable th) {
        lazySet(DisposableHelper.f31095a);
        try {
            this.f31141b.accept(th);
        } catch (Throwable th2) {
            Exceptions.m26521b(th2);
            RxJavaPlugins.m26757a(new CompositeException(th, th2));
        }
    }

    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.m32092b(this, disposable);
    }

    public final void onSuccess(T t) {
        lazySet(DisposableHelper.f31095a);
        try {
            this.f31140a.accept(t);
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
