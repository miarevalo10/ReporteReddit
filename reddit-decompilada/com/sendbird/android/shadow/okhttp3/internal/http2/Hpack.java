package com.sendbird.android.shadow.okhttp3.internal.http2;

import com.instabug.library.model.NetworkLog;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import com.sendbird.android.shadow.okhttp3.internal.Util;
import com.sendbird.android.shadow.okio.Buffer;
import com.sendbird.android.shadow.okio.BufferedSource;
import com.sendbird.android.shadow.okio.ByteString;
import com.sendbird.android.shadow.okio.Okio;
import com.sendbird.android.shadow.okio.Source;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

final class Hpack {
    static final Header[] f23463a;
    static final Map<ByteString, Integer> f23464b;

    static final class Reader {
        final List<Header> f23445a;
        final BufferedSource f23446b;
        final int f23447c;
        int f23448d;
        Header[] f23449e;
        int f23450f;
        int f23451g;
        int f23452h;

        Reader(Source source) {
            this(source, (byte) 0);
        }

        private Reader(Source source, byte b) {
            this.f23445a = new ArrayList();
            this.f23449e = new Header[(byte) 8];
            this.f23450f = this.f23449e.length - 1;
            this.f23451g = 0;
            this.f23452h = 0;
            this.f23447c = 4096;
            this.f23448d = 4096;
            this.f23446b = Okio.m25615a(source);
        }

        final void m25451a() {
            if (this.f23448d < this.f23452h) {
                if (this.f23448d == 0) {
                    m25445c();
                    return;
                }
                m25448d(this.f23452h - this.f23448d);
            }
        }

        private void m25445c() {
            Arrays.fill(this.f23449e, null);
            this.f23450f = this.f23449e.length - 1;
            this.f23451g = 0;
            this.f23452h = 0;
        }

        private int m25448d(int i) {
            int i2 = 0;
            if (i > 0) {
                for (int length = this.f23449e.length - 1; length >= this.f23450f && i > 0; length--) {
                    i -= this.f23449e[length].f23444i;
                    this.f23452h -= this.f23449e[length].f23444i;
                    this.f23451g--;
                    i2++;
                }
                System.arraycopy(this.f23449e, this.f23450f + 1, this.f23449e, (this.f23450f + 1) + i2, this.f23451g);
                this.f23450f += i2;
            }
            return i2;
        }

        final int m25449a(int i) {
            return (this.f23450f + 1) + i;
        }

        final ByteString m25454b(int i) {
            if (m25446c(i)) {
                return Hpack.f23463a[i].f23442g;
            }
            return this.f23449e[m25449a(i - Hpack.f23463a.length)].f23442g;
        }

        static boolean m25446c(int i) {
            return i >= 0 && i <= Hpack.f23463a.length - 1;
        }

        final void m25452a(Header header) {
            this.f23445a.add(header);
            int i = header.f23444i;
            if (i > this.f23448d) {
                m25445c();
                return;
            }
            m25448d((this.f23452h + i) - this.f23448d);
            if (this.f23451g + 1 > this.f23449e.length) {
                Object obj = new Header[(this.f23449e.length * 2)];
                System.arraycopy(this.f23449e, 0, obj, this.f23449e.length, this.f23449e.length);
                this.f23450f = this.f23449e.length - 1;
                this.f23449e = obj;
            }
            int i2 = this.f23450f;
            this.f23450f = i2 - 1;
            this.f23449e[i2] = header;
            this.f23451g++;
            this.f23452h += i;
        }

        private int m25447d() throws IOException {
            return this.f23446b.mo6563f() & 255;
        }

        final int m25450a(int i, int i2) throws IOException {
            i &= i2;
            if (i < i2) {
                return i;
            }
            i = 0;
            while (true) {
                int d = m25447d();
                if ((d & 128) == 0) {
                    return i2 + (d << i);
                }
                i2 += (d & 127) << i;
                i += 7;
            }
        }

