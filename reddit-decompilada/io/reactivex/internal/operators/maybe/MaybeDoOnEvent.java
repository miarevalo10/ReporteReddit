package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.disposables.DisposableHelper;

public final class MaybeDoOnEvent<T> extends AbstractMaybeWithUpstream<T, T> {
    final BiConsumer<? super T, ? super Throwable> f37915b;

    static final class DoOnEventMaybeObserver<T> implements MaybeObserver<T>, Disposable {
        final MaybeObserver<? super T> f31435a;
        final BiConsumer<? super T, ? super Throwable> f31436b;
        Disposable f31437c;

        DoOnEventMaybeObserver(MaybeObserver<? super T> maybeObserver, BiConsumer<? super T, ? super Throwable> biConsumer) {
            this.f31435a = maybeObserver;
            this.f31436b = biConsumer;
        }

        public final void mo5626a() {
            this.f31437c.mo5626a();
            this.f31437c = DisposableHelper.f31095a;
        }

        public final boolean mo5627b() {
            return this.f31437c.mo5627b();
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31437c, disposable)) {
                this.f31437c = disposable;
                this.f31435a.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            this.f31437c = DisposableHelper.f31095a;
            try {
                this.f31436b.mo4825a(t, null);
                this.f31435a.onSuccess(t);
            } catch (T t2) {
                Exceptions.m26521b(t2);
                this.f31435a.onError(t2);
            }
        }

        public final void onError(Throwable th) {
            this.f31437c = DisposableHelper.f31095a;
            try {
                this.f31436b.mo4825a(null, th);
            } catch (Throwable th2) {
                Exceptions.m26521b(th2);
                th = new CompositeException(th, th2);
            }
            this.f31435a.onError(th);
        }

        public final void onComplete() {
            this.f31437c = DisposableHelper.f31095a;
            try {
                this.f31436b.mo4825a(null, null);
                this.f31435a.onComplete();
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                this.f31435a.onError(th);
            }
        }
    }

    public MaybeDoOnEvent(MaybeSource<T> maybeSource, BiConsumer<? super T, ? super Throwable> biConsumer) {
        super(maybeSource);
        this.f37915b = biConsumer;
    }

    protected final void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.a.subscribe(new DoOnEventMaybeObserver(maybeObserver, this.f37915b));
    }
}
