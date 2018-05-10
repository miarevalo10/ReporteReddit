package io.reactivex.internal.operators.single;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleFlatMapCompletable<T> extends Completable {
    final SingleSource<T> f35810a;
    final Function<? super T, ? extends CompletableSource> f35811b;

    static final class FlatMapCompletableObserver<T> extends AtomicReference<Disposable> implements CompletableObserver, SingleObserver<T>, Disposable {
        final CompletableObserver f32358a;
        final Function<? super T, ? extends CompletableSource> f32359b;

        FlatMapCompletableObserver(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function) {
            this.f32358a = completableObserver;
            this.f32359b = function;
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
                CompletableSource completableSource = (CompletableSource) ObjectHelper.m26573a(this.f32359b.apply(t), "The mapper returned a null CompletableSource");
                if (!mo5627b()) {
                    completableSource.subscribe(this);
                }
            } catch (T t2) {
                Exceptions.m26521b(t2);
                onError(t2);
            }
        }

        public final void onError(Throwable th) {
            this.f32358a.onError(th);
        }

        public final void onComplete() {
            this.f32358a.onComplete();
        }
    }

    public SingleFlatMapCompletable(SingleSource<T> singleSource, Function<? super T, ? extends CompletableSource> function) {
        this.f35810a = singleSource;
        this.f35811b = function;
    }

    protected final void subscribeActual(CompletableObserver completableObserver) {
        Object flatMapCompletableObserver = new FlatMapCompletableObserver(completableObserver, this.f35811b);
        completableObserver.onSubscribe(flatMapCompletableObserver);
        this.f35810a.subscribe(flatMapCompletableObserver);
    }
}
