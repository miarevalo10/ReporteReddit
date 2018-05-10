package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

public final class MaybeToSingle<T> extends Single<T> {
    final MaybeSource<T> f35611a;
    final T f35612b;

    static final class ToSingleMaybeSubscriber<T> implements MaybeObserver<T>, Disposable {
        final SingleObserver<? super T> f31539a;
        final T f31540b;
        Disposable f31541c;

        ToSingleMaybeSubscriber(SingleObserver<? super T> singleObserver, T t) {
            this.f31539a = singleObserver;
            this.f31540b = t;
        }

        public final void mo5626a() {
            this.f31541c.mo5626a();
            this.f31541c = DisposableHelper.f31095a;
        }

        public final boolean mo5627b() {
            return this.f31541c.mo5627b();
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31541c, disposable)) {
                this.f31541c = disposable;
                this.f31539a.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            this.f31541c = DisposableHelper.f31095a;
            this.f31539a.onSuccess(t);
        }

        public final void onError(Throwable th) {
            this.f31541c = DisposableHelper.f31095a;
            this.f31539a.onError(th);
        }

        public final void onComplete() {
            this.f31541c = DisposableHelper.f31095a;
            if (this.f31540b != null) {
                this.f31539a.onSuccess(this.f31540b);
            } else {
                this.f31539a.onError(new NoSuchElementException("The MaybeSource is empty"));
            }
        }
    }

    public MaybeToSingle(MaybeSource<T> maybeSource, T t) {
        this.f35611a = maybeSource;
        this.f35612b = t;
    }

    protected final void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f35611a.subscribe(new ToSingleMaybeSubscriber(singleObserver, this.f35612b));
    }
}
