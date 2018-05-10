package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationsImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationsKt;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeHolder;
import kotlin.reflect.jvm.internal.impl.types.TypeHolderArgument;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.VarianceCheckerKt;

/* compiled from: UnsafeVarianceTypeSubstitution.kt */
public final class UnsafeVarianceTypeSubstitution extends TypeSubstitution {
    private final AnnotationsImpl f32832a;

    /* compiled from: UnsafeVarianceTypeSubstitution.kt */
    private static final class IndexedTypeHolder implements TypeHolder<IndexedTypeHolder> {
        final KotlinType f32830a;
        final List<Integer> f32831b;

        public IndexedTypeHolder(KotlinType kotlinType, List<Integer> list) {
            Intrinsics.m26847b(kotlinType, "type");
            Intrinsics.m26847b(list, "argumentIndices");
            this.f32830a = kotlinType;
            this.f32831b = list;
        }

        public final KotlinType mo5847c() {
            return this.f32830a;
        }

        public final Pair<IndexedTypeHolder, IndexedTypeHolder> mo5845a() {
            return FlexibleTypesKt.m27946a(this.f32830a) ? new Pair(new IndexedTypeHolder(FlexibleTypesKt.m27948c(this.f32830a), CollectionsKt___CollectionsKt.m41419a((Collection) this.f32831b, (Object) Integer.valueOf(0))), new IndexedTypeHolder(FlexibleTypesKt.m27949d(this.f32830a), CollectionsKt___CollectionsKt.m41419a((Collection) this.f32831b, (Object) Integer.valueOf(1)))) : null;
        }

        public final List<TypeHolderArgument<IndexedTypeHolder>> mo5846b() {
            Iterable<IndexedValue> q = CollectionsKt___CollectionsKt.m41452q(this.f32830a.mo6739a());
            Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(q));
            for (IndexedValue indexedValue : q) {
                arrayList.add(new C2575x6cfaae88((TypeProjection) indexedValue.f25278b, indexedValue.f25277a, this));
            }
            return (List) arrayList;
        }
    }

    public UnsafeVarianceTypeSubstitution(KotlinBuiltIns kotlinBuiltIns) {
        Intrinsics.m26847b(kotlinBuiltIns, "kotlinBuiltIns");
        this.f32832a = new AnnotationsImpl(CollectionsKt__CollectionsKt.m26791a((Object) AnnotationUtilKt.m27109a(kotlinBuiltIns)));
    }

    public final /* synthetic */ TypeProjection mo5795a(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "key");
        return null;
    }

    public final KotlinType mo5848a(KotlinType kotlinType, Variance variance) {
        Intrinsics.m26847b(kotlinType, "topLevelType");
        Intrinsics.m26847b(variance, "position");
        List arrayList = new ArrayList();
        VarianceCheckerKt.m28022a(new IndexedTypeHolder(kotlinType), variance, new UnsafeVarianceTypeSubstitution$prepareTopLevelType$1(arrayList), UnsafeVarianceTypeSubstitution$prepareTopLevelType$2.f38783a);
        return m33232a(kotlinType.mo6738h(), (Collection) arrayList);
    }

    private final UnwrappedType m33232a(UnwrappedType unwrappedType, Collection<? extends List<Integer>> collection) {
        if (collection.isEmpty()) {
            return unwrappedType;
        }
        if (unwrappedType instanceof FlexibleType) {
            FlexibleType flexibleType = (FlexibleType) unwrappedType;
            return KotlinTypeFactory.m27953a(m33231a(flexibleType.f38926a, (Collection) m33230a((Collection) collection, 0)), m33231a(flexibleType.f38927b, (Collection) m33230a((Collection) collection, 1)));
        } else if (unwrappedType instanceof SimpleType) {
            return m33231a((SimpleType) unwrappedType, (Collection) collection);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final SimpleType m33231a(SimpleType simpleType, Collection<? extends List<Integer>> collection) {
        if (collection.isEmpty()) {
            return simpleType;
        }
        if (collection.contains(CollectionsKt__CollectionsKt.m26790a())) {
            return simpleType.mo7296b(AnnotationsKt.m27117a(simpleType.mo5718q(), (Annotations) this.f32832a));
        }
        Iterable<IndexedValue> q = CollectionsKt___CollectionsKt.m41452q(simpleType.mo6739a());
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(q));
        for (IndexedValue indexedValue : q) {
            int i = indexedValue.f25277a;
            Object obj = (TypeProjection) indexedValue.f25278b;
            if (!obj.mo6734a()) {
                obj = new TypeProjectionImpl(obj.mo6735b(), m33232a(obj.mo6736c().mo6738h(), (Collection) m33230a((Collection) collection, i)));
            }
            arrayList.add(obj);
        }
        return TypeSubstitutionKt.m27992a(simpleType, (List) arrayList, simpleType.mo5718q());
    }

    private static List<List<Integer>> m33230a(Collection<? extends List<Integer>> collection, int i) {
        Collection arrayList = new ArrayList();
        collection = collection.iterator();
        while (true) {
            int i2 = 1;
            if (!collection.hasNext()) {
                break;
            }
            Object next = collection.next();
            if (((Number) ((List) next).get(0)).intValue() != i) {
                i2 = 0;
            }
            if (i2 != 0) {
                arrayList.add(next);
            }
        }
        Iterable<List> iterable = (List) arrayList;
        collection = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (List list : iterable) {
            collection.add(list.subList(1, list.size()));
        }
        return (List) collection;
    }
}
