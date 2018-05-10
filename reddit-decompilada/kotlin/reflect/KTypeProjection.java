package kotlin.reflect;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lkotlin/reflect/KTypeProjection;", "", "variance", "Lkotlin/reflect/KVariance;", "type", "Lkotlin/reflect/KType;", "(Lkotlin/reflect/KVariance;Lkotlin/reflect/KType;)V", "getType", "()Lkotlin/reflect/KType;", "getVariance", "()Lkotlin/reflect/KVariance;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "kotlin-runtime"}, k = 1, mv = {1, 1, 9})
/* compiled from: KType.kt */
public final class KTypeProjection {
    public static final Companion f25301a = new Companion();
    private static final KTypeProjection f25302d = new KTypeProjection(null, null);
    private final KVariance f25303b;
    private final KType f25304c;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lkotlin/reflect/KTypeProjection$Companion;", "", "()V", "STAR", "Lkotlin/reflect/KTypeProjection;", "getSTAR", "()Lkotlin/reflect/KTypeProjection;", "contravariant", "type", "Lkotlin/reflect/KType;", "covariant", "invariant", "kotlin-runtime"}, k = 1, mv = {1, 1, 9})
    /* compiled from: KType.kt */
    public static final class Companion {
        private Companion() {
        }

        public static KTypeProjection m26884a() {
            return KTypeProjection.f25302d;
        }

        public static KTypeProjection m26885a(KType kType) {
            Intrinsics.m26847b(kType, "type");
            return new KTypeProjection(KVariance.f25305a, kType);
        }

        public static KTypeProjection m26886b(KType kType) {
            Intrinsics.m26847b(kType, "type");
            return new KTypeProjection(KVariance.f25306b, kType);
        }

        public static KTypeProjection m26887c(KType kType) {
            Intrinsics.m26847b(kType, "type");
            return new KTypeProjection(KVariance.f25307c, kType);
        }
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof KTypeProjection) {
                KTypeProjection kTypeProjection = (KTypeProjection) obj;
                if (Intrinsics.m26845a(this.f25303b, kTypeProjection.f25303b) && Intrinsics.m26845a(this.f25304c, kTypeProjection.f25304c)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        KVariance kVariance = this.f25303b;
        int i = 0;
        int hashCode = (kVariance != null ? kVariance.hashCode() : 0) * 31;
        KType kType = this.f25304c;
        if (kType != null) {
            i = kType.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("KTypeProjection(variance=");
        stringBuilder.append(this.f25303b);
        stringBuilder.append(", type=");
        stringBuilder.append(this.f25304c);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public KTypeProjection(KVariance kVariance, KType kType) {
        this.f25303b = kVariance;
        this.f25304c = kType;
    }
}
