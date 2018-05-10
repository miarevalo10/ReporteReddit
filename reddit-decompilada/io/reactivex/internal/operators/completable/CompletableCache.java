package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableCache extends Completable implements CompletableObserver {
    static final InnerCompletableCache[] EMPTY = new InnerCompletableCache[0];
    static final InnerCompletableCache[] TERMINATED = new InnerCompletableCache[0];
    Throwable error;
    final AtomicReference<InnerCompletableCache[]> observers = new AtomicReference(EMPTY);
    final AtomicBoolean once = new AtomicBoolean();
    final CompletableSource source;

    final class InnerCompletableCache extends AtomicBoolean implements Disposable {
        final CompletableObserver f31175a;
        final /* synthetic */ CompletableCache f31176b;

        InnerCompletableCache(CompletableCache completableCache, CompletableObserver completableObserver) {
            this.f31176b = completableCache;
            this.f31175a = completableObserver;
        }

        public final boolean mo5627b() {
            return get();
        }

        public final void mo5626a() {
            if (compareAndSet(false, true)) {
                this.f31176b.remove(this);
            }
        }
    }

    public final void onSubscribe(Disposable disposable) {
    }

    public CompletableCache(CompletableSource completableSource) {
        this.source = completableSource;
    }

    protected final void subscribeActual(CompletableObserver completableObserver) {
        InnerCompletableCache innerCompletableCache = new InnerCompletableCache(this, completableObserver);
        completableObserver.onSubscribe(innerCompletableCache);
        if (add(innerCompletableCache)) {
            if (innerCompletableCache.mo5627b() != null) {
                remove(innerCompletableCache);
            }
            if (this.once.compareAndSet(false, true) != null) {
                this.source.subscribe(this);
                return;
            }
        }
        Throwable th = this.error;
        if (th != null) {
            completableObserver.onError(th);
            return;
        }
        completableObserver.onComplete();
    }

    public final void onError(Throwable th) {
        this.error = th;
        for (InnerCompletableCache innerCompletableCache : (InnerCompletableCache[]) this.observers.getAndSet(TERMINATED)) {
            if (!innerCompletableCache.get()) {
                innerCompletableCache.f31175a.onError(th);
            }
        }
    }

    public final void onComplete() {
        for (InnerCompletableCache innerCompletableCache : (InnerCompletableCache[]) this.observers.getAndSet(TERMINATED)) {
            if (!innerCompletableCache.get()) {
                innerCompletableCache.f31175a.onComplete();
            }
        }
    }

    final boolean add(InnerCompletableCache innerCompletableCache) {
        InnerCompletableCache[] innerCompletableCacheArr;
        Object obj;
        do {
            innerCompletableCacheArr = (InnerCompletableCache[]) this.observers.get();
            if (innerCompletableCacheArr == TERMINATED) {
                return false;
            }
            int length = innerCompletableCacheArr.length;
            obj = new InnerCompletableCache[(length + 1)];
            System.arraycopy(innerCompletableCacheArr, 0, obj, 0, length);
            obj[length] = innerCompletableCache;
        } while (!this.observers.compareAndSet(innerCompletableCacheArr, obj));
        return true;
    }

    final void remove(InnerCompletableCache innerCompletableCache) {
        InnerCompletableCache[] innerCompletableCacheArr;
        Object obj;
        do {
            innerCompletableCacheArr = (InnerCompletableCache[]) this.observers.get();
            int length = innerCompletableCacheArr.length;
            if (length != 0) {
                int i = -1;
                for (int i2 = 0; i2 < length; i2++) {
                    if (innerCompletableCacheArr[i2] == innerCompletableCache) {
                        i = i2;
                        break;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        obj = EMPTY;
                    } else {
                        Object obj2 = new InnerCompletableCache[(length - 1)];
                        System.arraycopy(innerCompletableCacheArr, 0, obj2, 0, i);
                        System.arraycopy(innerCompletableCacheArr, i + 1, obj2, i, (length - i) - 1);
                        obj = obj2;
                    }
                } else {
                    return;
                }
            }
            return;
        } while (!this.observers.compareAndSet(innerCompletableCacheArr, obj));
    }
}
