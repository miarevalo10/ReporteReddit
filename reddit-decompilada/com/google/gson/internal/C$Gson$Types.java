package com.google.gson.internal;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

public final class C$Gson$Types {
    static final Type[] f8747a = new Type[0];

    /* compiled from: $Gson$Types */
    private static final class GenericArrayTypeImpl implements Serializable, GenericArrayType {
        private final Type f8741a;

        public GenericArrayTypeImpl(Type type) {
            this.f8741a = C$Gson$Types.m7524a(type);
        }

        public final Type getGenericComponentType() {
            return this.f8741a;
        }

        public final boolean equals(Object obj) {
            return (!(obj instanceof GenericArrayType) || C$Gson$Types.m7528a((Type) this, (GenericArrayType) obj) == null) ? null : true;
        }

        public final int hashCode() {
            return this.f8741a.hashCode();
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(C$Gson$Types.m7532c(this.f8741a));
            stringBuilder.append("[]");
            return stringBuilder.toString();
        }
    }

    /* compiled from: $Gson$Types */
    private static final class ParameterizedTypeImpl implements Serializable, ParameterizedType {
        private final Type f8742a;
        private final Type f8743b;
        private final Type[] f8744c;

        public ParameterizedTypeImpl(Type type, Type type2, Type... typeArr) {
            int i = 0;
            if (type2 instanceof Class) {
                int i2;
                Class cls = (Class) type2;
                boolean z = true;
                if (!Modifier.isStatic(cls.getModifiers())) {
                    if (cls.getEnclosingClass() != null) {
                        i2 = 0;
                        if (type == null) {
                            if (i2 != 0) {
                                z = false;
                            }
                        }
                        C$Gson$Preconditions.m7522a(z);
                    }
                }
                i2 = true;
                if (type == null) {
                    if (i2 != 0) {
                        z = false;
                    }
                }
                C$Gson$Preconditions.m7522a(z);
            }
            if (type == null) {
                type = null;
            } else {
                type = C$Gson$Types.m7524a(type);
            }
            this.f8742a = type;
            this.f8743b = C$Gson$Types.m7524a(type2);
            this.f8744c = (Type[]) typeArr.clone();
            while (i < this.f8744c.length) {
                C$Gson$Preconditions.m7521a(this.f8744c[i]);
                C$Gson$Types.m7534e(this.f8744c[i]);
                this.f8744c[i] = C$Gson$Types.m7524a(this.f8744c[i]);
                i++;
            }
        }

        public final Type[] getActualTypeArguments() {
            return (Type[]) this.f8744c.clone();
        }

        public final Type getRawType() {
            return this.f8743b;
        }

        public final Type getOwnerType() {
            return this.f8742a;
        }

        public final boolean equals(Object obj) {
            return (!(obj instanceof ParameterizedType) || C$Gson$Types.m7528a((Type) this, (ParameterizedType) obj) == null) ? null : true;
        }

        public final int hashCode() {
            return (Arrays.hashCode(this.f8744c) ^ this.f8743b.hashCode()) ^ C$Gson$Types.m7523a(this.f8742a);
        }

        public final String toString() {
            int i = 1;
            StringBuilder stringBuilder = new StringBuilder(30 * (this.f8744c.length + 1));
            stringBuilder.append(C$Gson$Types.m7532c(this.f8743b));
            if (this.f8744c.length == 0) {
                return stringBuilder.toString();
            }
            stringBuilder.append(Operation.LESS_THAN);
            stringBuilder.append(C$Gson$Types.m7532c(this.f8744c[0]));
            while (i < this.f8744c.length) {
                stringBuilder.append(", ");
                stringBuilder.append(C$Gson$Types.m7532c(this.f8744c[i]));
                i++;
            }
            stringBuilder.append(Operation.GREATER_THAN);
            return stringBuilder.toString();
        }
    }

    /* compiled from: $Gson$Types */
    private static final class WildcardTypeImpl implements Serializable, WildcardType {
        private final Type f8745a;
        private final Type f8746b;

