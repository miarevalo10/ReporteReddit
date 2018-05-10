package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbq;

final class zzcgw {
    final String f6841a;
    final String f6842b;
    final long f6843c;
    final long f6844d;
    final long f6845e;
    final long f6846f;
    final Long f6847g;
    final Long f6848h;
    final Boolean f6849i;

    zzcgw(String str, String str2, long j, long j2, long j3, long j4, Long l, Long l2, Boolean bool) {
        zzcgw com_google_android_gms_internal_zzcgw = this;
        long j5 = j;
        long j6 = j2;
        long j7 = j4;
        zzbq.m4810a(str);
        zzbq.m4810a(str2);
        boolean z = false;
        zzbq.m4817b(j5 >= 0);
        zzbq.m4817b(j6 >= 0);
        if (j7 >= 0) {
            z = true;
        }
        zzbq.m4817b(z);
        com_google_android_gms_internal_zzcgw.f6841a = str;
        com_google_android_gms_internal_zzcgw.f6842b = str2;
        com_google_android_gms_internal_zzcgw.f6843c = j5;
        com_google_android_gms_internal_zzcgw.f6844d = j6;
        com_google_android_gms_internal_zzcgw.f6845e = j3;
        com_google_android_gms_internal_zzcgw.f6846f = j7;
        com_google_android_gms_internal_zzcgw.f6847g = l;
        com_google_android_gms_internal_zzcgw.f6848h = l2;
        com_google_android_gms_internal_zzcgw.f6849i = bool;
    }

    final zzcgw m5668a() {
        return new zzcgw(this.f6841a, this.f6842b, this.f6843c + 1, 1 + this.f6844d, this.f6845e, this.f6846f, this.f6847g, this.f6848h, this.f6849i);
    }

    final zzcgw m5669a(long j) {
        return new zzcgw(this.f6841a, this.f6842b, this.f6843c, this.f6844d, j, this.f6846f, this.f6847g, this.f6848h, this.f6849i);
    }

    final zzcgw m5670a(Long l, Long l2, Boolean bool) {
        zzcgw com_google_android_gms_internal_zzcgw = this;
        Boolean bool2 = (bool == null || bool.booleanValue()) ? bool : null;
        return new zzcgw(com_google_android_gms_internal_zzcgw.f6841a, com_google_android_gms_internal_zzcgw.f6842b, com_google_android_gms_internal_zzcgw.f6843c, com_google_android_gms_internal_zzcgw.f6844d, com_google_android_gms_internal_zzcgw.f6845e, com_google_android_gms_internal_zzcgw.f6846f, l, l2, bool2);
    }

    final zzcgw m5671b(long j) {
        return new zzcgw(this.f6841a, this.f6842b, this.f6843c, this.f6844d, this.f6845e, j, this.f6847g, this.f6848h, this.f6849i);
    }
}
