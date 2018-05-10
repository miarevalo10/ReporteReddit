package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* compiled from: StarProjectionImpl.kt */
public final class StarProjectionImplKt {
    public static final KotlinType m27956a(TypeParameterDescriptor typeParameterDescriptor) {
        Intrinsics.m26847b(typeParameterDescriptor, "$receiver");
        DeclarationDescriptor aD_ = typeParameterDescriptor.aD_();
        if (aD_ == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassifierDescriptorWithTypeParameters");
        }
        Iterable<TypeParameterDescriptor> b = ((ClassifierDescriptorWithTypeParameters) aD_).mo7610c().mo5723b();
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(b));
        for (TypeParameterDescriptor c : b) {
            arrayList.add(c.mo7610c());
        }
        KotlinType b2 = TypeSubstitutor.m27997a((TypeSubstitution) new StarProjectionImplKt$starProjectionType$1((List) arrayList)).m28005b((KotlinType) CollectionsKt___CollectionsKt.m41430d(typeParameterDescriptor.mo7715j()), Variance.f26339c);
        if (b2 != null) {
            return b2;
        }
        Object o = DescriptorUtilsKt.m27745d(typeParameterDescriptor).m27017o();
        Intrinsics.m26843a(o, "builtIns.defaultBound");
        return (KotlinType) o;
    }
}
