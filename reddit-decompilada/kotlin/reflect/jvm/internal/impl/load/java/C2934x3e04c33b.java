package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;

/* compiled from: specialBuiltinMembers.kt */
final class C2934x3e04c33b extends Lambda implements Function1<CallableMemberDescriptor, Boolean> {
    public static final C2934x3e04c33b f38360a = new C2934x3e04c33b();

    C2934x3e04c33b() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) obj;
        Intrinsics.m26847b(callableMemberDescriptor, "it");
        BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = BuiltinMethodsWithSpecialGenericSignature.f25612a;
        return Boolean.valueOf(CollectionsKt___CollectionsKt.m41420a((Iterable) BuiltinMethodsWithSpecialGenericSignature.f25618g, (Object) MethodSignatureMappingKt.m27348a((CallableDescriptor) callableMemberDescriptor)));
    }
}
