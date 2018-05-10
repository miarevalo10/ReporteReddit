package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.FunctionCaller.BoundInstanceMethod;
import kotlin.reflect.jvm.internal.FunctionCaller.BoundJvmStaticInObject;
import kotlin.reflect.jvm.internal.FunctionCaller.BoundStaticMethod;
import kotlin.reflect.jvm.internal.FunctionCaller.InstanceMethod;
import kotlin.reflect.jvm.internal.FunctionCaller.JvmStaticInObject;
import kotlin.reflect.jvm.internal.FunctionCaller.StaticMethod;
import kotlin.reflect.jvm.internal.JvmPropertySignature.JavaField;
import kotlin.reflect.jvm.internal.JvmPropertySignature.JavaMethodProperty;
import kotlin.reflect.jvm.internal.JvmPropertySignature.KotlinProperty;
import kotlin.reflect.jvm.internal.KPropertyImpl.Accessor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBuf.JvmMethodSignature;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBuf.JvmPropertySignature;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a \u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¨\u0006\u0005"}, d2 = {"computeCallerForAccessor", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "isGetter", "", "kotlin-reflection"}, k = 2, mv = {1, 1, 5})
/* compiled from: KPropertyImpl.kt */
public final class KPropertyImplKt {
    public static final /* synthetic */ FunctionCaller m26912a(Accessor accessor, boolean z) {
        KPropertyImplKt$computeCallerForAccessor$1 kPropertyImplKt$computeCallerForAccessor$1 = new KPropertyImplKt$computeCallerForAccessor$1(accessor);
        KPropertyImplKt$computeCallerForAccessor$2 kPropertyImplKt$computeCallerForAccessor$2 = new KPropertyImplKt$computeCallerForAccessor$2(accessor);
        KPropertyImplKt$computeCallerForAccessor$4 kPropertyImplKt$computeCallerForAccessor$4 = new KPropertyImplKt$computeCallerForAccessor$4(accessor, kPropertyImplKt$computeCallerForAccessor$1, z, new KPropertyImplKt$computeCallerForAccessor$3(accessor), kPropertyImplKt$computeCallerForAccessor$2);
        RuntimeTypeMapper runtimeTypeMapper = RuntimeTypeMapper.f25343a;
        JvmPropertySignature a = RuntimeTypeMapper.m26929a(accessor.mo7255d().m36189m());
        if (a instanceof KotlinProperty) {
            JvmMethodSignature jvmMethodSignature;
            KDeclarationContainerImpl kDeclarationContainerImpl;
            String a2;
            String a3;
            KPropertyImplKt$computeCallerForAccessor$4 kPropertyImplKt$computeCallerForAccessor$42;
            Field k;
            KotlinProperty kotlinProperty = (KotlinProperty) a;
            JvmPropertySignature jvmPropertySignature = kotlinProperty.f32564c;
            Method method = null;
            if (z) {
                if (jvmPropertySignature.m40424j()) {
                    z = jvmPropertySignature.f39937e;
                    jvmMethodSignature = (JvmMethodSignature) z;
                    if (jvmMethodSignature != null) {
                        jvmMethodSignature = jvmMethodSignature;
                        kDeclarationContainerImpl = accessor.mo7255d().f36037b;
                        a2 = kotlinProperty.f32565d.mo5829a(jvmMethodSignature.f39922c);
                        Intrinsics.m26843a((Object) a2, "jvmSignature.nameResolve…getString(signature.name)");
                        a3 = kotlinProperty.f32565d.mo5829a(jvmMethodSignature.f39923d);
                        Intrinsics.m26843a((Object) a3, "jvmSignature.nameResolve…getString(signature.desc)");
                        method = kDeclarationContainerImpl.m36167a(a2, a3, Visibilities.m27096a(accessor.mo7076i().mo7257j()));
                    }
                    if (method != null) {
                        kPropertyImplKt$computeCallerForAccessor$42 = kPropertyImplKt$computeCallerForAccessor$4;
                        k = accessor.mo7255d().m36187k();
                        if (k == null) {
                            Intrinsics.m26842a();
                        }
                        return kPropertyImplKt$computeCallerForAccessor$42.m38289a(k);
                    } else if (Modifier.isStatic(method.getModifiers())) {
                        if (accessor.mo7255d().mo6675f()) {
                            z = (FunctionCaller.Method) new BoundInstanceMethod(method, accessor.mo7255d().f36040e);
                        } else {
                            z = (FunctionCaller.Method) new InstanceMethod(method);
                        }
                        return (FunctionCaller) z;
                    } else if (kPropertyImplKt$computeCallerForAccessor$2.m38286a()) {
                        if (accessor.mo7255d().mo6675f() != null) {
                            accessor = (FunctionCaller.Method) new BoundJvmStaticInObject(method);
                        } else {
                            accessor = (FunctionCaller.Method) new JvmStaticInObject(method);
                        }
                        return (FunctionCaller) accessor;
                    } else {
                        if (accessor.mo7255d().mo6675f()) {
                            z = (FunctionCaller.Method) new BoundStaticMethod(method, accessor.mo7255d().f36040e);
                        } else {
                            z = (FunctionCaller.Method) new StaticMethod(method);
                        }
                        return (FunctionCaller) z;
                    }
                }
            } else if (jvmPropertySignature.m40425k()) {
                z = jvmPropertySignature.f39938f;
                jvmMethodSignature = (JvmMethodSignature) z;
                if (jvmMethodSignature != null) {
                    jvmMethodSignature = jvmMethodSignature;
                    kDeclarationContainerImpl = accessor.mo7255d().f36037b;
                    a2 = kotlinProperty.f32565d.mo5829a(jvmMethodSignature.f39922c);
                    Intrinsics.m26843a((Object) a2, "jvmSignature.nameResolve…getString(signature.name)");
                    a3 = kotlinProperty.f32565d.mo5829a(jvmMethodSignature.f39923d);
                    Intrinsics.m26843a((Object) a3, "jvmSignature.nameResolve…getString(signature.desc)");
                    method = kDeclarationContainerImpl.m36167a(a2, a3, Visibilities.m27096a(accessor.mo7076i().mo7257j()));
                }
                if (method != null) {
                    kPropertyImplKt$computeCallerForAccessor$42 = kPropertyImplKt$computeCallerForAccessor$4;
                    k = accessor.mo7255d().m36187k();
                    if (k == null) {
                        Intrinsics.m26842a();
                    }
                    return kPropertyImplKt$computeCallerForAccessor$42.m38289a(k);
                } else if (Modifier.isStatic(method.getModifiers())) {
                    if (accessor.mo7255d().mo6675f()) {
                        z = (FunctionCaller.Method) new InstanceMethod(method);
                    } else {
                        z = (FunctionCaller.Method) new BoundInstanceMethod(method, accessor.mo7255d().f36040e);
                    }
                    return (FunctionCaller) z;
                } else if (kPropertyImplKt$computeCallerForAccessor$2.m38286a()) {
                    if (accessor.mo7255d().mo6675f()) {
                        z = (FunctionCaller.Method) new StaticMethod(method);
                    } else {
                        z = (FunctionCaller.Method) new BoundStaticMethod(method, accessor.mo7255d().f36040e);
                    }
                    return (FunctionCaller) z;
                } else {
                    if (accessor.mo7255d().mo6675f() != null) {
                        accessor = (FunctionCaller.Method) new JvmStaticInObject(method);
                    } else {
                        accessor = (FunctionCaller.Method) new BoundJvmStaticInObject(method);
                    }
                    return (FunctionCaller) accessor;
                }
            }
            z = false;
            jvmMethodSignature = (JvmMethodSignature) z;
            if (jvmMethodSignature != null) {
                jvmMethodSignature = jvmMethodSignature;
                kDeclarationContainerImpl = accessor.mo7255d().f36037b;
                a2 = kotlinProperty.f32565d.mo5829a(jvmMethodSignature.f39922c);
                Intrinsics.m26843a((Object) a2, "jvmSignature.nameResolve…getString(signature.name)");
                a3 = kotlinProperty.f32565d.mo5829a(jvmMethodSignature.f39923d);
                Intrinsics.m26843a((Object) a3, "jvmSignature.nameResolve…getString(signature.desc)");
                method = kDeclarationContainerImpl.m36167a(a2, a3, Visibilities.m27096a(accessor.mo7076i().mo7257j()));
            }
            if (method != null) {
                kPropertyImplKt$computeCallerForAccessor$42 = kPropertyImplKt$computeCallerForAccessor$4;
                k = accessor.mo7255d().m36187k();
                if (k == null) {
                    Intrinsics.m26842a();
                }
                return kPropertyImplKt$computeCallerForAccessor$42.m38289a(k);
            } else if (Modifier.isStatic(method.getModifiers())) {
                if (accessor.mo7255d().mo6675f()) {
                    z = (FunctionCaller.Method) new BoundInstanceMethod(method, accessor.mo7255d().f36040e);
                } else {
                    z = (FunctionCaller.Method) new InstanceMethod(method);
                }
                return (FunctionCaller) z;
            } else if (kPropertyImplKt$computeCallerForAccessor$2.m38286a()) {
                if (accessor.mo7255d().mo6675f() != null) {
                    accessor = (FunctionCaller.Method) new BoundJvmStaticInObject(method);
                } else {
                    accessor = (FunctionCaller.Method) new JvmStaticInObject(method);
                }
                return (FunctionCaller) accessor;
            } else {
                if (accessor.mo7255d().mo6675f()) {
                    z = (FunctionCaller.Method) new BoundStaticMethod(method, accessor.mo7255d().f36040e);
                } else {
                    z = (FunctionCaller.Method) new StaticMethod(method);
                }
                return (FunctionCaller) z;
            }
        } else if (a instanceof JavaField) {
            return kPropertyImplKt$computeCallerForAccessor$4.m38289a(((JavaField) a).f32559a);
        } else {
            if (a instanceof JavaMethodProperty) {
                FunctionCaller.Method boundInstanceMethod;
                if (z) {
                    z = ((JavaMethodProperty) a).f32560a;
                } else {
                    JavaMethodProperty javaMethodProperty = (JavaMethodProperty) a;
                    z = javaMethodProperty.f32561b;
                    if (!z) {
                        z = new StringBuilder("No source found for setter of Java method property: ");
                        z.append(javaMethodProperty.f32560a);
                        throw ((Throwable) new KotlinReflectionInternalError(z.toString()));
                    }
                }
                if (accessor.mo7255d().mo6675f()) {
                    boundInstanceMethod = new BoundInstanceMethod(z, accessor.mo7255d().f36040e);
                } else {
                    boundInstanceMethod = (FunctionCaller.Method) new InstanceMethod(z);
                }
                return boundInstanceMethod;
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
