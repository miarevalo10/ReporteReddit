package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.plugins.RxJavaPlugins;

public class DeferredScalarDisposable<T> extends BasicIntQueueDisposable<T> {
    protected final Observer<? super T> f39381a;
    protected T f39382b;

    public DeferredScalarDisposable(Observer<? super T> observer) {
        this.f39381a = observer;
    }

    public final int mo7033a(int i) {
        if ((i & 2) == 0) {
            return 0;
        }
        lazySet(8);
        return 2;
    }

    public final void m39624a(T t) {
        int i = get();
        if ((i & 54) == 0) {
            if (i == 8) {
                this.f39382b = t;
                lazySet(16);
            } else {
                lazySet(2);
            }
            Observer observer = this.f39381a;
            observer.onNext(t);
            if (get() != 4) {
                observer.onComplete();
            }
        }
    }

    public final void m39625a(Throwable th) {
        if ((get() & 54) != 0) {
            RxJavaPlugins.m26757a(th);
            return;
        }
        lazySet(2);
        this.f39381a.onError(th);
    }

    public final void m39627c() {
        if ((get() & 54) == 0) {
            lazySet(2);
            this.f39381a.onComplete();
        }
    }

    public final T poll() throws Exception {
        if (get() != 16) {
            return null;
        }
        T t = this.f39382b;
        this.f39382b = null;
        lazySet(32);
        return t;
    }

    public final boolean isEmpty() {
        return get() != 16;
    }

    public final void clear() {
        lazySet(32);
        this.f39382b = null;
    }

    public void mo5626a() {
        set(4);
        this.f39382b = null;
    }

    public final boolean mo5627b() {
        return get() == 4;
    }
}
