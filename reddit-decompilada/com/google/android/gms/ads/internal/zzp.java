package com.google.android.gms.ads.internal;

import android.os.Bundle;
import com.google.android.gms.internal.zzjj;
import com.google.android.gms.internal.zzzv;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

@zzzv
public final class zzp {
    private static String m4515a(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = new TreeSet(bundle.keySet()).iterator();
        while (it.hasNext()) {
            Object obj = bundle.get((String) it.next());
            String a = obj == null ? "null" : obj instanceof Bundle ? m4515a((Bundle) obj) : obj.toString();
            stringBuilder.append(a);
        }
        return stringBuilder.toString();
    }

    public static Object[] m4516a(String str, zzjj com_google_android_gms_internal_zzjj, String str2, int i) {
        Set hashSet = new HashSet(Arrays.asList(str.split(",")));
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        arrayList.add(str2);
        if (hashSet.contains("formatString")) {
            arrayList.add(null);
        }
        if (hashSet.contains("networkType")) {
            arrayList.add(Integer.valueOf(i));
        }
        if (hashSet.contains("birthday")) {
            arrayList.add(Long.valueOf(com_google_android_gms_internal_zzjj.f18135b));
        }
        if (hashSet.contains("extras")) {
            arrayList.add(m4515a(com_google_android_gms_internal_zzjj.f18136c));
        }
        if (hashSet.contains("gender")) {
            arrayList.add(Integer.valueOf(com_google_android_gms_internal_zzjj.f18137d));
        }
        if (hashSet.contains("keywords")) {
            if (com_google_android_gms_internal_zzjj.f18138e != null) {
                arrayList.add(com_google_android_gms_internal_zzjj.f18138e.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("isTestDevice")) {
            arrayList.add(Boolean.valueOf(com_google_android_gms_internal_zzjj.f18139f));
        }
        if (hashSet.contains("tagForChildDirectedTreatment")) {
            arrayList.add(Integer.valueOf(com_google_android_gms_internal_zzjj.f18140g));
        }
        if (hashSet.contains("manualImpressionsEnabled")) {
            arrayList.add(Boolean.valueOf(com_google_android_gms_internal_zzjj.f18141h));
        }
        if (hashSet.contains("publisherProvidedId")) {
            arrayList.add(com_google_android_gms_internal_zzjj.f18142i);
        }
        if (hashSet.contains("location")) {
            if (com_google_android_gms_internal_zzjj.f18144k != null) {
                arrayList.add(com_google_android_gms_internal_zzjj.f18144k.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("contentUrl")) {
            arrayList.add(com_google_android_gms_internal_zzjj.f18145l);
        }
        if (hashSet.contains("networkExtras")) {
            arrayList.add(m4515a(com_google_android_gms_internal_zzjj.f18146m));
        }
        if (hashSet.contains("customTargeting")) {
            arrayList.add(m4515a(com_google_android_gms_internal_zzjj.f18147n));
        }
        if (hashSet.contains("categoryExclusions")) {
            if (com_google_android_gms_internal_zzjj.f18148o != null) {
                arrayList.add(com_google_android_gms_internal_zzjj.f18148o.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("requestAgent")) {
            arrayList.add(com_google_android_gms_internal_zzjj.f18149p);
        }
        if (hashSet.contains("requestPackage")) {
            arrayList.add(com_google_android_gms_internal_zzjj.f18150q);
        }
        if (hashSet.contains("isDesignedForFamilies")) {
            arrayList.add(Boolean.valueOf(com_google_android_gms_internal_zzjj.f18151r));
        }
        return arrayList.toArray();
    }
}
