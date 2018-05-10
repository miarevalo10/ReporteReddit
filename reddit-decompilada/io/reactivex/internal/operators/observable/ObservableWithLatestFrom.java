package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableWithLatestFrom<T, U, R> extends AbstractObservableWithUpstream<T, R> {
    final BiFunction<? super T, ? super U, ? extends R> f38128a;
    final ObservableSource<? extends U> f38129b;

    final class WithLastFrom implements Observer<U> {
        final /* synthetic */ ObservableWithLatestFrom f32272a;
        private final WithLatestFromObserver<T, U, R> f32273b;

        public final void onComplete() {
        }

        WithLastFrom(ObservableWithLatestFrom observableWithLatestFrom, WithLatestFromObserver<T, U, R> withLatestFromObserver) {
            this.f32272a = observableWithLatestFrom;
            this.f32273b = withLatestFromObserver;
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32092b(this.f32273b.f32277d, disposable);
        }

        public final void onNext(U u) {
            this.f32273b.lazySet(u);
        }

        public final void onError(Throwable th) {
            WithLatestFromObserver withLatestFromObserver = this.f32273b;
            DisposableHelper.m32090a(withLatestFromObserver.f32276c);
            withLatestFromObserver.f32274a.onError(th);
        }
    }

    static final class WithLatestFromObserver<T, U, R> extends AtomicReference<U> implements Observer<T>, Disposable {
        final Observer<? super R> f32274a;
        final BiFunction<? super T, ? super U, ? extends R> f32275b;
        final AtomicReference<Disposable> f32276c = new AtomicReference();
        final AtomicReference<Disposable> f32277d = new AtomicReference();

        WithLatestFromObserver(Observer<? super R> observer, BiFunction<? super T, ? super U, ? extends R> biFunction) {
            this.f32274a = observer;
            this.f32275b = biFunction;
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32092b(this.f32276c, disposable);
        }

        public final void onNext(T t) {
            Object obj = get();
            if (obj != null) {
                try {
                    this.f32274a.onNext(ObjectHelper.m26573a(this.f32275b.apply(t, obj), "The combiner returned a null value"));
                } catch (T t2) {
                    Exceptions.m26521b(t2);
                    mo5626a();
                    this.f32274a.onError(t2);
                }
            }
        }

        public final void onError(Throwable th) {
            DisposableHelper.m32090a(this.f32277d);
            this.f32274a.onError(th);
        }

        public final void onComplete() {
            DisposableHelper.m32090a(this.f32277d);
            this.f32274a.onComplete();
        }

        public final void mo5626a() {
            DisposableHelper.m32090a(this.f32276c);
            DisposableHelper.m32090a(this.f32277d);
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) this.f32276c.get());
        }
    }

    public ObservableWithLatestFrom(ObservableSource<T> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction, ObservableSource<? extends U> observableSource2) {
        super(observableSource);
        this.f38128a = biFunction;
        this.f38129b = observableSource2;
    }

    public final void subscribeActual(Observer<? super R> observer) {
        Object serializedObserver = new SerializedObserver(observer);
        observer = new WithLatestFromObserver(serializedObserver, this.f38128a);
        serializedObserver.onSubscribe(observer);
        this.f38129b.subscribe(new WithLastFrom(this, observer));
        this.source.subscribe(observer);
    }
}
