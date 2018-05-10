package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;

public final class ObservableSingleSingle<T> extends Single<T> {
    final ObservableSource<? extends T> f35734a;
    final T f35735b;

    static final class SingleElementObserver<T> implements Observer<T>, Disposable {
        final SingleObserver<? super T> f32108a;
        final T f32109b;
        Disposable f32110c;
        T f32111d;
        boolean f32112e;

        SingleElementObserver(SingleObserver<? super T> singleObserver, T t) {
            this.f32108a = singleObserver;
            this.f32109b = t;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f32110c, disposable)) {
                this.f32110c = disposable;
                this.f32108a.onSubscribe(this);
            }
        }

        public final void mo5626a() {
            this.f32110c.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f32110c.mo5627b();
        }

        public final void onNext(T t) {
            if (!this.f32112e) {
                if (this.f32111d != null) {
                    this.f32112e = true;
                    this.f32110c.mo5626a();
                    this.f32108a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.f32111d = t;
            }
        }

        public final void onError(Throwable th) {
            if (this.f32112e) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f32112e = true;
            this.f32108a.onError(th);
        }

        public final void onComplete() {
            if (!this.f32112e) {
                this.f32112e = true;
                Object obj = this.f32111d;
                this.f32111d = null;
                if (obj == null) {
                    obj = this.f32109b;
                }
                if (obj != null) {
                    this.f32108a.onSuccess(obj);
                } else {
                    this.f32108a.onError(new NoSuchElementException());
                }
            }
        }
    }

    public ObservableSingleSingle(ObservableSource<? extends T> observableSource, T t) {
        this.f35734a = observableSource;
        this.f35735b = t;
    }

    public final void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f35734a.subscribe(new SingleElementObserver(singleObserver, this.f35735b));
    }
}
