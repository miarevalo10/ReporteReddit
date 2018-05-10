package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.FilteredAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes.DefaultImpls;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: JavaTypeResolver.kt */
public final class LazyJavaTypeAttributes implements JavaTypeAttributes {
    private final FilteredAnnotations f32748a;
    private final TypeUsage f32749b;
    private final boolean f32750c;
    private final boolean f32751d;

    public final TypeParameterDescriptor mo5793h() {
        return null;
    }

    public LazyJavaTypeAttributes(TypeUsage typeUsage, Annotations annotations, boolean z, boolean z2) {
        Intrinsics.m26847b(typeUsage, "howThisTypeIsUsed");
        Intrinsics.m26847b(annotations, "annotations");
        this.f32749b = typeUsage;
        this.f32750c = z;
        this.f32751d = z2;
        this.f32748a = new FilteredAnnotations(annotations, (Function1) LazyJavaTypeAttributes$typeAnnotations$1.f38447a);
    }

    public final JavaTypeFlexibility mo5789d() {
        return DefaultImpls.m27209a();
    }

    public final RawBound mo5794i() {
        return DefaultImpls.m27210b();
    }

    public final TypeUsage mo5786a() {
        return this.f32749b;
    }

    public final boolean mo5790e() {
        return this.f32750c;
    }

    public /* synthetic */ LazyJavaTypeAttributes(TypeUsage typeUsage, Annotations annotations, boolean z, int i) {
        if ((i & 4) != 0) {
            z = true;
        }
        this(typeUsage, annotations, z, (boolean) 0);
    }

    public final boolean mo5792g() {
        return this.f32751d;
    }

    public final TypeUsage mo5787b() {
        Object obj = JvmAnnotationNames.f25636g;
        Intrinsics.m26843a(obj, "JETBRAINS_READONLY_ANNOTATION");
        if (m33080a(obj)) {
            obj = JvmAnnotationNames.f25635f;
            Intrinsics.m26843a(obj, "JETBRAINS_MUTABLE_ANNOTATION");
            if (!m33080a(obj)) {
                return TypeUsage.MEMBER_SIGNATURE_CONTRAVARIANT;
            }
        }
        return TypeUsage.MEMBER_SIGNATURE_COVARIANT;
    }

    public final /* bridge */ /* synthetic */ Annotations mo5791f() {
        return this.f32748a;
    }

    public final boolean mo5788c() {
        return JavaTypeResolverKt.m27232a((Annotations) this.f32748a);
    }

    private final boolean m33080a(FqName fqName) {
        return this.f32748a.mo6679a(fqName) != null ? true : null;
    }
}
