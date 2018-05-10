package com.google.android.exoplayer2.text.dvb;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import java.util.List;

final class DvbSubtitle implements Subtitle {
    private final List<Cue> f13559a;

    public final int mo1450a(long j) {
        return -1;
    }

    public final long a_(int i) {
        return 0;
    }

    public final int mo1452b() {
        return 1;
    }

    public DvbSubtitle(List<Cue> list) {
        this.f13559a = list;
    }

    public final List<Cue> mo1453b(long j) {
        return this.f13559a;
    }
}
