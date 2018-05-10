package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList.NonThrowingPredicate;
import io.reactivex.internal.util.NotificationLite;

final class SerializedSubject<T> extends Subject<T> implements NonThrowingPredicate<Object> {
    final Subject<T> f38177a;
    boolean f38178b;
    AppendOnlyLinkedArrayList<Object> f38179c;
    volatile boolean f38180d;

    SerializedSubject(Subject<T> subject) {
        this.f38177a = subject;
    }

    protected final void subscribeActual(Observer<? super T> observer) {
        this.f38177a.subscribe((Observer) observer);
    }

    public final void onSubscribe(Disposable disposable) {
        boolean z = true;
        if (!this.f38180d) {
            synchronized (this) {
                if (!this.f38180d) {
                    if (this.f38178b) {
                        AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.f38179c;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList();
                            this.f38179c = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.m26667a(NotificationLite.m26695a(disposable));
                        return;
                    }
                    this.f38178b = true;
                    z = false;
                }
            }
        }
        if (z) {
            disposable.mo5626a();
            return;
        }
        this.f38177a.onSubscribe(disposable);
        m38180a();
    }

    public final void onNext(T t) {
        if (!this.f38180d) {
            synchronized (this) {
                if (this.f38180d) {
                } else if (this.f38178b) {
                    AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.f38179c;
                    if (appendOnlyLinkedArrayList == null) {
                        appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList();
                        this.f38179c = appendOnlyLinkedArrayList;
                    }
                    appendOnlyLinkedArrayList.m26667a(NotificationLite.m26696a((Object) t));
                } else {
                    this.f38178b = true;
                    this.f38177a.onNext(t);
                    m38180a();
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onError(java.lang.Throwable r4) {
        /*
        r3 = this;
        r0 = r3.f38180d;
        if (r0 == 0) goto L_0x0008;
    L_0x0004:
        io.reactivex.plugins.RxJavaPlugins.m26757a(r4);
        return;
    L_0x0008:
        monitor-enter(r3);
        r0 = r3.f38180d;	 Catch:{ all -> 0x003b }
        r1 = 0;
        r2 = 1;
        if (r0 == 0) goto L_0x0011;
    L_0x000f:
        r1 = r2;
        goto L_0x002e;
    L_0x0011:
        r3.f38180d = r2;	 Catch:{ all -> 0x003b }
        r0 = r3.f38178b;	 Catch:{ all -> 0x003b }
        if (r0 == 0) goto L_0x002c;
    L_0x0017:
        r0 = r3.f38179c;	 Catch:{ all -> 0x003b }
        if (r0 != 0) goto L_0x0022;
    L_0x001b:
        r0 = new io.reactivex.internal.util.AppendOnlyLinkedArrayList;	 Catch:{ all -> 0x003b }
        r0.<init>();	 Catch:{ all -> 0x003b }
        r3.f38179c = r0;	 Catch:{ all -> 0x003b }
    L_0x0022:
        r4 = io.reactivex.internal.util.NotificationLite.m26697a(r4);	 Catch:{ all -> 0x003b }
        r0 = r0.f25180b;	 Catch:{ all -> 0x003b }
        r0[r1] = r4;	 Catch:{ all -> 0x003b }
        monitor-exit(r3);	 Catch:{ all -> 0x003b }
        return;
    L_0x002c:
        r3.f38178b = r2;	 Catch:{ all -> 0x003b }
    L_0x002e:
        monitor-exit(r3);	 Catch:{ all -> 0x003b }
        if (r1 == 0) goto L_0x0035;
    L_0x0031:
        io.reactivex.plugins.RxJavaPlugins.m26757a(r4);
        return;
    L_0x0035:
        r0 = r3.f38177a;
        r0.onError(r4);
        return;
    L_0x003b:
        r4 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x003b }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.subjects.SerializedSubject.onError(java.lang.Throwable):void");
    }

    public final void onComplete() {
        if (!this.f38180d) {
            synchronized (this) {
                if (this.f38180d) {
                    return;
                }
                this.f38180d = true;
                if (this.f38178b) {
                    AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.f38179c;
                    if (appendOnlyLinkedArrayList == null) {
                        appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList();
                        this.f38179c = appendOnlyLinkedArrayList;
                    }
                    appendOnlyLinkedArrayList.m26667a(NotificationLite.m26694a());
                    return;
                }
                this.f38178b = true;
                this.f38177a.onComplete();
            }
        }
    }

    private void m38180a() {
        while (true) {
            AppendOnlyLinkedArrayList appendOnlyLinkedArrayList;
            synchronized (this) {
                appendOnlyLinkedArrayList = this.f38179c;
                if (appendOnlyLinkedArrayList == null) {
                    this.f38178b = false;
                    return;
                }
                this.f38179c = null;
            }
            appendOnlyLinkedArrayList.m26666a((NonThrowingPredicate) this);
        }
    }

    public final boolean test(Object obj) {
        return NotificationLite.m26702b(obj, this.f38177a);
    }

    public final boolean hasObservers() {
        return this.f38177a.hasObservers();
    }

    public final boolean hasThrowable() {
        return this.f38177a.hasThrowable();
    }

    public final Throwable getThrowable() {
        return this.f38177a.getThrowable();
    }

    public final boolean hasComplete() {
        return this.f38177a.hasComplete();
    }
}
