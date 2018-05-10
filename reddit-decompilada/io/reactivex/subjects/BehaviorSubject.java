package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList.NonThrowingPredicate;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class BehaviorSubject<T> extends Subject<T> {
    static final BehaviorDisposable[] f38167c = new BehaviorDisposable[0];
    static final BehaviorDisposable[] f38168d = new BehaviorDisposable[0];
    private static final Object[] f38169j = new Object[0];
    final AtomicReference<Object> f38170a = new AtomicReference();
    final AtomicReference<BehaviorDisposable<T>[]> f38171b = new AtomicReference(f38167c);
    final ReadWriteLock f38172e = new ReentrantReadWriteLock();
    final Lock f38173f = this.f38172e.readLock();
    final Lock f38174g = this.f38172e.writeLock();
    final AtomicReference<Throwable> f38175h = new AtomicReference();
    long f38176i;

    static final class BehaviorDisposable<T> implements Disposable, NonThrowingPredicate<Object> {
        final Observer<? super T> f35943a;
        final BehaviorSubject<T> f35944b;
        boolean f35945c;
        boolean f35946d;
        AppendOnlyLinkedArrayList<Object> f35947e;
        boolean f35948f;
        volatile boolean f35949g;
        long f35950h;

        BehaviorDisposable(Observer<? super T> observer, BehaviorSubject<T> behaviorSubject) {
            this.f35943a = observer;
            this.f35944b = behaviorSubject;
        }

        public final void mo5626a() {
            if (!this.f35949g) {
                this.f35949g = true;
                this.f35944b.m38178a(this);
            }
        }

        public final boolean mo5627b() {
            return this.f35949g;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        final void m36024a(java.lang.Object r3, long r4) {
            /*
            r2 = this;
            r0 = r2.f35949g;
            if (r0 == 0) goto L_0x0005;
        L_0x0004:
            return;
        L_0x0005:
            r0 = r2.f35948f;
            if (r0 != 0) goto L_0x0036;
        L_0x0009:
            monitor-enter(r2);
            r0 = r2.f35949g;	 Catch:{ all -> 0x0033 }
            if (r0 == 0) goto L_0x0010;
        L_0x000e:
            monitor-exit(r2);	 Catch:{ all -> 0x0033 }
            return;
        L_0x0010:
            r0 = r2.f35950h;	 Catch:{ all -> 0x0033 }
            r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
            if (r4 != 0) goto L_0x0018;
        L_0x0016:
            monitor-exit(r2);	 Catch:{ all -> 0x0033 }
            return;
        L_0x0018:
            r4 = r2.f35946d;	 Catch:{ all -> 0x0033 }
            if (r4 == 0) goto L_0x002c;
        L_0x001c:
            r4 = r2.f35947e;	 Catch:{ all -> 0x0033 }
            if (r4 != 0) goto L_0x0027;
        L_0x0020:
            r4 = new io.reactivex.internal.util.AppendOnlyLinkedArrayList;	 Catch:{ all -> 0x0033 }
            r4.<init>();	 Catch:{ all -> 0x0033 }
            r2.f35947e = r4;	 Catch:{ all -> 0x0033 }
        L_0x0027:
            r4.m26667a(r3);	 Catch:{ all -> 0x0033 }
            monitor-exit(r2);	 Catch:{ all -> 0x0033 }
            return;
        L_0x002c:
            r4 = 1;
            r2.f35945c = r4;	 Catch:{ all -> 0x0033 }
            monitor-exit(r2);	 Catch:{ all -> 0x0033 }
            r2.f35948f = r4;
            goto L_0x0036;
        L_0x0033:
            r3 = move-exception;
            monitor-exit(r2);	 Catch:{ all -> 0x0033 }
            throw r3;
        L_0x0036:
            r2.test(r3);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.subjects.BehaviorSubject.BehaviorDisposable.a(java.lang.Object, long):void");
        }

        public final boolean test(Object obj) {
            if (!this.f35949g) {
                if (NotificationLite.m26699a(obj, this.f35943a) == null) {
                    return null;
                }
            }
            return true;
        }
    }

    public static <T> BehaviorSubject<T> m38175a() {
        return new BehaviorSubject();
    }

    BehaviorSubject() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final void subscribeActual(io.reactivex.Observer<? super T> r8) {
        /*
        r7 = this;
        r0 = new io.reactivex.subjects.BehaviorSubject$BehaviorDisposable;
        r0.<init>(r8, r7);
        r8.onSubscribe(r0);
    L_0x0008:
        r1 = r7.f38171b;
        r1 = r1.get();
        r1 = (io.reactivex.subjects.BehaviorSubject.BehaviorDisposable[]) r1;
        r2 = f38168d;
        r3 = 1;
        r4 = 0;
        if (r1 != r2) goto L_0x0018;
    L_0x0016:
        r1 = r4;
        goto L_0x002b;
    L_0x0018:
        r2 = r1.length;
        r5 = r2 + 1;
        r5 = new io.reactivex.subjects.BehaviorSubject.BehaviorDisposable[r5];
        java.lang.System.arraycopy(r1, r4, r5, r4, r2);
        r5[r2] = r0;
        r2 = r7.f38171b;
        r1 = r2.compareAndSet(r1, r5);
        if (r1 == 0) goto L_0x0008;
    L_0x002a:
        r1 = r3;
    L_0x002b:
        if (r1 == 0) goto L_0x0088;
    L_0x002d:
        r8 = r0.f35949g;
        if (r8 == 0) goto L_0x0035;
    L_0x0031:
        r7.m38178a(r0);
        return;
    L_0x0035:
        r8 = r0.f35949g;
        if (r8 != 0) goto L_0x0087;
    L_0x0039:
        monitor-enter(r0);
        r8 = r0.f35949g;	 Catch:{ all -> 0x0084 }
        if (r8 == 0) goto L_0x0040;
    L_0x003e:
        monitor-exit(r0);	 Catch:{ all -> 0x0084 }
        return;
    L_0x0040:
        r8 = r0.f35945c;	 Catch:{ all -> 0x0084 }
        if (r8 == 0) goto L_0x0046;
    L_0x0044:
        monitor-exit(r0);	 Catch:{ all -> 0x0084 }
        return;
    L_0x0046:
        r8 = r0.f35944b;	 Catch:{ all -> 0x0084 }
        r1 = r8.f38173f;	 Catch:{ all -> 0x0084 }
        r1.lock();	 Catch:{ all -> 0x0084 }
        r5 = r8.f38176i;	 Catch:{ all -> 0x0084 }
        r0.f35950h = r5;	 Catch:{ all -> 0x0084 }
        r8 = r8.f38170a;	 Catch:{ all -> 0x0084 }
        r8 = r8.get();	 Catch:{ all -> 0x0084 }
        r1.unlock();	 Catch:{ all -> 0x0084 }
        if (r8 == 0) goto L_0x005e;
    L_0x005c:
        r1 = r3;
        goto L_0x005f;
    L_0x005e:
        r1 = r4;
    L_0x005f:
        r0.f35946d = r1;	 Catch:{ all -> 0x0084 }
        r0.f35945c = r3;	 Catch:{ all -> 0x0084 }
        monitor-exit(r0);	 Catch:{ all -> 0x0084 }
        if (r8 == 0) goto L_0x0087;
    L_0x0066:
        r8 = r0.test(r8);
        if (r8 != 0) goto L_0x0087;
    L_0x006c:
        r8 = r0.f35949g;
        if (r8 != 0) goto L_0x0087;
    L_0x0070:
        monitor-enter(r0);
        r8 = r0.f35947e;	 Catch:{ all -> 0x0081 }
        if (r8 != 0) goto L_0x0079;
    L_0x0075:
        r0.f35946d = r4;	 Catch:{ all -> 0x0081 }
        monitor-exit(r0);	 Catch:{ all -> 0x0081 }
        return;
    L_0x0079:
        r1 = 0;
        r0.f35947e = r1;	 Catch:{ all -> 0x0081 }
        monitor-exit(r0);	 Catch:{ all -> 0x0081 }
        r8.m26666a(r0);
        goto L_0x006c;
    L_0x0081:
        r8 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0081 }
        throw r8;
    L_0x0084:
        r8 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0084 }
        throw r8;
    L_0x0087:
        return;
    L_0x0088:
        r0 = r7.f38175h;
        r0 = r0.get();
        r0 = (java.lang.Throwable) r0;
        r1 = io.reactivex.internal.util.ExceptionHelper.f25187a;
        if (r0 != r1) goto L_0x0098;
    L_0x0094:
        r8.onComplete();
        return;
    L_0x0098:
        r8.onError(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.subjects.BehaviorSubject.subscribeActual(io.reactivex.Observer):void");
    }

    public final void onSubscribe(Disposable disposable) {
        if (this.f38175h.get() != null) {
            disposable.mo5626a();
        }
    }

    public final void onNext(T t) {
        ObjectHelper.m26573a((Object) t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f38175h.get() == null) {
            t = NotificationLite.m26696a((Object) t);
            m38177b(t);
            for (BehaviorDisposable a : (BehaviorDisposable[]) this.f38171b.get()) {
                a.m36024a(t, this.f38176i);
            }
        }
    }

    public final void onError(Throwable th) {
        ObjectHelper.m26573a((Object) th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f38175h.compareAndSet(null, th)) {
            Object a = NotificationLite.m26697a(th);
            for (BehaviorDisposable a2 : m38176a(a)) {
                a2.m36024a(a, this.f38176i);
            }
            return;
        }
        RxJavaPlugins.m26757a(th);
    }

    public final void onComplete() {
        if (this.f38175h.compareAndSet(null, ExceptionHelper.f25187a)) {
            Object a = NotificationLite.m26694a();
            for (BehaviorDisposable a2 : m38176a(a)) {
                a2.m36024a(a, this.f38176i);
            }
        }
    }

    public final boolean hasObservers() {
        return ((BehaviorDisposable[]) this.f38171b.get()).length != 0;
    }

    public final Throwable getThrowable() {
        Object obj = this.f38170a.get();
        return NotificationLite.m26704c(obj) ? NotificationLite.m26707f(obj) : null;
    }

    public final T m38179b() {
        Object obj = this.f38170a.get();
        if (!NotificationLite.m26701b(obj)) {
            if (!NotificationLite.m26704c(obj)) {
                return NotificationLite.m26706e(obj);
            }
        }
        return null;
    }

    public final boolean hasComplete() {
        return NotificationLite.m26701b(this.f38170a.get());
    }

    public final boolean hasThrowable() {
        return NotificationLite.m26704c(this.f38170a.get());
    }

    final void m38178a(BehaviorDisposable<T> behaviorDisposable) {
        BehaviorDisposable[] behaviorDisposableArr;
        Object obj;
        do {
            behaviorDisposableArr = (BehaviorDisposable[]) this.f38171b.get();
            if (behaviorDisposableArr != f38168d) {
                if (behaviorDisposableArr != f38167c) {
                    int length = behaviorDisposableArr.length;
                    int i = -1;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (behaviorDisposableArr[i2] == behaviorDisposable) {
                            i = i2;
                            break;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            obj = f38167c;
                        } else {
                            Object obj2 = new BehaviorDisposable[(length - 1)];
                            System.arraycopy(behaviorDisposableArr, 0, obj2, 0, i);
                            System.arraycopy(behaviorDisposableArr, i + 1, obj2, i, (length - i) - 1);
                            obj = obj2;
                        }
                    } else {
                        return;
                    }
                }
            }
            return;
        } while (!this.f38171b.compareAndSet(behaviorDisposableArr, obj));
    }

    private BehaviorDisposable<T>[] m38176a(Object obj) {
        BehaviorDisposable<T>[] behaviorDisposableArr = (BehaviorDisposable[]) this.f38171b.get();
        if (behaviorDisposableArr != f38168d) {
            behaviorDisposableArr = (BehaviorDisposable[]) this.f38171b.getAndSet(f38168d);
            if (behaviorDisposableArr != f38168d) {
                m38177b(obj);
            }
        }
        return behaviorDisposableArr;
    }

    private void m38177b(Object obj) {
        this.f38174g.lock();
        try {
            this.f38176i++;
            this.f38170a.lazySet(obj);
        } finally {
            this.f38174g.unlock();
        }
    }
}
