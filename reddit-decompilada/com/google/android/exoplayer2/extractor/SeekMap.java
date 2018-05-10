package com.google.android.exoplayer2.extractor;

public interface SeekMap {

    public static final class Unseekable implements SeekMap {
        private final long f12839a;

        public final boolean a_() {
            return false;
        }

        public final long mo1329b(long j) {
            return 0;
        }

        public Unseekable(long j) {
            this.f12839a = j;
        }

        public final long mo1328b() {
            return this.f12839a;
        }
    }

    boolean a_();

    long mo1328b();

    long mo1329b(long j);
}
