package retrofit2;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.NoSuchElementException;
import okhttp3.ResponseBody;
import okio.Buffer;

public final class Utils {
    static final Type[] f41288a = new Type[0];

    private static final class GenericArrayTypeImpl implements GenericArrayType {
        private final Type f41282a;

        GenericArrayTypeImpl(Type type) {
            this.f41282a = type;
        }

        public final Type getGenericComponentType() {
            return this.f41282a;
        }

        public final boolean equals(Object obj) {
            return (!(obj instanceof GenericArrayType) || Utils.m43349a((Type) this, (GenericArrayType) obj) == null) ? null : true;
        }

        public final int hashCode() {
            return this.f41282a.hashCode();
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Utils.m43351b(this.f41282a));
            stringBuilder.append("[]");
            return stringBuilder.toString();
        }
    }

    private static final class ParameterizedTypeImpl implements ParameterizedType {
        private final Type f41283a;
        private final Type f41284b;
        private final Type[] f41285c;

        ParameterizedTypeImpl(Type type, Type type2, Type... typeArr) {
            int i;
            int i2 = 0;
            if (type2 instanceof Class) {
                i = 1;
                int i3 = type == null ? 1 : 0;
                if (((Class) type2).getEnclosingClass() != null) {
                    i = 0;
                }
                if (i3 != i) {
                    throw new IllegalArgumentException();
                }
            }
            i = typeArr.length;
            while (i2 < i) {
                Object obj = typeArr[i2];
                Utils.m43343a(obj, "typeArgument == null");
                Utils.m43353c(obj);
                i2++;
            }
            this.f41283a = type;
            this.f41284b = type2;
            this.f41285c = (Type[]) typeArr.clone();
        }

        public final Type[] getActualTypeArguments() {
            return (Type[]) this.f41285c.clone();
        }

        public final Type getRawType() {
            return this.f41284b;
        }

        public final Type getOwnerType() {
            return this.f41283a;
        }

        public final boolean equals(Object obj) {
            return (!(obj instanceof ParameterizedType) || Utils.m43349a((Type) this, (ParameterizedType) obj) == null) ? null : true;
        }

        public final int hashCode() {
            return (Arrays.hashCode(this.f41285c) ^ this.f41284b.hashCode()) ^ Utils.m43341a(this.f41283a);
        }

        public final String toString() {
            if (this.f41285c.length == 0) {
                return Utils.m43351b(this.f41284b);
            }
            int i = 1;
            StringBuilder stringBuilder = new StringBuilder(30 * (this.f41285c.length + 1));
            stringBuilder.append(Utils.m43351b(this.f41284b));
            stringBuilder.append(Operation.LESS_THAN);
            stringBuilder.append(Utils.m43351b(this.f41285c[0]));
            while (i < this.f41285c.length) {
                stringBuilder.append(", ");
                stringBuilder.append(Utils.m43351b(this.f41285c[i]));
                i++;
            }
            stringBuilder.append(Operation.GREATER_THAN);
            return stringBuilder.toString();
        }
    }

    private static final class WildcardTypeImpl implements WildcardType {
        private final Type f41286a;
        private final Type f41287b;

        WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            if (typeArr2.length > 1) {
                throw new IllegalArgumentException();
            } else if (typeArr2.length == 1) {
                if (typeArr2[0] == null) {
                    throw new NullPointerException();
                }
                Utils.m43353c(typeArr2[0]);
                if (typeArr[0] != Object.class) {
                    throw new IllegalArgumentException();
                }
                this.f41287b = typeArr2[0];
                this.f41286a = Object.class;
            } else if (typeArr[0] == null) {
                throw new NullPointerException();
            } else {
                Utils.m43353c(typeArr[0]);
                this.f41287b = null;
                this.f41286a = typeArr[0];
            }
        }

        public final Type[] getUpperBounds() {
            return new Type[]{this.f41286a};
        }

        public final Type[] getLowerBounds() {
            if (this.f41287b == null) {
                return Utils.f41288a;
            }
            return new Type[]{this.f41287b};
        }

        public final boolean equals(Object obj) {
            return (!(obj instanceof WildcardType) || Utils.m43349a((Type) this, (WildcardType) obj) == null) ? null : true;
        }

        public final int hashCode() {
            return (this.f41287b != null ? this.f41287b.hashCode() + 31 : 1) ^ (31 + this.f41286a.hashCode());
        }

        public final String toString() {
            StringBuilder stringBuilder;
            if (this.f41287b != null) {
                stringBuilder = new StringBuilder("? super ");
                stringBuilder.append(Utils.m43351b(this.f41287b));
                return stringBuilder.toString();
            } else if (this.f41286a == Object.class) {
                return Operation.EMPTY_PARAM;
            } else {
                stringBuilder = new StringBuilder("? extends ");
                stringBuilder.append(Utils.m43351b(this.f41286a));
                return stringBuilder.toString();
            }
        }
    }

    public static Class<?> m43342a(Type type) {
        Object obj;
        while (true) {
            m43343a(obj, "type == null");
            if (obj instanceof Class) {
                return (Class) obj;
            }
            if (obj instanceof ParameterizedType) {
                break;
            } else if (obj instanceof GenericArrayType) {
                return Array.newInstance(m43342a(((GenericArrayType) obj).getGenericComponentType()), 0).getClass();
            } else {
                if (obj instanceof TypeVariable) {
                    return Object.class;
                }
                if (obj instanceof WildcardType) {
                    obj = ((WildcardType) obj).getUpperBounds()[0];
                } else {
                    StringBuilder stringBuilder = new StringBuilder("Expected a Class, ParameterizedType, or GenericArrayType, but <");
                    stringBuilder.append(obj);
                    stringBuilder.append("> is of type ");
                    stringBuilder.append(obj.getClass().getName());
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
        }
        type = ((ParameterizedType) obj).getRawType();
        if (type instanceof Class) {
            return (Class) type;
        }
        throw new IllegalArgumentException();
    }

    static boolean m43349a(Type type, Type type2) {
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

    private static Type m43352b(Type type, Class<?> cls, Class<?> cls2) {
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

    static int m43341a(Object obj) {
        return obj != null ? obj.hashCode() : null;
    }

    static String m43351b(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    static Type m43345a(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return m43346a(type, (Class) cls, m43352b(type, cls, cls2));
        }
        throw new IllegalArgumentException();
    }

    private static Type m43346a(Type type, Class<?> cls, Type type2) {
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
                Type b = m43352b(type, cls, cls2);
                if (b instanceof ParameterizedType) {
                    TypeVariable[] typeParameters = cls2.getTypeParameters();
                    while (i < typeParameters.length) {
                        if (type2.equals(typeParameters[i])) {
                            type3 = ((ParameterizedType) b).getActualTypeArguments()[i];
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
                type = m43346a(type, (Class) cls, type2);
                if (type2 == type) {
                    return cls2;
                }
                return new GenericArrayTypeImpl(type);
            }
        }
        if (type2 instanceof GenericArrayType) {
            GenericArrayType genericArrayType = (GenericArrayType) type2;
            type3 = genericArrayType.getGenericComponentType();
            type = m43346a(type, (Class) cls, type3);
            if (type3 == type) {
                return genericArrayType;
            }
            return new GenericArrayTypeImpl(type);
        } else if (type2 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type2;
            type3 = parameterizedType.getOwnerType();
            Type a = m43346a(type, (Class) cls, type3);
            int i2 = a != type3 ? 1 : 0;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            int length = actualTypeArguments.length;
            while (i < length) {
                Type a2 = m43346a(type, (Class) cls, actualTypeArguments[i]);
                if (a2 != actualTypeArguments[i]) {
                    if (i2 == 0) {
                        actualTypeArguments = (Type[]) actualTypeArguments.clone();
                        i2 = 1;
                    }
                    actualTypeArguments[i] = a2;
                }
                i++;
            }
            return i2 != 0 ? new ParameterizedTypeImpl(a, parameterizedType.getRawType(), actualTypeArguments) : parameterizedType;
        } else if (!(type2 instanceof WildcardType)) {
            return type2;
        } else {
            WildcardType wildcardType = (WildcardType) type2;
            Type[] lowerBounds = wildcardType.getLowerBounds();
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (lowerBounds.length == 1) {
                if (m43346a(type, (Class) cls, lowerBounds[0]) != lowerBounds[0]) {
                    return new WildcardTypeImpl(new Type[]{Object.class}, new Type[]{m43346a(type, (Class) cls, lowerBounds[0])});
                }
            } else if (upperBounds.length == 1 && m43346a(type, (Class) cls, upperBounds[0]) != upperBounds[0]) {
                return new WildcardTypeImpl(new Type[]{m43346a(type, (Class) cls, upperBounds[0])}, f41288a);
            }
            return wildcardType;
        }
    }

    static void m43353c(Type type) {
        if ((type instanceof Class) && ((Class) type).isPrimitive() != null) {
            throw new IllegalArgumentException();
        }
    }

    static <T> T m43343a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    static boolean m43350a(Annotation[] annotationArr, Class<? extends Annotation> cls) {
        for (Object isInstance : annotationArr) {
            if (cls.isInstance(isInstance)) {
                return 1;
            }
        }
        return false;
    }

    static ResponseBody m43347a(ResponseBody responseBody) throws IOException {
        Object buffer = new Buffer();
        responseBody.source().a(buffer);
        return ResponseBody.create(responseBody.contentType(), responseBody.contentLength(), buffer);
    }

    static <T> void m43348a(Class<T> cls) {
        if (!cls.isInterface()) {
            throw new IllegalArgumentException("API declarations must be interfaces.");
        } else if (cls.getInterfaces().length > null) {
            throw new IllegalArgumentException("API interfaces must not extend other interfaces.");
        }
    }

    public static Type m43344a(int i, ParameterizedType parameterizedType) {
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (i >= 0) {
            if (i < actualTypeArguments.length) {
                i = actualTypeArguments[i];
                return (i instanceof WildcardType) != null ? ((WildcardType) i).getUpperBounds()[null] : i;
            }
        }
        StringBuilder stringBuilder = new StringBuilder("Index ");
        stringBuilder.append(i);
        stringBuilder.append(" not in range [0,");
        stringBuilder.append(actualTypeArguments.length);
        stringBuilder.append(") for ");
        stringBuilder.append(parameterizedType);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    static boolean m43354d(Type type) {
        while (!(type instanceof Class)) {
            if (type instanceof ParameterizedType) {
                for (Type d : ((ParameterizedType) type).getActualTypeArguments()) {
                    if (m43354d(d)) {
                        return true;
                    }
                }
                return false;
            } else if (type instanceof GenericArrayType) {
                type = ((GenericArrayType) type).getGenericComponentType();
            } else if ((type instanceof TypeVariable) || (type instanceof WildcardType)) {
                return true;
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
        return false;
    }

    static Type m43355e(Type type) {
        if (type instanceof ParameterizedType) {
            return m43344a(0, (ParameterizedType) type);
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}
