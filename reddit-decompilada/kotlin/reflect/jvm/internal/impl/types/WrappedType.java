package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.TypeCastException;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* compiled from: KotlinType.kt */
public abstract class WrappedType extends KotlinType {
    protected abstract KotlinType mo7117e();

    public boolean mo7118f() {
        return true;
    }

    public WrappedType() {
        super();
    }

    public final Annotations mo5718q() {
        return mo7117e().mo5718q();
    }

    public final TypeConstructor mo6743g() {
        return mo7117e().mo6743g();
    }

    public final List<TypeProjection> mo6739a() {
        return mo7117e().mo6739a();
    }

    public final boolean mo6741c() {
        return mo7117e().mo6741c();
    }

    public final MemberScope mo6740b() {
        return mo7117e().mo6740b();
    }

    public final boolean mo6742d() {
        return mo7117e().mo6742d();
    }

    public final UnwrappedType mo6738h() {
        KotlinType e = mo7117e();
        while (e instanceof WrappedType) {
            e = ((WrappedType) e).mo7117e();
        }
        if (e != null) {
            return (UnwrappedType) e;
        }
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.types.UnwrappedType");
    }

    public String toString() {
        return mo7118f() ? mo7117e().toString() : "<Not computed yet>";
    }
}
