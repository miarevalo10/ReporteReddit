package okhttp3;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.ByteString;
import okio.Okio;

public abstract class RequestBody {

    class C26071 extends RequestBody {
        final /* synthetic */ ByteString val$content;
        final /* synthetic */ MediaType val$contentType;

        C26071(MediaType mediaType, ByteString byteString) {
            this.val$contentType = mediaType;
            this.val$content = byteString;
        }

        public final MediaType contentType() {
            return this.val$contentType;
        }

        public final long contentLength() throws IOException {
            return (long) this.val$content.mo6166h();
        }

        public final void writeTo(BufferedSink bufferedSink) throws IOException {
            bufferedSink.mo6767d(this.val$content);
        }
    }

    class C26082 extends RequestBody {
        final /* synthetic */ int val$byteCount;
        final /* synthetic */ byte[] val$content;
        final /* synthetic */ MediaType val$contentType;
        final /* synthetic */ int val$offset;

        C26082(MediaType mediaType, int i, byte[] bArr, int i2) {
            this.val$contentType = mediaType;
            this.val$byteCount = i;
            this.val$content = bArr;
            this.val$offset = i2;
        }

        public final MediaType contentType() {
            return this.val$contentType;
        }

        public final long contentLength() {
            return (long) this.val$byteCount;
        }

        public final void writeTo(BufferedSink bufferedSink) throws IOException {
            bufferedSink.mo6765c(this.val$content, this.val$offset, this.val$byteCount);
        }
    }

    class C26093 extends RequestBody {
        final /* synthetic */ MediaType val$contentType;
        final /* synthetic */ File val$file;

        C26093(MediaType mediaType, File file) {
            this.val$contentType = mediaType;
            this.val$file = file;
        }

        public final MediaType contentType() {
            return this.val$contentType;
        }

        public final long contentLength() {
            return this.val$file.length();
        }

        public final void writeTo(BufferedSink bufferedSink) throws IOException {
            Closeable closeable = null;
            try {
                Closeable a = Okio.m28294a(this.val$file);
                try {
                    bufferedSink.mo6752a(a);
                    Util.closeQuietly(a);
                } catch (Throwable th) {
                    bufferedSink = th;
                    closeable = a;
                    Util.closeQuietly(closeable);
                    throw bufferedSink;
                }
            } catch (Throwable th2) {
                bufferedSink = th2;
                Util.closeQuietly(closeable);
                throw bufferedSink;
            }
        }
    }

    public long contentLength() throws IOException {
        return -1;
    }

    public abstract MediaType contentType();

    public abstract void writeTo(BufferedSink bufferedSink) throws IOException;

    public static RequestBody create(MediaType mediaType, String str) {
        Charset charset = Util.UTF_8;
        if (mediaType != null) {
            charset = mediaType.charset();
            if (charset == null) {
                charset = Util.UTF_8;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(mediaType);
                stringBuilder.append("; charset=utf-8");
                mediaType = MediaType.parse(stringBuilder.toString());
            }
        }
        return create(mediaType, str.getBytes(charset));
    }

    public static RequestBody create(MediaType mediaType, ByteString byteString) {
        return new C26071(mediaType, byteString);
    }

    public static RequestBody create(MediaType mediaType, byte[] bArr) {
        return create(mediaType, bArr, 0, bArr.length);
    }

    public static RequestBody create(MediaType mediaType, byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("content == null");
        }
        Util.checkOffsetAndCount((long) bArr.length, (long) i, (long) i2);
        return new C26082(mediaType, i2, bArr, i);
    }

    public static RequestBody create(MediaType mediaType, File file) {
        if (file != null) {
            return new C26093(mediaType, file);
        }
        throw new NullPointerException("content == null");
    }
}
