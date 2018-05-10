package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableTakeWhile<T> extends AbstractObservableWithUpstream<T, T> {
    final Predicate<? super T> f38095a;

    static final class TakeWhileObserver<T> implements Observer<T>, Disposable {
        final Observer<? super T> f32195a;
        final Predicate<? super T> f32196b;
        Disposable f32197c;
        boolean f32198d;

        TakeWhileObserver(Observer<? super T> observer, Predicate<? super T> predicate) {
            this.f32195a = observer;
            this.f32196b = predicate;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f32197c, disposable)) {
                this.f32197c = disposable;
                this.f32195a.onSubscribe(this);
            }
        }

        public final void mo5626a() {
            this.f32197c.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f32197c.mo5627b();
        }

        public final void onNext(T t) {
            if (!this.f32198d) {
                try {
                    if (this.f32196b.test(t)) {
                        this.f32195a.onNext(t);
                        return;
                    }
                    this.f32198d = true;
                    this.f32197c.mo5626a();
                    this.f32195a.onComplete();
                } catch (T t2) {
                    Exceptions.m26521b(t2);
                    this.f32197c.mo5626a();
                    onError(t2);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f32198d) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f32198d = true;
            this.f32195a.onError(th);
        }

        public final void onComplete() {
            if (!this.f32198d) {
                this.f32198d = true;
                this.f32195a.onComplete();
            }
        }
    }

    public ObservableTakeWhile(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.f38095a = predicate;
    }

    public final void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new TakeWhileObserver(observer, this.f38095a));
    }
}
