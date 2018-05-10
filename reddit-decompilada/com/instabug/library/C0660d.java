package com.instabug.library;

import java.lang.reflect.Method;

/* compiled from: ReflectionUtils */
public class C0660d {
    private static final String f9587a = "d";

    public static Method m8162a(Class cls, String str) {
        for (Method method : cls.getDeclaredMethods()) {
            if (method.getName().equals(str)) {
                method.setAccessible(true);
                return method;
            }
        }
        return null;
    }

    public static Method m8163a(Class cls, String str, Class... clsArr) {
        for (Method method : cls.getMethods()) {
            if (method.getName().equals(str) && method.getParameterTypes().length == 1) {
                int i = 0;
                while (i < method.getParameterTypes().length && method.getParameterTypes()[i] == clsArr[i]) {
                    if (i == method.getParameterTypes().length - 1) {
                        method.setAccessible(true);
                        return method;
                    }
                    i++;
                }
            }
        }
        return null;
    }
}
