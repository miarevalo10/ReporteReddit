package kotlin.reflect.jvm.internal.impl.util;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.util.MemberKindCheck.Member;
import kotlin.reflect.jvm.internal.impl.util.MemberKindCheck.MemberOrExtension;
import kotlin.reflect.jvm.internal.impl.util.ReturnsCheck.ReturnsBoolean;
import kotlin.reflect.jvm.internal.impl.util.ReturnsCheck.ReturnsInt;
import kotlin.reflect.jvm.internal.impl.util.ReturnsCheck.ReturnsUnit;
import kotlin.reflect.jvm.internal.impl.util.ValueParameterCountCheck.AtLeast;
import kotlin.reflect.jvm.internal.impl.util.ValueParameterCountCheck.Equals;
import kotlin.reflect.jvm.internal.impl.util.ValueParameterCountCheck.NoValueParameters;
import kotlin.reflect.jvm.internal.impl.util.ValueParameterCountCheck.SingleValueParameter;

/* compiled from: modifierChecks.kt */
public final class OperatorChecks extends AbstractModifierChecks {
    public static final OperatorChecks f33093a = null;
    private static final List<Checks> f33094b = null;

    static {
        OperatorChecks operatorChecks = new OperatorChecks();
    }

    private OperatorChecks() {
        f33093a = this;
        r0 = new Checks[18];
        Name name = OperatorNameConventions.f26401i;
        Intrinsics.m26843a((Object) name, HttpRequest.METHOD_GET);
        r0[0] = new Checks(name, new Check[]{MemberOrExtension.f36181a, new AtLeast(1)});
        name = OperatorNameConventions.f26402j;
        Intrinsics.m26843a((Object) name, "SET");
        r0[1] = new Checks(name, new Check[]{MemberOrExtension.f36181a, new AtLeast(2)}, (Function1) OperatorChecks$checks$1.f38953a);
        name = OperatorNameConventions.f26393a;
        Intrinsics.m26843a((Object) name, "GET_VALUE");
        r0[2] = new Checks(name, new Check[]{MemberOrExtension.f36181a, NoDefaultAndVarargsCheck.f33091a, new AtLeast(2), IsKPropertyCheck.f33087a});
        name = OperatorNameConventions.f26394b;
        Intrinsics.m26843a((Object) name, "SET_VALUE");
        r0[3] = new Checks(name, new Check[]{MemberOrExtension.f36181a, NoDefaultAndVarargsCheck.f33091a, new AtLeast(3), IsKPropertyCheck.f33087a});
        name = OperatorNameConventions.f26395c;
        Intrinsics.m26843a((Object) name, "PROVIDE_DELEGATE");
        r0[4] = new Checks(name, new Check[]{MemberOrExtension.f36181a, NoDefaultAndVarargsCheck.f33091a, new Equals(), IsKPropertyCheck.f33087a});
        name = OperatorNameConventions.f26399g;
        Intrinsics.m26843a((Object) name, "INVOKE");
        r0[5] = new Checks(name, new Check[]{MemberOrExtension.f36181a});
        name = OperatorNameConventions.f26398f;
        Intrinsics.m26843a((Object) name, "CONTAINS");
        r0[6] = new Checks(name, new Check[]{MemberOrExtension.f36181a, SingleValueParameter.f36188a, NoDefaultAndVarargsCheck.f33091a, ReturnsBoolean.f36182a});
        name = OperatorNameConventions.f26400h;
        Intrinsics.m26843a((Object) name, "ITERATOR");
        r0[7] = new Checks(name, new Check[]{MemberOrExtension.f36181a, NoValueParameters.f36187a});
        name = OperatorNameConventions.f26403k;
        Intrinsics.m26843a((Object) name, "NEXT");
        r0[8] = new Checks(name, new Check[]{MemberOrExtension.f36181a, NoValueParameters.f36187a});
        name = OperatorNameConventions.f26404l;
        Intrinsics.m26843a((Object) name, "HAS_NEXT");
        r0[9] = new Checks(name, new Check[]{MemberOrExtension.f36181a, NoValueParameters.f36187a, ReturnsBoolean.f36182a});
        name = OperatorNameConventions.f26381A;
        Intrinsics.m26843a((Object) name, "RANGE_TO");
        r0[10] = new Checks(name, new Check[]{MemberOrExtension.f36181a, SingleValueParameter.f36188a, NoDefaultAndVarargsCheck.f33091a});
        name = OperatorNameConventions.f26396d;
        Intrinsics.m26843a((Object) name, "EQUALS");
        r0[11] = new Checks(name, new Check[]{Member.f36180a}, (Function1) OperatorChecks$checks$2.f38955a);
        name = OperatorNameConventions.f26397e;
        Intrinsics.m26843a((Object) name, "COMPARE_TO");
        r0[12] = new Checks(name, new Check[]{MemberOrExtension.f36181a, ReturnsInt.f36183a, SingleValueParameter.f36188a, NoDefaultAndVarargsCheck.f33091a});
        r0[13] = new Checks((Collection) OperatorNameConventions.f26390J, new Check[]{MemberOrExtension.f36181a, SingleValueParameter.f36188a, NoDefaultAndVarargsCheck.f33091a});
        r0[14] = new Checks((Collection) OperatorNameConventions.f26389I, new Check[]{MemberOrExtension.f36181a, NoValueParameters.f36187a});
        r0[15] = new Checks((Collection) CollectionsKt__CollectionsKt.m26796b((Object[]) new Name[]{OperatorNameConventions.f26408p, OperatorNameConventions.f26409q}), new Check[]{MemberOrExtension.f36181a}, (Function1) OperatorChecks$checks$3.f38956a);
        r0[16] = new Checks((Collection) OperatorNameConventions.f26391K, new Check[]{MemberOrExtension.f36181a, ReturnsUnit.f36184a, SingleValueParameter.f36188a, NoDefaultAndVarargsCheck.f33091a});
        r0[17] = new Checks(OperatorNameConventions.f26405m, new Check[]{MemberOrExtension.f36181a, NoValueParameters.f36187a});
        f33094b = CollectionsKt__CollectionsKt.m26796b((Object[]) r0);
    }

    public final List<Checks> mo5947a() {
        return f33094b;
    }
}
