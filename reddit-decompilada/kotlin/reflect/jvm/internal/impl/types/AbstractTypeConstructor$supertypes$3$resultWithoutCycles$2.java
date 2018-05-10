package kotlin.reflect.jvm.internal.impl.types;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: AbstractTypeConstructor.kt */
final class AbstractTypeConstructor$supertypes$3$resultWithoutCycles$2 extends Lambda implements Function1<KotlinType, Unit> {
    final /* synthetic */ AbstractTypeConstructor$supertypes$3 f38920a;

    AbstractTypeConstructor$supertypes$3$resultWithoutCycles$2(AbstractTypeConstructor$supertypes$3 abstractTypeConstructor$supertypes$3) {
        this.f38920a = abstractTypeConstructor$supertypes$3;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        KotlinType kotlinType = (KotlinType) obj;
        Intrinsics.m26847b(kotlinType, "it");
        this.f38920a.f38921a.mo6685a(kotlinType);
        return Unit.f25273a;
    }
}
