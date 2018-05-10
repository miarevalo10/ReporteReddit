package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatten<T, R> extends AbstractMaybeWithUpstream<T, R> {
    final Function<? super T, ? extends MaybeSource<? extends R>> f37922b;

    static final class FlatMapMaybeObserver<T, R> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        final MaybeObserver<? super R> f31472a;
        final Function<? super T, ? extends MaybeSource<? extends R>> f31473b;
        Disposable f31474c;

        final class InnerObserver implements MaybeObserver<R> {
            final /* synthetic */ FlatMapMaybeObserver f31471a;

            InnerObserver(FlatMapMaybeObserver flatMapMaybeObserver) {
                this.f31471a = flatMapMaybeObserver;
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.m32092b(this.f31471a, disposable);
            }

            public final void onSuccess(R r) {
                this.f31471a.f31472a.onSuccess(r);
            }

            public final void onError(Throwable th) {
                this.f31471a.f31472a.onError(th);
            }

            public final void onComplete() {
                this.f31471a.f31472a.onComplete();
            }
        }

        FlatMapMaybeObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, ? extends MaybeSource<? extends R>> function) {
            this.f31472a = maybeObserver;
            this.f31473b = function;
        }

        public final void mo5626a() {
            DisposableHelper.m32090a((AtomicReference) this);
            this.f31474c.mo5626a();
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) get());
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31474c, disposable)) {
                this.f31474c = disposable;
                this.f31472a.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            try {
                MaybeSource maybeSource = (MaybeSource) ObjectHelper.m26573a(this.f31473b.apply(t), "The mapper returned a null MaybeSource");
                if (!mo5627b()) {
                    maybeSource.subscribe(new InnerObserver(this));
                }
            } catch (T t2) {
                Exceptions.m26521b(t2);
                this.f31472a.onError(t2);
            }
        }

        public final void onError(Throwable th) {
            this.f31472a.onError(th);
        }

        public final void onComplete() {
            this.f31472a.onComplete();
        }
    }

    public MaybeFlatten(MaybeSource<T> maybeSource, Function<? super T, ? extends MaybeSource<? extends R>> function) {
        super(maybeSource);
        this.f37922b = function;
    }

    protected final void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        this.a.subscribe(new FlatMapMaybeObserver(maybeObserver, this.f37922b));
    }
}
