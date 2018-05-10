package org.jcodec.common;

public class Assert {
    public static void assertTrue(boolean z) {
        if (!z) {
            throw new AssertionError();
        }
    }

    public static void assertTrue(String str, boolean z) {
        if (!z) {
            throw new AssertionError(str);
        }
    }

    public static void assertEquals(String str, int i, int i2) {
        if (i != i2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" expected ");
            stringBuilder.append(i);
            stringBuilder.append(" actual ");
            stringBuilder.append(i2);
            throw new AssertionError(stringBuilder.toString());
        }
    }

    public static void assertEquals(int i, int i2) {
        if (i != i2) {
            throw new AssertionError();
        }
    }

    public static void assertEquals(long j, int i) {
        if (j != ((long) i)) {
            throw new AssertionError();
        }
    }

    public static void assertNotNull(Object obj) {
        if (obj == null) {
            throw new AssertionError();
        }
    }

    public static void assertArrayEquals(int[] iArr, int[] iArr2) {
        if (iArr != iArr2) {
            if (iArr != null) {
                if (iArr2 != null) {
                    if (iArr.length != iArr2.length) {
                        throw new AssertionError();
                    }
                    for (int i = 0; i < iArr.length; i++) {
                        if (iArr[i] != iArr2[i]) {
                            throw new AssertionError();
                        }
                    }
                    return;
                }
            }
            throw new AssertionError();
        }
    }
}
