package com.google.android.gms.internal;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

final class zzfft implements zzfhd {
    private static final zzfft f14438a = new zzfft();
    private final Map<Class<?>, Method> f14439b = new HashMap();

    private zzfft() {
    }

    public static zzfft m13828a() {
        return f14438a;
    }

    public final boolean mo1899a(Class<?> cls) {
        return zzffu.class.isAssignableFrom(cls);
    }

    public final zzfhc mo1900b(Class<?> cls) {
        if (zzffu.class.isAssignableFrom(cls)) {
            try {
                Method method = (Method) this.f14439b.get(cls);
                if (method == null) {
                    method = cls.getDeclaredMethod("buildMessageInfo", new Class[0]);
                    method.setAccessible(true);
                    this.f14439b.put(cls, method);
                }
                return (zzfhc) method.invoke(null, new Object[0]);
            } catch (Throwable e) {
                String str = "Unable to get message info for ";
                String valueOf = String.valueOf(cls.getName());
                throw new RuntimeException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), e);
            }
        }
        String str2 = "Unsupported message type: ";
        valueOf = String.valueOf(cls.getName());
        throw new IllegalArgumentException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
    }
}
