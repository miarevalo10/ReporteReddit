package com.sendbird.android.shadow.okhttp3;

import com.sendbird.android.shadow.okhttp3.internal.http.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.List;

public final class Request {
    final RequestBody body;
    private volatile CacheControl cacheControl;
    final Headers headers;
    final String method;
    final Object tag;
    final HttpUrl url;

    public static class Builder {
        HttpUrl f23291a;
        String f23292b;
        com.sendbird.android.shadow.okhttp3.Headers.Builder f23293c;
        RequestBody f23294d;
        public Object f23295e;

        public Builder() {
            this.f23292b = HttpRequest.METHOD_GET;
            this.f23293c = new com.sendbird.android.shadow.okhttp3.Headers.Builder();
        }

        Builder(Request request) {
            this.f23291a = request.url;
            this.f23292b = request.method;
            this.f23294d = request.body;
            this.f23295e = request.tag;
            this.f23293c = request.headers.m25267a();
        }

        public final Builder m25314a(HttpUrl httpUrl) {
            if (httpUrl == null) {
                throw new NullPointerException("url == null");
            }
            this.f23291a = httpUrl;
            return this;
        }

        public final Builder m25315a(String str) {
            if (str == null) {
                throw new NullPointerException("url == null");
            }
            StringBuilder stringBuilder;
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                stringBuilder = new StringBuilder("http:");
                stringBuilder.append(str.substring(3));
                str = stringBuilder.toString();
            } else {
                if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                    stringBuilder = new StringBuilder("https:");
                    stringBuilder.append(str.substring(4));
                    str = stringBuilder.toString();
                }
            }
            HttpUrl d = HttpUrl.m25290d(str);
            if (d != null) {
                return m25314a(d);
            }
            StringBuilder stringBuilder2 = new StringBuilder("unexpected url: ");
            stringBuilder2.append(str);
            throw new IllegalArgumentException(stringBuilder2.toString());
        }

        public final Builder m25317a(String str, String str2) {
            com.sendbird.android.shadow.okhttp3.Headers.Builder builder = this.f23293c;
            com.sendbird.android.shadow.okhttp3.Headers.Builder.m25259c(str, str2);
            builder.m25263b(str);
            builder.m25264b(str, str2);
            return this;
        }

        public final Builder m25319b(String str) {
            this.f23293c.m25263b(str);
            return this;
        }

        public final Builder m25313a(Headers headers) {
            this.f23293c = headers.m25267a();
            return this;
        }

        public final Builder m25316a(String str, RequestBody requestBody) {
            if (str == null) {
                throw new NullPointerException("method == null");
            } else if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            } else if (requestBody != null && !HttpMethod.m25438c(str)) {
                r0 = new StringBuilder("method ");
                r0.append(str);
                r0.append(" must not have a request body.");
                throw new IllegalArgumentException(r0.toString());
            } else if (requestBody == null && HttpMethod.m25437b(str)) {
                r0 = new StringBuilder("method ");
                r0.append(str);
                r0.append(" must have a request body.");
                throw new IllegalArgumentException(r0.toString());
            } else {
                this.f23292b = str;
                this.f23294d = requestBody;
                return this;
            }
        }

        public final Request m25318a() {
            if (this.f23291a != null) {
                return new Request(this);
            }
            throw new IllegalStateException("url == null");
        }
    }

    Request(Builder builder) {
        this.url = builder.f23291a;
        this.method = builder.f23292b;
        this.headers = builder.f23293c.m25262a();
        this.body = builder.f23294d;
        this.tag = builder.f23295e != null ? builder.f23295e : this;
    }

    public final HttpUrl url() {
        return this.url;
    }

    public final String method() {
        return this.method;
    }

    public final Headers headers() {
        return this.headers;
    }

    public final String header(String str) {
        return this.headers.m25269a(str);
    }

    public final List<String> headers(String str) {
        return this.headers.m25271b(str);
    }

    public final RequestBody body() {
        return this.body;
    }

    public final Object tag() {
        return this.tag;
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    public final CacheControl cacheControl() {
        CacheControl cacheControl = this.cacheControl;
        if (cacheControl != null) {
            return cacheControl;
        }
        cacheControl = CacheControl.m25200a(this.headers);
        this.cacheControl = cacheControl;
        return cacheControl;
    }

    public final boolean isHttps() {
        return this.url.m25293b();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Request{method=");
        stringBuilder.append(this.method);
        stringBuilder.append(", url=");
        stringBuilder.append(this.url);
        stringBuilder.append(", tag=");
        stringBuilder.append(this.tag != this ? this.tag : null);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
