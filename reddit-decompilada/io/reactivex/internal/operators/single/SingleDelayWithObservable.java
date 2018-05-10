package io.reactivex.internal.operators.single;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.ResumeSingleObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleDelayWithObservable<T, U> extends Single<T> {
    final SingleSource<T> f35778a;
    final ObservableSource<U> f35779b;

    static final class OtherSubscriber<T, U> extends AtomicReference<Disposable> implements Observer<U>, Disposable {
        final SingleObserver<? super T> f32322a;
        final SingleSource<T> f32323b;
        boolean f32324c;

        OtherSubscriber(SingleObserver<? super T> singleObserver, SingleSource<T> singleSource) {
            this.f32322a = singleObserver;
            this.f32323b = singleSource;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32091a((AtomicReference) this, disposable) != null) {
                this.f32322a.onSubscribe(this);
            }
        }

        public final void onNext(U u) {
            ((Disposable) get()).mo5626a();
            onComplete();
        }

        public final void onError(Throwable th) {
            if (this.f32324c) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f32324c = true;
            this.f32322a.onError(th);
        }

        public final void onComplete() {
            if (!this.f32324c) {
                this.f32324c = true;
                this.f32323b.subscribe(new ResumeSingleObserver(this, this.f32322a));
            }
        }

        public final void mo5626a() {
            DisposableHelper.m32090a((AtomicReference) this);
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) get());
        }
    }

    public SingleDelayWithObservable(SingleSource<T> singleSource, ObservableSource<U> observableSource) {
        this.f35778a = singleSource;
        this.f35779b = observableSource;
    }

    protected final void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f35779b.subscribe(new OtherSubscriber(singleObserver, this.f35778a));
    }
}
