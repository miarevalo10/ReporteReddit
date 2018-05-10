package com.sendbird.android.shadow.okhttp3.internal.http;

import com.sendbird.android.shadow.okhttp3.MediaType;
import com.sendbird.android.shadow.okhttp3.ResponseBody;
import com.sendbird.android.shadow.okio.BufferedSource;

public final class RealResponseBody extends ResponseBody {
    private final String f30419a;
    private final long f30420b;
    private final BufferedSource f30421c;

    public RealResponseBody(String str, long j, BufferedSource bufferedSource) {
        this.f30419a = str;
        this.f30420b = j;
        this.f30421c = bufferedSource;
    }

    public final MediaType mo5296a() {
        return this.f30419a != null ? MediaType.m25307a(this.f30419a) : null;
    }

    public final long mo5297b() {
        return this.f30420b;
    }

    public final BufferedSource mo5298c() {
        return this.f30421c;
    }
}
