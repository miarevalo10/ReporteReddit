package com.sendbird.android.shadow.okio;

final class Segment {
    final byte[] f23607a;
    int f23608b;
    int f23609c;
    boolean f23610d;
    boolean f23611e;
    Segment f23612f;
    Segment f23613g;

    Segment() {
        this.f23607a = new byte[8192];
        this.f23611e = true;
        this.f23610d = false;
    }

    Segment(Segment segment) {
        this(segment.f23607a, segment.f23608b, segment.f23609c);
        segment.f23610d = true;
    }

    Segment(byte[] bArr, int i, int i2) {
        this.f23607a = bArr;
        this.f23608b = i;
        this.f23609c = i2;
        this.f23611e = null;
        this.f23610d = 1;
    }

    public final Segment m25628a() {
        Segment segment = this.f23612f != this ? this.f23612f : null;
        this.f23613g.f23612f = this.f23612f;
        this.f23612f.f23613g = this.f23613g;
        this.f23612f = null;
        this.f23613g = null;
        return segment;
    }

    public final Segment m25629a(Segment segment) {
        segment.f23613g = this;
        segment.f23612f = this.f23612f;
        this.f23612f.f23613g = segment;
        this.f23612f = segment;
        return segment;
    }

    public final void m25630a(Segment segment, int i) {
        if (segment.f23611e) {
            if (segment.f23609c + i > 8192) {
                if (segment.f23610d) {
                    throw new IllegalArgumentException();
                } else if ((segment.f23609c + i) - segment.f23608b > 8192) {
                    throw new IllegalArgumentException();
                } else {
                    System.arraycopy(segment.f23607a, segment.f23608b, segment.f23607a, 0, segment.f23609c - segment.f23608b);
                    segment.f23609c -= segment.f23608b;
                    segment.f23608b = 0;
                }
            }
            System.arraycopy(this.f23607a, this.f23608b, segment.f23607a, segment.f23609c, i);
            segment.f23609c += i;
            this.f23608b += i;
            return;
        }
        throw new IllegalArgumentException();
    }
}
