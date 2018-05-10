package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.Callable;

public final class ObservableToListSingle<T, U extends Collection<? super T>> extends Single<U> implements FuseToObservable<U> {
    final ObservableSource<T> f35742a;
    final Callable<U> f35743b;

    static final class ToListObserver<T, U extends Collection<? super T>> implements Observer<T>, Disposable {
        final SingleObserver<? super U> f32244a;
        U f32245b;
        Disposable f32246c;

        ToListObserver(SingleObserver<? super U> singleObserver, U u) {
            this.f32244a = singleObserver;
            this.f32245b = u;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f32246c, disposable)) {
                this.f32246c = disposable;
                this.f32244a.onSubscribe(this);
            }
        }

        public final void mo5626a() {
            this.f32246c.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f32246c.mo5627b();
        }

        public final void onNext(T t) {
            this.f32245b.add(t);
        }

        public final void onError(Throwable th) {
            this.f32245b = null;
            this.f32244a.onError(th);
        }

        public final void onComplete() {
            Collection collection = this.f32245b;
            this.f32245b = null;
            this.f32244a.onSuccess(collection);
        }
    }

    public ObservableToListSingle(ObservableSource<T> observableSource, int i) {
        this.f35742a = observableSource;
        this.f35743b = Functions.m26554a(i);
    }

    public ObservableToListSingle(ObservableSource<T> observableSource, Callable<U> callable) {
        this.f35742a = observableSource;
        this.f35743b = callable;
    }

    public final void subscribeActual(SingleObserver<? super U> singleObserver) {
        try {
            this.f35742a.subscribe(new ToListObserver(singleObserver, (Collection) ObjectHelper.m26573a(this.f35743b.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            EmptyDisposable.m38052a(th, (SingleObserver) singleObserver);
        }
    }

    public final Observable<U> mo6641a() {
        return RxJavaPlugins.m26742a(new ObservableToList(this.f35742a, this.f35743b));
    }
}
