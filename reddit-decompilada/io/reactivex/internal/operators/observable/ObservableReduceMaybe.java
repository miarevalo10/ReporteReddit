package io.reactivex.internal.operators.observable;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableReduceMaybe<T> extends Maybe<T> {
    final ObservableSource<T> f35705a;
    final BiFunction<T, T, T> f35706b;

    static final class ReduceObserver<T> implements Observer<T>, Disposable {
        final MaybeObserver<? super T> f31982a;
        final BiFunction<T, T, T> f31983b;
        boolean f31984c;
        T f31985d;
        Disposable f31986e;

        ReduceObserver(MaybeObserver<? super T> maybeObserver, BiFunction<T, T, T> biFunction) {
            this.f31982a = maybeObserver;
            this.f31983b = biFunction;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31986e, disposable)) {
                this.f31986e = disposable;
                this.f31982a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            if (!this.f31984c) {
                Object obj = this.f31985d;
                if (obj == null) {
                    this.f31985d = t;
                    return;
                }
                try {
                    this.f31985d = ObjectHelper.m26573a(this.f31983b.apply(obj, t), "The reducer returned a null value");
                } catch (T t2) {
                    Exceptions.m26521b(t2);
                    this.f31986e.mo5626a();
                    onError(t2);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f31984c) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f31984c = true;
            this.f31985d = null;
            this.f31982a.onError(th);
        }

        public final void onComplete() {
            if (!this.f31984c) {
                this.f31984c = true;
                Object obj = this.f31985d;
                this.f31985d = null;
                if (obj != null) {
                    this.f31982a.onSuccess(obj);
                } else {
                    this.f31982a.onComplete();
                }
            }
        }

        public final void mo5626a() {
            this.f31986e.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f31986e.mo5627b();
        }
    }

    public ObservableReduceMaybe(ObservableSource<T> observableSource, BiFunction<T, T, T> biFunction) {
        this.f35705a = observableSource;
        this.f35706b = biFunction;
    }

    protected final void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f35705a.subscribe(new ReduceObserver(maybeObserver, this.f35706b));
    }
}
