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
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableBufferBoundary<T, U extends Collection<? super T>, Open, Close> extends AbstractObservableWithUpstream<T, U> {
    final Callable<U> f37950a;
    final ObservableSource<? extends Open> f37951b;
    final Function<? super Open, ? extends ObservableSource<? extends Close>> f37952c;

    static final class BufferBoundaryObserver<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements Observer<T>, Disposable {
        final Observer<? super C> f31599a;
        final Callable<C> f31600b;
        final ObservableSource<? extends Open> f31601c;
        final Function<? super Open, ? extends ObservableSource<? extends Close>> f31602d;
        final CompositeDisposable f31603e = new CompositeDisposable();
        final AtomicReference<Disposable> f31604f = new AtomicReference();
        final AtomicThrowable f31605g = new AtomicThrowable();
        volatile boolean f31606h;
        final SpscLinkedArrayQueue<C> f31607i = new SpscLinkedArrayQueue(Observable.bufferSize());
        volatile boolean f31608j;
        long f31609k;
        Map<Long, C> f31610l = new LinkedHashMap();

        static final class BufferOpenObserver<Open> extends AtomicReference<Disposable> implements Observer<Open>, Disposable {
            final BufferBoundaryObserver<?, ?, Open, ?> f31598a;

            BufferOpenObserver(BufferBoundaryObserver<?, ?, Open, ?> bufferBoundaryObserver) {
                this.f31598a = bufferBoundaryObserver;
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.m32092b(this, disposable);
            }

            public final void onNext(Open open) {
                BufferBoundaryObserver bufferBoundaryObserver = this.f31598a;
                try {
                    Collection collection = (Collection) ObjectHelper.m26573a(bufferBoundaryObserver.f31600b.call(), "The bufferSupplier returned a null Collection");
                    ObservableSource observableSource = (ObservableSource) ObjectHelper.m26573a(bufferBoundaryObserver.f31602d.apply(open), "The bufferClose returned a null ObservableSource");
                    long j = bufferBoundaryObserver.f31609k;
                    bufferBoundaryObserver.f31609k = 1 + j;
                    synchronized (bufferBoundaryObserver) {
                        Map map = bufferBoundaryObserver.f31610l;
                        if (map == null) {
                            return;
                        }
                        map.put(Long.valueOf(j), collection);
                        Disposable bufferCloseObserver = new BufferCloseObserver(bufferBoundaryObserver, j);
                        bufferBoundaryObserver.f31603e.mo5631a(bufferCloseObserver);
                        observableSource.subscribe(bufferCloseObserver);
                    }
                } catch (Open open2) {
                    Exceptions.m26521b(open2);
                    DisposableHelper.m32090a(bufferBoundaryObserver.f31604f);
                    bufferBoundaryObserver.onError(open2);
                }
            }

            public final void onError(Throwable th) {
                lazySet(DisposableHelper.f31095a);
                this.f31598a.m32370a((Disposable) this, th);
            }

            public final void onComplete() {
                lazySet(DisposableHelper.f31095a);
                BufferBoundaryObserver bufferBoundaryObserver = this.f31598a;
                bufferBoundaryObserver.f31603e.mo5633c(this);
                if (bufferBoundaryObserver.f31603e.m32079d() == 0) {
                    DisposableHelper.m32090a(bufferBoundaryObserver.f31604f);
                    bufferBoundaryObserver.f31606h = true;
                    bufferBoundaryObserver.m32373c();
                }
            }

            public final void mo5626a() {
                DisposableHelper.m32090a((AtomicReference) this);
            }

            public final boolean mo5627b() {
                return get() == DisposableHelper.f31095a;
            }
        }

        BufferBoundaryObserver(Observer<? super C> observer, ObservableSource<? extends Open> observableSource, Function<? super Open, ? extends ObservableSource<? extends Close>> function, Callable<C> callable) {
            this.f31599a = observer;
            this.f31600b = callable;
            this.f31601c = observableSource;
            this.f31602d = function;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32092b(this.f31604f, disposable) != null) {
                disposable = new BufferOpenObserver(this);
                this.f31603e.mo5631a(disposable);
                this.f31601c.subscribe(disposable);
            }
        }

        public final void onNext(T t) {
            synchronized (this) {
                Map map = this.f31610l;
                if (map == null) {
                    return;
                }
                for (Collection add : map.values()) {
                    add.add(t);
                }
            }
        }

        public final void onError(Throwable th) {
            if (ExceptionHelper.m26684a(this.f31605g, th)) {
                this.f31603e.mo5626a();
                synchronized (this) {
                    this.f31610l = null;
                }
                this.f31606h = true;
                m32373c();
                return;
            }
            RxJavaPlugins.m26757a(th);
        }

        public final void onComplete() {
            this.f31603e.mo5626a();
            synchronized (this) {
                Map map = this.f31610l;
                if (map == null) {
                    return;
                }
                for (Collection offer : map.values()) {
                    this.f31607i.offer(offer);
                }
                this.f31610l = null;
                this.f31606h = true;
                m32373c();
            }
        }

        public final void mo5626a() {
            if (DisposableHelper.m32090a(this.f31604f)) {
                this.f31608j = true;
                this.f31603e.mo5626a();
                synchronized (this) {
                    this.f31610l = null;
                }
                if (getAndIncrement() != 0) {
                    this.f31607i.clear();
                }
            }
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) this.f31604f.get());
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        final void m32371a(io.reactivex.internal.operators.observable.ObservableBufferBoundary.BufferCloseObserver<T, C> r4, long r5) {
            /*
            r3 = this;
            r0 = r3.f31603e;
            r0.mo5633c(r4);
            r4 = r3.f31603e;
            r4 = r4.m32079d();
            r0 = 1;
            if (r4 != 0) goto L_0x0015;
        L_0x000e:
            r4 = r3.f31604f;
            io.reactivex.internal.disposables.DisposableHelper.m32090a(r4);
            r4 = r0;
            goto L_0x0016;
        L_0x0015:
            r4 = 0;
        L_0x0016:
            monitor-enter(r3);
            r1 = r3.f31610l;	 Catch:{ all -> 0x0035 }
            if (r1 != 0) goto L_0x001d;
        L_0x001b:
            monitor-exit(r3);	 Catch:{ all -> 0x0035 }
            return;
        L_0x001d:
            r1 = r3.f31607i;	 Catch:{ all -> 0x0035 }
            r2 = r3.f31610l;	 Catch:{ all -> 0x0035 }
            r5 = java.lang.Long.valueOf(r5);	 Catch:{ all -> 0x0035 }
            r5 = r2.remove(r5);	 Catch:{ all -> 0x0035 }
            r1.offer(r5);	 Catch:{ all -> 0x0035 }
            monitor-exit(r3);	 Catch:{ all -> 0x0035 }
            if (r4 == 0) goto L_0x0031;
        L_0x002f:
            r3.f31606h = r0;
        L_0x0031:
            r3.m32373c();
            return;
        L_0x0035:
            r4 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x0035 }
            throw r4;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableBufferBoundary.BufferBoundaryObserver.a(io.reactivex.internal.operators.observable.ObservableBufferBoundary$BufferCloseObserver, long):void");
        }

        final void m32370a(Disposable disposable, Throwable th) {
            DisposableHelper.m32090a(this.f31604f);
            this.f31603e.mo5633c(disposable);
            onError(th);
        }

        final void m32373c() {
            if (getAndIncrement() == 0) {
                Observer observer = this.f31599a;
                SpscLinkedArrayQueue spscLinkedArrayQueue = this.f31607i;
                int i = 1;
                while (!this.f31608j) {
                    boolean z = this.f31606h;
                    if (!z || this.f31605g.get() == null) {
                        Collection collection = (Collection) spscLinkedArrayQueue.poll();
                        Object obj = collection == null ? 1 : null;
                        if (z && obj != null) {
                            observer.onComplete();
                            return;
                        } else if (obj == null) {
                            observer.onNext(collection);
                        } else {
                            i = addAndGet(-i);
                            if (i == 0) {
                                return;
                            }
                        }
                    } else {
                        spscLinkedArrayQueue.clear();
                        observer.onError(ExceptionHelper.m26683a(this.f31605g));
                        return;
                    }
                }
                spscLinkedArrayQueue.clear();
            }
        }
    }

    static final class BufferCloseObserver<T, C extends Collection<? super T>> extends AtomicReference<Disposable> implements Observer<Object>, Disposable {
        final BufferBoundaryObserver<T, C, ?, ?> f31611a;
        final long f31612b;

        BufferCloseObserver(BufferBoundaryObserver<T, C, ?, ?> bufferBoundaryObserver, long j) {
            this.f31611a = bufferBoundaryObserver;
            this.f31612b = j;
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32092b(this, disposable);
        }

        public final void onNext(Object obj) {
            Disposable disposable = (Disposable) get();
            if (disposable != DisposableHelper.f31095a) {
                lazySet(DisposableHelper.f31095a);
                disposable.mo5626a();
                this.f31611a.m32371a(this, this.f31612b);
            }
        }

        public final void onError(Throwable th) {
            if (get() != DisposableHelper.f31095a) {
                lazySet(DisposableHelper.f31095a);
                this.f31611a.m32370a((Disposable) this, th);
                return;
            }
            RxJavaPlugins.m26757a(th);
        }

        public final void onComplete() {
            if (get() != DisposableHelper.f31095a) {
                lazySet(DisposableHelper.f31095a);
                this.f31611a.m32371a(this, this.f31612b);
            }
        }

        public final void mo5626a() {
            DisposableHelper.m32090a((AtomicReference) this);
        }

        public final boolean mo5627b() {
            return get() == DisposableHelper.f31095a;
        }
    }

    public ObservableBufferBoundary(ObservableSource<T> observableSource, ObservableSource<? extends Open> observableSource2, Function<? super Open, ? extends ObservableSource<? extends Close>> function, Callable<U> callable) {
        super(observableSource);
        this.f37951b = observableSource2;
        this.f37952c = function;
        this.f37950a = callable;
    }

    protected final void subscribeActual(Observer<? super U> observer) {
        Object bufferBoundaryObserver = new BufferBoundaryObserver(observer, this.f37951b, this.f37952c, this.f37950a);
        observer.onSubscribe(bufferBoundaryObserver);
        this.source.subscribe(bufferBoundaryObserver);
    }
}
