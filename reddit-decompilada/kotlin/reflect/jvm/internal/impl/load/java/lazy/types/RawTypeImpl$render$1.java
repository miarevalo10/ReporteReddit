package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: RawType.kt */
final class RawTypeImpl$render$1 extends Lambda implements Function2<String, String, Boolean> {
    public static final RawTypeImpl$render$1 f38450a = new RawTypeImpl$render$1();

    RawTypeImpl$render$1() {
        super(2);
    }

    public final /* synthetic */ Object mo6497a(Object obj, Object obj2) {
        return Boolean.valueOf(m38414a((String) obj, (String) obj2));
    }

    public static boolean m38414a(String str, String str2) {
        Intrinsics.m26847b(str, "first");
        Intrinsics.m26847b(str2, "second");
        if (Intrinsics.m26845a((Object) str, StringsKt__StringsKt.m42447a(str2, (CharSequence) "out ")) == null) {
            if (Intrinsics.m26845a((Object) str2, Operation.MULTIPLY) == null) {
                return null;
            }
        }
        return true;
    }
}
