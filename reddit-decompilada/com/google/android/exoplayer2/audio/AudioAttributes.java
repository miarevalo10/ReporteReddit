package com.google.android.exoplayer2.audio;

public final class AudioAttributes {
    public static final AudioAttributes f4096a;
    public final int f4097b;
    public final int f4098c;
    public final int f4099d;
    android.media.AudioAttributes f4100e;

    public static final class Builder {
        int f4093a = 0;
        int f4094b = 0;
        int f4095c = 1;
    }

    static {
        Builder builder = new Builder();
        f4096a = new AudioAttributes(builder.f4093a, builder.f4094b, builder.f4095c);
    }

    private AudioAttributes(int i, int i2, int i3) {
        this.f4097b = i;
        this.f4098c = i2;
        this.f4099d = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                AudioAttributes audioAttributes = (AudioAttributes) obj;
                return this.f4097b == audioAttributes.f4097b && this.f4098c == audioAttributes.f4098c && this.f4099d == audioAttributes.f4099d;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (31 * (((527 + this.f4097b) * 31) + this.f4098c)) + this.f4099d;
    }
}
