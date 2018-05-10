package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class ObservableCollectSingle<T, U> extends Single<U> implements FuseToObservable<U> {
    final ObservableSource<T> f35640a;
    final Callable<? extends U> f35641b;
    final BiConsumer<? super U, ? super T> f35642c;

    static final class CollectObserver<T, U> implements Observer<T>, Disposable {
        final SingleObserver<? super U> f31631a;
        final BiConsumer<? super U, ? super T> f31632b;
        final U f31633c;
        Disposable f31634d;
        boolean f31635e;

        CollectObserver(SingleObserver<? super U> singleObserver, U u, BiConsumer<? super U, ? super T> biConsumer) {
            this.f31631a = singleObserver;
            this.f31632b = biConsumer;
            this.f31633c = u;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31634d, disposable)) {
                this.f31634d = disposable;
                this.f31631a.onSubscribe(this);
            }
        }

        public final void mo5626a() {
            this.f31634d.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f31634d.mo5627b();
        }

        public final void onNext(T t) {
            if (!this.f31635e) {
                try {
                    this.f31632b.mo4825a(this.f31633c, t);
                } catch (T t2) {
                    this.f31634d.mo5626a();
                    onError(t2);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f31635e) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f31635e = true;
            this.f31631a.onError(th);
        }

        public final void onComplete() {
            if (!this.f31635e) {
                this.f31635e = true;
                this.f31631a.onSuccess(this.f31633c);
            }
        }
    }

    public ObservableCollectSingle(ObservableSource<T> observableSource, Callable<? extends U> callable, BiConsumer<? super U, ? super T> biConsumer) {
        this.f35640a = observableSource;
        this.f35641b = callable;
        this.f35642c = biConsumer;
    }

    protected final void subscribeActual(SingleObserver<? super U> singleObserver) {
        try {
            this.f35640a.subscribe(new CollectObserver(singleObserver, ObjectHelper.m26573a(this.f35641b.call(), "The initialSupplier returned a null value"), this.f35642c));
        } catch (Throwable th) {
            EmptyDisposable.m38052a(th, (SingleObserver) singleObserver);
        }
    }

    public final Observable<U> mo6641a() {
        return RxJavaPlugins.m26742a(new ObservableCollect(this.f35640a, this.f35641b, this.f35642c));
    }
}
