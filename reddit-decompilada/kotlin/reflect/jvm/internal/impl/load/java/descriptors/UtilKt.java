package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmPackagePartSource;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: util.kt */
public final class UtilKt {
    public static final List<ValueParameterDescriptor> m27194a(Collection<? extends KotlinType> collection, Collection<? extends ValueParameterDescriptor> collection2, CallableDescriptor callableDescriptor) {
        Collection<? extends KotlinType> collection3 = collection;
        Collection<? extends ValueParameterDescriptor> collection4 = collection2;
        CallableDescriptor callableDescriptor2 = callableDescriptor;
        Intrinsics.m26847b(collection3, "newValueParametersTypes");
        Intrinsics.m26847b(collection4, "oldValueParameters");
        Intrinsics.m26847b(callableDescriptor2, "newOwner");
        Object obj = collection.size() == collection2.size() ? 1 : null;
        if (_Assertions.f25274a && obj == null) {
            StringBuilder stringBuilder = new StringBuilder("Different value parameters sizes: Enhanced = ");
            stringBuilder.append(collection.size());
            stringBuilder.append(", Old = ");
            stringBuilder.append(collection2.size());
            throw new AssertionError(stringBuilder.toString());
        }
        Iterable<Pair> a = CollectionsKt___CollectionsKt.m41417a((Iterable) collection3, (Iterable) collection4);
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(a));
        for (Pair pair : a) {
            KotlinType kotlinType = (KotlinType) pair.f25267a;
            ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) pair.f25268b;
            int c = valueParameterDescriptor.mo7801c();
            Annotations q = valueParameterDescriptor.mo5718q();
            Object i = valueParameterDescriptor.mo6689i();
            Intrinsics.m26843a(i, "oldParameter.name");
            boolean h = valueParameterDescriptor.mo7802h();
            boolean p = valueParameterDescriptor.mo7805p();
            boolean s = valueParameterDescriptor.mo7806s();
            KotlinType a2 = valueParameterDescriptor.mo7803n() != null ? DescriptorUtilsKt.m27744c((DeclarationDescriptor) callableDescriptor2).mo7089b().m27000a(kotlinType) : null;
            Object r = valueParameterDescriptor.mo7258r();
            Intrinsics.m26843a(r, "oldParameter.source");
            arrayList.add(new ValueParameterDescriptorImpl(callableDescriptor2, valueParameterDescriptor, c, q, i, kotlinType, h, p, s, a2, r));
        }
        return (List) arrayList;
    }

    public static final LazyJavaStaticClassScope m27195a(ClassDescriptor classDescriptor) {
        MemberScope b;
        do {
            Intrinsics.m26847b(classDescriptor, "$receiver");
            classDescriptor = DescriptorUtilsKt.m27741b(classDescriptor);
            if (classDescriptor == null) {
                return null;
            }
            b = classDescriptor.mo7767b();
        } while (!(b instanceof LazyJavaStaticClassScope));
        return (LazyJavaStaticClassScope) b;
    }

    public static final Name m27196a(DeserializedMemberDescriptor deserializedMemberDescriptor) {
        Intrinsics.m26847b(deserializedMemberDescriptor, "$receiver");
        deserializedMemberDescriptor = deserializedMemberDescriptor.mo7815I();
        if (!(deserializedMemberDescriptor instanceof JvmPackagePartSource)) {
            deserializedMemberDescriptor = null;
        }
        JvmPackagePartSource jvmPackagePartSource = (JvmPackagePartSource) deserializedMemberDescriptor;
        return jvmPackagePartSource != null ? jvmPackagePartSource.m36309b() : null;
    }
}
