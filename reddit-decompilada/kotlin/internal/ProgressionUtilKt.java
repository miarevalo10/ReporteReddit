package kotlin.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a \u0010\u0000\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a \u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0001\u001a \u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0001\u001a\u0018\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0002\u001a\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005H\u0002¨\u0006\u000b"}, d2 = {"differenceModulo", "", "a", "b", "c", "", "getProgressionLastElement", "start", "end", "step", "mod", "kotlin-runtime"}, k = 2, mv = {1, 1, 9})
/* compiled from: progressionUtil.kt */
public final class ProgressionUtilKt {
    private static final int m26820a(int i, int i2) {
        i %= i2;
        return i >= 0 ? i : i + i2;
    }

    private static final long m26825b(long j, long j2) {
        j %= j2;
        return j >= 0 ? j : j + j2;
    }

    private static final int m26824b(int i, int i2, int i3) {
        return m26820a(m26820a(i, i3) - m26820a(i2, i3), i3);
    }

    private static final long m26823a(long j, long j2, long j3) {
        return m26825b(m26825b(j, j3) - m26825b(j2, j3), j3);
    }

    @PublishedApi
    public static final int m26821a(int i, int i2, int i3) {
        if (i3 > 0) {
            return i2 - m26824b(i2, i, i3);
        }
        if (i3 < 0) {
            return i2 + m26824b(i, i2, -i3);
        }
        throw ((Throwable) new IllegalArgumentException("Step is zero."));
    }

    @PublishedApi
    public static final long m26822a(long j, long j2) {
        return j2 - m26823a(j2, j, 1);
    }
}
