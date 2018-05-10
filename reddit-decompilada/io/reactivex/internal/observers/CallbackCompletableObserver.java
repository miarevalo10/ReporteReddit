package io.reactivex.internal.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class CallbackCompletableObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable, Consumer<Throwable> {
    final Consumer<? super Throwable> f31138a;
    final Action f31139b;

    public final /* synthetic */ void accept(Object obj) throws Exception {
        RxJavaPlugins.m26757a(new OnErrorNotImplementedException((Throwable) obj));
    }

    public CallbackCompletableObserver(Action action) {
        this.f31138a = this;
        this.f31139b = action;
    }

    public CallbackCompletableObserver(Consumer<? super Throwable> consumer, Action action) {
        this.f31138a = consumer;
        this.f31139b = action;
    }

    public final void onComplete() {
        try {
            this.f31139b.run();
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            RxJavaPlugins.m26757a(th);
        }
        lazySet(DisposableHelper.f31095a);
    }

    public final void onError(Throwable th) {
        try {
            this.f31138a.accept(th);
        } catch (Throwable th2) {
            Exceptions.m26521b(th2);
            RxJavaPlugins.m26757a(th2);
        }
        lazySet(DisposableHelper.f31095a);
    }

    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.m32092b(this, disposable);
    }

    public final void mo5626a() {
        DisposableHelper.m32090a((AtomicReference) this);
    }

    public final boolean mo5627b() {
        return get() == DisposableHelper.f31095a;
    }
}
