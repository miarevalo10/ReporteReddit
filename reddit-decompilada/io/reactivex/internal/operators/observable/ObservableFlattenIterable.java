package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableFlattenIterable<T, R> extends AbstractObservableWithUpstream<T, R> {
    final Function<? super T, ? extends Iterable<? extends R>> f38010a;

    static final class FlattenIterableObserver<T, R> implements Observer<T>, Disposable {
        final Observer<? super R> f31827a;
        final Function<? super T, ? extends Iterable<? extends R>> f31828b;
        Disposable f31829c;

        FlattenIterableObserver(Observer<? super R> observer, Function<? super T, ? extends Iterable<? extends R>> function) {
            this.f31827a = observer;
            this.f31828b = function;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31829c, disposable)) {
                this.f31829c = disposable;
                this.f31827a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            if (this.f31829c != DisposableHelper.f31095a) {
                try {
                    Observer observer = this.f31827a;
                    for (Object a : (Iterable) this.f31828b.apply(t)) {
                        try {
                            try {
                                observer.onNext(ObjectHelper.m26573a(a, "The iterator returned a null value"));
                            } catch (T t2) {
                                Exceptions.m26521b(t2);
                                this.f31829c.mo5626a();
                                onError(t2);
                                return;
                            }
                        } catch (T t22) {
                            Exceptions.m26521b(t22);
                            this.f31829c.mo5626a();
                            onError(t22);
                            return;
                        }
                    }
                } catch (T t222) {
                    Exceptions.m26521b(t222);
                    this.f31829c.mo5626a();
                    onError(t222);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f31829c == DisposableHelper.f31095a) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f31829c = DisposableHelper.f31095a;
            this.f31827a.onError(th);
        }

        public final void onComplete() {
            if (this.f31829c != DisposableHelper.f31095a) {
                this.f31829c = DisposableHelper.f31095a;
                this.f31827a.onComplete();
            }
        }

        public final boolean mo5627b() {
            return this.f31829c.mo5627b();
        }

        public final void mo5626a() {
            this.f31829c.mo5626a();
            this.f31829c = DisposableHelper.f31095a;
        }
    }

    public ObservableFlattenIterable(ObservableSource<T> observableSource, Function<? super T, ? extends Iterable<? extends R>> function) {
        super(observableSource);
        this.f38010a = function;
    }

    protected final void subscribeActual(Observer<? super R> observer) {
        this.source.subscribe(new FlattenIterableObserver(observer, this.f38010a));
    }
}