        final ByteString m25453b() throws IOException {
            int d = m25447d();
            int i = 0;
            int i2 = (d & 128) == 128 ? 1 : 0;
            d = m25450a(d, 127);
            if (i2 == 0) {
                return this.f23446b.mo6560c((long) d);
            }
            Huffman a = Huffman.m25519a();
            byte[] f = this.f23446b.mo6565f((long) d);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i3 = 0;
            Node node = a.f23530a;
            int i4 = i3;
            while (i < f.length) {
                i4 = (i4 << 8) | (f[i] & 255);
                i3 += 8;
                while (i3 >= 8) {
                    node = node.f23524a[(i4 >>> (i3 - 8)) & 255];
                    if (node.f23524a == null) {
                        byteArrayOutputStream.write(node.f23525b);
                        i3 -= node.f23526c;
                        node = a.f23530a;
                    } else {
                        i3 -= 8;
                    }
                }
                i++;
            }
            while (i3 > 0) {
                Node node2 = node.f23524a[(i4 << (8 - i3)) & 255];
                if (node2.f23524a != null || node2.f23526c > i3) {
                    break;
                }
                byteArrayOutputStream.write(node2.f23525b);
                i3 -= node2.f23526c;
                node = a.f23530a;
            }
            return ByteString.m25596a(byteArrayOutputStream.toByteArray());
        }
    }

    static final class Writer {
        int f23453a;
        int f23454b;
        Header[] f23455c;
        int f23456d;
        int f23457e;
        int f23458f;
        private final Buffer f23459g;
        private final boolean f23460h;
        private int f23461i;
        private boolean f23462j;

        Writer(Buffer buffer) {
            this(buffer, (byte) 0);
        }

        private Writer(Buffer buffer, byte b) {
            this.f23461i = (byte) -1;
            this.f23455c = new Header[(byte) 8];
            this.f23456d = this.f23455c.length - (byte) 1;
            this.f23457e = 0;
            this.f23458f = 0;
            this.f23453a = 4096;
            this.f23454b = 4096;
            this.f23460h = true;
            this.f23459g = buffer;
        }

        private void m25455a() {
            Arrays.fill(this.f23455c, null);
            this.f23456d = this.f23455c.length - 1;
            this.f23457e = 0;
            this.f23458f = 0;
        }

        private int m25459b(int i) {
            int i2 = 0;
            if (i > 0) {
                for (int length = this.f23455c.length - 1; length >= this.f23456d && i > 0; length--) {
                    i -= this.f23455c[length].f23444i;
                    this.f23458f -= this.f23455c[length].f23444i;
                    this.f23457e--;
                    i2++;
                }
                System.arraycopy(this.f23455c, this.f23456d + 1, this.f23455c, (this.f23456d + 1) + i2, this.f23457e);
                Arrays.fill(this.f23455c, this.f23456d + 1, (this.f23456d + 1) + i2, null);
                this.f23456d += i2;
            }
            return i2;
        }

        private void m25457a(Header header) {
            int i = header.f23444i;
            if (i > this.f23454b) {
                m25455a();
                return;
            }
            m25459b((this.f23458f + i) - this.f23454b);
            if (this.f23457e + 1 > this.f23455c.length) {
                Object obj = new Header[(this.f23455c.length * 2)];
                System.arraycopy(this.f23455c, 0, obj, this.f23455c.length, this.f23455c.length);
                this.f23456d = this.f23455c.length - 1;
                this.f23455c = obj;
            }
            int i2 = this.f23456d;
            this.f23456d = i2 - 1;
            this.f23455c[i2] = header;
            this.f23457e++;
            this.f23458f += i;
        }

