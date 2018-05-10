package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;

/* compiled from: RawType.kt */
final class RawTypeImpl$render$2 extends Lambda implements Function1<KotlinType, List<? extends String>> {
    final /* synthetic */ DescriptorRenderer f38451a;

    RawTypeImpl$render$2(DescriptorRenderer descriptorRenderer) {
        this.f38451a = descriptorRenderer;
        super(1);
    }

    public final List<String> m38417a(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "type");
        Iterable<TypeProjection> a = kotlinType.mo6739a();
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(a));
        for (TypeProjection a2 : a) {
            arrayList.add(this.f38451a.mo5895a(a2));
        }
        return (List) arrayList;
    }
}
