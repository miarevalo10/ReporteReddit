package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.BooleanRef;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* compiled from: IntersectionType.kt */
public final class IntersectionTypeKt {
    public static final UnwrappedType m28023a(List<? extends UnwrappedType> list) {
        Intrinsics.m26847b(list, "types");
        switch (list.size()) {
            case 0:
                throw new IllegalStateException("Expected some types".toString());
            case 1:
                return (UnwrappedType) CollectionsKt___CollectionsKt.m41441h((List) list);
            default:
                BooleanRef booleanRef = new BooleanRef();
                booleanRef.f25288a = false;
                BooleanRef booleanRef2 = new BooleanRef();
                booleanRef2.f25288a = false;
                Iterable<UnwrappedType> iterable = list;
                Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
                for (UnwrappedType unwrappedType : iterable) {
                    boolean z;
                    Object obj;
                    if (!booleanRef2.f25288a) {
                        if (!unwrappedType.mo6742d()) {
                            z = false;
                            booleanRef2.f25288a = z;
                            if (unwrappedType instanceof SimpleType) {
                                obj = (SimpleType) unwrappedType;
                            } else if (unwrappedType instanceof FlexibleType) {
                                throw new NoWhenBranchMatchedException();
                            } else {
                                booleanRef.f25288a = true;
                                obj = ((FlexibleType) unwrappedType).f38926a;
                            }
                            arrayList.add(obj);
                        }
                    }
                    z = true;
                    booleanRef2.f25288a = z;
                    if (unwrappedType instanceof SimpleType) {
                        obj = (SimpleType) unwrappedType;
                    } else if (unwrappedType instanceof FlexibleType) {
                        throw new NoWhenBranchMatchedException();
                    } else {
                        booleanRef.f25288a = true;
                        obj = ((FlexibleType) unwrappedType).f38926a;
                    }
                    arrayList.add(obj);
                }
                List list2 = (List) arrayList;
                if (booleanRef2.f25288a) {
                    StringBuilder stringBuilder = new StringBuilder("Intersection of error types: ");
                    stringBuilder.append(list);
                    Object c = ErrorUtils.m27943c(stringBuilder.toString());
                    Intrinsics.m26843a(c, "ErrorUtils.createErrorTy… of error types: $types\")");
                    return (UnwrappedType) c;
                } else if (booleanRef.f25288a == null) {
                    return m28024b(list2);
                } else {
                    Collection arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
                    for (UnwrappedType d : iterable) {
                        arrayList2.add(FlexibleTypesKt.m27949d(d));
                    }
                    return KotlinTypeFactory.m27953a(m28024b(list2), m28024b((List) arrayList2));
                }
        }
    }

    private static final SimpleType m28024b(List<? extends SimpleType> list) {
        IntersectionTypeConstructor intersectionTypeConstructor = new IntersectionTypeConstructor(list);
        list = Annotations.f32643a;
        list = Companion.m27115a();
        TypeConstructor typeConstructor = intersectionTypeConstructor;
        List a = CollectionsKt__CollectionsKt.m26790a();
        Object f = intersectionTypeConstructor.m33606f();
        Intrinsics.m26843a(f, "constructor.createScopeForKotlinType()");
        return KotlinTypeFactory.m27952a(list, typeConstructor, a, false, f);
    }
}
