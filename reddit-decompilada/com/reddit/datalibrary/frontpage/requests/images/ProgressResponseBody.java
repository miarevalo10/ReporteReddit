package com.reddit.datalibrary.frontpage.requests.images;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;

public class ProgressResponseBody extends ResponseBody {
    private final ResponseBody f16347a;
    private BufferedSource f16348b;
    private final String f16349c;

    public ProgressResponseBody(ResponseBody responseBody, String str) {
        this.f16347a = responseBody;
        this.f16349c = str;
    }

    public MediaType contentType() {
        return this.f16347a.contentType();
    }

    public long contentLength() {
        return this.f16347a.contentLength();
    }

    public BufferedSource source() {
        if (this.f16348b == null) {
            this.f16348b = Okio.a(new ForwardingSource(this, this.f16347a.source()) {
                long f18808a = 0;
                long f18809b = 0;
                float f18810c;
                final /* synthetic */ ProgressResponseBody f18811d;
                private int f18812e = null;
                private final ProgressChangedEvent f18813f = new ProgressChangedEvent(this.f18811d.f16349c);

                public long read(Buffer buffer, long j) throws IOException {
                    buffer = super.read(buffer, j);
                    this.f18808a += buffer != -1 ? buffer : 0;
                    this.f18810c = (float) this.f18811d.f16347a.contentLength();
                    int i = 100;
                    if (this.f18810c > 0.0f) {
                        i = (int) ((((float) this.f18808a) / this.f18810c) * 100.0f);
                    }
                    if (i != this.f18812e && i % 10 == 0 && System.currentTimeMillis() - this.f18809b > 1000) {
                        this.f18812e = i;
                        this.f18813f.f10924b = this.f18812e;
                        this.f18809b = System.currentTimeMillis();
                        ProgressMonitorBus.m9343a().post(this.f18813f);
                    }
                    return buffer;
                }
            });
        }
        return this.f16348b;
    }
}
