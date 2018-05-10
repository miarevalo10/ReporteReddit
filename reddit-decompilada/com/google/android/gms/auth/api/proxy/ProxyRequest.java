package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class ProxyRequest extends zzbfm {
    public static final Creator<ProxyRequest> CREATOR = new zza();
    public static final int HTTP_METHOD_DELETE = 3;
    public static final int HTTP_METHOD_GET = 0;
    public static final int HTTP_METHOD_HEAD = 4;
    public static final int HTTP_METHOD_OPTIONS = 5;
    public static final int HTTP_METHOD_PATCH = 7;
    public static final int HTTP_METHOD_POST = 1;
    public static final int HTTP_METHOD_PUT = 2;
    public static final int HTTP_METHOD_TRACE = 6;
    public static final int LAST_CODE = 7;
    public static final int VERSION_CODE = 2;
    public final byte[] body;
    public final int httpMethod;
    public final long timeoutMillis;
    public final String url;
    private int versionCode;
    private Bundle zzegj;

    ProxyRequest(int i, String str, int i2, long j, byte[] bArr, Bundle bundle) {
        this.versionCode = i;
        this.url = str;
        this.httpMethod = i2;
        this.timeoutMillis = j;
        this.body = bArr;
        this.zzegj = bundle;
    }

    public Map<String, String> getHeaderMap() {
        Map linkedHashMap = new LinkedHashMap(this.zzegj.size());
        for (String str : this.zzegj.keySet()) {
            linkedHashMap.put(str, this.zzegj.getString(str));
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public String toString() {
        String str = this.url;
        int i = this.httpMethod;
        StringBuilder stringBuilder = new StringBuilder(42 + String.valueOf(str).length());
        stringBuilder.append("ProxyRequest[ url: ");
        stringBuilder.append(str);
        stringBuilder.append(", method: ");
        stringBuilder.append(i);
        stringBuilder.append(" ]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        i = zzbfp.m5536a(parcel);
        zzbfp.m5545a(parcel, 1, this.url);
        zzbfp.m5540a(parcel, 2, this.httpMethod);
        zzbfp.m5541a(parcel, 3, this.timeoutMillis);
        zzbfp.m5548a(parcel, 4, this.body);
        zzbfp.m5542a(parcel, 5, this.zzegj);
        zzbfp.m5540a(parcel, 1000, this.versionCode);
        zzbfp.m5537a(parcel, i);
    }
}
