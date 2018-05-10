package org.threeten.bp.jdk8;

public final class Jdk8Methods {
    public static int m43164a(int i, int i2) {
        return i < i2 ? -1 : i > i2 ? 1 : 0;
    }

    public static int m43166a(long j, long j2) {
        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        return i < 0 ? -1 : i > 0 ? 1 : 0;
    }

    public static <T> T m43168a(T t, String str) {
        if (t != null) {
            return t;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" must not be null");
        throw new NullPointerException(stringBuilder.toString());
    }

    public static boolean m43169a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj2 == null ? false : obj.equals(obj2);
    }

    public static long m43171b(long j, long j2) {
        long j3 = j + j2;
        if ((j ^ j3) >= 0 || (j ^ j2) < 0) {
            return j3;
        }
        StringBuilder stringBuilder = new StringBuilder("Addition overflows a long: ");
        stringBuilder.append(j);
        stringBuilder.append(" + ");
        stringBuilder.append(j2);
        throw new ArithmeticException(stringBuilder.toString());
    }

    public static long m43172c(long j, long j2) {
        long j3 = j - j2;
        if ((j ^ j3) >= 0 || (j ^ j2) >= 0) {
            return j3;
        }
        StringBuilder stringBuilder = new StringBuilder("Subtraction overflows a long: ");
        stringBuilder.append(j);
        stringBuilder.append(" - ");
        stringBuilder.append(j2);
        throw new ArithmeticException(stringBuilder.toString());
    }

    public static long m43167a(long j, int i) {
        StringBuilder stringBuilder;
        switch (i) {
            case -1:
                if (j != Long.MIN_VALUE) {
                    return -j;
                }
                stringBuilder = new StringBuilder("Multiplication overflows a long: ");
                stringBuilder.append(j);
                stringBuilder.append(" * ");
                stringBuilder.append(i);
                throw new ArithmeticException(stringBuilder.toString());
            case 0:
                return 0;
            case 1:
                return j;
            default:
                long j2 = (long) i;
                long j3 = j * j2;
                if (j3 / j2 == j) {
                    return j3;
                }
                stringBuilder = new StringBuilder("Multiplication overflows a long: ");
                stringBuilder.append(j);
                stringBuilder.append(" * ");
                stringBuilder.append(i);
                throw new ArithmeticException(stringBuilder.toString());
        }
    }

    public static int m43165a(long j) {
        if (j <= 2147483647L) {
            if (j >= -2147483648L) {
                return (int) j;
            }
        }
        StringBuilder stringBuilder = new StringBuilder("Calculation overflows an int: ");
        stringBuilder.append(j);
        throw new ArithmeticException(stringBuilder.toString());
    }

    public static long m43173d(long j, long j2) {
        return j >= 0 ? j / j2 : ((j + 1) / j2) - 1;
    }

    public static long m43174e(long j, long j2) {
        return ((j % j2) + j2) % j2;
    }

    public static int m43170b(long j, int i) {
        long j2 = (long) i;
        return (int) (((j % j2) + j2) % j2);
    }

    public static int m43163a(int i) {
        return ((i % 7) + 7) % 7;
    }
}
