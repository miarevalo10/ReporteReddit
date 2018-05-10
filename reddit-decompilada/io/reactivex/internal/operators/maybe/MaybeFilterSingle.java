package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;

public final class MaybeFilterSingle<T> extends Maybe<T> {
    final SingleSource<T> f35573a;
    final Predicate<? super T> f35574b;

    static final class FilterMaybeObserver<T> implements SingleObserver<T>, Disposable {
        final MaybeObserver<? super T> f31447a;
        final Predicate<? super T> f31448b;
        Disposable f31449c;

        FilterMaybeObserver(MaybeObserver<? super T> maybeObserver, Predicate<? super T> predicate) {
            this.f31447a = maybeObserver;
            this.f31448b = predicate;
        }

        public final void mo5626a() {
            Disposable disposable = this.f31449c;
            this.f31449c = DisposableHelper.f31095a;
            disposable.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f31449c.mo5627b();
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31449c, disposable)) {
                this.f31449c = disposable;
                this.f31447a.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            try {
                if (this.f31448b.test(t)) {
                    this.f31447a.onSuccess(t);
                } else {
                    this.f31447a.onComplete();
                }
            } catch (T t2) {
                Exceptions.m26521b(t2);
                this.f31447a.onError(t2);
            }
        }

        public final void onError(Throwable th) {
            this.f31447a.onError(th);
        }
    }

    public MaybeFilterSingle(SingleSource<T> singleSource, Predicate<? super T> predicate) {
        this.f35573a = singleSource;
        this.f35574b = predicate;
    }

    protected final void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f35573a.subscribe(new FilterMaybeObserver(maybeObserver, this.f35574b));
    }
}
