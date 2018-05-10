package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

abstract class AbstractTransformFuture<I, O, F, T> extends TrustedFuture<O> implements Runnable {
    ListenableFuture<? extends I> f19830b;
    F f19831c;

    private static final class TransformFuture<I, O> extends AbstractTransformFuture<I, O, Function<? super I, ? extends O>, O> {
        final /* synthetic */ Object mo4425a(Object obj, Object obj2) throws Exception {
            return ((Function) obj).apply(obj2);
        }

        TransformFuture(ListenableFuture<? extends I> listenableFuture, Function<? super I, ? extends O> function) {
            super(listenableFuture, function);
        }

        final void mo4398b(O o) {
            mo4399a((Object) o);
        }
    }

    abstract T mo4425a(F f, I i) throws Exception;

    abstract void mo4398b(T t);

    static <I, O> ListenableFuture<O> m21564a(ListenableFuture<I> listenableFuture, Function<? super I, ? extends O> function, Executor executor) {
        Preconditions.m6908a((Object) function);
        ListenableFuture<O> transformFuture = new TransformFuture(listenableFuture, function);
        listenableFuture.mo4057a(transformFuture, MoreExecutors.m7339a(executor, transformFuture));
        return transformFuture;
    }

    AbstractTransformFuture(ListenableFuture<? extends I> listenableFuture, F f) {
        this.f19830b = (ListenableFuture) Preconditions.m6908a((Object) listenableFuture);
        this.f19831c = Preconditions.m6908a((Object) f);
    }

    public final void run() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r6 = this;
        r0 = r6.f19830b;
        r1 = r6.f19831c;
        r2 = r6.isCancelled();
        r3 = 1;
        r4 = 0;
        if (r0 != 0) goto L_0x000e;
    L_0x000c:
        r5 = r3;
        goto L_0x000f;
    L_0x000e:
        r5 = r4;
    L_0x000f:
        r2 = r2 | r5;
        if (r1 != 0) goto L_0x0013;
    L_0x0012:
        goto L_0x0014;
    L_0x0013:
        r3 = r4;
    L_0x0014:
        r2 = r2 | r3;
        if (r2 == 0) goto L_0x0018;
    L_0x0017:
        return;
    L_0x0018:
        r2 = 0;
        r6.f19830b = r2;
        r6.f19831c = r2;
        r0 = com.google.common.util.concurrent.Futures.m14884a(r0);	 Catch:{ CancellationException -> 0x004a, ExecutionException -> 0x0041, RuntimeException -> 0x003c, Error -> 0x0037 }
        r0 = r6.mo4425a(r1, r0);	 Catch:{ UndeclaredThrowableException -> 0x002e, Throwable -> 0x0029 }
        r6.mo4398b(r0);
        return;
    L_0x0029:
        r0 = move-exception;
        r6.mo4400a(r0);
        return;
    L_0x002e:
        r0 = move-exception;
        r0 = r0.getCause();
        r6.mo4400a(r0);
        return;
    L_0x0037:
        r0 = move-exception;
        r6.mo4400a(r0);
        return;
    L_0x003c:
        r0 = move-exception;
        r6.mo4400a(r0);
        return;
    L_0x0041:
        r0 = move-exception;
        r0 = r0.getCause();
        r6.mo4400a(r0);
        return;
    L_0x004a:
        r6.cancel(r4);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.AbstractTransformFuture.run():void");
    }

    protected final void mo4396a() {
        Future future = this.f19830b;
        boolean z = false;
        if (((future != null ? 1 : 0) & isCancelled()) != 0) {
            Object obj = this.f19271a;
            if ((obj instanceof Cancellation) && ((Cancellation) obj).f8560c) {
                z = true;
            }
            future.cancel(z);
        }
        this.f19830b = null;
        this.f19831c = null;
    }

    protected final String mo4397b() {
        ListenableFuture listenableFuture = this.f19830b;
        Object obj = this.f19831c;
        if (listenableFuture == null || obj == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("inputFuture=[");
        stringBuilder.append(listenableFuture);
        stringBuilder.append("], function=[");
        stringBuilder.append(obj);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
