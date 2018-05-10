package kotlin.reflect.jvm.internal;

import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.FunctionCaller.BoundConstructor;
import kotlin.reflect.jvm.internal.FunctionCaller.BoundInstanceMethod;
import kotlin.reflect.jvm.internal.FunctionCaller.BoundJvmStaticInObject;
import kotlin.reflect.jvm.internal.FunctionCaller.BoundStaticMethod;
import kotlin.reflect.jvm.internal.FunctionCaller.InstanceMethod;
import kotlin.reflect.jvm.internal.FunctionCaller.JvmStaticInObject;
import kotlin.reflect.jvm.internal.FunctionCaller.Method;
import kotlin.reflect.jvm.internal.FunctionCaller.StaticMethod;
import kotlin.reflect.jvm.internal.FunctionWithAllInvokes.DefaultImpls;
import kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUtilKt;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00032\u00020\u00042\u00020\u0005B)\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\fB\u0017\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fB5\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0011J\u001e\u0010*\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030+0\u00132\n\u0010,\u001a\u0006\u0012\u0002\b\u00030+H\u0002J\u0010\u0010-\u001a\u00020.2\u0006\u0010,\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020.2\u0006\u0010,\u001a\u00020/H\u0002J\u0010\u00101\u001a\u00020.2\u0006\u0010,\u001a\u00020/H\u0002J\u0013\u00102\u001a\u00020!2\b\u00103\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u000205H\u0016J\b\u00107\u001a\u00020!H\u0002J\b\u00108\u001a\u00020!H\u0002J\b\u00109\u001a\u00020\tH\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0002X\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00138VX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R!\u0010\u001a\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00138VX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001b\u0010\u0015R\u001b\u0010\r\u001a\u00020\u000e8VX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0017\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020!8VX\u0004¢\u0006\u0006\u001a\u0004\b \u0010\"R\u0014\u0010#\u001a\u00020!8VX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\"R\u0014\u0010$\u001a\u00020!8VX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\"R\u0014\u0010%\u001a\u00020!8VX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\"R\u0014\u0010&\u001a\u00020!8VX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\"R\u0014\u0010'\u001a\u00020!8VX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\"R\u0014\u0010\b\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u000e\u0010\n\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lkotlin/reflect/jvm/internal/KFunctionImpl;", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "Lkotlin/reflect/KFunction;", "Lkotlin/jvm/internal/FunctionBase;", "Lkotlin/reflect/jvm/internal/FunctionWithAllInvokes;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;)V", "descriptorInitialValue", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Ljava/lang/Object;)V", "caller", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "getCaller", "()Lkotlin/reflect/jvm/internal/FunctionCaller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "defaultCaller$delegate", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "descriptor$delegate", "isBound", "", "()Z", "isExternal", "isInfix", "isInline", "isOperator", "isSuspend", "getName", "()Ljava/lang/String;", "createConstructorCaller", "Ljava/lang/reflect/Constructor;", "member", "createInstanceMethodCaller", "Lkotlin/reflect/jvm/internal/FunctionCaller$Method;", "Ljava/lang/reflect/Method;", "createJvmStaticInObjectCaller", "createStaticMethodCaller", "equals", "other", "getArity", "", "hashCode", "isDeclared", "isPrivateInBytecode", "toString", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
/* compiled from: KFunctionImpl.kt */
public final class KFunctionImpl extends KCallableImpl<Object> implements FunctionBase, KFunction<Object>, FunctionWithAllInvokes {
    static final /* synthetic */ KProperty[] f38252b = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(KFunctionImpl.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(KFunctionImpl.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/FunctionCaller;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(KFunctionImpl.class), "defaultCaller", "getDefaultCaller()Lkotlin/reflect/jvm/internal/FunctionCaller;"))};
    final KDeclarationContainerImpl f38253a;
    private final LazySoftVal f38254c;
    private final LazySoftVal f38255d;
    private final LazySoftVal f38256e;
    private final String f38257f;
    private final Object f38258g;

    public final Object mo6492a(Object obj) {
        return DefaultImpls.m26901a(this, obj);
    }

    public final Object mo6497a(Object obj, Object obj2) {
        return DefaultImpls.m26902a(this, obj, obj2);
    }

    public final Object mo6509a(Object obj, Object obj2, Object obj3) {
        return DefaultImpls.m26903a(this, obj, obj2, obj3);
    }

    public final Object mo6942a(Object obj, Object obj2, Object obj3, Object obj4) {
        return DefaultImpls.m26904a(this, obj, obj2, obj3, obj4);
    }

    public final Object mo6933a(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return DefaultImpls.m26905a(this, obj, obj2, obj3, obj4, obj5, obj6);
    }

    public final /* synthetic */ CallableMemberDescriptor mo6676a() {
        return m38251d();
    }

    public final Object invoke() {
        return DefaultImpls.m26900a(this);
    }

    public final KDeclarationContainerImpl mo6674e() {
        return this.f38253a;
    }

    private KFunctionImpl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, FunctionDescriptor functionDescriptor, Object obj) {
        this.f38253a = kDeclarationContainerImpl;
        this.f38257f = str2;
        this.f38258g = obj;
        this.f38254c = ReflectProperties.m26917a(functionDescriptor, (Function0) new KFunctionImpl$descriptor$2(this, str));
        this.f38255d = ReflectProperties.m26919b((Function0) new KFunctionImpl$caller$2(this));
        this.f38256e = ReflectProperties.m26919b((Function0) new KFunctionImpl$defaultCaller$2(this));
    }

    public KFunctionImpl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, Object obj) {
        Intrinsics.m26847b(kDeclarationContainerImpl, "container");
        Intrinsics.m26847b(str, "name");
        Intrinsics.m26847b(str2, "signature");
        this(kDeclarationContainerImpl, str, str2, null, obj);
    }

    public KFunctionImpl(KDeclarationContainerImpl kDeclarationContainerImpl, FunctionDescriptor functionDescriptor) {
        Intrinsics.m26847b(kDeclarationContainerImpl, "container");
        Intrinsics.m26847b(functionDescriptor, "descriptor");
        String a = functionDescriptor.mo6689i().m27429a();
        Intrinsics.m26843a((Object) a, "descriptor.name.asString()");
        RuntimeTypeMapper runtimeTypeMapper = RuntimeTypeMapper.f25343a;
        this(kDeclarationContainerImpl, a, RuntimeTypeMapper.m26928a(functionDescriptor).mo5690a(), functionDescriptor);
    }

    public final boolean mo6675f() {
        return Intrinsics.m26845a(this.f38258g, CallableReference.f32530c) ^ 1;
    }

    public final String mo5687b() {
        Object a = m38251d().mo6689i().m27429a();
        Intrinsics.m26843a(a, "descriptor.name.asString()");
        return a;
    }

    public final int getArity() {
        return mo6677c().m26896a();
    }

    public final boolean equals(Object obj) {
        obj = UtilKt.m26934a(obj);
        if (obj != null && Intrinsics.m26845a(this.f38253a, obj.f38253a) && Intrinsics.m26845a(mo5687b(), obj.mo5687b()) && Intrinsics.m26845a(this.f38257f, obj.f38257f) && Intrinsics.m26845a(this.f38258g, obj.f38258g) != null) {
            return true;
        }
        return false;
    }

    public final String toString() {
        ReflectionObjectRenderer reflectionObjectRenderer = ReflectionObjectRenderer.f25341a;
        return ReflectionObjectRenderer.m26921a(m38251d());
    }

    public final FunctionDescriptor m38251d() {
        return (FunctionDescriptor) this.f38254c.mo5694a();
    }

    public final FunctionCaller<?> mo6677c() {
        return (FunctionCaller) this.f38255d.mo5694a();
    }

    public final int hashCode() {
        return (((this.f38253a.hashCode() * 31) + mo5687b().hashCode()) * 31) + this.f38257f.hashCode();
    }

    public static final /* synthetic */ boolean m38241b(KFunctionImpl kFunctionImpl) {
        if (!Visibilities.m27096a(kFunctionImpl.m38251d().mo7257j())) {
            if (AnnotationUtilKt.m27112a((MemberDescriptor) kFunctionImpl.m38251d()) == null) {
                return null;
            }
        }
        return true;
    }

    public static final /* synthetic */ FunctionCaller m38239a(KFunctionImpl kFunctionImpl, Constructor constructor) {
        return kFunctionImpl.mo6675f() ? new BoundConstructor(constructor, kFunctionImpl.f38258g) : (FunctionCaller) new FunctionCaller.Constructor(constructor);
    }

    public static final /* synthetic */ Method m38238a(KFunctionImpl kFunctionImpl, java.lang.reflect.Method method) {
        return kFunctionImpl.mo6675f() ? new BoundInstanceMethod(method, kFunctionImpl.f38258g) : (Method) new InstanceMethod(method);
    }

    public static final /* synthetic */ Method m38240b(KFunctionImpl kFunctionImpl, java.lang.reflect.Method method) {
        return kFunctionImpl.mo6675f() != null ? (Method) new BoundJvmStaticInObject(method) : (Method) new JvmStaticInObject(method);
    }

    public static final /* synthetic */ Method m38242c(KFunctionImpl kFunctionImpl, java.lang.reflect.Method method) {
        return kFunctionImpl.mo6675f() ? new BoundStaticMethod(method, kFunctionImpl.f38258g) : (Method) new StaticMethod(method);
    }
}
