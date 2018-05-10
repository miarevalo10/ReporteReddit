package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import kotlin.Pair;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Contract;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: JavaIncompatibilityRulesOverridabilityCondition.kt */
public final class JavaIncompatibilityRulesOverridabilityCondition implements ExternalOverridabilityCondition {
    public static final Companion f32694a = new Companion();

    /* compiled from: JavaIncompatibilityRulesOverridabilityCondition.kt */
    public static final class Companion {
        private Companion() {
        }

        public static boolean m27148a(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
            Intrinsics.m26847b(callableDescriptor, "superDescriptor");
            Intrinsics.m26847b(callableDescriptor2, "subDescriptor");
            if (callableDescriptor2 instanceof JavaMethodDescriptor) {
                if (callableDescriptor instanceof FunctionDescriptor) {
                    JavaMethodDescriptor javaMethodDescriptor = (JavaMethodDescriptor) callableDescriptor2;
                    FunctionDescriptor functionDescriptor = (FunctionDescriptor) callableDescriptor;
                    boolean z = javaMethodDescriptor.mo7757k().size() == functionDescriptor.mo7757k().size();
                    if (!_Assertions.f25274a || z) {
                        Iterable k = javaMethodDescriptor.m42807u().mo7757k();
                        Object k2 = functionDescriptor.mo7761v().mo7757k();
                        Intrinsics.m26843a(k2, "superDescriptor.original.valueParameters");
                        for (Pair pair : CollectionsKt___CollectionsKt.m41417a(k, (Iterable) k2)) {
                            ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) pair.f25267a;
                            ValueParameterDescriptor valueParameterDescriptor2 = (ValueParameterDescriptor) pair.f25268b;
                            FunctionDescriptor functionDescriptor2 = (FunctionDescriptor) callableDescriptor2;
                            Intrinsics.m26843a((Object) valueParameterDescriptor, "subParameter");
                            boolean z2 = m27147a(functionDescriptor2, valueParameterDescriptor) instanceof Primitive;
                            Intrinsics.m26843a((Object) valueParameterDescriptor2, "superParameter");
                            if (z2 != (m27147a(functionDescriptor, valueParameterDescriptor2) instanceof Primitive)) {
                                return true;
                            }
                        }
                        return false;
                    }
                    throw ((Throwable) new AssertionError("External overridability condition with CONFLICTS_ONLY should not be run with different value parameters size"));
                }
            }
            return false;
        }

