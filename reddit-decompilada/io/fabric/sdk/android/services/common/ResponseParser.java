package io.fabric.sdk.android.services.common;

import com.facebook.stetho.server.http.HttpStatus;

public class ResponseParser {
    public static int m26362a(int i) {
        return (i < HttpStatus.HTTP_OK || i > 299) ? (i < 300 || i > 399) ? (i < 400 || i > 499) ? i >= 500 ? 1 : 1 : 0 : 1 : 0;
    }
}
