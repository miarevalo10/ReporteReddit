package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u001e\b \u0018\u0000 /*\f\b\u0000\u0010\u0001 \u0001*\u0004\u0018\u00010\u00022\u00020\u0003:\u001a#$%&'()*+,-./0123456789:;<B1\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0002\u0010\u000bJ\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\nH&¢\u0006\u0002\u0010\u001dJ\u0019\u0010\u001e\u001a\u00020\u001f2\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\nH\u0014¢\u0006\u0002\u0010 J\u0012\u0010!\u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010\u0003H\u0004R\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00028\u0000X\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006="}, d2 = {"Lkotlin/reflect/jvm/internal/FunctionCaller;", "M", "Ljava/lang/reflect/Member;", "", "member", "returnType", "Ljava/lang/reflect/Type;", "instanceClass", "Ljava/lang/Class;", "valueParameterTypes", "", "(Ljava/lang/reflect/Member;Ljava/lang/reflect/Type;Ljava/lang/Class;[Ljava/lang/reflect/Type;)V", "arity", "", "getArity", "()I", "getInstanceClass$kotlin_reflection", "()Ljava/lang/Class;", "getMember$kotlin_reflection", "()Ljava/lang/reflect/Member;", "Ljava/lang/reflect/Member;", "parameterTypes", "", "getParameterTypes", "()Ljava/util/List;", "getReturnType$kotlin_reflection", "()Ljava/lang/reflect/Type;", "call", "args", "([Ljava/lang/Object;)Ljava/lang/Object;", "checkArguments", "", "([Ljava/lang/Object;)V", "checkObjectInstance", "obj", "BoundClassCompanionFieldGetter", "BoundClassCompanionFieldSetter", "BoundConstructor", "BoundInstanceFieldGetter", "BoundInstanceFieldSetter", "BoundInstanceMethod", "BoundJvmStaticInObject", "BoundJvmStaticInObjectFieldGetter", "BoundJvmStaticInObjectFieldSetter", "BoundStaticMethod", "ClassCompanionFieldGetter", "ClassCompanionFieldSetter", "Companion", "Constructor", "FieldGetter", "FieldSetter", "InstanceFieldGetter", "InstanceFieldSetter", "InstanceMethod", "JvmStaticInObject", "JvmStaticInObjectFieldGetter", "JvmStaticInObjectFieldSetter", "Method", "StaticFieldGetter", "StaticFieldSetter", "StaticMethod", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
/* compiled from: FunctionCaller.kt */
public abstract class FunctionCaller<M extends Member> {
    public static final Companion f25322d = new Companion();
    final M f25323a;
    final Type f25324b;
    final Class<?> f25325c;
    private final List<Type> f25326e;

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J1\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004¢\u0006\u0002\u0010\u0007J(\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\t0\u0004\"\u0006\b\u0001\u0010\t\u0018\u0001*\n\u0012\u0006\b\u0001\u0012\u0002H\t0\u0004H\b¢\u0006\u0002\u0010\nJ\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004*\u0006\u0012\u0002\b\u00030\u0004H\u0007¢\u0006\u0002\u0010\n¨\u0006\f"}, d2 = {"Lkotlin/reflect/jvm/internal/FunctionCaller$Companion;", "", "()V", "argsWithReceiver", "", "receiver", "args", "(Ljava/lang/Object;[Ljava/lang/Object;)[Ljava/lang/Object;", "dropFirst", "T", "([Ljava/lang/Object;)[Ljava/lang/Object;", "dropFirstArg", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: FunctionCaller.kt */
    public static final class Companion {
        private Companion() {
        }

        public static Object[] m26894a(Object obj, Object[] objArr) {
            Intrinsics.m26847b(objArr, "args");
            Object[] objArr2 = new Object[(objArr.length + 1)];
            objArr2[0] = obj;
            System.arraycopy(objArr, 0, objArr2, 1, objArr.length);
            return objArr2;
        }

        public static Object[] m26895a(Object[] objArr) {
            Intrinsics.m26847b(objArr, "$receiver");
            if (objArr == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            }
            objArr = objArr;
            if (objArr.length <= 1) {
                objArr = new Object[null];
            } else {
                objArr = Arrays.copyOfRange(objArr, 1, objArr.length);
                Intrinsics.m26843a((Object) objArr, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
                if (objArr == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
            return objArr;
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lkotlin/reflect/jvm/internal/FunctionCaller$BoundClassCompanionFieldSetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "Ljava/lang/reflect/Field;", "field", "klass", "Ljava/lang/Class;", "(Ljava/lang/reflect/Field;Ljava/lang/Class;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: FunctionCaller.kt */
    public static final class BoundClassCompanionFieldSetter extends FunctionCaller<Field> {
        public BoundClassCompanionFieldSetter(Field field, Class<?> cls) {
            Intrinsics.m26847b(field, "field");
            Intrinsics.m26847b(cls, "klass");
            Member member = field;
            Object obj = Void.TYPE;
            Intrinsics.m26843a(obj, "Void.TYPE");
            Type type = (Type) obj;
            Type[] typeArr = new Type[1];
            Object genericType = field.getGenericType();
            Intrinsics.m26843a(genericType, "field.genericType");
            typeArr[0] = genericType;
            super(member, type, cls, (Type[]) ((Object[]) typeArr));
        }

        public final Object mo5688a(Object[] objArr) {
            Intrinsics.m26847b(objArr, "args");
            mo5689b(objArr);
            ((Field) this.f25323a).set(null, ArraysKt___ArraysKt.m36099c(objArr));
            return Unit.f25273a;
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u001b\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0016¢\u0006\u0002\u0010\nR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlin/reflect/jvm/internal/FunctionCaller$BoundConstructor;", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "Ljava/lang/reflect/Constructor;", "constructor", "boundReceiver", "", "(Ljava/lang/reflect/Constructor;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: FunctionCaller.kt */
    public static final class BoundConstructor extends FunctionCaller<java.lang.reflect.Constructor<?>> {
        private final Object f32549e;

        public BoundConstructor(java.lang.reflect.Constructor<?> constructor, Object obj) {
            Intrinsics.m26847b(constructor, "constructor");
            Member member = constructor;
            Object declaringClass = constructor.getDeclaringClass();
            Intrinsics.m26843a(declaringClass, "constructor.declaringClass");
            Type type = (Type) declaringClass;
            Object genericParameterTypes = constructor.getGenericParameterTypes();
            Intrinsics.m26843a(genericParameterTypes, "constructor.genericParameterTypes");
            super(member, type, null, genericParameterTypes);
            this.f32549e = obj;
        }

        public final Object mo5688a(Object[] objArr) {
            Intrinsics.m26847b(objArr, "args");
            mo5689b(objArr);
            java.lang.reflect.Constructor constructor = (java.lang.reflect.Constructor) this.f25323a;
            objArr = Companion.m26894a(this.f32549e, objArr);
            return constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lkotlin/reflect/jvm/internal/FunctionCaller$ClassCompanionFieldGetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "Ljava/lang/reflect/Field;", "field", "klass", "Ljava/lang/Class;", "(Ljava/lang/reflect/Field;Ljava/lang/Class;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: FunctionCaller.kt */
    public static final class ClassCompanionFieldGetter extends FunctionCaller<Field> {
        public ClassCompanionFieldGetter(Field field, Class<?> cls) {
            Intrinsics.m26847b(field, "field");
            Intrinsics.m26847b(cls, "klass");
            Member member = field;
            Object genericType = field.getGenericType();
            Intrinsics.m26843a(genericType, "field.genericType");
            super(member, genericType, cls, (Type[]) ((Object[]) new Type[0]));
        }

        public final Object mo5688a(Object[] objArr) {
            Intrinsics.m26847b(objArr, "args");
            mo5689b(objArr);
            return ((Field) this.f25323a).get(ArraysKt___ArraysKt.m36082a(objArr));
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lkotlin/reflect/jvm/internal/FunctionCaller$ClassCompanionFieldSetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "Ljava/lang/reflect/Field;", "field", "klass", "Ljava/lang/Class;", "(Ljava/lang/reflect/Field;Ljava/lang/Class;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: FunctionCaller.kt */
    public static final class ClassCompanionFieldSetter extends FunctionCaller<Field> {
        public ClassCompanionFieldSetter(Field field, Class<?> cls) {
            Intrinsics.m26847b(field, "field");
            Intrinsics.m26847b(cls, "klass");
            Member member = field;
            Object obj = Void.TYPE;
            Intrinsics.m26843a(obj, "Void.TYPE");
            Type type = (Type) obj;
            Type[] typeArr = new Type[1];
            Object genericType = field.getGenericType();
            Intrinsics.m26843a(genericType, "field.genericType");
            typeArr[0] = genericType;
            super(member, type, cls, (Type[]) ((Object[]) typeArr));
        }

        public final Object mo5688a(Object[] objArr) {
            Intrinsics.m26847b(objArr, "args");
            mo5689b(objArr);
            ((Field) this.f25323a).set(null, ArraysKt___ArraysKt.m36099c(objArr));
            return Unit.f25273a;
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0011\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/reflect/jvm/internal/FunctionCaller$Constructor;", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "Ljava/lang/reflect/Constructor;", "constructor", "(Ljava/lang/reflect/Constructor;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: FunctionCaller.kt */
    public static final class Constructor extends FunctionCaller<java.lang.reflect.Constructor<?>> {
        public Constructor(java.lang.reflect.Constructor<?> constructor) {
            Intrinsics.m26847b(constructor, "constructor");
            Member member = constructor;
            Object declaringClass = constructor.getDeclaringClass();
            Intrinsics.m26843a(declaringClass, "constructor.declaringClass");
            Type type = (Type) declaringClass;
            Class declaringClass2 = constructor.getDeclaringClass();
            Class declaringClass3 = declaringClass2.getDeclaringClass();
            if (declaringClass3 == null || Modifier.isStatic(declaringClass2.getModifiers())) {
                declaringClass3 = null;
            }
            declaringClass3 = declaringClass3;
            Object genericParameterTypes = constructor.getGenericParameterTypes();
            Intrinsics.m26843a(genericParameterTypes, "constructor.genericParameterTypes");
            super(member, type, declaringClass3, genericParameterTypes);
        }

        public final Object mo5688a(Object[] objArr) {
            Intrinsics.m26847b(objArr, "args");
            mo5689b(objArr);
            return ((java.lang.reflect.Constructor) this.f25323a).newInstance(Arrays.copyOf(objArr, objArr.length));
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lkotlin/reflect/jvm/internal/FunctionCaller$FieldGetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "Ljava/lang/reflect/Field;", "field", "requiresInstance", "", "(Ljava/lang/reflect/Field;Z)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: FunctionCaller.kt */
    public static abstract class FieldGetter extends FunctionCaller<Field> {
        public FieldGetter(Field field, boolean z) {
            Intrinsics.m26847b(field, "field");
            Member member = field;
            Object genericType = field.getGenericType();
            Intrinsics.m26843a(genericType, "field.genericType");
            super(member, genericType, z ? field.getDeclaringClass() : null, (Type[]) ((Object[]) new Type[false]));
        }

        public Object mo5688a(Object[] objArr) {
            Intrinsics.m26847b(objArr, "args");
            mo5689b(objArr);
            return ((Field) this.f25323a).get(this.f25325c != null ? ArraysKt___ArraysKt.m36082a(objArr) : null);
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u001b\u0010\b\u001a\u0004\u0018\u00010\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0016¢\u0006\u0002\u0010\fJ\u0019\u0010\r\u001a\u00020\u000e2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0014¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkotlin/reflect/jvm/internal/FunctionCaller$FieldSetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "Ljava/lang/reflect/Field;", "field", "notNull", "", "requiresInstance", "(Ljava/lang/reflect/Field;ZZ)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "checkArguments", "", "([Ljava/lang/Object;)V", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: FunctionCaller.kt */
    public static abstract class FieldSetter extends FunctionCaller<Field> {
        private final boolean f32550e;

        public FieldSetter(Field field, boolean z, boolean z2) {
            Intrinsics.m26847b(field, "field");
            Member member = field;
            Object obj = Void.TYPE;
            Intrinsics.m26843a(obj, "Void.TYPE");
            Type type = (Type) obj;
            z2 = z2 ? field.getDeclaringClass() : false;
            Type[] typeArr = new Type[1];
            Object genericType = field.getGenericType();
            Intrinsics.m26843a(genericType, "field.genericType");
            typeArr[0] = genericType;
            super(member, type, z2, (Type[]) ((Object[]) typeArr));
            this.f32550e = z;
        }

        protected void mo5689b(Object[] objArr) {
            Intrinsics.m26847b(objArr, "args");
            super.mo5689b(objArr);
            if (this.f32550e && ArraysKt___ArraysKt.m36099c(objArr) == null) {
                throw ((Throwable) new IllegalArgumentException("null is not allowed as a value for this property."));
            }
        }

        public Object mo5688a(Object[] objArr) {
            Intrinsics.m26847b(objArr, "args");
            mo5689b(objArr);
            ((Field) this.f25323a).set(this.f25325c != null ? ArraysKt___ArraysKt.m36082a(objArr) : null, ArraysKt___ArraysKt.m36099c(objArr));
            return Unit.f25273a;
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ%\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0004¢\u0006\u0002\u0010\u000fR\u000e\u0010\n\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkotlin/reflect/jvm/internal/FunctionCaller$Method;", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "Ljava/lang/reflect/Method;", "method", "requiresInstance", "", "parameterTypes", "", "Ljava/lang/reflect/Type;", "(Ljava/lang/reflect/Method;Z[Ljava/lang/reflect/Type;)V", "isVoidMethod", "callMethod", "", "instance", "args", "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: FunctionCaller.kt */
    public static abstract class Method extends FunctionCaller<java.lang.reflect.Method> {
        private final boolean f32551e;

        public Method(java.lang.reflect.Method method, boolean z, Type[] typeArr) {
            Intrinsics.m26847b(method, "method");
            Intrinsics.m26847b(typeArr, "parameterTypes");
            Member member = method;
            Object genericReturnType = method.getGenericReturnType();
            Intrinsics.m26843a(genericReturnType, "method.genericReturnType");
            super(member, genericReturnType, z ? method.getDeclaringClass() : null, typeArr);
            this.f32551e = Intrinsics.m26845a(this.f25324b, Void.TYPE);
        }

        public /* synthetic */ Method(java.lang.reflect.Method method, boolean z, Type[] typeArr, int i) {
            if ((i & 2) != 0) {
                z = Modifier.isStatic(method.getModifiers()) ^ 1;
            }
            if ((i & 4) != 0) {
                typeArr = method.getGenericParameterTypes();
                Intrinsics.m26843a((Object) typeArr, "method.genericParameterTypes");
            }
            this(method, z, typeArr);
        }

        protected final Object m32869a(Object obj, Object[] objArr) {
            Intrinsics.m26847b(objArr, "args");
            return this.f32551e != null ? Unit.f25273a : ((java.lang.reflect.Method) this.f25323a).invoke(obj, Arrays.copyOf(objArr, objArr.length));
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0016¢\u0006\u0002\u0010\nR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlin/reflect/jvm/internal/FunctionCaller$BoundClassCompanionFieldGetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "boundReceiver", "", "(Ljava/lang/reflect/Field;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: FunctionCaller.kt */
    public static final class BoundClassCompanionFieldGetter extends FieldGetter {
        private final Object f36025e;

        public BoundClassCompanionFieldGetter(Field field, Object obj) {
            Intrinsics.m26847b(field, "field");
            super(field, false);
            this.f36025e = obj;
        }

        public final Object mo5688a(Object[] objArr) {
            Intrinsics.m26847b(objArr, "args");
            mo5689b(objArr);
            return ((Field) this.f25323a).get(this.f36025e);
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0016¢\u0006\u0002\u0010\nR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlin/reflect/jvm/internal/FunctionCaller$BoundInstanceFieldGetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "boundReceiver", "", "(Ljava/lang/reflect/Field;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: FunctionCaller.kt */
    public static final class BoundInstanceFieldGetter extends FieldGetter {
        private final Object f36026e;

        public BoundInstanceFieldGetter(Field field, Object obj) {
            Intrinsics.m26847b(field, "field");
            super(field, false);
            this.f36026e = obj;
        }

        public final Object mo5688a(Object[] objArr) {
            Intrinsics.m26847b(objArr, "args");
            mo5689b(objArr);
            return ((Field) this.f25323a).get(this.f36026e);
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u001b\u0010\t\u001a\u0004\u0018\u00010\u00072\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0016¢\u0006\u0002\u0010\fR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlin/reflect/jvm/internal/FunctionCaller$BoundInstanceFieldSetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "boundReceiver", "", "(Ljava/lang/reflect/Field;ZLjava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: FunctionCaller.kt */
    public static final class BoundInstanceFieldSetter extends FieldSetter {
        private final Object f36027e;

        public BoundInstanceFieldSetter(Field field, boolean z, Object obj) {
            Intrinsics.m26847b(field, "field");
            super(field, z, false);
            this.f36027e = obj;
        }

        public final Object mo5688a(Object[] objArr) {
            Intrinsics.m26847b(objArr, "args");
            mo5689b(objArr);
            ((Field) this.f25323a).set(this.f36027e, ArraysKt___ArraysKt.m36082a(objArr));
            return Unit.f25273a;
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0016¢\u0006\u0002\u0010\nR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlin/reflect/jvm/internal/FunctionCaller$BoundInstanceMethod;", "Lkotlin/reflect/jvm/internal/FunctionCaller$Method;", "method", "Ljava/lang/reflect/Method;", "boundReceiver", "", "(Ljava/lang/reflect/Method;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: FunctionCaller.kt */
    public static final class BoundInstanceMethod extends Method {
        private final Object f36028e;

        public BoundInstanceMethod(java.lang.reflect.Method method, Object obj) {
            Intrinsics.m26847b(method, "method");
            super(method, false, null, 4);
            this.f36028e = obj;
        }

        public final Object mo5688a(Object[] objArr) {
            Intrinsics.m26847b(objArr, "args");
            mo5689b(objArr);
            return m32869a(this.f36028e, objArr);
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/reflect/jvm/internal/FunctionCaller$BoundJvmStaticInObject;", "Lkotlin/reflect/jvm/internal/FunctionCaller$Method;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: FunctionCaller.kt */
    public static final class BoundJvmStaticInObject extends Method {
        public BoundJvmStaticInObject(java.lang.reflect.Method method) {
            Intrinsics.m26847b(method, "method");
            super(method, false, null, 4);
        }

        public final Object mo5688a(Object[] objArr) {
            Intrinsics.m26847b(objArr, "args");
            mo5689b(objArr);
            return m32869a(null, objArr);
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/reflect/jvm/internal/FunctionCaller$BoundJvmStaticInObjectFieldGetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: FunctionCaller.kt */
    public static final class BoundJvmStaticInObjectFieldGetter extends FieldGetter {
        public BoundJvmStaticInObjectFieldGetter(Field field) {
            Intrinsics.m26847b(field, "field");
            super(field, false);
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lkotlin/reflect/jvm/internal/FunctionCaller$BoundJvmStaticInObjectFieldSetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "(Ljava/lang/reflect/Field;Z)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: FunctionCaller.kt */
    public static final class BoundJvmStaticInObjectFieldSetter extends FieldSetter {
        public BoundJvmStaticInObjectFieldSetter(Field field, boolean z) {
            Intrinsics.m26847b(field, "field");
            super(field, z, false);
        }

        public final Object mo5688a(Object[] objArr) {
            Intrinsics.m26847b(objArr, "args");
            mo5689b(objArr);
            ((Field) this.f25323a).set(null, ArraysKt___ArraysKt.m36099c(objArr));
            return Unit.f25273a;
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0016¢\u0006\u0002\u0010\nR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlin/reflect/jvm/internal/FunctionCaller$BoundStaticMethod;", "Lkotlin/reflect/jvm/internal/FunctionCaller$Method;", "method", "Ljava/lang/reflect/Method;", "boundReceiver", "", "(Ljava/lang/reflect/Method;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: FunctionCaller.kt */
    public static final class BoundStaticMethod extends Method {
        private final Object f36029e;

        public BoundStaticMethod(java.lang.reflect.Method method, Object obj) {
            Type[] typeArr;
            Intrinsics.m26847b(method, "method");
            Object[] objArr = (Object[]) method.getGenericParameterTypes();
            if (objArr.length <= 1) {
                typeArr = new Type[0];
            } else {
                typeArr = Arrays.copyOfRange(objArr, 1, objArr.length);
                Intrinsics.m26843a((Object) typeArr, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
                if (typeArr == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
            super(method, false, (Type[]) ((Object[]) typeArr));
            this.f36029e = obj;
        }

        public final Object mo5688a(Object[] objArr) {
            Intrinsics.m26847b(objArr, "args");
            mo5689b(objArr);
            return m32869a(null, Companion.m26894a(this.f36029e, objArr));
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/reflect/jvm/internal/FunctionCaller$InstanceFieldGetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: FunctionCaller.kt */
    public static final class InstanceFieldGetter extends FieldGetter {
        public InstanceFieldGetter(Field field) {
            Intrinsics.m26847b(field, "field");
            super(field);
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/reflect/jvm/internal/FunctionCaller$InstanceFieldSetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "(Ljava/lang/reflect/Field;Z)V", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: FunctionCaller.kt */
    public static final class InstanceFieldSetter extends FieldSetter {
        public InstanceFieldSetter(Field field, boolean z) {
            Intrinsics.m26847b(field, "field");
            super(field, z);
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/reflect/jvm/internal/FunctionCaller$InstanceMethod;", "Lkotlin/reflect/jvm/internal/FunctionCaller$Method;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: FunctionCaller.kt */
    public static final class InstanceMethod extends Method {
        public InstanceMethod(java.lang.reflect.Method method) {
            Intrinsics.m26847b(method, "method");
            super(method, false, null, 6);
        }

        public final Object mo5688a(Object[] objArr) {
            Intrinsics.m26847b(objArr, "args");
            mo5689b(objArr);
            return m32869a(objArr[0], Companion.m26895a(objArr));
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/reflect/jvm/internal/FunctionCaller$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/FunctionCaller$Method;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: FunctionCaller.kt */
    public static final class JvmStaticInObject extends Method {
        public JvmStaticInObject(java.lang.reflect.Method method) {
            Intrinsics.m26847b(method, "method");
            super(method, true, null, 4);
        }

        public final Object mo5688a(Object[] objArr) {
            Intrinsics.m26847b(objArr, "args");
            mo5689b(objArr);
            m26898a(ArraysKt___ArraysKt.m36094b(objArr));
            return m32869a(null, Companion.m26895a(objArr));
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0014¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/reflect/jvm/internal/FunctionCaller$JvmStaticInObjectFieldGetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "checkArguments", "", "args", "", "([Ljava/lang/Object;)V", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: FunctionCaller.kt */
    public static final class JvmStaticInObjectFieldGetter extends FieldGetter {
        public JvmStaticInObjectFieldGetter(Field field) {
            Intrinsics.m26847b(field, "field");
            super(field, true);
        }

        protected final void mo5689b(Object[] objArr) {
            Intrinsics.m26847b(objArr, "args");
            super.mo5689b(objArr);
            m26898a((Object) ArraysKt___ArraysKt.m36094b(objArr));
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0014¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lkotlin/reflect/jvm/internal/FunctionCaller$JvmStaticInObjectFieldSetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "(Ljava/lang/reflect/Field;Z)V", "checkArguments", "", "args", "", "([Ljava/lang/Object;)V", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: FunctionCaller.kt */
    public static final class JvmStaticInObjectFieldSetter extends FieldSetter {
        public JvmStaticInObjectFieldSetter(Field field, boolean z) {
            Intrinsics.m26847b(field, "field");
            super(field, z, true);
        }

        protected final void mo5689b(Object[] objArr) {
            Intrinsics.m26847b(objArr, "args");
            super.mo5689b(objArr);
            m26898a((Object) ArraysKt___ArraysKt.m36094b(objArr));
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/reflect/jvm/internal/FunctionCaller$StaticFieldGetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: FunctionCaller.kt */
    public static final class StaticFieldGetter extends FieldGetter {
        public StaticFieldGetter(Field field) {
            Intrinsics.m26847b(field, "field");
            super(field);
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/reflect/jvm/internal/FunctionCaller$StaticFieldSetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "(Ljava/lang/reflect/Field;Z)V", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: FunctionCaller.kt */
    public static final class StaticFieldSetter extends FieldSetter {
        public StaticFieldSetter(Field field, boolean z) {
            Intrinsics.m26847b(field, "field");
            super(field, z);
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/reflect/jvm/internal/FunctionCaller$StaticMethod;", "Lkotlin/reflect/jvm/internal/FunctionCaller$Method;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: FunctionCaller.kt */
    public static final class StaticMethod extends Method {
        public StaticMethod(java.lang.reflect.Method method) {
            Intrinsics.m26847b(method, "method");
            super(method, false, null, 6);
        }

        public final Object mo5688a(Object[] objArr) {
            Intrinsics.m26847b(objArr, "args");
            mo5689b(objArr);
            return m32869a(null, objArr);
        }
    }

    public abstract Object mo5688a(Object[] objArr);

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FunctionCaller(M r2, java.lang.reflect.Type r3, java.lang.Class<?> r4, java.lang.reflect.Type[] r5) {
        /*
        r1 = this;
        r0 = "returnType";
        kotlin.jvm.internal.Intrinsics.m26847b(r3, r0);
        r0 = "valueParameterTypes";
        kotlin.jvm.internal.Intrinsics.m26847b(r5, r0);
        r1.<init>();
        r1.f25323a = r2;
        r1.f25324b = r3;
        r1.f25325c = r4;
        r2 = r1.f25325c;
        if (r2 == 0) goto L_0x003d;
    L_0x0018:
        r2 = (java.lang.Class) r2;
        r3 = new kotlin.jvm.internal.SpreadBuilder;
        r3.<init>();
        r2 = (java.lang.reflect.Type) r2;
        r3.m26867b(r2);
        r3.m26865a(r5);
        r2 = r3.f25294a;
        r2 = r2.size();
        r2 = new java.lang.reflect.Type[r2];
        r2 = r3.m26866a(r2);
        r2 = (java.lang.reflect.Type[]) r2;
        r2 = kotlin.collections.CollectionsKt__CollectionsKt.m26796b(r2);
        r2 = (java.util.List) r2;
        if (r2 != 0) goto L_0x0043;
    L_0x003d:
        r5 = (java.lang.Object[]) r5;
        r2 = kotlin.collections.ArraysKt___ArraysKt.m36109i(r5);
    L_0x0043:
        r1.f25326e = r2;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.FunctionCaller.<init>(java.lang.reflect.Member, java.lang.reflect.Type, java.lang.Class, java.lang.reflect.Type[]):void");
    }

    public final int m26896a() {
        return this.f25326e.size();
    }

    protected void mo5689b(Object[] objArr) {
        Intrinsics.m26847b(objArr, "args");
        if (m26896a() != objArr.length) {
            StringBuilder stringBuilder = new StringBuilder("Callable expects ");
            stringBuilder.append(m26896a());
            stringBuilder.append(" arguments, but ");
            stringBuilder.append(objArr.length);
            stringBuilder.append(" were provided.");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    protected final void m26898a(Object obj) {
        if (obj != null) {
            Member member = this.f25323a;
            if (member == null) {
                Intrinsics.m26842a();
            }
            if (member.getDeclaringClass().isInstance(obj) != null) {
                return;
            }
        }
        throw ((Throwable) new IllegalArgumentException("An object member requires the object instance passed as the first argument."));
    }
}