        private static JvmType m27147a(FunctionDescriptor functionDescriptor, ValueParameterDescriptor valueParameterDescriptor) {
            if (!MethodSignatureMappingKt.m27354b(functionDescriptor)) {
                Object obj = 1;
                if (functionDescriptor.mo7757k().size() == 1) {
                    DeclarationDescriptor aD_ = functionDescriptor.aD_();
                    if (!(aD_ instanceof ClassDescriptor)) {
                        aD_ = null;
                    }
                    ClassDescriptor classDescriptor = (ClassDescriptor) aD_;
                    if (classDescriptor != null) {
                        functionDescriptor = ((ValueParameterDescriptor) CollectionsKt___CollectionsKt.m41441h((List) functionDescriptor.mo7757k())).mo7777x().mo6743g().mo5724c();
                        if (!(functionDescriptor instanceof ClassDescriptor)) {
                            functionDescriptor = null;
                        }
                        ClassDescriptor classDescriptor2 = (ClassDescriptor) functionDescriptor;
                        if (classDescriptor2 != null) {
                            if (KotlinBuiltIns.m26980b(classDescriptor) && Intrinsics.m26845a(DescriptorUtilsKt.m27742b((DeclarationDescriptor) classDescriptor), DescriptorUtilsKt.m27742b((DeclarationDescriptor) classDescriptor2)) != null) {
                                if (obj != null) {
                                    return MethodSignatureMappingKt.m27352a(valueParameterDescriptor.mo7777x());
                                }
                            }
                        }
                    }
                }
                obj = null;
                if (obj != null) {
                    return MethodSignatureMappingKt.m27352a(valueParameterDescriptor.mo7777x());
                }
            }
            return MethodSignatureMappingKt.m27352a(TypeUtilsKt.m28065b(valueParameterDescriptor.mo7777x()));
        }
    }

    public final Contract mo5760a() {
        return Contract.CONFLICTS_ONLY;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Result mo5761a(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor r9, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor r10, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r11) {
        /*
        r8 = this;
        r0 = "superDescriptor";
        kotlin.jvm.internal.Intrinsics.m26847b(r9, r0);
        r0 = "subDescriptor";
        kotlin.jvm.internal.Intrinsics.m26847b(r10, r0);
        r0 = r9 instanceof kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
        r1 = 1;
        r2 = 0;
        if (r0 == 0) goto L_0x00aa;
    L_0x0010:
        r0 = r10 instanceof kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
        if (r0 == 0) goto L_0x00aa;
    L_0x0014:
        r0 = r10;
        r0 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) r0;
        r0 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.m26973a(r0);
        if (r0 == 0) goto L_0x001f;
    L_0x001d:
        goto L_0x00aa;
    L_0x001f:
        r0 = kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature.f25612a;
        r0 = r10;
        r0 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r0;
        r3 = r0.mo6689i();
        r3 = kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature.m27135a(r3);
        if (r3 != 0) goto L_0x003c;
    L_0x002e:
        r3 = kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithDifferentJvmName.f25594a;
        r3 = r0.mo6689i();
        r3 = kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithDifferentJvmName.m27128a(r3);
        if (r3 != 0) goto L_0x003c;
    L_0x003a:
        goto L_0x00aa;
    L_0x003c:
        r3 = r9;
        r3 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r3;
        r3 = kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers.m27173c(r3);
        r4 = r0.mo7763x();
        r4 = java.lang.Boolean.valueOf(r4);
        r5 = r9 instanceof kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
        r6 = 0;
        if (r5 != 0) goto L_0x0052;
    L_0x0050:
        r7 = r6;
        goto L_0x0053;
    L_0x0052:
        r7 = r9;
    L_0x0053:
        r7 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r7;
        if (r7 == 0) goto L_0x005f;
    L_0x0057:
        r6 = r7.mo7763x();
        r6 = java.lang.Boolean.valueOf(r6);
    L_0x005f:
        r4 = kotlin.jvm.internal.Intrinsics.m26845a(r4, r6);
        r4 = r4 ^ r1;
        if (r4 == 0) goto L_0x0070;
    L_0x0066:
        if (r3 == 0) goto L_0x006e;
    L_0x0068:
        r4 = r0.mo7763x();
        if (r4 != 0) goto L_0x0070;
    L_0x006e:
        r2 = r1;
        goto L_0x00aa;
    L_0x0070:
        r4 = r11 instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
        if (r4 == 0) goto L_0x00aa;
    L_0x0074:
        r4 = r0.mo7762w();
        if (r4 == 0) goto L_0x007b;
    L_0x007a:
        goto L_0x00aa;
    L_0x007b:
        if (r3 == 0) goto L_0x00aa;
    L_0x007d:
        r4 = r3;
        r4 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor) r4;
        r11 = kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers.m27171a(r11, r4);
        if (r11 == 0) goto L_0x0087;
    L_0x0086:
        goto L_0x00aa;
    L_0x0087:
        r11 = r3 instanceof kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
        if (r11 == 0) goto L_0x006e;
    L_0x008b:
        if (r5 == 0) goto L_0x006e;
    L_0x008d:
        r3 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r3;
        r11 = kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature.m27133a(r3);
        if (r11 == 0) goto L_0x006e;
    L_0x0095:
        r11 = kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.m27351a(r0, r2);
        r0 = r9;
        r0 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r0;
        r0 = r0.mo7761v();
        r0 = kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.m27351a(r0, r2);
        r11 = kotlin.jvm.internal.Intrinsics.m26845a(r11, r0);
        if (r11 == 0) goto L_0x006e;
    L_0x00aa:
        if (r2 == 0) goto L_0x00af;
    L_0x00ac:
        r9 = kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Result.INCOMPATIBLE;
        return r9;
    L_0x00af:
        r9 = kotlin.reflect.jvm.internal.impl.load.java.JavaIncompatibilityRulesOverridabilityCondition.Companion.m27148a(r9, r10);
        if (r9 == 0) goto L_0x00b8;
    L_0x00b5:
        r9 = kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Result.INCOMPATIBLE;
        return r9;
    L_0x00b8:
        r9 = kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Result.UNKNOWN;
        return r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.JavaIncompatibilityRulesOverridabilityCondition.a(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor):kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition$Result");
    }
}
