package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.Collection;
import java.util.concurrent.Callable;

public final class ObservableToList<T, U extends Collection<? super T>> extends AbstractObservableWithUpstream<T, U> {
    final Callable<U> f38109a;

    static final class ToListObserver<T, U extends Collection<? super T>> implements Observer<T>, Disposable {
        U f32241a;
        final Observer<? super U> f32242b;
        Disposable f32243c;

        ToListObserver(Observer<? super U> observer, U u) {
            this.f32242b = observer;
            this.f32241a = u;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f32243c, disposable)) {
                this.f32243c = disposable;
                this.f32242b.onSubscribe(this);
            }
        }

        public final void mo5626a() {
            this.f32243c.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f32243c.mo5627b();
        }

        public final void onNext(T t) {
            this.f32241a.add(t);
        }

        public final void onError(Throwable th) {
            this.f32241a = null;
            this.f32242b.onError(th);
        }

        public final void onComplete() {
            Collection collection = this.f32241a;
            this.f32241a = null;
            this.f32242b.onNext(collection);
            this.f32242b.onComplete();
        }
    }

    public ObservableToList(ObservableSource<T> observableSource) {
        super(observableSource);
        this.f38109a = Functions.m26554a(16);
    }

    public ObservableToList(ObservableSource<T> observableSource, Callable<U> callable) {
        super(observableSource);
        this.f38109a = callable;
    }

    public final void subscribeActual(Observer<? super U> observer) {
        try {
            this.source.subscribe(new ToListObserver(observer, (Collection) ObjectHelper.m26573a(this.f38109a.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            EmptyDisposable.m38051a(th, (Observer) observer);
        }
    }
}
