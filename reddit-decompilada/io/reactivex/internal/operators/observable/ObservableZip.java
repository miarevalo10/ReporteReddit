package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableZip<T, R> extends Observable<R> {
    final ObservableSource<? extends T>[] f35756a;
    final Iterable<? extends ObservableSource<? extends T>> f35757b;
    final Function<? super Object[], ? extends R> f35758c;
    final int f35759d;
    final boolean f35760e;

    static final class ZipCoordinator<T, R> extends AtomicInteger implements Disposable {
        final Observer<? super R> f32289a;
        final Function<? super Object[], ? extends R> f32290b;
        final ZipObserver<T, R>[] f32291c;
        final T[] f32292d;
        final boolean f32293e;
        volatile boolean f32294f;

        ZipCoordinator(Observer<? super R> observer, Function<? super Object[], ? extends R> function, int i, boolean z) {
            this.f32289a = observer;
            this.f32290b = function;
            this.f32291c = new ZipObserver[i];
            this.f32292d = (Object[]) new Object[i];
            this.f32293e = z;
        }

        public final void mo5626a() {
            if (!this.f32294f) {
                this.f32294f = true;
                m32675e();
                if (getAndIncrement() == 0) {
                    m32676f();
                }
            }
        }

        public final boolean mo5627b() {
            return this.f32294f;
        }

        private void m32674d() {
            m32676f();
            m32675e();
        }

        private void m32675e() {
            for (ZipObserver zipObserver : this.f32291c) {
                DisposableHelper.m32090a(zipObserver.f32299e);
            }
        }

        private void m32676f() {
            for (ZipObserver zipObserver : this.f32291c) {
                zipObserver.f32296b.clear();
            }
        }

        public final void m32679c() {
            ZipCoordinator zipCoordinator = this;
            if (getAndIncrement() == 0) {
                ZipObserver[] zipObserverArr = zipCoordinator.f32291c;
                Observer observer = zipCoordinator.f32289a;
                Object obj = zipCoordinator.f32292d;
                boolean z = zipCoordinator.f32293e;
                int i = 1;
                while (true) {
                    int length = zipObserverArr.length;
                    int i2 = 0;
                    int i3 = i2;
                    int i4 = i3;
                    while (i2 < length) {
                        ZipObserver zipObserver = zipObserverArr[i2];
                        Throwable th;
                        if (obj[i3] == null) {
                            Object obj2;
                            boolean z2 = zipObserver.f32297c;
                            Object poll = zipObserver.f32296b.poll();
                            Object obj3 = poll == null ? 1 : null;
                            if (zipCoordinator.f32294f) {
                                m32674d();
                            } else {
                                if (z2) {
                                    if (!z) {
                                        th = zipObserver.f32298d;
                                        if (th != null) {
                                            m32674d();
                                            observer.onError(th);
                                        } else if (obj3 != null) {
                                            m32674d();
                                            observer.onComplete();
                                        }
                                    } else if (obj3 != null) {
                                        th = zipObserver.f32298d;
                                        m32674d();
                                        if (th != null) {
                                            observer.onError(th);
                                        } else {
                                            observer.onComplete();
                                        }
                                    }
                                }
                                obj2 = null;
                                if (obj2 == null) {
                                    if (obj3 != null) {
                                        obj[i3] = poll;
                                    } else {
                                        i4++;
                                    }
                                } else {
                                    return;
                                }
                            }
                            obj2 = 1;
                            if (obj2 == null) {
                                return;
                            }
                            if (obj3 != null) {
                                i4++;
                            } else {
                                obj[i3] = poll;
                            }
                        } else if (zipObserver.f32297c && !z) {
                            th = zipObserver.f32298d;
                            if (th != null) {
                                m32674d();
                                observer.onError(th);
                                return;
                            }
                        }
                        i3++;
                        i2++;
                    }
                    if (i4 == 0) {
                        try {
                            observer.onNext(ObjectHelper.m26573a(zipCoordinator.f32290b.apply(obj.clone()), "The zipper returned a null value"));
                            Arrays.fill(obj, null);
                        } catch (Throwable th2) {
                            Throwable th3 = th2;
                            Exceptions.m26521b(th3);
                            m32674d();
                            observer.onError(th3);
                            return;
                        }
                    }
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }
    }

    static final class ZipObserver<T, R> implements Observer<T> {
        final ZipCoordinator<T, R> f32295a;
        final SpscLinkedArrayQueue<T> f32296b;
        volatile boolean f32297c;
        Throwable f32298d;
        final AtomicReference<Disposable> f32299e = new AtomicReference();

        ZipObserver(ZipCoordinator<T, R> zipCoordinator, int i) {
            this.f32295a = zipCoordinator;
            this.f32296b = new SpscLinkedArrayQueue(i);
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32092b(this.f32299e, disposable);
        }

        public final void onNext(T t) {
            this.f32296b.offer(t);
            this.f32295a.m32679c();
        }

        public final void onError(Throwable th) {
            this.f32298d = th;
            this.f32297c = true;
            this.f32295a.m32679c();
        }

        public final void onComplete() {
            this.f32297c = true;
            this.f32295a.m32679c();
        }
    }

    public ObservableZip(ObservableSource<? extends T>[] observableSourceArr, Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i, boolean z) {
        this.f35756a = observableSourceArr;
        this.f35757b = iterable;
        this.f35758c = function;
        this.f35759d = i;
        this.f35760e = z;
    }

    public final void subscribeActual(Observer<? super R> observer) {
        Object obj;
        int i;
        Object obj2 = this.f35756a;
        int i2 = 0;
        if (obj2 == null) {
            obj2 = new Observable[8];
            obj = obj2;
            i = 0;
            for (ObservableSource observableSource : this.f35757b) {
                if (i == obj.length) {
                    Object obj3 = new ObservableSource[((i >> 2) + i)];
                    System.arraycopy(obj, 0, obj3, 0, i);
                    obj = obj3;
                }
                int i3 = i + 1;
                obj[i] = observableSource;
                i = i3;
            }
        } else {
            obj = obj2;
            i = obj2.length;
        }
        if (i == 0) {
            EmptyDisposable.m38048a((Observer) observer);
            return;
        }
        Object zipCoordinator = new ZipCoordinator(observer, this.f35758c, i, this.f35760e);
        observer = this.f35759d;
        ZipObserver[] zipObserverArr = zipCoordinator.f32291c;
        int length = zipObserverArr.length;
        for (i3 = 0; i3 < length; i3++) {
            zipObserverArr[i3] = new ZipObserver(zipCoordinator, observer);
        }
        zipCoordinator.lazySet(0);
        zipCoordinator.f32289a.onSubscribe(zipCoordinator);
        while (i2 < length && zipCoordinator.f32294f == null) {
            obj[i2].subscribe(zipObserverArr[i2]);
            i2++;
        }
    }
}
