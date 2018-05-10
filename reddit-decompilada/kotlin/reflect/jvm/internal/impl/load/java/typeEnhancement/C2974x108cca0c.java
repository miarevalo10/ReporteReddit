package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: signatureEnhancement.kt */
final class C2974x108cca0c extends Lambda implements Function1<D, KotlinType> {
    final /* synthetic */ ValueParameterDescriptor f38752a;

    C2974x108cca0c(ValueParameterDescriptor valueParameterDescriptor) {
        this.f38752a = valueParameterDescriptor;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) obj;
        Intrinsics.m26847b(callableMemberDescriptor, "it");
        obj = ((ValueParameterDescriptor) callableMemberDescriptor.mo7757k().get(this.f38752a.mo7801c())).mo7777x();
        Intrinsics.m26843a(obj, "it.valueParameters[p.index].type");
        return obj;
    }
}
