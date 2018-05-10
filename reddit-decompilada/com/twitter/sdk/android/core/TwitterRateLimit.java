package com.twitter.sdk.android.core;

import okhttp3.Headers;

public class TwitterRateLimit {
    private int f23928a;
    private int f23929b;
    private long f23930c;

    TwitterRateLimit(Headers headers) {
        if (headers == null) {
            throw new IllegalArgumentException("headers must not be null");
        }
        for (int i = 0; i < headers.size(); i++) {
            if ("x-rate-limit-limit".equals(headers.name(i))) {
                this.f23928a = Integer.valueOf(headers.value(i)).intValue();
            } else if ("x-rate-limit-remaining".equals(headers.name(i))) {
                this.f23929b = Integer.valueOf(headers.value(i)).intValue();
            } else if ("x-rate-limit-reset".equals(headers.name(i))) {
                this.f23930c = Long.valueOf(headers.value(i)).longValue();
            }
        }
    }
}
