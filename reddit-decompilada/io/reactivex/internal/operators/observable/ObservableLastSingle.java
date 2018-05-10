package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

public final class ObservableLastSingle<T> extends Single<T> {
    final ObservableSource<T> f35698a;
    final T f35699b;

    static final class LastObserver<T> implements Observer<T>, Disposable {
        final SingleObserver<? super T> f31923a;
        final T f31924b;
        Disposable f31925c;
        T f31926d;

        LastObserver(SingleObserver<? super T> singleObserver, T t) {
            this.f31923a = singleObserver;
            this.f31924b = t;
        }

        public final void mo5626a() {
            this.f31925c.mo5626a();
            this.f31925c = DisposableHelper.f31095a;
        }

        public final boolean mo5627b() {
            return this.f31925c == DisposableHelper.f31095a;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31925c, disposable)) {
                this.f31925c = disposable;
                this.f31923a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            this.f31926d = t;
        }

        public final void onError(Throwable th) {
            this.f31925c = DisposableHelper.f31095a;
            this.f31926d = null;
            this.f31923a.onError(th);
        }

        public final void onComplete() {
            this.f31925c = DisposableHelper.f31095a;
            Object obj = this.f31926d;
            if (obj != null) {
                this.f31926d = null;
                this.f31923a.onSuccess(obj);
                return;
            }
            obj = this.f31924b;
            if (obj != null) {
                this.f31923a.onSuccess(obj);
            } else {
                this.f31923a.onError(new NoSuchElementException());
            }
        }
    }

    public ObservableLastSingle(ObservableSource<T> observableSource, T t) {
        this.f35698a = observableSource;
        this.f35699b = t;
    }

    protected final void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f35698a.subscribe(new LastObserver(singleObserver, this.f35699b));
    }
}
