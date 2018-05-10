package com.squareup.moshi;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;

public final class Types {
    static final Type[] f23710a = new Type[0];

    private static final class GenericArrayTypeImpl implements GenericArrayType {
        private final Type f23704a;

        GenericArrayTypeImpl(Type type) {
            this.f23704a = Types.m25722a(type);
        }

        public final Type getGenericComponentType() {
            return this.f23704a;
        }

        public final boolean equals(Object obj) {
            return (!(obj instanceof GenericArrayType) || Types.m25727a((Type) this, (GenericArrayType) obj) == null) ? null : true;
        }

        public final int hashCode() {
            return this.f23704a.hashCode();
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Types.m25731c(this.f23704a));
            stringBuilder.append("[]");
            return stringBuilder.toString();
        }
    }

    private static final class ParameterizedTypeImpl implements ParameterizedType {
        final Type[] f23705a;
        private final Type f23706b;
        private final Type f23707c;

        ParameterizedTypeImpl(Type type, Type type2, Type... typeArr) {
            int i = 0;
            if (type2 instanceof Class) {
                int i2 = 1;
                int i3 = type == null ? 1 : 0;
                if (((Class) type2).getEnclosingClass() != null) {
                    i2 = 0;
                }
                if (i3 != i2) {
                    StringBuilder stringBuilder = new StringBuilder("unexpected owner type for ");
                    stringBuilder.append(type2);
                    stringBuilder.append(": ");
                    stringBuilder.append(type);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
            if (type == null) {
                type = null;
            } else {
                type = Types.m25722a(type);
            }
            this.f23706b = type;
            this.f23707c = Types.m25722a(type2);
            this.f23705a = (Type[]) typeArr.clone();
            while (i < this.f23705a.length) {
                if (this.f23705a[i] == null) {
                    throw new NullPointerException();
                }
                Types.m25735g(this.f23705a[i]);
                this.f23705a[i] = Types.m25722a(this.f23705a[i]);
                i++;
            }
        }

        public final Type[] getActualTypeArguments() {
            return (Type[]) this.f23705a.clone();
        }

        public final Type getRawType() {
            return this.f23707c;
        }

        public final Type getOwnerType() {
            return this.f23706b;
        }

        public final boolean equals(Object obj) {
            return (!(obj instanceof ParameterizedType) || Types.m25727a((Type) this, (ParameterizedType) obj) == null) ? null : true;
        }

        public final int hashCode() {
            return (Arrays.hashCode(this.f23705a) ^ this.f23707c.hashCode()) ^ Types.m25720a(this.f23706b);
        }

        public final String toString() {
            int i = 1;
            StringBuilder stringBuilder = new StringBuilder(30 * (this.f23705a.length + 1));
            stringBuilder.append(Types.m25731c(this.f23707c));
            if (this.f23705a.length == 0) {
                return stringBuilder.toString();
            }
            stringBuilder.append(Operation.LESS_THAN);
            stringBuilder.append(Types.m25731c(this.f23705a[0]));
            while (i < this.f23705a.length) {
                stringBuilder.append(", ");
                stringBuilder.append(Types.m25731c(this.f23705a[i]));
                i++;
            }
            stringBuilder.append(Operation.GREATER_THAN);
            return stringBuilder.toString();
        }
    }

    private static final class WildcardTypeImpl implements WildcardType {
        private final Type f23708a;
        private final Type f23709b;

        WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            if (typeArr2.length > 1) {
                throw new IllegalArgumentException();
            } else if (typeArr.length != 1) {
                throw new IllegalArgumentException();
            } else if (typeArr2.length == 1) {
                if (typeArr2[0] == null) {
                    throw new NullPointerException();
                }
                Types.m25735g(typeArr2[0]);
                if (typeArr[0] != Object.class) {
                    throw new IllegalArgumentException();
                }
                this.f23709b = Types.m25722a(typeArr2[0]);
                this.f23708a = Object.class;
            } else if (typeArr[0] == null) {
                throw new NullPointerException();
            } else {
                Types.m25735g(typeArr[0]);
                this.f23709b = null;
                this.f23708a = Types.m25722a(typeArr[0]);
            }
        }

        public final Type[] getUpperBounds() {
            return new Type[]{this.f23708a};
        }

        public final Type[] getLowerBounds() {
            if (this.f23709b == null) {
                return Types.f23710a;
            }
            return new Type[]{this.f23709b};
        }

        public final boolean equals(Object obj) {
            return (!(obj instanceof WildcardType) || Types.m25727a((Type) this, (WildcardType) obj) == null) ? null : true;
        }

        public final int hashCode() {
            return (this.f23709b != null ? this.f23709b.hashCode() + 31 : 1) ^ (31 + this.f23708a.hashCode());
        }

        public final String toString() {
            StringBuilder stringBuilder;
            if (this.f23709b != null) {
                stringBuilder = new StringBuilder("? super ");
                stringBuilder.append(Types.m25731c(this.f23709b));
                return stringBuilder.toString();
            } else if (this.f23708a == Object.class) {
                return Operation.EMPTY_PARAM;
            } else {
                stringBuilder = new StringBuilder("? extends ");
                stringBuilder.append(Types.m25731c(this.f23708a));
                return stringBuilder.toString();
            }
        }
    }

    public static Set<? extends Annotation> m25726a(Set<? extends Annotation> set, Class<? extends Annotation> cls) {
        if (!cls.isAnnotationPresent(JsonQualifier.class)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(cls);
            stringBuilder.append(" is not a JsonQualifier.");
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (set.isEmpty()) {
            return null;
        } else {
            for (Annotation annotation : set) {
                if (cls.equals(annotation.annotationType())) {
                    cls = new LinkedHashSet(set);
                    cls.remove(annotation);
                    return Collections.unmodifiableSet(cls);
                }
            }
            return null;
        }
    }

    public static ParameterizedType m25721a(Type type, Type... typeArr) {
        return new ParameterizedTypeImpl(null, type, typeArr);
    }

    private static GenericArrayType m25736h(Type type) {
        return new GenericArrayTypeImpl(type);
    }

    static Type m25722a(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            return cls.isArray() ? new GenericArrayTypeImpl(m25722a(cls.getComponentType())) : cls;
        } else if (type instanceof ParameterizedType) {
            if (type instanceof ParameterizedTypeImpl) {
                return type;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new ParameterizedTypeImpl(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        } else if (type instanceof GenericArrayType) {
            if (type instanceof GenericArrayTypeImpl) {
                return type;
            }
            return new GenericArrayTypeImpl(((GenericArrayType) type).getGenericComponentType());
        } else if (!(type instanceof WildcardType) || (type instanceof WildcardTypeImpl)) {
            return type;
        } else {
            WildcardType wildcardType = (WildcardType) type;
            return new WildcardTypeImpl(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
        }
    }

    public static Class<?> m25728b(Type type) {
        while (!(type instanceof Class)) {
            if (type instanceof ParameterizedType) {
                return (Class) ((ParameterizedType) type).getRawType();
            }
            if (type instanceof GenericArrayType) {
                return Array.newInstance(m25728b(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
            }
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
        return (Class) type;
    }

    public static boolean m25727a(Type type, Type type2) {
        while (type != type2) {
            if (type instanceof Class) {
                if (!(type2 instanceof GenericArrayType)) {
                    return type.equals(type2);
                }
                type = ((Class) type).getComponentType();
                type2 = ((GenericArrayType) type2).getGenericComponentType();
            } else if (type instanceof ParameterizedType) {
                if (!(type2 instanceof ParameterizedType)) {
                    return false;
                }
                boolean z;
                ParameterizedType parameterizedType = (ParameterizedType) type;
                ParameterizedType parameterizedType2 = (ParameterizedType) type2;
                Object[] objArr;
                if (parameterizedType instanceof ParameterizedTypeImpl) {
                    objArr = ((ParameterizedTypeImpl) parameterizedType).f23705a;
                } else {
                    objArr = parameterizedType.getActualTypeArguments();
                }
                Object[] objArr2;
                if (parameterizedType2 instanceof ParameterizedTypeImpl) {
                    objArr2 = ((ParameterizedTypeImpl) parameterizedType2).f23705a;
                } else {
                    objArr2 = parameterizedType2.getActualTypeArguments();
                }
                Type ownerType = parameterizedType.getOwnerType();
                Type ownerType2 = parameterizedType2.getOwnerType();
                if (ownerType != ownerType2) {
                    if (ownerType == null || !ownerType.equals(ownerType2)) {
                        z = false;
                        if (z || parameterizedType.getRawType().equals(parameterizedType2.getRawType()) == null || Arrays.equals(r1, r3) == null) {
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
                if (type2 instanceof Class) {
                    Type componentType = ((Class) type2).getComponentType();
                    type2 = ((GenericArrayType) type).getGenericComponentType();
                    type = componentType;
                } else if (!(type2 instanceof GenericArrayType)) {
                    return false;
                } else {
                    GenericArrayType genericArrayType = (GenericArrayType) type2;
                    type = ((GenericArrayType) type).getGenericComponentType();
                    type2 = genericArrayType.getGenericComponentType();
                }
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

    static int m25720a(Object obj) {
        return obj != null ? obj.hashCode() : null;
    }

    static String m25731c(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    private static Type m25724a(Type type, Class<?> cls, Class<?> cls2) {
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

    private static Type m25729b(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return m25725a(type, (Class) cls, m25724a(type, (Class) cls, (Class) cls2));
        }
        throw new IllegalArgumentException();
    }

    static Type m25732d(Type type) {
        Class b = m25728b(type);
        return m25725a(type, b, b.getGenericSuperclass());
    }

    static Type m25733e(Type type) {
        if (type instanceof GenericArrayType) {
            return ((GenericArrayType) type).getGenericComponentType();
        }
        return type instanceof Class ? ((Class) type).getComponentType() : null;
    }

    public static Type m25723a(Type type, Class<?> cls) {
        type = m25729b(type, cls, Collection.class);
        if ((type instanceof WildcardType) != null) {
            type = ((WildcardType) type).getUpperBounds()[0];
        }
        if ((type instanceof ParameterizedType) != null) {
            return ((ParameterizedType) type).getActualTypeArguments()[0];
        }
        return Object.class;
    }

    static Type[] m25730b(Type type, Class<?> cls) {
        if (type == Properties.class) {
            return new Type[]{String.class, String.class};
        }
        type = m25729b(type, cls, Map.class);
        if ((type instanceof ParameterizedType) != null) {
            return ((ParameterizedType) type).getActualTypeArguments();
        }
        return new Type[]{Object.class, Object.class};
    }

    static Type m25725a(Type type, Class<?> cls, Type type2) {
        Type type3;
        while (true) {
            int i = 0;
            if (!(type2 instanceof TypeVariable)) {
                break;
            }
            type2 = (TypeVariable) type2;
            GenericDeclaration genericDeclaration = type2.getGenericDeclaration();
            Class cls2 = genericDeclaration instanceof Class ? (Class) genericDeclaration : null;
            if (cls2 != null) {
                Type a = m25724a(type, (Class) cls, cls2);
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
                type = m25725a(type, (Class) cls, type2);
                if (type2 == type) {
                    return cls2;
                }
                return m25736h(type);
            }
        }
        if (type2 instanceof GenericArrayType) {
            GenericArrayType genericArrayType = (GenericArrayType) type2;
            type3 = genericArrayType.getGenericComponentType();
            type = m25725a(type, (Class) cls, type3);
            if (type3 == type) {
                return genericArrayType;
            }
            return m25736h(type);
        } else if (type2 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type2;
            type3 = parameterizedType.getOwnerType();
            Type a2 = m25725a(type, (Class) cls, type3);
            int i2 = a2 != type3 ? 1 : 0;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            int length = actualTypeArguments.length;
            while (i < length) {
                Type a3 = m25725a(type, (Class) cls, actualTypeArguments[i]);
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
                if (m25725a(type, (Class) cls, lowerBounds[0]) != lowerBounds[0]) {
                    return new WildcardTypeImpl(new Type[]{Object.class}, new Type[]{m25725a(type, (Class) cls, lowerBounds[0])});
                }
            } else if (upperBounds.length == 1 && m25725a(type, (Class) cls, upperBounds[0]) != upperBounds[0]) {
                return new WildcardTypeImpl(new Type[]{m25725a(type, (Class) cls, upperBounds[0])}, f23710a);
            }
            return wildcardType;
        }
    }

    static boolean m25734f(Type type) {
        if (!(type == Boolean.class || type == Byte.class || type == Character.class || type == Double.class || type == Float.class || type == Integer.class || type == Long.class || type == Short.class || type == String.class)) {
            if (type != Object.class) {
                return null;
            }
        }
        return true;
    }

    static void m25735g(Type type) {
        if ((type instanceof Class) && ((Class) type).isPrimitive() != null) {
            throw new IllegalArgumentException();
        }
    }
}
