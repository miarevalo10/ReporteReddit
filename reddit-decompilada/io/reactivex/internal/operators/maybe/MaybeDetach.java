package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class MaybeDetach<T> extends AbstractMaybeWithUpstream<T, T> {

    static final class DetachMaybeObserver<T> implements MaybeObserver<T>, Disposable {
        MaybeObserver<? super T> f31427a;
        Disposable f31428b;

        DetachMaybeObserver(MaybeObserver<? super T> maybeObserver) {
            this.f31427a = maybeObserver;
        }

        public final void mo5626a() {
            this.f31427a = null;
            this.f31428b.mo5626a();
            this.f31428b = DisposableHelper.f31095a;
        }

        public final boolean mo5627b() {
            return this.f31428b.mo5627b();
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31428b, disposable)) {
                this.f31428b = disposable;
                this.f31427a.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            this.f31428b = DisposableHelper.f31095a;
            MaybeObserver maybeObserver = this.f31427a;
            if (maybeObserver != null) {
                this.f31427a = null;
                maybeObserver.onSuccess(t);
            }
        }

        public final void onError(Throwable th) {
            this.f31428b = DisposableHelper.f31095a;
            MaybeObserver maybeObserver = this.f31427a;
            if (maybeObserver != null) {
                this.f31427a = null;
                maybeObserver.onError(th);
            }
        }

        public final void onComplete() {
            this.f31428b = DisposableHelper.f31095a;
            MaybeObserver maybeObserver = this.f31427a;
            if (maybeObserver != null) {
                this.f31427a = null;
                maybeObserver.onComplete();
            }
        }
    }

    public MaybeDetach(MaybeSource<T> maybeSource) {
        super(maybeSource);
    }

    protected final void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.a.subscribe(new DetachMaybeObserver(maybeObserver));
    }
}
