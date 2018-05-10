package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.plugins.RxJavaPlugins;

public abstract class BasicFuseableObserver<T, R> implements Observer<T>, QueueDisposable<R> {
    protected final Observer<? super R> f37624a;
    protected Disposable f37625b;
    protected QueueDisposable<T> f37626c;
    protected boolean f37627d;
    protected int f37628e;

    public BasicFuseableObserver(Observer<? super R> observer) {
        this.f37624a = observer;
    }

    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.m32089a(this.f37625b, disposable)) {
            this.f37625b = disposable;
            if (disposable instanceof QueueDisposable) {
                this.f37626c = (QueueDisposable) disposable;
            }
            this.f37624a.onSubscribe(this);
        }
    }

    public void onError(Throwable th) {
        if (this.f37627d) {
            RxJavaPlugins.m26757a(th);
            return;
        }
        this.f37627d = true;
        this.f37624a.onError(th);
    }

    protected final void m38065a(Throwable th) {
        Exceptions.m26521b(th);
        this.f37625b.mo5626a();
        onError(th);
    }

    public void onComplete() {
        if (!this.f37627d) {
            this.f37627d = true;
            this.f37624a.onComplete();
        }
    }

    protected final int m38066b(int i) {
        QueueDisposable queueDisposable = this.f37626c;
        if (queueDisposable == null || (i & 4) != 0) {
            return 0;
        }
        i = queueDisposable.mo7033a(i);
        if (i != 0) {
            this.f37628e = i;
        }
        return i;
    }

    public final void mo5626a() {
        this.f37625b.mo5626a();
    }

    public final boolean mo5627b() {
        return this.f37625b.mo5627b();
    }

    public boolean isEmpty() {
        return this.f37626c.isEmpty();
    }

    public void clear() {
        this.f37626c.clear();
    }

    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
