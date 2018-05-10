package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: AbstractTypeConstructor.kt */
final class AbstractTypeConstructor$supertypes$3$resultWithoutCycles$1 extends Lambda implements Function1<TypeConstructor, Collection<? extends KotlinType>> {
    final /* synthetic */ AbstractTypeConstructor$supertypes$3 f38919a;

    AbstractTypeConstructor$supertypes$3$resultWithoutCycles$1(AbstractTypeConstructor$supertypes$3 abstractTypeConstructor$supertypes$3) {
        this.f38919a = abstractTypeConstructor$supertypes$3;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        TypeConstructor typeConstructor = (TypeConstructor) obj;
        Intrinsics.m26847b(typeConstructor, "it");
        return AbstractTypeConstructor.m33572a(typeConstructor);
    }
}
