package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
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

public final class ObservableSwitchMap<T, R> extends AbstractObservableWithUpstream<T, R> {
    final Function<? super T, ? extends ObservableSource<? extends R>> f38082a;
    final int f38083b;
    final boolean f38084c;

    static final class SwitchMapInnerObserver<T, R> extends AtomicReference<Disposable> implements Observer<R> {
        final SwitchMapObserver<T, R> f32149a;
        final long f32150b;
        final SpscLinkedArrayQueue<R> f32151c;
        volatile boolean f32152d;

        SwitchMapInnerObserver(SwitchMapObserver<T, R> switchMapObserver, long j, int i) {
            this.f32149a = switchMapObserver;
            this.f32150b = j;
            this.f32151c = new SpscLinkedArrayQueue(i);
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32092b(this, disposable);
        }

        public final void onNext(R r) {
            if (this.f32150b == this.f32149a.f32163k) {
                this.f32151c.offer(r);
                this.f32149a.m32620c();
            }
        }

        public final void onError(Throwable th) {
            SwitchMapObserver switchMapObserver = this.f32149a;
            if (this.f32150b == switchMapObserver.f32163k && ExceptionHelper.m26684a(switchMapObserver.f32158e, th)) {
                if (switchMapObserver.f32157d == null) {
                    switchMapObserver.f32161h.mo5626a();
                }
                this.f32152d = true;
                switchMapObserver.m32620c();
                return;
            }
            RxJavaPlugins.m26757a(th);
        }

        public final void onComplete() {
            if (this.f32150b == this.f32149a.f32163k) {
                this.f32152d = true;
                this.f32149a.m32620c();
            }
        }
    }

    static final class SwitchMapObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        static final SwitchMapInnerObserver<Object, Object> f32153j;
        final Observer<? super R> f32154a;
        final Function<? super T, ? extends ObservableSource<? extends R>> f32155b;
        final int f32156c;
        final boolean f32157d;
        final AtomicThrowable f32158e;
        volatile boolean f32159f;
        volatile boolean f32160g;
        Disposable f32161h;
        final AtomicReference<SwitchMapInnerObserver<T, R>> f32162i = new AtomicReference();
        volatile long f32163k;

        static {
            AtomicReference switchMapInnerObserver = new SwitchMapInnerObserver(null, -1, 1);
            f32153j = switchMapInnerObserver;
            DisposableHelper.m32090a(switchMapInnerObserver);
        }

