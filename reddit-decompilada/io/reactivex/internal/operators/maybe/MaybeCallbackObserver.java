package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeCallbackObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
    final Consumer<? super T> f31383a;
    final Consumer<? super Throwable> f31384b;
    final Action f31385c;

    public MaybeCallbackObserver(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        this.f31383a = consumer;
        this.f31384b = consumer2;
        this.f31385c = action;
    }

    public final void mo5626a() {
        DisposableHelper.m32090a((AtomicReference) this);
    }

    public final boolean mo5627b() {
        return DisposableHelper.m32088a((Disposable) get());
    }

    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.m32092b(this, disposable);
    }

    public final void onSuccess(T t) {
        lazySet(DisposableHelper.f31095a);
        try {
            this.f31383a.accept(t);
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            RxJavaPlugins.m26757a(th);
        }
    }

    public final void onError(Throwable th) {
        lazySet(DisposableHelper.f31095a);
        try {
            this.f31384b.accept(th);
        } catch (Throwable th2) {
            Exceptions.m26521b(th2);
            RxJavaPlugins.m26757a(new CompositeException(th, th2));
        }
    }

    public final void onComplete() {
        lazySet(DisposableHelper.f31095a);
        try {
            this.f31385c.run();
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            RxJavaPlugins.m26757a(th);
        }
    }
}
