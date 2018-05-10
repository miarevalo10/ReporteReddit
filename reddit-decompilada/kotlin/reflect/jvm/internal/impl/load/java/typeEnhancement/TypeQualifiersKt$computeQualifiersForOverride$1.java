package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: typeQualifiers.kt */
final class TypeQualifiersKt$computeQualifiersForOverride$1 extends Lambda implements Function2<NullabilityQualifier, MutabilityQualifier, JavaTypeQualifiers> {
    final /* synthetic */ boolean f38758a;

    TypeQualifiersKt$computeQualifiersForOverride$1(boolean z) {
        this.f38758a = z;
        super(2);
    }

    public final JavaTypeQualifiers m38520a(NullabilityQualifier nullabilityQualifier, MutabilityQualifier mutabilityQualifier) {
        if (this.f38758a) {
            if ((Intrinsics.m26845a((Object) nullabilityQualifier, NullabilityQualifier.f25748b) ^ 1) == 0) {
                return new JavaTypeQualifiers(nullabilityQualifier, mutabilityQualifier, true);
            }
        }
        return new JavaTypeQualifiers(nullabilityQualifier, mutabilityQualifier, false);
    }
}
