package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution.Companion;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckerContext.SupertypesPolicy;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckerContext.SupertypesPolicy.LowerIfFlexible;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckerContext.SupertypesPolicy.LowerIfFlexibleWithCustomSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckerContext.SupertypesPolicy.None;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;

/* compiled from: NewKotlinTypeChecker.kt */
final class C3002xfde4a0b6 extends Lambda implements Function1<SimpleType, SupertypesPolicy> {
    final /* synthetic */ TypeConstructor f38931a;
    final /* synthetic */ ObjectRef f38932b;

    C3002xfde4a0b6(TypeConstructor typeConstructor, ObjectRef objectRef) {
        this.f38931a = typeConstructor;
        this.f38932b = objectRef;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        SimpleType simpleType = (SimpleType) obj;
        Intrinsics.m26847b(simpleType, "it");
        obj = NewCapturedTypeKt.m28028a(simpleType, CaptureStatus.f26346a);
        if (Intrinsics.m26845a(obj.mo6743g(), this.f38931a)) {
            if (((List) this.f38932b.f25291a) == null) {
                this.f38932b.f25291a = new SmartList();
            }
            List list = (List) this.f38932b.f25291a;
            if (list == null) {
                Intrinsics.m26842a();
            }
            list.add(obj);
            return (SupertypesPolicy) None.f33081a;
        } else if (obj.mo6739a().isEmpty()) {
            return (SupertypesPolicy) LowerIfFlexible.f33079a;
        } else {
            Companion companion = TypeConstructorSubstitution.f33074b;
            return new LowerIfFlexibleWithCustomSubstitutor(Companion.m27970a((KotlinType) obj).m27987d());
        }
    }
}
