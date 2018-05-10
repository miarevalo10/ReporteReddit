package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;

public final class MaybeMap<T, R> extends AbstractMaybeWithUpstream<T, R> {
    final Function<? super T, ? extends R> f37924b;

    static final class MapMaybeObserver<T, R> implements MaybeObserver<T>, Disposable {
        final MaybeObserver<? super R> f31489a;
        final Function<? super T, ? extends R> f31490b;
        Disposable f31491c;

        MapMaybeObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, ? extends R> function) {
            this.f31489a = maybeObserver;
            this.f31490b = function;
        }

        public final void mo5626a() {
            Disposable disposable = this.f31491c;
            this.f31491c = DisposableHelper.f31095a;
            disposable.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f31491c.mo5627b();
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31491c, disposable)) {
                this.f31491c = disposable;
                this.f31489a.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            try {
                this.f31489a.onSuccess(ObjectHelper.m26573a(this.f31490b.apply(t), "The mapper returned a null item"));
            } catch (T t2) {
                Exceptions.m26521b(t2);
                this.f31489a.onError(t2);
            }
        }

        public final void onError(Throwable th) {
            this.f31489a.onError(th);
        }

        public final void onComplete() {
            this.f31489a.onComplete();
        }
    }

    public MaybeMap(MaybeSource<T> maybeSource, Function<? super T, ? extends R> function) {
        super(maybeSource);
        this.f37924b = function;
    }

    protected final void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        this.a.subscribe(new MapMaybeObserver(maybeObserver, this.f37924b));
    }
}
