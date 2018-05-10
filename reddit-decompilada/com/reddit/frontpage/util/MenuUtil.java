package com.reddit.frontpage.util;

import android.support.v4.util.ArrayMap;
import android.view.Menu;
import java.lang.reflect.Method;
import java.util.Map;
import timber.log.Timber;

public class MenuUtil {
    private static final Map<String, Method> f21754a = new ArrayMap();

    public static void m23812a(Menu menu) {
        if (menu != null) {
            Class cls = menu.getClass();
            if (cls.getSimpleName().equals("MenuBuilder")) {
                String canonicalName = cls.getCanonicalName();
                if (!f21754a.containsKey(canonicalName)) {
                    try {
                        Method declaredMethod = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", new Class[]{Boolean.TYPE});
                        declaredMethod.setAccessible(true);
                        f21754a.put(canonicalName, declaredMethod);
                    } catch (Throwable e) {
                        Timber.b(e, "Failed to obtain method for overflow icons.", new Object[0]);
                    }
                }
                Method method = (Method) f21754a.get(canonicalName);
                if (method != null) {
                    try {
                        method.invoke(menu, new Object[]{Boolean.valueOf(true)});
                    } catch (Menu menu2) {
                        Timber.b(menu2, "Failed to enable icons in overflow menu", new Object[0]);
                    }
                }
            }
        }
    }
}
