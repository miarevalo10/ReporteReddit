package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: CapturedTypeApproximation.kt */
public final class ApproximationBounds<T> {
    final T f26368a;
    public final T f26369b;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ApproximationBounds) {
                ApproximationBounds approximationBounds = (ApproximationBounds) obj;
                if (Intrinsics.m26845a(this.f26368a, approximationBounds.f26368a) && Intrinsics.m26845a(this.f26369b, approximationBounds.f26369b)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        Object obj = this.f26368a;
        int i = 0;
        int hashCode = (obj != null ? obj.hashCode() : 0) * 31;
        Object obj2 = this.f26369b;
        if (obj2 != null) {
            i = obj2.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("ApproximationBounds(lower=");
        stringBuilder.append(this.f26368a);
        stringBuilder.append(", upper=");
        stringBuilder.append(this.f26369b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public ApproximationBounds(T t, T t2) {
        this.f26368a = t;
        this.f26369b = t2;
    }
}
