package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: AbstractTypeConstructor.kt */
final class AbstractTypeConstructor$supertypes$1 extends Lambda implements Function0<Supertypes> {
    final /* synthetic */ AbstractTypeConstructor f38917a;

    AbstractTypeConstructor$supertypes$1(AbstractTypeConstructor abstractTypeConstructor) {
        this.f38917a = abstractTypeConstructor;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return new Supertypes(this.f38917a.mo6684a());
    }
}
