package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleCache<T> extends Single<T> implements SingleObserver<T> {
    static final CacheDisposable[] EMPTY = new CacheDisposable[0];
    static final CacheDisposable[] TERMINATED = new CacheDisposable[0];
    Throwable error;
    final AtomicReference<CacheDisposable<T>[]> observers = new AtomicReference(EMPTY);
    final SingleSource<? extends T> source;
    T value;
    final AtomicInteger wip = new AtomicInteger();

    static final class CacheDisposable<T> extends AtomicBoolean implements Disposable {
        final SingleObserver<? super T> f32312a;
        final SingleCache<T> f32313b;

        CacheDisposable(SingleObserver<? super T> singleObserver, SingleCache<T> singleCache) {
            this.f32312a = singleObserver;
            this.f32313b = singleCache;
        }

        public final boolean mo5627b() {
            return get();
        }

        public final void mo5626a() {
            if (compareAndSet(false, true)) {
                this.f32313b.remove(this);
            }
        }
    }

    public final void onSubscribe(Disposable disposable) {
    }

    public SingleCache(SingleSource<? extends T> singleSource) {
        this.source = singleSource;
    }

    protected final void subscribeActual(SingleObserver<? super T> singleObserver) {
        CacheDisposable cacheDisposable = new CacheDisposable(singleObserver, this);
        singleObserver.onSubscribe(cacheDisposable);
        if (add(cacheDisposable)) {
            if (cacheDisposable.mo5627b() != null) {
                remove(cacheDisposable);
            }
            if (this.wip.getAndIncrement() == null) {
                this.source.subscribe(this);
            }
            return;
        }
        Throwable th = this.error;
        if (th != null) {
            singleObserver.onError(th);
        } else {
            singleObserver.onSuccess(this.value);
        }
    }

    final boolean add(CacheDisposable<T> cacheDisposable) {
        CacheDisposable[] cacheDisposableArr;
        Object obj;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.observers.get();
            if (cacheDisposableArr == TERMINATED) {
                return false;
            }
            int length = cacheDisposableArr.length;
            obj = new CacheDisposable[(length + 1)];
            System.arraycopy(cacheDisposableArr, 0, obj, 0, length);
            obj[length] = cacheDisposable;
        } while (!this.observers.compareAndSet(cacheDisposableArr, obj));
        return true;
    }

    final void remove(CacheDisposable<T> cacheDisposable) {
        CacheDisposable[] cacheDisposableArr;
        Object obj;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.observers.get();
            int length = cacheDisposableArr.length;
            if (length != 0) {
                int i = -1;
                for (int i2 = 0; i2 < length; i2++) {
                    if (cacheDisposableArr[i2] == cacheDisposable) {
                        i = i2;
                        break;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        obj = EMPTY;
                    } else {
                        Object obj2 = new CacheDisposable[(length - 1)];
                        System.arraycopy(cacheDisposableArr, 0, obj2, 0, i);
                        System.arraycopy(cacheDisposableArr, i + 1, obj2, i, (length - i) - 1);
                        obj = obj2;
                    }
                } else {
                    return;
                }
            }
            return;
        } while (!this.observers.compareAndSet(cacheDisposableArr, obj));
    }

    public final void onSuccess(T t) {
        this.value = t;
        for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.observers.getAndSet(TERMINATED)) {
            if (!cacheDisposable.mo5627b()) {
                cacheDisposable.f32312a.onSuccess(t);
            }
        }
    }

    public final void onError(Throwable th) {
        this.error = th;
        for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.observers.getAndSet(TERMINATED)) {
            if (!cacheDisposable.mo5627b()) {
                cacheDisposable.f32312a.onError(th);
            }
        }
    }
}
