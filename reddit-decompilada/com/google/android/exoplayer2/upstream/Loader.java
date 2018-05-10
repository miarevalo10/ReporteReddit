package com.google.android.exoplayer2.upstream;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

public final class Loader implements LoaderErrorThrower {
    private final ExecutorService f13679a;
    private LoadTask<? extends Loadable> f13680b;
    private IOException f13681c;

    public interface Callback<T extends Loadable> {
        int mo1418a(T t, long j, long j2, IOException iOException);

        void mo1419a(T t, long j, long j2);

        void mo1420a(T t, long j, long j2, boolean z);
    }

    @SuppressLint({"HandlerLeak"})
    private final class LoadTask<T extends Loadable> extends Handler implements Runnable {
        public final int f5182a;
        IOException f5183b;
        int f5184c;
        final /* synthetic */ Loader f5185d;
        private final T f5186e;
        private final Callback<T> f5187f;
        private final long f5188g;
        private volatile Thread f5189h;
        private volatile boolean f5190i;

        public LoadTask(Loader loader, Looper looper, T t, Callback<T> callback, int i, long j) {
            this.f5185d = loader;
            super(looper);
            this.f5186e = t;
            this.f5187f = callback;
            this.f5182a = i;
            this.f5188g = j;
        }

        public final void m4157a(long j) {
            Assertions.m4186b(this.f5185d.f13680b == null);
            this.f5185d.f13680b = this;
            if (j > 0) {
                sendEmptyMessageDelayed(0, j);
            } else {
                m4155a();
            }
        }

