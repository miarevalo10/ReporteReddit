package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.platform.JavaToKotlinClassMap;

/* compiled from: JvmBuiltInsSettings.kt */
final class JvmBuiltInsSettings$isMutabilityViolation$2 extends Lambda implements Function1<CallableMemberDescriptor, Boolean> {
    final /* synthetic */ JvmBuiltInsSettings f38778a;

    JvmBuiltInsSettings$isMutabilityViolation$2(JvmBuiltInsSettings jvmBuiltInsSettings) {
        this.f38778a = jvmBuiltInsSettings;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) obj;
        if (Intrinsics.m26845a(callableMemberDescriptor.mo7760t(), Kind.DECLARATION)) {
            JavaToKotlinClassMap b = this.f38778a.f32802c;
            obj = callableMemberDescriptor.aD_();
            if (obj == null) {
                throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            } else if (b.m27444a((ClassDescriptor) obj) != null) {
                obj = true;
                return Boolean.valueOf(obj);
            }
        }
        obj = null;
        return Boolean.valueOf(obj);
    }
}
