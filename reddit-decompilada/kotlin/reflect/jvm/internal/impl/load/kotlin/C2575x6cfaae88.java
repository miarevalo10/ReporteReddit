package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeHolder;
import kotlin.reflect.jvm.internal.impl.types.TypeHolderArgument;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;

/* compiled from: UnsafeVarianceTypeSubstitution.kt */
public final class C2575x6cfaae88 implements TypeHolderArgument<IndexedTypeHolder> {
    final /* synthetic */ TypeProjection f32827a;
    final /* synthetic */ int f32828b;
    final /* synthetic */ IndexedTypeHolder f32829c;

    C2575x6cfaae88(TypeProjection typeProjection, int i, IndexedTypeHolder indexedTypeHolder) {
        this.f32827a = typeProjection;
        this.f32828b = i;
        this.f32829c = indexedTypeHolder;
    }

    public final TypeProjection mo5842a() {
        return this.f32827a;
    }

    public final TypeParameterDescriptor mo5843b() {
        return (TypeParameterDescriptor) this.f32829c.f32830a.mo6743g().mo5723b().get(this.f32828b);
    }

    public final /* synthetic */ TypeHolder mo5844c() {
        Object c = this.f32827a.mo6736c();
        Intrinsics.m26843a(c, "projection.type");
        return new IndexedTypeHolder(c, CollectionsKt___CollectionsKt.m41419a((Collection) this.f32829c.f32831b, (Object) Integer.valueOf(this.f32828b)));
    }
}
