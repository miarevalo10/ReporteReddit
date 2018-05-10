package io.reactivex.internal.operators.observable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableMergeWithCompletable<T> extends AbstractObservableWithUpstream<T, T> {
    final CompletableSource f38029a;

    static final class MergeWithObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        final Observer<? super T> f31935a;
        final AtomicReference<Disposable> f31936b = new AtomicReference();
        final OtherObserver f31937c = new OtherObserver(this);
        final AtomicThrowable f31938d = new AtomicThrowable();
        volatile boolean f31939e;
        volatile boolean f31940f;

        static final class OtherObserver extends AtomicReference<Disposable> implements CompletableObserver {
            final MergeWithObserver<?> f31934a;

            OtherObserver(MergeWithObserver<?> mergeWithObserver) {
                this.f31934a = mergeWithObserver;
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.m32092b(this, disposable);
            }

            public final void onError(Throwable th) {
                AtomicInteger atomicInteger = this.f31934a;
                DisposableHelper.m32090a(atomicInteger.f31936b);
                HalfSerializer.m26687a(atomicInteger.f31935a, th, atomicInteger, atomicInteger.f31938d);
            }

            public final void onComplete() {
                AtomicInteger atomicInteger = this.f31934a;
                atomicInteger.f31940f = true;
                if (atomicInteger.f31939e) {
                    HalfSerializer.m26688a(atomicInteger.f31935a, atomicInteger, atomicInteger.f31938d);
                }
            }
        }

        MergeWithObserver(Observer<? super T> observer) {
            this.f31935a = observer;
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32092b(this.f31936b, disposable);
        }

        public final void onNext(T t) {
            HalfSerializer.m26686a(this.f31935a, (Object) t, (AtomicInteger) this, this.f31938d);
        }

        public final void onError(Throwable th) {
            DisposableHelper.m32090a(this.f31936b);
            HalfSerializer.m26687a(this.f31935a, th, (AtomicInteger) this, this.f31938d);
        }

        public final void onComplete() {
            this.f31939e = true;
            if (this.f31940f) {
                HalfSerializer.m26688a(this.f31935a, (AtomicInteger) this, this.f31938d);
            }
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) this.f31936b.get());
        }

        public final void mo5626a() {
            DisposableHelper.m32090a(this.f31936b);
            DisposableHelper.m32090a(this.f31937c);
        }
    }

    public ObservableMergeWithCompletable(Observable<T> observable, CompletableSource completableSource) {
        super(observable);
        this.f38029a = completableSource;
    }

    protected final void subscribeActual(Observer<? super T> observer) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(observer);
        observer.onSubscribe(mergeWithObserver);
        this.source.subscribe(mergeWithObserver);
        this.f38029a.subscribe(mergeWithObserver.f31937c);
    }
}
