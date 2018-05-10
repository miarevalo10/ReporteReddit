package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.StrictEqualityTypeChecker;

/* compiled from: KotlinType.kt */
public abstract class KotlinType implements Annotated {
    public abstract List<TypeProjection> mo6739a();

    public abstract MemberScope mo6740b();

    public abstract boolean mo6741c();

    public abstract boolean mo6742d();

    public abstract TypeConstructor mo6743g();

    public abstract UnwrappedType mo6738h();

    private KotlinType() {
    }

    public final int hashCode() {
        if (mo6742d()) {
            return super.hashCode();
        }
        return (31 * ((mo6743g().hashCode() * 31) + mo6739a().hashCode())) + mo6741c();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KotlinType)) {
            return false;
        }
        KotlinType kotlinType = (KotlinType) obj;
        if (mo6741c() != kotlinType.mo6741c() || StrictEqualityTypeChecker.f26352a.m28035a(mo6738h(), kotlinType.mo6738h()) == null) {
            return false;
        }
        return true;
    }
}
