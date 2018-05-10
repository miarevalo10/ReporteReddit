package com.danikula.videocache;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.Closeable;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProxyCacheUtils {
    private static final Logger f3770a = LoggerFactory.a("ProxyCacheUtils");

    static String m3343a(String str) {
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        str = MimeTypeMap.getFileExtensionFromUrl(str);
        return TextUtils.isEmpty(str) ? null : singleton.getMimeTypeFromExtension(str);
    }

    static void m3345a(byte[] bArr, long j) {
        Preconditions.m3331a((Object) bArr, "Buffer must be not null!");
        boolean z = false;
        Preconditions.m3333a(j >= 0 ? 1 : 0, "Data offset must be positive!");
        if (8192 <= bArr.length) {
            z = true;
        }
        Preconditions.m3333a(z, "Length must be in range [0..buffer.length]");
    }

    static String m3346b(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (String str2) {
            throw new RuntimeException("Error encoding url", str2);
        }
    }

    static String m3347c(String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (String str2) {
            throw new RuntimeException("Error decoding url", str2);
        }
    }

    static void m3344a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Closeable closeable2) {
                f3770a.a("Error closing resource", closeable2);
            }
        }
    }

    public static String m3348d(String str) {
        try {
            str = MessageDigest.getInstance("MD5").digest(str.getBytes());
            StringBuffer stringBuffer = new StringBuffer();
            int length = str.length;
            for (int i = 0; i < length; i++) {
                stringBuffer.append(String.format("%02x", new Object[]{Byte.valueOf(str[i])}));
            }
            return stringBuffer.toString();
        } catch (String str2) {
            throw new IllegalStateException(str2);
        }
    }
}
