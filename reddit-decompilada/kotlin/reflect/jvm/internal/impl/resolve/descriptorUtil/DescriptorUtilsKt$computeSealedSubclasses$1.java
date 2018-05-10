package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import java.util.LinkedHashSet;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope.DefaultImpls;

/* compiled from: DescriptorUtils.kt */
final class DescriptorUtilsKt$computeSealedSubclasses$1 extends Lambda implements Function2<MemberScope, Boolean, Unit> {
    final /* synthetic */ ClassDescriptor f38807a;
    final /* synthetic */ LinkedHashSet f38808b;

    DescriptorUtilsKt$computeSealedSubclasses$1(ClassDescriptor classDescriptor, LinkedHashSet linkedHashSet) {
        this.f38807a = classDescriptor;
        this.f38808b = linkedHashSet;
        super(2);
    }

    public final /* synthetic */ Object mo6497a(Object obj, Object obj2) {
        m38570a((MemberScope) obj, ((Boolean) obj2).booleanValue());
        return Unit.f25273a;
    }

    public final void m38570a(MemberScope memberScope, boolean z) {
        Intrinsics.m26847b(memberScope, "scope");
        for (DeclarationDescriptor declarationDescriptor : DefaultImpls.m27789a(memberScope, DescriptorKindFilter.f26118h, null, 2)) {
            if (declarationDescriptor instanceof ClassDescriptor) {
                ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
                if (DescriptorUtils.m27643a(classDescriptor, this.f38807a)) {
                    this.f38808b.add(declarationDescriptor);
                }
                if (z) {
                    DescriptorUtilsKt$computeSealedSubclasses$1 descriptorUtilsKt$computeSealedSubclasses$1 = this;
                    MemberScope t = classDescriptor.mo7739t();
                    Intrinsics.m26843a((Object) t, "descriptor.unsubstitutedInnerClassesScope");
                    m38570a(t, z);
                }
            }
        }
    }
}
