package io.reactivex.internal.functions;

import io.reactivex.functions.BiPredicate;

public final class ObjectHelper {
    static final BiPredicate<Object, Object> f25024a = new BiObjectPredicate();

    static final class BiObjectPredicate implements BiPredicate<Object, Object> {
        BiObjectPredicate() {
        }

        public final boolean mo4928a(Object obj, Object obj2) {
            return ObjectHelper.m26574a(obj, obj2);
        }
    }

    public static int m26568a(int i, int i2) {
        return i < i2 ? -1 : i > i2 ? 1 : 0;
    }

    public static int m26570a(long j, long j2) {
        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        return i < 0 ? -1 : i > 0 ? 1 : 0;
    }

    public static <T> T m26573a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static boolean m26574a(Object obj, Object obj2) {
        if (obj != obj2) {
            if (obj == null || obj.equals(obj2) == null) {
                return null;
            }
        }
        return true;
    }

    public static <T> BiPredicate<T, T> m26572a() {
        return f25024a;
    }

    public static int m26569a(int i, String str) {
        if (i > 0) {
            return i;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" > 0 required but it was ");
        stringBuilder.append(i);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static long m26571a(long j, String str) {
        if (j > 0) {
            return j;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" > 0 required but it was ");
        stringBuilder.append(j);
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
