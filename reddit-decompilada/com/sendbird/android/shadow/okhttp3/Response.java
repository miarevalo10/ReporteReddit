package com.sendbird.android.shadow.okhttp3;

import java.io.Closeable;

public final class Response implements Closeable {
    public final Request f23308a;
    final Protocol f23309b;
    public final int f23310c;
    public final String f23311d;
    public final Handshake f23312e;
    public final Headers f23313f;
    public final ResponseBody f23314g;
    public final Response f23315h;
    final Response f23316i;
    public final Response f23317j;
    public final long f23318k;
    public final long f23319l;
    private volatile CacheControl f23320m;

    public static class Builder {
        public Request f23296a;
        public Protocol f23297b;
        public int f23298c;
        public String f23299d;
        public Handshake f23300e;
        com.sendbird.android.shadow.okhttp3.Headers.Builder f23301f;
        public ResponseBody f23302g;
        Response f23303h;
        Response f23304i;
        public Response f23305j;
        public long f23306k;
        public long f23307l;

        public Builder() {
            this.f23298c = -1;
            this.f23301f = new com.sendbird.android.shadow.okhttp3.Headers.Builder();
        }

        Builder(Response response) {
            this.f23298c = -1;
            this.f23296a = response.f23308a;
            this.f23297b = response.f23309b;
            this.f23298c = response.f23310c;
            this.f23299d = response.f23311d;
            this.f23300e = response.f23312e;
            this.f23301f = response.f23313f.m25267a();
            this.f23302g = response.f23314g;
            this.f23303h = response.f23315h;
            this.f23304i = response.f23316i;
            this.f23305j = response.f23317j;
            this.f23306k = response.f23318k;
            this.f23307l = response.f23319l;
        }

        public final Builder m25329a(String str, String str2) {
            this.f23301f.m25261a(str, str2);
            return this;
        }

        public final Builder m25327a(Headers headers) {
            this.f23301f = headers.m25267a();
            return this;
        }

        public final Builder m25328a(Response response) {
            if (response != null) {
                m25326a("networkResponse", response);
            }
            this.f23303h = response;
            return this;
        }

        public final Builder m25331b(Response response) {
            if (response != null) {
                m25326a("cacheResponse", response);
            }
            this.f23304i = response;
            return this;
        }

        private static void m25326a(String str, Response response) {
            StringBuilder stringBuilder;
            if (response.f23314g != null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(".body != null");
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (response.f23315h != null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(".networkResponse != null");
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (response.f23316i != null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(".cacheResponse != null");
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (response.f23317j != null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(".priorResponse != null");
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }

        public final Response m25330a() {
            if (this.f23296a == null) {
                throw new IllegalStateException("request == null");
            } else if (this.f23297b == null) {
                throw new IllegalStateException("protocol == null");
            } else if (this.f23298c < 0) {
                StringBuilder stringBuilder = new StringBuilder("code < 0: ");
                stringBuilder.append(this.f23298c);
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f23299d != null) {
                return new Response(this);
            } else {
                throw new IllegalStateException("message == null");
            }
        }
    }

    Response(Builder builder) {
        this.f23308a = builder.f23296a;
        this.f23309b = builder.f23297b;
        this.f23310c = builder.f23298c;
        this.f23311d = builder.f23299d;
        this.f23312e = builder.f23300e;
        this.f23313f = builder.f23301f.m25262a();
        this.f23314g = builder.f23302g;
        this.f23315h = builder.f23303h;
        this.f23316i = builder.f23304i;
        this.f23317j = builder.f23305j;
        this.f23318k = builder.f23306k;
        this.f23319l = builder.f23307l;
    }

    public final Builder m25332a() {
        return new Builder(this);
    }

    public final CacheControl m25334b() {
        CacheControl cacheControl = this.f23320m;
        if (cacheControl != null) {
            return cacheControl;
        }
        cacheControl = CacheControl.m25200a(this.f23313f);
        this.f23320m = cacheControl;
        return cacheControl;
    }

    public final void close() {
        if (this.f23314g == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        this.f23314g.close();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Response{protocol=");
        stringBuilder.append(this.f23309b);
        stringBuilder.append(", code=");
        stringBuilder.append(this.f23310c);
        stringBuilder.append(", message=");
        stringBuilder.append(this.f23311d);
        stringBuilder.append(", url=");
        stringBuilder.append(this.f23308a.url());
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public final String m25333a(String str) {
        str = this.f23313f.m25269a(str);
        return str != null ? str : null;
    }
}
