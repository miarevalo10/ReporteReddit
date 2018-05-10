package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableAnySingle<T> extends Single<Boolean> implements FuseToObservable<Boolean> {
    final ObservableSource<T> f35631a;
    final Predicate<? super T> f35632b;

    static final class AnyObserver<T> implements Observer<T>, Disposable {
        final SingleObserver<? super Boolean> f31581a;
        final Predicate<? super T> f31582b;
        Disposable f31583c;
        boolean f31584d;

        AnyObserver(SingleObserver<? super Boolean> singleObserver, Predicate<? super T> predicate) {
            this.f31581a = singleObserver;
            this.f31582b = predicate;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31583c, disposable)) {
                this.f31583c = disposable;
                this.f31581a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            if (!this.f31584d) {
                try {
                    if (this.f31582b.test(t) != null) {
                        this.f31584d = true;
                        this.f31583c.mo5626a();
                        this.f31581a.onSuccess(Boolean.valueOf(true));
                    }
                } catch (T t2) {
                    Exceptions.m26521b(t2);
                    this.f31583c.mo5626a();
                    onError(t2);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f31584d) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f31584d = true;
            this.f31581a.onError(th);
        }

        public final void onComplete() {
            if (!this.f31584d) {
                this.f31584d = true;
                this.f31581a.onSuccess(Boolean.valueOf(false));
            }
        }

        public final void mo5626a() {
            this.f31583c.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f31583c.mo5627b();
        }
    }

    public ObservableAnySingle(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        this.f35631a = observableSource;
        this.f35632b = predicate;
    }

    protected final void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.f35631a.subscribe(new AnyObserver(singleObserver, this.f35632b));
    }

    public final Observable<Boolean> mo6641a() {
        return RxJavaPlugins.m26742a(new ObservableAny(this.f35631a, this.f35632b));
    }
}