        public WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            boolean z = true;
            C$Gson$Preconditions.m7522a(typeArr2.length <= 1);
            C$Gson$Preconditions.m7522a(typeArr.length == 1);
            if (typeArr2.length == 1) {
                C$Gson$Preconditions.m7521a(typeArr2[0]);
                C$Gson$Types.m7534e(typeArr2[0]);
                if (typeArr[0] != Object.class) {
                    z = false;
                }
                C$Gson$Preconditions.m7522a(z);
                this.f8746b = C$Gson$Types.m7524a(typeArr2[0]);
                this.f8745a = Object.class;
                return;
            }
            C$Gson$Preconditions.m7521a(typeArr[0]);
            C$Gson$Types.m7534e(typeArr[0]);
            this.f8746b = null;
            this.f8745a = C$Gson$Types.m7524a(typeArr[0]);
        }

        public final Type[] getUpperBounds() {
            return new Type[]{this.f8745a};
        }

        public final Type[] getLowerBounds() {
            if (this.f8746b == null) {
                return C$Gson$Types.f8747a;
            }
            return new Type[]{this.f8746b};
        }

        public final boolean equals(Object obj) {
            return (!(obj instanceof WildcardType) || C$Gson$Types.m7528a((Type) this, (WildcardType) obj) == null) ? null : true;
        }

        public final int hashCode() {
            return (this.f8746b != null ? this.f8746b.hashCode() + 31 : 1) ^ (31 + this.f8745a.hashCode());
        }

