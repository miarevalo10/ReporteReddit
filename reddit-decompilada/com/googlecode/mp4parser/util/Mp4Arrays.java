package com.googlecode.mp4parser.util;

public final class Mp4Arrays {
    public static long[] m7715a(long[] jArr, long... jArr2) {
        if (jArr == null) {
            jArr = new long[0];
        }
        Object obj = new long[(jArr.length + 1)];
        System.arraycopy(jArr, 0, obj, 0, jArr.length);
        System.arraycopy(jArr2, 0, obj, jArr.length, 1);
        return obj;
    }
}