        public final void m4158a(boolean z) {
            this.f5190i = z;
            this.f5183b = null;
            if (hasMessages(0)) {
                removeMessages(0);
                if (!z) {
                    sendEmptyMessage(1);
                }
            } else {
                this.f5186e.mo1404a();
                if (this.f5189h != null) {
                    this.f5189h.interrupt();
                }
            }
            if (z) {
                m4156b();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.f5187f.mo1420a(this.f5186e, elapsedRealtime, elapsedRealtime - this.f5188g, true);
            }
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r4 = this;
            r0 = 2;
            r1 = 3;
            r2 = java.lang.Thread.currentThread();	 Catch:{ IOException -> 0x0099, InterruptedException -> 0x0088, Exception -> 0x006f, OutOfMemoryError -> 0x0056, Error -> 0x0041 }
            r4.f5189h = r2;	 Catch:{ IOException -> 0x0099, InterruptedException -> 0x0088, Exception -> 0x006f, OutOfMemoryError -> 0x0056, Error -> 0x0041 }
            r2 = r4.f5186e;	 Catch:{ IOException -> 0x0099, InterruptedException -> 0x0088, Exception -> 0x006f, OutOfMemoryError -> 0x0056, Error -> 0x0041 }
            r2 = r2.mo1405b();	 Catch:{ IOException -> 0x0099, InterruptedException -> 0x0088, Exception -> 0x006f, OutOfMemoryError -> 0x0056, Error -> 0x0041 }
            if (r2 != 0) goto L_0x0039;	 Catch:{ IOException -> 0x0099, InterruptedException -> 0x0088, Exception -> 0x006f, OutOfMemoryError -> 0x0056, Error -> 0x0041 }
        L_0x0010:
            r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0099, InterruptedException -> 0x0088, Exception -> 0x006f, OutOfMemoryError -> 0x0056, Error -> 0x0041 }
            r3 = "load:";	 Catch:{ IOException -> 0x0099, InterruptedException -> 0x0088, Exception -> 0x006f, OutOfMemoryError -> 0x0056, Error -> 0x0041 }
            r2.<init>(r3);	 Catch:{ IOException -> 0x0099, InterruptedException -> 0x0088, Exception -> 0x006f, OutOfMemoryError -> 0x0056, Error -> 0x0041 }
            r3 = r4.f5186e;	 Catch:{ IOException -> 0x0099, InterruptedException -> 0x0088, Exception -> 0x006f, OutOfMemoryError -> 0x0056, Error -> 0x0041 }
            r3 = r3.getClass();	 Catch:{ IOException -> 0x0099, InterruptedException -> 0x0088, Exception -> 0x006f, OutOfMemoryError -> 0x0056, Error -> 0x0041 }
            r3 = r3.getSimpleName();	 Catch:{ IOException -> 0x0099, InterruptedException -> 0x0088, Exception -> 0x006f, OutOfMemoryError -> 0x0056, Error -> 0x0041 }
            r2.append(r3);	 Catch:{ IOException -> 0x0099, InterruptedException -> 0x0088, Exception -> 0x006f, OutOfMemoryError -> 0x0056, Error -> 0x0041 }
            r2 = r2.toString();	 Catch:{ IOException -> 0x0099, InterruptedException -> 0x0088, Exception -> 0x006f, OutOfMemoryError -> 0x0056, Error -> 0x0041 }
            com.google.android.exoplayer2.util.TraceUtil.m4290a(r2);	 Catch:{ IOException -> 0x0099, InterruptedException -> 0x0088, Exception -> 0x006f, OutOfMemoryError -> 0x0056, Error -> 0x0041 }
            r2 = r4.f5186e;	 Catch:{ all -> 0x0034 }
            r2.mo1406c();	 Catch:{ all -> 0x0034 }
            com.google.android.exoplayer2.util.TraceUtil.m4289a();	 Catch:{ IOException -> 0x0099, InterruptedException -> 0x0088, Exception -> 0x006f, OutOfMemoryError -> 0x0056, Error -> 0x0041 }
            goto L_0x0039;	 Catch:{ IOException -> 0x0099, InterruptedException -> 0x0088, Exception -> 0x006f, OutOfMemoryError -> 0x0056, Error -> 0x0041 }
        L_0x0034:
            r2 = move-exception;	 Catch:{ IOException -> 0x0099, InterruptedException -> 0x0088, Exception -> 0x006f, OutOfMemoryError -> 0x0056, Error -> 0x0041 }
            com.google.android.exoplayer2.util.TraceUtil.m4289a();	 Catch:{ IOException -> 0x0099, InterruptedException -> 0x0088, Exception -> 0x006f, OutOfMemoryError -> 0x0056, Error -> 0x0041 }
            throw r2;	 Catch:{ IOException -> 0x0099, InterruptedException -> 0x0088, Exception -> 0x006f, OutOfMemoryError -> 0x0056, Error -> 0x0041 }
        L_0x0039:
            r2 = r4.f5190i;	 Catch:{ IOException -> 0x0099, InterruptedException -> 0x0088, Exception -> 0x006f, OutOfMemoryError -> 0x0056, Error -> 0x0041 }
            if (r2 != 0) goto L_0x0040;	 Catch:{ IOException -> 0x0099, InterruptedException -> 0x0088, Exception -> 0x006f, OutOfMemoryError -> 0x0056, Error -> 0x0041 }
        L_0x003d:
            r4.sendEmptyMessage(r0);	 Catch:{ IOException -> 0x0099, InterruptedException -> 0x0088, Exception -> 0x006f, OutOfMemoryError -> 0x0056, Error -> 0x0041 }
        L_0x0040:
            return;
        L_0x0041:
            r0 = move-exception;
            r1 = "LoadTask";
            r2 = "Unexpected error loading stream";
            android.util.Log.e(r1, r2, r0);
            r1 = r4.f5190i;
            if (r1 != 0) goto L_0x0055;
        L_0x004d:
            r1 = 4;
            r1 = r4.obtainMessage(r1, r0);
            r1.sendToTarget();
        L_0x0055:
            throw r0;
        L_0x0056:
            r0 = move-exception;
            r2 = "LoadTask";
            r3 = "OutOfMemory error loading stream";
            android.util.Log.e(r2, r3, r0);
            r2 = r4.f5190i;
            if (r2 != 0) goto L_0x006e;
        L_0x0062:
            r2 = new com.google.android.exoplayer2.upstream.Loader$UnexpectedLoaderException;
            r2.<init>(r0);
            r0 = r4.obtainMessage(r1, r2);
            r0.sendToTarget();
        L_0x006e:
            return;
        L_0x006f:
            r0 = move-exception;
            r2 = "LoadTask";
            r3 = "Unexpected exception loading stream";
            android.util.Log.e(r2, r3, r0);
            r2 = r4.f5190i;
            if (r2 != 0) goto L_0x0087;
        L_0x007b:
            r2 = new com.google.android.exoplayer2.upstream.Loader$UnexpectedLoaderException;
            r2.<init>(r0);
            r0 = r4.obtainMessage(r1, r2);
            r0.sendToTarget();
        L_0x0087:
            return;
        L_0x0088:
            r1 = r4.f5186e;
            r1 = r1.mo1405b();
            com.google.android.exoplayer2.util.Assertions.m4186b(r1);
            r1 = r4.f5190i;
            if (r1 != 0) goto L_0x0098;
        L_0x0095:
            r4.sendEmptyMessage(r0);
        L_0x0098:
            return;
        L_0x0099:
            r0 = move-exception;
            r2 = r4.f5190i;
            if (r2 != 0) goto L_0x00a5;
        L_0x009e:
            r0 = r4.obtainMessage(r1, r0);
            r0.sendToTarget();
        L_0x00a5:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.Loader.LoadTask.run():void");
        }

