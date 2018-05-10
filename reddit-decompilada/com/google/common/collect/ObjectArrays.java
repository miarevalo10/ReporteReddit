package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.lang.reflect.Array;

public final class ObjectArrays {
    public static <T> T[] m7239a(Class<T> cls, int i) {
        return (Object[]) Array.newInstance(cls, i);
    }

    public static <T> T[] m7241a(T[] tArr, int i) {
        return Platform.m7249a(tArr, i);
    }

    public static <T> T[] m7243a(T[] tArr, T[] tArr2, Class<T> cls) {
        cls = m7239a((Class) cls, tArr.length + tArr2.length);
        System.arraycopy(tArr, 0, cls, 0, tArr.length);
        System.arraycopy(tArr2, 0, cls, tArr.length, tArr2.length);
        return cls;
    }

    static <T> T[] m7242a(Object[] objArr, int i, T[] tArr) {
        Preconditions.m6912a(0, 0 + i, objArr.length);
        if (tArr.length < i) {
            tArr = Platform.m7249a(tArr, i);
        } else if (tArr.length > i) {
            tArr[i] = null;
        }
        System.arraycopy(objArr, 0, tArr, 0, i);
        return tArr;
    }

    static Object[] m7240a(Object... objArr) {
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            m7238a(objArr[i], i);
        }
        return objArr;
    }

    static Object m7238a(Object obj, int i) {
        if (obj != null) {
            return obj;
        }
        StringBuilder stringBuilder = new StringBuilder("at index ");
        stringBuilder.append(i);
        throw new NullPointerException(stringBuilder.toString());
    }
}
