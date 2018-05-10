package rx.observers;

import rx.Observer;
import rx.exceptions.Exceptions;
import rx.internal.operators.NotificationLite;

public class SerializedObserver<T> implements Observer<T> {
    private final Observer<? super T> f41816a;
    private boolean f41817b;
    private volatile boolean f41818c;
    private FastList f41819d;
    private final NotificationLite<T> f41820e = NotificationLite.m43450a();

    static final class FastList {
        Object[] f41386a;
        int f41387b;

        FastList() {
        }

        public final void m43486a(Object obj) {
            int i = this.f41387b;
            Object[] objArr = this.f41386a;
            if (objArr == null) {
                objArr = new Object[16];
                this.f41386a = objArr;
            } else if (i == objArr.length) {
                Object obj2 = new Object[((i >> 2) + i)];
                System.arraycopy(objArr, 0, obj2, 0, i);
                this.f41386a = obj2;
                objArr = obj2;
            }
            objArr[i] = obj;
            this.f41387b = i + 1;
        }
    }

    public SerializedObserver(Observer<? super T> observer) {
        this.f41816a = observer;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a_(T r7) {
        /*
        r6 = this;
        r0 = r6.f41818c;
        if (r0 == 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        monitor-enter(r6);
        r0 = r6.f41818c;	 Catch:{ all -> 0x006e }
        if (r0 == 0) goto L_0x000c;
    L_0x000a:
        monitor-exit(r6);	 Catch:{ all -> 0x006e }
        return;
    L_0x000c:
        r0 = r6.f41817b;	 Catch:{ all -> 0x006e }
        if (r0 == 0) goto L_0x0024;
    L_0x0010:
        r0 = r6.f41819d;	 Catch:{ all -> 0x006e }
        if (r0 != 0) goto L_0x001b;
    L_0x0014:
        r0 = new rx.observers.SerializedObserver$FastList;	 Catch:{ all -> 0x006e }
        r0.<init>();	 Catch:{ all -> 0x006e }
        r6.f41819d = r0;	 Catch:{ all -> 0x006e }
    L_0x001b:
        r7 = rx.internal.operators.NotificationLite.m43448a(r7);	 Catch:{ all -> 0x006e }
        r0.m43486a(r7);	 Catch:{ all -> 0x006e }
        monitor-exit(r6);	 Catch:{ all -> 0x006e }
        return;
    L_0x0024:
        r0 = 1;
        r6.f41817b = r0;	 Catch:{ all -> 0x006e }
        monitor-exit(r6);	 Catch:{ all -> 0x006e }
        r1 = r6.f41816a;	 Catch:{ Throwable -> 0x0065 }
        r1.a_(r7);	 Catch:{ Throwable -> 0x0065 }
    L_0x002d:
        monitor-enter(r6);
        r1 = r6.f41819d;	 Catch:{ all -> 0x0062 }
        r2 = 0;
        if (r1 != 0) goto L_0x0037;
    L_0x0033:
        r6.f41817b = r2;	 Catch:{ all -> 0x0062 }
        monitor-exit(r6);	 Catch:{ all -> 0x0062 }
        return;
    L_0x0037:
        r3 = 0;
        r6.f41819d = r3;	 Catch:{ all -> 0x0062 }
        monitor-exit(r6);	 Catch:{ all -> 0x0062 }
        r1 = r1.f41386a;
        r3 = r1.length;
    L_0x003e:
        if (r2 >= r3) goto L_0x002d;
    L_0x0040:
        r4 = r1[r2];
        if (r4 == 0) goto L_0x002d;
    L_0x0044:
        r5 = r6.f41816a;	 Catch:{ Throwable -> 0x0052 }
        r4 = rx.internal.operators.NotificationLite.m43451a(r5, r4);	 Catch:{ Throwable -> 0x0052 }
        if (r4 == 0) goto L_0x004f;
    L_0x004c:
        r6.f41818c = r0;	 Catch:{ Throwable -> 0x0052 }
        return;
    L_0x004f:
        r2 = r2 + 1;
        goto L_0x003e;
    L_0x0052:
        r1 = move-exception;
        r6.f41818c = r0;
        rx.exceptions.Exceptions.m43435b(r1);
        r0 = r6.f41816a;
        r7 = rx.exceptions.OnErrorThrowable.m43437a(r1, r7);
        r0.mo7904a(r7);
        return;
    L_0x0062:
        r7 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0062 }
        throw r7;
    L_0x0065:
        r1 = move-exception;
        r6.f41818c = r0;
        r0 = r6.f41816a;
        rx.exceptions.Exceptions.m43433a(r1, r0, r7);
        return;
    L_0x006e:
        r7 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x006e }
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.observers.SerializedObserver.a_(java.lang.Object):void");
    }

    public final void mo7904a(Throwable th) {
        Exceptions.m43435b(th);
        if (!this.f41818c) {
            synchronized (this) {
                if (this.f41818c) {
                    return;
                }
                this.f41818c = true;
                if (this.f41817b) {
                    FastList fastList = this.f41819d;
                    if (fastList == null) {
                        fastList = new FastList();
                        this.f41819d = fastList;
                    }
                    fastList.m43486a(NotificationLite.m43449a(th));
                    return;
                }
                this.f41817b = true;
                this.f41816a.mo7904a(th);
            }
        }
    }

    public final void mo7906b() {
        if (!this.f41818c) {
            synchronized (this) {
                if (this.f41818c) {
                    return;
                }
                this.f41818c = true;
                if (this.f41817b) {
                    FastList fastList = this.f41819d;
                    if (fastList == null) {
                        fastList = new FastList();
                        this.f41819d = fastList;
                    }
                    fastList.m43486a(NotificationLite.m43452b());
                    return;
                }
                this.f41817b = true;
                this.f41816a.mo7906b();
            }
        }
    }
}
