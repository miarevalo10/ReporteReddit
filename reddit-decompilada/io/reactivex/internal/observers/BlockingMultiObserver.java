package io.reactivex.internal.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class BlockingMultiObserver<T> extends CountDownLatch implements CompletableObserver, MaybeObserver<T>, SingleObserver<T> {
    T f31132a;
    Throwable f31133b;
    Disposable f31134c;
    volatile boolean f31135d;

    public BlockingMultiObserver() {
        super(1);
    }

    private void m32115c() {
        this.f31135d = true;
        Disposable disposable = this.f31134c;
        if (disposable != null) {
            disposable.mo5626a();
        }
    }

    public final void onSubscribe(Disposable disposable) {
        this.f31134c = disposable;
        if (this.f31135d) {
            disposable.mo5626a();
        }
    }

    public final void onSuccess(T t) {
        this.f31132a = t;
        countDown();
    }

    public final void onError(Throwable th) {
        this.f31133b = th;
        countDown();
    }

    public final void onComplete() {
        countDown();
    }

    public final T m32116a() {
        if (getCount() != 0) {
            try {
                BlockingHelper.m26675a();
                await();
            } catch (Throwable e) {
                m32115c();
                throw ExceptionHelper.m26682a(e);
            }
        }
        Throwable e2 = this.f31133b;
        if (e2 == null) {
            return this.f31132a;
        }
        throw ExceptionHelper.m26682a(e2);
    }

    public final T m32117a(T t) {
        if (getCount() != 0) {
            try {
                BlockingHelper.m26675a();
                await();
            } catch (Throwable e) {
                m32115c();
                throw ExceptionHelper.m26682a(e);
            }
        }
        Throwable th = this.f31133b;
        if (th != null) {
            throw ExceptionHelper.m26682a(th);
        }
        T t2 = this.f31132a;
        return t2 != null ? t2 : t;
    }

    public final Throwable m32119b() {
        if (getCount() != 0) {
            try {
                BlockingHelper.m26675a();
                await();
            } catch (Throwable e) {
                m32115c();
                return e;
            }
        }
        return this.f31133b;
    }

    public final Throwable m32118a(long j, TimeUnit timeUnit) {
        if (getCount() != 0) {
            try {
                BlockingHelper.m26675a();
                if (await(j, timeUnit) == null) {
                    m32115c();
                    throw ExceptionHelper.m26682a(new TimeoutException());
                }
            } catch (Throwable e) {
                m32115c();
                throw ExceptionHelper.m26682a(e);
            }
        }
        return this.f31133b;
    }

    public final boolean m32120b(long j, TimeUnit timeUnit) {
        if (getCount() != 0) {
            try {
                BlockingHelper.m26675a();
                if (await(j, timeUnit) == null) {
                    m32115c();
                    return 0;
                }
            } catch (Throwable e) {
                m32115c();
                throw ExceptionHelper.m26682a(e);
            }
        }
        Throwable e2 = this.f31133b;
        if (e2 == null) {
            return 1;
        }
        throw ExceptionHelper.m26682a(e2);
    }
}
