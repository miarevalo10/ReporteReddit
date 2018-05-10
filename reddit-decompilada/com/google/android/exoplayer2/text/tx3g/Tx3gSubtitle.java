package com.google.android.exoplayer2.text.tx3g;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Collections;
import java.util.List;

final class Tx3gSubtitle implements Subtitle {
    public static final Tx3gSubtitle f13568a = new Tx3gSubtitle();
    private final List<Cue> f13569b;

    public final int mo1450a(long j) {
        return j < 0 ? 0 : -1;
    }

    public final int mo1452b() {
        return 1;
    }

    public Tx3gSubtitle(Cue cue) {
        this.f13569b = Collections.singletonList(cue);
    }

    private Tx3gSubtitle() {
        this.f13569b = Collections.emptyList();
    }

    public final long a_(int i) {
        Assertions.m4184a(i == 0);
        return 0;
    }

    public final List<Cue> mo1453b(long j) {
        return j >= 0 ? this.f13569b : Collections.emptyList();
    }
}
