package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.internal.zzbhf;

public final class zzbf {
    private static Object f5900a = new Object();
    private static boolean f5901b;
    private static String f5902c;
    private static int f5903d;

    public static String m4802a(Context context) {
        m4804c(context);
        return f5902c;
    }

    public static int m4803b(Context context) {
        m4804c(context);
        return f5903d;
    }

    private static void m4804c(Context context) {
        synchronized (f5900a) {
            if (f5901b) {
                return;
            }
            f5901b = true;
            try {
                Bundle bundle = zzbhf.m5574a(context).m5569a(context.getPackageName(), 128).metaData;
                if (bundle == null) {
                    return;
                } else {
                    f5902c = bundle.getString("com.google.app.id");
                    f5903d = bundle.getInt("com.google.android.gms.version");
                }
            } catch (Throwable e) {
                Log.wtf("MetadataValueReader", "This should never happen.", e);
            }
        }
    }
}
