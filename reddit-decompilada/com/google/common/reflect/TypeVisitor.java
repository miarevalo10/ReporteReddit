package com.google.common.reflect;

import com.google.common.collect.Sets;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Set;

abstract class TypeVisitor {
    private final Set<Type> f8533a = Sets.m7254a();

    void mo2430a(Class<?> cls) {
    }

    void mo2436a(GenericArrayType genericArrayType) {
    }

    void mo2431a(ParameterizedType parameterizedType) {
    }

    void mo2432a(TypeVariable<?> typeVariable) {
    }

    void mo2433a(WildcardType wildcardType) {
    }

    TypeVisitor() {
    }

    public final void m7313a(Type... typeArr) {
        for (Object obj : typeArr) {
            if (obj != null && this.f8533a.add(obj)) {
                try {
                    if (obj instanceof TypeVariable) {
                        mo2432a((TypeVariable) obj);
                    } else if (obj instanceof WildcardType) {
                        mo2433a((WildcardType) obj);
                    } else if (obj instanceof ParameterizedType) {
                        mo2431a((ParameterizedType) obj);
                    } else if (obj instanceof Class) {
                        mo2430a((Class) obj);
                    } else if (obj instanceof GenericArrayType) {
                        mo2436a((GenericArrayType) obj);
                    } else {
                        StringBuilder stringBuilder = new StringBuilder("Unknown type: ");
                        stringBuilder.append(obj);
                        throw new AssertionError(stringBuilder.toString());
                    }
                } catch (Throwable th) {
                    this.f8533a.remove(obj);
                }
            }
        }
    }
}
