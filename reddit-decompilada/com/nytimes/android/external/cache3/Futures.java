package com.nytimes.android.external.cache3;

import com.nytimes.android.external.cache3.AbstractFuture.TrustedFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Futures {

    private static abstract class ImmediateFuture<V> implements ListenableFuture<V> {
        private static final Logger f15647a = Logger.getLogger(ImmediateFuture.class.getName());

        public boolean cancel(boolean z) {
            return false;
        }

        public abstract V get() throws ExecutionException;

        public boolean isCancelled() {
            return false;
        }

        public boolean isDone() {
            return true;
        }

        private ImmediateFuture() {
        }

        public final void mo2661a(Runnable runnable, Executor executor) {
            Preconditions.m8671a((Object) runnable, "Runnable was null.");
            Preconditions.m8671a((Object) executor, "Executor was null.");
            try {
                executor.execute(runnable);
            } catch (Throwable e) {
                Logger logger = f15647a;
                Level level = Level.SEVERE;
                StringBuilder stringBuilder = new StringBuilder("RuntimeException while executing runnable ");
                stringBuilder.append(runnable);
                stringBuilder.append(" with executor ");
                stringBuilder.append(executor);
                logger.log(level, stringBuilder.toString(), e);
            }
        }

        public V get(long j, TimeUnit timeUnit) throws ExecutionException {
            Preconditions.m8670a((Object) timeUnit);
            return get();
        }
    }

    private static class ImmediateFailedFuture<V> extends ImmediateFuture<V> {
        private final Throwable f18633a;

        ImmediateFailedFuture(Throwable th) {
            super();
            this.f18633a = th;
        }

        public V get() throws ExecutionException {
            throw new ExecutionException(this.f18633a);
        }
    }

    private static class ImmediateSuccessfulFuture<V> extends ImmediateFuture<V> {
        static final ImmediateSuccessfulFuture<Object> f18634a = new ImmediateSuccessfulFuture(null);
        private final V f18635b;

        ImmediateSuccessfulFuture(V v) {
            super();
            this.f18635b = v;
        }

        public V get() {
            return this.f18635b;
        }
    }

    private static abstract class AbstractChainingFuture<I, O, F> extends TrustedFuture<O> implements Runnable {
        ListenableFuture<? extends I> f19319b;
        F f19320c;

        abstract void mo4349a(F f, I i) throws Exception;

        AbstractChainingFuture(ListenableFuture<? extends I> listenableFuture, F f) {
            this.f19319b = (ListenableFuture) Preconditions.m8670a((Object) listenableFuture);
            this.f19320c = Preconditions.m8670a((Object) f);
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
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r6 = this;
            r0 = r6.f19319b;	 Catch:{ UndeclaredThrowableException -> 0x0037, Throwable -> 0x0032 }
            r1 = r6.f19320c;	 Catch:{ UndeclaredThrowableException -> 0x0037, Throwable -> 0x0032 }
            r2 = r6.isCancelled();	 Catch:{ UndeclaredThrowableException -> 0x0037, Throwable -> 0x0032 }
            r3 = 1;	 Catch:{ UndeclaredThrowableException -> 0x0037, Throwable -> 0x0032 }
            r4 = 0;	 Catch:{ UndeclaredThrowableException -> 0x0037, Throwable -> 0x0032 }
            if (r0 != 0) goto L_0x000e;	 Catch:{ UndeclaredThrowableException -> 0x0037, Throwable -> 0x0032 }
        L_0x000c:
            r5 = r3;	 Catch:{ UndeclaredThrowableException -> 0x0037, Throwable -> 0x0032 }
            goto L_0x000f;	 Catch:{ UndeclaredThrowableException -> 0x0037, Throwable -> 0x0032 }
        L_0x000e:
            r5 = r4;	 Catch:{ UndeclaredThrowableException -> 0x0037, Throwable -> 0x0032 }
        L_0x000f:
            r2 = r2 | r5;	 Catch:{ UndeclaredThrowableException -> 0x0037, Throwable -> 0x0032 }
            if (r1 != 0) goto L_0x0013;	 Catch:{ UndeclaredThrowableException -> 0x0037, Throwable -> 0x0032 }
        L_0x0012:
            goto L_0x0014;	 Catch:{ UndeclaredThrowableException -> 0x0037, Throwable -> 0x0032 }
        L_0x0013:
            r3 = r4;	 Catch:{ UndeclaredThrowableException -> 0x0037, Throwable -> 0x0032 }
        L_0x0014:
            r2 = r2 | r3;	 Catch:{ UndeclaredThrowableException -> 0x0037, Throwable -> 0x0032 }
            if (r2 == 0) goto L_0x0018;	 Catch:{ UndeclaredThrowableException -> 0x0037, Throwable -> 0x0032 }
        L_0x0017:
            return;	 Catch:{ UndeclaredThrowableException -> 0x0037, Throwable -> 0x0032 }
        L_0x0018:
            r2 = 0;	 Catch:{ UndeclaredThrowableException -> 0x0037, Throwable -> 0x0032 }
            r6.f19319b = r2;	 Catch:{ UndeclaredThrowableException -> 0x0037, Throwable -> 0x0032 }
            r6.f19320c = r2;	 Catch:{ UndeclaredThrowableException -> 0x0037, Throwable -> 0x0032 }
            r0 = com.nytimes.android.external.cache3.Uninterruptibles.m8683a(r0);	 Catch:{ CancellationException -> 0x002e, ExecutionException -> 0x0025 }
            r6.mo4349a(r1, r0);	 Catch:{ UndeclaredThrowableException -> 0x0037, Throwable -> 0x0032 }
            return;	 Catch:{ UndeclaredThrowableException -> 0x0037, Throwable -> 0x0032 }
        L_0x0025:
            r0 = move-exception;	 Catch:{ UndeclaredThrowableException -> 0x0037, Throwable -> 0x0032 }
            r0 = r0.getCause();	 Catch:{ UndeclaredThrowableException -> 0x0037, Throwable -> 0x0032 }
            r6.mo4090a(r0);	 Catch:{ UndeclaredThrowableException -> 0x0037, Throwable -> 0x0032 }
            return;	 Catch:{ UndeclaredThrowableException -> 0x0037, Throwable -> 0x0032 }
        L_0x002e:
            r6.cancel(r4);	 Catch:{ UndeclaredThrowableException -> 0x0037, Throwable -> 0x0032 }
            return;
        L_0x0032:
            r0 = move-exception;
            r6.mo4090a(r0);
            return;
        L_0x0037:
            r0 = move-exception;
            r0 = r0.getCause();
            r6.mo4090a(r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nytimes.android.external.cache3.Futures.AbstractChainingFuture.run():void");
        }

        final void mo4088a() {
            Future future = this.f19319b;
            boolean z = false;
            if (((future != null ? 1 : 0) & isCancelled()) != 0) {
                Object obj = this.f15637a;
                if ((obj instanceof Cancellation) && ((Cancellation) obj).f10097a) {
                    z = true;
                }
                future.cancel(z);
            }
            this.f19319b = null;
        }
    }

    private static final class ChainingFuture<I, O> extends AbstractChainingFuture<I, O, Function<? super I, ? extends O>> {
        final /* synthetic */ void mo4349a(Object obj, Object obj2) throws Exception {
            mo4089a(((Function) obj).apply(obj2));
        }

        ChainingFuture(ListenableFuture<? extends I> listenableFuture, Function<? super I, ? extends O> function) {
            super(listenableFuture, function);
        }
    }

    public static <V> ListenableFuture<V> m8550a(V v) {
        if (v == null) {
            return ImmediateSuccessfulFuture.f18634a;
        }
        return new ImmediateSuccessfulFuture(v);
    }

    public static <V> ListenableFuture<V> m8551a(Throwable th) {
        Preconditions.m8670a((Object) th);
        return new ImmediateFailedFuture(th);
    }

    public static <I, O> ListenableFuture<O> m8549a(ListenableFuture<I> listenableFuture, Function<? super I, ? extends O> function) {
        Preconditions.m8670a((Object) function);
        Object chainingFuture = new ChainingFuture(listenableFuture, function);
        listenableFuture.mo2661a(chainingFuture, DirectExecutor.f10127a);
        return chainingFuture;
    }
}
