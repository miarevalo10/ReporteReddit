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

public final class ObservableAllSingle<T> extends Single<Boolean> implements FuseToObservable<Boolean> {
    final ObservableSource<T> f35627a;
    final Predicate<? super T> f35628b;

    static final class AllObserver<T> implements Observer<T>, Disposable {
        final SingleObserver<? super Boolean> f31566a;
        final Predicate<? super T> f31567b;
        Disposable f31568c;
        boolean f31569d;

        AllObserver(SingleObserver<? super Boolean> singleObserver, Predicate<? super T> predicate) {
            this.f31566a = singleObserver;
            this.f31567b = predicate;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31568c, disposable)) {
                this.f31568c = disposable;
                this.f31566a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            if (!this.f31569d) {
                try {
                    if (this.f31567b.test(t) == null) {
                        this.f31569d = true;
                        this.f31568c.mo5626a();
                        this.f31566a.onSuccess(Boolean.valueOf(false));
                    }
                } catch (T t2) {
                    Exceptions.m26521b(t2);
                    this.f31568c.mo5626a();
                    onError(t2);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f31569d) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f31569d = true;
            this.f31566a.onError(th);
        }

        public final void onComplete() {
            if (!this.f31569d) {
                this.f31569d = true;
                this.f31566a.onSuccess(Boolean.valueOf(true));
            }
        }

        public final void mo5626a() {
            this.f31568c.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f31568c.mo5627b();
        }
    }

    public ObservableAllSingle(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        this.f35627a = observableSource;
        this.f35628b = predicate;
    }

    protected final void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.f35627a.subscribe(new AllObserver(singleObserver, this.f35628b));
    }

    public final Observable<Boolean> mo6641a() {
        return RxJavaPlugins.m26742a(new ObservableAll(this.f35627a, this.f35628b));
    }
}
