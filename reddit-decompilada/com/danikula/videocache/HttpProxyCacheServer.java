package com.danikula.videocache;

import android.content.Context;
import android.net.Uri;
import com.danikula.videocache.file.DiskUsage;
import com.danikula.videocache.file.FileNameGenerator;
import com.danikula.videocache.file.Md5FileNameGenerator;
import com.danikula.videocache.file.TotalSizeLruDiskUsage;
import com.danikula.videocache.sourcestorage.SourceInfoStorage;
import com.danikula.videocache.sourcestorage.SourceInfoStorageFactory;
import java.io.File;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class    HttpProxyCacheServer {
    private static final Logger f3736a = LoggerFactory.a("HttpProxyCacheServer");
    private final Object f3737b;
    private final ExecutorService f3738c;
    private final Map<String, HttpProxyCacheServerClients> f3739d;
    private final ServerSocket f3740e;
    private final int f3741f;
    private final Thread f3742g;
    private final Config f3743h;
    private final Pinger f3744i;

    public static final class Builder {
        public File f3728a;
        public FileNameGenerator f3729b = new Md5FileNameGenerator();
        public DiskUsage f3730c = new TotalSizeLruDiskUsage();
        public SourceInfoStorage f3731d;

        public Builder(Context context) {
            this.f3731d = SourceInfoStorageFactory.m3363a(context);
            this.f3728a = StorageUtils.m3353a(context);
        }
    }

    private final class SocketProcessorRunnable implements Runnable {
        final /* synthetic */ HttpProxyCacheServer f3732a;
        private final Socket f3733b;

        public SocketProcessorRunnable(HttpProxyCacheServer httpProxyCacheServer, Socket socket) {
            this.f3732a = httpProxyCacheServer;
            this.f3733b = socket;
        }

        public final void run() {
            HttpProxyCacheServer.m3315a(this.f3732a, this.f3733b);
        }
    }

    private final class WaitRequestsRunnable implements Runnable {
        final /* synthetic */ HttpProxyCacheServer f3734a;
        private final CountDownLatch f3735b;

        public WaitRequestsRunnable(HttpProxyCacheServer httpProxyCacheServer, CountDownLatch countDownLatch) {
            this.f3734a = httpProxyCacheServer;
            this.f3735b = countDownLatch;
        }

        public final void run() {
            this.f3735b.countDown();
            HttpProxyCacheServer.m3314a(this.f3734a);
        }
    }

    private HttpProxyCacheServer(Config config) {
        this.f3737b = new Object();
        this.f3738c = Executors.newFixedThreadPool(8);
        this.f3739d = new ConcurrentHashMap();
        this.f3743h = (Config) Preconditions.m3330a((Object) config);
        try {
            this.f3740e = new ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"));
            this.f3741f = this.f3740e.getLocalPort();
            IgnoreHostProxySelector.m3322a("127.0.0.1", this.f3741f);
            config = new CountDownLatch(1);
            this.f3742g = new Thread(new WaitRequestsRunnable(this, config));
            this.f3742g.start();
            config.await();
            this.f3744i = new Pinger("127.0.0.1", this.f3741f);
            config = f3736a;
            StringBuilder stringBuilder = new StringBuilder("Proxy cache server started. Is it alive? ");
            stringBuilder.append(this.f3744i.m3329a());
            config.b(stringBuilder.toString());
        } catch (Config config2) {
            this.f3738c.shutdown();
            throw new IllegalStateException("Error starting local proxy server", config2);
        }
    }

    private File m3313a(String str) {
        return new File(this.f3743h.f3719a, this.f3743h.f3720b.mo1104a(str));
    }

    private HttpProxyCacheServerClients m3318b(String str) throws ProxyCacheException {
        HttpProxyCacheServerClients httpProxyCacheServerClients;
        synchronized (this.f3737b) {
            httpProxyCacheServerClients = (HttpProxyCacheServerClients) this.f3739d.get(str);
            if (httpProxyCacheServerClients == null) {
                httpProxyCacheServerClients = new HttpProxyCacheServerClients(str, this.f3743h);
                this.f3739d.put(str, httpProxyCacheServerClients);
            }
        }
        return httpProxyCacheServerClients;
    }

    private int m3312a() {
        int i;
        synchronized (this.f3737b) {
            i = 0;
            for (HttpProxyCacheServerClients httpProxyCacheServerClients : this.f3739d.values()) {
                i += httpProxyCacheServerClients.f3745a.get();
            }
        }
        return i;
    }

    private static void m3316a(Throwable th) {
        f3736a.a("HttpProxyCacheServer error", th);
    }

    public final String m3319a(String str, boolean z) {
        if (z) {
            Preconditions.m3331a((Object) str, "Url can't be null!");
            if (m3313a(str).exists()) {
                str = m3313a(str);
                try {
                    this.f3743h.f3721c.mo1103a(str);
                } catch (boolean z2) {
                    Logger logger = f3736a;
                    StringBuilder stringBuilder = new StringBuilder("Error touching file ");
                    stringBuilder.append(str);
                    logger.a(stringBuilder.toString(), z2);
                }
                return Uri.fromFile(str).toString();
            }
        }
        if (this.f3744i.m3329a()) {
            str = String.format(Locale.US, "http://%s:%d/%s", new Object[]{"127.0.0.1", Integer.valueOf(this.f3741f), ProxyCacheUtils.m3346b(str)});
        }
        return str;
    }

    private static void m3317a(java.net.Socket r3) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = r3.isInputShutdown();	 Catch:{ SocketException -> 0x0016, IOException -> 0x000a }
        if (r0 != 0) goto L_0x001d;	 Catch:{ SocketException -> 0x0016, IOException -> 0x000a }
    L_0x0006:
        r3.shutdownInput();	 Catch:{ SocketException -> 0x0016, IOException -> 0x000a }
        goto L_0x001d;
    L_0x000a:
        r0 = move-exception;
        r1 = new com.danikula.videocache.ProxyCacheException;
        r2 = "Error closing socket input stream";
        r1.<init>(r2, r0);
        m3316a(r1);
        goto L_0x001d;
    L_0x0016:
        r0 = f3736a;
        r1 = "Releasing input stream… Socket is closed by client.";
        r0.a(r1);
    L_0x001d:
        r0 = r3.isOutputShutdown();	 Catch:{ IOException -> 0x0027 }
        if (r0 != 0) goto L_0x0033;	 Catch:{ IOException -> 0x0027 }
    L_0x0023:
        r3.shutdownOutput();	 Catch:{ IOException -> 0x0027 }
        goto L_0x0033;
    L_0x0027:
        r0 = move-exception;
        r1 = f3736a;
        r2 = "Failed to close socket on proxy side: {}. It seems client have already closed connection.";
        r0 = r0.getMessage();
        r1.a(r2, r0);
    L_0x0033:
        r0 = r3.isClosed();	 Catch:{ IOException -> 0x003d }
        if (r0 != 0) goto L_0x003c;	 Catch:{ IOException -> 0x003d }
    L_0x0039:
        r3.close();	 Catch:{ IOException -> 0x003d }
    L_0x003c:
        return;
    L_0x003d:
        r3 = move-exception;
        r0 = new com.danikula.videocache.ProxyCacheException;
        r1 = "Error closing socket";
        r0.<init>(r1, r3);
        m3316a(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.danikula.videocache.HttpProxyCacheServer.a(java.net.Socket):void");
    }

    static /* synthetic */ void m3314a(HttpProxyCacheServer httpProxyCacheServer) {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket accept = httpProxyCacheServer.f3740e.accept();
                Logger logger = f3736a;
                StringBuilder stringBuilder = new StringBuilder("Accept new socket ");
                stringBuilder.append(accept);
                logger.a(stringBuilder.toString());
                httpProxyCacheServer.f3738c.submit(new SocketProcessorRunnable(httpProxyCacheServer, accept));
            } catch (HttpProxyCacheServer httpProxyCacheServer2) {
                m3316a(new ProxyCacheException("Error during waiting connection", httpProxyCacheServer2));
                return;
            }
        }
    }

    static /* synthetic */ void m3315a(com.danikula.videocache.HttpProxyCacheServer r18, java.net.Socket r19) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r1 = r19.getInputStream();	 Catch:{ SocketException -> 0x017e, ProxyCacheException -> 0x0165, ProxyCacheException -> 0x0165 }
        r1 = com.danikula.videocache.GetRequest.m3311a(r1);	 Catch:{ SocketException -> 0x017e, ProxyCacheException -> 0x0165, ProxyCacheException -> 0x0165 }
        r2 = f3736a;	 Catch:{ SocketException -> 0x017e, ProxyCacheException -> 0x0165, ProxyCacheException -> 0x0165 }
        r3 = new java.lang.StringBuilder;	 Catch:{ SocketException -> 0x017e, ProxyCacheException -> 0x0165, ProxyCacheException -> 0x0165 }
        r4 = "Request to cache proxy:";	 Catch:{ SocketException -> 0x017e, ProxyCacheException -> 0x0165, ProxyCacheException -> 0x0165 }
        r3.<init>(r4);	 Catch:{ SocketException -> 0x017e, ProxyCacheException -> 0x0165, ProxyCacheException -> 0x0165 }
        r3.append(r1);	 Catch:{ SocketException -> 0x017e, ProxyCacheException -> 0x0165, ProxyCacheException -> 0x0165 }
        r3 = r3.toString();	 Catch:{ SocketException -> 0x017e, ProxyCacheException -> 0x0165, ProxyCacheException -> 0x0165 }
        r2.a(r3);	 Catch:{ SocketException -> 0x017e, ProxyCacheException -> 0x0165, ProxyCacheException -> 0x0165 }
        r2 = r1.f3725a;	 Catch:{ SocketException -> 0x017e, ProxyCacheException -> 0x0165, ProxyCacheException -> 0x0165 }
        r2 = com.danikula.videocache.ProxyCacheUtils.m3347c(r2);	 Catch:{ SocketException -> 0x017e, ProxyCacheException -> 0x0165, ProxyCacheException -> 0x0165 }
        r3 = com.danikula.videocache.Pinger.m3325a(r2);	 Catch:{ SocketException -> 0x017e, ProxyCacheException -> 0x0165, ProxyCacheException -> 0x0165 }
        if (r3 == 0) goto L_0x002c;	 Catch:{ SocketException -> 0x017e, ProxyCacheException -> 0x0165, ProxyCacheException -> 0x0165 }
    L_0x0027:
        com.danikula.videocache.Pinger.m3323a(r19);	 Catch:{ SocketException -> 0x017e, ProxyCacheException -> 0x0165, ProxyCacheException -> 0x0165 }
        goto L_0x0141;	 Catch:{ SocketException -> 0x017e, ProxyCacheException -> 0x0165, ProxyCacheException -> 0x0165 }
    L_0x002c:
        r3 = r18;	 Catch:{ SocketException -> 0x017e, ProxyCacheException -> 0x0165, ProxyCacheException -> 0x0165 }
        r2 = r3.m3318b(r2);	 Catch:{ SocketException -> 0x017e, ProxyCacheException -> 0x0165, ProxyCacheException -> 0x0165 }
        r2.m3320a();	 Catch:{ SocketException -> 0x017e, ProxyCacheException -> 0x0165, ProxyCacheException -> 0x0165 }
        r4 = r2.f3745a;	 Catch:{ all -> 0x015c }
        r4.incrementAndGet();	 Catch:{ all -> 0x015c }
        r4 = r2.f3746b;	 Catch:{ all -> 0x015c }
        r5 = new java.io.BufferedOutputStream;	 Catch:{ all -> 0x015c }
        r6 = r19.getOutputStream();	 Catch:{ all -> 0x015c }
        r5.<init>(r6);	 Catch:{ all -> 0x015c }
        r6 = r4.f12679a;	 Catch:{ all -> 0x015c }
        r6 = r6.m11768c();	 Catch:{ all -> 0x015c }
        r7 = android.text.TextUtils.isEmpty(r6);	 Catch:{ all -> 0x015c }
        r8 = 1;	 Catch:{ all -> 0x015c }
        r7 = r7 ^ r8;	 Catch:{ all -> 0x015c }
        r9 = r4.f12680b;	 Catch:{ all -> 0x015c }
        r9 = r9.isCompleted();	 Catch:{ all -> 0x015c }
        if (r9 == 0) goto L_0x0060;	 Catch:{ all -> 0x015c }
    L_0x0059:
        r9 = r4.f12680b;	 Catch:{ all -> 0x015c }
        r9 = r9.available();	 Catch:{ all -> 0x015c }
        goto L_0x0066;	 Catch:{ all -> 0x015c }
    L_0x0060:
        r9 = r4.f12679a;	 Catch:{ all -> 0x015c }
        r9 = r9.mo1100a();	 Catch:{ all -> 0x015c }
    L_0x0066:
        r11 = 0;	 Catch:{ all -> 0x015c }
        r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1));	 Catch:{ all -> 0x015c }
        if (r13 < 0) goto L_0x006e;	 Catch:{ all -> 0x015c }
    L_0x006c:
        r13 = r8;	 Catch:{ all -> 0x015c }
        goto L_0x006f;	 Catch:{ all -> 0x015c }
    L_0x006e:
        r13 = 0;	 Catch:{ all -> 0x015c }
    L_0x006f:
        r15 = r1.f3727c;	 Catch:{ all -> 0x015c }
        if (r15 == 0) goto L_0x0078;	 Catch:{ all -> 0x015c }
    L_0x0073:
        r11 = r1.f3726b;	 Catch:{ all -> 0x015c }
        r11 = r9 - r11;	 Catch:{ all -> 0x015c }
        goto L_0x0079;	 Catch:{ all -> 0x015c }
    L_0x0078:
        r11 = r9;	 Catch:{ all -> 0x015c }
    L_0x0079:
        if (r13 == 0) goto L_0x0081;	 Catch:{ all -> 0x015c }
    L_0x007b:
        r15 = r1.f3727c;	 Catch:{ all -> 0x015c }
        if (r15 == 0) goto L_0x0081;	 Catch:{ all -> 0x015c }
    L_0x007f:
        r15 = r8;	 Catch:{ all -> 0x015c }
        goto L_0x0082;	 Catch:{ all -> 0x015c }
    L_0x0081:
        r15 = 0;	 Catch:{ all -> 0x015c }
    L_0x0082:
        r14 = new java.lang.StringBuilder;	 Catch:{ all -> 0x015c }
        r14.<init>();	 Catch:{ all -> 0x015c }
        r8 = r1.f3727c;	 Catch:{ all -> 0x015c }
        if (r8 == 0) goto L_0x008e;	 Catch:{ all -> 0x015c }
    L_0x008b:
        r8 = "HTTP/1.1 206 PARTIAL CONTENT\n";	 Catch:{ all -> 0x015c }
        goto L_0x0090;	 Catch:{ all -> 0x015c }
    L_0x008e:
        r8 = "HTTP/1.1 200 OK\n";	 Catch:{ all -> 0x015c }
    L_0x0090:
        r14.append(r8);	 Catch:{ all -> 0x015c }
        r8 = "Accept-Ranges: bytes\n";	 Catch:{ all -> 0x015c }
        r14.append(r8);	 Catch:{ all -> 0x015c }
        if (r13 == 0) goto L_0x00ab;	 Catch:{ all -> 0x015c }
    L_0x009a:
        r8 = "Content-Length: %d\n";	 Catch:{ all -> 0x015c }
        r13 = 1;	 Catch:{ all -> 0x015c }
        r3 = new java.lang.Object[r13];	 Catch:{ all -> 0x015c }
        r11 = java.lang.Long.valueOf(r11);	 Catch:{ all -> 0x015c }
        r12 = 0;	 Catch:{ all -> 0x015c }
        r3[r12] = r11;	 Catch:{ all -> 0x015c }
        r3 = com.danikula.videocache.HttpProxyCache.m11756a(r8, r3);	 Catch:{ all -> 0x015c }
        goto L_0x00ad;	 Catch:{ all -> 0x015c }
    L_0x00ab:
        r3 = "";	 Catch:{ all -> 0x015c }
    L_0x00ad:
        r14.append(r3);	 Catch:{ all -> 0x015c }
        if (r15 == 0) goto L_0x00d7;	 Catch:{ all -> 0x015c }
    L_0x00b2:
        r3 = "Content-Range: bytes %d-%d/%d\n";	 Catch:{ all -> 0x015c }
        r8 = 3;	 Catch:{ all -> 0x015c }
        r8 = new java.lang.Object[r8];	 Catch:{ all -> 0x015c }
        r11 = r1.f3726b;	 Catch:{ all -> 0x015c }
        r11 = java.lang.Long.valueOf(r11);	 Catch:{ all -> 0x015c }
        r12 = 0;	 Catch:{ all -> 0x015c }
        r8[r12] = r11;	 Catch:{ all -> 0x015c }
        r11 = 1;	 Catch:{ all -> 0x015c }
        r11 = r9 - r11;	 Catch:{ all -> 0x015c }
        r11 = java.lang.Long.valueOf(r11);	 Catch:{ all -> 0x015c }
        r12 = 1;	 Catch:{ all -> 0x015c }
        r8[r12] = r11;	 Catch:{ all -> 0x015c }
        r11 = 2;	 Catch:{ all -> 0x015c }
        r9 = java.lang.Long.valueOf(r9);	 Catch:{ all -> 0x015c }
        r8[r11] = r9;	 Catch:{ all -> 0x015c }
        r3 = com.danikula.videocache.HttpProxyCache.m11756a(r3, r8);	 Catch:{ all -> 0x015c }
        goto L_0x00d9;	 Catch:{ all -> 0x015c }
    L_0x00d7:
        r3 = "";	 Catch:{ all -> 0x015c }
    L_0x00d9:
        r14.append(r3);	 Catch:{ all -> 0x015c }
        if (r7 == 0) goto L_0x00ec;	 Catch:{ all -> 0x015c }
    L_0x00de:
        r3 = "Content-Type: %s\n";	 Catch:{ all -> 0x015c }
        r13 = 1;	 Catch:{ all -> 0x015c }
        r7 = new java.lang.Object[r13];	 Catch:{ all -> 0x015c }
        r16 = 0;	 Catch:{ all -> 0x015c }
        r7[r16] = r6;	 Catch:{ all -> 0x015c }
        r3 = com.danikula.videocache.HttpProxyCache.m11756a(r3, r7);	 Catch:{ all -> 0x015c }
        goto L_0x00f1;	 Catch:{ all -> 0x015c }
    L_0x00ec:
        r13 = 1;	 Catch:{ all -> 0x015c }
        r16 = 0;	 Catch:{ all -> 0x015c }
        r3 = "";	 Catch:{ all -> 0x015c }
    L_0x00f1:
        r14.append(r3);	 Catch:{ all -> 0x015c }
        r3 = "\n";	 Catch:{ all -> 0x015c }
        r14.append(r3);	 Catch:{ all -> 0x015c }
        r3 = r14.toString();	 Catch:{ all -> 0x015c }
        r6 = "UTF-8";	 Catch:{ all -> 0x015c }
        r3 = r3.getBytes(r6);	 Catch:{ all -> 0x015c }
        r5.write(r3);	 Catch:{ all -> 0x015c }
        r6 = r1.f3726b;	 Catch:{ all -> 0x015c }
        r3 = r4.f12679a;	 Catch:{ all -> 0x015c }
        r8 = r3.mo1100a();	 Catch:{ all -> 0x015c }
        r10 = 0;	 Catch:{ all -> 0x015c }
        r3 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));	 Catch:{ all -> 0x015c }
        if (r3 <= 0) goto L_0x0116;	 Catch:{ all -> 0x015c }
    L_0x0114:
        r3 = r13;	 Catch:{ all -> 0x015c }
        goto L_0x0118;	 Catch:{ all -> 0x015c }
    L_0x0116:
        r3 = r16;	 Catch:{ all -> 0x015c }
    L_0x0118:
        r10 = r4.f12680b;	 Catch:{ all -> 0x015c }
        r10 = r10.available();	 Catch:{ all -> 0x015c }
        if (r3 == 0) goto L_0x0135;	 Catch:{ all -> 0x015c }
    L_0x0120:
        r3 = r1.f3727c;	 Catch:{ all -> 0x015c }
        if (r3 == 0) goto L_0x0135;	 Catch:{ all -> 0x015c }
    L_0x0124:
        r14 = r1.f3726b;	 Catch:{ all -> 0x015c }
        r1 = (float) r14;	 Catch:{ all -> 0x015c }
        r3 = (float) r10;	 Catch:{ all -> 0x015c }
        r8 = (float) r8;	 Catch:{ all -> 0x015c }
        r9 = 1045220557; // 0x3e4ccccd float:0.2 double:5.164075695E-315;	 Catch:{ all -> 0x015c }
        r8 = r8 * r9;	 Catch:{ all -> 0x015c }
        r3 = r3 + r8;	 Catch:{ all -> 0x015c }
        r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));	 Catch:{ all -> 0x015c }
        if (r1 > 0) goto L_0x0133;	 Catch:{ all -> 0x015c }
    L_0x0132:
        goto L_0x0135;	 Catch:{ all -> 0x015c }
    L_0x0133:
        r13 = r16;	 Catch:{ all -> 0x015c }
    L_0x0135:
        if (r13 == 0) goto L_0x013b;	 Catch:{ all -> 0x015c }
    L_0x0137:
        r4.m11758a(r5, r6);	 Catch:{ all -> 0x015c }
        goto L_0x013e;	 Catch:{ all -> 0x015c }
    L_0x013b:
        r4.m11759b(r5, r6);	 Catch:{ all -> 0x015c }
    L_0x013e:
        r2.m3321b();	 Catch:{ SocketException -> 0x017e, ProxyCacheException -> 0x0165, ProxyCacheException -> 0x0165 }
    L_0x0141:
        m3317a(r19);
        r1 = f3736a;
        r2 = new java.lang.StringBuilder;
        r3 = "Opened connections: ";
        r2.<init>(r3);
    L_0x014d:
        r3 = r18.m3312a();
        r2.append(r3);
        r2 = r2.toString();
        r1.a(r2);
        return;
    L_0x015c:
        r0 = move-exception;
        r1 = r0;
        r2.m3321b();	 Catch:{ SocketException -> 0x017e, ProxyCacheException -> 0x0165, ProxyCacheException -> 0x0165 }
        throw r1;	 Catch:{ SocketException -> 0x017e, ProxyCacheException -> 0x0165, ProxyCacheException -> 0x0165 }
    L_0x0162:
        r0 = move-exception;
        r1 = r0;
        goto L_0x0192;
    L_0x0165:
        r0 = move-exception;
        r1 = r0;
        r2 = new com.danikula.videocache.ProxyCacheException;	 Catch:{ all -> 0x0162 }
        r3 = "Error processing request";	 Catch:{ all -> 0x0162 }
        r2.<init>(r3, r1);	 Catch:{ all -> 0x0162 }
        m3316a(r2);	 Catch:{ all -> 0x0162 }
        m3317a(r19);
        r1 = f3736a;
        r2 = new java.lang.StringBuilder;
        r3 = "Opened connections: ";
        r2.<init>(r3);
        goto L_0x014d;
    L_0x017e:
        r1 = f3736a;	 Catch:{ all -> 0x0162 }
        r2 = "Closing socket… Socket is closed by client.";	 Catch:{ all -> 0x0162 }
        r1.a(r2);	 Catch:{ all -> 0x0162 }
        m3317a(r19);
        r1 = f3736a;
        r2 = new java.lang.StringBuilder;
        r3 = "Opened connections: ";
        r2.<init>(r3);
        goto L_0x014d;
    L_0x0192:
        m3317a(r19);
        r2 = f3736a;
        r3 = new java.lang.StringBuilder;
        r4 = "Opened connections: ";
        r3.<init>(r4);
        r4 = r18.m3312a();
        r3.append(r4);
        r3 = r3.toString();
        r2.a(r3);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.danikula.videocache.HttpProxyCacheServer.a(com.danikula.videocache.HttpProxyCacheServer, java.net.Socket):void");
    }
}
