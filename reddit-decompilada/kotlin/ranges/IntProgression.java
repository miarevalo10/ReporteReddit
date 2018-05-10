package kotlin.ranges;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\t\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0007\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lkotlin/ranges/IntProgression;", "", "", "start", "endInclusive", "step", "(III)V", "first", "getFirst", "()I", "last", "getLast", "getStep", "equals", "", "other", "", "hashCode", "isEmpty", "iterator", "Lkotlin/collections/IntIterator;", "toString", "", "Companion", "kotlin-runtime"}, k = 1, mv = {1, 1, 9})
/* compiled from: Progressions.kt */
public class IntProgression implements Iterable<Integer>, KMappedMarker {
    public static final Companion f32535d = new Companion();
    public final int f32536a;
    public final int f32537b;
    public final int f32538c;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¨\u0006\t"}, d2 = {"Lkotlin/ranges/IntProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/IntProgression;", "rangeStart", "", "rangeEnd", "step", "kotlin-runtime"}, k = 1, mv = {1, 1, 9})
    /* compiled from: Progressions.kt */
    public static final class Companion {
        private Companion() {
        }

        public static IntProgression m26878a(int i, int i2) {
            return new IntProgression(i, i2, -1);
        }
    }

    public IntProgression(int i, int i2, int i3) {
        if (i3 == 0) {
            throw ((Throwable) new IllegalArgumentException("Step must be non-zero"));
        }
        this.f32536a = i;
        this.f32537b = ProgressionUtilKt.m26821a(i, i2, i3);
        this.f32538c = i3;
    }

    public boolean mo6664a() {
        return this.f32538c > 0 ? this.f32536a > this.f32537b : this.f32536a < this.f32537b;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        r0 = r3 instanceof kotlin.ranges.IntProgression;
        if (r0 == 0) goto L_0x0029;
    L_0x0004:
        r0 = r2.mo6664a();
        if (r0 == 0) goto L_0x0013;
    L_0x000a:
        r0 = r3;
        r0 = (kotlin.ranges.IntProgression) r0;
        r0 = r0.mo6664a();
        if (r0 != 0) goto L_0x0027;
    L_0x0013:
        r0 = r2.f32536a;
        r3 = (kotlin.ranges.IntProgression) r3;
        r1 = r3.f32536a;
        if (r0 != r1) goto L_0x0029;
    L_0x001b:
        r0 = r2.f32537b;
        r1 = r3.f32537b;
        if (r0 != r1) goto L_0x0029;
    L_0x0021:
        r0 = r2.f32538c;
        r3 = r3.f32538c;
        if (r0 != r3) goto L_0x0029;
    L_0x0027:
        r3 = 1;
        return r3;
    L_0x0029:
        r3 = 0;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.ranges.IntProgression.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        return mo6664a() ? -1 : (31 * ((this.f32536a * 31) + this.f32537b)) + this.f32538c;
    }

    public String toString() {
        StringBuilder stringBuilder;
        int i;
        if (this.f32538c > 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.f32536a);
            stringBuilder.append("..");
            stringBuilder.append(this.f32537b);
            stringBuilder.append(" step ");
            i = this.f32538c;
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.f32536a);
            stringBuilder.append(" downTo ");
            stringBuilder.append(this.f32537b);
            stringBuilder.append(" step ");
            i = -this.f32538c;
        }
        stringBuilder.append(i);
        return stringBuilder.toString();
    }

    public /* synthetic */ Iterator iterator() {
        return new IntProgressionIterator(this.f32536a, this.f32537b, this.f32538c);
    }
}
