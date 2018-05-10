package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;

public final class zzi {
    private static Boolean f5966a;
    private static Boolean f5967b;
    private static Boolean f5968c;

    @TargetApi(21)
    public static boolean m4903b(Context context) {
        if (f5967b == null) {
            boolean z = zzq.m4915g() && context.getPackageManager().hasSystemFeature("cn.google");
            f5967b = Boolean.valueOf(z);
        }
        return f5967b.booleanValue();
    }

    public static boolean m4904c(Context context) {
        if (f5968c == null) {
            boolean z;
            if (!context.getPackageManager().hasSystemFeature("android.hardware.type.iot")) {
                if (!context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
                    z = false;
                    f5968c = Boolean.valueOf(z);
                }
            }
            z = true;
            f5968c = Boolean.valueOf(z);
        }
        return f5968c.booleanValue();
    }

    @TargetApi(24)
    public static boolean m4902a(Context context) {
        if (!zzq.m4916h() || m4903b(context)) {
            if (f5966a == null) {
                context = (!zzq.m4914f() || context.getPackageManager().hasSystemFeature("android.hardware.type.watch") == null) ? null : 1;
                f5966a = Boolean.valueOf(context);
            }
            if (f5966a.booleanValue() != null) {
                return true;
            }
        }
        return false;
    }
}
