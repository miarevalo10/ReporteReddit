package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatMapNotification<T, R> extends AbstractMaybeWithUpstream<T, R> {
    final Function<? super T, ? extends MaybeSource<? extends R>> f37919b;
    final Function<? super Throwable, ? extends MaybeSource<? extends R>> f37920c;
    final Callable<? extends MaybeSource<? extends R>> f37921d;

    static final class FlatMapMaybeObserver<T, R> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        final MaybeObserver<? super R> f31458a;
        final Function<? super T, ? extends MaybeSource<? extends R>> f31459b;
        final Function<? super Throwable, ? extends MaybeSource<? extends R>> f31460c;
        final Callable<? extends MaybeSource<? extends R>> f31461d;
        Disposable f31462e;

        final class InnerObserver implements MaybeObserver<R> {
            final /* synthetic */ FlatMapMaybeObserver f31457a;

            InnerObserver(FlatMapMaybeObserver flatMapMaybeObserver) {
                this.f31457a = flatMapMaybeObserver;
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.m32092b(this.f31457a, disposable);
            }

            public final void onSuccess(R r) {
                this.f31457a.f31458a.onSuccess(r);
            }

            public final void onError(Throwable th) {
                this.f31457a.f31458a.onError(th);
            }

            public final void onComplete() {
                this.f31457a.f31458a.onComplete();
            }
        }

        FlatMapMaybeObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, ? extends MaybeSource<? extends R>> function, Function<? super Throwable, ? extends MaybeSource<? extends R>> function2, Callable<? extends MaybeSource<? extends R>> callable) {
            this.f31458a = maybeObserver;
            this.f31459b = function;
            this.f31460c = function2;
            this.f31461d = callable;
        }

        public final void mo5626a() {
            DisposableHelper.m32090a((AtomicReference) this);
            this.f31462e.mo5626a();
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) get());
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31462e, disposable)) {
                this.f31462e = disposable;
                this.f31458a.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            try {
                ((MaybeSource) ObjectHelper.m26573a(this.f31459b.apply(t), "The onSuccessMapper returned a null MaybeSource")).subscribe(new InnerObserver(this));
            } catch (T t2) {
                Exceptions.m26521b(t2);
                this.f31458a.onError(t2);
            }
        }

        public final void onError(Throwable th) {
            try {
                ((MaybeSource) ObjectHelper.m26573a(this.f31460c.apply(th), "The onErrorMapper returned a null MaybeSource")).subscribe(new InnerObserver(this));
            } catch (Throwable e) {
                Exceptions.m26521b(e);
                this.f31458a.onError(new CompositeException(th, e));
            }
        }

        public final void onComplete() {
            try {
                ((MaybeSource) ObjectHelper.m26573a(this.f31461d.call(), "The onCompleteSupplier returned a null MaybeSource")).subscribe(new InnerObserver(this));
            } catch (Throwable e) {
                Exceptions.m26521b(e);
                this.f31458a.onError(e);
            }
        }
    }

    public MaybeFlatMapNotification(MaybeSource<T> maybeSource, Function<? super T, ? extends MaybeSource<? extends R>> function, Function<? super Throwable, ? extends MaybeSource<? extends R>> function2, Callable<? extends MaybeSource<? extends R>> callable) {
        super(maybeSource);
        this.f37919b = function;
        this.f37920c = function2;
        this.f37921d = callable;
    }

    protected final void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        this.a.subscribe(new FlatMapMaybeObserver(maybeObserver, this.f37919b, this.f37920c, this.f37921d));
    }
}
