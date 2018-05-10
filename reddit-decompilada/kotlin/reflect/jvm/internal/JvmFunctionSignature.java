package kotlin.reflect.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0006\u0005\u0006\u0007\b\t\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u0001\u0006\u000b\f\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "", "()V", "asString", "", "BuiltInFunction", "FakeJavaAnnotationConstructor", "JavaConstructor", "JavaMethod", "KotlinConstructor", "KotlinFunction", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaMethod;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$FakeJavaAnnotationConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$BuiltInFunction;", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
/* compiled from: RuntimeTypeMapper.kt */
public abstract class JvmFunctionSignature {

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001\nB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$BuiltInFunction;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "signature", "", "(Ljava/lang/String;)V", "asString", "getMember", "Ljava/lang/reflect/Member;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Predefined", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: RuntimeTypeMapper.kt */
    public static class BuiltInFunction extends JvmFunctionSignature {
        private final String f32552a;

        @Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$BuiltInFunction$Predefined;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$BuiltInFunction;", "signature", "", "member", "Ljava/lang/reflect/Member;", "(Ljava/lang/String;Ljava/lang/reflect/Member;)V", "getMember", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
        /* compiled from: RuntimeTypeMapper.kt */
        public static final class Predefined extends BuiltInFunction {
            private final Member f36030a;

            public Predefined(String str, Member member) {
                Intrinsics.m26847b(str, "signature");
                Intrinsics.m26847b(member, "member");
                super(str);
                this.f36030a = member;
            }

            public final Member mo6673a(KDeclarationContainerImpl kDeclarationContainerImpl) {
                Intrinsics.m26847b(kDeclarationContainerImpl, "container");
                return this.f36030a;
            }
        }

        public Member mo6673a(KDeclarationContainerImpl kDeclarationContainerImpl) {
            Intrinsics.m26847b(kDeclarationContainerImpl, "container");
            return null;
        }

        public BuiltInFunction(String str) {
            Intrinsics.m26847b(str, "signature");
            super();
            this.f32552a = str;
        }

        public final String mo5690a() {
            return this.f32552a;
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001f\u0010\u0007\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$FakeJavaAnnotationConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "getJClass", "()Ljava/lang/Class;", "methods", "", "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "getMethods", "()Ljava/util/List;", "asString", "", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: RuntimeTypeMapper.kt */
    public static final class FakeJavaAnnotationConstructor extends JvmFunctionSignature {
        final List<Method> f32553a = ArraysKt___ArraysKt.m36085a((Object[]) this.f32554b.getDeclaredMethods(), (Comparator) new C2136x577aa3c4());
        private final Class<?> f32554b;

        public FakeJavaAnnotationConstructor(Class<?> cls) {
            Intrinsics.m26847b(cls, "jClass");
            super();
            this.f32554b = cls;
        }

        public final String mo5690a() {
            return CollectionsKt___CollectionsKt.m41412a((Iterable) this.f32553a, (CharSequence) "", (CharSequence) "<init>(", (CharSequence) ")V", 0, null, (Function1) JvmFunctionSignature$FakeJavaAnnotationConstructor$asString$1.f38214a, 24);
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "constructor", "Ljava/lang/reflect/Constructor;", "(Ljava/lang/reflect/Constructor;)V", "getConstructor", "()Ljava/lang/reflect/Constructor;", "asString", "", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: RuntimeTypeMapper.kt */
    public static final class JavaConstructor extends JvmFunctionSignature {
        final Constructor<?> f32555a;

        public JavaConstructor(Constructor<?> constructor) {
            Intrinsics.m26847b(constructor, "constructor");
            super();
            this.f32555a = constructor;
        }

        public final String mo5690a() {
            return ArraysKt___ArraysKt.m36083a((Object[]) this.f32555a.getParameterTypes(), (CharSequence) "", (CharSequence) "<init>(", (CharSequence) ")V", 0, null, (Function1) JvmFunctionSignature$JavaConstructor$asString$1.f38215a, 24);
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaMethod;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "getMethod", "()Ljava/lang/reflect/Method;", "asString", "", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: RuntimeTypeMapper.kt */
    public static final class JavaMethod extends JvmFunctionSignature {
        final Method f32556a;

        public JavaMethod(Method method) {
            Intrinsics.m26847b(method, "method");
            super();
            this.f32556a = method;
        }

        public final String mo5690a() {
            return RuntimeTypeMapperKt.m26931a(this.f32556a);
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\u0003H\u0016R\u0011\u0010\u0005\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\n"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "signature", "", "(Ljava/lang/String;)V", "constructorDesc", "getConstructorDesc", "()Ljava/lang/String;", "getSignature", "asString", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: RuntimeTypeMapper.kt */
    public static final class KotlinConstructor extends JvmFunctionSignature {
        private final String f32557a;

        public KotlinConstructor(String str) {
            Intrinsics.m26847b(str, "signature");
            super();
            this.f32557a = str;
        }

        public final String m32876b() {
            String str = this.f32557a;
            int a = StringsKt__StringsKt.m42439a((CharSequence) this.f32557a, '(', 0, 6);
            if (str == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            Object substring = str.substring(a);
            Intrinsics.m26843a(substring, "(this as java.lang.String).substring(startIndex)");
            return substring;
        }

        public final String mo5690a() {
            return this.f32557a;
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\u0003H\u0016R\u0011\u0010\u0005\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007¨\u0006\f"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "signature", "", "(Ljava/lang/String;)V", "methodDesc", "getMethodDesc", "()Ljava/lang/String;", "methodName", "getMethodName", "getSignature", "asString", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: RuntimeTypeMapper.kt */
    public static final class KotlinFunction extends JvmFunctionSignature {
        private final String f32558a;

        public KotlinFunction(String str) {
            Intrinsics.m26847b(str, "signature");
            super();
            this.f32558a = str;
        }

        public final String m32878b() {
            return StringsKt__StringsKt.m42445a(this.f32558a, '(');
        }

        public final String m32879c() {
            String str = this.f32558a;
            int a = StringsKt__StringsKt.m42439a((CharSequence) this.f32558a, '(', 0, 6);
            if (str == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            Object substring = str.substring(a);
            Intrinsics.m26843a(substring, "(this as java.lang.String).substring(startIndex)");
            return substring;
        }

        public final String mo5690a() {
            return this.f32558a;
        }
    }

    public abstract String mo5690a();

    private JvmFunctionSignature() {
    }
}
