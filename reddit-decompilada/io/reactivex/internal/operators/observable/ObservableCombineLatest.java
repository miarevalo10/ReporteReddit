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
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableCombineLatest<T, R> extends Observable<R> {
    final ObservableSource<? extends T>[] f35643a;
    final Iterable<? extends ObservableSource<? extends T>> f35644b;
    final Function<? super Object[], ? extends R> f35645c;
    final int f35646d;
    final boolean f35647e;

    static final class CombinerObserver<T, R> extends AtomicReference<Disposable> implements Observer<T> {
        final LatestCoordinator<T, R> f31636a;
        final int f31637b;

        CombinerObserver(LatestCoordinator<T, R> latestCoordinator, int i) {
            this.f31636a = latestCoordinator;
            this.f31637b = i;
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32092b(this, disposable);
        }

        public final void onNext(T t) {
            this.f31636a.m32385a(this.f31637b, t);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onError(java.lang.Throwable r5) {
            /*
            r4 = this;
            r0 = r4.f31636a;
            r1 = r4.f31637b;
            r2 = r0.f31646i;
            r2 = io.reactivex.internal.util.ExceptionHelper.m26684a(r2, r5);
            if (r2 == 0) goto L_0x003a;
        L_0x000c:
            r5 = r0.f31643f;
            r2 = 1;
            if (r5 == 0) goto L_0x0030;
        L_0x0011:
            monitor-enter(r0);
            r5 = r0.f31641d;	 Catch:{ all -> 0x002d }
            if (r5 != 0) goto L_0x0018;
        L_0x0016:
            monitor-exit(r0);	 Catch:{ all -> 0x002d }
            return;
        L_0x0018:
            r1 = r5[r1];	 Catch:{ all -> 0x002d }
            if (r1 != 0) goto L_0x001e;
        L_0x001c:
            r1 = r2;
            goto L_0x001f;
        L_0x001e:
            r1 = 0;
        L_0x001f:
            if (r1 != 0) goto L_0x0029;
        L_0x0021:
            r3 = r0.f31648k;	 Catch:{ all -> 0x002d }
            r3 = r3 + r2;
            r0.f31648k = r3;	 Catch:{ all -> 0x002d }
            r5 = r5.length;	 Catch:{ all -> 0x002d }
            if (r3 != r5) goto L_0x002b;
        L_0x0029:
            r0.f31645h = r2;	 Catch:{ all -> 0x002d }
        L_0x002b:
            monitor-exit(r0);	 Catch:{ all -> 0x002d }
            goto L_0x0031;
        L_0x002d:
            r5 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x002d }
            throw r5;
        L_0x0030:
            r1 = r2;
        L_0x0031:
            if (r1 == 0) goto L_0x0036;
        L_0x0033:
            r0.m32387c();
        L_0x0036:
            r0.m32388d();
            return;
        L_0x003a:
            io.reactivex.plugins.RxJavaPlugins.m26757a(r5);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableCombineLatest.CombinerObserver.onError(java.lang.Throwable):void");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onComplete() {
            /*
            r5 = this;
            r0 = r5.f31636a;
            r1 = r5.f31637b;
            monitor-enter(r0);
            r2 = r0.f31641d;	 Catch:{ all -> 0x0029 }
            if (r2 != 0) goto L_0x000b;
        L_0x0009:
            monitor-exit(r0);	 Catch:{ all -> 0x0029 }
            return;
        L_0x000b:
            r1 = r2[r1];	 Catch:{ all -> 0x0029 }
            r3 = 1;
            if (r1 != 0) goto L_0x0012;
        L_0x0010:
            r1 = r3;
            goto L_0x0013;
        L_0x0012:
            r1 = 0;
        L_0x0013:
            if (r1 != 0) goto L_0x001d;
        L_0x0015:
            r4 = r0.f31648k;	 Catch:{ all -> 0x0029 }
            r4 = r4 + r3;
            r0.f31648k = r4;	 Catch:{ all -> 0x0029 }
            r2 = r2.length;	 Catch:{ all -> 0x0029 }
            if (r4 != r2) goto L_0x001f;
        L_0x001d:
            r0.f31645h = r3;	 Catch:{ all -> 0x0029 }
        L_0x001f:
            monitor-exit(r0);	 Catch:{ all -> 0x0029 }
            if (r1 == 0) goto L_0x0025;
        L_0x0022:
            r0.m32387c();
        L_0x0025:
            r0.m32388d();
            return;
        L_0x0029:
            r1 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x0029 }
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableCombineLatest.CombinerObserver.onComplete():void");
        }
    }

    static final class LatestCoordinator<T, R> extends AtomicInteger implements Disposable {
        final Observer<? super R> f31638a;
        final Function<? super Object[], ? extends R> f31639b;
        final CombinerObserver<T, R>[] f31640c;
        Object[] f31641d;
        final SpscLinkedArrayQueue<Object[]> f31642e;
        final boolean f31643f;
        volatile boolean f31644g;
        volatile boolean f31645h;
        final AtomicThrowable f31646i = new AtomicThrowable();
        int f31647j;
        int f31648k;

        LatestCoordinator(Observer<? super R> observer, Function<? super Object[], ? extends R> function, int i, int i2, boolean z) {
            this.f31638a = observer;
            this.f31639b = function;
            this.f31643f = z;
            this.f31641d = new Object[i];
            observer = new CombinerObserver[i];
            for (function = null; function < i; function++) {
                observer[function] = new CombinerObserver(this, function);
            }
            this.f31640c = observer;
            this.f31642e = new SpscLinkedArrayQueue(i2);
        }

        public final void mo5626a() {
            if (!this.f31644g) {
                this.f31644g = true;
                m32387c();
                if (getAndIncrement() == 0) {
                    m32383a(this.f31642e);
                }
            }
        }

        public final boolean mo5627b() {
            return this.f31644g;
        }

        final void m32387c() {
            for (AtomicReference a : this.f31640c) {
                DisposableHelper.m32090a(a);
            }
        }

        private void m32383a(SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            synchronized (this) {
                this.f31641d = null;
            }
            spscLinkedArrayQueue.clear();
        }

        final void m32388d() {
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue spscLinkedArrayQueue = this.f31642e;
                Observer observer = this.f31638a;
                boolean z = this.f31643f;
                int i = 1;
                while (!this.f31644g) {
                    if (z || this.f31646i.get() == null) {
                        boolean z2 = this.f31645h;
                        Object[] objArr = (Object[]) spscLinkedArrayQueue.poll();
                        Object obj = objArr == null ? 1 : null;
                        if (z2 && obj != null) {
                            m32383a(spscLinkedArrayQueue);
                            Throwable a = ExceptionHelper.m26683a(this.f31646i);
                            if (a == null) {
                                observer.onComplete();
                                return;
                            } else {
                                observer.onError(a);
                                return;
                            }
                        } else if (obj == null) {
                            try {
                                observer.onNext(ObjectHelper.m26573a(this.f31639b.apply(objArr), "The combiner returned a null value"));
                            } catch (Throwable th) {
                                Exceptions.m26521b(th);
                                ExceptionHelper.m26684a(this.f31646i, th);
                                m32387c();
                                m32383a(spscLinkedArrayQueue);
                                observer.onError(ExceptionHelper.m26683a(this.f31646i));
                                return;
                            }
                        } else {
                            i = addAndGet(-i);
                            if (i == 0) {
                                return;
                            }
                        }
                    } else {
                        m32387c();
                        m32383a(spscLinkedArrayQueue);
                        observer.onError(ExceptionHelper.m26683a(this.f31646i));
                        return;
                    }
                }
                m32383a(spscLinkedArrayQueue);
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        final void m32385a(int r4, T r5) {
            /*
            r3 = this;
            monitor-enter(r3);
            r0 = r3.f31641d;	 Catch:{ all -> 0x0029 }
            if (r0 != 0) goto L_0x0007;
        L_0x0005:
            monitor-exit(r3);	 Catch:{ all -> 0x0029 }
            return;
        L_0x0007:
            r1 = r0[r4];	 Catch:{ all -> 0x0029 }
            r2 = r3.f31647j;	 Catch:{ all -> 0x0029 }
            if (r1 != 0) goto L_0x0011;
        L_0x000d:
            r2 = r2 + 1;
            r3.f31647j = r2;	 Catch:{ all -> 0x0029 }
        L_0x0011:
            r0[r4] = r5;	 Catch:{ all -> 0x0029 }
            r4 = r0.length;	 Catch:{ all -> 0x0029 }
            if (r2 != r4) goto L_0x0021;
        L_0x0016:
            r4 = r3.f31642e;	 Catch:{ all -> 0x0029 }
            r5 = r0.clone();	 Catch:{ all -> 0x0029 }
            r4.offer(r5);	 Catch:{ all -> 0x0029 }
            r4 = 1;
            goto L_0x0022;
        L_0x0021:
            r4 = 0;
        L_0x0022:
            monitor-exit(r3);	 Catch:{ all -> 0x0029 }
            if (r4 == 0) goto L_0x0028;
        L_0x0025:
            r3.m32388d();
        L_0x0028:
            return;
        L_0x0029:
            r4 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x0029 }
            throw r4;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableCombineLatest.LatestCoordinator.a(int, java.lang.Object):void");
        }
    }

    public ObservableCombineLatest(ObservableSource<? extends T>[] observableSourceArr, Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i, boolean z) {
        this.f35643a = observableSourceArr;
        this.f35644b = iterable;
        this.f35645c = function;
        this.f35646d = i;
        this.f35647e = z;
    }

    public final void subscribeActual(Observer<? super R> observer) {
        int i;
        ObservableSource[] observableSourceArr = this.f35643a;
        int i2 = 0;
        if (observableSourceArr == null) {
            Object obj = new Observable[8];
            Object obj2 = obj;
            int i3 = 0;
            for (ObservableSource observableSource : this.f35644b) {
                if (i3 == obj2.length) {
                    Object obj3 = new ObservableSource[((i3 >> 2) + i3)];
                    System.arraycopy(obj2, 0, obj3, 0, i3);
                    obj2 = obj3;
                }
                int i4 = i3 + 1;
                obj2[i3] = observableSource;
                i3 = i4;
            }
            i = i3;
            observableSourceArr = obj2;
        } else {
            i = observableSourceArr.length;
        }
        if (i == 0) {
            EmptyDisposable.m38048a((Observer) observer);
            return;
        }
        LatestCoordinator latestCoordinator = new LatestCoordinator(observer, this.f35645c, i, this.f35646d, this.f35647e);
        observer = latestCoordinator.f31640c;
        int length = observer.length;
        latestCoordinator.f31638a.onSubscribe(latestCoordinator);
        while (i2 < length && !latestCoordinator.f31645h) {
            if (latestCoordinator.f31644g) {
                break;
            }
            observableSourceArr[i2].subscribe(observer[i2]);
            i2++;
        }
    }
}
