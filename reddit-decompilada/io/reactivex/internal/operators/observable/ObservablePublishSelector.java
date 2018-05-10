package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservablePublishSelector<T, R> extends AbstractObservableWithUpstream<T, R> {
    final Function<? super Observable<T>, ? extends ObservableSource<R>> f38041a;

    static final class SourceObserver<T, R> implements Observer<T> {
        final PublishSubject<T> f31978a;
        final AtomicReference<Disposable> f31979b;

        SourceObserver(PublishSubject<T> publishSubject, AtomicReference<Disposable> atomicReference) {
            this.f31978a = publishSubject;
            this.f31979b = atomicReference;
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32092b(this.f31979b, disposable);
        }

        public final void onNext(T t) {
            this.f31978a.onNext(t);
        }

        public final void onError(Throwable th) {
            this.f31978a.onError(th);
        }

        public final void onComplete() {
            this.f31978a.onComplete();
        }
    }

    static final class TargetObserver<T, R> extends AtomicReference<Disposable> implements Observer<R>, Disposable {
        final Observer<? super R> f31980a;
        Disposable f31981b;

        TargetObserver(Observer<? super R> observer) {
            this.f31980a = observer;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31981b, disposable)) {
                this.f31981b = disposable;
                this.f31980a.onSubscribe(this);
            }
        }

        public final void onNext(R r) {
            this.f31980a.onNext(r);
        }

        public final void onError(Throwable th) {
            DisposableHelper.m32090a((AtomicReference) this);
            this.f31980a.onError(th);
        }

        public final void onComplete() {
            DisposableHelper.m32090a((AtomicReference) this);
            this.f31980a.onComplete();
        }

        public final void mo5626a() {
            this.f31981b.mo5626a();
            DisposableHelper.m32090a((AtomicReference) this);
        }

        public final boolean mo5627b() {
            return this.f31981b.mo5627b();
        }
    }

    public ObservablePublishSelector(ObservableSource<T> observableSource, Function<? super Observable<T>, ? extends ObservableSource<R>> function) {
        super(observableSource);
        this.f38041a = function;
    }

    protected final void subscribeActual(Observer<? super R> observer) {
        PublishSubject create = PublishSubject.create();
        try {
            ObservableSource observableSource = (ObservableSource) ObjectHelper.m26573a(this.f38041a.apply(create), "The selector returned a null ObservableSource");
            Object targetObserver = new TargetObserver(observer);
            observableSource.subscribe(targetObserver);
            this.source.subscribe(new SourceObserver(create, targetObserver));
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            EmptyDisposable.m38051a(th, (Observer) observer);
        }
    }
}
