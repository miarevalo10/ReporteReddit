package kotlin.reflect.jvm.internal;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 5})
/* compiled from: AnnotationConstructorCaller.kt */
final class C2921x4fc4299 extends Lambda implements Function0<String> {
    final /* synthetic */ Class f38211a;
    final /* synthetic */ Map f38212b;

    C2921x4fc4299(Class cls, Map map) {
        this.f38211a = cls;
        this.f38212b = map;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('@');
        stringBuilder.append(this.f38211a.getCanonicalName());
        CollectionsKt___CollectionsKt.m41410a(this.f38212b.entrySet(), stringBuilder, ", ", "(", ")", 0, null, C2920xd18867f3.f38210a, 48);
        Object stringBuilder2 = stringBuilder.toString();
        Intrinsics.m26843a(stringBuilder2, "StringBuilder().apply(builderAction).toString()");
        return stringBuilder2;
    }
}
