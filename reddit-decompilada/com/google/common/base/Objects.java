package com.google.common.base;

import java.util.Arrays;

public final class Objects extends ExtraObjectsMethodsForWeb {
    public static boolean m14557a(Object obj, Object obj2) {
        if (obj != obj2) {
            if (obj == null || obj.equals(obj2) == null) {
                return null;
            }
        }
        return true;
    }

    public static int m14556a(Object... objArr) {
        return Arrays.hashCode(objArr);
    }
}
