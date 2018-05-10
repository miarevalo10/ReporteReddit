package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000'\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\t\u0010\u001a\u001a\u00020\u001bH\u0002J\t\u0010\u001c\u001a\u00020\u0002H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\tR\u001a\u0010\u0015\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0007\"\u0004\b\u0017\u0010\t¨\u0006\u001d"}, d2 = {"kotlin/text/DelimitedRangesSequence$iterator$1", "", "Lkotlin/ranges/IntRange;", "(Lkotlin/text/DelimitedRangesSequence;)V", "counter", "", "getCounter", "()I", "setCounter", "(I)V", "currentStartIndex", "getCurrentStartIndex", "setCurrentStartIndex", "nextItem", "getNextItem", "()Lkotlin/ranges/IntRange;", "setNextItem", "(Lkotlin/ranges/IntRange;)V", "nextSearchIndex", "getNextSearchIndex", "setNextSearchIndex", "nextState", "getNextState", "setNextState", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"}, k = 1, mv = {1, 1, 9})
/* compiled from: Strings.kt */
public final class DelimitedRangesSequence$iterator$1 implements Iterator<IntRange>, KMappedMarker {
    final /* synthetic */ DelimitedRangesSequence f33135a;
    private int f33136b = -1;
    private int f33137c;
    private int f33138d;
    private IntRange f33139e;
    private int f33140f;

    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    DelimitedRangesSequence$iterator$1(DelimitedRangesSequence delimitedRangesSequence) {
        this.f33135a = delimitedRangesSequence;
        this.f33137c = RangesKt___RangesKt.m32857e(delimitedRangesSequence.f33142b, delimitedRangesSequence.f33141a.length());
        this.f33138d = this.f33137c;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m33729a() {
        /*
        r6 = this;
        r0 = r6.f33138d;
        r1 = 0;
        if (r0 >= 0) goto L_0x000b;
    L_0x0005:
        r6.f33136b = r1;
        r0 = 0;
        r6.f33139e = r0;
        return;
    L_0x000b:
        r0 = r6.f33135a;
        r0 = r0.f33143c;
        r2 = -1;
        r3 = 1;
        if (r0 <= 0) goto L_0x0024;
    L_0x0015:
        r0 = r6.f33140f;
        r0 = r0 + r3;
        r6.f33140f = r0;
        r0 = r6.f33140f;
        r4 = r6.f33135a;
        r4 = r4.f33143c;
        if (r0 >= r4) goto L_0x0032;
    L_0x0024:
        r0 = r6.f33138d;
        r4 = r6.f33135a;
        r4 = r4.f33141a;
        r4 = r4.length();
        if (r0 <= r4) goto L_0x0048;
    L_0x0032:
        r0 = r6.f33137c;
        r1 = new kotlin.ranges.IntRange;
        r4 = r6.f33135a;
        r4 = r4.f33141a;
        r4 = kotlin.text.StringsKt__StringsKt.m42467e(r4);
        r1.<init>(r0, r4);
        r6.f33139e = r1;
        r6.f33138d = r2;
        goto L_0x009b;
    L_0x0048:
        r0 = r6.f33135a;
        r0 = r0.f33144d;
        r4 = r6.f33135a;
        r4 = r4.f33141a;
        r5 = r6.f33138d;
        r5 = java.lang.Integer.valueOf(r5);
        r0 = r0.mo6497a(r4, r5);
        r0 = (kotlin.Pair) r0;
        if (r0 != 0) goto L_0x0078;
    L_0x0062:
        r0 = r6.f33137c;
        r1 = new kotlin.ranges.IntRange;
        r4 = r6.f33135a;
        r4 = r4.f33141a;
        r4 = kotlin.text.StringsKt__StringsKt.m42467e(r4);
        r1.<init>(r0, r4);
        r6.f33139e = r1;
        r6.f33138d = r2;
        goto L_0x009b;
    L_0x0078:
        r2 = r0.f25267a;
        r2 = (java.lang.Number) r2;
        r2 = r2.intValue();
        r0 = r0.f25268b;
        r0 = (java.lang.Number) r0;
        r0 = r0.intValue();
        r4 = r6.f33137c;
        r4 = kotlin.ranges.RangesKt___RangesKt.m32854b(r4, r2);
        r6.f33139e = r4;
        r2 = r2 + r0;
        r6.f33137c = r2;
        r2 = r6.f33137c;
        if (r0 != 0) goto L_0x0098;
    L_0x0097:
        r1 = r3;
    L_0x0098:
        r2 = r2 + r1;
        r6.f33138d = r2;
    L_0x009b:
        r6.f33136b = r3;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.DelimitedRangesSequence$iterator$1.a():void");
    }

    public final boolean hasNext() {
        if (this.f33136b == -1) {
            m33729a();
        }
        return this.f33136b == 1;
    }

    public final /* synthetic */ Object next() {
        if (this.f33136b == -1) {
            m33729a();
        }
        if (this.f33136b == 0) {
            throw new NoSuchElementException();
        }
        IntRange intRange = this.f33139e;
        if (intRange == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.ranges.IntRange");
        }
        this.f33139e = null;
        this.f33136b = -1;
        return intRange;
    }
}
