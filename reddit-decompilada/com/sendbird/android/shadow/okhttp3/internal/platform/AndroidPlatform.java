package com.sendbird.android.shadow.okhttp3.internal.platform;

import android.os.Build.VERSION;
import android.util.Log;
import com.sendbird.android.shadow.okhttp3.Protocol;
import com.sendbird.android.shadow.okhttp3.internal.Util;
import com.sendbird.android.shadow.okhttp3.internal.tls.CertificateChainCleaner;
import com.sendbird.android.shadow.okhttp3.internal.tls.TrustRootIndex;
import com.sendbird.android.shadow.okio.Buffer;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

class AndroidPlatform extends Platform {
    private final Class<?> f30514a;
    private final OptionalMethod<Socket> f30515b;
    private final OptionalMethod<Socket> f30516d;
    private final OptionalMethod<Socket> f30517e;
    private final OptionalMethod<Socket> f30518f;
    private final CloseGuard f30519g = CloseGuard.m25538a();

    static final class CloseGuard {
        private final Method f23539a;
        private final Method f23540b;
        private final Method f23541c;

        private CloseGuard(Method method, Method method2, Method method3) {
            this.f23539a = method;
            this.f23540b = method2;
            this.f23541c = method3;
        }

        final java.lang.Object m25539a(java.lang.String r6) {
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
            r5 = this;
            r0 = r5.f23539a;
            r1 = 0;
            if (r0 == 0) goto L_0x0019;
        L_0x0005:
            r0 = r5.f23539a;	 Catch:{ Exception -> 0x0019 }
            r2 = 0;	 Catch:{ Exception -> 0x0019 }
            r3 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0019 }
            r0 = r0.invoke(r1, r3);	 Catch:{ Exception -> 0x0019 }
            r3 = r5.f23540b;	 Catch:{ Exception -> 0x0019 }
            r4 = 1;	 Catch:{ Exception -> 0x0019 }
            r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0019 }
            r4[r2] = r6;	 Catch:{ Exception -> 0x0019 }
            r3.invoke(r0, r4);	 Catch:{ Exception -> 0x0019 }
            return r0;
        L_0x0019:
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.platform.AndroidPlatform.CloseGuard.a(java.lang.String):java.lang.Object");
        }

        final boolean m25540a(java.lang.Object r4) {
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
            r0 = 0;
            if (r4 == 0) goto L_0x000b;
        L_0x0003:
            r1 = r3.f23541c;	 Catch:{ Exception -> 0x000b }
            r2 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x000b }
            r1.invoke(r4, r2);	 Catch:{ Exception -> 0x000b }
            r0 = 1;
        L_0x000b:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.platform.AndroidPlatform.CloseGuard.a(java.lang.Object):boolean");
        }

        static com.sendbird.android.shadow.okhttp3.internal.platform.AndroidPlatform.CloseGuard m25538a() {
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
            r0 = 0;
            r1 = "dalvik.system.CloseGuard";	 Catch:{ Exception -> 0x0028 }
            r1 = java.lang.Class.forName(r1);	 Catch:{ Exception -> 0x0028 }
            r2 = "get";	 Catch:{ Exception -> 0x0028 }
            r3 = 0;	 Catch:{ Exception -> 0x0028 }
            r4 = new java.lang.Class[r3];	 Catch:{ Exception -> 0x0028 }
            r2 = r1.getMethod(r2, r4);	 Catch:{ Exception -> 0x0028 }
            r4 = "open";	 Catch:{ Exception -> 0x0028 }
            r5 = 1;	 Catch:{ Exception -> 0x0028 }
            r5 = new java.lang.Class[r5];	 Catch:{ Exception -> 0x0028 }
            r6 = java.lang.String.class;	 Catch:{ Exception -> 0x0028 }
            r5[r3] = r6;	 Catch:{ Exception -> 0x0028 }
            r4 = r1.getMethod(r4, r5);	 Catch:{ Exception -> 0x0028 }
            r5 = "warnIfOpen";	 Catch:{ Exception -> 0x0028 }
            r3 = new java.lang.Class[r3];	 Catch:{ Exception -> 0x0028 }
            r1 = r1.getMethod(r5, r3);	 Catch:{ Exception -> 0x0028 }
            r0 = r2;
            goto L_0x002a;
        L_0x0028:
            r1 = r0;
            r4 = r1;
        L_0x002a:
            r2 = new com.sendbird.android.shadow.okhttp3.internal.platform.AndroidPlatform$CloseGuard;
            r2.<init>(r0, r4, r1);
            return r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.platform.AndroidPlatform.CloseGuard.a():com.sendbird.android.shadow.okhttp3.internal.platform.AndroidPlatform$CloseGuard");
        }
    }

    static final class AndroidCertificateChainCleaner extends CertificateChainCleaner {
        private final Object f30510a;
        private final Method f30511b;

        public final int hashCode() {
            return 0;
        }

        AndroidCertificateChainCleaner(Object obj, Method method) {
            this.f30510a = obj;
            this.f30511b = method;
        }

        public final List<Certificate> mo5365a(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                X509Certificate[] x509CertificateArr = (X509Certificate[]) list.toArray(new X509Certificate[list.size()]);
                return (List) this.f30511b.invoke(this.f30510a, new Object[]{x509CertificateArr, "RSA", str});
            } catch (List<Certificate> list2) {
                str = new SSLPeerUnverifiedException(list2.getMessage());
                str.initCause(list2);
                throw str;
            } catch (List<Certificate> list22) {
                throw new AssertionError(list22);
            }
        }

        public final boolean equals(Object obj) {
            return obj instanceof AndroidCertificateChainCleaner;
        }
    }

    static final class AndroidTrustRootIndex implements TrustRootIndex {
        private final X509TrustManager f30512a;
        private final Method f30513b;

        AndroidTrustRootIndex(X509TrustManager x509TrustManager, Method method) {
            this.f30513b = method;
            this.f30512a = x509TrustManager;
        }

        public final java.security.cert.X509Certificate mo5366a(java.security.cert.X509Certificate r6) {
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
            r5 = this;
            r0 = 0;
            r1 = r5.f30513b;	 Catch:{ IllegalAccessException -> 0x001a, InvocationTargetException -> 0x0019 }
            r2 = r5.f30512a;	 Catch:{ IllegalAccessException -> 0x001a, InvocationTargetException -> 0x0019 }
            r3 = 1;	 Catch:{ IllegalAccessException -> 0x001a, InvocationTargetException -> 0x0019 }
            r3 = new java.lang.Object[r3];	 Catch:{ IllegalAccessException -> 0x001a, InvocationTargetException -> 0x0019 }
            r4 = 0;	 Catch:{ IllegalAccessException -> 0x001a, InvocationTargetException -> 0x0019 }
            r3[r4] = r6;	 Catch:{ IllegalAccessException -> 0x001a, InvocationTargetException -> 0x0019 }
            r6 = r1.invoke(r2, r3);	 Catch:{ IllegalAccessException -> 0x001a, InvocationTargetException -> 0x0019 }
            r6 = (java.security.cert.TrustAnchor) r6;	 Catch:{ IllegalAccessException -> 0x001a, InvocationTargetException -> 0x0019 }
            if (r6 == 0) goto L_0x0018;	 Catch:{ IllegalAccessException -> 0x001a, InvocationTargetException -> 0x0019 }
        L_0x0013:
            r6 = r6.getTrustedCert();	 Catch:{ IllegalAccessException -> 0x001a, InvocationTargetException -> 0x0019 }
            return r6;
        L_0x0018:
            return r0;
        L_0x0019:
            return r0;
        L_0x001a:
            r6 = move-exception;
            r0 = "unable to get issues and signature";
            r6 = com.sendbird.android.shadow.okhttp3.internal.Util.m25357a(r0, r6);
            throw r6;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.platform.AndroidPlatform.AndroidTrustRootIndex.a(java.security.cert.X509Certificate):java.security.cert.X509Certificate");
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AndroidTrustRootIndex)) {
                return false;
            }
            AndroidTrustRootIndex androidTrustRootIndex = (AndroidTrustRootIndex) obj;
            return this.f30512a.equals(androidTrustRootIndex.f30512a) && this.f30513b.equals(androidTrustRootIndex.f30513b) != null;
        }

        public final int hashCode() {
            return this.f30512a.hashCode() + (31 * this.f30513b.hashCode());
        }
    }

    private AndroidPlatform(Class<?> cls, OptionalMethod<Socket> optionalMethod, OptionalMethod<Socket> optionalMethod2, OptionalMethod<Socket> optionalMethod3, OptionalMethod<Socket> optionalMethod4) {
        this.f30514a = cls;
        this.f30515b = optionalMethod;
        this.f30516d = optionalMethod2;
        this.f30517e = optionalMethod3;
        this.f30518f = optionalMethod4;
    }

    public final void mo5372a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (AssertionError e) {
            if (Util.m25370a(e) != null) {
                throw new IOException(e);
            }
            throw e;
        } catch (Socket socket2) {
            inetSocketAddress = new IOException("Exception in connect");
            inetSocketAddress.initCause(socket2);
            throw inetSocketAddress;
        } catch (Socket socket22) {
            if (VERSION.SDK_INT == 26) {
                inetSocketAddress = new IOException("Exception in connect");
                inetSocketAddress.initCause(socket22);
                throw inetSocketAddress;
            }
            throw socket22;
        }
    }

    public final void mo5373a(SSLSocket sSLSocket, String str, List<Protocol> list) {
        if (str != null) {
            this.f30515b.m25545a(sSLSocket, Boolean.valueOf(true));
            this.f30516d.m25545a(sSLSocket, str);
        }
        if (this.f30518f != null && this.f30518f.m25546a((Object) sSLSocket) != null) {
            str = new Object[1];
            Buffer buffer = new Buffer();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Protocol protocol = (Protocol) list.get(i);
                if (protocol != Protocol.HTTP_1_0) {
                    buffer.m35463b(protocol.toString().length());
                    buffer.m35455a(protocol.toString());
                }
            }
            str[0] = buffer.m35503q();
            this.f30518f.m25547b(sSLSocket, str);
        }
    }

    public final String mo5369a(SSLSocket sSLSocket) {
        if (this.f30517e == null || !this.f30517e.m25546a((Object) sSLSocket)) {
            return null;
        }
        byte[] bArr = (byte[]) this.f30517e.m25547b(sSLSocket, new Object[0]);
        if (bArr != null) {
            return new String(bArr, Util.f23338e);
        }
        return null;
    }

    public final void mo5370a(int i, String str, Throwable th) {
        int i2 = 5;
        if (i != 5) {
            i2 = 3;
        }
        if (th != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append('\n');
            stringBuilder.append(Log.getStackTraceString(th));
            str = stringBuilder.toString();
        }
        th = null;
        int length = str.length();
        while (th < length) {
            int min;
            int indexOf = str.indexOf(10, th);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, th + 4000);
                Log.println(i2, "OkHttp", str.substring(th, min));
                if (min >= indexOf) {
                    break;
                }
                th = min;
            }
            th = min + 1;
        }
    }

    public final Object mo5368a(String str) {
        return this.f30519g.m25539a(str);
    }

    public final void mo5371a(String str, Object obj) {
        if (this.f30519g.m25540a(obj) == null) {
            mo5370a(5, str, null);
        }
    }

    public final boolean mo5375b(java.lang.String r5) {
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
        r4 = this;
        r0 = "android.security.NetworkSecurityPolicy";	 Catch:{ ClassNotFoundException -> 0x0024, ClassNotFoundException -> 0x0024, IllegalAccessException -> 0x001b, IllegalAccessException -> 0x001b, IllegalAccessException -> 0x001b }
        r0 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0024, ClassNotFoundException -> 0x0024, IllegalAccessException -> 0x001b, IllegalAccessException -> 0x001b, IllegalAccessException -> 0x001b }
        r1 = "getInstance";	 Catch:{ ClassNotFoundException -> 0x0024, ClassNotFoundException -> 0x0024, IllegalAccessException -> 0x001b, IllegalAccessException -> 0x001b, IllegalAccessException -> 0x001b }
        r2 = 0;	 Catch:{ ClassNotFoundException -> 0x0024, ClassNotFoundException -> 0x0024, IllegalAccessException -> 0x001b, IllegalAccessException -> 0x001b, IllegalAccessException -> 0x001b }
        r3 = new java.lang.Class[r2];	 Catch:{ ClassNotFoundException -> 0x0024, ClassNotFoundException -> 0x0024, IllegalAccessException -> 0x001b, IllegalAccessException -> 0x001b, IllegalAccessException -> 0x001b }
        r1 = r0.getMethod(r1, r3);	 Catch:{ ClassNotFoundException -> 0x0024, ClassNotFoundException -> 0x0024, IllegalAccessException -> 0x001b, IllegalAccessException -> 0x001b, IllegalAccessException -> 0x001b }
        r3 = 0;	 Catch:{ ClassNotFoundException -> 0x0024, ClassNotFoundException -> 0x0024, IllegalAccessException -> 0x001b, IllegalAccessException -> 0x001b, IllegalAccessException -> 0x001b }
        r2 = new java.lang.Object[r2];	 Catch:{ ClassNotFoundException -> 0x0024, ClassNotFoundException -> 0x0024, IllegalAccessException -> 0x001b, IllegalAccessException -> 0x001b, IllegalAccessException -> 0x001b }
        r1 = r1.invoke(r3, r2);	 Catch:{ ClassNotFoundException -> 0x0024, ClassNotFoundException -> 0x0024, IllegalAccessException -> 0x001b, IllegalAccessException -> 0x001b, IllegalAccessException -> 0x001b }
        r0 = r4.m31451a(r5, r0, r1);	 Catch:{ ClassNotFoundException -> 0x0024, ClassNotFoundException -> 0x0024, IllegalAccessException -> 0x001b, IllegalAccessException -> 0x001b, IllegalAccessException -> 0x001b }
        return r0;
    L_0x001b:
        r5 = move-exception;
        r0 = "unable to determine cleartext support";
        r5 = com.sendbird.android.shadow.okhttp3.internal.Util.m25357a(r0, r5);
        throw r5;
    L_0x0024:
        r5 = super.mo5375b(r5);
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.platform.AndroidPlatform.b(java.lang.String):boolean");
    }

    private boolean m31451a(java.lang.String r6, java.lang.Class<?> r7, java.lang.Object r8) throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException {
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
        r5 = this;
        r0 = "isCleartextTrafficPermitted";	 Catch:{ NoSuchMethodException -> 0x001d }
        r1 = 1;	 Catch:{ NoSuchMethodException -> 0x001d }
        r2 = new java.lang.Class[r1];	 Catch:{ NoSuchMethodException -> 0x001d }
        r3 = java.lang.String.class;	 Catch:{ NoSuchMethodException -> 0x001d }
        r4 = 0;	 Catch:{ NoSuchMethodException -> 0x001d }
        r2[r4] = r3;	 Catch:{ NoSuchMethodException -> 0x001d }
        r0 = r7.getMethod(r0, r2);	 Catch:{ NoSuchMethodException -> 0x001d }
        r1 = new java.lang.Object[r1];	 Catch:{ NoSuchMethodException -> 0x001d }
        r1[r4] = r6;	 Catch:{ NoSuchMethodException -> 0x001d }
        r0 = r0.invoke(r8, r1);	 Catch:{ NoSuchMethodException -> 0x001d }
        r0 = (java.lang.Boolean) r0;	 Catch:{ NoSuchMethodException -> 0x001d }
        r0 = r0.booleanValue();	 Catch:{ NoSuchMethodException -> 0x001d }
        return r0;
    L_0x001d:
        r6 = r5.m31452b(r6, r7, r8);
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.platform.AndroidPlatform.a(java.lang.String, java.lang.Class, java.lang.Object):boolean");
    }

    private boolean m31452b(java.lang.String r4, java.lang.Class<?> r5, java.lang.Object r6) throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException {
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
        r0 = "isCleartextTrafficPermitted";	 Catch:{ NoSuchMethodException -> 0x0016 }
        r1 = 0;	 Catch:{ NoSuchMethodException -> 0x0016 }
        r2 = new java.lang.Class[r1];	 Catch:{ NoSuchMethodException -> 0x0016 }
        r5 = r5.getMethod(r0, r2);	 Catch:{ NoSuchMethodException -> 0x0016 }
        r0 = new java.lang.Object[r1];	 Catch:{ NoSuchMethodException -> 0x0016 }
        r5 = r5.invoke(r6, r0);	 Catch:{ NoSuchMethodException -> 0x0016 }
        r5 = (java.lang.Boolean) r5;	 Catch:{ NoSuchMethodException -> 0x0016 }
        r5 = r5.booleanValue();	 Catch:{ NoSuchMethodException -> 0x0016 }
        return r5;
    L_0x0016:
        r4 = super.mo5375b(r4);
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.platform.AndroidPlatform.b(java.lang.String, java.lang.Class, java.lang.Object):boolean");
    }

    private static boolean m31453d() {
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
        r0 = "GMSCore_OpenSSL";
        r0 = java.security.Security.getProvider(r0);
        r1 = 1;
        if (r0 == 0) goto L_0x000a;
    L_0x0009:
        return r1;
    L_0x000a:
        r0 = "android.net.Network";	 Catch:{ ClassNotFoundException -> 0x0010 }
        java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0010 }
        return r1;
    L_0x0010:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.platform.AndroidPlatform.d():boolean");
    }

    public final com.sendbird.android.shadow.okhttp3.internal.tls.CertificateChainCleaner mo5367a(javax.net.ssl.X509TrustManager r8) {
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
        r7 = this;
        r0 = "android.net.http.X509TrustManagerExtensions";	 Catch:{ Exception -> 0x0036 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Exception -> 0x0036 }
        r1 = 1;	 Catch:{ Exception -> 0x0036 }
        r2 = new java.lang.Class[r1];	 Catch:{ Exception -> 0x0036 }
        r3 = javax.net.ssl.X509TrustManager.class;	 Catch:{ Exception -> 0x0036 }
        r4 = 0;	 Catch:{ Exception -> 0x0036 }
        r2[r4] = r3;	 Catch:{ Exception -> 0x0036 }
        r2 = r0.getConstructor(r2);	 Catch:{ Exception -> 0x0036 }
        r3 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x0036 }
        r3[r4] = r8;	 Catch:{ Exception -> 0x0036 }
        r2 = r2.newInstance(r3);	 Catch:{ Exception -> 0x0036 }
        r3 = "checkServerTrusted";	 Catch:{ Exception -> 0x0036 }
        r5 = 3;	 Catch:{ Exception -> 0x0036 }
        r5 = new java.lang.Class[r5];	 Catch:{ Exception -> 0x0036 }
        r6 = java.security.cert.X509Certificate[].class;	 Catch:{ Exception -> 0x0036 }
        r5[r4] = r6;	 Catch:{ Exception -> 0x0036 }
        r4 = java.lang.String.class;	 Catch:{ Exception -> 0x0036 }
        r5[r1] = r4;	 Catch:{ Exception -> 0x0036 }
        r1 = 2;	 Catch:{ Exception -> 0x0036 }
        r4 = java.lang.String.class;	 Catch:{ Exception -> 0x0036 }
        r5[r1] = r4;	 Catch:{ Exception -> 0x0036 }
        r0 = r0.getMethod(r3, r5);	 Catch:{ Exception -> 0x0036 }
        r1 = new com.sendbird.android.shadow.okhttp3.internal.platform.AndroidPlatform$AndroidCertificateChainCleaner;	 Catch:{ Exception -> 0x0036 }
        r1.<init>(r2, r0);	 Catch:{ Exception -> 0x0036 }
        return r1;
    L_0x0036:
        r8 = super.mo5367a(r8);
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.platform.AndroidPlatform.a(javax.net.ssl.X509TrustManager):com.sendbird.android.shadow.okhttp3.internal.tls.CertificateChainCleaner");
    }

    public static com.sendbird.android.shadow.okhttp3.internal.platform.Platform m31450a() {
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
        r0 = 0;
        r1 = "com.android.org.conscrypt.SSLParametersImpl";	 Catch:{ ClassNotFoundException -> 0x0009 }
        r1 = java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x0009 }
    L_0x0007:
        r3 = r1;
        goto L_0x0010;
    L_0x0009:
        r1 = "org.apache.harmony.xnet.provider.jsse.SSLParametersImpl";	 Catch:{ ClassNotFoundException -> 0x0056 }
        r1 = java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x0056 }
        goto L_0x0007;	 Catch:{ ClassNotFoundException -> 0x0056 }
    L_0x0010:
        r4 = new com.sendbird.android.shadow.okhttp3.internal.platform.OptionalMethod;	 Catch:{ ClassNotFoundException -> 0x0056 }
        r1 = "setUseSessionTickets";	 Catch:{ ClassNotFoundException -> 0x0056 }
        r2 = 1;	 Catch:{ ClassNotFoundException -> 0x0056 }
        r5 = new java.lang.Class[r2];	 Catch:{ ClassNotFoundException -> 0x0056 }
        r6 = java.lang.Boolean.TYPE;	 Catch:{ ClassNotFoundException -> 0x0056 }
        r7 = 0;	 Catch:{ ClassNotFoundException -> 0x0056 }
        r5[r7] = r6;	 Catch:{ ClassNotFoundException -> 0x0056 }
        r4.<init>(r0, r1, r5);	 Catch:{ ClassNotFoundException -> 0x0056 }
        r5 = new com.sendbird.android.shadow.okhttp3.internal.platform.OptionalMethod;	 Catch:{ ClassNotFoundException -> 0x0056 }
        r1 = "setHostname";	 Catch:{ ClassNotFoundException -> 0x0056 }
        r6 = new java.lang.Class[r2];	 Catch:{ ClassNotFoundException -> 0x0056 }
        r8 = java.lang.String.class;	 Catch:{ ClassNotFoundException -> 0x0056 }
        r6[r7] = r8;	 Catch:{ ClassNotFoundException -> 0x0056 }
        r5.<init>(r0, r1, r6);	 Catch:{ ClassNotFoundException -> 0x0056 }
        r1 = m31453d();	 Catch:{ ClassNotFoundException -> 0x0056 }
        if (r1 == 0) goto L_0x004d;	 Catch:{ ClassNotFoundException -> 0x0056 }
    L_0x0032:
        r1 = new com.sendbird.android.shadow.okhttp3.internal.platform.OptionalMethod;	 Catch:{ ClassNotFoundException -> 0x0056 }
        r6 = byte[].class;	 Catch:{ ClassNotFoundException -> 0x0056 }
        r8 = "getAlpnSelectedProtocol";	 Catch:{ ClassNotFoundException -> 0x0056 }
        r9 = new java.lang.Class[r7];	 Catch:{ ClassNotFoundException -> 0x0056 }
        r1.<init>(r6, r8, r9);	 Catch:{ ClassNotFoundException -> 0x0056 }
        r6 = new com.sendbird.android.shadow.okhttp3.internal.platform.OptionalMethod;	 Catch:{ ClassNotFoundException -> 0x0056 }
        r8 = "setAlpnProtocols";	 Catch:{ ClassNotFoundException -> 0x0056 }
        r2 = new java.lang.Class[r2];	 Catch:{ ClassNotFoundException -> 0x0056 }
        r9 = byte[].class;	 Catch:{ ClassNotFoundException -> 0x0056 }
        r2[r7] = r9;	 Catch:{ ClassNotFoundException -> 0x0056 }
        r6.<init>(r0, r8, r2);	 Catch:{ ClassNotFoundException -> 0x0056 }
        r7 = r6;	 Catch:{ ClassNotFoundException -> 0x0056 }
        r6 = r1;	 Catch:{ ClassNotFoundException -> 0x0056 }
        goto L_0x004f;	 Catch:{ ClassNotFoundException -> 0x0056 }
    L_0x004d:
        r6 = r0;	 Catch:{ ClassNotFoundException -> 0x0056 }
        r7 = r6;	 Catch:{ ClassNotFoundException -> 0x0056 }
    L_0x004f:
        r1 = new com.sendbird.android.shadow.okhttp3.internal.platform.AndroidPlatform;	 Catch:{ ClassNotFoundException -> 0x0056 }
        r2 = r1;	 Catch:{ ClassNotFoundException -> 0x0056 }
        r2.<init>(r3, r4, r5, r6, r7);	 Catch:{ ClassNotFoundException -> 0x0056 }
        return r1;
    L_0x0056:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.platform.AndroidPlatform.a():com.sendbird.android.shadow.okhttp3.internal.platform.Platform");
    }

    public final com.sendbird.android.shadow.okhttp3.internal.tls.TrustRootIndex mo5374b(javax.net.ssl.X509TrustManager r7) {
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
        r0 = r7.getClass();	 Catch:{ NoSuchMethodException -> 0x001b }
        r1 = "findTrustAnchorByIssuerAndSignature";	 Catch:{ NoSuchMethodException -> 0x001b }
        r2 = 1;	 Catch:{ NoSuchMethodException -> 0x001b }
        r3 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x001b }
        r4 = 0;	 Catch:{ NoSuchMethodException -> 0x001b }
        r5 = java.security.cert.X509Certificate.class;	 Catch:{ NoSuchMethodException -> 0x001b }
        r3[r4] = r5;	 Catch:{ NoSuchMethodException -> 0x001b }
        r0 = r0.getDeclaredMethod(r1, r3);	 Catch:{ NoSuchMethodException -> 0x001b }
        r0.setAccessible(r2);	 Catch:{ NoSuchMethodException -> 0x001b }
        r1 = new com.sendbird.android.shadow.okhttp3.internal.platform.AndroidPlatform$AndroidTrustRootIndex;	 Catch:{ NoSuchMethodException -> 0x001b }
        r1.<init>(r7, r0);	 Catch:{ NoSuchMethodException -> 0x001b }
        return r1;
    L_0x001b:
        r7 = super.mo5374b(r7);
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.platform.AndroidPlatform.b(javax.net.ssl.X509TrustManager):com.sendbird.android.shadow.okhttp3.internal.tls.TrustRootIndex");
    }
}
