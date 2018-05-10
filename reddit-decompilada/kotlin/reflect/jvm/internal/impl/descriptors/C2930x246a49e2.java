package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: typeParameterUtils.kt */
final class C2930x246a49e2 extends Lambda implements Function1<DeclarationDescriptor, Boolean> {
    public static final C2930x246a49e2 f38328a = new C2930x246a49e2();

    C2930x246a49e2() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        DeclarationDescriptor declarationDescriptor = (DeclarationDescriptor) obj;
        Intrinsics.m26847b(declarationDescriptor, "it");
        return Boolean.valueOf(declarationDescriptor instanceof CallableDescriptor);
    }
}
