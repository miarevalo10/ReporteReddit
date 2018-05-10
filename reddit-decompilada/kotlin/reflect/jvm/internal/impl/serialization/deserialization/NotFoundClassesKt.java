package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;

/* compiled from: NotFoundClasses.kt */
public final class NotFoundClassesKt {
    public static final /* synthetic */ List m27861a(ClassifierDescriptor classifierDescriptor, int i) {
        Iterable intRange = new IntRange(1, i);
        Collection collection = (Collection) new ArrayList(CollectionsKt__IterablesKt.m32812b(intRange));
        Iterator it = intRange.iterator();
        while (it.hasNext()) {
            int a = ((IntIterator) it).mo6663a();
            DeclarationDescriptor declarationDescriptor = classifierDescriptor;
            Companion companion = Annotations.f32643a;
            Annotations a2 = Companion.m27115a();
            Variance variance = Variance.f26337a;
            StringBuilder stringBuilder = new StringBuilder("T");
            stringBuilder.append(a);
            collection.add(TypeParameterDescriptorImpl.m42660a(declarationDescriptor, a2, variance, Name.m27424a(stringBuilder.toString()), a));
        }
        return (List) collection;
    }

    public static final /* synthetic */ List m27862a(ClassId classId, Type type, TypeTable typeTable) {
        type = SequencesKt___SequencesKt.m33715e(SequencesKt___SequencesKt.m33716e(SequencesKt__SequencesKt.m28142a(type, new C2991x8eab408c(typeTable)), (Function1) C2992x8eab408d.f38859a));
        TypeTable f = SequencesKt___SequencesKt.m33717f(SequencesKt__SequencesKt.m28142a(classId, (Function1) NotFoundClassesKt$computeTypeParametersCount$classNestingLevel$1.f38857a));
        while (type.size() < f) {
            type.add(Integer.valueOf(null));
        }
        return type;
    }
}
