package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableTakeUntilPredicate<T> extends AbstractObservableWithUpstream<T, T> {
    final Predicate<? super T> f38094a;

    static final class TakeUntilPredicateObserver<T> implements Observer<T>, Disposable {
        final Observer<? super T> f32191a;
        final Predicate<? super T> f32192b;
        Disposable f32193c;
        boolean f32194d;

        TakeUntilPredicateObserver(Observer<? super T> observer, Predicate<? super T> predicate) {
            this.f32191a = observer;
            this.f32192b = predicate;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f32193c, disposable)) {
                this.f32193c = disposable;
                this.f32191a.onSubscribe(this);
            }
        }

        public final void mo5626a() {
            this.f32193c.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f32193c.mo5627b();
        }

        public final void onNext(T t) {
            if (!this.f32194d) {
                this.f32191a.onNext(t);
                try {
                    if (this.f32192b.test(t) != null) {
                        this.f32194d = true;
                        this.f32193c.mo5626a();
                        this.f32191a.onComplete();
                    }
                } catch (T t2) {
                    Exceptions.m26521b(t2);
                    this.f32193c.mo5626a();
                    onError(t2);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f32194d) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f32194d = true;
            this.f32191a.onError(th);
        }

        public final void onComplete() {
            if (!this.f32194d) {
                this.f32194d = true;
                this.f32191a.onComplete();
            }
        }
    }

    public ObservableTakeUntilPredicate(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.f38094a = predicate;
    }

    public final void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new TakeUntilPredicateObserver(observer, this.f38094a));
    }
}
