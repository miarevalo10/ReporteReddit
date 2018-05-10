package com.bumptech.glide.load.engine.cache;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

public final class MemorySizeCalculator {
    public final int f3464a;
    public final int f3465b;
    public final int f3466c;
    private final Context f3467d;

    public static final class Builder {
        static final int f3455a = (VERSION.SDK_INT < 26 ? 4 : 1);
        final Context f3456b;
        ActivityManager f3457c;
        ScreenDimensions f3458d;
        float f3459e = 2.0f;
        float f3460f = ((float) f3455a);
        float f3461g = 0.4f;
        float f3462h = 0.33f;
        int f3463i = 4194304;

        public Builder(Context context) {
            this.f3456b = context;
            this.f3457c = (ActivityManager) context.getSystemService("activity");
            this.f3458d = new DisplayMetricsScreenDimensions(context.getResources().getDisplayMetrics());
            if (VERSION.SDK_INT >= 26 && MemorySizeCalculator.m2975a(this.f3457c) != null) {
                this.f3460f = null;
            }
        }
    }

    interface ScreenDimensions {
        int mo963a();

        int mo964b();
    }

    private static final class DisplayMetricsScreenDimensions implements ScreenDimensions {
        private final DisplayMetrics f12510a;

        DisplayMetricsScreenDimensions(DisplayMetrics displayMetrics) {
            this.f12510a = displayMetrics;
        }

        public final int mo963a() {
            return this.f12510a.widthPixels;
        }

        public final int mo964b() {
            return this.f12510a.heightPixels;
        }
    }

    public MemorySizeCalculator(Builder builder) {
        int i;
        this.f3467d = builder.f3456b;
        if (m2975a(builder.f3457c)) {
            i = builder.f3463i / 2;
        } else {
            i = builder.f3463i;
        }
        this.f3466c = i;
        ActivityManager activityManager = builder.f3457c;
        float f = builder.f3461g;
        float f2 = builder.f3462h;
        float memoryClass = (float) ((activityManager.getMemoryClass() * 1024) * 1024);
        if (m2975a(activityManager)) {
            f = f2;
        }
        i = Math.round(memoryClass * f);
        f = (float) ((builder.f3458d.mo963a() * builder.f3458d.mo964b()) * 4);
        int round = Math.round(builder.f3460f * f);
        int round2 = Math.round(f * builder.f3459e);
        int i2 = i - this.f3466c;
        int i3 = round2 + round;
        if (i3 <= i2) {
            this.f3465b = round2;
            this.f3464a = round;
        } else {
            f = ((float) i2) / (builder.f3460f + builder.f3459e);
            this.f3465b = Math.round(builder.f3459e * f);
            this.f3464a = Math.round(f * builder.f3460f);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            String str = "MemorySizeCalculator";
            StringBuilder stringBuilder = new StringBuilder("Calculation complete, Calculated memory cache size: ");
            stringBuilder.append(m2974a(this.f3465b));
            stringBuilder.append(", pool size: ");
            stringBuilder.append(m2974a(this.f3464a));
            stringBuilder.append(", byte array size: ");
            stringBuilder.append(m2974a(this.f3466c));
            stringBuilder.append(", memory class limited? ");
            stringBuilder.append(i3 > i);
            stringBuilder.append(", max size: ");
            stringBuilder.append(m2974a(i));
            stringBuilder.append(", memoryClass: ");
            stringBuilder.append(builder.f3457c.getMemoryClass());
            stringBuilder.append(", isLowMemoryDevice: ");
            stringBuilder.append(m2975a(builder.f3457c));
            Log.d(str, stringBuilder.toString());
        }
    }

    private String m2974a(int i) {
        return Formatter.formatFileSize(this.f3467d, (long) i);
    }

    @TargetApi(19)
    static boolean m2975a(ActivityManager activityManager) {
        return VERSION.SDK_INT >= 19 ? activityManager.isLowRamDevice() : true;
    }
}
