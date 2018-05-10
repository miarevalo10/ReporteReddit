package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatWithSingle<T> extends AbstractObservableWithUpstream<T, T> {
    final SingleSource<? extends T> f37975a;

    static final class ConcatWithObserver<T> extends AtomicReference<Disposable> implements Observer<T>, SingleObserver<T>, Disposable {
        final Observer<? super T> f31707a;
        SingleSource<? extends T> f31708b;
        boolean f31709c;

        ConcatWithObserver(Observer<? super T> observer, SingleSource<? extends T> singleSource) {
            this.f31707a = observer;
            this.f31708b = singleSource;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32092b(this, disposable) != null && this.f31709c == null) {
                this.f31707a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            this.f31707a.onNext(t);
        }

        public final void onSuccess(T t) {
            this.f31707a.onNext(t);
            this.f31707a.onComplete();
        }

        public final void onError(Throwable th) {
            this.f31707a.onError(th);
        }

        public final void onComplete() {
            this.f31709c = true;
            DisposableHelper.m32094c(this, null);
            SingleSource singleSource = this.f31708b;
            this.f31708b = null;
            singleSource.subscribe(this);
        }

        public final void mo5626a() {
            DisposableHelper.m32090a((AtomicReference) this);
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) get());
        }
    }

    public ObservableConcatWithSingle(Observable<T> observable, SingleSource<? extends T> singleSource) {
        super(observable);
        this.f37975a = singleSource;
    }

    protected final void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new ConcatWithObserver(observer, this.f37975a));
    }
}
