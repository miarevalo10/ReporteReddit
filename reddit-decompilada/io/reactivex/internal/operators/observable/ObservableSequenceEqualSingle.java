package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableSequenceEqualSingle<T> extends Single<Boolean> implements FuseToObservable<Boolean> {
    final ObservableSource<? extends T> f35729a;
    final ObservableSource<? extends T> f35730b;
    final BiPredicate<? super T, ? super T> f35731c;
    final int f35732d;

    static final class EqualCoordinator<T> extends AtomicInteger implements Disposable {
        final SingleObserver<? super Boolean> f32090a;
        final BiPredicate<? super T, ? super T> f32091b;
        final ArrayCompositeDisposable f32092c = new ArrayCompositeDisposable();
        final ObservableSource<? extends T> f32093d;
        final ObservableSource<? extends T> f32094e;
        final EqualObserver<T>[] f32095f;
        volatile boolean f32096g;
        T f32097h;
        T f32098i;

        EqualCoordinator(SingleObserver<? super Boolean> singleObserver, int i, ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate) {
            this.f32090a = singleObserver;
            this.f32093d = observableSource;
            this.f32094e = observableSource2;
            this.f32091b = biPredicate;
            singleObserver = new EqualObserver[2];
            this.f32095f = singleObserver;
            singleObserver[0] = new EqualObserver(this, 0, i);
            singleObserver[1] = new EqualObserver(this, 1, i);
        }

        public final void mo5626a() {
            if (!this.f32096g) {
                this.f32096g = true;
                this.f32092c.mo5626a();
                if (getAndIncrement() == 0) {
                    EqualObserver[] equalObserverArr = this.f32095f;
                    equalObserverArr[0].f32100b.clear();
                    equalObserverArr[1].f32100b.clear();
                }
            }
        }

        public final boolean mo5627b() {
            return this.f32096g;
        }

        private void m32598a(SpscLinkedArrayQueue<T> spscLinkedArrayQueue, SpscLinkedArrayQueue<T> spscLinkedArrayQueue2) {
            this.f32096g = true;
            spscLinkedArrayQueue.clear();
            spscLinkedArrayQueue2.clear();
        }

        final void m32601c() {
            if (getAndIncrement() == 0) {
                EqualObserver[] equalObserverArr = this.f32095f;
                EqualObserver equalObserver = equalObserverArr[0];
                SpscLinkedArrayQueue spscLinkedArrayQueue = equalObserver.f32100b;
                EqualObserver equalObserver2 = equalObserverArr[1];
                SpscLinkedArrayQueue spscLinkedArrayQueue2 = equalObserver2.f32100b;
                int i = 1;
                while (!this.f32096g) {
                    boolean z = equalObserver.f32102d;
                    if (z) {
                        Throwable th = equalObserver.f32103e;
                        if (th != null) {
                            m32598a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                            this.f32090a.onError(th);
                            return;
                        }
                    }
                    boolean z2 = equalObserver2.f32102d;
                    if (z2) {
                        Throwable th2 = equalObserver2.f32103e;
                        if (th2 != null) {
                            m32598a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                            this.f32090a.onError(th2);
                            return;
                        }
                    }
                    if (this.f32097h == null) {
                        this.f32097h = spscLinkedArrayQueue.poll();
                    }
                    boolean z3 = this.f32097h == null;
                    if (this.f32098i == null) {
                        this.f32098i = spscLinkedArrayQueue2.poll();
                    }
                    boolean z4 = this.f32098i == null;
                    if (z && z2 && z3 && z4) {
                        this.f32090a.onSuccess(Boolean.valueOf(true));
                        return;
                    } else if (z && z2 && z3 != z4) {
                        m32598a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                        this.f32090a.onSuccess(Boolean.valueOf(false));
                        return;
                    } else {
                        if (!(z3 || z4)) {
                            try {
                                if (this.f32091b.mo4928a(this.f32097h, this.f32098i)) {
                                    this.f32097h = null;
                                    this.f32098i = null;
                                } else {
                                    m32598a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                                    this.f32090a.onSuccess(Boolean.valueOf(false));
                                    return;
                                }
                            } catch (Throwable th3) {
                                Exceptions.m26521b(th3);
                                m32598a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                                this.f32090a.onError(th3);
                                return;
                            }
                        }
                        if (z3 || z4) {
                            i = addAndGet(-i);
                            if (i == 0) {
                                return;
                            }
                        }
                    }
                }
                spscLinkedArrayQueue.clear();
                spscLinkedArrayQueue2.clear();
            }
        }
    }

    static final class EqualObserver<T> implements Observer<T> {
        final EqualCoordinator<T> f32099a;
        final SpscLinkedArrayQueue<T> f32100b;
        final int f32101c;
        volatile boolean f32102d;
        Throwable f32103e;

        EqualObserver(EqualCoordinator<T> equalCoordinator, int i, int i2) {
            this.f32099a = equalCoordinator;
            this.f32101c = i;
            this.f32100b = new SpscLinkedArrayQueue(i2);
        }

        public final void onSubscribe(Disposable disposable) {
            EqualCoordinator equalCoordinator = this.f32099a;
            equalCoordinator.f32092c.m32086a(this.f32101c, disposable);
        }

        public final void onNext(T t) {
            this.f32100b.offer(t);
            this.f32099a.m32601c();
        }

        public final void onError(Throwable th) {
            this.f32103e = th;
            this.f32102d = true;
            this.f32099a.m32601c();
        }

        public final void onComplete() {
            this.f32102d = true;
            this.f32099a.m32601c();
        }
    }

    public ObservableSequenceEqualSingle(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate, int i) {
        this.f35729a = observableSource;
        this.f35730b = observableSource2;
        this.f35731c = biPredicate;
        this.f35732d = i;
    }

    public final void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(singleObserver, this.f35732d, this.f35729a, this.f35730b, this.f35731c);
        singleObserver.onSubscribe(equalCoordinator);
        singleObserver = equalCoordinator.f32095f;
        equalCoordinator.f32093d.subscribe(singleObserver[0]);
        equalCoordinator.f32094e.subscribe(singleObserver[1]);
    }

    public final Observable<Boolean> mo6641a() {
        return RxJavaPlugins.m26742a(new ObservableSequenceEqual(this.f35729a, this.f35730b, this.f35731c, this.f35732d));
    }
}
