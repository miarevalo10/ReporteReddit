package bolts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Task<TResult> {
    public static final ExecutorService f2714a = BoltsExecutors.m2400a();
    public static final Executor f2715b = AndroidExecutors.m2398b();
    private static final Executor f2716c = BoltsExecutors.m2401b();
    private static volatile UnobservedExceptionHandler f2717d;
    private static Task<?> f2718m = new Task(null);
    private static Task<Boolean> f2719n = new Task(Boolean.valueOf(true));
    private static Task<Boolean> f2720o = new Task(Boolean.valueOf(false));
    private static Task<?> f2721p = new Task((byte) 0);
    private final Object f2722e = new Object();
    private boolean f2723f;
    private boolean f2724g;
    private TResult f2725h;
    private Exception f2726i;
    private boolean f2727j;
    private UnobservedErrorNotifier f2728k;
    private List<Continuation<TResult, Void>> f2729l = new ArrayList();

    public interface UnobservedExceptionHandler {
    }

    public static UnobservedExceptionHandler m2405a() {
        return f2717d;
    }

    Task() {
    }

    private Task(TResult tResult) {
        m2416a((Object) tResult);
    }

    private Task(byte b) {
        m2422g();
    }

    public final boolean m2417b() {
        boolean z;
        synchronized (this.f2722e) {
            z = this.f2723f;
        }
        return z;
    }

    public final boolean m2418c() {
        boolean z;
        synchronized (this.f2722e) {
            z = this.f2724g;
        }
        return z;
    }

    public final boolean m2419d() {
        boolean z;
        synchronized (this.f2722e) {
            z = m2421f() != null;
        }
        return z;
    }

    public final TResult m2420e() {
        TResult tResult;
        synchronized (this.f2722e) {
            tResult = this.f2725h;
        }
        return tResult;
    }

    public final Exception m2421f() {
        Exception exception;
        synchronized (this.f2722e) {
            if (this.f2726i != null) {
                this.f2727j = true;
                if (this.f2728k != null) {
                    this.f2728k.f2731a = null;
                    this.f2728k = null;
                }
            }
            exception = this.f2726i;
        }
        return exception;
    }

    public static <TResult> Task<TResult> m2407a(Callable<TResult> callable) {
        return m2410b(callable, f2714a);
    }

    public static <TResult> Task<TResult> m2408a(Callable<TResult> callable, Executor executor) {
        return m2410b(callable, executor);
    }

    private static <TResult> Task<TResult> m2410b(final Callable<TResult> callable, Executor executor) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        try {
            executor.execute(new Runnable() {
                final /* synthetic */ CancellationToken f2711a = null;

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
                    r2 = this;
                    r0 = r2.f2711a;
                    if (r0 == 0) goto L_0x0014;
                L_0x0004:
                    r0 = r2.f2711a;
                    r0 = r0.f2697a;
                    r0 = r0.m2402a();
                    if (r0 == 0) goto L_0x0014;
                L_0x000e:
                    r0 = r0;
                    r0.m2423a();
                    return;
                L_0x0014:
                    r0 = r0;	 Catch:{ CancellationException -> 0x0027, Exception -> 0x0020 }
                    r1 = r2;	 Catch:{ CancellationException -> 0x0027, Exception -> 0x0020 }
                    r1 = r1.call();	 Catch:{ CancellationException -> 0x0027, Exception -> 0x0020 }
                    r0.m2425a(r1);	 Catch:{ CancellationException -> 0x0027, Exception -> 0x0020 }
                    return;
                L_0x0020:
                    r0 = move-exception;
                    r1 = r0;
                    r1.m2424a(r0);
                    return;
                L_0x0027:
                    r0 = r0;
                    r0.m2423a();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: bolts.Task.4.run():void");
                }
            });
        } catch (Callable<TResult> callable2) {
            taskCompletionSource.m2424a(new ExecutorException(callable2));
        }
        return taskCompletionSource.f2730a;
    }

    public static Task<Void> m2406a(Collection<? extends Task<?>> collection) {
        if (collection.size() == 0) {
            return f2718m;
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        ArrayList arrayList = new ArrayList();
        Object obj = new Object();
        AtomicInteger atomicInteger = new AtomicInteger(collection.size());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        for (Task a : collection) {
            final Object obj2 = obj;
            final ArrayList arrayList2 = arrayList;
            final AtomicBoolean atomicBoolean2 = atomicBoolean;
            final AtomicInteger atomicInteger2 = atomicInteger;
            final TaskCompletionSource taskCompletionSource2 = taskCompletionSource;
            a.m2413a(new Continuation<Object, Void>() {
                public final /* synthetic */ Object mo769a(Task task) throws Exception {
                    return m10973b(task);
                }

                private Void m10973b(Task<Object> task) {
                    if (task.m2419d()) {
                        synchronized (obj2) {
                            arrayList2.add(task.m2421f());
                        }
                    }
                    if (task.m2418c() != null) {
                        atomicBoolean2.set(true);
                    }
                    if (atomicInteger2.decrementAndGet() == null) {
                        if (arrayList2.size() != null) {
                            if (arrayList2.size() == 1) {
                                taskCompletionSource2.m2424a((Exception) arrayList2.get(0));
                            } else {
                                taskCompletionSource2.m2424a(new AggregateException(String.format("There were %d exceptions.", new Object[]{Integer.valueOf(arrayList2.size())}), arrayList2));
                            }
                        } else if (atomicBoolean2.get() != null) {
                            taskCompletionSource2.m2423a();
                        } else {
                            taskCompletionSource2.m2425a(null);
                        }
                    }
                    return null;
                }
            });
        }
        return taskCompletionSource.f2730a;
    }

    public final <TContinuationResult> Task<TContinuationResult> m2414a(final Continuation<TResult, TContinuationResult> continuation, final Executor executor) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        synchronized (this.f2722e) {
            boolean b = m2417b();
            if (!b) {
                this.f2729l.add(new Continuation<TResult, Void>(this) {
                    final /* synthetic */ CancellationToken f12110d = null;
                    final /* synthetic */ Task f12111e;

                    public final /* bridge */ /* synthetic */ Object mo769a(Task task) throws Exception {
                        Task.m2411b(taskCompletionSource, continuation, task, executor, this.f12110d);
                        return null;
                    }
                });
            }
        }
        if (b) {
            m2411b(taskCompletionSource, continuation, this, executor, null);
        }
        return taskCompletionSource.f2730a;
    }

    public final <TContinuationResult> Task<TContinuationResult> m2413a(Continuation<TResult, TContinuationResult> continuation) {
        return m2414a((Continuation) continuation, f2716c);
    }

    private static <TContinuationResult, TResult> void m2411b(final TaskCompletionSource<TContinuationResult> taskCompletionSource, final Continuation<TResult, TContinuationResult> continuation, final Task<TResult> task, Executor executor, final CancellationToken cancellationToken) {
        try {
            executor.execute(new Runnable() {
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
                    r2 = this;
                    r0 = r5;
                    if (r0 == 0) goto L_0x0014;
                L_0x0004:
                    r0 = r5;
                    r0 = r0.f2697a;
                    r0 = r0.m2402a();
                    if (r0 == 0) goto L_0x0014;
                L_0x000e:
                    r0 = r1;
                    r0.m2423a();
                    return;
                L_0x0014:
                    r0 = r2;	 Catch:{ CancellationException -> 0x0029, Exception -> 0x0022 }
                    r1 = r3;	 Catch:{ CancellationException -> 0x0029, Exception -> 0x0022 }
                    r0 = r0.mo769a(r1);	 Catch:{ CancellationException -> 0x0029, Exception -> 0x0022 }
                    r1 = r1;	 Catch:{ CancellationException -> 0x0029, Exception -> 0x0022 }
                    r1.m2425a(r0);	 Catch:{ CancellationException -> 0x0029, Exception -> 0x0022 }
                    return;
                L_0x0022:
                    r0 = move-exception;
                    r1 = r1;
                    r1.m2424a(r0);
                    return;
                L_0x0029:
                    r0 = r1;
                    r0.m2423a();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: bolts.Task.14.run():void");
                }
            });
        } catch (Continuation<TResult, TContinuationResult> continuation2) {
            taskCompletionSource.m2424a(new ExecutorException(continuation2));
        }
    }

    private void m2412h() {
        synchronized (this.f2722e) {
            for (Continuation a : this.f2729l) {
                try {
                    a.mo769a(this);
                } catch (RuntimeException e) {
                    throw e;
                } catch (Throwable e2) {
                    throw new RuntimeException(e2);
                }
            }
            this.f2729l = null;
        }
    }

    final boolean m2422g() {
        synchronized (this.f2722e) {
            if (this.f2723f) {
                return false;
            }
            this.f2723f = true;
            this.f2724g = true;
            this.f2722e.notifyAll();
            m2412h();
            return true;
        }
    }

    final boolean m2416a(TResult tResult) {
        synchronized (this.f2722e) {
            if (this.f2723f) {
                return null;
            }
            this.f2723f = true;
            this.f2725h = tResult;
            this.f2722e.notifyAll();
            m2412h();
            return true;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final boolean m2415a(java.lang.Exception r4) {
        /*
        r3 = this;
        r0 = r3.f2722e;
        monitor-enter(r0);
        r1 = r3.f2723f;	 Catch:{ all -> 0x002a }
        r2 = 0;
        if (r1 == 0) goto L_0x000a;
    L_0x0008:
        monitor-exit(r0);	 Catch:{ all -> 0x002a }
        return r2;
    L_0x000a:
        r1 = 1;
        r3.f2723f = r1;	 Catch:{ all -> 0x002a }
        r3.f2726i = r4;	 Catch:{ all -> 0x002a }
        r3.f2727j = r2;	 Catch:{ all -> 0x002a }
        r4 = r3.f2722e;	 Catch:{ all -> 0x002a }
        r4.notifyAll();	 Catch:{ all -> 0x002a }
        r3.m2412h();	 Catch:{ all -> 0x002a }
        r4 = r3.f2727j;	 Catch:{ all -> 0x002a }
        if (r4 != 0) goto L_0x0028;
    L_0x001d:
        r4 = f2717d;	 Catch:{ all -> 0x002a }
        if (r4 == 0) goto L_0x0028;
    L_0x0021:
        r4 = new bolts.UnobservedErrorNotifier;	 Catch:{ all -> 0x002a }
        r4.<init>(r3);	 Catch:{ all -> 0x002a }
        r3.f2728k = r4;	 Catch:{ all -> 0x002a }
    L_0x0028:
        monitor-exit(r0);	 Catch:{ all -> 0x002a }
        return r1;
    L_0x002a:
        r4 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x002a }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: bolts.Task.a(java.lang.Exception):boolean");
    }
}
