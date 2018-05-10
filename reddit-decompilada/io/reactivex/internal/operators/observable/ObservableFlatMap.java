package io.reactivex.internal.operators.observable;

import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableFlatMap<T, U> extends AbstractObservableWithUpstream<T, U> {
    final Function<? super T, ? extends ObservableSource<? extends U>> f38000a;
    final boolean f38001b;
    final int f38002c;
    final int f38003d;

    static final class InnerObserver<T, U> extends AtomicReference<Disposable> implements Observer<U> {
        final long f31775a;
        final MergeObserver<T, U> f31776b;
        volatile boolean f31777c;
        volatile SimpleQueue<U> f31778d;
        int f31779e;

        InnerObserver(MergeObserver<T, U> mergeObserver, long j) {
            this.f31775a = j;
            this.f31776b = mergeObserver;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32092b(this, disposable) && (disposable instanceof QueueDisposable)) {
                QueueDisposable queueDisposable = (QueueDisposable) disposable;
                int a = queueDisposable.mo7033a(7);
                if (a == 1) {
                    this.f31779e = a;
                    this.f31778d = queueDisposable;
                    this.f31777c = true;
                    this.f31776b.m32441c();
                } else if (a == 2) {
                    this.f31779e = a;
                    this.f31778d = queueDisposable;
                }
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onNext(U r4) {
            /*
            r3 = this;
            r0 = r3.f31779e;
            if (r0 != 0) goto L_0x003a;
        L_0x0004:
            r0 = r3.f31776b;
            r1 = r0.get();
            if (r1 != 0) goto L_0x0020;
        L_0x000c:
            r1 = 0;
            r2 = 1;
            r1 = r0.compareAndSet(r1, r2);
            if (r1 == 0) goto L_0x0020;
        L_0x0014:
            r1 = r0.f31782a;
            r1.onNext(r4);
            r4 = r0.decrementAndGet();
            if (r4 != 0) goto L_0x0036;
        L_0x001f:
            return;
        L_0x0020:
            r1 = r3.f31778d;
            if (r1 != 0) goto L_0x002d;
        L_0x0024:
            r1 = new io.reactivex.internal.queue.SpscLinkedArrayQueue;
            r2 = r0.f31786e;
            r1.<init>(r2);
            r3.f31778d = r1;
        L_0x002d:
            r1.offer(r4);
            r4 = r0.getAndIncrement();
            if (r4 != 0) goto L_0x0039;
        L_0x0036:
            r0.m32442d();
        L_0x0039:
            return;
        L_0x003a:
            r4 = r3.f31776b;
            r4.m32441c();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableFlatMap.InnerObserver.onNext(java.lang.Object):void");
        }

        public final void onError(Throwable th) {
            if (ExceptionHelper.m26684a(this.f31776b.f31789h, th)) {
                if (this.f31776b.f31784c == null) {
                    this.f31776b.m32443e();
                }
                this.f31777c = true;
                this.f31776b.m32441c();
                return;
            }
            RxJavaPlugins.m26757a(th);
        }

        public final void onComplete() {
            this.f31777c = true;
            this.f31776b.m32441c();
        }
    }

    static final class MergeObserver<T, U> extends AtomicInteger implements Observer<T>, Disposable {
        static final InnerObserver<?, ?>[] f31780k = new InnerObserver[0];
        static final InnerObserver<?, ?>[] f31781l = new InnerObserver[0];
        final Observer<? super U> f31782a;
        final Function<? super T, ? extends ObservableSource<? extends U>> f31783b;
        final boolean f31784c;
        final int f31785d;
        final int f31786e;
        volatile SimplePlainQueue<U> f31787f;
        volatile boolean f31788g;
        final AtomicThrowable f31789h = new AtomicThrowable();
        volatile boolean f31790i;
        final AtomicReference<InnerObserver<?, ?>[]> f31791j;
        Disposable f31792m;
        long f31793n;
        long f31794o;
        int f31795p;
        Queue<ObservableSource<? extends U>> f31796q;
        int f31797r;

        MergeObserver(Observer<? super U> observer, Function<? super T, ? extends ObservableSource<? extends U>> function, boolean z, int i, int i2) {
            this.f31782a = observer;
            this.f31783b = function;
            this.f31784c = z;
            this.f31785d = i;
            this.f31786e = i2;
            if (i != RedditJobManager.f10810d) {
                this.f31796q = new ArrayDeque(i);
            }
            this.f31791j = new AtomicReference(f31780k);
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31792m, disposable)) {
                this.f31792m = disposable;
                this.f31782a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            if (!this.f31788g) {
                try {
                    ObservableSource observableSource = (ObservableSource) ObjectHelper.m26573a(this.f31783b.apply(t), "The mapper returned a null ObservableSource");
                    if (this.f31785d != RedditJobManager.f10810d) {
                        synchronized (this) {
                            if (this.f31797r == this.f31785d) {
                                this.f31796q.offer(observableSource);
                                return;
                            }
                            this.f31797r++;
                        }
                    }
                    m32435a(observableSource);
                } catch (T t2) {
                    Exceptions.m26521b(t2);
                    this.f31792m.mo5626a();
                    onError(t2);
                }
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void m32435a(io.reactivex.ObservableSource<? extends U> r6) {
            /*
            r5 = this;
        L_0x0000:
            r0 = r6 instanceof java.util.concurrent.Callable;
            if (r0 == 0) goto L_0x0085;
        L_0x0004:
            r6 = (java.util.concurrent.Callable) r6;
            r0 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
            r1 = 1;
            r6 = r6.call();	 Catch:{ Throwable -> 0x005d }
            if (r6 == 0) goto L_0x0069;
        L_0x0010:
            r2 = r5.get();
            if (r2 != 0) goto L_0x0029;
        L_0x0016:
            r2 = 0;
            r2 = r5.compareAndSet(r2, r1);
            if (r2 == 0) goto L_0x0029;
        L_0x001d:
            r2 = r5.f31782a;
            r2.onNext(r6);
            r6 = r5.decrementAndGet();
            if (r6 != 0) goto L_0x0059;
        L_0x0028:
            goto L_0x0069;
        L_0x0029:
            r2 = r5.f31787f;
            if (r2 != 0) goto L_0x0042;
        L_0x002d:
            r2 = r5.f31785d;
            if (r2 != r0) goto L_0x0039;
        L_0x0031:
            r2 = new io.reactivex.internal.queue.SpscLinkedArrayQueue;
            r3 = r5.f31786e;
            r2.<init>(r3);
            goto L_0x0040;
        L_0x0039:
            r2 = new io.reactivex.internal.queue.SpscArrayQueue;
            r3 = r5.f31785d;
            r2.<init>(r3);
        L_0x0040:
            r5.f31787f = r2;
        L_0x0042:
            r6 = r2.offer(r6);
            if (r6 != 0) goto L_0x0053;
        L_0x0048:
            r6 = new java.lang.IllegalStateException;
            r2 = "Scalar queue full?!";
            r6.<init>(r2);
            r5.onError(r6);
            goto L_0x0069;
        L_0x0053:
            r6 = r5.getAndIncrement();
            if (r6 != 0) goto L_0x0069;
        L_0x0059:
            r5.m32442d();
            goto L_0x0069;
        L_0x005d:
            r6 = move-exception;
            io.reactivex.exceptions.Exceptions.m26521b(r6);
            r2 = r5.f31789h;
            io.reactivex.internal.util.ExceptionHelper.m26684a(r2, r6);
            r5.m32441c();
        L_0x0069:
            r6 = r5.f31785d;
            if (r6 == r0) goto L_0x009a;
        L_0x006d:
            monitor-enter(r5);
            r6 = r5.f31796q;	 Catch:{ all -> 0x0082 }
            r6 = r6.poll();	 Catch:{ all -> 0x0082 }
            r6 = (io.reactivex.ObservableSource) r6;	 Catch:{ all -> 0x0082 }
            if (r6 != 0) goto L_0x007f;
        L_0x0078:
            r6 = r5.f31797r;	 Catch:{ all -> 0x0082 }
            r6 = r6 - r1;
            r5.f31797r = r6;	 Catch:{ all -> 0x0082 }
            monitor-exit(r5);	 Catch:{ all -> 0x0082 }
            return;
        L_0x007f:
            monitor-exit(r5);	 Catch:{ all -> 0x0082 }
            goto L_0x0000;
        L_0x0082:
            r6 = move-exception;
            monitor-exit(r5);	 Catch:{ all -> 0x0082 }
            throw r6;
        L_0x0085:
            r0 = new io.reactivex.internal.operators.observable.ObservableFlatMap$InnerObserver;
            r1 = r5.f31793n;
            r3 = 1;
            r3 = r3 + r1;
            r5.f31793n = r3;
            r0.<init>(r5, r1);
            r1 = r5.m32436a(r0);
            if (r1 == 0) goto L_0x009a;
        L_0x0097:
            r6.subscribe(r0);
        L_0x009a:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableFlatMap.MergeObserver.a(io.reactivex.ObservableSource):void");
        }

        private boolean m32436a(InnerObserver<T, U> innerObserver) {
            InnerObserver[] innerObserverArr;
            Object obj;
            do {
                innerObserverArr = (InnerObserver[]) this.f31791j.get();
                if (innerObserverArr == f31781l) {
                    DisposableHelper.m32090a((AtomicReference) innerObserver);
                    return false;
                }
                int length = innerObserverArr.length;
                obj = new InnerObserver[(length + 1)];
                System.arraycopy(innerObserverArr, 0, obj, 0, length);
                obj[length] = innerObserver;
            } while (!this.f31791j.compareAndSet(innerObserverArr, obj));
            return true;
        }

        private void m32437b(InnerObserver<T, U> innerObserver) {
            InnerObserver[] innerObserverArr;
            Object obj;
            do {
                innerObserverArr = (InnerObserver[]) this.f31791j.get();
                int length = innerObserverArr.length;
                if (length != 0) {
                    int i = -1;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (innerObserverArr[i2] == innerObserver) {
                            i = i2;
                            break;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            obj = f31780k;
                        } else {
                            Object obj2 = new InnerObserver[(length - 1)];
                            System.arraycopy(innerObserverArr, 0, obj2, 0, i);
                            System.arraycopy(innerObserverArr, i + 1, obj2, i, (length - i) - 1);
                            obj = obj2;
                        }
                    } else {
                        return;
                    }
                }
                return;
            } while (!this.f31791j.compareAndSet(innerObserverArr, obj));
        }

        public final void onError(Throwable th) {
            if (this.f31788g) {
                RxJavaPlugins.m26757a(th);
            } else if (ExceptionHelper.m26684a(this.f31789h, th)) {
                this.f31788g = true;
                m32441c();
            } else {
                RxJavaPlugins.m26757a(th);
            }
        }

        public final void onComplete() {
            if (!this.f31788g) {
                this.f31788g = true;
                m32441c();
            }
        }

        public final void mo5626a() {
            if (!this.f31790i) {
                this.f31790i = true;
                if (m32443e()) {
                    Throwable a = ExceptionHelper.m26683a(this.f31789h);
                    if (a != null && a != ExceptionHelper.f25187a) {
                        RxJavaPlugins.m26757a(a);
                    }
                }
            }
        }

        public final boolean mo5627b() {
            return this.f31790i;
        }

        final void m32441c() {
            if (getAndIncrement() == 0) {
                m32442d();
            }
        }

        final void m32442d() {
            Observer observer = this.f31782a;
            int i = 1;
            while (!m32438f()) {
                SimplePlainQueue simplePlainQueue = this.f31787f;
                if (simplePlainQueue != null) {
                    while (!m32438f()) {
                        Object poll = simplePlainQueue.poll();
                        if (poll != null) {
                            observer.onNext(poll);
                        } else if (poll == null) {
                        }
                    }
                    return;
                }
                boolean z = this.f31788g;
                SimplePlainQueue simplePlainQueue2 = this.f31787f;
                InnerObserver[] innerObserverArr = (InnerObserver[]) this.f31791j.get();
                int length = innerObserverArr.length;
                if (z && ((simplePlainQueue2 == null || simplePlainQueue2.isEmpty()) && length == 0)) {
                    Throwable a = ExceptionHelper.m26683a(this.f31789h);
                    if (a != ExceptionHelper.f25187a) {
                        if (a == null) {
                            observer.onComplete();
                            return;
                        }
                        observer.onError(a);
                    }
                    return;
                }
                int i2 = 0;
                if (length != 0) {
                    long j = this.f31794o;
                    int i3 = this.f31795p;
                    if (length <= i3 || innerObserverArr[i3].f31775a != j) {
                        if (length <= i3) {
                            i3 = 0;
                        }
                        int i4 = i3;
                        for (i3 = 0; i3 < length && innerObserverArr[i4].f31775a != j; i3++) {
                            i4++;
                            if (i4 == length) {
                                i4 = 0;
                            }
                        }
                        this.f31795p = i4;
                        this.f31794o = innerObserverArr[i4].f31775a;
                        i3 = i4;
                    }
                    int i5 = 0;
                    int i6 = i3;
                    i3 = i5;
                    while (i3 < length) {
                        if (!m32438f()) {
                            AtomicReference atomicReference = innerObserverArr[i6];
                            while (!m32438f()) {
                                SimpleQueue simpleQueue = atomicReference.f31778d;
                                if (simpleQueue != null) {
                                    Object poll2;
                                    while (true) {
                                        try {
                                            poll2 = simpleQueue.poll();
                                            if (poll2 == null) {
                                                break;
                                            }
                                            observer.onNext(poll2);
                                            if (m32438f()) {
                                                return;
                                            }
                                        } catch (Throwable th) {
                                            Exceptions.m26521b(th);
                                            DisposableHelper.m32090a(atomicReference);
                                            ExceptionHelper.m26684a(this.f31789h, th);
                                            if (!m32438f()) {
                                                m32437b(atomicReference);
                                                i3++;
                                                i5 = 1;
                                            } else {
                                                return;
                                            }
                                        }
                                    }
                                    if (poll2 == null) {
                                    }
                                }
                                boolean z2 = atomicReference.f31777c;
                                SimpleQueue simpleQueue2 = atomicReference.f31778d;
                                if (z2 && (simpleQueue2 == null || simpleQueue2.isEmpty())) {
                                    m32437b(atomicReference);
                                    if (!m32438f()) {
                                        i5 = 1;
                                    } else {
                                        return;
                                    }
                                }
                                i6++;
                                if (i6 == length) {
                                    i6 = 0;
                                }
                                i3++;
                            }
                            return;
                        }
                        return;
                    }
                    this.f31795p = i6;
                    this.f31794o = innerObserverArr[i6].f31775a;
                    i2 = i5;
                }
                if (i2 == 0) {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (this.f31785d != RedditJobManager.f10810d) {
                    synchronized (this) {
                        ObservableSource observableSource = (ObservableSource) this.f31796q.poll();
                        if (observableSource == null) {
                            this.f31797r--;
                        } else {
                            m32435a(observableSource);
                        }
                    }
                } else {
                    continue;
                }
            }
        }

        private boolean m32438f() {
            if (this.f31790i) {
                return true;
            }
            Throwable th = (Throwable) this.f31789h.get();
            if (this.f31784c || th == null) {
                return false;
            }
            m32443e();
            th = ExceptionHelper.m26683a(this.f31789h);
            if (th != ExceptionHelper.f25187a) {
                this.f31782a.onError(th);
            }
            return true;
        }

        final boolean m32443e() {
            this.f31792m.mo5626a();
            int i = 0;
            if (((InnerObserver[]) this.f31791j.get()) != f31781l) {
                InnerObserver[] innerObserverArr = (InnerObserver[]) this.f31791j.getAndSet(f31781l);
                if (innerObserverArr != f31781l) {
                    int length = innerObserverArr.length;
                    while (i < length) {
                        DisposableHelper.m32090a(innerObserverArr[i]);
                        i++;
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public ObservableFlatMap(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends U>> function, boolean z, int i, int i2) {
        super(observableSource);
        this.f38000a = function;
        this.f38001b = z;
        this.f38002c = i;
        this.f38003d = i2;
    }

    public final void subscribeActual(Observer<? super U> observer) {
        if (!ObservableScalarXMap.m26648a(this.source, observer, this.f38000a)) {
            this.source.subscribe(new MergeObserver(observer, this.f38000a, this.f38001b, this.f38002c, this.f38003d));
        }
    }
}
