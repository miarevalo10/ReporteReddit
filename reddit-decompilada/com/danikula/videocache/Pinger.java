package com.danikula.videocache;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Pinger {
    private static final Logger f3756a = LoggerFactory.a("Pinger");
    private final ExecutorService f3757b = Executors.newSingleThreadExecutor();
    private final String f3758c;
    private final int f3759d;

    private class PingCallable implements Callable<Boolean> {
        final /* synthetic */ Pinger f3755a;

        private PingCallable(Pinger pinger) {
            this.f3755a = pinger;
        }

        public /* synthetic */ Object call() throws Exception {
            return Boolean.valueOf(this.f3755a.m3327c());
        }
    }

    Pinger(String str, int i) {
        this.f3758c = (String) Preconditions.m3330a((Object) str);
        this.f3759d = i;
    }

    final boolean m3329a() {
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
        r8 = this;
        r0 = 1;
        com.danikula.videocache.Preconditions.m3332a(r0);
        com.danikula.videocache.Preconditions.m3332a(r0);
        r1 = 0;
        r2 = 70;
        r3 = r2;
        r2 = r1;
    L_0x000c:
        r4 = 3;
        if (r2 >= r4) goto L_0x0058;
    L_0x000f:
        r4 = r8.f3757b;	 Catch:{ TimeoutException -> 0x0033, InterruptedException -> 0x002a, InterruptedException -> 0x002a }
        r5 = new com.danikula.videocache.Pinger$PingCallable;	 Catch:{ TimeoutException -> 0x0033, InterruptedException -> 0x002a, InterruptedException -> 0x002a }
        r5.<init>();	 Catch:{ TimeoutException -> 0x0033, InterruptedException -> 0x002a, InterruptedException -> 0x002a }
        r4 = r4.submit(r5);	 Catch:{ TimeoutException -> 0x0033, InterruptedException -> 0x002a, InterruptedException -> 0x002a }
        r5 = (long) r3;	 Catch:{ TimeoutException -> 0x0033, InterruptedException -> 0x002a, InterruptedException -> 0x002a }
        r7 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ TimeoutException -> 0x0033, InterruptedException -> 0x002a, InterruptedException -> 0x002a }
        r4 = r4.get(r5, r7);	 Catch:{ TimeoutException -> 0x0033, InterruptedException -> 0x002a, InterruptedException -> 0x002a }
        r4 = (java.lang.Boolean) r4;	 Catch:{ TimeoutException -> 0x0033, InterruptedException -> 0x002a, InterruptedException -> 0x002a }
        r4 = r4.booleanValue();	 Catch:{ TimeoutException -> 0x0033, InterruptedException -> 0x002a, InterruptedException -> 0x002a }
        if (r4 == 0) goto L_0x0053;
    L_0x0029:
        return r0;
    L_0x002a:
        r4 = move-exception;
        r5 = f3756a;
        r6 = "Error pinging server due to unexpected error";
        r5.a(r6, r4);
        goto L_0x0053;
    L_0x0033:
        r4 = f3756a;
        r5 = new java.lang.StringBuilder;
        r6 = "Error pinging server (attempt: ";
        r5.<init>(r6);
        r5.append(r2);
        r6 = ", timeout: ";
        r5.append(r6);
        r5.append(r3);
        r6 = "). ";
        r5.append(r6);
        r5 = r5.toString();
        r4.c(r5);
    L_0x0053:
        r2 = r2 + 1;
        r3 = r3 * 2;
        goto L_0x000c;
    L_0x0058:
        r5 = java.util.Locale.US;
        r6 = "Error pinging server (attempts: %d, max timeout: %d). If you see this message, please, report at https://github.com/danikula/AndroidVideoCache/issues/134. Default proxies are: %s";
        r4 = new java.lang.Object[r4];
        r2 = java.lang.Integer.valueOf(r2);
        r4[r1] = r2;
        r2 = 2;
        r3 = r3 / r2;
        r3 = java.lang.Integer.valueOf(r3);
        r4[r0] = r3;
        r0 = r8.m3326b();
        r4[r2] = r0;
        r0 = java.lang.String.format(r5, r6, r4);
        r2 = f3756a;
        r3 = new com.danikula.videocache.ProxyCacheException;
        r3.<init>(r0);
        r2.a(r0, r3);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.danikula.videocache.Pinger.a():boolean");
    }

    private List<Proxy> m3326b() {
        try {
            return ProxySelector.getDefault().select(new URI(m3328d()));
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    static boolean m3325a(String str) {
        return "ping".equals(str);
    }

    static void m3323a(Socket socket) throws IOException {
        socket = socket.getOutputStream();
        socket.write("HTTP/1.1 200 OK\n\n".getBytes());
        socket.write("ping ok".getBytes());
    }

    private boolean m3327c() throws ProxyCacheException {
        HttpUrlSource httpUrlSource = new HttpUrlSource(m3328d());
        boolean equals;
        try {
            byte[] bytes = "ping ok".getBytes();
            httpUrlSource.mo1101a(0);
            byte[] bArr = new byte[bytes.length];
            httpUrlSource.mo1099a(bArr);
            equals = Arrays.equals(bytes, bArr);
            Logger logger = f3756a;
            StringBuilder stringBuilder = new StringBuilder("Ping response: `");
            stringBuilder.append(new String(bArr));
            stringBuilder.append("`, pinged? ");
            stringBuilder.append(equals);
            logger.b(stringBuilder.toString());
            return equals;
        } catch (ProxyCacheException e) {
            equals = e;
            f3756a.a("Error reading ping response", equals);
            return false;
        } finally {
            httpUrlSource.mo1102b();
        }
    }

    private String m3328d() {
        return String.format(Locale.US, "http://%s:%d/%s", new Object[]{this.f3758c, Integer.valueOf(this.f3759d), "ping"});
    }
}
