package kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize;

import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: capitalizeDecapitalize.kt */
final class CapitalizeDecapitalizeKt$decapitalizeSmart$2 extends Lambda implements Function1<String, String> {
    final /* synthetic */ boolean f38962a = true;

    CapitalizeDecapitalizeKt$decapitalizeSmart$2() {
        super(1);
    }

    public final String m38728a(String str) {
        Intrinsics.m26847b(str, "string");
        if (this.f38962a) {
            return CapitalizeDecapitalizeKt.m28083c(str);
        }
        if (str == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        Object toLowerCase = str.toLowerCase();
        Intrinsics.m26843a(toLowerCase, "(this as java.lang.String).toLowerCase()");
        return toLowerCase;
    }
}
