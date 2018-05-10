package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NotFoundClasses.MockClassDescriptor;

/* compiled from: NotFoundClasses.kt */
final class NotFoundClasses$classes$1 extends Lambda implements Function1<ClassRequest, MockClassDescriptor> {
    final /* synthetic */ NotFoundClasses f38853a;

    NotFoundClasses$classes$1(NotFoundClasses notFoundClasses) {
        this.f38853a = notFoundClasses;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        ClassRequest classRequest = (ClassRequest) obj;
        Intrinsics.m26847b(classRequest, "request");
        return (MockClassDescriptor) NotFoundClasses.m27856a(this.f38853a, classRequest, new Function4<DeclarationDescriptor, Name, Boolean, Integer, MockClassDescriptor>() {
            public final /* synthetic */ Object mo6942a(Object obj, Object obj2, Object obj3, Object obj4) {
                DeclarationDescriptor declarationDescriptor = (DeclarationDescriptor) obj;
                Name name = (Name) obj2;
                boolean booleanValue = ((Boolean) obj3).booleanValue();
                int intValue = ((Number) obj4).intValue();
                Intrinsics.m26847b(declarationDescriptor, "owner");
                Intrinsics.m26847b(name, "name");
                return new MockClassDescriptor(this.f38853a.f26264d, declarationDescriptor, name, booleanValue, intValue);
            }
        });
    }
}
