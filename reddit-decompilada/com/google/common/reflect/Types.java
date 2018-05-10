package com.google.common.reflect;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map.Entry;

final class Types {
    private static final Function<Type, String> f8556a = new C11931();
    private static final Joiner f8557b = Joiner.m6882a(", ").mo2324b("null");

    private enum ClassOwnership {
        ;
        
        static final ClassOwnership f8536c = null;

        static class C11963 extends AnonymousClass1LocalClass<String> {
            C11963() {
            }
        }

        abstract Class<?> mo2440a(Class<?> cls);

        static {
            ParameterizedType parameterizedType = (ParameterizedType) new C11963().getClass().getGenericSuperclass();
            ClassOwnership[] values = values();
            int length = values.length;
            int i;
            while (i < length) {
                ClassOwnership classOwnership = values[i];
                if (classOwnership.mo2440a(AnonymousClass1LocalClass.class) == parameterizedType.getOwnerType()) {
                    f8536c = classOwnership;
                    return;
                }
                i++;
            }
            throw new AssertionError();
        }
    }

    private static final class GenericArrayTypeImpl implements Serializable, GenericArrayType {
        private final Type f8538a;

        GenericArrayTypeImpl(Type type) {
            this.f8538a = JavaVersion.f8543e.mo2442b(type);
        }

        public final Type getGenericComponentType() {
            return this.f8538a;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Types.m7330b(this.f8538a));
            stringBuilder.append("[]");
            return stringBuilder.toString();
        }

