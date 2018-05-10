package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;

public final class ObservableSkipUntil<T, U> extends AbstractObservableWithUpstream<T, T> {
    final ObservableSource<U> f38078a;

    final class SkipUntil implements Observer<U> {
        Disposable f32129a;
        final /* synthetic */ ObservableSkipUntil f32130b;
        private final ArrayCompositeDisposable f32131c;
        private final SkipUntilObserver<T> f32132d;
        private final SerializedObserver<T> f32133e;

        SkipUntil(ObservableSkipUntil observableSkipUntil, ArrayCompositeDisposable arrayCompositeDisposable, SkipUntilObserver<T> skipUntilObserver, SerializedObserver<T> serializedObserver) {
            this.f32130b = observableSkipUntil;
            this.f32131c = arrayCompositeDisposable;
            this.f32132d = skipUntilObserver;
            this.f32133e = serializedObserver;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f32129a, disposable)) {
                this.f32129a = disposable;
                this.f32131c.m32086a(1, disposable);
            }
        }

        public final void onNext(U u) {
            this.f32129a.mo5626a();
            this.f32132d.f32137d = true;
        }

        public final void onError(Throwable th) {
            this.f32131c.mo5626a();
            this.f32133e.onError(th);
        }

        public final void onComplete() {
            this.f32132d.f32137d = true;
        }
    }

    static final class SkipUntilObserver<T> implements Observer<T> {
        final Observer<? super T> f32134a;
        final ArrayCompositeDisposable f32135b;
        Disposable f32136c;
        volatile boolean f32137d;
        boolean f32138e;

        SkipUntilObserver(Observer<? super T> observer, ArrayCompositeDisposable arrayCompositeDisposable) {
            this.f32134a = observer;
            this.f32135b = arrayCompositeDisposable;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f32136c, disposable)) {
                this.f32136c = disposable;
                this.f32135b.m32086a(0, disposable);
            }
        }

        public final void onNext(T t) {
            if (this.f32138e) {
                this.f32134a.onNext(t);
                return;
            }
            if (this.f32137d) {
                this.f32138e = true;
                this.f32134a.onNext(t);
            }
        }

        public final void onError(Throwable th) {
            this.f32135b.mo5626a();
            this.f32134a.onError(th);
        }

        public final void onComplete() {
            this.f32135b.mo5626a();
            this.f32134a.onComplete();
        }
    }

    public ObservableSkipUntil(ObservableSource<T> observableSource, ObservableSource<U> observableSource2) {
        super(observableSource);
        this.f38078a = observableSource2;
    }

    public final void subscribeActual(Observer<? super T> observer) {
        Object serializedObserver = new SerializedObserver(observer);
        observer = new ArrayCompositeDisposable();
        serializedObserver.onSubscribe(observer);
        Observer skipUntilObserver = new SkipUntilObserver(serializedObserver, observer);
        this.f38078a.subscribe(new SkipUntil(this, observer, skipUntilObserver, serializedObserver));
        this.source.subscribe(skipUntilObserver);
    }
}
