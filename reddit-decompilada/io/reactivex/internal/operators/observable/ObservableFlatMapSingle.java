package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
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
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableFlatMapSingle<T, R> extends AbstractObservableWithUpstream<T, R> {
    final Function<? super T, ? extends SingleSource<? extends R>> f38008a;
    final boolean f38009b;

    static final class FlatMapSingleObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        final Observer<? super R> f31818a;
        final boolean f31819b;
        final CompositeDisposable f31820c = new CompositeDisposable();
        final AtomicInteger f31821d = new AtomicInteger(1);
        final AtomicThrowable f31822e = new AtomicThrowable();
        final Function<? super T, ? extends SingleSource<? extends R>> f31823f;
        final AtomicReference<SpscLinkedArrayQueue<R>> f31824g = new AtomicReference();
        Disposable f31825h;
        volatile boolean f31826i;

        final class InnerObserver extends AtomicReference<Disposable> implements SingleObserver<R>, Disposable {
            final /* synthetic */ FlatMapSingleObserver f31817a;

            InnerObserver(FlatMapSingleObserver flatMapSingleObserver) {
                this.f31817a = flatMapSingleObserver;
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.m32092b(this, disposable);
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void onSuccess(R r5) {
                /*
                r4 = this;
                r0 = r4.f31817a;
                r1 = r0.f31820c;
                r1.mo5633c(r4);
                r1 = r0.get();
                if (r1 != 0) goto L_0x0051;
            L_0x000d:
                r1 = 1;
                r2 = 0;
                r3 = r0.compareAndSet(r2, r1);
                if (r3 == 0) goto L_0x0051;
            L_0x0015:
                r3 = r0.f31818a;
                r3.onNext(r5);
                r5 = r0.f31821d;
                r5 = r5.decrementAndGet();
                if (r5 != 0) goto L_0x0023;
            L_0x0022:
                goto L_0x0024;
            L_0x0023:
                r1 = r2;
            L_0x0024:
                r5 = r0.f31824g;
                r5 = r5.get();
                r5 = (io.reactivex.internal.queue.SpscLinkedArrayQueue) r5;
                if (r1 == 0) goto L_0x004a;
            L_0x002e:
                if (r5 == 0) goto L_0x0036;
            L_0x0030:
                r5 = r5.isEmpty();
                if (r5 == 0) goto L_0x004a;
            L_0x0036:
                r5 = r0.f31822e;
                r5 = io.reactivex.internal.util.ExceptionHelper.m26683a(r5);
                if (r5 == 0) goto L_0x0044;
            L_0x003e:
                r0 = r0.f31818a;
                r0.onError(r5);
                return;
            L_0x0044:
                r5 = r0.f31818a;
                r5.onComplete();
                return;
            L_0x004a:
                r5 = r0.decrementAndGet();
                if (r5 == 0) goto L_0x0081;
            L_0x0050:
                goto L_0x007e;
            L_0x0051:
                r1 = r0.f31824g;
                r1 = r1.get();
                r1 = (io.reactivex.internal.queue.SpscLinkedArrayQueue) r1;
                if (r1 == 0) goto L_0x005c;
            L_0x005b:
                goto L_0x006e;
            L_0x005c:
                r1 = new io.reactivex.internal.queue.SpscLinkedArrayQueue;
                r2 = io.reactivex.Observable.bufferSize();
                r1.<init>(r2);
                r2 = r0.f31824g;
                r3 = 0;
                r2 = r2.compareAndSet(r3, r1);
                if (r2 == 0) goto L_0x0051;
            L_0x006e:
                monitor-enter(r1);
                r1.offer(r5);	 Catch:{ all -> 0x0082 }
                monitor-exit(r1);	 Catch:{ all -> 0x0082 }
                r5 = r0.f31821d;
                r5.decrementAndGet();
                r5 = r0.getAndIncrement();
                if (r5 != 0) goto L_0x0081;
            L_0x007e:
                r0.m32463d();
            L_0x0081:
                return;
            L_0x0082:
                r5 = move-exception;
                monitor-exit(r1);	 Catch:{ all -> 0x0082 }
                throw r5;
                */
                throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableFlatMapSingle.FlatMapSingleObserver.InnerObserver.onSuccess(java.lang.Object):void");
            }

            public final void onError(Throwable th) {
                FlatMapSingleObserver flatMapSingleObserver = this.f31817a;
                flatMapSingleObserver.f31820c.mo5633c(this);
                if (ExceptionHelper.m26684a(flatMapSingleObserver.f31822e, th)) {
                    if (flatMapSingleObserver.f31819b == null) {
                        flatMapSingleObserver.f31825h.mo5626a();
                        flatMapSingleObserver.f31820c.mo5626a();
                    }
                    flatMapSingleObserver.f31821d.decrementAndGet();
                    flatMapSingleObserver.m32462c();
                    return;
                }
                RxJavaPlugins.m26757a(th);
            }

            public final boolean mo5627b() {
                return DisposableHelper.m32088a((Disposable) get());
            }

            public final void mo5626a() {
                DisposableHelper.m32090a((AtomicReference) this);
            }
        }

        FlatMapSingleObserver(Observer<? super R> observer, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z) {
            this.f31818a = observer;
            this.f31823f = function;
            this.f31819b = z;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31825h, disposable)) {
                this.f31825h = disposable;
                this.f31818a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            try {
                SingleSource singleSource = (SingleSource) ObjectHelper.m26573a(this.f31823f.apply(t), "The mapper returned a null SingleSource");
                this.f31821d.getAndIncrement();
                Disposable innerObserver = new InnerObserver(this);
                if (!this.f31826i && this.f31820c.mo5631a(innerObserver)) {
                    singleSource.subscribe(innerObserver);
                }
            } catch (T t2) {
                Exceptions.m26521b(t2);
                this.f31825h.mo5626a();
                onError(t2);
            }
        }

        public final void onError(Throwable th) {
            this.f31821d.decrementAndGet();
            if (ExceptionHelper.m26684a(this.f31822e, th)) {
                if (this.f31819b == null) {
                    this.f31820c.mo5626a();
                }
                m32462c();
                return;
            }
            RxJavaPlugins.m26757a(th);
        }

        public final void onComplete() {
            this.f31821d.decrementAndGet();
            m32462c();
        }

        public final void mo5626a() {
            this.f31826i = true;
            this.f31825h.mo5626a();
            this.f31820c.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f31826i;
        }

        final void m32462c() {
            if (getAndIncrement() == 0) {
                m32463d();
            }
        }

        private void m32459e() {
            SpscLinkedArrayQueue spscLinkedArrayQueue = (SpscLinkedArrayQueue) this.f31824g.get();
            if (spscLinkedArrayQueue != null) {
                spscLinkedArrayQueue.clear();
            }
        }

        final void m32463d() {
            Observer observer = this.f31818a;
            AtomicInteger atomicInteger = this.f31821d;
            AtomicReference atomicReference = this.f31824g;
            int i = 1;
            while (!this.f31826i) {
                Throwable a;
                if (this.f31819b || ((Throwable) this.f31822e.get()) == null) {
                    Object obj = null;
                    Object obj2 = atomicInteger.get() == 0 ? 1 : null;
                    SpscLinkedArrayQueue spscLinkedArrayQueue = (SpscLinkedArrayQueue) atomicReference.get();
                    Object poll = spscLinkedArrayQueue != null ? spscLinkedArrayQueue.poll() : null;
                    if (poll == null) {
                        obj = 1;
                    }
                    if (obj2 != null && obj != null) {
                        a = ExceptionHelper.m26683a(this.f31822e);
                        if (a != null) {
                            observer.onError(a);
                            return;
                        } else {
                            observer.onComplete();
                            return;
                        }
                    } else if (obj == null) {
                        observer.onNext(poll);
                    } else {
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    }
                } else {
                    a = ExceptionHelper.m26683a(this.f31822e);
                    m32459e();
                    observer.onError(a);
                    return;
                }
            }
            m32459e();
        }
    }

    public ObservableFlatMapSingle(ObservableSource<T> observableSource, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z) {
        super(observableSource);
        this.f38008a = function;
        this.f38009b = z;
    }

    protected final void subscribeActual(Observer<? super R> observer) {
        this.source.subscribe(new FlatMapSingleObserver(observer, this.f38008a, this.f38009b));
    }
}
