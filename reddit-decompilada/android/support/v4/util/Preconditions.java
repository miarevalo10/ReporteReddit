package android.support.v4.util;

public class Preconditions {
    public static void m1043a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static <T> T m1042a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }
}
