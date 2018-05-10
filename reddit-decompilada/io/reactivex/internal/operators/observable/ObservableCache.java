package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.LinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableCache<T> extends AbstractObservableWithUpstream<T, T> {
    final AtomicBoolean once = new AtomicBoolean();
    final CacheState<T> state;

    static final class CacheState<T> extends LinkedArrayList implements Observer<T> {
        static final ReplayDisposable[] f31613d = new ReplayDisposable[0];
        static final ReplayDisposable[] f31614e = new ReplayDisposable[0];
        final Observable<? extends T> f31615a;
        final SequentialDisposable f31616b = new SequentialDisposable();
        final AtomicReference<ReplayDisposable<T>[]> f31617c = new AtomicReference(f31613d);
        volatile boolean f31618f;
        boolean f31619g;

        CacheState(Observable<? extends T> observable, int i) {
            super(i);
            this.f31615a = observable;
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32091a(this.f31616b, disposable);
        }

        public final void onNext(T t) {
            if (!this.f31619g) {
                m26693a(NotificationLite.m26696a((Object) t));
                for (ReplayDisposable c : (ReplayDisposable[]) this.f31617c.get()) {
                    c.m32378c();
                }
            }
        }

        public final void onError(Throwable th) {
            if (!this.f31619g) {
                this.f31619g = true;
                m26693a(NotificationLite.m26697a(th));
                this.f31616b.mo5626a();
                for (ReplayDisposable c : (ReplayDisposable[]) this.f31617c.getAndSet(f31614e)) {
                    c.m32378c();
                }
            }
        }

        public final void onComplete() {
            if (!this.f31619g) {
                this.f31619g = true;
                m26693a(NotificationLite.m26694a());
                this.f31616b.mo5626a();
                for (ReplayDisposable c : (ReplayDisposable[]) this.f31617c.getAndSet(f31614e)) {
                    c.m32378c();
                }
            }
        }
    }

    static final class ReplayDisposable<T> extends AtomicInteger implements Disposable {
        final Observer<? super T> f31620a;
        final CacheState<T> f31621b;
        Object[] f31622c;
        int f31623d;
        int f31624e;
        volatile boolean f31625f;

        ReplayDisposable(Observer<? super T> observer, CacheState<T> cacheState) {
            this.f31620a = observer;
            this.f31621b = cacheState;
        }

        public final boolean mo5627b() {
            return this.f31625f;
        }

        public final void mo5626a() {
            if (!this.f31625f) {
                this.f31625f = true;
                CacheState cacheState = this.f31621b;
                ReplayDisposable[] replayDisposableArr;
                Object obj;
                do {
                    replayDisposableArr = (ReplayDisposable[]) cacheState.f31617c.get();
                    int length = replayDisposableArr.length;
                    if (length != 0) {
                        int i = -1;
                        for (int i2 = 0; i2 < length; i2++) {
                            if (replayDisposableArr[i2].equals(this)) {
                                i = i2;
                                break;
                            }
                        }
                        if (i < 0) {
                            return;
                        }
                        if (length == 1) {
                            obj = CacheState.f31613d;
                        } else {
                            Object obj2 = new ReplayDisposable[(length - 1)];
                            System.arraycopy(replayDisposableArr, 0, obj2, 0, i);
                            System.arraycopy(replayDisposableArr, i + 1, obj2, i, (length - i) - 1);
                            obj = obj2;
                        }
                    } else {
                        return;
                    }
                } while (!cacheState.f31617c.compareAndSet(replayDisposableArr, obj));
            }
        }

        public final void m32378c() {
            if (getAndIncrement() == 0) {
                Observer observer = this.f31620a;
                int i = 1;
                while (!this.f31625f) {
                    int i2 = this.f31621b.f25193k;
                    if (i2 != 0) {
                        Object[] objArr = this.f31622c;
                        if (objArr == null) {
                            objArr = this.f31621b.f25191i;
                            this.f31622c = objArr;
                        }
                        int length = objArr.length - 1;
                        int i3 = this.f31624e;
                        int i4 = this.f31623d;
                        while (i3 < i2) {
                            if (!this.f31625f) {
                                if (i4 == length) {
                                    objArr = (Object[]) objArr[length];
                                    i4 = 0;
                                }
                                if (!NotificationLite.m26699a(objArr[i4], observer)) {
                                    i4++;
                                    i3++;
                                } else {
                                    return;
                                }
                            }
                            return;
                        }
                        if (!this.f31625f) {
                            this.f31624e = i3;
                            this.f31623d = i4;
                            this.f31622c = objArr;
                        } else {
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

    public static <T> Observable<T> from(Observable<T> observable) {
        return from(observable, 16);
    }

    public static <T> Observable<T> from(Observable<T> observable, int i) {
        ObjectHelper.m26569a(i, "capacityHint");
        return RxJavaPlugins.m26742a(new ObservableCache(observable, new CacheState(observable, i)));
    }

    private ObservableCache(Observable<T> observable, CacheState<T> cacheState) {
        super(observable);
        this.state = cacheState;
    }

    protected final void subscribeActual(Observer<? super T> observer) {
        Object replayDisposable = new ReplayDisposable(observer, this.state);
        observer.onSubscribe(replayDisposable);
        observer = this.state;
        ReplayDisposable[] replayDisposableArr;
        Object obj;
        do {
            replayDisposableArr = (ReplayDisposable[]) observer.f31617c.get();
            if (replayDisposableArr == CacheState.f31614e) {
                break;
            }
            int length = replayDisposableArr.length;
            obj = new ReplayDisposable[(length + 1)];
            System.arraycopy(replayDisposableArr, 0, obj, 0, length);
            obj[length] = replayDisposable;
        } while (!observer.f31617c.compareAndSet(replayDisposableArr, obj));
        if (this.once.get() == null && this.once.compareAndSet(false, true) != null) {
            Observer observer2 = this.state;
            observer2.f31615a.subscribe(observer2);
            observer2.f31618f = true;
        }
        replayDisposable.m32378c();
    }

    final boolean isConnected() {
        return this.state.f31618f;
    }

    final boolean hasObservers() {
        return ((ReplayDisposable[]) this.state.f31617c.get()).length != 0;
    }

    final int cachedEventCount() {
        return this.state.f25193k;
    }
}
