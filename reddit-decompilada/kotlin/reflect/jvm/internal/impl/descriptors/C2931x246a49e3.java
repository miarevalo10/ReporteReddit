package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;

/* compiled from: typeParameterUtils.kt */
final class C2931x246a49e3 extends Lambda implements Function1<DeclarationDescriptor, Sequence<? extends TypeParameterDescriptor>> {
    public static final C2931x246a49e3 f38329a = new C2931x246a49e3();

    C2931x246a49e3() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        DeclarationDescriptor declarationDescriptor = (DeclarationDescriptor) obj;
        Intrinsics.m26847b(declarationDescriptor, "it");
        if (declarationDescriptor != null) {
            return CollectionsKt___CollectionsKt.m41455t(((CallableDescriptor) declarationDescriptor).mo7735f());
        }
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
    }
}
