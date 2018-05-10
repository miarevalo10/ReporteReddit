package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* compiled from: typeEnhancement.kt */
final class EnhancementResult<T> {
    final T f25737a;
    final Annotations f25738b;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof EnhancementResult) {
                EnhancementResult enhancementResult = (EnhancementResult) obj;
                if (Intrinsics.m26845a(this.f25737a, enhancementResult.f25737a) && Intrinsics.m26845a(this.f25738b, enhancementResult.f25738b)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        Object obj = this.f25737a;
        int i = 0;
        int hashCode = (obj != null ? obj.hashCode() : 0) * 31;
        Annotations annotations = this.f25738b;
        if (annotations != null) {
            i = annotations.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("EnhancementResult(result=");
        stringBuilder.append(this.f25737a);
        stringBuilder.append(", enhancementAnnotations=");
        stringBuilder.append(this.f25738b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public EnhancementResult(T t, Annotations annotations) {
        this.f25737a = t;
        this.f25738b = annotations;
    }
}
