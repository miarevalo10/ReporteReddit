package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.LinkedList;
import java.util.List;

public final class ListCompositeDisposable implements Disposable, DisposableContainer {
    List<Disposable> f31098a;
    volatile boolean f31099b;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo5626a() {
        /*
        r4 = this;
        r0 = r4.f31099b;
        if (r0 == 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        monitor-enter(r4);
        r0 = r4.f31099b;	 Catch:{ all -> 0x0055 }
        if (r0 == 0) goto L_0x000c;
    L_0x000a:
        monitor-exit(r4);	 Catch:{ all -> 0x0055 }
        return;
    L_0x000c:
        r0 = 1;
        r4.f31099b = r0;	 Catch:{ all -> 0x0055 }
        r1 = r4.f31098a;	 Catch:{ all -> 0x0055 }
        r2 = 0;
        r4.f31098a = r2;	 Catch:{ all -> 0x0055 }
        monitor-exit(r4);	 Catch:{ all -> 0x0055 }
        if (r1 == 0) goto L_0x0054;
    L_0x0017:
        r1 = r1.iterator();
    L_0x001b:
        r3 = r1.hasNext();
        if (r3 == 0) goto L_0x003a;
    L_0x0021:
        r3 = r1.next();
        r3 = (io.reactivex.disposables.Disposable) r3;
        r3.mo5626a();	 Catch:{ Throwable -> 0x002b }
        goto L_0x001b;
    L_0x002b:
        r3 = move-exception;
        io.reactivex.exceptions.Exceptions.m26521b(r3);
        if (r2 != 0) goto L_0x0036;
    L_0x0031:
        r2 = new java.util.ArrayList;
        r2.<init>();
    L_0x0036:
        r2.add(r3);
        goto L_0x001b;
    L_0x003a:
        if (r2 == 0) goto L_0x0054;
    L_0x003c:
        r1 = r2.size();
        if (r1 != r0) goto L_0x004e;
    L_0x0042:
        r0 = 0;
        r0 = r2.get(r0);
        r0 = (java.lang.Throwable) r0;
        r0 = io.reactivex.internal.util.ExceptionHelper.m26682a(r0);
        throw r0;
    L_0x004e:
        r0 = new io.reactivex.exceptions.CompositeException;
        r0.<init>(r2);
        throw r0;
    L_0x0054:
        return;
    L_0x0055:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0055 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.disposables.ListCompositeDisposable.a():void");
    }

    public final boolean mo5627b() {
        return this.f31099b;
    }

    public final boolean mo5631a(Disposable disposable) {
        ObjectHelper.m26573a((Object) disposable, "d is null");
        if (!this.f31099b) {
            synchronized (this) {
                if (!this.f31099b) {
                    List list = this.f31098a;
                    if (list == null) {
                        list = new LinkedList();
                        this.f31098a = list;
                    }
                    list.add(disposable);
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
    public final boolean mo5633c(io.reactivex.disposables.Disposable r3) {
        /*
        r2 = this;
        r0 = "Disposable item is null";
        io.reactivex.internal.functions.ObjectHelper.m26573a(r3, r0);
        r0 = r2.f31099b;
        r1 = 0;
        if (r0 == 0) goto L_0x000b;
    L_0x000a:
        return r1;
    L_0x000b:
        monitor-enter(r2);
        r0 = r2.f31099b;	 Catch:{ all -> 0x0022 }
        if (r0 == 0) goto L_0x0012;
    L_0x0010:
        monitor-exit(r2);	 Catch:{ all -> 0x0022 }
        return r1;
    L_0x0012:
        r0 = r2.f31098a;	 Catch:{ all -> 0x0022 }
        if (r0 == 0) goto L_0x0020;
    L_0x0016:
        r3 = r0.remove(r3);	 Catch:{ all -> 0x0022 }
        if (r3 != 0) goto L_0x001d;
    L_0x001c:
        goto L_0x0020;
    L_0x001d:
        monitor-exit(r2);	 Catch:{ all -> 0x0022 }
        r3 = 1;
        return r3;
    L_0x0020:
        monitor-exit(r2);	 Catch:{ all -> 0x0022 }
        return r1;
    L_0x0022:
        r3 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0022 }
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.disposables.ListCompositeDisposable.c(io.reactivex.disposables.Disposable):boolean");
    }
}
