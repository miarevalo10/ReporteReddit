package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class MaybeFromSingle<T> extends Maybe<T> {
    final SingleSource<T> f35592a;

    static final class FromSingleObserver<T> implements SingleObserver<T>, Disposable {
        final MaybeObserver<? super T> f31477a;
        Disposable f31478b;

        FromSingleObserver(MaybeObserver<? super T> maybeObserver) {
            this.f31477a = maybeObserver;
        }

        public final void mo5626a() {
            this.f31478b.mo5626a();
            this.f31478b = DisposableHelper.f31095a;
        }

        public final boolean mo5627b() {
            return this.f31478b.mo5627b();
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31478b, disposable)) {
                this.f31478b = disposable;
                this.f31477a.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            this.f31478b = DisposableHelper.f31095a;
            this.f31477a.onSuccess(t);
        }

        public final void onError(Throwable th) {
            this.f31478b = DisposableHelper.f31095a;
            this.f31477a.onError(th);
        }
    }

    public MaybeFromSingle(SingleSource<T> singleSource) {
        this.f35592a = singleSource;
    }

    protected final void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f35592a.subscribe(new FromSingleObserver(maybeObserver));
    }
}
