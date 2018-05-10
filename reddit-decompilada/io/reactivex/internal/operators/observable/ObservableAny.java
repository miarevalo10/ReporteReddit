package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableAny<T> extends AbstractObservableWithUpstream<T, Boolean> {
    final Predicate<? super T> f37946a;

    static final class AnyObserver<T> implements Observer<T>, Disposable {
        final Observer<? super Boolean> f31577a;
        final Predicate<? super T> f31578b;
        Disposable f31579c;
        boolean f31580d;

        AnyObserver(Observer<? super Boolean> observer, Predicate<? super T> predicate) {
            this.f31577a = observer;
            this.f31578b = predicate;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31579c, disposable)) {
                this.f31579c = disposable;
                this.f31577a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            if (!this.f31580d) {
                try {
                    if (this.f31578b.test(t) != null) {
                        this.f31580d = true;
                        this.f31579c.mo5626a();
                        this.f31577a.onNext(Boolean.valueOf(true));
                        this.f31577a.onComplete();
                    }
                } catch (T t2) {
                    Exceptions.m26521b(t2);
                    this.f31579c.mo5626a();
                    onError(t2);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f31580d) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f31580d = true;
            this.f31577a.onError(th);
        }

        public final void onComplete() {
            if (!this.f31580d) {
                this.f31580d = true;
                this.f31577a.onNext(Boolean.valueOf(false));
                this.f31577a.onComplete();
            }
        }

        public final void mo5626a() {
            this.f31579c.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f31579c.mo5627b();
        }
    }

    public ObservableAny(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.f37946a = predicate;
    }

    protected final void subscribeActual(Observer<? super Boolean> observer) {
        this.source.subscribe(new AnyObserver(observer, this.f37946a));
    }
}