        public final int hashCode() {
            return this.f8538a.hashCode();
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof GenericArrayType)) {
                return null;
            }
            return Objects.m14557a(getGenericComponentType(), ((GenericArrayType) obj).getGenericComponentType());
        }
    }

    enum JavaVersion {
        ;
        
        static final JavaVersion f8543e = null;

        static class C12015 extends TypeCapture<Entry<String, int[][]>> {
            C12015() {
            }
        }

        static class C12026 extends TypeCapture<int[]> {
            C12026() {
            }
        }

        abstract Type mo2441a(Type type);

        boolean mo2444a() {
            return true;
        }

        abstract Type mo2442b(Type type);

        String mo2443c(Type type) {
            return Types.m7330b(type);
        }

        final ImmutableList<Type> m7315a(Type[] typeArr) {
            Builder e = ImmutableList.m14736e();
            for (Type b : typeArr) {
                e.m19281c(mo2442b(b));
            }
            return e.m19278a();
        }
    }

    static final class NativeTypeVariableEquals<X> {
        static final boolean f8545a = (NativeTypeVariableEquals.class.getTypeParameters()[0].equals(Types.m7326a((GenericDeclaration) NativeTypeVariableEquals.class, "X", new Type[0])) ^ 1);

        NativeTypeVariableEquals() {
        }
    }

    private static final class ParameterizedTypeImpl implements Serializable, ParameterizedType {
        private final Type f8546a;
        private final ImmutableList<Type> f8547b;
        private final Class<?> f8548c;

        ParameterizedTypeImpl(Type type, Class<?> cls, Type[] typeArr) {
            Preconditions.m6908a((Object) cls);
            Preconditions.m6913a(typeArr.length == cls.getTypeParameters().length);
            Types.m7327a(typeArr, "type parameter");
            this.f8546a = type;
            this.f8548c = cls;
            this.f8547b = JavaVersion.f8543e.m7315a(typeArr);
        }

        public final Type[] getActualTypeArguments() {
            return ((Type[]) this.f8547b.toArray(new Type[this.f8547b.size()]));
        }

        public final Type getRawType() {
            return this.f8548c;
        }

        public final Type getOwnerType() {
            return this.f8546a;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            if (this.f8546a != null && JavaVersion.f8543e.mo2444a()) {
                stringBuilder.append(JavaVersion.f8543e.mo2443c(this.f8546a));
                stringBuilder.append('.');
            }
            stringBuilder.append(this.f8548c.getName());
            stringBuilder.append('<');
            stringBuilder.append(Types.f8557b.m6886a(Iterables.m7135a(this.f8547b, Types.f8556a)));
            stringBuilder.append('>');
            return stringBuilder.toString();
        }

        public final int hashCode() {
            return ((this.f8546a == null ? 0 : this.f8546a.hashCode()) ^ this.f8547b.hashCode()) ^ this.f8548c.hashCode();
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            if (getRawType().equals(parameterizedType.getRawType()) && Objects.m14557a(getOwnerType(), parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments()) != null) {
                return true;
            }
            return false;
        }
    }

    private static final class TypeVariableImpl<D extends GenericDeclaration> {
        private final D f8549a;
        private final String f8550b;
        private final ImmutableList<Type> f8551c;

        TypeVariableImpl(D d, String str, Type[] typeArr) {
            Types.m7327a(typeArr, "bound for type variable");
            this.f8549a = (GenericDeclaration) Preconditions.m6908a((Object) d);
            this.f8550b = (String) Preconditions.m6908a((Object) str);
            this.f8551c = ImmutableList.m14732a((Object[]) typeArr);
        }

        public final String toString() {
            return this.f8550b;
        }

        public final int hashCode() {
            return this.f8549a.hashCode() ^ this.f8550b.hashCode();
        }

        public final boolean equals(Object obj) {
            if (NativeTypeVariableEquals.f8545a) {
                if (obj == null || !Proxy.isProxyClass(obj.getClass()) || !(Proxy.getInvocationHandler(obj) instanceof TypeVariableInvocationHandler)) {
                    return false;
                }
                obj = ((TypeVariableInvocationHandler) Proxy.getInvocationHandler(obj)).f8553b;
                return this.f8550b.equals(obj.f8550b) && this.f8549a.equals(obj.f8549a) && this.f8551c.equals(obj.f8551c) != null;
            } else if (!(obj instanceof TypeVariable)) {
                return false;
            } else {
                TypeVariable typeVariable = (TypeVariable) obj;
                return this.f8550b.equals(typeVariable.getName()) && this.f8549a.equals(typeVariable.getGenericDeclaration()) != null;
            }
        }
    }

    private static final class TypeVariableInvocationHandler implements InvocationHandler {
        private static final ImmutableMap<String, Method> f8552a;
        private final TypeVariableImpl<?> f8553b;

        static {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = com.google.common.collect.ImmutableMap.m7129b();
            r1 = com.google.common.reflect.Types.TypeVariableImpl.class;
            r1 = r1.getMethods();
            r2 = 0;
            r3 = r1.length;
        L_0x000c:
            if (r2 >= r3) goto L_0x002a;
        L_0x000e:
            r4 = r1[r2];
            r5 = r4.getDeclaringClass();
            r6 = com.google.common.reflect.Types.TypeVariableImpl.class;
            r5 = r5.equals(r6);
            if (r5 == 0) goto L_0x0027;
        L_0x001c:
            r5 = 1;
            r4.setAccessible(r5);	 Catch:{ AccessControlException -> 0x0020 }
        L_0x0020:
            r5 = r4.getName();
            r0.m7124a(r5, r4);
        L_0x0027:
            r2 = r2 + 1;
            goto L_0x000c;
        L_0x002a:
            r0 = r0.m7125a();
            f8552a = r0;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.reflect.Types.TypeVariableInvocationHandler.<clinit>():void");
        }

        TypeVariableInvocationHandler(TypeVariableImpl<?> typeVariableImpl) {
            this.f8553b = typeVariableImpl;
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            obj = method.getName();
            method = (Method) f8552a.get(obj);
            if (method == null) {
                throw new UnsupportedOperationException(obj);
            }
            try {
                return method.invoke(this.f8553b, objArr);
            } catch (Object obj2) {
                throw obj2.getCause();
            }
        }
    }

    static final class WildcardTypeImpl implements Serializable, WildcardType {
        private final ImmutableList<Type> f8554a;
        private final ImmutableList<Type> f8555b;

        WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            Types.m7327a(typeArr, "lower bound for wildcard");
            Types.m7327a(typeArr2, "upper bound for wildcard");
            this.f8554a = JavaVersion.f8543e.m7315a(typeArr);
            this.f8555b = JavaVersion.f8543e.m7315a(typeArr2);
        }

        public final Type[] getLowerBounds() {
            return ((Type[]) this.f8554a.toArray(new Type[this.f8554a.size()]));
        }

        public final Type[] getUpperBounds() {
            return ((Type[]) this.f8555b.toArray(new Type[this.f8555b.size()]));
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) obj;
            if (!this.f8554a.equals(Arrays.asList(wildcardType.getLowerBounds())) || this.f8555b.equals(Arrays.asList(wildcardType.getUpperBounds())) == null) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return this.f8554a.hashCode() ^ this.f8555b.hashCode();
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder(Operation.EMPTY_PARAM);
            Iterator a = this.f8554a.m14740a(0);
            while (a.hasNext()) {
                Type type = (Type) a.next();
                stringBuilder.append(" super ");
                stringBuilder.append(JavaVersion.f8543e.mo2443c(type));
            }
            for (Type type2 : Iterables.m7141b(this.f8555b, Predicates.m6925a(Predicates.m6926a((Object) Object.class)))) {
                stringBuilder.append(" extends ");
                stringBuilder.append(JavaVersion.f8543e.mo2443c(type2));
            }
            return stringBuilder.toString();
        }
    }

    static class C11931 implements Function<Type, String> {
        C11931() {
        }

        public final /* synthetic */ Object apply(Object obj) {
            return JavaVersion.f8543e.mo2443c((Type) obj);
        }
    }

    static Type m7325a(Type type) {
        if (!(type instanceof WildcardType)) {
            return JavaVersion.f8543e.mo2441a(type);
        }
        WildcardType wildcardType = (WildcardType) type;
        Type[] lowerBounds = wildcardType.getLowerBounds();
        Preconditions.m6914a(lowerBounds.length <= 1, (Object) "Wildcard cannot have more than one lower bounds.");
        if (lowerBounds.length == 1) {
            return new WildcardTypeImpl(new Type[]{m7325a(lowerBounds[0])}, new Type[]{Object.class});
        }
        Preconditions.m6914a(wildcardType.getUpperBounds().length == 1, (Object) "Wildcard should have only one upper bound.");
        return new WildcardTypeImpl(new Type[0], new Type[]{m7325a(wildcardType.getUpperBounds()[0])});
    }

    static <D extends GenericDeclaration> TypeVariable<D> m7326a(D d, String str, Type... typeArr) {
        if (typeArr.length == 0) {
            typeArr = new Type[]{Object.class};
        }
        return (TypeVariable) Reflection.m7289a(TypeVariable.class, new TypeVariableInvocationHandler(new TypeVariableImpl(d, str, typeArr)));
    }

    static String m7330b(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    static Class<?> m7322a(Class<?> cls) {
        return Array.newInstance(cls, 0).getClass();
    }

    static ParameterizedType m7324a(Type type, Class<?> cls, Type... typeArr) {
        if (type == null) {
            return new ParameterizedTypeImpl(ClassOwnership.f8536c.mo2440a(cls), cls, typeArr);
        }
        Preconditions.m6908a((Object) typeArr);
        Preconditions.m6917a(cls.getEnclosingClass() != null, "Owner type for unenclosed %s", (Object) cls);
        return new ParameterizedTypeImpl(type, cls, typeArr);
    }

    static /* synthetic */ void m7327a(Type[] typeArr, String str) {
        for (Type type : typeArr) {
            if (type instanceof Class) {
                Object obj = (Class) type;
                Preconditions.m6919a(obj.isPrimitive() ^ 1, "Primitive type '%s' used as %s", obj, (Object) str);
            }
        }
    }
}
