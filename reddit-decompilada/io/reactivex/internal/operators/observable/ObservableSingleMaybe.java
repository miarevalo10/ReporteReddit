package io.reactivex.internal.operators.observable;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableSingleMaybe<T> extends Maybe<T> {
    final ObservableSource<T> f35733a;

    static final class SingleElementObserver<T> implements Observer<T>, Disposable {
        final MaybeObserver<? super T> f32104a;
        Disposable f32105b;
        T f32106c;
        boolean f32107d;

        SingleElementObserver(MaybeObserver<? super T> maybeObserver) {
            this.f32104a = maybeObserver;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f32105b, disposable)) {
                this.f32105b = disposable;
                this.f32104a.onSubscribe(this);
            }
        }

        public final void mo5626a() {
            this.f32105b.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f32105b.mo5627b();
        }

        public final void onNext(T t) {
            if (!this.f32107d) {
                if (this.f32106c != null) {
                    this.f32107d = true;
                    this.f32105b.mo5626a();
                    this.f32104a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.f32106c = t;
            }
        }

        public final void onError(Throwable th) {
            if (this.f32107d) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f32107d = true;
            this.f32104a.onError(th);
        }

        public final void onComplete() {
            if (!this.f32107d) {
                this.f32107d = true;
                Object obj = this.f32106c;
                this.f32106c = null;
                if (obj == null) {
                    this.f32104a.onComplete();
                } else {
                    this.f32104a.onSuccess(obj);
                }
            }
        }
    }

    public ObservableSingleMaybe(ObservableSource<T> observableSource) {
        this.f35733a = observableSource;
    }

    public final void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f35733a.subscribe(new SingleElementObserver(maybeObserver));
    }
}
