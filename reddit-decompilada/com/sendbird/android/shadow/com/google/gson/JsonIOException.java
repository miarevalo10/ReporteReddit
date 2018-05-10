package com.sendbird.android.shadow.com.google.gson;

public final class JsonIOException extends JsonParseException {
    public JsonIOException(String str) {
        super(str);
    }

    public JsonIOException(Throwable th) {
        super(th);
    }
}
