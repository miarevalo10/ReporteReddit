package okio;

final class SegmentPool {
    static Segment f26685a;
    static long f26686b;

    private SegmentPool() {
    }

    static Segment m28306a() {
        synchronized (SegmentPool.class) {
            if (f26685a != null) {
                Segment segment = f26685a;
                f26685a = segment.f26683f;
                segment.f26683f = null;
                f26686b -= 8192;
                return segment;
            }
            return new Segment();
        }
    }

    static void m28307a(Segment segment) {
        if (segment.f26683f == null) {
            if (segment.f26684g == null) {
                if (!segment.f26681d) {
                    synchronized (SegmentPool.class) {
                        if (f26686b + 8192 > 65536) {
                            return;
                        }
                        f26686b += 8192;
                        segment.f26683f = f26685a;
                        segment.f26680c = 0;
                        segment.f26679b = 0;
                        f26685a = segment;
                        return;
                    }
                }
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}
