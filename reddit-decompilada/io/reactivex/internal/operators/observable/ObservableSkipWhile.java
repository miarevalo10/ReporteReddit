package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;

public final class ObservableSkipWhile<T> extends AbstractObservableWithUpstream<T, T> {
    final Predicate<? super T> f38079a;

    static final class SkipWhileObserver<T> implements Observer<T>, Disposable {
        final Observer<? super T> f32139a;
        final Predicate<? super T> f32140b;
        Disposable f32141c;
        boolean f32142d;

        SkipWhileObserver(Observer<? super T> observer, Predicate<? super T> predicate) {
            this.f32139a = observer;
            this.f32140b = predicate;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f32141c, disposable)) {
                this.f32141c = disposable;
                this.f32139a.onSubscribe(this);
            }
        }

        public final void mo5626a() {
            this.f32141c.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f32141c.mo5627b();
        }

        public final void onNext(T t) {
            if (this.f32142d) {
                this.f32139a.onNext(t);
                return;
            }
            try {
                if (!this.f32140b.test(t)) {
                    this.f32142d = true;
                    this.f32139a.onNext(t);
                }
            } catch (T t2) {
                Exceptions.m26521b(t2);
                this.f32141c.mo5626a();
                this.f32139a.onError(t2);
            }
        }

        public final void onError(Throwable th) {
            this.f32139a.onError(th);
        }

        public final void onComplete() {
            this.f32139a.onComplete();
        }
    }

    public ObservableSkipWhile(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.f38079a = predicate;
    }

    public final void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new SkipWhileObserver(observer, this.f38079a));
    }
}
