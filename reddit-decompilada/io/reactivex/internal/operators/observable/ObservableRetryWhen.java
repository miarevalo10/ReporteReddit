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
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableRetryWhen<T> extends AbstractObservableWithUpstream<T, T> {
    final Function<? super Observable<Throwable>, ? extends ObservableSource<?>> f38059a;

    static final class RepeatWhenObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        final Observer<? super T> f32047a;
        final AtomicInteger f32048b = new AtomicInteger();
        final AtomicThrowable f32049c = new AtomicThrowable();
        final Subject<Throwable> f32050d;
        final InnerRepeatObserver f32051e = new InnerRepeatObserver(this);
        final AtomicReference<Disposable> f32052f = new AtomicReference();
        final ObservableSource<T> f32053g;
        volatile boolean f32054h;

        final class InnerRepeatObserver extends AtomicReference<Disposable> implements Observer<Object> {
            final /* synthetic */ RepeatWhenObserver f32046a;

            InnerRepeatObserver(RepeatWhenObserver repeatWhenObserver) {
                this.f32046a = repeatWhenObserver;
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.m32092b(this, disposable);
            }

            public final void onNext(Object obj) {
                this.f32046a.m32578c();
            }

            public final void onError(Throwable th) {
                AtomicInteger atomicInteger = this.f32046a;
                DisposableHelper.m32090a(atomicInteger.f32052f);
                HalfSerializer.m26687a(atomicInteger.f32047a, th, atomicInteger, atomicInteger.f32049c);
            }

            public final void onComplete() {
                AtomicInteger atomicInteger = this.f32046a;
                DisposableHelper.m32090a(atomicInteger.f32052f);
                HalfSerializer.m26688a(atomicInteger.f32047a, atomicInteger, atomicInteger.f32049c);
            }
        }

        RepeatWhenObserver(Observer<? super T> observer, Subject<Throwable> subject, ObservableSource<T> observableSource) {
            this.f32047a = observer;
            this.f32050d = subject;
            this.f32053g = observableSource;
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32094c(this.f32052f, disposable);
        }

        public final void onNext(T t) {
            HalfSerializer.m26686a(this.f32047a, (Object) t, (AtomicInteger) this, this.f32049c);
        }

        public final void onError(Throwable th) {
            this.f32054h = false;
            this.f32050d.onNext(th);
        }

        public final void onComplete() {
            DisposableHelper.m32090a(this.f32051e);
            HalfSerializer.m26688a(this.f32047a, (AtomicInteger) this, this.f32049c);
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) this.f32052f.get());
        }

        public final void mo5626a() {
            DisposableHelper.m32090a(this.f32052f);
            DisposableHelper.m32090a(this.f32051e);
        }

        final void m32578c() {
            if (this.f32048b.getAndIncrement() == 0) {
                while (!mo5627b()) {
                    if (!this.f32054h) {
                        this.f32054h = true;
                        this.f32053g.subscribe(this);
                    }
                    if (this.f32048b.decrementAndGet() == 0) {
                    }
                }
            }
        }
    }

    public ObservableRetryWhen(ObservableSource<T> observableSource, Function<? super Observable<Throwable>, ? extends ObservableSource<?>> function) {
        super(observableSource);
        this.f38059a = function;
    }

    protected final void subscribeActual(Observer<? super T> observer) {
        Subject toSerialized = PublishSubject.create().toSerialized();
        try {
            ObservableSource observableSource = (ObservableSource) ObjectHelper.m26573a(this.f38059a.apply(toSerialized), "The handler returned a null ObservableSource");
            RepeatWhenObserver repeatWhenObserver = new RepeatWhenObserver(observer, toSerialized, this.source);
            observer.onSubscribe(repeatWhenObserver);
            observableSource.subscribe(repeatWhenObserver.f32051e);
            repeatWhenObserver.m32578c();
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            EmptyDisposable.m38051a(th, (Observer) observer);
        }
    }
}