        final void m25461a(List<Header> list) throws IOException {
            if (this.f23462j) {
                if (this.f23461i < this.f23454b) {
                    m25456a(this.f23461i, 31, 32);
                }
                this.f23462j = false;
                this.f23461i = RedditJobManager.f10810d;
                m25456a(this.f23454b, 31, 32);
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                int intValue;
                int i2;
                int length;
                int i3;
                ByteString byteString;
                Header header = (Header) list.get(i);
                ByteString g = header.f23442g.mo5404g();
                ByteString byteString2 = header.f23443h;
                Integer num = (Integer) Hpack.f23464b.get(g);
                if (num != null) {
                    intValue = num.intValue() + 1;
                    if (intValue > 1 && intValue < 8) {
                        if (!Util.m25371a(Hpack.f23463a[intValue - 1].f23443h, (Object) byteString2)) {
                            if (Util.m25371a(Hpack.f23463a[intValue].f23443h, (Object) byteString2)) {
                                i2 = intValue;
                                intValue++;
                                if (intValue == -1) {
                                    length = this.f23455c.length;
                                    for (i3 = this.f23456d + 1; i3 < length; i3++) {
                                        if (Util.m25371a(this.f23455c[i3].f23442g, (Object) g)) {
                                            if (!Util.m25371a(this.f23455c[i3].f23443h, (Object) byteString2)) {
                                                intValue = Hpack.f23463a.length + (i3 - this.f23456d);
                                                break;
                                            } else if (i2 != -1) {
                                                i2 = (i3 - this.f23456d) + Hpack.f23463a.length;
                                            }
                                        }
                                    }
                                }
                                if (intValue == -1) {
                                    m25456a(intValue, 127, 128);
                                } else if (i2 == -1) {
                                    this.f23459g.m35463b(64);
                                    m25458a(g);
                                    m25458a(byteString2);
                                    m25457a(header);
                                } else {
                                    byteString = Header.f23436a;
                                    if (g.mo5396a(0, byteString, 0, byteString.mo5405h()) || Header.f23441f.equals(g)) {
                                        m25456a(i2, 63, 64);
                                        m25458a(byteString2);
                                        m25457a(header);
                                    } else {
                                        m25456a(i2, 15, 0);
                                        m25458a(byteString2);
                                    }
                                }
                            }
                        }
                    }
                    i2 = intValue;
                    intValue = -1;
                    if (intValue == -1) {
                        length = this.f23455c.length;
                        for (i3 = this.f23456d + 1; i3 < length; i3++) {
                            if (Util.m25371a(this.f23455c[i3].f23442g, (Object) g)) {
                                if (!Util.m25371a(this.f23455c[i3].f23443h, (Object) byteString2)) {
                                    intValue = Hpack.f23463a.length + (i3 - this.f23456d);
                                    break;
                                } else if (i2 != -1) {
                                    i2 = (i3 - this.f23456d) + Hpack.f23463a.length;
                                }
                            }
                        }
                    }
                    if (intValue == -1) {
                        m25456a(intValue, 127, 128);
                    } else if (i2 == -1) {
                        byteString = Header.f23436a;
                        if (g.mo5396a(0, byteString, 0, byteString.mo5405h())) {
                        }
                        m25456a(i2, 63, 64);
                        m25458a(byteString2);
                        m25457a(header);
                    } else {
                        this.f23459g.m35463b(64);
                        m25458a(g);
                        m25458a(byteString2);
                        m25457a(header);
                    }
                } else {
                    intValue = -1;
                }
                i2 = intValue;
                if (intValue == -1) {
                    length = this.f23455c.length;
                    for (i3 = this.f23456d + 1; i3 < length; i3++) {
                        if (Util.m25371a(this.f23455c[i3].f23442g, (Object) g)) {
                            if (!Util.m25371a(this.f23455c[i3].f23443h, (Object) byteString2)) {
                                intValue = Hpack.f23463a.length + (i3 - this.f23456d);
                                break;
                            } else if (i2 != -1) {
                                i2 = (i3 - this.f23456d) + Hpack.f23463a.length;
                            }
                        }
                    }
                }
                if (intValue == -1) {
                    m25456a(intValue, 127, 128);
                } else if (i2 == -1) {
                    this.f23459g.m35463b(64);
                    m25458a(g);
                    m25458a(byteString2);
                    m25457a(header);
                } else {
                    byteString = Header.f23436a;
                    if (g.mo5396a(0, byteString, 0, byteString.mo5405h())) {
                    }
                    m25456a(i2, 63, 64);
                    m25458a(byteString2);
                    m25457a(header);
                }
            }
        }

        private void m25456a(int i, int i2, int i3) {
            if (i < i2) {
                this.f23459g.m35463b(i | i3);
                return;
            }
            this.f23459g.m35463b(i3 | i2);
            i -= i2;
            while (i >= 128) {
                this.f23459g.m35463b(128 | (i & 127));
                i >>>= 7;
            }
            this.f23459g.m35463b(i);
        }

        private void m25458a(ByteString byteString) throws IOException {
            if (this.f23460h) {
                Huffman.m25519a();
                if (Huffman.m25518a(byteString) < byteString.mo5405h()) {
                    Object buffer = new Buffer();
                    Huffman.m25519a();
                    Huffman.m25520a(byteString, buffer);
                    byteString = buffer.m35500n();
                    m25456a(byteString.mo5405h(), 127, 128);
                    this.f23459g.m35454a(byteString);
                    return;
                }
            }
            m25456a(byteString.mo5405h(), 127, 0);
            this.f23459g.m35454a(byteString);
        }

