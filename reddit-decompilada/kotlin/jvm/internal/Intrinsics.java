package kotlin.jvm.internal;

import java.util.Arrays;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;

public class Intrinsics {
    public static int m26838a(int i, int i2) {
        return i < i2 ? -1 : i == i2 ? 0 : 1;
    }

    public static int m26839a(long j, long j2) {
        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        return i < 0 ? -1 : i == 0 ? 0 : 1;
    }

    private Intrinsics() {
    }

    public static void m26842a() {
        throw ((KotlinNullPointerException) m26840a(new KotlinNullPointerException()));
    }

    public static void m26844a(String str) {
        StringBuilder stringBuilder = new StringBuilder("lateinit property ");
        stringBuilder.append(str);
        stringBuilder.append(" has not been initialized");
        throw ((UninitializedPropertyAccessException) m26840a(new UninitializedPropertyAccessException(stringBuilder.toString())));
    }

    public static void m26843a(Object obj, String str) {
        if (obj == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" must not be null");
            throw ((IllegalStateException) m26840a(new IllegalStateException(stringBuilder.toString())));
        }
    }

    public static boolean m26845a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null ? true : null;
        } else {
            return obj.equals(obj2);
        }
    }

    private static <T extends Throwable> T m26840a(T t) {
        return m26841a((Throwable) t, Intrinsics.class.getName());
    }

    static <T extends Throwable> T m26841a(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int i = -1;
        int length = stackTrace.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        str = Arrays.asList(stackTrace).subList(i + 1, length);
        t.setStackTrace((StackTraceElement[]) str.toArray(new StackTraceElement[str.size()]));
        return t;
    }

    public static void m26847b(Object obj, String str) {
        if (obj == null) {
            obj = Thread.currentThread().getStackTrace()[3];
            String className = obj.getClassName();
            obj = obj.getMethodName();
            StringBuilder stringBuilder = new StringBuilder("Parameter specified as non-null is null: method ");
            stringBuilder.append(className);
            stringBuilder.append(".");
            stringBuilder.append(obj);
            stringBuilder.append(", parameter ");
            stringBuilder.append(str);
            throw ((IllegalArgumentException) m26840a(new IllegalArgumentException(stringBuilder.toString())));
        }
    }

    public static void m26846b() {
        throw new UnsupportedOperationException("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }
}
