package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.View;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.UUID;

public final class zzdr {
    private static final char[] f7261a = "0123456789abcdef".toCharArray();

    public static long m5886a(double d, int i, DisplayMetrics displayMetrics) {
        return Math.round((d * ((double) i)) / ((double) displayMetrics.density));
    }

    public static Activity m5887a(View view) {
        View rootView = view.getRootView();
        if (rootView != null) {
            view = rootView;
        }
        Context context = view.getContext();
        int i = 0;
        while ((context instanceof ContextWrapper) && i < 10) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
            i++;
        }
        return null;
    }

    public static Long m5888a() {
        return Long.valueOf(Calendar.getInstance(TimeZone.getTimeZone("America/Los_Angeles")).getTime().getTime());
    }

    public static String m5889a(String str) {
        if (str == null || !str.matches("^[a-fA-F0-9]{8}-([a-fA-F0-9]{4}-){3}[a-fA-F0-9]{12}$")) {
            return str;
        }
        UUID fromString = UUID.fromString(str);
        byte[] bArr = new byte[16];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.putLong(fromString.getMostSignificantBits());
        wrap.putLong(fromString.getLeastSignificantBits());
        return zzbu.m5579a(bArr, true);
    }

    public static String m5890a(Throwable th) {
        Writer stringWriter = new StringWriter();
        zzdvl.m5926a(th, new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static boolean m5891a(DisplayMetrics displayMetrics) {
        return (displayMetrics == null || displayMetrics.density == 0.0f) ? false : true;
    }

    public static boolean m5892b() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean m5893b(String str) {
        if (str != null) {
            if (!str.isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
