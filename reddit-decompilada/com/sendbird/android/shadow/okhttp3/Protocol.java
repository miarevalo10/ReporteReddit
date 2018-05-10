package com.sendbird.android.shadow.okhttp3;

import java.io.IOException;

public enum Protocol {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");
    
    private final String f23290e;

    private Protocol(String str) {
        this.f23290e = str;
    }

    public static Protocol m25312a(String str) throws IOException {
        if (str.equals(HTTP_1_0.f23290e)) {
            return HTTP_1_0;
        }
        if (str.equals(HTTP_1_1.f23290e)) {
            return HTTP_1_1;
        }
        if (str.equals(HTTP_2.f23290e)) {
            return HTTP_2;
        }
        if (str.equals(SPDY_3.f23290e)) {
            return SPDY_3;
        }
        StringBuilder stringBuilder = new StringBuilder("Unexpected protocol: ");
        stringBuilder.append(str);
        throw new IOException(stringBuilder.toString());
    }

    public final String toString() {
        return this.f23290e;
    }
}
