package com.google.android.exoplayer2.source;

public final class CompositeSequenceableLoader implements SequenceableLoader {
    private final SequenceableLoader[] f13240a;

    public CompositeSequenceableLoader(SequenceableLoader[] sequenceableLoaderArr) {
        this.f13240a = sequenceableLoaderArr;
    }

    public final long mo1402d() {
        long j = Long.MAX_VALUE;
        for (SequenceableLoader d : this.f13240a) {
            long d2 = d.mo1402d();
            if (d2 != Long.MIN_VALUE) {
                j = Math.min(j, d2);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    public final long mo1403e() {
        long j = Long.MAX_VALUE;
        for (SequenceableLoader e : this.f13240a) {
            long e2 = e.mo1403e();
            if (e2 != Long.MIN_VALUE) {
                j = Math.min(j, e2);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    public final boolean mo1401c(long j) {
        boolean z = false;
        int i;
        do {
            long e = mo1403e();
            if (e == Long.MIN_VALUE) {
                break;
            }
            SequenceableLoader[] sequenceableLoaderArr = this.f13240a;
            int length = sequenceableLoaderArr.length;
            int i2 = 0;
            i = i2;
            while (i2 < length) {
                SequenceableLoader sequenceableLoader = sequenceableLoaderArr[i2];
                if (sequenceableLoader.mo1403e() == e) {
                    i |= sequenceableLoader.mo1401c(j);
                }
                i2++;
            }
            z |= i;
        } while (i != 0);
        return z;
    }
}
