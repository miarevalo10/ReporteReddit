package android.support.v4.text;

import android.os.Build.VERSION;
import android.util.Log;
import java.lang.reflect.Method;
import java.util.Locale;

public final class ICUCompat {
    private static Method f1365a;
    private static Method f1366b;

    static {
        if (VERSION.SDK_INT >= 21) {
            try {
                f1366b = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", new Class[]{Locale.class});
                return;
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
        try {
            Class cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                f1365a = cls.getMethod("getScript", new Class[]{String.class});
                f1366b = cls.getMethod("addLikelySubtags", new Class[]{String.class});
            }
        } catch (Throwable e2) {
            f1365a = null;
            f1366b = null;
            Log.w("ICUCompat", e2);
        }
    }

    public static String m992a(Locale locale) {
        if (VERSION.SDK_INT >= 21) {
            try {
                return ((Locale) f1366b.invoke(null, new Object[]{locale})).getScript();
            } catch (Throwable e) {
                Log.w("ICUCompat", e);
                return locale.getScript();
            } catch (Throwable e2) {
                Log.w("ICUCompat", e2);
                return locale.getScript();
            }
        }
        String b = m993b(locale);
        if (b != null) {
            return m991a(b);
        }
        return null;
    }

    private static String m991a(String str) {
        try {
            if (f1365a != null) {
                return (String) f1365a.invoke(null, new Object[]{str});
            }
        } catch (String str2) {
            Log.w("ICUCompat", str2);
        } catch (String str22) {
            Log.w("ICUCompat", str22);
        }
        return null;
    }

    private static String m993b(Locale locale) {
        locale = locale.toString();
        try {
            if (f1366b != null) {
                return (String) f1366b.invoke(null, new Object[]{locale});
            }
        } catch (Throwable e) {
            Log.w("ICUCompat", e);
        } catch (Throwable e2) {
            Log.w("ICUCompat", e2);
        }
        return locale;
    }
}
