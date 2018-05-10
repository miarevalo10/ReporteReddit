package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Set;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: typeQualifiers.kt */
final class TypeQualifiersKt$computeQualifiersForOverride$2 extends Lambda implements Function4<Set<? extends T>, T, T, T, T> {
    public static final TypeQualifiersKt$computeQualifiersForOverride$2 f38759a = new TypeQualifiersKt$computeQualifiersForOverride$2();

    TypeQualifiersKt$computeQualifiersForOverride$2() {
        super(4);
    }

    public static <T> T m38521a(Set<? extends T> set, T t, T t2, T t3) {
        Intrinsics.m26847b(set, "$receiver");
        Intrinsics.m26847b(t, "low");
        Intrinsics.m26847b(t2, "high");
        set = set.contains(t) ? t : set.contains(t2) != null ? t2 : null;
        if (Intrinsics.m26845a((Object) set, (Object) t) != null && Intrinsics.m26845a((Object) t3, (Object) t2) != null) {
            return null;
        }
        if (t3 != null) {
            set = t3;
        }
        return set;
    }
}
