package com.sendbird.android.shadow.okhttp3;

import com.sendbird.android.shadow.okhttp3.internal.Util;
import com.sendbird.android.shadow.okio.BufferedSink;
import com.sendbird.android.shadow.okio.Okio;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public abstract class RequestBody {

    class C24682 extends RequestBody {
        final /* synthetic */ MediaType f30373a;
        final /* synthetic */ int f30374b;
        final /* synthetic */ byte[] f30375c;
        final /* synthetic */ int f30376d = null;

        C24682(MediaType mediaType, int i, byte[] bArr) {
            this.f30373a = mediaType;
            this.f30374b = i;
            this.f30375c = bArr;
        }

        public final MediaType mo5211a() {
            return this.f30373a;
        }

        public final long mo5213b() {
            return (long) this.f30374b;
        }

        public final void mo5212a(BufferedSink bufferedSink) throws IOException {
            bufferedSink.mo6559c(this.f30375c, this.f30376d, this.f30374b);
        }
    }

    class C24693 extends RequestBody {
        final /* synthetic */ MediaType f30377a;
        final /* synthetic */ File f30378b;

        C24693(MediaType mediaType, File file) {
            this.f30377a = mediaType;
            this.f30378b = file;
        }

        public final MediaType mo5211a() {
            return this.f30377a;
        }

        public final long mo5213b() {
            return this.f30378b.length();
        }

        public final void mo5212a(BufferedSink bufferedSink) throws IOException {
            Closeable closeable = null;
            try {
                Closeable a = Okio.m25620a(this.f30378b);
                try {
                    bufferedSink.mo6548a(a);
                    Util.m25366a(a);
                } catch (Throwable th) {
                    bufferedSink = th;
                    closeable = a;
                    Util.m25366a(closeable);
                    throw bufferedSink;
                }
            } catch (Throwable th2) {
                bufferedSink = th2;
                Util.m25366a(closeable);
                throw bufferedSink;
            }
        }
    }

    public abstract MediaType mo5211a();

    public abstract void mo5212a(BufferedSink bufferedSink) throws IOException;

    public long mo5213b() throws IOException {
        return -1;
    }

    public static RequestBody m25321a(MediaType mediaType, String str) {
        Charset charset = Util.f23338e;
        if (mediaType != null) {
            charset = mediaType.m25308a(null);
            if (charset == null) {
                charset = Util.f23338e;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(mediaType);
                stringBuilder.append("; charset=utf-8");
                mediaType = MediaType.m25307a(stringBuilder.toString());
            }
        }
        return m25322a(mediaType, str.getBytes(charset));
    }

    public static RequestBody m25322a(MediaType mediaType, byte[] bArr) {
        int length = bArr.length;
        if (bArr == null) {
            throw new NullPointerException("content == null");
        }
        Util.m25365a((long) bArr.length, (long) length);
        return new C24682(mediaType, length, bArr);
    }

    public static RequestBody m25320a(MediaType mediaType, File file) {
        if (file != null) {
            return new C24693(mediaType, file);
        }
        throw new NullPointerException("content == null");
    }
}
