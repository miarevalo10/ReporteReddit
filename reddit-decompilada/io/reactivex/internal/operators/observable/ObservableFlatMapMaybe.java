package io.reactivex.internal.operators.observable;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
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
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableFlatMapMaybe<T, R> extends AbstractObservableWithUpstream<T, R> {
    final Function<? super T, ? extends MaybeSource<? extends R>> f38006a;
    final boolean f38007b;

    static final class FlatMapMaybeObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        final Observer<? super R> f31808a;
        final boolean f31809b;
        final CompositeDisposable f31810c = new CompositeDisposable();
        final AtomicInteger f31811d = new AtomicInteger(1);
        final AtomicThrowable f31812e = new AtomicThrowable();
        final Function<? super T, ? extends MaybeSource<? extends R>> f31813f;
        final AtomicReference<SpscLinkedArrayQueue<R>> f31814g = new AtomicReference();
        Disposable f31815h;
        volatile boolean f31816i;

        final class InnerObserver extends AtomicReference<Disposable> implements MaybeObserver<R>, Disposable {
            final /* synthetic */ FlatMapMaybeObserver f31807a;

            InnerObserver(FlatMapMaybeObserver flatMapMaybeObserver) {
                this.f31807a = flatMapMaybeObserver;
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.m32092b(this, disposable);
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void onSuccess(R r5) {
                /*
                r4 = this;
                r0 = r4.f31807a;
                r1 = r0.f31810c;
                r1.mo5633c(r4);
                r1 = r0.get();
                if (r1 != 0) goto L_0x0051;
            L_0x000d:
                r1 = 1;
                r2 = 0;
                r3 = r0.compareAndSet(r2, r1);
                if (r3 == 0) goto L_0x0051;
            L_0x0015:
                r3 = r0.f31808a;
                r3.onNext(r5);
                r5 = r0.f31811d;
                r5 = r5.decrementAndGet();
                if (r5 != 0) goto L_0x0023;
            L_0x0022:
                goto L_0x0024;
            L_0x0023:
                r1 = r2;
            L_0x0024:
                r5 = r0.f31814g;
                r5 = r5.get();
                r5 = (io.reactivex.internal.queue.SpscLinkedArrayQueue) r5;
                if (r1 == 0) goto L_0x004a;
            L_0x002e:
                if (r5 == 0) goto L_0x0036;
            L_0x0030:
                r5 = r5.isEmpty();
                if (r5 == 0) goto L_0x004a;
            L_0x0036:
                r5 = r0.f31812e;
                r5 = io.reactivex.internal.util.ExceptionHelper.m26683a(r5);
                if (r5 == 0) goto L_0x0044;
            L_0x003e:
                r0 = r0.f31808a;
                r0.onError(r5);
                return;
            L_0x0044:
                r5 = r0.f31808a;
                r5.onComplete();
                return;
            L_0x004a:
                r5 = r0.decrementAndGet();
                if (r5 == 0) goto L_0x0081;
            L_0x0050:
                goto L_0x007e;
            L_0x0051:
                r1 = r0.f31814g;
                r1 = r1.get();
                r1 = (io.reactivex.internal.queue.SpscLinkedArrayQueue) r1;
                if (r1 == 0) goto L_0x005c;
            L_0x005b:
                goto L_0x006e;
            L_0x005c:
                r1 = new io.reactivex.internal.queue.SpscLinkedArrayQueue;
                r2 = io.reactivex.Observable.bufferSize();
                r1.<init>(r2);
                r2 = r0.f31814g;
                r3 = 0;
                r2 = r2.compareAndSet(r3, r1);
                if (r2 == 0) goto L_0x0051;
            L_0x006e:
                monitor-enter(r1);
                r1.offer(r5);	 Catch:{ all -> 0x0082 }
                monitor-exit(r1);	 Catch:{ all -> 0x0082 }
                r5 = r0.f31811d;
                r5.decrementAndGet();
                r5 = r0.getAndIncrement();
                if (r5 != 0) goto L_0x0081;
            L_0x007e:
                r0.m32456d();
            L_0x0081:
                return;
            L_0x0082:
                r5 = move-exception;
                monitor-exit(r1);	 Catch:{ all -> 0x0082 }
                throw r5;
                */
                throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableFlatMapMaybe.FlatMapMaybeObserver.InnerObserver.onSuccess(java.lang.Object):void");
            }

            public final void onError(Throwable th) {
                FlatMapMaybeObserver flatMapMaybeObserver = this.f31807a;
                flatMapMaybeObserver.f31810c.mo5633c(this);
                if (ExceptionHelper.m26684a(flatMapMaybeObserver.f31812e, th)) {
                    if (flatMapMaybeObserver.f31809b == null) {
                        flatMapMaybeObserver.f31815h.mo5626a();
                        flatMapMaybeObserver.f31810c.mo5626a();
                    }
                    flatMapMaybeObserver.f31811d.decrementAndGet();
                    flatMapMaybeObserver.m32455c();
                    return;
                }
                RxJavaPlugins.m26757a(th);
            }

            public final void onComplete() {
                FlatMapMaybeObserver flatMapMaybeObserver = this.f31807a;
                flatMapMaybeObserver.f31810c.mo5633c(this);
                if (flatMapMaybeObserver.get() == 0) {
                    int i = 1;
                    if (flatMapMaybeObserver.compareAndSet(0, 1)) {
                        if (flatMapMaybeObserver.f31811d.decrementAndGet() != 0) {
                            i = 0;
                        }
                        SpscLinkedArrayQueue spscLinkedArrayQueue = (SpscLinkedArrayQueue) flatMapMaybeObserver.f31814g.get();
                        if (i == 0 || !(spscLinkedArrayQueue == null || spscLinkedArrayQueue.isEmpty())) {
                            if (flatMapMaybeObserver.decrementAndGet() != 0) {
                                flatMapMaybeObserver.m32456d();
                                return;
                            }
                        }
                        Throwable a = ExceptionHelper.m26683a(flatMapMaybeObserver.f31812e);
                        if (a != null) {
                            flatMapMaybeObserver.f31808a.onError(a);
                            return;
                        } else {
                            flatMapMaybeObserver.f31808a.onComplete();
                            return;
                        }
                    }
                }
                flatMapMaybeObserver.f31811d.decrementAndGet();
                flatMapMaybeObserver.m32455c();
            }

            public final boolean mo5627b() {
                return DisposableHelper.m32088a((Disposable) get());
            }

            public final void mo5626a() {
                DisposableHelper.m32090a((AtomicReference) this);
            }
        }

        FlatMapMaybeObserver(Observer<? super R> observer, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z) {
            this.f31808a = observer;
            this.f31813f = function;
            this.f31809b = z;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31815h, disposable)) {
                this.f31815h = disposable;
                this.f31808a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            try {
                MaybeSource maybeSource = (MaybeSource) ObjectHelper.m26573a(this.f31813f.apply(t), "The mapper returned a null MaybeSource");
                this.f31811d.getAndIncrement();
                Disposable innerObserver = new InnerObserver(this);
                if (!this.f31816i && this.f31810c.mo5631a(innerObserver)) {
                    maybeSource.subscribe(innerObserver);
                }
            } catch (T t2) {
                Exceptions.m26521b(t2);
                this.f31815h.mo5626a();
                onError(t2);
            }
        }

        public final void onError(Throwable th) {
            this.f31811d.decrementAndGet();
            if (ExceptionHelper.m26684a(this.f31812e, th)) {
                if (this.f31809b == null) {
                    this.f31810c.mo5626a();
                }
                m32455c();
                return;
            }
            RxJavaPlugins.m26757a(th);
        }

        public final void onComplete() {
            this.f31811d.decrementAndGet();
            m32455c();
        }

        public final void mo5626a() {
            this.f31816i = true;
            this.f31815h.mo5626a();
            this.f31810c.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f31816i;
        }

        final void m32455c() {
            if (getAndIncrement() == 0) {
                m32456d();
            }
        }

        private void m32452e() {
            SpscLinkedArrayQueue spscLinkedArrayQueue = (SpscLinkedArrayQueue) this.f31814g.get();
            if (spscLinkedArrayQueue != null) {
                spscLinkedArrayQueue.clear();
            }
        }

        final void m32456d() {
            Observer observer = this.f31808a;
            AtomicInteger atomicInteger = this.f31811d;
            AtomicReference atomicReference = this.f31814g;
            int i = 1;
            while (!this.f31816i) {
                Throwable a;
                if (this.f31809b || ((Throwable) this.f31812e.get()) == null) {
                    Object obj = null;
                    Object obj2 = atomicInteger.get() == 0 ? 1 : null;
                    SpscLinkedArrayQueue spscLinkedArrayQueue = (SpscLinkedArrayQueue) atomicReference.get();
                    Object poll = spscLinkedArrayQueue != null ? spscLinkedArrayQueue.poll() : null;
                    if (poll == null) {
                        obj = 1;
                    }
                    if (obj2 != null && obj != null) {
                        a = ExceptionHelper.m26683a(this.f31812e);
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
                    a = ExceptionHelper.m26683a(this.f31812e);
                    m32452e();
                    observer.onError(a);
                    return;
                }
            }
            m32452e();
        }
    }

    public ObservableFlatMapMaybe(ObservableSource<T> observableSource, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z) {
        super(observableSource);
        this.f38006a = function;
        this.f38007b = z;
    }

    protected final void subscribeActual(Observer<? super R> observer) {
        this.source.subscribe(new FlatMapMaybeObserver(observer, this.f38006a, this.f38007b));
    }
}
