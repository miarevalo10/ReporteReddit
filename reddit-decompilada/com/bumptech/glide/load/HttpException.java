package com.bumptech.glide.load;

import java.io.IOException;

public final class HttpException extends IOException {
    private final int f3324a;

    public HttpException(int i) {
        StringBuilder stringBuilder = new StringBuilder("Http request failed with status code: ");
        stringBuilder.append(i);
        this(stringBuilder.toString(), i);
    }

    public HttpException(String str) {
        this(str, -1);
    }

    public HttpException(String str, int i) {
        this(str, i, (byte) 0);
    }

    private HttpException(String str, int i, byte b) {
        super(str, (byte) 0);
        this.f3324a = i;
    }
}
