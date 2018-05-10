package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableTake<T> extends AbstractObservableWithUpstream<T, T> {
    final long f38085a;

    static final class TakeObserver<T> implements Observer<T>, Disposable {
        final Observer<? super T> f32164a;
        boolean f32165b;
        Disposable f32166c;
        long f32167d;

        TakeObserver(Observer<? super T> observer, long j) {
            this.f32164a = observer;
            this.f32167d = j;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f32166c, disposable)) {
                this.f32166c = disposable;
                if (this.f32167d == 0) {
                    this.f32165b = true;
                    disposable.mo5626a();
                    EmptyDisposable.m38048a(this.f32164a);
                    return;
                }
                this.f32164a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            if (!this.f32165b) {
                long j = this.f32167d;
                this.f32167d = j - 1;
                if (j > 0) {
                    Object obj = this.f32167d == 0 ? 1 : null;
                    this.f32164a.onNext(t);
                    if (obj != null) {
                        onComplete();
                    }
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f32165b) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f32165b = true;
            this.f32166c.mo5626a();
            this.f32164a.onError(th);
        }

        public final void onComplete() {
            if (!this.f32165b) {
                this.f32165b = true;
                this.f32166c.mo5626a();
                this.f32164a.onComplete();
            }
        }

        public final void mo5626a() {
            this.f32166c.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f32166c.mo5627b();
        }
    }

    public ObservableTake(ObservableSource<T> observableSource, long j) {
        super(observableSource);
        this.f38085a = j;
    }

    protected final void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new TakeObserver(observer, this.f38085a));
    }
}
