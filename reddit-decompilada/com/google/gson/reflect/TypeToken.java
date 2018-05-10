package com.google.gson.reflect;

import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class TypeToken<T> {
    public final Class<? super T> f8834a;
    public final Type f8835b;
    final int f8836c;

    protected TypeToken() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        this.f8835b = C$Gson$Types.m7524a(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
        this.f8834a = C$Gson$Types.m7529b(this.f8835b);
        this.f8836c = this.f8835b.hashCode();
    }

    private TypeToken(Type type) {
        this.f8835b = C$Gson$Types.m7524a((Type) C$Gson$Preconditions.m7521a((Object) type));
        this.f8834a = C$Gson$Types.m7529b(this.f8835b);
        this.f8836c = this.f8835b.hashCode();
    }

    public final int hashCode() {
        return this.f8836c;
    }

    public final boolean equals(Object obj) {
        return (!(obj instanceof TypeToken) || C$Gson$Types.m7528a(this.f8835b, ((TypeToken) obj).f8835b) == null) ? null : true;
    }

    public final String toString() {
        return C$Gson$Types.m7532c(this.f8835b);
    }

    public static TypeToken<?> m7571a(Type type) {
        return new TypeToken(type);
    }

    public static <T> TypeToken<T> m7570a(Class<T> cls) {
        return new TypeToken(cls);
    }
}
