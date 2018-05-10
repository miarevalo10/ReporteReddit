package io.reactivex.internal.operators.observable;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatWithMaybe<T> extends AbstractObservableWithUpstream<T, T> {
    final MaybeSource<? extends T> f37974a;

    static final class ConcatWithObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Observer<T>, Disposable {
        final Observer<? super T> f31704a;
        MaybeSource<? extends T> f31705b;
        boolean f31706c;

        ConcatWithObserver(Observer<? super T> observer, MaybeSource<? extends T> maybeSource) {
            this.f31704a = observer;
            this.f31705b = maybeSource;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32092b(this, disposable) != null && this.f31706c == null) {
                this.f31704a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            this.f31704a.onNext(t);
        }

        public final void onSuccess(T t) {
            this.f31704a.onNext(t);
            this.f31704a.onComplete();
        }

        public final void onError(Throwable th) {
            this.f31704a.onError(th);
        }

        public final void onComplete() {
            if (this.f31706c) {
                this.f31704a.onComplete();
                return;
            }
            this.f31706c = true;
            DisposableHelper.m32094c(this, null);
            MaybeSource maybeSource = this.f31705b;
            this.f31705b = null;
            maybeSource.subscribe(this);
        }

        public final void mo5626a() {
            DisposableHelper.m32090a((AtomicReference) this);
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) get());
        }
    }

    public ObservableConcatWithMaybe(Observable<T> observable, MaybeSource<? extends T> maybeSource) {
        super(observable);
        this.f37974a = maybeSource;
    }

    protected final void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new ConcatWithObserver(observer, this.f37974a));
    }
}
