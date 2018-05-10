package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableDoFinally<T> extends AbstractObservableWithUpstream<T, T> {
    final Action f37989a;

    static final class DoFinallyObserver<T> extends BasicIntQueueDisposable<T> implements Observer<T> {
        final Observer<? super T> f39578a;
        final Action f39579b;
        Disposable f39580c;
        QueueDisposable<T> f39581d;
        boolean f39582e;

        DoFinallyObserver(Observer<? super T> observer, Action action) {
            this.f39578a = observer;
            this.f39579b = action;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f39580c, disposable)) {
                this.f39580c = disposable;
                if (disposable instanceof QueueDisposable) {
                    this.f39581d = (QueueDisposable) disposable;
                }
                this.f39578a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            this.f39578a.onNext(t);
        }

        public final void onError(Throwable th) {
            this.f39578a.onError(th);
            m39727c();
        }

        public final void onComplete() {
            this.f39578a.onComplete();
            m39727c();
        }

        public final void mo5626a() {
            this.f39580c.mo5626a();
            m39727c();
        }

        public final boolean mo5627b() {
            return this.f39580c.mo5627b();
        }

        public final int mo7033a(int i) {
            QueueDisposable queueDisposable = this.f39581d;
            if (queueDisposable == null || (i & 4) != 0) {
                return 0;
            }
            i = queueDisposable.mo7033a(i);
            if (i != 0) {
                boolean z = true;
                if (i != 1) {
                    z = false;
                }
                this.f39582e = z;
            }
            return i;
        }

        public final void clear() {
            this.f39581d.clear();
        }

        public final boolean isEmpty() {
            return this.f39581d.isEmpty();
        }

        public final T poll() throws Exception {
            T poll = this.f39581d.poll();
            if (poll == null && this.f39582e) {
                m39727c();
            }
            return poll;
        }

        private void m39727c() {
            if (compareAndSet(0, 1)) {
                try {
                    this.f39579b.run();
                } catch (Throwable th) {
                    Exceptions.m26521b(th);
                    RxJavaPlugins.m26757a(th);
                }
            }
        }
    }

    public ObservableDoFinally(ObservableSource<T> observableSource, Action action) {
        super(observableSource);
        this.f37989a = action;
    }

    protected final void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new DoFinallyObserver(observer, this.f37989a));
    }
}
