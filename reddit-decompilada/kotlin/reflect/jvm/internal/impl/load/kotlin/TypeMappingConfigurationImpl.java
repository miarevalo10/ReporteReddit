package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration.DefaultImpls;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: methodSignatureMapping.kt */
public final class TypeMappingConfigurationImpl implements TypeMappingConfiguration<JvmType> {
    public static final TypeMappingConfigurationImpl f32826b = null;

    public final void mo5840a(KotlinType kotlinType, ClassDescriptor classDescriptor) {
        Intrinsics.m26847b(kotlinType, "kotlinType");
        Intrinsics.m26847b(classDescriptor, "descriptor");
    }

    public final String mo5841b(ClassDescriptor classDescriptor) {
        Intrinsics.m26847b(classDescriptor, "classDescriptor");
        return null;
    }

    static {
        TypeMappingConfigurationImpl typeMappingConfigurationImpl = new TypeMappingConfigurationImpl();
    }

    private TypeMappingConfigurationImpl() {
        f32826b = this;
    }

    public final /* synthetic */ Object mo5837a(ClassDescriptor classDescriptor) {
        Intrinsics.m26847b(classDescriptor, "classDescriptor");
        return null;
    }

    public final Function2<String, String, String> mo5838a() {
        return DefaultImpls.m27369a();
    }

    public final KotlinType mo5839a(Collection<? extends KotlinType> collection) {
        Intrinsics.m26847b(collection, "types");
        StringBuilder stringBuilder = new StringBuilder("There should be no intersection type in existing descriptors, but found: ");
        stringBuilder.append(CollectionsKt___CollectionsKt.m41412a((Iterable) collection, null, null, null, 0, null, null, 63));
        throw new AssertionError(stringBuilder.toString());
    }
}
