package android.support.v4.content;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
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

abstract class ModernAsyncTask<Params, Progress, Result> {
    private static final ThreadFactory f1219a = new C01021();
    private static final BlockingQueue<Runnable> f1220b = new LinkedBlockingQueue(10);
    public static final Executor f1221c;
    private static InternalHandler f1222h;
    private static volatile Executor f1223i;
    final WorkerRunnable<Params, Result> f1224d = new C10012(this);
    final FutureTask<Result> f1225e = new FutureTask<Result>(this, this.f1224d) {
        final /* synthetic */ ModernAsyncTask f1210a;

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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = r3.get();	 Catch:{ InterruptedException -> 0x0027, ExecutionException -> 0x001a, CancellationException -> 0x0013, Throwable -> 0x000a }
            r1 = r3.f1210a;	 Catch:{ InterruptedException -> 0x0027, ExecutionException -> 0x001a, CancellationException -> 0x0013, Throwable -> 0x000a }
            r1.m756c(r0);	 Catch:{ InterruptedException -> 0x0027, ExecutionException -> 0x001a, CancellationException -> 0x0013, Throwable -> 0x000a }
            return;
        L_0x000a:
            r0 = move-exception;
            r1 = new java.lang.RuntimeException;
            r2 = "An error occurred while executing doInBackground()";
            r1.<init>(r2, r0);
            throw r1;
        L_0x0013:
            r0 = r3.f1210a;
            r1 = 0;
            r0.m756c(r1);
            return;
        L_0x001a:
            r0 = move-exception;
            r1 = new java.lang.RuntimeException;
            r2 = "An error occurred while executing doInBackground()";
            r0 = r0.getCause();
            r1.<init>(r2, r0);
            throw r1;
        L_0x0027:
            r0 = move-exception;
            r1 = "AsyncTask";
            android.util.Log.w(r1, r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.content.ModernAsyncTask.3.done():void");
        }
    };
    volatile Status f1226f = Status.PENDING;
    final AtomicBoolean f1227g = new AtomicBoolean();
    private final AtomicBoolean f1228j = new AtomicBoolean();

    static class C01021 implements ThreadFactory {
        private final AtomicInteger f1209a = new AtomicInteger(1);

        C01021() {
        }

        public final Thread newThread(Runnable runnable) {
            StringBuilder stringBuilder = new StringBuilder("ModernAsyncTask #");
            stringBuilder.append(this.f1209a.getAndIncrement());
            return new Thread(runnable, stringBuilder.toString());
        }
    }

    static /* synthetic */ class C01044 {
        static final /* synthetic */ int[] f1211a = new int[Status.values().length];

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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = android.support.v4.content.ModernAsyncTask.Status.values();
            r0 = r0.length;
            r0 = new int[r0];
            f1211a = r0;
            r0 = f1211a;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = android.support.v4.content.ModernAsyncTask.Status.RUNNING;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r0 = f1211a;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = android.support.v4.content.ModernAsyncTask.Status.FINISHED;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2;	 Catch:{ NoSuchFieldError -> 0x001f }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.content.ModernAsyncTask.4.<clinit>():void");
        }
    }

    private static class AsyncTaskResult<Data> {
        final ModernAsyncTask f1212a;
        final Data[] f1213b;

        AsyncTaskResult(ModernAsyncTask modernAsyncTask, Data... dataArr) {
            this.f1212a = modernAsyncTask;
            this.f1213b = dataArr;
        }
    }

    private static class InternalHandler extends Handler {
        InternalHandler() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            AsyncTaskResult asyncTaskResult = (AsyncTaskResult) message.obj;
            switch (message.what) {
                case 1:
                    asyncTaskResult.f1212a.m758e(asyncTaskResult.f1213b[0]);
                    return;
                case 2:
                    ModernAsyncTask.m751b();
                    break;
                default:
                    break;
            }
        }
    }

    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    private static abstract class WorkerRunnable<Params, Result> implements Callable<Result> {
        Params[] f1218b;

        WorkerRunnable() {
        }
    }

    class C10012 extends WorkerRunnable<Params, Result> {
        final /* synthetic */ ModernAsyncTask f11415a;

        C10012(ModernAsyncTask modernAsyncTask) {
            this.f11415a = modernAsyncTask;
        }

        public Result call() throws Exception {
            Throwable th;
            Throwable th2;
            this.f11415a.f1228j.set(true);
            Object obj = null;
            try {
                Process.setThreadPriority(10);
                Result a = this.f11415a.mo259a();
                try {
                    Binder.flushPendingCommands();
                    this.f11415a.m757d(a);
                    return a;
                } catch (Throwable th3) {
                    th2 = th3;
                    obj = a;
                    this.f11415a.m757d(obj);
                    throw th2;
                }
            } catch (Throwable th4) {
                th = th4;
                this.f11415a.f1227g.set(true);
                throw th;
            }
        }
    }

    protected static void m751b() {
    }

    protected abstract Result mo259a();

    protected void mo260a(Result result) {
    }

    protected void mo261b(Result result) {
    }

    static {
        Executor threadPoolExecutor = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, f1220b, f1219a);
        f1221c = threadPoolExecutor;
        f1223i = threadPoolExecutor;
    }

    private static Handler m752c() {
        Handler handler;
        synchronized (ModernAsyncTask.class) {
            if (f1222h == null) {
                f1222h = new InternalHandler();
            }
            handler = f1222h;
        }
        return handler;
    }

    ModernAsyncTask() {
    }

    final void m756c(Result result) {
        if (!this.f1228j.get()) {
            m757d(result);
        }
    }

    final Result m757d(Result result) {
        m752c().obtainMessage(1, new AsyncTaskResult(this, result)).sendToTarget();
        return result;
    }

    final void m758e(Result result) {
        if (this.f1227g.get()) {
            mo261b((Object) result);
        } else {
            mo260a((Object) result);
        }
        this.f1226f = Status.FINISHED;
    }
}
