package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.reddit.frontpage.presentation.modtools.bottomsheet.modqueueoptions.ModQueueOptionsPresenter;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Object;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.platform.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;

/* compiled from: methodSignatureMapping.kt */
public final class MethodSignatureMappingKt {
    public static final String m27351a(FunctionDescriptor functionDescriptor, boolean z) {
        String str;
        Intrinsics.m26847b(functionDescriptor, "$receiver");
        StringBuilder stringBuilder = new StringBuilder();
        if (functionDescriptor instanceof ConstructorDescriptor) {
            str = "<init>";
        } else {
            str = functionDescriptor.mo6689i().m27429a();
            Intrinsics.m26843a((Object) str, "name.asString()");
        }
        stringBuilder.append(str);
        stringBuilder.append("(");
        for (ValueParameterDescriptor x : functionDescriptor.mo7757k()) {
            KotlinType x2 = x.mo7777x();
            Intrinsics.m26843a((Object) x2, "it.type");
            m27353a(stringBuilder, x2);
        }
        stringBuilder.append(")");
        if (z) {
            if (TypeSignatureMappingKt.m27381a((CallableDescriptor) functionDescriptor)) {
                stringBuilder.append("V");
            } else {
                KotlinType aN_ = functionDescriptor.aN_();
                if (aN_ == null) {
                    Intrinsics.m26842a();
                }
                Intrinsics.m26843a((Object) aN_, "returnType!!");
                m27353a(stringBuilder, aN_);
            }
        }
        return stringBuilder.toString();
    }

    public static final boolean m27354b(FunctionDescriptor functionDescriptor) {
        Intrinsics.m26847b(functionDescriptor, "f");
        if (functionDescriptor.mo7757k().size() == 1 && !SpecialBuiltinMembers.m27175e(functionDescriptor)) {
            if ((Intrinsics.m26845a(functionDescriptor.mo6689i().m27429a(), ModQueueOptionsPresenter.ACTION_REMOVE) ^ 1) == 0) {
                JvmType a = m27352a(((ValueParameterDescriptor) CollectionsKt___CollectionsKt.m41441h(functionDescriptor.mo7761v().mo7757k())).mo7777x());
                Object obj = null;
                if (!(a instanceof Primitive)) {
                    a = null;
                }
                Primitive primitive = (Primitive) a;
                if (primitive != null) {
                    obj = primitive.f32823a;
                }
                if ((Intrinsics.m26845a(obj, JvmPrimitiveType.INT) ^ 1) != 0) {
                    return false;
                }
                functionDescriptor = BuiltinMethodsWithSpecialGenericSignature.m27133a(functionDescriptor);
                if (functionDescriptor == null) {
                    return false;
                }
                a = m27352a(((ValueParameterDescriptor) CollectionsKt___CollectionsKt.m41441h(functionDescriptor.mo7761v().mo7757k())).mo7777x());
                return (Intrinsics.m26845a(DescriptorUtilsKt.m27738a(functionDescriptor.aD_()), KotlinBuiltIns.f25420j.f25374U.m27409b()) == null || (a instanceof Object) == null || Intrinsics.m26845a(((Object) a).f32822a, (Object) "java/lang/Object") == null) ? false : true;
            }
        }
        return false;
    }

    public static final String m27349a(ClassDescriptor classDescriptor) {
        Intrinsics.m26847b(classDescriptor, "$receiver");
        ClassId a = JavaToKotlinClassMap.f25878a.m27443a(DescriptorUtilsKt.m27742b((DeclarationDescriptor) classDescriptor).m27409b());
        if (a == null) {
            return TypeSignatureMappingKt.m27379a(classDescriptor, TypeMappingConfigurationImpl.f32826b);
        }
        Object a2 = JvmClassName.m27749a(a).m27752a();
        Intrinsics.m26843a(a2, "JvmClassName.byClassId(it).internalName");
        return a2;
    }

    private static final void m27353a(StringBuilder stringBuilder, KotlinType kotlinType) {
        stringBuilder.append(m27352a(kotlinType));
    }

    public static final JvmType m27352a(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "$receiver");
        return (JvmType) TypeSignatureMappingKt.m27377a(kotlinType, JvmTypeFactoryImpl.f32824a, TypeMappingMode.f25815g, TypeMappingConfigurationImpl.f32826b, null, FunctionsKt.m28108d());
    }

    public static final String m27348a(CallableDescriptor callableDescriptor) {
        Intrinsics.m26847b(callableDescriptor, "$receiver");
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.f25810a;
        if (DescriptorUtils.m27651b((DeclarationDescriptor) callableDescriptor)) {
            return null;
        }
        DeclarationDescriptor aD_ = callableDescriptor.aD_();
        if (!(aD_ instanceof ClassDescriptor)) {
            aD_ = null;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) aD_;
        if (classDescriptor == null || classDescriptor.mo6689i().f25866a) {
            return null;
        }
        callableDescriptor = callableDescriptor.aM_();
        if (!(callableDescriptor instanceof SimpleFunctionDescriptor)) {
            callableDescriptor = null;
        }
        SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) callableDescriptor;
        if (simpleFunctionDescriptor == null) {
            return null;
        }
        String a = m27351a((FunctionDescriptor) simpleFunctionDescriptor, true);
        Intrinsics.m26843a((Object) a, "(original as? SimpleFunc…l).computeJvmDescriptor()");
        return SignatureBuildingComponents.m27359a(classDescriptor, a);
    }
}
