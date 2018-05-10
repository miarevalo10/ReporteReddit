package com.sendbird.android.shadow.okio;

final class SegmentPool {
    static Segment f23614a;
    static long f23615b;

    private SegmentPool() {
    }

    static Segment m25631a() {
        synchronized (SegmentPool.class) {
            if (f23614a != null) {
                Segment segment = f23614a;
                f23614a = segment.f23612f;
                segment.f23612f = null;
                f23615b -= 8192;
                return segment;
            }
            return new Segment();
        }
    }

    static void m25632a(Segment segment) {
        if (segment.f23612f == null) {
            if (segment.f23613g == null) {
                if (!segment.f23610d) {
                    synchronized (SegmentPool.class) {
                        if (f23615b + 8192 > 65536) {
                            return;
                        }
                        f23615b += 8192;
                        segment.f23612f = f23614a;
                        segment.f23609c = 0;
                        segment.f23608b = 0;
                        f23614a = segment;
                        return;
                    }
                }
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}
