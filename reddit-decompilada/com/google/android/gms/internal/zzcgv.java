package com.google.android.gms.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbq;

public final class zzcgv {
    final String f6835a;
    final String f6836b;
    String f6837c;
    final long f6838d;
    final long f6839e;
    final zzcgx f6840f;

    public final String toString() {
        String str = this.f6835a;
        String str2 = this.f6836b;
        String valueOf = String.valueOf(this.f6840f);
        StringBuilder stringBuilder = new StringBuilder(((33 + String.valueOf(str).length()) + String.valueOf(str2).length()) + String.valueOf(valueOf).length());
        stringBuilder.append("Event{appId='");
        stringBuilder.append(str);
        stringBuilder.append("', name='");
        stringBuilder.append(str2);
        stringBuilder.append("', params=");
        stringBuilder.append(valueOf);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    zzcgv(zzcim com_google_android_gms_internal_zzcim, String str, String str2, String str3, long j, long j2, zzcgx com_google_android_gms_internal_zzcgx) {
        zzbq.m4810a(str2);
        zzbq.m4810a(str3);
        zzbq.m4808a((Object) com_google_android_gms_internal_zzcgx);
        this.f6835a = str2;
        this.f6836b = str3;
        if (TextUtils.isEmpty(str) != null) {
            str = null;
        }
        this.f6837c = str;
        this.f6838d = j;
        this.f6839e = j2;
        if (this.f6839e != 0 && this.f6839e > this.f6838d) {
            com_google_android_gms_internal_zzcim.m5754e().f17818c.m5694a("Event created with reverse previous/current timestamps. appId", zzchm.m18154a(str2));
        }
        this.f6840f = com_google_android_gms_internal_zzcgx;
    }

    zzcgv(zzcim com_google_android_gms_internal_zzcim, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        zzbq.m4810a(str2);
        zzbq.m4810a(str3);
        this.f6835a = str2;
        this.f6836b = str3;
        if (TextUtils.isEmpty(str) != null) {
            str = null;
        }
        this.f6837c = str;
        this.f6838d = j;
        this.f6839e = j2;
        if (this.f6839e != 0 && this.f6839e > this.f6838d) {
            com_google_android_gms_internal_zzcim.m5754e().f17818c.m5694a("Event created with reverse previous/current timestamps. appId", zzchm.m18154a(str2));
        }
        this.f6840f = m5667a(com_google_android_gms_internal_zzcim, bundle);
    }

    private static zzcgx m5667a(zzcim com_google_android_gms_internal_zzcim, Bundle bundle) {
        if (bundle == null || bundle.isEmpty()) {
            return new zzcgx(new Bundle());
        }
        Bundle bundle2 = new Bundle(bundle);
        bundle = bundle2.keySet().iterator();
        while (bundle.hasNext()) {
            String str = (String) bundle.next();
            if (str == null) {
                com_google_android_gms_internal_zzcim.m5754e().f17816a.m5693a("Param name can't be null");
                bundle.remove();
            } else {
                com_google_android_gms_internal_zzcim.m5758i();
                Object a = zzclq.m18505a(str, bundle2.get(str));
                if (a == null) {
                    com_google_android_gms_internal_zzcim.m5754e().f17818c.m5694a("Param value can't be null", com_google_android_gms_internal_zzcim.m5759j().m18130b(str));
                    bundle.remove();
                } else {
                    com_google_android_gms_internal_zzcim.m5758i().m18540a(bundle2, str, a);
                }
            }
        }
        return new zzcgx(bundle2);
    }
}
