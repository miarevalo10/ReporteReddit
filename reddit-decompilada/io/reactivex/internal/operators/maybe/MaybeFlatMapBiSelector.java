package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatMapBiSelector<T, U, R> extends AbstractMaybeWithUpstream<T, R> {
    final Function<? super T, ? extends MaybeSource<? extends U>> f37917b;
    final BiFunction<? super T, ? super U, ? extends R> f37918c;

    static final class FlatMapBiMainObserver<T, U, R> implements MaybeObserver<T>, Disposable {
        final Function<? super T, ? extends MaybeSource<? extends U>> f31453a;
        final InnerObserver<T, U, R> f31454b;

        static final class InnerObserver<T, U, R> extends AtomicReference<Disposable> implements MaybeObserver<U> {
            final MaybeObserver<? super R> f31450a;
            final BiFunction<? super T, ? super U, ? extends R> f31451b;
            T f31452c;

            InnerObserver(MaybeObserver<? super R> maybeObserver, BiFunction<? super T, ? super U, ? extends R> biFunction) {
                this.f31450a = maybeObserver;
                this.f31451b = biFunction;
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.m32092b(this, disposable);
            }

            public final void onSuccess(U u) {
                Object obj = this.f31452c;
                this.f31452c = null;
                try {
                    this.f31450a.onSuccess(ObjectHelper.m26573a(this.f31451b.apply(obj, u), "The resultSelector returned a null value"));
                } catch (U u2) {
                    Exceptions.m26521b(u2);
                    this.f31450a.onError(u2);
                }
            }

            public final void onError(Throwable th) {
                this.f31450a.onError(th);
            }

            public final void onComplete() {
                this.f31450a.onComplete();
            }
        }

        FlatMapBiMainObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, ? extends MaybeSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
            this.f31454b = new InnerObserver(maybeObserver, biFunction);
            this.f31453a = function;
        }

        public final void mo5626a() {
            DisposableHelper.m32090a(this.f31454b);
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) this.f31454b.get());
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32092b(this.f31454b, disposable) != null) {
                this.f31454b.f31450a.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            try {
                MaybeSource maybeSource = (MaybeSource) ObjectHelper.m26573a(this.f31453a.apply(t), "The mapper returned a null MaybeSource");
                if (DisposableHelper.m32094c(this.f31454b, null)) {
                    this.f31454b.f31452c = t;
                    maybeSource.subscribe(this.f31454b);
                }
            } catch (T t2) {
                Exceptions.m26521b(t2);
                this.f31454b.f31450a.onError(t2);
            }
        }

        public final void onError(Throwable th) {
            this.f31454b.f31450a.onError(th);
        }

        public final void onComplete() {
            this.f31454b.f31450a.onComplete();
        }
    }

    public MaybeFlatMapBiSelector(MaybeSource<T> maybeSource, Function<? super T, ? extends MaybeSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        super(maybeSource);
        this.f37917b = function;
        this.f37918c = biFunction;
    }

    protected final void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        this.a.subscribe(new FlatMapBiMainObserver(maybeObserver, this.f37917b, this.f37918c));
    }
}
