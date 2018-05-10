package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.LongIterator;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\b\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lkotlin/ranges/LongProgressionIterator;", "Lkotlin/collections/LongIterator;", "first", "", "last", "step", "(JJJ)V", "finalElement", "hasNext", "", "next", "getStep", "()J", "nextLong", "kotlin-runtime"}, k = 1, mv = {1, 1, 9})
/* compiled from: ProgressionIterators.kt */
public final class LongProgressionIterator extends LongIterator {
    private final long f36019a;
    private boolean f36020b;
    private long f36021c;
    private final long f36022d;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LongProgressionIterator(long r3, long r5, long r7) {
        /*
        r2 = this;
        r2.<init>();
        r2.f36022d = r7;
        r2.f36019a = r5;
        r7 = r2.f36022d;
        r0 = 0;
        r7 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1));
        r8 = 0;
        r0 = 1;
        if (r7 <= 0) goto L_0x0017;
    L_0x0011:
        r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r5 > 0) goto L_0x001c;
    L_0x0015:
        r8 = r0;
        goto L_0x001c;
    L_0x0017:
        r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r5 < 0) goto L_0x001c;
    L_0x001b:
        goto L_0x0015;
    L_0x001c:
        r2.f36020b = r8;
        r5 = r2.f36020b;
        if (r5 == 0) goto L_0x0023;
    L_0x0022:
        goto L_0x0025;
    L_0x0023:
        r3 = r2.f36019a;
    L_0x0025:
        r2.f36021c = r3;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.ranges.LongProgressionIterator.<init>(long, long, long):void");
    }

    public final boolean hasNext() {
        return this.f36020b;
    }

    public final long mo6668a() {
        long j = this.f36021c;
        if (j != this.f36019a) {
            this.f36021c += this.f36022d;
        } else if (this.f36020b) {
            this.f36020b = false;
        } else {
            throw new NoSuchElementException();
        }
        return j;
    }
}
