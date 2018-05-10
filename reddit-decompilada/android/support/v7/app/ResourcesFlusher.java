package android.support.v7.app;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

class ResourcesFlusher {
    private static Field f1832a;
    private static boolean f1833b;
    private static Class f1834c;
    private static boolean f1835d;
    private static Field f1836e;
    private static boolean f1837f;
    private static Field f1838g;
    private static boolean f1839h;

    static boolean m1557a(Resources resources) {
        if (VERSION.SDK_INT >= 24) {
            return m1561d(resources);
        }
        if (VERSION.SDK_INT >= 23) {
            return m1560c(resources);
        }
        return VERSION.SDK_INT >= 21 ? m1559b(resources) : null;
    }

    @RequiresApi(21)
    private static boolean m1559b(Resources resources) {
        if (!f1833b) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f1832a = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable e) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e);
            }
            f1833b = true;
        }
        if (f1832a != null) {
            try {
                resources = (Map) f1832a.get(resources);
            } catch (Resources resources2) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", resources2);
                resources2 = null;
            }
            if (resources2 != null) {
                resources2.clear();
                return true;
            }
        }
        return null;
    }

    @RequiresApi(23)
    private static boolean m1560c(Resources resources) {
        Object obj;
        if (!f1833b) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f1832a = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable e) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e);
            }
            f1833b = true;
        }
        if (f1832a != null) {
            try {
                obj = f1832a.get(resources);
            } catch (Resources resources2) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", resources2);
            }
            if (obj != null || obj == null || m1558a(obj) == null) {
                return false;
            }
            return true;
        }
        obj = null;
        if (obj != null) {
            return false;
        }
        return true;
    }

    @RequiresApi(24)
    private static boolean m1561d(Resources resources) {
        if (!f1839h) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                f1838g = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable e) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e);
            }
            f1839h = true;
        }
        if (f1838g == null) {
            return false;
        }
        try {
            resources = f1838g.get(resources);
        } catch (Resources resources2) {
            Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", resources2);
            resources2 = null;
        }
        if (resources2 == null) {
            return false;
        }
        Object obj;
        if (!f1833b) {
            try {
                Field declaredField2 = resources2.getClass().getDeclaredField("mDrawableCache");
                f1832a = declaredField2;
                declaredField2.setAccessible(true);
            } catch (Throwable e2) {
                Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e2);
            }
            f1833b = true;
        }
        if (f1832a != null) {
            try {
                obj = f1832a.get(resources2);
            } catch (Resources resources22) {
                Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", resources22);
            }
            if (obj != null || m1558a(obj) == null) {
                return false;
            }
            return true;
        }
        obj = null;
        if (obj != null) {
        }
        return false;
    }

    @RequiresApi(16)
    private static boolean m1558a(Object obj) {
        if (!f1835d) {
            try {
                f1834c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (Throwable e) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e);
            }
            f1835d = true;
        }
        if (f1834c == null) {
            return false;
        }
        if (!f1837f) {
            try {
                Field declaredField = f1834c.getDeclaredField("mUnthemedEntries");
                f1836e = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable e2) {
                Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e2);
            }
            f1837f = true;
        }
        if (f1836e == null) {
            return false;
        }
        try {
            obj = (LongSparseArray) f1836e.get(obj);
        } catch (Object obj2) {
            Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", obj2);
            obj2 = null;
        }
        if (obj2 == null) {
            return false;
        }
        obj2.clear();
        return true;
    }
}
