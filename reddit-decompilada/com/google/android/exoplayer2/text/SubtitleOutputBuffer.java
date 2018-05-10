package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.decoder.OutputBuffer;
import java.util.List;

public abstract class SubtitleOutputBuffer extends OutputBuffer implements Subtitle {
    private Subtitle f17032d;
    private long f17033e;

    public abstract void mo3924e();

    public final void m17333a(long j, Subtitle subtitle, long j2) {
        this.b = j;
        this.f17032d = subtitle;
        if (j2 == Long.MAX_VALUE) {
            j2 = this.b;
        }
        this.f17033e = j2;
    }

    public final int mo1452b() {
        return this.f17032d.mo1452b();
    }

    public final long a_(int i) {
        return this.f17032d.a_(i) + this.f17033e;
    }

    public final int mo1450a(long j) {
        return this.f17032d.mo1450a(j - this.f17033e);
    }

    public final List<Cue> mo1453b(long j) {
        return this.f17032d.mo1453b(j - this.f17033e);
    }

    public final void mo1321a() {
        super.mo1321a();
        this.f17032d = null;
    }
}