        final void m25460a(int i) {
            this.f23453a = i;
            i = Math.min(i, 16384);
            if (this.f23454b != i) {
                if (i < this.f23454b) {
                    this.f23461i = Math.min(this.f23461i, i);
                }
                this.f23462j = true;
                this.f23454b = i;
                if (this.f23454b < this.f23458f) {
                    if (this.f23454b == 0) {
                        m25455a();
                        return;
                    }
                    m25459b(this.f23458f - this.f23454b);
                }
            }
        }
    }

    static {
        r0 = new Header[61];
        int i = 0;
        r0[0] = new Header(Header.f23441f, "");
        r0[1] = new Header(Header.f23438c, HttpRequest.METHOD_GET);
        r0[2] = new Header(Header.f23438c, HttpRequest.METHOD_POST);
        r0[3] = new Header(Header.f23439d, Operation.DIVISION);
        r0[4] = new Header(Header.f23439d, "/index.html");
        r0[5] = new Header(Header.f23440e, "http");
        r0[6] = new Header(Header.f23440e, "https");
        r0[7] = new Header(Header.f23437b, "200");
        r0[8] = new Header(Header.f23437b, "204");
        r0[9] = new Header(Header.f23437b, "206");
        r0[10] = new Header(Header.f23437b, "304");
        r0[11] = new Header(Header.f23437b, "400");
        r0[12] = new Header(Header.f23437b, "404");
        r0[13] = new Header(Header.f23437b, "500");
        r0[14] = new Header("accept-charset", "");
        r0[15] = new Header("accept-encoding", "gzip, deflate");
        r0[16] = new Header("accept-language", "");
        r0[17] = new Header("accept-ranges", "");
        r0[18] = new Header("accept", "");
        r0[19] = new Header("access-control-allow-origin", "");
        r0[20] = new Header("age", "");
        r0[21] = new Header("allow", "");
        r0[22] = new Header("authorization", "");
        r0[23] = new Header("cache-control", "");
        r0[24] = new Header("content-disposition", "");
        r0[25] = new Header("content-encoding", "");
        r0[26] = new Header("content-language", "");
        r0[27] = new Header("content-length", "");
        r0[28] = new Header("content-location", "");
        r0[29] = new Header("content-range", "");
        r0[30] = new Header(NetworkLog.CONTENT_TYPE, "");
        r0[31] = new Header("cookie", "");
        r0[32] = new Header("date", "");
        r0[33] = new Header("etag", "");
        r0[34] = new Header("expect", "");
        r0[35] = new Header("expires", "");
        r0[36] = new Header("from", "");
        r0[37] = new Header("host", "");
        r0[38] = new Header("if-match", "");
        r0[39] = new Header("if-modified-since", "");
        r0[40] = new Header("if-none-match", "");
        r0[41] = new Header("if-range", "");
        r0[42] = new Header("if-unmodified-since", "");
        r0[43] = new Header("last-modified", "");
        r0[44] = new Header("link", "");
        r0[45] = new Header("location", "");
        r0[46] = new Header("max-forwards", "");
        r0[47] = new Header("proxy-authenticate", "");
        r0[48] = new Header("proxy-authorization", "");
        r0[49] = new Header("range", "");
        r0[50] = new Header("referer", "");
        r0[51] = new Header("refresh", "");
        r0[52] = new Header("retry-after", "");
        r0[53] = new Header("server", "");
        r0[54] = new Header("set-cookie", "");
        r0[55] = new Header("strict-transport-security", "");
        r0[56] = new Header("transfer-encoding", "");
        r0[57] = new Header("user-agent", "");
        r0[58] = new Header("vary", "");
        r0[59] = new Header("via", "");
        r0[60] = new Header("www-authenticate", "");
        f23463a = r0;
        Map linkedHashMap = new LinkedHashMap(f23463a.length);
        while (i < f23463a.length) {
            if (!linkedHashMap.containsKey(f23463a[i].f23442g)) {
                linkedHashMap.put(f23463a[i].f23442g, Integer.valueOf(i));
            }
            i++;
        }
        f23464b = Collections.unmodifiableMap(linkedHashMap);
    }

    static ByteString m25462a(ByteString byteString) throws IOException {
        int h = byteString.mo5405h();
        int i = 0;
        while (i < h) {
            byte a = byteString.mo5392a(i);
            if (a < (byte) 65 || a > (byte) 90) {
                i++;
            } else {
                StringBuilder stringBuilder = new StringBuilder("PROTOCOL_ERROR response malformed: mixed case name: ");
                stringBuilder.append(byteString.mo5394a());
                throw new IOException(stringBuilder.toString());
            }
        }
        return byteString;
    }
}
