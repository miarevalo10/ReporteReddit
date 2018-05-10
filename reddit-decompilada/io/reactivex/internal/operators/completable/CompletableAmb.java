package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;

public final class CompletableAmb extends Completable {
    private final CompletableSource[] f34703a;
    private final Iterable<? extends CompletableSource> f34704b;

    static final class Amb implements CompletableObserver {
        private final AtomicBoolean f31172a;
        private final CompositeDisposable f31173b;
        private final CompletableObserver f31174c;

        Amb(AtomicBoolean atomicBoolean, CompositeDisposable compositeDisposable, CompletableObserver completableObserver) {
            this.f31172a = atomicBoolean;
            this.f31173b = compositeDisposable;
            this.f31174c = completableObserver;
        }

        public final void onComplete() {
            if (this.f31172a.compareAndSet(false, true)) {
                this.f31173b.mo5626a();
                this.f31174c.onComplete();
            }
        }

        public final void onError(Throwable th) {
            if (this.f31172a.compareAndSet(false, true)) {
                this.f31173b.mo5626a();
                this.f31174c.onError(th);
                return;
            }
            RxJavaPlugins.m26757a(th);
        }

        public final void onSubscribe(Disposable disposable) {
            this.f31173b.mo5631a(disposable);
        }
    }

    public CompletableAmb(CompletableSource[] completableSourceArr, Iterable<? extends CompletableSource> iterable) {
        this.f34703a = completableSourceArr;
        this.f34704b = iterable;
    }

    public final void subscribeActual(CompletableObserver completableObserver) {
        int i;
        Throwable th;
        Object obj = this.f34703a;
        if (obj == null) {
            obj = new CompletableSource[8];
            try {
                i = 0;
                for (CompletableSource completableSource : this.f34704b) {
                    if (completableSource == null) {
                        EmptyDisposable.m38049a(new NullPointerException("One of the sources is null"), completableObserver);
                        return;
                    }
                    if (i == obj.length) {
                        Object obj2 = new CompletableSource[((i >> 2) + i)];
                        System.arraycopy(obj, 0, obj2, 0, i);
                        obj = obj2;
                    }
                    int i2 = i + 1;
                    obj[i] = completableSource;
                    i = i2;
                }
            } catch (Throwable th2) {
                Exceptions.m26521b(th2);
                EmptyDisposable.m38049a(th2, completableObserver);
                return;
            }
        }
        i = obj.length;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        completableObserver.onSubscribe(compositeDisposable);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        CompletableObserver amb = new Amb(atomicBoolean, compositeDisposable, completableObserver);
        int i3 = 0;
        while (i3 < i) {
            CompletableSource completableSource2 = obj[i3];
            if (!compositeDisposable.mo5627b()) {
                if (completableSource2 == null) {
                    th2 = new NullPointerException("One of the sources is null");
                    if (atomicBoolean.compareAndSet(false, true)) {
                        compositeDisposable.mo5626a();
                        completableObserver.onError(th2);
                        return;
                    }
                    RxJavaPlugins.m26757a(th2);
                    return;
                }
                completableSource2.subscribe(amb);
                i3++;
            } else {
                return;
            }
        }
        if (i == 0) {
            completableObserver.onComplete();
        }
    }
}
