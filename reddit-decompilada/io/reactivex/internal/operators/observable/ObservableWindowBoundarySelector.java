package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.UnicastSubject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableWindowBoundarySelector<T, B, V> extends AbstractObservableWithUpstream<T, Observable<T>> {
    final ObservableSource<B> f38116a;
    final Function<? super B, ? extends ObservableSource<V>> f38117b;
    final int f38118c;

    static final class WindowOperation<T, B> {
        final UnicastSubject<T> f25139a;
        final B f25140b;

        WindowOperation(UnicastSubject<T> unicastSubject, B b) {
            this.f25139a = unicastSubject;
            this.f25140b = b;
        }
    }

    static final class OperatorWindowBoundaryCloseObserver<T, V> extends DisposableObserver<V> {
        final WindowBoundaryMainObserver<T, ?, V> f35750a;
        final UnicastSubject<T> f35751b;
        boolean f35752c;

        OperatorWindowBoundaryCloseObserver(WindowBoundaryMainObserver<T, ?, V> windowBoundaryMainObserver, UnicastSubject<T> unicastSubject) {
            this.f35750a = windowBoundaryMainObserver;
            this.f35751b = unicastSubject;
        }

        public final void onNext(V v) {
            if (this.f35752c == null) {
                this.f35752c = true;
                mo5626a();
                this.f35750a.m39761a(this);
            }
        }

        public final void onError(Throwable th) {
            if (this.f35752c) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f35752c = true;
            this.f35750a.m39763a(th);
        }

        public final void onComplete() {
            if (!this.f35752c) {
                this.f35752c = true;
                this.f35750a.m39761a(this);
            }
        }
    }

    static final class OperatorWindowBoundaryOpenObserver<T, B> extends DisposableObserver<B> {
        final WindowBoundaryMainObserver<T, B, ?> f35753a;

        OperatorWindowBoundaryOpenObserver(WindowBoundaryMainObserver<T, B, ?> windowBoundaryMainObserver) {
            this.f35753a = windowBoundaryMainObserver;
        }

        public final void onNext(B b) {
            this.f35753a.m39762a((Object) b);
        }

        public final void onError(Throwable th) {
            this.f35753a.m39763a(th);
        }

        public final void onComplete() {
            this.f35753a.onComplete();
        }
    }

    static final class WindowBoundaryMainObserver<T, B, V> extends QueueDrainObserver<T, Object, Observable<T>> implements Disposable {
        final ObservableSource<B> f39629g;
        final Function<? super B, ? extends ObservableSource<V>> f39630h;
        final int f39631i;
        final CompositeDisposable f39632j;
        Disposable f39633k;
        final AtomicReference<Disposable> f39634l = new AtomicReference();
        final List<UnicastSubject<T>> f39635m;
        final AtomicLong f39636n = new AtomicLong();

        public final void mo7035a(Observer<? super Observable<T>> observer, Object obj) {
        }

        WindowBoundaryMainObserver(Observer<? super Observable<T>> observer, ObservableSource<B> observableSource, Function<? super B, ? extends ObservableSource<V>> function, int i) {
            super(observer, new MpscLinkedQueue());
            this.f39629g = observableSource;
            this.f39630h = function;
            this.f39631i = i;
            this.f39632j = new CompositeDisposable();
            this.f39635m = new ArrayList();
            this.f39636n.lazySet(1);
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f39633k, disposable)) {
                this.f39633k = disposable;
                this.a.onSubscribe(this);
                if (this.c == null) {
                    disposable = new OperatorWindowBoundaryOpenObserver(this);
                    if (this.f39634l.compareAndSet(null, disposable)) {
                        this.f39636n.getAndIncrement();
                        this.f39629g.subscribe(disposable);
                    }
                }
            }
        }

        public final void onNext(T t) {
            if (m38075f()) {
                for (UnicastSubject onNext : this.f39635m) {
                    onNext.onNext(t);
                }
                if (mo7034a(-1) == null) {
                    return;
                }
            }
            this.b.offer(NotificationLite.m26696a((Object) t));
            if (m38074e() == null) {
                return;
            }
            m39758i();
        }

        public final void onError(Throwable th) {
            if (this.d) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.e = th;
            this.d = true;
            if (m38074e()) {
                m39758i();
            }
            if (this.f39636n.decrementAndGet() == 0) {
                this.f39632j.mo5626a();
            }
            this.a.onError(th);
        }

        public final void onComplete() {
            if (!this.d) {
                this.d = true;
                if (m38074e()) {
                    m39758i();
                }
                if (this.f39636n.decrementAndGet() == 0) {
                    this.f39632j.mo5626a();
                }
                this.a.onComplete();
            }
        }

        final void m39763a(Throwable th) {
            this.f39633k.mo5626a();
            this.f39632j.mo5626a();
            onError(th);
        }

        public final void mo5626a() {
            this.c = true;
        }

        public final boolean mo5627b() {
            return this.c;
        }

        private void m39757h() {
            this.f39632j.mo5626a();
            DisposableHelper.m32090a(this.f39634l);
        }

        private void m39758i() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.b;
            Observer observer = this.a;
            List<UnicastSubject> list = this.f39635m;
            int i = 1;
            while (true) {
                boolean z = this.d;
                Object poll = mpscLinkedQueue.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    break;
                } else if (z2) {
                    i = mo7034a(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (poll instanceof WindowOperation) {
                    WindowOperation windowOperation = (WindowOperation) poll;
                    if (windowOperation.f25139a != null) {
                        if (list.remove(windowOperation.f25139a)) {
                            windowOperation.f25139a.onComplete();
                            if (this.f39636n.decrementAndGet() == 0) {
                                m39757h();
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.c) {
                        UnicastSubject a = UnicastSubject.m38182a(this.f39631i);
                        list.add(a);
                        observer.onNext(a);
                        try {
                            ObservableSource observableSource = (ObservableSource) ObjectHelper.m26573a(this.f39630h.apply(windowOperation.f25140b), "The ObservableSource supplied is null");
                            Disposable operatorWindowBoundaryCloseObserver = new OperatorWindowBoundaryCloseObserver(this, a);
                            if (this.f39632j.mo5631a(operatorWindowBoundaryCloseObserver)) {
                                this.f39636n.getAndIncrement();
                                observableSource.subscribe(operatorWindowBoundaryCloseObserver);
                            }
                        } catch (Throwable th) {
                            Exceptions.m26521b(th);
                            this.c = true;
                            observer.onError(th);
                        }
                    }
                } else {
                    for (UnicastSubject onNext : list) {
                        onNext.onNext(NotificationLite.m26706e(poll));
                    }
                }
            }
            m39757h();
            Throwable th2 = this.e;
            if (th2 != null) {
                for (UnicastSubject onError : list) {
                    onError.onError(th2);
                }
            } else {
                for (UnicastSubject onComplete : list) {
                    onComplete.onComplete();
                }
            }
            list.clear();
        }

        final void m39762a(B b) {
            this.b.offer(new WindowOperation(null, b));
            if (m38074e() != null) {
                m39758i();
            }
        }

        final void m39761a(OperatorWindowBoundaryCloseObserver<T, V> operatorWindowBoundaryCloseObserver) {
            this.f39632j.mo5633c(operatorWindowBoundaryCloseObserver);
            this.b.offer(new WindowOperation(operatorWindowBoundaryCloseObserver.f35751b, null));
            if (m38074e() != null) {
                m39758i();
            }
        }
    }

    public ObservableWindowBoundarySelector(ObservableSource<T> observableSource, ObservableSource<B> observableSource2, Function<? super B, ? extends ObservableSource<V>> function, int i) {
        super(observableSource);
        this.f38116a = observableSource2;
        this.f38117b = function;
        this.f38118c = i;
    }

    public final void subscribeActual(Observer<? super Observable<T>> observer) {
        this.source.subscribe(new WindowBoundaryMainObserver(new SerializedObserver(observer), this.f38116a, this.f38117b, this.f38118c));
    }
}
