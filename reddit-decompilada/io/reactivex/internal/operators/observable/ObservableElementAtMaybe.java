package io.reactivex.internal.operators.observable;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableElementAtMaybe<T> extends Maybe<T> implements FuseToObservable<T> {
    final ObservableSource<T> f35662a;
    final long f35663b;

    static final class ElementAtObserver<T> implements Observer<T>, Disposable {
        final MaybeObserver<? super T> f31764a;
        final long f31765b;
        Disposable f31766c;
        long f31767d;
        boolean f31768e;

        ElementAtObserver(MaybeObserver<? super T> maybeObserver, long j) {
            this.f31764a = maybeObserver;
            this.f31765b = j;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31766c, disposable)) {
                this.f31766c = disposable;
                this.f31764a.onSubscribe(this);
            }
        }

        public final void mo5626a() {
            this.f31766c.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f31766c.mo5627b();
        }

        public final void onNext(T t) {
            if (!this.f31768e) {
                long j = this.f31767d;
                if (j == this.f31765b) {
                    this.f31768e = true;
                    this.f31766c.mo5626a();
                    this.f31764a.onSuccess(t);
                    return;
                }
                this.f31767d = j + 1;
            }
        }

        public final void onError(Throwable th) {
            if (this.f31768e) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f31768e = true;
            this.f31764a.onError(th);
        }

        public final void onComplete() {
            if (!this.f31768e) {
                this.f31768e = true;
                this.f31764a.onComplete();
            }
        }
    }

    public ObservableElementAtMaybe(ObservableSource<T> observableSource, long j) {
        this.f35662a = observableSource;
        this.f35663b = j;
    }

    public final void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f35662a.subscribe(new ElementAtObserver(maybeObserver, this.f35663b));
    }

    public final Observable<T> mo6641a() {
        return RxJavaPlugins.m26742a(new ObservableElementAt(this.f35662a, this.f35663b, null, false));
    }
}
