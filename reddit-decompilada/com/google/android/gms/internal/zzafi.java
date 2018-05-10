package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzbs;

@zzzv
public final class zzafi {
    public static String m5105a(String str, Context context) {
        if (zzbs.m4507z().m5090a(context)) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            String i = zzbs.m4507z().m5104i(context);
            if (i == null) {
                return str;
            }
            if (((Boolean) zzkb.m6350f().m6488a(zznh.an)).booleanValue()) {
                String str2 = (String) zzkb.m6350f().m6488a(zznh.ao);
                if (str.contains(str2)) {
                    if (zzbs.m4486e().m5230d(str)) {
                        zzbs.m4507z().m5087a(context, i);
                        return str.replace(str2, i);
                    } else if (zzbs.m4486e().m5231e(str)) {
                        zzbs.m4507z().m5092b(context, i);
                        return str.replace(str2, i);
                    }
                }
            } else if (!str.contains("fbs_aeid")) {
                if (zzbs.m4486e().m5230d(str)) {
                    zzbs.m4507z().m5087a(context, i);
                    zzbs.m4486e();
                    return zzahn.m5152a(str, "fbs_aeid", i).toString();
                } else if (zzbs.m4486e().m5231e(str)) {
                    zzbs.m4507z().m5092b(context, i);
                    zzbs.m4486e();
                    str = zzahn.m5152a(str, "fbs_aeid", i).toString();
                }
            }
        }
        return str;
    }
}
