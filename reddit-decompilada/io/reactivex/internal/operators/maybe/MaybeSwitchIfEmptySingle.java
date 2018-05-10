package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeSwitchIfEmptySingle<T> extends Single<T> {
    final MaybeSource<T> f35602a;
    final SingleSource<? extends T> f35603b;

    static final class SwitchIfEmptyMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        final SingleObserver<? super T> f31518a;
        final SingleSource<? extends T> f31519b;

        static final class OtherSingleObserver<T> implements SingleObserver<T> {
            final SingleObserver<? super T> f31516a;
            final AtomicReference<Disposable> f31517b;

            OtherSingleObserver(SingleObserver<? super T> singleObserver, AtomicReference<Disposable> atomicReference) {
                this.f31516a = singleObserver;
                this.f31517b = atomicReference;
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.m32092b(this.f31517b, disposable);
            }

            public final void onSuccess(T t) {
                this.f31516a.onSuccess(t);
            }

            public final void onError(Throwable th) {
                this.f31516a.onError(th);
            }
        }

        SwitchIfEmptyMaybeObserver(SingleObserver<? super T> singleObserver, SingleSource<? extends T> singleSource) {
            this.f31518a = singleObserver;
            this.f31519b = singleSource;
        }

        public final void mo5626a() {
            DisposableHelper.m32090a((AtomicReference) this);
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) get());
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32092b(this, disposable) != null) {
                this.f31518a.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            this.f31518a.onSuccess(t);
        }

        public final void onError(Throwable th) {
            this.f31518a.onError(th);
        }

        public final void onComplete() {
            Disposable disposable = (Disposable) get();
            if (disposable != DisposableHelper.f31095a && compareAndSet(disposable, null)) {
                this.f31519b.subscribe(new OtherSingleObserver(this.f31518a, this));
            }
        }
    }

    public MaybeSwitchIfEmptySingle(MaybeSource<T> maybeSource, SingleSource<? extends T> singleSource) {
        this.f35602a = maybeSource;
        this.f35603b = singleSource;
    }

    protected final void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f35602a.subscribe(new SwitchIfEmptyMaybeObserver(singleObserver, this.f35603b));
    }
}
