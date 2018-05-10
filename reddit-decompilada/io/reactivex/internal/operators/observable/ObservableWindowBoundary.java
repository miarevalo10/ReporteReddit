package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableWindowBoundary<T, B> extends AbstractObservableWithUpstream<T, Observable<T>> {
    final ObservableSource<B> f38114a;
    final int f38115b;

    static final class WindowBoundaryInnerObserver<T, B> extends DisposableObserver<B> {
        final WindowBoundaryMainObserver<T, B> f35748a;
        boolean f35749b;

        WindowBoundaryInnerObserver(WindowBoundaryMainObserver<T, B> windowBoundaryMainObserver) {
            this.f35748a = windowBoundaryMainObserver;
        }

        public final void onNext(B b) {
            if (this.f35749b == null) {
                this.f35748a.m39756h();
            }
        }

        public final void onError(Throwable th) {
            if (this.f35749b) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f35749b = true;
            this.f35748a.onError(th);
        }

        public final void onComplete() {
            if (!this.f35749b) {
                this.f35749b = true;
                this.f35748a.onComplete();
            }
        }
    }

    static final class WindowBoundaryMainObserver<T, B> extends QueueDrainObserver<T, Object, Observable<T>> implements Disposable {
        static final Object f39622l = new Object();
        final ObservableSource<B> f39623g;
        final int f39624h;
        Disposable f39625i;
        final AtomicReference<Disposable> f39626j = new AtomicReference();
        UnicastSubject<T> f39627k;
        final AtomicLong f39628m = new AtomicLong();

        WindowBoundaryMainObserver(Observer<? super Observable<T>> observer, ObservableSource<B> observableSource, int i) {
            super(observer, new MpscLinkedQueue());
            this.f39623g = observableSource;
            this.f39624h = i;
            this.f39628m.lazySet(1);
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f39625i, disposable)) {
                this.f39625i = disposable;
                disposable = this.a;
                disposable.onSubscribe(this);
                if (!this.c) {
                    UnicastSubject a = UnicastSubject.m38182a(this.f39624h);
                    this.f39627k = a;
                    disposable.onNext(a);
                    disposable = new WindowBoundaryInnerObserver(this);
                    if (this.f39626j.compareAndSet(null, disposable)) {
                        this.f39628m.getAndIncrement();
                        this.f39623g.subscribe(disposable);
                    }
                }
            }
        }

        public final void onNext(T t) {
            if (m38075f()) {
                this.f39627k.onNext(t);
                if (mo7034a(-1) == null) {
                    return;
                }
            }
            this.b.offer(NotificationLite.m26696a((Object) t));
            if (m38074e() == null) {
                return;
            }
            m39753i();
        }

        public final void onError(Throwable th) {
            if (this.d) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.e = th;
            this.d = true;
            if (m38074e()) {
                m39753i();
            }
            if (this.f39628m.decrementAndGet() == 0) {
                DisposableHelper.m32090a(this.f39626j);
            }
            this.a.onError(th);
        }

        public final void onComplete() {
            if (!this.d) {
                this.d = true;
                if (m38074e()) {
                    m39753i();
                }
                if (this.f39628m.decrementAndGet() == 0) {
                    DisposableHelper.m32090a(this.f39626j);
                }
                this.a.onComplete();
            }
        }

        public final void mo5626a() {
            this.c = true;
        }

        public final boolean mo5627b() {
            return this.c;
        }

        private void m39753i() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.b;
            Observer observer = this.a;
            UnicastSubject unicastSubject = this.f39627k;
            int i = 1;
            while (true) {
                boolean z = this.d;
                Object poll = mpscLinkedQueue.poll();
                Object obj = poll == null ? 1 : null;
                if (z && obj != null) {
                    break;
                } else if (obj != null) {
                    i = mo7034a(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (poll == f39622l) {
                    unicastSubject.onComplete();
                    if (this.f39628m.decrementAndGet() == 0) {
                        DisposableHelper.m32090a(this.f39626j);
                        return;
                    } else if (!this.c) {
                        unicastSubject = UnicastSubject.m38182a(this.f39624h);
                        this.f39628m.getAndIncrement();
                        this.f39627k = unicastSubject;
                        observer.onNext(unicastSubject);
                    }
                } else {
                    unicastSubject.onNext(NotificationLite.m26706e(poll));
                }
            }
            DisposableHelper.m32090a(this.f39626j);
            Throwable th = this.e;
            if (th != null) {
                unicastSubject.onError(th);
            } else {
                unicastSubject.onComplete();
            }
        }

        final void m39756h() {
            this.b.offer(f39622l);
            if (m38074e()) {
                m39753i();
            }
        }
    }

    public ObservableWindowBoundary(ObservableSource<T> observableSource, ObservableSource<B> observableSource2, int i) {
        super(observableSource);
        this.f38114a = observableSource2;
        this.f38115b = i;
    }

    public final void subscribeActual(Observer<? super Observable<T>> observer) {
        this.source.subscribe(new WindowBoundaryMainObserver(new SerializedObserver(observer), this.f38114a, this.f38115b));
    }
}
