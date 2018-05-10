package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class LambdaObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
    final Consumer<? super T> f31163a;
    final Consumer<? super Throwable> f31164b;
    final Action f31165c;
    final Consumer<? super Disposable> f31166d;

    public LambdaObserver(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Consumer<? super Disposable> consumer3) {
        this.f31163a = consumer;
        this.f31164b = consumer2;
        this.f31165c = action;
        this.f31166d = consumer3;
    }

    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.m32092b(this, disposable)) {
            try {
                this.f31166d.accept(this);
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                disposable.mo5626a();
                onError(th);
            }
        }
    }

    public final void onNext(T t) {
        if (!mo5627b()) {
            try {
                this.f31163a.accept(t);
            } catch (T t2) {
                Exceptions.m26521b(t2);
                ((Disposable) get()).mo5626a();
                onError(t2);
            }
        }
    }

    public final void onError(Throwable th) {
        if (!mo5627b()) {
            lazySet(DisposableHelper.f31095a);
            try {
                this.f31164b.accept(th);
            } catch (Throwable th2) {
                Exceptions.m26521b(th2);
                RxJavaPlugins.m26757a(new CompositeException(th, th2));
            }
        }
    }

    public final void onComplete() {
        if (!mo5627b()) {
            lazySet(DisposableHelper.f31095a);
            try {
                this.f31165c.run();
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                RxJavaPlugins.m26757a(th);
            }
        }
    }

    public final void mo5626a() {
        DisposableHelper.m32090a((AtomicReference) this);
    }

    public final boolean mo5627b() {
        return get() == DisposableHelper.f31095a;
    }
}
