package com.sendbird.android.shadow.okhttp3.internal.http;

import io.fabric.sdk.android.services.network.HttpRequest;

public final class HttpMethod {
    public static boolean m25436a(String str) {
        if (!(str.equals(HttpRequest.METHOD_POST) || str.equals("PATCH") || str.equals(HttpRequest.METHOD_PUT) || str.equals("DELETE"))) {
            if (str.equals("MOVE") == null) {
                return null;
            }
        }
        return true;
    }

    public static boolean m25437b(String str) {
        if (!(str.equals(HttpRequest.METHOD_POST) || str.equals(HttpRequest.METHOD_PUT) || str.equals("PATCH") || str.equals("PROPPATCH"))) {
            if (str.equals("REPORT") == null) {
                return null;
            }
        }
        return true;
    }

    public static boolean m25438c(String str) {
        if (!(m25437b(str) || str.equals(HttpRequest.METHOD_OPTIONS) || str.equals("DELETE") || str.equals("PROPFIND") || str.equals("MKCOL"))) {
            if (str.equals("LOCK") == null) {
                return null;
            }
        }
        return true;
    }

    public static boolean m25439d(String str) {
        return str.equals("PROPFIND");
    }

    public static boolean m25440e(String str) {
        return str.equals("PROPFIND") == null ? true : null;
    }
}
