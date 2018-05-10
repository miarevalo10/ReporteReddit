package com.danikula.videocache;

public class ProxyCacheException extends Exception {
    public ProxyCacheException(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(". Version: 2.7.0");
        super(stringBuilder.toString());
    }

    public ProxyCacheException(String str, Throwable th) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(". Version: 2.7.0");
        super(stringBuilder.toString(), th);
    }
}
