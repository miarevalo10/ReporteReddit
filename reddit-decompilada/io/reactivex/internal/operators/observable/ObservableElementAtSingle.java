package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;

public final class ObservableElementAtSingle<T> extends Single<T> implements FuseToObservable<T> {
    final ObservableSource<T> f35664a;
    final long f35665b;
    final T f35666c;

    static final class ElementAtObserver<T> implements Observer<T>, Disposable {
        final SingleObserver<? super T> f31769a;
        final long f31770b;
        final T f31771c;
        Disposable f31772d;
        long f31773e;
        boolean f31774f;

        ElementAtObserver(SingleObserver<? super T> singleObserver, long j, T t) {
            this.f31769a = singleObserver;
            this.f31770b = j;
            this.f31771c = t;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31772d, disposable)) {
                this.f31772d = disposable;
                this.f31769a.onSubscribe(this);
            }
        }

        public final void mo5626a() {
            this.f31772d.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f31772d.mo5627b();
        }

        public final void onNext(T t) {
            if (!this.f31774f) {
                long j = this.f31773e;
                if (j == this.f31770b) {
                    this.f31774f = true;
                    this.f31772d.mo5626a();
                    this.f31769a.onSuccess(t);
                    return;
                }
                this.f31773e = j + 1;
            }
        }

        public final void onError(Throwable th) {
            if (this.f31774f) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f31774f = true;
            this.f31769a.onError(th);
        }

        public final void onComplete() {
            if (!this.f31774f) {
                this.f31774f = true;
                Object obj = this.f31771c;
                if (obj != null) {
                    this.f31769a.onSuccess(obj);
                    return;
                }
                this.f31769a.onError(new NoSuchElementException());
            }
        }
    }

    public ObservableElementAtSingle(ObservableSource<T> observableSource, long j, T t) {
        this.f35664a = observableSource;
        this.f35665b = j;
        this.f35666c = t;
    }

    public final void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f35664a.subscribe(new ElementAtObserver(singleObserver, this.f35665b, this.f35666c));
    }

    public final Observable<T> mo6641a() {
        return RxJavaPlugins.m26742a(new ObservableElementAt(this.f35664a, this.f35665b, this.f35666c, true));
    }
}
