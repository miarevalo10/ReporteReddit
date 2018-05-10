package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;

/* compiled from: notFoundClasses.kt */
final class NotFoundClassesKt$splitCanonicalFqName$1 extends Lambda implements Function1<String, String> {
    public static final NotFoundClassesKt$splitCanonicalFqName$1 f38449a = new NotFoundClassesKt$splitCanonicalFqName$1();

    NotFoundClassesKt$splitCanonicalFqName$1() {
        super(1);
    }

    public static String m38412a(String str) {
        Intrinsics.m26847b(str, "$receiver");
        if ((((CharSequence) str).length() > 0 ? 1 : null) != null) {
            return str;
        }
        Object a = SpecialNames.f25873d.m27429a();
        Intrinsics.m26843a(a, "SpecialNames.SAFE_IDENTI…ER_FOR_NO_NAME.asString()");
        return a;
    }
}
