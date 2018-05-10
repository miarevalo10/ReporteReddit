package com.facebook.stetho.server;

import android.net.LocalServerSocket;
import android.net.LocalSocket;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.Util;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class LocalSocketServer {
    private static final int MAX_BIND_RETRIES = 2;
    private static final int TIME_BETWEEN_BIND_RETRIES_MS = 1000;
    private static final String WORKER_THREAD_NAME_PREFIX = "StethoWorker";
    private final String mAddress;
    private final String mFriendlyName;
    private Thread mListenerThread;
    private LocalServerSocket mServerSocket;
    private final SocketHandler mSocketHandler;
    private boolean mStopped;
    private final AtomicInteger mThreadId = new AtomicInteger();

    private static class WorkerThread extends Thread {
        private final LocalSocket mSocket;
        private final SocketHandler mSocketHandler;

        public WorkerThread(LocalSocket localSocket, SocketHandler socketHandler) {
            this.mSocket = localSocket;
            this.mSocketHandler = socketHandler;
        }

        public void run() {
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
            r0 = r4.mSocketHandler;	 Catch:{ IOException -> 0x0010 }
            r1 = r4.mSocket;	 Catch:{ IOException -> 0x0010 }
            r0.onAccepted(r1);	 Catch:{ IOException -> 0x0010 }
            r0 = r4.mSocket;	 Catch:{ IOException -> 0x000d }
            r0.close();	 Catch:{ IOException -> 0x000d }
            return;
        L_0x000d:
            return;
        L_0x000e:
            r0 = move-exception;
            goto L_0x0023;
        L_0x0010:
            r0 = move-exception;
            r1 = "I/O error: %s";	 Catch:{ all -> 0x000e }
            r2 = 1;	 Catch:{ all -> 0x000e }
            r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x000e }
            r3 = 0;	 Catch:{ all -> 0x000e }
            r2[r3] = r0;	 Catch:{ all -> 0x000e }
            com.facebook.stetho.common.LogUtil.m3448w(r1, r2);	 Catch:{ all -> 0x000e }
            r0 = r4.mSocket;	 Catch:{ IOException -> 0x0022 }
            r0.close();	 Catch:{ IOException -> 0x0022 }
            return;
        L_0x0022:
            return;
        L_0x0023:
            r1 = r4.mSocket;	 Catch:{ IOException -> 0x0028 }
            r1.close();	 Catch:{ IOException -> 0x0028 }
        L_0x0028:
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.stetho.server.LocalSocketServer.WorkerThread.run():void");
        }
    }

    public LocalSocketServer(String str, String str2, SocketHandler socketHandler) {
        this.mFriendlyName = (String) Util.throwIfNull(str);
        this.mAddress = (String) Util.throwIfNull(str2);
        this.mSocketHandler = socketHandler;
    }

    public String getName() {
        return this.mFriendlyName;
    }

    public void run() throws IOException {
        synchronized (this) {
            if (this.mStopped) {
                return;
            }
            this.mListenerThread = Thread.currentThread();
            listenOnAddress(this.mAddress);
        }
    }

    private void listenOnAddress(java.lang.String r4) throws java.io.IOException {
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
        r3 = this;
        r0 = bindToSocket(r4);
        r3.mServerSocket = r0;
        r0 = new java.lang.StringBuilder;
        r1 = "Listening on @";
        r0.<init>(r1);
        r0.append(r4);
        r0 = r0.toString();
        com.facebook.stetho.common.LogUtil.m3439i(r0);
    L_0x0017:
        r0 = java.lang.Thread.interrupted();
        if (r0 != 0) goto L_0x0067;
    L_0x001d:
        r0 = r3.mServerSocket;	 Catch:{ SocketException -> 0x005a, InterruptedIOException -> 0x0067, IOException -> 0x0053 }
        r0 = r0.accept();	 Catch:{ SocketException -> 0x005a, InterruptedIOException -> 0x0067, IOException -> 0x0053 }
        r1 = new com.facebook.stetho.server.LocalSocketServer$WorkerThread;	 Catch:{ SocketException -> 0x005a, InterruptedIOException -> 0x0067, IOException -> 0x0053 }
        r2 = r3.mSocketHandler;	 Catch:{ SocketException -> 0x005a, InterruptedIOException -> 0x0067, IOException -> 0x0053 }
        r1.<init>(r0, r2);	 Catch:{ SocketException -> 0x005a, InterruptedIOException -> 0x0067, IOException -> 0x0053 }
        r0 = new java.lang.StringBuilder;	 Catch:{ SocketException -> 0x005a, InterruptedIOException -> 0x0067, IOException -> 0x0053 }
        r2 = "StethoWorker-";	 Catch:{ SocketException -> 0x005a, InterruptedIOException -> 0x0067, IOException -> 0x0053 }
        r0.<init>(r2);	 Catch:{ SocketException -> 0x005a, InterruptedIOException -> 0x0067, IOException -> 0x0053 }
        r2 = r3.mFriendlyName;	 Catch:{ SocketException -> 0x005a, InterruptedIOException -> 0x0067, IOException -> 0x0053 }
        r0.append(r2);	 Catch:{ SocketException -> 0x005a, InterruptedIOException -> 0x0067, IOException -> 0x0053 }
        r2 = "-";	 Catch:{ SocketException -> 0x005a, InterruptedIOException -> 0x0067, IOException -> 0x0053 }
        r0.append(r2);	 Catch:{ SocketException -> 0x005a, InterruptedIOException -> 0x0067, IOException -> 0x0053 }
        r2 = r3.mThreadId;	 Catch:{ SocketException -> 0x005a, InterruptedIOException -> 0x0067, IOException -> 0x0053 }
        r2 = r2.incrementAndGet();	 Catch:{ SocketException -> 0x005a, InterruptedIOException -> 0x0067, IOException -> 0x0053 }
        r0.append(r2);	 Catch:{ SocketException -> 0x005a, InterruptedIOException -> 0x0067, IOException -> 0x0053 }
        r0 = r0.toString();	 Catch:{ SocketException -> 0x005a, InterruptedIOException -> 0x0067, IOException -> 0x0053 }
        r1.setName(r0);	 Catch:{ SocketException -> 0x005a, InterruptedIOException -> 0x0067, IOException -> 0x0053 }
        r0 = 1;	 Catch:{ SocketException -> 0x005a, InterruptedIOException -> 0x0067, IOException -> 0x0053 }
        r1.setDaemon(r0);	 Catch:{ SocketException -> 0x005a, InterruptedIOException -> 0x0067, IOException -> 0x0053 }
        r1.start();	 Catch:{ SocketException -> 0x005a, InterruptedIOException -> 0x0067, IOException -> 0x0053 }
        goto L_0x0017;
    L_0x0053:
        r0 = move-exception;
        r1 = "I/O error initialising connection thread";
        com.facebook.stetho.common.LogUtil.m3449w(r0, r1);
        goto L_0x0067;
    L_0x005a:
        r0 = move-exception;
        r1 = java.lang.Thread.interrupted();
        if (r1 != 0) goto L_0x0067;
    L_0x0061:
        r1 = "I/O error";
        com.facebook.stetho.common.LogUtil.m3449w(r0, r1);
        goto L_0x0017;
    L_0x0067:
        r0 = new java.lang.StringBuilder;
        r1 = "Server shutdown on @";
        r0.<init>(r1);
        r0.append(r4);
        r4 = r0.toString();
        com.facebook.stetho.common.LogUtil.m3439i(r4);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stetho.server.LocalSocketServer.listenOnAddress(java.lang.String):void");
    }

    public void stop() {
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
        r1 = this;
        monitor-enter(r1);
        r0 = 1;
        r1.mStopped = r0;	 Catch:{ all -> 0x001b }
        r0 = r1.mListenerThread;	 Catch:{ all -> 0x001b }
        if (r0 != 0) goto L_0x000a;	 Catch:{ all -> 0x001b }
    L_0x0008:
        monitor-exit(r1);	 Catch:{ all -> 0x001b }
        return;	 Catch:{ all -> 0x001b }
    L_0x000a:
        monitor-exit(r1);	 Catch:{ all -> 0x001b }
        r0 = r1.mListenerThread;
        r0.interrupt();
        r0 = r1.mServerSocket;	 Catch:{ IOException -> 0x001a }
        if (r0 == 0) goto L_0x0019;	 Catch:{ IOException -> 0x001a }
    L_0x0014:
        r0 = r1.mServerSocket;	 Catch:{ IOException -> 0x001a }
        r0.close();	 Catch:{ IOException -> 0x001a }
    L_0x0019:
        return;
    L_0x001a:
        return;
    L_0x001b:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001b }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stetho.server.LocalSocketServer.stop():void");
    }

    private static LocalServerSocket bindToSocket(String str) throws IOException {
        int i = 2;
        Throwable th = null;
        while (true) {
            try {
                break;
            } catch (Throwable e) {
                LogUtil.m3449w(e, "Binding error, sleep 1000 ms...");
                if (th == null) {
                    th = e;
                }
                Util.sleepUninterruptibly(1000);
                r2 = i - 1;
                if (i <= 0) {
                    throw th;
                }
                int i2;
                i = i2;
            }
        }
        if (LogUtil.isLoggable(3)) {
            StringBuilder stringBuilder = new StringBuilder("Trying to bind to @");
            stringBuilder.append(str);
            LogUtil.m3431d(stringBuilder.toString());
        }
        return new LocalServerSocket(str);
    }
}
