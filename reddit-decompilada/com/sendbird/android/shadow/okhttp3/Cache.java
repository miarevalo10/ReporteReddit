package com.sendbird.android.shadow.okhttp3;

import com.sendbird.android.shadow.okhttp3.Headers.Builder;
import com.sendbird.android.shadow.okhttp3.internal.cache.CacheRequest;
import com.sendbird.android.shadow.okhttp3.internal.cache.CacheStrategy;
import com.sendbird.android.shadow.okhttp3.internal.cache.DiskLruCache;
import com.sendbird.android.shadow.okhttp3.internal.cache.DiskLruCache.Editor;
import com.sendbird.android.shadow.okhttp3.internal.cache.DiskLruCache.Snapshot;
import com.sendbird.android.shadow.okhttp3.internal.cache.InternalCache;
import com.sendbird.android.shadow.okhttp3.internal.http.HttpHeaders;
import com.sendbird.android.shadow.okhttp3.internal.http.StatusLine;
import com.sendbird.android.shadow.okhttp3.internal.io.FileSystem;
import com.sendbird.android.shadow.okhttp3.internal.platform.Platform;
import com.sendbird.android.shadow.okio.Buffer;
import com.sendbird.android.shadow.okio.Buffer.C20452;
import com.sendbird.android.shadow.okio.BufferedSink;
import com.sendbird.android.shadow.okio.BufferedSource;
import com.sendbird.android.shadow.okio.ByteString;
import com.sendbird.android.shadow.okio.ForwardingSink;
import com.sendbird.android.shadow.okio.ForwardingSource;
import com.sendbird.android.shadow.okio.Okio;
import com.sendbird.android.shadow.okio.Sink;
import com.sendbird.android.shadow.okio.Source;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public final class Cache implements Closeable, Flushable {
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 201105;
    final DiskLruCache cache;
    private int hitCount;
    final InternalCache internalCache;
    private int networkCount;
    private int requestCount;
    int writeAbortCount;
    int writeSuccessCount;

    class C20352 implements Iterator<String> {
        final Iterator<Snapshot> f23049a = this.f23052d.cache.snapshots();
        String f23050b;
        boolean f23051c;
        final /* synthetic */ Cache f23052d;

        C20352(Cache cache) throws IOException {
            this.f23052d = cache;
        }

        public boolean hasNext() {
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
            r4 = this;
            r0 = r4.f23050b;
            r1 = 1;
            if (r0 == 0) goto L_0x0006;
        L_0x0005:
            return r1;
        L_0x0006:
            r0 = 0;
            r4.f23051c = r0;
        L_0x0009:
            r2 = r4.f23049a;
            r2 = r2.hasNext();
            if (r2 == 0) goto L_0x0034;
        L_0x0011:
            r2 = r4.f23049a;
            r2 = r2.next();
            r2 = (com.sendbird.android.shadow.okhttp3.internal.cache.DiskLruCache.Snapshot) r2;
            r3 = r2.f23385c;	 Catch:{ IOException -> 0x0030, all -> 0x002b }
            r3 = r3[r0];	 Catch:{ IOException -> 0x0030, all -> 0x002b }
            r3 = com.sendbird.android.shadow.okio.Okio.m25615a(r3);	 Catch:{ IOException -> 0x0030, all -> 0x002b }
            r3 = r3.mo6579p();	 Catch:{ IOException -> 0x0030, all -> 0x002b }
            r4.f23050b = r3;	 Catch:{ IOException -> 0x0030, all -> 0x002b }
            r2.close();
            return r1;
        L_0x002b:
            r0 = move-exception;
            r2.close();
            throw r0;
        L_0x0030:
            r2.close();
            goto L_0x0009;
        L_0x0034:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.Cache.2.hasNext():boolean");
        }

        public void remove() {
            if (this.f23051c) {
                this.f23049a.remove();
                return;
            }
            throw new IllegalStateException("remove() before next()");
        }

        public /* synthetic */ Object next() {
            if (hasNext()) {
                String str = this.f23050b;
                this.f23050b = null;
                this.f23051c = true;
                return str;
            }
            throw new NoSuchElementException();
        }
    }

    private static final class Entry {
        private static final String f23053k;
        private static final String f23054l;
        final String f23055a;
        final Headers f23056b;
        final String f23057c;
        final Protocol f23058d;
        final int f23059e;
        final String f23060f;
        final Headers f23061g;
        final Handshake f23062h;
        final long f23063i;
        final long f23064j;

        static {
            StringBuilder stringBuilder = new StringBuilder();
            Platform.m25549b();
            stringBuilder.append(Platform.m25550c());
            stringBuilder.append("-Sent-Millis");
            f23053k = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            Platform.m25549b();
            stringBuilder.append(Platform.m25550c());
            stringBuilder.append("-Received-Millis");
            f23054l = stringBuilder.toString();
        }

        Entry(Source source) throws IOException {
            try {
                BufferedSource a = Okio.m25615a(source);
                this.f23055a = a.mo6579p();
                this.f23057c = a.mo6579p();
                Builder builder = new Builder();
                int readInt = Cache.readInt(a);
                int i = 0;
                for (int i2 = 0; i2 < readInt; i2++) {
                    builder.m25260a(a.mo6579p());
                }
                this.f23056b = builder.m25262a();
                StatusLine a2 = StatusLine.m25443a(a.mo6579p());
                this.f23058d = a2.f23425a;
                this.f23059e = a2.f23426b;
                this.f23060f = a2.f23427c;
                builder = new Builder();
                readInt = Cache.readInt(a);
                while (i < readInt) {
                    builder.m25260a(a.mo6579p());
                    i++;
                }
                String c = builder.m25265c(f23053k);
                String c2 = builder.m25265c(f23054l);
                builder.m25263b(f23053k);
                builder.m25263b(f23054l);
                long j = 0;
                this.f23063i = c != null ? Long.parseLong(c) : 0;
                if (c2 != null) {
                    j = Long.parseLong(c2);
                }
                this.f23064j = j;
                this.f23061g = builder.m25262a();
                if (m25197a()) {
                    String p = a.mo6579p();
                    if (p.length() > 0) {
                        StringBuilder stringBuilder = new StringBuilder("expected \"\" but was \"");
                        stringBuilder.append(p);
                        stringBuilder.append("\"");
                        throw new IOException(stringBuilder.toString());
                    }
                    TlsVersion tlsVersion;
                    CipherSuite a3 = CipherSuite.m25210a(a.mo6579p());
                    List a4 = m25195a(a);
                    List a5 = m25195a(a);
                    if (a.mo6562d()) {
                        tlsVersion = TlsVersion.SSL_3_0;
                    } else {
                        tlsVersion = TlsVersion.m25341a(a.mo6579p());
                    }
                    this.f23062h = Handshake.m25257a(tlsVersion, a3, a4, a5);
                } else {
                    this.f23062h = null;
                }
                source.close();
            } catch (Throwable th) {
                source.close();
            }
        }

        Entry(Response response) {
            this.f23055a = response.f23308a.url().toString();
            this.f23056b = HttpHeaders.m25434c(response);
            this.f23057c = response.f23308a.method();
            this.f23058d = response.f23309b;
            this.f23059e = response.f23310c;
            this.f23060f = response.f23311d;
            this.f23061g = response.f23313f;
            this.f23062h = response.f23312e;
            this.f23063i = response.f23318k;
            this.f23064j = response.f23319l;
        }

        public final void m25198a(Editor editor) throws IOException {
            int i = 0;
            editor = Okio.m25614a(editor.m25384a(0));
            editor.mo6553b(this.f23055a).mo6570h(10);
            editor.mo6553b(this.f23057c).mo6570h(10);
            editor.mo6576l((long) (this.f23056b.f23197a.length / 2)).mo6570h(10);
            int length = this.f23056b.f23197a.length / 2;
            for (int i2 = 0; i2 < length; i2++) {
                editor.mo6553b(this.f23056b.m25268a(i2)).mo6553b(": ").mo6553b(this.f23056b.m25270b(i2)).mo6570h(10);
            }
            editor.mo6553b(new StatusLine(this.f23058d, this.f23059e, this.f23060f).toString()).mo6570h(10);
            editor.mo6576l((long) ((this.f23061g.f23197a.length / 2) + 2)).mo6570h(10);
            length = this.f23061g.f23197a.length / 2;
            while (i < length) {
                editor.mo6553b(this.f23061g.m25268a(i)).mo6553b(": ").mo6553b(this.f23061g.m25270b(i)).mo6570h(10);
                i++;
            }
            editor.mo6553b(f23053k).mo6553b(": ").mo6576l(this.f23063i).mo6570h(10);
            editor.mo6553b(f23054l).mo6553b(": ").mo6576l(this.f23064j).mo6570h(10);
            if (m25197a()) {
                editor.mo6570h(10);
                editor.mo6553b(this.f23062h.f23193b.bj).mo6570h(10);
                m25196a(editor, this.f23062h.f23194c);
                m25196a(editor, this.f23062h.f23195d);
                editor.mo6553b(this.f23062h.f23192a.f23330f).mo6570h(10);
            }
            editor.close();
        }

        private boolean m25197a() {
            return this.f23055a.startsWith("https://");
        }

        private static List<Certificate> m25195a(BufferedSource bufferedSource) throws IOException {
            int readInt = Cache.readInt(bufferedSource);
            if (readInt == -1) {
                return Collections.emptyList();
            }
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                List<Certificate> arrayList = new ArrayList(readInt);
                for (int i = 0; i < readInt; i++) {
                    String p = bufferedSource.mo6579p();
                    Buffer buffer = new Buffer();
                    buffer.m35454a(ByteString.m25597b(p));
                    arrayList.add(instance.generateCertificate(new C20452(buffer)));
                }
                return arrayList;
            } catch (BufferedSource bufferedSource2) {
                throw new IOException(bufferedSource2.getMessage());
            }
        }

        private static void m25196a(BufferedSink bufferedSink, List<Certificate> list) throws IOException {
            try {
                bufferedSink.mo6576l((long) list.size()).mo6570h(10);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    bufferedSink.mo6553b(ByteString.m25596a(((Certificate) list.get(i)).getEncoded()).mo5398b()).mo6570h(10);
                }
            } catch (BufferedSink bufferedSink2) {
                throw new IOException(bufferedSink2.getMessage());
            }
        }
    }

    class C24621 implements InternalCache {
        final /* synthetic */ Cache f30354a;

        C24621(Cache cache) {
            this.f30354a = cache;
        }

        public Response get(Request request) throws IOException {
            return this.f30354a.get(request);
        }

        public CacheRequest put(Response response) throws IOException {
            return this.f30354a.put(response);
        }

        public void remove(Request request) throws IOException {
            this.f30354a.remove(request);
        }

        public void update(Response response, Response response2) {
            this.f30354a.update(response, response2);
        }

        public void trackConditionalCacheHit() {
            this.f30354a.trackConditionalCacheHit();
        }

        public void trackResponse(CacheStrategy cacheStrategy) {
            this.f30354a.trackResponse(cacheStrategy);
        }
    }

    private final class CacheRequestImpl implements CacheRequest {
        boolean f30355a;
        final /* synthetic */ Cache f30356b;
        private final Editor f30357c;
        private Sink f30358d;
        private Sink f30359e;

        CacheRequestImpl(final Cache cache, final Editor editor) {
            this.f30356b = cache;
            this.f30357c = editor;
            this.f30358d = editor.m25384a(1);
            this.f30359e = new ForwardingSink(this, this.f30358d) {
                final /* synthetic */ CacheRequestImpl f34606c;

                public void close() throws IOException {
                    synchronized (this.f34606c.f30356b) {
                        if (this.f34606c.f30355a) {
                            return;
                        }
                        this.f34606c.f30355a = true;
                        Cache cache = this.f34606c.f30356b;
                        cache.writeSuccessCount++;
                        super.close();
                        editor.m25386b();
                    }
                }
            };
        }

        public final void abort() {
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
            r4 = this;
            r0 = r4.f30356b;
            monitor-enter(r0);
            r1 = r4.f30355a;	 Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x0009;	 Catch:{ all -> 0x0020 }
        L_0x0007:
            monitor-exit(r0);	 Catch:{ all -> 0x0020 }
            return;	 Catch:{ all -> 0x0020 }
        L_0x0009:
            r1 = 1;	 Catch:{ all -> 0x0020 }
            r4.f30355a = r1;	 Catch:{ all -> 0x0020 }
            r2 = r4.f30356b;	 Catch:{ all -> 0x0020 }
            r3 = r2.writeAbortCount;	 Catch:{ all -> 0x0020 }
            r3 = r3 + r1;	 Catch:{ all -> 0x0020 }
            r2.writeAbortCount = r3;	 Catch:{ all -> 0x0020 }
            monitor-exit(r0);	 Catch:{ all -> 0x0020 }
            r0 = r4.f30358d;
            com.sendbird.android.shadow.okhttp3.internal.Util.m25366a(r0);
            r0 = r4.f30357c;	 Catch:{ IOException -> 0x001f }
            r0.m25387c();	 Catch:{ IOException -> 0x001f }
            return;
        L_0x001f:
            return;
        L_0x0020:
            r1 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x0020 }
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.Cache.CacheRequestImpl.abort():void");
        }

        public final Sink body() {
            return this.f30359e;
        }
    }

    private static class CacheResponseBody extends ResponseBody {
        final Snapshot f30360a;
        private final BufferedSource f30361b;
        private final String f30362c;
        private final String f30363d;

        CacheResponseBody(final Snapshot snapshot, String str, String str2) {
            this.f30360a = snapshot;
            this.f30362c = str;
            this.f30363d = str2;
            this.f30361b = Okio.m25615a(new ForwardingSource(this, snapshot.f23385c[1]) {
                final /* synthetic */ CacheResponseBody f34608b;

                public void close() throws IOException {
                    snapshot.close();
                    super.close();
                }
            });
        }

        public final MediaType mo5296a() {
            return this.f30362c != null ? MediaType.m25307a(this.f30362c) : null;
        }

        public final long mo5297b() {
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
            r4 = this;
            r0 = -1;
            r2 = r4.f30363d;	 Catch:{ NumberFormatException -> 0x000e }
            if (r2 == 0) goto L_0x000d;	 Catch:{ NumberFormatException -> 0x000e }
        L_0x0006:
            r2 = r4.f30363d;	 Catch:{ NumberFormatException -> 0x000e }
            r2 = java.lang.Long.parseLong(r2);	 Catch:{ NumberFormatException -> 0x000e }
            return r2;
        L_0x000d:
            return r0;
        L_0x000e:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.Cache.CacheResponseBody.b():long");
        }

        public final BufferedSource mo5298c() {
            return this.f30361b;
        }
    }

    public Cache(File file, long j) {
        this(file, j, FileSystem.f23538a);
    }

    Cache(File file, long j, FileSystem fileSystem) {
        this.internalCache = new C24621(this);
        this.cache = DiskLruCache.create(fileSystem, file, VERSION, 2, j);
    }

    public static String key(HttpUrl httpUrl) {
        return ByteString.m25595a(httpUrl.toString()).mo5399c().mo5403f();
    }

    final com.sendbird.android.shadow.okhttp3.Response get(com.sendbird.android.shadow.okhttp3.Request r10) {
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
        r9 = this;
        r0 = r10.url();
        r0 = key(r0);
        r1 = 0;
        r2 = r9.cache;	 Catch:{ IOException -> 0x00a9 }
        r0 = r2.get(r0);	 Catch:{ IOException -> 0x00a9 }
        if (r0 != 0) goto L_0x0012;
    L_0x0011:
        return r1;
    L_0x0012:
        r2 = new com.sendbird.android.shadow.okhttp3.Cache$Entry;	 Catch:{ IOException -> 0x00a5 }
        r3 = r0.f23385c;	 Catch:{ IOException -> 0x00a5 }
        r4 = 0;	 Catch:{ IOException -> 0x00a5 }
        r3 = r3[r4];	 Catch:{ IOException -> 0x00a5 }
        r2.<init>(r3);	 Catch:{ IOException -> 0x00a5 }
        r3 = r2.f23061g;
        r5 = "Content-Type";
        r3 = r3.m25269a(r5);
        r5 = r2.f23061g;
        r6 = "Content-Length";
        r5 = r5.m25269a(r6);
        r6 = new com.sendbird.android.shadow.okhttp3.Request$Builder;
        r6.<init>();
        r7 = r2.f23055a;
        r6 = r6.m25315a(r7);
        r7 = r2.f23057c;
        r6 = r6.m25316a(r7, r1);
        r7 = r2.f23056b;
        r6 = r6.m25313a(r7);
        r6 = r6.m25318a();
        r7 = new com.sendbird.android.shadow.okhttp3.Response$Builder;
        r7.<init>();
        r7.f23296a = r6;
        r6 = r2.f23058d;
        r7.f23297b = r6;
        r6 = r2.f23059e;
        r7.f23298c = r6;
        r6 = r2.f23060f;
        r7.f23299d = r6;
        r6 = r2.f23061g;
        r6 = r7.m25327a(r6);
        r7 = new com.sendbird.android.shadow.okhttp3.Cache$CacheResponseBody;
        r7.<init>(r0, r3, r5);
        r6.f23302g = r7;
        r0 = r2.f23062h;
        r6.f23300e = r0;
        r7 = r2.f23063i;
        r6.f23306k = r7;
        r7 = r2.f23064j;
        r6.f23307l = r7;
        r0 = r6.m25330a();
        r3 = r2.f23055a;
        r5 = r10.url();
        r5 = r5.toString();
        r3 = r3.equals(r5);
        if (r3 == 0) goto L_0x009c;
    L_0x0087:
        r3 = r2.f23057c;
        r5 = r10.method();
        r3 = r3.equals(r5);
        if (r3 == 0) goto L_0x009c;
    L_0x0093:
        r2 = r2.f23056b;
        r10 = com.sendbird.android.shadow.okhttp3.internal.http.HttpHeaders.m25431a(r0, r2, r10);
        if (r10 == 0) goto L_0x009c;
    L_0x009b:
        r4 = 1;
    L_0x009c:
        if (r4 != 0) goto L_0x00a4;
    L_0x009e:
        r10 = r0.f23314g;
        com.sendbird.android.shadow.okhttp3.internal.Util.m25366a(r10);
        return r1;
    L_0x00a4:
        return r0;
    L_0x00a5:
        com.sendbird.android.shadow.okhttp3.internal.Util.m25366a(r0);
        return r1;
    L_0x00a9:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.Cache.get(com.sendbird.android.shadow.okhttp3.Request):com.sendbird.android.shadow.okhttp3.Response");
    }

    final void remove(Request request) throws IOException {
        this.cache.remove(key(request.url()));
    }

    final void update(com.sendbird.android.shadow.okhttp3.Response r5, com.sendbird.android.shadow.okhttp3.Response r6) {
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
        r4 = this;
        r0 = new com.sendbird.android.shadow.okhttp3.Cache$Entry;
        r0.<init>(r6);
        r5 = r5.f23314g;
        r5 = (com.sendbird.android.shadow.okhttp3.Cache.CacheResponseBody) r5;
        r5 = r5.f30360a;
        r6 = r5.f23386d;	 Catch:{ IOException -> 0x001e }
        r1 = r5.f23383a;	 Catch:{ IOException -> 0x001e }
        r2 = r5.f23384b;	 Catch:{ IOException -> 0x001e }
        r5 = r6.edit(r1, r2);	 Catch:{ IOException -> 0x001e }
        if (r5 == 0) goto L_0x001d;
    L_0x0017:
        r0.m25198a(r5);	 Catch:{ IOException -> 0x001f }
        r5.m25386b();	 Catch:{ IOException -> 0x001f }
    L_0x001d:
        return;
    L_0x001e:
        r5 = 0;
    L_0x001f:
        r4.abortQuietly(r5);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.Cache.update(com.sendbird.android.shadow.okhttp3.Response, com.sendbird.android.shadow.okhttp3.Response):void");
    }

    private void abortQuietly(com.sendbird.android.shadow.okhttp3.internal.cache.DiskLruCache.Editor r1) {
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
        r0 = this;
        if (r1 == 0) goto L_0x0007;
    L_0x0002:
        r1.m25387c();	 Catch:{ IOException -> 0x0006 }
        goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.Cache.abortQuietly(com.sendbird.android.shadow.okhttp3.internal.cache.DiskLruCache$Editor):void");
    }

    public final void initialize() throws IOException {
        this.cache.initialize();
    }

    public final void delete() throws IOException {
        this.cache.delete();
    }

    public final void evictAll() throws IOException {
        this.cache.evictAll();
    }

    public final Iterator<String> urls() throws IOException {
        return new C20352(this);
    }

    public final synchronized int writeAbortCount() {
        return this.writeAbortCount;
    }

    public final synchronized int writeSuccessCount() {
        return this.writeSuccessCount;
    }

    public final long size() throws IOException {
        return this.cache.size();
    }

    public final long maxSize() {
        return this.cache.getMaxSize();
    }

    public final void flush() throws IOException {
        this.cache.flush();
    }

    public final void close() throws IOException {
        this.cache.close();
    }

    public final File directory() {
        return this.cache.getDirectory();
    }

    public final boolean isClosed() {
        return this.cache.isClosed();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final synchronized void trackResponse(com.sendbird.android.shadow.okhttp3.internal.cache.CacheStrategy r2) {
        /*
        r1 = this;
        monitor-enter(r1);
        r0 = r1.requestCount;	 Catch:{ all -> 0x001f }
        r0 = r0 + 1;
        r1.requestCount = r0;	 Catch:{ all -> 0x001f }
        r0 = r2.f23364a;	 Catch:{ all -> 0x001f }
        if (r0 == 0) goto L_0x0013;
    L_0x000b:
        r2 = r1.networkCount;	 Catch:{ all -> 0x001f }
        r2 = r2 + 1;
        r1.networkCount = r2;	 Catch:{ all -> 0x001f }
        monitor-exit(r1);
        return;
    L_0x0013:
        r2 = r2.f23365b;	 Catch:{ all -> 0x001f }
        if (r2 == 0) goto L_0x001d;
    L_0x0017:
        r2 = r1.hitCount;	 Catch:{ all -> 0x001f }
        r2 = r2 + 1;
        r1.hitCount = r2;	 Catch:{ all -> 0x001f }
    L_0x001d:
        monitor-exit(r1);
        return;
    L_0x001f:
        r2 = move-exception;
        monitor-exit(r1);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.Cache.trackResponse(com.sendbird.android.shadow.okhttp3.internal.cache.CacheStrategy):void");
    }

    final synchronized void trackConditionalCacheHit() {
        this.hitCount++;
    }

    public final synchronized int networkCount() {
        return this.networkCount;
    }

    public final synchronized int hitCount() {
        return this.hitCount;
    }

    public final synchronized int requestCount() {
        return this.requestCount;
    }

    static int readInt(BufferedSource bufferedSource) throws IOException {
        try {
            long l = bufferedSource.mo6575l();
            bufferedSource = bufferedSource.mo6579p();
            if (l >= 0 && l <= 2147483647L) {
                if (bufferedSource.isEmpty()) {
                    return (int) l;
                }
            }
            StringBuilder stringBuilder = new StringBuilder("expected an int but was \"");
            stringBuilder.append(l);
            stringBuilder.append(bufferedSource);
            stringBuilder.append("\"");
            throw new IOException(stringBuilder.toString());
        } catch (BufferedSource bufferedSource2) {
            throw new IOException(bufferedSource2.getMessage());
        }
    }

    final com.sendbird.android.shadow.okhttp3.internal.cache.CacheRequest put(com.sendbird.android.shadow.okhttp3.Response r4) {
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
        r3 = this;
        r0 = r4.f23308a;
        r0 = r0.method();
        r1 = r4.f23308a;
        r1 = r1.method();
        r1 = com.sendbird.android.shadow.okhttp3.internal.http.HttpMethod.m25436a(r1);
        r2 = 0;
        if (r1 == 0) goto L_0x0019;
    L_0x0013:
        r4 = r4.f23308a;	 Catch:{ IOException -> 0x0018 }
        r3.remove(r4);	 Catch:{ IOException -> 0x0018 }
    L_0x0018:
        return r2;
    L_0x0019:
        r1 = "GET";
        r0 = r0.equals(r1);
        if (r0 != 0) goto L_0x0022;
    L_0x0021:
        return r2;
    L_0x0022:
        r0 = com.sendbird.android.shadow.okhttp3.internal.http.HttpHeaders.m25433b(r4);
        if (r0 == 0) goto L_0x0029;
    L_0x0028:
        return r2;
    L_0x0029:
        r0 = new com.sendbird.android.shadow.okhttp3.Cache$Entry;
        r0.<init>(r4);
        r1 = r3.cache;	 Catch:{ IOException -> 0x004a }
        r4 = r4.f23308a;	 Catch:{ IOException -> 0x004a }
        r4 = r4.url();	 Catch:{ IOException -> 0x004a }
        r4 = key(r4);	 Catch:{ IOException -> 0x004a }
        r4 = r1.edit(r4);	 Catch:{ IOException -> 0x004a }
        if (r4 != 0) goto L_0x0041;
    L_0x0040:
        return r2;
    L_0x0041:
        r0.m25198a(r4);	 Catch:{ IOException -> 0x004b }
        r0 = new com.sendbird.android.shadow.okhttp3.Cache$CacheRequestImpl;	 Catch:{ IOException -> 0x004b }
        r0.<init>(r3, r4);	 Catch:{ IOException -> 0x004b }
        return r0;
    L_0x004a:
        r4 = r2;
    L_0x004b:
        r3.abortQuietly(r4);
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.Cache.put(com.sendbird.android.shadow.okhttp3.Response):com.sendbird.android.shadow.okhttp3.internal.cache.CacheRequest");
    }
}
