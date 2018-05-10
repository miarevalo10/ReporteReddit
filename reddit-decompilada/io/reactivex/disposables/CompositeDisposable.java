package io.reactivex.disposables;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.OpenHashSet;
import java.util.ArrayList;

public final class CompositeDisposable implements Disposable, DisposableContainer {
    OpenHashSet<Disposable> f31091a;
    volatile boolean f31092b;

    public CompositeDisposable(Disposable... disposableArr) {
        ObjectHelper.m26573a((Object) disposableArr, "resources is null");
        this.f31091a = new OpenHashSet((byte) 0);
        for (int i = 0; i <= 0; i++) {
            Object obj = disposableArr[0];
            ObjectHelper.m26573a(obj, "Disposable item is null");
            this.f31091a.m26716a(obj);
        }
    }

    public final void mo5626a() {
        if (!this.f31092b) {
            synchronized (this) {
                if (this.f31092b) {
                    return;
                }
                this.f31092b = true;
                OpenHashSet openHashSet = this.f31091a;
                this.f31091a = null;
                m32072a(openHashSet);
            }
        }
    }

    public final boolean mo5627b() {
        return this.f31092b;
    }

    public final boolean mo5631a(Disposable disposable) {
        ObjectHelper.m26573a((Object) disposable, "d is null");
        if (!this.f31092b) {
            synchronized (this) {
                if (!this.f31092b) {
                    OpenHashSet openHashSet = this.f31091a;
                    if (openHashSet == null) {
                        openHashSet = new OpenHashSet();
                        this.f31091a = openHashSet;
                    }
                    openHashSet.m26716a((Object) disposable);
                    return true;
                }
            }
        }
        disposable.mo5626a();
        return null;
    }

    public final boolean mo5632b(Disposable disposable) {
        if (!mo5633c(disposable)) {
            return null;
        }
        disposable.mo5626a();
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo5633c(io.reactivex.disposables.Disposable r8) {
        /*
        r7 = this;
        r0 = "Disposable item is null";
        io.reactivex.internal.functions.ObjectHelper.m26573a(r8, r0);
        r0 = r7.f31092b;
        r1 = 0;
        if (r0 == 0) goto L_0x000b;
    L_0x000a:
        return r1;
    L_0x000b:
        monitor-enter(r7);
        r0 = r7.f31092b;	 Catch:{ all -> 0x004d }
        if (r0 == 0) goto L_0x0012;
    L_0x0010:
        monitor-exit(r7);	 Catch:{ all -> 0x004d }
        return r1;
    L_0x0012:
        r0 = r7.f31091a;	 Catch:{ all -> 0x004d }
        if (r0 == 0) goto L_0x004b;
    L_0x0016:
        r2 = r0.f25204e;	 Catch:{ all -> 0x004d }
        r3 = r0.f25201b;	 Catch:{ all -> 0x004d }
        r4 = r8.hashCode();	 Catch:{ all -> 0x004d }
        r4 = io.reactivex.internal.util.OpenHashSet.m26714a(r4);	 Catch:{ all -> 0x004d }
        r4 = r4 & r3;
        r5 = r2[r4];	 Catch:{ all -> 0x004d }
        r6 = 1;
        if (r5 != 0) goto L_0x002a;
    L_0x0028:
        r8 = r1;
        goto L_0x0046;
    L_0x002a:
        r5 = r5.equals(r8);	 Catch:{ all -> 0x004d }
        if (r5 == 0) goto L_0x0035;
    L_0x0030:
        r8 = r0.m26715a(r4, r2, r3);	 Catch:{ all -> 0x004d }
        goto L_0x0046;
    L_0x0035:
        r4 = r4 + r6;
        r4 = r4 & r3;
        r5 = r2[r4];	 Catch:{ all -> 0x004d }
        if (r5 != 0) goto L_0x003c;
    L_0x003b:
        goto L_0x0028;
    L_0x003c:
        r5 = r5.equals(r8);	 Catch:{ all -> 0x004d }
        if (r5 == 0) goto L_0x0035;
    L_0x0042:
        r8 = r0.m26715a(r4, r2, r3);	 Catch:{ all -> 0x004d }
    L_0x0046:
        if (r8 != 0) goto L_0x0049;
    L_0x0048:
        goto L_0x004b;
    L_0x0049:
        monitor-exit(r7);	 Catch:{ all -> 0x004d }
        return r6;
    L_0x004b:
        monitor-exit(r7);	 Catch:{ all -> 0x004d }
        return r1;
    L_0x004d:
        r8 = move-exception;
        monitor-exit(r7);	 Catch:{ all -> 0x004d }
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.disposables.CompositeDisposable.c(io.reactivex.disposables.Disposable):boolean");
    }

    public final void m32077c() {
        if (!this.f31092b) {
            synchronized (this) {
                if (this.f31092b) {
                    return;
                }
                OpenHashSet openHashSet = this.f31091a;
                this.f31091a = null;
                m32072a(openHashSet);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int m32079d() {
        /*
        r2 = this;
        r0 = r2.f31092b;
        r1 = 0;
        if (r0 == 0) goto L_0x0006;
    L_0x0005:
        return r1;
    L_0x0006:
        monitor-enter(r2);
        r0 = r2.f31092b;	 Catch:{ all -> 0x0015 }
        if (r0 == 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r2);	 Catch:{ all -> 0x0015 }
        return r1;
    L_0x000d:
        r0 = r2.f31091a;	 Catch:{ all -> 0x0015 }
        if (r0 == 0) goto L_0x0013;
    L_0x0011:
        r1 = r0.f25202c;	 Catch:{ all -> 0x0015 }
    L_0x0013:
        monitor-exit(r2);	 Catch:{ all -> 0x0015 }
        return r1;
    L_0x0015:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0015 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.disposables.CompositeDisposable.d():int");
    }

    private static void m32072a(OpenHashSet<Disposable> openHashSet) {
        if (openHashSet != null) {
            Iterable iterable = null;
            for (Object obj : openHashSet.f25204e) {
                if (obj instanceof Disposable) {
                    try {
                        ((Disposable) obj).mo5626a();
                    } catch (Throwable th) {
                        Exceptions.m26521b(th);
                        if (iterable == null) {
                            iterable = new ArrayList();
                        }
                        iterable.add(th);
                    }
                }
            }
            if (iterable == null) {
                return;
            }
            if (iterable.size() == 1) {
                throw ExceptionHelper.m26682a((Throwable) iterable.get(0));
            }
            throw new CompositeException(iterable);
        }
    }
}
