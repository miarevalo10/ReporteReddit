package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.Format;

public final class Track {
    public final int f4453a;
    public final int f4454b;
    public final long f4455c;
    public final long f4456d;
    public final long f4457e;
    public final Format f4458f;
    public final int f4459g;
    public final long[] f4460h;
    public final long[] f4461i;
    public final int f4462j;
    private final TrackEncryptionBox[] f4463k;

    public Track(int i, int i2, long j, long j2, long j3, Format format, int i3, TrackEncryptionBox[] trackEncryptionBoxArr, int i4, long[] jArr, long[] jArr2) {
        this.f4453a = i;
        this.f4454b = i2;
        this.f4455c = j;
        this.f4456d = j2;
        this.f4457e = j3;
        this.f4458f = format;
        this.f4459g = i3;
        this.f4463k = trackEncryptionBoxArr;
        this.f4462j = i4;
        this.f4460h = jArr;
        this.f4461i = jArr2;
    }

    public final TrackEncryptionBox m3819a(int i) {
        return this.f4463k == null ? 0 : this.f4463k[i];
    }
}
