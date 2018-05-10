package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: typeQualifiers.kt */
final class TypeQualifiersKt$computeQualifiersForOverride$3 extends Lambda implements Function2<Set<? extends T>, T, T> {
    public static final TypeQualifiersKt$computeQualifiersForOverride$3 f38760a = new TypeQualifiersKt$computeQualifiersForOverride$3();

    TypeQualifiersKt$computeQualifiersForOverride$3() {
        super(2);
    }

    public static <T> T m38523a(Set<? extends T> set, T t) {
        Intrinsics.m26847b(set, "$receiver");
        if (t != null) {
            Set<? extends T> p = CollectionsKt___CollectionsKt.m41451p(SetsKt___SetsKt.m32821b(set, t));
            if (p != null) {
                set = p;
            }
        }
        return CollectionsKt___CollectionsKt.m41442i((Iterable) set);
    }
}
