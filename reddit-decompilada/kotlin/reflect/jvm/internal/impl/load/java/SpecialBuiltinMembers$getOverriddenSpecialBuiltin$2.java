package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;

/* compiled from: specialBuiltinMembers.kt */
final class SpecialBuiltinMembers$getOverriddenSpecialBuiltin$2 extends Lambda implements Function1<CallableMemberDescriptor, Boolean> {
    public static final SpecialBuiltinMembers$getOverriddenSpecialBuiltin$2 f38365a = new SpecialBuiltinMembers$getOverriddenSpecialBuiltin$2();

    SpecialBuiltinMembers$getOverriddenSpecialBuiltin$2() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) obj;
        Intrinsics.m26847b(callableMemberDescriptor, "it");
        obj = (!KotlinBuiltIns.m26973a((DeclarationDescriptor) callableMemberDescriptor) || BuiltinMethodsWithSpecialGenericSignature.m27134a(callableMemberDescriptor) == null) ? null : true;
        return Boolean.valueOf(obj);
    }
}
