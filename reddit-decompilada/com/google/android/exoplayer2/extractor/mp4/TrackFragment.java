package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.util.ParsableByteArray;

final class TrackFragment {
    public DefaultSampleValues f4469a;
    public long f4470b;
    public long f4471c;
    public long f4472d;
    public int f4473e;
    public int f4474f;
    public long[] f4475g;
    public int[] f4476h;
    public int[] f4477i;
    public int[] f4478j;
    public long[] f4479k;
    public boolean[] f4480l;
    public boolean f4481m;
    public boolean[] f4482n;
    public TrackEncryptionBox f4483o;
    public int f4484p;
    public ParsableByteArray f4485q;
    public boolean f4486r;
    public long f4487s;

    TrackFragment() {
    }

    public final void m3820a(int i) {
        if (this.f4485q == null || this.f4485q.f5258c < i) {
            this.f4485q = new ParsableByteArray(i);
        }
        this.f4484p = i;
        this.f4481m = true;
        this.f4486r = true;
    }

    public final long m3821b(int i) {
        return this.f4479k[i] + ((long) this.f4478j[i]);
    }
}
