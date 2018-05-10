package io.reactivex.internal.observers;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

public final class FutureSingleObserver<T> extends CountDownLatch implements SingleObserver<T>, Disposable, Future<T> {
    T f31155a;
    Throwable f31156b;
    final AtomicReference<Disposable> f31157c = new AtomicReference();

    public final void mo5626a() {
    }

    public FutureSingleObserver() {
        super(1);
    }

    public final boolean cancel(boolean z) {
        DisposableHelper disposableHelper;
        do {
            disposableHelper = (Disposable) this.f31157c.get();
            if (disposableHelper != this) {
                if (disposableHelper == DisposableHelper.f31095a) {
                }
            }
            return false;
        } while (!this.f31157c.compareAndSet(disposableHelper, DisposableHelper.f31095a));
        if (disposableHelper != null) {
            disposableHelper.mo5626a();
        }
        countDown();
        return true;
    }

    public final boolean isCancelled() {
        return DisposableHelper.m32088a((Disposable) this.f31157c.get());
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
        Throwable th = this.f31156b;
        if (th == null) {
            return this.f31155a;
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
        j = this.f31156b;
        if (j == null) {
            return this.f31155a;
        }
        throw new ExecutionException(j);
    }

    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.m32092b(this.f31157c, disposable);
    }

    public final void onSuccess(T t) {
        Disposable disposable = (Disposable) this.f31157c.get();
        if (disposable != DisposableHelper.f31095a) {
            this.f31155a = t;
            this.f31157c.compareAndSet(disposable, this);
            countDown();
        }
    }

    public final void onError(Throwable th) {
        Disposable disposable;
        do {
            disposable = (Disposable) this.f31157c.get();
            if (disposable == DisposableHelper.f31095a) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f31156b = th;
        } while (!this.f31157c.compareAndSet(disposable, this));
        countDown();
    }

    public final boolean mo5627b() {
        return isDone();
    }
}
