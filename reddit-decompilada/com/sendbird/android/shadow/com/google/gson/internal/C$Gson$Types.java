package com.sendbird.android.shadow.com.google.gson.internal;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

public final class C$Gson$Types {
    static final Type[] f22908a = new Type[0];

    /* compiled from: $Gson$Types */
    private static final class GenericArrayTypeImpl implements Serializable, GenericArrayType {
        private final Type f22902a;

        public GenericArrayTypeImpl(Type type) {
            this.f22902a = C$Gson$Types.m25096a(type);
        }

        public final Type getGenericComponentType() {
            return this.f22902a;
        }

        public final boolean equals(Object obj) {
            return (!(obj instanceof GenericArrayType) || C$Gson$Types.m25101a((Type) this, (GenericArrayType) obj) == null) ? null : true;
        }

        public final int hashCode() {
            return this.f22902a.hashCode();
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(C$Gson$Types.m25105c(this.f22902a));
            stringBuilder.append("[]");
            return stringBuilder.toString();
        }
    }

    /* compiled from: $Gson$Types */
    private static final class ParameterizedTypeImpl implements Serializable, ParameterizedType {
        private final Type f22903a;
        private final Type f22904b;
        private final Type[] f22905c;

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
                        C$Gson$Preconditions.m25094a(z);
                    }
                }
                i2 = true;
                if (type == null) {
                    if (i2 != 0) {
                        z = false;
                    }
                }
                C$Gson$Preconditions.m25094a(z);
            }
            if (type == null) {
                type = null;
            } else {
                type = C$Gson$Types.m25096a(type);
            }
            this.f22903a = type;
            this.f22904b = C$Gson$Types.m25096a(type2);
            this.f22905c = (Type[]) typeArr.clone();
            type = this.f22905c.length;
            while (i < type) {
                C$Gson$Preconditions.m25093a(this.f22905c[i]);
                C$Gson$Types.m25107e(this.f22905c[i]);
                this.f22905c[i] = C$Gson$Types.m25096a(this.f22905c[i]);
                i++;
            }
        }

        public final Type[] getActualTypeArguments() {
            return (Type[]) this.f22905c.clone();
        }

        public final Type getRawType() {
            return this.f22904b;
        }

        public final Type getOwnerType() {
            return this.f22903a;
        }

        public final boolean equals(Object obj) {
            return (!(obj instanceof ParameterizedType) || C$Gson$Types.m25101a((Type) this, (ParameterizedType) obj) == null) ? null : true;
        }

        public final int hashCode() {
            return (Arrays.hashCode(this.f22905c) ^ this.f22904b.hashCode()) ^ C$Gson$Types.m25095a(this.f22903a);
        }

        public final String toString() {
            int length = this.f22905c.length;
            if (length == 0) {
                return C$Gson$Types.m25105c(this.f22904b);
            }
            StringBuilder stringBuilder = new StringBuilder(30 * (length + 1));
            stringBuilder.append(C$Gson$Types.m25105c(this.f22904b));
            stringBuilder.append(Operation.LESS_THAN);
            stringBuilder.append(C$Gson$Types.m25105c(this.f22905c[0]));
            for (int i = 1; i < length; i++) {
                stringBuilder.append(", ");
                stringBuilder.append(C$Gson$Types.m25105c(this.f22905c[i]));
            }
            stringBuilder.append(Operation.GREATER_THAN);
            return stringBuilder.toString();
        }
    }

    /* compiled from: $Gson$Types */
    private static final class WildcardTypeImpl implements Serializable, WildcardType {
        private final Type f22906a;
        private final Type f22907b;

        public WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            boolean z = true;
            C$Gson$Preconditions.m25094a(typeArr2.length <= 1);
            C$Gson$Preconditions.m25094a(typeArr.length == 1);
            if (typeArr2.length == 1) {
                C$Gson$Preconditions.m25093a(typeArr2[0]);
                C$Gson$Types.m25107e(typeArr2[0]);
                if (typeArr[0] != Object.class) {
                    z = false;
                }
                C$Gson$Preconditions.m25094a(z);
                this.f22907b = C$Gson$Types.m25096a(typeArr2[0]);
                this.f22906a = Object.class;
                return;
            }
            C$Gson$Preconditions.m25093a(typeArr[0]);
            C$Gson$Types.m25107e(typeArr[0]);
            this.f22907b = null;
            this.f22906a = C$Gson$Types.m25096a(typeArr[0]);
        }

        public final Type[] getUpperBounds() {
            return new Type[]{this.f22906a};
        }

        public final Type[] getLowerBounds() {
            if (this.f22907b == null) {
                return C$Gson$Types.f22908a;
            }
            return new Type[]{this.f22907b};
        }

        public final boolean equals(Object obj) {
            return (!(obj instanceof WildcardType) || C$Gson$Types.m25101a((Type) this, (WildcardType) obj) == null) ? null : true;
        }

        public final int hashCode() {
            return (this.f22907b != null ? this.f22907b.hashCode() + 31 : 1) ^ (31 + this.f22906a.hashCode());
        }

        public final String toString() {
            StringBuilder stringBuilder;
            if (this.f22907b != null) {
                stringBuilder = new StringBuilder("? super ");
                stringBuilder.append(C$Gson$Types.m25105c(this.f22907b));
                return stringBuilder.toString();
            } else if (this.f22906a == Object.class) {
                return Operation.EMPTY_PARAM;
            } else {
                stringBuilder = new StringBuilder("? extends ");
                stringBuilder.append(C$Gson$Types.m25105c(this.f22906a));
                return stringBuilder.toString();
            }
        }
    }

    private static GenericArrayType m25108f(Type type) {
        return new GenericArrayTypeImpl(type);
    }

    public static Type m25096a(Type type) {
        if (type instanceof Class) {
            type = (Class) type;
            if (type.isArray()) {
                type = new GenericArrayTypeImpl(C$Gson$Types.m25096a(type.getComponentType()));
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

    public static Class<?> m25102b(Type type) {
        while (!(type instanceof Class)) {
            if (type instanceof ParameterizedType) {
                type = ((ParameterizedType) type).getRawType();
                C$Gson$Preconditions.m25094a(type instanceof Class);
                return (Class) type;
            } else if (type instanceof GenericArrayType) {
                return Array.newInstance(C$Gson$Types.m25102b(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
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

    public static boolean m25101a(Type type, Type type2) {
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

    static int m25095a(Object obj) {
        return obj != null ? obj.hashCode() : null;
    }

    public static String m25105c(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    private static Type m25098a(Type type, Class<?> cls, Class<?> cls2) {
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

    private static Type m25103b(Type type, Class<?> cls, Class<?> cls2) {
        C$Gson$Preconditions.m25094a(cls2.isAssignableFrom(cls));
        return C$Gson$Types.m25099a(type, (Class) cls, C$Gson$Types.m25098a(type, (Class) cls, (Class) cls2));
    }

    public static Type m25106d(Type type) {
        if (type instanceof GenericArrayType) {
            return ((GenericArrayType) type).getGenericComponentType();
        }
        return ((Class) type).getComponentType();
    }

    public static Type m25097a(Type type, Class<?> cls) {
        type = C$Gson$Types.m25103b(type, cls, Collection.class);
        if ((type instanceof WildcardType) != null) {
            type = ((WildcardType) type).getUpperBounds()[0];
        }
        if ((type instanceof ParameterizedType) != null) {
            return ((ParameterizedType) type).getActualTypeArguments()[0];
        }
        return Object.class;
    }

    public static Type[] m25104b(Type type, Class<?> cls) {
        if (type == Properties.class) {
            return new Type[]{String.class, String.class};
        }
        type = C$Gson$Types.m25103b(type, cls, Map.class);
        if ((type instanceof ParameterizedType) != null) {
            return ((ParameterizedType) type).getActualTypeArguments();
        }
        return new Type[]{Object.class, Object.class};
    }

    public static Type m25099a(Type type, Class<?> cls, Type type2) {
        return C$Gson$Types.m25100a(type, cls, type2, new HashSet());
    }

    private static Type m25100a(Type type, Class<?> cls, Type type2, Collection<TypeVariable> collection) {
        Type type3;
        do {
            int i = 0;
            if (type2 instanceof TypeVariable) {
                type3 = (TypeVariable) type2;
                if (collection.contains(type3)) {
                    return type2;
                }
                collection.add(type3);
                type2 = type3.getGenericDeclaration();
                Class cls2 = type2 instanceof Class ? (Class) type2 : null;
                if (cls2 != null) {
                    Type a = C$Gson$Types.m25098a(type, (Class) cls, cls2);
                    if (a instanceof ParameterizedType) {
                        type2 = cls2.getTypeParameters();
                        int length = type2.length;
                        while (i < length) {
                            if (type3.equals(type2[i])) {
                                type2 = ((ParameterizedType) a).getActualTypeArguments()[i];
                                continue;
                            } else {
                                i++;
                            }
                        }
                        throw new NoSuchElementException();
                    }
                }
                type2 = type3;
                continue;
            } else {
                if (type2 instanceof Class) {
                    Class cls3 = (Class) type2;
                    if (cls3.isArray()) {
                        type2 = cls3.getComponentType();
                        type = C$Gson$Types.m25100a(type, cls, type2, collection);
                        if (type2 == type) {
                            return cls3;
                        }
                        return C$Gson$Types.m25108f(type);
                    }
                }
                if (type2 instanceof GenericArrayType) {
                    GenericArrayType genericArrayType = (GenericArrayType) type2;
                    type3 = genericArrayType.getGenericComponentType();
                    type = C$Gson$Types.m25100a(type, cls, type3, collection);
                    if (type3 == type) {
                        return genericArrayType;
                    }
                    return C$Gson$Types.m25108f(type);
                } else if (type2 instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type2;
                    type3 = parameterizedType.getOwnerType();
                    Type a2 = C$Gson$Types.m25100a(type, cls, type3, collection);
                    int i2 = a2 != type3 ? 1 : 0;
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    int length2 = actualTypeArguments.length;
                    while (i < length2) {
                        Type a3 = C$Gson$Types.m25100a(type, cls, actualTypeArguments[i], collection);
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
                        type = C$Gson$Types.m25100a(type, cls, lowerBounds[0], collection);
                        if (type != lowerBounds[0]) {
                            return new WildcardTypeImpl(new Type[]{Object.class}, (type instanceof WildcardType) != null ? ((WildcardType) type).getLowerBounds() : new Type[]{type});
                        }
                    } else if (upperBounds.length == 1) {
                        type = C$Gson$Types.m25100a(type, cls, upperBounds[0], collection);
                        if (type != upperBounds[0]) {
                            return new WildcardTypeImpl((type instanceof WildcardType) != null ? ((WildcardType) type).getUpperBounds() : new Type[]{type}, f22908a);
                        }
                    }
                    return wildcardType;
                }
            }
        } while (type2 != type3);
        return type2;
    }

    static void m25107e(Type type) {
        boolean z;
        if (type instanceof Class) {
            if (((Class) type).isPrimitive() != null) {
                z = null;
                C$Gson$Preconditions.m25094a(z);
            }
        }
        z = true;
        C$Gson$Preconditions.m25094a(z);
    }
}
