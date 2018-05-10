package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;

public final class SerializedObserver<T> implements Observer<T>, Disposable {
    final Observer<? super T> f32474a;
    final boolean f32475b;
    Disposable f32476c;
    boolean f32477d;
    AppendOnlyLinkedArrayList<Object> f32478e;
    volatile boolean f32479f;

    public SerializedObserver(Observer<? super T> observer) {
        this(observer, (byte) 0);
    }

    private SerializedObserver(Observer<? super T> observer, byte b) {
        this.f32474a = observer;
        this.f32475b = null;
    }

    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.m32089a(this.f32476c, disposable)) {
            this.f32476c = disposable;
            this.f32474a.onSubscribe(this);
        }
    }

    public final void mo5626a() {
        this.f32476c.mo5626a();
    }

    public final boolean mo5627b() {
        return this.f32476c.mo5627b();
    }

    public final void onNext(T t) {
        if (!this.f32479f) {
            if (t == null) {
                this.f32476c.mo5626a();
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            synchronized (this) {
                if (this.f32479f) {
                } else if (this.f32477d) {
                    AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.f32478e;
                    if (appendOnlyLinkedArrayList == null) {
                        appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList();
                        this.f32478e = appendOnlyLinkedArrayList;
                    }
                    appendOnlyLinkedArrayList.m26667a(NotificationLite.m26696a((Object) t));
                } else {
                    this.f32477d = true;
                    this.f32474a.onNext(t);
                    m32793c();
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onError(java.lang.Throwable r4) {
        /*
        r3 = this;
        r0 = r3.f32479f;
        if (r0 == 0) goto L_0x0008;
    L_0x0004:
        io.reactivex.plugins.RxJavaPlugins.m26757a(r4);
        return;
    L_0x0008:
        monitor-enter(r3);
        r0 = r3.f32479f;	 Catch:{ all -> 0x0045 }
        r1 = 0;
        r2 = 1;
        if (r0 == 0) goto L_0x0011;
    L_0x000f:
        r1 = r2;
        goto L_0x0038;
    L_0x0011:
        r0 = r3.f32477d;	 Catch:{ all -> 0x0045 }
        if (r0 == 0) goto L_0x0034;
    L_0x0015:
        r3.f32479f = r2;	 Catch:{ all -> 0x0045 }
        r0 = r3.f32478e;	 Catch:{ all -> 0x0045 }
        if (r0 != 0) goto L_0x0022;
    L_0x001b:
        r0 = new io.reactivex.internal.util.AppendOnlyLinkedArrayList;	 Catch:{ all -> 0x0045 }
        r0.<init>();	 Catch:{ all -> 0x0045 }
        r3.f32478e = r0;	 Catch:{ all -> 0x0045 }
    L_0x0022:
        r4 = io.reactivex.internal.util.NotificationLite.m26697a(r4);	 Catch:{ all -> 0x0045 }
        r2 = r3.f32475b;	 Catch:{ all -> 0x0045 }
        if (r2 == 0) goto L_0x002e;
    L_0x002a:
        r0.m26667a(r4);	 Catch:{ all -> 0x0045 }
        goto L_0x0032;
    L_0x002e:
        r0 = r0.f25180b;	 Catch:{ all -> 0x0045 }
        r0[r1] = r4;	 Catch:{ all -> 0x0045 }
    L_0x0032:
        monitor-exit(r3);	 Catch:{ all -> 0x0045 }
        return;
    L_0x0034:
        r3.f32479f = r2;	 Catch:{ all -> 0x0045 }
        r3.f32477d = r2;	 Catch:{ all -> 0x0045 }
    L_0x0038:
        monitor-exit(r3);	 Catch:{ all -> 0x0045 }
        if (r1 == 0) goto L_0x003f;
    L_0x003b:
        io.reactivex.plugins.RxJavaPlugins.m26757a(r4);
        return;
    L_0x003f:
        r0 = r3.f32474a;
        r0.onError(r4);
        return;
    L_0x0045:
        r4 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0045 }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.observers.SerializedObserver.onError(java.lang.Throwable):void");
    }

    public final void onComplete() {
        if (!this.f32479f) {
            synchronized (this) {
                if (this.f32479f) {
                } else if (this.f32477d) {
                    AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.f32478e;
                    if (appendOnlyLinkedArrayList == null) {
                        appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList();
                        this.f32478e = appendOnlyLinkedArrayList;
                    }
                    appendOnlyLinkedArrayList.m26667a(NotificationLite.m26694a());
                } else {
                    this.f32479f = true;
                    this.f32477d = true;
                    this.f32474a.onComplete();
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m32793c() {
        /*
        r6 = this;
    L_0x0000:
        monitor-enter(r6);
        r0 = r6.f32478e;	 Catch:{ all -> 0x0030 }
        r1 = 0;
        if (r0 != 0) goto L_0x000a;
    L_0x0006:
        r6.f32477d = r1;	 Catch:{ all -> 0x0030 }
        monitor-exit(r6);	 Catch:{ all -> 0x0030 }
        return;
    L_0x000a:
        r2 = 0;
        r6.f32478e = r2;	 Catch:{ all -> 0x0030 }
        monitor-exit(r6);	 Catch:{ all -> 0x0030 }
        r2 = r6.f32474a;
        r3 = r0.f25180b;
        r0 = r0.f25179a;
    L_0x0014:
        if (r3 == 0) goto L_0x002d;
    L_0x0016:
        r4 = r1;
    L_0x0017:
        if (r4 >= r0) goto L_0x0028;
    L_0x0019:
        r5 = r3[r4];
        if (r5 == 0) goto L_0x0028;
    L_0x001d:
        r5 = io.reactivex.internal.util.NotificationLite.m26702b(r5, r2);
        if (r5 == 0) goto L_0x0025;
    L_0x0023:
        r1 = 1;
        goto L_0x002d;
    L_0x0025:
        r4 = r4 + 1;
        goto L_0x0017;
    L_0x0028:
        r3 = r3[r0];
        r3 = (java.lang.Object[]) r3;
        goto L_0x0014;
    L_0x002d:
        if (r1 == 0) goto L_0x0000;
    L_0x002f:
        return;
    L_0x0030:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0030 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.observers.SerializedObserver.c():void");
    }
}
