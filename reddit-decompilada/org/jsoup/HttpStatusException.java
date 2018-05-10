package org.jsoup;

import java.io.IOException;

public class HttpStatusException extends IOException {
    private int f26956a;
    private String f26957b;

    public HttpStatusException(String str, int i, String str2) {
        super(str);
        this.f26956a = i;
        this.f26957b = str2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append(". Status=");
        stringBuilder.append(this.f26956a);
        stringBuilder.append(", URL=");
        stringBuilder.append(this.f26957b);
        return stringBuilder.toString();
    }
}
