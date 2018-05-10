package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableWindowBoundarySupplier<T, B> extends AbstractObservableWithUpstream<T, Observable<T>> {
    final Callable<? extends ObservableSource<B>> f38119a;
    final int f38120b;

    static final class WindowBoundaryInnerObserver<T, B> extends DisposableObserver<B> {
        final WindowBoundaryMainObserver<T, B> f35754a;
        boolean f35755b;

        WindowBoundaryInnerObserver(WindowBoundaryMainObserver<T, B> windowBoundaryMainObserver) {
            this.f35754a = windowBoundaryMainObserver;
        }

        public final void onNext(B b) {
            if (this.f35755b == null) {
                this.f35755b = true;
                mo5626a();
                this.f35754a.m39768h();
            }
        }

        public final void onError(Throwable th) {
            if (this.f35755b) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f35755b = true;
            this.f35754a.onError(th);
        }

        public final void onComplete() {
            if (!this.f35755b) {
                this.f35755b = true;
                this.f35754a.onComplete();
            }
        }
    }

    static final class WindowBoundaryMainObserver<T, B> extends QueueDrainObserver<T, Object, Observable<T>> implements Disposable {
        static final Object f39637l = new Object();
        final Callable<? extends ObservableSource<B>> f39638g;
        final int f39639h;
        Disposable f39640i;
        final AtomicReference<Disposable> f39641j = new AtomicReference();
        UnicastSubject<T> f39642k;
        final AtomicLong f39643m = new AtomicLong();

        WindowBoundaryMainObserver(Observer<? super Observable<T>> observer, Callable<? extends ObservableSource<B>> callable, int i) {
            super(observer, new MpscLinkedQueue());
            this.f39638g = callable;
            this.f39639h = i;
            this.f39643m.lazySet(1);
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f39640i, disposable)) {
                this.f39640i = disposable;
                Observer observer = this.a;
                observer.onSubscribe(this);
                if (!this.c) {
                    try {
                        ObservableSource observableSource = (ObservableSource) ObjectHelper.m26573a(this.f39638g.call(), "The first window ObservableSource supplied is null");
                        disposable = UnicastSubject.m38182a(this.f39639h);
                        this.f39642k = disposable;
                        observer.onNext(disposable);
                        disposable = new WindowBoundaryInnerObserver(this);
                        if (this.f39641j.compareAndSet(null, disposable)) {
                            this.f39643m.getAndIncrement();
                            observableSource.subscribe(disposable);
                        }
                    } catch (Throwable th) {
                        Exceptions.m26521b(th);
                        disposable.mo5626a();
                        observer.onError(th);
                    }
                }
            }
        }

        public final void onNext(T t) {
            if (m38075f()) {
                this.f39642k.onNext(t);
                if (mo7034a(-1) == null) {
                    return;
                }
            }
            this.b.offer(NotificationLite.m26696a((Object) t));
            if (m38074e() == null) {
                return;
            }
            m39765i();
        }

        public final void onError(Throwable th) {
            if (this.d) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.e = th;
            this.d = true;
            if (m38074e()) {
                m39765i();
            }
            if (this.f39643m.decrementAndGet() == 0) {
                DisposableHelper.m32090a(this.f39641j);
            }
            this.a.onError(th);
        }

        public final void onComplete() {
            if (!this.d) {
                this.d = true;
                if (m38074e()) {
                    m39765i();
                }
                if (this.f39643m.decrementAndGet() == 0) {
                    DisposableHelper.m32090a(this.f39641j);
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

        private void m39765i() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.b;
            Observer observer = this.a;
            UnicastSubject unicastSubject = this.f39642k;
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
                } else if (poll == f39637l) {
                    unicastSubject.onComplete();
                    if (this.f39643m.decrementAndGet() == 0) {
                        DisposableHelper.m32090a(this.f39641j);
                        return;
                    } else if (this.c) {
                        continue;
                    } else {
                        try {
                            ObservableSource observableSource = (ObservableSource) ObjectHelper.m26573a(this.f39638g.call(), "The ObservableSource supplied is null");
                            UnicastSubject a = UnicastSubject.m38182a(this.f39639h);
                            this.f39643m.getAndIncrement();
                            this.f39642k = a;
                            observer.onNext(a);
                            Observer windowBoundaryInnerObserver = new WindowBoundaryInnerObserver(this);
                            if (this.f39641j.compareAndSet(this.f39641j.get(), windowBoundaryInnerObserver)) {
                                observableSource.subscribe(windowBoundaryInnerObserver);
                            }
                            unicastSubject = a;
                        } catch (Throwable th) {
                            Exceptions.m26521b(th);
                            DisposableHelper.m32090a(this.f39641j);
                            observer.onError(th);
                            return;
                        }
                    }
                } else {
                    unicastSubject.onNext(NotificationLite.m26706e(poll));
                }
            }
            DisposableHelper.m32090a(this.f39641j);
            Throwable th2 = this.e;
            if (th2 != null) {
                unicastSubject.onError(th2);
            } else {
                unicastSubject.onComplete();
            }
        }

        final void m39768h() {
            this.b.offer(f39637l);
            if (m38074e()) {
                m39765i();
            }
        }
    }

    public ObservableWindowBoundarySupplier(ObservableSource<T> observableSource, Callable<? extends ObservableSource<B>> callable, int i) {
        super(observableSource);
        this.f38119a = callable;
        this.f38120b = i;
    }

    public final void subscribeActual(Observer<? super Observable<T>> observer) {
        this.source.subscribe(new WindowBoundaryMainObserver(new SerializedObserver(observer), this.f38119a, this.f38120b));
    }
}
