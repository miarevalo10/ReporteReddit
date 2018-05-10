package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableOnErrorNext<T> extends AbstractObservableWithUpstream<T, T> {
    final Function<? super Throwable, ? extends ObservableSource<? extends T>> f38035a;
    final boolean f38036b;

    static final class OnErrorNextObserver<T> implements Observer<T> {
        final Observer<? super T> f31961a;
        final Function<? super Throwable, ? extends ObservableSource<? extends T>> f31962b;
        final boolean f31963c;
        final SequentialDisposable f31964d = new SequentialDisposable();
        boolean f31965e;
        boolean f31966f;

        OnErrorNextObserver(Observer<? super T> observer, Function<? super Throwable, ? extends ObservableSource<? extends T>> function, boolean z) {
            this.f31961a = observer;
            this.f31962b = function;
            this.f31963c = z;
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32094c(this.f31964d, disposable);
        }

        public final void onNext(T t) {
            if (!this.f31966f) {
                this.f31961a.onNext(t);
            }
        }

        public final void onError(Throwable th) {
            if (!this.f31965e) {
                this.f31965e = true;
                if (!this.f31963c || (th instanceof Exception)) {
                    try {
                        ObservableSource observableSource = (ObservableSource) this.f31962b.apply(th);
                        if (observableSource == null) {
                            Throwable nullPointerException = new NullPointerException("Observable is null");
                            nullPointerException.initCause(th);
                            this.f31961a.onError(nullPointerException);
                            return;
                        }
                        observableSource.subscribe(this);
                        return;
                    } catch (Throwable th2) {
                        Exceptions.m26521b(th2);
                        this.f31961a.onError(new CompositeException(th, th2));
                        return;
                    }
                }
                this.f31961a.onError(th);
            } else if (this.f31966f) {
                RxJavaPlugins.m26757a(th);
            } else {
                this.f31961a.onError(th);
            }
        }

        public final void onComplete() {
            if (!this.f31966f) {
                this.f31966f = true;
                this.f31965e = true;
                this.f31961a.onComplete();
            }
        }
    }

    public ObservableOnErrorNext(ObservableSource<T> observableSource, Function<? super Throwable, ? extends ObservableSource<? extends T>> function, boolean z) {
        super(observableSource);
        this.f38035a = function;
        this.f38036b = z;
    }

    public final void subscribeActual(Observer<? super T> observer) {
        Observer onErrorNextObserver = new OnErrorNextObserver(observer, this.f38035a, this.f38036b);
        observer.onSubscribe(onErrorNextObserver.f31964d);
        this.source.subscribe(onErrorNextObserver);
    }
}
