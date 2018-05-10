package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableAmb<T> extends Observable<T> {
    final ObservableSource<? extends T>[] f35629a;
    final Iterable<? extends ObservableSource<? extends T>> f35630b;

    static final class AmbCoordinator<T> implements Disposable {
        final Observer<? super T> f31570a;
        final AmbInnerObserver<T>[] f31571b;
        final AtomicInteger f31572c = new AtomicInteger();

        AmbCoordinator(Observer<? super T> observer, int i) {
            this.f31570a = observer;
            this.f31571b = new AmbInnerObserver[i];
        }

        public final void m32355a(ObservableSource<? extends T>[] observableSourceArr) {
            AmbInnerObserver[] ambInnerObserverArr = this.f31571b;
            int i = 0;
            int length = ambInnerObserverArr.length;
            int i2 = 0;
            while (i2 < length) {
                int i3 = i2 + 1;
                ambInnerObserverArr[i2] = new AmbInnerObserver(this, i3, this.f31570a);
                i2 = i3;
            }
            this.f31572c.lazySet(0);
            this.f31570a.onSubscribe(this);
            while (i < length && this.f31572c.get() == 0) {
                observableSourceArr[i].subscribe(ambInnerObserverArr[i]);
                i++;
            }
        }

        public final boolean m32356a(int i) {
            int i2 = this.f31572c.get();
            int i3 = 0;
            if (i2 != 0) {
                return i2 == i;
            } else {
                if (!this.f31572c.compareAndSet(0, i)) {
                    return false;
                }
                AmbInnerObserver[] ambInnerObserverArr = this.f31571b;
                int length = ambInnerObserverArr.length;
                while (i3 < length) {
                    int i4 = i3 + 1;
                    if (i4 != i) {
                        DisposableHelper.m32090a(ambInnerObserverArr[i3]);
                    }
                    i3 = i4;
                }
                return true;
            }
        }

        public final void mo5626a() {
            if (this.f31572c.get() != -1) {
                this.f31572c.lazySet(-1);
                for (AtomicReference a : this.f31571b) {
                    DisposableHelper.m32090a(a);
                }
            }
        }

        public final boolean mo5627b() {
            return this.f31572c.get() == -1;
        }
    }

    static final class AmbInnerObserver<T> extends AtomicReference<Disposable> implements Observer<T> {
        final AmbCoordinator<T> f31573a;
        final int f31574b;
        final Observer<? super T> f31575c;
        boolean f31576d;

        AmbInnerObserver(AmbCoordinator<T> ambCoordinator, int i, Observer<? super T> observer) {
            this.f31573a = ambCoordinator;
            this.f31574b = i;
            this.f31575c = observer;
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32092b(this, disposable);
        }

        public final void onNext(T t) {
            if (this.f31576d) {
                this.f31575c.onNext(t);
            } else if (this.f31573a.m32356a(this.f31574b)) {
                this.f31576d = true;
                this.f31575c.onNext(t);
            } else {
                ((Disposable) get()).mo5626a();
            }
        }

        public final void onError(Throwable th) {
            if (this.f31576d) {
                this.f31575c.onError(th);
            } else if (this.f31573a.m32356a(this.f31574b)) {
                this.f31576d = true;
                this.f31575c.onError(th);
            } else {
                RxJavaPlugins.m26757a(th);
            }
        }

        public final void onComplete() {
            if (this.f31576d) {
                this.f31575c.onComplete();
                return;
            }
            if (this.f31573a.m32356a(this.f31574b)) {
                this.f31576d = true;
                this.f31575c.onComplete();
            }
        }
    }

    public ObservableAmb(ObservableSource<? extends T>[] observableSourceArr, Iterable<? extends ObservableSource<? extends T>> iterable) {
        this.f35629a = observableSourceArr;
        this.f35630b = iterable;
    }

    public final void subscribeActual(Observer<? super T> observer) {
        int i;
        ObservableSource[] observableSourceArr = this.f35629a;
        if (observableSourceArr == null) {
            observableSourceArr = new Observable[8];
            try {
                i = 0;
                for (ObservableSource observableSource : this.f35630b) {
                    if (observableSource == null) {
                        EmptyDisposable.m38051a(new NullPointerException("One of the sources is null"), (Observer) observer);
                        return;
                    }
                    if (i == observableSourceArr.length) {
                        Object obj = new ObservableSource[((i >> 2) + i)];
                        System.arraycopy(observableSourceArr, 0, obj, 0, i);
                        observableSourceArr = obj;
                    }
                    int i2 = i + 1;
                    observableSourceArr[i] = observableSource;
                    i = i2;
                }
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                EmptyDisposable.m38051a(th, (Observer) observer);
                return;
            }
        }
        i = observableSourceArr.length;
        if (i == 0) {
            EmptyDisposable.m38048a((Observer) observer);
        } else if (i == 1) {
            observableSourceArr[0].subscribe(observer);
        } else {
            new AmbCoordinator(observer, i).m32355a(observableSourceArr);
        }
    }
}
