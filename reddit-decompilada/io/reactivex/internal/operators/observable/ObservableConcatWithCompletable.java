package io.reactivex.internal.operators.observable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatWithCompletable<T> extends AbstractObservableWithUpstream<T, T> {
    final CompletableSource f37973a;

    static final class ConcatWithObserver<T> extends AtomicReference<Disposable> implements CompletableObserver, Observer<T>, Disposable {
        final Observer<? super T> f31701a;
        CompletableSource f31702b;
        boolean f31703c;

        ConcatWithObserver(Observer<? super T> observer, CompletableSource completableSource) {
            this.f31701a = observer;
            this.f31702b = completableSource;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32092b(this, disposable) != null && this.f31703c == null) {
                this.f31701a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            this.f31701a.onNext(t);
        }

        public final void onError(Throwable th) {
            this.f31701a.onError(th);
        }

        public final void onComplete() {
            if (this.f31703c) {
                this.f31701a.onComplete();
                return;
            }
            this.f31703c = true;
            DisposableHelper.m32094c(this, null);
            CompletableSource completableSource = this.f31702b;
            this.f31702b = null;
            completableSource.subscribe(this);
        }

        public final void mo5626a() {
            DisposableHelper.m32090a((AtomicReference) this);
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) get());
        }
    }

    public ObservableConcatWithCompletable(Observable<T> observable, CompletableSource completableSource) {
        super(observable);
        this.f37973a = completableSource;
    }

    protected final void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new ConcatWithObserver(observer, this.f37973a));
    }
}
