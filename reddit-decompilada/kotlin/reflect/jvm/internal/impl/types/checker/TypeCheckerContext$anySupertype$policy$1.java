package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckerContext.SupertypesPolicy;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckerContext.SupertypesPolicy.None;

/* compiled from: TypeCheckerContext.kt */
final class TypeCheckerContext$anySupertype$policy$1 extends Lambda implements Function1<SupertypesPolicy, Boolean> {
    public static final TypeCheckerContext$anySupertype$policy$1 f38944a = new TypeCheckerContext$anySupertype$policy$1();

    TypeCheckerContext$anySupertype$policy$1() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        obj = (SupertypesPolicy) obj;
        Intrinsics.m26847b(obj, "it");
        return Boolean.valueOf(Intrinsics.m26845a(obj, None.f33081a) ^ 1);
    }
}