        SwitchMapObserver(Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function, int i, boolean z) {
            this.f32154a = observer;
            this.f32155b = function;
            this.f32156c = i;
            this.f32157d = z;
            this.f32158e = new AtomicThrowable();
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f32161h, disposable)) {
                this.f32161h = disposable;
                this.f32154a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            long j = this.f32163k + 1;
            this.f32163k = j;
            AtomicReference atomicReference = (SwitchMapInnerObserver) this.f32162i.get();
            if (atomicReference != null) {
                DisposableHelper.m32090a(atomicReference);
            }
            try {
                ObservableSource observableSource = (ObservableSource) ObjectHelper.m26573a(this.f32155b.apply(t), "The ObservableSource returned is null");
                Observer switchMapInnerObserver = new SwitchMapInnerObserver(this, j, this.f32156c);
                SwitchMapInnerObserver switchMapInnerObserver2;
                do {
                    switchMapInnerObserver2 = (SwitchMapInnerObserver) this.f32162i.get();
                    if (switchMapInnerObserver2 == f32153j) {
                        break;
                    }
                } while (!this.f32162i.compareAndSet(switchMapInnerObserver2, switchMapInnerObserver));
                observableSource.subscribe(switchMapInnerObserver);
            } catch (T t2) {
                Exceptions.m26521b(t2);
                this.f32161h.mo5626a();
                onError(t2);
            }
        }

        public final void onError(Throwable th) {
            if (this.f32159f || !ExceptionHelper.m26684a(this.f32158e, th)) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            if (this.f32157d == null) {
                m32617d();
            }
            this.f32159f = true;
            m32620c();
        }

        public final void onComplete() {
            if (!this.f32159f) {
                this.f32159f = true;
                m32620c();
            }
        }

        public final void mo5626a() {
            if (!this.f32160g) {
                this.f32160g = true;
                this.f32161h.mo5626a();
                m32617d();
            }
        }

        public final boolean mo5627b() {
            return this.f32160g;
        }

        private void m32617d() {
            if (((SwitchMapInnerObserver) this.f32162i.get()) != f32153j) {
                AtomicReference atomicReference = (SwitchMapInnerObserver) this.f32162i.getAndSet(f32153j);
                if (atomicReference != f32153j && atomicReference != null) {
                    DisposableHelper.m32090a(atomicReference);
                }
            }
        }

        final void m32620c() {
            if (getAndIncrement() == 0) {
                Observer observer = this.f32154a;
                int i = 1;
                while (!this.f32160g) {
                    Object obj = null;
                    if (this.f32159f) {
                        Object obj2 = this.f32162i.get() == null ? 1 : null;
                        if (this.f32157d) {
                            if (obj2 != null) {
                                Throwable th = (Throwable) this.f32158e.get();
                                if (th != null) {
                                    observer.onError(th);
                                    return;
                                } else {
                                    observer.onComplete();
                                    return;
                                }
                            }
                        } else if (((Throwable) this.f32158e.get()) != null) {
                            observer.onError(ExceptionHelper.m26683a(this.f32158e));
                            return;
                        } else if (obj2 != null) {
                            observer.onComplete();
                            return;
                        }
                    }
                    SwitchMapInnerObserver switchMapInnerObserver = (SwitchMapInnerObserver) this.f32162i.get();
                    if (switchMapInnerObserver != null) {
                        boolean isEmpty;
                        SpscLinkedArrayQueue spscLinkedArrayQueue = switchMapInnerObserver.f32151c;
                        if (switchMapInnerObserver.f32152d) {
                            isEmpty = spscLinkedArrayQueue.isEmpty();
                            if (this.f32157d) {
                                if (isEmpty) {
                                    this.f32162i.compareAndSet(switchMapInnerObserver, null);
                                }
                            } else if (((Throwable) this.f32158e.get()) != null) {
                                observer.onError(ExceptionHelper.m26683a(this.f32158e));
                                return;
                            } else if (isEmpty) {
                                this.f32162i.compareAndSet(switchMapInnerObserver, null);
                            }
                        }
                        while (!this.f32160g) {
                            if (switchMapInnerObserver == this.f32162i.get()) {
                                if (this.f32157d || ((Throwable) this.f32158e.get()) == null) {
                                    isEmpty = switchMapInnerObserver.f32152d;
                                    Object poll = spscLinkedArrayQueue.poll();
                                    Object obj3 = poll == null ? 1 : null;
                                    if (isEmpty && obj3 != null) {
                                        this.f32162i.compareAndSet(switchMapInnerObserver, null);
                                    } else if (obj3 == null) {
                                        observer.onNext(poll);
                                    } else if (obj != null) {
                                        continue;
                                    }
                                } else {
                                    observer.onError(ExceptionHelper.m26683a(this.f32158e));
                                    return;
                                }
                            }
                            obj = 1;
                            if (obj != null) {
                                continue;
                            }
                        }
                        return;
                    }
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }
    }

    public ObservableSwitchMap(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends R>> function, int i, boolean z) {
        super(observableSource);
        this.f38082a = function;
        this.f38083b = i;
        this.f38084c = z;
    }

    public final void subscribeActual(Observer<? super R> observer) {
        if (!ObservableScalarXMap.m26648a(this.source, observer, this.f38082a)) {
            this.source.subscribe(new SwitchMapObserver(observer, this.f38082a, this.f38083b, this.f38084c));
        }
    }
}
