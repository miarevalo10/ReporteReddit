package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: signatureEnhancement.kt */
final class C2973xf7c621fd extends Lambda implements Function1<D, KotlinType> {
    public static final C2973xf7c621fd f38750a = new C2973xf7c621fd();

    C2973xf7c621fd() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) obj;
        Intrinsics.m26847b(callableMemberDescriptor, "it");
        obj = callableMemberDescriptor.mo7755d();
        if (obj == null) {
            Intrinsics.m26842a();
        }
        obj = obj.mo7777x();
        Intrinsics.m26843a(obj, "it.extensionReceiverParameter!!.type");
        return obj;
    }
}
