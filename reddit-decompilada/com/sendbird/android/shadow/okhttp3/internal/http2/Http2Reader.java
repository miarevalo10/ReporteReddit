package com.sendbird.android.shadow.okhttp3.internal.http2;

import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import com.sendbird.android.shadow.okio.Buffer;
import com.sendbird.android.shadow.okio.BufferedSource;
import com.sendbird.android.shadow.okio.ByteString;
import com.sendbird.android.shadow.okio.Source;
import com.sendbird.android.shadow.okio.Timeout;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

final class Http2Reader implements Closeable {
    static final Logger f23499a = Logger.getLogger(Http2.class.getName());
    final BufferedSource f23500b;
    final boolean f23501c;
    final Reader f23502d = new Reader(this.f23503e);
    private final ContinuationSource f23503e = new ContinuationSource(this.f23500b);

    interface Handler {
        void mo5345a(int i, long j);

        void mo5346a(int i, ErrorCode errorCode);

        void mo5347a(int i, ByteString byteString);

        void mo5348a(int i, List<Header> list) throws IOException;

        void mo5349a(Settings settings);

        void mo5350a(boolean z, int i, int i2);

        void mo5351a(boolean z, int i, BufferedSource bufferedSource, int i2) throws IOException;

        void mo5352a(boolean z, int i, List<Header> list);
    }

    static final class ContinuationSource implements Source {
        int f30492a;
        byte f30493b;
        int f30494c;
        int f30495d;
        short f30496e;
        private final BufferedSource f30497f;

        public final void close() throws IOException {
        }

        ContinuationSource(BufferedSource bufferedSource) {
            this.f30497f = bufferedSource;
        }

        public final long mo5322a(Buffer buffer, long j) throws IOException {
            while (this.f30495d == 0) {
                this.f30497f.mo6568g((long) this.f30496e);
                this.f30496e = (short) 0;
                if ((this.f30493b & 4) != 0) {
                    return -1;
                }
                int i = this.f30494c;
                int a = Http2Reader.m25489a(this.f30497f);
                this.f30495d = a;
                this.f30492a = a;
                byte f = (byte) (this.f30497f.mo6563f() & 255);
                this.f30493b = (byte) (this.f30497f.mo6563f() & 255);
                if (Http2Reader.f23499a.isLoggable(Level.FINE)) {
                    Http2Reader.f23499a.fine(Http2.m25464a(true, this.f30494c, this.f30492a, f, this.f30493b));
                }
                this.f30494c = this.f30497f.mo6569h() & RedditJobManager.f10810d;
                if (f != (byte) 9) {
                    throw Http2.m25465b("%s != TYPE_CONTINUATION", new Object[]{Byte.valueOf(f)});
                } else if (this.f30494c != i) {
                    throw Http2.m25465b("TYPE_CONTINUATION streamId changed", new Object[0]);
                }
            }
            buffer = this.f30497f.mo5322a(buffer, Math.min(j, (long) this.f30495d));
            if (buffer == -1) {
                return -1;
            }
            this.f30495d = (int) (((long) this.f30495d) - buffer);
            return buffer;
        }

        public final Timeout mo5323a() {
            return this.f30497f.mo5323a();
        }
    }

    Http2Reader(BufferedSource bufferedSource, boolean z) {
        this.f23500b = bufferedSource;
        this.f23501c = z;
    }

