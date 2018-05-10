package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class ObservableScanSeed<T, R> extends AbstractObservableWithUpstream<T, R> {
    final BiFunction<R, ? super T, R> f38069a;
    final Callable<R> f38070b;

    static final class ScanSeedObserver<T, R> implements Observer<T>, Disposable {
        final Observer<? super R> f32071a;
        final BiFunction<R, ? super T, R> f32072b;
        R f32073c;
        Disposable f32074d;
        boolean f32075e;

        ScanSeedObserver(Observer<? super R> observer, BiFunction<R, ? super T, R> biFunction, R r) {
            this.f32071a = observer;
            this.f32072b = biFunction;
            this.f32073c = r;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f32074d, disposable)) {
                this.f32074d = disposable;
                this.f32071a.onSubscribe(this);
                this.f32071a.onNext(this.f32073c);
            }
        }

        public final void mo5626a() {
            this.f32074d.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f32074d.mo5627b();
        }

        public final void onNext(T t) {
            if (!this.f32075e) {
                try {
                    t = ObjectHelper.m26573a(this.f32072b.apply(this.f32073c, t), "The accumulator returned a null value");
                    this.f32073c = t;
                    this.f32071a.onNext(t);
                } catch (T t2) {
                    Exceptions.m26521b(t2);
                    this.f32074d.mo5626a();
                    onError(t2);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f32075e) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f32075e = true;
            this.f32071a.onError(th);
        }

        public final void onComplete() {
            if (!this.f32075e) {
                this.f32075e = true;
                this.f32071a.onComplete();
            }
        }
    }

    public ObservableScanSeed(ObservableSource<T> observableSource, Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        super(observableSource);
        this.f38069a = biFunction;
        this.f38070b = callable;
    }

    public final void subscribeActual(Observer<? super R> observer) {
        try {
            this.source.subscribe(new ScanSeedObserver(observer, this.f38069a, ObjectHelper.m26573a(this.f38070b.call(), "The seed supplied is null")));
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            EmptyDisposable.m38051a(th, (Observer) observer);
        }
    }
}
