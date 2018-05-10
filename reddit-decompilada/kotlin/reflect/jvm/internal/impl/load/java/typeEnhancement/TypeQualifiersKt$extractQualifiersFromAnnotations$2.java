package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: typeQualifiers.kt */
final class TypeQualifiersKt$extractQualifiersFromAnnotations$2 extends Lambda implements Function2<T, T, T> {
    public static final TypeQualifiersKt$extractQualifiersFromAnnotations$2 f38762a = new TypeQualifiersKt$extractQualifiersFromAnnotations$2();

    TypeQualifiersKt$extractQualifiersFromAnnotations$2() {
        super(2);
    }

    public final <T> T mo6497a(T t, T t2) {
        if (!(t == null || t2 == null)) {
            if (!Intrinsics.m26845a((Object) t, (Object) t2)) {
                return null;
            }
        }
        if (t == null) {
            t = t2;
        }
        return t;
    }
}
