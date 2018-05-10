package com.google.android.exoplayer2.text.ssa;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.List;

final class SsaSubtitle implements Subtitle {
    private final Cue[] f13560a;
    private final long[] f13561b;

    public SsaSubtitle(Cue[] cueArr, long[] jArr) {
        this.f13560a = cueArr;
        this.f13561b = jArr;
    }

    public final int mo1450a(long j) {
        j = Util.m4301a(this.f13561b, j, false, false);
        return j < this.f13561b.length ? j : -1;
    }

    public final int mo1452b() {
        return this.f13561b.length;
    }

    public final long a_(int i) {
        boolean z = false;
        Assertions.m4184a(i >= 0);
        if (i < this.f13561b.length) {
            z = true;
        }
        Assertions.m4184a(z);
        return this.f13561b[i];
    }

    public final List<Cue> mo1453b(long j) {
        j = Util.m4300a(this.f13561b, j, false);
        if (j != -1) {
            if (this.f13560a[j] != null) {
                return Collections.singletonList(this.f13560a[j]);
            }
        }
        return Collections.emptyList();
    }
}
