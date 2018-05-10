package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils.ErrorScope;

/* compiled from: KotlinTypeFactory.kt */
final class SimpleTypeImpl extends SimpleType {
    private final Annotations f39985a;
    private final TypeConstructor f39986b;
    private final List<TypeProjection> f39987c;
    private final boolean f39988d;
    private final MemberScope f39989e;

    public final boolean mo6742d() {
        return false;
    }

    public final /* synthetic */ UnwrappedType mo7271a(Annotations annotations) {
        return m40513c(annotations);
    }

    public final /* synthetic */ UnwrappedType mo7272a(boolean z) {
        return m40514c(z);
    }

    public final /* synthetic */ SimpleType mo7296b(Annotations annotations) {
        return m40513c(annotations);
    }

    public final /* synthetic */ SimpleType mo7297b(boolean z) {
        return m40514c(z);
    }

    public final Annotations mo5718q() {
        return this.f39985a;
    }

    public final TypeConstructor mo6743g() {
        return this.f39986b;
    }

    public final List<TypeProjection> mo6739a() {
        return this.f39987c;
    }

    public final boolean mo6741c() {
        return this.f39988d;
    }

    public final MemberScope mo6740b() {
        return this.f39989e;
    }

    public SimpleTypeImpl(Annotations annotations, TypeConstructor typeConstructor, List<? extends TypeProjection> list, boolean z, MemberScope memberScope) {
        Intrinsics.m26847b(annotations, "annotations");
        Intrinsics.m26847b(typeConstructor, "constructor");
        Intrinsics.m26847b(list, "arguments");
        Intrinsics.m26847b(memberScope, "memberScope");
        this.f39985a = annotations;
        this.f39986b = typeConstructor;
        this.f39987c = list;
        this.f39988d = z;
        this.f39989e = memberScope;
        if ((this.f39989e instanceof ErrorScope) != null) {
            typeConstructor = new StringBuilder("SimpleTypeImpl should not be created for error type: ");
            typeConstructor.append(this.f39989e);
            typeConstructor.append("\n");
            typeConstructor.append(this.f39986b);
            throw ((Throwable) new IllegalStateException(typeConstructor.toString()));
        }
    }

    private SimpleTypeImpl m40513c(Annotations annotations) {
        Intrinsics.m26847b(annotations, "newAnnotations");
        return new SimpleTypeImpl(annotations, this.f39986b, this.f39987c, this.f39988d, this.f39989e);
    }

    private SimpleTypeImpl m40514c(boolean z) {
        return new SimpleTypeImpl(this.f39985a, this.f39986b, this.f39987c, z, this.f39989e);
    }
}
