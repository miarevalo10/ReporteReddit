package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class ForEachWhileObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
    final Predicate<? super T> f31146a;
    final Consumer<? super Throwable> f31147b;
    final Action f31148c;
    boolean f31149d;

    public ForEachWhileObserver(Predicate<? super T> predicate, Consumer<? super Throwable> consumer, Action action) {
        this.f31146a = predicate;
        this.f31147b = consumer;
        this.f31148c = action;
    }

    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.m32092b(this, disposable);
    }

    public final void onNext(T t) {
        if (!this.f31149d) {
            try {
                if (this.f31146a.test(t) == null) {
                    DisposableHelper.m32090a((AtomicReference) this);
                    onComplete();
                }
            } catch (T t2) {
                Exceptions.m26521b(t2);
                DisposableHelper.m32090a((AtomicReference) this);
                onError(t2);
            }
        }
    }

    public final void onError(Throwable th) {
        if (this.f31149d) {
            RxJavaPlugins.m26757a(th);
            return;
        }
        this.f31149d = true;
        try {
            this.f31147b.accept(th);
        } catch (Throwable th2) {
            Exceptions.m26521b(th2);
            RxJavaPlugins.m26757a(new CompositeException(th, th2));
        }
    }

    public final void onComplete() {
        if (!this.f31149d) {
            this.f31149d = true;
            try {
                this.f31148c.run();
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
        return DisposableHelper.m32088a((Disposable) get());
    }
}
