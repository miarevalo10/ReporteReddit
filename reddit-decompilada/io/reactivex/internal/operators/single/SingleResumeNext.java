package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.ResumeSingleObserver;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleResumeNext<T> extends Single<T> {
    final SingleSource<? extends T> f35838a;
    final Function<? super Throwable, ? extends SingleSource<? extends T>> f35839b;

    static final class ResumeMainSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
        final SingleObserver<? super T> f32378a;
        final Function<? super Throwable, ? extends SingleSource<? extends T>> f32379b;

        ResumeMainSingleObserver(SingleObserver<? super T> singleObserver, Function<? super Throwable, ? extends SingleSource<? extends T>> function) {
            this.f32378a = singleObserver;
            this.f32379b = function;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32092b(this, disposable) != null) {
                this.f32378a.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            this.f32378a.onSuccess(t);
        }

        public final void onError(Throwable th) {
            try {
                ((SingleSource) ObjectHelper.m26573a(this.f32379b.apply(th), "The nextFunction returned a null SingleSource.")).subscribe(new ResumeSingleObserver(this, this.f32378a));
            } catch (Throwable th2) {
                Exceptions.m26521b(th2);
                this.f32378a.onError(new CompositeException(th, th2));
            }
        }

        public final void mo5626a() {
            DisposableHelper.m32090a((AtomicReference) this);
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) get());
        }
    }

    public SingleResumeNext(SingleSource<? extends T> singleSource, Function<? super Throwable, ? extends SingleSource<? extends T>> function) {
        this.f35838a = singleSource;
        this.f35839b = function;
    }

    protected final void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f35838a.subscribe(new ResumeMainSingleObserver(singleObserver, this.f35839b));
    }
}
