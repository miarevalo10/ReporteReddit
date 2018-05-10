package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Map;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;

/* compiled from: specialBuiltinMembers.kt */
final class C2933x6ce919c0 extends Lambda implements Function1<CallableMemberDescriptor, Boolean> {
    final /* synthetic */ SimpleFunctionDescriptor f38359a;

    C2933x6ce919c0(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        this.f38359a = simpleFunctionDescriptor;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Intrinsics.m26847b((CallableMemberDescriptor) obj, "it");
        obj = BuiltinMethodsWithDifferentJvmName.f25594a;
        obj = BuiltinMethodsWithDifferentJvmName.f25597d;
        String a = MethodSignatureMappingKt.m27348a((CallableDescriptor) this.f38359a);
        if (obj != null) {
            return Boolean.valueOf(((Map) obj).containsKey(a));
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    }
}
