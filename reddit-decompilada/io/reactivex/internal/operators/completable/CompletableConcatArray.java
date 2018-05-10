package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableConcatArray extends Completable {
    final CompletableSource[] f34718a;

    static final class ConcatInnerObserver extends AtomicInteger implements CompletableObserver {
        final CompletableObserver f31178a;
        final CompletableSource[] f31179b;
        int f31180c;
        final SequentialDisposable f31181d = new SequentialDisposable();

        ConcatInnerObserver(CompletableObserver completableObserver, CompletableSource[] completableSourceArr) {
            this.f31178a = completableObserver;
            this.f31179b = completableSourceArr;
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32094c(this.f31181d, disposable);
        }

        public final void onError(Throwable th) {
            this.f31178a.onError(th);
        }

        public final void onComplete() {
            m32143a();
        }

        final void m32143a() {
            if (!this.f31181d.mo5627b() && getAndIncrement() == 0) {
                CompletableSource[] completableSourceArr = this.f31179b;
                while (!this.f31181d.mo5627b()) {
                    int i = this.f31180c;
                    this.f31180c = i + 1;
                    if (i == completableSourceArr.length) {
                        this.f31178a.onComplete();
                        return;
                    }
                    completableSourceArr[i].subscribe(this);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }
    }

    public CompletableConcatArray(CompletableSource[] completableSourceArr) {
        this.f34718a = completableSourceArr;
    }

    public final void subscribeActual(CompletableObserver completableObserver) {
        ConcatInnerObserver concatInnerObserver = new ConcatInnerObserver(completableObserver, this.f34718a);
        completableObserver.onSubscribe(concatInnerObserver.f31181d);
        concatInnerObserver.m32143a();
    }
}
