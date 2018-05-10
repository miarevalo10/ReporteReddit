package kotlin.reflect.jvm.internal.impl.platform;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution.Companion;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: mappingUtil.kt */
public final class MappingUtilKt {
    public static final TypeConstructorSubstitution m27447a(ClassDescriptor classDescriptor, ClassDescriptor classDescriptor2) {
        Intrinsics.m26847b(classDescriptor, "from");
        Intrinsics.m26847b(classDescriptor2, "to");
        Object obj = classDescriptor.mo7719s().size() == classDescriptor2.mo7719s().size() ? 1 : null;
        if (_Assertions.f25274a && obj == null) {
            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(classDescriptor);
            stringBuilder2.append(" and ");
            stringBuilder2.append(classDescriptor2);
            stringBuilder2.append(" should have same number of type parameters, ");
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder2 = new StringBuilder("but ");
            stringBuilder2.append(classDescriptor.mo7719s().size());
            stringBuilder2.append(" / ");
            stringBuilder2.append(classDescriptor2.mo7719s().size());
            stringBuilder2.append(" found");
            stringBuilder.append(stringBuilder2.toString());
            throw ((Throwable) new AssertionError(stringBuilder.toString()));
        }
        Companion companion = TypeConstructorSubstitution.f33074b;
        Iterable<TypeParameterDescriptor> s = classDescriptor.mo7719s();
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(s));
        for (TypeParameterDescriptor c : s) {
            arrayList.add(c.mo7610c());
        }
        Iterable iterable = (List) arrayList;
        s = classDescriptor2.mo7719s();
        Collection collection = (Collection) new ArrayList(CollectionsKt__IterablesKt.m32812b(s));
        for (TypeParameterDescriptor c2 : s) {
            collection.add(TypeUtilsKt.m28068e(c2.mo7714h()));
        }
        return Intrinsics.m26847b(MapsKt__MapsKt.m36117a((Iterable) CollectionsKt___CollectionsKt.m41417a(iterable, (Iterable) (List) collection)), "map");
    }
}
