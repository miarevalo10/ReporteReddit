package io.reactivex.internal.operators.single;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.ResumeSingleObserver;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleDelayWithCompletable<T> extends Single<T> {
    final SingleSource<T> f35776a;
    final CompletableSource f35777b;

    static final class OtherObserver<T> extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
        final SingleObserver<? super T> f32320a;
        final SingleSource<T> f32321b;

        OtherObserver(SingleObserver<? super T> singleObserver, SingleSource<T> singleSource) {
            this.f32320a = singleObserver;
            this.f32321b = singleSource;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32092b(this, disposable) != null) {
                this.f32320a.onSubscribe(this);
            }
        }

        public final void onError(Throwable th) {
            this.f32320a.onError(th);
        }

        public final void onComplete() {
            this.f32321b.subscribe(new ResumeSingleObserver(this, this.f32320a));
        }

        public final void mo5626a() {
            DisposableHelper.m32090a((AtomicReference) this);
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) get());
        }
    }

    public SingleDelayWithCompletable(SingleSource<T> singleSource, CompletableSource completableSource) {
        this.f35776a = singleSource;
        this.f35777b = completableSource;
    }

    protected final void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f35777b.subscribe(new OtherObserver(singleObserver, this.f35776a));
    }
}
