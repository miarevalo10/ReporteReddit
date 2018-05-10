package com.sendbird.android.shadow.okhttp3.internal.http;

import com.sendbird.android.shadow.okhttp3.HttpUrl;
import com.sendbird.android.shadow.okhttp3.Request;
import java.net.Proxy.Type;

public final class RequestLine {
    public static String m25442a(Request request, Type type) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(request.method());
        stringBuilder.append(' ');
        type = (request.isHttps() || type != Type.HTTP) ? null : true;
        if (type != null) {
            stringBuilder.append(request.url());
        } else {
            stringBuilder.append(m25441a(request.url()));
        }
        stringBuilder.append(" HTTP/1.1");
        return stringBuilder.toString();
    }

    public static String m25441a(HttpUrl httpUrl) {
        String e = httpUrl.m25297e();
        httpUrl = httpUrl.m25299g();
        if (httpUrl == null) {
            return e;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(e);
        stringBuilder.append('?');
        stringBuilder.append(httpUrl);
        return stringBuilder.toString();
    }
}
