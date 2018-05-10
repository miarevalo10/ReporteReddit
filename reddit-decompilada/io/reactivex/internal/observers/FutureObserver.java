package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

public final class FutureObserver<T> extends CountDownLatch implements Observer<T>, Disposable, Future<T> {
    T f31152a;
    Throwable f31153b;
    final AtomicReference<Disposable> f31154c = new AtomicReference();

    public final void mo5626a() {
    }

    public FutureObserver() {
        super(1);
    }

    public final boolean cancel(boolean z) {
        DisposableHelper disposableHelper;
        do {
            disposableHelper = (Disposable) this.f31154c.get();
            if (disposableHelper != this) {
                if (disposableHelper == DisposableHelper.f31095a) {
                }
            }
            return false;
        } while (!this.f31154c.compareAndSet(disposableHelper, DisposableHelper.f31095a));
        if (disposableHelper != null) {
            disposableHelper.mo5626a();
        }
        countDown();
        return true;
    }

    public final boolean isCancelled() {
        return DisposableHelper.m32088a((Disposable) this.f31154c.get());
    }

    public final boolean isDone() {
        return getCount() == 0;
    }

    public final T get() throws InterruptedException, ExecutionException {
        if (getCount() != 0) {
            BlockingHelper.m26675a();
            await();
        }
        if (isCancelled()) {
            throw new CancellationException();
        }
        Throwable th = this.f31153b;
        if (th == null) {
            return this.f31152a;
        }
        throw new ExecutionException(th);
    }

    public final T get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        if (getCount() != 0) {
            BlockingHelper.m26675a();
            if (await(j, timeUnit) == null) {
                throw new TimeoutException();
            }
        }
        if (isCancelled() != null) {
            throw new CancellationException();
        }
        j = this.f31153b;
        if (j == null) {
            return this.f31152a;
        }
        throw new ExecutionException(j);
    }

    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.m32092b(this.f31154c, disposable);
    }

    public final void onNext(T t) {
        if (this.f31152a != null) {
            ((Disposable) this.f31154c.get()).mo5626a();
            onError(new IndexOutOfBoundsException("More than one element received"));
            return;
        }
        this.f31152a = t;
    }

    public final void onError(Throwable th) {
        if (this.f31153b == null) {
            this.f31153b = th;
            DisposableHelper disposableHelper;
            do {
                disposableHelper = (Disposable) this.f31154c.get();
                if (disposableHelper != this) {
                    if (disposableHelper == DisposableHelper.f31095a) {
                    }
                }
                RxJavaPlugins.m26757a(th);
                return;
            } while (!this.f31154c.compareAndSet(disposableHelper, this));
            countDown();
            return;
        }
        RxJavaPlugins.m26757a(th);
    }

    public final void onComplete() {
        if (this.f31152a == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        DisposableHelper disposableHelper;
        do {
            disposableHelper = (Disposable) this.f31154c.get();
            if (disposableHelper != this) {
                if (disposableHelper == DisposableHelper.f31095a) {
                }
            }
            return;
        } while (!this.f31154c.compareAndSet(disposableHelper, this));
        countDown();
    }

    public final boolean mo5627b() {
        return isDone();
    }
}