        public final void handleMessage(Message message) {
            if (!this.f5190i) {
                if (message.what == 0) {
                    m4155a();
                } else if (message.what == 4) {
                    throw ((Error) message.obj);
                } else {
                    m4156b();
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    long j = elapsedRealtime - this.f5188g;
                    if (this.f5186e.mo1405b()) {
                        this.f5187f.mo1420a(this.f5186e, elapsedRealtime, j, false);
                        return;
                    }
                    switch (message.what) {
                        case 1:
                            this.f5187f.mo1420a(this.f5186e, elapsedRealtime, j, false);
                            return;
                        case 2:
                            this.f5187f.mo1419a(this.f5186e, elapsedRealtime, j);
                            return;
                        case 3:
                            this.f5183b = (IOException) message.obj;
                            message = this.f5187f.mo1418a(this.f5186e, elapsedRealtime, j, this.f5183b);
                            if (message != 3) {
                                if (message != 2) {
                                    if (message == 1) {
                                        message = 1;
                                    } else {
                                        message = this.f5184c + 1;
                                    }
                                    this.f5184c = message;
                                    m4157a((long) Math.min((this.f5184c - 1) * 1000, 5000));
                                    break;
                                }
                            }
                            this.f5185d.f13681c = this.f5183b;
                            return;
                            break;
                        default:
                            break;
                    }
                }
            }
        }

        private void m4155a() {
            this.f5183b = null;
            this.f5185d.f13679a.execute(this.f5185d.f13680b);
        }

        private void m4156b() {
            this.f5185d.f13680b = null;
        }
    }

    public interface Loadable {
        void mo1404a();

        boolean mo1405b();

        void mo1406c() throws IOException, InterruptedException;
    }

    public interface ReleaseCallback {
        void mo1421f();
    }

    private static final class ReleaseTask extends Handler implements Runnable {
        private final ReleaseCallback f5191a;

        public ReleaseTask(ReleaseCallback releaseCallback) {
            this.f5191a = releaseCallback;
        }

        public final void run() {
            sendEmptyMessage(0);
        }

        public final void handleMessage(Message message) {
            this.f5191a.mo1421f();
        }
    }

    public static final class UnexpectedLoaderException extends IOException {
        public UnexpectedLoaderException(Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("Unexpected ");
            stringBuilder.append(th.getClass().getSimpleName());
            stringBuilder.append(": ");
            stringBuilder.append(th.getMessage());
            super(stringBuilder.toString(), th);
        }
    }

    public Loader(String str) {
        this.f13679a = Util.m4306a(str);
    }

    public final <T extends Loadable> long m12692a(T t, Callback<T> callback, int i) {
        Looper myLooper = Looper.myLooper();
        Assertions.m4186b(myLooper != null);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new LoadTask(this, myLooper, t, callback, i, elapsedRealtime).m4157a((long) null);
        return elapsedRealtime;
    }

    public final boolean m12693a() {
        return this.f13680b != null;
    }

    public final void m12695b() {
        this.f13680b.m4158a(false);
    }

    public final boolean m12694a(ReleaseCallback releaseCallback) {
        boolean z = true;
        if (this.f13680b != null) {
            this.f13680b.m4158a(true);
            if (releaseCallback != null) {
                this.f13679a.execute(new ReleaseTask(releaseCallback));
            }
        } else if (releaseCallback != null) {
            releaseCallback.mo1421f();
            this.f13679a.shutdown();
            return z;
        }
        z = false;
        this.f13679a.shutdown();
        return z;
    }

    public final void mo1477c() throws IOException {
        if (this.f13681c != null) {
            throw this.f13681c;
        } else if (this.f13680b != null) {
            LoadTask loadTask = this.f13680b;
            int i = this.f13680b.f5182a;
            if (loadTask.f5183b != null && loadTask.f5184c > i) {
                throw loadTask.f5183b;
            }
        }
    }
}
