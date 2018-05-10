package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableMergeIterable extends Completable {
    final Iterable<? extends CompletableSource> f34761a;

    static final class MergeCompletableObserver extends AtomicBoolean implements CompletableObserver {
        final CompositeDisposable f31212a;
        final CompletableObserver f31213b;
        final AtomicInteger f31214c;

        MergeCompletableObserver(CompletableObserver completableObserver, CompositeDisposable compositeDisposable, AtomicInteger atomicInteger) {
            this.f31213b = completableObserver;
            this.f31212a = compositeDisposable;
            this.f31214c = atomicInteger;
        }

        public final void onSubscribe(Disposable disposable) {
            this.f31212a.mo5631a(disposable);
        }

        public final void onError(Throwable th) {
            this.f31212a.mo5626a();
            if (compareAndSet(false, true)) {
                this.f31213b.onError(th);
            } else {
                RxJavaPlugins.m26757a(th);
            }
        }

        public final void onComplete() {
            if (this.f31214c.decrementAndGet() == 0 && compareAndSet(false, true)) {
                this.f31213b.onComplete();
            }
        }
    }

    public CompletableMergeIterable(Iterable<? extends CompletableSource> iterable) {
        this.f34761a = iterable;
    }

    public final void subscribeActual(CompletableObserver completableObserver) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        completableObserver.onSubscribe(compositeDisposable);
        try {
            Iterator it = (Iterator) ObjectHelper.m26573a(this.f34761a.iterator(), "The source iterator returned is null");
            AtomicInteger atomicInteger = new AtomicInteger(1);
            MergeCompletableObserver mergeCompletableObserver = new MergeCompletableObserver(completableObserver, compositeDisposable, atomicInteger);
            while (compositeDisposable.mo5627b() == null) {
                try {
                    if (it.hasNext() == null) {
                        mergeCompletableObserver.onComplete();
                        return;
                    } else if (compositeDisposable.mo5627b() == null) {
                        try {
                            CompletableSource completableSource = (CompletableSource) ObjectHelper.m26573a(it.next(), "The iterator returned a null CompletableSource");
                            if (!compositeDisposable.mo5627b()) {
                                atomicInteger.getAndIncrement();
                                completableSource.subscribe(mergeCompletableObserver);
                            } else {
                                return;
                            }
                        } catch (CompletableObserver completableObserver2) {
                            Exceptions.m26521b(completableObserver2);
                            compositeDisposable.mo5626a();
                            mergeCompletableObserver.onError(completableObserver2);
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (CompletableObserver completableObserver22) {
                    Exceptions.m26521b(completableObserver22);
                    compositeDisposable.mo5626a();
                    mergeCompletableObserver.onError(completableObserver22);
                    return;
                }
            }
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            completableObserver22.onError(th);
        }
    }
}
