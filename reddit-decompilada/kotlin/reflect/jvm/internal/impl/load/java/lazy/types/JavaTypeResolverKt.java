package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImplKt;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: JavaTypeResolver.kt */
public final class JavaTypeResolverKt {
    private static final FqName f25722a = new FqName("java.lang.Class");

    public static final TypeProjection m27231a(TypeParameterDescriptor typeParameterDescriptor, JavaTypeAttributes javaTypeAttributes) {
        Intrinsics.m26847b(typeParameterDescriptor, "typeParameter");
        Intrinsics.m26847b(javaTypeAttributes, "attr");
        if (Intrinsics.m26845a(javaTypeAttributes.mo5786a(), TypeUsage.SUPERTYPE) != null) {
            return (TypeProjection) new TypeProjectionImpl(StarProjectionImplKt.m27956a(typeParameterDescriptor));
        }
        return (TypeProjection) new StarProjectionImpl(typeParameterDescriptor);
    }

    public static final boolean m27232a(Annotations annotations) {
        Intrinsics.m26847b(annotations, "$receiver");
        Object obj = JvmAnnotationNames.f25633d;
        Intrinsics.m26843a(obj, "JETBRAINS_NOT_NULL_ANNOTATION");
        return annotations.mo6679a(obj) != null ? true : null;
    }

    public static /* synthetic */ JavaTypeAttributes m27226a(TypeUsage typeUsage, boolean z, boolean z2, TypeParameterDescriptor typeParameterDescriptor, int i) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            typeParameterDescriptor = null;
        }
        Intrinsics.m26847b(typeUsage, "$receiver");
        return (JavaTypeAttributes) new JavaTypeResolverKt$toAttributes$1(typeUsage, z, z2, typeParameterDescriptor);
    }

    public static final JavaTypeAttributes m27227a(JavaTypeAttributes javaTypeAttributes, boolean z, boolean z2, boolean z3) {
        Intrinsics.m26847b(javaTypeAttributes, "$receiver");
        return new JavaTypeResolverKt$computeAttributes$1(javaTypeAttributes, z, z3, z2);
    }

    public static final KotlinType m27230a(TypeParameterDescriptor typeParameterDescriptor, TypeParameterDescriptor typeParameterDescriptor2, Function0<? extends KotlinType> function0) {
        Intrinsics.m26847b(typeParameterDescriptor, "$receiver");
        Intrinsics.m26847b(function0, "defaultValue");
        if (typeParameterDescriptor == typeParameterDescriptor2) {
            return (KotlinType) function0.invoke();
        }
        KotlinType kotlinType = (KotlinType) CollectionsKt___CollectionsKt.m41430d(typeParameterDescriptor.mo7715j());
        if (kotlinType.mo6743g().mo5724c() instanceof ClassDescriptor) {
            return TypeUtilsKt.m28069f(kotlinType);
        }
        if (typeParameterDescriptor2 != null) {
            Object obj = typeParameterDescriptor2;
        }
        typeParameterDescriptor2 = kotlinType.mo6743g().mo5724c();
        if (typeParameterDescriptor2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
        }
        Object obj2 = typeParameterDescriptor2;
        while ((Intrinsics.m26845a(obj2, obj) ^ 1) != 0) {
            KotlinType kotlinType2 = (KotlinType) CollectionsKt___CollectionsKt.m41430d((List) obj2.mo7715j());
            if (kotlinType2.mo6743g().mo5724c() instanceof ClassDescriptor) {
                return TypeUtilsKt.m28069f(kotlinType2);
            }
            typeParameterDescriptor2 = kotlinType2.mo6743g().mo5724c();
            if (typeParameterDescriptor2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
            }
            typeParameterDescriptor2 = typeParameterDescriptor2;
        }
        return (KotlinType) function0.invoke();
    }
}
