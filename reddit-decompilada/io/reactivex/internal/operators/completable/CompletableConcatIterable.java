package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableConcatIterable extends Completable {
    final Iterable<? extends CompletableSource> f34719a;

    static final class ConcatInnerObserver extends AtomicInteger implements CompletableObserver {
        final CompletableObserver f31182a;
        final Iterator<? extends CompletableSource> f31183b;
        final SequentialDisposable f31184c = new SequentialDisposable();

        ConcatInnerObserver(CompletableObserver completableObserver, Iterator<? extends CompletableSource> it) {
            this.f31182a = completableObserver;
            this.f31183b = it;
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32094c(this.f31184c, disposable);
        }

        public final void onError(Throwable th) {
            this.f31182a.onError(th);
        }

        public final void onComplete() {
            m32144a();
        }

        final void m32144a() {
            if (!this.f31184c.mo5627b() && getAndIncrement() == 0) {
                Iterator it = this.f31183b;
                while (!this.f31184c.mo5627b()) {
                    try {
                        if (it.hasNext()) {
                            try {
                                ((CompletableSource) ObjectHelper.m26573a(it.next(), "The CompletableSource returned is null")).subscribe(this);
                                if (decrementAndGet() == 0) {
                                    return;
                                }
                            } catch (Throwable th) {
                                Exceptions.m26521b(th);
                                this.f31182a.onError(th);
                                return;
                            }
                        }
                        this.f31182a.onComplete();
                        return;
                    } catch (Throwable th2) {
                        Exceptions.m26521b(th2);
                        this.f31182a.onError(th2);
                        return;
                    }
                }
            }
        }
    }

    public CompletableConcatIterable(Iterable<? extends CompletableSource> iterable) {
        this.f34719a = iterable;
    }

    public final void subscribeActual(CompletableObserver completableObserver) {
        try {
            ConcatInnerObserver concatInnerObserver = new ConcatInnerObserver(completableObserver, (Iterator) ObjectHelper.m26573a(this.f34719a.iterator(), "The iterator returned is null"));
            completableObserver.onSubscribe(concatInnerObserver.f31184c);
            concatInnerObserver.m32144a();
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            EmptyDisposable.m38049a(th, completableObserver);
        }
    }
}
