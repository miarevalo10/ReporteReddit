package com.google.common.base;

import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.logging.Logger;

final class Platform {
    private static final Logger f8239a = Logger.getLogger(Platform.class.getName());
    private static final PatternCompiler f8240b = new JdkPatternCompiler();

    private static final class JdkPatternCompiler implements PatternCompiler {
        private JdkPatternCompiler() {
        }
    }

    private Platform() {
    }

    static long m6903a() {
        return System.nanoTime();
    }

    static <T extends Enum<T>> Optional<T> m6904a(Class<T> cls, String str) {
        WeakReference weakReference = (WeakReference) Enums.m6874a(cls).get(str);
        return weakReference == null ? Optional.m6898e() : Optional.m6896b(cls.cast(weakReference.get()));
    }

    static String m6905a(double d) {
        return String.format(Locale.ROOT, "%.4g", new Object[]{Double.valueOf(d)});
    }

    static boolean m6906a(String str) {
        if (str != null) {
            if (str.isEmpty() == null) {
                return null;
            }
        }
        return true;
    }
}
