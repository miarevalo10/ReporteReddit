package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableDelaySubscriptionOther<T, U> extends Observable<T> {
    final ObservableSource<? extends T> f35660a;
    final ObservableSource<U> f35661b;

    final class DelayObserver implements Observer<U> {
        final SequentialDisposable f31741a;
        final Observer<? super T> f31742b;
        boolean f31743c;
        final /* synthetic */ ObservableDelaySubscriptionOther f31744d;

        final class OnComplete implements Observer<T> {
            final /* synthetic */ DelayObserver f31740a;

            OnComplete(DelayObserver delayObserver) {
                this.f31740a = delayObserver;
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.m32091a(this.f31740a.f31741a, disposable);
            }

            public final void onNext(T t) {
                this.f31740a.f31742b.onNext(t);
            }

            public final void onError(Throwable th) {
                this.f31740a.f31742b.onError(th);
            }

            public final void onComplete() {
                this.f31740a.f31742b.onComplete();
            }
        }

        DelayObserver(ObservableDelaySubscriptionOther observableDelaySubscriptionOther, SequentialDisposable sequentialDisposable, Observer<? super T> observer) {
            this.f31744d = observableDelaySubscriptionOther;
            this.f31741a = sequentialDisposable;
            this.f31742b = observer;
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32091a(this.f31741a, disposable);
        }

        public final void onNext(U u) {
            onComplete();
        }

        public final void onError(Throwable th) {
            if (this.f31743c) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f31743c = true;
            this.f31742b.onError(th);
        }

        public final void onComplete() {
            if (!this.f31743c) {
                this.f31743c = true;
                this.f31744d.f35660a.subscribe(new OnComplete(this));
            }
        }
    }

    public ObservableDelaySubscriptionOther(ObservableSource<? extends T> observableSource, ObservableSource<U> observableSource2) {
        this.f35660a = observableSource;
        this.f35661b = observableSource2;
    }

    public final void subscribeActual(Observer<? super T> observer) {
        Object sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        this.f35661b.subscribe(new DelayObserver(this, sequentialDisposable, observer));
    }
}
