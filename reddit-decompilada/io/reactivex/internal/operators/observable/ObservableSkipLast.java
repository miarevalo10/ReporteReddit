package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;

public final class ObservableSkipLast<T> extends AbstractObservableWithUpstream<T, T> {
    final int f38072a;

    static final class SkipLastObserver<T> extends ArrayDeque<T> implements Observer<T>, Disposable {
        final Observer<? super T> f32116a;
        final int f32117b;
        Disposable f32118c;

        SkipLastObserver(Observer<? super T> observer, int i) {
            super(i);
            this.f32116a = observer;
            this.f32117b = i;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f32118c, disposable)) {
                this.f32118c = disposable;
                this.f32116a.onSubscribe(this);
            }
        }

        public final void mo5626a() {
            this.f32118c.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f32118c.mo5627b();
        }

        public final void onNext(T t) {
            if (this.f32117b == size()) {
                this.f32116a.onNext(poll());
            }
            offer(t);
        }

        public final void onError(Throwable th) {
            this.f32116a.onError(th);
        }

        public final void onComplete() {
            this.f32116a.onComplete();
        }
    }

    public ObservableSkipLast(ObservableSource<T> observableSource, int i) {
        super(observableSource);
        this.f38072a = i;
    }

    public final void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new SkipLastObserver(observer, this.f38072a));
    }
}
