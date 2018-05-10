package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdRequest.Gender;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.zzb;
import java.util.Date;
import java.util.HashSet;

@zzzv
public final class zzwj {
    public static int m6772a(ErrorCode errorCode) {
        switch (zzwk.f8116a[errorCode.ordinal()]) {
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            default:
                return 0;
        }
    }

    public static MediationAdRequest m6774a(zzjj com_google_android_gms_internal_zzjj, boolean z) {
        Gender gender;
        HashSet hashSet = com_google_android_gms_internal_zzjj.f18138e != null ? new HashSet(com_google_android_gms_internal_zzjj.f18138e) : null;
        Date date = new Date(com_google_android_gms_internal_zzjj.f18135b);
        switch (com_google_android_gms_internal_zzjj.f18137d) {
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            default:
                gender = Gender.UNKNOWN;
                break;
        }
        return new MediationAdRequest(date, gender, hashSet, z, com_google_android_gms_internal_zzjj.f18144k);
    }

    public static AdSize m6773a(zzjn com_google_android_gms_internal_zzjn) {
        r1 = new AdSize[6];
        int i = 0;
        r1[0] = AdSize.f3958b;
        r1[1] = AdSize.f3959c;
        r1[2] = AdSize.f3960d;
        r1[3] = AdSize.f3961e;
        r1[4] = AdSize.f3962f;
        r1[5] = AdSize.f3963g;
        while (i < 6) {
            if (r1[i].f3964a.f5378k == com_google_android_gms_internal_zzjn.f18156e && r1[i].f3964a.f5379l == com_google_android_gms_internal_zzjn.f18153b) {
                return r1[i];
            }
            i++;
        }
        return new AdSize(zzb.m4570a(com_google_android_gms_internal_zzjn.f18156e, com_google_android_gms_internal_zzjn.f18153b, com_google_android_gms_internal_zzjn.f18152a));
    }
}
