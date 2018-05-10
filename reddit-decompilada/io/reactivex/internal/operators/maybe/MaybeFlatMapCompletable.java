package io.reactivex.internal.operators.maybe;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatMapCompletable<T> extends Completable {
    final MaybeSource<T> f35575a;
    final Function<? super T, ? extends CompletableSource> f35576b;

    static final class FlatMapCompletableObserver<T> extends AtomicReference<Disposable> implements CompletableObserver, MaybeObserver<T>, Disposable {
        final CompletableObserver f31455a;
        final Function<? super T, ? extends CompletableSource> f31456b;

        FlatMapCompletableObserver(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function) {
            this.f31455a = completableObserver;
            this.f31456b = function;
        }

        public final void mo5626a() {
            DisposableHelper.m32090a((AtomicReference) this);
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) get());
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32094c(this, disposable);
        }

        public final void onSuccess(T t) {
            try {
                CompletableSource completableSource = (CompletableSource) ObjectHelper.m26573a(this.f31456b.apply(t), "The mapper returned a null CompletableSource");
                if (!mo5627b()) {
                    completableSource.subscribe(this);
                }
            } catch (T t2) {
                Exceptions.m26521b(t2);
                onError(t2);
            }
        }

        public final void onError(Throwable th) {
            this.f31455a.onError(th);
        }

        public final void onComplete() {
            this.f31455a.onComplete();
        }
    }

    public MaybeFlatMapCompletable(MaybeSource<T> maybeSource, Function<? super T, ? extends CompletableSource> function) {
        this.f35575a = maybeSource;
        this.f35576b = function;
    }

    protected final void subscribeActual(CompletableObserver completableObserver) {
        Object flatMapCompletableObserver = new FlatMapCompletableObserver(completableObserver, this.f35576b);
        completableObserver.onSubscribe(flatMapCompletableObserver);
        this.f35575a.subscribe(flatMapCompletableObserver);
    }
}
