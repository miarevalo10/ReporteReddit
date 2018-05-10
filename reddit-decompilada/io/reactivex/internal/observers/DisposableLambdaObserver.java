package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

public final class DisposableLambdaObserver<T> implements Observer<T>, Disposable {
    final Observer<? super T> f31142a;
    final Consumer<? super Disposable> f31143b;
    final Action f31144c;
    Disposable f31145d;

    public DisposableLambdaObserver(Observer<? super T> observer, Consumer<? super Disposable> consumer, Action action) {
        this.f31142a = observer;
        this.f31143b = consumer;
        this.f31144c = action;
    }

    public final void onSubscribe(Disposable disposable) {
        try {
            this.f31143b.accept(disposable);
            if (DisposableHelper.m32089a(this.f31145d, disposable)) {
                this.f31145d = disposable;
                this.f31142a.onSubscribe(this);
            }
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            disposable.mo5626a();
            this.f31145d = DisposableHelper.f31095a;
            EmptyDisposable.m38051a(th, this.f31142a);
        }
    }

    public final void onNext(T t) {
        this.f31142a.onNext(t);
    }

    public final void onError(Throwable th) {
        if (this.f31145d != DisposableHelper.f31095a) {
            this.f31142a.onError(th);
        } else {
            RxJavaPlugins.m26757a(th);
        }
    }

    public final void onComplete() {
        if (this.f31145d != DisposableHelper.f31095a) {
            this.f31142a.onComplete();
        }
    }

    public final void mo5626a() {
        try {
            this.f31144c.run();
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            RxJavaPlugins.m26757a(th);
        }
        this.f31145d.mo5626a();
    }

    public final boolean mo5627b() {
        return this.f31145d.mo5627b();
    }
}
