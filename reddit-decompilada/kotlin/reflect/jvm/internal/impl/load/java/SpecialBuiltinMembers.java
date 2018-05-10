package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckingProcedure;

/* compiled from: specialBuiltinMembers.kt */
public final class SpecialBuiltinMembers {
    public static final <T extends CallableMemberDescriptor> T m27167a(T t) {
        Intrinsics.m26847b(t, "$receiver");
        BuiltinMethodsWithDifferentJvmName builtinMethodsWithDifferentJvmName = BuiltinMethodsWithDifferentJvmName.f25594a;
        if ((BuiltinMethodsWithDifferentJvmName.m27126a().contains(t.mo6689i()) ^ 1) != 0) {
            BuiltinSpecialProperties builtinSpecialProperties = BuiltinSpecialProperties.f25619a;
            if ((BuiltinSpecialProperties.m27138a().contains(DescriptorUtilsKt.m27733a((CallableMemberDescriptor) t).mo6689i()) ^ 1) != 0) {
                return null;
            }
        }
        if (!(t instanceof PropertyDescriptor)) {
            if (!(t instanceof PropertyAccessorDescriptor)) {
                if (t instanceof SimpleFunctionDescriptor) {
                    return DescriptorUtilsKt.m27734a(t, SpecialBuiltinMembers$getOverriddenBuiltinWithDifferentJvmName$2.f38364a);
                }
                return null;
            }
        }
        return DescriptorUtilsKt.m27734a(t, SpecialBuiltinMembers$getOverriddenBuiltinWithDifferentJvmName$1.f38363a);
    }

    public static final boolean m27172b(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.m26847b(callableMemberDescriptor, "$receiver");
        return m27167a(callableMemberDescriptor) != null ? true : null;
    }

    public static final <T extends CallableMemberDescriptor> T m27173c(T t) {
        Intrinsics.m26847b(t, "$receiver");
        CallableMemberDescriptor a = m27167a(t);
        if (a != null) {
            return a;
        }
        BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = BuiltinMethodsWithSpecialGenericSignature.f25612a;
        if (BuiltinMethodsWithSpecialGenericSignature.m27135a(t.mo6689i())) {
            return DescriptorUtilsKt.m27734a(t, SpecialBuiltinMembers$getOverriddenSpecialBuiltin$2.f38365a);
        }
        return null;
    }

    public static final boolean m27171a(ClassDescriptor classDescriptor, CallableDescriptor callableDescriptor) {
        Intrinsics.m26847b(classDescriptor, "$receiver");
        Intrinsics.m26847b(callableDescriptor, "specialCallableDescriptor");
        callableDescriptor = callableDescriptor.aD_();
        if (callableDescriptor == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        }
        callableDescriptor = ((ClassDescriptor) callableDescriptor).mo7714h();
        for (classDescriptor = DescriptorUtils.m27637a(classDescriptor); classDescriptor != null; classDescriptor = DescriptorUtils.m27637a(classDescriptor)) {
            if (!(classDescriptor instanceof JavaClassDescriptor)) {
                if (TypeCheckingProcedure.m28043a((KotlinType) classDescriptor.mo7714h(), (KotlinType) callableDescriptor) != null) {
                    if (KotlinBuiltIns.m26973a((DeclarationDescriptor) classDescriptor) == null) {
                        return true;
                    }
                    return false;
                }
            }
        }
        return false;
    }

    public static final boolean m27175e(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.m26847b(callableMemberDescriptor, "$receiver");
        Intrinsics.m26847b(callableMemberDescriptor, "$receiver");
        CallableMemberDescriptor a = DescriptorUtilsKt.m27733a(callableMemberDescriptor);
        DeclarationDescriptor declarationDescriptor = null;
        if (!(a instanceof JavaCallableMemberDescriptor)) {
            a = null;
        }
        JavaCallableMemberDescriptor javaCallableMemberDescriptor = (JavaCallableMemberDescriptor) a;
        if (javaCallableMemberDescriptor != null) {
            declarationDescriptor = javaCallableMemberDescriptor.aD_();
        }
        if (!(declarationDescriptor instanceof JavaClassDescriptor)) {
            if (KotlinBuiltIns.m26973a((DeclarationDescriptor) callableMemberDescriptor) == null) {
                return null;
            }
        }
        return true;
    }

    public static final String m27174d(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.m26847b(callableMemberDescriptor, "callableMemberDescriptor");
        callableMemberDescriptor = KotlinBuiltIns.m26973a((DeclarationDescriptor) callableMemberDescriptor) ? m27167a(callableMemberDescriptor) : null;
        if (callableMemberDescriptor != null) {
            callableMemberDescriptor = DescriptorUtilsKt.m27733a(callableMemberDescriptor);
            if (callableMemberDescriptor != null) {
                if (callableMemberDescriptor instanceof PropertyDescriptor) {
                    BuiltinSpecialProperties builtinSpecialProperties = BuiltinSpecialProperties.f25619a;
                    return BuiltinSpecialProperties.m27140b(callableMemberDescriptor);
                } else if (!(callableMemberDescriptor instanceof SimpleFunctionDescriptor)) {
                    return null;
                } else {
                    BuiltinMethodsWithDifferentJvmName builtinMethodsWithDifferentJvmName = BuiltinMethodsWithDifferentJvmName.f25594a;
                    callableMemberDescriptor = BuiltinMethodsWithDifferentJvmName.m27127a((SimpleFunctionDescriptor) callableMemberDescriptor);
                    if (callableMemberDescriptor != null) {
                        return callableMemberDescriptor.m27429a();
                    }
                    return null;
                }
            }
        }
        return null;
    }

    public static final /* synthetic */ FqName m27170a(FqNameUnsafe fqNameUnsafe, String str) {
        Object d = fqNameUnsafe.m27416a(Name.m27424a(str)).m27420d();
        Intrinsics.m26843a(d, "child(Name.identifier(name)).toSafe()");
        return d;
    }

    public static final /* synthetic */ FqName m27169a(FqName fqName, String str) {
        Object a = fqName.m27408a(Name.m27424a(str));
        Intrinsics.m26843a(a, "child(Name.identifier(name))");
        return a;
    }

    public static final /* synthetic */ NameAndSignature m27168a(String str, String str2, String str3, String str4) {
        Object a = Name.m27424a(str2);
        Intrinsics.m26843a(a, "Name.identifier(name)");
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.f25810a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str3);
        stringBuilder.append(")");
        stringBuilder.append(str4);
        return new NameAndSignature(a, SignatureBuildingComponents.m27358a(str, stringBuilder.toString()));
    }
}
