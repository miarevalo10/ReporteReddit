package android.support.v7.content.res;

import java.lang.reflect.Array;

final class GrowingArrayUtils {
    static final /* synthetic */ boolean f1860a = true;

    private static int m1573a(int i) {
        return i <= 4 ? 8 : i * 2;
    }

    public static <T> T[] m1575a(T[] tArr, int i, T t) {
        if (f1860a || i <= tArr.length) {
            if (i + 1 > tArr.length) {
                T[] tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), m1573a(i));
                System.arraycopy(tArr, 0, tArr2, 0, i);
                tArr = tArr2;
            }
            tArr[i] = t;
            return tArr;
        }
        throw new AssertionError();
    }

    public static int[] m1574a(int[] iArr, int i, int i2) {
        if (f1860a || i <= iArr.length) {
            if (i + 1 > iArr.length) {
                Object obj = new int[m1573a(i)];
                System.arraycopy(iArr, 0, obj, 0, i);
                iArr = obj;
            }
            iArr[i] = i2;
            return iArr;
        }
        throw new AssertionError();
    }

    private GrowingArrayUtils() {
    }
}
