package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableMergeDelayErrorArray extends Completable {
    final CompletableSource[] f34759a;

    static final class MergeInnerCompletableObserver implements CompletableObserver {
        final CompletableObserver f31208a;
        final CompositeDisposable f31209b;
        final AtomicThrowable f31210c;
        final AtomicInteger f31211d;

        MergeInnerCompletableObserver(CompletableObserver completableObserver, CompositeDisposable compositeDisposable, AtomicThrowable atomicThrowable, AtomicInteger atomicInteger) {
            this.f31208a = completableObserver;
            this.f31209b = compositeDisposable;
            this.f31210c = atomicThrowable;
            this.f31211d = atomicInteger;
        }

        public final void onSubscribe(Disposable disposable) {
            this.f31209b.mo5631a(disposable);
        }

        public final void onError(Throwable th) {
            if (ExceptionHelper.m26684a(this.f31210c, th)) {
                m32158a();
            } else {
                RxJavaPlugins.m26757a(th);
            }
        }

        public final void onComplete() {
            m32158a();
        }

        private void m32158a() {
            if (this.f31211d.decrementAndGet() == 0) {
                Throwable a = ExceptionHelper.m26683a(this.f31210c);
                if (a == null) {
                    this.f31208a.onComplete();
                    return;
                }
                this.f31208a.onError(a);
            }
        }
    }

    public CompletableMergeDelayErrorArray(CompletableSource[] completableSourceArr) {
        this.f34759a = completableSourceArr;
    }

    public final void subscribeActual(CompletableObserver completableObserver) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        int i = 0;
        AtomicInteger atomicInteger = new AtomicInteger(this.f34759a.length + 1);
        AtomicReference atomicThrowable = new AtomicThrowable();
        completableObserver.onSubscribe(compositeDisposable);
        CompletableSource[] completableSourceArr = this.f34759a;
        int length = completableSourceArr.length;
        while (i < length) {
            CompletableSource completableSource = completableSourceArr[i];
            if (!compositeDisposable.mo5627b()) {
                if (completableSource == null) {
                    ExceptionHelper.m26684a(atomicThrowable, new NullPointerException("A completable source is null"));
                    atomicInteger.decrementAndGet();
                } else {
                    completableSource.subscribe(new MergeInnerCompletableObserver(completableObserver, compositeDisposable, atomicThrowable, atomicInteger));
                }
                i++;
            } else {
                return;
            }
        }
        if (atomicInteger.decrementAndGet() == 0) {
            Throwable a = ExceptionHelper.m26683a(atomicThrowable);
            if (a == null) {
                completableObserver.onComplete();
                return;
            }
            completableObserver.onError(a);
        }
    }
}
