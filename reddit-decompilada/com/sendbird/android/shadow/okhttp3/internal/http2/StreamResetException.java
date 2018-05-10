package com.sendbird.android.shadow.okhttp3.internal.http2;

import java.io.IOException;

public final class StreamResetException extends IOException {
    public final ErrorCode f23537a;

    public StreamResetException(ErrorCode errorCode) {
        StringBuilder stringBuilder = new StringBuilder("stream was reset: ");
        stringBuilder.append(errorCode);
        super(stringBuilder.toString());
        this.f23537a = errorCode;
    }
}
