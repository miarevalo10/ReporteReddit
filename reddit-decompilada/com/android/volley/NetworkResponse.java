package com.android.volley;

import com.facebook.stetho.server.http.HttpStatus;
import java.io.Serializable;
import java.util.Map;

public class NetworkResponse implements Serializable {
    public final int f2777a;
    public final byte[] f2778b;
    public final Map<String, String> f2779c;
    public final boolean f2780d;
    public final long f2781e;

    public NetworkResponse(int i, byte[] bArr, Map<String, String> map, boolean z, long j) {
        this.f2777a = i;
        this.f2778b = bArr;
        this.f2779c = map;
        this.f2780d = z;
        this.f2781e = j;
    }

    public NetworkResponse(byte[] bArr, Map<String, String> map) {
        this(HttpStatus.HTTP_OK, bArr, map, false, 0);
    }
}
