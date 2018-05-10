package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableScan<T> extends AbstractObservableWithUpstream<T, T> {
    final BiFunction<T, T, T> f38068a;

    static final class ScanObserver<T> implements Observer<T>, Disposable {
        final Observer<? super T> f32066a;
        final BiFunction<T, T, T> f32067b;
        Disposable f32068c;
        T f32069d;
        boolean f32070e;

        ScanObserver(Observer<? super T> observer, BiFunction<T, T, T> biFunction) {
            this.f32066a = observer;
            this.f32067b = biFunction;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f32068c, disposable)) {
                this.f32068c = disposable;
                this.f32066a.onSubscribe(this);
            }
        }

        public final void mo5626a() {
            this.f32068c.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f32068c.mo5627b();
        }

        public final void onNext(T t) {
            if (!this.f32070e) {
                Observer observer = this.f32066a;
                Object obj = this.f32069d;
                if (obj == null) {
                    this.f32069d = t;
                    observer.onNext(t);
                    return;
                }
                try {
                    t = ObjectHelper.m26573a(this.f32067b.apply(obj, t), "The value returned by the accumulator is null");
                    this.f32069d = t;
                    observer.onNext(t);
                } catch (T t2) {
                    Exceptions.m26521b(t2);
                    this.f32068c.mo5626a();
                    onError(t2);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f32070e) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f32070e = true;
            this.f32066a.onError(th);
        }

        public final void onComplete() {
            if (!this.f32070e) {
                this.f32070e = true;
                this.f32066a.onComplete();
            }
        }
    }

    public ObservableScan(ObservableSource<T> observableSource, BiFunction<T, T, T> biFunction) {
        super(observableSource);
        this.f38068a = biFunction;
    }

    public final void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new ScanObserver(observer, this.f38068a));
    }
}
