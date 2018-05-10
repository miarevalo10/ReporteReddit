package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableReduceSeedSingle<T, R> extends Single<R> {
    final ObservableSource<T> f35707a;
    final R f35708b;
    final BiFunction<R, ? super T, R> f35709c;

    static final class ReduceSeedObserver<T, R> implements Observer<T>, Disposable {
        final SingleObserver<? super R> f31987a;
        final BiFunction<R, ? super T, R> f31988b;
        R f31989c;
        Disposable f31990d;

        ReduceSeedObserver(SingleObserver<? super R> singleObserver, BiFunction<R, ? super T, R> biFunction, R r) {
            this.f31987a = singleObserver;
            this.f31989c = r;
            this.f31988b = biFunction;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31990d, disposable)) {
                this.f31990d = disposable;
                this.f31987a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            Object obj = this.f31989c;
            if (obj != null) {
                try {
                    this.f31989c = ObjectHelper.m26573a(this.f31988b.apply(obj, t), "The reducer returned a null value");
                } catch (T t2) {
                    Exceptions.m26521b(t2);
                    this.f31990d.mo5626a();
                    onError(t2);
                }
            }
        }

        public final void onError(Throwable th) {
            Object obj = this.f31989c;
            this.f31989c = null;
            if (obj != null) {
                this.f31987a.onError(th);
            } else {
                RxJavaPlugins.m26757a(th);
            }
        }

        public final void onComplete() {
            Object obj = this.f31989c;
            this.f31989c = null;
            if (obj != null) {
                this.f31987a.onSuccess(obj);
            }
        }

        public final void mo5626a() {
            this.f31990d.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f31990d.mo5627b();
        }
    }

    public ObservableReduceSeedSingle(ObservableSource<T> observableSource, R r, BiFunction<R, ? super T, R> biFunction) {
        this.f35707a = observableSource;
        this.f35708b = r;
        this.f35709c = biFunction;
    }

    protected final void subscribeActual(SingleObserver<? super R> singleObserver) {
        this.f35707a.subscribe(new ReduceSeedObserver(singleObserver, this.f35709c, this.f35708b));
    }
}
