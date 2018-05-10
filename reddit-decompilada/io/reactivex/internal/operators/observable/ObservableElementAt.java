package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;

public final class ObservableElementAt<T> extends AbstractObservableWithUpstream<T, T> {
    final long f37996a;
    final T f37997b;
    final boolean f37998c;

    static final class ElementAtObserver<T> implements Observer<T>, Disposable {
        final Observer<? super T> f31757a;
        final long f31758b;
        final T f31759c;
        final boolean f31760d;
        Disposable f31761e;
        long f31762f;
        boolean f31763g;

        ElementAtObserver(Observer<? super T> observer, long j, T t, boolean z) {
            this.f31757a = observer;
            this.f31758b = j;
            this.f31759c = t;
            this.f31760d = z;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31761e, disposable)) {
                this.f31761e = disposable;
                this.f31757a.onSubscribe(this);
            }
        }

        public final void mo5626a() {
            this.f31761e.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f31761e.mo5627b();
        }

        public final void onNext(T t) {
            if (!this.f31763g) {
                long j = this.f31762f;
                if (j == this.f31758b) {
                    this.f31763g = true;
                    this.f31761e.mo5626a();
                    this.f31757a.onNext(t);
                    this.f31757a.onComplete();
                    return;
                }
                this.f31762f = j + 1;
            }
        }

        public final void onError(Throwable th) {
            if (this.f31763g) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f31763g = true;
            this.f31757a.onError(th);
        }

        public final void onComplete() {
            if (!this.f31763g) {
                this.f31763g = true;
                Object obj = this.f31759c;
                if (obj == null && this.f31760d) {
                    this.f31757a.onError(new NoSuchElementException());
                    return;
                }
                if (obj != null) {
                    this.f31757a.onNext(obj);
                }
                this.f31757a.onComplete();
            }
        }
    }

    public ObservableElementAt(ObservableSource<T> observableSource, long j, T t, boolean z) {
        super(observableSource);
        this.f37996a = j;
        this.f37997b = t;
        this.f37998c = z;
    }

    public final void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new ElementAtObserver(observer, this.f37996a, this.f37997b, this.f37998c));
    }
}
