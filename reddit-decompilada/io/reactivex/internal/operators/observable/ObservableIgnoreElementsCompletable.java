package io.reactivex.internal.operators.observable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableIgnoreElementsCompletable<T> extends Completable implements FuseToObservable<T> {
    final ObservableSource<T> f35685a;

    static final class IgnoreObservable<T> implements Observer<T>, Disposable {
        final CompletableObserver f31881a;
        Disposable f31882b;

        public final void onNext(T t) {
        }

        IgnoreObservable(CompletableObserver completableObserver) {
            this.f31881a = completableObserver;
        }

        public final void onSubscribe(Disposable disposable) {
            this.f31882b = disposable;
            this.f31881a.onSubscribe(this);
        }

        public final void onError(Throwable th) {
            this.f31881a.onError(th);
        }

        public final void onComplete() {
            this.f31881a.onComplete();
        }

        public final void mo5626a() {
            this.f31882b.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f31882b.mo5627b();
        }
    }

    public ObservableIgnoreElementsCompletable(ObservableSource<T> observableSource) {
        this.f35685a = observableSource;
    }

    public final void subscribeActual(CompletableObserver completableObserver) {
        this.f35685a.subscribe(new IgnoreObservable(completableObserver));
    }

    public final Observable<T> mo6641a() {
        return RxJavaPlugins.m26742a(new ObservableIgnoreElements(this.f35685a));
    }
}
