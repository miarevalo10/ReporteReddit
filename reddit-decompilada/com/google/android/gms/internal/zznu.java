package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzbs;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@zzzv
public final class zznu {
    public boolean f7942a;
    public final Object f7943b = new Object();
    public String f7944c;
    zznu f7945d;
    private final List<zzns> f7946e = new LinkedList();
    private final Map<String, String> f7947f = new LinkedHashMap();

    public zznu(boolean z, String str, String str2) {
        this.f7942a = z;
        this.f7947f.put("action", str);
        this.f7947f.put("ad_format", str2);
    }

    public final zzns m6502a() {
        return m6503a(zzbs.m4492k().mo1633b());
    }

    public final zzns m6503a(long j) {
        return !this.f7942a ? null : new zzns(j, null, null);
    }

    public final void m6504a(String str, String str2) {
        if (this.f7942a && !TextUtils.isEmpty(str2)) {
            zznk e = zzbs.m4490i().m13257e();
            if (e != null) {
                synchronized (this.f7943b) {
                    zzno a = e.m6494a(str);
                    Map map = this.f7947f;
                    map.put(str, a.mo2059a((String) map.get(str), str2));
                }
            }
        }
    }

    public final boolean m6505a(zzns com_google_android_gms_internal_zzns, long j, String... strArr) {
        synchronized (this.f7943b) {
            for (String com_google_android_gms_internal_zzns2 : strArr) {
                this.f7946e.add(new zzns(j, com_google_android_gms_internal_zzns2, com_google_android_gms_internal_zzns));
            }
        }
        return true;
    }

    public final boolean m6506a(zzns com_google_android_gms_internal_zzns, String... strArr) {
        if (this.f7942a) {
            if (com_google_android_gms_internal_zzns != null) {
                return m6505a(com_google_android_gms_internal_zzns, zzbs.m4492k().mo1633b(), strArr);
            }
        }
        return false;
    }

    final Map<String, String> m6508c() {
        synchronized (this.f7943b) {
            Map<String, String> a;
            zznk e = zzbs.m4490i().m13257e();
            if (e != null) {
                if (this.f7945d != null) {
                    a = e.m6495a(this.f7947f, this.f7945d.m6508c());
                    return a;
                }
            }
            a = this.f7947f;
            return a;
        }
    }

    public final zzns m6509d() {
        synchronized (this.f7943b) {
        }
        return null;
    }

    public final String m6507b() {
        String stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        synchronized (this.f7943b) {
            for (zzns com_google_android_gms_internal_zzns : this.f7946e) {
                long j = com_google_android_gms_internal_zzns.f7937a;
                String str = com_google_android_gms_internal_zzns.f7938b;
                zzns com_google_android_gms_internal_zzns2 = com_google_android_gms_internal_zzns2.f7939c;
                if (com_google_android_gms_internal_zzns2 != null && j > 0) {
                    j -= com_google_android_gms_internal_zzns2.f7937a;
                    stringBuilder2.append(str);
                    stringBuilder2.append('.');
                    stringBuilder2.append(j);
                    stringBuilder2.append(',');
                }
            }
            this.f7946e.clear();
            if (!TextUtils.isEmpty(this.f7944c)) {
                stringBuilder2.append(this.f7944c);
            } else if (stringBuilder2.length() > 0) {
                stringBuilder2.setLength(stringBuilder2.length() - 1);
            }
            stringBuilder = stringBuilder2.toString();
        }
        return stringBuilder;
    }
}
