package com.sendbird.android.shadow.okhttp3;

import com.sendbird.android.shadow.okhttp3.internal.Util;
import com.sendbird.android.shadow.okio.Buffer;
import com.sendbird.android.shadow.okio.BufferedSource;
import java.io.Closeable;
import java.io.IOException;

public abstract class ResponseBody implements Closeable {

    class C24701 extends ResponseBody {
        final /* synthetic */ MediaType f30379a = null;
        final /* synthetic */ long f30380b;
        final /* synthetic */ BufferedSource f30381c;

        C24701(long j, BufferedSource bufferedSource) {
            this.f30380b = j;
            this.f30381c = bufferedSource;
        }

        public final MediaType mo5296a() {
            return this.f30379a;
        }

        public final long mo5297b() {
            return this.f30380b;
        }

        public final BufferedSource mo5298c() {
            return this.f30381c;
        }
    }

    public abstract MediaType mo5296a();

    public abstract long mo5297b();

    public abstract BufferedSource mo5298c();

    public final String m25339d() throws IOException {
        Closeable c = mo5298c();
        try {
            MediaType a = mo5296a();
            String a2 = c.mo6549a(Util.m25361a((BufferedSource) c, a != null ? a.m25308a(Util.f23338e) : Util.f23338e));
            return a2;
        } finally {
            Util.m25366a(c);
        }
    }

    public void close() {
        Util.m25366a(mo5298c());
    }

    public static ResponseBody m25335a(byte[] bArr) {
        BufferedSource b = new Buffer().m35464b(bArr);
        long length = (long) bArr.length;
        if (b != null) {
            return new C24701(length, b);
        }
        throw new NullPointerException("source == null");
    }
}