    public final boolean m25492a(boolean r11, com.sendbird.android.shadow.okhttp3.internal.http2.Http2Reader.Handler r12) throws java.io.IOException {
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
        r10 = this;
        r0 = 0;
        r1 = r10.f23500b;	 Catch:{ IOException -> 0x02ad }
        r2 = 9;	 Catch:{ IOException -> 0x02ad }
        r1.mo6550a(r2);	 Catch:{ IOException -> 0x02ad }
        r1 = r10.f23500b;
        r1 = m25489a(r1);
        r2 = 1;
        if (r1 < 0) goto L_0x029e;
    L_0x0011:
        r3 = 16384; // 0x4000 float:2.2959E-41 double:8.0948E-320;
        if (r1 <= r3) goto L_0x0017;
    L_0x0015:
        goto L_0x029e;
    L_0x0017:
        r4 = r10.f23500b;
        r4 = r4.mo6563f();
        r4 = r4 & 255;
        r4 = (byte) r4;
        r5 = 4;
        if (r11 == 0) goto L_0x0034;
    L_0x0023:
        if (r4 == r5) goto L_0x0034;
    L_0x0025:
        r11 = "Expected a SETTINGS frame but was %s";
        r12 = new java.lang.Object[r2];
        r1 = java.lang.Byte.valueOf(r4);
        r12[r0] = r1;
        r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.m25465b(r11, r12);
        throw r11;
    L_0x0034:
        r11 = r10.f23500b;
        r11 = r11.mo6563f();
        r11 = r11 & 255;
        r11 = (byte) r11;
        r6 = r10.f23500b;
        r6 = r6.mo6569h();
        r7 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r6 = r6 & r7;
        r8 = f23499a;
        r9 = java.util.logging.Level.FINE;
        r8 = r8.isLoggable(r9);
        if (r8 == 0) goto L_0x005a;
    L_0x0051:
        r8 = f23499a;
        r9 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.m25464a(r2, r6, r1, r4, r11);
        r8.fine(r9);
    L_0x005a:
        r8 = 8;
        switch(r4) {
            case 0: goto L_0x025d;
            case 1: goto L_0x0229;
            case 2: goto L_0x0207;
            case 3: goto L_0x01cb;
            case 4: goto L_0x014b;
            case 5: goto L_0x011d;
            case 6: goto L_0x00ec;
            case 7: goto L_0x009e;
            case 8: goto L_0x0067;
            default: goto L_0x005f;
        };
    L_0x005f:
        r11 = r10.f23500b;
        r0 = (long) r1;
        r11.mo6568g(r0);
        goto L_0x029d;
    L_0x0067:
        if (r1 == r5) goto L_0x0078;
    L_0x0069:
        r11 = "TYPE_WINDOW_UPDATE length !=4: %s";
        r12 = new java.lang.Object[r2];
        r1 = java.lang.Integer.valueOf(r1);
        r12[r0] = r1;
        r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.m25465b(r11, r12);
        throw r11;
    L_0x0078:
        r11 = r10.f23500b;
        r11 = r11.mo6569h();
        r3 = (long) r11;
        r7 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r3 = r3 & r7;
        r7 = 0;
        r11 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1));
        if (r11 != 0) goto L_0x0099;
    L_0x0089:
        r11 = "windowSizeIncrement was 0";
        r12 = new java.lang.Object[r2];
        r1 = java.lang.Long.valueOf(r3);
        r12[r0] = r1;
        r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.m25465b(r11, r12);
        throw r11;
    L_0x0099:
        r12.mo5345a(r6, r3);
        goto L_0x029d;
    L_0x009e:
        if (r1 >= r8) goto L_0x00af;
    L_0x00a0:
        r11 = "TYPE_GOAWAY length < 8: %s";
        r12 = new java.lang.Object[r2];
        r1 = java.lang.Integer.valueOf(r1);
        r12[r0] = r1;
        r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.m25465b(r11, r12);
        throw r11;
    L_0x00af:
        if (r6 == 0) goto L_0x00ba;
    L_0x00b1:
        r11 = "TYPE_GOAWAY streamId != 0";
        r12 = new java.lang.Object[r0];
        r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.m25465b(r11, r12);
        throw r11;
    L_0x00ba:
        r11 = r10.f23500b;
        r11 = r11.mo6569h();
        r3 = r10.f23500b;
        r3 = r3.mo6569h();
        r1 = r1 - r8;
        r4 = com.sendbird.android.shadow.okhttp3.internal.http2.ErrorCode.m25444a(r3);
        if (r4 != 0) goto L_0x00dc;
    L_0x00cd:
        r11 = "TYPE_GOAWAY unexpected error code: %d";
        r12 = new java.lang.Object[r2];
        r1 = java.lang.Integer.valueOf(r3);
        r12[r0] = r1;
        r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.m25465b(r11, r12);
        throw r11;
    L_0x00dc:
        r0 = com.sendbird.android.shadow.okio.ByteString.f23602b;
        if (r1 <= 0) goto L_0x00e7;
    L_0x00e0:
        r0 = r10.f23500b;
        r3 = (long) r1;
        r0 = r0.mo6560c(r3);
    L_0x00e7:
        r12.mo5347a(r11, r0);
        goto L_0x029d;
    L_0x00ec:
        if (r1 == r8) goto L_0x00fd;
    L_0x00ee:
        r11 = "TYPE_PING length != 8: %s";
        r12 = new java.lang.Object[r2];
        r1 = java.lang.Integer.valueOf(r1);
        r12[r0] = r1;
        r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.m25465b(r11, r12);
        throw r11;
    L_0x00fd:
        if (r6 == 0) goto L_0x0108;
    L_0x00ff:
        r11 = "TYPE_PING streamId != 0";
        r12 = new java.lang.Object[r0];
        r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.m25465b(r11, r12);
        throw r11;
    L_0x0108:
        r1 = r10.f23500b;
        r1 = r1.mo6569h();
        r3 = r10.f23500b;
        r3 = r3.mo6569h();
        r11 = r11 & r2;
        if (r11 == 0) goto L_0x0118;
    L_0x0117:
        r0 = r2;
    L_0x0118:
        r12.mo5350a(r0, r1, r3);
        goto L_0x029d;
    L_0x011d:
        if (r6 != 0) goto L_0x0128;
    L_0x011f:
        r11 = "PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0";
        r12 = new java.lang.Object[r0];
        r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.m25465b(r11, r12);
        throw r11;
    L_0x0128:
        r3 = r11 & 8;
        if (r3 == 0) goto L_0x0135;
    L_0x012c:
        r0 = r10.f23500b;
        r0 = r0.mo6563f();
        r0 = r0 & 255;
        r0 = (short) r0;
    L_0x0135:
        r3 = r10.f23500b;
        r3 = r3.mo6569h();
        r3 = r3 & r7;
        r1 = r1 + -4;
        r1 = m25488a(r1, r11, r0);
        r11 = r10.m25490a(r1, r0, r11, r6);
        r12.mo5348a(r3, r11);
        goto L_0x029d;
    L_0x014b:
        if (r6 == 0) goto L_0x0156;
    L_0x014d:
        r11 = "TYPE_SETTINGS streamId != 0";
        r12 = new java.lang.Object[r0];
        r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.m25465b(r11, r12);
        throw r11;
    L_0x0156:
        r11 = r11 & r2;
        if (r11 == 0) goto L_0x0164;
    L_0x0159:
        if (r1 == 0) goto L_0x029d;
    L_0x015b:
        r11 = "FRAME_SIZE_ERROR ack frame should be empty!";
        r12 = new java.lang.Object[r0];
        r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.m25465b(r11, r12);
        throw r11;
    L_0x0164:
        r11 = r1 % 6;
        if (r11 == 0) goto L_0x0177;
    L_0x0168:
        r11 = "TYPE_SETTINGS length %% 6 != 0: %s";
        r12 = new java.lang.Object[r2];
        r1 = java.lang.Integer.valueOf(r1);
        r12[r0] = r1;
        r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.m25465b(r11, r12);
        throw r11;
    L_0x0177:
        r11 = new com.sendbird.android.shadow.okhttp3.internal.http2.Settings;
        r11.<init>();
        r4 = r0;
    L_0x017d:
        if (r4 >= r1) goto L_0x01c6;
    L_0x017f:
        r6 = r10.f23500b;
        r6 = r6.mo6567g();
        r7 = r10.f23500b;
        r7 = r7.mo6569h();
        switch(r6) {
            case 1: goto L_0x01c0;
            case 2: goto L_0x01b3;
            case 3: goto L_0x01b1;
            case 4: goto L_0x01a5;
            case 5: goto L_0x018f;
            default: goto L_0x018e;
        };
    L_0x018e:
        goto L_0x01c0;
    L_0x018f:
        if (r7 < r3) goto L_0x0196;
    L_0x0191:
        r8 = 16777215; // 0xffffff float:2.3509886E-38 double:8.2890456E-317;
        if (r7 <= r8) goto L_0x01c0;
    L_0x0196:
        r11 = "PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s";
        r12 = new java.lang.Object[r2];
        r1 = java.lang.Integer.valueOf(r7);
        r12[r0] = r1;
        r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.m25465b(r11, r12);
        throw r11;
    L_0x01a5:
        r6 = 7;
        if (r7 >= 0) goto L_0x01c0;
    L_0x01a8:
        r11 = "PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1";
        r12 = new java.lang.Object[r0];
        r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.m25465b(r11, r12);
        throw r11;
    L_0x01b1:
        r6 = r5;
        goto L_0x01c0;
    L_0x01b3:
        if (r7 == 0) goto L_0x01c0;
    L_0x01b5:
        if (r7 == r2) goto L_0x01c0;
    L_0x01b7:
        r11 = "PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1";
        r12 = new java.lang.Object[r0];
        r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.m25465b(r11, r12);
        throw r11;
    L_0x01c0:
        r11.m25527a(r6, r7);
        r4 = r4 + 6;
        goto L_0x017d;
    L_0x01c6:
        r12.mo5349a(r11);
        goto L_0x029d;
    L_0x01cb:
        if (r1 == r5) goto L_0x01dc;
    L_0x01cd:
        r11 = "TYPE_RST_STREAM length: %d != 4";
        r12 = new java.lang.Object[r2];
        r1 = java.lang.Integer.valueOf(r1);
        r12[r0] = r1;
        r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.m25465b(r11, r12);
        throw r11;
    L_0x01dc:
        if (r6 != 0) goto L_0x01e7;
    L_0x01de:
        r11 = "TYPE_RST_STREAM streamId == 0";
        r12 = new java.lang.Object[r0];
        r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.m25465b(r11, r12);
        throw r11;
    L_0x01e7:
        r11 = r10.f23500b;
        r11 = r11.mo6569h();
        r1 = com.sendbird.android.shadow.okhttp3.internal.http2.ErrorCode.m25444a(r11);
        if (r1 != 0) goto L_0x0202;
    L_0x01f3:
        r12 = "TYPE_RST_STREAM unexpected error code: %d";
        r1 = new java.lang.Object[r2];
        r11 = java.lang.Integer.valueOf(r11);
        r1[r0] = r11;
        r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.m25465b(r12, r1);
        throw r11;
    L_0x0202:
        r12.mo5346a(r6, r1);
        goto L_0x029d;
    L_0x0207:
        r11 = 5;
        if (r1 == r11) goto L_0x0219;
    L_0x020a:
        r11 = "TYPE_PRIORITY length: %d != 5";
        r12 = new java.lang.Object[r2];
        r1 = java.lang.Integer.valueOf(r1);
        r12[r0] = r1;
        r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.m25465b(r11, r12);
        throw r11;
    L_0x0219:
        if (r6 != 0) goto L_0x0224;
    L_0x021b:
        r11 = "TYPE_PRIORITY streamId == 0";
        r12 = new java.lang.Object[r0];
        r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.m25465b(r11, r12);
        throw r11;
    L_0x0224:
        r10.m25491a();
        goto L_0x029d;
    L_0x0229:
        if (r6 != 0) goto L_0x0234;
    L_0x022b:
        r11 = "PROTOCOL_ERROR: TYPE_HEADERS streamId == 0";
        r12 = new java.lang.Object[r0];
        r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.m25465b(r11, r12);
        throw r11;
    L_0x0234:
        r3 = r11 & 1;
        if (r3 == 0) goto L_0x023a;
    L_0x0238:
        r3 = r2;
        goto L_0x023b;
    L_0x023a:
        r3 = r0;
    L_0x023b:
        r4 = r11 & 8;
        if (r4 == 0) goto L_0x0248;
    L_0x023f:
        r0 = r10.f23500b;
        r0 = r0.mo6563f();
        r0 = r0 & 255;
        r0 = (short) r0;
    L_0x0248:
        r4 = r11 & 32;
        if (r4 == 0) goto L_0x0251;
    L_0x024c:
        r10.m25491a();
        r1 = r1 + -5;
    L_0x0251:
        r1 = m25488a(r1, r11, r0);
        r11 = r10.m25490a(r1, r0, r11, r6);
        r12.mo5352a(r3, r6, r11);
        goto L_0x029d;
    L_0x025d:
        if (r6 != 0) goto L_0x0268;
    L_0x025f:
        r11 = "PROTOCOL_ERROR: TYPE_DATA streamId == 0";
        r12 = new java.lang.Object[r0];
        r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.m25465b(r11, r12);
        throw r11;
    L_0x0268:
        r3 = r11 & 1;
        if (r3 == 0) goto L_0x026e;
    L_0x026c:
        r3 = r2;
        goto L_0x026f;
    L_0x026e:
        r3 = r0;
    L_0x026f:
        r4 = r11 & 32;
        if (r4 == 0) goto L_0x0275;
    L_0x0273:
        r4 = r2;
        goto L_0x0276;
    L_0x0275:
        r4 = r0;
    L_0x0276:
        if (r4 == 0) goto L_0x0281;
    L_0x0278:
        r11 = "PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA";
        r12 = new java.lang.Object[r0];
        r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.m25465b(r11, r12);
        throw r11;
    L_0x0281:
        r4 = r11 & 8;
        if (r4 == 0) goto L_0x028e;
    L_0x0285:
        r0 = r10.f23500b;
        r0 = r0.mo6563f();
        r0 = r0 & 255;
        r0 = (short) r0;
    L_0x028e:
        r11 = m25488a(r1, r11, r0);
        r1 = r10.f23500b;
        r12.mo5351a(r3, r6, r1, r11);
        r11 = r10.f23500b;
        r0 = (long) r0;
        r11.mo6568g(r0);
    L_0x029d:
        return r2;
    L_0x029e:
        r11 = "FRAME_SIZE_ERROR: %s";
        r12 = new java.lang.Object[r2];
        r1 = java.lang.Integer.valueOf(r1);
        r12[r0] = r1;
        r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.m25465b(r11, r12);
        throw r11;
    L_0x02ad:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.http2.Http2Reader.a(boolean, com.sendbird.android.shadow.okhttp3.internal.http2.Http2Reader$Handler):boolean");
    }

    private List<Header> m25490a(int i, short s, byte b, int i2) throws IOException {
        ContinuationSource continuationSource = this.f23503e;
        this.f23503e.f30495d = i;
        continuationSource.f30492a = i;
        this.f23503e.f30496e = s;
        this.f23503e.f30493b = b;
        this.f23503e.f30494c = i2;
        i = this.f23502d;
        while (i.f23446b.mo6562d() == (short) 0) {
            byte f = i.f23446b.mo6563f() & 255;
            if (f == Byte.MIN_VALUE) {
                throw new IOException("index == 0");
            } else if ((f & 128) == 128) {
                s = i.m25450a(f, Byte.MAX_VALUE) - 1;
                if (Reader.m25446c(s) != (byte) 0) {
                    i.f23445a.add(Hpack.f23463a[s]);
                } else {
                    b = i.m25449a(s - Hpack.f23463a.length);
                    if (b >= (byte) 0) {
                        if (b <= i.f23449e.length - 1) {
                            i.f23445a.add(i.f23449e[b]);
                        }
                    }
                    b = new StringBuilder("Header index too large ");
                    b.append(s + 1);
                    throw new IOException(b.toString());
                }
            } else if (f == (byte) 64) {
                i.m25452a(new Header(Hpack.m25462a(i.m25453b()), i.m25453b()));
            } else if ((f & 64) == 64) {
                i.m25452a(new Header(i.m25454b(i.m25450a(f, (byte) 63) - 1), i.m25453b()));
            } else if ((f & 32) == (byte) 32) {
                i.f23448d = i.m25450a(f, (byte) 31);
                if (i.f23448d >= (short) 0) {
                    if (i.f23448d <= i.f23447c) {
                        i.m25451a();
                    }
                }
                b = new StringBuilder("Invalid dynamic table size update ");
                b.append(i.f23448d);
                throw new IOException(b.toString());
            } else {
                if (f != (byte) 16) {
                    if (f != (byte) 0) {
                        i.f23445a.add(new Header(i.m25454b(i.m25450a(f, (byte) 15) - 1), i.m25453b()));
                    }
                }
                i.f23445a.add(new Header(Hpack.m25462a(i.m25453b()), i.m25453b()));
            }
        }
        i = this.f23502d;
        s = new ArrayList(i.f23445a);
        i.f23445a.clear();
        return s;
    }

    private void m25491a() throws IOException {
        this.f23500b.mo6569h();
        this.f23500b.mo6563f();
    }

    public final void close() throws IOException {
        this.f23500b.close();
    }

    static int m25489a(BufferedSource bufferedSource) throws IOException {
        return (bufferedSource.mo6563f() & 255) | (((bufferedSource.mo6563f() & 255) << 16) | ((bufferedSource.mo6563f() & 255) << 8));
    }

    private static int m25488a(int i, byte b, short s) throws IOException {
        if ((b & 8) != (byte) 0) {
            short s2 = i - 1;
        }
        if (s <= s2) {
            return (short) (s2 - s);
        }
        throw Http2.m25465b("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(s2));
    }
}
