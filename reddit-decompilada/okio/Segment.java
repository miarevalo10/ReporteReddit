package okio;

final class Segment {
    final byte[] f26678a;
    int f26679b;
    int f26680c;
    boolean f26681d;
    boolean f26682e;
    Segment f26683f;
    Segment f26684g;

    Segment() {
        this.f26678a = new byte[8192];
        this.f26682e = true;
        this.f26681d = false;
    }

    Segment(Segment segment) {
        this(segment.f26678a, segment.f26679b, segment.f26680c);
        segment.f26681d = true;
    }

    Segment(byte[] bArr, int i, int i2) {
        this.f26678a = bArr;
        this.f26679b = i;
        this.f26680c = i2;
        this.f26682e = null;
        this.f26681d = 1;
    }

    public final Segment m28303a() {
        Segment segment = this.f26683f != this ? this.f26683f : null;
        this.f26684g.f26683f = this.f26683f;
        this.f26683f.f26684g = this.f26684g;
        this.f26683f = null;
        this.f26684g = null;
        return segment;
    }

    public final Segment m28304a(Segment segment) {
        segment.f26684g = this;
        segment.f26683f = this.f26683f;
        this.f26683f.f26684g = segment;
        this.f26683f = segment;
        return segment;
    }

    public final void m28305a(Segment segment, int i) {
        if (segment.f26682e) {
            if (segment.f26680c + i > 8192) {
                if (segment.f26681d) {
                    throw new IllegalArgumentException();
                } else if ((segment.f26680c + i) - segment.f26679b > 8192) {
                    throw new IllegalArgumentException();
                } else {
                    System.arraycopy(segment.f26678a, segment.f26679b, segment.f26678a, 0, segment.f26680c - segment.f26679b);
                    segment.f26680c -= segment.f26679b;
                    segment.f26679b = 0;
                }
            }
            System.arraycopy(this.f26678a, this.f26679b, segment.f26678a, segment.f26680c, i);
            segment.f26680c += i;
            this.f26679b += i;
            return;
        }
        throw new IllegalArgumentException();
    }
}
