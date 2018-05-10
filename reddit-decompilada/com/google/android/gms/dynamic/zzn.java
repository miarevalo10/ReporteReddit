package com.google.android.gms.dynamic;

import android.os.IBinder;
import com.google.android.gms.dynamic.IObjectWrapper.zza;
import java.lang.reflect.Field;

public final class zzn<T> extends zza {
    private final T f17358a;

    private zzn(T t) {
        this.f17358a = t;
    }

    public static <T> IObjectWrapper m17692a(T t) {
        return new zzn(t);
    }

    public static <T> T m17693a(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper instanceof zzn) {
            return ((zzn) iObjectWrapper).f17358a;
        }
        IBinder asBinder = iObjectWrapper.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        int i = 0;
        int length = declaredFields.length;
        Field field = null;
        int i2 = 0;
        while (i < length) {
            Field field2 = declaredFields[i];
            if (!field2.isSynthetic()) {
                i2++;
                field = field2;
            }
            i++;
        }
        if (i2 != 1) {
            int length2 = declaredFields.length;
            StringBuilder stringBuilder = new StringBuilder(64);
            stringBuilder.append("Unexpected number of IObjectWrapper declared fields: ");
            stringBuilder.append(length2);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (field.isAccessible()) {
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        } else {
            field.setAccessible(true);
            try {
                return field.get(asBinder);
            } catch (Throwable e) {
                throw new IllegalArgumentException("Binder object is null.", e);
            } catch (Throwable e2) {
                throw new IllegalArgumentException("Could not access the field in remoteBinder.", e2);
            }
        }
    }
}
