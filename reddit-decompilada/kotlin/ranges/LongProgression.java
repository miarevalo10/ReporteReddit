package kotlin.ranges;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\t\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0011\u0010\u0007\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lkotlin/ranges/LongProgression;", "", "", "start", "endInclusive", "step", "(JJJ)V", "first", "getFirst", "()J", "last", "getLast", "getStep", "equals", "", "other", "", "hashCode", "", "isEmpty", "iterator", "Lkotlin/collections/LongIterator;", "toString", "", "Companion", "kotlin-runtime"}, k = 1, mv = {1, 1, 9})
/* compiled from: Progressions.kt */
public class LongProgression implements Iterable<Long>, KMappedMarker {
    public static final Companion f32539c = new Companion();
    final long f32540a;
    final long f32541b;
    private final long f32542d = 1;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¨\u0006\t"}, d2 = {"Lkotlin/ranges/LongProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/LongProgression;", "rangeStart", "", "rangeEnd", "step", "kotlin-runtime"}, k = 1, mv = {1, 1, 9})
    /* compiled from: Progressions.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public LongProgression(long j, long j2) {
        this.f32540a = j;
        this.f32541b = ProgressionUtilKt.m26822a(j, j2);
    }

    public boolean mo6669a() {
        return this.f32542d > 0 ? this.f32540a > this.f32541b : this.f32540a < this.f32541b;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
        r4 = this;
        r0 = r5 instanceof kotlin.ranges.LongProgression;
        if (r0 == 0) goto L_0x002f;
    L_0x0004:
        r0 = r4.mo6669a();
        if (r0 == 0) goto L_0x0013;
    L_0x000a:
        r0 = r5;
        r0 = (kotlin.ranges.LongProgression) r0;
        r0 = r0.mo6669a();
        if (r0 != 0) goto L_0x002d;
    L_0x0013:
        r0 = r4.f32540a;
        r5 = (kotlin.ranges.LongProgression) r5;
        r2 = r5.f32540a;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 != 0) goto L_0x002f;
    L_0x001d:
        r0 = r4.f32541b;
        r2 = r5.f32541b;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 != 0) goto L_0x002f;
    L_0x0025:
        r0 = r4.f32542d;
        r2 = r5.f32542d;
        r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r5 != 0) goto L_0x002f;
    L_0x002d:
        r5 = 1;
        return r5;
    L_0x002f:
        r5 = 0;
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.ranges.LongProgression.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        return mo6669a() ? -1 : (int) ((31 * (((this.f32540a ^ (this.f32540a >>> 32)) * 31) + (this.f32541b ^ (this.f32541b >>> 32)))) + (this.f32542d ^ (this.f32542d >>> 32)));
    }

    public String toString() {
        StringBuilder stringBuilder;
        long j;
        if (this.f32542d > 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.f32540a);
            stringBuilder.append("..");
            stringBuilder.append(this.f32541b);
            stringBuilder.append(" step ");
            j = this.f32542d;
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.f32540a);
            stringBuilder.append(" downTo ");
            stringBuilder.append(this.f32541b);
            stringBuilder.append(" step ");
            j = -this.f32542d;
        }
        stringBuilder.append(j);
        return stringBuilder.toString();
    }

    public /* synthetic */ Iterator iterator() {
        return new LongProgressionIterator(this.f32540a, this.f32541b, this.f32542d);
    }
}
