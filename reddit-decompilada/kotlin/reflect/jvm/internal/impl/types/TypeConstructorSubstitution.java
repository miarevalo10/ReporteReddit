package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* compiled from: TypeSubstitution.kt */
public abstract class TypeConstructorSubstitution extends TypeSubstitution {
    public static final Companion f33074b = new Companion();

    /* compiled from: TypeSubstitution.kt */
    public static final class Companion {
        private Companion() {
        }

        public static TypeSubstitution m27970a(KotlinType kotlinType) {
            Intrinsics.m26847b(kotlinType, "kotlinType");
            return m27971a(kotlinType.mo6743g(), kotlinType.mo6739a());
        }

        public static TypeSubstitution m27971a(TypeConstructor typeConstructor, List<? extends TypeProjection> list) {
            Intrinsics.m26847b(typeConstructor, "typeConstructor");
            Intrinsics.m26847b(list, "arguments");
            List b = typeConstructor.mo5723b();
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) CollectionsKt___CollectionsKt.m41439g(b);
            if (typeParameterDescriptor != null ? typeParameterDescriptor.mo7711b() : false) {
                Iterable<TypeParameterDescriptor> b2 = typeConstructor.mo5723b();
                Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(b2));
                for (TypeParameterDescriptor typeParameterDescriptor2 : b2) {
                    arrayList.add(typeParameterDescriptor2.mo7610c());
                }
                return Intrinsics.m26847b(MapsKt__MapsKt.m36117a((Iterable) CollectionsKt___CollectionsKt.m41417a((Iterable) (List) arrayList, (Iterable) list)), "map");
            }
            Intrinsics.m26843a((Object) b, "parameters");
            return (TypeSubstitution) new IndexedParametersSubstitution(b, (List) list);
        }
    }

    public static final TypeConstructorSubstitution m33613a(Map<TypeConstructor, ? extends TypeProjection> map) {
        return Intrinsics.m26847b(map, "map");
    }

    public static final TypeSubstitution m33614a(TypeConstructor typeConstructor, List<? extends TypeProjection> list) {
        Intrinsics.m26847b(typeConstructor, "typeConstructor");
        Intrinsics.m26847b(list, "arguments");
        return Companion.m27971a(typeConstructor, list);
    }

    public abstract TypeProjection mo6737a(TypeConstructor typeConstructor);

    public final TypeProjection mo5795a(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "key");
        return mo6737a(kotlinType.mo6743g());
    }
}
