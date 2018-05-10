package com.google.android.exoplayer2;

public final class PlaybackParameters {
    public static final PlaybackParameters f4054a = new PlaybackParameters(1.0f, 1.0f);
    public final float f4055b;
    public final float f4056c;
    public final int f4057d;

    public PlaybackParameters(float f, float f2) {
        this.f4055b = f;
        this.f4056c = f2;
        this.f4057d = Math.round(f * 1000.0f);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                PlaybackParameters playbackParameters = (PlaybackParameters) obj;
                return this.f4055b == playbackParameters.f4055b && this.f4056c == playbackParameters.f4056c;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (31 * (527 + Float.floatToRawIntBits(this.f4055b))) + Float.floatToRawIntBits(this.f4056c);
    }
}
