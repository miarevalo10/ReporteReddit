package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: signatureEnhancement.kt */
final class PartEnhancementResult {
    final KotlinType f25750a;
    final boolean f25751b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PartEnhancementResult) {
            PartEnhancementResult partEnhancementResult = (PartEnhancementResult) obj;
            if (Intrinsics.m26845a(this.f25750a, partEnhancementResult.f25750a)) {
                if (this.f25751b == partEnhancementResult.f25751b) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        KotlinType kotlinType = this.f25750a;
        int hashCode = (kotlinType != null ? kotlinType.hashCode() : 0) * 31;
        int i = this.f25751b;
        if (i != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("PartEnhancementResult(type=");
        stringBuilder.append(this.f25750a);
        stringBuilder.append(", wereChanges=");
        stringBuilder.append(this.f25751b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public PartEnhancementResult(KotlinType kotlinType, boolean z) {
        Intrinsics.m26847b(kotlinType, "type");
        this.f25750a = kotlinType;
        this.f25751b = z;
    }
}
