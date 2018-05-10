package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableAll<T> extends AbstractObservableWithUpstream<T, Boolean> {
    final Predicate<? super T> f37945a;

    static final class AllObserver<T> implements Observer<T>, Disposable {
        final Observer<? super Boolean> f31562a;
        final Predicate<? super T> f31563b;
        Disposable f31564c;
        boolean f31565d;

        AllObserver(Observer<? super Boolean> observer, Predicate<? super T> predicate) {
            this.f31562a = observer;
            this.f31563b = predicate;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31564c, disposable)) {
                this.f31564c = disposable;
                this.f31562a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            if (!this.f31565d) {
                try {
                    if (this.f31563b.test(t) == null) {
                        this.f31565d = true;
                        this.f31564c.mo5626a();
                        this.f31562a.onNext(Boolean.valueOf(false));
                        this.f31562a.onComplete();
                    }
                } catch (T t2) {
                    Exceptions.m26521b(t2);
                    this.f31564c.mo5626a();
                    onError(t2);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f31565d) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f31565d = true;
            this.f31562a.onError(th);
        }

        public final void onComplete() {
            if (!this.f31565d) {
                this.f31565d = true;
                this.f31562a.onNext(Boolean.valueOf(true));
                this.f31562a.onComplete();
            }
        }

        public final void mo5626a() {
            this.f31564c.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f31564c.mo5627b();
        }
    }

    public ObservableAll(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.f37945a = predicate;
    }

    protected final void subscribeActual(Observer<? super Boolean> observer) {
        this.source.subscribe(new AllObserver(observer, this.f37945a));
    }
}
