package com.google.android.gms.internal;

import com.facebook.stetho.server.http.HttpStatus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public final class zzp {
    public final int f7956a;
    public final byte[] f7957b;
    public final Map<String, String> f7958c;
    public final List<zzl> f7959d;
    public final boolean f7960e;
    private long f7961f;

    private zzp(int i, byte[] bArr, Map<String, String> map, List<zzl> list, boolean z, long j) {
        this.f7956a = i;
        this.f7957b = bArr;
        this.f7958c = map;
        this.f7959d = list == null ? null : Collections.unmodifiableList(list);
        this.f7960e = z;
        this.f7961f = j;
    }

    @Deprecated
    public zzp(int i, byte[] bArr, Map<String, String> map, boolean z, long j) {
        this(i, bArr, map, m6558a((Map) map), z, j);
    }

    public zzp(int i, byte[] bArr, boolean z, long j, List<zzl> list) {
        this(i, bArr, m6559a((List) list), list, z, j);
    }

    @Deprecated
    public zzp(byte[] bArr, Map<String, String> map) {
        this((int) HttpStatus.HTTP_OK, bArr, (Map) map, false, 0);
    }

    private static List<zzl> m6558a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        if (map.isEmpty()) {
            return Collections.emptyList();
        }
        List<zzl> arrayList = new ArrayList(map.size());
        for (Entry entry : map.entrySet()) {
            arrayList.add(new zzl((String) entry.getKey(), (String) entry.getValue()));
        }
        return arrayList;
    }

    private static Map<String, String> m6559a(List<zzl> list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        Map<String, String> treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (zzl com_google_android_gms_internal_zzl : list) {
            treeMap.put(com_google_android_gms_internal_zzl.f7777a, com_google_android_gms_internal_zzl.f7778b);
        }
        return treeMap;
    }
}
