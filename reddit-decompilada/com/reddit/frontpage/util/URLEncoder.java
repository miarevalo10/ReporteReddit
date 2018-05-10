package com.reddit.frontpage.util;

import com.reddit.frontpage.libcore.net.UriCodec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class URLEncoder {
    static final UriCodec f21806a = new C23851();

    static class C23851 extends UriCodec {
        C23851() {
        }

        protected final boolean mo5045a(char c) {
            return " .-_".indexOf(c) != '￿';
        }
    }

    public static String m23942a(String str, String str2) throws UnsupportedEncodingException {
        UriCodec uriCodec = f21806a;
        Charset forName = Charset.forName(str2);
        StringBuilder stringBuilder = new StringBuilder(str.length());
        uriCodec.m22534a(stringBuilder, str, forName);
        return stringBuilder.toString();
    }
}
