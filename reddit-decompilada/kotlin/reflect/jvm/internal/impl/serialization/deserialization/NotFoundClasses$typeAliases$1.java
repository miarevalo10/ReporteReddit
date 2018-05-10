package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: NotFoundClasses.kt */
final class NotFoundClasses$typeAliases$1 extends Lambda implements Function1<ClassRequest, MockTypeAliasDescriptor> {
    final /* synthetic */ NotFoundClasses f38856a;

    NotFoundClasses$typeAliases$1(NotFoundClasses notFoundClasses) {
        this.f38856a = notFoundClasses;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        ClassRequest classRequest = (ClassRequest) obj;
        Intrinsics.m26847b(classRequest, "request");
        return (MockTypeAliasDescriptor) NotFoundClasses.m27856a(this.f38856a, classRequest, new Function4<DeclarationDescriptor, Name, Boolean, Integer, MockTypeAliasDescriptor>() {
            public final /* synthetic */ Object mo6942a(Object obj, Object obj2, Object obj3, Object obj4) {
                DeclarationDescriptor declarationDescriptor = (DeclarationDescriptor) obj;
                Name name = (Name) obj2;
                boolean booleanValue = ((Boolean) obj3).booleanValue();
                int intValue = ((Number) obj4).intValue();
                Intrinsics.m26847b(declarationDescriptor, "owner");
                Intrinsics.m26847b(name, "name");
                return new MockTypeAliasDescriptor(this.f38856a.f26264d, declarationDescriptor, name, booleanValue, intValue);
            }
        });
    }
}
