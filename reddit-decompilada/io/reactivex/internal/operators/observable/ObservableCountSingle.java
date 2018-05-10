package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableCountSingle<T> extends Single<Long> implements FuseToObservable<Long> {
    final ObservableSource<T> f35651a;

    static final class CountObserver implements Observer<Object>, Disposable {
        final SingleObserver<? super Long> f31713a;
        Disposable f31714b;
        long f31715c;

        CountObserver(SingleObserver<? super Long> singleObserver) {
            this.f31713a = singleObserver;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31714b, disposable)) {
                this.f31714b = disposable;
                this.f31713a.onSubscribe(this);
            }
        }

        public final void mo5626a() {
            this.f31714b.mo5626a();
            this.f31714b = DisposableHelper.f31095a;
        }

        public final boolean mo5627b() {
            return this.f31714b.mo5627b();
        }

        public final void onNext(Object obj) {
            this.f31715c++;
        }

        public final void onError(Throwable th) {
            this.f31714b = DisposableHelper.f31095a;
            this.f31713a.onError(th);
        }

        public final void onComplete() {
            this.f31714b = DisposableHelper.f31095a;
            this.f31713a.onSuccess(Long.valueOf(this.f31715c));
        }
    }

    public ObservableCountSingle(ObservableSource<T> observableSource) {
        this.f35651a = observableSource;
    }

    public final void subscribeActual(SingleObserver<? super Long> singleObserver) {
        this.f35651a.subscribe(new CountObserver(singleObserver));
    }

    public final Observable<Long> mo6641a() {
        return RxJavaPlugins.m26742a(new ObservableCount(this.f35651a));
    }
}
