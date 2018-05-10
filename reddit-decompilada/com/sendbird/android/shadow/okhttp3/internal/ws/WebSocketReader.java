package com.sendbird.android.shadow.okhttp3.internal.ws;

import com.sendbird.android.shadow.okio.Buffer;
import com.sendbird.android.shadow.okio.BufferedSource;
import com.sendbird.android.shadow.okio.ByteString;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;

final class WebSocketReader {
    final boolean f23577a;
    final BufferedSource f23578b;
    final FrameCallback f23579c;
    boolean f23580d;
    int f23581e;
    long f23582f;
    long f23583g;
    boolean f23584h;
    boolean f23585i;
    boolean f23586j;
    final byte[] f23587k = new byte[4];
    final byte[] f23588l = new byte[8192];

    public interface FrameCallback {
        void mo5378a(int i, String str);

        void mo5379a(ByteString byteString);

        void mo5382c();

        void mo5383c(String str) throws IOException;
    }

    final void m25586a() throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Not initialized variable reg: 1, insn: 0x003e: MOVE  (r0 ?[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r1 ?[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:10:0x003e, method: com.sendbird.android.shadow.okhttp3.internal.ws.WebSocketReader.a():void
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:168)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:132)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r7 = this;
        r0 = r7.f23580d;
        if (r0 == 0) goto L_0x000c;
    L_0x0004:
        r0 = new java.io.IOException;
        r1 = "closed";
        r0.<init>(r1);
        throw r0;
    L_0x000c:
        r0 = r7.f23578b;
        r0 = r0.mo5323a();
        r0 = r0.av_();
        r2 = r7.f23578b;
        r2 = r2.mo5323a();
        r2.mo5390d();
        r2 = r7.f23578b;	 Catch:{ all -> 0x0117 }
        r2 = r2.mo6563f();	 Catch:{ all -> 0x0117 }
        r2 = r2 & 255;
        r3 = r7.f23578b;
        r3 = r3.mo5323a();
        r4 = java.util.concurrent.TimeUnit.NANOSECONDS;
        r3.mo5385a(r0, r4);
        r0 = r2 & 15;
        r7.f23581e = r0;
        r0 = r2 & 128;
        r1 = 0;
        r3 = 1;
        if (r0 == 0) goto L_0x003e;
    L_0x003c:
        r0 = r3;
        goto L_0x003f;
    L_0x003e:
        r0 = r1;
    L_0x003f:
        r7.f23584h = r0;
        r0 = r2 & 8;
        if (r0 == 0) goto L_0x0047;
    L_0x0045:
        r0 = r3;
        goto L_0x0048;
    L_0x0047:
        r0 = r1;
    L_0x0048:
        r7.f23585i = r0;
        r0 = r7.f23585i;
        if (r0 == 0) goto L_0x005a;
    L_0x004e:
        r0 = r7.f23584h;
        if (r0 != 0) goto L_0x005a;
    L_0x0052:
        r0 = new java.net.ProtocolException;
        r1 = "Control frames must be final.";
        r0.<init>(r1);
        throw r0;
    L_0x005a:
        r0 = r2 & 64;
        if (r0 == 0) goto L_0x0060;
    L_0x005e:
        r0 = r3;
        goto L_0x0061;
    L_0x0060:
        r0 = r1;
    L_0x0061:
        r4 = r2 & 32;
        if (r4 == 0) goto L_0x0067;
    L_0x0065:
        r4 = r3;
        goto L_0x0068;
    L_0x0067:
        r4 = r1;
    L_0x0068:
        r2 = r2 & 16;
        if (r2 == 0) goto L_0x006e;
    L_0x006c:
        r2 = r3;
        goto L_0x006f;
    L_0x006e:
        r2 = r1;
    L_0x006f:
        if (r0 != 0) goto L_0x010f;
    L_0x0071:
        if (r4 != 0) goto L_0x010f;
    L_0x0073:
        if (r2 == 0) goto L_0x0077;
    L_0x0075:
        goto L_0x010f;
    L_0x0077:
        r0 = r7.f23578b;
        r0 = r0.mo6563f();
        r0 = r0 & 255;
        r2 = r0 & 128;
        if (r2 == 0) goto L_0x0084;
    L_0x0083:
        r1 = r3;
    L_0x0084:
        r7.f23586j = r1;
        r1 = r7.f23586j;
        r2 = r7.f23577a;
        if (r1 != r2) goto L_0x009b;
    L_0x008c:
        r0 = new java.net.ProtocolException;
        r1 = r7.f23577a;
        if (r1 == 0) goto L_0x0095;
    L_0x0092:
        r1 = "Server-sent frames must not be masked.";
        goto L_0x0097;
    L_0x0095:
        r1 = "Client-sent frames must be masked.";
    L_0x0097:
        r0.<init>(r1);
        throw r0;
    L_0x009b:
        r0 = r0 & 127;
        r0 = (long) r0;
        r7.f23582f = r0;
        r0 = r7.f23582f;
        r2 = 126; // 0x7e float:1.77E-43 double:6.23E-322;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        r1 = 0;
        if (r0 != 0) goto L_0x00b8;
    L_0x00aa:
        r0 = r7.f23578b;
        r0 = r0.mo6567g();
        r3 = (long) r0;
        r5 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
        r3 = r3 & r5;
        r7.f23582f = r3;
        goto L_0x00ed;
    L_0x00b8:
        r3 = r7.f23582f;
        r5 = 127; // 0x7f float:1.78E-43 double:6.27E-322;
        r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r0 != 0) goto L_0x00ed;
    L_0x00c0:
        r0 = r7.f23578b;
        r3 = r0.mo6571i();
        r7.f23582f = r3;
        r3 = r7.f23582f;
        r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1));
        if (r0 >= 0) goto L_0x00ed;
    L_0x00ce:
        r0 = new java.net.ProtocolException;
        r1 = new java.lang.StringBuilder;
        r2 = "Frame length 0x";
        r1.<init>(r2);
        r2 = r7.f23582f;
        r2 = java.lang.Long.toHexString(r2);
        r1.append(r2);
        r2 = " > 0x7FFFFFFFFFFFFFFF";
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x00ed:
        r7.f23583g = r1;
        r0 = r7.f23585i;
        if (r0 == 0) goto L_0x0103;
    L_0x00f3:
        r0 = r7.f23582f;
        r2 = 125; // 0x7d float:1.75E-43 double:6.2E-322;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 <= 0) goto L_0x0103;
    L_0x00fb:
        r0 = new java.net.ProtocolException;
        r1 = "Control frame must be less than 125B.";
        r0.<init>(r1);
        throw r0;
    L_0x0103:
        r0 = r7.f23586j;
        if (r0 == 0) goto L_0x010e;
    L_0x0107:
        r0 = r7.f23578b;
        r1 = r7.f23587k;
        r0.mo6551a(r1);
    L_0x010e:
        return;
    L_0x010f:
        r0 = new java.net.ProtocolException;
        r1 = "Reserved flags are unsupported.";
        r0.<init>(r1);
        throw r0;
    L_0x0117:
        r2 = move-exception;
        r3 = r7.f23578b;
        r3 = r3.mo5323a();
        r4 = java.util.concurrent.TimeUnit.NANOSECONDS;
        r3.mo5385a(r0, r4);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.ws.WebSocketReader.a():void");
    }

    WebSocketReader(boolean z, BufferedSource bufferedSource, FrameCallback frameCallback) {
        if (bufferedSource == null) {
            throw new NullPointerException("source == null");
        } else if (frameCallback == null) {
            throw new NullPointerException("frameCallback == null");
        } else {
            this.f23577a = z;
            this.f23578b = bufferedSource;
            this.f23579c = frameCallback;
        }
    }

    final void m25588b() throws IOException {
        int a;
        Buffer buffer = new Buffer();
        if (this.f23583g < this.f23582f) {
            if (this.f23577a) {
                this.f23578b.mo6554b(buffer, this.f23582f);
            } else {
                while (this.f23583g < this.f23582f) {
                    a = this.f23578b.mo6547a(this.f23588l, 0, (int) Math.min(this.f23582f - this.f23583g, (long) this.f23588l.length));
                    if (a == -1) {
                        throw new EOFException();
                    }
                    long j = (long) a;
                    WebSocketProtocol.m25579a(this.f23588l, j, this.f23587k, this.f23583g);
                    buffer.m35465b(this.f23588l, 0, a);
                    this.f23583g += j;
                }
            }
        }
        switch (this.f23581e) {
            case 8:
                a = 1005;
                String str = "";
                long j2 = buffer.f34625b;
                if (j2 == 1) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                if (j2 != 0) {
                    a = buffer.mo6567g();
                    str = buffer.m35501o();
                    String a2 = WebSocketProtocol.m25578a(a);
                    if (a2 != null) {
                        throw new ProtocolException(a2);
                    }
                }
                this.f23579c.mo5378a(a, str);
                this.f23580d = true;
                return;
            case 9:
                this.f23579c.mo5379a(buffer.m35500n());
                return;
            case 10:
                FrameCallback frameCallback = this.f23579c;
                buffer.m35500n();
                frameCallback.mo5382c();
                return;
            default:
                StringBuilder stringBuilder = new StringBuilder("Unknown control opcode: ");
                stringBuilder.append(Integer.toHexString(this.f23581e));
                throw new ProtocolException(stringBuilder.toString());
        }
    }

    private void m25585c() throws IOException {
        while (!this.f23580d) {
            m25586a();
            if (this.f23585i) {
                m25588b();
            } else {
                return;
            }
        }
    }

    final void m25587a(Buffer buffer) throws IOException {
        while (!this.f23580d) {
            if (this.f23583g == this.f23582f) {
                if (!this.f23584h) {
                    m25585c();
                    if (this.f23581e != 0) {
                        StringBuilder stringBuilder = new StringBuilder("Expected continuation opcode. Got: ");
                        stringBuilder.append(Integer.toHexString(this.f23581e));
                        throw new ProtocolException(stringBuilder.toString());
                    } else if (this.f23584h && this.f23582f == 0) {
                        return;
                    }
                }
                return;
            }
            long j = this.f23582f - this.f23583g;
            if (this.f23586j) {
                j = (long) this.f23578b.mo6547a(this.f23588l, 0, (int) Math.min(j, (long) this.f23588l.length));
                if (j == -1) {
                    throw new EOFException();
                }
                WebSocketProtocol.m25579a(this.f23588l, j, this.f23587k, this.f23583g);
                buffer.m35465b(this.f23588l, 0, (int) j);
            } else {
                j = this.f23578b.mo5322a(buffer, j);
                if (j == -1) {
                    throw new EOFException();
                }
            }
            this.f23583g += j;
        }
        throw new IOException("closed");
    }
}
