package retrofit2;

import java.io.IOException;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.HttpUrl.Builder;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;

final class RequestBuilder {
    private static final char[] f41214k = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    final String f41215a;
    final HttpUrl f41216b;
    String f41217c;
    Builder f41218d;
    final Request.Builder f41219e = new Request.Builder();
    MediaType f41220f;
    final boolean f41221g;
    MultipartBody.Builder f41222h;
    FormBody.Builder f41223i;
    RequestBody f41224j;

    private static class ContentTypeOverridingRequestBody extends RequestBody {
        private final RequestBody f41624a;
        private final MediaType f41625b;

        ContentTypeOverridingRequestBody(RequestBody requestBody, MediaType mediaType) {
            this.f41624a = requestBody;
            this.f41625b = mediaType;
        }

        public MediaType contentType() {
            return this.f41625b;
        }

        public long contentLength() throws IOException {
            return this.f41624a.contentLength();
        }

        public void writeTo(BufferedSink bufferedSink) throws IOException {
            this.f41624a.writeTo(bufferedSink);
        }
    }

    RequestBuilder(String str, HttpUrl httpUrl, String str2, Headers headers, MediaType mediaType, boolean z, boolean z2, boolean z3) {
        this.f41215a = str;
        this.f41216b = httpUrl;
        this.f41217c = str2;
        this.f41220f = mediaType;
        this.f41221g = z;
        if (headers != null) {
            this.f41219e.headers(headers);
        }
        if (z2) {
            this.f41223i = new FormBody.Builder();
            return;
        }
        if (z3) {
            this.f41222h = new MultipartBody.Builder();
            this.f41222h.setType(MultipartBody.FORM);
        }
    }

    final void m43313a(String str, String str2) {
        if ("Content-Type".equalsIgnoreCase(str)) {
            str = MediaType.parse(str2);
            if (str == null) {
                StringBuilder stringBuilder = new StringBuilder("Malformed content type: ");
                stringBuilder.append(str2);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            this.f41220f = str;
            return;
        }
        this.f41219e.addHeader(str, str2);
    }

    static String m43312a(String str, boolean z) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt >= 32 && codePointAt < 127 && " \"<>^`{}|\\?#".indexOf(codePointAt) == -1) {
                if (!z) {
                    if (codePointAt != 47) {
                        if (codePointAt == 37) {
                        }
                    }
                }
                i += Character.charCount(codePointAt);
            }
            Buffer buffer = new Buffer();
            buffer.a(str, 0, i);
            Buffer buffer2 = null;
            while (i < length) {
                int codePointAt2 = str.codePointAt(i);
                if (!(z && (codePointAt2 == 9 || codePointAt2 == 10 || codePointAt2 == 12 || codePointAt2 == 13))) {
                    if (codePointAt2 >= 32 && codePointAt2 < 127 && " \"<>^`{}|\\?#".indexOf(codePointAt2) == -1) {
                        if (!z) {
                            if (codePointAt2 != 47) {
                                if (codePointAt2 == 37) {
                                }
                            }
                        }
                        buffer.a(codePointAt2);
                    }
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    buffer2.a(codePointAt2);
                    while (!buffer2.d()) {
                        int g = buffer2.g() & 255;
                        buffer.b(37);
                        buffer.b(f41214k[(g >> 4) & 15]);
                        buffer.b(f41214k[g & 15]);
                    }
                }
                i += Character.charCount(codePointAt2);
            }
            return buffer.p();
        }
        return str;
    }

    final void m43314a(String str, String str2, boolean z) {
        if (this.f41217c != null) {
            this.f41218d = this.f41216b.newBuilder(this.f41217c);
            if (this.f41218d == null) {
                str2 = new StringBuilder("Malformed URL. Base: ");
                str2.append(this.f41216b);
                str2.append(", Relative: ");
                str2.append(this.f41217c);
                throw new IllegalArgumentException(str2.toString());
            }
            this.f41217c = null;
        }
        if (z) {
            this.f41218d.addEncodedQueryParameter(str, str2);
        } else {
            this.f41218d.addQueryParameter(str, str2);
        }
    }

    final void m43316b(String str, String str2, boolean z) {
        if (z) {
            this.f41223i.addEncoded(str, str2);
        } else {
            this.f41223i.add(str, str2);
        }
    }

    final void m43315a(Headers headers, RequestBody requestBody) {
        this.f41222h.addPart(headers, requestBody);
    }
}
