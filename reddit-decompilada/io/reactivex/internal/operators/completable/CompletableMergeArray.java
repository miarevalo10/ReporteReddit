package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableMergeArray extends Completable {
    final CompletableSource[] f34758a;

    static final class InnerCompletableObserver extends AtomicInteger implements CompletableObserver {
        final CompletableObserver f31205a;
        final AtomicBoolean f31206b;
        final CompositeDisposable f31207c;

        InnerCompletableObserver(CompletableObserver completableObserver, AtomicBoolean atomicBoolean, CompositeDisposable compositeDisposable, int i) {
            this.f31205a = completableObserver;
            this.f31206b = atomicBoolean;
            this.f31207c = compositeDisposable;
            lazySet(i);
        }

        public final void onSubscribe(Disposable disposable) {
            this.f31207c.mo5631a(disposable);
        }

        public final void onError(Throwable th) {
            this.f31207c.mo5626a();
            if (this.f31206b.compareAndSet(false, true)) {
                this.f31205a.onError(th);
            } else {
                RxJavaPlugins.m26757a(th);
            }
        }

        public final void onComplete() {
            if (decrementAndGet() == 0 && this.f31206b.compareAndSet(false, true)) {
                this.f31205a.onComplete();
            }
        }
    }

    public CompletableMergeArray(CompletableSource[] completableSourceArr) {
        this.f34758a = completableSourceArr;
    }

    public final void subscribeActual(CompletableObserver completableObserver) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        int i = 0;
        InnerCompletableObserver innerCompletableObserver = new InnerCompletableObserver(completableObserver, new AtomicBoolean(), compositeDisposable, this.f34758a.length + 1);
        completableObserver.onSubscribe(compositeDisposable);
        completableObserver = this.f34758a;
        int length = completableObserver.length;
        while (i < length) {
            CompletableSource completableSource = completableObserver[i];
            if (!compositeDisposable.mo5627b()) {
                if (completableSource == null) {
                    compositeDisposable.mo5626a();
                    innerCompletableObserver.onError(new NullPointerException("A completable source is null"));
                    return;
                }
                completableSource.subscribe(innerCompletableObserver);
                i++;
            } else {
                return;
            }
        }
        innerCompletableObserver.onComplete();
    }
}
