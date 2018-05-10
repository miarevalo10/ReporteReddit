package io.reactivex.internal.operators.single;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class SingleToObservable<T> extends Observable<T> {
    final SingleSource<? extends T> f35854a;

    static final class SingleToObservableObserver<T> implements SingleObserver<T>, Disposable {
        final Observer<? super T> f32391a;
        Disposable f32392b;

        SingleToObservableObserver(Observer<? super T> observer) {
            this.f32391a = observer;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f32392b, disposable)) {
                this.f32392b = disposable;
                this.f32391a.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            this.f32391a.onNext(t);
            this.f32391a.onComplete();
        }

        public final void onError(Throwable th) {
            this.f32391a.onError(th);
        }

        public final void mo5626a() {
            this.f32392b.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f32392b.mo5627b();
        }
    }

    public SingleToObservable(SingleSource<? extends T> singleSource) {
        this.f35854a = singleSource;
    }

    public final void subscribeActual(Observer<? super T> observer) {
        this.f35854a.subscribe(new SingleToObservableObserver(observer));
    }
}
