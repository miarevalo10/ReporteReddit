package com.google.android.gms.internal;

import android.util.JsonWriter;
import java.util.Map;

final /* synthetic */ class zzajw implements zzaka {
    private final String f14118a;
    private final String f14119b;
    private final Map f14120c;
    private final byte[] f14121d;

    zzajw(String str, String str2, Map map, byte[] bArr) {
        this.f14118a = str;
        this.f14119b = str2;
        this.f14120c = map;
        this.f14121d = bArr;
    }

    public final void mo1729a(JsonWriter jsonWriter) {
        zzajv.m5348a(this.f14118a, this.f14119b, this.f14120c, this.f14121d, jsonWriter);
    }
}
