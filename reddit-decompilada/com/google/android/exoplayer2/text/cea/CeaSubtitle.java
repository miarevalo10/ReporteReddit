package com.google.android.exoplayer2.text.cea;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Collections;
import java.util.List;

final class CeaSubtitle implements Subtitle {
    private final List<Cue> f13558a;

    public final int mo1450a(long j) {
        return j < 0 ? 0 : -1;
    }

    public final int mo1452b() {
        return 1;
    }

    public CeaSubtitle(List<Cue> list) {
        this.f13558a = list;
    }

    public final long a_(int i) {
        Assertions.m4184a(i == 0);
        return 0;
    }

    public final List<Cue> mo1453b(long j) {
        return j >= 0 ? this.f13558a : Collections.emptyList();
    }
}
