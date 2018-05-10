package org.jsoup;

import java.io.IOException;

public class UnsupportedMimeTypeException extends IOException {
    private String f26958a;
    private String f26959b;

    public UnsupportedMimeTypeException(String str, String str2, String str3) {
        super(str);
        this.f26958a = str2;
        this.f26959b = str3;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append(". Mimetype=");
        stringBuilder.append(this.f26958a);
        stringBuilder.append(", URL=");
        stringBuilder.append(this.f26959b);
        return stringBuilder.toString();
    }
}
