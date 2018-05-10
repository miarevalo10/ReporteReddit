package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;

public final class ObservableOnErrorReturn<T> extends AbstractObservableWithUpstream<T, T> {
    final Function<? super Throwable, ? extends T> f38037a;

    static final class OnErrorReturnObserver<T> implements Observer<T>, Disposable {
        final Observer<? super T> f31967a;
        final Function<? super Throwable, ? extends T> f31968b;
        Disposable f31969c;

        OnErrorReturnObserver(Observer<? super T> observer, Function<? super Throwable, ? extends T> function) {
            this.f31967a = observer;
            this.f31968b = function;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31969c, disposable)) {
                this.f31969c = disposable;
                this.f31967a.onSubscribe(this);
            }
        }

        public final void mo5626a() {
            this.f31969c.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f31969c.mo5627b();
        }

        public final void onNext(T t) {
            this.f31967a.onNext(t);
        }

        public final void onError(Throwable th) {
            Throwable nullPointerException;
            try {
                Object apply = this.f31968b.apply(th);
                if (apply == null) {
                    nullPointerException = new NullPointerException("The supplied value is null");
                    nullPointerException.initCause(th);
                    this.f31967a.onError(nullPointerException);
                    return;
                }
                this.f31967a.onNext(apply);
                this.f31967a.onComplete();
            } catch (Throwable nullPointerException2) {
                Exceptions.m26521b(nullPointerException2);
                this.f31967a.onError(new CompositeException(th, nullPointerException2));
            }
        }

        public final void onComplete() {
            this.f31967a.onComplete();
        }
    }

    public ObservableOnErrorReturn(ObservableSource<T> observableSource, Function<? super Throwable, ? extends T> function) {
        super(observableSource);
        this.f38037a = function;
    }

    public final void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new OnErrorReturnObserver(observer, this.f38037a));
    }
}
