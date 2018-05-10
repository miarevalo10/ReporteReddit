package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;

/* compiled from: NotFoundClasses.kt */
final class C2988x6e310cf6 extends Lambda implements Function0<List<? extends TypeParameterDescriptor>> {
    final /* synthetic */ MockTypeAliasDescriptor f38851a;

    C2988x6e310cf6(MockTypeAliasDescriptor mockTypeAliasDescriptor) {
        this.f38851a = mockTypeAliasDescriptor;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return TypeParameterUtilsKt.m27089a(this.f38851a);
    }
}
