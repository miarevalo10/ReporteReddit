package io.fabric.sdk.android.services.concurrency;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AsyncTask<Params, Progress, Result> {
    private static final int f24804a;
    public static final Executor f24805b = new ThreadPoolExecutor(f24807h, f24808i, 1, TimeUnit.SECONDS, f24810k, f24809j);
    public static final Executor f24806c = new SerialExecutor();
    private static final int f24807h;
    private static final int f24808i = ((f24804a * 2) + 1);
    private static final ThreadFactory f24809j = new C21161();
    private static final BlockingQueue<Runnable> f24810k = new LinkedBlockingQueue(128);
    private static final InternalHandler f24811l = new InternalHandler();
    private static volatile Executor f24812m = f24806c;
    public final WorkerRunnable<Params, Result> f24813d = new C25442(this);
    public final FutureTask<Result> f24814e = new FutureTask<Result>(this, this.f24813d) {
        final /* synthetic */ AsyncTask f24791a;

        protected void done() {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = r3.f24791a;	 Catch:{ InterruptedException -> 0x001e, ExecutionException -> 0x0011, CancellationException -> 0x000a }
            r1 = r3.get();	 Catch:{ InterruptedException -> 0x001e, ExecutionException -> 0x0011, CancellationException -> 0x000a }
            io.fabric.sdk.android.services.concurrency.AsyncTask.m26368b(r0, r1);	 Catch:{ InterruptedException -> 0x001e, ExecutionException -> 0x0011, CancellationException -> 0x000a }
            return;
        L_0x000a:
            r0 = r3.f24791a;
            r1 = 0;
            io.fabric.sdk.android.services.concurrency.AsyncTask.m26368b(r0, r1);
            return;
        L_0x0011:
            r0 = move-exception;
            r1 = new java.lang.RuntimeException;
            r2 = "An error occured while executing doInBackground()";
            r0 = r0.getCause();
            r1.<init>(r2, r0);
            throw r1;
        L_0x001e:
            r0 = move-exception;
            r1 = "AsyncTask";
            android.util.Log.w(r1, r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.concurrency.AsyncTask.3.done():void");
        }
    };
    public volatile Status f24815f = Status.PENDING;
    protected final AtomicBoolean f24816g = new AtomicBoolean();
    private final AtomicBoolean f24817n = new AtomicBoolean();

    static class C21161 implements ThreadFactory {
        private final AtomicInteger f24790a = new AtomicInteger(1);

        C21161() {
        }

        public final Thread newThread(Runnable runnable) {
            StringBuilder stringBuilder = new StringBuilder("AsyncTask #");
            stringBuilder.append(this.f24790a.getAndIncrement());
            return new Thread(runnable, stringBuilder.toString());
        }
    }

    static /* synthetic */ class C21184 {
        public static final /* synthetic */ int[] f24792a = new int[Status.values().length];

        static {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = io.fabric.sdk.android.services.concurrency.AsyncTask.Status.values();
            r0 = r0.length;
            r0 = new int[r0];
            f24792a = r0;
            r0 = f24792a;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = io.fabric.sdk.android.services.concurrency.AsyncTask.Status.RUNNING;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r0 = f24792a;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = io.fabric.sdk.android.services.concurrency.AsyncTask.Status.FINISHED;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2;	 Catch:{ NoSuchFieldError -> 0x001f }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.concurrency.AsyncTask.4.<clinit>():void");
        }
    }

    private static class AsyncTaskResult<Data> {
        final AsyncTask f24793a;
        final Data[] f24794b;

        AsyncTaskResult(AsyncTask asyncTask, Data... dataArr) {
            this.f24793a = asyncTask;
            this.f24794b = dataArr;
        }
    }

    private static class InternalHandler extends Handler {
        public InternalHandler() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            AsyncTaskResult asyncTaskResult = (AsyncTaskResult) message.obj;
            switch (message.what) {
                case 1:
                    AsyncTask.m26371c(asyncTaskResult.f24793a, asyncTaskResult.f24794b[0]);
                    return;
                case 2:
                    AsyncTask.m26370c();
                    break;
                default:
                    break;
            }
        }
    }

    private static class SerialExecutor implements Executor {
        final LinkedList<Runnable> f24797a;
        Runnable f24798b;

        private SerialExecutor() {
            this.f24797a = new LinkedList();
        }

        public synchronized void execute(final Runnable runnable) {
            this.f24797a.offer(new Runnable(this) {
                final /* synthetic */ SerialExecutor f24796b;

                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        this.f24796b.m26365a();
                    }
                }
            });
            if (this.f24798b == null) {
                m26365a();
            }
        }

        protected final synchronized void m26365a() {
            Runnable runnable = (Runnable) this.f24797a.poll();
            this.f24798b = runnable;
            if (runnable != null) {
                AsyncTask.f24805b.execute(this.f24798b);
            }
        }
    }

    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    private static abstract class WorkerRunnable<Params, Result> implements Callable<Result> {
        public Params[] f24803b;

        private WorkerRunnable() {
        }
    }

    class C25442 extends WorkerRunnable<Params, Result> {
        final /* synthetic */ AsyncTask f31004a;

        C25442(AsyncTask asyncTask) {
            this.f31004a = asyncTask;
            super();
        }

        public Result call() throws Exception {
            this.f31004a.f24817n.set(true);
            Process.setThreadPriority(10);
            return this.f31004a.m26369c(this.f31004a.mo6591b());
        }
    }

    protected static void m26370c() {
    }

    public void mo6589a() {
    }

    public void mo6590a(Result result) {
    }

    public abstract Result mo6591b();

    public void mo6592b(Result result) {
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f24804a = availableProcessors;
        f24807h = availableProcessors + 1;
    }

    private Result m26369c(Result result) {
        f24811l.obtainMessage(1, new AsyncTaskResult(this, result)).sendToTarget();
        return result;
    }

    public final boolean m26376d() {
        this.f24816g.set(true);
        return this.f24814e.cancel(true);
    }

    static /* synthetic */ void m26368b(AsyncTask asyncTask, Object obj) {
        if (!asyncTask.f24817n.get()) {
            asyncTask.m26369c(obj);
        }
    }

    static /* synthetic */ void m26371c(AsyncTask asyncTask, Object obj) {
        if (asyncTask.f24816g.get()) {
            asyncTask.mo6592b(obj);
        } else {
            asyncTask.mo6590a(obj);
        }
        asyncTask.f24815f = Status.FINISHED;
    }
}