        public final String toString() {
            StringBuilder stringBuilder;
            if (this.f8746b != null) {
                stringBuilder = new StringBuilder("? super ");
                stringBuilder.append(C$Gson$Types.m7532c(this.f8746b));
                return stringBuilder.toString();
            } else if (this.f8745a == Object.class) {
                return Operation.EMPTY_PARAM;
            } else {
                stringBuilder = new StringBuilder("? extends ");
                stringBuilder.append(C$Gson$Types.m7532c(this.f8745a));
                return stringBuilder.toString();
            }
        }
    }

    private static GenericArrayType m7535f(Type type) {
        return new GenericArrayTypeImpl(type);
    }

    public static Type m7524a(Type type) {
        if (type instanceof Class) {
            type = (Class) type;
            if (type.isArray()) {
                type = new GenericArrayTypeImpl(C$Gson$Types.m7524a(type.getComponentType()));
            }
            return type;
        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new ParameterizedTypeImpl(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        } else if (type instanceof GenericArrayType) {
            return new GenericArrayTypeImpl(((GenericArrayType) type).getGenericComponentType());
        } else {
            if (!(type instanceof WildcardType)) {
                return type;
            }
            WildcardType wildcardType = (WildcardType) type;
            return new WildcardTypeImpl(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
        }
    }

    public static Class<?> m7529b(Type type) {
        while (!(type instanceof Class)) {
            if (type instanceof ParameterizedType) {
                type = ((ParameterizedType) type).getRawType();
                C$Gson$Preconditions.m7522a(type instanceof Class);
                return (Class) type;
            } else if (type instanceof GenericArrayType) {
                return Array.newInstance(C$Gson$Types.m7529b(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
            } else {
                if (type instanceof TypeVariable) {
                    return Object.class;
                }
                if (type instanceof WildcardType) {
                    type = ((WildcardType) type).getUpperBounds()[0];
                } else {
                    String str;
                    if (type == null) {
                        str = "null";
                    } else {
                        str = type.getClass().getName();
                    }
                    StringBuilder stringBuilder = new StringBuilder("Expected a Class, ParameterizedType, or GenericArrayType, but <");
                    stringBuilder.append(type);
                    stringBuilder.append("> is of type ");
                    stringBuilder.append(str);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
        }
        return (Class) type;
    }

    public static boolean m7528a(Type type, Type type2) {
        while (type != type2) {
            if (type instanceof Class) {
                return type.equals(type2);
            }
            if (type instanceof ParameterizedType) {
                if (!(type2 instanceof ParameterizedType)) {
                    return false;
                }
                boolean z;
                ParameterizedType parameterizedType = (ParameterizedType) type;
                ParameterizedType parameterizedType2 = (ParameterizedType) type2;
                Type ownerType = parameterizedType.getOwnerType();
                Type ownerType2 = parameterizedType2.getOwnerType();
                if (ownerType != ownerType2) {
                    if (ownerType == null || !ownerType.equals(ownerType2)) {
                        z = false;
                        if (z || !parameterizedType.getRawType().equals(parameterizedType2.getRawType()) || Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments()) == null) {
                            return false;
                        }
                        return true;
                    }
                }
                z = true;
                if (z) {
                }
                return false;
            } else if (type instanceof GenericArrayType) {
                if (!(type2 instanceof GenericArrayType)) {
                    return false;
                }
                GenericArrayType genericArrayType = (GenericArrayType) type2;
                type = ((GenericArrayType) type).getGenericComponentType();
                type2 = genericArrayType.getGenericComponentType();
            } else if (type instanceof WildcardType) {
                if (!(type2 instanceof WildcardType)) {
                    return false;
                }
                WildcardType wildcardType = (WildcardType) type;
                WildcardType wildcardType2 = (WildcardType) type2;
                if (!Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) || Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds()) == null) {
                    return false;
                }
                return true;
            } else if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
                return false;
            } else {
                TypeVariable typeVariable = (TypeVariable) type;
                TypeVariable typeVariable2 = (TypeVariable) type2;
                if (typeVariable.getGenericDeclaration() != typeVariable2.getGenericDeclaration() || typeVariable.getName().equals(typeVariable2.getName()) == null) {
                    return false;
                }
                return true;
            }
        }
        return true;
    }

    static int m7523a(Object obj) {
        return obj != null ? obj.hashCode() : null;
    }

    public static String m7532c(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    private static Type m7526a(Type type, Class<?> cls, Class<?> cls2) {
        while (cls2 != cls) {
            if (cls2.isInterface() != null) {
                type = cls.getInterfaces();
                int length = type.length;
                for (int i = 0; i < length; i++) {
                    if (type[i] == cls2) {
                        return cls.getGenericInterfaces()[i];
                    }
                    if (cls2.isAssignableFrom(type[i])) {
                        cls = cls.getGenericInterfaces()[i];
                        type = type[i];
                        break;
                    }
                }
            }
            if (cls.isInterface() == null) {
                while (cls != Object.class) {
                    Class<?> superclass = cls.getSuperclass();
                    if (superclass == cls2) {
                        return cls.getGenericSuperclass();
                    }
                    if (cls2.isAssignableFrom(superclass)) {
                        cls = cls.getGenericSuperclass();
                        Class<?> cls3 = cls;
                        Type type2 = type;
                        Object obj = cls3;
                    } else {
                        cls = superclass;
                    }
                }
            }
            return cls2;
        }
        return type;
    }

    private static Type m7530b(Type type, Class<?> cls, Class<?> cls2) {
        C$Gson$Preconditions.m7522a(cls2.isAssignableFrom(cls));
        return C$Gson$Types.m7527a(type, (Class) cls, C$Gson$Types.m7526a(type, (Class) cls, (Class) cls2));
    }

    public static Type m7533d(Type type) {
        if (type instanceof GenericArrayType) {
            return ((GenericArrayType) type).getGenericComponentType();
        }
        return ((Class) type).getComponentType();
    }

    public static Type m7525a(Type type, Class<?> cls) {
        type = C$Gson$Types.m7530b(type, cls, Collection.class);
        if ((type instanceof WildcardType) != null) {
            type = ((WildcardType) type).getUpperBounds()[0];
        }
        if ((type instanceof ParameterizedType) != null) {
            return ((ParameterizedType) type).getActualTypeArguments()[0];
        }
        return Object.class;
    }

    public static Type[] m7531b(Type type, Class<?> cls) {
        if (type == Properties.class) {
            return new Type[]{String.class, String.class};
        }
        type = C$Gson$Types.m7530b(type, cls, Map.class);
        if ((type instanceof ParameterizedType) != null) {
            return ((ParameterizedType) type).getActualTypeArguments();
        }
        return new Type[]{Object.class, Object.class};
    }

    public static Type m7527a(Type type, Class<?> cls, Type type2) {
        while (true) {
            int i = 0;
            if (!(type2 instanceof TypeVariable)) {
                break;
            }
            Type type3;
            type2 = (TypeVariable) type2;
            GenericDeclaration genericDeclaration = type2.getGenericDeclaration();
            Class cls2 = genericDeclaration instanceof Class ? (Class) genericDeclaration : null;
            if (cls2 != null) {
                Type a = C$Gson$Types.m7526a(type, (Class) cls, cls2);
                if (a instanceof ParameterizedType) {
                    TypeVariable[] typeParameters = cls2.getTypeParameters();
                    while (i < typeParameters.length) {
                        if (type2.equals(typeParameters[i])) {
                            type3 = ((ParameterizedType) a).getActualTypeArguments()[i];
                            if (type3 == type2) {
                                return type3;
                            }
                            type2 = type3;
                        } else {
                            i++;
                        }
                    }
                    throw new NoSuchElementException();
                }
            }
            type3 = type2;
            if (type3 == type2) {
                return type3;
            }
            type2 = type3;
        }
        if (type2 instanceof Class) {
            cls2 = (Class) type2;
            if (cls2.isArray()) {
                type2 = cls2.getComponentType();
                type = C$Gson$Types.m7527a(type, (Class) cls, type2);
                if (type2 == type) {
                    return cls2;
                }
                return C$Gson$Types.m7535f(type);
            }
        }
        if (type2 instanceof GenericArrayType) {
            GenericArrayType genericArrayType = (GenericArrayType) type2;
            type3 = genericArrayType.getGenericComponentType();
            type = C$Gson$Types.m7527a(type, (Class) cls, type3);
            if (type3 == type) {
                return genericArrayType;
            }
            return C$Gson$Types.m7535f(type);
        } else if (type2 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type2;
            type3 = parameterizedType.getOwnerType();
            Type a2 = C$Gson$Types.m7527a(type, (Class) cls, type3);
            int i2 = a2 != type3 ? 1 : 0;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            int length = actualTypeArguments.length;
            while (i < length) {
                Type a3 = C$Gson$Types.m7527a(type, (Class) cls, actualTypeArguments[i]);
                if (a3 != actualTypeArguments[i]) {
                    if (i2 == 0) {
                        actualTypeArguments = (Type[]) actualTypeArguments.clone();
                        i2 = 1;
                    }
                    actualTypeArguments[i] = a3;
                }
                i++;
            }
            return i2 != 0 ? new ParameterizedTypeImpl(a2, parameterizedType.getRawType(), actualTypeArguments) : parameterizedType;
        } else if (!(type2 instanceof WildcardType)) {
            return type2;
        } else {
            WildcardType wildcardType = (WildcardType) type2;
            Type[] lowerBounds = wildcardType.getLowerBounds();
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (lowerBounds.length == 1) {
                if (C$Gson$Types.m7527a(type, (Class) cls, lowerBounds[0]) != lowerBounds[0]) {
                    return new WildcardTypeImpl(new Type[]{Object.class}, new Type[]{C$Gson$Types.m7527a(type, (Class) cls, lowerBounds[0])});
                }
            } else if (upperBounds.length == 1 && C$Gson$Types.m7527a(type, (Class) cls, upperBounds[0]) != upperBounds[0]) {
                return new WildcardTypeImpl(new Type[]{C$Gson$Types.m7527a(type, (Class) cls, upperBounds[0])}, f8747a);
            }
            return wildcardType;
        }
    }

    static void m7534e(Type type) {
        boolean z;
        if (type instanceof Class) {
            if (((Class) type).isPrimitive() != null) {
                z = null;
                C$Gson$Preconditions.m7522a(z);
            }
        }
        z = true;
        C$Gson$Preconditions.m7522a(z);
    }
}
