package android.support.v7.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatDrawableManager;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;

public final class AppCompatResources {
    private static final ThreadLocal<TypedValue> f1857a = new ThreadLocal();
    private static final WeakHashMap<Context, SparseArray<ColorStateListCacheEntry>> f1858b = new WeakHashMap(0);
    private static final Object f1859c = new Object();

    private static class ColorStateListCacheEntry {
        final ColorStateList f1855a;
        final Configuration f1856b;

        ColorStateListCacheEntry(ColorStateList colorStateList, Configuration configuration) {
            this.f1855a = colorStateList;
            this.f1856b = configuration;
        }
    }

    public static ColorStateList m1569a(Context context, int i) {
        if (VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        ColorStateList d = m1572d(context, i);
        if (d != null) {
            return d;
        }
        d = m1571c(context, i);
        if (d == null) {
            return ContextCompat.m717b(context, i);
        }
        synchronized (f1859c) {
            SparseArray sparseArray = (SparseArray) f1858b.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                f1858b.put(context, sparseArray);
            }
            sparseArray.append(i, new ColorStateListCacheEntry(d, context.getResources().getConfiguration()));
        }
        return d;
    }

    public static Drawable m1570b(Context context, int i) {
        return AppCompatDrawableManager.m1809a().m1818a(context, i, false);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.content.res.ColorStateList m1572d(android.content.Context r4, int r5) {
        /*
        r0 = f1859c;
        monitor-enter(r0);
        r1 = f1858b;	 Catch:{ all -> 0x0035 }
        r1 = r1.get(r4);	 Catch:{ all -> 0x0035 }
        r1 = (android.util.SparseArray) r1;	 Catch:{ all -> 0x0035 }
        if (r1 == 0) goto L_0x0032;
    L_0x000d:
        r2 = r1.size();	 Catch:{ all -> 0x0035 }
        if (r2 <= 0) goto L_0x0032;
    L_0x0013:
        r2 = r1.get(r5);	 Catch:{ all -> 0x0035 }
        r2 = (android.support.v7.content.res.AppCompatResources.ColorStateListCacheEntry) r2;	 Catch:{ all -> 0x0035 }
        if (r2 == 0) goto L_0x0032;
    L_0x001b:
        r3 = r2.f1856b;	 Catch:{ all -> 0x0035 }
        r4 = r4.getResources();	 Catch:{ all -> 0x0035 }
        r4 = r4.getConfiguration();	 Catch:{ all -> 0x0035 }
        r4 = r3.equals(r4);	 Catch:{ all -> 0x0035 }
        if (r4 == 0) goto L_0x002f;
    L_0x002b:
        r4 = r2.f1855a;	 Catch:{ all -> 0x0035 }
        monitor-exit(r0);	 Catch:{ all -> 0x0035 }
        return r4;
    L_0x002f:
        r1.remove(r5);	 Catch:{ all -> 0x0035 }
    L_0x0032:
        monitor-exit(r0);	 Catch:{ all -> 0x0035 }
        r4 = 0;
        return r4;
    L_0x0035:
        r4 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0035 }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.content.res.AppCompatResources.d(android.content.Context, int):android.content.res.ColorStateList");
    }

    private static ColorStateList m1571c(Context context, int i) {
        Resources resources = context.getResources();
        TypedValue typedValue = (TypedValue) f1857a.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            f1857a.set(typedValue);
        }
        boolean z = true;
        resources.getValue(i, typedValue, true);
        if (typedValue.type < 28 || typedValue.type > 31) {
            z = false;
        }
        if (z) {
            return null;
        }
        Resources resources2 = context.getResources();
        try {
            return AppCompatColorStateListInflater.m1567a(resources2, resources2.getXml(i), context.getTheme());
        } catch (Context context2) {
            Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", context2);
            return null;
        }
    }
}
