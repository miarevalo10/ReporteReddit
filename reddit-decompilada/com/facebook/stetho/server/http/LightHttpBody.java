package com.facebook.stetho.server.http;

import java.io.IOException;
import java.io.OutputStream;

public abstract class LightHttpBody {
    public abstract int contentLength();

    public abstract String contentType();

    public abstract void writeTo(OutputStream outputStream) throws IOException;

    public static LightHttpBody create(String str, String str2) {
        try {
            return create(str.getBytes("UTF-8"), str2);
        } catch (String str3) {
            throw new RuntimeException(str3);
        }
    }

    public static LightHttpBody create(final byte[] bArr, final String str) {
        return new LightHttpBody() {
            public final String contentType() {
                return str;
            }

            public final int contentLength() {
                return bArr.length;
            }

            public final void writeTo(OutputStream outputStream) throws IOException {
                outputStream.write(bArr);
            }
        };
    }
}
