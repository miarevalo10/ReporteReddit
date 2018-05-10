package kotlin.ranges;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0014B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0013\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0005\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, d2 = {"Lkotlin/ranges/IntRange;", "Lkotlin/ranges/IntProgression;", "Lkotlin/ranges/ClosedRange;", "", "start", "endInclusive", "(II)V", "getEndInclusive", "()Ljava/lang/Integer;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "isEmpty", "toString", "", "Companion", "kotlin-runtime"}, k = 1, mv = {1, 1, 9})
/* compiled from: Ranges.kt */
public final class IntRange extends IntProgression {
    public static final Companion f36017e = new Companion();
    private static final IntRange f36018f = new IntRange(1, 0);

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/ranges/IntRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/IntRange;", "getEMPTY", "()Lkotlin/ranges/IntRange;", "kotlin-runtime"}, k = 1, mv = {1, 1, 9})
    /* compiled from: Ranges.kt */
    public static final class Companion {
        private Companion() {
        }

        public static IntRange m26879a() {
            return IntRange.f36018f;
        }
    }

    public IntRange(int i, int i2) {
        super(i, i2, 1);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        r0 = r3 instanceof kotlin.ranges.IntRange;
        if (r0 == 0) goto L_0x0023;
    L_0x0004:
        r0 = r2.mo6664a();
        if (r0 == 0) goto L_0x0013;
    L_0x000a:
        r0 = r3;
        r0 = (kotlin.ranges.IntRange) r0;
        r0 = r0.mo6664a();
        if (r0 != 0) goto L_0x0021;
    L_0x0013:
        r0 = r2.f32536a;
        r3 = (kotlin.ranges.IntRange) r3;
        r1 = r3.f32536a;
        if (r0 != r1) goto L_0x0023;
    L_0x001b:
        r0 = r2.f32537b;
        r3 = r3.f32537b;
        if (r0 != r3) goto L_0x0023;
    L_0x0021:
        r3 = 1;
        return r3;
    L_0x0023:
        r3 = 0;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.ranges.IntRange.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        if (mo6664a()) {
            return -1;
        }
        return (31 * this.f32536a) + this.f32537b;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f32536a);
        stringBuilder.append("..");
        stringBuilder.append(this.f32537b);
        return stringBuilder.toString();
    }

    public final boolean mo6664a() {
        return this.f32536a > this.f32537b;
    }
}
