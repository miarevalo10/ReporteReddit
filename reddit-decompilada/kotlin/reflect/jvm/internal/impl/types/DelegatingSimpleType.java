package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* compiled from: SpecialTypes.kt */
public abstract class DelegatingSimpleType extends SimpleType {
    public abstract SimpleType mo7611e();

    public final Annotations mo5718q() {
        return mo7611e().mo5718q();
    }

    public final TypeConstructor mo6743g() {
        return mo7611e().mo6743g();
    }

    public final List<TypeProjection> mo6739a() {
        return mo7611e().mo6739a();
    }

    public boolean mo6741c() {
        return mo7611e().mo6741c();
    }

    public final MemberScope mo6740b() {
        return mo7611e().mo6740b();
    }
}
