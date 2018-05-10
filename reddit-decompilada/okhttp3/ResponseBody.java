package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;

public abstract class ResponseBody implements Closeable {
    private Reader reader;

    static final class BomAwareReader extends Reader {
        private final Charset charset;
        private boolean closed;
        private Reader delegate;
        private final BufferedSource source;

        BomAwareReader(BufferedSource bufferedSource, Charset charset) {
            this.source = bufferedSource;
            this.charset = charset;
        }

        public final int read(char[] cArr, int i, int i2) throws IOException {
            if (this.closed) {
                throw new IOException("Stream closed");
            }
            Reader reader = this.delegate;
            if (reader == null) {
                Reader inputStreamReader = new InputStreamReader(this.source.mo6770e(), Util.bomAwareCharset(this.source, this.charset));
                this.delegate = inputStreamReader;
                reader = inputStreamReader;
            }
            return reader.read(cArr, i, i2);
        }

        public final void close() throws IOException {
            this.closed = true;
            if (this.delegate != null) {
                this.delegate.close();
            } else {
                this.source.close();
            }
        }
    }

    class C26101 extends ResponseBody {
        final /* synthetic */ BufferedSource val$content;
        final /* synthetic */ long val$contentLength;
        final /* synthetic */ MediaType val$contentType;

        C26101(MediaType mediaType, long j, BufferedSource bufferedSource) {
            this.val$contentType = mediaType;
            this.val$contentLength = j;
            this.val$content = bufferedSource;
        }

        public final MediaType contentType() {
            return this.val$contentType;
        }

        public final long contentLength() {
            return this.val$contentLength;
        }

        public final BufferedSource source() {
            return this.val$content;
        }
    }

    public abstract long contentLength();

    public abstract MediaType contentType();

    public abstract BufferedSource source();

    public final InputStream byteStream() {
        return source().mo6770e();
    }

    public final byte[] bytes() throws IOException {
        long contentLength = contentLength();
        if (contentLength > 2147483647L) {
            StringBuilder stringBuilder = new StringBuilder("Cannot buffer entire body for content length: ");
            stringBuilder.append(contentLength);
            throw new IOException(stringBuilder.toString());
        }
        Closeable source = source();
        try {
            byte[] s = source.mo6789s();
            if (contentLength == -1 || contentLength == ((long) s.length)) {
                return s;
            }
            StringBuilder stringBuilder2 = new StringBuilder("Content-Length (");
            stringBuilder2.append(contentLength);
            stringBuilder2.append(") and stream length (");
            stringBuilder2.append(s.length);
            stringBuilder2.append(") disagree");
            throw new IOException(stringBuilder2.toString());
        } finally {
            Util.closeQuietly(source);
        }
    }

    public final Reader charStream() {
        Reader reader = this.reader;
        if (reader != null) {
            return reader;
        }
        reader = new BomAwareReader(source(), charset());
        this.reader = reader;
        return reader;
    }

    public final String string() throws IOException {
        Closeable source = source();
        try {
            String a = source.mo6753a(Util.bomAwareCharset(source, charset()));
            return a;
        } finally {
            Util.closeQuietly(source);
        }
    }

    private Charset charset() {
        MediaType contentType = contentType();
        return contentType != null ? contentType.charset(Util.UTF_8) : Util.UTF_8;
    }

    public void close() {
        Util.closeQuietly(source());
    }

    public static ResponseBody create(MediaType mediaType, String str) {
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
        str = new Buffer().m36484a(str, 0, str.length(), charset);
        return create(mediaType, str.f36201b, str);
    }

    public static ResponseBody create(MediaType mediaType, byte[] bArr) {
        return create(mediaType, (long) bArr.length, new Buffer().m36494b(bArr));
    }

    public static ResponseBody create(MediaType mediaType, long j, BufferedSource bufferedSource) {
        if (bufferedSource != null) {
            return new C26101(mediaType, j, bufferedSource);
        }
        throw new NullPointerException("source == null");
    }
}
