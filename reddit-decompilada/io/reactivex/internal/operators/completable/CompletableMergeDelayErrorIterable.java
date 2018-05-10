package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableMergeDelayErrorIterable extends Completable {
    final Iterable<? extends CompletableSource> f34760a;

    public CompletableMergeDelayErrorIterable(Iterable<? extends CompletableSource> iterable) {
        this.f34760a = iterable;
    }

    public final void subscribeActual(CompletableObserver completableObserver) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        completableObserver.onSubscribe(compositeDisposable);
        Throwable a;
        try {
            Iterator it = (Iterator) ObjectHelper.m26573a(this.f34760a.iterator(), "The source iterator returned is null");
            AtomicInteger atomicInteger = new AtomicInteger(1);
            AtomicReference atomicThrowable = new AtomicThrowable();
            while (!compositeDisposable.mo5627b()) {
                try {
                    if (!it.hasNext()) {
                        if (atomicInteger.decrementAndGet() == 0) {
                            a = ExceptionHelper.m26683a(atomicThrowable);
                            if (a == null) {
                                completableObserver.onComplete();
                                return;
                            }
                            completableObserver.onError(a);
                        }
                        return;
                    } else if (!compositeDisposable.mo5627b()) {
                        try {
                            CompletableSource completableSource = (CompletableSource) ObjectHelper.m26573a(it.next(), "The iterator returned a null CompletableSource");
                            if (!compositeDisposable.mo5627b()) {
                                atomicInteger.getAndIncrement();
                                completableSource.subscribe(new MergeInnerCompletableObserver(completableObserver, compositeDisposable, atomicThrowable, atomicInteger));
                            } else {
                                return;
                            }
                        } catch (Throwable a2) {
                            Exceptions.m26521b(a2);
                            ExceptionHelper.m26684a(atomicThrowable, a2);
                        }
                    } else {
                        return;
                    }
                } catch (Throwable a22) {
                    Exceptions.m26521b(a22);
                    ExceptionHelper.m26684a(atomicThrowable, a22);
                }
            }
        } catch (Throwable a222) {
            Exceptions.m26521b(a222);
            completableObserver.onError(a222);
        }
    }
}
