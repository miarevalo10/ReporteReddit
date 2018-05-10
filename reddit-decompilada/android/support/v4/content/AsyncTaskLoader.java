package android.support.v4.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.content.ModernAsyncTask.C01044;
import android.support.v4.content.ModernAsyncTask.Status;
import android.support.v4.os.OperationCanceledException;
import android.support.v4.util.TimeUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

public abstract class AsyncTaskLoader<D> extends Loader<D> {
    volatile LoadTask f11407a;
    volatile LoadTask f11408b;
    long f11409c;
    long f11410d;
    Handler f11411e;
    private final Executor f11412o;

    final class LoadTask extends ModernAsyncTask<Void, Void, D> implements Runnable {
        boolean f11404a;
        final /* synthetic */ AsyncTaskLoader f11405b;
        private final CountDownLatch f11406h = new CountDownLatch(1);

        LoadTask(AsyncTaskLoader asyncTaskLoader) {
            this.f11405b = asyncTaskLoader;
        }

        protected final /* synthetic */ Object mo259a() {
            return m10005c();
        }

        private D m10005c() {
            try {
                return this.f11405b.mo3402d();
            } catch (OperationCanceledException e) {
                if (this.f1227g.get()) {
                    return null;
                }
                throw e;
            }
        }

        protected final void mo260a(D d) {
            try {
                Loader loader = this.f11405b;
                if (loader.f11407a != this) {
                    loader.m10010a(this, d);
                } else if (loader.f1191k) {
                    loader.mo3791a(d);
                } else {
                    loader.f1194n = false;
                    loader.f11410d = SystemClock.uptimeMillis();
                    loader.f11407a = null;
                    loader.mo3792b(d);
                }
                this.f11406h.countDown();
            } catch (Throwable th) {
                this.f11406h.countDown();
            }
        }

        protected final void mo261b(D d) {
            try {
                this.f11405b.m10010a(this, d);
            } finally {
                this.f11406h.countDown();
            }
        }

        public final void run() {
            this.f11404a = false;
            this.f11405b.m10014c();
        }
    }

    public void mo3791a(D d) {
    }

    public abstract D mo3402d();

    public AsyncTaskLoader(Context context) {
        this(context, ModernAsyncTask.f1221c);
    }

    private AsyncTaskLoader(Context context, Executor executor) {
        super(context);
        this.f11410d = -10000;
        this.f11412o = executor;
    }

    protected final void mo262a() {
        super.mo262a();
        m738g();
        this.f11407a = new LoadTask(this);
        m10014c();
    }

    protected final boolean mo264b() {
        if (this.f11407a == null) {
            return false;
        }
        if (!this.j) {
            this.m = true;
        }
        if (this.f11408b != null) {
            if (this.f11407a.f11404a) {
                this.f11407a.f11404a = false;
                this.f11411e.removeCallbacks(this.f11407a);
            }
            this.f11407a = null;
            return false;
        } else if (this.f11407a.f11404a) {
            this.f11407a.f11404a = false;
            this.f11411e.removeCallbacks(this.f11407a);
            this.f11407a = null;
            return false;
        } else {
            ModernAsyncTask modernAsyncTask = this.f11407a;
            modernAsyncTask.f1227g.set(true);
            boolean cancel = modernAsyncTask.f1225e.cancel(false);
            if (cancel) {
                this.f11408b = this.f11407a;
            }
            this.f11407a = null;
            return cancel;
        }
    }

    final void m10014c() {
        if (this.f11408b == null && this.f11407a != null) {
            if (this.f11407a.f11404a) {
                this.f11407a.f11404a = false;
                this.f11411e.removeCallbacks(this.f11407a);
            }
            if (this.f11409c <= 0 || SystemClock.uptimeMillis() >= this.f11410d + this.f11409c) {
                ModernAsyncTask modernAsyncTask = this.f11407a;
                Executor executor = this.f11412o;
                if (modernAsyncTask.f1226f != Status.PENDING) {
                    switch (C01044.f1211a[modernAsyncTask.f1226f.ordinal()]) {
                        case 1:
                            throw new IllegalStateException("Cannot execute task: the task is already running.");
                        case 2:
                            throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
                        default:
                            throw new IllegalStateException("We should never reach this state");
                    }
                }
                modernAsyncTask.f1226f = Status.RUNNING;
                modernAsyncTask.f1224d.f1218b = null;
                executor.execute(modernAsyncTask.f1225e);
            } else {
                this.f11407a.f11404a = true;
                this.f11411e.postAtTime(this.f11407a, this.f11410d + this.f11409c);
            }
        }
    }

    final void m10010a(LoadTask loadTask, D d) {
        mo3791a(d);
        if (this.f11408b == loadTask) {
            if (this.f1194n != null) {
                if (this.f1190j != null) {
                    m739h();
                } else {
                    this.f1193m = true;
                }
            }
            this.f11410d = SystemClock.uptimeMillis();
            this.f11408b = null;
            if (this.f1188h != null) {
                this.f1188h.mo251d();
            }
            m10014c();
        }
    }

    public final void mo263a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.mo263a(str, fileDescriptor, printWriter, strArr);
        if (this.f11407a != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.f11407a);
            printWriter.print(" waiting=");
            printWriter.println(this.f11407a.f11404a);
        }
        if (this.f11408b != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.f11408b);
            printWriter.print(" waiting=");
            printWriter.println(this.f11408b.f11404a);
        }
        if (this.f11409c != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            TimeUtils.m1069a(this.f11409c, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            TimeUtils.m1068a(this.f11410d, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }
}
