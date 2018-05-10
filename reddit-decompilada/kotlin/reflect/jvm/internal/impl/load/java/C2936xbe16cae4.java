package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* compiled from: specialBuiltinMembers.kt */
final class C2936xbe16cae4 extends Lambda implements Function1<CallableMemberDescriptor, Boolean> {
    public static final C2936xbe16cae4 f38362a = new C2936xbe16cae4();

    C2936xbe16cae4() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) obj;
        Intrinsics.m26847b(callableMemberDescriptor, "it");
        BuiltinSpecialProperties builtinSpecialProperties = BuiltinSpecialProperties.f25619a;
        return Boolean.valueOf(BuiltinSpecialProperties.m27139a(callableMemberDescriptor));
    }
}
