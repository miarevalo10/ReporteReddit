package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class MaybeHide<T> extends AbstractMaybeWithUpstream<T, T> {

    static final class HideMaybeObserver<T> implements MaybeObserver<T>, Disposable {
        final MaybeObserver<? super T> f31479a;
        Disposable f31480b;

        HideMaybeObserver(MaybeObserver<? super T> maybeObserver) {
            this.f31479a = maybeObserver;
        }

        public final void mo5626a() {
            this.f31480b.mo5626a();
            this.f31480b = DisposableHelper.f31095a;
        }

        public final boolean mo5627b() {
            return this.f31480b.mo5627b();
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31480b, disposable)) {
                this.f31480b = disposable;
                this.f31479a.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            this.f31479a.onSuccess(t);
        }

        public final void onError(Throwable th) {
            this.f31479a.onError(th);
        }

        public final void onComplete() {
            this.f31479a.onComplete();
        }
    }

    public MaybeHide(MaybeSource<T> maybeSource) {
        super(maybeSource);
    }

    protected final void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.a.subscribe(new HideMaybeObserver(maybeObserver));
    }
}
