package com.google.android.exoplayer2.text.webvtt;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Collections;
import java.util.List;

final class Mp4WebvttSubtitle implements Subtitle {
    private final List<Cue> f13570a;

    public final int mo1450a(long j) {
        return j < 0 ? 0 : -1;
    }

    public final int mo1452b() {
        return 1;
    }

    public Mp4WebvttSubtitle(List<Cue> list) {
        this.f13570a = Collections.unmodifiableList(list);
    }

    public final long a_(int i) {
        Assertions.m4184a(i == 0);
        return 0;
    }

    public final List<Cue> mo1453b(long j) {
        return j >= 0 ? this.f13570a : Collections.emptyList();
    }
}
