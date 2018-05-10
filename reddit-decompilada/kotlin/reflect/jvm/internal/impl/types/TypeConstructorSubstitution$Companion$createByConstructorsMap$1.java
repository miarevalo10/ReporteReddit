package kotlin.reflect.jvm.internal.impl.types;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TypeSubstitution.kt */
public final class TypeConstructorSubstitution$Companion$createByConstructorsMap$1 extends TypeConstructorSubstitution {
    final /* synthetic */ Map f36175a;
    final /* synthetic */ boolean f36176c = null;

    TypeConstructorSubstitution$Companion$createByConstructorsMap$1(Map map) {
        this.f36175a = map;
    }

    public final TypeProjection mo6737a(TypeConstructor typeConstructor) {
        Intrinsics.m26847b(typeConstructor, "key");
        return (TypeProjection) this.f36175a.get(typeConstructor);
    }

    public final boolean mo5796a() {
        return this.f36175a.isEmpty();
    }

    public final boolean mo5934c() {
        return this.f36176c;
    }
}
