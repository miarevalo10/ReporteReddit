package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: AbstractTypeConstructor.kt */
final class AbstractTypeConstructor$supertypes$3 extends Lambda implements Function1<Supertypes, Unit> {
    final /* synthetic */ AbstractTypeConstructor f38921a;

    AbstractTypeConstructor$supertypes$3(AbstractTypeConstructor abstractTypeConstructor) {
        this.f38921a = abstractTypeConstructor;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Supertypes supertypes = (Supertypes) obj;
        Intrinsics.m26847b(supertypes, "supertypes");
        Collection a = this.f38921a.aK_().mo5714a(this.f38921a, supertypes.f26311b, new AbstractTypeConstructor$supertypes$3$resultWithoutCycles$1(this), new AbstractTypeConstructor$supertypes$3$resultWithoutCycles$2(this));
        Collection collection = null;
        if (a.isEmpty()) {
            KotlinType f = this.f38921a.mo6687f();
            List a2 = f != null ? CollectionsKt__CollectionsKt.m26791a((Object) f) : null;
            if (a2 == null) {
                a2 = CollectionsKt__CollectionsKt.m26790a();
            }
            a = a2;
        }
        if (a instanceof List) {
            collection = a;
        }
        List list = (List) collection;
        if (list == null) {
            list = CollectionsKt___CollectionsKt.m41449n(a);
        }
        Intrinsics.m26847b(list, "<set-?>");
        supertypes.f26310a = list;
        return Unit.f25273a;
    }
}
