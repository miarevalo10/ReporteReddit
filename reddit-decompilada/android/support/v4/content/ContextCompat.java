package android.support.v4.content;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Process;
import android.util.TypedValue;
import java.io.File;

public class ContextCompat {
    private static final Object f1180a = new Object();
    private static TypedValue f1181b;

    public static boolean m715a(Context context, Intent[] intentArr) {
        if (VERSION.SDK_INT >= 16) {
            context.startActivities(intentArr, null);
        } else {
            context.startActivities(intentArr);
        }
        return true;
    }

    public static File[] m716a(Context context) {
        if (VERSION.SDK_INT >= 19) {
            return context.getExternalFilesDirs(null);
        }
        return new File[]{context.getExternalFilesDir(null)};
    }

    public static File[] m718b(Context context) {
        if (VERSION.SDK_INT >= 19) {
            return context.getExternalCacheDirs();
        }
        return new File[]{context.getExternalCacheDir()};
    }

    public static final Drawable m714a(Context context, int i) {
        if (VERSION.SDK_INT >= 21) {
            return context.getDrawable(i);
        }
        if (VERSION.SDK_INT >= 16) {
            return context.getResources().getDrawable(i);
        }
        synchronized (f1180a) {
            if (f1181b == null) {
                f1181b = new TypedValue();
            }
            context.getResources().getValue(i, f1181b, true);
            i = f1181b.resourceId;
        }
        return context.getResources().getDrawable(i);
    }

    public static final ColorStateList m717b(Context context, int i) {
        if (VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        return context.getResources().getColorStateList(i);
    }

    public static final int m719c(Context context, int i) {
        if (VERSION.SDK_INT >= 23) {
            return context.getColor(i);
        }
        return context.getResources().getColor(i);
    }

    public static int m713a(Context context, String str) {
        if (str != null) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }

    public static Context m720c(Context context) {
        return VERSION.SDK_INT >= 24 ? context.createDeviceProtectedStorageContext() : null;
    }

    public static boolean m721d(Context context) {
        return VERSION.SDK_INT >= 24 ? context.isDeviceProtectedStorage() : null;
    }
}
