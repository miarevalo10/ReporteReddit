package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

public final class ObservableMapNotification<T, R> extends AbstractObservableWithUpstream<T, ObservableSource<? extends R>> {
    final Function<? super T, ? extends ObservableSource<? extends R>> f38026a;
    final Function<? super Throwable, ? extends ObservableSource<? extends R>> f38027b;
    final Callable<? extends ObservableSource<? extends R>> f38028c;

    static final class MapNotificationObserver<T, R> implements Observer<T>, Disposable {
        final Observer<? super ObservableSource<? extends R>> f31927a;
        final Function<? super T, ? extends ObservableSource<? extends R>> f31928b;
        final Function<? super Throwable, ? extends ObservableSource<? extends R>> f31929c;
        final Callable<? extends ObservableSource<? extends R>> f31930d;
        Disposable f31931e;

        MapNotificationObserver(Observer<? super ObservableSource<? extends R>> observer, Function<? super T, ? extends ObservableSource<? extends R>> function, Function<? super Throwable, ? extends ObservableSource<? extends R>> function2, Callable<? extends ObservableSource<? extends R>> callable) {
            this.f31927a = observer;
            this.f31928b = function;
            this.f31929c = function2;
            this.f31930d = callable;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31931e, disposable)) {
                this.f31931e = disposable;
                this.f31927a.onSubscribe(this);
            }
        }

        public final void mo5626a() {
            this.f31931e.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f31931e.mo5627b();
        }

        public final void onNext(T t) {
            try {
                this.f31927a.onNext((ObservableSource) ObjectHelper.m26573a(this.f31928b.apply(t), "The onNext ObservableSource returned is null"));
            } catch (T t2) {
                Exceptions.m26521b(t2);
                this.f31927a.onError(t2);
            }
        }

        public final void onError(Throwable th) {
            try {
                this.f31927a.onNext((ObservableSource) ObjectHelper.m26573a(this.f31929c.apply(th), "The onError ObservableSource returned is null"));
                this.f31927a.onComplete();
            } catch (Throwable th2) {
                Exceptions.m26521b(th2);
                this.f31927a.onError(new CompositeException(th, th2));
            }
        }

        public final void onComplete() {
            try {
                this.f31927a.onNext((ObservableSource) ObjectHelper.m26573a(this.f31930d.call(), "The onComplete ObservableSource returned is null"));
                this.f31927a.onComplete();
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                this.f31927a.onError(th);
            }
        }
    }

    public ObservableMapNotification(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends R>> function, Function<? super Throwable, ? extends ObservableSource<? extends R>> function2, Callable<? extends ObservableSource<? extends R>> callable) {
        super(observableSource);
        this.f38026a = function;
        this.f38027b = function2;
        this.f38028c = callable;
    }

    public final void subscribeActual(Observer<? super ObservableSource<? extends R>> observer) {
        this.source.subscribe(new MapNotificationObserver(observer, this.f38026a, this.f38027b, this.f38028c));
    }
}
