package io.reactivex.internal.operators.observable;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class ObservableLastMaybe<T> extends Maybe<T> {
    final ObservableSource<T> f35697a;

    static final class LastObserver<T> implements Observer<T>, Disposable {
        final MaybeObserver<? super T> f31920a;
        Disposable f31921b;
        T f31922c;

        LastObserver(MaybeObserver<? super T> maybeObserver) {
            this.f31920a = maybeObserver;
        }

        public final void mo5626a() {
            this.f31921b.mo5626a();
            this.f31921b = DisposableHelper.f31095a;
        }

        public final boolean mo5627b() {
            return this.f31921b == DisposableHelper.f31095a;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31921b, disposable)) {
                this.f31921b = disposable;
                this.f31920a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            this.f31922c = t;
        }

        public final void onError(Throwable th) {
            this.f31921b = DisposableHelper.f31095a;
            this.f31922c = null;
            this.f31920a.onError(th);
        }

        public final void onComplete() {
            this.f31921b = DisposableHelper.f31095a;
            Object obj = this.f31922c;
            if (obj != null) {
                this.f31922c = null;
                this.f31920a.onSuccess(obj);
                return;
            }
            this.f31920a.onComplete();
        }
    }

    public ObservableLastMaybe(ObservableSource<T> observableSource) {
        this.f35697a = observableSource;
    }

    protected final void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f35697a.subscribe(new LastObserver(maybeObserver));
    }
}
