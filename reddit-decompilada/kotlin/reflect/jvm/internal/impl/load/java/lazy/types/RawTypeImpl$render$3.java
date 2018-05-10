package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: RawType.kt */
final class RawTypeImpl$render$3 extends Lambda implements Function2<String, String, String> {
    public static final RawTypeImpl$render$3 f38452a = new RawTypeImpl$render$3();

    RawTypeImpl$render$3() {
        super(2);
    }

    public static String m38418a(String str, String str2) {
        Intrinsics.m26847b(str, "$receiver");
        Intrinsics.m26847b(str2, "newArgs");
        if (!StringsKt__StringsKt.m42460b((CharSequence) str, '<')) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(StringsKt__StringsKt.m42445a(str, '<'));
        stringBuilder.append(Operation.LESS_THAN);
        stringBuilder.append(str2);
        stringBuilder.append(Operation.GREATER_THAN);
        stringBuilder.append(StringsKt__StringsKt.m42458b(str, '>'));
        return stringBuilder.toString();
    }
}
