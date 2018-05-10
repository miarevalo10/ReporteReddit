package com.squareup.moshi;

public final class JsonDataException extends RuntimeException {
    public JsonDataException(String str) {
        super(str);
    }

    public JsonDataException(String str, Throwable th) {
        super(str, th);
    }
}
