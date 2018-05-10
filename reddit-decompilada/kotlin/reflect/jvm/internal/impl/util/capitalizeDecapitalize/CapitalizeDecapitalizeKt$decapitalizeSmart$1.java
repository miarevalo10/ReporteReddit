package kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: capitalizeDecapitalize.kt */
final class CapitalizeDecapitalizeKt$decapitalizeSmart$1 extends Lambda implements Function1<Integer, Boolean> {
    final /* synthetic */ String f38960a;
    final /* synthetic */ boolean f38961b = true;

    CapitalizeDecapitalizeKt$decapitalizeSmart$1(String str) {
        this.f38960a = str;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        return Boolean.valueOf(m38726a(((Number) obj).intValue()));
    }

    public final boolean m38726a(int i) {
        i = this.f38960a.charAt(i);
        if (this.f38961b) {
            return 65 <= i && i <= 90;
        } else {
            return Character.isUpperCase(i);
        }
    }
}
