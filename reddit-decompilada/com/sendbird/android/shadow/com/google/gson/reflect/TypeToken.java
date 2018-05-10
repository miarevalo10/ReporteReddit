package com.sendbird.android.shadow.com.google.gson.reflect;

import com.sendbird.android.shadow.com.google.gson.internal.C$Gson$Preconditions;
import com.sendbird.android.shadow.com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class TypeToken<T> {
    public final Class<? super T> f22996a;
    public final Type f22997b;
    final int f22998c;

    protected TypeToken() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        this.f22997b = C$Gson$Types.m25096a(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
        this.f22996a = C$Gson$Types.m25102b(this.f22997b);
        this.f22998c = this.f22997b.hashCode();
    }

    private TypeToken(Type type) {
        this.f22997b = C$Gson$Types.m25096a((Type) C$Gson$Preconditions.m25093a((Object) type));
        this.f22996a = C$Gson$Types.m25102b(this.f22997b);
        this.f22998c = this.f22997b.hashCode();
    }

    public final int hashCode() {
        return this.f22998c;
    }

    public final boolean equals(Object obj) {
        return (!(obj instanceof TypeToken) || C$Gson$Types.m25101a(this.f22997b, ((TypeToken) obj).f22997b) == null) ? null : true;
    }

    public final String toString() {
        return C$Gson$Types.m25105c(this.f22997b);
    }

    public static TypeToken<?> m25142a(Type type) {
        return new TypeToken(type);
    }

    public static <T> TypeToken<T> m25141a(Class<T> cls) {
        return new TypeToken(cls);
    }
}
