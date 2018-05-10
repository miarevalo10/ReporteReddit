package android.support.v4.math;

public class MathUtils {
    public static float m853a(float f) {
        return f < 0.0f ? 0.0f : f > 1.0f ? 1.0f : f;
    }

    public static int m854a(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }
}
