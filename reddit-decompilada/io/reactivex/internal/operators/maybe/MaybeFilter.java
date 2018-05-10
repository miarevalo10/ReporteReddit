package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;

public final class MaybeFilter<T> extends AbstractMaybeWithUpstream<T, T> {
    final Predicate<? super T> f37916b;

    static final class FilterMaybeObserver<T> implements MaybeObserver<T>, Disposable {
        final MaybeObserver<? super T> f31444a;
        final Predicate<? super T> f31445b;
        Disposable f31446c;

        FilterMaybeObserver(MaybeObserver<? super T> maybeObserver, Predicate<? super T> predicate) {
            this.f31444a = maybeObserver;
            this.f31445b = predicate;
        }

        public final void mo5626a() {
            Disposable disposable = this.f31446c;
            this.f31446c = DisposableHelper.f31095a;
            disposable.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f31446c.mo5627b();
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31446c, disposable)) {
                this.f31446c = disposable;
                this.f31444a.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            try {
                if (this.f31445b.test(t)) {
                    this.f31444a.onSuccess(t);
                } else {
                    this.f31444a.onComplete();
                }
            } catch (T t2) {
                Exceptions.m26521b(t2);
                this.f31444a.onError(t2);
            }
        }

        public final void onError(Throwable th) {
            this.f31444a.onError(th);
        }

        public final void onComplete() {
            this.f31444a.onComplete();
        }
    }

    public MaybeFilter(MaybeSource<T> maybeSource, Predicate<? super T> predicate) {
        super(maybeSource);
        this.f37916b = predicate;
    }

    protected final void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.a.subscribe(new FilterMaybeObserver(maybeObserver, this.f37916b));
    }
}
