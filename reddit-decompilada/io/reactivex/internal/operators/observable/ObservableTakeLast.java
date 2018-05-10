package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;

public final class ObservableTakeLast<T> extends AbstractObservableWithUpstream<T, T> {
    final int f38086a;

    static final class TakeLastObserver<T> extends ArrayDeque<T> implements Observer<T>, Disposable {
        final Observer<? super T> f32168a;
        final int f32169b;
        Disposable f32170c;
        volatile boolean f32171d;

        TakeLastObserver(Observer<? super T> observer, int i) {
            this.f32168a = observer;
            this.f32169b = i;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f32170c, disposable)) {
                this.f32170c = disposable;
                this.f32168a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            if (this.f32169b == size()) {
                poll();
            }
            offer(t);
        }

        public final void onError(Throwable th) {
            this.f32168a.onError(th);
        }

        public final void onComplete() {
            Observer observer = this.f32168a;
            while (!this.f32171d) {
                Object poll = poll();
                if (poll == null) {
                    if (!this.f32171d) {
                        observer.onComplete();
                    }
                    return;
                }
                observer.onNext(poll);
            }
        }

        public final void mo5626a() {
            if (!this.f32171d) {
                this.f32171d = true;
                this.f32170c.mo5626a();
            }
        }

        public final boolean mo5627b() {
            return this.f32171d;
        }
    }

    public ObservableTakeLast(ObservableSource<T> observableSource, int i) {
        super(observableSource);
        this.f38086a = i;
    }

    public final void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new TakeLastObserver(observer, this.f38086a));
    }
}
