package okhttp3;

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
import okhttp3.Headers.Builder;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.cache.DiskLruCache.Editor;
import okhttp3.internal.cache.DiskLruCache.Snapshot;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

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

    class C21712 implements Iterator<String> {
        boolean canRemove;
        final Iterator<Snapshot> delegate = Cache.this.cache.snapshots();
        String nextUrl;

        C21712() throws IOException {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r4 = this;
            r0 = r4.nextUrl;
            r1 = 1;
            if (r0 == 0) goto L_0x0006;
        L_0x0005:
            return r1;
        L_0x0006:
            r0 = 0;
            r4.canRemove = r0;
        L_0x0009:
            r2 = r4.delegate;
            r2 = r2.hasNext();
            if (r2 == 0) goto L_0x0034;
        L_0x0011:
            r2 = r4.delegate;
            r2 = r2.next();
            r2 = (okhttp3.internal.cache.DiskLruCache.Snapshot) r2;
            r3 = r2.getSource(r0);	 Catch:{ IOException -> 0x0030, all -> 0x002b }
            r3 = okio.Okio.m28289a(r3);	 Catch:{ IOException -> 0x0030, all -> 0x002b }
            r3 = r3.mo6788q();	 Catch:{ IOException -> 0x0030, all -> 0x002b }
            r4.nextUrl = r3;	 Catch:{ IOException -> 0x0030, all -> 0x002b }
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
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cache.2.hasNext():boolean");
        }

        public String next() {
            if (hasNext()) {
                String str = this.nextUrl;
                this.nextUrl = null;
                this.canRemove = true;
                return str;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            if (this.canRemove) {
                this.delegate.remove();
                return;
            }
            throw new IllegalStateException("remove() before next()");
        }
    }

    private static final class Entry {
        private static final String RECEIVED_MILLIS;
        private static final String SENT_MILLIS;
        private final int code;
        private final Handshake handshake;
        private final String message;
        private final Protocol protocol;
        private final long receivedResponseMillis;
        private final String requestMethod;
        private final Headers responseHeaders;
        private final long sentRequestMillis;
        private final String url;
        private final Headers varyHeaders;

        static {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Platform.get().getPrefix());
            stringBuilder.append("-Sent-Millis");
            SENT_MILLIS = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(Platform.get().getPrefix());
            stringBuilder.append("-Received-Millis");
            RECEIVED_MILLIS = stringBuilder.toString();
        }

        Entry(Source source) throws IOException {
            try {
                BufferedSource a = Okio.m28289a(source);
                this.url = a.mo6788q();
                this.requestMethod = a.mo6788q();
                Builder builder = new Builder();
                int readInt = Cache.readInt(a);
                int i = 0;
                for (int i2 = 0; i2 < readInt; i2++) {
                    builder.addLenient(a.mo6788q());
                }
                this.varyHeaders = builder.build();
                StatusLine parse = StatusLine.parse(a.mo6788q());
                this.protocol = parse.protocol;
                this.code = parse.code;
                this.message = parse.message;
                builder = new Builder();
                readInt = Cache.readInt(a);
                while (i < readInt) {
                    builder.addLenient(a.mo6788q());
                    i++;
                }
                String str = builder.get(SENT_MILLIS);
                String str2 = builder.get(RECEIVED_MILLIS);
                builder.removeAll(SENT_MILLIS);
                builder.removeAll(RECEIVED_MILLIS);
                long j = 0;
                this.sentRequestMillis = str != null ? Long.parseLong(str) : 0;
                if (str2 != null) {
                    j = Long.parseLong(str2);
                }
                this.receivedResponseMillis = j;
                this.responseHeaders = builder.build();
                if (isHttps()) {
                    String q = a.mo6788q();
                    if (q.length() > 0) {
                        StringBuilder stringBuilder = new StringBuilder("expected \"\" but was \"");
                        stringBuilder.append(q);
                        stringBuilder.append("\"");
                        throw new IOException(stringBuilder.toString());
                    }
                    TlsVersion tlsVersion;
                    CipherSuite forJavaName = CipherSuite.forJavaName(a.mo6788q());
                    List readCertificateList = readCertificateList(a);
                    List readCertificateList2 = readCertificateList(a);
                    if (a.mo6769d()) {
                        tlsVersion = TlsVersion.SSL_3_0;
                    } else {
                        tlsVersion = TlsVersion.forJavaName(a.mo6788q());
                    }
                    this.handshake = Handshake.get(tlsVersion, forJavaName, readCertificateList, readCertificateList2);
                } else {
                    this.handshake = null;
                }
                source.close();
            } catch (Throwable th) {
                source.close();
            }
        }

        Entry(Response response) {
            this.url = response.request().url().toString();
            this.varyHeaders = HttpHeaders.varyHeaders(response);
            this.requestMethod = response.request().method();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.responseHeaders = response.headers();
            this.handshake = response.handshake();
            this.sentRequestMillis = response.sentRequestAtMillis();
            this.receivedResponseMillis = response.receivedResponseAtMillis();
        }

        public final void writeTo(Editor editor) throws IOException {
            int i = 0;
            editor = Okio.m28288a(editor.newSink(0));
            editor.mo6760b(this.url).mo6775h(10);
            editor.mo6760b(this.requestMethod).mo6775h(10);
            editor.mo6786n((long) this.varyHeaders.size()).mo6775h(10);
            int size = this.varyHeaders.size();
            for (int i2 = 0; i2 < size; i2++) {
                editor.mo6760b(this.varyHeaders.name(i2)).mo6760b(": ").mo6760b(this.varyHeaders.value(i2)).mo6775h(10);
            }
            editor.mo6760b(new StatusLine(this.protocol, this.code, this.message).toString()).mo6775h(10);
            editor.mo6786n((long) (this.responseHeaders.size() + 2)).mo6775h(10);
            size = this.responseHeaders.size();
            while (i < size) {
                editor.mo6760b(this.responseHeaders.name(i)).mo6760b(": ").mo6760b(this.responseHeaders.value(i)).mo6775h(10);
                i++;
            }
            editor.mo6760b(SENT_MILLIS).mo6760b(": ").mo6786n(this.sentRequestMillis).mo6775h(10);
            editor.mo6760b(RECEIVED_MILLIS).mo6760b(": ").mo6786n(this.receivedResponseMillis).mo6775h(10);
            if (isHttps()) {
                editor.mo6775h(10);
                editor.mo6760b(this.handshake.cipherSuite().javaName()).mo6775h(10);
                writeCertList(editor, this.handshake.peerCertificates());
                writeCertList(editor, this.handshake.localCertificates());
                editor.mo6760b(this.handshake.tlsVersion().javaName()).mo6775h(10);
            }
            editor.close();
        }

        private boolean isHttps() {
            return this.url.startsWith("https://");
        }

        private List<Certificate> readCertificateList(BufferedSource bufferedSource) throws IOException {
            int readInt = Cache.readInt(bufferedSource);
            if (readInt == -1) {
                return Collections.emptyList();
            }
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                List<Certificate> arrayList = new ArrayList(readInt);
                for (int i = 0; i < readInt; i++) {
                    String q = bufferedSource.mo6788q();
                    Buffer buffer = new Buffer();
                    buffer.m36486a(ByteString.m28270b(q));
                    arrayList.add(instance.generateCertificate(buffer.mo6770e()));
                }
                return arrayList;
            } catch (BufferedSource bufferedSource2) {
                throw new IOException(bufferedSource2.getMessage());
            }
        }

        private void writeCertList(BufferedSink bufferedSink, List<Certificate> list) throws IOException {
            try {
                bufferedSink.mo6786n((long) list.size()).mo6775h(10);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    bufferedSink.mo6760b(ByteString.m28269a(((Certificate) list.get(i)).getEncoded()).mo6159b()).mo6775h(10);
                }
            } catch (BufferedSink bufferedSink2) {
                throw new IOException(bufferedSink2.getMessage());
            }
        }

        public final boolean matches(Request request, Response response) {
            return (this.url.equals(request.url().toString()) && this.requestMethod.equals(request.method()) && HttpHeaders.varyMatches(response, this.varyHeaders, request) != null) ? true : null;
        }

        public final Response response(Snapshot snapshot) {
            String str = this.responseHeaders.get("Content-Type");
            String str2 = this.responseHeaders.get("Content-Length");
            return new Response.Builder().request(new Request.Builder().url(this.url).method(this.requestMethod, null).headers(this.varyHeaders).build()).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(new CacheResponseBody(snapshot, str, str2)).handshake(this.handshake).sentRequestAtMillis(this.sentRequestMillis).receivedResponseAtMillis(this.receivedResponseMillis).build();
        }
    }

    class C26011 implements InternalCache {
        C26011() {
        }

        public Response get(Request request) throws IOException {
            return Cache.this.get(request);
        }

        public CacheRequest put(Response response) throws IOException {
            return Cache.this.put(response);
        }

        public void remove(Request request) throws IOException {
            Cache.this.remove(request);
        }

        public void update(Response response, Response response2) {
            Cache.this.update(response, response2);
        }

        public void trackConditionalCacheHit() {
            Cache.this.trackConditionalCacheHit();
        }

        public void trackResponse(CacheStrategy cacheStrategy) {
            Cache.this.trackResponse(cacheStrategy);
        }
    }

    private final class CacheRequestImpl implements CacheRequest {
        private Sink body;
        private Sink cacheOut;
        boolean done;
        private final Editor editor;

        CacheRequestImpl(final Editor editor) {
            this.editor = editor;
            this.cacheOut = editor.newSink(1);
            this.body = new ForwardingSink(this.cacheOut, Cache.this) {
                public void close() throws IOException {
                    synchronized (Cache.this) {
                        if (CacheRequestImpl.this.done) {
                            return;
                        }
                        CacheRequestImpl.this.done = true;
                        Cache cache = Cache.this;
                        cache.writeSuccessCount++;
                        super.close();
                        editor.commit();
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r4 = this;
            r0 = okhttp3.Cache.this;
            monitor-enter(r0);
            r1 = r4.done;	 Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x0009;	 Catch:{ all -> 0x0020 }
        L_0x0007:
            monitor-exit(r0);	 Catch:{ all -> 0x0020 }
            return;	 Catch:{ all -> 0x0020 }
        L_0x0009:
            r1 = 1;	 Catch:{ all -> 0x0020 }
            r4.done = r1;	 Catch:{ all -> 0x0020 }
            r2 = okhttp3.Cache.this;	 Catch:{ all -> 0x0020 }
            r3 = r2.writeAbortCount;	 Catch:{ all -> 0x0020 }
            r3 = r3 + r1;	 Catch:{ all -> 0x0020 }
            r2.writeAbortCount = r3;	 Catch:{ all -> 0x0020 }
            monitor-exit(r0);	 Catch:{ all -> 0x0020 }
            r0 = r4.cacheOut;
            okhttp3.internal.Util.closeQuietly(r0);
            r0 = r4.editor;	 Catch:{ IOException -> 0x001f }
            r0.abort();	 Catch:{ IOException -> 0x001f }
            return;
        L_0x001f:
            return;
        L_0x0020:
            r1 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x0020 }
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cache.CacheRequestImpl.abort():void");
        }

        public final Sink body() {
            return this.body;
        }
    }

    private static class CacheResponseBody extends ResponseBody {
        private final BufferedSource bodySource;
        private final String contentLength;
        private final String contentType;
        final Snapshot snapshot;

        CacheResponseBody(final Snapshot snapshot, String str, String str2) {
            this.snapshot = snapshot;
            this.contentType = str;
            this.contentLength = str2;
            this.bodySource = Okio.m28289a(new ForwardingSource(snapshot.getSource(1)) {
                public void close() throws IOException {
                    snapshot.close();
                    super.close();
                }
            });
        }

        public MediaType contentType() {
            return this.contentType != null ? MediaType.parse(this.contentType) : null;
        }

        public long contentLength() {
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
            r0 = -1;
            r2 = r4.contentLength;	 Catch:{ NumberFormatException -> 0x000e }
            if (r2 == 0) goto L_0x000d;	 Catch:{ NumberFormatException -> 0x000e }
        L_0x0006:
            r2 = r4.contentLength;	 Catch:{ NumberFormatException -> 0x000e }
            r2 = java.lang.Long.parseLong(r2);	 Catch:{ NumberFormatException -> 0x000e }
            return r2;
        L_0x000d:
            return r0;
        L_0x000e:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cache.CacheResponseBody.contentLength():long");
        }

        public BufferedSource source() {
            return this.bodySource;
        }
    }

    public Cache(File file, long j) {
        this(file, j, FileSystem.SYSTEM);
    }

    Cache(File file, long j, FileSystem fileSystem) {
        this.internalCache = new C26011();
        this.cache = DiskLruCache.create(fileSystem, file, VERSION, 2, j);
    }

    public static String key(HttpUrl httpUrl) {
        return ByteString.m28267a(httpUrl.toString()).mo6160c().mo6164f();
    }

    final okhttp3.Response get(okhttp3.Request r5) {
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
        r0 = r5.url();
        r0 = key(r0);
        r1 = 0;
        r2 = r4.cache;	 Catch:{ IOException -> 0x0033 }
        r0 = r2.get(r0);	 Catch:{ IOException -> 0x0033 }
        if (r0 != 0) goto L_0x0012;
    L_0x0011:
        return r1;
    L_0x0012:
        r2 = new okhttp3.Cache$Entry;	 Catch:{ IOException -> 0x002f }
        r3 = 0;	 Catch:{ IOException -> 0x002f }
        r3 = r0.getSource(r3);	 Catch:{ IOException -> 0x002f }
        r2.<init>(r3);	 Catch:{ IOException -> 0x002f }
        r0 = r2.response(r0);
        r5 = r2.matches(r5, r0);
        if (r5 != 0) goto L_0x002e;
    L_0x0026:
        r5 = r0.body();
        okhttp3.internal.Util.closeQuietly(r5);
        return r1;
    L_0x002e:
        return r0;
    L_0x002f:
        okhttp3.internal.Util.closeQuietly(r0);
        return r1;
    L_0x0033:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cache.get(okhttp3.Request):okhttp3.Response");
    }

    final okhttp3.internal.cache.CacheRequest put(okhttp3.Response r4) {
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
        r0 = r4.request();
        r0 = r0.method();
        r1 = r4.request();
        r1 = r1.method();
        r1 = okhttp3.internal.http.HttpMethod.invalidatesCache(r1);
        r2 = 0;
        if (r1 == 0) goto L_0x001f;
    L_0x0017:
        r4 = r4.request();	 Catch:{ IOException -> 0x001e }
        r3.remove(r4);	 Catch:{ IOException -> 0x001e }
    L_0x001e:
        return r2;
    L_0x001f:
        r1 = "GET";
        r0 = r0.equals(r1);
        if (r0 != 0) goto L_0x0028;
    L_0x0027:
        return r2;
    L_0x0028:
        r0 = okhttp3.internal.http.HttpHeaders.hasVaryAll(r4);
        if (r0 == 0) goto L_0x002f;
    L_0x002e:
        return r2;
    L_0x002f:
        r0 = new okhttp3.Cache$Entry;
        r0.<init>(r4);
        r1 = r3.cache;	 Catch:{ IOException -> 0x0052 }
        r4 = r4.request();	 Catch:{ IOException -> 0x0052 }
        r4 = r4.url();	 Catch:{ IOException -> 0x0052 }
        r4 = key(r4);	 Catch:{ IOException -> 0x0052 }
        r4 = r1.edit(r4);	 Catch:{ IOException -> 0x0052 }
        if (r4 != 0) goto L_0x0049;
    L_0x0048:
        return r2;
    L_0x0049:
        r0.writeTo(r4);	 Catch:{ IOException -> 0x0053 }
        r0 = new okhttp3.Cache$CacheRequestImpl;	 Catch:{ IOException -> 0x0053 }
        r0.<init>(r4);	 Catch:{ IOException -> 0x0053 }
        return r0;
    L_0x0052:
        r4 = r2;
    L_0x0053:
        r3.abortQuietly(r4);
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cache.put(okhttp3.Response):okhttp3.internal.cache.CacheRequest");
    }

    final void remove(Request request) throws IOException {
        this.cache.remove(key(request.url()));
    }

    final void update(okhttp3.Response r2, okhttp3.Response r3) {
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
        r0 = new okhttp3.Cache$Entry;
        r0.<init>(r3);
        r2 = r2.body();
        r2 = (okhttp3.Cache.CacheResponseBody) r2;
        r2 = r2.snapshot;
        r2 = r2.edit();	 Catch:{ IOException -> 0x001a }
        if (r2 == 0) goto L_0x0019;
    L_0x0013:
        r0.writeTo(r2);	 Catch:{ IOException -> 0x001b }
        r2.commit();	 Catch:{ IOException -> 0x001b }
    L_0x0019:
        return;
    L_0x001a:
        r2 = 0;
    L_0x001b:
        r1.abortQuietly(r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cache.update(okhttp3.Response, okhttp3.Response):void");
    }

    private void abortQuietly(okhttp3.internal.cache.DiskLruCache.Editor r1) {
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
        r0 = this;
        if (r1 == 0) goto L_0x0007;
    L_0x0002:
        r1.abort();	 Catch:{ IOException -> 0x0006 }
        goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cache.abortQuietly(okhttp3.internal.cache.DiskLruCache$Editor):void");
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
        return new C21712();
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
    final synchronized void trackResponse(okhttp3.internal.cache.CacheStrategy r2) {
        /*
        r1 = this;
        monitor-enter(r1);
        r0 = r1.requestCount;	 Catch:{ all -> 0x001f }
        r0 = r0 + 1;
        r1.requestCount = r0;	 Catch:{ all -> 0x001f }
        r0 = r2.networkRequest;	 Catch:{ all -> 0x001f }
        if (r0 == 0) goto L_0x0013;
    L_0x000b:
        r2 = r1.networkCount;	 Catch:{ all -> 0x001f }
        r2 = r2 + 1;
        r1.networkCount = r2;	 Catch:{ all -> 0x001f }
        monitor-exit(r1);
        return;
    L_0x0013:
        r2 = r2.cacheResponse;	 Catch:{ all -> 0x001f }
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
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cache.trackResponse(okhttp3.internal.cache.CacheStrategy):void");
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
            long m = bufferedSource.mo6783m();
            bufferedSource = bufferedSource.mo6788q();
            if (m >= 0 && m <= 2147483647L) {
                if (bufferedSource.isEmpty()) {
                    return (int) m;
                }
            }
            StringBuilder stringBuilder = new StringBuilder("expected an int but was \"");
            stringBuilder.append(m);
            stringBuilder.append(bufferedSource);
            stringBuilder.append("\"");
            throw new IOException(stringBuilder.toString());
        } catch (BufferedSource bufferedSource2) {
            throw new IOException(bufferedSource2.getMessage());
        }
    }
}
