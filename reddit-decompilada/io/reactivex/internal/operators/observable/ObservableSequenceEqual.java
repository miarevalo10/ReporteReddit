package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableSequenceEqual<T> extends Observable<Boolean> {
    final ObservableSource<? extends T> f35725a;
    final ObservableSource<? extends T> f35726b;
    final BiPredicate<? super T, ? super T> f35727c;
    final int f35728d;

    static final class EqualCoordinator<T> extends AtomicInteger implements Disposable {
        final Observer<? super Boolean> f32076a;
        final BiPredicate<? super T, ? super T> f32077b;
        final ArrayCompositeDisposable f32078c = new ArrayCompositeDisposable();
        final ObservableSource<? extends T> f32079d;
        final ObservableSource<? extends T> f32080e;
        final EqualObserver<T>[] f32081f;
        volatile boolean f32082g;
        T f32083h;
        T f32084i;

        EqualCoordinator(Observer<? super Boolean> observer, int i, ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate) {
            this.f32076a = observer;
            this.f32079d = observableSource;
            this.f32080e = observableSource2;
            this.f32077b = biPredicate;
            observer = new EqualObserver[2];
            this.f32081f = observer;
            observer[0] = new EqualObserver(this, 0, i);
            observer[1] = new EqualObserver(this, 1, i);
        }

        public final void mo5626a() {
            if (!this.f32082g) {
                this.f32082g = true;
                this.f32078c.mo5626a();
                if (getAndIncrement() == 0) {
                    EqualObserver[] equalObserverArr = this.f32081f;
                    equalObserverArr[0].f32086b.clear();
                    equalObserverArr[1].f32086b.clear();
                }
            }
        }

        public final boolean mo5627b() {
            return this.f32082g;
        }

        private void m32594a(SpscLinkedArrayQueue<T> spscLinkedArrayQueue, SpscLinkedArrayQueue<T> spscLinkedArrayQueue2) {
            this.f32082g = true;
            spscLinkedArrayQueue.clear();
            spscLinkedArrayQueue2.clear();
        }

        final void m32597c() {
            if (getAndIncrement() == 0) {
                EqualObserver[] equalObserverArr = this.f32081f;
                EqualObserver equalObserver = equalObserverArr[0];
                SpscLinkedArrayQueue spscLinkedArrayQueue = equalObserver.f32086b;
                EqualObserver equalObserver2 = equalObserverArr[1];
                SpscLinkedArrayQueue spscLinkedArrayQueue2 = equalObserver2.f32086b;
                int i = 1;
                while (!this.f32082g) {
                    boolean z = equalObserver.f32088d;
                    if (z) {
                        Throwable th = equalObserver.f32089e;
                        if (th != null) {
                            m32594a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                            this.f32076a.onError(th);
                            return;
                        }
                    }
                    boolean z2 = equalObserver2.f32088d;
                    if (z2) {
                        Throwable th2 = equalObserver2.f32089e;
                        if (th2 != null) {
                            m32594a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                            this.f32076a.onError(th2);
                            return;
                        }
                    }
                    if (this.f32083h == null) {
                        this.f32083h = spscLinkedArrayQueue.poll();
                    }
                    boolean z3 = this.f32083h == null;
                    if (this.f32084i == null) {
                        this.f32084i = spscLinkedArrayQueue2.poll();
                    }
                    boolean z4 = this.f32084i == null;
                    if (z && z2 && z3 && z4) {
                        this.f32076a.onNext(Boolean.valueOf(true));
                        this.f32076a.onComplete();
                        return;
                    } else if (z && z2 && z3 != z4) {
                        m32594a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                        this.f32076a.onNext(Boolean.valueOf(false));
                        this.f32076a.onComplete();
                        return;
                    } else {
                        if (!(z3 || z4)) {
                            try {
                                if (this.f32077b.mo4928a(this.f32083h, this.f32084i)) {
                                    this.f32083h = null;
                                    this.f32084i = null;
                                } else {
                                    m32594a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                                    this.f32076a.onNext(Boolean.valueOf(false));
                                    this.f32076a.onComplete();
                                    return;
                                }
                            } catch (Throwable th3) {
                                Exceptions.m26521b(th3);
                                m32594a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                                this.f32076a.onError(th3);
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
        final EqualCoordinator<T> f32085a;
        final SpscLinkedArrayQueue<T> f32086b;
        final int f32087c;
        volatile boolean f32088d;
        Throwable f32089e;

        EqualObserver(EqualCoordinator<T> equalCoordinator, int i, int i2) {
            this.f32085a = equalCoordinator;
            this.f32087c = i;
            this.f32086b = new SpscLinkedArrayQueue(i2);
        }

        public final void onSubscribe(Disposable disposable) {
            EqualCoordinator equalCoordinator = this.f32085a;
            equalCoordinator.f32078c.m32086a(this.f32087c, disposable);
        }

        public final void onNext(T t) {
            this.f32086b.offer(t);
            this.f32085a.m32597c();
        }

        public final void onError(Throwable th) {
            this.f32089e = th;
            this.f32088d = true;
            this.f32085a.m32597c();
        }

        public final void onComplete() {
            this.f32088d = true;
            this.f32085a.m32597c();
        }
    }

    public ObservableSequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate, int i) {
        this.f35725a = observableSource;
        this.f35726b = observableSource2;
        this.f35727c = biPredicate;
        this.f35728d = i;
    }

    public final void subscribeActual(Observer<? super Boolean> observer) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(observer, this.f35728d, this.f35725a, this.f35726b, this.f35727c);
        observer.onSubscribe(equalCoordinator);
        observer = equalCoordinator.f32081f;
        equalCoordinator.f32079d.subscribe(observer[0]);
        equalCoordinator.f32080e.subscribe(observer[1]);
    }
}
