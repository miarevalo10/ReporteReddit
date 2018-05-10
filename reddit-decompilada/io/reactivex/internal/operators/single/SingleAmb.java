package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;

public final class SingleAmb<T> extends Single<T> {
    private final SingleSource<? extends T>[] f35764a;
    private final Iterable<? extends SingleSource<? extends T>> f35765b;

    static final class AmbSingleObserver<T> extends AtomicBoolean implements SingleObserver<T> {
        final CompositeDisposable f32310a;
        final SingleObserver<? super T> f32311b;

        AmbSingleObserver(SingleObserver<? super T> singleObserver, CompositeDisposable compositeDisposable) {
            this.f32311b = singleObserver;
            this.f32310a = compositeDisposable;
        }

        public final void onSubscribe(Disposable disposable) {
            this.f32310a.mo5631a(disposable);
        }

        public final void onSuccess(T t) {
            if (compareAndSet(false, true)) {
                this.f32310a.mo5626a();
                this.f32311b.onSuccess(t);
            }
        }

        public final void onError(Throwable th) {
            if (compareAndSet(false, true)) {
                this.f32310a.mo5626a();
                this.f32311b.onError(th);
                return;
            }
            RxJavaPlugins.m26757a(th);
        }
    }

    public SingleAmb(SingleSource<? extends T>[] singleSourceArr, Iterable<? extends SingleSource<? extends T>> iterable) {
        this.f35764a = singleSourceArr;
        this.f35765b = iterable;
    }

    protected final void subscribeActual(SingleObserver<? super T> singleObserver) {
        int i;
        int i2;
        Object obj = this.f35764a;
        if (obj == null) {
            obj = new SingleSource[8];
            try {
                i = 0;
                for (SingleSource singleSource : this.f35765b) {
                    if (singleSource == null) {
                        EmptyDisposable.m38052a(new NullPointerException("One of the sources is null"), (SingleObserver) singleObserver);
                        return;
                    }
                    if (i == obj.length) {
                        Object obj2 = new SingleSource[((i >> 2) + i)];
                        System.arraycopy(obj, 0, obj2, 0, i);
                        obj = obj2;
                    }
                    i2 = i + 1;
                    obj[i] = singleSource;
                    i = i2;
                }
            } catch (Throwable th) {
                Throwable th2;
                Exceptions.m26521b(th2);
                EmptyDisposable.m38052a(th2, (SingleObserver) singleObserver);
                return;
            }
        }
        i = obj.length;
        Object compositeDisposable = new CompositeDisposable();
        Object ambSingleObserver = new AmbSingleObserver(singleObserver, compositeDisposable);
        singleObserver.onSubscribe(compositeDisposable);
        i2 = 0;
        while (i2 < i) {
            SingleSource singleSource2 = obj[i2];
            if (!ambSingleObserver.get()) {
                if (singleSource2 == null) {
                    compositeDisposable.mo5626a();
                    th2 = new NullPointerException("One of the sources is null");
                    if (ambSingleObserver.compareAndSet(false, true)) {
                        singleObserver.onError(th2);
                        return;
                    } else {
                        RxJavaPlugins.m26757a(th2);
                        return;
                    }
                }
                singleSource2.subscribe(ambSingleObserver);
                i2++;
            } else {
                return;
            }
        }
    }
}
