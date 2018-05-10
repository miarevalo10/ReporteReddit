package okhttp3;

import com.facebook.stetho.dumpapp.Framer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

public final class MultipartBody extends RequestBody {
    public static final MediaType ALTERNATIVE = MediaType.parse("multipart/alternative");
    private static final byte[] COLONSPACE = new byte[]{(byte) 58, (byte) 32};
    private static final byte[] CRLF = new byte[]{(byte) 13, (byte) 10};
    private static final byte[] DASHDASH = new byte[]{Framer.STDIN_FRAME_PREFIX, Framer.STDIN_FRAME_PREFIX};
    public static final MediaType DIGEST = MediaType.parse("multipart/digest");
    public static final MediaType FORM = MediaType.parse("multipart/form-data");
    public static final MediaType MIXED = MediaType.parse("multipart/mixed");
    public static final MediaType PARALLEL = MediaType.parse("multipart/parallel");
    private final ByteString boundary;
    private long contentLength = -1;
    private final MediaType contentType;
    private final MediaType originalType;
    private final List<Part> parts;

    public static final class Builder {
        private final ByteString boundary;
        private final List<Part> parts;
        private MediaType type;

        public Builder() {
            this(UUID.randomUUID().toString());
        }

        public Builder(String str) {
            this.type = MultipartBody.MIXED;
            this.parts = new ArrayList();
            this.boundary = ByteString.m28267a(str);
        }

        public final Builder setType(MediaType mediaType) {
            if (mediaType == null) {
                throw new NullPointerException("type == null");
            } else if (mediaType.type().equals("multipart")) {
                this.type = mediaType;
                return this;
            } else {
                StringBuilder stringBuilder = new StringBuilder("multipart != ");
                stringBuilder.append(mediaType);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }

        public final Builder addPart(RequestBody requestBody) {
            return addPart(Part.create(requestBody));
        }

        public final Builder addPart(Headers headers, RequestBody requestBody) {
            return addPart(Part.create(headers, requestBody));
        }

        public final Builder addFormDataPart(String str, String str2) {
            return addPart(Part.createFormData(str, str2));
        }

        public final Builder addFormDataPart(String str, String str2, RequestBody requestBody) {
            return addPart(Part.createFormData(str, str2, requestBody));
        }

        public final Builder addPart(Part part) {
            if (part == null) {
                throw new NullPointerException("part == null");
            }
            this.parts.add(part);
            return this;
        }

        public final MultipartBody build() {
            if (!this.parts.isEmpty()) {
                return new MultipartBody(this.boundary, this.type, this.parts);
            }
            throw new IllegalStateException("Multipart body must have at least one part.");
        }
    }

    public static final class Part {
        final RequestBody body;
        final Headers headers;

        public static Part create(RequestBody requestBody) {
            return create(null, requestBody);
        }

        public static Part create(Headers headers, RequestBody requestBody) {
            if (requestBody == null) {
                throw new NullPointerException("body == null");
            } else if (headers != null && headers.get("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            } else if (headers == null || headers.get("Content-Length") == null) {
                return new Part(headers, requestBody);
            } else {
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }
        }

        public static Part createFormData(String str, String str2) {
            return createFormData(str, null, RequestBody.create(null, str2));
        }

        public static Part createFormData(String str, String str2, RequestBody requestBody) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            StringBuilder stringBuilder = new StringBuilder("form-data; name=");
            MultipartBody.appendQuotedString(stringBuilder, str);
            if (str2 != null) {
                stringBuilder.append("; filename=");
                MultipartBody.appendQuotedString(stringBuilder, str2);
            }
            return create(Headers.of("Content-Disposition", stringBuilder.toString()), requestBody);
        }

        private Part(Headers headers, RequestBody requestBody) {
            this.headers = headers;
            this.body = requestBody;
        }

        public final Headers headers() {
            return this.headers;
        }

        public final RequestBody body() {
            return this.body;
        }
    }

    MultipartBody(ByteString byteString, MediaType mediaType, List<Part> list) {
        this.boundary = byteString;
        this.originalType = mediaType;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(mediaType);
        stringBuilder.append("; boundary=");
        stringBuilder.append(byteString.mo6154a());
        this.contentType = MediaType.parse(stringBuilder.toString());
        this.parts = Util.immutableList((List) list);
    }

    public final MediaType type() {
        return this.originalType;
    }

    public final String boundary() {
        return this.boundary.mo6154a();
    }

    public final int size() {
        return this.parts.size();
    }

    public final List<Part> parts() {
        return this.parts;
    }

    public final Part part(int i) {
        return (Part) this.parts.get(i);
    }

    public final MediaType contentType() {
        return this.contentType;
    }

    public final long contentLength() throws IOException {
        long j = this.contentLength;
        if (j != -1) {
            return j;
        }
        j = writeOrCountBytes(null, true);
        this.contentLength = j;
        return j;
    }

    public final void writeTo(BufferedSink bufferedSink) throws IOException {
        writeOrCountBytes(bufferedSink, false);
    }

    private long writeOrCountBytes(BufferedSink bufferedSink, boolean z) throws IOException {
        Buffer buffer;
        if (z) {
            bufferedSink = new Buffer();
            buffer = bufferedSink;
        } else {
            buffer = null;
        }
        int size = this.parts.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            Part part = (Part) this.parts.get(i);
            Headers headers = part.headers;
            RequestBody requestBody = part.body;
            bufferedSink.mo6764c(DASHDASH);
            bufferedSink.mo6767d(this.boundary);
            bufferedSink.mo6764c(CRLF);
            if (headers != null) {
                int size2 = headers.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    bufferedSink.mo6760b(headers.name(i2)).mo6764c(COLONSPACE).mo6760b(headers.value(i2)).mo6764c(CRLF);
                }
            }
            MediaType contentType = requestBody.contentType();
            if (contentType != null) {
                bufferedSink.mo6760b("Content-Type: ").mo6760b(contentType.toString()).mo6764c(CRLF);
            }
            long contentLength = requestBody.contentLength();
            if (contentLength != -1) {
                bufferedSink.mo6760b("Content-Length: ").mo6786n(contentLength).mo6764c(CRLF);
            } else if (z) {
                buffer.m36539t();
                return -1;
            }
            bufferedSink.mo6764c(CRLF);
            if (z) {
                j += contentLength;
            } else {
                requestBody.writeTo(bufferedSink);
            }
            bufferedSink.mo6764c(CRLF);
        }
        bufferedSink.mo6764c(DASHDASH);
        bufferedSink.mo6767d(this.boundary);
        bufferedSink.mo6764c(DASHDASH);
        bufferedSink.mo6764c(CRLF);
        if (z) {
            j += buffer.f36201b;
            buffer.m36539t();
        }
        return j;
    }

    static StringBuilder appendQuotedString(StringBuilder stringBuilder, String str) {
        stringBuilder.append('\"');
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '\n') {
                stringBuilder.append("%0A");
            } else if (charAt == '\r') {
                stringBuilder.append("%0D");
            } else if (charAt != '\"') {
                stringBuilder.append(charAt);
            } else {
                stringBuilder.append("%22");
            }
        }
        stringBuilder.append('\"');
        return stringBuilder;
    }
}
