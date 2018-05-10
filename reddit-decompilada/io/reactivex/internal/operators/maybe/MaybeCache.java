package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeCache<T> extends Maybe<T> implements MaybeObserver<T> {
    static final CacheDisposable[] EMPTY = new CacheDisposable[0];
    static final CacheDisposable[] TERMINATED = new CacheDisposable[0];
    Throwable error;
    final AtomicReference<CacheDisposable<T>[]> observers = new AtomicReference(EMPTY);
    final AtomicReference<MaybeSource<T>> source;
    T value;

    static final class CacheDisposable<T> extends AtomicReference<MaybeCache<T>> implements Disposable {
        final MaybeObserver<? super T> f31382a;

        CacheDisposable(MaybeObserver<? super T> maybeObserver, MaybeCache<T> maybeCache) {
            super(maybeCache);
            this.f31382a = maybeObserver;
        }

        public final void mo5626a() {
            MaybeCache maybeCache = (MaybeCache) getAndSet(null);
            if (maybeCache != null) {
                maybeCache.remove(this);
            }
        }

        public final boolean mo5627b() {
            return get() == null;
        }
    }

    public final void onSubscribe(Disposable disposable) {
    }

    public MaybeCache(MaybeSource<T> maybeSource) {
        this.source = new AtomicReference(maybeSource);
    }

    protected final void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        CacheDisposable cacheDisposable = new CacheDisposable(maybeObserver, this);
        maybeObserver.onSubscribe(cacheDisposable);
        if (!add(cacheDisposable)) {
            if (!cacheDisposable.mo5627b()) {
                Throwable th = this.error;
                if (th != null) {
                    maybeObserver.onError(th);
                    return;
                }
                Object obj = this.value;
                if (obj != null) {
                    maybeObserver.onSuccess(obj);
                    return;
                }
                maybeObserver.onComplete();
            }
        } else if (cacheDisposable.mo5627b() != null) {
            remove(cacheDisposable);
        } else {
            MaybeSource maybeSource = (MaybeSource) this.source.getAndSet(null);
            if (maybeSource != null) {
                maybeSource.subscribe(this);
            }
        }
    }

    public final void onSuccess(T t) {
        this.value = t;
        for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.observers.getAndSet(TERMINATED)) {
            if (!cacheDisposable.mo5627b()) {
                cacheDisposable.f31382a.onSuccess(t);
            }
        }
    }

    public final void onError(Throwable th) {
        this.error = th;
        for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.observers.getAndSet(TERMINATED)) {
            if (!cacheDisposable.mo5627b()) {
                cacheDisposable.f31382a.onError(th);
            }
        }
    }

    public final void onComplete() {
        for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.observers.getAndSet(TERMINATED)) {
            if (!cacheDisposable.mo5627b()) {
                cacheDisposable.f31382a.onComplete();
            }
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
}
