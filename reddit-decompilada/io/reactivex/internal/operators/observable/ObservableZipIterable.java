package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;

public final class ObservableZipIterable<T, U, V> extends Observable<V> {
    final Observable<? extends T> f35761a;
    final Iterable<U> f35762b;
    final BiFunction<? super T, ? super U, ? extends V> f35763c;

    static final class ZipIterableObserver<T, U, V> implements Observer<T>, Disposable {
        final Observer<? super V> f32300a;
        final Iterator<U> f32301b;
        final BiFunction<? super T, ? super U, ? extends V> f32302c;
        Disposable f32303d;
        boolean f32304e;

        ZipIterableObserver(Observer<? super V> observer, Iterator<U> it, BiFunction<? super T, ? super U, ? extends V> biFunction) {
            this.f32300a = observer;
            this.f32301b = it;
            this.f32302c = biFunction;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f32303d, disposable)) {
                this.f32303d = disposable;
                this.f32300a.onSubscribe(this);
            }
        }

        public final void mo5626a() {
            this.f32303d.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f32303d.mo5627b();
        }

        public final void onNext(T t) {
            if (!this.f32304e) {
                try {
                    try {
                        this.f32300a.onNext(ObjectHelper.m26573a(this.f32302c.apply(t, ObjectHelper.m26573a(this.f32301b.next(), "The iterator returned a null value")), "The zipper function returned a null value"));
                        try {
                            if (this.f32301b.hasNext() == null) {
                                this.f32304e = true;
                                this.f32303d.mo5626a();
                                this.f32300a.onComplete();
                            }
                        } catch (T t2) {
                            Exceptions.m26521b(t2);
                            m32680a(t2);
                        }
                    } catch (T t22) {
                        Exceptions.m26521b(t22);
                        m32680a(t22);
                    }
                } catch (T t222) {
                    Exceptions.m26521b(t222);
                    m32680a(t222);
                }
            }
        }

        private void m32680a(Throwable th) {
            this.f32304e = true;
            this.f32303d.mo5626a();
            this.f32300a.onError(th);
        }

        public final void onError(Throwable th) {
            if (this.f32304e) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f32304e = true;
            this.f32300a.onError(th);
        }

        public final void onComplete() {
            if (!this.f32304e) {
                this.f32304e = true;
                this.f32300a.onComplete();
            }
        }
    }

    public ObservableZipIterable(Observable<? extends T> observable, Iterable<U> iterable, BiFunction<? super T, ? super U, ? extends V> biFunction) {
        this.f35761a = observable;
        this.f35762b = iterable;
        this.f35763c = biFunction;
    }

    public final void subscribeActual(Observer<? super V> observer) {
        try {
            Iterator it = (Iterator) ObjectHelper.m26573a(this.f35762b.iterator(), "The iterator returned by other is null");
            try {
                if (it.hasNext()) {
                    this.f35761a.subscribe(new ZipIterableObserver(observer, it, this.f35763c));
                } else {
                    EmptyDisposable.m38048a((Observer) observer);
                }
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                EmptyDisposable.m38051a(th, (Observer) observer);
            }
        } catch (Throwable th2) {
            Exceptions.m26521b(th2);
            EmptyDisposable.m38051a(th2, (Observer) observer);
        }
    }
}
