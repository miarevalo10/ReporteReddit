package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.EmptyComponent;

public final class ObservableDetach<T> extends AbstractObservableWithUpstream<T, T> {

    static final class DetachObserver<T> implements Observer<T>, Disposable {
        Observer<? super T> f31748a;
        Disposable f31749b;

        DetachObserver(Observer<? super T> observer) {
            this.f31748a = observer;
        }

        public final void mo5626a() {
            Disposable disposable = this.f31749b;
            this.f31749b = EmptyComponent.f35937a;
            this.f31748a = EmptyComponent.m36014d();
            disposable.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f31749b.mo5627b();
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31749b, disposable)) {
                this.f31749b = disposable;
                this.f31748a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            this.f31748a.onNext(t);
        }

        public final void onError(Throwable th) {
            Observer observer = this.f31748a;
            this.f31749b = EmptyComponent.f35937a;
            this.f31748a = EmptyComponent.m36014d();
            observer.onError(th);
        }

        public final void onComplete() {
            Observer observer = this.f31748a;
            this.f31749b = EmptyComponent.f35937a;
            this.f31748a = EmptyComponent.m36014d();
            observer.onComplete();
        }
    }

    public ObservableDetach(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    protected final void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new DetachObserver(observer));
    }
}
